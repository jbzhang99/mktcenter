package com.bizvane.mktcenterservice.controllers;

import com.bizvane.mktcenterfacade.interfaces.ActivityOrderService;
import com.bizvane.mktcenterfacade.models.bo.ActivityBO;
import com.bizvane.mktcenterfacade.models.bo.OrderModelBo;
import com.bizvane.mktcenterfacade.models.po.MktCouponPO;
import com.bizvane.mktcenterfacade.models.po.MktMessagePO;
import com.bizvane.mktcenterfacade.models.vo.ActivityVO;
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
 * @description
 *
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
    public ResponseData<ActivityVO> getActivityOrderList(ActivityVO vo, PageForm pageForm,HttpServletRequest request){
        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        ResponseData<ActivityVO> activityOrderList = activityOrderService.getActivityOrderList(vo, pageForm,stageUser);
        return activityOrderList;
    }

    /**
     * 创建活动
     * @return
     */
    @RequestMapping("addActivityOrder")
    public ResponseData<Integer> addActivityOrder(ActivityBO bo, HttpServletRequest request){
      /*  //参数校验
        ResponseData responseData = ActivityParamCheckUtil.checkParam(bo);
        //参数校验不通过
        if(SystemConstants.ERROR_CODE==responseData.getCode()){
            return responseData;
        }*/
        //参数校验通过，获取操作人信息
        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        //SysAccountPO stageUser = new SysAccountPO();

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
