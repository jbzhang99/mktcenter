package com.bizvane.messageservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.centerstageservice.models.po.SysAccountPo;
import com.bizvane.couponservice.common.utils.HttpUtils;
import com.bizvane.messagefacade.interfaces.WxNewTempService;
import com.bizvane.messagefacade.models.po.MsgWxTempPO;
import com.bizvane.utils.responseinfo.ResponseData;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 微信模板
 */
@Slf4j
@RestController
@RequestMapping(value = "/wechatNewTem",method = RequestMethod.POST)
public class WechatNewTemController {

    @Autowired
    private WxNewTempService wxNewTempService;


    @ApiOperation(value = "", notes = "获取微信模板下拉", tags = {""},httpMethod = "POST")
    @RequestMapping("/getWxTemplate")
    @ResponseBody
    public ResponseData<Object> getWxTemplate(HttpServletRequest request){
    	 SysAccountPo accountPo = HttpUtils.getLoginUser(request);
         log.info("enter method"+this.getClass().getName()+JSONObject.toJSONString(accountPo));
  		 return wxNewTempService.getWxTemplate(accountPo.getBrandId());
    }
    
    
    
    @ApiOperation(value = "", notes = "保存，更新接口微信模板", tags = {""},httpMethod = "POST")
    @ApiImplicitParams({
    	
    	@ApiImplicitParam(name = "templateType", value = "模板类型", required = true, dataType = "String"),
    	@ApiImplicitParam(name = "status", value = "开启状态", required = true, dataType = "String"),
    	
    	@ApiImplicitParam(name = "wxTemplateId", value = "微信模板id", required = true, dataType = "String"),
        @ApiImplicitParam(name = "title", value = "模板名称", required = true, dataType = "String"),
        
        @ApiImplicitParam(name = "first", value = "头内容", required = true, dataType = "String"),
        @ApiImplicitParam(name = "content", value = "中部模板json格式{}", required = true, dataType = "String"),
        @ApiImplicitParam(name = "tail", value = "尾部内容", required = true, dataType = "String"),
        
        @ApiImplicitParam(name = "url", value = "详情地址", required = true, dataType = "String"),
        
        
})
    @RequestMapping("/saveWxTemplate")
    @ResponseBody
    public ResponseData<Object> saveWxTemplate(MsgWxTempPO msgWxTempPO, HttpServletRequest request){
    	 SysAccountPo accountPo = HttpUtils.getLoginUser(request);
         msgWxTempPO.setSysBrandId(accountPo.getBrandId());
         msgWxTempPO.setSysCompanyId(msgWxTempPO.getSysCompanyId());
         
         log.info("enter saveWxTemplate method"+JSONObject.toJSONString(msgWxTempPO));
  		 return wxNewTempService.saveWxTemplate(msgWxTempPO);
    }
    
}
