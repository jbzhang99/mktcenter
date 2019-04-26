package com.bizvane.mktcenterservice.controllers;

import com.bizvane.mktcenterfacade.interfaces.ActivityRegisterService;
import com.bizvane.mktcenterfacade.models.bo.ActivityBO;
import com.bizvane.mktcenterfacade.models.po.MktCouponPO;
import com.bizvane.mktcenterfacade.models.po.MktMessagePO;
import com.bizvane.mktcenterfacade.models.vo.ActivityVO;
import com.bizvane.mktcenterfacade.models.vo.MemberInfoModelVOActivity;
import com.bizvane.mktcenterfacade.models.vo.PageForm;
import com.bizvane.mktcenterservice.common.constants.SystemConstants;
import com.bizvane.mktcenterservice.common.utils.ActivityParamCheckUtil;
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
 * @date on 2018/7/13 13:37
 * @description 开卡活动
 *
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
    public ResponseData<ActivityVO> getActivityList(ActivityVO vo, PageForm pageForm,HttpServletRequest request){
        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        ResponseData<ActivityVO> activityRegisterList = activityRegisterService.getActivityList(vo, pageForm,stageUser);
        return activityRegisterList;
    }

    /**
     * 创建活动
     * @return
     */
    @RequestMapping("addActivity")
    public ResponseData<Integer> addActivity(ActivityBO bo, HttpServletRequest request){
    /*    ActivityBO bo = new ActivityBO();
        bo.setActivityVO(activityVO);
        bo.setCouponCodeList(couponCodeList);
        bo.setMessageVOList(messageVOList);*/
        //参数校验
     /*   ResponseData responseData = ActivityParamCheckUtil.checkParam(bo);
        //参数校验不通过
        if(SystemConstants.ERROR_CODE==responseData.getCode()){
            return responseData;
        }*/
        //参数校验通过，获取操作人信息
        SysAccountPO stageUser = TokenUtils.getStageUser(request);

        //新增活动
        ResponseData<Integer> integerResponseData = activityRegisterService.addActivity(bo, stageUser);

        //返回
        return integerResponseData;
    }

    /**
     * 修改活动
     * @param
     * @return
     */
    @RequestMapping("updateActivityRegister")
    public ResponseData<Integer> updateActivityRegister(ActivityVO activityVO, List<MktCouponPO> couponCodeList, List<MktMessagePO> messageVOList, HttpServletRequest request){
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
        ResponseData<Integer> registerData = activityRegisterService.updateActivityRegister(bo,stageUser);

        //返回

        return registerData;
    }
    /**
     * 执行活动
     * @param
     * @return
     */
    @RequestMapping("executeActivity")
    public ResponseData<Integer> executeActivity(MemberInfoModelVOActivity vo){
        return activityRegisterService.executeActivity(vo);
    }
    /**
     * 查询活动详情
     * @param businessCode
     * @return
     */
    @RequestMapping("selectActivityRegisterById")
    public ResponseData<ActivityBO> selectActivityRegisterById(String businessCode){
        return activityRegisterService.selectActivityRegisterById(businessCode);
    }
}
