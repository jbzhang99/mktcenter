package com.bizvane.mktcenterservice.models.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2018/11/23 11:38
 */
@Data
public class CouponRecordVO {
    //pc端
    private Integer pageSize=10;
    private Integer pageNumber=1;
    private String exchangeCode;
    private String convertCouponRecordCode;
    private String memberName;
    private String cardNo;
    private String couponName;
    private String couponCodes;
    private Date startTime;
    private Date endTime;

    private Long brandId;
    //小程序
    private Boolean canConvertCoupon=Boolean.FALSE;
    //可用积分
    private Integer countIntegral;
    private String memberCode;
    private Long openCardStoreId=-1L;
    private List<Integer> exchangeIds;

}
