package com.bizvane.messagefacade.models.po;

import java.io.Serializable;
import java.util.Date;

public class MsgSmsTempPO implements Serializable {
    /**
     * 只读.
    主键自增. msg_sms_temp_id
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    @io.swagger.annotations.ApiModelProperty(value = "主键自增",name = "msgSmsTempId", required = false,example = "")
    private Long msgSmsTempId;

    /**
     * 只读.
    所属企业id. sys_company_id
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    @io.swagger.annotations.ApiModelProperty(value = "所属企业id",name = "sysCompanyId", required = false,example = "")
    private Long sysCompanyId;

    /**
     * 只读.
    所属品牌id. sys_brand_id
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    @io.swagger.annotations.ApiModelProperty(value = "所属品牌id",name = "sysBrandId", required = false,example = "")
    private Long sysBrandId;

    /**
     * 只读.
    业务类型(COUPON-券，INTEGRAL-积分，MEMBER-会员，ORDER-订单). business_type
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    @io.swagger.annotations.ApiModelProperty(value = "业务类型(COUPON-券，INTEGRAL-积分，MEMBER-会员，ORDER-订单)",name = "businessType", required = false,example = "")
    private String businessType;

    /**
     * 只读.
    短信模板类型(COUPON_RECEIVE-券到账提醒，COUPON_UNRECEIVED-券未领取提醒，COUPON_EXPIRE-券到期提醒，INTEGRAL_ADD-积分增加提醒，INTEGRAL_SUBTRACT-积分减少提醒，INTEGRAL_EXPIRE-积分到期提醒，INTEGRAL_USE-积分使用提醒，MEMEBER_REGISTER-会员注册提醒，MEMEBER_INVITE_REGISTER-会员绑定成功提醒，MEMEBER_UPGRADE-会员升级提醒，MEMEBER_DOWNGRADE-会员降级提醒，ORDER_OFFLINE_CONSUME-线下订单提醒，ORDER_ONLINE_CONSUME-线上订单提醒，ORDER_PAYMENT-订单支付提醒，ORDER_SHIP-订单发货提醒，ORDER_SIGN-订单签收提醒，ORDER_CANCEL-订单取消提醒，ORDER_APPRAISAL-订单评价提醒). template_type
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    @io.swagger.annotations.ApiModelProperty(value = "短信模板类型(COUPON_RECEIVE-券到账提醒，COUPON_UNRECEIVED-券未领取提醒，COUPON_EXPIRE-券到期提醒，INTEGRAL_ADD-积分增加提醒，INTEGRAL_SUBTRACT-积分减少提醒，INTEGRAL_EXPIRE-积分到期提醒，INTEGRAL_USE-积分使用提醒，MEMEBER_REGISTER-会员注册提醒，MEMEBER_INVITE_REGISTER-会员绑定成功提醒，MEMEBER_UPGRADE-会员升级提醒，MEMEBER_DOWNGRADE-会员降级提醒，ORDER_OFFLINE_CONSUME-线下订单提醒，ORDER_ONLINE_CONSUME-线上订单提醒，ORDER_PAYMENT-订单支付提醒，ORDER_SHIP-订单发货提醒，ORDER_SIGN-订单签收提醒，ORDER_CANCEL-订单取消提醒，ORDER_APPRAISAL-订单评价提醒)",name = "templateType", required = false,example = "")
    private String templateType;

    /**
     * 只读.
    短信配置开关 0.关闭1.开启. status
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    @io.swagger.annotations.ApiModelProperty(value = "短信配置开关 0.关闭1.开启",name = "status", required = false,example = "")
    private Boolean status;

    /**
     * 只读.
    0.全部发送 1.向微信会员发送短信2.向非微信会员发送短信. send_wxmember
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    @io.swagger.annotations.ApiModelProperty(value = "0.全部发送 1.微信会员不发送短信2.向非微信会员发送短信",name = "sendWxmember", required = false,example = "")
    private Integer sendWxmember;

    /**
     * 只读.
    备注. remark
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    @io.swagger.annotations.ApiModelProperty(value = "备注",name = "remark", required = false,example = "")
    private String remark;

    /**
     * 只读.
    创建人id. create_user_id
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建人id",name = "createUserId", required = false,example = "")
    private Long createUserId;

    /**
     * 只读.
    创建人. create_user_name
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建人",name = "createUserName", required = false,example = "")
    private String createUserName;

    /**
     * 只读.
    创建时间. create_date
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建时间",name = "createDate", required = false,example = "")
    private Date createDate;

    /**
     * 只读.
    修改人id. modified_user_id
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    @io.swagger.annotations.ApiModelProperty(value = "修改人id",name = "modifiedUserId", required = false,example = "")
    private Long modifiedUserId;

    /**
     * 只读.
    修改人. modified_user_name
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    @io.swagger.annotations.ApiModelProperty(value = "修改人",name = "modifiedUserName", required = false,example = "")
    private String modifiedUserName;

    /**
     * 只读.
    修改时间. modified_date
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    @io.swagger.annotations.ApiModelProperty(value = "修改时间",name = "modifiedDate", required = false,example = "")
    private Date modifiedDate;

    /**
     * 只读.
    数据有效性（1有效，0无效）. valid
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    @io.swagger.annotations.ApiModelProperty(value = "数据有效性（1有效，0无效）",name = "valid", required = false,example = "")
    private Boolean valid;

    /**
     * 只读.
    模板内容. content
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    @io.swagger.annotations.ApiModelProperty(value = "模板内容",name = "content", required = false,example = "")
    private String content;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    private static final long serialVersionUID = 1L;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    public Long getMsgSmsTempId() {
        return msgSmsTempId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    public void setMsgSmsTempId(Long msgSmsTempId) {
        this.msgSmsTempId = msgSmsTempId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    public Long getSysCompanyId() {
        return sysCompanyId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    public void setSysCompanyId(Long sysCompanyId) {
        this.sysCompanyId = sysCompanyId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    public Long getSysBrandId() {
        return sysBrandId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    public void setSysBrandId(Long sysBrandId) {
        this.sysBrandId = sysBrandId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    public String getBusinessType() {
        return businessType;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    public String getTemplateType() {
        return templateType;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    public void setTemplateType(String templateType) {
        this.templateType = templateType == null ? null : templateType.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    public Integer getSendWxmember() {
        return sendWxmember;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    public void setSendWxmember(Integer sendWxmember) {
        this.sendWxmember = sendWxmember;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    public Long getCreateUserId() {
        return createUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    public Long getModifiedUserId() {
        return modifiedUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    public void setModifiedUserId(Long modifiedUserId) {
        this.modifiedUserId = modifiedUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    public String getModifiedUserName() {
        return modifiedUserName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    public void setModifiedUserName(String modifiedUserName) {
        this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    public Date getModifiedDate() {
        return modifiedDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    public Boolean getValid() {
        return valid;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    public String getContent() {
        return content;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 19:53:52
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    
}