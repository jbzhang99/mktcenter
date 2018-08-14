package com.bizvane.mktcenterserviceimpl.service.jobhandler;

import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.service.api.MemberInfoApiService;
import com.bizvane.mktcenterservice.interfaces.ActivitySmartService;
import com.bizvane.mktcenterservice.models.bo.ActivitySmartBO;
import com.bizvane.mktcenterservice.models.bo.AwardBO;
import com.bizvane.mktcenterservice.models.po.*;
import com.bizvane.mktcenterserviceimpl.common.award.Award;
import com.bizvane.mktcenterserviceimpl.common.constants.ResponseConstants;
import com.bizvane.mktcenterserviceimpl.common.enums.BusinessTypeEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.MktSmartTypeEnum;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivitySmartPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktCouponPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktMessagePOMapper;
import com.bizvane.utils.responseinfo.ResponseData;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author chen.li
 * @date on 2018/8/3 14:05
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@JobHandler(value="smartActivity")
@Component
@Slf4j
public class ActivitySmartJobHandler extends IJobHandler {

    @Autowired
    private ActivitySmartService activitySmartService;

    @Autowired
    private MktActivityPOMapper mktActivityPOMapper;

    @Autowired
    private MktCouponPOMapper mktCouponPOMapper;

    @Autowired
    private MktMessagePOMapper mktMessagePOMapper;

    @Autowired
    private MktActivitySmartPOMapper mktActivitySmartPOMapper;

    @Autowired
    private Award award;

