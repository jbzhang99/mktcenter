package com.bizvane.mktcenterserviceimpl.controllers;

import com.bizvane.mktcenterservice.interfaces.TaskInviteService;
import com.bizvane.mktcenterservice.models.bo.TaskBO;
import com.bizvane.mktcenterservice.models.po.MktCouponPO;
import com.bizvane.mktcenterservice.models.vo.MessageVO;
import com.bizvane.mktcenterservice.models.vo.TaskVO;
import com.bizvane.mktcenterserviceimpl.common.constants.SystemConstants;
import com.bizvane.mktcenterserviceimpl.common.utils.TaskParamCheckUtil;
import com.bizvane.utils.commonutils.PageForm;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/13 13:38
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@RestController
@RequestMapping("taskInvite")
public class TaskInviteController {

    @Autowired
    private TaskInviteService taskInviteService;

    /**
     * 查询任务列表
     * @return
     */
    @RequestMapping("getTaskList")
    public ResponseData<TaskVO> getTaskList(TaskVO vo, PageForm pageForm){
        ResponseData<TaskVO> taskVOResponseData = taskInviteService.getTaskList(vo, pageForm);
        return taskVOResponseData;
    }

    /**
     * 创建任务
     * @return
     */
    @RequestMapping("addTask")
    public ResponseData<Integer> addTask(TaskVO vo, List<MktCouponPO> couponCodeList, List<MessageVO> messageVOList, HttpServletRequest request){
        TaskBO bo = new TaskBO();
        bo.setTaskVO(vo);
        bo.setMktCouponPOList(couponCodeList);
        bo.setMessageVOList(messageVOList);
        //参数校验
        ResponseData responseData = TaskParamCheckUtil.checkParam(bo);
        //参数校验不通过
        if(SystemConstants.ERROR_CODE==responseData.getCode()){
            return responseData;
        }
        //参数校验通过，获取操作人信息
//        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        SysAccountPO stageUser = new SysAccountPO();

        //新增活动
        ResponseData<Integer> integerResponseData = taskInviteService.addTask(bo, stageUser);

        //返回
        return integerResponseData;
    }

    /**
     * 修改任务
     * @param
     * @return
     */
    public ResponseData<Integer> updateTask(TaskVO vo, List<MktCouponPO> couponCodeList, List<MessageVO> messageVOList, HttpServletRequest request){
        TaskBO bo = new TaskBO();
        bo.setTaskVO(vo);
        bo.setMktCouponPOList(couponCodeList);
        bo.setMessageVOList(messageVOList);
        //参数校验
        ResponseData responseData = TaskParamCheckUtil.checkParam(bo);
        //参数校验不通过
        if(SystemConstants.ERROR_CODE==responseData.getCode()){
            return responseData;
        }
        //参数校验通过，获取操作人信息
        SysAccountPO stageUser = new SysAccountPO();
        //更新活动
        ResponseData<Integer> registerData = taskInviteService.updateTask(bo,stageUser);

        //返回

        return registerData;
    }

    /**
     * 执行任务
     * @param
     * @return
     */
    public ResponseData<Integer> executeTask(TaskVO vo){

        return taskInviteService.executeTask(vo);
    }

    /**
     * 查询任务详情
     * @param mktActivityId
     * @return
     */
    public ResponseData<List<TaskVO>> selectTaskById(Long mktActivityId){
        return taskInviteService.selectTaskById(mktActivityId);
    }
}
