package com.bizvane.mktcenterfacade.models.vo;

import com.bizvane.centerstageservice.models.po.SysStorePo;
import com.bizvane.couponfacade.models.po.CouponDefinitionPO;
import com.bizvane.couponfacade.models.vo.CouponDetailResponseVO;
import com.bizvane.mktcenterfacade.models.po.MktCouponIntegralExchangePO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by agan on 2018/11/22.
 */
@Data
public class MktCouponIntegralExchangeVO extends MktCouponIntegralExchangePO {
    @ApiModelProperty(name = "startTime", value = "券有效期的开始时间")
    private String startTime;
    @ApiModelProperty(name = "endTime", value = "券有效期的结束时间")
    private  String endTime;
    @ApiModelProperty(name = "exchangeIds", value = "兑换券id集合")
    private List<Long> exchangeIds;//id集合
    @ApiModelProperty(name = "restCount", value = "剩余库存")
    private Integer restCount;//剩余库存
    //门店实体类
    @ApiModelProperty(name = "sysStorePos", value = "门店信息")
    private List<SysStorePo> sysStorePos;
    //券剩余数量
    @ApiModelProperty(name = "residueCouponNumber", value = "券剩余数量")
    private Long residueCouponNumber;
    @ApiModelProperty(name = "couponDefinitionPO", value = "券定义实体")
    private CouponDefinitionPO couponDefinitionPO;
    //券
    @ApiModelProperty(name = "couponDetailResponseVO", value = "券详情实体")
    private CouponDetailResponseVO couponDetailResponseVO;

    @ApiModelProperty(name = "canConvertCoupon", value = "能否兑换，true/false")
    private Boolean canConvert;

    @ApiModelProperty(name = "convertedNum", value = "已经兑换的数量")
    private Long convertedNum;

    private String message;

    /**
     * 会员code
     */
    private String memberCode;

    /**
     * 零库存
     */
    private Boolean zeroStore;

    private Boolean couponExpire;
}
