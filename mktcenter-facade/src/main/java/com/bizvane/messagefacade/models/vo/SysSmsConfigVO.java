package com.bizvane.messagefacade.models.vo;

import java.util.Date;

/**
 * @Author: lijunwei
 * @Time: 2018/7/17 10:04
 */
public class SysSmsConfigVO {

    private String sysCompanyId;//公司id
    private Long sysBrandId;//品牌id
    private Integer platformType;//通道所属品台: 1梦网，2三通.
    private Integer channelType;//通道用途:通道类型：10=营销；20=验证码
    private Integer channel;//通道类型:10=商帆；20=客户

    private String sign;//签名
    private Boolean companyChannel;//是否作为企业级短信通道,用于发送短信
    private Boolean international;  //只读. 是否为国际短信通道. international
    private String remark;// remark   用于备注   子码

    private String channelName;//通道名称
    private String channelService;//路径
    private String channelAccount;//账号
    private String channelPassword;//密码
    private  String  msgContent; //内容
    private  String  phone;//单个手机号
    private  String  phones;//多个手机号,用于批量发送
    private  Integer batchNum;//批量发送最大条数
    
    private  String  msgId;//任务id
    
    

    private Boolean status;//短信是否发送成功
    
    
    // 以下下字段po转vo用到
    private Long sysSmsConfigId;
    private String companyCode;//公司名称
    private String companyName;//公司名称
    private String brandName;//品牌名称
    private Long price;//价格
    private Long createUserId;//创建人id
    private String createUserName;//创建人id
    private  String  countryCode;//区号
	private Date createDate;
	private Long modifiedUserId;
	private String modifiedUserName;
	private Date modifiedDate;
	private Boolean valid;
	private String batchChannelService;
	
	
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	public String getBatchChannelService() {
		return batchChannelService;
	}
	public void setBatchChannelService(String batchChannelService) {
		this.batchChannelService = batchChannelService;
	}
	public String getSysCompanyId() {
		return sysCompanyId;
	}
	public void setSysCompanyId(String sysCompanyId) {
		this.sysCompanyId = sysCompanyId;
	}
	public Long getSysBrandId() {
		return sysBrandId;
	}
	public void setSysBrandId(Long sysBrandId) {
		this.sysBrandId = sysBrandId;
	}
	public Integer getPlatformType() {
		return platformType;
	}
	public void setPlatformType(Integer platformType) {
		this.platformType = platformType;
	}
	public Integer getChannelType() {
		return channelType;
	}
	public void setChannelType(Integer channelType) {
		this.channelType = channelType;
	}
	public Integer getChannel() {
		return channel;
	}
	public void setChannel(Integer channel) {
		this.channel = channel;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public Boolean getCompanyChannel() {
		return companyChannel;
	}
	public void setCompanyChannel(Boolean companyChannel) {
		this.companyChannel = companyChannel;
	}
	public Boolean getInternational() {
		return international;
	}
	public void setInternational(Boolean international) {
		this.international = international;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public String getChannelService() {
		return channelService;
	}
	public void setChannelService(String channelService) {
		this.channelService = channelService;
	}
	public String getChannelAccount() {
		return channelAccount;
	}
	public void setChannelAccount(String channelAccount) {
		this.channelAccount = channelAccount;
	}
	public String getChannelPassword() {
		return channelPassword;
	}
	public void setChannelPassword(String channelPassword) {
		this.channelPassword = channelPassword;
	}
	public String getMsgContent() {
		return msgContent;
	}
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhones() {
		return phones;
	}
	public void setPhones(String phones) {
		this.phones = phones;
	}
	public Integer getBatchNum() {
		return batchNum;
	}
	public void setBatchNum(Integer batchNum) {
		this.batchNum = batchNum;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Long getSysSmsConfigId() {
		return sysSmsConfigId;
	}
	public void setSysSmsConfigId(Long sysSmsConfigId) {
		this.sysSmsConfigId = sysSmsConfigId;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
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
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Long getModifiedUserId() {
		return modifiedUserId;
	}
	public void setModifiedUserId(Long modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}
	public String getModifiedUserName() {
		return modifiedUserName;
	}
	public void setModifiedUserName(String modifiedUserName) {
		this.modifiedUserName = modifiedUserName;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public Boolean getValid() {
		return valid;
	}
	public void setValid(Boolean valid) {
		this.valid = valid;
	}




    
}
