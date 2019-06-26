package com.bizvane.mktcenterfacade.rpc;

import com.bizvane.mktcenterfacade.models.bo.ActivityEvaluationBO;
import com.bizvane.mktcenterfacade.models.vo.InviteSuccessVO;
import com.bizvane.mktcenterfacade.models.vo.MemberInfoModelVOActivity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bizvane.mktcenterfacade.models.bo.OrderModelBo;
import com.bizvane.utils.responseinfo.ResponseData;

import javax.validation.Valid;

/**
 * 活动执行
 * @author 董争光
 * 2019年6月4日下午3:51:54
 */
@FeignClient(value = "${feign.client.mktcenter.name}",
  path = "${feign.client.mktcenter.path}/activityExecuteFeign")
public interface ActivityExecuteServiceFeign {

  /**
   * 开卡活动
   * @param vo
   * @return
   */
  @RequestMapping("executeRegisterActivity")
  void executeRegisterActivity(@RequestBody MemberInfoModelVOActivity vo);

  /**
   * 消费活动
   * @param
   * @return
   */
  @RequestMapping("orderAward")
  void executeOrderActivity(@RequestBody OrderModelBo vo);

  /**
   * 评价奖励活动
   * @param
   * @return
   */
  @RequestMapping("evaluationAward")
  void executeEvaluationActivity(@RequestBody ActivityEvaluationBO bo);

  /**
   * 邀请开卡活动
   * @param
   * @return
   */
  @RequestMapping("inviteRegisterAward")
  void executeinviteRegisterActivity(@RequestBody @Valid InviteSuccessVO vo);
}
