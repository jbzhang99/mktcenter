package com.bizvane.mktcenterserviceimpl.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bizvane.centerstageservice.models.po.SysStorePo;
import com.bizvane.couponfacade.interfaces.CouponDefinitionServiceFeign;
import com.bizvane.mktcenterservice.interfaces.ActivityRedPacketService;
import com.bizvane.mktcenterservice.interfaces.TaskService;
import com.bizvane.mktcenterservice.models.bo.ActivityRedPacketBO;
import com.bizvane.mktcenterservice.models.po.*;
import com.bizvane.mktcenterservice.models.vo.ActivityPriceParamVO;
import com.bizvane.mktcenterservice.models.vo.ActivityRedPacketVO;
import com.bizvane.mktcenterserviceimpl.common.job.JobUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.CodeUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.TimeUtils;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityRedPacketPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityRedPacketRecordPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityRedPacketSumPOMapper;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.utils.tokens.TokenUtils;
import com.bizvane.wechatfacade.interfaces.QRCodeServiceFeign;
import com.bizvane.wechatfacade.models.vo.CreateMiniprgmQRCodeRequestVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: lijunwei
 * @Time: 2019/1/11 13:55
 */
@Slf4j
@Service
public class ActivityRedPacketServiceImpl implements ActivityRedPacketService {
    @Autowired
    private MktActivityPOMapper mktActivityPOMapper;
    @Autowired
    private QRCodeServiceFeign qrCodeServiceFeign;
    @Autowired
    private MktActivityRedPacketPOMapper mktActivityRedPacketPOMapper;
    @Autowired
    private MktActivityRedPacketSumPOMapper mktActivityRedPacketSumPOMapper;
    @Autowired
    private JobUtil jobUtil;
    @Autowired
    private TaskService taskService;
    @Autowired
    private CouponDefinitionServiceFeign couponDefinitionServiceFeign;
    @Autowired
    private MktActivityRedPacketRecordPOMapper mktActivityRedPacketRecordPOMapper;

    /**
     * 新增
     */
    @Override
    public ResponseData<JSONObject> addActivityRedPacket(ActivityRedPacketBO bo, HttpServletRequest request) throws ParseException {
        ResponseData<JSONObject> responseData = new ResponseData<>();
        SysAccountPO sysAccountPo = TokenUtils.getStageUser(request);
        String activeRedPacketCode = CodeUtil.getActiveRedPacketCode();
        Date date = new Date();
        MktActivityPOWithBLOBs activityPO = bo.getActivityPO();
        Date startTime = activityPO.getStartTime();
        Boolean runStatus = TimeUtils.ifImmediatelyRun(startTime);
        log.info("红包 addActivityRedPacket status:" + runStatus);
        if (runStatus) {
            activityPO.setActivityStatus(2);
        } else {
            activityPO.setActivityStatus(1);
            jobUtil.addStartRedPacketJob(sysAccountPo, activityPO, activeRedPacketCode);
        }
        jobUtil.addEndStartRedPacketJob(sysAccountPo, activityPO, activeRedPacketCode);

        CreateMiniprgmQRCodeRequestVO createMiniprgmQRCodeRequestVO = new CreateMiniprgmQRCodeRequestVO();
        createMiniprgmQRCodeRequestVO.setSysBrandId(sysAccountPo.getBrandId());
        createMiniprgmQRCodeRequestVO.setMiniProgramType("10");
        createMiniprgmQRCodeRequestVO.setPath("pages/template01/prize-draw/main");
        createMiniprgmQRCodeRequestVO.setScene(activeRedPacketCode);
        log.info("addActivityRedPacket wexin param:" + JSON.toJSONString(createMiniprgmQRCodeRequestVO));
        ResponseData<String> qrCodeResponseData = qrCodeServiceFeign.createMiniprgmQRCode(createMiniprgmQRCodeRequestVO);
        log.info("addActivityRedPacket wexin result:" + JSON.toJSONString(qrCodeResponseData));
        String weixinUrl = qrCodeResponseData.getData();

        activityPO.setQrCodeUrl(weixinUrl);
        activityPO.setActivityCode(activeRedPacketCode);
        activityPO.setActivityType(12);
        activityPO.setSysCompanyId(sysAccountPo.getSysCompanyId());
        activityPO.setSysBrandId(sysAccountPo.getBrandId());
        activityPO.setCreateUserId(sysAccountPo.getSysAccountId());
        activityPO.setCreateUserName(sysAccountPo.getName());
        activityPO.setCreateDate(date);
        mktActivityPOMapper.insertSelective(activityPO);

        MktActivityRedPacketPO activityRedPacketPO = bo.getActivityRedPacketPO();
        activityRedPacketPO.setSysCompanyId(sysAccountPo.getSysCompanyId());
        activityRedPacketPO.setSysBrandId(sysAccountPo.getBrandId());
        activityRedPacketPO.setMktActivityId(activityPO.getMktActivityId());
        activityPO.setSysBrandId(sysAccountPo.getBrandId());
        activityPO.setCreateUserId(sysAccountPo.getSysAccountId());
        activityPO.setCreateUserName(sysAccountPo.getName());
        activityPO.setCreateDate(date);
        mktActivityRedPacketPOMapper.insertSelective(activityRedPacketPO);

        MktActivityRedPacketSumPO redPacketSumPO = new MktActivityRedPacketSumPO();
        redPacketSumPO.setMktActivityId(activityPO.getMktActivityId());
        redPacketSumPO.setSysCompanyId(sysAccountPo.getSysCompanyId());
        redPacketSumPO.setActivityCode(activityPO.getActivityCode());
        redPacketSumPO.setActivityName(activityPO.getActivityName());
        redPacketSumPO.setActivityTime(TimeUtils.getDataNum(activityPO.getStartTime(), activityPO.getEndTime()));
        redPacketSumPO.setSysBrandId(sysAccountPo.getBrandId());
        redPacketSumPO.setCreateUserId(sysAccountPo.getSysAccountId());
        redPacketSumPO.setCreateUserName(sysAccountPo.getName());
        redPacketSumPO.setCreateDate(date);
        mktActivityRedPacketSumPOMapper.insertSelective(redPacketSumPO);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("qrCodeUrl", weixinUrl);
        jsonObject.put("activityCode", activeRedPacketCode);
        jsonObject.put("activityName", activityPO.getActivityName());
        responseData.setData(jsonObject);
        return responseData;
    }

