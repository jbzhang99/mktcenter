package com.bizvane.mktcenterserviceimpl.common.award;

import com.alibaba.fastjson.JSON;
import com.bizvane.centerstageservice.models.po.SysBrandPo;
import com.bizvane.centerstageservice.rpc.BrandServiceRpc;
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
import com.bizvane.messagefacade.models.vo.ActivityMessageVO;
import com.bizvane.messagefacade.models.vo.MemberMessageVO;
import com.bizvane.messagefacade.models.vo.SysSmsConfigVO;
import com.bizvane.mktcenterservice.interfaces.ActivityBirthdayService;
import com.bizvane.mktcenterservice.interfaces.ActivityService;
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
    @Autowired
    private ActivityService activityService;
    @Autowired
    private BrandServiceRpc brandServiceRpc;
    /**
     * 查询会员信息发送你个短信和微信消息
     * @param messageVOList
     * @param membersInfoSearchVo
     */
    @Async("asyncServiceExecutor")
    public void getMemberList(List<MktMessagePO> messageVOList, MembersInfoSearchVo membersInfoSearchVo,ActivityVO activityVO) {
        log.info("进来这里了==============");
        ResponseData<PageInfo<MemberInfoVo>> memberInfoVoPage = membersAdvancedSearchApiService.search(membersInfoSearchVo);
        //循环分页条件查询会员信息发送短信信息
        for (int a =1;a<=memberInfoVoPage.getData().getPages();a++){
            membersInfoSearchVo.setPageNumber(a);
            ResponseData<com.bizvane.utils.responseinfo.PageInfo<MemberInfoVo>> memberInfoVoPages = membersAdvancedSearchApiService.search(membersInfoSearchVo);
            List<MemberInfoVo> memberInfoModelList = memberInfoVoPages.getData().getList();
            //循环发送
            log.info("开始循环发送++++++++++++++++++++++");
            if (!CollectionUtils.isEmpty(memberInfoModelList)){
                for (MemberInfoModel memberInfo:memberInfoModelList) {
                    activityService.sendMessage(messageVOList, memberInfo,activityVO);

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
        log.info("已经查询到相应的会员一共多少页++++++++++="+memberInfoVoPage.getData().getPages());
        for (int a =1;a<=memberInfoVoPage.getData().getPages();a++) {
            membersInfoSearchVo.setPageNumber(a);
            ResponseData<com.bizvane.utils.responseinfo.PageInfo<MemberInfoVo>> memberInfoVoPages = membersAdvancedSearchApiService.search(membersInfoSearchVo);
            List<MemberInfoVo> memberInfoModelList = memberInfoVoPages.getData().getList();
            for (MemberInfoModel memberInfo:memberInfoModelList) {
                AwardBO awardBO = new AwardBO();
                log.info("调用高级搜索的参数列表查询完毕==================一共++++"+memberInfoModelList.size());
                activityService.sendPoints(vo, awardBO, memberInfo);
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
        for (int a =1;a<=memberInfoVoPage.getData().getPages();a++) {
            membersInfoSearchVo.setPageNumber(a);
            ResponseData<com.bizvane.utils.responseinfo.PageInfo<MemberInfoVo>> memberInfoVoPages = membersAdvancedSearchApiService.search(membersInfoSearchVo);
            List<MemberInfoVo> memberInfoModelList = memberInfoVoPages.getData().getList();
            for (MemberInfoModel memberInfo:memberInfoModelList) {
                SysSmsConfigVO sysSmsConfigVO = new SysSmsConfigVO();
                AwardBO awardBO = new AwardBO();
                activityService.sendShort(mktMessagePO, awardBO, sysSmsConfigVO, memberInfo);
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
        for (int a =1;a<=memberInfoVoPage.getData().getPages();a++) {
            membersInfoSearchVo.setPageNumber(a);
            ResponseData<com.bizvane.utils.responseinfo.PageInfo<MemberInfoVo>> memberInfoVoPages = membersAdvancedSearchApiService.search(membersInfoSearchVo);
            List<MemberInfoVo> memberInfoModelList = memberInfoVoPages.getData().getList();
            for (MemberInfoModel memberInfo:memberInfoModelList) {
                MemberMessageVO memberMessageVO = new MemberMessageVO();
                AwardBO awardBO = new AwardBO();
                activityService.sendWx(mktMessagePO, awardBO, memberMessageVO, memberInfo);
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
        log.info("马上开始发券了激动吗嘛嘛嘛嘛嘛嘛嘛嘛嘛啊啊啊啊啊啊啊");
        ResponseData<com.bizvane.utils.responseinfo.PageInfo<MemberInfoVo>> memberInfoVoPage = membersAdvancedSearchApiService.search(membersInfoSearchVo);
        for (int a = 1; a <= memberInfoVoPage.getData().getPages(); a++) {
            membersInfoSearchVo.setPageNumber(a);
            ResponseData<com.bizvane.utils.responseinfo.PageInfo<MemberInfoVo>> memberInfoVoPages = membersAdvancedSearchApiService.search(membersInfoSearchVo);
            List<MemberInfoVo> memberInfoModelList = memberInfoVoPages.getData().getList();
            for (MemberInfoModel memberInfo : memberInfoModelList) {
                SendCouponSimpleRequestVO sendCouponSimpleRequestVO = new SendCouponSimpleRequestVO();
                AwardBO awardBO = new AwardBO();
                activityService.sendCoupon(vo, awardBO, sendCouponSimpleRequestVO, memberInfo);
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
            memberInfoModel.setSysCompanyId(activityBirthday.getSysCompanyId());
            memberInfoModel.setLevelId(Long.valueOf(activityBirthday.getMbrLevelCode()));
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
                log.info("已经查询到相应的会员总数量是++++++++++="+memberInfoModelListss.getData().getTotal());
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
            memberInfoModel.setSysCompanyId(activityAniversary.getSysCompanyId());
            memberInfoModel.setBrandId(activityAniversary.getSysBrandId());
            memberInfoModel.setLevelId(Long.valueOf(activityAniversary.getMbrLevelCode()));
            memberInfoModel.setOpenCardTimeLine(activityAniversary.getDaysAhead());
            memberInfoModel.setMemberScope(activityAniversary.getMemberType().toString());
            memberInfoModel.setPageNumber(1);
            memberInfoModel.setPageSize(10000);
            ResponseData<PageInfo<MemberInfoModel>> memberInfoModelLists =memberInfoApiService.getMemberInfo(memberInfoModel);
            for (int a=1;a<=memberInfoModelLists.getData().getPages();a++){
                memberInfoModel.setPageNumber(a);
                log.info("开始查询相应的会员参数++++++++++=+=============+"+ JSON.toJSONString(memberInfoModel));
                ResponseData<PageInfo<MemberInfoModel>> memberInfoModelListss =memberInfoApiService.getMemberInfo(memberInfoModel);
                List<MemberInfoModel> memberInfoModelList = memberInfoModelListss.getData().getList();
                log.info("已经查询到相应的会员总数量是++++++++++="+memberInfoModelListss.getData().getTotal());
                for (MemberInfoModel memberInfo:memberInfoModelList) {
                    activityVipAniversaryService.AniversaryReward(activityAniversary, memberInfo);
                }
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
        ResponseData<SysBrandPo> SysBrandPos = brandServiceRpc.getBrandByID(mktActivityPOWithBLOBs.getSysBrandId());
        ResponseData<PageInfo<MemberInfoVo>> memberInfoVoPage = membersAdvancedSearchApiService.search(membersInfoSearchVo);
        for (int a =1;a<=memberInfoVoPage.getData().getPages();a++){
            membersInfoSearchVo.setPageNumber(a);
            ResponseData<PageInfo<MemberInfoVo>> memberInfoVoPages = membersAdvancedSearchApiService.search(membersInfoSearchVo);
            List<MemberInfoVo> memberInfoModelList = memberInfoVoPages.getData().getList();
            log.info("start deal with award");
            MktSmartTypeEnum mktSmartTypeEnum = MktSmartTypeEnum.getMktSmartTypeEnumByCode(mktSmartType);
            switch (mktSmartTypeEnum){
                case SMART_TYPE_COUPON_BATCH:
                    log.info("match with SMART_TYPE_COUPON_BATCH");
                    MktCouponPOExample mktCouponPOExample = new MktCouponPOExample();
                    mktCouponPOExample.createCriteria().andValidEqualTo(Boolean.TRUE).andBizTypeEqualTo(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode()).andBizIdEqualTo(mktActivityPOWithBLOBs.getMktActivityId());
                    List<MktCouponPO> mktCouponPOS = mktCouponPOMapper.selectByExample(mktCouponPOExample);
                    //coupon loop
                    for(MktCouponPO mktCouponPO : mktCouponPOS){
                        AwardBO awardBO = new AwardBO();
                        SendCouponBatchRequestVO sendCouponBatchRequestVO = new SendCouponBatchRequestVO();
                        sendCouponBatchRequestVO.setMemberList(memberInfoVoPages.getData().getList());
                        sendCouponBatchRequestVO.setCouponDefinitionId(mktCouponPO.getCouponDefinitionId());
                        sendCouponBatchRequestVO.setBusinessId(mktActivityPOWithBLOBs.getMktActivityId());
                        if (null!=mktActivityPOWithBLOBs.getMktActivitySmartGroupId()){
                            sendCouponBatchRequestVO.setBusinessType(SendTypeEnum.SEND_COUPON_ORIENT_MARKET.getCode());
                        }else {
                            sendCouponBatchRequestVO.setBusinessType(SendTypeEnum.SEND_COUPON_MEMBER_GROUP.getCode());
                        }
                        awardBO.setMktType(MktSmartTypeEnum.SMART_TYPE_COUPON_BATCH.getCode());
                        awardBO.setSendCouponBatchRequestVO(sendCouponBatchRequestVO);
                        log.info("智能营销-开始批量发券发券");
                        award.execute(awardBO);
                    }
                    break;
                case SMART_TYPE_INTEGRAL:
                    log.info("match with SMART_TYPE_INTEGRAL");
                    for(MemberInfoModel memberInfoModel : memberInfoModelList){
                        AwardBO awardBO = new AwardBO();
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
                        log.info("智能营销-开始发积分积分了");
                        award.execute(awardBO);
                    }
                    break;
                case SMART_TYPE_SMS:
                    log.info("match with SMART_TYPE_SMS");
                    //get activity message object
                    MktMessagePOExample mktMessagePOExample = new MktMessagePOExample();
                    mktMessagePOExample.createCriteria().andValidEqualTo(Boolean.TRUE).andBizTypeEqualTo(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode()).andBizIdEqualTo(mktActivityPOWithBLOBs.getMktActivityId());
                    List<MktMessagePO> mktMessagePOS = mktMessagePOMapper.selectByExampleWithBLOBs(mktMessagePOExample);
                    MktMessagePO mktMessagePO = mktMessagePOS.get(0);
                    //member loop
                    for(MemberInfoModel memberInfoModel : memberInfoModelList){
                        AwardBO awardBO = new AwardBO();
                        ActivityMessageVO activityMessageVO = new ActivityMessageVO();
                        activityMessageVO.setMemberPhone(memberInfoModel.getPhone());
                        activityMessageVO.setSysBrandId(memberInfoModel.getBrandId());
                        activityMessageVO.setMemberName(memberInfoModel.getName());
                        activityMessageVO.setSendWxmember(mktMessagePO.getMsgContent());
                        awardBO.setMktType(MktSmartTypeEnum.SMART_TYPE_SMS.getCode());
                        awardBO.setActivityMessageVO(activityMessageVO);
                        log.info("智能营销-开始发短信短信了");
                        award.execute(awardBO);
                    }
                    break;
                case SMART_TYPE_WXMESSAGE:
                    log.info("match with SMART_TYPE_WXMESSAGE");
                    //get activity message object
                    MktMessagePOExample mktMessagePOExample1 = new MktMessagePOExample();
                    mktMessagePOExample1.createCriteria().andValidEqualTo(Boolean.TRUE).andBizTypeEqualTo(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode()).andBizIdEqualTo(mktActivityPOWithBLOBs.getMktActivityId());
                    List<MktMessagePO> mktMessagePOS1 = mktMessagePOMapper.selectByExampleWithBLOBs(mktMessagePOExample1);
                    MktMessagePO mktMessage = mktMessagePOS1.get(0);
                    //member loop
                    for(MemberInfoModel memberInfoModel : memberInfoModelList){
                        AwardBO awardBO = new AwardBO();
                        ActivityMessageVO activityMessageVO = new ActivityMessageVO();
                        activityMessageVO.setMemberCode(memberInfoModel.getMemberCode());
                        activityMessageVO.setSysCompanyId(mktActivityPOWithBLOBs.getSysCompanyId());
                        activityMessageVO.setSysBrandId(mktActivityPOWithBLOBs.getSysBrandId());
                        activityMessageVO.setSysBrandName(SysBrandPos.getData().getBrandName());
                        activityMessageVO.setActivityName(mktActivityPOWithBLOBs.getActivityName());
                        activityMessageVO.setActivityInterests(mktMessage.getMsgContent());
                        activityMessageVO.setMemberPhone(memberInfoModel.getPhone());
                        activityMessageVO.setActivityLongtime("智能营销");
                        awardBO.setMktType(MktSmartTypeEnum.SMART_TYPE_WXMESSAGE.getCode());
                        awardBO.setActivityMessageVO(activityMessageVO);
                        log.info("智能营销-开始发微信微信了");
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
    public void sendWXmessage(List<MktMessagePO> messageVOList, WxChannelInfoSearchVo wxChannelInfoSearchVo,ActivityVO activityVO) {
        ResponseData<com.bizvane.utils.responseinfo.PageInfo<WxChannelInfoVo>> wxChannelInfoVos =  wxChannelInfoAdvancedSearchApiServic.queryAdvancedChannelInfoList(wxChannelInfoSearchVo);
        //查询到页数循环
        for (int a = 1;a<=wxChannelInfoVos.getData().getPages();a++){
            wxChannelInfoSearchVo.setPageNum(a);
            ResponseData<com.bizvane.utils.responseinfo.PageInfo<WxChannelInfoVo>> wxChannelInfoVolist =  wxChannelInfoAdvancedSearchApiServic.queryAdvancedChannelInfoList(wxChannelInfoSearchVo);
            List<WxChannelInfoVo>  wxChannelInfoVoAll = wxChannelInfoVolist.getData().getList();
            //循环发送
            if (!CollectionUtils.isEmpty(wxChannelInfoVoAll)){
                for (WxChannelInfoVo wxChannelInfoVo:wxChannelInfoVoAll) {
                    activityService.sendRegisterWx(messageVOList, wxChannelInfoVo,activityVO);
                }
            }
        }
    }


    @Async("asyncServiceExecutor")
    public void sendDXmessage(List<MktMessagePO> messageVOList, MembersInfoSearchVo membersInfoSearchVo) {
        log.info("查询会员条件是==========="+ JSON.toJSONString(membersInfoSearchVo));
        ResponseData<PageInfo<MemberInfoVo>> memberInfoVoPage = membersAdvancedSearchApiService.search(membersInfoSearchVo);
        log.info("查询到会员是++++++++++"+ JSON.toJSONString(memberInfoVoPage));
        //循环分页条件查询会员信息发送短信信息
        for (int a =1;a<=memberInfoVoPage.getData().getPages();a++){
            membersInfoSearchVo.setPageNumber(a);
            ResponseData<com.bizvane.utils.responseinfo.PageInfo<MemberInfoVo>> memberInfoVoPages = membersAdvancedSearchApiService.search(membersInfoSearchVo);
            log.info("查询到需要发短信会员是···········"+ JSON.toJSONString(memberInfoVoPages));
            List<MemberInfoVo> memberInfoModelList = memberInfoVoPages.getData().getList();
            log.info("开始循环发送短信");
            //循环发送
            if (!CollectionUtils.isEmpty(memberInfoModelList)){
                for (MemberInfoModel memberInfo:memberInfoModelList) {
                    log.info("循环信息类然后发送短信+");
                    //循环信息类然后发送
                    activityService.sendDx(messageVOList, memberInfo);
                }
            }
        }
    }

}
