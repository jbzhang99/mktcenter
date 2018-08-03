package com.bizvane.mktcenterserviceimpl.common.award;

import com.bizvane.couponfacade.interfaces.SendCouponServiceFeign;
import com.bizvane.couponfacade.models.vo.SendCouponSimpleRequestVO;
import com.bizvane.members.facade.enums.IntegralChangeTypeEnum;
import com.bizvane.members.facade.models.IntegralRecordModel;
import com.bizvane.members.facade.service.api.IntegralRecordApiService;
import com.bizvane.mktcenterservice.models.bo.AwardBO;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chen.li
 * @date on 2018/8/3 14:39
 * @description 营销奖励工具：1发券、2发积分、3短信、4模板消息
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@Component
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


    /**
     * 奖励券，单
     * @param bo
     * @return
     */
    public ResponseData<Integer> awardCouponSimple(AwardBO bo){
        ResponseData responseData = new ResponseData();
        SendCouponSimpleRequestVO va = new SendCouponSimpleRequestVO();
        va.setMemberCode(bo.getMemberCode());
        va.setCouponDefinitionId(bo.getCouponDefinitionId());
        va.setSendBussienId(bo.getSendBussienId());
        va.setSendType("10");
        sendCouponServiceFeign.simple(va);
        return responseData;
    }

    /**
     * 奖励券，批
     * @param bo
     * @return
     */
    public ResponseData<Integer> awardCouponBatch(AwardBO bo){
        ResponseData responseData = new ResponseData();
        SendCouponSimpleRequestVO va = new SendCouponSimpleRequestVO();
        va.setMemberCode(bo.getMemberCode());
        va.setCouponDefinitionId(bo.getCouponDefinitionId());
        va.setSendBussienId(bo.getSendBussienId());
        va.setSendType("10");
        sendCouponServiceFeign.simple(va);
        return responseData;
    }

    /**
     * 奖励积分
     * @param bo
     * @return
     */
    public ResponseData<Integer> awardIntegral(AwardBO bo){
        ResponseData responseData = new ResponseData();
        //增加积分奖励新增接口
        IntegralRecordModel var1 = new IntegralRecordModel();
        var1.setMemberCode(bo.getMemberCode());
        var1.setChangeBills(bo.getChangeBills());
        var1.setChangeIntegral(bo.getChangeIntegral());
        var1.setChangeWay(IntegralChangeTypeEnum.INCOME.getCode());
        integralRecordApiService.updateMemberIntegral(var1);
        return responseData;
    }


    /**
     * 发送短信
     * @param bo
     * @return
     */
    public ResponseData<Integer> sendSms(AwardBO bo){
        ResponseData responseData = new ResponseData();
        return responseData;
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
