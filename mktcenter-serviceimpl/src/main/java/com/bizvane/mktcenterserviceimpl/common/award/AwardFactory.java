package com.bizvane.mktcenterserviceimpl.common.award;

import com.alibaba.fastjson.JSON;
import com.bizvane.centercontrolservice.rpc.SysSmsConfigServiceRpc;
import com.bizvane.couponfacade.interfaces.SendCouponServiceFeign;
import com.bizvane.couponfacade.models.vo.SendCouponBatchRequestVO;
import com.bizvane.couponfacade.models.vo.SendCouponSimpleRequestVO;
import com.bizvane.members.facade.enums.IntegralChangeTypeEnum;
import com.bizvane.members.facade.exception.MemberException;
import com.bizvane.members.facade.models.IntegralRecordModel;
import com.bizvane.members.facade.service.api.IntegralChangeApiService;
import com.bizvane.members.facade.service.api.IntegralRecordApiService;
import com.bizvane.members.facade.service.card.request.IntegralChangeRequestModel;
import com.bizvane.messagefacade.interfaces.SendCommonMessageFeign;
import com.bizvane.messagefacade.interfaces.TemplateMessageServiceFeign;
import com.bizvane.messagefacade.models.vo.*;
import com.bizvane.mktcenterservice.models.bo.AwardBO;
import com.bizvane.mktcenterserviceimpl.common.constants.ResponseConstants;
import com.bizvane.utils.responseinfo.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author chen.li
 * @date on 2018/8/3 14:39
 * @description 营销奖励工具：1发券、2发积分、3短信、4模板消息
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@Component
@Slf4j
public class AwardFactory {

    /**
     * 券rpc接口
     */
    @Autowired
    private SendCouponServiceFeign sendCouponServiceFeign;

    /**
     * 积分调整rpc接口
     */
    @Autowired
    private IntegralRecordApiService integralRecordApiService;

    @Autowired
    private SendCommonMessageFeign sendCommonMessageFeign;

    @Autowired
    private TemplateMessageServiceFeign templateMessageServiceFeign;
    @Autowired
    private IntegralChangeApiService integralChangeApiService;
    /**
     * 奖励券，单
     * @param bo
     * @return
     */
    @Async("asyncServiceExecutor")
    public ResponseData<Integer> awardCouponSimple(AwardBO bo){
        ResponseData responseData = new ResponseData();
        try {
            SendCouponSimpleRequestVO va = bo.getSendCouponSimpleRequestVO();
            log.info("开始执行发券操作参数="+ JSON.toJSONString(va));
            ResponseData<Object> simple = sendCouponServiceFeign.simple(va);
            log.info("发券操作完成完成了完成了完成了完成了");
        } catch (Exception e) {
            log.error("com.bizvane.mktcenterserviceimpl.common.award.AwardFactory.awardCouponSimple error"+ e.getMessage());
            responseData.setCode(ResponseConstants.ERROR);
            return responseData;
        }
        return responseData;
    }

    /**
     * 奖励券，批量
     * @param bo
     * @return
     */
    @Async("asyncServiceExecutor")
    public ResponseData<Integer> awardCouponBatch(AwardBO bo){
        ResponseData responseData = new ResponseData();
        try {
            SendCouponBatchRequestVO sendCouponBatchRequestVO = bo.getSendCouponBatchRequestVO();
            sendCouponBatchRequestVO.setSendType((byte) 1);
            log.info("开始执行批量发券操作参数="+ JSON.toJSONString(sendCouponBatchRequestVO));
            responseData = sendCouponServiceFeign.batchCoupon(sendCouponBatchRequestVO);
            log.info("发券操作完成完成了完成了完成了完成了");
        } catch (Exception e) {
            log.error("com.bizvane.mktcenterserviceimpl.common.award.AwardFactory.awardCouponBatch error:"+e.getMessage());
            responseData.setCode(ResponseConstants.ERROR);
            return responseData;
        }
        return responseData;
    }

    /**
     * 奖励积分
     * @param bo
     * @return
     */
    @Async("asyncServiceExecutor")
    public ResponseData<Integer> awardIntegral(AwardBO bo){
        ResponseData responseData = new ResponseData();
        try {
            //增加积分奖励新增接口
            IntegralChangeRequestModel var1 = bo.getIntegralRecordModel();
            log.info("开始执行新增积分操作参数="+ JSON.toJSONString(var1));
            integralChangeApiService.integralChangeOperate(var1);
            log.info("积分增加操作完成完成了完成了完成了完成了");
        } catch (MemberException e) {
            log.error("com.bizvane.mktcenterserviceimpl.common.award.AwardFactory.awardIntegral error:"+e.getMessage());
            responseData.setCode(ResponseConstants.ERROR);
            return responseData;
        }
        return responseData;
    }


    /**
     * 发送短信
     * @param bo
     * @return
     */
    @Async("asyncServiceExecutor")
    public ResponseData<String> sendSms(AwardBO bo){

        SysSmsConfigVO msgvo = bo.getSysSmsConfigVO();
        ActivityMessageVO activityMessageVO = new ActivityMessageVO();
        activityMessageVO.setSysBrandId(msgvo.getSysBrandId());
        activityMessageVO.setMemberPhone(msgvo.getPhone());
        activityMessageVO.setSendWxmember(msgvo.getMsgContent());
        /*msgvo.setChannelName("moments3.4");//平台
        msgvo.setChannelAccount("JJ0253");//账号
        msgvo.setChannelPassword("513678");//密码
        msgvo.setChannelService("http://TSN19.800CT.COM:8901/MWGate/wmgw.asmx/MongateSendSubmit");//路径*/
        log.info("开始执行发送短信操作参数="+ JSON.toJSONString(activityMessageVO));
      return templateMessageServiceFeign.sendSmsTemplateMessage(activityMessageVO);

    }


    /**
     * 发送模板消息
     * @param bo
     * @return
     */
    @Async("asyncServiceExecutor")
    public ResponseData<String> sendWxTemplateMessage(AwardBO bo){
        ResponseData responseData = new ResponseData();
        MemberMessageVO memberMessageVO = bo.getMemberMessageVO();
        ActivityMessageVO activityMessageVO = new ActivityMessageVO();
        activityMessageVO.setSysBrandId(memberMessageVO.getSysBrandId());
        activityMessageVO.setMemberCode(memberMessageVO.getMemberCode());
        activityMessageVO.setActivityInterests(memberMessageVO.getActivityInterests());
        activityMessageVO.setActivityName(memberMessageVO.getActivityName());
        activityMessageVO.setActivityStartDate(memberMessageVO.getActivityDate());
        log.info("开始执行发送模板消息操作参数="+ JSON.toJSONString(activityMessageVO));
        templateMessageServiceFeign.sendTemplateMessage(activityMessageVO);
        log.info("发送模板消息操作完成完成了完成了完成了完成了");
        return responseData;
    }

    //发送批量短信
    @Async("asyncServiceExecutor")
    public ResponseData<String> sendBantchSms(AwardBO bo){
        GenrealSendMessageVO vo = bo.getGenrealSendMessageVO();
        return templateMessageServiceFeign.sendGenrealBatch(vo);
    }

}
