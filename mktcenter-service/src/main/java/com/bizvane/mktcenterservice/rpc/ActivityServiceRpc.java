package com.bizvane.mktcenterservice.rpc;

import com.bizvane.centerstageservice.models.po.SysCheckPo;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.mktcenterservice.models.bo.ActivityBO;
import com.bizvane.mktcenterservice.models.po.MktActivityRecordPO;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.models.vo.MktActivityRecordVO;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by agan on 2018/7/27.
 */
@FeignClient("${feign.client.mktcenter.name}")
@RequestMapping("${feign.client.mktcenter.path}/activityRpc")
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
 @RequestMapping("getActivityList")
 ResponseData<List<ActivityVO>> getActivityList(@RequestBody ActivityVO vo);

 /**
  * 签到列表
  * @param vo
  * @return
  */
 @RequestMapping("getActivityRecordPOList")
 public ResponseData<List<MktActivityRecordPO>> getActivityRecordPOList(@RequestBody MktActivityRecordVO vo);
 /**
  * 执行活动
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
 public ResponseData<Integer> executeActivityEvaluation(@RequestBody MemberInfoModel vo);

 /**
  * 执行开卡活动
  * @param vo
  * @return
  */
 @RequestMapping("executeActivity")
 ResponseData<Integer> executeActivity(@RequestBody MemberInfoModel vo);
}
