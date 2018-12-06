package com.bizvane.mktcenterservice.models.vo;

import lombok.Data;

/**
 * @Author: lijunwei
 * @Time: 2018/12/6 14:42
 */
@Data
public class PictureMessageVO {
    Long brandId;
    String offset="0";
    String count="20";
    String type="news";
}