    /**
     * 查询详情
     */
    @Override
    public ResponseData<ActivityRedPacketBO> selectActivityRedPacket(ActivityRedPacketVO vo) {
        ResponseData<ActivityRedPacketBO> responseData = new ResponseData<>();
        ActivityRedPacketBO activityBO = new ActivityRedPacketBO();
        Long mktActivityId = vo.getMktActivityId();
        String activityCode = vo.getActivityCode();
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = null;
        if (StringUtils.isNotBlank(activityCode)) {
            MktActivityPOExample example = new MktActivityPOExample();
            example.createCriteria().andActivityCodeEqualTo(activityCode).andValidEqualTo(Boolean.TRUE);
            List<MktActivityPOWithBLOBs> mktActivityPOWithBLOBsList = mktActivityPOMapper.selectByExampleWithBLOBs(example);
            if (CollectionUtils.isNotEmpty(mktActivityPOWithBLOBsList)) {
                mktActivityPOWithBLOBs = mktActivityPOWithBLOBsList.get(0);
            }
        } else {
            mktActivityPOWithBLOBs = mktActivityPOMapper.selectByPrimaryKey(mktActivityId);
        }
        String storeLimitListStr = mktActivityPOWithBLOBs.getStoreLimitList();
        List<SysStorePo> storeList = new ArrayList<SysStorePo>();
        if (StringUtils.isNotBlank(storeLimitListStr)) {
            List<Long> storeIdList = Arrays.asList(storeLimitListStr.split(",")).stream().map(element -> Long.valueOf(element)).collect(Collectors.toList());
            //查询店铺列表
            storeList = taskService.getStoreListByIds(storeIdList);
            log.info("---------通过品牌Ids--" + JSON.toJSONString(storeList) + "-----获取店铺列表----------" + JSON.toJSONString(storeList));
            activityBO.setStoreList(storeList);
        }
        MktActivityRedPacketPOExample example = new MktActivityRedPacketPOExample();
        example.createCriteria().andMktActivityIdEqualTo(mktActivityPOWithBLOBs.getMktActivityId());
        MktActivityRedPacketPO mktActivityRedPacketPO = mktActivityRedPacketPOMapper.selectByExample(example).get(0);
        activityBO.setCouponDefinitionPO(couponDefinitionServiceFeign.findByIdRpc(mktActivityRedPacketPO.getCouponDefinitionId()).getData());
        responseData.setData(activityBO);
        return responseData;
    }

