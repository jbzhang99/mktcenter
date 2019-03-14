package com.bizvane.messagefacade.models.po;

import java.io.Serializable;
import java.util.Date;

public class WxMessageTempPO implements Serializable {

  /**
   * 只读. 主键自增. wx_message_temp_id
   * @mbg.generated  2018-08-02 15:58:49
   */
  @io.swagger.annotations.ApiModelProperty(value = "主键自增", name = "wxMessageTempId", required = false, example = "")
  private Long wxMessageTempId;
  /**
   * 只读. 所属企业id. sys_company_id
   * @mbg.generated  2018-08-02 15:58:49
   */
  @io.swagger.annotations.ApiModelProperty(value = "所属企业id", name = "sysCompanyId", required = false, example = "")
  private Long sysCompanyId;
  /**
   * 只读. 所属品牌id. sys_brand_id
   * @mbg.generated  2018-08-02 15:58:49
   */
  @io.swagger.annotations.ApiModelProperty(value = "所属品牌id", name = "sysBrandId", required = false, example = "")
  private Long sysBrandId;
  /**
   * 只读. 所属公众号id. wx_public_id
   * @mbg.generated  2018-08-02 15:58:49
   */
  @io.swagger.annotations.ApiModelProperty(value = "所属公众号id", name = "wxPublicId", required = false, example = "")
  private Long wxPublicId;
  /**
   * 只读. 对应微信上的模板编号. short_code
   * @mbg.generated  2018-08-02 15:58:49
   */
  @io.swagger.annotations.ApiModelProperty(value = "对应微信上的模板编号", name = "shortCode", required = false, example = "")
  private String shortCode;
  /**
   * 只读. 对应微信上的模板id. wx_template_id
   * @mbg.generated  2018-08-02 15:58:49
   */
  @io.swagger.annotations.ApiModelProperty(value = "对应微信上的模板id", name = "wxTemplateId", required = false, example = "")
  private String wxTemplateId;
  /**
   * 只读. 主行业. primary_industry
   * @mbg.generated  2018-08-02 15:58:49
   */
  @io.swagger.annotations.ApiModelProperty(value = "主行业", name = "primaryIndustry", required = false, example = "")
  private String primaryIndustry;
  /**
   * 只读. 副行业. deputy_indestry
   * @mbg.generated  2018-08-02 15:58:49
   */
  @io.swagger.annotations.ApiModelProperty(value = "副行业", name = "deputyIndestry", required = false, example = "")
  private String deputyIndestry;
  /**
   * 只读. 模板标题. title
   * @mbg.generated  2018-08-02 15:58:49
   */
  @io.swagger.annotations.ApiModelProperty(value = "模板标题", name = "title", required = false, example = "")
  private String title;
  /**
   * 只读. 头信息. first
   * @mbg.generated  2018-08-02 15:58:49
   */
  @io.swagger.annotations.ApiModelProperty(value = "头信息", name = "first", required = false, example = "")
  private String first;
  /**
   * 只读. 尾信息. tail
   * @mbg.generated  2018-08-02 15:58:49
   */
  @io.swagger.annotations.ApiModelProperty(value = "尾信息", name = "tail", required = false, example = "")
  private String tail;
  /**
   * 只读. 模板内容. content
   * @mbg.generated  2018-08-02 15:58:49
   */
  @io.swagger.annotations.ApiModelProperty(value = "模板内容", name = "content", required = false, example = "")
  private String content;
  /**
   * 只读. 模板消息. message
   * @mbg.generated  2018-08-02 15:58:49
   */
  @io.swagger.annotations.ApiModelProperty(value = "模板消息", name = "message", required = false, example = "")
  private String message;
  /**
   * 只读. 示例. example
   * @mbg.generated  2018-08-02 15:58:49
   */
  @io.swagger.annotations.ApiModelProperty(value = "示例", name = "example", required = false, example = "")
  private String example;
  /**
   * 只读. 详情地址. url
   * @mbg.generated  2018-08-02 15:58:49
   */
  @io.swagger.annotations.ApiModelProperty(value = "详情地址", name = "url", required = false, example = "")
  private String url;
  /**
   * 只读. 业务类型(COUPON-券，INTEGRAL-积分，MEMBER-会员，ORDER-订单). business_type
   * @mbg.generated  2018-08-02 15:58:49
   */
  @io.swagger.annotations.ApiModelProperty(value = "业务类型(COUPON-券，INTEGRAL-积分，MEMBER-会员，ORDER-订单)",
      name = "businessType", required = false, example = "")
  private String businessType;
  /**
   * 只读. 模板类型(COUPON_RECEIVE-券到账提醒，COUPON_UNRECEIVED-券未领取提醒，COUPON_EXPIRE-券到期提醒，INTEGRAL_ADD-积分增加提醒，INTEGRAL_SUBTRACT-积分减少提醒，INTEGRAL_EXPIRE-积分到期提醒，INTEGRAL_USE-积分使用提醒，MEMEBER_REGISTER-会员注册提醒，MEMEBER_INVITE_REGISTER-会员绑定成功提醒，MEMEBER_UPGRADE-会员升级提醒，MEMEBER_DOWNGRADE-会员降级提醒，ORDER_OFFLINE_CONSUME-线下订单提醒，ORDER_ONLINE_CONSUME-线上订单提醒，ORDER_PAYMENT-订单支付提醒，ORDER_SHIP-订单发货提醒，ORDER_SIGN-订单签收提醒，ORDER_CANCEL-订单取消提醒，ORDER_APPRAISAL-订单评价提醒). template_type
   * @mbg.generated  2018-08-02 15:58:49
   */
  @io.swagger.annotations.ApiModelProperty(
      value = "模板类型(COUPON_RECEIVE-券到账提醒，COUPON_UNRECEIVED-券未领取提醒，COUPON_EXPIRE-券到期提醒，INTEGRAL_ADD-积分增加提醒，INTEGRAL_SUBTRACT-积分减少提醒，INTEGRAL_EXPIRE-积分到期提醒，INTEGRAL_USE-积分使用提醒，MEMEBER_REGISTER-会员注册提醒，MEMEBER_INVITE_REGISTER-会员绑定成功提醒，MEMEBER_UPGRADE-会员升级提醒，MEMEBER_DOWNGRADE-会员降级提醒，ORDER_OFFLINE_CONSUME-线下订单提醒，ORDER_ONLINE_CONSUME-线上订单提醒，ORDER_PAYMENT-订单支付提醒，ORDER_SHIP-订单发货提醒，ORDER_SIGN-订单签收提醒，ORDER_CANCEL-订单取消提醒，ORDER_APPRAISAL-订单评价提醒)",
      name = "templateType", required = false, example = "")
  private String templateType;
  /**
   * 只读. 执行方法. class_path
   * @mbg.generated  2018-08-02 15:58:49
   */
  @io.swagger.annotations.ApiModelProperty(value = "执行方法", name = "classPath", required = false, example = "")
  private String classPath;
  /**
   * 只读. 是否需要授权. isauthorize
   * @mbg.generated  2018-08-02 15:58:49
   */
  @io.swagger.annotations.ApiModelProperty(value = "是否需要授权", name = "isauthorize", required = false, example = "")
  private Boolean isauthorize;
  /**
   * 只读. 是否发模板消息. issendmessage
   * @mbg.generated  2018-08-02 15:58:49
   */
  @io.swagger.annotations.ApiModelProperty(value = "是否发模板消息", name = "issendmessage", required = false, example = "")
  private Boolean issendmessage;
  /**
   * 只读. 备注. remark
   * @mbg.generated  2018-08-02 15:58:49
   */
  @io.swagger.annotations.ApiModelProperty(value = "备注", name = "remark", required = false, example = "")
  private String remark;
  /**
   * 只读. 创建人id. create_user_id
   * @mbg.generated  2018-08-02 15:58:49
   */
  @io.swagger.annotations.ApiModelProperty(value = "创建人id", name = "createUserId", required = false, example = "")
  private Long createUserId;
  /**
   * 只读. 创建人. create_user_name
   * @mbg.generated  2018-08-02 15:58:49
   */
  @io.swagger.annotations.ApiModelProperty(value = "创建人", name = "createUserName", required = false, example = "")
  private String createUserName;
  /**
   * 只读. 创建时间. create_date
   * @mbg.generated  2018-08-02 15:58:49
   */
  @io.swagger.annotations.ApiModelProperty(value = "创建时间", name = "createDate", required = false, example = "")
  private Date createDate;
  /**
   * 只读. 修改人id. modified_user_id
   * @mbg.generated  2018-08-02 15:58:49
   */
  @io.swagger.annotations.ApiModelProperty(value = "修改人id", name = "modifiedUserId", required = false, example = "")
  private Long modifiedUserId;
  /**
   * 只读. 修改人. modified_user_name
   * @mbg.generated  2018-08-02 15:58:49
   */
  @io.swagger.annotations.ApiModelProperty(value = "修改人", name = "modifiedUserName", required = false, example = "")
  private String modifiedUserName;
  /**
   * 只读. 修改时间. modified_date
   * @mbg.generated  2018-08-02 15:58:49
   */
  @io.swagger.annotations.ApiModelProperty(value = "修改时间", name = "modifiedDate", required = false, example = "")
  private Date modifiedDate;
  /**
   * 只读. 数据有效性（1有效，0无效）. valid
   * @mbg.generated  2018-08-02 15:58:49
   */
  @io.swagger.annotations.ApiModelProperty(value = "数据有效性（1有效，0无效）", name = "valid", required = false, example = "")
  private Boolean valid;
  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  private static final long serialVersionUID = 1L;

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public Long getWxMessageTempId() {
    return wxMessageTempId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public void setWxMessageTempId(Long wxMessageTempId) {
    this.wxMessageTempId = wxMessageTempId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public Long getSysCompanyId() {
    return sysCompanyId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public void setSysCompanyId(Long sysCompanyId) {
    this.sysCompanyId = sysCompanyId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public Long getSysBrandId() {
    return sysBrandId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public void setSysBrandId(Long sysBrandId) {
    this.sysBrandId = sysBrandId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public Long getWxPublicId() {
    return wxPublicId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public void setWxPublicId(Long wxPublicId) {
    this.wxPublicId = wxPublicId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public String getShortCode() {
    return shortCode;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public void setShortCode(String shortCode) {
    this.shortCode = shortCode == null ? null : shortCode.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public String getWxTemplateId() {
    return wxTemplateId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public void setWxTemplateId(String wxTemplateId) {
    this.wxTemplateId = wxTemplateId == null ? null : wxTemplateId.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public String getPrimaryIndustry() {
    return primaryIndustry;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public void setPrimaryIndustry(String primaryIndustry) {
    this.primaryIndustry = primaryIndustry == null ? null : primaryIndustry.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public String getDeputyIndestry() {
    return deputyIndestry;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public void setDeputyIndestry(String deputyIndestry) {
    this.deputyIndestry = deputyIndestry == null ? null : deputyIndestry.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public String getTitle() {
    return title;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public void setTitle(String title) {
    this.title = title == null ? null : title.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public String getFirst() {
    return first;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public void setFirst(String first) {
    this.first = first == null ? null : first.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public String getTail() {
    return tail;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public void setTail(String tail) {
    this.tail = tail == null ? null : tail.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public String getContent() {
    return content;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public void setContent(String content) {
    this.content = content == null ? null : content.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public String getMessage() {
    return message;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public void setMessage(String message) {
    this.message = message == null ? null : message.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public String getExample() {
    return example;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public void setExample(String example) {
    this.example = example == null ? null : example.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public String getUrl() {
    return url;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public void setUrl(String url) {
    this.url = url == null ? null : url.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public String getBusinessType() {
    return businessType;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public void setBusinessType(String businessType) {
    this.businessType = businessType == null ? null : businessType.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public String getTemplateType() {
    return templateType;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public void setTemplateType(String templateType) {
    this.templateType = templateType == null ? null : templateType.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public String getClassPath() {
    return classPath;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public void setClassPath(String classPath) {
    this.classPath = classPath == null ? null : classPath.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public Boolean getIsauthorize() {
    return isauthorize;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public void setIsauthorize(Boolean isauthorize) {
    this.isauthorize = isauthorize;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public Boolean getIssendmessage() {
    return issendmessage;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public void setIssendmessage(Boolean issendmessage) {
    this.issendmessage = issendmessage;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public String getRemark() {
    return remark;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public void setRemark(String remark) {
    this.remark = remark == null ? null : remark.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public Long getCreateUserId() {
    return createUserId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public void setCreateUserId(Long createUserId) {
    this.createUserId = createUserId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public String getCreateUserName() {
    return createUserName;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public void setCreateUserName(String createUserName) {
    this.createUserName = createUserName == null ? null : createUserName.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public Date getCreateDate() {
    return createDate;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public Long getModifiedUserId() {
    return modifiedUserId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public void setModifiedUserId(Long modifiedUserId) {
    this.modifiedUserId = modifiedUserId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public String getModifiedUserName() {
    return modifiedUserName;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public void setModifiedUserName(String modifiedUserName) {
    this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public Date getModifiedDate() {
    return modifiedDate;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public void setModifiedDate(Date modifiedDate) {
    this.modifiedDate = modifiedDate;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public Boolean getValid() {
    return valid;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  public void setValid(Boolean valid) {
    this.valid = valid;
  }
}