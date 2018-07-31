package com.bizvane.mktcenterservice.models.vo;

import com.bizvane.mktcenterservice.models.po.MktTaskPO;

import java.math.BigDecimal;

/**
 * @author chen.li
 * @date on 2018/7/17 9:41
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public class TaskVO extends MktTaskPO {
    /**
     * 1.获取所有数据
     * 2.获取启用的数据
     * 3.获取禁用的数据
     */
    private  String  showType;

    /**
     * 只读. 任务描述. task_info
     * @mbg.generated  2018-07-14 13:26:02
     */
    @io.swagger.annotations.ApiModelProperty(value = "任务描述", name = "taskInfo", required = false, example = "")
    private String taskInfo;
    /**
     * 只读. 任务列表图片，多张逗号分隔. task_list_img
     * @mbg.generated  2018-07-14 13:26:02
     */
    @io.swagger.annotations.ApiModelProperty(value = "任务列表图片，多张逗号分隔", name = "taskListImg", required = false, example = "")
    private String taskListImg;
    /**
     * 只读. 任务详情图片. task_detail_img
     * @mbg.generated  2018-07-14 13:26:02
     */
    @io.swagger.annotations.ApiModelProperty(value = "任务详情图片", name = "taskDetailImg", required = false, example = "")
    private String taskDetailImg;

    /**
     * 只读. 邀请开卡人数. invite_num
     * @mbg.generated  2018-07-25 16:02:16
     */
    @io.swagger.annotations.ApiModelProperty(value = "邀请开卡人数", name = "inviteNum", required = false, example = "")
    private Integer inviteNum;

    /**
     * 只读. 任务条件/订单来源限制：0全部类型，1线下订单，2微商城订单. order_source
     * @mbg.generated  2018-07-25 16:02:16
     */
    @io.swagger.annotations.ApiModelProperty(value = "任务条件/订单来源限制：0全部类型，1线下订单，2微商城订单", name = "orderSource", required = false, example = "")
    private Integer orderSource;
    /**
     * 只读. 任务条件/累计消费金额. consume_amount
     * @mbg.generated  2018-07-25 16:02:16
     */
    @io.swagger.annotations.ApiModelProperty(value = "任务条件/累计消费金额", name = "consumeAmount", required = false, example = "")
    private BigDecimal consumeAmount;
    /**
     * 只读. 任务条件/累计消费次数. consume_times
     * @mbg.generated  2018-07-25 16:02:16
     */
    @io.swagger.annotations.ApiModelProperty(value = "任务条件/累计消费次数", name = "consumeTimes", required = false, example = "")
    private Integer consumeTimes;

    /**
     * 只读. 需要完善的字段code，逗号分隔. property_code
     * @mbg.generated  2018-07-25 16:02:16
     */
    @io.swagger.annotations.ApiModelProperty(value = "需要完善的字段code，逗号分隔", name = "propertyCode", required = false, example = "")
    private String propertyCode;

    /**
     * 只读. 任务条件/分享次数. share_times
     * @mbg.generated  2018-07-25 16:02:16
     */
    @io.swagger.annotations.ApiModelProperty(value = "任务条件/分享次数", name = "shareTimes", required = false, example = "")
    private Integer shareTimes;
    /**
     * 只读. 任务条件/分享的链接类型：1站内链接，2自定义链接. share_url_type
     * @mbg.generated  2018-07-25 16:02:16
     */
    @io.swagger.annotations.ApiModelProperty(value = "任务条件/分享的链接类型：1站内链接，2自定义链接", name = "shareUrlType", required = false, example = "")
    private Integer shareUrlType;
    /**
     * 只读. 任务条件/需要分享的链接. share_url
     * @mbg.generated  2018-07-25 16:02:16
     */
    @io.swagger.annotations.ApiModelProperty(value = "任务条件/需要分享的链接", name = "shareUrl", required = false, example = "")
    private String shareUrl;

    public String getTaskInfo() {
        return taskInfo;
    }

    public void setTaskInfo(String taskInfo) {
        this.taskInfo = taskInfo;
    }

    public String getTaskListImg() {
        return taskListImg;
    }

    public void setTaskListImg(String taskListImg) {
        this.taskListImg = taskListImg;
    }

    public String getTaskDetailImg() {
        return taskDetailImg;
    }

    public void setTaskDetailImg(String taskDetailImg) {
        this.taskDetailImg = taskDetailImg;
    }

    public Integer getInviteNum() {
        return inviteNum;
    }

    public void setInviteNum(Integer inviteNum) {
        this.inviteNum = inviteNum;
    }

    public Integer getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(Integer orderSource) {
        this.orderSource = orderSource;
    }

    public BigDecimal getConsumeAmount() {
        return consumeAmount;
    }

    public void setConsumeAmount(BigDecimal consumeAmount) {
        this.consumeAmount = consumeAmount;
    }

    public Integer getConsumeTimes() {
        return consumeTimes;
    }

    public void setConsumeTimes(Integer consumeTimes) {
        this.consumeTimes = consumeTimes;
    }

    public String getPropertyCode() {
        return propertyCode;
    }

    public void setPropertyCode(String propertyCode) {
        this.propertyCode = propertyCode;
    }

    public Integer getShareTimes() {
        return shareTimes;
    }

    public void setShareTimes(Integer shareTimes) {
        this.shareTimes = shareTimes;
    }

    public Integer getShareUrlType() {
        return shareUrlType;
    }

    public void setShareUrlType(Integer shareUrlType) {
        this.shareUrlType = shareUrlType;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }
}
