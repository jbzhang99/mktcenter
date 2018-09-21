package com.bizvane.mktcenterserviceimpl.controllers;

import com.bizvane.centerstageservice.models.vo.SysStoreVo;
import com.bizvane.mktcenterservice.interfaces.TaskService;
import com.bizvane.mktcenterservice.models.bo.TaskBO;
import com.bizvane.mktcenterservice.models.po.MktTaskPOWithBLOBs;
import com.bizvane.mktcenterservice.models.vo.*;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.utils.tokens.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/13 13:30
 * @description 任务
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@Slf4j
@RestController
@RequestMapping("task")
public class TaskController {
    @Autowired
    private TaskService taskService;
    /**
     * 根据tonken中登录人的账号id和公司id获取店铺列表
     */
    @RequestMapping("getWhiteStoreList")
    public ResponseData<List<SysStoreVo>> getWhiteStoreList(SysStoreVo vo,HttpServletRequest request){
        ResponseData<List<SysStoreVo>> responseData=null;
        SysAccountPO sysAccountPo = TokenUtils.getStageUser(request);
        if (sysAccountPo!=null){
            responseData = taskService.getWhiteStoreList(vo, sysAccountPo);
        }else{
            responseData=new ResponseData<List<SysStoreVo>>();
            responseData.setMessage("无法获取登录者数据!");
        }
        return responseData;
    }
    /**
     * 获取任务详情 --通用--已经核对
     */
    @RequestMapping("selectTaskById")
    public ResponseData<TaskBO> selectTaskById(Long businessId,Integer taskType){
        return taskService.selectTaskById(businessId,taskType);
    }
    /**
     * 禁用任务
     * @param mktTaskId
     * @return
     */
    @RequestMapping("stopTaskById")
    public ResponseData<Integer> stopTaskById(Long mktTaskId, HttpServletRequest request){
        //获取操作人信息
        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        //禁用任务
        ResponseData<Integer> integerResponseData = taskService.stopTaskById(mktTaskId, stageUser);
        return integerResponseData;
    }
    /**
     * 任务审核--已经核对
     * @param request
     * @return
     * Long businessId , Integer checkStatus,String remark, Date startTime,Date endTime,
     */
    @RequestMapping("checkTaskById")
    public ResponseData<Integer> checkTaskById(CheckTaskVO vo,HttpServletRequest request) throws ParseException {
        //获取操作人信息
        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        //审核任务
        ResponseData<Integer> integerResponseData = taskService.checkTaskById(vo,stageUser);
        return integerResponseData;
    }

    /**
     * 任务效果分析
     * @param vo
     * @return
     */
    @RequestMapping("doAnalysis")
    public ResponseData<TaskRecordVO> doAnalysis(TaskAnalysisVo vo,HttpServletRequest request){
        SysAccountPO sysAccountPo = TokenUtils.getStageUser(request);

//        SysAccountPO sysAccountPo = new SysAccountPO();
//        sysAccountPo.setSysAccountId(26L);
//        sysAccountPo.setSysCompanyId(2L);
//        sysAccountPo.setBrandId(4L);
//        sysAccountPo.setAccountCode("15328634678");
//        sysAccountPo.setName("不啊哟删除");

        return taskService.doAnalysis(vo,sysAccountPo);
    }
    @RequestMapping("getTaskByTaskType")
    public ResponseData<com.github.pagehelper.PageInfo<MktTaskPOWithBLOBs>> getTaskByTaskType(TaskVO vo, PageForm pageForm){
       return taskService.getTaskByTaskType(vo,pageForm);
    }

}
