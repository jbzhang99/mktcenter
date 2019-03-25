package com.bizvane.messagefacade.models.po;

import java.io.Serializable;
import java.util.Date;

public class WxPublicPO implements Serializable {

  /**
   * 只读. 主键自增. wx_public_id
   * @mbg.generated  2018-07-14 14:12:10
   */
  private Long wxPublicId;
  /**
   * 只读. 所属品牌id. sys_brand_id
   * @mbg.generated  2018-07-14 14:12:10
   */
  private Long sysBrandId;
  /**
   * 只读. . appid
   * @mbg.generated  2018-07-14 14:12:10
   */
  private String appid;
  /**
   * 只读. 域名. domain
   * @mbg.generated  2018-07-14 14:12:10
   */
  private String domain;
  /**
   * 只读. 公众号二维码地址. wxqrcodeurl
   * @mbg.generated  2018-07-14 14:12:10
   */
  private String wxqrcodeurl;
  /**
   * 只读. 公众号昵称. nick
   * @mbg.generated  2018-07-14 14:12:10
   */
  private String nick;
  /**
   * 只读. 公众号头像. headimg
   * @mbg.generated  2018-07-14 14:12:10
   */
  private String headimg;
  /**
   * 只读. 公众号类型，0代表订阅号，1代表由历史老帐号升级后的订阅号，2代表服务号. typeinfo
   * @mbg.generated  2018-07-14 14:12:10
   */
  private String typeinfo;
  /**
   * 只读. 公众号认证类型，-1代表未认证，0代表微信认证，1代表新浪微博认证，2代表腾讯微博认证，3代表已资质认证通过但还未通过名称认证，4代表已资质认证通过、还未通过名称认证，但通过了新浪微博认证，5代表已资质认证通过、还未通过名称认证，但通过了腾讯微博认证. verifytype
   * @mbg.generated  2018-07-14 14:12:10
   */
  private String verifytype;
  /**
   * 只读. 授权方公众号所设置的微信号，可能为空. code
   * @mbg.generated  2018-07-14 14:12:10
   */
  private String code;
  /**
   * 只读. 原始id. originid
   * @mbg.generated  2018-07-14 14:12:10
   */
  private String originid;
  /**
   * 只读. 二维码图片的url. qrcodeurl
   * @mbg.generated  2018-07-14 14:12:10
   */
  private String qrcodeurl;
  /**
   * 只读. 授权刷新码. authorizer_refresh_token
   * @mbg.generated  2018-07-14 14:12:10
   */
  private String authorizerRefreshToken;
  /**
   * 只读. 授权码. authorizer_access_token
   * @mbg.generated  2018-07-14 14:12:10
   */
  private String authorizerAccessToken;
  /**
   * 只读. 授权码过期时间. aattime
   * @mbg.generated  2018-07-14 14:12:10
   */
  private Long aattime;
  /**
   * 只读. jssdk token. jssdk_access_token
   * @mbg.generated  2018-07-14 14:12:10
   */
  private String jssdkAccessToken;
  /**
   * 只读. jssdk token 过期时间. jattime
   * @mbg.generated  2018-07-14 14:12:10
   */
  private Long jattime;
  /**
   * 只读. 第三方应用appid. publicpartyappid
   * @mbg.generated  2018-07-14 14:12:10
   */
  private String publicpartyappid;
  /**
   * 只读. 是否授权. isconnect
   * @mbg.generated  2018-07-14 14:12:10
   */
  private String isconnect;
  /**
   * 只读. 品牌名称. brand_name
   * @mbg.generated  2018-07-14 14:12:10
   */
  private String brandName;
  /**
   * 只读. 品牌图片. brand_picture
   * @mbg.generated  2018-07-14 14:12:10
   */
  private String brandPicture;
  /**
   * 只读. 备注. remark
   * @mbg.generated  2018-07-14 14:12:10
   */
  private String remark;
  /**
   * 只读. 创建人id. create_user_id
   * @mbg.generated  2018-07-14 14:12:10
   */
  private Long createUserId;
  /**
   * 只读. 创建人. create_user_name
   * @mbg.generated  2018-07-14 14:12:10
   */
  private String createUserName;
  /**
   * 只读. 创建时间. create_date
   * @mbg.generated  2018-07-14 14:12:10
   */
  private Date createDate;
  /**
   * 只读. 修改人id. modified_user_id
   * @mbg.generated  2018-07-14 14:12:10
   */
  private Long modifiedUserId;
  /**
   * 只读. 修改人. modified_user_name
   * @mbg.generated  2018-07-14 14:12:10
   */
  private String modifiedUserName;
  /**
   * 只读. 修改时间. modified_date
   * @mbg.generated  2018-07-14 14:12:10
   */
  private Date modifiedDate;
  /**
   * 只读. 数据有效性（1有效，0无效）. valid
   * @mbg.generated  2018-07-14 14:12:10
   */
  private Boolean valid;
  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  private static final long serialVersionUID = 1L;

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public Long getWxPublicId() {
    return wxPublicId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public void setWxPublicId(Long wxPublicId) {
    this.wxPublicId = wxPublicId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public Long getSysBrandId() {
    return sysBrandId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public void setSysBrandId(Long sysBrandId) {
    this.sysBrandId = sysBrandId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public String getAppid() {
    return appid;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public void setAppid(String appid) {
    this.appid = appid == null ? null : appid.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public String getDomain() {
    return domain;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public void setDomain(String domain) {
    this.domain = domain == null ? null : domain.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public String getWxqrcodeurl() {
    return wxqrcodeurl;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public void setWxqrcodeurl(String wxqrcodeurl) {
    this.wxqrcodeurl = wxqrcodeurl == null ? null : wxqrcodeurl.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public String getNick() {
    return nick;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public void setNick(String nick) {
    this.nick = nick == null ? null : nick.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public String getHeadimg() {
    return headimg;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public void setHeadimg(String headimg) {
    this.headimg = headimg == null ? null : headimg.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public String getTypeinfo() {
    return typeinfo;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public void setTypeinfo(String typeinfo) {
    this.typeinfo = typeinfo == null ? null : typeinfo.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public String getVerifytype() {
    return verifytype;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public void setVerifytype(String verifytype) {
    this.verifytype = verifytype == null ? null : verifytype.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public String getCode() {
    return code;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public void setCode(String code) {
    this.code = code == null ? null : code.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public String getOriginid() {
    return originid;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public void setOriginid(String originid) {
    this.originid = originid == null ? null : originid.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public String getQrcodeurl() {
    return qrcodeurl;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public void setQrcodeurl(String qrcodeurl) {
    this.qrcodeurl = qrcodeurl == null ? null : qrcodeurl.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public String getAuthorizerRefreshToken() {
    return authorizerRefreshToken;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public void setAuthorizerRefreshToken(String authorizerRefreshToken) {
    this.authorizerRefreshToken = authorizerRefreshToken == null ? null : authorizerRefreshToken.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public String getAuthorizerAccessToken() {
    return authorizerAccessToken;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public void setAuthorizerAccessToken(String authorizerAccessToken) {
    this.authorizerAccessToken = authorizerAccessToken == null ? null : authorizerAccessToken.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public Long getAattime() {
    return aattime;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public void setAattime(Long aattime) {
    this.aattime = aattime;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public String getJssdkAccessToken() {
    return jssdkAccessToken;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public void setJssdkAccessToken(String jssdkAccessToken) {
    this.jssdkAccessToken = jssdkAccessToken == null ? null : jssdkAccessToken.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public Long getJattime() {
    return jattime;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public void setJattime(Long jattime) {
    this.jattime = jattime;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public String getPublicpartyappid() {
    return publicpartyappid;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public void setPublicpartyappid(String publicpartyappid) {
    this.publicpartyappid = publicpartyappid == null ? null : publicpartyappid.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public String getIsconnect() {
    return isconnect;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public void setIsconnect(String isconnect) {
    this.isconnect = isconnect == null ? null : isconnect.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public String getBrandName() {
    return brandName;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public void setBrandName(String brandName) {
    this.brandName = brandName == null ? null : brandName.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public String getBrandPicture() {
    return brandPicture;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public void setBrandPicture(String brandPicture) {
    this.brandPicture = brandPicture == null ? null : brandPicture.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public String getRemark() {
    return remark;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public void setRemark(String remark) {
    this.remark = remark == null ? null : remark.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public Long getCreateUserId() {
    return createUserId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public void setCreateUserId(Long createUserId) {
    this.createUserId = createUserId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public String getCreateUserName() {
    return createUserName;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public void setCreateUserName(String createUserName) {
    this.createUserName = createUserName == null ? null : createUserName.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public Date getCreateDate() {
    return createDate;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public Long getModifiedUserId() {
    return modifiedUserId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public void setModifiedUserId(Long modifiedUserId) {
    this.modifiedUserId = modifiedUserId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public String getModifiedUserName() {
    return modifiedUserName;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public void setModifiedUserName(String modifiedUserName) {
    this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public Date getModifiedDate() {
    return modifiedDate;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public void setModifiedDate(Date modifiedDate) {
    this.modifiedDate = modifiedDate;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public Boolean getValid() {
    return valid;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-14 14:12:10
   */
  public void setValid(Boolean valid) {
    this.valid = valid;
  }
}