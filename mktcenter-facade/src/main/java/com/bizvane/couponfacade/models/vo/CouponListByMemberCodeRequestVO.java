package com.bizvane.couponfacade.models.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class CouponListByMemberCodeRequestVO implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;


  @io.swagger.annotations.ApiModelProperty(value = "会员号", name = "memberCode")
  private String memberCode;

  @io.swagger.annotations.ApiModelProperty(value = "券使用状态", name = "couponStatus")
  private Byte couponStatus;

  @io.swagger.annotations.ApiModelProperty(value = "显示条数", name = "pageSize")
  private Integer pageSize = 20;

  @io.swagger.annotations.ApiModelProperty(value = "当前页数", name = "page")
  private Integer pageNumber = 1;
}
