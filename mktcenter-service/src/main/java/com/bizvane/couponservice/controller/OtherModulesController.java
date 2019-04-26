package com.bizvane.couponservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.centerstageservice.models.po.SysAccountPo;
import com.bizvane.centerstageservice.models.po.SysDimSkuPo;
import com.bizvane.centerstageservice.models.po.SysStorePo;
import com.bizvane.centerstageservice.rpc.StoreServiceRpc;
import com.bizvane.centerstageservice.rpc.SysDimSkuServiceRpc;
import com.bizvane.couponfacade.utils.PageFormUtil;
import com.bizvane.couponservice.common.utils.HttpParamUtil;
import com.bizvane.couponservice.common.utils.HttpUtils;
import com.bizvane.couponservice.common.utils.JacksonUtil;
import com.bizvane.couponservice.service.OtherModulesService;
import com.bizvane.members.facade.es.pojo.MembersInfoSearchPojo;
import com.bizvane.members.facade.es.vo.MembersInfoSearchVo;
import com.bizvane.members.facade.service.api.MembersAdvancedSearchApiService;
import com.bizvane.members.facade.vo.MemberInfoVo;
import com.github.pagehelper.PageInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by yunjie.tian on 2018/9/6.
 */
@RestController
@RequestMapping("/otherModules")
public class OtherModulesController {

    private static final Logger logger = LoggerFactory.getLogger(OtherModulesController.class);

    @Autowired
    private StoreServiceRpc storeServiceRpc;

    @Autowired
    private OtherModulesService otherModulesService;

    @Autowired
    private SysDimSkuServiceRpc sysDimSkuServiceRpc;

    @Autowired
    private MembersAdvancedSearchApiService membersAdvancedSearchApiService;


    /**
     * 门店列表
     * @param sysStoreOfflineCode
     * @return
     */
    @ApiOperation(value = "查询店铺分页接口", notes = "查询店铺分页接口", tags = {"中台模块"},httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysStoreOfflineCode", value = "店铺线下编号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "storeName", value = "店铺名称", required = true, dataType = "String")
    })
    @RequestMapping("/staffPage")
    public ResponseData<PageInfo<SysStorePo>> getScreenStaff(@RequestParam(value = "sysStoreOfflineCode",required = false)String sysStoreOfflineCode,
                                                          @RequestParam(value = "storeName",required = false)String storeName,
                                                    PageFormUtil page, HttpServletRequest request){

        ResponseData<PageInfo<SysStorePo>> responseData = storeServiceRpc.getConditionStoreList(sysStoreOfflineCode,storeName,page.getPageNumber(),page.getPageSize());

        return responseData;

    }


    /**
     * 根据高级搜索条件查找会员
     * @param
     * @return
     */
    @ApiOperation(value = "根据高级搜索条件查找会员", notes = "根据高级搜索条件查找会员", tags = {"查询会员列表"},httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "", value = "", required = true, dataType = "String")
    })
    @RequestMapping("/getMemberList")
    public ResponseData<List<MemberInfoVo>> getMemberList(MembersInfoSearchVo memberVO){

        ResponseData<List<MemberInfoVo>> responseData = null;
        try{
            responseData = otherModulesService.searchMembers(memberVO);
        }catch (Exception e){

        }


        return responseData;

    }


    /**
     * 根据商品code和商品名称分页查询列表
     * @param productCode
     * @return
     * */
    @ApiOperation(value = "根据商品code和商品名称分页查询列表", notes = "根据商品code和商品名称分页查询列表", tags = {"中台模块"},httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productCode", value = "商品编码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "productName", value = "商品名称", required = true, dataType = "String")
    })
    @RequestMapping("/getDimSkuList")
    public ResponseData<PageInfo<SysDimSkuPo>> getSysDimSkuList(@RequestParam(value = "productCode",required = false)String productCode,
                                                                @RequestParam(value = "productName",required = false)String productName,
                                                                PageFormUtil page, HttpServletRequest request){


        ResponseData<PageInfo<SysDimSkuPo>> responseData = sysDimSkuServiceRpc.getConditionDimSkuList(productCode,productName,page.getPageNumber(),page.getPageSize());

        return responseData;

    }



    /**
     * 查询es会员
     *
     * @return
     */
    @PostMapping("/memberEs")
    public ResponseData<PageInfo<MembersInfoSearchPojo>> findMemberEsSearch(HttpServletRequest request) {

        MembersInfoSearchVo searchVo = JacksonUtil.json2Objs(HttpParamUtil.getJSONParam(request),
                MembersInfoSearchVo.class);
    	logger.info("enter OtherModulesController findMemberEsSearch method param:MembersInfoSearchVo:{}", JSONObject.toJSONString(searchVo));
    	SysAccountPo accountPo = HttpUtils.getLoginUser(request);
    	searchVo.setBrandId(accountPo.getBrandId());
    	searchVo.setSysCompanyId(accountPo.getSysCompanyId());
    	ResponseData<PageInfo<MembersInfoSearchPojo>> esResult = membersAdvancedSearchApiService.advancedSearch(searchVo);

    	return esResult;

    }
    
    

}
