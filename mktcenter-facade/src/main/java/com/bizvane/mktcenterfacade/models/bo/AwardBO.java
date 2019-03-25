package com.bizvane.mktcenterfacade.models.bo;

import com.bizvane.couponfacade.models.vo.SendCouponBatchRequestVO;
import com.bizvane.couponfacade.models.vo.SendCouponSimpleRequestVO;
import com.bizvane.members.facade.service.card.request.IntegralChangeRequestModel;
import com.bizvane.messagefacade.models.vo.*;

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
    /**
     * 批量短信
     */
    private GenrealSendMessageVO genrealSendMessageVO;
    /**
     * 查询短信数量
     */
    private GenrealGetMessageVO  genrealGetMessageVO;
    /**
     * 发送微信短信消息模板类
     */
    private ActivityMessageVO activityMessageVO;

    public ActivityMessageVO getActivityMessageVO() {
        return activityMessageVO;
    }

    public void setActivityMessageVO(ActivityMessageVO activityMessageVO) {
        this.activityMessageVO = activityMessageVO;
    }

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

    public GenrealSendMessageVO getGenrealSendMessageVO() {
        return genrealSendMessageVO;
    }

    public void setGenrealSendMessageVO(GenrealSendMessageVO genrealSendMessageVO) {
        this.genrealSendMessageVO = genrealSendMessageVO;
    }

    public GenrealGetMessageVO getGenrealGetMessageVO() {
        return genrealGetMessageVO;
    }

    public void setGenrealGetMessageVO(GenrealGetMessageVO genrealGetMessageVO) {
        this.genrealGetMessageVO = genrealGetMessageVO;
    }

}
