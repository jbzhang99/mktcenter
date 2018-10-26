package com.bizvane.mktcenterserviceimpl.service.impl;

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
import com.bizvane.mktcenterservice.interfaces.ActivityEvaluationService;
import com.bizvane.mktcenterservice.models.bo.ActivityAnalysisCountBO;
import com.bizvane.mktcenterservice.models.bo.ActivityBO;
import com.bizvane.mktcenterservice.models.bo.AwardBO;
import com.bizvane.mktcenterservice.models.bo.CtivityAnalysisBO;
import com.bizvane.mktcenterservice.models.po.MktActivityEvaluationPO;
import com.bizvane.mktcenterservice.models.po.MktActivityPOWithBLOBs;
import com.bizvane.mktcenterservice.models.po.MktActivityRecordPO;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterserviceimpl.common.award.Award;
import com.bizvane.mktcenterserviceimpl.common.enums.*;
import com.bizvane.mktcenterserviceimpl.common.utils.CodeUtil;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityEvaluationPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityRecordPOMapper;
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
    private SysCheckConfigServiceRpc sysCheckConfigServiceRpc;

    @Autowired
    private SysCheckServiceRpc sysCheckServiceRpc;

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
    @Override
    public ResponseData<ActivityVO> getActivityEvaluationList(ActivityVO vo, PageForm pageForm) {
        log.info("查询评价奖励活动开始");
        ResponseData responseData = new ResponseData();
        PageHelper.startPage(pageForm.getPageNumber(), pageForm.getPageSize());
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
        //根据品牌id和活动类型判断该品牌下是否存在该类型的活动，一个品牌下面只能有一个评价奖励的活动
        List<ActivityVO> activityEvaluationList = mktActivityEvaluationPOMapper.getActivityVOList(vo);
        //判断集合是否有值
        if (!CollectionUtils.isEmpty(activityEvaluationList)) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage("已存在评价奖励活动!");
            return responseData;
        }
        //根据该企业id查询该企业下是否存在审核配置，是否需要审核然后判断
        SysCheckConfigVo so = new SysCheckConfigVo();
        so.setSysBrandId(activityVO.getSysBrandId());
        ResponseData<List<SysCheckConfigVo>> sysCheckConfigVo = sysCheckConfigServiceRpc.getCheckConfigListAll(so);
        List<SysCheckConfigVo> sysCheckConfigVoList = sysCheckConfigVo.getData();

        //判断是否有审核配置
        int i = 0;
        if (!CollectionUtils.isEmpty(sysCheckConfigVoList)) {
            for (SysCheckConfigVo sysCheckConfig : sysCheckConfigVoList) {
                //判断是否需要审核  暂时先写这三个审核类型 后期确定下来写成枚举类
                if (sysCheckConfig.getFunctionCode().equals("C0001") || sysCheckConfig.getFunctionCode().equals("C0002") || sysCheckConfig.getFunctionCode().equals("C0003")) {
                    i += 1;
                }
            }
        }

        if (i > 0) {
            //查询结果如果需要审核审核状态为待审核
            mktActivityPOWithBLOBs.setCheckStatus(CheckStatusEnum.CHECK_STATUS_PENDING.getCode());
            //活动状态设置为待执行
            mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_PENDING.getCode());
            //如果是待审核数据则需要增加一条审核数据

        } else {
            //查询结果如果不需要审核审核状态为已审核
            mktActivityPOWithBLOBs.setCheckStatus(CheckStatusEnum.CHECK_STATUS_APPROVED.getCode());
            //活动状态设置为执行中
            mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
            //发送模板消息和短信消息TODO
        }
        //新增活动主表
        mktActivityPOWithBLOBs.setCreateDate(new Date());
        mktActivityPOWithBLOBs.setCreateUserId(stageUser.getSysAccountId());
        mktActivityPOWithBLOBs.setCreateUserName(stageUser.getName());
        log.info("新增主表数据=" + JSON.toJSONString(mktActivityPOWithBLOBs));
        mktActivityPOMapper.insertSelective(mktActivityPOWithBLOBs);
        //获取新增后数据id
        Long mktActivityId = mktActivityPOWithBLOBs.getMktActivityId();
        //调用rpc返回的结果
        ResponseData<Long> rpcResponse = new ResponseData<>();
        if (i > 0) {

            //如果是待审核数据则需要增加一条审核数据
            log.info("增加审核中心一条数据");
            SysCheckPo po = new SysCheckPo();
            po.setSysBrandId(mktActivityPOWithBLOBs.getSysBrandId());
            po.setBusinessCode(mktActivityPOWithBLOBs.getActivityCode());
            po.setBusinessName(mktActivityPOWithBLOBs.getActivityName());
            po.setBusinessId(mktActivityId);
            po.setBusinessType(ActivityTypeEnum.ACTIVITY_TYPE_EVALUATION.getCode());
            po.setFunctionCode("C0002");
            po.setCheckStatus(CheckStatusEnum.CHECK_STATUS_PENDING.getCode());
            po.setCreateDate(new Date());
            po.setCreateUserId(stageUser.getCreateUserId());
            po.setCreateUserName(stageUser.getCreateUserName());
            po.setBizName(mktActivityPOWithBLOBs.getActivityName());
            log.info("请求sysCheckServiceRpc时的参数" + JSON.toJSONString(po));
            sysCheckServiceRpc.addCheck(po);
        }


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
    public ResponseData<Integer> executeActivityEvaluation(MemberInfoModel vo) {
        log.info("执行评价送积分活动=++++++++++++++______________-----------------------333333");
        log.info("执行评价送积分活动=" + vo.getBrandId() + "=" + vo.getMemberCode());
        //返回对象
        ResponseData responseData = new ResponseData();
        //查询品牌下所有执行中的活动
        ActivityVO activity = new ActivityVO();
        activity.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
        activity.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_EVALUATION.getCode());
        List<ActivityVO> evaluationList = mktActivityEvaluationPOMapper.getActivityVOList(activity);
        if (CollectionUtils.isEmpty(evaluationList)) {
            responseData.setCode(SysResponseEnum.OPERATE_FAILED_DATA_NOT_EXISTS.getCode());
            responseData.setMessage(SysResponseEnum.OPERATE_FAILED_DATA_NOT_EXISTS.getMessage());
            return responseData;
        }
        for (ActivityVO activityVO : evaluationList) {
            //增加积分奖励新增接口
            log.info("执行评价送积分777777777777777777");
            AwardBO bo = new AwardBO();
            IntegralChangeRequestModel integralChangeRequestModel = new IntegralChangeRequestModel();
            integralChangeRequestModel.setSysCompanyId(activityVO.getSysCompanyId());
            integralChangeRequestModel.setBrandId(activityVO.getSysBrandId());
            integralChangeRequestModel.setMemberCode(vo.getMemberCode());
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
            po.setMemberCode(vo.getMemberCode());
            po.setParticipateDate(new Date());
            po.setPoints(activityVO.getPoints());
            po.setAcitivityId(activityVO.getMktActivityId());
            po.setSysBrandId(activityVO.getSysBrandId());
            log.info("新增积分记录表");
            mktActivityRecordPOMapper.insertSelective(po);
        }
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }


    @Override
    public ResponseData<Integer> checkActivityEvaluation(SysCheckPo po, SysAccountPO sysAccountPO) {
        log.info("审核活动开始");
        ResponseData responseData = new ResponseData();
        MktActivityPOWithBLOBs bs = new MktActivityPOWithBLOBs();
        bs.setModifiedUserId(sysAccountPO.getSysAccountId());
        bs.setModifiedDate(new Date());
        bs.setModifiedUserName(sysAccountPO.getName());
        bs.setCheckStatus(po.getCheckStatus());
        bs.setActivityCode(po.getBusinessCode());
        bs.setMktActivityId(po.getBusinessId());
        //判断是审核通过还是审核驳回
        if (bs.getCheckStatus() == CheckStatusEnum.CHECK_STATUS_APPROVED.getCode()) {
            //将活动状态变更为执行中
            log.info("更新活动状态");
            bs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
            int i = mktActivityPOMapper.updateByPrimaryKeySelective(bs);
        } else {
            log.info("更新活动状态");
            bs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_FINISHED.getCode());
            int i = mktActivityPOMapper.updateByPrimaryKeySelective(bs);

        }
        ResponseData<Integer> rpcResponse = new ResponseData<>();
        //更新审核中心状态
        rpcResponse = sysCheckServiceRpc.updateCheck(po);
        //审核中心返回的结果，1是成功
        log.info("sysCheckServiceRpc返回的结果是:" + rpcResponse.getData());
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
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
