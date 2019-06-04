package com.bizvane.mktcenterservice.controllers.rpc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bizvane.mktcenterfacade.interfaces.ActivityOrderService;
import com.bizvane.mktcenterfacade.models.bo.OrderModelBo;
import com.bizvane.mktcenterfacade.rpc.ActivityExecuteServiceFeign;
import com.bizvane.utils.responseinfo.ResponseData;
@RestController
@RequestMapping("activityExecuteFeign")
public class ActivityExecuteFeignController implements ActivityExecuteServiceFeign {

  @Autowired
  private ActivityOrderService activityOrderService;
  @Override
  public ResponseData<Integer> order(@RequestBody OrderModelBo vo) {
    // TODO Auto-generated method stub
    return activityOrderService.executeOrder(vo);
  }

}