    @Autowired
    private MemberInfoApiService memberInfoApiService;

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        log.info("com.bizvane.mktcenterserviceimpl.service.jobhandler.ActivitySmartJobHandler.execute param:"+param);
        ReturnT returnT = new ReturnT();
        try {
            String[] split = param.split("&");
            if(split.length>1){
                Integer mktSmartType = Integer.valueOf(split[0]);
                String activitiCode = split[1];
                //get main activity object
                MktActivityPOExample mktActivityPOExample = new MktActivityPOExample();
                mktActivityPOExample.createCriteria().andValidEqualTo(Boolean.TRUE).andActivityCodeEqualTo(activitiCode);
                List<MktActivityPOWithBLOBs> mktActivityPOWithBLOBsList = mktActivityPOMapper.selectByExampleWithBLOBs(mktActivityPOExample);
                MktActivityPOWithBLOBs mktActivityPOWithBLOBs = new MktActivityPOWithBLOBs();
                if(CollectionUtils.isNotEmpty(mktActivityPOWithBLOBsList)){
                    mktActivityPOWithBLOBs = mktActivityPOWithBLOBsList.get(0);
                }else{
                    log.error("mktActivityPOWithBLOBsList is empty");
                    returnT.setMsg("mktActivityPOWithBLOBsList is empty");
                    return returnT;
                }
                //get smart activity object
                MktActivitySmartPOExample mktActivitySmartPOExample = new MktActivitySmartPOExample();
                mktActivitySmartPOExample.createCriteria().andValidEqualTo(Boolean.TRUE).andMktActivityIdEqualTo(mktActivityPOWithBLOBs.getMktActivityId());
                List<MktActivitySmartPO> mktActivitySmartPOList = mktActivitySmartPOMapper.selectByExampleWithBLOBs(mktActivitySmartPOExample);
                MktActivitySmartPO mktActivitySmartPO = new MktActivitySmartPO();
                if(CollectionUtils.isNotEmpty(mktActivitySmartPOList)){
                    mktActivitySmartPO = mktActivitySmartPOList.get(0);
                }else{
                    log.error("mktActivitySmartPOList is empty");
                    returnT.setMsg("mktActivitySmartPOList is empty");
                    return returnT;
                }
                String targetMbr = mktActivitySmartPO.getTargetMbr();
                //get member by condition
                ResponseData<List<MemberInfoModel>> memberInfo = memberInfoApiService.getMemberInfo(new MemberInfoModel());
                List<MemberInfoModel> memberInfoModelList = memberInfo.getData();
                if(CollectionUtils.isEmpty(memberInfoModelList)){
                    log.error("target member is empty");
                    returnT.setMsg("target member is empty");
                    return returnT;
                }
                log.info("start deal with award");
                AwardBO awardBO = new AwardBO();
                MktSmartTypeEnum mktSmartTypeEnum = MktSmartTypeEnum.getMktSmartTypeEnumByCode(mktSmartType);
                if(mktSmartTypeEnum==null){
                    log.error("mktSmartTypeEnum is null");
                    returnT.setMsg("mktSmartTypeEnum is null");
                    return returnT;
                }
                switch (mktSmartTypeEnum){
                    case SMART_TYPE_COUPON_BATCH:
                        log.info("match with SMART_TYPE_COUPON_BATCH");
                        MktCouponPOExample mktCouponPOExample = new MktCouponPOExample();
                        mktCouponPOExample.createCriteria().andValidEqualTo(Boolean.TRUE).andBizTypeEqualTo(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode()).andBizIdEqualTo(mktActivityPOWithBLOBs.getMktActivityId());
                        List<MktCouponPO> mktCouponPOS = mktCouponPOMapper.selectByExample(mktCouponPOExample);
                        //coupon loop
                        for(MktCouponPO mktCouponPO : mktCouponPOS){
                            awardBO.setMemberInfoModelList(memberInfo.getData());
                            awardBO.setMktSmartType(MktSmartTypeEnum.SMART_TYPE_COUPON_BATCH.getCode());
                            awardBO.setCouponDefinitionId(mktCouponPO.getCouponDefinitionId());
                            award.execute(awardBO);
                        }
                        break;
                    case SMART_TYPE_INTEGRAL:
                        log.info("match with SMART_TYPE_INTEGRAL");
                        //member loop
                        for(MemberInfoModel memberInfoModel : memberInfoModelList){
                            awardBO.setMemberCode(memberInfoModel.getMemberCode());
                            awardBO.setMktSmartType(MktSmartTypeEnum.SMART_TYPE_INTEGRAL.getCode());
                            awardBO.setChangeIntegral(mktActivityPOWithBLOBs.getPoints());
                            award.execute(awardBO);
                        }
                        break;
                    case SMART_TYPE_SMS:
                        log.info("match with SMART_TYPE_SMS");
                        //get activity message object
                        MktMessagePOExample mktMessagePOExample = new MktMessagePOExample();
                        mktMessagePOExample.createCriteria().andValidEqualTo(Boolean.TRUE).andBizTypeEqualTo(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode()).andBizIdEqualTo(mktActivityPOWithBLOBs.getMktActivityId());
                        List<MktMessagePO> mktMessagePOS = mktMessagePOMapper.selectByExample(mktMessagePOExample);
                        if(CollectionUtils.isEmpty(mktMessagePOS)){
                            log.error("mktMessagePOS is empty");
                            returnT.setMsg("mktMessagePOS is empty");
                            return returnT;
                        }
                        //member loop
                        for(MemberInfoModel memberInfoModel : memberInfoModelList){
                            awardBO.setMemberCode(memberInfoModel.getMemberCode());
                            awardBO.setMktSmartType(MktSmartTypeEnum.SMART_TYPE_SMS.getCode());
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
                        if(CollectionUtils.isEmpty(mktMessagePOS1)){
                            log.error("mktMessagePOS1 is empty");
                            returnT.setMsg("mktMessagePOS1 is empty");
                            return returnT;
                        }
                        //member loop
                        for(MemberInfoModel memberInfoModel : memberInfoModelList){
                            awardBO.setMemberCode(memberInfoModel.getMemberCode());
                            awardBO.setMktSmartType(MktSmartTypeEnum.SMART_TYPE_WXMESSAGE.getCode());
                            //get WXMESSAGE config
                            award.execute(awardBO);
                        }
                        break;
                        default:break;
                }
                ResponseData<T> execute = activitySmartService.execute(new ActivitySmartBO());
                returnT.setCode(ResponseConstants.SUCCESS);
                returnT.setContent(ResponseConstants.SUCCESS_MSG);
                returnT.setMsg(ResponseConstants.SUCCESS_MSG);
            }else{
                returnT.setCode(ResponseConstants.ERROR);
                returnT.setContent(ResponseConstants.ERROR_MSG);
                returnT.setMsg(ResponseConstants.ERROR_MSG);
            }
        } catch (Exception e) {
            log.error("com.bizvane.mktcenterserviceimpl.service.jobhandler.ActivitySmartJobHandler.execute error"+e.getMessage());
        }
        return returnT;
    }
}
