package com.bizvane.messageservice.controller;

import com.bizvane.messageservice.service.MsgSmsTempService;
import com.bizvane.messagefacade.models.po.MsgSmsTempPO;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.utils.tokens.TokenUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


/**
 *短信模板
 * @author liangzanwen
 *2018年8月13日下午8:29:53
 */
@Controller
@RequestMapping("/msgSmsTemp")
public class MsgSmsTempController {

    @Autowired
    private MsgSmsTempService msgSmsTempService;

    /**
     * 根据模板类型查询 
     * @param   sysBrandId templateType
     * @return
     */
    
    
    /**
      * 查短信模板消息
     * @param businessType
     * @return
     */
    @ApiOperation(value = "查询短信模板消息", notes = "查询短信模板消息", tags = {"短信模板查询"},httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysBrandId", value = "所属品牌id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "businessType", value = "业务类型", required = true, dataType = "String"),
            @ApiImplicitParam(name = "templateType", value = "短信模板类型", required = true, dataType = "String")
    })
    @RequestMapping("/getTemplateType")
    @ResponseBody
    public ResponseData<Object> getTemplate(@RequestParam("sysBrandId") Long sysBrandId,@RequestParam("businessType") String businessType,@RequestParam("templateType") String templateType){
        return msgSmsTempService.getTemplateByType(sysBrandId,businessType,templateType);
    }
    
    /**
     * 查短信模板消息
    * @param businessType
    * @return
    */
   @ApiOperation(value = "根据模板类型查询短信模板@列表", notes = "查询短信模板@列表", tags = {"短信模板@列表查询"},httpMethod = "POST")
   @ApiImplicitParams({
           @ApiImplicitParam(name = "templateType", value = "短信模板类型(COUPON_RECEIVE-券到账提醒，COUPON_UNRECEIVED-券未领取提醒，COUPON_EXPIRE-券到期提醒，COUPON_USE券使用提醒，INTEGRAL_ADD-积分增加提醒，INTEGRAL_SUBTRACT-积分减少提醒，INTEGRAL_EXPIRE-积分到期提醒，INTEGRAL_USE-积分使用提醒，MEMEBER_REGISTER-会员注册提醒，MEMEBER_INVITE_REGISTER-会员绑定，MEMEBER_UPGRADE-会员升级提醒，MEMEBER_DOWNGRADE-会员降级提醒，ORDER_OFFLINE_CONSUME-线下订单提醒，ORDER_ONLINE_CONSUME-线上订单提醒，ORDER_PAYMENT-订单支付提醒，ORDER_SHIP-订单发货提醒，ORDER_SIGN-订单签收提醒，ORDER_CANCEL-订单取消提醒，ORDER_APPRAISAL-订单评价提醒,ACTIVITY_TEMPLATE_MESSAGE活动消息)',", required = true, dataType = "String")
   })
   @RequestMapping("/findBytemplateType")
   @ResponseBody
   public ResponseData<Object> findBytemplateType(@RequestParam("templateType") String templateType){
       return msgSmsTempService.findBytemplateType(templateType);
   }

    /**
     * 根据id更新短信模板
     * @param po
     * @return
     */
    
    @ApiOperation(value = "根据id更新短信模板", notes = "根据id更新短信模板", tags = {"短信模板根据id更新"},httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "msgSmsTempId", value = "msgSmsTempId根据id更新", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "businessType", value = "业务类型(COUPON-券，INTEGRAL-积分，MEMBER-会员，ORDER-订单)", required = true, dataType = "String"),
            @ApiImplicitParam(name = "templateType", value = "模板类型(COUPON_RECEIVE-券到账提醒，COUPON_UNRECEIVED-券未领取提醒，COUPON_EXPIRE-券到期提醒，INTEGRAL_ADD-积分增加提醒，INTEGRAL_SUBTRACT-积分减少提醒，INTEGRAL_EXPIRE-积分到期提醒，INTEGRAL_USE-积分使用提醒，MEMEBER_REGISTER-会员注册提醒，MEMEBER_INVITE_REGISTER-会员绑定成功提醒，MEMEBER_UPGRADE-会员升级提醒，MEMEBER_DOWNGRADE-会员降级提醒，ORDER_OFFLINE_CONSUME-线下订单提醒，ORDER_ONLINE_CONSUME-线上订单提醒，ORDER_PAYMENT-订单支付提醒，ORDER_SHIP-订单发货提醒，ORDER_SIGN-订单签收提醒，ORDER_CANCEL-订单取消提醒，ORDER_APPRAISAL-订单评价提醒)", required = true, dataType = "String"),
            @ApiImplicitParam(name = "status", value = "短信配置开关 0.关闭1.开启 ,", required = true, dataType = "boolean"),
            @ApiImplicitParam(name = "content", value = "模板内容 ,", required = true, dataType = "String"),
            @ApiImplicitParam(name = "sendWxmember", value = "0.全部发送 1.向微信会员发送短信2.向非微信会员发送短信 ,", required = true, dataType = "Long"),
    })
    @RequestMapping("/updateMsgSmsTemp")
    @ResponseBody
    public ResponseData<Object> updateMsgSmsTemp( MsgSmsTempPO po, HttpServletRequest request){
    	
	    SysAccountPO stageUser = TokenUtils.getStageUser(request);
	    
	    po.setSysCompanyId(stageUser.getSysCompanyId());//所属品牌
	    po.setSysBrandId(stageUser.getBrandId());//所属品牌
	    po.setModifiedUserId(stageUser.getSysAccountId());//名字
	    po.setModifiedUserName(stageUser.getName());//名字
	    
	    
        return msgSmsTempService.updateMsgSmsTempById(po);
    }
    
    /**
       * 新建模板
     * @param po
     * @return
     */
    
    
    @ApiOperation(value = "新建模板", notes = "新建模板", tags = {"短信模板新建"},httpMethod = "POST")
    
    @ApiImplicitParams({
        @ApiImplicitParam(name = "businessType", value = "业务类型(COUPON-券，INTEGRAL-积分，MEMBER-会员，ORDER-订单)", required = true, dataType = "String"),
        @ApiImplicitParam(name = "templateType", value = "模板类型(COUPON_RECEIVE-券到账提醒，COUPON_UNRECEIVED-券未领取提醒，COUPON_EXPIRE-券到期提醒，INTEGRAL_ADD-积分增加提醒，INTEGRAL_SUBTRACT-积分减少提醒，INTEGRAL_EXPIRE-积分到期提醒，INTEGRAL_USE-积分使用提醒，MEMEBER_REGISTER-会员注册提醒，MEMEBER_INVITE_REGISTER-会员绑定成功提醒，MEMEBER_UPGRADE-会员升级提醒，MEMEBER_DOWNGRADE-会员降级提醒，ORDER_OFFLINE_CONSUME-线下订单提醒，ORDER_ONLINE_CONSUME-线上订单提醒，ORDER_PAYMENT-订单支付提醒，ORDER_SHIP-订单发货提醒，ORDER_SIGN-订单签收提醒，ORDER_CANCEL-订单取消提醒，ORDER_APPRAISAL-订单评价提醒)", required = true, dataType = "String"),
        @ApiImplicitParam(name = "status", value = "短信配置开关 ture，关fale ,", required = true, dataType = "boolean"),
        @ApiImplicitParam(name = "content", value = "模板内容 ,", required = true, dataType = "String"),
        @ApiImplicitParam(name = "sendWxmember", value = "0.全部发送 1.向微信会员发送短信2.向非微信会员发送短信 ,", required = true, dataType = "Long"),
        
     })
    @RequestMapping("/insertMsgSmsTemp")
    @ResponseBody
    public ResponseData<Object> insert( MsgSmsTempPO po, HttpServletRequest request){
    	
	    SysAccountPO stageUser = TokenUtils.getStageUser(request);
	    
	    
	    po.setSysCompanyId(stageUser.getSysCompanyId());//所属品牌
	    po.setSysBrandId(stageUser.getBrandId());//所属品牌
	    po.setCreateUserId(stageUser.getSysAccountId());//名字
	    po.setCreateUserName(stageUser.getName());//名字
        return msgSmsTempService.insert(po);
    }

}
