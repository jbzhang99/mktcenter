package com.bizvane.couponservice.controller.rpc;

import com.bizvane.couponfacade.models.po.CouponEntityPO;
import com.bizvane.couponfacade.models.vo.CouponSendMemberListRequestVO;
import com.bizvane.couponfacade.models.vo.CouponSendMemberListResponseVO;
import com.bizvane.couponfacade.models.vo.CouponStatusUpdateBatchRequestVO;
import com.bizvane.couponservice.service.CouponEntityService;
import com.bizvane.utils.responseinfo.ResponseData;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yunjie.tian on 2018/8/8.
 */
@RestController
@RequestMapping("/couponEntityRpc")
public class CouponEntityRpcController {

    private static final Logger logger = LoggerFactory.getLogger(CouponEntityRpcController.class);

    @Autowired
    private CouponEntityService couponEntityService;

    /**
     * 查询会员是否有某个券
     * @param memberCode
     * @param sendBusinessId
     * @return
     */
    @ApiOperation(value = "查询会员是否有某个券", notes = "查询会员是否有某个券", tags = {"券实例接口"},httpMethod = "POST")
    @RequestMapping(value="/findCouponHave", method = RequestMethod.POST)
    public ResponseData<List<CouponEntityPO>> findCouponHave(@RequestParam(value = "memberCode",required = false)String memberCode,
                                                             @RequestParam(value = "sendBusinessId",required = false)Long sendBusinessId,
                                                             @RequestParam(value = "date",required = false)String date){
        logger.info("enter findCouponHave method param: date:{},memberCode:{},sendBusinessId:{}",date,memberCode,sendBusinessId);
        return couponEntityService.finCouponHave(memberCode,sendBusinessId,date);
    }


    /**
     * 单张发券收到线下处理结果
     * @param couponCode
     * @param couponStatus
     * @return
     */
    @ApiOperation(value = "单张发券收到线下处理结果", notes = "单张发券收到线下处理结果", tags = {"券实例接口"},httpMethod = "POST")
    @RequestMapping(value="/updateCouponStatus", method = RequestMethod.POST)
    public ResponseData<Integer> updateCouponStatus(@RequestParam(value = "couponCode",required = false)String couponCode,
                                                    @RequestParam(value = "couponStatus",required = false)Byte couponStatus,
                                                    @RequestParam(value = "ifSendAgain",required = false)Integer ifSendAgain){

        logger.info("enter CouponEntityRpcController updateCouponStatus method :param:couponCode:{},couponStatus:{},ifSendAgain:{}",couponCode,couponStatus,ifSendAgain);
        ResponseData<Integer> responseData = couponEntityService.updateCouponStatus(couponCode,couponStatus,ifSendAgain);
        return responseData;
    }


    /**
     * 批量发券收到线下处理结果 手动发券处理结果
     * @param vo
     * @return
     */
    @ApiOperation(value = "批量发券收到线下处理结果", notes = "批量发券收到线下处理结果", tags = {"券实例接口"},httpMethod = "POST")
    @RequestMapping(value="/updateCouponStatusBatch", method = RequestMethod.POST)
    public ResponseData<Integer> updateCouponStatusBatch(@RequestBody(required = false) CouponStatusUpdateBatchRequestVO vo){
        ResponseData<Integer> responseData = couponEntityService.updateCouponStatusBatch(vo);
        return responseData;
    }


    @ApiOperation(value = "查询活动/任务发送的券的会员列表", notes = "查询活动/任务发送的券的会员列表", tags = {"券实例接口"},httpMethod = "POST")
    @RequestMapping(value="/findCouponSendMemberList", method = RequestMethod.POST)
    public ResponseData<PageInfo<CouponSendMemberListResponseVO>> findCouponSendMemberList(@RequestBody(required = false)CouponSendMemberListRequestVO requestVO){
        return couponEntityService.findCouponSendMemberList(requestVO);
    }
}
