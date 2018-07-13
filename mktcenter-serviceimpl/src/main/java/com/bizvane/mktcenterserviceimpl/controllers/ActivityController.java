package com.bizvane.mktcenterserviceimpl.controllers;

import com.bizvane.mktcenterservice.interfaces.ActivityService;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterserviceimpl.common.constants.ActivityConstants;
import com.bizvane.mktcenterserviceimpl.common.constants.SystemConstants;
import com.bizvane.mktcenterserviceimpl.common.enums.ActivityTypeEnum;
import com.bizvane.mktcenterserviceimpl.common.utils.ActivityParamCheckUtil;
import com.bizvane.utils.constants.SysConstants;
import com.bizvane.utils.jobutils.JobClient;
import com.bizvane.utils.jobutils.XxlJobInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.utils.tokens.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chen.li
 * @date on 2018/7/6 15:12
 * @description 营销活动
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@RestController
@RequestMapping("activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private JobClient jobClient;

    /**
     * 查询活动列表
     * @return
     */
    @RequestMapping("getActivityList")
    public ResponseData<ActivityVO> getActivityList(ActivityVO vo){
        //参数校验
        ResponseData responseData = ActivityParamCheckUtil.checkParam(vo);
        //参数校验不通过
        if(SystemConstants.ERROR_CODE==responseData.getCode()){
            return responseData;
        }
        //参数校验通过，获取操作人信息

        //新增活动

        //判断活动开始时间，是否需要添加job调度

        //返回

        return null;
    }

    /**
     * 创建活动
     * @return
     */
    @RequestMapping("addActivity")
    public ResponseData<Integer> addActivity(ActivityVO vo){
        //参数校验
        ResponseData responseData = ActivityParamCheckUtil.checkParam(vo);
        //参数校验不通过
        if(SystemConstants.ERROR_CODE==responseData.getCode()){
            return responseData;
        }
        //参数校验通过，获取操作人信息

        //新增活动

        //判断活动开始时间，是否需要添加job调度

        //返回

        return null;
    }

    /**
     * 修改活动
     * @param vo
     * @return
     */
    public ResponseData<Integer> updateActivity(ActivityVO vo){
        //参数校验
        ResponseData responseData = ActivityParamCheckUtil.checkParam(vo);
        //参数校验不通过
        if(SystemConstants.ERROR_CODE==responseData.getCode()){
            return responseData;
        }
        //参数校验通过，获取操作人信息

        //更新活动

        //判断活动开始时间，是否需要修改job调度

        //返回

        return null;
    }

    /**
     * 禁用活动
     * @param mktActivityId
     * @return
     */
    @RequestMapping("stopActivityById")
    public ResponseData<Integer> stopActivityById(Long mktActivityId, HttpServletRequest request){
        //获取操作人信息
        SysAccountPO stageUser =new SysAccountPO();
//        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        //禁用活动
        ResponseData<Integer> integerResponseData = activityService.stopActivityById(mktActivityId, stageUser);
        return integerResponseData;
    }
}
