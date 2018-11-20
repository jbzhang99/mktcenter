package com.bizvane.mktcenterserviceimpl.service.impl;

import com.alibaba.fastjson.JSON;
import com.bizvane.centerstageservice.models.po.SysBrandPo;
import com.bizvane.centerstageservice.models.po.SysCheckPo;
import com.bizvane.centerstageservice.rpc.BrandServiceRpc;
import com.bizvane.centerstageservice.rpc.SysCheckServiceRpc;
import com.bizvane.couponfacade.enums.SendTypeEnum;
import com.bizvane.couponfacade.interfaces.CouponEntityServiceFeign;
import com.bizvane.couponfacade.interfaces.CouponQueryServiceFeign;
import com.bizvane.couponfacade.models.vo.CouponFindCouponCountResponseVO;
import com.bizvane.couponfacade.models.vo.CouponSendMemberListRequestVO;
import com.bizvane.couponfacade.models.vo.CouponSendMemberListResponseVO;
import com.bizvane.couponfacade.models.vo.SendCouponSimpleRequestVO;
import com.bizvane.members.facade.enums.IntegralChangeTypeEnum;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.service.api.MemberInfoApiService;
import com.bizvane.members.facade.service.card.request.IntegralChangeRequestModel;
import com.bizvane.members.facade.vo.WxChannelInfoVo;
import com.bizvane.messagefacade.models.vo.ActivityMessageVO;
import com.bizvane.messagefacade.models.vo.MemberMessageVO;
import com.bizvane.messagefacade.models.vo.SysSmsConfigVO;
import com.bizvane.mktcenterservice.interfaces.ActivityService;
import com.bizvane.mktcenterservice.models.bo.ActivityAnalysisCountBO;
import com.bizvane.mktcenterservice.models.bo.AwardBO;
import com.bizvane.mktcenterservice.models.bo.CtivityAnalysisBO;
import com.bizvane.mktcenterservice.models.po.*;
import com.bizvane.mktcenterservice.models.vo.ActivitySmartVO;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterservice.models.vo.WhiteStoreVO;
import com.bizvane.mktcenterserviceimpl.common.award.Award;
import com.bizvane.mktcenterserviceimpl.common.enums.*;
import com.bizvane.mktcenterserviceimpl.common.utils.DateUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.ExecuteParamCheckUtil;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityRegisterPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktMessagePOMapper;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.jobutils.JobClient;
import com.bizvane.utils.jobutils.XxlJobInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chen.li
 * @date on 2018/7/6 19:50
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@Service
@Slf4j
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private MktActivityPOMapper mktActivityPOMapper;
    @Autowired
    private MktMessagePOMapper mktMessagePOMapper;
    @Autowired
    private SysCheckServiceRpc sysCheckServiceRpc;
    @Autowired
    private CouponQueryServiceFeign couponQueryServiceFeign;
    @Autowired
    private MemberInfoApiService memberInfoApiService;
    @Autowired
    private MktActivityRegisterPOMapper mktActivityRegisterPOMapper;
    @Autowired
    private JobClient jobClient;
    @Autowired
    private Award award;
    @Autowired
    private CouponEntityServiceFeign couponEntityServiceFeign;
    @Autowired
    private BrandServiceRpc brandServiceRpc;

    /**
     * 禁用/启用活动
     * @param vo
     * @return
     */
    @Override
    public ResponseData<Integer> updateActivityById(ActivityVO vo, SysAccountPO sysAccountPO) {
        ResponseData responseData = new ResponseData();
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = new MktActivityPOWithBLOBs();
        mktActivityPOWithBLOBs.setMktActivityId(vo.getMktActivityId());
        mktActivityPOWithBLOBs.setActivityStatus(4);
        mktActivityPOWithBLOBs.setModifiedUserId(sysAccountPO.getSysAccountId());
        mktActivityPOWithBLOBs.setModifiedDate(new Date());
        mktActivityPOWithBLOBs.setModifiedUserName(sysAccountPO.getName());
        int i = mktActivityPOMapper.updateByPrimaryKeySelective(mktActivityPOWithBLOBs);
        //job类
        XxlJobInfo xxlJobInfo = new XxlJobInfo();
        xxlJobInfo.setExecutorParam(vo.getActivityCode());
        xxlJobInfo.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode());
        //先删除原来创建的job任务
        jobClient.removeByBiz(xxlJobInfo);
        //删除审核中心数据
        SysCheckPo po = new SysCheckPo();
        po.setBusinessId(vo.getMktActivityId());
        sysCheckServiceRpc.deleteByBusinessId(po);
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }

    /**
     * 活动审核
     * @param
     * @param sysAccountPO
     * @return
     */
    @Override
    public ResponseData<Integer> checkActivityById(SysCheckPo po, SysAccountPO sysAccountPO) {
        ResponseData responseData = new ResponseData();
        MktActivityPOWithBLOBs bs = new MktActivityPOWithBLOBs();
        bs.setModifiedUserId(sysAccountPO.getSysAccountId());
        bs.setModifiedDate(new Date());
        bs.setModifiedUserName(sysAccountPO.getName());
        bs.setCheckStatus(po.getCheckStatus());
        bs.setActivityCode(po.getBusinessCode());
        bs.setMktActivityId(po.getBusinessId());
        //根据code查询出审核活动的详细信息
        ActivityVO vo = new ActivityVO();
        vo.setActivityCode(po.getBusinessCode());
        List<ActivityVO> activityRegisterList = mktActivityRegisterPOMapper.getActivityList(vo);
        if (CollectionUtils.isEmpty(activityRegisterList)){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.OPERATE_FAILED_DATA_NOT_EXISTS.getMessage());
            return responseData;
        }
        ActivityVO activityPO = activityRegisterList.get(0);
        //判断是审核通过还是审核驳回
        if(bs.getCheckStatus()==CheckStatusEnum.CHECK_STATUS_APPROVED.getCode()){
            //活动开始时间<当前时间<活动结束时间  或者长期活动 也就是StartTime=null
            if(1== activityPO.getLongTerm() ||(new Date().after(activityPO.getStartTime()) && new Date().before(activityPO.getEndTime()))){
                //将活动状态变更为执行中 并且发送消息
                bs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());

            }
            //判断审核时间 >活动结束时间  将活动状态变为已结束
            if(null!=activityPO.getEndTime() && new Date().after(activityPO.getEndTime())){
                bs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_FINISHED.getCode());
            }

        }else{
            bs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_FINISHED.getCode());
        }
        log.info("更新审核状态的参数是+======="+ JSON.toJSONString(bs));
        int i = mktActivityPOMapper.updateByPrimaryKeySelective(bs);
        //更新审核中心状态
        sysCheckServiceRpc.updateCheck(po);
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }

    /**
     * 小程序端查询活动列表
     * @param vo
     * @return
     */
    @Override
    public ResponseData<List<ActivityVO>> getActivityList(ActivityVO vo) {
        ResponseData responseData = new ResponseData();
        List<ActivityVO> lists = new ArrayList<>();
        MemberInfoModel memberInfoModel = new MemberInfoModel();
        memberInfoModel.setServiceStoreId(vo.getServiceStoreId());
        log.info("服务id是=============="+vo.getServiceStoreId());
        List<ActivityVO> activityList =mktActivityPOMapper.getActivityList(vo);
        if (!CollectionUtils.isEmpty(activityList)){
            for (ActivityVO activity:activityList) {
                //过滤门店
                if (!ExecuteParamCheckUtil.implementActivitCheck(memberInfoModel,activity)){
                    continue;
                }
                lists.add(activity);

            }
        }

        responseData.setData(lists);
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }

    /**
     * 活动效果分析
     * @param bo
     * @param pageForm
     * @return
     */
    @Override
    public ResponseData<CtivityAnalysisBO> getActivityAnalysisCountpage(ActivityAnalysisCountBO bo, PageForm pageForm) {
        ResponseData responseData = new ResponseData();
        CtivityAnalysisBO ctivityAnalysisBO = new CtivityAnalysisBO();
        PageHelper.startPage(pageForm.getPageNumber(),pageForm.getPageSize());
        //分页查询出主表信息
        log.info("现在查询主表信息第一次开始时间是+======="+ new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(new Date()));
        List<ActivityAnalysisCountBO> activityAnalysisList = mktActivityPOMapper.getActivityAnalysisCountpage(bo);
        log.info("查询主表信息结束时间是+======="+ new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(new Date()));
        Long couponSums = 0L;
        Long couponUsedSums = 0L;
        BigDecimal moneySu = new BigDecimal(0);
        if (!CollectionUtils.isEmpty(activityAnalysisList)){
            log.info("开始循环时间+++++++"+ new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(new Date()));
            for (ActivityAnalysisCountBO activityAnalysisCount:activityAnalysisList) {
                if (activityAnalysisCount.getActivityStatus()==ActivityStatusEnum.ACTIVITY_STATUS_PENDING.getCode()){
                    activityAnalysisCount.setDays("0天");
                }
                if (activityAnalysisCount.getActivityStatus()==ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode()){
                    if (activityAnalysisCount.getLongTerm()==0){
                        //这里判断是否是签到或者评价奖励
                        if(activityAnalysisCount.getActivityType()==6 ||activityAnalysisCount.getActivityType()==9){
                            activityAnalysisCount.setDays(DateUtil.getIntervalBetweenTwoDate(activityAnalysisCount.getCreateDate(),new Date()));
                        }else{
                            activityAnalysisCount.setDays(DateUtil.getIntervalBetweenTwoDate(activityAnalysisCount.getStartTime(),new Date()));                        }

                    }else if (activityAnalysisCount.getLongTerm()==1){
                        activityAnalysisCount.setDays(DateUtil.getIntervalBetweenTwoDate(activityAnalysisCount.getCreateDate(),new Date()));
                    }
                }
                if (activityAnalysisCount.getActivityStatus()==ActivityStatusEnum.ACTIVITY_STATUS_FINISHED.getCode()){
                    activityAnalysisCount.setDays(DateUtil.getIntervalBetweenTwoDate(activityAnalysisCount.getStartTime(),activityAnalysisCount.getEndTime()));
                }
                if (activityAnalysisCount.getActivityStatus()==4){
                    activityAnalysisCount.setDays("0天");
                }
                //查询券统计
                //判断是不是领券
                String sendType ="";
                if (null==bo.getActivityType()){
                    sendType = CouponSendTypeEnum.getCouponSendTypeEnumByMktModuleCode(bo.getActivityTypeExtend()).getCouponModuleCode();
                }else{
                    sendType = CouponSendTypeEnum.getCouponSendTypeEnumByMktModuleCode(bo.getActivityType()).getCouponModuleCode();
                }
                log.info("查询一个活动发券情况开始时间！！！！！！！！！"+ new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(new Date()));
                ResponseData<CouponFindCouponCountResponseVO> couponFindCouponCountResponseVODate = couponQueryServiceFeign.findCouponCountBySendBusinessId(activityAnalysisCount.getMktActivityId(),sendType,activityAnalysisCount.getSysBrandId());
                log.info("查询一个活动发券情况结束时间？？？？？？？？？"+ new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(new Date()));
                CouponFindCouponCountResponseVO couponFindCouponCountResponseVO = couponFindCouponCountResponseVODate.getData();
                //券数量
                activityAnalysisCount.setCouponSum(couponFindCouponCountResponseVO.getCouponSum());
                //算券数量
                if (null!=couponFindCouponCountResponseVO.getCouponSum()){
                    couponSums= couponSums+couponFindCouponCountResponseVO.getCouponSum();
                }
                //核销券数量
                activityAnalysisCount.setCouponUsedSum(couponFindCouponCountResponseVO.getCouponUsedSum());
                //算合计核销数量
                if (null!=couponFindCouponCountResponseVO.getCouponUsedSum()){
                    couponUsedSums=couponUsedSums+couponFindCouponCountResponseVO.getCouponUsedSum();
                }

                //收益
                activityAnalysisCount.setMoney(couponFindCouponCountResponseVO.getMoney());
                //算合计收益
                if (null!=couponFindCouponCountResponseVO.getMoney()){
                    moneySu = moneySu.add(new BigDecimal(String.valueOf(couponFindCouponCountResponseVO.getMoney())));
                }

                //核销率
                if ((null!=couponFindCouponCountResponseVO.getCouponUsedSum() && null!=couponFindCouponCountResponseVO.getCouponSum())) {
                    // 创建一个数值格式化对象
                    NumberFormat numberFormat = NumberFormat.getInstance();
                    // 设置精确到小数点后2位
                    numberFormat.setMaximumFractionDigits(2);
                    String result = numberFormat.format((float) couponFindCouponCountResponseVO.getCouponUsedSum() / (float) couponFindCouponCountResponseVO.getCouponSum() * 100);
                    log.info("百分比百分比百分比百分比+========"+result);
                    if (!result.equals("�")){
                        activityAnalysisCount.setCouponUsedSumPercentage(result + "%");
                    }



                }
                //判断百分比 默认0
                if (null==activityAnalysisCount.getCouponUsedSumPercentage()){
                    activityAnalysisCount.setCouponUsedSumPercentage(0+"%");
                }
                //活动金额默认0
                if (null==activityAnalysisCount.getOrderAmountSum()){
                    activityAnalysisCount.setOrderAmountSum(new BigDecimal(0));
                }
                //参与人次默认0
                if (null==activityAnalysisCount.getParticipateNumber()){
                    activityAnalysisCount.setParticipateNumber(0L);
                }
            }
            log.info("循环结束时间+++++++"+ new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(new Date()));
        }
        //合计积分总数 和参与人数总数
        CtivityAnalysisBO ctivityAnalysis = mktActivityPOMapper.getActivityAnalysisTotal(bo);
        //参与人数
        ctivityAnalysisBO.setParticipateTotal(ctivityAnalysis.getParticipateTotal());
        //积分总数
        ctivityAnalysisBO.setPointsSumTotal(ctivityAnalysis.getPointsSumTotal());
        //积分 合计 券收益合计
        Integer type =null;
        if (null==bo.getActivityType()){
            type=bo.getActivityTypeExtend();
        }else{
            type=bo.getActivityType();
        }
        ActivityConvertCouponTypeEnum activityConvertCouponTypeEnumByCode = ActivityConvertCouponTypeEnum.getActivityConvertCouponTypeEnumByCode(type);
        String activityType = activityConvertCouponTypeEnumByCode.getCouponCode();
        //查询券合计
        log.info("查询券合计开始时间+++++++"+ new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(new Date()));
       /* ResponseData<CouponFindCouponCountResponseVO> couponFindCouponCountVO =  couponQueryServiceFeign.getCountBySendType(activityType,bo.getSysBrandId());
        CouponFindCouponCountResponseVO couponFindCoupon = couponFindCouponCountVO.getData();*/
      /*  //合计优惠券总数量
        ctivityAnalysisBO.setCouponSumTotal(couponFindCoupon.getCouponSum());
        //合计优惠券核销数量
        ctivityAnalysisBO.setCouponUsedSumTotal(couponFindCoupon.getCouponUsedSum());
        //合计券收益
        ctivityAnalysisBO.setMoneyTotal(couponFindCoupon.getMoney());*/
        //合计优惠券总数量
        ctivityAnalysisBO.setCouponSumTotal(couponSums);
        //合计优惠券核销数量
        ctivityAnalysisBO.setCouponUsedSumTotal(couponUsedSums);
        //合计券收益
        ctivityAnalysisBO.setMoneyTotal(moneySu);
        log.info("查询券合计结束时间+++++++"+ new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(new Date()));
        PageInfo<ActivityAnalysisCountBO> pageInfo = new PageInfo<>(activityAnalysisList);
        ctivityAnalysisBO.setActivityAnalysisCountBO(pageInfo.getList());
        ctivityAnalysisBO.setTotal(pageInfo.getTotal());
        responseData.setData(ctivityAnalysisBO);
        return responseData;
    }

    /**
     * 奖励券
     * @param activityCode
     * @return
     */
    public ResponseData<Integer> awardCoupon(String activityCode){
        ResponseData responseData = new ResponseData();
        return responseData;
    }

    /**
     * 奖励积分
     * @param activityCode
     * @return
     */
    public ResponseData<Integer> awardIntegral(String activityCode){
        ResponseData responseData = new ResponseData();
        return responseData;
    }

    /**
     * 发送短信
     * @param activityCode
     * @return
     */
    public ResponseData<Integer> sendSms(String activityCode){
        ResponseData responseData = new ResponseData();
        return responseData;
    }

    /**
     * 发送模板消息
     * @param activityCode
     * @return
     */
    public ResponseData<Integer> sendWxTemplateMessage(String activityCode){
        ResponseData responseData = new ResponseData();
        return responseData;
    }
    @Override
    @Async("asyncServiceExecutor")
    public void sendMessage(List<MktMessagePO> messageVOList, MemberInfoModel memberInfo,ActivityVO activityVO) {
        ResponseData<SysBrandPo> SysBrandPos = brandServiceRpc.getBrandByID(activityVO.getSysBrandId());
        //循环信息类然后发送
        for (MktMessagePO mktMessagePO:messageVOList) {
            AwardBO awardBO = new AwardBO();
            if (mktMessagePO.getMsgType().equals("1") ){
                log.info("开始发送微信消息");
                //发送微信模板消息
                ActivityMessageVO activityMessageVO = new ActivityMessageVO();
                activityMessageVO.setMemberCode(memberInfo.getMemberCode());
                activityMessageVO.setSysCompanyId(activityVO.getSysCompanyId());
                activityMessageVO.setSysBrandId(activityVO.getSysBrandId());
                activityMessageVO.setSysBrandName(SysBrandPos.getData().getBrandName());
                activityMessageVO.setActivityName(activityVO.getActivityName());
                activityMessageVO.setActivityInterests(mktMessagePO.getMsgContent());
                activityMessageVO.setMemberPhone(memberInfo.getPhone());
                if (activityVO.getLongTerm()==1){
                    activityMessageVO.setActivityLongtime("长期活动");
                }else{
                    activityMessageVO.setActivityStartDate(activityVO.getStartTime());
                    activityMessageVO.setActivityEndDate(activityVO.getEndTime());
                }
                activityMessageVO.setMemberName(memberInfo.getName());
                activityMessageVO.setUnl("/pages/template01/activity-details/main?activityCode="+activityVO.getActivityCode()+"&activityType="+activityVO.getActivityType());
                awardBO.setActivityMessageVO(activityMessageVO);
                awardBO.setMktType(MktSmartTypeEnum.SMART_TYPE_WXMESSAGE.getCode());
                award.execute(awardBO);
            }
            if (mktMessagePO.getMsgType().equals("2")){
                ActivityMessageVO activityMessageVO = new ActivityMessageVO();
                activityMessageVO.setMemberPhone(memberInfo.getPhone());
                activityMessageVO.setSysBrandId(memberInfo.getBrandId());
                activityMessageVO.setMemberName(memberInfo.getName());
                activityMessageVO.setSendWxmember(mktMessagePO.getMsgContent());
                awardBO.setActivityMessageVO(activityMessageVO);
                awardBO.setMktType(MktSmartTypeEnum.SMART_TYPE_SMS.getCode());
                //发送短信消息
                award.execute(awardBO);
            }
        }
    }
    @Override
    @Async("asyncServiceExecutor")
    public void sendPoints(ActivitySmartVO vo, AwardBO awardBO, MemberInfoModel memberInfo) {
        log.info("智能营销开始发送积分积分积分了啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊");
        IntegralChangeRequestModel integralChangeRequestModel =new IntegralChangeRequestModel();
        integralChangeRequestModel.setSysCompanyId(vo.getSysCompanyId());
        integralChangeRequestModel.setBrandId(vo.getSysBrandId());
        integralChangeRequestModel.setMemberCode(memberInfo.getMemberCode());
        integralChangeRequestModel.setChangeBills(vo.getActivityCode());
        integralChangeRequestModel.setChangeIntegral(vo.getPoints());
        integralChangeRequestModel.setChangeType(IntegralChangeTypeEnum.INCOME.getCode());
        integralChangeRequestModel.setBusinessType(com.bizvane.members.facade.enums.BusinessTypeEnum.ACTIVITY_TYPE_SMART.getCode());
        integralChangeRequestModel.setChangeDate(new Date());
        awardBO.setIntegralRecordModel(integralChangeRequestModel);
        awardBO.setMktType(MktSmartTypeEnum.SMART_TYPE_INTEGRAL.getCode());
        log.info("手机号码是+====="+memberInfo.getPhone()+"开始赠送积分了~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        award.execute(awardBO);
        log.info("手机号码是+====="+memberInfo.getPhone()+"送完积分了&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
    }
    @Override
    @Async("asyncServiceExecutor")
    public void sendShort(MktMessagePO mktMessagePO, AwardBO awardBO, SysSmsConfigVO sysSmsConfigVO, MemberInfoModel memberInfo) {
        ActivityMessageVO activityMessageVO = new ActivityMessageVO();
        activityMessageVO.setMemberPhone(memberInfo.getPhone());
        activityMessageVO.setSysBrandId(memberInfo.getBrandId());
        activityMessageVO.setMemberName(memberInfo.getName());
        activityMessageVO.setSendWxmember(mktMessagePO.getMsgContent());
        awardBO.setActivityMessageVO(activityMessageVO);
        awardBO.setMktType(MktSmartTypeEnum.SMART_TYPE_SMS.getCode());
        award.execute(awardBO);
    }
    @Override
    @Async("asyncServiceExecutor")
    public void sendWx(MktMessagePO mktMessagePO, AwardBO awardBO, MemberMessageVO memberMessageVO, MemberInfoModel memberInfo) {
        ResponseData<SysBrandPo> SysBrandPos = brandServiceRpc.getBrandByID(memberInfo.getBrandId());
        //发送微信模板消息
        ActivityMessageVO activityMessageVO = new ActivityMessageVO();
        activityMessageVO.setMemberCode(memberInfo.getMemberCode());
        activityMessageVO.setSysCompanyId(memberInfo.getSysCompanyId());
        activityMessageVO.setSysBrandId(memberInfo.getBrandId());
        activityMessageVO.setSysBrandName(SysBrandPos.getData().getBrandName());
        activityMessageVO.setActivityName("营销发送微信消息");
        activityMessageVO.setActivityInterests(mktMessagePO.getMsgContent());
        activityMessageVO.setMemberPhone(memberInfo.getPhone());
        activityMessageVO.setActivityLongtime("智能营销");
        activityMessageVO.setUnl("/pages/template01/activity-details/main");
        awardBO.setActivityMessageVO(activityMessageVO);
        awardBO.setMktType(MktSmartTypeEnum.SMART_TYPE_WXMESSAGE.getCode());
        award.execute(awardBO);
    }

    @Override
    @Async("asyncServiceExecutor")
    public void sendCoupon(ActivitySmartVO vo, AwardBO awardBO, SendCouponSimpleRequestVO sendCouponSimpleRequestVO, MemberInfoModel memberInfo) {
        if (!org.springframework.util.CollectionUtils.isEmpty(vo.getMktCouponPOS())) {
            for (MktCouponPO mktCouponPO : vo.getMktCouponPOS()) {
                sendCouponSimpleRequestVO.setBusinessName(vo.getActivityName());
                sendCouponSimpleRequestVO.setMemberCode(memberInfo.getMemberCode());
                sendCouponSimpleRequestVO.setCouponDefinitionId(mktCouponPO.getCouponDefinitionId());
                sendCouponSimpleRequestVO.setSendBussienId(mktCouponPO.getBizId());
                if (null!=vo.getMktActivitySmartGroupId()){
                    sendCouponSimpleRequestVO.setSendType(SendTypeEnum.SEND_COUPON_ORIENT_MARKET.getCode());
                }else {
                    sendCouponSimpleRequestVO.setSendType(SendTypeEnum.SEND_COUPON_MEMBER_GROUP.getCode());
                }
                sendCouponSimpleRequestVO.setBrandId(vo.getSysBrandId());
                sendCouponSimpleRequestVO.setCompanyId(vo.getSysCompanyId());
                awardBO.setSendCouponSimpleRequestVO(sendCouponSimpleRequestVO);
                awardBO.setMktType(MktSmartTypeEnum.SMART_TYPE_COUPON.getCode());
                log.info("调用高级搜索的参数列表=================="+ JSON.toJSONString(sendCouponSimpleRequestVO));
                log.info("智能营销开始发券发券发券发券了+++++++++++++++++++++=========================");
                award.execute(awardBO);
            }
        }
    }
    @Override
    @Async("asyncServiceExecutor")
    public void sendRegisterWx(List<MktMessagePO> messageVOList, WxChannelInfoVo wxChannelInfoVo,ActivityVO activityVO) {
        ResponseData<SysBrandPo> SysBrandPos = brandServiceRpc.getBrandByID(activityVO.getSysBrandId());
        for (MktMessagePO mktMessagePO:messageVOList) {
            AwardBO awardBO = new AwardBO();
            if (mktMessagePO.getMsgType().equals("1") ){
                log.info("发送微信~~~~~~~~~~~~~~~~~~");
                //发送微信模板消息
                //发送微信模板消息
                ActivityMessageVO activityMessageVO = new ActivityMessageVO();
                //如果是开卡活动传微信id
                if (activityVO.getActivityType()==ActivityTypeEnum.ACTIVITY_TYPE_REGISGER.getCode()){
                    activityMessageVO.setOpenId(wxChannelInfoVo.getWxOpenId());
                }
                if (null==wxChannelInfoVo.getMemberCode()){
                    activityMessageVO.setMemberCode(String.valueOf(1));
                }else{
                    activityMessageVO.setMemberCode(wxChannelInfoVo.getMemberCode());
                }
                activityMessageVO.setSysCompanyId(activityVO.getSysCompanyId());
                activityMessageVO.setSysBrandId(activityVO.getSysBrandId());
                activityMessageVO.setSysBrandName(SysBrandPos.getData().getBrandName());
                activityMessageVO.setActivityName(activityVO.getActivityName());
                activityMessageVO.setActivityInterests(mktMessagePO.getMsgContent());
                activityMessageVO.setMemberPhone(wxChannelInfoVo.getPhone());
                if (activityVO.getLongTerm()==1){
                    activityMessageVO.setActivityLongtime("长期活动");
                }else{
                    activityMessageVO.setActivityStartDate(activityVO.getStartTime());
                    activityMessageVO.setActivityEndDate(activityVO.getEndTime());
                }
                activityMessageVO.setUnl("/pages/template01/activity-details/main?activityCode="+activityVO.getActivityCode()+"&activityType="+activityVO.getActivityType());
                awardBO.setActivityMessageVO(activityMessageVO);
                awardBO.setMktType(MktSmartTypeEnum.SMART_TYPE_WXMESSAGE.getCode());
                award.execute(awardBO);
            }
        }
    }

    @Override
    @Async("asyncServiceExecutor")
    public void sendDx(List<MktMessagePO> messageVOList, MemberInfoModel memberInfo) {
        for (MktMessagePO mktMessagePO:messageVOList) {
            AwardBO awardBO = new AwardBO();
            if (mktMessagePO.getMsgType().equals("2")){
                ActivityMessageVO activityMessageVO = new ActivityMessageVO();
                activityMessageVO.setMemberPhone(memberInfo.getPhone());
                activityMessageVO.setSysBrandId(memberInfo.getBrandId());
                activityMessageVO.setMemberName(memberInfo.getName());
                activityMessageVO.setSendWxmember(mktMessagePO.getMsgContent());
                awardBO.setActivityMessageVO(activityMessageVO);
                awardBO.setMktType(MktSmartTypeEnum.SMART_TYPE_SMS.getCode());
                //发送短信消息
                award.execute(awardBO);
            }
        }
    }

    /**
     * 活动、任务效果分析“发行优惠券”添加会员明细弹框；
     * @return
     */
    @Override
    public ResponseData<PageInfo<CouponSendMemberListResponseVO>> findCouponSendResultActivity(Long id, Integer type,
                                                                                       SysAccountPO stageUser,PageForm pageForm,
                                                                                        String name,String cardNo) {
        ResponseData responseData = new ResponseData();

        if(null == id){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.MODEL_FAILED_VALIDATION.getMessage());
            return responseData;
        }

        if(null == type){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.MODEL_FAILED_VALIDATION.getMessage());
            return responseData;
        }

        CouponSendMemberListRequestVO requestVO = new CouponSendMemberListRequestVO();
        requestVO.setSendBusinessId(id);
        //类型转换
        requestVO.setSendType(ActivityConvertCouponTypeEnum.getActivityConvertCouponTypeEnumByCode(type).getCouponCode());
        requestVO.setBrandId(stageUser.getBrandId());
        requestVO.setPageNumber(pageForm.getPageNumber());
        requestVO.setPageSize(pageForm.getPageSize());
        requestVO.setName(name);
        requestVO.setCardNo(cardNo);

        ResponseData<PageInfo<CouponSendMemberListResponseVO>> sendMemberListResult = couponEntityServiceFeign.findCouponSendMemberList(requestVO);

        responseData.setData(sendMemberListResult.getData());
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }

    /**
     * 白名单店铺
     * @param vo
     * @return
     */
    @Override
    public List<Long> getActivityWhiteStoreIds(WhiteStoreVO vo) {
        List<Long> storeIds = null;
        try{
            String whiteStoreIds = mktActivityPOMapper.getActivityWhiteStoreIds(vo);
            if (org.apache.commons.lang3.StringUtils.isNotBlank(whiteStoreIds)){
                storeIds = Arrays.asList(whiteStoreIds.split(",")).stream().filter(element -> org.apache.commons.lang3.StringUtils.isNotBlank(element)).
                        map(element -> Long.valueOf(element)).distinct().collect(Collectors.toList());
            }
        }catch (Exception e){
            e.printStackTrace();
            log.info("getWhiteStoreIds--异常--");
        }finally {
            return storeIds;
        }
    }
}
