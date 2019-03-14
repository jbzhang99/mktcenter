package com.bizvane.couponfacade.es;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018\8\13 0013.
 * 高级搜索 pojo
 */
@Data
@EqualsAndHashCode
@Document(indexName = "t_mbr_members", type = "doc")
public class MembersInfoSearchPojo implements Serializable {

    //polarDB mbr主键id

    private Long mbrMemberId;
    //线下VipId
    private String vipId;
    //线下品牌code
    private String offlineBrandCode;
    //企业id
    private Long sysCompanyId;
    //品牌号
    private Long brandId;
    //会员code
    @Id
    private String memberCode;
    //姓名
    private String name;
    //手机号
    private String phone;
    //身份证
    private String idCard;
    //会员卡号
    private String cardNo;
    //女:0 男:1  2:未知
    private String gender;
    //生日
    @Field(type = FieldType.Date, pattern = "yyyy-MM-dd")
    private Date birthday;
    //冗余生日时间的格式月日,例如：0101
    private String birthdayMD;
    //等级id
    private Long levelId;
    //线下等级code
    private String offlineLevelCode;
    //等级名称
    private String levelName;
    //省
    private String province;
    //市
    private String city;
    //区
    private String county;
    //标签ids
    private String labelNames;
    //总可用积分
    private Integer countIntegral;
    //开卡时间
    @Field(type = FieldType.Date)
    private Date openCardTime;
    //是否关注,1：未关注,2：已关注,3:已取关
    //@Field(type = FieldType.Date)
    private String focus;
    //绑卡状态1：未绑卡,2已绑卡
    private Integer cardStatus;
    //是否微信会员
    private Integer wxMembers;
    //活跃会员1：是,2：否
    private Integer activeMember;
    //沉默会员1:是,2:否
    private Integer silenceMember;
    //濒临睡眠会员1:是,2:否
    private Integer vergeSleepMember;
    //休眠会员
    private Integer dormancyMember;
    //流失会员
    private Integer awayMember;
    //首次购买时间
    @Field(type = FieldType.Date)
    private Date firstBuyTime;
    //最近购买时间
    @Field(type = FieldType.Date)
    private Date lastBuyTime;

    private Long serviceStoreId;
    private Long serviceGuideId;
    private Long openCardGuideId;
    private Long openCardStoreId;

    private String serviceStoreName;
    private String serviceGuideName;
    private String openCardGuideName;
    private String openCardStoreName;

    private String allChannelIds;
    
