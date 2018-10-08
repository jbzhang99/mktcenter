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
     * 创建任务
     * @return
     */
    @RequestMapping("/addTask")
    public ResponseData<Integer> addTask(TaskBO bo , HttpServletRequest request) throws ParseException {
        //参数校验通过，获取操作人信息
        SysAccountPO sysAccountPo = TokenUtils.getStageUser(request);
        bo.getTaskVO().setTaskType(3);
        return  taskInviteService.addTask(bo, sysAccountPo);
    }
    /**
     * 修改任务
     */
    @RequestMapping("/updateInviteTask")
    public ResponseData updateInviteTask(TaskBO bo, HttpServletRequest request) throws ParseException {
        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        return  taskInviteService.updateInviteTask(bo, stageUser);
    }
}
