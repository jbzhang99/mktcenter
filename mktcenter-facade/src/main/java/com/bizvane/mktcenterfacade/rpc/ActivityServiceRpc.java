package com.bizvane.mktcenterfacade.rpc;

import com.bizvane.centerstageservice.models.po.SysCheckPo;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.mktcenterfacade.models.responsevo.StoreActivityResponseVO;
import com.bizvane.mktcenterfacade.models.vo.*;
import com.bizvane.mktcenterfacade.models.bo.ActivityBO;
import com.bizvane.mktcenterfacade.models.bo.ActivityEvaluationBO;
import com.bizvane.mktcenterfacade.models.po.MktActivityRecordPO;
import com.bizvane.utils.responseinfo.ResponseData;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by agan on 2018/7/27.
 */
@FeignClient(value = "${feign.client.mktcenter.name}",path = "${feign.client.mktcenter.path}/activityRpc")
public interface ActivityServiceRpc {
 /**
  * 审核
  *
  * @param
  * @return
  */
 @RequestMapping("checkActivityById")
 ResponseData<Integer> checkActivityByIdRpc(@RequestBody SysCheckPo po);

 /**
  * 禁用/启用活动
  *
  * @param vo
  * @return
  */
 @RequestMapping("updateActivityById")
 public ResponseData<Integer> updateActivityById(@RequestBody ActivityVO vo);

 /**
  * 查询开卡活动详情
  *
  * @param activityCode
  * @return
  */
 @RequestMapping("selectActivityRegisterById")
 public ResponseData<ActivityBO> selectActivityRegisterById(@RequestParam("activityCode") String activityCode);

 /**
  * 查询活动详情
  *
  * @param activityCode
  * @return
  */
 @RequestMapping("selectActivityOrderById")
 public ResponseData<ActivityBO> selectActivityOrderById(@RequestParam("activityCode") String activityCode);

 /**
  * 查询活动详情
  *
  * @param activityCode
  * @return
  */
 @RequestMapping("selectActivityUpgradesById")
 ResponseData<ActivityBO> selectActivityUpgradesById(@RequestParam("activityCode") String activityCode);

 /**
  * 小程序端活动列表
  *
  * @param vo
  * @return
  */
// @RequestMapping("getActivityList")
// ResponseData<List<ActivityVO>> getActivityList(@RequestBody ActivityVO vo);

 @RequestMapping("getActivityList")
 public ResponseData<PageInfo<StoreActivityResponseVO>> getActivityList(StoreActivityVO storeActivityVO);

 /**
  * 签到列表
  * @param vo
  * @return
  */
 @RequestMapping("getActivityRecordPOList")
 public ResponseData<List<MktActivityRecordPO>> getActivityRecordPOList(@RequestBody MktActivityRecordVO vo);
 /**
  * 执行签到活动
  * @param
  * @return
  */
 @RequestMapping("executeActivitySignin")
 public ResponseData<Integer> executeActivitySignin(@RequestBody MemberInfoModel vo);

 /**
  * 执行评价奖励活动
  * @param vo
  * @return
  */
 @RequestMapping("executeEvaluationActivity")
 public ResponseData<Integer> executeActivityEvaluation(@RequestBody ActivityEvaluationBO bo);

 /**
  * 执行开卡活动
  * @param vo
  * @return
  */
 @RequestMapping("executeRegisterActivity")
 ResponseData<Integer> executeRegisterActivity(@RequestBody MemberInfoModelVOActivity vo);

 /**
  * 升级活动
  * @param vo
  * @return
  */
 @RequestMapping("executeUpgrades")
 ResponseData<Integer> executeUpgrades(@RequestBody MemberInfoModel vo);

 @RequestMapping("judgeMember")
 public  ResponseData<Integer> judgeMember(@RequestBody JudgeMemberVO vo);
}
