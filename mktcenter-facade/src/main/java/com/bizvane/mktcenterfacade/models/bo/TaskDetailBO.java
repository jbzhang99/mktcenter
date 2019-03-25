package com.bizvane.mktcenterfacade.models.bo;

import com.bizvane.mktcenterfacade.models.po.MktMessagePO;
import com.bizvane.mktcenterfacade.models.po.MktTaskInvitePO;
import com.bizvane.mktcenterfacade.models.po.MktTaskOrderPO;
import com.bizvane.mktcenterfacade.models.po.MktCouponPO;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2018/7/31 11:42
 */
public class TaskDetailBO {
    private Long mktTaskId;
    private Long sysCompanyId;
    private Long sysBrandId;
    private String taskCode;
    private Integer taskType;
    private String taskName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date startTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date endTime;
    private Integer points;
    private Integer checkStatus;
    private Integer taskStatus;
    private String remark;
    private String taskInfo;
    private String taskListImg;
    private String taskDetailImg;
    private String  propertyCode;
    /**
     * 会员订单与消费
     */
    private MktTaskOrderPO mktTaskOrderPO;

    /**
     * 会员开卡任务
     */
    private MktTaskInvitePO mktTaskInvitePO;
    /**
     * 券号列表(奖励)
     */
    private List<MktCouponPO> mktCouponPOList;

    /**
     * 消息对象
     */
    private List<MktMessagePO> mktmessagePOList;

    public Long getMktTaskId() {
        return mktTaskId;
    }

    public void setMktTaskId(Long mktTaskId) {
        this.mktTaskId = mktTaskId;
    }

    public Long getSysCompanyId() {
        return sysCompanyId;
    }

    public void setSysCompanyId(Long sysCompanyId) {
        this.sysCompanyId = sysCompanyId;
    }

    public Long getSysBrandId() {
        return sysBrandId;
    }

    public void setSysBrandId(Long sysBrandId) {
        this.sysBrandId = sysBrandId;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

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

    public MktTaskOrderPO getMktTaskOrderPO() {
        return mktTaskOrderPO;
    }

    public void setMktTaskOrderPO(MktTaskOrderPO mktTaskOrderPO) {
        this.mktTaskOrderPO = mktTaskOrderPO;
    }

    public List<MktCouponPO> getMktCouponPOList() {
        return mktCouponPOList;
    }

    public void setMktCouponPOList(List<MktCouponPO> mktCouponPOList) {
        this.mktCouponPOList = mktCouponPOList;
    }

    public List<MktMessagePO> getMktmessagePOList() {
        return mktmessagePOList;
    }

    public void setMktmessagePOList(List<MktMessagePO> mktmessagePOList) {
        this.mktmessagePOList = mktmessagePOList;
    }

    public MktTaskInvitePO getMktTaskInvitePO() {
        return mktTaskInvitePO;
    }

    public void setMktTaskInvitePO(MktTaskInvitePO mktTaskInvitePO) {
        this.mktTaskInvitePO = mktTaskInvitePO;
    }

    public String getPropertyCode() {
        return propertyCode;
    }

    public void setPropertyCode(String propertyCode) {
        this.propertyCode = propertyCode;
    }
}
