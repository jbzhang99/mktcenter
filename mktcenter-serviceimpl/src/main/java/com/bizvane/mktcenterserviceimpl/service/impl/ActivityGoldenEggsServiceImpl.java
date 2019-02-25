package com.bizvane.mktcenterserviceimpl.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bizvane.centerstageservice.models.po.SysStorePo;
import com.bizvane.couponfacade.interfaces.CouponDefinitionServiceFeign;
import com.bizvane.couponfacade.interfaces.CouponServiceFeign;
import com.bizvane.couponfacade.models.po.CouponDefinitionPO;
import com.bizvane.couponfacade.models.vo.CouponUseVO;
import com.bizvane.mktcenterservice.interfaces.ActivityGoldenEggsService;
import com.bizvane.mktcenterservice.interfaces.TaskService;
import com.bizvane.mktcenterservice.models.po.*;
import com.bizvane.mktcenterservice.models.vo.*;
import com.bizvane.mktcenterserviceimpl.common.utils.CodeUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.TimeUtils;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPrizePOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPrizeRecordPOMapper;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.utils.tokens.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static java.util.stream.Collectors.toList;

/**
 * @Author: lijunwei
 * @Time: 2019/2/25 10:14
 */
@Service
@Slf4j
public class ActivityGoldenEggsServiceImpl implements ActivityGoldenEggsService {
    @Autowired
    private ActivityCommonServiceImpl activityCommonServiceImpl;
    @Autowired
    private MktActivityPOMapper mktActivityPOMapper;
    @Autowired
    private TaskService taskService;
    @Autowired
    private MktActivityPrizePOMapper mktActivityPrizePOMapper;
    @Autowired
    private CouponDefinitionServiceFeign couponDefinitionServiceFeign;
    @Autowired
    private MktActivityPrizeRecordPOMapper mktActivityPrizeRecordPOMapper;
    @Autowired
    private CouponServiceFeign couponServiceFeign;
    @Autowired
    private RedisTemplate<String,Integer> redisTemplate;

