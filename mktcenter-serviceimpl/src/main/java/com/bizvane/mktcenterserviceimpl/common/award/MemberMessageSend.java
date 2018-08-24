package com.bizvane.mktcenterserviceimpl.common.award;

import com.bizvane.couponfacade.models.vo.SendCouponSimpleRequestVO;
import com.bizvane.members.facade.enums.IntegralChangeTypeEnum;
import com.bizvane.members.facade.es.vo.MembersInfoSearchVo;
import com.bizvane.members.facade.models.IntegralRecordModel;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.service.api.MemberInfoApiService;
import com.bizvane.members.facade.service.api.MembersAdvancedSearchApiService;
import com.bizvane.members.facade.vo.MemberInfoApiModel;
import com.bizvane.members.facade.vo.MemberInfoVo;
import com.bizvane.members.facade.vo.PageVo;
import com.bizvane.messagefacade.models.vo.MemberMessageVO;
import com.bizvane.messagefacade.models.vo.SysSmsConfigVO;
import com.bizvane.mktcenterservice.interfaces.ActivityBirthdayService;
import com.bizvane.mktcenterservice.models.bo.AwardBO;
import com.bizvane.mktcenterservice.models.po.MktCouponPO;
import com.bizvane.mktcenterservice.models.po.MktMessagePO;
import com.bizvane.mktcenterservice.models.vo.ActivitySmartVO;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterserviceimpl.common.enums.MktSmartTypeEnum;
import com.bizvane.utils.responseinfo.PageInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 查询会员发送消息
 * Created by agan on 2018/8/24.
 */
@Component
public class MemberMessageSend {
    @Autowired
    private MembersAdvancedSearchApiService membersAdvancedSearchApiService;
    @Autowired
    private Award award;
    @Autowired
    private MemberInfoApiService memberInfoApiService;
    @Autowired
    private ActivityBirthdayService activityBirthdayService;
    /**
     * 查询会员信息发送你个短信和微信消息
     * @param messageVOList
     * @param membersInfoSearchVo
     */
    @Async("asyncServiceExecutor")
    public void getMemberList(List<MktMessagePO> messageVOList, MembersInfoSearchVo membersInfoSearchVo) {
        ResponseData<PageInfo<MemberInfoVo>> memberInfoVoPage = membersAdvancedSearchApiService.search(membersInfoSearchVo);
        //循环分页条件查询会员信息发送短信信息
        for (int a =1;a<=memberInfoVoPage.getData().getPages();a++){
            membersInfoSearchVo.setPageNumber(a);
            ResponseData<com.bizvane.utils.responseinfo.PageInfo<MemberInfoVo>> memberInfoVoPages = membersAdvancedSearchApiService.search(membersInfoSearchVo);
            List<MemberInfoVo> memberInfoModelList = memberInfoVoPages.getData().getList();
            //循环发送
            if (!CollectionUtils.isEmpty(memberInfoModelList)){
                for (MemberInfoModel memberInfo:memberInfoModelList) {
                    //循环信息类然后发送
                    for (MktMessagePO mktMessagePO:messageVOList) {
                        AwardBO awardBO = new AwardBO();
                        if (mktMessagePO.getMsgType().equals("1") && !StringUtils.isEmpty(memberInfo.getWxOpenId())){
                            //发送微信模板消息
                            MemberMessageVO memberMessageVO = new MemberMessageVO();
                            memberMessageVO.setMemberCode(memberInfo.getMemberCode());
                            memberMessageVO.setOpenId(memberInfo.getWxOpenId());
                            awardBO.setMemberMessageVO(memberMessageVO);
                            awardBO.setMktType(MktSmartTypeEnum.SMART_TYPE_WXMESSAGE.getCode());
                            award.execute(awardBO);
                        }
                        if (mktMessagePO.getMsgType().equals("2")){
                            SysSmsConfigVO sysSmsConfigVO = new SysSmsConfigVO();
                            sysSmsConfigVO.setPhone(memberInfo.getPhone());
                            awardBO.setSysSmsConfigVO(sysSmsConfigVO);
                            awardBO.setMktType(MktSmartTypeEnum.SMART_TYPE_SMS.getCode());
                            //发送短信消息
                            award.execute(awardBO);
                        }
                    }
                }
            }
        }
    }

