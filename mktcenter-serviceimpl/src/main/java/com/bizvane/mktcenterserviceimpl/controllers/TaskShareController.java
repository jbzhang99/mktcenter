package com.bizvane.mktcenterserviceimpl.controllers;

//import com.bizvane.appletservice.Rpc.MenberMadeServiceRpc;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.mktcenterservice.interfaces.TaskShareService;
import com.bizvane.mktcenterservice.models.bo.TaskBO;
import com.bizvane.mktcenterservice.models.po.MktCouponPO;
import com.bizvane.mktcenterservice.models.po.MktMessagePO;
import com.bizvane.mktcenterservice.models.vo.MessageVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterservice.models.vo.ShareSuccessVO;
import com.bizvane.mktcenterservice.models.vo.TaskVO;
import com.bizvane.mktcenterserviceimpl.common.constants.SystemConstants;
import com.bizvane.mktcenterserviceimpl.common.enums.TaskTypeEnum;
import com.bizvane.mktcenterserviceimpl.common.utils.TaskParamCheckUtil;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.utils.tokens.TokenUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
     * 创建任务
     * @return
     */
    @RequestMapping("addTask")
    public ResponseData<Integer> addTask(TaskBO bo,HttpServletRequest request) throws ParseException {
        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        return taskShareService.addTask(bo, stageUser);
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
    /**
     * 效果分析
     * @param date1
     * @param date2
     * @param request
     * @param taskName
     * @param pageForm
     * @return
     */
//    @RequestMapping("getTaskProfileRecordByTime")
//    public ResponseData getTaskProfileRecordByTime(String date1, String date2,HttpServletRequest request ,String taskName, PageForm pageForm)throws Exception{
//
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date timeStart = simpleDateFormat.parse(date1);
//
//        Date timeEnd = simpleDateFormat.parse(date2);
//        SysAccountPO stageUser = TokenUtils.getStageUser(request);
//
//        return taskShareService.getTaskShareRecordByTime(timeStart,timeEnd,stageUser,taskName,pageForm);
//    }


}

