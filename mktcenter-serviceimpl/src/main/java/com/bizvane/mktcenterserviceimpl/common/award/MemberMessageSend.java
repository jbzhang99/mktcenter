package com.bizvane.mktcenterserviceimpl.common.award;

import com.alibaba.fastjson.JSON;
import com.bizvane.couponfacade.enums.SendTypeEnum;
import com.bizvane.couponfacade.models.vo.SendCouponBatchRequestVO;
import com.bizvane.couponfacade.models.vo.SendCouponSimpleRequestVO;
import com.bizvane.members.facade.enums.IntegralChangeTypeEnum;
import com.bizvane.members.facade.es.pojo.MembersInfoSearchPojo;
import com.bizvane.members.facade.es.vo.MembersInfoSearchVo;
import com.bizvane.members.facade.es.vo.WxChannelInfoSearchVo;
import com.bizvane.members.facade.models.IntegralRecordModel;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.service.api.MemberInfoApiService;
import com.bizvane.members.facade.service.api.MembersAdvancedSearchApiService;
import com.bizvane.members.facade.service.api.WxChannelInfoAdvancedSearchApiService;
import com.bizvane.members.facade.service.card.request.IntegralChangeRequestModel;
import com.bizvane.members.facade.vo.MemberInfoApiModel;
import com.bizvane.members.facade.vo.MemberInfoVo;
import com.bizvane.members.facade.vo.PageVo;
import com.bizvane.members.facade.vo.WxChannelInfoVo;
import com.bizvane.messagefacade.models.vo.MemberMessageVO;
import com.bizvane.messagefacade.models.vo.SysSmsConfigVO;
import com.bizvane.mktcenterservice.interfaces.ActivityBirthdayService;
import com.bizvane.mktcenterservice.interfaces.ActivityVipAniversaryService;
import com.bizvane.mktcenterservice.models.bo.AwardBO;
import com.bizvane.mktcenterservice.models.po.*;
import com.bizvane.mktcenterservice.models.vo.ActivitySmartVO;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterserviceimpl.common.enums.BusinessTypeEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.CouponSendTypeEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.MktSmartTypeEnum;
import com.bizvane.mktcenterserviceimpl.mappers.MktCouponPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktMessagePOMapper;
import com.bizvane.utils.responseinfo.PageInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * 查询会员发送消息
 * Created by agan on 2018/8/24.
 */
@Component
@Slf4j
public class MemberMessageSend {
    @Autowired
    private Award award;
    @Autowired
    private MemberInfoApiService memberInfoApiService;
    @Autowired
    private ActivityBirthdayService activityBirthdayService;

    @Autowired
    private ActivityVipAniversaryService activityVipAniversaryService;

    @Autowired
    private MktCouponPOMapper mktCouponPOMapper;

    @Autowired
    private MktMessagePOMapper mktMessagePOMapper;

