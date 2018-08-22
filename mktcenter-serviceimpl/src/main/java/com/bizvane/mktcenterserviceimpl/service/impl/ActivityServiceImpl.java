package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.centerstageservice.models.po.SysCheckPo;
import com.bizvane.centerstageservice.rpc.SysCheckServiceRpc;
import com.bizvane.couponfacade.enums.SendTypeEnum;
import com.bizvane.couponfacade.interfaces.CouponQueryServiceFeign;
import com.bizvane.couponfacade.models.vo.CouponFindCouponCountResponseVO;
import com.bizvane.members.facade.models.IntegralRecordModel;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.service.api.IntegralRecordApiService;
import com.bizvane.members.facade.service.api.MemberInfoApiService;
import com.bizvane.members.facade.vo.MemberInfoApiModel;
import com.bizvane.messagefacade.models.vo.MemberMessageVO;
import com.bizvane.messagefacade.models.vo.SysSmsConfigVO;
import com.bizvane.mktcenterservice.interfaces.ActivityService;
import com.bizvane.mktcenterservice.models.bo.ActivityAnalysisCountBO;
import com.bizvane.mktcenterservice.models.bo.AwardBO;
import com.bizvane.mktcenterservice.models.bo.CtivityAnalysisBO;
import com.bizvane.mktcenterservice.models.po.*;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterserviceimpl.common.award.Award;
import com.bizvane.mktcenterserviceimpl.common.enums.*;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityRegisterPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktMessagePOMapper;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.Date;
import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/6 19:50
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@Service
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
    private IntegralRecordApiService integralRecordApiService;
    @Autowired
    private Award award;
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
                int i = mktActivityPOMapper.updateByPrimaryKeySelective(bs);
                //发送模板消息TODO
                //查询消息集合
                MktMessagePOExample example = new MktMessagePOExample();
                example.createCriteria().andBizIdEqualTo(po.getBusinessId()).andValidEqualTo(true);
                List<MktMessagePO> listMktMessage = mktMessagePOMapper.selectByExample(example);
                //查询对应的会员
                MemberInfoApiModel memberInfoModel= new MemberInfoApiModel();
                memberInfoModel.setBrandId(activityPO.getSysBrandId());
                memberInfoModel.setLevelId(Long.parseLong(activityPO.getMbrLevelCode()));
                ResponseData<List<MemberInfoModel>> memberInfoModelLists =memberInfoApiService.getMemberInfo(memberInfoModel);
                List<MemberInfoModel> memberInfoModelList = memberInfoModelLists.getData();
                //循环发送
                if (!org.springframework.util.CollectionUtils.isEmpty(memberInfoModelList)){
                    for (MemberInfoModel memberInfo:memberInfoModelList) {
                        //循环信息类然后发送
                        for (MktMessagePO mktMessagePO:listMktMessage) {
                            AwardBO awardBO = new AwardBO();
                            if (mktMessagePO.getMsgType().equals("1")){
                                //发送微信模板消息
                                MemberMessageVO memberMessageVO = new MemberMessageVO();
                                memberMessageVO.setMemberCode(memberInfo.getMemberCode());
                                memberMessageVO.setActivityName(activityPO.getActivityName());
                                memberMessageVO.setActivityDate(activityPO.getStartTime());
                                memberMessageVO.setActivityInterests(mktMessagePO.getMsgContent());
                                awardBO.setMemberMessageVO(memberMessageVO);
                                awardBO.setMktType(MktSmartTypeEnum.SMART_TYPE_WXMESSAGE.getCode());
                                award.execute(awardBO);
                            }
                            if (mktMessagePO.getMsgType().equals("2")){
                                SysSmsConfigVO  sysSmsConfigVO = new SysSmsConfigVO();
                                sysSmsConfigVO.setPhone(memberInfo.getPhone());
                                sysSmsConfigVO.setMsgContent(mktMessagePO.getMsgContent());
                                sysSmsConfigVO.setSysBrandId(activityPO.getSysBrandId());
                                awardBO.setSysSmsConfigVO(sysSmsConfigVO);
                                awardBO.setMktType(MktSmartTypeEnum.SMART_TYPE_SMS.getCode());
                                //发送短信消息
                                award.execute(awardBO);
                            }
                        }
                    }
                }

            }
            //判断审核时间 >活动结束时间  将活动状态变为已结束
            if(new Date().after(activityPO.getEndTime())){
                bs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_FINISHED.getCode());
                int i = mktActivityPOMapper.updateByPrimaryKeySelective(bs);
            }

        }else{
            bs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_FINISHED.getCode());
            int i = mktActivityPOMapper.updateByPrimaryKeySelective(bs);
        }
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
        List<ActivityVO> activityList =mktActivityPOMapper.getActivityList(vo);
        responseData.setData(activityList);
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
        List<ActivityAnalysisCountBO> activityAnalysisList = mktActivityPOMapper.getActivityAnalysisCountpage(bo);
        if (!CollectionUtils.isEmpty(activityAnalysisList)){
            for (ActivityAnalysisCountBO activityAnalysisCount:activityAnalysisList) {
                //查询券统计
                ResponseData<CouponFindCouponCountResponseVO> couponFindCouponCountResponseVODate = couponQueryServiceFeign.findCouponCountBySendBusinessId(activityAnalysisCount.getMktActivityId(), CouponSendTypeEnum.getCouponSendTypeEnumByMktModuleCode(bo.getActivityType()).getCouponModuleCode(),activityAnalysisCount.getSysBrandId());
                CouponFindCouponCountResponseVO couponFindCouponCountResponseVO = couponFindCouponCountResponseVODate.getData();
                //券数量
                activityAnalysisCount.setCouponSum(couponFindCouponCountResponseVO.getCouponSum());
                //核销券数量
                activityAnalysisCount.setCouponUsedSum(couponFindCouponCountResponseVO.getCouponUsedSum());
                //收益
                activityAnalysisCount.setMoney(couponFindCouponCountResponseVO.getMoney());
                //核销率
                if (null!=couponFindCouponCountResponseVO.getCouponUsedSum() && null!=couponFindCouponCountResponseVO.getCouponSum()) {
                    // 创建一个数值格式化对象
                    NumberFormat numberFormat = NumberFormat.getInstance();
                    // 设置精确到小数点后2位
                    numberFormat.setMaximumFractionDigits(2);
                    String result = numberFormat.format((float) couponFindCouponCountResponseVO.getCouponUsedSum() / (float) couponFindCouponCountResponseVO.getCouponSum() * 100);
                    activityAnalysisCount.setCouponUsedSumPercentage(result + "%");
                }

            }

        }
        //合计积分总数 和参与人数总数
        CtivityAnalysisBO ctivityAnalysis = mktActivityPOMapper.getActivityAnalysisTotal(bo);
        //参与人数
        ctivityAnalysisBO.setParticipateTotal(ctivityAnalysis.getParticipateTotal());
        //积分总数
        ctivityAnalysisBO.setPointsSumTotal(ctivityAnalysis.getPointsSumTotal());
        //积分 合计 券收益合计
        String activityType="";
        if(bo.getActivityType()== ActivityTypeEnum.ACTIVITY_TYPE_REGISGER.getCode()){
            activityType = SendTypeEnum.SEND_COUPON_ONLINE_ACTIVITY.getCode();
        }
        if(bo.getActivityType()== ActivityTypeEnum.ACTIVITY_TYPE_UPGRADE.getCode()){
            activityType = SendTypeEnum.SEND_COUPON_UPGRADE_ACTIVITY.getCode();
        }
        if(bo.getActivityType()== ActivityTypeEnum.ACTIVITY_TYPE_ORDER.getCode()){
            activityType = SendTypeEnum.SEND_COUPON_COUSUME_ACTIVITY.getCode();
        }
        if(bo.getActivityType()== ActivityTypeEnum.ACTIVITY_TYPE_SIGNIN.getCode()){
            activityType = SendTypeEnum.SEND_COUPON_SIGN_ACTIVITY.getCode();
        }
        if(bo.getActivityType()== ActivityTypeEnum.ACTIVITY_TYPE_BIRTHDAY.getCode()){
            activityType = SendTypeEnum.SEND_COUPON_BIRTH_ACTIVITY.getCode();
        }
        if(bo.getActivityType()== ActivityTypeEnum.ACTIVITY_TYPE_QRCODE.getCode()){
            activityType = SendTypeEnum.SEND_COUPON_RECEIVE_ACTIVITY.getCode();
        }
        if(bo.getActivityType()== ActivityTypeEnum.ACTIVITY_TYPE_MANUAL.getCode()){
            activityType = SendTypeEnum.SEND_COUPON_RECEIVE_ACTIVITY.getCode();
        }
        //查询券合计
        ResponseData<CouponFindCouponCountResponseVO> couponFindCouponCountVO =  couponQueryServiceFeign.getCountBySendType(activityType,bo.getSysBrandId());
        CouponFindCouponCountResponseVO couponFindCoupon = couponFindCouponCountVO.getData();
        //合计优惠券总数量
        ctivityAnalysisBO.setCouponSumTotal(couponFindCoupon.getCouponSum());
        //合计优惠券核销数量
        ctivityAnalysisBO.setCouponUsedSumTotal(couponFindCoupon.getCouponUsedSum());
        //合计券收益
        ctivityAnalysisBO.setMoneyTotal(couponFindCoupon.getMoney());
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
}
