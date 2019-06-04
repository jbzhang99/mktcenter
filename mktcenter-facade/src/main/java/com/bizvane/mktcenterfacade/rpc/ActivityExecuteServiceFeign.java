package com.bizvane.mktcenterfacade.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bizvane.mktcenterfacade.models.bo.OrderModelBo;
import com.bizvane.utils.responseinfo.ResponseData;

/**
 * 活动执行
 * @author 董争光
 * 2019年6月4日下午3:51:54
 */
@FeignClient(value = "${feign.client.mktcenter.name}",
  path = "${feign.client.mktcenter.path}/activityExecuteFeign")
public interface ActivityExecuteServiceFeign {

  /**
   * 消费活动
   * @param
   * @return
   */
  @RequestMapping("order")
  ResponseData<Integer> order(@RequestBody OrderModelBo vo);
}
