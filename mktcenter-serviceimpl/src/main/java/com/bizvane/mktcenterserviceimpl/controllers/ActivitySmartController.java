package com.bizvane.mktcenterserviceimpl.controllers;

import com.bizvane.mktcenterservice.interfaces.ActivitySmartService;
import com.bizvane.mktcenterservice.models.po.MktActivitySmartPO;
import com.bizvane.mktcenterservice.models.po.MktCouponPO;
import com.bizvane.mktcenterservice.models.vo.ActivitySmartVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterserviceimpl.common.utils.ActivityParamCheckUtil;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/13 13:37
 * @description 智能营销
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@RestController
@RequestMapping("activitySmart")
public class ActivitySmartController {

    @Autowired
    private ActivitySmartService activitySmartService;

    /**
     * 查询智能营销活动列表(方块)
     * @return
     */
    @RequestMapping("getActivityList")
    public ResponseData<List<ActivitySmartVO>> getActivityList(ActivitySmartVO vo){
        return activitySmartService.getActivityList(vo);
    }

    /**
     * 查询历史营销活动列表
     * @return
     */
    @RequestMapping("getActivityHistoryList")
    public ResponseData<PageInfo<MktActivitySmartPO>> getActivityHistoryList(ActivitySmartVO vo, PageForm pageForm){
        return activitySmartService.getActivityHistoryList(vo, pageForm);
    }

    /**
     * 对某个智能营销组创建任务
     * 任务类型：1优惠券营销
     * @return
     */
    @RequestMapping("addCouponActivity")
    public ResponseData<Integer> addCouponActivity(ActivitySmartVO vo, List<MktCouponPO> couponCodeList, HttpServletRequest request){
        //获取操作人信息
//        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        SysAccountPO stageUser = new SysAccountPO();
        ResponseData<Integer> responseData = activitySmartService.addCouponActivity(vo, couponCodeList, stageUser);
        return responseData;
    }

    /**
     * 对某个智能营销组创建任务
     * 任务类型：2积分营销
     * @return
     */
    @RequestMapping("addIntegralActivity")
    public ResponseData<Integer> addIntegralActivity(ActivitySmartVO vo, HttpServletRequest request){
        //参数校验
        ResponseData responseData = ActivityParamCheckUtil.checkSmartActivityParam(vo);
        //参数校验通过，获取操作人信息
//        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        SysAccountPO stageUser = new SysAccountPO();
        return new ResponseData<>();
    }

    /**
     * 对某个智能营销组创建任务
     * 任务类型：3短信营销
     * @return
     */
    @RequestMapping("addSmsActivity")
    public ResponseData<Integer> addSmsActivity(ActivitySmartVO vo, HttpServletRequest request){
        //参数校验
        ResponseData responseData = ActivityParamCheckUtil.checkSmartActivityParam(vo);
        //参数校验通过，获取操作人信息
//        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        SysAccountPO stageUser = new SysAccountPO();
        return new ResponseData<>();
    }

    /**
     * 对某个智能营销组创建任务
     * 任务类型：4微信模板消息营销
     * @return
     */
    @RequestMapping("addTemplateMsgActivity")
    public ResponseData<Integer> addTemplateMsgActivity(ActivitySmartVO vo, HttpServletRequest request){
        //参数校验
        ResponseData responseData = ActivityParamCheckUtil.checkSmartActivityParam(vo);
        //参数校验通过，获取操作人信息
//        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        SysAccountPO stageUser = new SysAccountPO();
        return new ResponseData<>();
    }
}
