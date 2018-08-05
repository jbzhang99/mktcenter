package com.bizvane.mktcenterserviceimpl.controllers;

import com.alibaba.fastjson.JSON;
import com.bizvane.mktcenterservice.interfaces.TaskInviteService;
import com.bizvane.mktcenterservice.models.bo.TaskBO;
import com.bizvane.mktcenterservice.models.bo.TaskDetailBO;
import com.bizvane.mktcenterservice.models.po.MktCouponPO;
import com.bizvane.mktcenterservice.models.vo.MessageVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterservice.models.vo.TaskDetailVO;
import com.bizvane.mktcenterservice.models.vo.TaskVO;
import com.bizvane.mktcenterserviceimpl.common.constants.SystemConstants;
import com.bizvane.mktcenterserviceimpl.common.utils.TaskParamCheckUtil;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.utils.tokens.TokenUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/13 13:38
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 * 消费金额任务
 */
@RestController
@RequestMapping("/taskInvite")
public class TaskInviteController {

    @Autowired
    private TaskInviteService taskInviteService;

    /**
     * 任务审核
     */
    @RequestMapping("/checkInviteTask")
    public  ResponseData<Integer>  checkInviteTask(TaskVO vo){
        ResponseData<Integer> result = new ResponseData<Integer>(SysResponseEnum.FAILED.getCode(),SysResponseEnum.FAILED.getMessage(),null);
        Integer data = taskInviteService.checkInviteTask(vo);
        if (data>0){
            result.setCode(SysResponseEnum.SUCCESS.getCode());
            result.setMessage(SysResponseEnum.SUCCESS.getMessage());
        }
        return result;
    }
    /**
     * 查询消费任务详情
     */
    @RequestMapping("/getInviteTaskDetails")
    public  ResponseData<TaskDetailBO> getInviteTaskDetails(Long mktTaskId){
        ResponseData<TaskDetailBO> result = new ResponseData<TaskDetailBO>(SysResponseEnum.FAILED.getCode(),SysResponseEnum.FAILED.getMessage(),null);
        List<TaskDetailBO> lists = taskInviteService.getInviteTaskDetails(mktTaskId);

        if (CollectionUtils.isNotEmpty(lists)){
            result.setCode(SysResponseEnum.SUCCESS.getCode());
            result.setMessage(SysResponseEnum.SUCCESS.getMessage());
            result.setData(lists.get(0));
        }

        return  result;
    }

    /**
     * 创建任务
     * @return
     */
    @RequestMapping("/addTask")
    public ResponseData<Integer> addTask(TaskDetailVO vo, HttpServletRequest request) throws ParseException {
        //参数校验通过，获取操作人信息
        SysAccountPO stageUser = TokenUtils.getStageUser(request);

        return  taskInviteService.addTask(vo, stageUser);
    }
    /**
     * 修改任务
     */
    @RequestMapping("/updateInviteTask")
    public ResponseData updateInviteTask(TaskDetailVO vo, HttpServletRequest request) throws ParseException {
        SysAccountPO stageUser = TokenUtils.getStageUser(request);

        return  taskInviteService.updateInviteTask(vo, stageUser);
    }
}
