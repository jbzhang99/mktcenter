package com.bizvane.mktcenterservice.models.vo;

import com.bizvane.couponfacade.models.po.CouponDefinitionPO;
import com.bizvane.mktcenterservice.models.po.MktConvertCouponRecordPO;
import lombok.Data;

/**
 * @Author: lijunwei
 * @Time: 2018/11/26 9:41
 */
@Data
public class MktConvertCouponRecordVO extends MktConvertCouponRecordPO {
   private  CouponDefinitionPO couponDefinitionPO;
}
