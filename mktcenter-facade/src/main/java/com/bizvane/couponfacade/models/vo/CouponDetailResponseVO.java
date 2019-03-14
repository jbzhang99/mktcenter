package com.bizvane.couponfacade.models.vo;

import com.bizvane.couponfacade.models.po.*;
import com.bizvane.members.facade.vo.WxChannelInfoVo;

import java.io.Serializable;
import java.util.List;

public class CouponDetailResponseVO implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @io.swagger.annotations.ApiModelProperty(value = "券定义对象", name = "couponDefinitionPO", required = false,example = "")
  private CouponDefinitionPO couponDefinitionPO;
  @io.swagger.annotations.ApiModelProperty(value = "券实例对象", name = "couponEntityPO", required = false,example = "")
  private CouponEntityPO couponEntityPO;
  @io.swagger.annotations.ApiModelProperty(value = "券状态集合", name = "couponStatusLogList", required = false,example = "")
  private List<CouponStatusLogPO> couponStatusLogList;
  @io.swagger.annotations.ApiModelProperty(value = "渠道对象集合", name = "wxChannelInfoVo", required = false,example = "")
  private WxChannelInfoVo wxChannelInfoVo;
  @io.swagger.annotations.ApiModelProperty(value = "手动发券对象", name = "wxChannelInfoVo", required = false,example = "")
  private CouponManualPO couponManualPO;
  @io.swagger.annotations.ApiModelProperty(value = "券定义对象列表", name = "couponDefinitionPOList", required = false,example = "")
  private List<CouponDefinitionPOWithBLOBs> couponDefinitionPOList;

  public CouponDefinitionPO getCouponDefinitionPO() {
    return couponDefinitionPO;
  }

  public void setCouponDefinitionPO(CouponDefinitionPO couponDefinitionPO) {
    this.couponDefinitionPO = couponDefinitionPO;
  }

  public CouponEntityPO getCouponEntityPO() {
    return couponEntityPO;
  }

  public void setCouponEntityPO(CouponEntityPO couponEntityPO) {
    this.couponEntityPO = couponEntityPO;
  }

  public List<CouponStatusLogPO> getCouponStatusLogList() {
    return couponStatusLogList;
  }

  public void setCouponStatusLogList(List<CouponStatusLogPO> couponStatusLogList) {
        this.couponStatusLogList = couponStatusLogList;
    }

  public WxChannelInfoVo getWxChannelInfoVo() {
    return wxChannelInfoVo;
  }

  public void setWxChannelInfoVo(WxChannelInfoVo wxChannelInfoVo) {
    this.wxChannelInfoVo = wxChannelInfoVo;
  }

  public CouponManualPO getCouponManualPO() {
    return couponManualPO;
  }

  public void setCouponManualPO(CouponManualPO couponManualPO) {
    this.couponManualPO = couponManualPO;
  }

  public List<CouponDefinitionPOWithBLOBs> getCouponDefinitionPOList() {
    return couponDefinitionPOList;
  }

  public void setCouponDefinitionPOList(List<CouponDefinitionPOWithBLOBs> couponDefinitionPOList) {
    this.couponDefinitionPOList = couponDefinitionPOList;
  }
}
