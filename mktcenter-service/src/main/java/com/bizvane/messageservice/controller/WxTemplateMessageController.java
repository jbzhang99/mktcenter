package com.bizvane.messageservice.controller;

import com.bizvane.messageservice.service.WxMessagetempService;
import com.bizvane.messagefacade.models.po.MsgWxTempPO;
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
 * Created by yunjie.tian on 2018/7/24.
 * 模板消息发送
 */
@Controller
@RequestMapping("/wxTemplateMag")
public class WxTemplateMessageController {

    @Autowired
    private WxMessagetempService wxMessagetempService;



    /**
      * 查微信模板消息
     * @param businessType
     * @return
     */
    @ApiOperation(value = "查询微信模板消息", notes = "查询微信模板消息", tags = {"微信模板查询"},httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysBrandId", value = "所属品牌id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "templateType", value = "微信模板类型", required = true, dataType = "String")
    })
    @RequestMapping("/getTemplateType")
    @ResponseBody
    public ResponseData<Object> getTemplate(@RequestParam("sysBrandId") Long sysBrandId,@RequestParam("businessType") String businessType,@RequestParam("templateType") String templateType){
    	
        return wxMessagetempService.getTemplateByType(sysBrandId, businessType,templateType);
    }

    /**
       * 根据id更新微信模板占时不用做，后台数据手动添加
     * @param po
     * @return
     */
    
    @ApiOperation(value = "根据id更新微信模板", notes = "根据id更新微信模板", tags = {"微信模板根据id更新"},httpMethod = "POST")
    @ApiImplicitParams({
//            @ApiImplicitParam(name = "msgSmsTempId", value = "msgSmsTempId根据id更新", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "businessType", value = "业务类型(COUPON-券，INTEGRAL-积分，MEMBER-会员，ORDER-订单)", required = true, dataType = "String"),
//            @ApiImplicitParam(name = "templateType", value = "模板类型(COUPON_RECEIVE-券到账提醒，COUPON_UNRECEIVED-券未领取提醒，COUPON_EXPIRE-券到期提醒，INTEGRAL_ADD-积分增加提醒，INTEGRAL_SUBTRACT-积分减少提醒，INTEGRAL_EXPIRE-积分到期提醒，INTEGRAL_USE-积分使用提醒，MEMEBER_REGISTER-会员注册提醒，MEMEBER_INVITE_REGISTER-会员绑定成功提醒，MEMEBER_UPGRADE-会员升级提醒，MEMEBER_DOWNGRADE-会员降级提醒，ORDER_OFFLINE_CONSUME-线下订单提醒，ORDER_ONLINE_CONSUME-线上订单提醒，ORDER_PAYMENT-订单支付提醒，ORDER_SHIP-订单发货提醒，ORDER_SIGN-订单签收提醒，ORDER_CANCEL-订单取消提醒，ORDER_APPRAISAL-订单评价提醒)", required = true, dataType = "String"),
            @ApiImplicitParam(name = "status", value = "微信配置开关 true，关fale ,", required = true, dataType = "boolean"),
//            @ApiImplicitParam(name = "first", value = "头信息（可空，如不填写默认发送：尊敬的会员） ,", required = true, dataType = "String"),
//            @ApiImplicitParam(name = "message", value = "中部模板消息内容（查看详情跳转小程序详情页面地址） ,", required = true, dataType = "String"),
//            @ApiImplicitParam(name = "tail", value = "底部备注，（可空，如果不填写默认发送：感谢您的支持） ,", required = true, dataType = "String"),
//            @ApiImplicitParam(name = "url", value = "详情地址（查看详情跳转小程序详情页面地址） ,", required = true, dataType = "String"),
    })
    @RequestMapping("/updateMsgSmsTemp")
    @ResponseBody
    public ResponseData<Object> updateMsgSmsTemp( MsgWxTempPO po, HttpServletRequest request){
        	
    	    SysAccountPO stageUser = TokenUtils.getStageUser(request);
    	    po.setSysCompanyId(stageUser.getSysCompanyId());//所属品牌
    	    po.setSysBrandId(stageUser.getBrandId());//所属品牌
    	    po.setModifiedUserId(stageUser.getSysAccountId());//名字
    	    po.setModifiedUserName(stageUser.getName());//名字
    	
        return wxMessagetempService.updateMsgSmsTempById(po);
    }
    
    /**
       * 新建模板占时不用做，后台数据手动添加
     * @param po
     * @return
     */
    
    
    @ApiOperation(value = "新建模板", notes = "新建模板", tags = {"微信模板新建"},httpMethod = "POST")
    
    @ApiImplicitParams({
        @ApiImplicitParam(name = "businessType", value = "业务类型(COUPON-券，INTEGRAL-积分，MEMBER-会员，ORDER-订单)", required = true, dataType = "String"),
        @ApiImplicitParam(name = "templateType", value = "模板类型(COUPON_RECEIVE-券到账提醒，COUPON_UNRECEIVED-券未领取提醒，COUPON_EXPIRE-券到期提醒，INTEGRAL_ADD-积分增加提醒，INTEGRAL_SUBTRACT-积分减少提醒，INTEGRAL_EXPIRE-积分到期提醒，INTEGRAL_USE-积分使用提醒，MEMEBER_REGISTER-会员注册提醒，MEMEBER_INVITE_REGISTER-会员绑定成功提醒，MEMEBER_UPGRADE-会员升级提醒，MEMEBER_DOWNGRADE-会员降级提醒，ORDER_OFFLINE_CONSUME-线下订单提醒，ORDER_ONLINE_CONSUME-线上订单提醒，ORDER_PAYMENT-订单支付提醒，ORDER_SHIP-订单发货提醒，ORDER_SIGN-订单签收提醒，ORDER_CANCEL-订单取消提醒，ORDER_APPRAISAL-订单评价提醒)", required = true, dataType = "String"),
        @ApiImplicitParam(name = "status", value = "微信配置开关 true，关fale ,", required = true, dataType = "boolean"),
        @ApiImplicitParam(name = "first", value = "头信息（可空，如不填写默认发送：尊敬的会员） ,", required = true, dataType = "String"),
        @ApiImplicitParam(name = "message", value = "中部模板消息内容（查看详情跳转小程序详情页面地址） ,", required = true, dataType = "String"),
        @ApiImplicitParam(name = "tail", value = "底部备注，（可空，如果不填写默认发送：感谢您的支持） ,", required = true, dataType = "String"),
        @ApiImplicitParam(name = "url", value = "详情地址（查看详情跳转小程序详情页面地址） ,", required = true, dataType = "String"),
        
     })
    @RequestMapping("/insertMsgSmsTemp")
    @ResponseBody
    public ResponseData<Object> insert( MsgWxTempPO po){
        return wxMessagetempService.insert(po);
    }



}
