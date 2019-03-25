package com.bizvane.messagefacade.models.po;

import java.io.Serializable;
import java.util.Date;

public class WxStorePO implements Serializable {

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
   * 只读. 门店编号. CODE
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String code;
  /**
   * 只读. 门店名称. NAME
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String name;
  /**
   * 只读. 门店图片. PICTURE_URL
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String pictureUrl;
  /**
   * 只读. 门店坐标. LBS
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String lbs;
  /**
   * 只读. 联系电话. PHONE
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String phone;
  /**
   * 只读. 关联省份表. AD_PROVINCE_ID
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Long adProvinceId;
  /**
   * 只读. 关联城市表. AD_CITY_ID
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Long adCityId;
  /**
   * 只读. 关联区域表. AD_AREA_ID
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Long adAreaId;
  /**
   * 只读. 详细地址. ADDRESS
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String address;
  /**
   * 只读. 关联公众号. WX_PUBLIC_ID
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Long wxPublicId;
  /**
   * 只读. . IDCODE
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String idcode;
  /**
   * 只读. 门店二维码. QRCODE_URL
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String qrcodeUrl;
  /**
   * 只读. 门店LOGO. LOGO
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String logo;
  /**
   * 只读. 会员类型. WX_VIPTYPE_ID
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Long wxViptypeId;
  /**
   * 只读. 是否直辖店. IS_CROWN
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String isCrown;
  /**
   * 只读. 是否兑换优惠券. ISSENDQUAN
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String issendquan;
  /**
   * 只读. 关联优惠券. WX_COUPON_ID
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Long wxCouponId;
  /**
   * 只读. 所属经销商. WX_DEALERS_ID
   * @mbg.generated  2018-07-07 17:52:51
   */
  private Long wxDealersId;
  /**
   * 只读. 邮政编码. POSTCODE
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String postcode;
  /**
   * 只读. 线下门店id. ERP_STORE_ID
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String erpStoreId;
  /**
   * 只读. 区域. REGION
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String region;
  /**
   * 只读. 是否关店. ISCLOSE
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String isclose;
  /**
   * 只读. 是否默认开卡门店. IS_DEFAULT_STORE
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String isDefaultStore;
  /**
   * 只读. 天猫智慧门店的门店id. STORE_ID
   * @mbg.generated  2018-07-07 17:52:51
   */
  private String storeId;
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
  public String getCode() {
    return code;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setCode(String code) {
    this.code = code == null ? null : code.trim();
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
  public String getPictureUrl() {
    return pictureUrl;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setPictureUrl(String pictureUrl) {
    this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getLbs() {
    return lbs;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setLbs(String lbs) {
    this.lbs = lbs == null ? null : lbs.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getPhone() {
    return phone;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setPhone(String phone) {
    this.phone = phone == null ? null : phone.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public Long getAdProvinceId() {
    return adProvinceId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setAdProvinceId(Long adProvinceId) {
    this.adProvinceId = adProvinceId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public Long getAdCityId() {
    return adCityId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setAdCityId(Long adCityId) {
    this.adCityId = adCityId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public Long getAdAreaId() {
    return adAreaId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setAdAreaId(Long adAreaId) {
    this.adAreaId = adAreaId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getAddress() {
    return address;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setAddress(String address) {
    this.address = address == null ? null : address.trim();
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
  public String getIdcode() {
    return idcode;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setIdcode(String idcode) {
    this.idcode = idcode == null ? null : idcode.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getQrcodeUrl() {
    return qrcodeUrl;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setQrcodeUrl(String qrcodeUrl) {
    this.qrcodeUrl = qrcodeUrl == null ? null : qrcodeUrl.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getLogo() {
    return logo;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setLogo(String logo) {
    this.logo = logo == null ? null : logo.trim();
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
  public String getIsCrown() {
    return isCrown;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setIsCrown(String isCrown) {
    this.isCrown = isCrown == null ? null : isCrown.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getIssendquan() {
    return issendquan;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setIssendquan(String issendquan) {
    this.issendquan = issendquan == null ? null : issendquan.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public Long getWxCouponId() {
    return wxCouponId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setWxCouponId(Long wxCouponId) {
    this.wxCouponId = wxCouponId;
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
  public String getPostcode() {
    return postcode;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setPostcode(String postcode) {
    this.postcode = postcode == null ? null : postcode.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getErpStoreId() {
    return erpStoreId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setErpStoreId(String erpStoreId) {
    this.erpStoreId = erpStoreId == null ? null : erpStoreId.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getRegion() {
    return region;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setRegion(String region) {
    this.region = region == null ? null : region.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getIsclose() {
    return isclose;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setIsclose(String isclose) {
    this.isclose = isclose == null ? null : isclose.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getIsDefaultStore() {
    return isDefaultStore;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setIsDefaultStore(String isDefaultStore) {
    this.isDefaultStore = isDefaultStore == null ? null : isDefaultStore.trim();
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public String getStoreId() {
    return storeId;
  }

  /**
   * 只读. 
   * @mbg.generated  2018-07-07 17:52:51
   */
  public void setStoreId(String storeId) {
    this.storeId = storeId == null ? null : storeId.trim();
  }
}