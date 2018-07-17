package com.bizvane.mktcenterserviceimpl.controllers;

import com.bizvane.mktcenterservice.interfaces.TaskProfileService;
import com.bizvane.mktcenterservice.models.vo.TaskVO;
import com.bizvane.utils.commonutils.PageForm;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chen.li
 * @date on 2018/7/13 13:39
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@RestController
@RequestMapping("taskProfile")
public class TaskProfileController {

    @Autowired
    private TaskProfileService taskProfileService;

    /**
     * 查询任务列表
     * @return
     */
    @RequestMapping("getTaskList")
    public ResponseData<TaskVO> getTaskList(TaskVO vo, PageForm pageForm){
        return null;
    }
}
