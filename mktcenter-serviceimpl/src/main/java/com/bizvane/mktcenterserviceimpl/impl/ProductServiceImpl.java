package com.bizvane.centercontrolserviceimpl.impl;

import com.bizvane.mktcenterservice.interfaces.ProductService;
import com.bizvane.mktcenterservice.models.PO.DefProductPO;
import com.bizvane.mktcenterservice.models.PO.DefProductPOExample;
import com.bizvane.mktcenterservice.models.VO.ProductVO;
import com.bizvane.mktcenterservice.models.VO.Result;
import com.bizvane.mktcenterservice.utils.PageFormUtil;
import com.bizvane.centercontrolserviceimpl.constants.ResponseConstants;
import com.bizvane.mktcenterserviceimpl.mappers.DefProductPOMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chen.li
 * @date on 2018/6/26 10:08
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private DefProductPOMapper defProductPOMapper;

    /**
     * 查询产品列表
     * @param vo
     * @return
     */
    @Override
    public Result<Map<String, Object>> getProductList(ProductVO vo, PageFormUtil pageFormUtil) {
        Result result = new Result();
        PageHelper.startPage(pageFormUtil.getPageNumber(),pageFormUtil.getPageSize());
        DefProductPOExample example = new DefProductPOExample();
        example.createCriteria().andProductNameIsNotNull();
        List<DefProductPO> defProductPOS = defProductPOMapper.selectByExample(example);
        PageInfo<DefProductPO> defProductPOPageInfo = new PageInfo<>(defProductPOS);
        Map map = new HashMap();
        map.put("rows",defProductPOPageInfo.getList());
        map.put("total",defProductPOPageInfo.getTotal());
        result.setData(map);
        result.setStatus(ResponseConstants.SUCCESS);
        result.setMsg(ResponseConstants.SUCCESS_MSG);
        return result;
    }

    /**
     * 新增产品
     * @param po
     * @return
     */
    @Override
    public Result<Integer> addProduct(DefProductPO po) {
        Result result = new Result();
        defProductPOMapper.insertSelective(po);
        result.setData(po.getDefProductId());
        result.setStatus(ResponseConstants.SUCCESS);
        result.setMsg(ResponseConstants.SUCCESS_MSG);
        return result;
    }

    /**
     * 更新产品
     * @param po
     * @return
     */
    @Override
    public Result<Integer> updateProduct(DefProductPO po) {
        Result result = new Result();
        DefProductPOExample example = new DefProductPOExample();
        example.createCriteria().andDefProductIdEqualTo(po.getDefProductId());
        defProductPOMapper.updateByExampleSelective(po,example);
        result.setData(po.getDefProductId());
        result.setStatus(ResponseConstants.SUCCESS);
        result.setMsg(ResponseConstants.SUCCESS_MSG);
        return result;
    }
}
