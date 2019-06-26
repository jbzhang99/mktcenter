package com.bizvane.mktcenterservice.service.rpc;

import com.alibaba.fastjson.JSON;
import com.bizvane.couponfacade.enums.SendTypeEnum;
import com.bizvane.couponfacade.models.vo.SendCouponSimpleRequestVO;
import com.bizvane.members.facade.enums.IntegralChangeTypeEnum;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.service.api.MemberInfoApiService;
import com.bizvane.members.facade.service.card.request.IntegralChangeRequestModel;
import com.bizvane.members.facade.vo.MemberInfoApiModel;
import com.bizvane.mktcenterfacade.models.bo.ActivityInviteBO;
import com.bizvane.mktcenterfacade.models.bo.AwardBO;
import com.bizvane.mktcenterfacade.models.po.*;
import com.bizvane.mktcenterfacade.models.vo.ActivityInviteVO;
import com.bizvane.mktcenterfacade.models.vo.ActivityVO;
import com.bizvane.mktcenterfacade.models.vo.InviteSuccessVO;
import com.bizvane.mktcenterfacade.models.vo.MktActivityRecordVO;
import com.bizvane.mktcenterfacade.rpc.ActivityInviteServiceRpc;
import com.bizvane.mktcenterservice.common.award.Award;
import com.bizvane.mktcenterservice.common.constants.ActivityConstants;
import com.bizvane.mktcenterservice.common.enums.ActivityTypeEnum;
import com.bizvane.mktcenterservice.common.enums.BusinessTypeEnum;
import com.bizvane.mktcenterservice.common.enums.MktSmartTypeEnum;
import com.bizvane.mktcenterservice.mappers.MktActivityInvitePOMapper;
import com.bizvane.mktcenterservice.mappers.MktActivityRecordPOMapper;
import com.bizvane.mktcenterservice.mappers.MktActivityStatisticsPOMapper;
import com.bizvane.mktcenterservice.mappers.MktCouponPOMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author chen.li
 * @date on 2019/6/19 15:24
 * @description
 */
@RestController
@RequestMapping("activityInviteRpc")
@Slf4j
public class ActivityInviteServiceRpcImpl implements ActivityInviteServiceRpc {

    @Autowired
    private MemberInfoApiService memberInfoApiService;

    @Autowired
    private MktActivityInvitePOMapper mktActivityInvitePOMapper;

    @Autowired
    private MktActivityRecordPOMapper mktActivityRecordPOMapper;

    @Autowired
    private MktActivityStatisticsPOMapper mktActivityStatisticsPOMapper;

    @Autowired
    private MktCouponPOMapper mktCouponPOMapper;

    @Autowired
    private Award award;

