package com.bizvane.mktcenterservice.controllers.rpc;

import com.bizvane.mktcenterfacade.interfaces.ActivityEvaluationService;
import com.bizvane.mktcenterfacade.interfaces.ActivityInviteService;
import com.bizvane.mktcenterfacade.interfaces.ActivityRegisterService;
import com.bizvane.mktcenterfacade.models.bo.ActivityEvaluationBO;
import com.bizvane.mktcenterfacade.models.vo.InviteSuccessVO;
import com.bizvane.mktcenterfacade.models.vo.MemberInfoModelVOActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bizvane.mktcenterfacade.interfaces.ActivityOrderService;
import com.bizvane.mktcenterfacade.models.bo.OrderModelBo;
import com.bizvane.mktcenterfacade.rpc.ActivityExecuteServiceFeign;
import com.bizvane.utils.responseinfo.ResponseData;

import javax.validation.Valid;

@RestController
@RequestMapping("activityExecuteFeign")
public class ActivityExecuteFeignController implements ActivityExecuteServiceFeign {

  @Autowired
  private ActivityRegisterService activityRegisterService;

  @Autowired
  private ActivityOrderService activityOrderService;

  @Autowired
  private ActivityEvaluationService activityEvaluationService;

  @Autowired
  private ActivityInviteService activityInviteService;

  @Override
  public void executeRegisterActivity(@RequestBody MemberInfoModelVOActivity vo){
    activityRegisterService.executeRegisterActivity(vo);
  }

  @Override
  public void executeOrderActivity(@RequestBody OrderModelBo bo) {
     activityOrderService.award(bo);
  }

  @Override
  public void executeEvaluationActivity(@RequestBody ActivityEvaluationBO bo) {
    activityEvaluationService.executeActivityEvaluation(bo);
  }

  @Override
  public void executeinviteRegisterActivity(@RequestBody @Valid InviteSuccessVO vo) {
     activityInviteService.award(vo);
  }

}
