package com.bizvane.couponservice.controller.rpc;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.couponfacade.models.po.CouponDefinitionMoneyPO;
import com.bizvane.couponfacade.models.po.CouponDefinitionPO;
import com.bizvane.couponfacade.models.po.CouponDefinitionPOWithBLOBs;
import com.bizvane.couponfacade.models.vo.CouponDefinitionListQueryVO;
import com.bizvane.couponfacade.utils.PageFormUtil;
import com.bizvane.couponservice.service.CouponDefinitionService;
import com.github.pagehelper.PageInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yunjie.tian on 2018/8/8.
 */
@RestController
@RequestMapping("/couponDefinitionRpc")
public class CouponDefinitionRpcController {

    private static final Logger logger = LoggerFactory.getLogger(CouponDefinitionRpcController.class);

    @Autowired
    private CouponDefinitionService couponDefinitionService;

    /**
     * 券定义列表接口
     * @param vo
     * @return
     */
    @RequestMapping(value = "/getList",method = RequestMethod.POST)
    @ApiOperation(value = "获取券定义列表接口",notes = "获取券定义列表接口",tags = {"券定义接口"},httpMethod = "POST")
    public ResponseData<PageInfo<CouponDefinitionPO>> getListRpc(@RequestBody CouponDefinitionListQueryVO vo) {
        logger.info("enter getListRpc method param:CouponDefinitionListQueryVO:{}", JSONObject.toJSONString(vo));

        PageFormUtil pageForm = new PageFormUtil();
        pageForm.setPageNumber(vo.getPageNumber());
        pageForm.setPageSize(vo.getPageSize());

        return couponDefinitionService.getListRpc(vo,pageForm);
    }


    /**
     * 修改券定义
     * @param po
     * @return
     */
    @ApiOperation(value = "根据id修改券信息接口", notes = "根据id修改券信息接口", tags = {"券定义接口"},httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "couponDefinitionId", value = "券定义id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "status", value = "券状态（1已启用，0已停用）", required = true, dataType = "Boolean"),
            @ApiImplicitParam(name = "sysBrandId", value = "品牌id", required = true, dataType = "Long")
    })
    @RequestMapping(value="/updateById", method = RequestMethod.POST)
    public ResponseData<Object> updateRpc(@RequestBody CouponDefinitionPOWithBLOBs po){
        logger.info("enter updateRpc method param:CouponDefinitionPOWithBLOBs:{}",JSONObject.toJSONString(po));
        return couponDefinitionService.update(po);

    }
    
    
    @ApiOperation(value = "涨红包接口", notes = "涨红包接口", tags = {"涨红包接口"},httpMethod = "POST")
    @ApiImplicitParams({
    	
    	 @ApiImplicitParam(name = "taskId", value = "品牌taskId", required = true, dataType = "Long")
    })
    @RequestMapping(value="/definitionMoneyRpc", method = RequestMethod.POST)
    public ResponseData<Object> definitionMoneyRpc(@RequestBody CouponDefinitionMoneyPO po){
        logger.info("enter updateRpc method param:CouponDefinitionPOWithBLOBs:{}",JSONObject.toJSONString(po));
        return couponDefinitionService.definitionMoneyRpc(po);
    }


    /**
     * 查找单张券接口
     * @param couponDefinitionId
     * @return
     */
    @ApiOperation(value = "复制：根据id查找单张券接口", notes = "复制：根据id查找单张券接口", tags = {"券定义接口"},httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "couponDefinitionId", value = "券定义id", required = true, dataType = "Long")
    })
    @RequestMapping(value="/findById", method = RequestMethod.POST)
    public ResponseData<CouponDefinitionPOWithBLOBs> findByIdRpc(@RequestParam(value = "couponDefinitionId",required = false)Long couponDefinitionId){
        logger.info("enter findByIdRpc method param:couponDefinitionId:{}",couponDefinitionId);
        return couponDefinitionService.getCouponDefinition(couponDefinitionId);

    }


    /**
     * 判断券是否过期
     * @param couponDefinitionId
     * @return
     */
    @ApiOperation(value = "判断券是否过期",notes = "判断券是否过期",tags = {"券定义接口"},httpMethod = "POST")
    @RequestMapping(value="couponDefinitionExpire", method = RequestMethod.POST)
    public ResponseData<Boolean> couponDefinitionExpire(@RequestParam("couponDefinitionId") Long couponDefinitionId){
        logger.info("enter couponDefinitionExpire method param:couponDefinitionId:{}",couponDefinitionId);
        try {
            return couponDefinitionService.couponDefinitionExpire(couponDefinitionId);
        }catch (Exception e){

            logger.info("couponDefinitionExpire Exception ! exception:{}",JSONObject.toJSONString(e));
        }

        return new ResponseData<>();
    }


}