    /**
     * 现在执行活动的逻辑是每满足条件一次，往record表中插入一条记录，同时更新statistics表统计的数据
     * 当满足奖励条件时，只在record的某一条数据上标注已奖励为是
     *
     * @param vo
     */
    @Override
    public void award(InviteSuccessVO vo) {
        log.info("邀请注册活动的参数:{}", JSON.toJSONString(vo));
        //查邀请人会员信息
        MemberInfoApiModel members = new MemberInfoApiModel();
        members.setBrandId(vo.getSysBrandId());
        members.setMemberCode(vo.getInviteOpenId());
        MemberInfoModel invitemMmeberInfo = memberInfoApiService.getMemberModel(members).getData();
        log.info("邀请注册活动的会员信息:{}", JSON.toJSONString(invitemMmeberInfo));

        //符合条件的活动列表
        List<ActivityVO> executingActivityList = mktActivityInvitePOMapper.getExecutingActivityList(invitemMmeberInfo.getSysCompanyId());
        log.info("邀请注册活动符合条件的列表--" + JSON.toJSONString(executingActivityList));
        if (CollectionUtils.isNotEmpty(executingActivityList)) {
            executingActivityList.forEach(obj -> {
                //邀请开卡人数
                MktActivityRecordPO mktActivityRecordPO = new MktActivityRecordPO();
                mktActivityRecordPO.setSysCompanyId(invitemMmeberInfo.getSysCompanyId());
                mktActivityRecordPO.setSysBrandId(invitemMmeberInfo.getBrandId());
                mktActivityRecordPO.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_INVITE.getCode());
                mktActivityRecordPO.setAcitivityId(obj.getMktActivityId());
                mktActivityRecordPO.setMemberCode(invitemMmeberInfo.getMemberCode());
                mktActivityRecordPO.setParticipateDate(vo.getOpenCardTime());
                if (null == mktActivityRecordPO.getPoints()) {
                    mktActivityRecordPO.setPoints(0);
                } else {
                    mktActivityRecordPO.setPoints(obj.getPoints());
                }
                // 获取会员是否已经成功参与过某一活动
                ActivityInviteBO activityInviteBO = judgeIfAwarded(mktActivityRecordPO);
                log.info("the member is awarded:{}", activityInviteBO.getAwarded());
                if (!activityInviteBO.getAwarded() && obj.getInviteNum().equals(activityInviteBO.getParcitpateTimes())) {
                    mktActivityRecordPO.setRewarded(1);
                    log.info("新增参与记录");
                    mktActivityRecordPOMapper.insertSelective(mktActivityRecordPO);
                    log.info("邀请注册活动完成，进行奖励");
                    //判断奖励
                    if (obj.getPoints() != null) {
                        log.info("邀请注册活动给membercode:{}赠送积分:{}", invitemMmeberInfo.getMemberCode(), obj.getPoints());
                        AwardBO bo = new AwardBO();
                        IntegralChangeRequestModel integralChangeRequestModel =new IntegralChangeRequestModel();
                        integralChangeRequestModel.setSysCompanyId(invitemMmeberInfo.getSysCompanyId());
                        integralChangeRequestModel.setBrandId(invitemMmeberInfo.getBrandId());
                        integralChangeRequestModel.setMemberCode(invitemMmeberInfo.getMemberCode());
                        integralChangeRequestModel.setChangeBills(obj.getActivityCode());
                        integralChangeRequestModel.setChangeIntegral(obj.getPoints());
                        integralChangeRequestModel.setChangeType(IntegralChangeTypeEnum.INCOME.getCode());
                        integralChangeRequestModel.setBusinessType(com.bizvane.members.facade.enums.BusinessTypeEnum.TASK_TYPE_INVITATION_OPENCARD.getCode());
                        integralChangeRequestModel.setChangeDate(new Date());
                        bo.setIntegralRecordModel(integralChangeRequestModel);
                        bo.setMktType(MktSmartTypeEnum.SMART_TYPE_INTEGRAL.getCode());
                        log.info("邀请注册活动送积分,params:{}", JSON.toJSONString(integralChangeRequestModel));
                        award.execute(bo);
                    }
                    MktCouponPOExample mktCouponPOExample = new MktCouponPOExample();
                    mktCouponPOExample.createCriteria().andValidEqualTo(Boolean.TRUE).andSysCompanyIdEqualTo(obj.getSysCompanyId())
                            .andBizTypeEqualTo(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode()).andBizIdEqualTo(obj.getMktActivityId());
                    List<MktCouponPO> mktCouponPOS = mktCouponPOMapper.selectByExample(mktCouponPOExample);
                    if (CollectionUtils.isNotEmpty(mktCouponPOS)) {
                        log.info("邀请注册活动给membercode:{}赠送券:{}", invitemMmeberInfo.getMemberCode(), JSON.toJSONString(mktCouponPOS));
                        AwardBO awardBO = new AwardBO();
                        SendCouponSimpleRequestVO sendCouponSimpleRequestVO = new SendCouponSimpleRequestVO();
                        sendCouponSimpleRequestVO.setMemberCode(invitemMmeberInfo.getMemberCode());
                        sendCouponSimpleRequestVO.setCouponDefinitionId(obj.getCouponDefinitionId());
                        sendCouponSimpleRequestVO.setSendBussienId(obj.getMktActivityId());
                        sendCouponSimpleRequestVO.setSendType(SendTypeEnum.SEND_COUPON_INVITE_OPENCARD_TASK.getCode());
                        sendCouponSimpleRequestVO.setCompanyId(invitemMmeberInfo.getSysCompanyId());
                        sendCouponSimpleRequestVO.setBrandId(invitemMmeberInfo.getBrandId());
                        sendCouponSimpleRequestVO.setBusinessName(obj.getActivityName());
                        awardBO.setSendCouponSimpleRequestVO(sendCouponSimpleRequestVO);
                        awardBO.setMktType(MktSmartTypeEnum.SMART_TYPE_COUPON.getCode());
                        log.info("邀请注册活动送券,params:{}", JSON.toJSONString(sendCouponSimpleRequestVO));
                        award.execute(awardBO);
                    }
                }
            });
        }
    }

    //查询会员某个邀请开卡活动参与次数
    private ActivityInviteBO judgeIfAwarded(MktActivityRecordPO mktActivityRecordPO){
        ActivityInviteBO activityInviteBO = new ActivityInviteBO();
        log.info("enter ActivityInviteServiceRpcImpl#judgeIfAwarded paramas:{}",JSON.toJSONString(mktActivityRecordPO));
        MktActivityRecordPOExample excamle = new MktActivityRecordPOExample();
        excamle.createCriteria().andSysBrandIdEqualTo(mktActivityRecordPO.getSysBrandId()).andAcitivityIdEqualTo(mktActivityRecordPO.getAcitivityId()).andMemberCodeEqualTo(mktActivityRecordPO.getMemberCode())
                .andRewardedEqualTo(1).andActivityTypeEqualTo(mktActivityRecordPO.getActivityType()).andValidEqualTo(Boolean.TRUE);
        List<MktActivityRecordPO> list= mktActivityRecordPOMapper.selectByExample(excamle);
        //默认给false
        activityInviteBO.setAwarded(Boolean.FALSE);
        activityInviteBO.setParcitpateTimes(list.size());
        for(MktActivityRecordPO recordPO : list){
            if(ActivityConstants.awarded.equals(recordPO.getRewarded())){
                activityInviteBO.setAwarded(Boolean.TRUE);
                return activityInviteBO;
            }
        }
        return  activityInviteBO;
    }
}
