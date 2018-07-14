package com.bizvane.mktcenterserviceimpl.controllers;

import com.bizvane.mktcenterservice.interfaces.ActivityRegisterService;
import com.bizvane.mktcenterservice.models.bo.ActivityBO;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterserviceimpl.common.constants.SystemConstants;
import com.bizvane.mktcenterserviceimpl.common.utils.ActivityParamCheckUtil;
import com.bizvane.utils.commonutils.PageForm;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.utils.tokens.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chen.li
 * @date on 2018/7/13 13:37
 * @description 开卡活动
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@RestController
@RequestMapping("activityRegister")
public class ActivityRegisterController {

    @Autowired
    private ActivityRegisterService activityRegisterService;

    /**
     * 查询活动列表
     * @return
     */
    @RequestMapping("getActivityList")
    public ResponseData<ActivityVO> getActivityList(ActivityVO vo, PageForm pageForm){
        ResponseData<ActivityVO> activityRegisterList = activityRegisterService.getActivityList(vo, pageForm);
        return activityRegisterList;
    }

    /**
     * 创建活动
     * @return
     */
    @RequestMapping("addActivity")
    public ResponseData<Integer> addActivity(@RequestBody ActivityBO bo, HttpServletRequest request){
        //参数校验
        ResponseData responseData = ActivityParamCheckUtil.checkParam(bo);
        //参数校验不通过
        if(SystemConstants.ERROR_CODE==responseData.getCode()){
            return responseData;
        }
        //参数校验通过，获取操作人信息
//        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        SysAccountPO stageUser = new SysAccountPO();

        //新增活动
        ResponseData<Integer> integerResponseData = activityRegisterService.addActivity(bo, stageUser);

        //返回
        return integerResponseData;
    }

    /**
     * 修改活动
     * @param bo
     * @return
     */
    public ResponseData<Integer> updateActivity(@RequestBody ActivityBO bo){
        //参数校验
        ResponseData responseData = ActivityParamCheckUtil.checkParam(bo);
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
}
