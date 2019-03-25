package com.bizvane.mktcenterservice.controllers.rpc;

import com.bizvane.centerstageservice.models.po.SysCheckPo;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.mktcenterfacade.interfaces.*;
import com.bizvane.mktcenterfacade.models.bo.ActivityBO;
import com.bizvane.mktcenterfacade.models.po.MktActivityRecordPO;
import com.bizvane.mktcenterfacade.models.vo.ActivityVO;
import com.bizvane.mktcenterfacade.models.vo.JudgeMemberVO;
import com.bizvane.mktcenterfacade.models.vo.MemberInfoModelVOActivity;
import com.bizvane.mktcenterfacade.models.vo.MktActivityRecordVO;
import com.bizvane.mktcenterservice.common.enums.ActivityTypeEnum;
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
    @Autowired
    private ActivityManualService activityManualService;
    @Autowired
    private ActivityEvaluationService activityEvaluationService;
    @Autowired
    private ActivityVipAniversaryService activityVipAniversaryService;


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
    public ResponseData<Integer> checkActivityById(@RequestBody SysCheckPo po, HttpServletRequest request){
        ResponseData responseData = new ResponseData();
        //获取操作人信息
        SysAccountPO stageUser =new SysAccountPO();
//        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        //开卡活动审核
        if(po.getBusinessType()==ActivityTypeEnum.ACTIVITY_TYPE_REGISGER.getCode()){
            responseData = activityService.checkActivityById(po, stageUser);
        }
        //会员升级活动审核
        if(po.getBusinessType()==ActivityTypeEnum.ACTIVITY_TYPE_UPGRADE.getCode()){
            responseData = activityUpgradeService.checkActivityUpgrades(po,stageUser);
        }
        //会员生日活动
        if(po.getBusinessType()==ActivityTypeEnum.ACTIVITY_TYPE_BIRTHDAY.getCode()){
            responseData = activityBirthdayService.checkActivityBirthday(po,stageUser);
        }
        //会员消费活动审核
        if(po.getBusinessType()==ActivityTypeEnum.ACTIVITY_TYPE_ORDER.getCode()){
            responseData =activityOrderService.checkActivityOrder(po,stageUser);
        }
        //会员签到活动审核
        if(po.getBusinessType()==ActivityTypeEnum.ACTIVITY_TYPE_SIGNIN.getCode()){
            responseData = activitySigninService.checkActivitySignin(po,stageUser);

        }
        //扫码领券&手动领券审核
        if(po.getBusinessType()==ActivityTypeEnum.ACTIVITY_TYPE_QRCODE.getCode()||po.getBusinessType()==ActivityTypeEnum.ACTIVITY_TYPE_MANUAL.getCode()){
            responseData = activityManualService.checkActivity(po,stageUser);

        }
        //入会纪念日活动审核
        if(po.getBusinessType()==ActivityTypeEnum.ACTIVITY_TYPE_ANNIVERSARY.getCode()){
            responseData = activityVipAniversaryService.checkActivityVipAniversary(po,stageUser);
        }
        //评价奖励活动审核
        if(po.getBusinessType()==ActivityTypeEnum.ACTIVITY_TYPE_EVALUATION.getCode()){
            responseData = activityEvaluationService.checkActivityEvaluation(po,stageUser);
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
     * 执行活动签到
     * @param
     * @return
     */
    @RequestMapping("executeActivitySignin")
    public ResponseData<Integer> executeActivitySignin(@RequestBody MemberInfoModel vo){
        return activitySigninService.executeActivitySignin(vo);
    }

    /**
     * 执行评价奖励活动
     * @param
     * @return
     */
    @RequestMapping("/executeEvaluationActivity")
    @io.swagger.annotations.ApiModelProperty(value = "",name = "执行评价送积分活动", required = false,example = "")
    public ResponseData<Integer> executeEvaluationActivity(@RequestBody MemberInfoModel vo){
        return activityEvaluationService.executeActivityEvaluation(vo);
    }

    /**
     * 执行活动开卡
     * @param
     * @return
     */
    @RequestMapping("executeActivity")
    public ResponseData<Integer> executeActivity(@RequestBody MemberInfoModelVOActivity vo){
        return activityRegisterService.executeActivity(vo);
    }

    /**
     * 执行活动
     * @param vo
     * @return
     */
    @RequestMapping("executeUpgrades")
    public ResponseData<Integer> executeUpgrades(@RequestBody MemberInfoModel vo){
        return activityUpgradeService.executeUpgrades(vo);
    }

    @RequestMapping("judgeMember")
    public  ResponseData<Integer> judgeMember(@RequestBody JudgeMemberVO vo){
       return  activityService.judgeMember(vo);
    }
}
