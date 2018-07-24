package com.bizvane.mktcenterservice.models.vo;

import com.bizvane.mktcenterservice.models.po.MktTaskPO;

/**
 * @author chen.li
 * @date on 2018/7/17 9:41
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public class TaskVO extends MktTaskPO {

    private String taskInfo;

    public String getTaskInfo() {
        return taskInfo;
    }

    public void setTaskInfo(String taskInfo) {
        this.taskInfo = taskInfo;
    }
}
