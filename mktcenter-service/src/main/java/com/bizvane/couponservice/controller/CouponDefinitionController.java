package com.bizvane.couponservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.centercontrolservice.models.po.DefCouponConfigurePO;
import com.bizvane.centercontrolservice.rpc.DefCouponConfigureRpc;
import com.bizvane.centerstageservice.models.po.SysAccountPo;
import com.bizvane.centerstageservice.models.po.SysDimSkuPo;
import com.bizvane.centerstageservice.models.po.SysStorePo;
import com.bizvane.couponfacade.models.po.CouponDefinitionCodePO;
import com.bizvane.couponfacade.models.po.CouponDefinitionPO;
import com.bizvane.couponfacade.models.po.CouponDefinitionPOWithBLOBs;
import com.bizvane.couponfacade.models.vo.CouponDefinitionCodeQueryVO;
import com.bizvane.couponfacade.models.vo.CouponDefinitionListQueryVO;
import com.bizvane.couponfacade.utils.PageFormUtil;
import com.bizvane.couponservice.common.utils.HttpUtils;
import com.bizvane.couponservice.service.CouponDefinitionService;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.PageInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/couponDefinition")
public class CouponDefinitionController{

    private static final Logger logger = LoggerFactory.getLogger(CouponDefinitionController.class);

    @Autowired
    private CouponDefinitionService couponDefinitionService;
    @Autowired
    private DefCouponConfigureRpc defCouponConfigureRpc;//中控


