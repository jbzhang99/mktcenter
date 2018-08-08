package com.bizvane.mktcenterserviceimpl.controllers;

import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.mktcenterservice.interfaces.TaskShareService;
import com.bizvane.mktcenterservice.models.bo.TaskBO;
import com.bizvane.mktcenterservice.models.po.MktCouponPO;
import com.bizvane.mktcenterservice.models.po.MktMessagePO;
import com.bizvane.mktcenterservice.models.vo.MessageVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterservice.models.vo.TaskVO;
import com.bizvane.mktcenterserviceimpl.common.constants.SystemConstants;
import com.bizvane.mktcenterserviceimpl.common.utils.TaskParamCheckUtil;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/13 13:40
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@RestController
@RequestMapping("taskShare")
public class TaskShareController {

    @Autowired
    private TaskShareService taskShareService;

    /**
     * 查询任务列表
     * @return
     */
    @RequestMapping("getTaskList")
    public ResponseData<PageInfo<TaskVO>> getTaskList(TaskVO vo, PageForm pageForm){
        ResponseData<PageInfo<TaskVO>> taskVOResponseData = taskShareService.getTaskList(vo, pageForm);
        return taskVOResponseData;
    }

    /**
     * 创建任务
     * @return
     */
    @RequestMapping("addTask")
    public ResponseData<Integer> addTask(TaskBO bo, HttpServletRequest request){

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
        ResponseData<Integer> integerResponseData = taskShareService.addTask(bo, stageUser);

        //返回
        return integerResponseData;
    }

    /**
     * 修改任务
     * @param
     * @return
     */
    @RequestMapping("updateTask")
    public ResponseData<Integer> updateTask(TaskBO bo, HttpServletRequest request){

        //参数校验
        ResponseData responseData = TaskParamCheckUtil.checkParam(bo);
        //参数校验不通过
        if(SystemConstants.ERROR_CODE==responseData.getCode()){
            return responseData;
        }
        //参数校验通过，获取操作人信息
        SysAccountPO stageUser = new SysAccountPO();
        //更新活动
        ResponseData<Integer> registerData = taskShareService.updateTask(bo,stageUser);

        //返回

        return registerData;
    }

    /**
     * 执行任务
     * @param
     * @return
     */
    @RequestMapping("executeTask")
    public ResponseData<Integer> executeTask(TaskVO vo,MemberInfoModel memberInfoModel){

        return taskShareService.executeTask(vo,memberInfoModel);
    }

    /**
     * 查询任务详情
     * @param businessId
     * @return
     */
    @RequestMapping("selectTaskById")
    public ResponseData<TaskBO> selectTaskById(Long businessId){
        return taskShareService.selectTaskById(businessId);
    }

    /**
     * 审核任务
     * @param taskId
     * @param stageUser
     * @return
     */
    @RequestMapping("checkTaskShare")
    public ResponseData checkTaskShare(Long taskId,SysAccountPO stageUser,Integer checkStatus){

        return taskShareService.checkTaskShare(taskId,stageUser,checkStatus);
    }


    /**
     * 禁用任务
     * @param taskId
     * @param stageUser
     * @return
     */
    @RequestMapping("stopTask")
    public ResponseData stopTask(Long taskId,SysAccountPO stageUser){
        return taskShareService.stopTask(taskId, stageUser);
    }

    public ResponseData getTaskShareRecordByTime(Date date1, Date date2, SysAccountPO stageUser, String taskName, PageForm pageForm){

        return taskShareService.getTaskShareRecordByTime(date1,date2,stageUser,taskName,pageForm);
    }


    /**
     * 效果分析
     * @param date1
     * @param date2
     * @param stageUser
     * @param pageForm
     * @return
     */
    @RequestMapping("getTaskProfileRecordByTime")
    public ResponseData getTaskProfileRecordByTime(Date date1, Date date2, SysAccountPO stageUser,String taskName, PageForm pageForm){

        return taskShareService.getTaskShareRecordByTime(date1,date2,stageUser,taskName,pageForm);
    }
}

