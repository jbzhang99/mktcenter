package com.bizvane.couponservice.controller.rpc;

import com.bizvane.centerstageservice.models.po.SysAccountPo;
import com.bizvane.couponfacade.models.po.CouponQuotaDetailPO;
import com.bizvane.couponfacade.models.po.CouponQuotaPO;
import com.bizvane.couponfacade.models.vo.CouponQuotaDetailVO;
import com.bizvane.couponfacade.models.vo.CouponQuotaVO;
import com.bizvane.couponfacade.utils.PageFormUtil;
import com.bizvane.couponservice.service.CouponQuotaService;
import com.github.pagehelper.PageInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/couponQuotaRpc")
public class CouponQuotaRpcController {
    private static final Logger logger = LoggerFactory.getLogger(CouponQuotaRpcController.class);
    
    @Autowired
    private CouponQuotaService couponQuotaService;
    
    
    /**
     * 券的配额记录列表
     *
     * @param vo
     * @return
     */
    @ApiOperation(value = "券的配额记录详情列表", notes = "券的配额记录详情列表", tags = {"券的配额记录详情列表"}, httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "baseSearchValue", value = "高级搜索", required = true, dataType = "String"),
            @ApiImplicitParam(name = "couponQuotaId", value = "券配额表主键id", required = true, dataType = "Long"),
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
        
        return couponQuotaService.getCouponQuotaListDetail(vo, accountPo, pageForm);

    }
    
    
    /**
     * 券的配额记录列表
     *
     * @param vo
     * @return
     */
    @ApiOperation(value = "券的配额记录列表", notes = "券的配额记录列表", tags = {"券的配额记录列表"}, httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "baseSearchValue", value = "高级搜索", required = true, dataType = "String"),
            @ApiImplicitParam(name = "quotaTopic", value = "分配主题", required = true, dataType = "String"),
            @ApiImplicitParam(name = "couponName", value = "券名称", required = true, dataType = "String"),
            
            @ApiImplicitParam(name = "startDateStart", value = "开始时间-开始", required = true, dataType = "String"),
            @ApiImplicitParam(name = "startDateEnd", value = "开始时间-结束", required = true, dataType = "String"),
            
            @ApiImplicitParam(name = "endDateStart", value = "截止时间-开始", required = true, dataType = "String"),
            @ApiImplicitParam(name = "endDateEnd", value = "截止时间-结束", required = true, dataType = "String"),
            
            @ApiImplicitParam(name = "createDateStart", value = "创建时间-开始", required = true, dataType = "String"),
            @ApiImplicitParam(name = "createDateEnd", value = "创建时间-结束", required = true, dataType = "String"),
            
            

    })
    @ResponseBody
    @RequestMapping(value = "/getCouponQuotaList", method = RequestMethod.POST)
    ResponseData<PageInfo<CouponQuotaPO>> getCouponQuotaList(@RequestBody(required = false)CouponQuotaVO vo) {
        logger.info("enter getList method param: getCouponQuotaList:{},PageFormUtil:{}", vo);
        SysAccountPo accountPo=new SysAccountPo();
        accountPo.setBrandId(vo.getSysBrandId());
        
        PageFormUtil pageForm=new PageFormUtil();
        pageForm.setPageNumber(vo.getPageNumber());
        pageForm.setPageSize(vo.getPageSize());
        
        return couponQuotaService.getCouponQuotaList(vo, accountPo, pageForm);

    }

    /**
     * @param vo
     * @return
     */
    @ApiOperation(value = "新建配额任务", notes = "新建配额任务", tags = {"新建配额任务"}, httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "quotaTopic", value = "分配主题", required = true, dataType = "String"),
            @ApiImplicitParam(name = "couponDefinitionId", value = "优惠券定义id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "memberAverage", value = "人均张数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "startDate", value = "开始时间", required = true, dataType = "Date"),
            @ApiImplicitParam(name = "endDate", value = "结束时间", required = true, dataType = "Date"),
            @ApiImplicitParam(name = "staffCodeList", value = "分配员工", required = true, dataType = "List<String>"),
            
    })
    @ResponseBody
    @RequestMapping(value = "/createCouponQuota", method = RequestMethod.POST)
    ResponseData<Long> createCouponQuota(@RequestBody(required = false)CouponQuotaVO vo) {
        logger.info("enter createCouponQuota method param: CouponQuotaVO:{},PageFormUtil:{}", vo);
        SysAccountPo accountPo=new SysAccountPo();
        accountPo.setBrandId(vo.getSysBrandId());
        accountPo.setSysCompanyId(vo.getSysCompanyId());
        accountPo.setCreateUserId(vo.getCreateUserId());
        accountPo.setCreateUserName(vo.getCreateUserName());
        
        return couponQuotaService.add(vo, accountPo);

    }






}