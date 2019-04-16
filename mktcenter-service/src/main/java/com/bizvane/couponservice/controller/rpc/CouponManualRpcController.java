package com.bizvane.couponservice.controller.rpc;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.couponfacade.models.po.CouponManualPO;
import com.bizvane.couponfacade.models.vo.CouponManualVO;
import com.bizvane.couponfacade.utils.PageFormUtil;
import com.bizvane.couponservice.service.CouponManualService;
import com.github.pagehelper.PageInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yunjie.tian on 2018/8/8.
 */
@RestController
@RequestMapping("/couponManualRpc")
public class CouponManualRpcController {

    private static final Logger logger = LoggerFactory.getLogger(CouponManualRpcController.class);

    @Autowired
    private CouponManualService couponManualService;


    @ApiOperation(value = "查询手动发券列表接口", notes = "查询手动发券列表接口", tags = {"手动发券接口"},httpMethod = "POST")
    @RequestMapping(value="/getList", method = RequestMethod.POST)
    ResponseData<PageInfo<CouponManualVO>> getListRpc(@RequestBody CouponManualVO vo){
        logger.info("enter getListRpc method param: CouponManualVO:{}", JSONObject.toJSONString(vo));
        PageFormUtil pageForm = new PageFormUtil();
        pageForm.setPageNumber(vo.getPageNumber());
        pageForm.setPageSize(vo.getPageSize());
        return couponManualService.getListRpc(vo,pageForm);

    }

    @ApiOperation(value = "更改发送状态接口", notes = "更改发送状态接口", tags = {"手动发券接口"},httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "couponManualId", value = "手动发券id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "taskStatus", value = "审核状态", required = true, dataType = "Byte")
    })
    @RequestMapping(value="/changeTask", method = RequestMethod.POST)
    ResponseData<Integer> changeTaskRpc(@RequestBody CouponManualPO po){
        logger.info("enter changeTaskRpc method param: CouponManualPO:{}", JSONObject.toJSONString(po));
        return couponManualService.changeTask(po);

    }
}
