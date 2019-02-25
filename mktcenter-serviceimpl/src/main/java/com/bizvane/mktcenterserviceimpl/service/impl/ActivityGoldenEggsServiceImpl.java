package com.bizvane.mktcenterserviceimpl.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bizvane.centerstageservice.models.po.SysStorePo;
import com.bizvane.couponfacade.interfaces.CouponDefinitionServiceFeign;
import com.bizvane.couponfacade.interfaces.CouponServiceFeign;
import com.bizvane.couponfacade.models.po.CouponDefinitionPO;
import com.bizvane.couponfacade.models.vo.CouponUseVO;
import com.bizvane.mktcenterservice.interfaces.ActivityGoldenEggsService;
import com.bizvane.mktcenterservice.interfaces.TaskService;
import com.bizvane.mktcenterservice.models.po.*;
import com.bizvane.mktcenterservice.models.vo.*;
import com.bizvane.mktcenterserviceimpl.common.utils.CodeUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.TimeUtils;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPrizePOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPrizeRecordPOMapper;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.utils.tokens.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: lijunwei
 * @Time: 2019/2/25 10:14
 */
@Service
@Slf4j
public class ActivityGoldenEggsServiceImpl implements ActivityGoldenEggsService {
    @Autowired
    private ActivityCommonServiceImpl activityCommonServiceImpl;
    @Autowired
    private MktActivityPOMapper mktActivityPOMapper;
    @Autowired
    private TaskService taskService;
    @Autowired
    private MktActivityPrizePOMapper mktActivityPrizePOMapper;
    @Autowired
    private CouponDefinitionServiceFeign couponDefinitionServiceFeign;
    @Autowired
    private MktActivityPrizeRecordPOMapper mktActivityPrizeRecordPOMapper;
    @Autowired
    private CouponServiceFeign couponServiceFeign;

