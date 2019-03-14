package com.bizvane.messagefacade.models.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class WxVipPO implements Serializable {

  /**
   * 只读. 主键自增. ID
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Long id;
  /**
   * 只读. 所属公司. AD_CLIENT_ID
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Long adClientId;
  /**
   * 只读. 记录创建人. CREATEID
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Long createid;
  /**
   * 只读. 创建时间. CREATEDATE
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Date createdate;
  /**
   * 只读. 记录修改人. MODIFYID
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Long modifyid;
  /**
   * 只读. 修改时间. MODIFYDATE
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Date modifydate;
  /**
   * 只读. 是否可用. ISACTIVE
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String isactive;
  /**
   * 只读. 会员名称. NAME
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String name;
  /**
   * 只读. 会员昵称. NICKNAME
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String nickname;
  /**
   * 只读. 会员编号. VIP_NO
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String vipNo;
  /**
   * 只读. 关联会员类型. WX_VIPTYPE_ID
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Long wxViptypeId;
  /**
   * 只读. 储值卡号. PET_CARD
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String petCard;
  /**
   * 只读. 密码. PASSWORD
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String password;
  /**
   * 只读. 是否设置储值卡密码(Y/N). ISSETPASSWORD
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String issetpassword;
  /**
   * 只读. 开卡时间. OPENCARD_TIME
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Date opencardTime;
  /**
   * 只读. 过期时间（有效期）. OVERCARD_TIME
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Date overcardTime;
  /**
   * 只读. 总积分. TOTAL_INTEGRAL
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Integer totalIntegral;
  /**
   * 只读. 余额. BALANCE
   * @mbg.generated  2018-07-07 17:52:51
   */
  private BigDecimal balance;
  /**
   * 只读. 状态名称. STATUS_NAME
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String statusName;
  /**
   * 只读. 手机号. PHONE_NUMBER
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String phoneNumber;
  /**
   * 只读. 身份证号. ID_NUMBER
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String idNumber;
  /**
   * 只读. 性别. GENDER
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String gender;
  /**
   * 只读. 生日. BIRTHDAY
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Date birthday;
  /**
   * 只读. 邮箱. EMAIL
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String email;
  /**
   * 只读. 地区省. PROVINCES
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String provinces;
  /**
   * 只读. 地区市. CITIES
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String cities;
  /**
   * 只读. 地区县. COUNTIES
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String counties;
  /**
   * 只读. OPENID关联. OPENID
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String openid;
  /**
   * 只读. 线下卡号. OFF_CARD_ID
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String offCardId;
  /**
   * 只读. 是否线上绑卡. ISTIEDCARD
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String istiedcard;
  /**
   * 只读. 头像图片. HEADIMG_URL
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String headimgUrl;
  /**
   * 只读. 开卡门店关联. WX_STORE_ID
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Long wxStoreId;
  /**
   * 只读. 开卡导购关联. WX_GUIDE_ID
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Long wxGuideId;
  /**
   * 只读. 当前门店. WX_STORE_CUR_ID
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Long wxStoreCurId;
  /**
   * 只读. 当前导购. WX_GUIDE_CUR_ID
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Long wxGuideCurId;
  /**
   * 只读. 是否关注. ISFOCUS
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String isfocus;
  /**
   * 只读. UNIONID关联. UNIONID
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String unionid;
  /**
   * 只读. 最后访问时间. LAST_ACCESS_TIME
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Date lastAccessTime;
  /**
   * 只读. 关注时间. FOCUS_TIME
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Date focusTime;
  /**
   * 只读. 更新时间. UPDATE_TIME
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Date updateTime;
  /**
   * 只读. 取消关注时间. CANCEL_TIME
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Date cancelTime;
  /**
   * 只读. 所属公众号. WX_PUBLIC_ID
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Long wxPublicId;
  /**
   * 只读. 会员编号. CUSTCODE
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String custcode;
  /**
   * 只读. 是否需要同步vip信息. NEED_ERPUPDATE
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String needErpupdate;
  /**
   * 只读. 最后消费时间. LAST_DATE
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Date lastDate;
  /**
   * 只读. 累计消费金额. AMOUNT
   * @mbg.generated  2018-07-07 17:52:51
   */
  private BigDecimal amount;
  /**
   * 只读. 职业. PROFESSIONAL
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String professional;
  /**
   * 只读. 行业. BUSINESS
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String business;
  /**
   * 只读. 爱好. HOBBY
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String hobby;
  /**
   * 只读. 线下ERPID. ERPID
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String erpid;
  /**
   * 只读. 累计一年消费金额. AMOUNT_YEAR
   * @mbg.generated  2018-07-07 17:52:51
   */
  private BigDecimal amountYear;
  /**
   * 只读. 线下开卡状态. ERPOPENCARDSTATUS
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String erpopencardstatus;
  /**
   * 只读. 线下卡是否有效. ERPVIPSTATE
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String erpvipstate;
  /**
   * 只读. 是否老会员. ISOLDVIP
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String isoldvip;
  /**
   * 只读. 是否取消关注. IS_UNSUBSCRIBE
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String isUnsubscribe;
  /**
   * 只读. 创建微信会员卡接口并审核通过后，微信返回的”会员卡卡套“. CARDID
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String cardid;
  /**
   * 只读. 是否绑定会员. ISBING
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String isbing;
  /**
   * 只读. 微信卡套id. WX_CARDID
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String wxCardid;
  /**
   * 只读. 微信会员领取卡卷code,激活、修改卡号时可用. WX_CODE
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String wxCode;
  /**
   * 只读. 会员来源（1001,2001,3001,4001分别表示公众号开卡，微信支付即会员，支付宝支付即会员,天猫会员）. VIP_SOURCE
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String vipSource;
  /**
   * 只读. 线上开卡时间. ONLINE_OPENTIME
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Date onlineOpentime;
  /**
   * 只读. 赠送金额. GIVE_MONEY
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Long giveMoney;
  /**
   * 只读. 支付宝用户id. ALIPAY_USER_ID
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String alipayUserId;
  /**
   * 只读. 会员所属消费区域关联(ecco). WX_CONSUMEAREA_ID
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Long wxConsumeareaId;
  /**
   * 只读. 解绑时间. UNBIND_TIME
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Date unbindTime;
  /**
   * 只读. 是否送券(登录,开卡). ISSENDCOUPON
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String issendcoupon;
  /**
   * 只读. 是否送过积分(登录,开卡). ISSENDINTEGRAL
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String issendintegral;
  /**
   * 只读. 登录或者开卡送积分时间. SENDINTEGRAL_TIME
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Date sendintegralTime;
  /**
   * 只读. 登录或者开卡送券时间. SENDCOUPON_TIME
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Date sendcouponTime;
  /**
   * 只读. 所属经销商. WX_DEALERS_ID
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Long wxDealersId;
  /**
   * 只读. CRM是否发券. ISCRMSENDCOUPON
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String iscrmsendcoupon;
  /**
   * 只读. 会员活动分享人openid. SHARE_OPEN_ID
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String shareOpenId;
  /**
   * 只读. 关联活动. WX_CROSS_BRAND_ID
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Long wxCrossBrandId;
  /**
   * 只读. 跨品牌活动ID. WX_CROSS_BRAND_ITEM_ID
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Long wxCrossBrandItemId;
  /**
   * 只读. 活动公众号. CROSS_ID
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Long crossId;
  /**
   * 只读. 是否执行过跨品牌活动. IS_CROSS
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String isCross;
  /**
   * 只读. 区号. AREA_CODE
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String areaCode;
  /**
   * 只读. 会员头像. WX_HEADIMG
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String wxHeadimg;
  /**
   * 只读. 天猫加密手机号. MIX_MOBILE
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String mixMobile;
  /**
   * 只读. 会员淘宝昵称. TAOBAO_NICK
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String taobaoNick;
  /**
   * 只读. 场景id(支付宝会员卡引进会员的场景). OUTER_STR
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String outerStr;
  /**
   * 只读. 微信电子会员卡场景id. WX_OUTER_STR
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String wxOuterStr;
  /**
   * 只读. 支付宝会员卡开卡时间. ALIPAY_OPENCARD_TIME
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Date alipayOpencardTime;
  /**
   * 只读. 微信电子会员卡开卡时间. WXECARD_OPENCARD_TIME
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Date wxecardOpencardTime;
  /**
   * 只读. 天猫领卡时间. TMALL_OPENCARD_TIME
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Date tmallOpencardTime;
  /**
   * 只读. 支付宝业务卡号，用于删卡传参. BIZ_CARD_NO
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String bizCardNo;
  /**
   * 只读. 昵称. NICK
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String nick;
  /**
   * 只读. 是否发生日券. IS_SENDBIRTHDAY_COUPON
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String isSendbirthdayCoupon;
  /**
   * 只读. hbase同步时间. HBASE_AUTO_TIME
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Date hbaseAutoTime;
  /**
   * 只读. 到期积分. CLEAR_POINT
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Integer clearPoint;
  /**
   * 只读. 身高. VIP_HEIGHT
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String vipHeight;
  /**
   * 只读. 体重. VIP_WEIGHT
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String vipWeight;
  /**
   * 只读. 鞋码. SHOES_SIZE
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String shoesSize;
  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  private static final long serialVersionUID = 1L;

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public Long getId() {
    return id;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public Long getAdClientId() {
    return adClientId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setAdClientId(Long adClientId) {
    this.adClientId = adClientId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public Long getCreateid() {
    return createid;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setCreateid(Long createid) {
    this.createid = createid;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public Date getCreatedate() {
    return createdate;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setCreatedate(Date createdate) {
    this.createdate = createdate;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public Long getModifyid() {
    return modifyid;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setModifyid(Long modifyid) {
    this.modifyid = modifyid;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public Date getModifydate() {
    return modifydate;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setModifydate(Date modifydate) {
    this.modifydate = modifydate;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getIsactive() {
    return isactive;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setIsactive(String isactive) {
    this.isactive = isactive == null ? null : isactive.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getName() {
    return name;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setName(String name) {
    this.name = name == null ? null : name.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getNickname() {
    return nickname;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setNickname(String nickname) {
    this.nickname = nickname == null ? null : nickname.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getVipNo() {
    return vipNo;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setVipNo(String vipNo) {
    this.vipNo = vipNo == null ? null : vipNo.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public Long getWxViptypeId() {
    return wxViptypeId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setWxViptypeId(Long wxViptypeId) {
    this.wxViptypeId = wxViptypeId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getPetCard() {
    return petCard;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setPetCard(String petCard) {
    this.petCard = petCard == null ? null : petCard.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getPassword() {
    return password;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setPassword(String password) {
    this.password = password == null ? null : password.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getIssetpassword() {
    return issetpassword;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setIssetpassword(String issetpassword) {
    this.issetpassword = issetpassword == null ? null : issetpassword.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public Date getOpencardTime() {
    return opencardTime;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setOpencardTime(Date opencardTime) {
    this.opencardTime = opencardTime;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public Date getOvercardTime() {
    return overcardTime;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setOvercardTime(Date overcardTime) {
    this.overcardTime = overcardTime;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public Integer getTotalIntegral() {
    return totalIntegral;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setTotalIntegral(Integer totalIntegral) {
    this.totalIntegral = totalIntegral;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public BigDecimal getBalance() {
    return balance;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getStatusName() {
    return statusName;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setStatusName(String statusName) {
    this.statusName = statusName == null ? null : statusName.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getIdNumber() {
    return idNumber;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setIdNumber(String idNumber) {
    this.idNumber = idNumber == null ? null : idNumber.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getGender() {
    return gender;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setGender(String gender) {
    this.gender = gender == null ? null : gender.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public Date getBirthday() {
    return birthday;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getEmail() {
    return email;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setEmail(String email) {
    this.email = email == null ? null : email.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getProvinces() {
    return provinces;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setProvinces(String provinces) {
    this.provinces = provinces == null ? null : provinces.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getCities() {
    return cities;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setCities(String cities) {
    this.cities = cities == null ? null : cities.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getCounties() {
    return counties;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setCounties(String counties) {
    this.counties = counties == null ? null : counties.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getOpenid() {
    return openid;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setOpenid(String openid) {
    this.openid = openid == null ? null : openid.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getOffCardId() {
    return offCardId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setOffCardId(String offCardId) {
    this.offCardId = offCardId == null ? null : offCardId.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getIstiedcard() {
    return istiedcard;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setIstiedcard(String istiedcard) {
    this.istiedcard = istiedcard == null ? null : istiedcard.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getHeadimgUrl() {
    return headimgUrl;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setHeadimgUrl(String headimgUrl) {
    this.headimgUrl = headimgUrl == null ? null : headimgUrl.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public Long getWxStoreId() {
    return wxStoreId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setWxStoreId(Long wxStoreId) {
    this.wxStoreId = wxStoreId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public Long getWxGuideId() {
    return wxGuideId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setWxGuideId(Long wxGuideId) {
    this.wxGuideId = wxGuideId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public Long getWxStoreCurId() {
    return wxStoreCurId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setWxStoreCurId(Long wxStoreCurId) {
    this.wxStoreCurId = wxStoreCurId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public Long getWxGuideCurId() {
    return wxGuideCurId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setWxGuideCurId(Long wxGuideCurId) {
    this.wxGuideCurId = wxGuideCurId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getIsfocus() {
    return isfocus;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setIsfocus(String isfocus) {
    this.isfocus = isfocus == null ? null : isfocus.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getUnionid() {
    return unionid;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setUnionid(String unionid) {
    this.unionid = unionid == null ? null : unionid.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public Date getLastAccessTime() {
    return lastAccessTime;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setLastAccessTime(Date lastAccessTime) {
    this.lastAccessTime = lastAccessTime;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public Date getFocusTime() {
    return focusTime;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setFocusTime(Date focusTime) {
    this.focusTime = focusTime;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public Date getUpdateTime() {
    return updateTime;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public Date getCancelTime() {
    return cancelTime;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setCancelTime(Date cancelTime) {
    this.cancelTime = cancelTime;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public Long getWxPublicId() {
    return wxPublicId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setWxPublicId(Long wxPublicId) {
    this.wxPublicId = wxPublicId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getCustcode() {
    return custcode;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setCustcode(String custcode) {
    this.custcode = custcode == null ? null : custcode.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getNeedErpupdate() {
    return needErpupdate;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setNeedErpupdate(String needErpupdate) {
    this.needErpupdate = needErpupdate == null ? null : needErpupdate.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public Date getLastDate() {
    return lastDate;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setLastDate(Date lastDate) {
    this.lastDate = lastDate;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public BigDecimal getAmount() {
    return amount;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getProfessional() {
    return professional;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setProfessional(String professional) {
    this.professional = professional == null ? null : professional.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getBusiness() {
    return business;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setBusiness(String business) {
    this.business = business == null ? null : business.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getHobby() {
    return hobby;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setHobby(String hobby) {
    this.hobby = hobby == null ? null : hobby.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getErpid() {
    return erpid;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setErpid(String erpid) {
    this.erpid = erpid == null ? null : erpid.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public BigDecimal getAmountYear() {
    return amountYear;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setAmountYear(BigDecimal amountYear) {
    this.amountYear = amountYear;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getErpopencardstatus() {
    return erpopencardstatus;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setErpopencardstatus(String erpopencardstatus) {
    this.erpopencardstatus = erpopencardstatus == null ? null : erpopencardstatus.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getErpvipstate() {
    return erpvipstate;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setErpvipstate(String erpvipstate) {
    this.erpvipstate = erpvipstate == null ? null : erpvipstate.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getIsoldvip() {
    return isoldvip;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setIsoldvip(String isoldvip) {
    this.isoldvip = isoldvip == null ? null : isoldvip.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getIsUnsubscribe() {
    return isUnsubscribe;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setIsUnsubscribe(String isUnsubscribe) {
    this.isUnsubscribe = isUnsubscribe == null ? null : isUnsubscribe.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getCardid() {
    return cardid;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setCardid(String cardid) {
    this.cardid = cardid == null ? null : cardid.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getIsbing() {
    return isbing;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setIsbing(String isbing) {
    this.isbing = isbing == null ? null : isbing.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getWxCardid() {
    return wxCardid;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setWxCardid(String wxCardid) {
    this.wxCardid = wxCardid == null ? null : wxCardid.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getWxCode() {
    return wxCode;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setWxCode(String wxCode) {
    this.wxCode = wxCode == null ? null : wxCode.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getVipSource() {
    return vipSource;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setVipSource(String vipSource) {
    this.vipSource = vipSource == null ? null : vipSource.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public Date getOnlineOpentime() {
    return onlineOpentime;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setOnlineOpentime(Date onlineOpentime) {
    this.onlineOpentime = onlineOpentime;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public Long getGiveMoney() {
    return giveMoney;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setGiveMoney(Long giveMoney) {
    this.giveMoney = giveMoney;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getAlipayUserId() {
    return alipayUserId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setAlipayUserId(String alipayUserId) {
    this.alipayUserId = alipayUserId == null ? null : alipayUserId.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public Long getWxConsumeareaId() {
    return wxConsumeareaId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setWxConsumeareaId(Long wxConsumeareaId) {
    this.wxConsumeareaId = wxConsumeareaId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public Date getUnbindTime() {
    return unbindTime;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setUnbindTime(Date unbindTime) {
    this.unbindTime = unbindTime;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getIssendcoupon() {
    return issendcoupon;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setIssendcoupon(String issendcoupon) {
    this.issendcoupon = issendcoupon == null ? null : issendcoupon.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getIssendintegral() {
    return issendintegral;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setIssendintegral(String issendintegral) {
    this.issendintegral = issendintegral == null ? null : issendintegral.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public Date getSendintegralTime() {
    return sendintegralTime;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setSendintegralTime(Date sendintegralTime) {
    this.sendintegralTime = sendintegralTime;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public Date getSendcouponTime() {
    return sendcouponTime;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setSendcouponTime(Date sendcouponTime) {
    this.sendcouponTime = sendcouponTime;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public Long getWxDealersId() {
    return wxDealersId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setWxDealersId(Long wxDealersId) {
    this.wxDealersId = wxDealersId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getIscrmsendcoupon() {
    return iscrmsendcoupon;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setIscrmsendcoupon(String iscrmsendcoupon) {
    this.iscrmsendcoupon = iscrmsendcoupon == null ? null : iscrmsendcoupon.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getShareOpenId() {
    return shareOpenId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setShareOpenId(String shareOpenId) {
    this.shareOpenId = shareOpenId == null ? null : shareOpenId.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public Long getWxCrossBrandId() {
    return wxCrossBrandId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setWxCrossBrandId(Long wxCrossBrandId) {
    this.wxCrossBrandId = wxCrossBrandId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public Long getWxCrossBrandItemId() {
    return wxCrossBrandItemId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setWxCrossBrandItemId(Long wxCrossBrandItemId) {
    this.wxCrossBrandItemId = wxCrossBrandItemId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public Long getCrossId() {
    return crossId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setCrossId(Long crossId) {
    this.crossId = crossId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getIsCross() {
    return isCross;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setIsCross(String isCross) {
    this.isCross = isCross == null ? null : isCross.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getAreaCode() {
    return areaCode;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setAreaCode(String areaCode) {
    this.areaCode = areaCode == null ? null : areaCode.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getWxHeadimg() {
    return wxHeadimg;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setWxHeadimg(String wxHeadimg) {
    this.wxHeadimg = wxHeadimg == null ? null : wxHeadimg.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getMixMobile() {
    return mixMobile;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setMixMobile(String mixMobile) {
    this.mixMobile = mixMobile == null ? null : mixMobile.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getTaobaoNick() {
    return taobaoNick;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setTaobaoNick(String taobaoNick) {
    this.taobaoNick = taobaoNick == null ? null : taobaoNick.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getOuterStr() {
    return outerStr;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setOuterStr(String outerStr) {
    this.outerStr = outerStr == null ? null : outerStr.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getWxOuterStr() {
    return wxOuterStr;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setWxOuterStr(String wxOuterStr) {
    this.wxOuterStr = wxOuterStr == null ? null : wxOuterStr.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public Date getAlipayOpencardTime() {
    return alipayOpencardTime;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setAlipayOpencardTime(Date alipayOpencardTime) {
    this.alipayOpencardTime = alipayOpencardTime;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public Date getWxecardOpencardTime() {
    return wxecardOpencardTime;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setWxecardOpencardTime(Date wxecardOpencardTime) {
    this.wxecardOpencardTime = wxecardOpencardTime;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public Date getTmallOpencardTime() {
    return tmallOpencardTime;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setTmallOpencardTime(Date tmallOpencardTime) {
    this.tmallOpencardTime = tmallOpencardTime;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getBizCardNo() {
    return bizCardNo;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setBizCardNo(String bizCardNo) {
    this.bizCardNo = bizCardNo == null ? null : bizCardNo.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getNick() {
    return nick;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setNick(String nick) {
    this.nick = nick == null ? null : nick.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getIsSendbirthdayCoupon() {
    return isSendbirthdayCoupon;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setIsSendbirthdayCoupon(String isSendbirthdayCoupon) {
    this.isSendbirthdayCoupon = isSendbirthdayCoupon == null ? null : isSendbirthdayCoupon.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public Date getHbaseAutoTime() {
    return hbaseAutoTime;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setHbaseAutoTime(Date hbaseAutoTime) {
    this.hbaseAutoTime = hbaseAutoTime;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public Integer getClearPoint() {
    return clearPoint;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setClearPoint(Integer clearPoint) {
    this.clearPoint = clearPoint;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getVipHeight() {
    return vipHeight;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setVipHeight(String vipHeight) {
    this.vipHeight = vipHeight == null ? null : vipHeight.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getVipWeight() {
    return vipWeight;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setVipWeight(String vipWeight) {
    this.vipWeight = vipWeight == null ? null : vipWeight.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getShoesSize() {
    return shoesSize;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setShoesSize(String shoesSize) {
    this.shoesSize = shoesSize == null ? null : shoesSize.trim();
  }
}