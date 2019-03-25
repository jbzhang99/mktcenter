package com.bizvane.messagefacade.interfaces;

import com.bizvane.messagefacade.models.po.MsgCoupontimePO;
import com.bizvane.utils.responseinfo.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 *活动模板消息
 * @author liangzanwen
 *2018年8月14日下午8:22:40
 */
@FeignClient(value="${feign.client.mktcenter.name}",path="${feign.client.mktcenter.path}/msgCouponTime")
@Api(value = "优惠券到期通知",tags = {"优惠券到期通知"})
public interface MsgCouponTimeServiceFeign {

  /**
   * 微信活动消费模板发送
   * @param vo
   * @return
   */
  @ApiOperation(value = "优惠券到期通知保全和更新 ")
  @RequestMapping(value = "/saveCouponTime", method = RequestMethod.POST)
  ResponseData<Long> saveCouponTime(long days);

  
  /**
   *短信活动消费模板发送
   * @param vo
   * @return
   */
  @ApiOperation(value = "根据品牌查")
  @RequestMapping(value = "/getCouponTime", method = RequestMethod.POST)
  ResponseData<MsgCoupontimePO>  getCouponTime(long sysBrandId);


  /**
   *查询优惠券到期通知集合
   * @return
   */
  @ApiOperation(value = "查询", notes = "查询优惠券到期通知集合", tags = {"查询优惠券到期通知集合"},httpMethod = "POST")
  @RequestMapping("/getCouponTimeList")
  public ResponseData<List<MsgCoupontimePO>>  getCouponTimeList();

}
