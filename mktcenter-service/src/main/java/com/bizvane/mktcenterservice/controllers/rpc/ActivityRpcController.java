package com.bizvane.mktcenterservice.controllers.rpc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bizvane.mktcenterfacade.interfaces.ActivityBirthdayService;
import com.bizvane.mktcenterfacade.interfaces.ActivityEvaluationService;
import com.bizvane.mktcenterfacade.interfaces.ActivityManualService;
import com.bizvane.mktcenterfacade.interfaces.ActivityOrderService;
import com.bizvane.mktcenterfacade.interfaces.ActivityRecordService;
import com.bizvane.mktcenterfacade.interfaces.ActivityRegisterService;
import com.bizvane.mktcenterfacade.interfaces.ActivityService;
import com.bizvane.mktcenterfacade.interfaces.ActivityVipAniversaryService;
import com.bizvane.mktcenterfacade.models.bo.ActivityBO;
import com.bizvane.mktcenterfacade.models.bo.ActivityEvaluationBO;
import com.bizvane.mktcenterfacade.models.po.MktActivityRecordPO;
import com.bizvane.mktcenterfacade.models.responsevo.StoreActivityResponseVO;
import com.bizvane.mktcenterfacade.models.vo.ActivityVO;
import com.bizvane.mktcenterfacade.models.vo.JudgeMemberVO;
import com.bizvane.mktcenterfacade.models.vo.MemberInfoModelVOActivity;
import com.bizvane.mktcenterfacade.models.vo.MktActivityRecordVO;
import com.bizvane.mktcenterfacade.models.vo.StoreActivityVO;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.github.pagehelper.PageInfo;

/**
 * @author chen.li
 * @date on 2018/7/28 9:56
 * @description  活动主体，对外提供
 *
 */
@RestController
@RequestMapping("activityRpc")
public class ActivityRpcController {

    @Autowired
    private ActivityService activityService;
    @Autowired
    private ActivityOrderService activityOrderService;
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
     * 小程序端活动列表
     * @param storeActivityVO
     * @return
     */
    @RequestMapping("getActivityList")
    public ResponseData<PageInfo<StoreActivityResponseVO>> getActivityList(@RequestBody StoreActivityVO storeActivityVO){
        return activityService.getActivityList(storeActivityVO);
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
     * 执行评价奖励活动
     * @param
     * @return
     */
    @RequestMapping("/executeEvaluationActivity")
    @io.swagger.annotations.ApiModelProperty(value = "",name = "执行评价送积分活动", required = false,example = "")
    public ResponseData<Integer> executeEvaluationActivity(@Valid @RequestBody ActivityEvaluationBO bo){
        return activityEvaluationService.executeActivityEvaluation(bo);
    }
    @RequestMapping("judgeMember")
    public  ResponseData<Integer> judgeMember(@RequestBody JudgeMemberVO vo){
       return  activityService.judgeMember(vo);
    }
}
