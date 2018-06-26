package com.bizvane.centercontrolserviceimpl.controllers;

import com.bizvane.mktcenterservice.interfaces.ProductService;
import com.bizvane.mktcenterservice.models.PO.DefProductPO;
import com.bizvane.mktcenterservice.models.VO.ProductVO;
import com.bizvane.mktcenterservice.models.VO.Result;
import com.bizvane.mktcenterservice.utils.PageFormUtil;
import com.bizvane.centercontrolserviceimpl.rpc.ProductServiceRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author chen.li
 * @date on 2018/6/26 9:54
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@Controller
@RequestMapping("product")
public class ProductController{

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductServiceRpc productServiceRpc;

    /**
     * 查询产品列表
     * @return
     */
    @ResponseBody
    @RequestMapping("getProductList")
    public Result<Map<String,Object>> getProductList(ProductVO vo, PageFormUtil pageFormUtil){
        return productService.getProductList(vo,pageFormUtil);
    }

    /**
     * 新增产品
     * @return
     */
    @ResponseBody
    @RequestMapping("addProduct")
    public Result<Integer> addProduct(DefProductPO po) {
        return productService.addProduct(po);
    }

    /**
     * 更新产品
     * @param po
     * @return
     */
    @ResponseBody
    @RequestMapping("updateProduct")
    public Result<Integer> updateProduct(DefProductPO po){
        return productService.updateProduct(po);
    }

    /**
     * rpc查询中台项目获取时间
     * @return
     */
    @ResponseBody
    @RequestMapping("getDateTimeRpc")
    public String getDateTime(){
      return productServiceRpc.getdatetime();
    }
}
