package com.bizvane.messagefacade.models.po;

import java.io.Serializable;
import java.util.Date;

public class RocketConfigPO implements Serializable {

  /**
   * 只读. 主键id. rocket_config_id
   * @mbg.generated  2018-07-10 21:03:24
   */
  private Integer rocketConfigId;
  /**
   * 只读. 模板名字. model_name
   * @mbg.generated  2018-07-10 21:03:24
   */
  private String modelName;
  /**
   * 只读. . business_type
   * @mbg.generated  2018-07-10 21:03:24
   */
  private String businessType;
  /**
   * 只读. 角色：producer-生产者，consumer-消费者. role_type
   * @mbg.generated  2018-07-10 21:03:24
   */
  private String roleType;
  /**
   * 只读. . role_id
   * @mbg.generated  2018-07-10 21:03:24
   */
  private String roleId;
  /**
   * 只读. . topic
   * @mbg.generated  2018-07-10 21:03:24
   */
  private String topic;
  /**
   * 只读. . tag
   * @mbg.generated  2018-07-10 21:03:24
   */
  private String tag;
  /**
   * 只读. . message_listener_bean
   * @mbg.generated  2018-07-10 21:03:24
   */
  private String messageListenerBean;
  /**
   * 只读. 备注. remark
   * @mbg.generated  2018-07-10 21:03:24
   */
  private String remark;
  /**
   * 只读. 创建人id. create_user_id
   * @mbg.generated  2018-07-10 21:03:24
   */
  private Long createUserId;
  /**
   * 只读. 创建人. create_user_name
   * @mbg.generated  2018-07-10 21:03:24
   */
  private String createUserName;
  /**
   * 只读. 创建日期. create_date
   * @mbg.generated  2018-07-10 21:03:24
   */
  private Date createDate;
  /**
   * 只读. 修改人id. modified_user_id
   * @mbg.generated  2018-07-10 21:03:24
   */
  private Long modifiedUserId;
  /**
   * 只读. 修改人. modified_user_name
   * @mbg.generated  2018-07-10 21:03:24
   */
  private String modifiedUserName;
  /**
   * 只读. 修改时间. modified_date
   * @mbg.generated  2018-07-10 21:03:24
   */
  private Date modifiedDate;
  /**
   * 只读. 数据有效性：1=有效；0=无效. valid
   * @mbg.generated  2018-07-10 21:03:24
   */
  private Boolean valid;
  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  private static final long serialVersionUID = 1L;

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  public Integer getRocketConfigId() {
    return rocketConfigId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  public void setRocketConfigId(Integer rocketConfigId) {
    this.rocketConfigId = rocketConfigId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  public String getModelName() {
    return modelName;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  public void setModelName(String modelName) {
    this.modelName = modelName == null ? null : modelName.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  public String getBusinessType() {
    return businessType;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  public void setBusinessType(String businessType) {
    this.businessType = businessType == null ? null : businessType.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  public String getRoleType() {
    return roleType;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  public void setRoleType(String roleType) {
    this.roleType = roleType == null ? null : roleType.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  public String getRoleId() {
    return roleId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  public void setRoleId(String roleId) {
    this.roleId = roleId == null ? null : roleId.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  public String getTopic() {
    return topic;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  public void setTopic(String topic) {
    this.topic = topic == null ? null : topic.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  public String getTag() {
    return tag;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  public void setTag(String tag) {
    this.tag = tag == null ? null : tag.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  public String getMessageListenerBean() {
    return messageListenerBean;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  public void setMessageListenerBean(String messageListenerBean) {
    this.messageListenerBean = messageListenerBean == null ? null : messageListenerBean.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  public String getRemark() {
    return remark;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  public void setRemark(String remark) {
    this.remark = remark == null ? null : remark.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  public Long getCreateUserId() {
    return createUserId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  public void setCreateUserId(Long createUserId) {
    this.createUserId = createUserId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  public String getCreateUserName() {
    return createUserName;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  public void setCreateUserName(String createUserName) {
    this.createUserName = createUserName == null ? null : createUserName.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  public Date getCreateDate() {
    return createDate;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  public Long getModifiedUserId() {
    return modifiedUserId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  public void setModifiedUserId(Long modifiedUserId) {
    this.modifiedUserId = modifiedUserId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  public String getModifiedUserName() {
    return modifiedUserName;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  public void setModifiedUserName(String modifiedUserName) {
    this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  public Date getModifiedDate() {
    return modifiedDate;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  public void setModifiedDate(Date modifiedDate) {
    this.modifiedDate = modifiedDate;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  public Boolean getValid() {
    return valid;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-10 21:03:24
   */
  public void setValid(Boolean valid) {
    this.valid = valid;
  }
}