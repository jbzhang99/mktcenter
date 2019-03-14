package com.bizvane.messagefacade.models.po;

import java.io.Serializable;
import java.util.Date;

public class MondodbMsgWxLogPO implements Serializable {
	
	/**
	 * 只读. 主键id. msg_sms_log_id
	 * @mbg.generated  2018-08-09 09:44:32
	 */
	
	 private String _id;
    /**
     * 只读.
    主键id. wechat_message_log_id
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    @io.swagger.annotations.ApiModelProperty(value = "主键id",name = "wechatMessageLogId", required = false,example = "")
    private Long wechatMessageLogId;

    /**
     * 只读.
    消息队列msgid. rocket_msg_id
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    @io.swagger.annotations.ApiModelProperty(value = "消息队列msgid",name = "rocketMsgId", required = false,example = "")
    private String rocketMsgId;

    /**
     * 只读.
    消息id. message_id
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    @io.swagger.annotations.ApiModelProperty(value = "消息id",name = "messageId", required = false,example = "")
    private String messageId;

    /**
     * 只读.
    业务模型代码. bussiness_module_code
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    @io.swagger.annotations.ApiModelProperty(value = "业务模型代码",name = "bussinessModuleCode", required = false,example = "")
    private String bussinessModuleCode;

    /**
     * 只读.
    业务单据号. bussiness_id
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    @io.swagger.annotations.ApiModelProperty(value = "业务单据号",name = "bussinessId", required = false,example = "")
    private String bussinessId;

    /**
     * 只读.
    微信公众号id. wx_public_id
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    @io.swagger.annotations.ApiModelProperty(value = "微信公众号id",name = "wxPublicId", required = false,example = "")
    private Long wxPublicId;

    /**
     * 只读.
    会员openid. open_id
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    @io.swagger.annotations.ApiModelProperty(value = "会员openid",name = "openId", required = false,example = "")
    private String openId;

    /**
     * 只读.
    会员姓名. member_name
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    @io.swagger.annotations.ApiModelProperty(value = "会员姓名",name = "memberName", required = false,example = "")
    private String memberName;

    /**
     * 只读.
    会员手机号码. member_phone
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    @io.swagger.annotations.ApiModelProperty(value = "会员手机号码",name = "memberPhone", required = false,example = "")
    private String memberPhone;

    /**
     * 只读.
    微信昵称. wx_nick
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    @io.swagger.annotations.ApiModelProperty(value = "微信昵称",name = "wxNick", required = false,example = "")
    private String wxNick;

    /**
     * 只读.
    微信模板类型(消息内容). template_type
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    @io.swagger.annotations.ApiModelProperty(value = "微信模板类型(消息内容)",name = "templateType", required = false,example = "")
    private String templateType;

    /**
     * 只读.
    发送数据. data_body
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    @io.swagger.annotations.ApiModelProperty(value = "发送数据",name = "dataBody", required = false,example = "")
    private String dataBody;

    /**
     * 只读.
    微信消息体. message_body
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    @io.swagger.annotations.ApiModelProperty(value = "微信消息体",name = "messageBody", required = false,example = "")
    private String messageBody;

    /**
     * 只读.
    返回数据. result_info
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    @io.swagger.annotations.ApiModelProperty(value = "返回数据",name = "resultInfo", required = false,example = "")
    private String resultInfo;

    /**
     * 只读.
    发送状态（发送结果）：00-新增；05-失败；10-成功；. send_state
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    @io.swagger.annotations.ApiModelProperty(value = "发送状态（发送结果）：00-新增；05-失败；10-成功；",name = "sendState", required = false,example = "")
    private String sendState;

    /**
     * 只读.
    出现错误是否支持重发. is_resend
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    @io.swagger.annotations.ApiModelProperty(value = "出现错误是否支持重发",name = "isResend", required = false,example = "")
    private Boolean isResend;

    /**
     * 只读.
    最后修改人. update_user_id
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    @io.swagger.annotations.ApiModelProperty(value = "最后修改人",name = "updateUserId", required = false,example = "")
    private Integer updateUserId;

    /**
     * 只读.
    最后修改日期. update_date
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    @io.swagger.annotations.ApiModelProperty(value = "最后修改日期",name = "updateDate", required = false,example = "")
    private Date updateDate;

    /**
     * 只读.
    创建人. create_user_id
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建人",name = "createUserId", required = false,example = "")
    private Integer createUserId;

    /**
     * 只读.
    创建日期（发送时间）. create_date
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建日期（发送时间）",name = "createDate", required = false,example = "")
    private Date createDate;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    private static final long serialVersionUID = 1L;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    public Long getWechatMessageLogId() {
        return wechatMessageLogId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    public void setWechatMessageLogId(Long wechatMessageLogId) {
        this.wechatMessageLogId = wechatMessageLogId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    public String getRocketMsgId() {
        return rocketMsgId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    public void setRocketMsgId(String rocketMsgId) {
        this.rocketMsgId = rocketMsgId == null ? null : rocketMsgId.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    public void setMessageId(String messageId) {
        this.messageId = messageId == null ? null : messageId.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    public String getBussinessModuleCode() {
        return bussinessModuleCode;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    public void setBussinessModuleCode(String bussinessModuleCode) {
        this.bussinessModuleCode = bussinessModuleCode == null ? null : bussinessModuleCode.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    public String getBussinessId() {
        return bussinessId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    public void setBussinessId(String bussinessId) {
        this.bussinessId = bussinessId == null ? null : bussinessId.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    public Long getWxPublicId() {
        return wxPublicId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    public void setWxPublicId(Long wxPublicId) {
        this.wxPublicId = wxPublicId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    public String getMemberPhone() {
        return memberPhone;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone == null ? null : memberPhone.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    public String getWxNick() {
        return wxNick;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    public void setWxNick(String wxNick) {
        this.wxNick = wxNick == null ? null : wxNick.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    public String getTemplateType() {
        return templateType;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    public void setTemplateType(String templateType) {
        this.templateType = templateType == null ? null : templateType.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    public String getDataBody() {
        return dataBody;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    public void setDataBody(String dataBody) {
        this.dataBody = dataBody == null ? null : dataBody.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    public String getMessageBody() {
        return messageBody;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody == null ? null : messageBody.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    public String getResultInfo() {
        return resultInfo;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo == null ? null : resultInfo.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    public String getSendState() {
        return sendState;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    public void setSendState(String sendState) {
        this.sendState = sendState == null ? null : sendState.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    public Boolean getIsResend() {
        return isResend;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    public void setIsResend(Boolean isResend) {
        this.isResend = isResend;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    public Integer getUpdateUserId() {
        return updateUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    public Integer getCreateUserId() {
        return createUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}
    
    
}