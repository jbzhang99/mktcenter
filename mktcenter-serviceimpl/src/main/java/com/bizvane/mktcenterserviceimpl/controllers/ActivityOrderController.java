package com.bizvane.mktcenterserviceimpl.controllers;

import com.bizvane.mktcenterservice.interfaces.ActivityOrderService;
import com.bizvane.mktcenterservice.models.bo.ActivityBO;
import com.bizvane.mktcenterservice.models.bo.OrderModelBo;
import com.bizvane.mktcenterservice.models.po.MktCouponPO;
import com.bizvane.mktcenterservice.models.po.MktMessagePO;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.models.vo.MessageVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterserviceimpl.common.constants.SystemConstants;
import com.bizvane.mktcenterserviceimpl.common.utils.ActivityParamCheckUtil;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/13 13:37
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@RestController
@RequestMapping("activityOrder")
public class ActivityOrderController {

    @Autowired
    private ActivityOrderService activityOrderService;

    /**
     * 查询活动列表
     * @return
     */
    @RequestMapping("getActivityOrderList")
    public ResponseData<ActivityVO> getActivityOrderList(ActivityVO vo, PageForm pageForm){
        ResponseData<ActivityVO> activityOrderList = activityOrderService.getActivityOrderList(vo, pageForm);
        return activityOrderList;
    }

    /**
     * 创建活动
     * @return
     */
    @RequestMapping("addActivityOrder.do")
    public ResponseData<Integer> addActivityOrder(ActivityVO activityVO, List<MktCouponPO> couponCodeList, List<MktMessagePO> messageVOList, HttpServletRequest request){
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
//        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        SysAccountPO stageUser = new SysAccountPO();

        //新增活动
        ResponseData<Integer> integerResponseData = activityOrderService.addActivityOrder(bo, stageUser);

        //返回
        return integerResponseData;
    }

    /**
     * 查询活动详情
     * @param businessCode
     * @return
     */
    @RequestMapping("selectActivityOrderById")
    public ResponseData<ActivityBO> selectActivityOrderById(String businessCode){
        return activityOrderService.selectActivityOrderById(businessCode);
    }
    /**
     * 修改活动
     * @return
     */
    public ResponseData<Integer> updateActivityOrder(ActivityVO activityVO, List<MktCouponPO> couponCodeList, List<MktMessagePO> messageVOList, HttpServletRequest request){
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
        ResponseData<Integer> order = activityOrderService.updateActivityOrder(bo,stageUser);
        return order;
    }
    /**
     * 执行活动
     * @param
     * @return
     */
    @RequestMapping("executeOrder")
    public ResponseData<Integer> executeOrder(OrderModelBo vo){
        return activityOrderService.executeOrder(vo);
    }
}