    @Autowired
    private WxChannelInfoAdvancedSearchApiService wxChannelInfoAdvancedSearchApiServic;
    @Autowired
    private MembersAdvancedSearchApiService membersAdvancedSearchApiService;
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
        log.info("已经查询到相应的会员一共多少页++++++++++="+memberInfoVoPage.getData().getPages());
        for (int a =1;a<=memberInfoVoPage.getData().getPages();a++) {
            membersInfoSearchVo.setPageNumber(a);
            ResponseData<com.bizvane.utils.responseinfo.PageInfo<MemberInfoVo>> memberInfoVoPages = membersAdvancedSearchApiService.search(membersInfoSearchVo);
            List<MemberInfoVo> memberInfoModelList = memberInfoVoPages.getData().getList();
            for (MemberInfoModel memberInfo:memberInfoModelList) {
                IntegralChangeRequestModel integralChangeRequestModel =new IntegralChangeRequestModel();
                integralChangeRequestModel.setSysCompanyId(vo.getSysCompanyId());
                integralChangeRequestModel.setBrandId(vo.getSysBrandId());
                integralChangeRequestModel.setMemberCode(memberInfo.getMemberCode());
                integralChangeRequestModel.setChangeBills(vo.getActivityCode());
                integralChangeRequestModel.setChangeIntegral(vo.getPoints());
                integralChangeRequestModel.setChangeType(IntegralChangeTypeEnum.INCOME.getCode());
                integralChangeRequestModel.setBusinessType(com.bizvane.members.facade.enums.BusinessTypeEnum.ACTIVITY_TYPE_SMART.getCode());
                awardBO.setIntegralRecordModel(integralChangeRequestModel);
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
                        sendCouponSimpleRequestVO.setSendType(SendTypeEnum.SEND_COUPON_ORIENT_MARKET.getCode());
                        sendCouponSimpleRequestVO.setBrandId(vo.getSysBrandId());
                        sendCouponSimpleRequestVO.setCompanyId(vo.getSysCompanyId());
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
        log.info("开始执行发送生日活动");
        for (ActivityVO activityBirthday:activityBirthdayList) {
            //根据品牌id 会员等级 会员范围  时间周期 查询会员信息 循环
            //查询对应的会员
            MemberInfoApiModel memberInfoModel= new MemberInfoApiModel();
            memberInfoModel.setBrandId(activityBirthday.getSysBrandId());
            if (!activityBirthday.getMbrLevelCode().equals(0)){
                memberInfoModel.setLevelId(Long.parseLong(activityBirthday.getMbrLevelCode()));
            }
            memberInfoModel.setBirthdayLine(activityBirthday.getDaysAhead());
            memberInfoModel.setMemberScope(activityBirthday.getMemberType().toString());
            memberInfoModel.setPageNumber(1);
            memberInfoModel.setPageSize(10000);
            ResponseData<PageInfo<MemberInfoModel>> memberInfoModelLists =memberInfoApiService.getMemberInfo(memberInfoModel);
            //循环页数
            for (int a=1;a<=memberInfoModelLists.getData().getPages();a++){
                memberInfoModel.setPageNumber(a);
                log.info("开始查询相应的会员参数++++++++++=+=============+"+ JSON.toJSONString(memberInfoModel));
                ResponseData<PageInfo<MemberInfoModel>> memberInfoModelListss =memberInfoApiService.getMemberInfo(memberInfoModel);
                List<MemberInfoModel> memberInfoModelList = memberInfoModelListss.getData().getList();
                log.info("已经查询到相应的会员++++++++++=");
                //循环每一页的人数
                for (MemberInfoModel memberInfo:memberInfoModelList) {
                    activityBirthdayService.birthdayReward(activityBirthday, memberInfo);
                }
            }


        }
    }

    /**
     * 纪念日活动发送奖励券
     * @param activityAniversaryList
     */
    @Async("asyncServiceExecutor")
    public void sendAniversaryCoupon(List<ActivityVO> activityAniversaryList) {
        for (ActivityVO activityAniversary:activityAniversaryList) {
            //根据品牌id 会员等级 会员范围  时间周期 查询会员信息 循环
            //查询对应的会员
            MemberInfoApiModel memberInfoModel= new MemberInfoApiModel();
            memberInfoModel.setBrandId(activityAniversary.getSysBrandId());
            if (!activityAniversary.getMbrLevelCode().equals("0")){
                memberInfoModel.setLevelId(Long.parseLong(activityAniversary.getMbrLevelCode()));
            }
            memberInfoModel.setBirthdayLine(activityAniversary.getDaysAhead());
            memberInfoModel.setMemberScope(activityAniversary.getMemberType().toString());
            memberInfoModel.setPageNumber(1);
            memberInfoModel.setPageSize(10000);
            ResponseData<PageInfo<MemberInfoModel>> memberInfoModelLists =memberInfoApiService.getMemberInfo(memberInfoModel);
            for (int a=1;a<=memberInfoModelLists.getData().getPages();a++){
                ResponseData<PageInfo<MemberInfoModel>> memberInfoModelListss =memberInfoApiService.getMemberInfo(memberInfoModel);
                List<MemberInfoModel> memberInfoModelList = memberInfoModelListss.getData().getList();
                activityVipAniversaryService.AniversaryReward(activityAniversary,memberInfoModelList);
            }
        }
    }

    /**
     *
     * 智能营销发送奖励
     * @param mktSmartType
     * @param mktActivityPOWithBLOBs
     * @param membersInfoSearchVo
     */
    @Async("asyncServiceExecutor")
    public void sendSmart(Integer mktSmartType, MktActivityPOWithBLOBs mktActivityPOWithBLOBs, MembersInfoSearchVo membersInfoSearchVo) {
        ResponseData<PageInfo<MemberInfoVo>> memberInfoVoPage = membersAdvancedSearchApiService.search(membersInfoSearchVo);
        //ResponseData<PageInfo<MembersInfoSearchPojo>> memberInfoVoPage =membersAdvancedSearchApiService.advancedSearch(membersInfoSearchVo);
        for (int a =0;a<memberInfoVoPage.getData().getPages();a++){
            membersInfoSearchVo.setPageNumber(a);
            ResponseData<PageInfo<MemberInfoVo>> memberInfoVoPages = membersAdvancedSearchApiService.search(membersInfoSearchVo);
            //ResponseData<PageInfo<MembersInfoSearchPojo>> memberInfoVoPages =membersAdvancedSearchApiService.advancedSearch(membersInfoSearchVo);
            List<MemberInfoVo> memberInfoModelList = memberInfoVoPages.getData().getList();
            /*if(CollectionUtils.isEmpty(memberInfoModelList)){
                log.error("target member is empty");
                returnT.setMsg("target member is empty");
                return returnT;
            }*/
            log.info("start deal with award");
            AwardBO awardBO = new AwardBO();
            MktSmartTypeEnum mktSmartTypeEnum = MktSmartTypeEnum.getMktSmartTypeEnumByCode(mktSmartType);
            /*if(mktSmartTypeEnum==null){
                log.error("mktSmartTypeEnum is null");
                returnT.setMsg("mktSmartTypeEnum is null");
                return returnT;
            }*/
            switch (mktSmartTypeEnum){
                case SMART_TYPE_COUPON_BATCH:
                    log.info("match with SMART_TYPE_COUPON_BATCH");
                    MktCouponPOExample mktCouponPOExample = new MktCouponPOExample();
                    mktCouponPOExample.createCriteria().andValidEqualTo(Boolean.TRUE).andBizTypeEqualTo(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode()).andBizIdEqualTo(mktActivityPOWithBLOBs.getMktActivityId());
                    List<MktCouponPO> mktCouponPOS = mktCouponPOMapper.selectByExample(mktCouponPOExample);
                    //coupon loop
                    for(MktCouponPO mktCouponPO : mktCouponPOS){
                        SendCouponBatchRequestVO sendCouponBatchRequestVO = new SendCouponBatchRequestVO();
                        //sendCouponBatchRequestVO.setMemberList(memberInfoVoPages.getData().getList());
                        sendCouponBatchRequestVO.setCouponDefinitionId(mktCouponPO.getCouponDefinitionId());
                        awardBO.setMktType(MktSmartTypeEnum.SMART_TYPE_COUPON_BATCH.getCode());
                        awardBO.setSendCouponBatchRequestVO(sendCouponBatchRequestVO);
                        award.execute(awardBO);
                    }
                    break;
                case SMART_TYPE_INTEGRAL:
                    log.info("match with SMART_TYPE_INTEGRAL");
                    //member loop
                    for(MemberInfoModel memberInfoModel : memberInfoModelList){
                        IntegralChangeRequestModel integralChangeRequestModel =new IntegralChangeRequestModel();
                        integralChangeRequestModel.setSysCompanyId(mktActivityPOWithBLOBs.getSysCompanyId());
                        integralChangeRequestModel.setBrandId(mktActivityPOWithBLOBs.getSysBrandId());
                        integralChangeRequestModel.setMemberCode(memberInfoModel.getMemberCode());
                        integralChangeRequestModel.setChangeBills(mktActivityPOWithBLOBs.getActivityCode());
                        integralChangeRequestModel.setChangeIntegral(mktActivityPOWithBLOBs.getPoints());
                        integralChangeRequestModel.setChangeType(IntegralChangeTypeEnum.INCOME.getCode());
                        integralChangeRequestModel.setBusinessType(com.bizvane.members.facade.enums.BusinessTypeEnum.ACTIVITY_TYPE_SMART.getCode());
                        integralChangeRequestModel.setChangeDate(new Date());
                        awardBO.setIntegralRecordModel(integralChangeRequestModel);
                        awardBO.setMktType(MktSmartTypeEnum.SMART_TYPE_INTEGRAL.getCode());
                        award.execute(awardBO);
                    }
                    break;
                case SMART_TYPE_SMS:
                    log.info("match with SMART_TYPE_SMS");
                    //get activity message object
                    MktMessagePOExample mktMessagePOExample = new MktMessagePOExample();
                    mktMessagePOExample.createCriteria().andValidEqualTo(Boolean.TRUE).andBizTypeEqualTo(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode()).andBizIdEqualTo(mktActivityPOWithBLOBs.getMktActivityId());
                    List<MktMessagePO> mktMessagePOS = mktMessagePOMapper.selectByExampleWithBLOBs(mktMessagePOExample);
                   /* if(CollectionUtils.isEmpty(mktMessagePOS)){
                        log.error("mktMessagePOS is empty");
                        returnT.setMsg("mktMessagePOS is empty");
                        return returnT;
                    }*/
                    MktMessagePO mktMessagePO = mktMessagePOS.get(0);
                    //member loop
                    for(MemberInfoModel memberInfoModel : memberInfoModelList){
                        SysSmsConfigVO sysSmsConfigVO = new SysSmsConfigVO();
//                            sysSmsConfigVO.setPhone(memberInfoModel.getPhone());
                        sysSmsConfigVO.setPhone(memberInfoModel.getPhone());
                        sysSmsConfigVO.setMsgContent(mktMessagePO.getMsgContent());
                        awardBO.setMktType(MktSmartTypeEnum.SMART_TYPE_SMS.getCode());
                        awardBO.setSysSmsConfigVO(sysSmsConfigVO);
                        //get sms config
                        award.execute(awardBO);
                    }
                    break;
                case SMART_TYPE_WXMESSAGE:
                    log.info("match with SMART_TYPE_WXMESSAGE");
                    //get activity message object
                    MktMessagePOExample mktMessagePOExample1 = new MktMessagePOExample();
                    mktMessagePOExample1.createCriteria().andValidEqualTo(Boolean.TRUE).andBizTypeEqualTo(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode()).andBizIdEqualTo(mktActivityPOWithBLOBs.getMktActivityId());
                    List<MktMessagePO> mktMessagePOS1 = mktMessagePOMapper.selectByExample(mktMessagePOExample1);
                   /* if(CollectionUtils.isEmpty(mktMessagePOS1)){
                        log.error("mktMessagePOS1 is empty");
                        returnT.setMsg("mktMessagePOS1 is empty");
                        return returnT;
                    }*/
                    //member loop
                    for(MemberInfoModel memberInfoModel : memberInfoModelList){
                        MemberMessageVO memberMessageVO = new MemberMessageVO();
                        memberMessageVO.setMemberCode(memberInfoModel.getMemberCode());
                        memberMessageVO.setOpenId(memberInfoModel.getWxOpenId());
                        awardBO.setMktType(MktSmartTypeEnum.SMART_TYPE_WXMESSAGE.getCode());
                        awardBO.setMemberMessageVO(memberMessageVO);
                        //get WXMESSAGE config
                        award.execute(awardBO);
                    }
                    break;
                default:break;
            }
        }
    }

    /**
     * 开卡活动发送微信消息
     * @param messageVOList
     * @param wxChannelInfoSearchVo
     */
    @Async("asyncServiceExecutor")
    public void sendWXmessage(List<MktMessagePO> messageVOList, WxChannelInfoSearchVo wxChannelInfoSearchVo) {
        ResponseData<com.bizvane.utils.responseinfo.PageInfo<WxChannelInfoVo>> wxChannelInfoVos =  wxChannelInfoAdvancedSearchApiServic.queryAdvancedChannelInfoList(wxChannelInfoSearchVo);
        //查询到页数循环
        for (int a = 1;a<=wxChannelInfoVos.getData().getPages();a++){
            wxChannelInfoSearchVo.setPageNum(a);
            ResponseData<com.bizvane.utils.responseinfo.PageInfo<WxChannelInfoVo>> wxChannelInfoVolist =  wxChannelInfoAdvancedSearchApiServic.queryAdvancedChannelInfoList(wxChannelInfoSearchVo);
            List<WxChannelInfoVo>  wxChannelInfoVoAll = wxChannelInfoVolist.getData().getList();
            //循环发送
            if (!CollectionUtils.isEmpty(wxChannelInfoVoAll)){
                for (WxChannelInfoVo wxChannelInfoVo:wxChannelInfoVoAll) {
                    for (MktMessagePO mktMessagePO:messageVOList) {
                        AwardBO awardBO = new AwardBO();
                        if (mktMessagePO.getMsgType().equals("1") && !StringUtils.isEmpty(wxChannelInfoVo.getWxOpenId())){
                            //发送微信模板消息
                            MemberMessageVO memberMessageVO = new MemberMessageVO();
                            memberMessageVO.setMemberCode(wxChannelInfoVo.getMemberCode());
                            memberMessageVO.setOpenId(wxChannelInfoVo.getWxOpenId());
                            awardBO.setMemberMessageVO(memberMessageVO);
                            awardBO.setMktType(MktSmartTypeEnum.SMART_TYPE_WXMESSAGE.getCode());
                            award.execute(awardBO);
                        }
                    }
                }
            }
        }
    }

    @Async("asyncServiceExecutor")
    public void sendDXmessage(List<MktMessagePO> messageVOList, MembersInfoSearchVo membersInfoSearchVo) {
        ResponseData<PageInfo<MemberInfoVo>> memberInfoVoPage = membersAdvancedSearchApiService.search(membersInfoSearchVo);
        //循环分页条件查询会员信息发送短信信息
        for (int a =1;a<=memberInfoVoPage.getData().getPages();a++){
            membersInfoSearchVo.setPageNumber(a);
            ResponseData<com.bizvane.utils.responseinfo.PageInfo<MemberInfoVo>> memberInfoVoPages = membersAdvancedSearchApiService.search(membersInfoSearchVo);
            List<MemberInfoVo> memberInfoModelList = memberInfoVoPages.getData().getList();
            log.info("开始循环发送短信");
            //循环发送
            if (!CollectionUtils.isEmpty(memberInfoModelList)){
                for (MemberInfoModel memberInfo:memberInfoModelList) {
                    log.info("循环信息类然后发送短信+");
                    //循环信息类然后发送
                    for (MktMessagePO mktMessagePO:messageVOList) {
                        AwardBO awardBO = new AwardBO();
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
}