    //会员分销
    //分销状态
    private Boolean distributionState;
    //分销创建人
    private String distributionCreateName;
    //分销创建时间
    private Date distributionCreateTime;
    //分销修改人
    private String distributionModifiedName;
    //分销修改时间
    private Date distributionModifiedTime;
  /*  //消费金额累计
    private BigDecimal consumeAmountAll;
    private BigDecimal consumeAmount1;
    private BigDecimal consumeAmount2;
    private BigDecimal consumeAmount3;
    private BigDecimal consumeAmount4;
    private BigDecimal consumeAmount5;
    private BigDecimal consumeAmount6;
    private BigDecimal consumeAmount7;
    private BigDecimal consumeAmount8;
    private BigDecimal consumeAmount9;
    private BigDecimal consumeAmount10;
    private BigDecimal consumeAmount11;
    private BigDecimal consumeAmount12;
    private BigDecimal consumeAmount13;
    private BigDecimal consumeAmount14;
    private BigDecimal consumeAmount15;
    private BigDecimal consumeAmount16;
    private BigDecimal consumeAmount17;
    private BigDecimal consumeAmount18;
    private BigDecimal consumeAmount19;
    private BigDecimal consumeAmount20;
    private BigDecimal consumeAmount21;
    private BigDecimal consumeAmount22;
    private BigDecimal consumeAmount23;
    private BigDecimal consumeAmount24;
    //消费次数
    private Integer consumeNumberAll;
    private Integer consumeNumber1;
    private Integer consumeNumber2;
    private Integer consumeNumber3;
    private Integer consumeNumber4;
    private Integer consumeNumber5;
    private Integer consumeNumber6;
    private Integer consumeNumber7;
    private Integer consumeNumber8;
    private Integer consumeNumber9;
    private Integer consumeNumber10;
    private Integer consumeNumber11;
    private Integer consumeNumber12;
    private Integer consumeNumber13;
    private Integer consumeNumber14;
    private Integer consumeNumber15;
    private Integer consumeNumber16;
    private Integer consumeNumber17;
    private Integer consumeNumber18;
    private Integer consumeNumber19;
    private Integer consumeNumber20;
    private Integer consumeNumber21;
    private Integer consumeNumber22;
    private Integer consumeNumber23;
    private Integer consumeNumber24;
    //退款金额
    private BigDecimal refundAmountAll;
    private BigDecimal refundAmount1;
    private BigDecimal refundAmount2;
    private BigDecimal refundAmount3;
    private BigDecimal refundAmount4;
    private BigDecimal refundAmount5;
    private BigDecimal refundAmount6;
    private BigDecimal refundAmount7;
    private BigDecimal refundAmount8;
    private BigDecimal refundAmount9;
    private BigDecimal refundAmount10;
    private BigDecimal refundAmount11;
    private BigDecimal refundAmount12;
    private BigDecimal refundAmount13;
    private BigDecimal refundAmount14;
    private BigDecimal refundAmount15;
    private BigDecimal refundAmount16;
    private BigDecimal refundAmount17;
    private BigDecimal refundAmount18;
    private BigDecimal refundAmount19;
    private BigDecimal refundAmount20;
    private BigDecimal refundAmount21;
    private BigDecimal refundAmount22;
    private BigDecimal refundAmount23;
    private BigDecimal refundAmount24;
    //客单价金额
    private BigDecimal pctAmountAll;
    private BigDecimal pctAmount1;
    private BigDecimal pctAmount2;
    private BigDecimal pctAmount3;
    private BigDecimal pctAmount4;
    private BigDecimal pctAmount5;
    private BigDecimal pctAmount6;
    private BigDecimal pctAmount7;
    private BigDecimal pctAmount8;
    private BigDecimal pctAmount9;
    private BigDecimal pctAmount10;
    private BigDecimal pctAmount11;
    private BigDecimal pctAmount12;
    private BigDecimal pctAmount13;
    private BigDecimal pctAmount14;
    private BigDecimal pctAmount15;
    private BigDecimal pctAmount16;
    private BigDecimal pctAmount17;
    private BigDecimal pctAmount18;
    private BigDecimal pctAmount19;
    private BigDecimal pctAmount20;
    private BigDecimal pctAmount21;
    private BigDecimal pctAmount22;
    private BigDecimal pctAmount23;
    private BigDecimal pctAmount24;
    //折扣率
    private Integer discountRateAll;
    private Integer discountRate1;
    private Integer discountRate2;
    private Integer discountRate3;
    private Integer discountRate4;
    private Integer discountRate5;
    private Integer discountRate6;
    private Integer discountRate7;
    private Integer discountRate8;
    private Integer discountRate9;
    private Integer discountRate10;
    private Integer discountRate11;
    private Integer discountRate12;
    private Integer discountRate13;
    private Integer discountRate14;
    private Integer discountRate15;
    private Integer discountRate16;
    private Integer discountRate17;
    private Integer discountRate18;
    private Integer discountRate19;
    private Integer discountRate20;
    private Integer discountRate21;
    private Integer discountRate22;
    private Integer discountRate23;
    private Integer discountRate24;
    //连带率件数
    private Integer aprNumberAll;
    private Integer aprNumber1;
    private Integer aprNumber2;
    private Integer aprNumber3;
    private Integer aprNumber4;
    private Integer aprNumber5;
    private Integer aprNumber6;
    private Integer aprNumber7;
    private Integer aprNumber8;
    private Integer aprNumber9;
    private Integer aprNumber10;
    private Integer aprNumber11;
    private Integer aprNumber12;
    private Integer aprNumber13;
    private Integer aprNumber14;
    private Integer aprNumber15;
    private Integer aprNumber16;
    private Integer aprNumber17;
    private Integer aprNumber18;
    private Integer aprNumber19;
    private Integer aprNumber20;
    private Integer aprNumber21;
    private Integer aprNumber22;
    private Integer aprNumber23;
    private Integer aprNumber24;*/

    //优惠券
    //券总数
    private int couponTotalNumber;
    //已使用
    private int couponUseNumber;
    //未使用
    private int couponUnusedNumber;
    //已过期
    private int couponPastDueNumber;
    //扩展字段值
    private String extendValue;
    //拓展字段code
    private String extendCode;
    
    //会员分销管理使用一下高级搜索字段
    //创建人id
    private String createUserId;
    //创建人名称
    private String createUserName;
    //创建日期
    private Date createDate;
    //修改人id
    private String modifiedUserId;
    //修改人名称
    private String modifiedUserName;
    //修改日期
    private Date modifiedDate;
}
