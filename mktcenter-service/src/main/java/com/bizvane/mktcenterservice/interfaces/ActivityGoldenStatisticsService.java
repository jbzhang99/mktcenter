package com.bizvane.mktcenterservice.interfaces;

import com.bizvane.utils.responseinfo.ResponseData;

/**
 * 砸金蛋活动统计
 *
 * @author liufq
 * */
public interface ActivityGoldenStatisticsService {
    /**
     * 砸金蛋活动统计
     *
     * @param activityId 活动id
     * @param code 枚举值： 1、访问人数 2、参与会员数 3、页面转发次数 4、有效分享人数 5、注册会员数
     * @param memberCode 会员code
     *
     * @return
     * */
    ResponseData goldenStatisticsData(Long activityId, int code,String memberCode);

    /**
     * 砸金蛋活动概括
     *
     * @param activityId
     *
     * @return
     * */
    ResponseData goldenActivityGeneralization(Long activityId);
}
