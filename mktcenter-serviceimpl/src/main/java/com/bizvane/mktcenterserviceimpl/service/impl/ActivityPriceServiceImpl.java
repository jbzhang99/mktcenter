package com.bizvane.mktcenterserviceimpl.service.impl;

import com.alibaba.fastjson.JSON;
import com.bizvane.mktcenterservice.interfaces.ActivityPriceService;
import com.bizvane.mktcenterservice.models.po.*;
import com.bizvane.mktcenterservice.models.vo.ActivityPriceBO;
import com.bizvane.mktcenterservice.models.vo.ActivityPriceParamVO;
import com.bizvane.mktcenterservice.models.vo.AnalysisPriceResultVO;
import com.bizvane.mktcenterserviceimpl.common.utils.CodeUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.TimeUtils;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityCountPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPrizePOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPrizeRecordPOMapper;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.utils.tokens.TokenUtils;
import com.bizvane.wechatfacade.interfaces.QRCodeServiceFeign;
import com.bizvane.wechatfacade.models.vo.CreateMiniprgmQRCodeRequestVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2018/12/19 14:20
 */

@Service
@Slf4j
public class ActivityPriceServiceImpl implements ActivityPriceService {

    @Autowired
    private MktActivityPOMapper mktActivityPOMapper;
    @Autowired
    private MktActivityPrizePOMapper mktActivityPrizePOMapper;
    @Autowired
    private QRCodeServiceFeign qrCodeServiceFeign;
    @Autowired
    private MktActivityPrizeRecordPOMapper mktActivitPrizeRecordPOMapper;
    @Autowired
    private MktActivityCountPOMapper mktActivityCountPOMapper;

    /**
     * 新增
     *
     * @param bo
     * @return
     */
    @Transactional
    @Override
    public ResponseData<String> addActivityPrice(ActivityPriceBO bo, HttpServletRequest request) {
        ResponseData<String> responseData = new ResponseData<>();
        MktActivityPOWithBLOBs activityPO = bo.getActivityPO();
        List<MktActivityPrizePO> activityPrizePOList = bo.getActivityPrizePOList();
        if (activityPO == null || CollectionUtils.isEmpty(activityPrizePOList)) {
            responseData.setCode(100);
            responseData.setMessage("数据不合格!");
        }

        SysAccountPO sysAccountPo = TokenUtils.getStageUser(request);
        Long sysAccountId = sysAccountPo.getSysAccountId();
        String name = sysAccountPo.getName();
        Long brandId = sysAccountPo.getBrandId();
        Long sysCompanyId = sysAccountPo.getSysCompanyId();
        Date date = new Date();
        String activePriceCode = CodeUtil.getActivePriceCode();

        CreateMiniprgmQRCodeRequestVO createMiniprgmQRCodeRequestVO = new CreateMiniprgmQRCodeRequestVO();
        createMiniprgmQRCodeRequestVO.setSysBrandId(brandId);
        createMiniprgmQRCodeRequestVO.setMiniProgramType("10");
        createMiniprgmQRCodeRequestVO.setPath("pages/template01/coupon-scancode/main");
        createMiniprgmQRCodeRequestVO.setScene(activePriceCode);
        log.info("addActivityPrice wexin param:" + JSON.toJSONString(createMiniprgmQRCodeRequestVO));
        ResponseData<String> qrCodeResponseData = qrCodeServiceFeign.createMiniprgmQRCode(createMiniprgmQRCodeRequestVO);
        log.info("addActivityPrice wexin result:" + JSON.toJSONString(qrCodeResponseData));
        String weixinUrl = qrCodeResponseData.getData();

        activityPO.setActivityType(11);
        activityPO.setQrCodeUrl(weixinUrl);
        activityPO.setActivityCode(activePriceCode);
        activityPO.setSysBrandId(brandId);
        activityPO.setSysCompanyId(sysCompanyId);
        activityPO.setCreateUserId(sysAccountId);
        activityPO.setCreateUserName(name);
        activityPO.setCreateDate(date);
        mktActivityPOMapper.insertSelective(activityPO);
        Long mktActivityId = activityPO.getMktActivityId();

        activityPrizePOList.parallelStream().forEach((MktActivityPrizePO po) -> {
            po.setMktActivityId(mktActivityId);
            po.setSysBrandId(brandId);
            po.setSysCompanyId(sysCompanyId);
            po.setCreateUserId(sysAccountId);
            po.setCreateUserName(name);
            po.setCreateDate(date);
            mktActivityPrizePOMapper.insertSelective(po);
        });
        MktActivityCountPO mktActivityCountPO = new MktActivityCountPO();
        mktActivityCountPO.setMktActivityId(mktActivityId);
        mktActivityCountPO.setSysCompanyId(sysCompanyId);
        mktActivityCountPO.setSysBrandId(brandId);
        mktActivityCountPO.setCreateUserId(sysAccountId);
        mktActivityCountPO.setCreateUserName(name);
        mktActivityCountPO.setCreateDate(date);
        mktActivityCountPOMapper.insertSelective(mktActivityCountPO);

        responseData.setData(weixinUrl);
        return responseData;
    }