    /**
     * 查询会员信息发送积分奖励
     * @param vo
     * @param activityCode
     * @param membersInfoSearchVo
     */
    @Async("asyncServiceExecutor")
    public void sendMemberPoints(ActivitySmartVO vo, String activityCode, MembersInfoSearchVo membersInfoSearchVo) {
        ResponseData<com.bizvane.utils.responseinfo.PageInfo<MemberInfoVo>> memberInfoVoPage = membersAdvancedSearchApiService.search(membersInfoSearchVo);
        AwardBO awardBO = new AwardBO();
        IntegralRecordModel integralRecordModel = new IntegralRecordModel();
        for (int a =1;a<=memberInfoVoPage.getData().getPages();a++) {
            membersInfoSearchVo.setPageNumber(a);
            ResponseData<com.bizvane.utils.responseinfo.PageInfo<MemberInfoVo>> memberInfoVoPages = membersAdvancedSearchApiService.search(membersInfoSearchVo);
            List<MemberInfoVo> memberInfoModelList = memberInfoVoPages.getData().getList();
            for (MemberInfoModel memberInfo:memberInfoModelList) {
                integralRecordModel.setMemberCode(memberInfo.getMemberCode());
                integralRecordModel.setChangeBills(activityCode);
                integralRecordModel.setChangeIntegral(vo.getPoints());
                integralRecordModel.setChangeWay(IntegralChangeTypeEnum.INCOME.getCode());
                awardBO.setIntegralRecordModel(integralRecordModel);
                awardBO.setMktType(MktSmartTypeEnum.SMART_TYPE_INTEGRAL.getCode());
                award.execute(awardBO);
            }
        }
    }

    /**
     * 智能营销发送短信消息
     * @param mktMessagePO
     * @param membersInfoSearchVo
     */
    @Async("asyncServiceExecutor")
    public  void sendShortMessage(MktMessagePO mktMessagePO, MembersInfoSearchVo membersInfoSearchVo) {
        ResponseData<com.bizvane.utils.responseinfo.PageInfo<MemberInfoVo>> memberInfoVoPage = membersAdvancedSearchApiService.search(membersInfoSearchVo);
        AwardBO awardBO = new AwardBO();
        SysSmsConfigVO sysSmsConfigVO = new SysSmsConfigVO();
        for (int a =1;a<=memberInfoVoPage.getData().getPages();a++) {
            membersInfoSearchVo.setPageNumber(a);
            ResponseData<com.bizvane.utils.responseinfo.PageInfo<MemberInfoVo>> memberInfoVoPages = membersAdvancedSearchApiService.search(membersInfoSearchVo);
            List<MemberInfoVo> memberInfoModelList = memberInfoVoPages.getData().getList();
            for (MemberInfoModel memberInfo:memberInfoModelList) {
                sysSmsConfigVO.setPhone(memberInfo.getPhone());
                sysSmsConfigVO.setMsgContent(mktMessagePO.getMsgContent());
                awardBO.setSysSmsConfigVO(sysSmsConfigVO);
                awardBO.setMktType(MktSmartTypeEnum.SMART_TYPE_SMS.getCode());
                award.execute(awardBO);
            }
        }
    }
    /**
     * 智能营销发送微信模板消息
     * @param mktMessagePO
     * @param membersInfoSearchVo
     */
    @Async("asyncServiceExecutor")
    public  void sendWxMessage(MktMessagePO mktMessagePO, MembersInfoSearchVo membersInfoSearchVo) {
        ResponseData<com.bizvane.utils.responseinfo.PageInfo<MemberInfoVo>> memberInfoVoPage = membersAdvancedSearchApiService.search(membersInfoSearchVo);
        AwardBO awardBO = new AwardBO();
        MemberMessageVO memberMessageVO = new MemberMessageVO();
        for (int a =1;a<=memberInfoVoPage.getData().getPages();a++) {
            membersInfoSearchVo.setPageNumber(a);
            ResponseData<com.bizvane.utils.responseinfo.PageInfo<MemberInfoVo>> memberInfoVoPages = membersAdvancedSearchApiService.search(membersInfoSearchVo);
            List<MemberInfoVo> memberInfoModelList = memberInfoVoPages.getData().getList();
            for (MemberInfoModel memberInfo:memberInfoModelList) {
                memberMessageVO.setMemberCode(memberInfo.getMemberCode());
                memberMessageVO.setOpenId(memberInfo.getWxOpenId());
                memberMessageVO.setActivityInterests(mktMessagePO.getMsgContent());
                awardBO.setMemberMessageVO(memberMessageVO);
                awardBO.setMktType(MktSmartTypeEnum.SMART_TYPE_WXMESSAGE.getCode());
                award.execute(awardBO);
            }
        }
    }

