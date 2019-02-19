package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.mktcenterservice.interfaces.ActivityGoldenStatisticsService;
import com.bizvane.mktcenterservice.models.po.MktActivityPOWithBLOBs;
import com.bizvane.mktcenterserviceimpl.common.constants.StatisticsConstants;
import com.bizvane.mktcenterserviceimpl.common.enums.GoldenStatisticsEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.StatisticsEnum;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPOMapper;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.redisutils.RedisTemplateServiceImpl;
import com.bizvane.utils.responseinfo.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liufq
 */
@Service
@Slf4j
public class ActivityGoldenStatisticsServiceImpl implements ActivityGoldenStatisticsService {
    @Autowired
    private RedisTemplateServiceImpl redisTemplateService;

    @Autowired
    private MktActivityPOMapper mktActivityPOMapper;

    @Override
    public ResponseData goldenStatisticsData(Long activityId, int code, String memberCode) {
        log.info("砸金蛋活动统计入参：activityId:" + activityId + ",code:" + code + ",memberCode:" + memberCode);
        ResponseData responseData = new ResponseData();
        responseData.setCode(SysResponseEnum.FAILED.getCode());
        try {
            if (activityId == null) {
                responseData.setMessage("activityId不能为空!");
                return responseData;
            }
            if (StringUtils.isBlank(code + "")) {
                responseData.setMessage("code不能为空");
                return responseData;
            }
            if (StringUtils.isBlank(memberCode)) {
                responseData.setMessage("会员code不能为空!");
                return responseData;
            }

            //查询活动id
            MktActivityPOWithBLOBs mktActivityPOWithBLOBs = mktActivityPOMapper.selectByPrimaryKey(activityId);
            //redis过期时间
            Long redisOutTime = StatisticsConstants.getTimeIntervalMilliseconds(mktActivityPOWithBLOBs.getStartTime(), mktActivityPOWithBLOBs.getEndTime());
            //redisKey定义规则:GOLDEN+活动id+code
            String redisKey = "GOLDEN" + activityId + code;
            if (GoldenStatisticsEnum.VISITORS_COUNT.getCode() == code) {
                SimpleDateFormat sdfH = new SimpleDateFormat("yyyyMMddHH");
                redisKey = redisKey + sdfH.format(new Date());
                //访问人数统计
                Integer visitorsCount = (Integer) redisTemplateService.stringGetStringByKey(redisKey);
                if (visitorsCount == null) {
                    visitorsCount = 1;
                } else {
                    visitorsCount = visitorsCount + 1;
                }
                redisTemplateService.stringSetValueAndExpireTime(redisKey, visitorsCount, redisOutTime);

            } else if (GoldenStatisticsEnum.PARTICIPATE_MEMBER_COUNT.getCode() == code) {
                //参与会员数统计
                redisKey = redisKey + memberCode;
                Integer visitorsCount = (Integer) redisTemplateService.stringGetStringByKey(redisKey);
                if (visitorsCount == null) {
                    redisTemplateService.stringSetValueAndExpireTime(redisKey, 1, redisOutTime);
                }
            } else if (GoldenStatisticsEnum.PAGE_FORWARD_COUNT.getCode() == code) {
                //页面转发次数统计
                Integer visitorsCount = (Integer) redisTemplateService.stringGetStringByKey(redisKey);
                if (visitorsCount == null) {
                    visitorsCount = 1;
                } else {
                    visitorsCount = visitorsCount + 1;
                }
                redisTemplateService.stringSetValueAndExpireTime(redisKey, visitorsCount, redisOutTime);
            } else if (GoldenStatisticsEnum.EFFECTIVE_SHARING_COUNT.getCode() == code) {
                //有效分享人数统计
                Integer visitorsCount = (Integer) redisTemplateService.stringGetStringByKey(redisKey);
                if (visitorsCount == null) {
                    visitorsCount = 1;
                } else {
                    visitorsCount = visitorsCount + 1;
                }
                redisTemplateService.stringSetValueAndExpireTime(redisKey, visitorsCount, redisOutTime);
            } else if (GoldenStatisticsEnum.REGISTER_MEMBERS_COUNT.getCode() == code) {
                //注册会员数统计
                redisKey = redisKey + memberCode;
                Integer visitorsCount = (Integer) redisTemplateService.stringGetStringByKey(redisKey);
                if (visitorsCount == null) {
                    visitorsCount = 1;
                } else {
                    visitorsCount = visitorsCount + 1;
                }
                redisTemplateService.stringSetValueAndExpireTime(redisKey, visitorsCount, redisOutTime);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(e.getMessage());
        }
        log.info("统计类型:{}", StatisticsEnum.getStatisticsEnumByCode(code).getMessage());
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());

        log.info("==========统计结束！！！");
        return responseData;
    }

    @Override
    public ResponseData goldenActivityGeneralization(Long activityId) {
        ResponseData responseData = new ResponseData();
        responseData.setCode(SysResponseEnum.FAILED.getCode());
        if (activityId == null) {
            responseData.setMessage("活动id不能为空!");
            return responseData;
        }

        return null;
    }


}
