package com.bizvane.messageservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.messageservice.common.constants.SystemConstants;
import com.bizvane.messageservice.common.constants.TemplateMessageTypeConstant;
import com.bizvane.messageservice.service.RocketMQWechatService;
import com.bizvane.messagefacade.models.vo.Result;
import com.bizvane.messagefacade.models.vo.WechatEnterpriseMessageVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yunjie.tian on 2019/1/11.
 *
 * 企业微信消息
 */
@RestController
@RequestMapping(value = "/wechatCompany",method = RequestMethod.POST)
public class WechatCompanyController {

    @Autowired
    private RocketMQWechatService rocketMQWechatService;


    /**
     * 离线消息
     * @return
     */
    @RequestMapping(value = "/offlineInfo", method = RequestMethod.POST)
    public Result<String> offlineInfo(@RequestBody WechatEnterpriseMessageVO requestVO) {
        JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(requestVO));

        jsonObject.put("rocketMQTopic", SystemConstants.ROCKET_TOPIC_SIMPLE_MESSAGE);
        jsonObject.put("rocketMQTag", TemplateMessageTypeConstant.OFFLINE_INFO);
        jsonObject.put("bussinessModuleCode", TemplateMessageTypeConstant.OFFLINE_INFO);
        jsonObject.put("bussinessType",SystemConstants.ROCKET_CONFIG_BUSINESS_TYPE_WECHAT_OFFLINE_INFO_MESSAGE);
        
        if(StringUtils.isNotBlank(requestVO.getOpenId())){
        	 jsonObject.put("rocketMQBussinessId", requestVO.getOpenId());
        }else {
        	 jsonObject.put("rocketMQBussinessId", requestVO.getMemberCode());
        }
       
        return rocketMQWechatService.sendMessage(jsonObject.toJSONString());
    }
}
