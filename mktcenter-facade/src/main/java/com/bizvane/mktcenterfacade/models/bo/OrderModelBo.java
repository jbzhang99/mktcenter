package com.bizvane.mktcenterfacade.models.bo;

import java.math.BigDecimal;

import lombok.Data;

/**
 * 堂倌
 * 
 * @author 董争光
 * 2019年6月4日下午4:14:58
 */
@Data
public class OrderModelBo {
    private String memberCode;//会员编号
    private Long brandId;//品牌id
    private Integer orderFrom;//订单来源
    private BigDecimal payMoney;//订单金额
    private String productNos;//商品编码
    private Long serviceStoreId;//服务门店id
    private Long levelId;//会员等级id
    private Integer memberType;//会员范围
    private Long companyId;//企业id
}
