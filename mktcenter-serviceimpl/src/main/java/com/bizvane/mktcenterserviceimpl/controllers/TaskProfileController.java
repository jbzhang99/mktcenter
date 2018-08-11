package com.bizvane.mktcenterserviceimpl.controllers;

import com.bizvane.members.facade.models.ExtendPropertyModel;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.service.api.ExtendPropertyApiService;
import com.bizvane.members.facade.service.api.MemberInfoApiService;
import com.bizvane.members.facade.service.api.MemberLevelApiService;
import com.bizvane.mktcenterservice.interfaces.TaskProfileService;
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
import com.bizvane.utils.tokens.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @author gengxiaoyu
 * @date on 2018/7/13 13:39
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@RestController
@RequestMapping("taskProfile")
public class TaskProfileController {

    @Autowired
    private TaskProfileService taskProfileService;

    @Autowired
    private MemberLevelApiService memberLevelApiService;

    @Autowired
    private MemberInfoApiService memberInfoApiService;

    @Autowired
    private ExtendPropertyApiService extendPropertyApiService;



    /**
     * 创建任务
     * @return
     */
    @RequestMapping("addTask")
    public ResponseData<Integer> addTask(TaskBO bo, HttpServletRequest request){

        //获取操作人信息
        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        //SysAccountPO stageUser = new SysAccountPO();

        //参数校验
        ResponseData responseData =  TaskParamCheckUtil.checkParam(bo);
        //参数校验不通过
        if (responseData.getCode()==SystemConstants.ERROR_CODE){
            return responseData;
        }

        //新增任务
        ResponseData<Integer> integerResponseData = taskProfileService.addTask(bo, stageUser);

        //返回
        return integerResponseData;
    }

    /**
     * 修改任务
     * @param bo
     * @param request
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
        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        //SysAccountPO stageUser = new SysAccountPO();
        //更新活动
        ResponseData<Integer> registerData = taskProfileService.updateTask(bo,stageUser);

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

        return taskProfileService.executeTask(vo,memberInfoModel);
    }

    /**
     * 查询任务详情
     * @param businessId
     * @return
     */
    @RequestMapping("selectTaskById")
    public ResponseData<TaskBO> selectTaskById(Long businessId){
        return taskProfileService.selectTaskById(businessId);
    }


    /**
     * 查询商家自定义扩展信息
     * @param
     * @return
     */
    //前端传回的是品牌id还是ExtendPropertyModel？？？？
    @RequestMapping("getExtendProperty")
    public ResponseData getExtendProperty(Long brandId){

        ExtendPropertyModel extendPropertyModel = new ExtendPropertyModel();
        extendPropertyModel.setBrandId(brandId);
        return extendPropertyApiService.getExtendProperty(extendPropertyModel);

    }

    /**
     * 任务审核
     * @param taskId
     * @param request
     * @param checkStatus
     * @return
     */
    @RequestMapping("checkTaskProfile")
    public ResponseData checkTaskprofile(Long taskId,HttpServletRequest request,Integer checkStatus){

        ResponseData responseData = new ResponseData();
        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        responseData = taskProfileService.checkTaskProfile(taskId,stageUser,checkStatus);
        return responseData;
    }


    /**
     * 禁用任务
     * @param taskId
     * @param request
     * @return
     */
    @RequestMapping("stopTask")
    public ResponseData stopTask(Long taskId,HttpServletRequest request){

        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        return taskProfileService.stopTask(taskId, stageUser);
    }


    /**
     * 效果分析
     * @param date1
     * @param date2
     * @param request
     * @param pageForm
     * @return
     */
    @RequestMapping("getTaskProfileRecordByTime")
    public ResponseData getTaskProfileRecordByTime(Date date1, Date date2, HttpServletRequest request, PageForm pageForm){

        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        return taskProfileService.getTaskProfileRecordByTime(date1,date2,stageUser,pageForm);
    }

}

