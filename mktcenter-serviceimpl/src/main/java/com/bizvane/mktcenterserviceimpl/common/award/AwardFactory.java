package com.bizvane.mktcenterserviceimpl.common.award;

import com.bizvane.couponfacade.interfaces.SendCouponServiceFeign;
import com.bizvane.couponfacade.models.vo.SendCouponSimpleRequestVO;
import com.bizvane.members.facade.enums.IntegralChangeTypeEnum;
import com.bizvane.members.facade.exception.MemberException;
import com.bizvane.members.facade.models.IntegralRecordModel;
import com.bizvane.members.facade.service.api.IntegralRecordApiService;
import com.bizvane.messagefacade.interfaces.SendCommonMessageFeign;
import com.bizvane.messagefacade.models.vo.SysSmsConfigVO;
import com.bizvane.mktcenterservice.models.bo.AwardBO;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterserviceimpl.common.constants.ResponseConstants;
import com.bizvane.utils.responseinfo.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    /**
     * 奖励券，单
     * @param bo
     * @return
     */
    public ResponseData<Integer> awardCouponSimple(AwardBO bo){
        ResponseData responseData = new ResponseData();
        try {
            SendCouponSimpleRequestVO va = new SendCouponSimpleRequestVO();
            va.setMemberCode(bo.getMemberCode());
            va.setCouponDefinitionId(bo.getCouponDefinitionId());
            va.setSendBussienId(bo.getSendBussienId());
            va.setSendType("10");
            sendCouponServiceFeign.simple(va);
        } catch (Exception e) {
            log.error("com.bizvane.mktcenterserviceimpl.common.award.AwardFactory.awardCouponSimple error"+ e.getMessage());
            responseData.setCode(ResponseConstants.ERROR);
            return responseData;
        }
        return responseData;
    }

    /**
     * 奖励券，批
     * @param bo
     * @return
     */
    public ResponseData<Integer> awardCouponBatch(AwardBO bo){
        ResponseData responseData = new ResponseData();
        try {
            SendCouponSimpleRequestVO va = new SendCouponSimpleRequestVO();
            va.setMemberCode(bo.getMemberCode());
            va.setCouponDefinitionId(bo.getCouponDefinitionId());
            va.setSendBussienId(bo.getSendBussienId());
            va.setSendType("10");
            sendCouponServiceFeign.simple(va);
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
    public ResponseData<Integer> awardIntegral(AwardBO bo){
        ResponseData responseData = new ResponseData();
        try {
            //增加积分奖励新增接口
            IntegralRecordModel var1 = new IntegralRecordModel();
            var1.setMemberCode(bo.getMemberCode());
            var1.setChangeBills(bo.getChangeBills());
            var1.setChangeIntegral(bo.getChangeIntegral());
            var1.setChangeWay(IntegralChangeTypeEnum.INCOME.getCode());
            integralRecordApiService.updateMemberIntegral(var1);
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
    public ResponseData<Integer> sendSms(AwardBO bo){

        SysSmsConfigVO msgvo = new SysSmsConfigVO();
        msgvo.setChannelName("moments3.4");
        msgvo.setChannelAccount("JJ0253");//账号
        msgvo.setChannelPassword("513678");//密码
        msgvo.setChannelService("http://TSN19.800CT.COM:8901/MWGate/wmgw.asmx/MongateSendSubmit");//路径
        msgvo.setPhone(bo.getPhone());//手机
        msgvo.setMsgContent("任务活动发短信!");//内容
      return sendCommonMessageFeign.sendSmg(msgvo);

    }


    /**
     * 发送模板消息
     * @param bo
     * @return
     */
    public ResponseData<Integer> sendWxTemplateMessage(AwardBO bo){
        ResponseData responseData = new ResponseData();
        return responseData;
    }

}
