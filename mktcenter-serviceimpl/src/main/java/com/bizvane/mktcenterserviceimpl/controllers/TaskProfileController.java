package com.bizvane.mktcenterserviceimpl.controllers;

import com.bizvane.members.facade.models.ExtendPropertyModel;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.service.api.ExtendPropertyApiService;
import com.bizvane.members.facade.service.api.MemberInfoApiService;
import com.bizvane.members.facade.service.api.MemberLevelApiService;
import com.bizvane.members.facade.vo.ExtendPropertyVO;
import com.bizvane.mktcenterservice.interfaces.TaskProfileService;
import com.bizvane.mktcenterservice.models.bo.TaskBO;
import com.bizvane.mktcenterservice.models.po.MktCouponPO;
import com.bizvane.mktcenterservice.models.po.MktMessagePO;
import com.bizvane.mktcenterservice.models.vo.MessageVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterservice.models.vo.ProfileSuccessVO;
import com.bizvane.mktcenterservice.models.vo.TaskVO;
import com.bizvane.mktcenterserviceimpl.common.constants.SystemConstants;
import com.bizvane.mktcenterserviceimpl.common.enums.TaskTypeEnum;
import com.bizvane.mktcenterserviceimpl.common.utils.TaskParamCheckUtil;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.utils.tokens.TokenUtils;
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
     * 获取品牌下 完善资料的字段code和名称
     * @param sysBrandId
     * @return
     */
    @RequestMapping("getMemberField")
    public  ResponseData<List<ExtendPropertyVO>> getMemberField(Long sysBrandId){
        return taskProfileService.getMemberField(sysBrandId);
    }

    /**
     * 创建任务
     * @return
     */
    @RequestMapping("addTask")
    public ResponseData<Integer> addTask(TaskBO bo, HttpServletRequest request) throws ParseException {
        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        return  taskProfileService.addTask(bo, stageUser);

    }

    /**
     * 修改任务
     * @param bo
     * @param request
     * @return
     */
    @RequestMapping("updateTask")
    public ResponseData<Integer> updateTask(TaskBO bo, HttpServletRequest request){
        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        return taskProfileService.updateTask(bo,stageUser);
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
    public ResponseData getTaskProfileRecordByTime(String date1, String date2, HttpServletRequest request, PageForm pageForm)throws Exception{

        SysAccountPO stageUser = TokenUtils.getStageUser(request);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date timeStart = simpleDateFormat.parse(date1);

        Date timeEnd = simpleDateFormat.parse(date2);
        return taskProfileService.getTaskProfileRecordByTime(timeStart,timeEnd,stageUser,pageForm);
    }
    /**
     * 执行完善资料的任务奖励
     */
    @RequestMapping("doAwardProfile")
    public  void   doAwardProfile(ProfileSuccessVO vo){
        taskProfileService.doAwardProfile(vo);
    }
}

