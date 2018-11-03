package com.bizvane.mktcenterserviceimpl.controllers;

import com.bizvane.mktcenterservice.interfaces.ActivityBirthdayService;
import com.bizvane.mktcenterservice.models.bo.ActivityBO;
import com.bizvane.mktcenterservice.models.po.MktCouponPO;
import com.bizvane.mktcenterservice.models.po.MktMessagePO;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.models.vo.MessageVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterserviceimpl.common.constants.SystemConstants;
import com.bizvane.mktcenterserviceimpl.common.utils.ActivityParamCheckUtil;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.utils.tokens.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/13 13:36
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@RestController
@RequestMapping("activityBirthday")
public class ActivityBirthdayController {

    @Autowired
    private ActivityBirthdayService activityBirthdayService;

    /**
     * 查询活动列表
     * @return
     */
    @RequestMapping("getActivityBirthdayList")
    public ResponseData<ActivityVO> getActivityBirthdayList(ActivityVO vo, PageForm pageForm,HttpServletRequest request){
        //参数校验通过，获取操作人信息
        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        ResponseData<ActivityVO> activityBirthdayList = activityBirthdayService.getActivityBirthdayList(vo, pageForm,stageUser);
        return activityBirthdayList;
    }
    /**
     * 创建活动
     * @return
     */
    @RequestMapping("addActivityBirthday")
    public ResponseData<Integer> addActivityBirthday(ActivityBO bo, HttpServletRequest request){
        /*ActivityBO bo = new ActivityBO();
        bo.setActivityVO(activityVO);
        bo.setCouponCodeList(couponCodeList);
        bo.setMessageVOList(messageVOList);
        //参数校验
        ResponseData responseData = ActivityParamCheckUtil.checkParam(bo);
        //参数校验不通过
        if(SystemConstants.ERROR_CODE==responseData.getCode()){
            return responseData;
        }*/
        //参数校验通过，获取操作人信息
        SysAccountPO stageUser = TokenUtils.getStageUser(request);

        //新增活动
        ResponseData<Integer> integerResponseData = activityBirthdayService.addActivityBirthday(bo, stageUser);

        //返回
        return integerResponseData;
    }
    /**
     * 查询活动详情
     * @param businessCode
     * @return
     */
    @RequestMapping("selectActivityBirthdayById")
    public ResponseData<ActivityBO> selectActivityBirthdayById(String businessCode){
        return activityBirthdayService.selectActivityBirthdayById(businessCode);
    }
    /**
     * 修改活动
     * @param
     * @return
     */
    @RequestMapping("updateActivityBirthday")
    public ResponseData<Integer> updateActivityBirthday(ActivityVO activityVO, List<MktCouponPO> couponCodeList, List<MktMessagePO> messageVOList, HttpServletRequest request){
        ActivityBO bo = new ActivityBO();
        bo.setActivityVO(activityVO);
        bo.setCouponCodeList(couponCodeList);
        bo.setMessageVOList(messageVOList);
        //参数校验
        ResponseData responseData = ActivityParamCheckUtil.checkParam(bo);
        //参数校验不通过
        if(SystemConstants.ERROR_CODE==responseData.getCode()){
            return responseData;
        }
        //参数校验通过，获取操作人信息
        SysAccountPO stageUser = new SysAccountPO();
        //更新活动
        ResponseData<Integer> registerData = activityBirthdayService.updateActivityBirthday(bo,stageUser);

        //返回

        return registerData;
    }
}
