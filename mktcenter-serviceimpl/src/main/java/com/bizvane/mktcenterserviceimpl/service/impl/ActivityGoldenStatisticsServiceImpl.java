package com.bizvane.mktcenterserviceimpl.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.mktcenterservice.interfaces.ActivityGoldenStatisticsService;
import com.bizvane.mktcenterservice.models.bo.ActivityGoldenStatisticsBo;
import com.bizvane.mktcenterservice.models.po.MktActivityPOWithBLOBs;
import com.bizvane.mktcenterservice.models.po.MktGoldenStatisticsPO;
import com.bizvane.mktcenterservice.models.vo.MktGoldenStatisticsVO;
import com.bizvane.mktcenterserviceimpl.common.constants.StatisticsConstants;
import com.bizvane.mktcenterserviceimpl.common.enums.GoldenStatisticsEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.StatisticsEnum;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktGoldenStatisticsPOMapper;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.redisutils.RedisTemplateServiceImpl;
import com.bizvane.utils.responseinfo.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

    @Autowired
    private MktGoldenStatisticsPOMapper mktGoldenStatisticsPOMapper;

    @Override
    public ResponseData goldenStatisticsData(ActivityGoldenStatisticsBo bo) {
        log.info("砸金蛋活动统计入参：activityId:" + bo.getActivityId() + ",code:" + bo.getCode() + ",memberCode:" + bo.getMemberCode());
        ResponseData responseData = new ResponseData();
        responseData.setCode(SysResponseEnum.FAILED.getCode());
        try {
            if (bo.getActivityId() == null) {
                responseData.setMessage("activityId不能为空!");
                return responseData;
            }
            if (StringUtils.isBlank(bo.getCode() + "")) {
                responseData.setMessage("code不能为空");
                return responseData;
            }
            if (StringUtils.isBlank(bo.getMemberCode())) {
                responseData.setMessage("会员code不能为空!");
                return responseData;
            }

            //查询活动id
            MktActivityPOWithBLOBs mktActivityPOWithBLOBs = mktActivityPOMapper.selectByPrimaryKey(bo.getActivityId());
            //redis过期时间
            Long redisOutTime = StatisticsConstants.getTimeIntervalMilliseconds(mktActivityPOWithBLOBs.getStartTime(), mktActivityPOWithBLOBs.getEndTime());
            //redisKey定义规则:GOLDEN+活动id+code
            String redisKey = "GOLDEN" + bo.getActivityId() + bo.getCode();
            if (GoldenStatisticsEnum.VISITORS_COUNT.getCode() == bo.getCode()) {
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

            } else if (GoldenStatisticsEnum.PARTICIPATE_MEMBER_COUNT.getCode() == bo.getCode()) {
                Integer participateMemberCount = (Integer) redisTemplateService.stringGetStringByKey(redisKey);
                if (participateMemberCount == null) {
                    participateMemberCount = 0;
                }
                //参与会员数统计
                String redisKeys = redisKey + bo.getMemberCode();
                Integer participateMemberCounts = (Integer) redisTemplateService.stringGetStringByKey(redisKeys);
                if (participateMemberCounts == null) {
                    redisTemplateService.stringSetValueAndExpireTime(redisKeys, 1, redisOutTime);
                    participateMemberCount = participateMemberCount + 1;
                    redisTemplateService.stringSetValueAndExpireTime(redisKey, participateMemberCount, redisOutTime);
                }
            } else if (GoldenStatisticsEnum.PAGE_FORWARD_COUNT.getCode() == bo.getCode()) {
                //页面转发次数统计
                Integer pageForwardCount = (Integer) redisTemplateService.stringGetStringByKey(redisKey);
                if (pageForwardCount == null) {
                    pageForwardCount = 1;
                } else {
                    pageForwardCount = pageForwardCount + 1;
                }
                redisTemplateService.stringSetValueAndExpireTime(redisKey, pageForwardCount, redisOutTime);
            } else if (GoldenStatisticsEnum.EFFECTIVE_SHARING_COUNT.getCode() == bo.getCode()) {
                //有效分享人数统计
                Integer effectiveSharingCount = (Integer) redisTemplateService.stringGetStringByKey(redisKey);
                if (effectiveSharingCount == null) {
                    effectiveSharingCount = 1;
                } else {
                    effectiveSharingCount = effectiveSharingCount + 1;
                }
                redisTemplateService.stringSetValueAndExpireTime(redisKey, effectiveSharingCount, redisOutTime);
            } else if (GoldenStatisticsEnum.REGISTER_MEMBERS_COUNT.getCode() == bo.getCode()) {
                //注册会员数统计
                Integer registerMembersCount = (Integer) redisTemplateService.stringGetStringByKey(redisKey);
                if (registerMembersCount == null) {
                    registerMembersCount = 1;
                } else {
                    registerMembersCount = registerMembersCount + 1;
                }
                redisTemplateService.stringSetValueAndExpireTime(redisKey, registerMembersCount, redisOutTime);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(e.getMessage());
        }
        log.info("统计类型:{}", StatisticsEnum.getStatisticsEnumByCode(bo.getCode()).getMessage());
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

        MktGoldenStatisticsPO po = mktGoldenStatisticsPOMapper.getTotalGoldenStatistics(activityId);
        if (po == null) {
            po.setTotalVisitorsCount(0);
            po.setTotalParticipateMemberCount(0);
            po.setTotalPageForwardCount(0);
            po.setTotalEffectiveSharingCount(0);
            po.setTotalRegisterMembersCount(0);
        }

        responseData.setData(po);
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());

        return responseData;
    }

    @Override
    public ResponseData goldenActivityGeneralizationDate(ActivityGoldenStatisticsBo bo) {
        ResponseData responseData = new ResponseData();
        responseData.setCode(SysResponseEnum.FAILED.getCode());
        if (bo.getActivityId() == null) {
            responseData.setMessage("活动id不能为空!");
            return responseData;
        }
        if (StringUtils.isBlank(bo.getStartDate())) {
            responseData.setMessage("开始时间不能为空!");
            return responseData;
        }
        if (StringUtils.isBlank(bo.getEndDate())) {
            responseData.setMessage("结束时间不能为空!");
            return responseData;
        }

        //开始时间等于结束时间查询单日数据查询分时
        MktGoldenStatisticsPO po = null;
        if (bo.getStartDate().equals(bo.getEndDate())) {
            po = mktGoldenStatisticsPOMapper.getTotalGoldenStatisticsDate(bo);
            if (po == null) {
                po = new MktGoldenStatisticsPO();
                po.setVisitorsCount(0);
                po.setParticipateMemberCount(0);
                po.setPageForwardCount(0);
                po.setEffectiveSharingCount(0);
                po.setRegisterMembersCount(0);
                po.setHourJsonData(getDataJson());
            } else {
                if (StringUtils.isBlank(po.getHourJsonData())) {
                    po.setHourJsonData(getDataJson());
                }
            }

        } else {
            po = new MktGoldenStatisticsPO();
            List<MktGoldenStatisticsVO> mktGoldenStatisticsVoList = mktGoldenStatisticsPOMapper.getTotalGoldenStatisticsDates(bo);
            JSONObject dataJson = null;
            int visitorsCount = 0;
            int participateMemberCount = 0;
            int pageForwardCount = 0;
            int effectiveSharingCount = 0;
            int registerMembersCount = 0;
            if (mktGoldenStatisticsVoList.size() > 0) {
                dataJson = new JSONObject();
                for (int i = 0; i < mktGoldenStatisticsVoList.size(); i++) {
                    MktGoldenStatisticsVO mktGoldenStatisticsVO = mktGoldenStatisticsVoList.get(i);
                    visitorsCount = visitorsCount + mktGoldenStatisticsVO.getVisitorsCount();
                    participateMemberCount = participateMemberCount + mktGoldenStatisticsVO.getParticipateMemberCount();
                    pageForwardCount = pageForwardCount + mktGoldenStatisticsVO.getPageForwardCount();
                    effectiveSharingCount = effectiveSharingCount + mktGoldenStatisticsVO.getEffectiveSharingCount();
                    registerMembersCount = registerMembersCount + mktGoldenStatisticsVO.getRegisterMembersCount();

                    dataJson.put(mktGoldenStatisticsVO.getStatisticsTimes(), mktGoldenStatisticsVO.getVisitorsCount());
                }
            }
            po.setVisitorsCount(visitorsCount);
            po.setParticipateMemberCount(participateMemberCount);
            po.setPageForwardCount(pageForwardCount);
            po.setEffectiveSharingCount(effectiveSharingCount);
            po.setRegisterMembersCount(registerMembersCount);

            List<String> dateList = null;
            try {
                dateList = findDates(bo.getStartDate(), bo.getEndDate());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (dateList != null && dateList.size() > 0) {
                JSONObject resultDataJson = new JSONObject();
                for (int i = 0; i < dateList.size(); i++) {
                    Integer visitors = dataJson.getInteger(dateList.get(i));
                    if (visitors != null) {
                        resultDataJson.put(dateList.get(i), visitors);
                    } else {
                        resultDataJson.put(dateList.get(i), 0);
                    }
                }
                po.setHourJsonData(resultDataJson.toJSONString());
            }
        }

        responseData.setData(po);
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());

        return responseData;
    }

    /**
     * 当日期数据为空时返回数据
     */
    private String getDataJson() {
        JSONObject dataJson = new JSONObject();
        dataJson.put("08:00", 0);
        dataJson.put("09:00", 0);
        dataJson.put("10:00", 0);
        dataJson.put("11:00", 0);
        dataJson.put("12:00", 0);
        dataJson.put("13:00", 0);
        dataJson.put("14:00", 0);
        dataJson.put("15:00", 0);
        dataJson.put("16:00", 0);
        dataJson.put("17:00", 0);
        dataJson.put("18:00", 0);
        dataJson.put("19:00", 0);
        dataJson.put("20:00", 0);
        dataJson.put("21:00", 0);
        dataJson.put("22:00", 0);

        return dataJson.toJSONString();
    }

    private List<String> findDates(String startDate, String endDate) throws ParseException {
        //日期工具类准备
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        //设置开始时间
        Calendar calBegin = Calendar.getInstance();
        calBegin.setTime(format.parse(startDate));

        //设置结束时间
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(format.parse(endDate));

        //装返回的日期集合容器
        List<String> dateList = new ArrayList<String>();
        dateList.add(startDate);

        // 每次循环给calBegin日期加一天，直到calBegin.getTime()时间等于dEnd
        while (format.parse(endDate).after(calBegin.getTime())) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            dateList.add(format.format(calBegin.getTime()));
        }

        log.info("开始时间到结束时间时间段:" + dateList);
        return dateList;
    }
}
