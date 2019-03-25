package com.bizvane.mktcenterfacade.models.vo;

import com.bizvane.couponfacade.models.po.CouponDefinitionPO;
import com.bizvane.mktcenterfacade.models.po.MktConvertCouponRecordPO;
import lombok.Data;

/**
 * @Author: lijunwei
 * @Time: 2018/11/26 9:41
 */
@Data
public class MktConvertCouponRecordVO extends MktConvertCouponRecordPO {
   private  CouponDefinitionPO couponDefinitionPO;
}
