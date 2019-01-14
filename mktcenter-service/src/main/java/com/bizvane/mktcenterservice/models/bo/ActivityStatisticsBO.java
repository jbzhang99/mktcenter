package com.bizvane.mktcenterservice.models.bo;


import com.bizvane.mktcenterservice.models.po.MktActivityStatisticsPO;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author yy
 * @create 2019-01-14 17:31
 */
@Data
public class ActivityStatisticsBO  extends MktActivityStatisticsPO implements Serializable{

    private static final long serialVersionUID = -5085691516635531991L;


    /**累计访问人数**/
    private Integer totalVisitorsCount;

    /**累计发起会员人数**/
    private Integer totalLaunchMembersCount;

    /**累计助力会员数**/
    private Integer totalHelpMembersCount;

    /**累计注册会员数**/
    private Integer totalRegisterMembersCount;

    /**累计领劵数**/
    private Long totalTakeCouponCount;


    /**访问人数比例**/
    private BigDecimal scaleVisitorsCount;

    /**发起会员人数比例**/
    private BigDecimal scaleLaunchMembersCount;

    /**助力会员数比例**/
    private BigDecimal scaleHelpMembersCount;

    /**注册会员数比例**/
    private BigDecimal scaleRegisterMembersCount;

    /**领劵数比例**/
    private BigDecimal scaleTakeCouponCount;


    /**累计访问人数比例**/
    private BigDecimal scaleTotalVisitorsCount;

    /**累计发起会员人数比例**/
    private BigDecimal scaleTotalLaunchMembersCount;

    /**累计助力会员数比例**/
    private BigDecimal scaleTotalHelpMembersCount;

    /**累计注册会员数比例**/
    private BigDecimal scaleTotalRegisterMembersCount;

    /**累计领劵数比例**/
    private BigDecimal scaleTotalTakeCouponCount;

}
