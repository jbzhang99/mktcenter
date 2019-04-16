package com.bizvane.couponservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.centerstageservice.models.po.SysAccountPo;
import com.bizvane.couponfacade.models.po.CouponSendFailLogPO;
import com.bizvane.couponfacade.models.vo.CouponSendFailLogVO;
import com.bizvane.couponfacade.utils.PageFormUtil;
import com.bizvane.couponservice.common.utils.HttpUtils;
import com.bizvane.couponservice.service.SendCouponService;
import com.github.pagehelper.PageInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yunjie.tian on 2018/7/30.
 */
@RestController
@RequestMapping("/sendCoupon")
public class CouponSendFailLogController {
    private static final Logger logger = LoggerFactory.getLogger(CouponSendFailLogController.class);
    @Autowired
    private SendCouponService sendCouponService;

    /**
     * 发券失败查询
     * @param vo
     * @return
     */
    @ApiOperation(value = "发券失败查询", notes = "发券失败查询", tags = {"发券失败查询"},httpMethod = "POST")
    @RequestMapping("/couponSendFail.do")
    public ResponseData<PageInfo> couponSendFail(CouponSendFailLogVO vo, PageFormUtil pageForm, HttpServletRequest request){
        logger.info("enter couponSendFail method param: CouponSendFailLogVO:{},PageFormUtil:{}", JSONObject.toJSONString(vo),JSONObject.toJSONString(pageForm));
        SysAccountPo accountPo = HttpUtils.getLoginUser(request);
        return sendCouponService.couponSendFail(vo,accountPo,pageForm);
    }

    /**
     *  根据id修改券发放失败信息
     * @return
     */
    @ApiOperation(value = "根据id修改券发放失败信息", notes = "根据id修改券发放失败信息", tags = {"发券失败查询"},httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "couponSendFailLogId", value = "主键id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "sendStatus", value = "补发状态（1待补发，2已补发）", required = true, dataType = "Byte"),
    })
    @RequestMapping("/update.do")
    public ResponseData<Object> update(CouponSendFailLogPO couponSendFailLogPO){
        logger.info("enter update method param: CouponSendFailLogPO:{}",JSONObject.toJSONString(couponSendFailLogPO));
        return sendCouponService.update(couponSendFailLogPO);
    }

}
