package com.bizvane.mktcenterservice.models.po;

import java.io.Serializable;
import java.util.Date;

public class MktActivityOrderPO implements Serializable {

	/**
	 * 只读. pkid. mkt_activity_order_id
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	@io.swagger.annotations.ApiModelProperty(value = "pkid", name = "mktActivityOrderId", required = false, example = "")
	private Long mktActivityOrderId;
	/**
	 * 只读. 关联活动id. mkt_activity_id
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	@io.swagger.annotations.ApiModelProperty(value = "关联活动id", name = "mktActivityId", required = false, example = "")
	private Long mktActivityId;
	/**
	 * 只读. 活动目标会员等级编号. mbr_level_code
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	@io.swagger.annotations.ApiModelProperty(value = "活动目标会员等级编号", name = "mbrLevelCode", required = false, example = "")
	private String mbrLevelCode;
	/**
	 * 只读. 活动目标会员等级名称. mbr_level_name
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	@io.swagger.annotations.ApiModelProperty(value = "活动目标会员等级名称", name = "mbrLevelName", required = false, example = "")
	private String mbrLevelName;
	/**
	 * 只读. 针对的会员类型：0,所有类型，1微信会员. member_type
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	@io.swagger.annotations.ApiModelProperty(value = "针对的会员类型：0,所有类型，1微信会员", name = "memberType", required = false, example = "")
	private Integer memberType;
	/**
	 * 只读. 订单来源：1线下订单，2微商城订单. order_source
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	@io.swagger.annotations.ApiModelProperty(value = "订单来源：1线下订单，2微商城订单", name = "orderSource", required = false, example = "")
	private Integer orderSource;
	/**
	 * 只读. 订单最低金额. order_min_price
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	@io.swagger.annotations.ApiModelProperty(value = "订单最低金额", name = "orderMinPrice", required = false, example = "")
	private String orderMinPrice;
	/**
	 * 只读. 是否限制商品，0否，1是. is_commodity_limit
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	@io.swagger.annotations.ApiModelProperty(value = "是否限制商品，0否，1是", name = "isCommodityLimit", required = false, example = "")
	private Boolean isCommodityLimit;
	/**
	 * 只读. 是否限制门店，0否，1是. is_store_limit
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	@io.swagger.annotations.ApiModelProperty(value = "是否限制门店，0否，1是", name = "isStoreLimit", required = false, example = "")
	private Boolean isStoreLimit;
	/**
	 * 只读. 备注. remark
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	@io.swagger.annotations.ApiModelProperty(value = "备注", name = "remark", required = false, example = "")
	private String remark;
	/**
	 * 只读. 创建人id. create_user_id
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人id", name = "createUserId", required = false, example = "")
	private Long createUserId;
	/**
	 * 只读. 创建人. create_user_name
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人", name = "createUserName", required = false, example = "")
	private String createUserName;
	/**
	 * 只读. 创建日期. create_date
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建日期", name = "createDate", required = false, example = "")
	private Date createDate;
	/**
	 * 只读. 修改人id. modified_user_id
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人id", name = "modifiedUserId", required = false, example = "")
	private Long modifiedUserId;
	/**
	 * 只读. 修改人. modified_user_name
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人", name = "modifiedUserName", required = false, example = "")
	private String modifiedUserName;
	/**
	 * 只读. 修改时间. modified_date
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改时间", name = "modifiedDate", required = false, example = "")
	private Date modifiedDate;
	/**
	 * 只读. 数据有效性：1=有效；0=无效. valid
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	@io.swagger.annotations.ApiModelProperty(value = "数据有效性：1=有效；0=无效", name = "valid", required = false, example = "")
	private Boolean valid;
	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public Long getMktActivityOrderId() {
		return mktActivityOrderId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public void setMktActivityOrderId(Long mktActivityOrderId) {
		this.mktActivityOrderId = mktActivityOrderId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public Long getMktActivityId() {
		return mktActivityId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public void setMktActivityId(Long mktActivityId) {
		this.mktActivityId = mktActivityId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public String getMbrLevelCode() {
		return mbrLevelCode;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public void setMbrLevelCode(String mbrLevelCode) {
		this.mbrLevelCode = mbrLevelCode == null ? null : mbrLevelCode.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public String getMbrLevelName() {
		return mbrLevelName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public void setMbrLevelName(String mbrLevelName) {
		this.mbrLevelName = mbrLevelName == null ? null : mbrLevelName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public Integer getMemberType() {
		return memberType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public void setMemberType(Integer memberType) {
		this.memberType = memberType;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public Integer getOrderSource() {
		return orderSource;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public void setOrderSource(Integer orderSource) {
		this.orderSource = orderSource;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public String getOrderMinPrice() {
		return orderMinPrice;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public void setOrderMinPrice(String orderMinPrice) {
		this.orderMinPrice = orderMinPrice == null ? null : orderMinPrice.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public Boolean getIsCommodityLimit() {
		return isCommodityLimit;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public void setIsCommodityLimit(Boolean isCommodityLimit) {
		this.isCommodityLimit = isCommodityLimit;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public Boolean getIsStoreLimit() {
		return isStoreLimit;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public void setIsStoreLimit(Boolean isStoreLimit) {
		this.isStoreLimit = isStoreLimit;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public Long getCreateUserId() {
		return createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public String getCreateUserName() {
		return createUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public Long getModifiedUserId() {
		return modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public void setModifiedUserId(Long modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public String getModifiedUserName() {
		return modifiedUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public void setModifiedUserName(String modifiedUserName) {
		this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public Boolean getValid() {
		return valid;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 10:42:22
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
}