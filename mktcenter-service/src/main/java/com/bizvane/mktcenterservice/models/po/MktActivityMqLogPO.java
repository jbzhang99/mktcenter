package com.bizvane.mktcenterservice.models.po;

import java.io.Serializable;
import java.util.Date;

public class MktActivityMqLogPO implements Serializable {

	/**
	 * 只读. pkid. mkt_activity_mq_log_id
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	@io.swagger.annotations.ApiModelProperty(value = "pkid", name = "mktActivityMqLogId", required = false, example = "")
	private Long mktActivityMqLogId;
	/**
	 * 只读. 活动id. mkt_activity_id
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	@io.swagger.annotations.ApiModelProperty(value = "活动id", name = "mktActivityId", required = false, example = "")
	private String mktActivityId;
	/**
	 * 只读. 分区. partition
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	@io.swagger.annotations.ApiModelProperty(value = "分区", name = "partition", required = false, example = "")
	private Integer partition;
	/**
	 * 只读. 偏移量. offset
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	@io.swagger.annotations.ApiModelProperty(value = "偏移量", name = "offset", required = false, example = "")
	private Integer offset;
	/**
	 * 只读. 类型. type
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	@io.swagger.annotations.ApiModelProperty(value = "类型", name = "type", required = false, example = "")
	private Long type;
	/**
	 * 只读. 值. value
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	@io.swagger.annotations.ApiModelProperty(value = "值", name = "value", required = false, example = "")
	private String value;
	/**
	 * 只读. 备注. remark
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	@io.swagger.annotations.ApiModelProperty(value = "备注", name = "remark", required = false, example = "")
	private String remark;
	/**
	 * 只读. 创建人id. create_user_id
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人id", name = "createUserId", required = false, example = "")
	private Long createUserId;
	/**
	 * 只读. 创建人. create_user_name
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人", name = "createUserName", required = false, example = "")
	private String createUserName;
	/**
	 * 只读. 创建日期. create_date
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建日期", name = "createDate", required = false, example = "")
	private Date createDate;
	/**
	 * 只读. 修改人id. modified_user_id
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人id", name = "modifiedUserId", required = false, example = "")
	private Long modifiedUserId;
	/**
	 * 只读. 修改人. modified_user_name
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人", name = "modifiedUserName", required = false, example = "")
	private String modifiedUserName;
	/**
	 * 只读. 修改时间. modified_date
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改时间", name = "modifiedDate", required = false, example = "")
	private Date modifiedDate;
	/**
	 * 只读. 数据有效性：1=有效；0=无效. valid
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	@io.swagger.annotations.ApiModelProperty(value = "数据有效性：1=有效；0=无效", name = "valid", required = false, example = "")
	private Boolean valid;
	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public Long getMktActivityMqLogId() {
		return mktActivityMqLogId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public void setMktActivityMqLogId(Long mktActivityMqLogId) {
		this.mktActivityMqLogId = mktActivityMqLogId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public String getMktActivityId() {
		return mktActivityId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public void setMktActivityId(String mktActivityId) {
		this.mktActivityId = mktActivityId == null ? null : mktActivityId.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public Integer getPartition() {
		return partition;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public void setPartition(Integer partition) {
		this.partition = partition;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public Integer getOffset() {
		return offset;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public Long getType() {
		return type;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public void setType(Long type) {
		this.type = type;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public String getValue() {
		return value;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public void setValue(String value) {
		this.value = value == null ? null : value.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public Long getCreateUserId() {
		return createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public String getCreateUserName() {
		return createUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public Long getModifiedUserId() {
		return modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public void setModifiedUserId(Long modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public String getModifiedUserName() {
		return modifiedUserName;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public void setModifiedUserName(String modifiedUserName) {
		this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public Boolean getValid() {
		return valid;
	}

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
}