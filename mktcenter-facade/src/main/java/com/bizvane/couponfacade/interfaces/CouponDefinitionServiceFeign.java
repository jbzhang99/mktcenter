package com.bizvane.couponfacade.interfaces;

import com.bizvane.couponfacade.models.po.CouponDefinitionMoneyPO;
import com.bizvane.couponfacade.models.po.CouponDefinitionPO;
import com.bizvane.couponfacade.models.po.CouponDefinitionPOWithBLOBs;
import com.bizvane.couponfacade.models.vo.CouponDefinitionListQueryVO;
import com.github.pagehelper.PageInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="${feign.client.mktcenter.name}",path="${feign.client.mktcenter.path}/couponDefinitionRpc")
@Api(value = "券定义管理",tags = {"券定义管理"})
public interface CouponDefinitionServiceFeign {

    /**
     * 券定义列表接口
     * @param vo
     * @return
     */
    @ApiOperation(value = "获取券定义列表接口",notes = "获取券定义列表接口",tags = {"券定义接口"},httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysBrandId", value = "品牌id", required = true, dataType = "Long"),
    })
    @RequestMapping(value="/getList", method = RequestMethod.POST)
    ResponseData<PageInfo<CouponDefinitionPO>> getListRpc(@RequestBody CouponDefinitionListQueryVO vo);


    /**
     * 修改券定义接口
     * @param po
     * @return
     */
    @ApiOperation(value = "修改券定义接口",notes = "修改券定义接口",tags = {"券定义接口"},httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "couponDefinitionId", value = "券定义id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "status", value = "券状态（1已启用，0已停用）", required = true, dataType = "Boolean")
    })
    @RequestMapping(value="updateById", method = RequestMethod.POST)
    ResponseData<Object> updateByIdRpc(@RequestBody CouponDefinitionPOWithBLOBs po);
    
    @ApiOperation(value = "涨红包接口", notes = "涨红包接口", tags = {"涨红包接口"},httpMethod = "POST")
    @ApiImplicitParams({
    	
    	 @ApiImplicitParam(name = "taskId", value = "任务taskId", required = true, dataType = "Long")
    })
    @RequestMapping(value="/definitionMoneyRpc", method = RequestMethod.POST)
    public ResponseData<Object> definitionMoneyRpc(@RequestBody CouponDefinitionMoneyPO po);

    /**
     * 查找单个券定义接口
     * @param couponDefinitionId
     * @return
     */
    @ApiOperation(value = "查找单个券定义接口",notes = "查找单个券定义接口",tags = {"券定义接口"},httpMethod = "POST")
    @RequestMapping(value="findById", method = RequestMethod.POST)
    ResponseData<CouponDefinitionPO> findByIdRpc(@RequestParam("couponDefinitionId") Long couponDefinitionId);


    /**
     * 判断券是否过期
     * @param couponDefinitionId
     * @return
     */
    @ApiOperation(value = "判断券是否过期",notes = "判断券是否过期",tags = {"券定义接口"},httpMethod = "POST")
    @RequestMapping(value="couponDefinitionExpire", method = RequestMethod.POST)
    ResponseData<Boolean> couponDefinitionExpire(@RequestParam("couponDefinitionId") Long couponDefinitionId);


}
