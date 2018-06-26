package com.bizvane.mktcenterservice.interfaces;

import com.bizvane.mktcenterservice.models.VO.ProductVO;
import com.bizvane.mktcenterservice.models.VO.Result;
import com.bizvane.mktcenterservice.utils.PageFormUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

/**
 * @author chen.li
 * @date on 2018/6/26 9:40
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */

public interface ProductService {

    public Result<Map<String,Object>> getProductList(ProductVO vo, PageFormUtil pageFormUtil);

    public Result<Integer> addProduct(DefProductPO po);

    @ApiOperation(value = "更新产品", notes = "产品信息", tags = {"产品信息"})
    @PostMapping("/updateProduct")
    public Result<Integer> updateProduct(DefProductPO po);
}
