package com.bizvane.mktcenterservice.models.po;

import java.io.Serializable;
import java.util.Date;

public class MktActivityManualPO implements Serializable {

	/**
	 * ֻ��. pkid. mkt_activity_manual_id
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	@io.swagger.annotations.ApiModelProperty(value = "pkid", name = "mktActivityManualId", required = false, example = "")
	private Long mktActivityManualId;
	/**
	 * ֻ��. �����id. mkt_activity_id
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	@io.swagger.annotations.ApiModelProperty(value = "�����id", name = "mktActivityId", required = false, example = "")
	private Long mktActivityId;
	/**
	 * ֻ��. ��ȡ��ʽ��1ɨ����ȯ��2�ֶ���ȯ. receive_type
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	@io.swagger.annotations.ApiModelProperty(value = "��ȡ��ʽ��1ɨ����ȯ��2�ֶ���ȯ", name = "receiveType", required = false, example = "")
	private Integer receiveType;
	/**
	 * ֻ��. ÿ��ÿ�������ȡ������. per_person_per_day_max
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	@io.swagger.annotations.ApiModelProperty(value = "ÿ��ÿ�������ȡ������", name = "perPersonPerDayMax", required = false, example = "")
	private Integer perPersonPerDayMax;
	/**
	 * ֻ��. ÿ�������ȡ. per_person_max
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	@io.swagger.annotations.ApiModelProperty(value = "ÿ�������ȡ", name = "perPersonMax", required = false, example = "")
	private Integer perPersonMax;
	/**
	 * ֻ��. ��ע. remark
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	@io.swagger.annotations.ApiModelProperty(value = "��ע", name = "remark", required = false, example = "")
	private String remark;
	/**
	 * ֻ��. ������id. create_user_id
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	@io.swagger.annotations.ApiModelProperty(value = "������id", name = "createUserId", required = false, example = "")
	private Long createUserId;
	/**
	 * ֻ��. ������. create_user_name
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	@io.swagger.annotations.ApiModelProperty(value = "������", name = "createUserName", required = false, example = "")
	private String createUserName;
	/**
	 * ֻ��. ��������. create_date
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	@io.swagger.annotations.ApiModelProperty(value = "��������", name = "createDate", required = false, example = "")
	private Date createDate;
	/**
	 * ֻ��. �޸���id. modified_user_id
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	@io.swagger.annotations.ApiModelProperty(value = "�޸���id", name = "modifiedUserId", required = false, example = "")
	private Long modifiedUserId;
	/**
	 * ֻ��. �޸���. modified_user_name
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	@io.swagger.annotations.ApiModelProperty(value = "�޸���", name = "modifiedUserName", required = false, example = "")
	private String modifiedUserName;
	/**
	 * ֻ��. �޸�ʱ��. modified_date
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	@io.swagger.annotations.ApiModelProperty(value = "�޸�ʱ��", name = "modifiedDate", required = false, example = "")
	private Date modifiedDate;
	/**
	 * ֻ��. ������Ч�ԣ�1=��Ч��0=��Ч. valid
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	@io.swagger.annotations.ApiModelProperty(value = "������Ч�ԣ�1=��Ч��0=��Ч", name = "valid", required = false, example = "")
	private Boolean valid;
	/**
	 * ֻ��. ��ά���ַ. qrcode
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	@io.swagger.annotations.ApiModelProperty(value = "��ά���ַ", name = "qrcode", required = false, example = "")
	private String qrcode;
	/**
	 * ֻ��. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	public Long getMktActivityManualId() {
		return mktActivityManualId;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	public void setMktActivityManualId(Long mktActivityManualId) {
		this.mktActivityManualId = mktActivityManualId;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	public Long getMktActivityId() {
		return mktActivityId;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	public void setMktActivityId(Long mktActivityId) {
		this.mktActivityId = mktActivityId;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	public Integer getReceiveType() {
		return receiveType;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	public void setReceiveType(Integer receiveType) {
		this.receiveType = receiveType;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	public Integer getPerPersonPerDayMax() {
		return perPersonPerDayMax;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	public void setPerPersonPerDayMax(Integer perPersonPerDayMax) {
		this.perPersonPerDayMax = perPersonPerDayMax;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	public Integer getPerPersonMax() {
		return perPersonMax;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	public void setPerPersonMax(Integer perPersonMax) {
		this.perPersonMax = perPersonMax;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	public Long getCreateUserId() {
		return createUserId;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	public String getCreateUserName() {
		return createUserName;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	public Long getModifiedUserId() {
		return modifiedUserId;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	public void setModifiedUserId(Long modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	public String getModifiedUserName() {
		return modifiedUserName;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	public void setModifiedUserName(String modifiedUserName) {
		this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	public Boolean getValid() {
		return valid;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	public String getQrcode() {
		return qrcode;
	}

	/**
	 * ֻ��. 
	 * @mbg.generated  2018-07-29 11:43:54
	 */
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode == null ? null : qrcode.trim();
	}
}