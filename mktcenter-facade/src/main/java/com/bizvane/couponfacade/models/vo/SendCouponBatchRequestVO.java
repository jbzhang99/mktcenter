package com.bizvane.couponfacade.models.vo;

import com.bizvane.members.facade.es.pojo.MembersInfoSearchPojo;
import com.bizvane.members.facade.vo.MemberInfoVo;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SendCouponBatchRequestVO implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "券定义id", name = "couponDefinitionId", required = false,example = "")
  private Long couponDefinitionId;
  @ApiModelProperty(value = "发送类型(1-立即发送，2-指定时间)", name = "sendType", required = false,example = "")
  private Byte sendType;
  @ApiModelProperty(value = "发券时间" , name = "sendTime" , required = false , example = "")
  private Date sendTime;
  @ApiModelProperty(value = "任务名称" , name = "businessName" , required = false , example = "")
  private String businessName;
  @ApiModelProperty(value = "业务id" , name = "businessId" , required = false , example = "")
  private Long businessId;
  @ApiModelProperty(value = "业务类型" , name = "businessType" , required = false , example = "")
  private String businessType;
  @ApiModelProperty(value = "会员集合(手动发券)", name = "memberList", required = false,example = "")
  private List<MembersInfoSearchPojo> memberListManual;

  @ApiModelProperty(value = "会员集合(营销)", name = "memberList", required = false,example = "")
  private List<MemberInfoVo> memberList;

  @ApiModelProperty(value = "创建人id",name = "createUserId", required = false,example = "")
  private Long createUserId;

  @ApiModelProperty(value = "创建人",name = "createUserName", required = false,example = "")
  private String createUserName;

  /*@io.swagger.annotations.ApiModelProperty(value = "总条数",name = "totalNumber", required = true,example = "")
  private Integer totalNumber;*/


//  企业微信群发新加字段
  @ApiModelProperty(value = "员工code",name = "staffCode", required = true,example = "")
  private String staffCode;
  @ApiModelProperty(value = "员工名称",name = "staffName", required = true,example = "")
  private String staffName;
  @ApiModelProperty(value = "企业id",name = "企业id", required = true,example = "")
  private Long sysCompanyId;
  @ApiModelProperty(value = "品牌id",name = "品牌id", required = true,example = "")
  private Long sysBrandId;
//  会员传memberList这个集合
//  @io.swagger.annotations.ApiModelProperty(value = "发送会员code集合",name = "发送会员code集合", required = true,example = "")
//  private String memberCodeList;
//  @io.swagger.annotations.ApiModelProperty(value = "发送会员名称集合",name = "发送会员名称集合", required = true,example = "")
//  private String memberNameList;
  @ApiModelProperty(value = "发送会员数量",name = "发送会员数量", required = true,example = "")
  private String memberNum;

  @ApiModelProperty(value = "券配额表主键",name = "券配额表主键", required = true,example = "")
  private Long couponQuotaId;

  @ApiModelProperty(value = "券定义id群",name = "券定义id群", required = true,example = "")
  private String couponDefinitionIds;

  @ApiModelProperty(value = "发券一级批次号（系统）",name = "发券二级批次号（系统）", required = true,example = "")
  private String batchSendCode;

  @ApiModelProperty(value = "发券二级批次号（系统）",name = "发券二级批次号（系统）", required = true,example = "")
  private Long batchSendCodeDetail;
  
  
  

  public String getBatchSendCode() {
	return batchSendCode;
}

public void setBatchSendCode(String batchSendCode) {
	this.batchSendCode = batchSendCode;
}

public Long getBatchSendCodeDetail() {
	return batchSendCodeDetail;
}

public void setBatchSendCodeDetail(Long batchSendCodeDetail) {
	this.batchSendCodeDetail = batchSendCodeDetail;
}

public Long getCouponQuotaId() {
	return couponQuotaId;
}

public void setCouponQuotaId(Long couponQuotaId) {
	this.couponQuotaId = couponQuotaId;
}

public String getStaffCode() {
	return staffCode;
}

public void setStaffCode(String staffCode) {
	this.staffCode = staffCode;
}

public String getStaffName() {
	return staffName;
}

public void setStaffName(String staffName) {
	this.staffName = staffName;
}





public Long getSysCompanyId() {
	return sysCompanyId;
}

public void setSysCompanyId(Long sysCompanyId) {
	this.sysCompanyId = sysCompanyId;
}

public Long getSysBrandId() {
	return sysBrandId;
}

public void setSysBrandId(Long sysBrandId) {
	this.sysBrandId = sysBrandId;
}

//public String getMemberCodeList() {
//	return memberCodeList;
//}
//
//public void setMemberCodeList(String memberCodeList) {
//	this.memberCodeList = memberCodeList;
//}
//
//public String getMemberNameList() {
//	return memberNameList;
//}
//
//public void setMemberNameList(String memberNameList) {
//	this.memberNameList = memberNameList;
//}

public String getMemberNum() {
	return memberNum;
}

public void setMemberNum(String memberNum) {
	this.memberNum = memberNum;
}

/*public Integer getTotalNumber() {
    return totalNumber;
  }

  public void setTotalNumber(Integer totalNumber) {
    this.totalNumber = totalNumber;
  }*/

  public String getBusinessName() {
    return businessName;
  }

  public void setBusinessName(String businessName) {
    this.businessName = businessName;
  }

  public Long getBusinessId() {
    return businessId;
  }

  public void setBusinessId(Long businessId) {
    this.businessId = businessId;
  }

  public Long getCouponDefinitionId() {
    return couponDefinitionId;
  }

  public void setCouponDefinitionId(Long couponDefinitionId) {
    this.couponDefinitionId = couponDefinitionId;
  }

  public String getBusinessType() {
    return businessType;
  }

  public void setBusinessType(String businessType) {
    this.businessType = businessType;
  }

  public Date getSendTime() {
    return sendTime;
  }

  public void setSendTime(Date sendTime) {
    this.sendTime = sendTime;
  }

  public Byte getSendType() {
    return sendType;
  }

  public void setSendType(Byte sendType) {
    this.sendType = sendType;
  }

  public Long getCreateUserId() {
    return createUserId;
  }

  public void setCreateUserId(Long createUserId) {
    this.createUserId = createUserId;
  }

  public String getCreateUserName() {
    return createUserName;
  }

  public void setCreateUserName(String createUserName) {
    this.createUserName = createUserName;
  }

  public List<MembersInfoSearchPojo> getMemberListManual() {
    return memberListManual;
  }

  public void setMemberListManual(List<MembersInfoSearchPojo> memberListManual) {
    this.memberListManual = memberListManual;
  }

  public List<MemberInfoVo> getMemberList() {
    return memberList;
  }

  public void setMemberList(List<MemberInfoVo> memberList) {
    this.memberList = memberList;
  }

  public String getCouponDefinitionIds() {
    return couponDefinitionIds;
  }

  public void setCouponDefinitionIds(String couponDefinitionIds) {
    this.couponDefinitionIds = couponDefinitionIds;
  }
}
