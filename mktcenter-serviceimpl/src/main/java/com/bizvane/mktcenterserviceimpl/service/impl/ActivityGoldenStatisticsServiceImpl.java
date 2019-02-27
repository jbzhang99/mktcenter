package com.bizvane.mktcenterserviceimpl.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.mktcenterservice.interfaces.ActivityGoldenStatisticsService;
import com.bizvane.mktcenterservice.models.bo.ActivityGoldenStatisticsBo;
import com.bizvane.mktcenterservice.models.po.MktActivityPOExample;
import com.bizvane.mktcenterservice.models.po.MktActivityPOWithBLOBs;
import com.bizvane.mktcenterservice.models.po.MktGoldenStatisticsPO;
import com.bizvane.mktcenterservice.models.vo.MktGoldenStatisticsVO;
import com.bizvane.mktcenterserviceimpl.common.constants.StatisticsConstants;
import com.bizvane.mktcenterserviceimpl.common.enums.ActivityStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.ActivityTypeEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.GoldenStatisticsEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.StatisticsEnum;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktGoldenStatisticsPOMapper;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.redisutils.RedisTemplateServiceImpl;
import com.bizvane.utils.responseinfo.ResponseData;
import com.xxl.job.core.biz.model.ReturnT;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            //查询活动id
            MktActivityPOWithBLOBs mktActivityPOWithBLOBs = mktActivityPOMapper.selectByPrimaryKey(bo.getActivityId());
            //redis过期时间
            Long redisOutTime = StatisticsConstants.getTimeIntervalMilliseconds(mktActivityPOWithBLOBs.getStartTime(), mktActivityPOWithBLOBs.getEndTime());
            //redisKey定义规则:GOLDEN+活动id+code
            String redisKey = "GOLDEN" + bo.getActivityId() + sdf.format(new Date()) + bo.getCode();
            if (GoldenStatisticsEnum.VISITORS_COUNT.getCode() == bo.getCode()) {
                SimpleDateFormat sdfH = new SimpleDateFormat("yyyyMMddHH");
                redisKey = redisKey + sdfH.format(new Date());
                //访问人数统计
                Integer visitorsCount = (Integer) redisTemplateService.stringGetStringByKey(redisKey);
                log.info("当前访问值：" + visitorsCount);
                if (visitorsCount == null) {
                    visitorsCount = 1;
                } else {
                    visitorsCount = visitorsCount + 1;
                }
                log.info("砸金蛋活动统计redisKey:" + redisKey);
                redisTemplateService.stringSetValueAndExpireTime(redisKey, visitorsCount, redisOutTime);
            } else if (GoldenStatisticsEnum.PARTICIPATE_MEMBER_COUNT.getCode() == bo.getCode()) {
                if (StringUtils.isBlank(bo.getMemberCode())) {
                    responseData.setMessage("会员code不能为空!");
                    return responseData;
                }
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
                    log.info("砸金蛋活动统计redisKey:" + redisKey);
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
                log.info("砸金蛋活动统计redisKey:" + redisKey);
                redisTemplateService.stringSetValueAndExpireTime(redisKey, pageForwardCount, redisOutTime);
            } else if (GoldenStatisticsEnum.EFFECTIVE_SHARING_COUNT.getCode() == bo.getCode()) {
                //有效分享人数统计
                Integer effectiveSharingCount = (Integer) redisTemplateService.stringGetStringByKey(redisKey);
                if (effectiveSharingCount == null) {
                    effectiveSharingCount = 1;
                } else {
                    effectiveSharingCount = effectiveSharingCount + 1;
                }
                log.info("砸金蛋活动统计redisKey:" + redisKey);
                redisTemplateService.stringSetValueAndExpireTime(redisKey, effectiveSharingCount, redisOutTime);
            } else if (GoldenStatisticsEnum.REGISTER_MEMBERS_COUNT.getCode() == bo.getCode()) {
                //注册会员数统计
                Integer registerMembersCount = (Integer) redisTemplateService.stringGetStringByKey(redisKey);
                if (registerMembersCount == null) {
                    registerMembersCount = 1;
                } else {
                    registerMembersCount = registerMembersCount + 1;
                }
                log.info("砸金蛋活动统计redisKey:" + redisKey);
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
            po = new MktGoldenStatisticsPO();
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

        String startDates = bo.getStartDate() + " 00:00:00";
        String endDates = bo.getEndDate() + " 59:59:59";

        //开始时间等于结束时间查询单日数据查询分时
        MktGoldenStatisticsPO po = null;
        if (bo.getStartDate().equals(bo.getEndDate())) {
            po = mktGoldenStatisticsPOMapper.getTotalGoldenStatisticsDate(bo.getActivityId(), startDates, endDates);
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
            List<MktGoldenStatisticsVO> mktGoldenStatisticsVoList = mktGoldenStatisticsPOMapper.getTotalGoldenStatisticsDates(bo.getActivityId(), startDates, endDates);
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

    @Override
    public ResponseData goldenExecute() {
        ResponseData responseData = new ResponseData();
        responseData.setCode(SysResponseEnum.FAILED.getCode());
        log.info("砸金蛋活动统计定时任务开始。。。");
        //获取活动id列表
        //MktActivityPOExample example = new MktActivityPOExample();
        //example.createCriteria().andActivityTypeGreaterThanOrEqualTo(ActivityTypeEnum.ACTIVITY_TYPE_REDBAGS.getCode()).andActivityStatusEqualTo(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode()).andValidEqualTo(true);
        //List<MktActivityPOWithBLOBs> activityIds = mktActivityPOMapper.selectByExampleWithBLOBs(example);
        //if (CollectionUtils.isEmpty(activityIds)) {
        //    log.info("没有正在进行中的活动!");
        //    return responseData;
        //}

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        //for (MktActivityPOWithBLOBs activity : activityIds) {
        MktGoldenStatisticsPO po = new MktGoldenStatisticsPO();

        //根据活动id查询所有时间段的统计数据
        //Long activityId = activity.getMktActivityId();
        Long activityId = 1L;
        //得到从活动开始到先在的统计数量
        MktGoldenStatisticsPO totalPo = mktGoldenStatisticsPOMapper.getTotalGoldenStatistics(activityId);
        po.setSysCompanyId(3841L);
        po.setSysBrandId(96L);
        po.setMktActivityId(1L);

        int totalVisitorsCount = 0;
        int totalParticipateMemberCount = 0;
        int totalPageForwardCount = 0;
        int totalEffectiveSharingCount = 0;
        int totalRegisterMembersCount = 0;
        if (totalPo != null) {
            if (totalPo.getTotalVisitorsCount() != null) {
                totalVisitorsCount = totalPo.getTotalVisitorsCount();
            }
            if (totalPo.getTotalParticipateMemberCount() != null) {
                totalParticipateMemberCount = totalPo.getTotalParticipateMemberCount();
            }
            if (totalPo.getTotalPageForwardCount() != null) {
                totalPageForwardCount = totalPo.getTotalPageForwardCount();
            }
            if (totalPo.getTotalEffectiveSharingCount() != null) {
                totalEffectiveSharingCount = totalPo.getTotalEffectiveSharingCount();
            }
            if (totalPo.getTotalRegisterMembersCount() != null) {
                totalRegisterMembersCount = totalPo.getTotalRegisterMembersCount();
            }
        }
        //redisKey定义规则:GOLDEN+活动id+code
        String redisKey = "GOLDEN" + activityId + sdf.format(new Date());
        Integer visitorsCount = 0;
        //统计访问人数和获取访问人数每个时间点
        JSONObject visitorsJson = new JSONObject(new LinkedHashMap<>());
        for (int i = 7; i < 22; i++) {
            String timeStr = "";
            int time = i + 1;
            if (i < 10) {
                timeStr = "0" + time;
            } else {
                timeStr = String.valueOf(time);
            }
            //访问人数统计
            Integer visitorsCountH = (Integer) redisTemplateService.stringGetStringByKey(redisKey + 0 + sdf.format(new Date()) + i);
            log.info("redisKey:" + redisKey + 0 + sdf.format(new Date()) + i + ",value" + visitorsCountH);
            if (visitorsCountH != null) {
                visitorsJson.put(timeStr + ":00", visitorsCountH);
                visitorsCount = visitorsCountH + visitorsCount;
            } else {
                visitorsJson.put(timeStr + ":00", 0);
            }
        }
        po.setHourJsonData(visitorsJson.toJSONString());
        po.setVisitorsCount(visitorsCount);
        po.setTotalVisitorsCount(totalVisitorsCount + visitorsCount);

        //统计参与会员数
        Integer participateMemberCount = (Integer) redisTemplateService.stringGetStringByKey(redisKey + 1);
        if (participateMemberCount == null) {
            participateMemberCount = 0;
        }
        po.setParticipateMemberCount(participateMemberCount);
        po.setTotalParticipateMemberCount(participateMemberCount + totalParticipateMemberCount);

        //统计页面转发次数
        Integer pageForwardCount = (Integer) redisTemplateService.stringGetStringByKey(redisKey + 2);
        if (pageForwardCount == null) {
            pageForwardCount = 0;
        }
        po.setPageForwardCount(pageForwardCount);
        po.setTotalPageForwardCount(pageForwardCount + totalPageForwardCount);

        //有效分享人数
        Integer effectiveSharingCount = (Integer) redisTemplateService.stringGetStringByKey(redisKey + 3);
        if (effectiveSharingCount == null) {
            effectiveSharingCount = 0;
        }
        po.setEffectiveSharingCount(effectiveSharingCount);
        po.setTotalEffectiveSharingCount(effectiveSharingCount + totalEffectiveSharingCount);

        //注册会员数
        //有效分享人数
        Integer registerMembersCount = (Integer) redisTemplateService.stringGetStringByKey(redisKey + 4);
        if (registerMembersCount == null) {
            registerMembersCount = 0;
        }
        po.setRegisterMembersCount(registerMembersCount);
        po.setTotalRegisterMembersCount(registerMembersCount + totalRegisterMembersCount);

        po.setStatisticsTime(new Date());
        po.setStatisticsType("1");
        mktGoldenStatisticsPOMapper.insertSelective(po);
        // }

        log.info("砸金蛋活动统计定时任务结束。。。");
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }

    /**
     * 当日期数据为空时返回数据
     */
    private String getDataJson() {
        JSONObject dataJson = new JSONObject(new LinkedHashMap<>());
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
