package com.bizvane.mktcenterservice.service.rpc;

import com.alibaba.fastjson.JSON;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.service.api.MemberInfoApiService;
import com.bizvane.members.facade.vo.MemberInfoApiModel;
import com.bizvane.mktcenterfacade.models.po.*;
import com.bizvane.mktcenterfacade.models.vo.ActivityInviteVO;
import com.bizvane.mktcenterfacade.models.vo.InviteSuccessVO;
import com.bizvane.mktcenterfacade.models.vo.MktActivityRecordVO;
import com.bizvane.mktcenterfacade.rpc.ActivityInviteServiceRpc;
import com.bizvane.mktcenterservice.common.constants.ActivityConstants;
import com.bizvane.mktcenterservice.common.enums.ActivityTypeEnum;
import com.bizvane.mktcenterservice.mappers.MktActivityInvitePOMapper;
import com.bizvane.mktcenterservice.mappers.MktActivityRecordPOMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    /**
     * 现在执行活动的逻辑是没满足条件一次，往record表中插入一条记录，同时更新statistics表统计的数据
     * 当满足奖励条件时，只在record的某一条数据上标注奖励为是
     * @param vo
     */
    @Override
    public void award(InviteSuccessVO vo) {
        log.info("邀请注册活动的参数:{}",JSON.toJSONString(vo));
        //查邀请人会员信息
        MemberInfoApiModel members = new MemberInfoApiModel();
        members.setMemberCode(vo.getInviteMemberCode());
        MemberInfoModel invitemMmeberInfo = memberInfoApiService.getMemberModel(members).getData();
        log.info("邀请注册活动的会员信息:{}",JSON.toJSONString(invitemMmeberInfo));

        //符合条件的活动列表
        List<ActivityInviteVO> executingActivityList = mktActivityInvitePOMapper.getExecutingActivityList(invitemMmeberInfo.getSysCompanyId());
        log.info("邀请注册活动符合条件的列表--"+ JSON.toJSONString(executingActivityList));
        if (CollectionUtils.isNotEmpty(executingActivityList)){
            executingActivityList.forEach(obj->{
                //邀请开卡人数
                Integer inviteNum = obj.getInviteNum();
                MktActivityRecordVO recordVO = new MktActivityRecordVO();
                recordVO.setSysBrandId(invitemMmeberInfo.getBrandId());
                recordVO.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_INVITE.getCode());
                recordVO.setAcitivityId(obj.getMktActivityId());
                recordVO.setMemberCode(invitemMmeberInfo.getMemberCode());
                // 获取会员是否已经成功参与过某一活动
                Boolean awarded = judgeIfAwarded(recordVO);
                if (!awarded){
                    MktActivityRecordPO recordPO = new MktActivityRecordPO();
                    BeanUtils.copyProperties(recordVO,recordPO);
                    recordPO.setParticipateDate(vo.getOpenCardTime());
                    recordPO.setSysCompanyId(invitemMmeberInfo.getSysCompanyId());
                    if(null==recordPO.getPoints()){
                        recordPO.setPoints(0);
                    }
                    log.info("新增积分记录表");
                    mktActivityRecordPOMapper.insertSelective(recordPO);

//                    //更新总次数
//                    TotalStatisticsBO totalBO = taskRecordService.getTotalStatistics(recordVO);
//                    if (totalBO!=null && totalBO.getTotalTimes()!=null &&  totalBO.getTotalTimes().equals(inviteNum)){
//                        recordPO.setRewarded(1);
//                        recordPO.setPoints(obj.getPoints());
//                        recordPO.setMktTaskRecordId(recordId);
//                        taskRecordService.updateTaskRecord(recordPO);
//                        log.info("---邀请注册活动 发券--");
//                        taskService.sendCouponAndPoint(memberCode,obj);
//                    }
                }
            });
        }
    }

    //判断会员邀请开卡是否获得过奖励
    public Boolean judgeIfAwarded(MktActivityRecordVO vo){
        log.info("enter ActivityInviteServiceRpcImpl#judgeIfAwarded paramas:{}",JSON.toJSONString(vo));
        MktActivityRecordPOExample excamle = new MktActivityRecordPOExample();
        excamle.createCriteria().andSysBrandIdEqualTo(vo.getSysBrandId()).andAcitivityIdEqualTo(vo.getAcitivityId()).andMemberCodeEqualTo(vo.getMemberCode())
                .andRewardedEqualTo(1).andActivityTypeEqualTo(vo.getActivityType()).andValidEqualTo(Boolean.TRUE);
        List<MktActivityRecordPO> list= mktActivityRecordPOMapper.selectByExample(excamle);

        for(MktActivityRecordPO mktActivityRecordPO : list){
            if(ActivityConstants.awarded.equals(mktActivityRecordPO.getRewarded())){
                return  Boolean.TRUE;
            }
        }
        return  Boolean.FALSE;
    }
}
