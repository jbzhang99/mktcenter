package com.bizvane.messageservice.controller;

import com.bizvane.messageservice.service.MsgCouponTimeService;
import com.bizvane.messagefacade.models.po.MsgCoupontimePO;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.utils.tokens.TokenUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Geng on 2018/8/20.
 */
@RestController
@RequestMapping("/msgCouponTime")
public class MsgCouponTimeController {

    @Autowired
    private MsgCouponTimeService msgCouponTimeService;

    @ApiOperation(value = "保全优惠券到期通知", notes = "保全优惠券到期通知", tags = {"保全优惠券到期通知"},httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "days", value = "时间", required = true, dataType = "Long"),
    })
    @RequestMapping("/saveCouponTime")
    public ResponseData<Long> saveCouponTime(long days, HttpServletRequest request)throws Exception{
        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        return msgCouponTimeService.saveSendTime(days,stageUser);
    }
    
    
    @RequestMapping("/testCoupon")
    public ResponseData<Long> testCoupon()throws Exception{
        return msgCouponTimeService.testCoupon();
    }

    @ApiOperation(value = "查询", notes = "查询优惠券到期通知", tags = {"查询优惠券到期通知"},httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysBrandId", value = "所属品牌id", required = true, dataType = "Long"),
    })
    @RequestMapping("/getCouponTime")
    public ResponseData<MsgCoupontimePO>  getCouponTime(long sysBrandId){
        return msgCouponTimeService.getSendTime(sysBrandId);
    }


    /**
     *查询优惠券到期通知集合
     * @return
     */
    @ApiOperation(value = "查询", notes = "查询优惠券到期通知集合", tags = {"查询优惠券到期通知集合"},httpMethod = "POST")
    @RequestMapping("/getCouponTimeList")
    public ResponseData<List<MsgCoupontimePO>>  getCouponTimeList(){
        return msgCouponTimeService.getCouponTimeList();
    }

}
