package com.bizvane.mktcenterfacade.models.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ActivityCouponVO implements Serializable {
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "活动id", name = "mktActivityId", required = false, example = "")
  private Long mktActivityId;
  
  @ApiModelProperty(value = "活动编号", name = "activityCode", required = false, example = "")
  private String activityCode;

  @ApiModelProperty(value = "活动名称", name = "activityName", required = false, example = "")
  private String activityName;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
  @ApiModelProperty(value = "活动开始时间", name = "startTime", required = false, example = "")
  private Date startTime;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
  @ApiModelProperty(value = "活动结束时间", name = "endTime", required = false, example = "")
  private Date endTime;

  @ApiModelProperty(value = "活动描述、简介", name = "activityInfo", required = false, example = "")
  private String activityInfo;
  
  @ApiModelProperty(value = "是否长期：1是，0否", name = "longTerm", required = false, example = "")
  private Integer longTerm;
  
  @ApiModelProperty(value = "活动列表图片，多张逗号分隔", name = "activityListImg", required = false, example = "")
  private String activityListImg;

  @ApiModelProperty(value = "活动详情图片", name = "activityDetailImg", required = false, example = "")
  private String activityDetailImg;
  
  @ApiModelProperty(value = "活动状态：0全部，1待执行，2执行中，3已结束，4已禁用", name = "activityStatus", required = false, example = "")
  private Integer activityStatus;
  
  @io.swagger.annotations.ApiModelProperty(value = "备注", name = "remark", required = false, example = "")
  private String remark;

  @io.swagger.annotations.ApiModelProperty(value = "创建人id", name = "createUserId", required = false, example = "")
  private Long createUserId;

  @io.swagger.annotations.ApiModelProperty(value = "创建人", name = "createUserName", required = false, example = "")
  private String createUserName;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
  @io.swagger.annotations.ApiModelProperty(value = "创建日期", name = "createDate", required = false, example = "")
  private Date createDate;

  @ApiModelProperty(value = "二维码", name = "qrcode", required = false, example = "")
  private String qrcode;//二维码
  
  @ApiModelProperty(value = "活动明细id", name = "mktActivityManualId", required = false, example = "")
  private Long mktActivityManualId;
 
  @ApiModelProperty(value = "券定义id", name = "couponDefinitionId", required = false, example = "")
  private Long couponDefinitionId;

  @ApiModelProperty(value = "券名称", name = "couponName", required = false, example = "")
  private String couponName;
  
  @ApiModelProperty(value = "是否可以领取", name = "canReceive", required = false, example = "")
  private Boolean canReceive;

  @ApiModelProperty(value = "每日领取数量限制", name = "perPersonPerDayMax", required = false, example = "")
  private Long perPersonPerDayMax;
  
  @ApiModelProperty(value = "总数数量限制", name = "perPersonMax", required = false, example = "")
  private Long perPersonMax;
  
  @ApiModelProperty(value = "优惠类型（1现金，2折扣，3兑换）", name = "preferentialType", required = false, example = "")
  private Byte preferentialType;

  @ApiModelProperty(value = "券的面额", name = "money", required = false, example = "")
  private BigDecimal money;

  @ApiModelProperty(value = "券的折扣", name = "discount", required = false, example = "")
  private BigDecimal discount;

  @ApiModelProperty(value = "兑换券商品id", name = "exchangeProductId", required = false, example = "")
  private String exchangeProductId;

  @ApiModelProperty(value = "有效期类型：1-日期区间，2-领取后X天有效，3-仅限会员生日当天使用，4-仅限会员生日当月使用", name = "validType", required = false,
      example = "")
  private Byte validType;

  @ApiModelProperty(value = "有效期开始时间", name = "validDateStart", required = false, example = "")
  private Date validDateStart;

  @ApiModelProperty(value = "有效期结束时间", name = "validDateEnd", required = false, example = "")
  private Date validDateEnd;

  @ApiModelProperty(value = "有效天数", name = "validDay", required = false, example = "")
  private Integer validDay;
  

  @ApiModelProperty(value = "最低消费金额(满减金额)", name = "minConsume", required = false, example = "")
  private BigDecimal minConsume;
  

  
}
