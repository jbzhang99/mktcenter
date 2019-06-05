package com.bizvane.couponservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.couponfacade.enums.SendTypeEnum;
import com.bizvane.couponfacade.models.vo.SendCouponBatchRequestVO;
import com.bizvane.couponfacade.models.vo.SendCouponQuotaBatchRequestVO;
import com.bizvane.couponfacade.models.vo.SendCouponSimpleRequestVO;
import com.bizvane.couponservice.service.CouponQuotaDetailService;
import com.bizvane.couponservice.service.SendCouponService;
import com.bizvane.members.facade.vo.MemberInfoVo;
import com.bizvane.utils.responseinfo.ResponseData;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 发送券模板消息
 */
@RestController
@RequestMapping("/sendCoupon")
public class SendCouponController{

    @Autowired
    private SendCouponService sendCouponService;
    
    @Autowired
    private  CouponQuotaDetailService couponQuotaDetailService;

    private static final Logger logger = LoggerFactory.getLogger(SendCouponController.class);

    /**
     * 单张发券(优惠券入账)
     * @return
     */
    @ApiOperation(value = "单张发券接口", notes = "单张发券接口", tags = {"发券"},httpMethod = "POST")
    @RequestMapping("/simple")
    public ResponseData<String> simple(@RequestBody(required = false) SendCouponSimpleRequestVO vo){
        logger.info("enter simple method param: SendCouponSimpleRequestVO:{}", JSONObject.toJSONString(vo));
      return sendCouponService.simple(vo);
    
    }

    /**
     * 批量发券
     * @return
     */
    @ApiOperation(value = "批量发券接口", notes = "批量发券接口", tags = {"发券"},httpMethod = "POST")
    @RequestMapping("/batchRpc")
    public ResponseData<String> batchCoupon(@RequestBody SendCouponBatchRequestVO vo){
        logger.info("enter batchCoupon method param: SendCouponBatchRequestVO:{}", JSONObject.toJSONString(vo));
        ResponseData<String> responseData = sendCouponService.batchRpc(vo);
        return responseData;

    }
    

    /**
       *企业微信 批量发券
     * @return
     */
    @ApiOperation(value = "企业微信批量发券接口", notes = "批量发券接口", tags = {"发券"},httpMethod = "POST")
    @RequestMapping("/couponQuotaBatchRpc")
    public ResponseData<String> couponQuotaBatchRpc(@RequestBody SendCouponQuotaBatchRequestVO vo){
        logger.info("enter batchCoupon method param: couponQuotaBatchRpc:{}", JSONObject.toJSONString(vo));

        vo.setBusinessType(SendTypeEnum.SEND_COUPON_QUOTA_MALl.getCode());
        vo.setBusinessName(vo.getStaffName()+"/"+vo.getStaffCode());
        vo.setCreateUserName(vo.getStaffCode());

        //拼接memberCode
        List<MemberInfoVo> memberList = new ArrayList<>();
        String[] memberCodes = vo.getMemberCodeStr().split(",");
        for(int i=0;i<memberCodes.length;i++){
            MemberInfoVo memberInfoVo = new MemberInfoVo();
            memberInfoVo.setMemberCode(memberCodes[i]);
            memberList.add(memberInfoVo);
        }

        vo.setMemberNum(memberList.size()+"");

        //保存配额信息
        ResponseData<String> response =  couponQuotaDetailService.batchRpc(vo);
        if(response.getCode()>0) {
        	return response;
        }
        logger.info("enter batchCoupon method param: 企业微信 批量发券:{}", response.getData());


        SendCouponBatchRequestVO sendCouponBatchRequestVO = new SendCouponBatchRequestVO();
        sendCouponBatchRequestVO.setCouponDefinitionId(vo.getCouponDefinitionId());
        sendCouponBatchRequestVO.setSysCompanyId(vo.getSysCompanyId());
        sendCouponBatchRequestVO.setSysBrandId(vo.getSysBrandId());
        sendCouponBatchRequestVO.setMemberNum(vo.getMemberNum());
        sendCouponBatchRequestVO.setBusinessType(SendTypeEnum.SEND_COUPON_QUOTA_MALl.getCode());
        sendCouponBatchRequestVO.setBusinessName(vo.getStaffName()+"/"+vo.getStaffCode());
        sendCouponBatchRequestVO.setCreateUserName(vo.getStaffCode());
        sendCouponBatchRequestVO.setBusinessId(Long.parseLong(response.getData()));

        sendCouponBatchRequestVO.setMemberList(memberList);
        sendCouponBatchRequestVO.setMemberNum(memberList.size()+"");

        //发券
        ResponseData<String> responseData = sendCouponService.batchRpc(sendCouponBatchRequestVO);
        logger.info("enter batchCoupon method param: 企业微信 批量发券end:{}", responseData.getData());
        return responseData;

    }


    /**
     * 券到期提醒
     * @param expireDay
     * @return
     */
    @ApiOperation(value = "券到期提醒", notes = "券到期提醒", tags = {"发券"},httpMethod = "POST")
    @ApiImplicitParams({
         @ApiImplicitParam(name = "expireDay", value = "过期时间", required = true, dataType = "String")
    })
    @RequestMapping("/expire")
    public ResponseData<Integer> expire(@RequestParam(value = "expireDay",required = false) String expireDay){
        logger.info("enter expire method param: expireDay:{}", expireDay);

        ResponseData<Integer> responseData = sendCouponService.expire(expireDay);

        return responseData;

    }


    /**
     * 补发券(单张)
     * @return
     */
    @ApiOperation(value = "券补发(单张)", notes = "券补发(单张)", tags = {"发券"},httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "couponSendFailLogId", value = "券失败日志表id", required = true, dataType = "Long")
    })
    @RequestMapping("/sendSingleAgain")
    public ResponseData<Integer> sendSingleAgain(@RequestParam(value = "couponSendFailLogId",required = false)Long couponSendFailLogId){

        return sendCouponService.sendSingleAgain(couponSendFailLogId);
    }


    /**
     * 补发券(批量)
     * @return
     */
    @ApiOperation(value = "券补发(批量)", notes = "券补发(批量)", tags = {"发券"},httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "券失败日志id", required = true, dataType = "String")
    })
    @RequestMapping(value = "/sendBatchAgain",method = RequestMethod.POST)
    public ResponseData<Integer> sendBatchAgain(@RequestParam("ids")String ids){
        logger.info("enter sendBatchAgain method param:ids:{}",ids);
        return sendCouponService.sendBatchAgain(ids);
    }



}
