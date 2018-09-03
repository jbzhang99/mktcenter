package com.bizvane.mktcenterservice.models.bo;

import com.bizvane.couponfacade.models.po.CouponDefinitionPO;
import com.bizvane.couponfacade.models.vo.SendCouponBatchRequestVO;
import com.bizvane.couponfacade.models.vo.SendCouponSimpleRequestVO;
import com.bizvane.members.facade.models.IntegralRecordModel;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.service.card.request.IntegralChangeRequestModel;
import com.bizvane.messagefacade.models.vo.MemberMessageVO;
import com.bizvane.messagefacade.models.vo.SysSmsConfigVO;
import com.bizvane.mktcenterservice.models.vo.MessageVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author chen.li
 * @date on 2018/8/3 15:10
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public class AwardBO {

    /**
     * 业务单id
     */
    private Long businessId;

    /**
     * 业务单编号
     */
    private Long businessCode;

    /**
     * 营销方式 1优惠券营销，2积分营销，3短信营销，4微信模板消息营销
     */
    private Integer mktType;
    /**
     * 单发券
     */
    private SendCouponSimpleRequestVO sendCouponSimpleRequestVO;

    /**
     * 群发券
     */
    private SendCouponBatchRequestVO sendCouponBatchRequestVO;

    /**
     * 积分奖励对象
     */
    private IntegralChangeRequestModel integralRecordModel;

    /**
     * 模板消息对象
     */
    private MemberMessageVO memberMessageVO;

    /**
     * 短信
     */
    private SysSmsConfigVO sysSmsConfigVO;

    public IntegralChangeRequestModel getIntegralRecordModel() {
        return integralRecordModel;
    }

    public void setIntegralRecordModel(IntegralChangeRequestModel integralRecordModel) {
        this.integralRecordModel = integralRecordModel;
    }

    public SendCouponSimpleRequestVO getSendCouponSimpleRequestVO() {
        return sendCouponSimpleRequestVO;
    }

    public void setSendCouponSimpleRequestVO(SendCouponSimpleRequestVO sendCouponSimpleRequestVO) {
        this.sendCouponSimpleRequestVO = sendCouponSimpleRequestVO;
    }

    public SendCouponBatchRequestVO getSendCouponBatchRequestVO() {
        return sendCouponBatchRequestVO;
    }

    public void setSendCouponBatchRequestVO(SendCouponBatchRequestVO sendCouponBatchRequestVO) {
        this.sendCouponBatchRequestVO = sendCouponBatchRequestVO;
    }

    public MemberMessageVO getMemberMessageVO() {
        return memberMessageVO;
    }

    public void setMemberMessageVO(MemberMessageVO memberMessageVO) {
        this.memberMessageVO = memberMessageVO;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public Long getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(Long businessCode) {
        this.businessCode = businessCode;
    }

    public SysSmsConfigVO getSysSmsConfigVO() {
        return sysSmsConfigVO;
    }

    public void setSysSmsConfigVO(SysSmsConfigVO sysSmsConfigVO) {
        this.sysSmsConfigVO = sysSmsConfigVO;
    }

    public Integer getMktType() {
        return mktType;
    }

    public void setMktType(Integer mktType) {
        this.mktType = mktType;
    }
}
