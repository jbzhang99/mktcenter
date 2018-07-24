package com.bizvane.mktcenterservice.models.bo;

import com.bizvane.mktcenterservice.models.vo.MessageVO;
import com.bizvane.mktcenterservice.models.vo.TaskVO;

import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/24 10:52
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public class TaskBO {

    /**
     * 任务对象
     */
    private TaskVO taskVO;

    /**
     * 券号列表
     */
    private List<String> couponCodeList;

    /**
     * 消息对象
     */
    private List<MessageVO> messageVOList;

    public TaskVO getTaskVO() {
        return taskVO;
    }

    public void setTaskVO(TaskVO taskVO) {
        this.taskVO = taskVO;
    }

    public List<String> getCouponCodeList() {
        return couponCodeList;
    }

    public void setCouponCodeList(List<String> couponCodeList) {
        this.couponCodeList = couponCodeList;
    }

    public List<MessageVO> getMessageVOList() {
        return messageVOList;
    }

    public void setMessageVOList(List<MessageVO> messageVOList) {
        this.messageVOList = messageVOList;
    }
}
