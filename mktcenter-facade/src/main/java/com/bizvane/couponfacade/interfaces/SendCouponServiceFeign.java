package com.bizvane.couponfacade.interfaces;

import com.bizvane.couponfacade.models.vo.SendCouponBatchRequestVO;
import com.bizvane.couponfacade.models.vo.SendCouponQuotaBatchRequestVO;
import com.bizvane.couponfacade.models.vo.SendCouponSimpleRequestVO;
import com.bizvane.utils.responseinfo.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="${feign.client.mktcenter.name}",path="${feign.client.mktcenter.path}/sendCoupon")
@Api(value = "发券",tags = {"API"})
public interface SendCouponServiceFeign {
    
    /**
     * 单张发券
     * @return
     */
    @ApiOperation(value = "单张发券接口", notes = "单张发券接口", tags = {"券消息配置"},httpMethod = "POST")
    @RequestMapping(value="/simple", method = RequestMethod.POST)
    ResponseData<String> simple(@RequestBody(required = false) SendCouponSimpleRequestVO vo);
    
    /**
     * 批量发券
     * @return
     */
    /*@ApiOperation(value = "批量发券接口", notes = "批量发券接口", tags = {"券消息配置"},httpMethod = "POST")
    @RequestMapping(value="/batch", method = RequestMethod.POST)
    ResponseData<Object> batch(@RequestBody SendCouponBatchRequestVO vo);*/


    /**
     * 批量发券
     * @return
     */
    @ApiOperation(value = "批量发券接口", notes = "批量发券接口", tags = {"券消息配置"},httpMethod = "POST")
    @RequestMapping(value="/batchRpc", method = RequestMethod.POST)
    ResponseData<Object> batchCoupon(@RequestBody SendCouponBatchRequestVO vo);
    
    
    /**
     * 批量发券
     * @return
     */
    @ApiOperation(value = "企业微信批量发券接口", notes = "企业微信批量发券接口", tags = {"券消息配置"},httpMethod = "POST")
    @RequestMapping(value="/couponQuotaBatchRpc", method = RequestMethod.POST)
    ResponseData<Object> couponQuotaBatchRpc(@RequestBody SendCouponQuotaBatchRequestVO vo);


    /**
     * 券到期提醒
     * @param expireDay
     * @return
     */
    @ApiOperation(value = "券到期提醒", notes = "券到期提醒", tags = {"发券"},httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "expireDay", value = "过期时间", required = true, dataType = "String")
    })
    @RequestMapping("/expire")
    public ResponseData<Integer> expire(@RequestParam(value = "expireDay", required = false) String expireDay);

}