    /**
     * 营销查询会员发券
     * @param vo
     * @param membersInfoSearchVo
     */
    @Async("asyncServiceExecutor")
    public void sendMemberCoupon(ActivitySmartVO vo, MembersInfoSearchVo membersInfoSearchVo) {
        ResponseData<com.bizvane.utils.responseinfo.PageInfo<MemberInfoVo>> memberInfoVoPage = membersAdvancedSearchApiService.search(membersInfoSearchVo);
        AwardBO awardBO = new AwardBO();
        SendCouponSimpleRequestVO sendCouponSimpleRequestVO = new SendCouponSimpleRequestVO();
        for (int a = 1; a <= memberInfoVoPage.getData().getPages(); a++) {
            membersInfoSearchVo.setPageNumber(a);
            ResponseData<com.bizvane.utils.responseinfo.PageInfo<MemberInfoVo>> memberInfoVoPages = membersAdvancedSearchApiService.search(membersInfoSearchVo);
            List<MemberInfoVo> memberInfoModelList = memberInfoVoPages.getData().getList();
            for (MemberInfoModel memberInfo : memberInfoModelList) {
                if (!CollectionUtils.isEmpty(vo.getMktCouponPOS())) {
                    for (MktCouponPO mktCouponPO : vo.getMktCouponPOS()) {
                        sendCouponSimpleRequestVO.setMemberCode(memberInfo.getMemberCode().toString());
                        sendCouponSimpleRequestVO.setCouponDefinitionId(mktCouponPO.getCouponDefinitionId());
                        sendCouponSimpleRequestVO.setSendBussienId(mktCouponPO.getBizId());
                        awardBO.setSendCouponSimpleRequestVO(sendCouponSimpleRequestVO);
                        awardBO.setMktType(MktSmartTypeEnum.SMART_TYPE_COUPON.getCode());
                        award.execute(awardBO);
                    }
                }
            }
        }
    }

    /**
     * 生日活动发送奖励券
     * @param activityBirthdayList
     */
    @Async("asyncServiceExecutor")
    public void sendBirthdayCoupon(List<ActivityVO> activityBirthdayList) {
        for (ActivityVO activityBirthday:activityBirthdayList) {
            //根据品牌id 会员等级 会员范围  时间周期 查询会员信息 循环
            //查询对应的会员
            MemberInfoApiModel memberInfoModel= new MemberInfoApiModel();
            memberInfoModel.setBrandId(activityBirthday.getSysBrandId());
            if (!activityBirthday.getMbrLevelCode().equals("0")){
                memberInfoModel.setLevelId(Long.parseLong(activityBirthday.getMbrLevelCode()));
            }
            memberInfoModel.setBirthdayLine(activityBirthday.getDaysAhead());
            memberInfoModel.setMemberScope(activityBirthday.getMemberType().toString());
            memberInfoModel.setPageNumber(1);
            memberInfoModel.setPageSize(10000);
            ResponseData<PageInfo<MemberInfoModel>> memberInfoModelLists =memberInfoApiService.getMemberInfo(memberInfoModel);
            for (int a=1;a<=memberInfoModelLists.getData().getPages();a++){
                ResponseData<PageInfo<MemberInfoModel>> memberInfoModelListss =memberInfoApiService.getMemberInfo(memberInfoModel);
                List<MemberInfoModel> memberInfoModelList = memberInfoModelListss.getData().getList();
                activityBirthdayService.birthdayReward(activityBirthday,memberInfoModelList);
            }


        }
    }
}