    /**
     * 新增
     *
     * @param bo
     * @param request
     * @return
     * @throws ParseException
     */
    @Override
    public ResponseData<JSONObject> addActivityGE(ActivityPriceBO bo, HttpServletRequest request) throws ParseException {
        ResponseData<JSONObject> responseData = new ResponseData<>();
        MktActivityPOWithBLOBs activityPO = bo.getActivityPO();
        List<MktActivityPrizeVO> activityPrizePOList = bo.getActivityPrizePOList();
        if (activityPO == null || CollectionUtils.isEmpty(activityPrizePOList)) {
            responseData.setCode(100);
            responseData.setMessage("数据不合格!");
        }
        SysAccountPO sysAccountPo = TokenUtils.getStageUser(request);
        Long brandId = sysAccountPo.getBrandId();
        String activePriceCode = CodeUtil.getActiveCode("GE");
        String weixinUrl = activityCommonServiceImpl.getWxurl(brandId, activePriceCode);
        Long mktActivityId = activityCommonServiceImpl.addActivityMianGame(activityPO, sysAccountPo, activePriceCode, weixinUrl);
        activityCommonServiceImpl.addAllPrize(activityPrizePOList, sysAccountPo, mktActivityId);
        activityCommonServiceImpl.addGameCount(sysAccountPo, mktActivityId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("qrCodeUrl", weixinUrl);
        jsonObject.put("activePriceCode", activePriceCode);
        jsonObject.put("activityName", activityPO.getActivityName());
        responseData.setData(jsonObject);
        return responseData;
    }

    /**
     * 查询详情 id
     *
     * @param mktActivityId
     * @return
     */
    @Override
    public ResponseData<ActivityPriceBO> selectActivityGEById(Long mktActivityId, HttpServletRequest request) {
        ResponseData<ActivityPriceBO> responseData = new ResponseData<>();
        ActivityPriceBO activityPriceBO = new ActivityPriceBO();
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = mktActivityPOMapper.selectByPrimaryKey(mktActivityId);
        String storeLimitListStr = mktActivityPOWithBLOBs.getStoreLimitList();
        List<SysStorePo> storeList = new ArrayList<SysStorePo>();
        if (StringUtils.isNotBlank(storeLimitListStr)) {
            List<Long> storeIdList = Arrays.asList(storeLimitListStr.split(",")).stream().map(element -> Long.valueOf(element)).collect(toList());
            //查询店铺列表
            storeList = taskService.getStoreListByIds(storeIdList);
            log.info("---------通过品牌Ids--" + JSON.toJSONString(storeList) + "-----获取店铺列表----------" + JSON.toJSONString(storeList));
            activityPriceBO.setStoreList(storeList);
        }
        List<MktActivityPrizeVO> mktActivityPrizeVOS = mktActivityPrizePOMapper.selectMktActivityPrizeById(mktActivityId);
        mktActivityPrizeVOS.stream().forEach(obj -> {
            Long couponDefinitionId = obj.getCouponDefinitionId();
            if (couponDefinitionId != null) {
                ResponseData<CouponDefinitionPO> coupon = couponDefinitionServiceFeign.findByIdRpc(couponDefinitionId);
                obj.setCouponDefinitionPO(coupon.getData());
            }
        });
        activityPriceBO.setActivityPO(mktActivityPOWithBLOBs);
        activityPriceBO.setActivityPrizePOList(mktActivityPrizeVOS);
        responseData.setData(activityPriceBO);
        return responseData;
    }

    /**
     * 查询详情 code
     */
    @Override
    public ResponseData<ActivityPrizeBO> selectActivityGEByCode(String activePriceCode) {
        ResponseData<ActivityPrizeBO> responseData = new ResponseData<>();
        ActivityPrizeBO activityPriceBO = new ActivityPrizeBO();
        MktActivityPOExample example0 = new MktActivityPOExample();
        example0.createCriteria().andActivityCodeEqualTo(activePriceCode);
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = mktActivityPOMapper.selectByExampleWithBLOBs(example0).get(0);

        MktActivityPrizePOExample example = new MktActivityPrizePOExample();
        example.createCriteria().andMktActivityIdEqualTo(mktActivityPOWithBLOBs.getMktActivityId()).andValidEqualTo(Boolean.TRUE);
        List<MktActivityPrizePO> mktActivityPrizePOS = mktActivityPrizePOMapper.selectByExample(example);
        activityPriceBO.setActivityPO(mktActivityPOWithBLOBs);
        activityPriceBO.setActivityPrizePOList(mktActivityPrizePOS);
        responseData.setData(activityPriceBO);
        return responseData;
    }

    /**
     * 查询列表
     */
    @Override
    public ResponseData<PageInfo<MktActivityPOWithBLOBs>> selectActivityEGLists(ActivityPriceParamVO vo, HttpServletRequest request) {
        ResponseData<PageInfo<MktActivityPOWithBLOBs>> responseData = new ResponseData<>();
        SysAccountPO sysAccountPo = TokenUtils.getStageUser(request);
        vo.setBrandId(sysAccountPo.getBrandId());
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        List<MktActivityPOWithBLOBs> listparam = mktActivityPOMapper.selectActivityPriceLists(vo);
        if (CollectionUtils.isEmpty(listparam)) {
            listparam = new ArrayList<MktActivityPOWithBLOBs>();
        }
        PageInfo<MktActivityPOWithBLOBs> pageInfo = new PageInfo<>(listparam);
        responseData.setData(pageInfo);
        return responseData;
    }

    /**
     * 修改
     */
    @Override
    public ResponseData<JSONObject> updateActivityGE(ActivityPriceBO bo, HttpServletRequest request) throws ParseException {
        ResponseData<JSONObject> responseData = new ResponseData<>();
        MktActivityPOWithBLOBs activityPO = bo.getActivityPO();
        List<MktActivityPrizeVO> activityPrizePOList = bo.getActivityPrizePOList();
        if (activityPO == null || CollectionUtils.isEmpty(activityPrizePOList)) {
            responseData.setCode(100);
            responseData.setMessage("数据不合格!");
        }
        activityCommonServiceImpl.stopJobs(activityPO);
        activityCommonServiceImpl.deleteAllPrize(activityPO.getMktActivityId());

        SysAccountPO sysAccountPo = TokenUtils.getStageUser(request);
        activityCommonServiceImpl.updateActivityMianGame(activityPO, sysAccountPo);
        activityCommonServiceImpl.addAllPrize(activityPrizePOList, sysAccountPo, activityPO.getMktActivityId());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("qrCodeUrl", activityPO.getQrCodeUrl());
        jsonObject.put("activePriceCode", activityPO.getActivityCode());
        jsonObject.put("activityName", activityPO.getActivityName());
        responseData.setData(jsonObject);
        return responseData;
    }

    /**
     * 禁用
     */
    @Override
    public ResponseData<Integer> stopActivityEG(MktActivityPOWithBLOBs po, HttpServletRequest request) {
        return activityCommonServiceImpl.stopActivityGame(po, request);
    }

    /**
     * 记录统计
     */
    @Override
    public ResponseData<PageInfo<AnalysisPriceResultVO>> selectAnalysisEG(ActivityPriceParamVO vo, HttpServletRequest request) {
        ResponseData<PageInfo<AnalysisPriceResultVO>> responseData = new ResponseData<>();
        SysAccountPO sysAccountPo = TokenUtils.getStageUser(request);
        vo.setBrandId(sysAccountPo.getBrandId());
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        List<AnalysisPriceResultVO> lists = mktActivityPrizePOMapper.selectAnalysisPrice(vo);
        if (CollectionUtils.isEmpty(lists)) {
            lists = new ArrayList<>();
        } else {
            lists.parallelStream().forEach(param -> {
                int dataNum = TimeUtils.getDataNum(param.getEndTime());
                param.setResidueDates(dataNum);
                int days = param.getTotalDates() - dataNum;
                param.setGoingDates(days < 0 ? 0 : days);
                param.setPrizePeople(mktActivityPrizeRecordPOMapper.selectPrizePeopleNum(param.getMktActivityId()));
                param.setTotalPeople(mktActivityPrizeRecordPOMapper.selectTotalPeopleNum(param.getMktActivityId()));
            });
        }
        PageInfo<AnalysisPriceResultVO> pageInfo = new PageInfo<>(lists);
        responseData.setData(pageInfo);
        return responseData;
    }

    /**
     * 中奖人数
     */
    @Override
    public ResponseData<PageInfo<MktActivityPrizeRecordPO>> selectPrizePeople(ActivityPriceParamVO vo) {
        log.info("selectPrizePeople  parram:" + JSON.toJSONString(vo));
        ResponseData<PageInfo<MktActivityPrizeRecordPO>> responseData = new ResponseData<>();
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        List<MktActivityPrizeRecordPO> lists = mktActivityPrizeRecordPOMapper.selectPrizePeople(vo);
        if (CollectionUtils.isEmpty(lists)) {
            lists = new ArrayList<MktActivityPrizeRecordPO>();
        }
        PageInfo<MktActivityPrizeRecordPO> pageInfo = new PageInfo<>(lists);
        responseData.setData(pageInfo);
        return responseData;
    }

    /**
     * 核销
     */
    @Override
    public ResponseData<String> doVerificationCoupon(ActivityPriceParamVO vo, HttpServletRequest request) {
        log.info("doVerificationCoupon param:" + JSON.toJSONString(vo));
        ResponseData<String> responseData = null;
        String couponDefinitionCode = vo.getCouponDefinitionCode();
        if (StringUtils.isBlank(couponDefinitionCode) || "0".equals(couponDefinitionCode)) {
            responseData = new ResponseData<>();
            responseData.setCode(100);
            responseData.setMessage("奖品不是券,无法核销!");
            return responseData;
        }
        SysAccountPO sysAccountPo = TokenUtils.getStageUser(request);
        CouponUseVO requestVO = new CouponUseVO();
        requestVO.setCouponCode(couponDefinitionCode);
        requestVO.setStaffCode(sysAccountPo.getAccountCode());
        requestVO.setBrandId(sysAccountPo.getBrandId());
        responseData = couponServiceFeign.use(requestVO);
        log.info("doVerificationCoupon result:" + JSON.toJSONString(responseData));

        if (responseData.getCode() == 0) {
            MktActivityPrizeRecordPO record = new MktActivityPrizeRecordPO();
            record.setMktActivityPrizeRecordId(vo.getMktActivityPrizeRecordId());
            record.setRemark("1");
            mktActivityPrizeRecordPOMapper.updateByPrimaryKeySelective(record);
        }
        return responseData;
    }


    //小程序 操作
    //砸金蛋
    public ResponseData<String> doEggFrenzy(ProbabilityVO vo) throws ParseException {
        ResponseData<String> responseData = new ResponseData<>();
        MktActivityPOWithBLOBs po = this.getMktActivityPrizePO(vo);
        String key = vo.getMemberCode() + po.getMktActivityId();
        Integer triesLimit = po.getTriesLimit();
        Boolean ifHas = redisTemplate.hasKey(key);
        if (ifHas){
            Integer value = redisTemplate.opsForValue().get(key);
            if (value<=0){
                responseData.setData("今日次数用完了,快去邀请好友增加机会!");
                return responseData;
            }
            redisTemplate.opsForValue().set(key,value-1,TimeUtils.getMSeconds(), TimeUnit.MILLISECONDS);
        }else{
            redisTemplate.opsForValue().set(key,triesLimit-1,TimeUtils.getMSeconds(), TimeUnit.MILLISECONDS);
        }
        return this.getPrizeProbability(po.getMktActivityId(),po.getActivityCode(), po.getActivityName(),vo.getMemberCode());
    }

   //获取主表详情
    public MktActivityPOWithBLOBs getMktActivityPrizePO(ProbabilityVO vo) {
        MktActivityPOExample example0 = new MktActivityPOExample();
        MktActivityPOExample.Criteria criteria = example0.createCriteria();
        MktActivityPOExample.Criteria criteria1 = criteria.andValidEqualTo(Boolean.TRUE);
        if (StringUtils.isNotBlank(vo.getActivityCode())){
            criteria1.andActivityCodeEqualTo(vo.getActivityCode());
        }else{
            criteria1.andMktActivityIdEqualTo(vo.getMktActivityId());
        }
        return mktActivityPOMapper.selectByExampleWithBLOBs(example0).get(0);
    }

    //获取奖项列表
    public List<MktActivityPrizePO> getEGPrizeLists(Long mktActivityId, String memberCode) {
        MktActivityPrizePOExample example = new MktActivityPrizePOExample();
        example.createCriteria().andMktActivityIdEqualTo(mktActivityId).andValidEqualTo(Boolean.TRUE);
        example.setOrderByClause(" BY probability desc");
        List<MktActivityPrizePO> mktActivityPrizePOS = mktActivityPrizePOMapper.selectByExample(example);
        return mktActivityPrizePOS;
    }

    //计算概率
    public ResponseData<String> getPrizeProbability(Long mktActivityId, String activityCode, String activityName, String memberCode) {
        ResponseData<String> responseData = new ResponseData<>();
        List<MktActivityPrizePO> egPrizeLists = this.getEGPrizeLists(mktActivityId, memberCode);
        MktActivityPrizePO mktActivityPrizePOThanks = egPrizeLists.get(egPrizeLists.size() - 1);
        List<Integer> collectTarget = egPrizeLists.stream().filter(obj -> obj.getProbability() != null).map(obj -> obj.getProbability().multiply(new BigDecimal(1000000)).intValue()).collect(toList());
        Integer[] arrayTarget = collectTarget.toArray(new Integer[0]);
        Integer arrayDesc[] = new Integer[arrayTarget.length + 1];
        arrayDesc[0] = 0;
        System.arraycopy(arrayTarget, 0, arrayDesc, 1, arrayTarget.length);
        Integer radomNumber = Integer.valueOf(ThreadLocalRandom.current().nextInt(1000000 * 100));
        int index = egPrizeLists.size() - 1;
        for (int i = 1; i < arrayDesc.length; i++) {
            arrayDesc[i] = arrayDesc[i] + arrayDesc[i - 1];
            if (radomNumber < arrayDesc[i]) {
                index = i - 1;
            }
        }
        MktActivityPrizePO mktActivityPrizePO = egPrizeLists.get(index);
        Integer awadType = mktActivityPrizePO.getAwadType();
        Integer prizeType = mktActivityPrizePO.getPrizeType();
        Integer prizePoints = mktActivityPrizePO.getPrizePoints();
        //无效次数
        Integer invalidCount = mktActivityPrizePO.getInvalidCount();
        //奖总数量
        Integer prizeTotalSum = mktActivityPrizePO.getPrizeSum();
        //限中次数
        Integer userLimitSum = mktActivityPrizePO.getUserLimitSum();
        //谢谢参与
        if (90 == prizeType) {
            return activityCommonServiceImpl.operationPoint(mktActivityPrizePO, activityCode, memberCode);
        }
        //非谢谢参与奖
        //参与次数
        Integer participateNum = mktActivityPrizeRecordPOMapper.getParticipateNum(mktActivityId, null, memberCode);
        //前几次不中
        if (invalidCount != null && participateNum < invalidCount) {
            return activityCommonServiceImpl.operationPoint(mktActivityPrizePOThanks, activityCode, memberCode);
        }
        //超过 中此类型奖品次数的限制
        Integer oneTypePrizeNum = mktActivityPrizeRecordPOMapper.getParticipateNum(mktActivityId, prizeType, memberCode);
        if (userLimitSum != null && oneTypePrizeNum >= userLimitSum) {
            return activityCommonServiceImpl.operationPoint(mktActivityPrizePOThanks, activityCode, memberCode);
        }
        //奖品数量的判断
        Integer getprizeNum = mktActivityPrizeRecordPOMapper.getParticipateNum(mktActivityId, prizeType, null);
        if (getprizeNum >= prizeTotalSum) {
            return activityCommonServiceImpl.operationPoint(mktActivityPrizePOThanks, activityCode, memberCode);
        }
        //中奖
        if (10 == awadType) {
            return activityCommonServiceImpl.operationPoint(mktActivityPrizePO, activityCode, memberCode);
        }
        //发券
        return activityCommonServiceImpl.operationCoupon(mktActivityPrizePO, mktActivityId, activityCode, activityName, memberCode);
    }
}
