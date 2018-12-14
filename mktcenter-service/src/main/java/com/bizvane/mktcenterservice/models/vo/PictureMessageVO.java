package com.bizvane.mktcenterservice.models.vo;

import lombok.Data;

/**
 * @Author: lijunwei
 * @Time: 2018/12/6 14:42
 */
@Data
public class PictureMessageVO {
    private  Long brandId;
    private String offset;//"0"
    private  String count;//"4"
    private String type="news";
    private int pageSize=4;
    private int pageNumber=1;
}
