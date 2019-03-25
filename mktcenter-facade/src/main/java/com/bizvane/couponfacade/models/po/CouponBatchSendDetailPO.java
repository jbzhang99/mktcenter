package com.bizvane.couponfacade.models.po;

import java.io.Serializable;
import java.util.Date;

public class CouponBatchSendDetailPO implements Serializable {

	/**
	 * 只读. pkid. t_coupon_batch_send_detail_id
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	@io.swagger.annotations.ApiModelProperty(value = "pkid", name = "tCouponBatchSendDetailId", required = false, example = "")
	private Long tCouponBatchSendDetailId;
	/**
	 * 只读. 所属企业id. sys_company_id
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	@io.swagger.annotations.ApiModelProperty(value = "所属企业id", name = "sysCompanyId", required = false, example = "")
	private Long sysCompanyId;
	/**
	 * 只读. 所属品牌id. sys_brand_id
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	@io.swagger.annotations.ApiModelProperty(value = "所属品牌id", name = "sysBrandId", required = false, example = "")
	private Long sysBrandId;
	/**
	 * 只读. 所属品牌编号. brand_code
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	@io.swagger.annotations.ApiModelProperty(value = "所属品牌编号", name = "brandCode", required = false, example = "")
	private String brandCode;
	/**
	 * 只读. 手工发券id. coupon_manual_id
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	@io.swagger.annotations.ApiModelProperty(value = "手工发券id", name = "couponManualId", required = false, example = "")
	private String couponManualId;
	/**
	 * 只读. 券定义id. coupon_definition_id
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券定义id", name = "couponDefinitionId", required = false, example = "")
	private String couponDefinitionId;
	/**
	 * 只读. 发券一级批次号（系统）. batch_send_code
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	@io.swagger.annotations.ApiModelProperty(value = "发券一级批次号（系统）", name = "batchSendCode", required = false, example = "")
	private String batchSendCode;
	/**
	 * 只读. 发券二级批次号（系统）. batch_send_code_detail
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	@io.swagger.annotations.ApiModelProperty(value = "发券二级批次号（系统）", name = "batchSendCodeDetail", required = false, example = "")
	private String batchSendCodeDetail;
	/**
	 * 只读. 券编号. coupon_definition_code
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券编号", name = "couponDefinitionCode", required = false, example = "")
	private String couponDefinitionCode;
	/**
	 * 只读. 券名称. coupon_name
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	@io.swagger.annotations.ApiModelProperty(value = "券名称", name = "couponName", required = false, example = "")
	private String couponName;
	/**
	 * 只读. 有效期开始时间. valid_date_start
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	@io.swagger.annotations.ApiModelProperty(value = "有效期开始时间", name = "validDateStart", required = false, example = "")
	private Date validDateStart;
	/**
	 * 只读. 有效期结束时间. valid_date_end
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	@io.swagger.annotations.ApiModelProperty(value = "有效期结束时间", name = "validDateEnd", required = false, example = "")
	private Date validDateEnd;
	/**
	 * 只读. 业务类型. biz_type
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	@io.swagger.annotations.ApiModelProperty(value = "业务类型", name = "bizType", required = false, example = "")
	private String bizType;
	/**
	 * 只读. 业务单号. biz_code
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	@io.swagger.annotations.ApiModelProperty(value = "业务单号", name = "bizCode", required = false, example = "")
	private String bizCode;
	/**
	 * 只读. 发送总数. send_num
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	@io.swagger.annotations.ApiModelProperty(value = "发送总数", name = "sendNum", required = false, example = "")
	private Integer sendNum;
	/**
	 * 只读. 失败数量. fail_num
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	@io.swagger.annotations.ApiModelProperty(value = "失败数量", name = "failNum", required = false, example = "")
	private Integer failNum;
	/**
	 * 只读. 是否需要将绑定关系同步至线下（0-不需要，1-需要）. is_offline_sync
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	@io.swagger.annotations.ApiModelProperty(value = "是否需要将绑定关系同步至线下（0-不需要，1-需要）", name = "isOfflineSync", required = false, example = "")
	private Boolean isOfflineSync;
	/**
	 * 只读. 同步状态（1未同步，2已同步，3同步中）. sync_status
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	@io.swagger.annotations.ApiModelProperty(value = "同步状态（1未同步，2已同步，3同步中）", name = "syncStatus", required = false, example = "")
	private Byte syncStatus;
	/**
	 * 只读. 绑定状态（1绑定中，2绑定完成，3绑定失败）. bind_status
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	@io.swagger.annotations.ApiModelProperty(value = "绑定状态（1绑定中，2绑定完成，3绑定失败）", name = "bindStatus", required = false, example = "")
	private Byte bindStatus;
	/**
	 * 只读. 会员es搜索条件. member_es
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	@io.swagger.annotations.ApiModelProperty(value = "会员es搜索条件", name = "memberEs", required = false, example = "")
	private String memberEs;
	/**
	 * 只读. 备注. remark
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	@io.swagger.annotations.ApiModelProperty(value = "备注", name = "remark", required = false, example = "")
	private String remark;
	/**
	 * 只读. 创建人id. create_user_id
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人id", name = "createUserId", required = false, example = "")
	private Long createUserId;
	/**
	 * 只读. 创建人. create_user_name
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人", name = "createUserName", required = false, example = "")
	private String createUserName;
	/**
	 * 只读. 创建时间. create_date
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建时间", name = "createDate", required = false, example = "")
	private Date createDate;
	/**
	 * 只读. 修改人id. modified_user_id
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人id", name = "modifiedUserId", required = false, example = "")
	private Long modifiedUserId;
	/**
	 * 只读. 修改人. modified_user_name
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人", name = "modifiedUserName", required = false, example = "")
	private String modifiedUserName;
	/**
	 * 只读. 修改时间. modified_date
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改时间", name = "modifiedDate", required = false, example = "")
	private Date modifiedDate;
	/**
	 * 只读. 数据有效性（1有效，0无效）. valid
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	@io.swagger.annotations.ApiModelProperty(value = "数据有效性（1有效，0无效）", name = "valid", required = false, example = "")
	private Boolean valid;
	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public Long gettCouponBatchSendDetailId() {
		return tCouponBatchSendDetailId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public void settCouponBatchSendDetailId(Long tCouponBatchSendDetailId) {
		this.tCouponBatchSendDetailId = tCouponBatchSendDetailId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public Long getSysCompanyId() {
		return sysCompanyId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public void setSysCompanyId(Long sysCompanyId) {
		this.sysCompanyId = sysCompanyId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public Long getSysBrandId() {
		return sysBrandId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public void setSysBrandId(Long sysBrandId) {
		this.sysBrandId = sysBrandId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public String getBrandCode() {
		return brandCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode == null ? null : brandCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public String getCouponManualId() {
		return couponManualId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public void setCouponManualId(String couponManualId) {
		this.couponManualId = couponManualId == null ? null : couponManualId.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public String getCouponDefinitionId() {
		return couponDefinitionId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public void setCouponDefinitionId(String couponDefinitionId) {
		this.couponDefinitionId = couponDefinitionId == null ? null : couponDefinitionId.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public String getBatchSendCode() {
		return batchSendCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public void setBatchSendCode(String batchSendCode) {
		this.batchSendCode = batchSendCode == null ? null : batchSendCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public String getBatchSendCodeDetail() {
		return batchSendCodeDetail;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public void setBatchSendCodeDetail(String batchSendCodeDetail) {
		this.batchSendCodeDetail = batchSendCodeDetail == null ? null : batchSendCodeDetail.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public String getCouponDefinitionCode() {
		return couponDefinitionCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public void setCouponDefinitionCode(String couponDefinitionCode) {
		this.couponDefinitionCode = couponDefinitionCode == null ? null : couponDefinitionCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public String getCouponName() {
		return couponName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public void setCouponName(String couponName) {
		this.couponName = couponName == null ? null : couponName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public Date getValidDateStart() {
		return validDateStart;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public void setValidDateStart(Date validDateStart) {
		this.validDateStart = validDateStart;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public Date getValidDateEnd() {
		return validDateEnd;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public void setValidDateEnd(Date validDateEnd) {
		this.validDateEnd = validDateEnd;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public String getBizType() {
		return bizType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public void setBizType(String bizType) {
		this.bizType = bizType == null ? null : bizType.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public String getBizCode() {
		return bizCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public void setBizCode(String bizCode) {
		this.bizCode = bizCode == null ? null : bizCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public Integer getSendNum() {
		return sendNum;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public void setSendNum(Integer sendNum) {
		this.sendNum = sendNum;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public Integer getFailNum() {
		return failNum;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public void setFailNum(Integer failNum) {
		this.failNum = failNum;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public Boolean getIsOfflineSync() {
		return isOfflineSync;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public void setIsOfflineSync(Boolean isOfflineSync) {
		this.isOfflineSync = isOfflineSync;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public Byte getSyncStatus() {
		return syncStatus;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public void setSyncStatus(Byte syncStatus) {
		this.syncStatus = syncStatus;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public Byte getBindStatus() {
		return bindStatus;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public void setBindStatus(Byte bindStatus) {
		this.bindStatus = bindStatus;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public String getMemberEs() {
		return memberEs;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public void setMemberEs(String memberEs) {
		this.memberEs = memberEs == null ? null : memberEs.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public Long getCreateUserId() {
		return createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public String getCreateUserName() {
		return createUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public Long getModifiedUserId() {
		return modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public void setModifiedUserId(Long modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public String getModifiedUserName() {
		return modifiedUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public void setModifiedUserName(String modifiedUserName) {
		this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public Boolean getValid() {
		return valid;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2019-01-04 18:32:43
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
}