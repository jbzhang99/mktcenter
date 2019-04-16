package com.bizvane.couponfacade.interfaces;

import com.bizvane.couponfacade.models.po.CouponQuotaDetailPO;
import com.bizvane.couponfacade.models.po.CouponQuotaSendDetailPO;
import com.bizvane.couponfacade.models.vo.CouponEntityVO;
import com.bizvane.couponfacade.models.vo.CouponQuotaDetailVO;
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
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yunjie.tian on 2018/8/7.
 */
@FeignClient(value="${feign.client.mktcenter.name}",path="${feign.client.mktcenter.path}/couponQuotaDetailRpc")
@Api(value = "企业微信配额接口",tags = {"配额接口"})
public interface CouponQuotaDetailServiceFeign {
	
	
	
	
	
    @ApiOperation(value = "企业微信券的发放记录列表", notes = "券的发放记录列表", tags = {"券的发放记录"}, httpMethod = "POST")
    @ApiImplicitParams({
//            @ApiImplicitParam(name = "memberCode", value = "会员号", required = true, dataType = "String"),
//            @ApiImplicitParam(name = "name", value = "会员名称", required = true, dataType = "String"),
//            @ApiImplicitParam(name = "couponCode", value = "券号", required = true, dataType = "String"),
//            @ApiImplicitParam(name = "couponName", value = "券名称", required = true, dataType = "String"),
//            @ApiImplicitParam(name = "phone", value = "手机号", required = true, dataType = "String"),
            
            @ApiImplicitParam(name = "baseSearchValue", value = "高级查询", required = true, dataType = "String"),
            @ApiImplicitParam(name = "staffcode", value = "员工编号", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "couponStatus", value = "20-未使用，25-已过期，30-已核销", required = true, dataType = "String"),
            @ApiImplicitParam(name = "pageNumber", value = "当前页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "显示条数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "sysBrandId", value = "品牌id", required = true, dataType = "Integer"),
            
    })
    @ResponseBody
    @RequestMapping(value = "/getList", method = RequestMethod.POST)
    ResponseData<PageInfo<CouponEntityVO>> getList(@RequestBody(required = false) CouponEntityVO vo) ;



    /**
     * 查询我的（导购/店长）可发送优惠券列表接口（ 后台配置）
     *
     * @param vo
     * @return
     */
    @ApiOperation(value = "查询我的（导购/店长）可发送优惠券列表接口（ 后台配置）", notes = "查询我的（导购/店长）可发送优惠券列表接口（ 后台配置）", tags = {"查询我的（导购/店长）可发送优惠券列表接口（ 后台配置）"}, httpMethod = "POST")
    @ApiImplicitParams({


            //券来源：后台做员工的优惠券配额类型可以用注释下面接口参数,查询我的（导购/店长）可发送优惠券列表接口（ 后台配置）
    	    @ApiImplicitParam(name = "couponName", value = "券名称", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "staffcode", value = "员工编号", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "pageNumber", value = "当前页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "显示条数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "sysBrandId", value = "品牌id", required = true, dataType = "Long"),
    })
    @ResponseBody
    @RequestMapping(value = "/getCouponQuotaListDetail", method = RequestMethod.POST)
    ResponseData<PageInfo<CouponQuotaDetailPO>> getCouponQuotaListDetail(@RequestBody(required = false) CouponQuotaDetailVO vo) ;


    /**
     * 我的优惠券群发历史
     *
     * @param vo
     * @return
     */
    @ApiOperation(value = "我的优惠券群发历史", notes = "优惠券群发历史", tags = {"券的配额记录详情列表"}, httpMethod = "POST")
    @ApiImplicitParams({

            // 查询我的优惠券群发历史列表接口，返回每次发送的时间，群发会员名称ID和券详情，
            @ApiImplicitParam(name = "staffcode", value = "员工编号", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "pageNumber", value = "当前页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "显示条数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "sysBrandId", value = "品牌id", required = true, dataType = "Long"),
    })
    @ResponseBody
    @RequestMapping(value = "/getSendCouponQuotaListDetail", method = RequestMethod.POST)
    ResponseData<PageInfo<CouponQuotaSendDetailPO>> getSendCouponQuotaListDetail(@RequestBody(required = false) CouponQuotaDetailVO vo) ;


    /**
     * 我的优惠券群发历史
     *
     * @param vo
     * @return
     */
    @ApiOperation(value = "我的优惠券群发详情", notes = "优惠券群发详情", tags = {"券的配额记录详情列表"}, httpMethod = "POST")
    @ApiImplicitParams({
    	  @ApiImplicitParam(name = "couponQuotaDetailId", value = "品牌id", required = true, dataType = "Long"),
    })
    @ResponseBody
    @RequestMapping(value = "/getSendCouponQuotaListDetailOne", method = RequestMethod.POST)
    ResponseData<CouponQuotaSendDetailPO> getSendCouponQuotaListDetailOne(@RequestBody(required = false) CouponQuotaDetailVO vo) ;

}
