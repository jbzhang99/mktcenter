package com.bizvane.mktcenterservice.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bizvane.centerstageservice.models.po.SysStorePo;
import com.bizvane.couponfacade.interfaces.CouponDefinitionServiceFeign;
import com.bizvane.couponfacade.interfaces.CouponServiceFeign;
import com.bizvane.couponfacade.models.po.CouponDefinitionPO;
import com.bizvane.couponfacade.models.vo.CouponUseVO;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.service.api.MemberInfoApiService;
import com.bizvane.mktcenterfacade.interfaces.ActivityGoldenEggsService;
import com.bizvane.mktcenterfacade.interfaces.ActivityGoldenStatisticsService;
import com.bizvane.mktcenterfacade.interfaces.TaskService;
import com.bizvane.mktcenterfacade.models.bo.ActivityGoldenStatisticsBo;
import com.bizvane.mktcenterfacade.models.po.*;
import com.bizvane.mktcenterfacade.models.vo.*;
import com.bizvane.mktcenterservice.common.locktools.DistributedLocker;
import com.bizvane.mktcenterservice.common.utils.CodeUtil;
import com.bizvane.mktcenterservice.common.utils.TimeUtils;
import com.bizvane.mktcenterservice.mappers.MktActivityPOMapper;
import com.bizvane.mktcenterservice.mappers.MktActivityPrizePOMapper;
import com.bizvane.mktcenterservice.mappers.MktActivityPrizeRecordPOMapper;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.utils.tokens.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;
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
    @Resource
    private RedisTemplate<String,Integer> redisTemplate;
    @Autowired
    private   MemberInfoApiService memberInfoApiService;
    @Autowired
    private  ActivityGoldenStatisticsService activityGoldenStatisticsService;
    @Autowired
    private DistributedLocker distributedLocker;

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
        activityPO.setActivityType(13);
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
     * @return
     */
    @Override
    public ResponseData<ActivityPriceBO> selectActivityGEById(ProbabilityVO vo) {
        ResponseData<ActivityPriceBO> responseData = new ResponseData<>();
        ActivityPriceBO activityPriceBO = new ActivityPriceBO();
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = this.getMktActivityPOWithBLOBs(vo);
        String storeLimitListStr = mktActivityPOWithBLOBs.getStoreLimitList();
        List<SysStorePo> storeList = new ArrayList<SysStorePo>();
        if (StringUtils.isNotBlank(storeLimitListStr)) {
            List<Long> storeIdList = Arrays.asList(storeLimitListStr.split(",")).stream().map(element -> Long.valueOf(element)).collect(toList());
            //查询店铺列表
            storeList = taskService.getStoreListByIds(storeIdList);
            log.info("---------通过品牌Ids--" + JSON.toJSONString(storeList) + "-----获取店铺列表----------" + JSON.toJSONString(storeList));
            activityPriceBO.setStoreList(storeList);
        }
        List<MktActivityPrizeVO> mktActivityPrizeVOS = mktActivityPrizePOMapper.selectMktActivityPrizeById(mktActivityPOWithBLOBs.getMktActivityId());
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
        vo.setActivityType(13);
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
        vo.setActivityType(13);
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
        vo.setPrizeType(90);
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
    @Override
    public ResponseData<String> doEggFrenzy(ProbabilityVO vo) throws ParseException {
        log.info("砸金蛋 参数:"+JSON.toJSONString(vo));
        RLock lock = distributedLocker.lock(vo.getMktActivityId()+"EG", TimeUnit.SECONDS, 30L);
        ResponseData<String> responseData = new ResponseData<>();
        String memberCode = vo.getMemberCode();

        this.setgoldenStatistics(vo.getMktActivityId(),1, vo.getMemberCode());

        MemberInfoModel member = new MemberInfoModel();
        member.setMemberCode(memberCode);
        MemberInfoModel memberInfoModel = memberInfoApiService.getSingleMemberModel(member).getData();
        MktActivityPOWithBLOBs po = this.getMktActivityPOWithBLOBs(vo);

        if (this.judgeMemberTotalPoint(po, memberInfoModel)){
            responseData.setData("101");
            responseData.setMessage("您的积分不足！");
            distributedLocker.unlock(lock);
            return responseData;
        }
        String key = memberCode + po.getMktActivityId();
        Integer triesLimit = po.getTriesLimit();
        if (this.judgeTriesLimit(key, triesLimit)){
            responseData.setData("103");
            responseData.setMessage("今日次数用完了,快去邀请好友增加机会!");
            distributedLocker.unlock(lock);
            return responseData;
        }
        if (activityCommonServiceImpl.operationPoint(po, memberCode)){
            responseData.setData("102");
            responseData.setMessage("扣减积分失败");
            distributedLocker.unlock(lock);
            return responseData;
        }
        ResponseData<String> prizeProbabilityResult = this.getPrizeProbability(po.getMktActivityId(), po.getActivityCode(), po.getActivityName(), memberInfoModel);
        distributedLocker.unlock(lock);
        return prizeProbabilityResult;
    }
    //判断  会员的积分
    public boolean judgeMemberTotalPoint(MktActivityPOWithBLOBs po,MemberInfoModel memberInfoModel) {
            if (po.getPrizePoints()>memberInfoModel.getCountIntegral()){
                return true;
            }
        return false;
    }

    //判断 每人每天可参与次数
    public Boolean judgeTriesLimit(String key, Integer triesLimit) throws ParseException {
        Date date = new Date();
        String format = TimeUtils.sdf.format(date);
        key=key+format;
        Boolean ifHas = redisTemplate.hasKey(key);
        if (ifHas){
            Integer value = redisTemplate.opsForValue().get(key);
             if(value<1){
                 return Boolean.TRUE;
             }
            redisTemplate.opsForValue().set(key,value-1, TimeUtils.getMSeconds(date,format), TimeUnit.MILLISECONDS);
        }else{
            redisTemplate.opsForValue().set(key,triesLimit-1,TimeUtils.getMSeconds(date,format), TimeUnit.MILLISECONDS);
        }
        return Boolean.FALSE;
    }

    //获取主表详情
    @Override
    public MktActivityPOWithBLOBs getMktActivityPOWithBLOBs(ProbabilityVO vo) {
        MktActivityPOExample example0 = new MktActivityPOExample();
        MktActivityPOExample.Criteria criteria = example0.createCriteria();
        MktActivityPOExample.Criteria criteria1 = criteria.andValidEqualTo(Boolean.TRUE);
        if (StringUtils.isNotBlank(vo.getActivityCode())){
            criteria1.andActivityCodeEqualTo(vo.getActivityCode());
        }else{
            criteria1.andMktActivityIdEqualTo(vo.getMktActivityId());
        }
        MktActivityPOWithBLOBs poWithBLOBs = mktActivityPOMapper.selectByExampleWithBLOBs(example0).get(0);

        //this.setgoldenStatistics(poWithBLOBs.getMktActivityId(),0, vo.getMemberCode());
        return poWithBLOBs;
    }

    //获取奖项列表
    public List<MktActivityPrizePO> getEGPrizeLists(Long mktActivityId) {
        MktActivityPrizePOExample example = new MktActivityPrizePOExample();
        example.createCriteria().andMktActivityIdEqualTo(mktActivityId).andValidEqualTo(Boolean.TRUE);
        example.setOrderByClause(" probability ASC");
        List<MktActivityPrizePO> mktActivityPrizePOS = mktActivityPrizePOMapper.selectByExample(example);
        return mktActivityPrizePOS;
    }

    //计算概率
    public ResponseData<String> getPrizeProbability(Long mktActivityId, String activityCode, String activityName, MemberInfoModel memberInfoModel) {
        String memberCode = memberInfoModel.getMemberCode();
        List<MktActivityPrizePO> egPrizeLists = this.getEGPrizeLists(mktActivityId);
        MktActivityPrizePO mktActivityPrizePOThanks = egPrizeLists.get(0);
        List<Integer> collectTarget = egPrizeLists.stream().filter(obj -> obj.getProbability() != null).map(obj -> obj.getProbability().multiply(new BigDecimal(1000000)).intValue()).collect(toList());
        Integer[] arrayTarget = collectTarget.toArray(new Integer[0]);
        Integer arrayDesc[] = new Integer[arrayTarget.length + 1];
        arrayDesc[0] = 0;
        System.arraycopy(arrayTarget, 0, arrayDesc, 1, arrayTarget.length);
        Integer radomNumber = Integer.valueOf(ThreadLocalRandom.current().nextInt(1000000 * 100));
        int index = 0;
        for (int i = 1; i < arrayDesc.length; i++) {
            arrayDesc[i] = arrayDesc[i] + arrayDesc[i - 1];
            log.info(radomNumber+"-----------------"+arrayDesc[i]+"--"+arrayDesc[i] +"--"+arrayDesc[i - 1]);
            if (radomNumber < arrayDesc[i]) {
                index = i;
                break;
            }
        }
        MktActivityPrizePO mktActivityPrizePO = egPrizeLists.get(index);
        log.info("---------------------奖---------------"+JSON.toJSONString(mktActivityPrizePO));
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
            return activityCommonServiceImpl.operationPoint(mktActivityPrizePO, activityCode, memberInfoModel);
        }
        //非谢谢参与奖
        //参与次数
        Integer participateNum = mktActivityPrizeRecordPOMapper.getParticipateNum(mktActivityId, null, memberCode);
        //前几次不中
        if (invalidCount != null && participateNum < invalidCount) {
            return activityCommonServiceImpl.operationPoint(mktActivityPrizePOThanks, activityCode, memberInfoModel);
        }
        //超过 中此类型奖品次数的限制
        Integer oneTypePrizeNum = mktActivityPrizeRecordPOMapper.getParticipateNum(mktActivityId, prizeType,memberCode);
        if (userLimitSum != null && oneTypePrizeNum >= userLimitSum) {
            return activityCommonServiceImpl.operationPoint(mktActivityPrizePOThanks, activityCode, memberInfoModel);
        }
        //奖品数量的判断
        Integer getprizeNum = mktActivityPrizeRecordPOMapper.getParticipateNum(mktActivityId, prizeType, null);
        if (getprizeNum >= prizeTotalSum) {
            return activityCommonServiceImpl.operationPoint(mktActivityPrizePOThanks, activityCode, memberInfoModel);
        }
        //中奖
        if (10 == awadType) {
            return activityCommonServiceImpl.operationPoint(mktActivityPrizePO, activityCode, memberInfoModel);
        }
        //发券
        return activityCommonServiceImpl.operationCoupon(mktActivityPrizePO,activityName, memberInfoModel);
    }

    /**
     *小程序获取中奖纪录列表  轮播 或 会员中奖记录
     * @param po
     * @return
     */
    @Override
    public ResponseData<List<MktActivityPrizeRecordPO>> getEGPrizeRecordList(MktActivityPrizeRecordPO po) {
        log.info("砸金蛋中奖纪录列表开始参数为："+ JSON.toJSONString(po));
        ResponseData responseData = new ResponseData();
        MktActivityPrizeRecordPOExample example = new MktActivityPrizeRecordPOExample();
        //判断是轮播还是抽奖记录
        if(po.getIsWinPrize()){
            //轮播图
            example.createCriteria().andMktActivityIdEqualTo(po.getMktActivityId()).andIsWinPrizeEqualTo(po.getIsWinPrize());
        }else{
            //抽奖记录
            example.createCriteria().andMemberCodeEqualTo(po.getMemberCode()).andMktActivityIdEqualTo(po.getMktActivityId());
        }
        example.setOrderByClause("prize_time DESC");

        List<MktActivityPrizeRecordPO> lists = mktActivityPrizeRecordPOMapper.selectByExample(example);
        log.info("砸金蛋中奖纪录列表查询结束:"+JSON.toJSONString(lists));
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        responseData.setData(lists);
        return responseData;
    }

    /**
     * 查询  每人每天限制次数
     * @param vo
     * @return
     * @throws ParseException
     */
    @Override
    public ResponseData<Integer>  residueMemberNumber(ProbabilityVO vo) throws ParseException {
        ResponseData<Integer> responseData = new ResponseData<>();
        Date date = new Date();
        String format = TimeUtils.sdf.format(date);
        String key = vo.getMemberCode() + vo.getMktActivityId()+format;
        Boolean ifHas = redisTemplate.hasKey(key);
        Integer value=vo.getTriesLimit();
        if (ifHas){
            value = redisTemplate.opsForValue().get(key);
            log.info("取出 redis 次数:"+value);
        }else{
            redisTemplate.opsForValue().set(key,vo.getTriesLimit(),TimeUtils.getMSeconds(date,format), TimeUnit.MILLISECONDS);
        }
        log.info("取出 redis 次数 最终:"+value);
        responseData.setData(value);
        return responseData;
    }
    //添加 每人每天限制次数
    @Override
    public ResponseData<Integer> addMemberNumber(ProbabilityVO vo) throws ParseException {
        ResponseData<Integer> responseData = new ResponseData<>();
        Date date = new Date();
        String format = TimeUtils.sdf.format(date);
        String key = vo.getMemberCode() + vo.getMktActivityId()+format;
        Boolean ifHas = redisTemplate.hasKey(key);
        Integer value=vo.getTriesLimit();
        if (ifHas){
            value = redisTemplate.opsForValue().get(key);
            log.info("存入 redis 次数:"+value);
        }
        redisTemplate.opsForValue().set(key,value+1,TimeUtils.getMSeconds(date,format), TimeUnit.MILLISECONDS);
        log.info("存入 redis 次数 最终:"+value+1);
        this.setgoldenStatistics(vo.getMktActivityId(),2, vo.getMemberCode());

        responseData.setData(value);
        return responseData;
    }
     //添加统计页面数据
    public  void  setgoldenStatistics(Long activityId,int code, String memberCode){
        ActivityGoldenStatisticsBo bo=new ActivityGoldenStatisticsBo();
        bo.setActivityId(activityId);
        bo.setCode(code);
        bo.setMemberCode(memberCode);
        ResponseData responseData = activityGoldenStatisticsService.goldenStatisticsData(bo);
        log.info("添加统计页面数据:"+JSON.toJSONString(bo)+"--"+JSON.toJSONString(responseData));
    }
    @Override
    public ResponseData<MktActivityPOWithBLOBs>  getActivityId(ProbabilityVO vo){
        ResponseData<MktActivityPOWithBLOBs> responseData = new ResponseData<>();
        MktActivityPOExample example=new MktActivityPOExample();
        example.createCriteria().andActivityCodeEqualTo(vo.getActivityCode());
        List<MktActivityPOWithBLOBs> mktActivityPOWithBLOBs = mktActivityPOMapper.selectByExampleWithBLOBs(example);
        MktActivityPOWithBLOBs poWithBLOBs = mktActivityPOWithBLOBs.get(0);
        responseData.setData(poWithBLOBs);
        return responseData;
    }
}