    @Override
    public ResponseData<ActivityRedPacketBO> selectActivityRedPacketDetail(ActivityRedPacketVO vo) {
        ResponseData<ActivityRedPacketBO> responseData = new ResponseData<>();
//        ActivityRedPacketBO activityBO=new  ActivityRedPacketBO();
//        Long mktActivityId = vo.getMktActivityId();
//        String activityCode = vo.getActivityCode();
//        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = null;
//        MktActivityPOExample example = new MktActivityPOExample();
//        example.createCriteria().andActivityCodeEqualTo(activityCode).andValidEqualTo(Boolean.TRUE);
//        List<MktActivityPOWithBLOBs> mktActivityPOWithBLOBsList = mktActivityPOMapper.selectByExampleWithBLOBs(example);
//        if (CollectionUtils.isNotEmpty(mktActivityPOWithBLOBsList)) {
//            mktActivityPOWithBLOBs = mktActivityPOWithBLOBsList.get(0);
//        }
//
//        MktActivityRedPacketPOExample example=new MktActivityRedPacketPOExample();
//        example.createCriteria().andMktActivityIdEqualTo(mktActivityPOWithBLOBs.getMktActivityId());
//        MktActivityRedPacketPO mktActivityRedPacketPO = mktActivityRedPacketPOMapper.selectByExample(example).get(0);
//        activityBO.setCouponDefinitionPO(couponDefinitionServiceFeign.findByIdRpc(mktActivityRedPacketPO.getCouponDefinitionId()).getData());
//        responseData.setData(activityBO);

        ActivityRedPacketBO activityRedPacketBO = mktActivityPOMapper.selectActivityRedPacketDetail(vo);
        responseData.setData(activityRedPacketBO);
        return responseData;
    }

    /**
     * 查询活动列表
     */
    @Override
    public ResponseData<PageInfo<MktActivityPOWithBLOBs>> selectActivityRedPacketList(ActivityPriceParamVO vo, HttpServletRequest request) {
        ResponseData<PageInfo<MktActivityPOWithBLOBs>> responseData = new ResponseData<>();
        SysAccountPO sysAccountPo = TokenUtils.getStageUser(request);
        vo.setBrandId(sysAccountPo.getBrandId());
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        List<MktActivityPOWithBLOBs> listparam = mktActivityPOMapper.selectActivityPriceLists(vo);
        if (CollectionUtils.isEmpty(listparam)) {
            listparam = new ArrayList<MktActivityPOWithBLOBs>();
        }
        PageInfo<MktActivityPOWithBLOBs> pageInfo = new PageInfo<>(listparam);
        responseData.setData(pageInfo);
        return responseData;
    }

    /**
     * 添加记录 发起  助力  领券
     */
    @Transactional
    public void andActivityRedPacketRecord(ActivityRedPacketVO vo) {
        log.info("andActivityRedPacketRecord param:" + JSON.toJSONString(vo));
        Integer type = vo.getType();
        Integer redPacketCount = mktActivityRedPacketRecordPOMapper.getRedPacketCount(vo);
        log.info("andActivityRedPacketRecord redPacketCount param:" + redPacketCount);
        ActivityRedPacketBO bo = mktActivityPOMapper.selectActivityRedPacketDetail(vo);
        Date couponDate = new Date();
        Boolean flag = Boolean.FALSE;

        if (1 == type && redPacketCount == 0) {
            flag = Boolean.TRUE;
            vo.setInitiatorNum(1);
        } else if (2 == type) {
            flag = Boolean.TRUE;
            vo.setHelpNum(1);

        } else if (3 == type && redPacketCount == 0) {
            flag = Boolean.TRUE;
            vo.setGetCouponNum(1);
        }
        log.info("andActivityRedPacketRecord flag param:" + flag);
        if (redPacketCount > 0) {
            vo.setHelpNum(0);
        }

        if (flag) {
            MktActivityRedPacketRecordPO recordPO = new MktActivityRedPacketRecordPO();
            BeanUtils.copyProperties(vo, recordPO);
            recordPO.setCouponDefinitionId(bo.getActivityRedPacketPO().getCouponDefinitionId());
            recordPO.setCouponName(bo.getActivityRedPacketPO().getCouponName());
            recordPO.setGetCouponDate(couponDate);
            recordPO.setRewardIntegral(bo.getActivityRedPacketPO().getRewardIntegral());
            mktActivityRedPacketRecordPOMapper.insertSelective(recordPO);

            mktActivityRedPacketSumPOMapper.updateUpdateCount(vo);
        }
    }


}