    /**
     * 新增
     * @param bo
     * @param request
     * @return
     * @throws ParseException
     */
    @Override
    public ResponseData<JSONObject> addActivityGE(ActivityPriceBO bo, HttpServletRequest request) throws ParseException {
        ResponseData<JSONObject> responseData = new ResponseData<>();
        MktActivityPOWithBLOBs activityPO = bo.getActivityPO();
        List<MktActivityPrizeVO> activityPrizePOList = bo.getActivityPrizePOList();
        if (activityPO == null || CollectionUtils.isEmpty(activityPrizePOList)) {
            responseData.setCode(100);
            responseData.setMessage("数据不合格!");
        }
        SysAccountPO sysAccountPo = TokenUtils.getStageUser(request);
        Long brandId = sysAccountPo.getBrandId();
        String activePriceCode = CodeUtil.getActiveCode("GE");
        String weixinUrl = activityCommonServiceImpl.getWxurl(brandId, activePriceCode);
        Long mktActivityId = activityCommonServiceImpl.addActivityMianGame(activityPO, sysAccountPo, activePriceCode, weixinUrl);
        activityCommonServiceImpl.addAllPrize(activityPrizePOList, sysAccountPo, mktActivityId);
        activityCommonServiceImpl.addGameCount(sysAccountPo, mktActivityId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("qrCodeUrl", weixinUrl);
        jsonObject.put("activePriceCode", activePriceCode);
        jsonObject.put("activityName", activityPO.getActivityName());
        responseData.setData(jsonObject);
        return responseData;
    }

    /**
     * 查询详情 id
     * @param mktActivityId
     * @return
     */
    @Override
    public ResponseData<ActivityPriceBO> selectActivityGEById(Long mktActivityId, HttpServletRequest request) {
        ResponseData<ActivityPriceBO> responseData = new ResponseData<>();
        ActivityPriceBO activityPriceBO = new ActivityPriceBO();
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = mktActivityPOMapper.selectByPrimaryKey(mktActivityId);
        String storeLimitListStr = mktActivityPOWithBLOBs.getStoreLimitList();
        List<SysStorePo> storeList = new ArrayList<SysStorePo>();
        if (StringUtils.isNotBlank(storeLimitListStr)) {
            List<Long> storeIdList = Arrays.asList(storeLimitListStr.split(",")).stream().map(element -> Long.valueOf(element)).collect(Collectors.toList());
            //查询店铺列表
            storeList = taskService.getStoreListByIds(storeIdList);
            log.info("---------通过品牌Ids--" + JSON.toJSONString(storeList) + "-----获取店铺列表----------" + JSON.toJSONString(storeList));
            activityPriceBO.setStoreList(storeList);
        }
        List<MktActivityPrizeVO> mktActivityPrizeVOS = mktActivityPrizePOMapper.selectMktActivityPrizeById(mktActivityId);
        mktActivityPrizeVOS.stream().forEach(obj -> {
            Long couponDefinitionId = obj.getCouponDefinitionId();
            if (couponDefinitionId != null) {
                ResponseData<CouponDefinitionPO> coupon = couponDefinitionServiceFeign.findByIdRpc(couponDefinitionId);
                obj.setCouponDefinitionPO(coupon.getData());
            }
        });
        activityPriceBO.setActivityPO(mktActivityPOWithBLOBs);
        activityPriceBO.setActivityPrizePOList(mktActivityPrizeVOS);
        responseData.setData(activityPriceBO);
        return responseData;
    }

    /**
     * 查询详情 code
     */
    @Override
    public ResponseData<ActivityPrizeBO> selectActivityGEByCode(String activePriceCode) {
        ResponseData<ActivityPrizeBO> responseData = new ResponseData<>();
        ActivityPrizeBO activityPriceBO = new ActivityPrizeBO();
        MktActivityPOExample example0 = new MktActivityPOExample();
        example0.createCriteria().andActivityCodeEqualTo(activePriceCode);
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = mktActivityPOMapper.selectByExampleWithBLOBs(example0).get(0);

        MktActivityPrizePOExample example = new MktActivityPrizePOExample();
        example.createCriteria().andMktActivityIdEqualTo(mktActivityPOWithBLOBs.getMktActivityId()).andValidEqualTo(Boolean.TRUE);
        List<MktActivityPrizePO> mktActivityPrizePOS = mktActivityPrizePOMapper.selectByExample(example);
        activityPriceBO.setActivityPO(mktActivityPOWithBLOBs);
        activityPriceBO.setActivityPrizePOList(mktActivityPrizePOS);
        responseData.setData(activityPriceBO);
        return responseData;
    }

    /**
     * 查询列表
     */
    @Override
    public ResponseData<PageInfo<MktActivityPOWithBLOBs>> selectActivityEGLists(ActivityPriceParamVO vo, HttpServletRequest request) {
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
     * 修改
     */
    @Override
    public ResponseData<JSONObject> updateActivityGE(ActivityPriceBO bo, HttpServletRequest request) throws ParseException {
        ResponseData<JSONObject> responseData = new ResponseData<>();
        MktActivityPOWithBLOBs activityPO = bo.getActivityPO();
        List<MktActivityPrizeVO> activityPrizePOList = bo.getActivityPrizePOList();
        if (activityPO == null || CollectionUtils.isEmpty(activityPrizePOList)) {
            responseData.setCode(100);
            responseData.setMessage("数据不合格!");
        }
        activityCommonServiceImpl.stopJobs(activityPO);
        activityCommonServiceImpl.deleteAllPrize(activityPO.getMktActivityId());

        SysAccountPO sysAccountPo = TokenUtils.getStageUser(request);
        activityCommonServiceImpl.updateActivityMianGame(activityPO,sysAccountPo);
        activityCommonServiceImpl.addAllPrize(activityPrizePOList, sysAccountPo, activityPO.getMktActivityId());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("qrCodeUrl",activityPO.getQrCodeUrl());
        jsonObject.put("activePriceCode", activityPO.getActivityCode());
        jsonObject.put("activityName", activityPO.getActivityName());
        responseData.setData(jsonObject);
        return responseData;
    }
    /**
     * 禁用
     */
    @Override
    public ResponseData<Integer> stopActivityEG(MktActivityPOWithBLOBs po, HttpServletRequest request) {
       return activityCommonServiceImpl.stopActivityGame(po, request);
    }

    /**
     * 记录统计
     */
    @Override
    public ResponseData<PageInfo<AnalysisPriceResultVO>> selectAnalysisEG(ActivityPriceParamVO vo, HttpServletRequest request) {
        ResponseData<PageInfo<AnalysisPriceResultVO>> responseData = new ResponseData<>();
        SysAccountPO sysAccountPo = TokenUtils.getStageUser(request);
        vo.setBrandId(sysAccountPo.getBrandId());
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        List<AnalysisPriceResultVO> lists = mktActivityPrizePOMapper.selectAnalysisPrice(vo);
        if (CollectionUtils.isEmpty(lists)) {
            lists = new ArrayList<>();
        } else {
            lists.parallelStream().forEach(param -> {
                int dataNum = TimeUtils.getDataNum(param.getEndTime());
                param.setResidueDates(dataNum);
                int days = param.getTotalDates() - dataNum;
                param.setGoingDates(days < 0 ? 0 : days);
                param.setPrizePeople(mktActivityPrizeRecordPOMapper.selectPrizePeopleNum(param.getMktActivityId()));
                param.setTotalPeople(mktActivityPrizeRecordPOMapper.selectTotalPeopleNum(param.getMktActivityId()));
            });
        }
        PageInfo<AnalysisPriceResultVO> pageInfo = new PageInfo<>(lists);
        responseData.setData(pageInfo);
        return responseData;
    }

    /**
     * 中奖人数
     */
    @Override
    public ResponseData<PageInfo<MktActivityPrizeRecordPO>> selectPrizePeople(ActivityPriceParamVO vo) {
        log.info("selectPrizePeople  parram:" + JSON.toJSONString(vo));
        ResponseData<PageInfo<MktActivityPrizeRecordPO>> responseData = new ResponseData<>();
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        List<MktActivityPrizeRecordPO> lists = mktActivityPrizeRecordPOMapper.selectPrizePeople(vo);
        if (CollectionUtils.isEmpty(lists)) {
            lists = new ArrayList<MktActivityPrizeRecordPO>();
        }
        PageInfo<MktActivityPrizeRecordPO> pageInfo = new PageInfo<>(lists);
        responseData.setData(pageInfo);
        return responseData;
    }

    /**
     * 核销
     */
    @Override
    public ResponseData<String> doVerificationCoupon(ActivityPriceParamVO vo, HttpServletRequest request) {
        log.info("doVerificationCoupon param:" + JSON.toJSONString(vo));
        ResponseData<String> responseData = null;
        String couponDefinitionCode = vo.getCouponDefinitionCode();
        if (StringUtils.isBlank(couponDefinitionCode) || "0".equals(couponDefinitionCode)) {
            responseData = new ResponseData<>();
            responseData.setCode(100);
            responseData.setMessage("奖品不是券,无法核销!");
            return responseData;
        }
        SysAccountPO sysAccountPo = TokenUtils.getStageUser(request);
        CouponUseVO requestVO = new CouponUseVO();
        requestVO.setCouponCode(couponDefinitionCode);
        requestVO.setStaffCode(sysAccountPo.getAccountCode());
        requestVO.setBrandId(sysAccountPo.getBrandId());
        responseData = couponServiceFeign.use(requestVO);
        log.info("doVerificationCoupon result:" + JSON.toJSONString(responseData));

        if (responseData.getCode() == 0) {
            MktActivityPrizeRecordPO record = new MktActivityPrizeRecordPO();
            record.setMktActivityPrizeRecordId(vo.getMktActivityPrizeRecordId());
            record.setRemark("1");
            mktActivityPrizeRecordPOMapper.updateByPrimaryKeySelective(record);
        }
        return responseData;
    }
}
