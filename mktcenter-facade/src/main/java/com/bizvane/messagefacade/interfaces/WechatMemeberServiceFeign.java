package com.bizvane.messagefacade.interfaces;

import com.bizvane.messagefacade.models.vo.MemberMessageVO;
import com.bizvane.utils.responseinfo.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 会员相关模板消息
 * @author 董争光
 * 2018年7月25日下午1:53:44
 */
@FeignClient(value="${feign.client.mktcenter.name}",path="${feign.client.mktcenter.path}/wechatMemeber")
@Api(value = "会员相关模板消息",tags = {"会员相关模板消息"})
public interface WechatMemeberServiceFeign {

  /**
   * 会员注册提醒
   * @param vo
   * @return
   */
  @ApiOperation(value = "会员注册提醒")
  @RequestMapping(value = "/memeberRegister", method = RequestMethod.POST)
  @ResponseBody
  ResponseData<String> memeberRegister(@RequestBody MemberMessageVO vo);

  /**
   * 会员绑定成功提醒
   * @param vo
   * @return
   */
  @ApiOperation(value = "会员绑定成功提醒")
  @RequestMapping(value = "/memeberInviteRegister", method = RequestMethod.POST)
  @ResponseBody
  ResponseData<String> memeberInviteRegister(@RequestBody MemberMessageVO vo);
  
  /**
   * 会员升级提醒
   * @param vo
   * @return
   */
  @ApiOperation(value = "会员升级提醒")
  @RequestMapping(value = "/memeberUpgrade", method = RequestMethod.POST)
  @ResponseBody
  ResponseData<String> memeberUpgrade(@RequestBody MemberMessageVO vo);
  
  /**
   * 会员降级提醒
   * @param vo
   * @return
   */
  @ApiOperation(value = "会员降级提醒")
  @RequestMapping(value = "/memeberDowngrade", method = RequestMethod.POST)
  @ResponseBody
  ResponseData<String> memeberDowngrade(@RequestBody MemberMessageVO vo);


}
