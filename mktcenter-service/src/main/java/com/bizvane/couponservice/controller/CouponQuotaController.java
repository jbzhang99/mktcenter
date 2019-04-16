package com.bizvane.couponservice.controller;

import com.bizvane.centerstageservice.models.po.SysAccountPo;
import com.bizvane.couponfacade.models.po.CouponQuotaDetailPO;
import com.bizvane.couponfacade.models.po.CouponQuotaPO;
import com.bizvane.couponfacade.models.vo.CouponQuotaDetailVO;
import com.bizvane.couponfacade.models.vo.CouponQuotaVO;
import com.bizvane.couponfacade.utils.PageFormUtil;
import com.bizvane.couponservice.common.utils.HttpUtils;
import com.bizvane.couponservice.service.CouponQuotaService;
import com.github.pagehelper.PageInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by yunjie.tian on 2018/7/20.
 */
@RestController
@RequestMapping("/couponQuota")
public class CouponQuotaController {
    private static final Logger logger = LoggerFactory.getLogger(CouponQuotaController.class);
    
    @Autowired
    private CouponQuotaService couponQuotaService;
    
    
    
    
    
    /**
     * 券的配额记录列表
     *
     * @param vo
     * @return
     */
    @ApiOperation(value = "券的配额开关", notes = "券的配额开关", tags = {"券的配额开关"}, httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "state", value = "数据有效性（1启用，  0禁用）", required = true, dataType = "String"),
            @ApiImplicitParam(name = "couponQuotaId", value = "券配额表主键id", required = true, dataType = "Long"),

    })
    @ResponseBody
    @RequestMapping(value = "/updateBycouponQuotaId.do", method = RequestMethod.POST)
    ResponseData<String> updateBycouponQuotaId(CouponQuotaVO vo, HttpServletRequest request) {
        logger.info("enter getList method param: updateBycouponQuotaId:{},PageFormUtil:{}", vo);
        SysAccountPo accountPo = HttpUtils.getLoginUser(request);
        return couponQuotaService.updateBycouponQuotaId(vo, accountPo);

    }
    
    
    /**
     * 配额记录详情列表
     *
     * @param vo
     * @return
     */
    @ApiOperation(value = "券的点击配额记录详情列表", notes = "券的点击配额记录详情列表", tags = {"券的点击配额记录详情列表"}, httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "baseSearchValue", value = "高级搜索", required = true, dataType = "String"),
            @ApiImplicitParam(name = "couponQuotaId", value = "券配额表主键id", required = true, dataType = "Long"),
            
            @ApiImplicitParam(name = "pageNumber", value = "当前页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "显示条数", required = true, dataType = "Integer"),

    })
    @ResponseBody
    @RequestMapping(value = "/getCouponQuotaListDetail.do", method = RequestMethod.POST)
    ResponseData<PageInfo<CouponQuotaDetailPO>> getCouponQuotaListDetail(CouponQuotaDetailVO vo, HttpServletRequest request, PageFormUtil pageForm) {
        logger.info("enter getList method param: getCouponQuotaListDetail:{},PageFormUtil:{}", vo, pageForm);
        SysAccountPo accountPo = HttpUtils.getLoginUser(request);
        return couponQuotaService.getCouponQuotaListDetail(vo, accountPo, pageForm);

    }
    
    
    /**
     * 
     *
     * @param vo
     * @return
     */
    @ApiOperation(value = "券配额编辑查询", notes = "券配额编辑查询", tags = {"券配额编辑查询"}, httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "couponQuotaId", value = "券配额表主键id", required = true, dataType = "Long"),
    })
    @ResponseBody
    @RequestMapping(value = "/getCouponQuotaListDetailforupdate.do", method = RequestMethod.POST)
    ResponseData<List<CouponQuotaDetailPO>> getCouponQuotaListDetailforupdate(CouponQuotaDetailVO vo, HttpServletRequest request) {
        logger.info("enter getList method param: getCouponQuotaListDetailforupdate:{},PageFormUtil:{}", vo);
        SysAccountPo accountPo = HttpUtils.getLoginUser(request);
        return couponQuotaService.getCouponQuotaListDetailforupdate(vo, accountPo);

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
    @RequestMapping(value = "/getCouponQuotaList.do", method = RequestMethod.POST)
    ResponseData<PageInfo<CouponQuotaPO>> getCouponQuotaList(CouponQuotaVO vo, HttpServletRequest request, PageFormUtil pageForm) {
        logger.info("enter getList method param: getCouponQuotaList:{},PageFormUtil:{}", vo, pageForm);
        SysAccountPo accountPo = HttpUtils.getLoginUser(request);
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
            @ApiImplicitParam(name = "startDate", value = "开始时间", required = true, dataType = "String"),
            @ApiImplicitParam(name = "endDate", value = "结束时间", required = true, dataType = "String"),
            @ApiImplicitParam(name = "staffCodeList", value = "分配员工编号", required = true, dataType = "A员工编号1,编号1"),
            @ApiImplicitParam(name = "staffNameList", value = "分配员工名称(编号和名称顺序对应)", required = true, dataType = "A员工名称1,名称2"),
            
            @ApiImplicitParam(name = "couponQuotaId", value = "配额id，如果是修改就多传这个字段", required = true, dataType = "String,String"),
            
            
    })
    @ResponseBody
    @RequestMapping(value = "/createCouponQuota.do", method = RequestMethod.POST)
    ResponseData<Long> createCouponQuota(CouponQuotaVO vo, HttpServletRequest request) {
        logger.info("enter createCouponQuota method param: CouponQuotaVO:{},PageFormUtil:{}", vo);
        SysAccountPo accountPo = HttpUtils.getLoginUser(request);
        return couponQuotaService.add(vo, accountPo);

    }






}