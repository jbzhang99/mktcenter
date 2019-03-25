package com.bizvane.couponservice.controller.rpc;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.couponfacade.models.vo.*;
import com.bizvane.couponservice.service.CouponService;
import com.bizvane.utils.responseinfo.ResponseData;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/couponRpc")
public class CouponController {

  private static Logger logger = LoggerFactory.getLogger(CouponController.class);

  @Autowired
  private CouponService couponService;

  /**
   * 根据券号使用优惠券接口(核销)
   * @return
   */
  @ApiOperation(value = "根据券号使用优惠券接口(核销)", notes = "根据券号使用优惠券接口", tags = {"券操作接口"},httpMethod = "POST")
  @RequestMapping(value="/use", method = RequestMethod.POST)
  ResponseData<String> use(@RequestBody(required = false)CouponUseVO requestVO){
    logger.info("enter use method param:CouponUseRequestVO:{}",JSONObject.toJSONString(requestVO));
    requestVO.setUseFrom((byte) 1);
    return couponService.use(requestVO);
  }


  /**
   * 企业微信券核销
   * @return
   */
  @ApiOperation(value = "企业微信券核销", notes = "企业微信券核销", tags = {"券操作接口"},httpMethod = "POST")
  @RequestMapping(value="/wechatEnterpriseUse", method = RequestMethod.POST)
  ResponseData<String> wechatEnterpriseUse(@RequestBody(required = false)CouponUseVO requestVO){
    logger.info("enter use method param:wechatEnterpriseUse:{}",JSONObject.toJSONString(requestVO));
    return couponService.wechatEnterpriseUse(requestVO);
  }



  /**
   * 线上使用优惠券 线上即是微商城
   * @param vo
   * @return
   */
  @ApiOperation(value = "线上使用优惠券接口(核销)", notes = "线上使用优惠券接口", tags = {"券操作接口"},httpMethod = "POST")
  @RequestMapping(value="/onlineUse", method = RequestMethod.POST)
  ResponseData<String> onlineUse(@RequestBody CouponOnlineUseRequestVO vo){
    logger.info("enter onlineUse method param:CouponOnlineUseRequestVO:{}",JSONObject.toJSONString(vo));
    vo.setUseFrom((byte) 3);//线上
    return couponService.onlineUse(vo);
  }

  /**
   * 线下使用优惠券
   * @param vo
   * @return
   */
  @ApiOperation(value = "线下使用优惠券接口(核销)", notes = "线下使用优惠券接口", tags = {"券操作接口"},httpMethod = "POST")
  @RequestMapping(value="/offlineUse", method = RequestMethod.POST)
  ResponseData<Integer> offlineUse(@RequestBody(required = false) CouponOfflineUseRequestVO vo){
	  vo.setUseFrom((byte) 4);//线下
    logger.info("enter offlineUse method param:CouponOnlineUseRequestVO:{}",JSONObject.toJSONString(vo));
    return couponService.offlineUse(vo);
  }

  /**
   * 冲正券接口
   * @param vo
   * @return
   */
  @ApiOperation(value = "冲正券接口", notes = "冲正券接口", tags = {"券消息配置"},httpMethod = "POST")
  @RequestMapping(value="/cancelUse", method = RequestMethod.POST)
  ResponseData<Object> cancelUse(@RequestBody CouponCancelUseRequestVO vo){
    logger.info("enter cancelUse method param:CouponCancelUseRequestVO:{}",JSONObject.toJSONString(vo));
    return couponService.cancelUse(vo);

  }



  /**
   * 转赠
   * @param vo
   * @return
   */
  @ApiOperation(value = "转赠券接口", notes = "转赠券接口", tags = {"券操作接口"},httpMethod = "POST")
  @ApiImplicitParams({
          @ApiImplicitParam(name = "couponCode", value = "券code", required = true, dataType = "String"),
          @ApiImplicitParam(name = "oldMemberCode", value = "旧会员code", required = true, dataType = "String"),
          @ApiImplicitParam(name = "newMemberCode", value = "新会员code", required = true, dataType = "String"),
          @ApiImplicitParam(name = "useBusinessCode", value = "业务code", required = true, dataType = "String")
  })
  @RequestMapping(value="/givenCoupon", method = RequestMethod.POST)
  ResponseData<Integer> givenCoupon(@RequestBody(required = false) CouponEntityVO vo){
    logger.info("enter givenCoupon method param:CouponEntityVO:{}",JSONObject.toJSONString(vo));
    return couponService.givenCoupon(vo);
  }

  /**
   * 转赠状态更改为转赠中
   * @return
   */
  @ApiOperation(value = "转赠状态更改为转赠中", notes = "转赠状态更改为转赠中", tags = {"券实例接口"},httpMethod = "POST")
  @ApiImplicitParams({
          @ApiImplicitParam(name = "couponCode", value = "券code", required = true, dataType = "String")
  })
  @RequestMapping(value="/couponGiving", method = RequestMethod.POST)
  ResponseData<Integer> couponGiving(@RequestParam("couponCode")String couponCode){
    return couponService.couponGiving(couponCode);
  }



  /**
   * 锁定
   * @param vo
   * @return
   */
  @ApiOperation(value = "锁定券接口", notes = "锁定券接口", tags = {"券操作接口"},httpMethod = "POST")
  @ApiImplicitParams({
          @ApiImplicitParam(name = "couponCode", value = "券code", required = true, dataType = "String"),
          @ApiImplicitParam(name = "memberCode", value = "会员code", required = true, dataType = "String")
  })
  @RequestMapping(value="/lock", method = RequestMethod.POST)
  ResponseData<Object> lock(@RequestBody CouponEntityVO vo){
    logger.info("enter lock method param:CouponEntityVO:{}",JSONObject.toJSONString(vo));
    return couponService.lock(vo);
  }


  /**
   * 未锁定
   * @param vo
   * @return
   */
  @ApiOperation(value = "解锁券接口", notes = "解锁券接口", tags = {"券操作接口"},httpMethod = "POST")
  @ApiImplicitParams({
          @ApiImplicitParam(name = "couponCode", value = "券code", required = true, dataType = "String"),
          @ApiImplicitParam(name = "memberCode", value = "会员code", required = true, dataType = "String")
  })
  @RequestMapping(value="/unlock", method = RequestMethod.POST)
  ResponseData<Object> unlock(@RequestBody CouponEntityVO vo){
    logger.info("enter unlock method param:CouponEntityVO:{}",JSONObject.toJSONString(vo));
    return couponService.unlock(vo);
  }

  /**
   * 券过期
   * @param vo
   * @return
   */
  @ApiOperation(value = "优惠券到期接口", notes = "优惠券到期接口", tags = {"券操作接口"},httpMethod = "POST")
  @ApiImplicitParams({
          @ApiImplicitParam(name = "couponCode", value = "券code", required = true, dataType = "Long"),
          @ApiImplicitParam(name = "memberCode", value = "会员code", required = true, dataType = "Long"),
          @ApiImplicitParam(name = "useBusinessCode", value = "使用业务code", required = true, dataType = "Long"),
  })
  @RequestMapping(value="/couponExpire", method = RequestMethod.POST)
  ResponseData<Object> couponExpire(@RequestBody CouponEntityVO vo){
    logger.info("enter couponExpire method param:CouponEntityVO:{}",JSONObject.toJSONString(vo));
    return couponService.couponExpire(vo);
  }


}
