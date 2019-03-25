package com.bizvane.mktcenterservice.controllers;

import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.mktcenterfacade.interfaces.ActivityUpgradeService;
import com.bizvane.mktcenterfacade.models.bo.ActivityBO;
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
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@RestController
@RequestMapping("activityUpgrade")
public class ActivityUpgradeController {

    @Autowired
    private ActivityUpgradeService activityUpgradeService;

    /**
     * 查询活动列表
     * @return
     */
    @RequestMapping("getActivityUpgradeList")
    public ResponseData<ActivityVO> getActivityUpgradeList(ActivityVO vo, PageForm pageForm,HttpServletRequest request){
        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        ResponseData<ActivityVO> activityUpgradeList = activityUpgradeService.getActivityUpgradeList(vo, pageForm,stageUser);
        return activityUpgradeList;
    }
    /**
     * 创建活动
     * @return
     */
    @RequestMapping("addActivityUpgrade")
    public ResponseData<Integer> addActivityUpgrade(ActivityBO bo, HttpServletRequest request){
        //参数校验
    /*    ResponseData responseData = ActivityParamCheckUtil.checkParam(bo);
        //参数校验不通过
        if(SystemConstants.ERROR_CODE==responseData.getCode()){
            return responseData;
        }*/
        //参数校验通过，获取操作人信息
        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        //SysAccountPO stageUser = new SysAccountPO();

        //新增活动
        ResponseData<Integer> integerResponseData = activityUpgradeService.addActivityUpgrade(bo, stageUser);

        //返回
        return integerResponseData;
    }

    /**
     * 修改活动
     * @return
     */
    @RequestMapping("updateActivityUpgrade.do")
    public ResponseData<Integer> updateActivityUpgrade(ActivityVO activityVO, List<MktCouponPO> couponCodeList, List<MktMessagePO> messageVOList, HttpServletRequest request){
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
        ResponseData<Integer> upgradeData = activityUpgradeService.updateActivityUpgrade(bo,stageUser);

        //返回

        return upgradeData;
    }

    /**
     * 查询活动详情
     * @param businessCode
     * @return
     */
    @RequestMapping("selectActivityUpgradesById")
    public ResponseData<ActivityBO> selectActivityUpgradesById(String businessCode){
        return activityUpgradeService.selectActivityUpgradesById(businessCode);
    }
    /**
     * 执行活动
     * @param vo
     * @return
     */
    @RequestMapping("executeUpgrades")
    public ResponseData<Integer> executeUpgrades(MemberInfoModel vo){
        return activityUpgradeService.executeUpgrades(vo);
    }
}
