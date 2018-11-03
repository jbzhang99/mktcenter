package com.bizvane.mktcenterserviceimpl.controllers;

import com.bizvane.centercontrolservice.models.po.AppletFunctionPO;
import com.bizvane.mktcenterservice.interfaces.TaskShareService;
import com.bizvane.mktcenterservice.models.bo.TaskBO;
import com.bizvane.mktcenterservice.models.vo.ShareSuccessVO;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.utils.tokens.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
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

    @RequestMapping("getURLList")
    public ResponseData<List<AppletFunctionPO>> getURLList(HttpServletRequest request){
        SysAccountPO sysAccountPo = TokenUtils.getStageUser(request);
        Long brandId = sysAccountPo.getBrandId();
        return taskShareService.getURLList(brandId);
    }
    /**
     * 创建任务
     * @return
     */
    @RequestMapping("addTask")
    public ResponseData<Integer> addTask(TaskBO bo,HttpServletRequest request) throws ParseException {
        SysAccountPO sysAccountPo = TokenUtils.getStageUser(request);
//        SysAccountPO sysAccountPo=new SysAccountPO();
//        sysAccountPo.setBrandId(96L);
//        sysAccountPo.setName("测试测试");
//        sysAccountPo.setSysAccountId(12867L);
//        sysAccountPo.setSysCompanyId(3841L);
        bo.getTaskVO().setTaskType(2);
        return taskShareService.addTask(bo, sysAccountPo);
    }
    /**
     * 修改任务
     * @param
     * @return
     */
    @RequestMapping("updateTask")
    public ResponseData<Integer> updateTask(TaskBO bo, HttpServletRequest request){
        //参数校验通过，获取操作人信息
        SysAccountPO stageUser=TokenUtils.getStageUser(request);
        return taskShareService.updateTask(bo,stageUser);
    }
    /**
     * 执行分享任务的奖励
     * @param vo
     */
    @RequestMapping("doAwardShare")
    public  void   doAwardShare(ShareSuccessVO vo){
        taskShareService.doAwardShare(vo);
    }

}

