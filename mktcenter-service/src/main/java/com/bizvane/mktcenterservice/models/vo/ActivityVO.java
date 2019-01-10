package com.bizvane.mktcenterservice.models.vo;

import com.bizvane.centerstageservice.models.po.SysDimSkuPo;
import com.bizvane.centerstageservice.models.po.SysStorePo;
import com.bizvane.couponfacade.models.po.CouponDefinitionPO;
import com.bizvane.couponfacade.models.po.CouponEntityPO;
import com.bizvane.couponfacade.models.vo.CouponDetailResponseVO;
import com.bizvane.couponfacade.models.vo.CouponFindCouponCountResponseVO;
import com.bizvane.mktcenterservice.models.po.MktActivityPO;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/6 20:07
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public class ActivityVO extends MktActivityPO {
    private Boolean storeLimit;
    /**
     * 只读. 活动描述、简介. activity_info
     * @mbg.generated  2018-07-13 10:42:22
     */
    @io.swagger.annotations.ApiModelProperty(value = "活动描述、简介", name = "activityInfo", required = false, example = "")
    private String activityInfo;

    /**
     * 只读. 线下开卡状态：0所有，1未开，2已开. offline_card_status
     * @mbg.generated  2018-07-13 10:42:22
     */
    @io.swagger.annotations.ApiModelProperty(value = "线下开卡状态：0所有，1未开，2已开", name = "offlineCardStatus", required = false, example = "")
    private Integer offlineCardStatus;

    /**
     * 只读. 开卡时等级编号. mbr_level_code
     * @mbg.generated  2018-07-13 10:42:22
     */
    @io.swagger.annotations.ApiModelProperty(value = "活动针对的会员等级编号", name = "mbrLevelCode", required = false, example = "")
    private String mbrLevelCode;
    /**
     * 只读. 开卡时等级名称. mbr_level_name
     * @mbg.generated  2018-07-13 10:42:22
     */
    @io.swagger.annotations.ApiModelProperty(value = "活动针对的会员等级名称", name = "mbrLevelName", required = false, example = "")
    private String mbrLevelName;

    /**
     * 只读. 针对的会员类型：0,所有类型，1微信会员. member_type
     * @mbg.generated  2018-07-13 11:45:27
     */
    @io.swagger.annotations.ApiModelProperty(value = "针对的会员类型：0,所有类型，1微信会员", name = "memberType", required = false, example = "")
    private Integer memberType;

    /**
     * 只读. 提前多少日进行. days_ahead
     * @mbg.generated  2018-07-13 10:42:22
     */
    @io.swagger.annotations.ApiModelProperty(value = "提前多少日进行", name = "daysAhead", required = false, example = "")
    private Integer daysAhead;

    /**
     * 只读. 订单最低金额. order_min_price
     * @mbg.generated  2018-07-13 10:42:22
     */
    @io.swagger.annotations.ApiModelProperty(value = "订单最低金额", name = "orderMinPrice", required = false, example = "")
    private String orderMinPrice;

    /**
     * 只读. 签到方式：1连续签到，2累计签到，3单日签到. sign_type
     * @mbg.generated  2018-07-13 10:42:22
     */
    @io.swagger.annotations.ApiModelProperty(value = "签到方式：1连续签到，2累计签到，3单日签到", name = "signType", required = false, example = "")
    private Integer signType;
    /**
     * 只读. 积分方式. integral_type
     * @mbg.generated  2018-07-13 10:42:22
     */
    @io.swagger.annotations.ApiModelProperty(value = "积分方式", name = "integralType", required = false, example = "")
    private String integralType;
    /**
     * 只读. 赠送积分基数. integral_basis
     * @mbg.generated  2018-07-13 10:42:22
     */
    @io.swagger.annotations.ApiModelProperty(value = "赠送积分基数", name = "integralBasis", required = false, example = "")
    private Long integralBasis;
    /**
     * 只读. 每次增加的数值. integral_addend
     * @mbg.generated  2018-07-13 10:42:22
     */
    @io.swagger.annotations.ApiModelProperty(value = "每次增加的数值", name = "integralAddend", required = false, example = "")
    private Long integralAddend;
    /**
     * 只读. 增加后的最高积分上限. integral_max
     * @mbg.generated  2018-07-13 10:42:22
     */
    @io.swagger.annotations.ApiModelProperty(value = "增加后的最高积分上限", name = "integralMax", required = false, example = "")
    private Long integralMax;
    /**
     * 创建时间开始
     */
   	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @io.swagger.annotations.ApiModelProperty(value = "创建日期", name = "createDateStart", required = false, example = "")
    private Date createDateStart;
    /**
     * 创建时间结束
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @io.swagger.annotations.ApiModelProperty(value = "创建日期", name = "createDateEnd", required = false, example = "")
    private Date createDateEnd;

    @io.swagger.annotations.ApiModelProperty(value = "��ά���ַ", name = "qrcode", required = false, example = "")
    private String qrcode;//二维码
    @io.swagger.annotations.ApiModelProperty(value = "订单来源：1线下订单，2微商城订单", name = "orderSource", required = false, example = "")
    private Integer orderSource;//订单来源

    private Integer perPersonPerDayMax;

    private Integer perPersonMax;

    /**
     * 券定义id
     */
    private Long couponDefinitionId;

    private String couponCode;//券号

    private String couponName;//券名称
    //是否可领取
    private Boolean canReceive;
   //活动明细id
    private Long mktActivityManualId;

    /**
     * 券实例
     */
    private CouponEntityPO couponEntityPO;

    /**
     * 券定义
     */
    private CouponDefinitionPO couponDefinitionPO;

    private CouponFindCouponCountResponseVO couponFindCouponCountResponseVO;
    /**
     * 通过id查询券实例
     */
    private CouponDetailResponseVO couponDetailResponseVO;

    /**核销率
     * */
    private String useCouponRate;
    /**
     * 会员编号
     */
    private String memberCode;

    /**
     * 只读. 商品限制名单. commodity_limit_list
     * @mbg.generated  2018-08-16 16:54:21
     */
    @io.swagger.annotations.ApiModelProperty(value = "商品限制名单", name = "commodityLimitList", required = false, example = "")
    private String commodityLimitList;
    /**
     * 只读. 门店限制名单. store_limit_list
     * @mbg.generated  2018-08-16 16:54:21
     */
    @io.swagger.annotations.ApiModelProperty(value = "门店限制名单", name = "storeLimitList", required = false, example = "")
    private String storeLimitList;

    /**
     * 只读. 商品限制状态：0不限制，1限制. is_commodity_limit
     * @mbg.generated  2018-08-16 16:54:21
     */
    @io.swagger.annotations.ApiModelProperty(value = "商品限制状态：0不限制，1限制", name = "isCommodityLimit", required = false, example = "")
    private Boolean isCommodityLimit;
    /**
     * 只读. 商品限制类型：1黑名单，2白名单. commodity_limit_type
     * @mbg.generated  2018-08-16 16:54:21
     */
    @io.swagger.annotations.ApiModelProperty(value = "商品限制类型：1黑名单，2白名单", name = "commodityLimitType", required = false, example = "")
    private Integer commodityLimitType;
    /**
     * 只读. 门店限制状态：0不限制，1限制. is_store_limit
     * @mbg.generated  2018-08-16 16:54:21
     */
    @io.swagger.annotations.ApiModelProperty(value = "门店限制状态：0不限制，1限制", name = "isStoreLimit", required = false, example = "")
    private Boolean isStoreLimit;
    /**
     * 只读. 门店限制类型：1黑名单，2白名单. store_limit_type
     * @mbg.generated  2018-08-16 16:54:21
     */
    @io.swagger.annotations.ApiModelProperty(value = "门店限制类型：1黑名单，2白名单", name = "storeLimitType", required = false, example = "")
    private Integer storeLimitType;

    @io.swagger.annotations.ApiModelProperty(value = "立即发送：1是，0否", name = "sendImmediately", required = false, example = "")
    private Boolean sendImmediately;

    @io.swagger.annotations.ApiModelProperty(value = "开始发送时间", name = "sendTime", required = false, example = "")
    private Date sendTime;
    //门店实体类
    private List<SysStorePo> sysStorePos;
    //商品实体类
    private List<SysDimSkuPo> sysDimSkuPos;
    @io.swagger.annotations.ApiModelProperty(value = "入会满多少月",name = "registerMonths", required = false,example = "")
    private Integer registerMonths;
    //判断创建时候过滤禁用状态
    private String stop;

    private Long serviceStoreId;//服务门店
    private String activityDetailImg;//活动详情图片

    public String getActivityDetailImg() {
        return activityDetailImg;
    }

    public void setActivityDetailImg(String activityDetailImg) {
        this.activityDetailImg = activityDetailImg;
    }

    public Long getServiceStoreId() {
        return serviceStoreId;
    }

    public void setServiceStoreId(Long serviceStoreId) {
        this.serviceStoreId = serviceStoreId;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public Integer getRegisterMonths() {
        return registerMonths;
    }

    public void setRegisterMonths(Integer registerMonths) {
        this.registerMonths = registerMonths;
    }

    public List<SysDimSkuPo> getSysDimSkuPos() {
        return sysDimSkuPos;
    }

    public void setSysDimSkuPos(List<SysDimSkuPo> sysDimSkuPos) {
        this.sysDimSkuPos = sysDimSkuPos;
    }

    public List<SysStorePo> getSysStorePos() {
        return sysStorePos;
    }

    public void setSysStorePos(List<SysStorePo> sysStorePos) {
        this.sysStorePos = sysStorePos;
    }


    public Boolean getSendImmediately() {
        return sendImmediately;
    }

    public void setSendImmediately(Boolean sendImmediately) {
        this.sendImmediately = sendImmediately;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getCommodityLimitList() {
        return commodityLimitList;
    }

    public CouponDetailResponseVO getCouponDetailResponseVO() {
        return couponDetailResponseVO;
    }

    public void setCouponDetailResponseVO(CouponDetailResponseVO couponDetailResponseVO) {
        this.couponDetailResponseVO = couponDetailResponseVO;
    }

    public void setCommodityLimitList(String commodityLimitList) {
        this.commodityLimitList = commodityLimitList;
    }

    public String getStoreLimitList() {
        return storeLimitList;
    }

    public void setStoreLimitList(String storeLimitList) {
        this.storeLimitList = storeLimitList;
    }

    public Boolean getCommodityLimit() {
        return isCommodityLimit;
    }

    public void setCommodityLimit(Boolean commodityLimit) {
        isCommodityLimit = commodityLimit;
    }

    public Integer getCommodityLimitType() {
        return commodityLimitType;
    }

    public void setCommodityLimitType(Integer commodityLimitType) {
        this.commodityLimitType = commodityLimitType;
    }

//    public Boolean getStoreLimit() {
//        return isStoreLimit;
//    }
//
//    public void setStoreLimit(Boolean storeLimit) {
//        isStoreLimit = storeLimit;
//    }

    public Integer getStoreLimitType() {
        return storeLimitType;
    }

    public void setStoreLimitType(Integer storeLimitType) {
        this.storeLimitType = storeLimitType;
    }

    public Integer getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(Integer orderSource) {
        this.orderSource = orderSource;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public String getActivityInfo() {
        return activityInfo;
    }

    public void setActivityInfo(String activityInfo) {
        this.activityInfo = activityInfo;
    }

    public Integer getOfflineCardStatus() {
        return offlineCardStatus;
    }

    public void setOfflineCardStatus(Integer offlineCardStatus) {
        this.offlineCardStatus = offlineCardStatus;
    }

    public String getMbrLevelCode() {
        return mbrLevelCode;
    }

    public void setMbrLevelCode(String mbrLevelCode) {
        this.mbrLevelCode = mbrLevelCode;
    }

    public String getMbrLevelName() {
        return mbrLevelName;
    }

    public void setMbrLevelName(String mbrLevelName) {
        this.mbrLevelName = mbrLevelName;
    }

    public Integer getMemberType() {
        return memberType;
    }

    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
    }

    public Integer getDaysAhead() {
        return daysAhead;
    }

    public void setDaysAhead(Integer daysAhead) {
        this.daysAhead = daysAhead;
    }

    public String getOrderMinPrice() {
        return orderMinPrice;
    }

    public void setOrderMinPrice(String orderMinPrice) {
        this.orderMinPrice = orderMinPrice;
    }


    public Integer getSignType() {
        return signType;
    }

    public void setSignType(Integer signType) {
        this.signType = signType;
    }

    public String getIntegralType() {
        return integralType;
    }

    public void setIntegralType(String integralType) {
        this.integralType = integralType;
    }

    public Long getIntegralBasis() {
        return integralBasis;
    }

    public void setIntegralBasis(Long integralBasis) {
        this.integralBasis = integralBasis;
    }

    public Long getIntegralAddend() {
        return integralAddend;
    }

    public void setIntegralAddend(Long integralAddend) {
        this.integralAddend = integralAddend;
    }

    public Long getIntegralMax() {
        return integralMax;
    }

    public void setIntegralMax(Long integralMax) {
        this.integralMax = integralMax;
    }

    public Date getCreateDateStart() {
        return createDateStart;
    }

    public Date getCreateDateEnd() {
        return createDateEnd;
    }

    public void setCreateDateStart(Date createDateStart) {
        this.createDateStart = createDateStart;
    }

    public void setCreateDateEnd(Date createDateEnd) {
        this.createDateEnd = createDateEnd;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public Integer getPerPersonPerDayMax() {
        return perPersonPerDayMax;
    }

    public void setPerPersonPerDayMax(Integer perPersonPerDayMax) {
        this.perPersonPerDayMax = perPersonPerDayMax;
    }

    public Integer getPerPersonMax() {
        return perPersonMax;
    }

    public void setPerPersonMax(Integer perPersonMax) {
        this.perPersonMax = perPersonMax;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public Boolean getCanReceive() {
        return canReceive;
    }

    public void setCanReceive(Boolean canReceive) {
        this.canReceive = canReceive;
    }

    public Long getMktActivityManualId() {
        return mktActivityManualId;
    }

    public void setMktActivityManualId(Long mktActivityManualId) {
        this.mktActivityManualId = mktActivityManualId;
    }

    public CouponEntityPO getCouponEntityPO() {
        return couponEntityPO;
    }

    public void setCouponEntityPO(CouponEntityPO couponEntityPO) {
        this.couponEntityPO = couponEntityPO;
    }

    public CouponFindCouponCountResponseVO getCouponFindCouponCountResponseVO() {
        return couponFindCouponCountResponseVO;
    }

    public void setCouponFindCouponCountResponseVO(CouponFindCouponCountResponseVO couponFindCouponCountResponseVO) {
        this.couponFindCouponCountResponseVO = couponFindCouponCountResponseVO;
    }

    public String getUseCouponRate() {
        return useCouponRate;
    }

    public void setUseCouponRate(String useCouponRate) {
        this.useCouponRate = useCouponRate;
    }

    public Long getCouponDefinitionId() {
        return couponDefinitionId;
    }

    public void setCouponDefinitionId(Long couponDefinitionId) {
        this.couponDefinitionId = couponDefinitionId;
    }


    public CouponDefinitionPO getCouponDefinitionPO() {
        return couponDefinitionPO;
    }

    public void setCouponDefinitionPO(CouponDefinitionPO couponDefinitionPO) {
        this.couponDefinitionPO = couponDefinitionPO;
    }

    public Boolean getStoreLimit() {
        return storeLimit;
    }

    public void setStoreLimit(Boolean storeLimit) {
        this.storeLimit = storeLimit;
    }
}
