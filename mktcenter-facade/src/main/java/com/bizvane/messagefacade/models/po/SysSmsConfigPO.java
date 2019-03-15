package com.bizvane.messagefacade.models.po;

import java.io.Serializable;
import java.util.Date;

public class SysSmsConfigPO implements Serializable {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_sys_sms_config.sys_sms_config_id
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "短信配置id", name = "sysSmsConfigId", required = false, example = "")
	private Long sysSmsConfigId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_sys_sms_config.sys_company_id
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "企业id", name = "sysCompanyId", required = false, example = "")
	private String sysCompanyId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_sys_sms_config.company_code
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "企业编号", name = "companyCode", required = false, example = "")
	private String companyCode;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_sys_sms_config.company_name
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "企业名称", name = "companyName", required = false, example = "")
	private String companyName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_sys_sms_config.sys_brand_id
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "品牌id", name = "sysBrandId", required = false, example = "")
	private Long sysBrandId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_sys_sms_config.brand_name
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "品牌名称", name = "brandName", required = false, example = "")
	private String brandName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_sys_sms_config.platform_type
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "平台类型id 例如  1梦网，2三通", name = "platformType", required = false, example = "")
	private Integer platformType;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_sys_sms_config.channel_type
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "通道类型：10=营销；20=验证码", name = "channelType", required = false, example = "")
	private Integer channelType;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_sys_sms_config.channel
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "通道渠道：10=商帆；20=客户", name = "channel", required = false, example = "")
	private Integer channel;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_sys_sms_config.channel_name
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "通道名称：枚举", name = "channelName", required = false, example = "")
	private String channelName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_sys_sms_config.channel_service
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "通道服务地址", name = "channelService", required = false, example = "")
	private String channelService;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_sys_sms_config.batch_channel_service
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	private String batchChannelService;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_sys_sms_config.channel_account
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "通道账号", name = "channelAccount", required = false, example = "")
	private String channelAccount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_sys_sms_config.channel_password
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "通道密码", name = "channelPassword", required = false, example = "")
	private String channelPassword;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_sys_sms_config.price
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "单价", name = "price", required = false, example = "")
	private Long price;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_sys_sms_config.batch_num
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "批量发送最大条数", name = "batchNum", required = false, example = "")
	private Integer batchNum;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_sys_sms_config.sign
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "签名", name = "sign", required = false, example = "")
	private String sign;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_sys_sms_config.company_channel
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "是否作为企业级短信通道，每个企业只能有一个，用于企业下账号修改密码的短信验证码发送等", name = "companyChannel", required = false, example = "")
	private Boolean companyChannel;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_sys_sms_config.international
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "是否为国际短信通道", name = "international", required = false, example = "")
	private Boolean international;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_sys_sms_config.remark
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "备注", name = "remark", required = false, example = "")
	private String remark;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_sys_sms_config.create_user_id
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人id", name = "createUserId", required = false, example = "")
	private Long createUserId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_sys_sms_config.create_user_name
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建人", name = "createUserName", required = false, example = "")
	private String createUserName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_sys_sms_config.create_date
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "创建日期", name = "createDate", required = false, example = "")
	private Date createDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_sys_sms_config.modified_user_id
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人id", name = "modifiedUserId", required = false, example = "")
	private Long modifiedUserId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_sys_sms_config.modified_user_name
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改人", name = "modifiedUserName", required = false, example = "")
	private String modifiedUserName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_sys_sms_config.modified_date
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "修改时间", name = "modifiedDate", required = false, example = "")
	private Date modifiedDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_sys_sms_config.valid
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	@io.swagger.annotations.ApiModelProperty(value = "数据有效性：1=有效；0=无效", name = "valid", required = false, example = "")
	private Boolean valid;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_sys_sms_config.sys_sms_config_id
	 * @return  the value of t_sys_sms_config.sys_sms_config_id
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public Long getSysSmsConfigId() {
		return sysSmsConfigId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_sys_sms_config.sys_sms_config_id
	 * @param sysSmsConfigId  the value for t_sys_sms_config.sys_sms_config_id
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public void setSysSmsConfigId(Long sysSmsConfigId) {
		this.sysSmsConfigId = sysSmsConfigId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_sys_sms_config.sys_company_id
	 * @return  the value of t_sys_sms_config.sys_company_id
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public String getSysCompanyId() {
		return sysCompanyId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_sys_sms_config.sys_company_id
	 * @param sysCompanyId  the value for t_sys_sms_config.sys_company_id
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public void setSysCompanyId(String sysCompanyId) {
		this.sysCompanyId = sysCompanyId == null ? null : sysCompanyId.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_sys_sms_config.company_code
	 * @return  the value of t_sys_sms_config.company_code
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public String getCompanyCode() {
		return companyCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_sys_sms_config.company_code
	 * @param companyCode  the value for t_sys_sms_config.company_code
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode == null ? null : companyCode.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_sys_sms_config.company_name
	 * @return  the value of t_sys_sms_config.company_name
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_sys_sms_config.company_name
	 * @param companyName  the value for t_sys_sms_config.company_name
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName == null ? null : companyName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_sys_sms_config.sys_brand_id
	 * @return  the value of t_sys_sms_config.sys_brand_id
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public Long getSysBrandId() {
		return sysBrandId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_sys_sms_config.sys_brand_id
	 * @param sysBrandId  the value for t_sys_sms_config.sys_brand_id
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public void setSysBrandId(Long sysBrandId) {
		this.sysBrandId = sysBrandId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_sys_sms_config.brand_name
	 * @return  the value of t_sys_sms_config.brand_name
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public String getBrandName() {
		return brandName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_sys_sms_config.brand_name
	 * @param brandName  the value for t_sys_sms_config.brand_name
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName == null ? null : brandName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_sys_sms_config.platform_type
	 * @return  the value of t_sys_sms_config.platform_type
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public Integer getPlatformType() {
		return platformType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_sys_sms_config.platform_type
	 * @param platformType  the value for t_sys_sms_config.platform_type
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public void setPlatformType(Integer platformType) {
		this.platformType = platformType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_sys_sms_config.channel_type
	 * @return  the value of t_sys_sms_config.channel_type
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public Integer getChannelType() {
		return channelType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_sys_sms_config.channel_type
	 * @param channelType  the value for t_sys_sms_config.channel_type
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public void setChannelType(Integer channelType) {
		this.channelType = channelType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_sys_sms_config.channel
	 * @return  the value of t_sys_sms_config.channel
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public Integer getChannel() {
		return channel;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_sys_sms_config.channel
	 * @param channel  the value for t_sys_sms_config.channel
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public void setChannel(Integer channel) {
		this.channel = channel;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_sys_sms_config.channel_name
	 * @return  the value of t_sys_sms_config.channel_name
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public String getChannelName() {
		return channelName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_sys_sms_config.channel_name
	 * @param channelName  the value for t_sys_sms_config.channel_name
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public void setChannelName(String channelName) {
		this.channelName = channelName == null ? null : channelName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_sys_sms_config.channel_service
	 * @return  the value of t_sys_sms_config.channel_service
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public String getChannelService() {
		return channelService;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_sys_sms_config.channel_service
	 * @param channelService  the value for t_sys_sms_config.channel_service
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public void setChannelService(String channelService) {
		this.channelService = channelService == null ? null : channelService.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_sys_sms_config.batch_channel_service
	 * @return  the value of t_sys_sms_config.batch_channel_service
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public String getBatchChannelService() {
		return batchChannelService;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_sys_sms_config.batch_channel_service
	 * @param batchChannelService  the value for t_sys_sms_config.batch_channel_service
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public void setBatchChannelService(String batchChannelService) {
		this.batchChannelService = batchChannelService == null ? null : batchChannelService.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_sys_sms_config.channel_account
	 * @return  the value of t_sys_sms_config.channel_account
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public String getChannelAccount() {
		return channelAccount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_sys_sms_config.channel_account
	 * @param channelAccount  the value for t_sys_sms_config.channel_account
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public void setChannelAccount(String channelAccount) {
		this.channelAccount = channelAccount == null ? null : channelAccount.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_sys_sms_config.channel_password
	 * @return  the value of t_sys_sms_config.channel_password
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public String getChannelPassword() {
		return channelPassword;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_sys_sms_config.channel_password
	 * @param channelPassword  the value for t_sys_sms_config.channel_password
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public void setChannelPassword(String channelPassword) {
		this.channelPassword = channelPassword == null ? null : channelPassword.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_sys_sms_config.price
	 * @return  the value of t_sys_sms_config.price
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public Long getPrice() {
		return price;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_sys_sms_config.price
	 * @param price  the value for t_sys_sms_config.price
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public void setPrice(Long price) {
		this.price = price;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_sys_sms_config.batch_num
	 * @return  the value of t_sys_sms_config.batch_num
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public Integer getBatchNum() {
		return batchNum;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_sys_sms_config.batch_num
	 * @param batchNum  the value for t_sys_sms_config.batch_num
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public void setBatchNum(Integer batchNum) {
		this.batchNum = batchNum;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_sys_sms_config.sign
	 * @return  the value of t_sys_sms_config.sign
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public String getSign() {
		return sign;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_sys_sms_config.sign
	 * @param sign  the value for t_sys_sms_config.sign
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public void setSign(String sign) {
		this.sign = sign == null ? null : sign.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_sys_sms_config.company_channel
	 * @return  the value of t_sys_sms_config.company_channel
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public Boolean getCompanyChannel() {
		return companyChannel;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_sys_sms_config.company_channel
	 * @param companyChannel  the value for t_sys_sms_config.company_channel
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public void setCompanyChannel(Boolean companyChannel) {
		this.companyChannel = companyChannel;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_sys_sms_config.international
	 * @return  the value of t_sys_sms_config.international
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public Boolean getInternational() {
		return international;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_sys_sms_config.international
	 * @param international  the value for t_sys_sms_config.international
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public void setInternational(Boolean international) {
		this.international = international;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_sys_sms_config.remark
	 * @return  the value of t_sys_sms_config.remark
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_sys_sms_config.remark
	 * @param remark  the value for t_sys_sms_config.remark
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_sys_sms_config.create_user_id
	 * @return  the value of t_sys_sms_config.create_user_id
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public Long getCreateUserId() {
		return createUserId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_sys_sms_config.create_user_id
	 * @param createUserId  the value for t_sys_sms_config.create_user_id
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_sys_sms_config.create_user_name
	 * @return  the value of t_sys_sms_config.create_user_name
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public String getCreateUserName() {
		return createUserName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_sys_sms_config.create_user_name
	 * @param createUserName  the value for t_sys_sms_config.create_user_name
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_sys_sms_config.create_date
	 * @return  the value of t_sys_sms_config.create_date
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_sys_sms_config.create_date
	 * @param createDate  the value for t_sys_sms_config.create_date
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_sys_sms_config.modified_user_id
	 * @return  the value of t_sys_sms_config.modified_user_id
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public Long getModifiedUserId() {
		return modifiedUserId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_sys_sms_config.modified_user_id
	 * @param modifiedUserId  the value for t_sys_sms_config.modified_user_id
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public void setModifiedUserId(Long modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_sys_sms_config.modified_user_name
	 * @return  the value of t_sys_sms_config.modified_user_name
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public String getModifiedUserName() {
		return modifiedUserName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_sys_sms_config.modified_user_name
	 * @param modifiedUserName  the value for t_sys_sms_config.modified_user_name
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public void setModifiedUserName(String modifiedUserName) {
		this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_sys_sms_config.modified_date
	 * @return  the value of t_sys_sms_config.modified_date
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_sys_sms_config.modified_date
	 * @param modifiedDate  the value for t_sys_sms_config.modified_date
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_sys_sms_config.valid
	 * @return  the value of t_sys_sms_config.valid
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public Boolean getValid() {
		return valid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_sys_sms_config.valid
	 * @param valid  the value for t_sys_sms_config.valid
	 * @mbg.generated  Mon Aug 20 20:07:00 CST 2018
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
}