package com.bizvane.mktcenterserviceimpl.controllers.rpc;

import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.mktcenterservice.interfaces.*;
import com.bizvane.mktcenterservice.models.bo.ActivityBO;
import com.bizvane.mktcenterservice.models.po.MktActivityPOWithBLOBs;
import com.bizvane.mktcenterservice.models.po.MktActivityRecordPO;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.models.vo.MktActivityRecordVO;
import com.bizvane.mktcenterserviceimpl.common.enums.ActivityTypeEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/28 9:56
 * @description  活动主体，对外提供
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@RestController
@RequestMapping("activityRpc")
public class ActivityRpcController {

    @Autowired
    private ActivityService activityService;
    @Autowired
    private ActivityUpgradeService activityUpgradeService;
    @Autowired
    private ActivityOrderService activityOrderService;
    @Autowired
    private ActivitySigninService activitySigninService;
    @Autowired
    private ActivityBirthdayService activityBirthdayService;
    @Autowired
    private ActivityRegisterService activityRegisterService;
    @Autowired
    private ActivityRecordService activityRecordService;
    /**
     * 禁用/启用活动
     * @param vo
     * @return
     */
    @RequestMapping("updateActivityById")
    public ResponseData<Integer> updateActivityById(@RequestBody ActivityVO vo, HttpServletRequest request){
        //获取操作人信息
        SysAccountPO stageUser =new SysAccountPO();
//        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        //禁用活动
        ResponseData<Integer> integerResponseData = activityService.updateActivityById(vo, stageUser);
        return integerResponseData;
    }

    /**
     * 活动审核
     * @param
     * @param request
     * @return
     */
    @RequestMapping("checkActivityById")
    public ResponseData<Integer> checkActivityById(@RequestBody MktActivityPOWithBLOBs bs, HttpServletRequest request){
        ResponseData responseData = new ResponseData();
        //获取操作人信息
        SysAccountPO stageUser =new SysAccountPO();
//        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        //开卡活动审核
        if(bs.getActivityType()==ActivityTypeEnum.ACTIVITY_TYPE_REGISGER.getCode()){
            ResponseData<Integer> integerResponseData = activityService.checkActivityById(bs, stageUser);
        }
        //会员升级活动审核
        if(bs.getActivityType()==ActivityTypeEnum.ACTIVITY_TYPE_UPGRADE.getCode()){
            ResponseData<Integer> integerResponseData = activityUpgradeService.checkActivityUpgrades(bs,stageUser);
        }
        //会员生日活动
        if(bs.getActivityType()==ActivityTypeEnum.ACTIVITY_TYPE_BIRTHDAY.getCode()){
            ResponseData<Integer> integerResponseData = activityBirthdayService.checkActivityBirthday(bs,stageUser);
        }
        //会员消费活动审核
        if(bs.getActivityType()==ActivityTypeEnum.ACTIVITY_TYPE_ORDER.getCode()){
            ResponseData<Integer> integerResponseData =activityOrderService.checkActivityOrder(bs,stageUser);
        }
        //会员签到活动审核
        if(bs.getActivityType()==ActivityTypeEnum.ACTIVITY_TYPE_SIGNIN.getCode()){
            ResponseData<Integer> integerResponseData = activitySigninService.checkActivitySignin(bs,stageUser);

        }
        return responseData;
    }
    /**
     * 查询开卡活动详情
     * @param activityCode
     * @return
     */
    @RequestMapping("selectActivityRegisterById")
    public ResponseData<ActivityBO> selectActivityRegisterById(@RequestParam("activityCode") String activityCode){
        return activityRegisterService.selectActivityRegisterById(activityCode);
    }
    /**
     * 查询活动详情
     * @param activityCode
     * @return
     */
    @RequestMapping("selectActivityOrderById")
    public ResponseData<ActivityBO> selectActivityOrderById(@RequestParam("activityCode") String activityCode){
        return activityOrderService.selectActivityOrderById(activityCode);
    }
    /**
     * 查询活动详情
     * @param activityCode
     * @return
     */
    @RequestMapping("selectActivityUpgradesById")
    public ResponseData<ActivityBO> selectActivityUpgradesById(@RequestParam("activityCode") String activityCode){
        return activityUpgradeService.selectActivityUpgradesById(activityCode);
    }
    /**
     * 小程序端活动列表
     * @param vo
     * @return
     */
    @RequestMapping("getActivityList")
    public ResponseData<List<ActivityVO>>  getActivityList(@RequestBody ActivityVO vo){
        return activityService.getActivityList(vo);
    }

    /**
     * 小程序端会员签到
     * @param vo
     * @return
     */
    @RequestMapping("getActivityRecordPOList")
    public ResponseData<List<MktActivityRecordPO>> getActivityRecordPOList(@RequestBody MktActivityRecordVO vo){
        return activityRecordService.getActivityRecordPOList(vo);
    }
    /**
     * 执行活动
     * @param
     * @return
     */
    @RequestMapping("executeActivitySignin")
    public ResponseData<Integer> executeActivitySignin(@RequestBody MemberInfoModel vo){
        return activitySigninService.executeActivitySignin(vo);
    }
}