    /**
     * 查询详情 id
     *
     * @param mktActivityId
     * @return
     */
    @Override
    public ResponseData<ActivityPriceBO> selectActivityPrice(Long mktActivityId, HttpServletRequest request) {
        ResponseData<ActivityPriceBO> responseData = new ResponseData<>();

        //  SysAccountPO sysAccountPo = TokenUtils.getStageUser(request);
        ActivityPriceBO activityPriceBO = new ActivityPriceBO();
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = mktActivityPOMapper.selectByPrimaryKey(mktActivityId);

        MktActivityPrizePOExample example = new MktActivityPrizePOExample();
        example.createCriteria().andMktActivityIdEqualTo(mktActivityId);
        List<MktActivityPrizePO> mktActivityPrizePOS = mktActivityPrizePOMapper.selectByExample(example);

        activityPriceBO.setActivityPO(mktActivityPOWithBLOBs);
        activityPriceBO.setActivityPrizePOList(mktActivityPrizePOS);
        responseData.setData(activityPriceBO);
        return responseData;
    }

    /**
     * 查询详情 code
     */
    @Override
    public ResponseData<ActivityPriceBO> selectActivityPrice(String activePriceCode, HttpServletRequest request) {
        ResponseData<ActivityPriceBO> responseData = new ResponseData<>();

        //  SysAccountPO sysAccountPo = TokenUtils.getStageUser(request);
        ActivityPriceBO activityPriceBO = new ActivityPriceBO();
        MktActivityPOExample example0 = new MktActivityPOExample();
        example0.createCriteria().andActivityCodeEqualTo(activePriceCode);
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = mktActivityPOMapper.selectByExampleWithBLOBs(example0).get(0);

        MktActivityPrizePOExample example = new MktActivityPrizePOExample();
        example.createCriteria().andMktActivityIdEqualTo(mktActivityPOWithBLOBs.getMktActivityId());
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
    public ResponseData<List<MktActivityPOWithBLOBs>> selectActivityPriceLists(ActivityPriceParamVO vo, HttpServletRequest request) {
        ResponseData<List<MktActivityPOWithBLOBs>> responseData = new ResponseData<>();
        SysAccountPO sysAccountPo = TokenUtils.getStageUser(request);
        MktActivityPOExample example = new MktActivityPOExample();
        MktActivityPOExample.Criteria criteria = example.createCriteria();
        criteria.andSysBrandIdEqualTo(sysAccountPo.getBrandId());
        String activityCode = vo.getActivityCode();
        if (null != activityCode) {
            criteria.andActivityCodeLike("%" + activityCode + "%");
        }
        String activityName = vo.getActivityName();
        if (null != activityName) {
            criteria.andActivityNameLike("%" + activityName + "%");
        }
        Integer activityStatus = vo.getActivityStatus();
        if (null != activityStatus) {
            criteria.andActivityStatusEqualTo(activityStatus);
        }
        List<MktActivityPOWithBLOBs> listparam = mktActivityPOMapper.selectByExampleWithBLOBs(example);
        if (CollectionUtils.isEmpty(listparam)) {
            responseData.setData(new ArrayList<MktActivityPOWithBLOBs>());
            return responseData;
        }
        responseData.setData(listparam);
        return responseData;
    }

    /**
     * 记录统计
     */
    @Override
    public ResponseData<PageInfo<AnalysisPriceResultVO>> selectAnalysisPrice(ActivityPriceParamVO vo, HttpServletRequest request) {
        ResponseData<PageInfo<AnalysisPriceResultVO>> responseData = new ResponseData<>();
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        List<AnalysisPriceResultVO> lists = mktActivityPrizePOMapper.selectAnalysisPrice(vo);
        if (CollectionUtils.isEmpty(lists)) {
            lists = new ArrayList<>();
        } else {
            lists.parallelStream().forEach(param -> {
                int dataNum = TimeUtils.getDataNum(param.getEndTime());
                param.setResidueDates(dataNum);
                param.setGoingDates(param.getTotalDates() - dataNum);
                param.setPrizePeople(mktActivitPrizeRecordPOMapper.selectPrizePeopleNum(param.getMktActivityId()));
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
        ResponseData<PageInfo<MktActivityPrizeRecordPO>> responseData = new ResponseData<>();
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        MktActivityPrizeRecordPOExample example = new MktActivityPrizeRecordPOExample();
        example.createCriteria().andMktActivityIdEqualTo(vo.getMktActivityId())
                .andMemberNameLike("%" + vo.getMemberName() + "%")
                .andPrizeNameLike("%" + vo.getPrizeName() + "%")
                .andAwadTypeNotEqualTo(50).andValidEqualTo(Boolean.TRUE);

        List<MktActivityPrizeRecordPO> lists = mktActivitPrizeRecordPOMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(lists)) {
            lists = new ArrayList<MktActivityPrizeRecordPO>();
        }
        PageInfo<MktActivityPrizeRecordPO> pageInfo = new PageInfo<>(lists);
        responseData.setData(pageInfo);
        return responseData;


    }
}
