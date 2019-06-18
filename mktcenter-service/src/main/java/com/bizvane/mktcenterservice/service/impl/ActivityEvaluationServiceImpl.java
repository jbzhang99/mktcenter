package com.bizvane.mktcenterservice.service.impl;

import com.alibaba.fastjson.JSON;
import com.bizvane.centerstageservice.models.po.SysCheckPo;
import com.bizvane.centerstageservice.models.po.SysStorePo;
import com.bizvane.centerstageservice.models.vo.SysCheckConfigVo;
import com.bizvane.centerstageservice.rpc.StoreServiceRpc;
import com.bizvane.centerstageservice.rpc.SysCheckConfigServiceRpc;
import com.bizvane.centerstageservice.rpc.SysCheckServiceRpc;
import com.bizvane.couponfacade.interfaces.CouponQueryServiceFeign;
import com.bizvane.couponfacade.models.vo.CouponFindCouponCountResponseVO;
import com.bizvane.members.facade.enums.*;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.service.card.request.IntegralChangeRequestModel;
import com.bizvane.mktcenterfacade.interfaces.ActivityEvaluationService;
import com.bizvane.mktcenterfacade.models.bo.ActivityAnalysisCountBO;
import com.bizvane.mktcenterfacade.models.bo.ActivityBO;
import com.bizvane.mktcenterfacade.models.bo.ActivityEvaluationBO;
import com.bizvane.mktcenterfacade.models.bo.AwardBO;
import com.bizvane.mktcenterfacade.models.bo.CtivityAnalysisBO;
import com.bizvane.mktcenterfacade.models.po.MktActivityCountPO;
import com.bizvane.mktcenterfacade.models.po.MktActivityEvaluationPO;
import com.bizvane.mktcenterfacade.models.po.MktActivityPOWithBLOBs;
import com.bizvane.mktcenterfacade.models.po.MktActivityRecordPO;
import com.bizvane.mktcenterfacade.models.vo.ActivityVO;
import com.bizvane.mktcenterfacade.models.vo.PageForm;
import com.bizvane.mktcenterservice.common.award.Award;
import com.bizvane.mktcenterservice.common.enums.ActivityStatusEnum;
import com.bizvane.mktcenterservice.common.enums.ActivityTypeEnum;
import com.bizvane.mktcenterservice.common.enums.CheckStatusEnum;
import com.bizvane.mktcenterservice.common.enums.MktSmartTypeEnum;
import com.bizvane.mktcenterservice.common.utils.CodeUtil;
import com.bizvane.mktcenterservice.common.utils.ExecuteParamCheckUtil;
import com.bizvane.mktcenterservice.mappers.MktActivityCountPOMapper;
import com.bizvane.mktcenterservice.mappers.MktActivityEvaluationPOMapper;
import com.bizvane.mktcenterservice.mappers.MktActivityPOMapper;
import com.bizvane.mktcenterservice.mappers.MktActivityRecordPOMapper;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by pc on 2018/9/6.
 */
@Service
@Slf4j
public class ActivityEvaluationServiceImpl implements ActivityEvaluationService {
    @Autowired
    private MktActivityEvaluationPOMapper mktActivityEvaluationPOMapper;

    @Autowired
    private MktActivityPOMapper mktActivityPOMapper;

    @Autowired
    private MktActivityRecordPOMapper mktActivityRecordPOMapper;

    @Autowired
    private CouponQueryServiceFeign couponQueryServiceFeign;

    @Autowired
    private Award award;
    @Autowired
    private StoreServiceRpc storeServiceRpc;
    
    @Autowired
    private MktActivityCountPOMapper mktActivityCountPOMapper;
    
    @Override
    public ResponseData<ActivityVO> getActivityEvaluationList(ActivityVO vo, PageForm pageForm,SysAccountPO stageUser) {
        log.info("查询评价奖励活动开始");
        ResponseData responseData = new ResponseData();
        PageHelper.startPage(pageForm.getPageNumber(), pageForm.getPageSize());
        vo.setSysBrandId(stageUser.getBrandId());
        List<ActivityVO> activityEvaluation = mktActivityEvaluationPOMapper.getActivityVOList(vo);
        PageInfo<ActivityVO> pageInfo = new PageInfo<>(activityEvaluation);
        responseData.setData(pageInfo);
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }

