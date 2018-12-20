package com.bizvane.mktcenterservice.models.vo;

import lombok.Data;

/**
 * @Author: lijunwei
 * @Time: 2018/12/19 17:28
 */
@Data
public class ActivityPriceParamVO {
    private int pageNumber;
    private int pageSize;
    private Long mktActivityId;
    private String activityCode;
    private String activityName;
    private Integer activityStatus;
    private Long brandId;
    private String prizeName;
    private String memberPhone;
    private String memberName;
    private String qrCodeUrl;
}
