package com.bizvane.couponservice.controller.rpc;

import com.bizvane.centerstageservice.models.po.SysAccountPo;
import com.bizvane.couponfacade.models.po.CouponQuotaDetailPO;
import com.bizvane.couponfacade.models.po.CouponQuotaSendDetailPO;
import com.bizvane.couponfacade.models.vo.CouponEntityVO;
import com.bizvane.couponfacade.models.vo.CouponQuotaDetailVO;
import com.bizvane.couponfacade.utils.PageFormUtil;
import com.bizvane.couponservice.service.CouponQuotaDetailService;
import com.github.pagehelper.PageInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
@RequestMapping("/couponQuotaDetailRpc")
public class CouponQuotaDetailRpcController {
    private static final Logger logger = LoggerFactory.getLogger(CouponQuotaDetailRpcController.class);
    
    @Autowired
    private CouponQuotaDetailService couponQuotaDetailService;
    
    
    /**
     * 券的发放记录列表
     *
     * @param vo
     * @return
     */
    @ApiOperation(value = "企业微信券的发放记录列表", notes = "券的发放记录列表", tags = {"券的发放记录"}, httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "memberCode", value = "会员号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "name", value = "会员名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "couponCode", value = "券号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "couponName", value = "券名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "phone", value = "手机号", required = true, dataType = "String"),
            
            @ApiImplicitParam(name = "couponStatus", value = "20-未使用，25-已过期，30-已核销", required = true, dataType = "String"),
            
            @ApiImplicitParam(name = "pageNumber", value = "当前页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "显示条数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "sysBrandId", value = "品牌id", required = true, dataType = "Integer"),

            
    })
    @ResponseBody
    @RequestMapping(value = "/getList", method = RequestMethod.POST)
    ResponseData<PageInfo<CouponEntityVO>> getList(@RequestBody(required = false)CouponEntityVO vo) {
        logger.info("enter getList method param: getList:{},PageFormUtil:{}", vo);
        SysAccountPo accountPo=new SysAccountPo();
        accountPo.setBrandId(vo.getSysBrandId());
        
        PageFormUtil pageForm=new PageFormUtil();
        pageForm.setPageNumber(vo.getPageNumber());
        pageForm.setPageSize(vo.getPageSize());
        
        return couponQuotaDetailService.getList(vo, accountPo, pageForm);

    }
    
    
    /**
     * 查询我的（导购/店长）可发送优惠券列表接口
     *
     * @param vo
     * @return
     */
    @ApiOperation(value = "查询我的（导购/店长）可发送优惠券列表接口详情列表", notes = "查询我的（导购/店长）可发送优惠券列表接口详情列表", tags = {"详情列表"}, httpMethod = "POST")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "staffcode", value = "员工编号", required = true, dataType = "Long"),
        @ApiImplicitParam(name = "pageNumber", value = "当前页数", required = true, dataType = "Integer"),
        @ApiImplicitParam(name = "pageSize", value = "显示条数", required = true, dataType = "Integer"),
        @ApiImplicitParam(name = "sysBrandId", value = "品牌id", required = true, dataType = "Long"),
    })
    @ResponseBody
    @RequestMapping(value = "/getCouponQuotaListDetail", method = RequestMethod.POST)
    ResponseData<PageInfo<CouponQuotaDetailPO>> getCouponQuotaListDetail(@RequestBody(required = false)CouponQuotaDetailVO vo) {
        logger.info("enter getList method param: getCouponQuotaListDetail:{},PageFormUtil:{}", vo);
        
        SysAccountPo accountPo=new SysAccountPo();
        accountPo.setBrandId(vo.getSysBrandId());
        
        PageFormUtil pageForm=new PageFormUtil();
        pageForm.setPageNumber(vo.getPageNumber());
        pageForm.setPageSize(vo.getPageSize());
        //加时间 ，只查询我的优惠券可发送
        Date currentTime = new Date();
         SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         String dateString = formatter.format(currentTime);
        vo.setExtendNote(dateString);
        
        return couponQuotaDetailService.getCouponQuotaListDetail(vo, accountPo, pageForm);

    }
    
    
    
    @ApiOperation(value = "我的优惠券群发详情", notes = "优惠券群发详情", tags = {"券的配额记录详情列表"}, httpMethod = "POST")
    @ApiImplicitParams({
    	  @ApiImplicitParam(name = "couponQuotaDetailId", value = "品牌id", required = true, dataType = "Long"),
    })
    @ResponseBody
    @RequestMapping(value = "/getSendCouponQuotaListDetailOne", method = RequestMethod.POST)
    ResponseData<CouponQuotaDetailPO> getSendCouponQuotaListDetailOne(@RequestBody(required = false)CouponQuotaDetailVO vo) {
        logger.info("enter getList method param: getSendCouponQuotaListDetailOne:{},PageFormUtil:{}", vo);
        return couponQuotaDetailService.getCouponQuotaListDetail(vo);

    }
    
    
    @ApiOperation(value = "我的优惠券群发历史", notes = "我的优惠券群发历史", tags = {"我的优惠券群发历史"}, httpMethod = "POST")
    @ApiImplicitParams({
    })
    @ResponseBody
    @RequestMapping(value = "/getSendCouponQuotaListDetail", method = RequestMethod.POST)
    ResponseData<PageInfo<CouponQuotaSendDetailPO>> getSendCouponQuotaListDetail(@RequestBody(required = false)CouponQuotaDetailVO vo) {
        logger.info("enter getList method param: getSendCouponQuotaListDetail:{},PageFormUtil:{}", vo);
        
        SysAccountPo accountPo=new SysAccountPo();
        accountPo.setBrandId(vo.getSysBrandId());
        
        PageFormUtil pageForm=new PageFormUtil();
        pageForm.setPageNumber(vo.getPageNumber());
        pageForm.setPageSize(vo.getPageSize());
        
        return couponQuotaDetailService.getSendCouponQuotaListDetail(vo, accountPo, pageForm);

    }
    
    

}