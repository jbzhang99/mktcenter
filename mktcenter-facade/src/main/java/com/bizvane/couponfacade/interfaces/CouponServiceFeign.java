package com.bizvane.couponfacade.interfaces;

import com.bizvane.couponfacade.models.vo.*;
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

@FeignClient(value="${feign.client.mktcenter.name}",path="${feign.client.mktcenter.path}/couponRpc")
@Api("券管理")
public interface CouponServiceFeign {


  /**
   * 根据券号使用优惠券接口(核销)
   * @param requestVO
   * @return
   */
  @ApiOperation(value = "根据券号使用优惠券接口(核销)", notes = "根据券号使用优惠券接口", tags = {"券操作接口"},httpMethod = "POST")
  @RequestMapping(value="/use", method = RequestMethod.POST)
  ResponseData<String> use(@RequestBody(required = false) CouponUseVO requestVO);

  /**
   * 企业微信券核销
   * @param requestVO
   * @return
   */
  @ApiOperation(value = "企业微信券核销", notes = "企业微信券核销", tags = {"券操作接口"},httpMethod = "POST")
  @RequestMapping(value="/wechatEnterpriseUse", method = RequestMethod.POST)
  ResponseData<String> wechatEnterpriseUse(@RequestBody(required = false) CouponUseVO requestVO);


  /**
   * 线上使用优惠券
   * @param vo
   * @return
   */
  @ApiOperation(value = "线上使用优惠券接口", notes = "线上使用优惠券接口", tags = {"券消息配置"},httpMethod = "POST")
  @RequestMapping(value="/onlineUse", method = RequestMethod.POST)
  ResponseData<Object> onlineUse(@RequestBody CouponOnlineUseRequestVO vo);

  /**
   * 线下使用优惠券
   * @param vo
   * @return
   */
  @ApiOperation(value = "线下使用优惠券接口", notes = "线下使用优惠券接口", tags = {"券消息配置"},httpMethod = "POST")
  @RequestMapping(value="/offlineUse", method = RequestMethod.POST)
  ResponseData<Object> offlineUse(@RequestBody CouponOfflineUseRequestVO vo);


  /**
   * 冲正券接口
   * @param vo
   * @return
   */
  @ApiOperation(value = "冲正券接口", notes = "冲正券接口", tags = {"券消息配置"},httpMethod = "POST")
  @RequestMapping(value="/cancelUse", method = RequestMethod.POST)
  ResponseData<Object> cancelUse(@RequestBody CouponCancelUseRequestVO vo);

  /**
   * 转赠
   * @param vo
   * @return
   */
  @ApiOperation(value = "转赠券接口", notes = "转赠券接口", tags = {"券实例接口"},httpMethod = "POST")
  @ApiImplicitParams({
          @ApiImplicitParam(name = "couponCode", value = "券code", required = true, dataType = "String"),
          @ApiImplicitParam(name = "oldMemberCode", value = "旧会员code", required = true, dataType = "String"),
          @ApiImplicitParam(name = "newMemberCode", value = "新会员code", required = true, dataType = "String"),
          @ApiImplicitParam(name = "useBusinessCode", value = "业务code", required = true, dataType = "String")
  })
  @RequestMapping(value="/givenCoupon", method = RequestMethod.POST)
  ResponseData<Integer> givenCoupon(@RequestBody CouponEntityVO vo);


  /**
   * 转赠状态更改为转赠中
   * @return
   */
  @ApiOperation(value = "转赠状态更改为转赠中", notes = "转赠状态更改为转赠中", tags = {"券实例接口"},httpMethod = "POST")
  @ApiImplicitParams({
          @ApiImplicitParam(name = "couponCode", value = "券code", required = true, dataType = "String")
  })
  @RequestMapping(value="/couponGiving", method = RequestMethod.POST)
  ResponseData<Integer> couponGiving(@RequestParam("couponCode") String couponCode);


  /**
   * 锁定
   * @param vo
   * @return
   */
  @ApiOperation(value = "锁定券接口", notes = "锁定券接口", tags = {"券实例接口"},httpMethod = "POST")
  @ApiImplicitParams({
          @ApiImplicitParam(name = "couponCode", value = "券code", required = true, dataType = "String"),
          @ApiImplicitParam(name = "memberCode", value = "会员code", required = true, dataType = "String")
  })
  @RequestMapping(value="/lock", method = RequestMethod.POST)
  ResponseData<Object> lock(@RequestBody CouponEntityVO vo);


  /**
   * 未锁定
   * @param vo
   * @return
   */
  @ApiOperation(value = "解锁券接口", notes = "解锁券接口", tags = {"券实例接口"},httpMethod = "POST")
  @ApiImplicitParams({
          @ApiImplicitParam(name = "couponCode", value = "券code", required = true, dataType = "String"),
          @ApiImplicitParam(name = "memberCode", value = "会员code", required = true, dataType = "String")
  })
  @RequestMapping(value="/unlock", method = RequestMethod.POST)
  ResponseData<Object> unlock(@RequestBody CouponEntityVO vo);

  /**
   * 券过期
   * @param vo
   * @return
   */
  @ApiOperation(value = "优惠券到期接口", notes = "优惠券到期接口", tags = {"券消息配置"},httpMethod = "POST")
  @ApiImplicitParams({
          @ApiImplicitParam(name = "couponCode", value = "券code", required = true, dataType = "String"),
          @ApiImplicitParam(name = "memberCode", value = "会员code", required = true, dataType = "String"),
          @ApiImplicitParam(name = "useBusinessCode", value = "使用业务code", required = true, dataType = "String"),
          @ApiImplicitParam(name = "sysBrandId", value = "品牌id", required = true, dataType = "Long"),
  })
  @RequestMapping(value="/couponExpire", method = RequestMethod.POST)
  ResponseData<Object> couponExpire(@RequestBody CouponEntityVO vo);



}
