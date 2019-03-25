package com.bizvane.couponfacade.models.po;

import java.io.Serializable;
import java.util.Date;

public class RocketLogPO implements Serializable {
    /**
     * 只读.
    主键id. rocket_log_id
     *
     * @mbg.generated 2018-07-13 19:38:21
     */
    @io.swagger.annotations.ApiModelProperty(value = "主键id",name = "rocketLogId", required = false,example = "")
    private Long rocketLogId;

    /**
     * 只读.
    消息id. message_id
     *
     * @mbg.generated 2018-07-13 19:38:21
     */
    @io.swagger.annotations.ApiModelProperty(value = "消息id",name = "messageId", required = false,example = "")
    private String messageId;

    /**
     * 只读.
    业务单据号. bussiness_id
     *
     * @mbg.generated 2018-07-13 19:38:21
     */
    @io.swagger.annotations.ApiModelProperty(value = "业务单据号",name = "bussinessId", required = false,example = "")
    private String bussinessId;

    /**
     * 只读.
    业务模型代码. bussiness_module_code
     *
     * @mbg.generated 2018-07-13 19:38:21
     */
    @io.swagger.annotations.ApiModelProperty(value = "业务模型代码",name = "bussinessModuleCode", required = false,example = "")
    private String bussinessModuleCode;

    /**
     * 只读.
    发送数据. data_body
     *
     * @mbg.generated 2018-07-13 19:38:21
     */
    @io.swagger.annotations.ApiModelProperty(value = "发送数据",name = "dataBody", required = false,example = "")
    private String dataBody;

    /**
     * 只读.
    返回数据. result_info
     *
     * @mbg.generated 2018-07-13 19:38:21
     */
    @io.swagger.annotations.ApiModelProperty(value = "返回数据",name = "resultInfo", required = false,example = "")
    private String resultInfo;

    /**
     * 只读.
    发送状态：00-新增；05-生产失败；10-生产成功；15-消费失败；20-消费成功；. send_state
     *
     * @mbg.generated 2018-07-13 19:38:21
     */
    @io.swagger.annotations.ApiModelProperty(value = "发送状态：00-新增；05-生产失败；10-生产成功；15-消费失败；20-消费成功；",name = "sendState", required = false,example = "")
    private String sendState;

    /**
     * 只读.
    最后修改人. update_user_id
     *
     * @mbg.generated 2018-07-13 19:38:21
     */
    @io.swagger.annotations.ApiModelProperty(value = "最后修改人",name = "updateUserId", required = false,example = "")
    private Integer updateUserId;

    /**
     * 只读.
    最后修改日期. update_date
     *
     * @mbg.generated 2018-07-13 19:38:21
     */
    @io.swagger.annotations.ApiModelProperty(value = "最后修改日期",name = "updateDate", required = false,example = "")
    private Date updateDate;

    /**
     * 只读.
    创建人. create_user_id
     *
     * @mbg.generated 2018-07-13 19:38:21
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建人",name = "createUserId", required = false,example = "")
    private Integer createUserId;

    /**
     * 只读.
    创建日期. create_date
     *
     * @mbg.generated 2018-07-13 19:38:21
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建日期",name = "createDate", required = false,example = "")
    private Date createDate;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:38:21
     */
    private static final long serialVersionUID = 1L;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:38:21
     */
    public Long getRocketLogId() {
        return rocketLogId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:38:21
     */
    public void setRocketLogId(Long rocketLogId) {
        this.rocketLogId = rocketLogId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:38:21
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:38:21
     */
    public void setMessageId(String messageId) {
        this.messageId = messageId == null ? null : messageId.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:38:21
     */
    public String getBussinessId() {
        return bussinessId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:38:21
     */
    public void setBussinessId(String bussinessId) {
        this.bussinessId = bussinessId == null ? null : bussinessId.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:38:21
     */
    public String getBussinessModuleCode() {
        return bussinessModuleCode;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:38:21
     */
    public void setBussinessModuleCode(String bussinessModuleCode) {
        this.bussinessModuleCode = bussinessModuleCode == null ? null : bussinessModuleCode.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:38:21
     */
    public String getDataBody() {
        return dataBody;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:38:21
     */
    public void setDataBody(String dataBody) {
        this.dataBody = dataBody == null ? null : dataBody.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:38:21
     */
    public String getResultInfo() {
        return resultInfo;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:38:21
     */
    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo == null ? null : resultInfo.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:38:21
     */
    public String getSendState() {
        return sendState;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:38:21
     */
    public void setSendState(String sendState) {
        this.sendState = sendState == null ? null : sendState.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:38:21
     */
    public Integer getUpdateUserId() {
        return updateUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:38:21
     */
    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:38:21
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:38:21
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:38:21
     */
    public Integer getCreateUserId() {
        return createUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:38:21
     */
    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:38:21
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:38:21
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}