    /**
     * 券定义列表
     * @param vo
     * @return
     */
    @ApiOperation(value = "查询券定义列表", notes = "查询券定义列表", tags = {"券定义列表"},httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "couponName", value = "券名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "preferentialType", value = "优惠形式（1现金，2折扣，3礼品)", required = true, dataType = "byte"),
            @ApiImplicitParam(name = "status", value = "券状态（1已启用，0已停用）", required = true, dataType = "Boolean"),
            @ApiImplicitParam(name = "createDateStart", value = "创建时间开始", required = true, dataType = "String"),
            @ApiImplicitParam(name = "createDateEnd", value = "创建时间结束", required = true, dataType = "String"),
            @ApiImplicitParam(name = "useChannel", value = "适用渠道（1仅线上，2仅线下，3全渠道）", required = true, dataType = "String"),
            @ApiImplicitParam(name = "createUserName", value = "创建人", required = true, dataType = "String"),
            @ApiImplicitParam(name = "couponDefinitionId", value = "券定义id", required = true, dataType = "Long")
    })
    @RequestMapping("/getList.do")
    public ResponseData<PageInfo<CouponDefinitionPO>> getList(HttpServletRequest request, CouponDefinitionListQueryVO vo) {
        logger.info("enter getList method param:CouponDefinitionListQueryVO:{}", JSONObject.toJSONString(vo));
        
      SysAccountPo sysAccountPo =  HttpUtils.getLoginUser(request);
      PageFormUtil pageForm = new PageFormUtil();
      pageForm.setPageNumber(vo.getPageNumber());
      pageForm.setPageSize(vo.getPageSize());
      
      return couponDefinitionService.getList(vo,pageForm,sysAccountPo.getBrandId(),sysAccountPo.getSysCompanyId());
    }
    
    
    
    
    /**
     * 线下券号列表查询
     * @param vo
     * @return
     */
    @ApiOperation(value = "线下券号列表查询", notes = "线下券号列表查询", tags = {"线下券号列表查询"},httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "couponName", value = "券名称", required = true, dataType = "String"),

    })
    @RequestMapping("/getListDefinitionCode")
    public ResponseData<PageInfo<CouponDefinitionCodePO>> getListDefinitionCode(HttpServletRequest request, CouponDefinitionCodeQueryVO vo) {
        logger.info("enter getList method param:CouponDefinitionListQueryVO:{}", JSONObject.toJSONString(vo));
        
      SysAccountPo sysAccountPo =  HttpUtils.getLoginUser(request);
      PageFormUtil pageForm = new PageFormUtil();
      pageForm.setPageNumber(vo.getPageNumber());
      pageForm.setPageSize(vo.getPageSize());
      
      return couponDefinitionService.getListDefinitionCode(vo,pageForm,sysAccountPo.getBrandId(),sysAccountPo.getSysCompanyId());
    }

    /**
     * 添加券定义
     * @param po
     * @return
     */
    @ApiOperation(value = "券保存", notes = "券保存", tags = {"定义券"},httpMethod = "POST")
    @RequestMapping(value="/add.do", method = RequestMethod.POST)
    public ResponseData<Long> add(CouponDefinitionPOWithBLOBs po,HttpServletRequest request){
        logger.info("enter add method param:CouponDefinitionPOWithBLOBs:{}", JSONObject.toJSONString(po));
       SysAccountPo accountPo = HttpUtils.getLoginUser(request);
      return couponDefinitionService.add(po,accountPo);
      
    }

    /**
     * 修改券定义
     * @param po
     * @return
     */
    @ApiOperation(value = "修改券状态", notes = "修改券状态", tags = {"券定义列表"},httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "couponDefinitionId", value = "券定义id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "status", value = "券状态（1已启用，0已停用）", required = true, dataType = "Boolean"),
    })
    @RequestMapping(value="/update.do", method = RequestMethod.POST)
    public ResponseData<Object> update(CouponDefinitionPOWithBLOBs po){
        logger.info("enter update method param:CouponDefinitionPOWithBLOBs:{}", JSONObject.toJSONString(po));
      return couponDefinitionService.update(po);
      
    }


    /**
     * 查找单张券
     * @param couponDefinitionId
     * @return
     */
    @ApiOperation(value = "复制:查找单张券", notes = "复制：查找单张券", tags = {"券定义列表"},httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "couponDefinitionId", value = "券定义id", required = true, dataType = "Long")
    })
    @RequestMapping(value="/find.do", method = RequestMethod.POST)
    public ResponseData<CouponDefinitionPOWithBLOBs> getCouponDefinition(@RequestParam(value = "couponDefinitionId",required = false)Long couponDefinitionId){
        logger.info("enter getCouponDefinition method param:couponDefinitionId:{}",couponDefinitionId);
        return couponDefinitionService.getCouponDefinition(couponDefinitionId);
      
    }

    /**
     * 券自定义模板查询
     * @param couponDefinitionPO
     * @return
     */
    @ApiOperation(value = "券自定义模板查询", notes = "券自定义模板查询", tags = {"定义券"},httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "createUserId", value = "用户id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "couponName", value = "券名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "preferentialType", value = "券类型", required = true, dataType = "Byte")
    })
    @RequestMapping(value="/getTemplate.do", method = RequestMethod.POST)
    public ResponseData<PageInfo> getTemplate(CouponDefinitionPO couponDefinitionPO, PageFormUtil pageFormUtil,
                                              HttpServletRequest request){
        logger.info("enter getTemplate method param:couponDefinitionPO:{},PageFormUtil:{}",JSONObject.toJSONString(couponDefinitionPO),JSONObject.toJSONString(pageFormUtil));
        SysAccountPo accountPo = HttpUtils.getLoginUser(request);
        return couponDefinitionService.getTemplate(couponDefinitionPO,pageFormUtil,accountPo);

    }

    /**
     * 线下券类型获取
     * @return
     */
    @ApiOperation(value = "线下券类型获取", notes = "线下券类型获取", tags = {"定义券"},httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "isConfigure", value = "券定义类型：1-线上定义，2-erp生成", required = true, dataType = "Long"),
    })
    @RequestMapping("/getDefinitionType.do")
    public ResponseData<Object> getDefinitionType(HttpServletRequest request) {
        logger.info("enter getDefinitionType method param:{}");
        ResponseData<Object> responseData = new ResponseData<>();

        SysAccountPo accountPo = HttpUtils.getLoginUser(request);
        Long sysCompanyId = accountPo.getSysCompanyId();
        Long sysBrandId = accountPo.getBrandId();

        if(null == sysCompanyId){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage("企业id不能为空");
            return responseData;
        }
        if(null == sysBrandId){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage("品牌id不能为空");
            return responseData;
        }

        List<DefCouponConfigurePO> list = defCouponConfigureRpc.getDefCouponConfigure(sysCompanyId,sysBrandId);
        if(null == list || list.size()==0){
            responseData.setMessage(SysResponseEnum.OPERATE_FAILED_DATA_NOT_EXISTS.getMessage());
            return responseData;
        }
        responseData.setData(list.get(0));
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }

    /**
     * 查询可用的券信息
     * @param vo
     * @return
     */
    @ApiOperation(value = "查询可用的券信息", notes = "查询可用的券信息", tags = {"券定义列表"},httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "couponName", value = "券名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "couponDefinitionId", value = "券定义id", required = true, dataType = "Long")
    })
    @RequestMapping("/getUseList.do")
    public ResponseData<PageInfo<CouponDefinitionPO>> getUseList(HttpServletRequest request,CouponDefinitionListQueryVO vo,
                                                                 PageFormUtil pageForm) {
        logger.info("enter getList method param:CouponDefinitionListQueryVO:{}", JSONObject.toJSONString(vo));

        SysAccountPo sysAccountPo = HttpUtils.getLoginUser(request);

        return couponDefinitionService.getUseList(vo,pageForm,sysAccountPo.getBrandId());
    }


    /**
     * 查询商品信息列表
     * @return
     */
    @ApiOperation(value = "查询商品信息列表", notes = "查询商品信息列表", tags = {"券定义列表"},httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "order", value = "商品名单id", required = true, dataType = "String"),
            @ApiImplicitParam(name = "productCode", value = "商品code", required = true, dataType = "String"),
            @ApiImplicitParam(name = "productName", value = "商品名称", required = true, dataType = "String")
    })
    @RequestMapping("/getIdSysDimSkuList.do")
    public ResponseData<PageInfo<SysDimSkuPo>> getIdSysDimSkuList(@RequestParam(value = "order",required = false) String order,
                                                   @RequestParam(value = "productCode",required = false) String productCode,
                                                   @RequestParam(value = "productName",required = false) String productName,
                                                   PageFormUtil page,HttpServletRequest request) {
        logger.info("enter getDimSkuList method param:order:{}", order);

        SysAccountPo sysAccountPo = HttpUtils.getLoginUser(request);

        return couponDefinitionService.getIdSysDimSkuList(order,productCode,productName,page,sysAccountPo);
    }

    /**
     * 查询门店信息列表
     * @return
     */
    @ApiOperation(value = "查询门店信息列表", notes = "查询门店信息列表", tags = {"券定义列表"},httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "store", value = "门店名单id", required = true, dataType = "String"),
            @ApiImplicitParam(name = "sysStoreOfflineCode", value = "门店code", required = true, dataType = "String"),
            @ApiImplicitParam(name = "storeName", value = "门店名称", required = true, dataType = "String")
    })
    @RequestMapping("/getIdStoreList.do")
    public ResponseData<PageInfo<SysStorePo>> getIdStoreList(@RequestParam(value = "store",required = false)String store,
                                                             @RequestParam(value = "sysStoreOfflineCode",required = false) String sysStoreOfflineCode,
                                                             @RequestParam(value = "storeName",required = false) String storeName,
                                                             PageFormUtil page,
                                                             HttpServletRequest request) {
        logger.info("enter getIdStoreList method param:store:{}", store);

        SysAccountPo sysAccountPo = HttpUtils.getLoginUser(request);

        return couponDefinitionService.getIdStoreList(store,sysStoreOfflineCode,storeName,page,sysAccountPo);
    }

}