    @Override
    @Transactional
    public ResponseData<Integer> addActivityEvaluation(ActivityBO bo, SysAccountPO stageUser) {
        //本地测试时使用
        log.info("创建评价奖励活动开始");
        //返回对象
        ResponseData responseData = new ResponseData();
        //得到大实体类
        ActivityVO activityVO = bo.getActivityVO();
        //工具类生成活动编码
        String activityCode = CodeUtil.getActivityCode();
        activityVO.setActivityCode(activityCode);
        //增加活动类型是评价奖励活动
        activityVO.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_EVALUATION.getCode());
        //增加品牌id
        log.info("获取的品牌id是=" + stageUser.getBrandId());
        if (null == stageUser.getBrandId()) {
            log.error("token没有获取到品牌id");
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage("Token没有获取到品牌id!");
            return responseData;
        }
        activityVO.setSysBrandId(stageUser.getBrandId());
        activityVO.setSysCompanyId(stageUser.getSysCompanyId());
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = new MktActivityPOWithBLOBs();
        BeanUtils.copyProperties(activityVO, mktActivityPOWithBLOBs);
        //查询看是否已存在评价奖励活动
        ActivityVO vo = new ActivityVO();
        vo.setSysBrandId(stageUser.getBrandId());
        vo.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_EVALUATION.getCode());
        vo.setStop("true");
        //根据品牌id和活动类型判断该品牌下是否存在该类型的活动，一个品牌下面只能有一个评价奖励的活动
        List<ActivityVO> activityEvaluationList = mktActivityEvaluationPOMapper.getActivityVOList(vo);
        //判断集合是否有值
        if (!CollectionUtils.isEmpty(activityEvaluationList)) {
            for (ActivityVO activity:activityEvaluationList) {
                //判断适用商品
                if (false==activity.getIsStoreLimit() ||!ExecuteParamCheckUtil.addActivitCheck(bo,activity)){
                    responseData.setCode(SysResponseEnum.FAILED.getCode());
                    responseData.setMessage("已存在评价奖励活动!");
                    return responseData;
                }
            }
        }

        //查询结果如果不需要审核审核状态为已审核
        mktActivityPOWithBLOBs.setCheckStatus(CheckStatusEnum.CHECK_STATUS_APPROVED.getCode());
        //活动状态设置为执行中
        mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
        //发送模板消息和短信消息TODO

        //新增活动主表
        mktActivityPOWithBLOBs.setCreateDate(new Date());
        mktActivityPOWithBLOBs.setCreateUserId(stageUser.getSysAccountId());
        mktActivityPOWithBLOBs.setCreateUserName(stageUser.getName());
        mktActivityPOWithBLOBs.setActivityName("评价奖励活动");
        mktActivityPOWithBLOBs.setActivityInfo(activityVO.getActivityInfo());
        log.info("新增主表数据=" + JSON.toJSONString(mktActivityPOWithBLOBs));
        mktActivityPOMapper.insertSelective(mktActivityPOWithBLOBs);
        //获取新增后数据id
        Long mktActivityId = mktActivityPOWithBLOBs.getMktActivityId();
        
        // 新增活动统计表
        MktActivityCountPO mktActivityCountPO = new MktActivityCountPO();
        mktActivityCountPO.setMktActivityId(mktActivityId);
        mktActivityCountPO.setSysCompanyId(mktActivityPOWithBLOBs.getSysCompanyId());
        mktActivityCountPO.setSysBrandId(mktActivityPOWithBLOBs.getSysBrandId());
        mktActivityCountPO.setCreateDate(new Date());
        mktActivityCountPO.setCreateUserId(stageUser.getSysAccountId());
        mktActivityCountPO.setCreateUserName(stageUser.getName());
        mktActivityCountPOMapper.insertSelective(mktActivityCountPO);

        //新增评价奖励活动表
        MktActivityEvaluationPO mktActivityEvaluationPO = new MktActivityEvaluationPO();
        BeanUtils.copyProperties(mktActivityPOWithBLOBs, mktActivityEvaluationPO);
        mktActivityEvaluationPO.setMktActivityId(mktActivityId);
        mktActivityEvaluationPO.setIsStoreLimit(activityVO.getStoreLimit());
        if (true==activityVO.getStoreLimit()){
            mktActivityEvaluationPO.setStoreLimitList(activityVO.getStoreLimitList());
            mktActivityEvaluationPO.setStoreLimitType(activityVO.getStoreLimitType());
        }
        //评价奖励活动和签到活动是没有名字，但是审核活动时需要显示活动的名字，这里给一个固定的。
        mktActivityPOWithBLOBs.setActivityName("评价奖励活动");
        log.info("评价奖励活动表数据=" + JSON.toJSONString(mktActivityEvaluationPO));
        mktActivityEvaluationPOMapper.insertSelective(mktActivityEvaluationPO);
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }

    @Override
    public ResponseData<ActivityBO> selectActivityEvaluationById(String businessCode) {
        log.info("查询评价奖励活动详情");
        ResponseData responseData = new ResponseData();
        ActivityBO bo = new ActivityBO();
        ActivityVO vo = new ActivityVO();
        vo.setActivityCode(businessCode);
        List<ActivityVO> evaluationList = mktActivityEvaluationPOMapper.getActivityVOList(vo);
        if (CollectionUtils.isEmpty(evaluationList)) {
            responseData.setCode(SysResponseEnum.OPERATE_FAILED_DATA_NOT_EXISTS.getCode());
            responseData.setMessage(SysResponseEnum.OPERATE_FAILED_DATA_NOT_EXISTS.getMessage());
            return responseData;
        }
        if(!CollectionUtils.isEmpty(evaluationList)){
            bo.setActivityVO(evaluationList.get(0));
            if (!StringUtils.isEmpty(evaluationList.get(0).getStoreLimitList())){
                String ids =evaluationList.get(0).getStoreLimitList();
                //查询适用门店
                List<Long> listIds = Arrays.asList(ids.split(",")).stream().map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
                ResponseData<List<SysStorePo>> sysStorePOs = storeServiceRpc.getIdStoreLists(listIds);

                if(!CollectionUtils.isEmpty(sysStorePOs.getData())){
                    bo.getActivityVO().setSysStorePos(sysStorePOs.getData());
                }
            }
        }

        bo.setActivityVO(evaluationList.get(0));
        responseData.setData(bo);
        return responseData;
    }

    @Override
    public ResponseData<Integer> executeActivityEvaluation(ActivityEvaluationBO activityEvaluationBO) {
        log.info("执行评价送积分活动=++++++++++++++______________-----------------------333333");
        
        String memberCode = activityEvaluationBO.getMemberCode();
        Long brandId = activityEvaluationBO.getBrandId();
        //查询品牌下所有执行中的活动
        ActivityVO activity = new ActivityVO();
        activity.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
        activity.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_EVALUATION.getCode());
        activity.setSysBrandId(brandId);
        List<ActivityVO> evaluationList = mktActivityEvaluationPOMapper.getActivityVOList(activity);
        if (CollectionUtils.isEmpty(evaluationList)) {
        
          return new ResponseData<Integer>(SysResponseEnum.OPERATE_FAILED_DATA_NOT_EXISTS.getCode(), SysResponseEnum.OPERATE_FAILED_DATA_NOT_EXISTS.getMessage());
        }
        for (ActivityVO activityVO : evaluationList) {
            //增加积分奖励新增接口
            log.info("执行评价送积分777777777777777777");
            AwardBO bo = new AwardBO();
            IntegralChangeRequestModel integralChangeRequestModel = new IntegralChangeRequestModel();
            integralChangeRequestModel.setSysCompanyId(activityVO.getSysCompanyId());
            integralChangeRequestModel.setBrandId(activityVO.getSysBrandId());
            integralChangeRequestModel.setMemberCode(memberCode);
            integralChangeRequestModel.setChangeBills(activityVO.getActivityCode());
            integralChangeRequestModel.setChangeIntegral(activityVO.getPoints());
            integralChangeRequestModel.setChangeType(IntegralChangeTypeEnum.INCOME.getCode());
            integralChangeRequestModel.setBusinessType(com.bizvane.members.facade.enums.BusinessTypeEnum.TASK_TYPE_EVALUATE_AWARD.getCode());
            integralChangeRequestModel.setChangeDate(new Date());
            bo.setIntegralRecordModel(integralChangeRequestModel);
            bo.setMktType(MktSmartTypeEnum.SMART_TYPE_INTEGRAL.getCode());
            log.info("新增积分奖励");
            award.execute(bo);
            //新增积分到会员参与活动记录表中数据
            MktActivityRecordPO po = new MktActivityRecordPO();
            po.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_EVALUATION.getCode());
            po.setMemberCode(memberCode);
            po.setParticipateDate(new Date());
            po.setPoints(activityVO.getPoints());
            po.setAcitivityId(activityVO.getMktActivityId());
            po.setSysBrandId(activityVO.getSysBrandId());
            log.info("新增积分记录表");
            mktActivityRecordPOMapper.insertSelective(po);
            
            mktActivityCountPOMapper.updateSum(activityVO.getMktActivityId(), 1, BigDecimal.ZERO, activityVO.getPoints());
        }
        return new ResponseData<>();
    }

    @Override
    public ResponseData<CtivityAnalysisBO> getActivityAnalysisCountpage(ActivityAnalysisCountBO bo, PageForm pageForm) {
        //如果是评价奖励活动,则只有积分记录
        ResponseData responseData = new ResponseData();
        CtivityAnalysisBO ctivityAnalysisBO = new CtivityAnalysisBO();
        PageHelper.startPage(pageForm.getPageNumber(), pageForm.getPageSize());

        if (bo.getActivityType() == 9) {
            //分页查询出主表信息
            List<ActivityAnalysisCountBO> activityAnalysisList = mktActivityPOMapper.getActivityAnalysisCountpage(bo);
            for (ActivityAnalysisCountBO activityAnalysisCountBO : activityAnalysisList) {
                System.out.println(activityAnalysisCountBO.getMktActivityId() + activityAnalysisCountBO.getActivityName() + activityAnalysisCountBO.getParticipateNumber() + activityAnalysisCountBO.getPointsSum());
            }
            ctivityAnalysisBO.setActivityAnalysisCountBO(activityAnalysisList);
            responseData.setData(ctivityAnalysisBO);
            //如果是入会纪念日活动，那么除了有积分奖励之外，还有券奖励
        } else {
            List<ActivityAnalysisCountBO> activityAnalysisList = mktActivityPOMapper.getActivityAnalysisCountpage(bo);
            for (ActivityAnalysisCountBO activityAnalysisCountBO : activityAnalysisList) {
                System.out.println(activityAnalysisCountBO.getMktActivityId() + activityAnalysisCountBO.getActivityName() + activityAnalysisCountBO.getParticipateNumber() + activityAnalysisCountBO.getPointsSum());
            }
            //合计积分总数 和参与人数总数
            CtivityAnalysisBO ctivityAnalysis = mktActivityPOMapper.getActivityAnalysisTotal(bo);
            //参与人数
            ctivityAnalysisBO.setParticipateTotal(ctivityAnalysis.getParticipateTotal());
            //积分总数
            ctivityAnalysisBO.setPointsSumTotal(ctivityAnalysis.getPointsSumTotal());

            //查询券合计
            ResponseData<CouponFindCouponCountResponseVO> couponFindCouponCountVO = couponQueryServiceFeign.getCountBySendType("90", bo.getSysBrandId());
            System.out.println("couponFindCouponCountVO=====" + couponFindCouponCountVO);
            System.out.println("=========" + couponFindCouponCountVO.getData().getMoney() + "==========" + couponFindCouponCountVO.getData().getCouponSum());
            System.out.println("couponFindCouponCountVO=====" + couponFindCouponCountVO.toString());

            //System.out.println("couponFindCouponCountVO========="+couponFindCouponCountVO.getData().getMoney());
            CouponFindCouponCountResponseVO couponFindCoupon = couponFindCouponCountVO.getData();
            //合计优惠券总数量
            ctivityAnalysisBO.setCouponSumTotal(couponFindCoupon.getCouponSum());
            //合计优惠券核销数量
            ctivityAnalysisBO.setCouponUsedSumTotal(couponFindCoupon.getCouponUsedSum());
            //合计券收益
            ctivityAnalysisBO.setMoneyTotal(couponFindCoupon.getMoney());
            PageInfo<ActivityAnalysisCountBO> pageInfo = new PageInfo<>(activityAnalysisList);
            ctivityAnalysisBO.setActivityAnalysisCountBO(pageInfo.getList());
            ctivityAnalysisBO.setTotal(pageInfo.getTotal());

            responseData.setData(ctivityAnalysisBO);
        }

        return responseData;
    }


}
