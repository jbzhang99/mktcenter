package com.bizvane.messagefacade.interfaces;

import com.bizvane.messagefacade.models.po.MsgSmsTempPO;
import com.bizvane.messagefacade.models.vo.*;
import com.bizvane.utils.responseinfo.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 *短信通用消息
 * @author liangzanwen
 *2018年8月14日下午8:22:40
 */
@FeignClient(value="${feign.client.mktcenter.name}",path="${feign.client.mktcenter.path}/templateMessage")
@Api(value = "短信通用消息",tags = {"短信通用消息"})
public interface TemplateMessageServiceFeign {
	
 //图文消息
 @ApiOperation(value = "图文消息")
 @RequestMapping(value = "/sendTuWenMessage", method = RequestMethod.POST)
 public Result<String> sendTuWenMessage(@RequestBody SendTuWenMessageVO vo) ;
	  
 @ApiOperation(value = "企业微信模板 ")
 @RequestMapping(value = "/getTemplateType", method = RequestMethod.POST)
 ResponseData<List<MsgSmsTempPO>> getTemplateType(@RequestBody GenrealTemMessage vo);
	
  @ApiOperation(value = "企业微信通用批量短信发送 ")
  @RequestMapping(value = "/sendQyGenrealBatch", method = RequestMethod.POST)
  ResponseData<String> sendQyGenrealBatch(@RequestBody GenrealSendMessageVO vo);
	
  @ApiOperation(value = "通用批量短信发送 ")
  @RequestMapping(value = "/sendGenrealBatch", method = RequestMethod.POST)
  ResponseData<String> sendGenrealBatch(@RequestBody GenrealSendMessageVO vo);
  
  
  @ApiOperation(value = "根据传参数 查询短信发送成功率")
  @RequestMapping(value = "/getReturnMessage", method = RequestMethod.POST)
  ResponseData<SmsStatisticsVO>  getReturnMessage(@RequestBody GenrealGetMessageVO vo);

  /**
   * 微信活动消费模板发送
   * @param vo
   * @return
   */
  @ApiOperation(value = "微信活动消费模板发送 ")
  @RequestMapping(value = "/sendTemplateMessage", method = RequestMethod.POST)
  ResponseData<String> sendTemplateMessage(@RequestBody ActivityMessageVO vo);

  
  /**
   *短信活动消费模板发送
   * @param vo
   * @return
   */
  @ApiOperation(value = "短信活动短信消费模板发送")
  @RequestMapping(value = "/sendSmsTemplateMessage", method = RequestMethod.POST)
  ResponseData<String> sendSmsTemplateMessage(@RequestBody ActivityMessageVO vo);


}
