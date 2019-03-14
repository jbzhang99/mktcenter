package com.bizvane.couponfacade.interfaces;

import com.bizvane.couponfacade.models.po.CouponManualPO;
import com.bizvane.couponfacade.models.vo.CouponManualVO;
import com.bizvane.utils.responseinfo.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value="${feign.client.coupon.name}",path="${feign.client.coupon.path}/couponManualRpc")
@Api(value = "手工发券",tags = {"API"})
public interface CouponManualServiceFeign {

  @ApiOperation(value = "查询手动发券列表接口", notes = "查询手动发券列表接口", tags = {"手动发券"},httpMethod = "POST")
  @RequestMapping(value="getList", method = RequestMethod.POST)
  ResponseData<CouponManualVO> getListRpc(@RequestBody CouponManualVO vo);

  @ApiOperation(value = "更改发送状态接口", notes = "更改发送状态接口", tags = {"手动发券"},httpMethod = "POST")
  @ApiImplicitParams({
          @ApiImplicitParam(name = "couponManualId", value = "手动发券id", required = true, dataType = "Long"),
          @ApiImplicitParam(name = "taskStatus", value = "审核状态", required = true, dataType = "Byte")
  })
  @RequestMapping(value="changeTask", method = RequestMethod.POST)
  ResponseData<Object> changeTaskRpc(@RequestBody CouponManualPO po);

}
