package com.bizvane.couponfacade.interfaces;

import com.bizvane.couponfacade.models.po.CouponQuotaDetailPO;
import com.bizvane.couponfacade.models.po.CouponQuotaPO;
import com.bizvane.couponfacade.models.vo.CouponQuotaDetailVO;
import com.bizvane.couponfacade.models.vo.CouponQuotaVO;
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
@FeignClient(value="${feign.client.mktcenter.name}",path="${feign.client.mktcenter.path}/couponQuotaRpc")
@Api(value = "企业微信配额接口",tags = {"配额接口"})
public interface CouponQuotaServiceFeign {


    /**
     * 券的配额详情列表
     *
     * @param vo
     * @return
     */
    @ApiOperation(value = "券的配额记录详情列表", notes = "券的配额记录详情列表", tags = {"券的配额记录详情列表"}, httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "baseSearchValue", value = "高级搜索 姓名/所属店铺名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "couponQuotaId", value = "券配额表主键id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "pageNumber", value = "当前页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "显示条数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "sysBrandId", value = "品牌id", required = true, dataType = "Long"),

    })
    @ResponseBody
    @RequestMapping(value = "/getCouponQuotaListDetail", method = RequestMethod.POST)
    ResponseData<PageInfo<CouponQuotaDetailPO>> getCouponQuotaListDetail(@RequestBody(required = false) CouponQuotaDetailVO vo) ;

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

            @ApiImplicitParam(name = "pageNumber", value = "当前页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "显示条数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "sysBrandId", value = "品牌id", required = true, dataType = "Long"),



    })
    @ResponseBody
    @RequestMapping(value = "/getCouponQuotaList", method = RequestMethod.POST)
    ResponseData<PageInfo<CouponQuotaPO>> getCouponQuotaList(@RequestBody(required = false) CouponQuotaVO vo);



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

            @ApiImplicitParam(name = "sysCompanyId", value = "企业id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "sysBrandId", value = "品牌id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "createUserId", value = "创建人id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "createUserName", value = "id", required = true, dataType = "String"),

    })
    @ResponseBody
    @RequestMapping(value = "/createCouponQuota", method = RequestMethod.POST)
    ResponseData<Long> createCouponQuota(@RequestBody(required = false) CouponQuotaVO vo);
}
