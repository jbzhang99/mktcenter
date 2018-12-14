package com.bizvane.mktcenterserviceimpl.service.impl;

import com.alibaba.fastjson.JSON;
import com.bizvane.centerstageservice.models.po.SysCheckConfigPo;
import com.bizvane.centerstageservice.models.po.SysCheckPo;
import com.bizvane.centerstageservice.models.po.SysStorePo;
import com.bizvane.centerstageservice.models.vo.SysCheckConfigVo;
import com.bizvane.centerstageservice.rpc.StoreServiceRpc;
import com.bizvane.centerstageservice.rpc.SysCheckConfigServiceRpc;
import com.bizvane.centerstageservice.rpc.SysCheckServiceRpc;
import com.bizvane.couponfacade.interfaces.CouponQueryServiceFeign;
import com.bizvane.couponfacade.models.po.CouponEntityPO;
import com.bizvane.couponfacade.models.vo.CouponDetailResponseVO;
import com.bizvane.couponfacade.models.vo.CouponEntityAndDefinitionVO;
import com.bizvane.members.facade.enums.BusinessTypeEnum;
import com.bizvane.members.facade.enums.IntegralChangeTypeEnum;
import com.bizvane.members.facade.models.IntegralRecordModel;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.service.api.IntegralChangeApiService;
import com.bizvane.members.facade.service.api.IntegralRecordApiService;
import com.bizvane.members.facade.service.card.request.IntegralChangeRequestModel;
import com.bizvane.members.facade.service.card.response.IntegralChangeResponseModel;
import com.bizvane.mktcenterservice.interfaces.ActivitySigninService;
import com.bizvane.mktcenterservice.models.bo.ActivityBO;
import com.bizvane.mktcenterservice.models.bo.AwardBO;
import com.bizvane.mktcenterservice.models.po.*;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterserviceimpl.common.award.Award;
import com.bizvane.mktcenterserviceimpl.common.enums.*;
import com.bizvane.mktcenterserviceimpl.common.utils.CodeUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.ExecuteParamCheckUtil;
import com.bizvane.mktcenterserviceimpl.mappers.*;
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
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author chen.li
 * @date on 2018/7/13 18:52
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@Service
@Slf4j
public class ActivitySigninServiceImpl implements ActivitySigninService {

    @Autowired
    private MktActivitySigninMapper mktActivitySigninMapper;
    @Autowired
    private MktActivityPOMapper mktActivityPOMapper;
    @Autowired
    private MktMessagePOMapper mktMessagePOMapper;
    @Autowired
    private SysCheckConfigServiceRpc sysCheckConfigServiceRpc;
    @Autowired
    private IntegralRecordApiService integralRecordApiService;
    @Autowired
    private MktActivityRecordPOMapper mktActivityRecordPOMapper;
    @Autowired
    private SysCheckServiceRpc sysCheckServiceRpc;
    @Autowired
    private MktCouponPOMapper mktCouponPOMapper;
    @Autowired
    private CouponQueryServiceFeign couponQueryServiceFeign;
    @Autowired
    private Award award;
    @Autowired
    private StoreServiceRpc storeServiceRpc;
    
    @Autowired
    private MktActivityCountPOMapper mktActivityCountPOMapper;

    @Autowired
    private IntegralChangeApiService integralChangeApiService;
    
    /**
     * 查询签到活动列表
     * @param vo
     * @param pageForm
     * @return
     */
    @Override
    public ResponseData<ActivityVO> getActivitySigninList(ActivityVO vo, PageForm pageForm,SysAccountPO stageUser) {
        log.info("查询签到活动列表");
        ResponseData responseData = new ResponseData();
        PageHelper.startPage(pageForm.getPageNumber(),pageForm.getPageSize());
        vo.setSysBrandId(stageUser.getBrandId());
        List<ActivityVO> activitySigninList = mktActivitySigninMapper.getActivitySigninList(vo);
        PageInfo<ActivityVO> pageInfo = new PageInfo<>(activitySigninList);
        responseData.setData(pageInfo);
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }

    /**
     * 创建会员签到积分活动
     * @param bo
     * @param stageUser
     * @return
     */
    @Override
    @Transactional
    public ResponseData<Integer> addActivitySignin(ActivityBO bo, SysAccountPO stageUser) {
        log.info("创建签到活动开始");
        //返回对象
        ResponseData responseData = new ResponseData();
        //得到大实体类
        ActivityVO activityVO = bo.getActivityVO();
        //工具类生成活动编码
        String activityCode = CodeUtil.getActivityCode();
        activityVO.setActivityCode(activityCode);
        //增加活动类型是签到活动
        activityVO.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_SIGNIN.getCode());
        //增加品牌id
        log.info("获取的品牌id是="+stageUser.getBrandId());
        if(null==stageUser.getBrandId()){
            log.error("token没有获取到品牌id");
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage("Token没有获取到品牌id!");
            return responseData;
        }
        activityVO.setSysBrandId(stageUser.getBrandId());
        activityVO.setSysCompanyId(stageUser.getSysCompanyId());
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = new MktActivityPOWithBLOBs();
        BeanUtils.copyProperties(activityVO,mktActivityPOWithBLOBs);
        //查询看是否已存在签到活动
        ActivityVO vo= new ActivityVO();
        vo.setSysBrandId(stageUser.getBrandId());
        vo.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_SIGNIN.getCode());
        vo.setStop("ture");
        List<ActivityVO> activitySigninList = mktActivitySigninMapper.getActivitySigninList(vo);
        if(!CollectionUtils.isEmpty(activitySigninList)){
            for (ActivityVO activity:activitySigninList) {
                //判断适用商品
                if (false==activity.getStoreLimit() ||!ExecuteParamCheckUtil.addActivitCheck(bo,activity)){
                    responseData.setCode(SysResponseEnum.FAILED.getCode());
                    responseData.setMessage("已存在签到活动!");
                    return responseData;
                }
            }

        }
       /* if(!CollectionUtils.isEmpty(activitySigninList)){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage("已存在签到活动!");
            return responseData;
        }*/
        //查询审核配置，是否需要审核然后判断
        /*SysCheckConfigVo so = new SysCheckConfigVo();
        so.setSysBrandId(activityVO.getSysBrandId());*/
        ResponseData<List<SysCheckConfigVo>> sysCheckConfigVo =sysCheckConfigServiceRpc.getCheckConfigListAll(activityVO.getSysBrandId());
        List<SysCheckConfigVo> sysCheckConfigVoList = sysCheckConfigVo.getData();
        //判断是否有审核配置
        int i = 0;
        if(!CollectionUtils.isEmpty(sysCheckConfigVoList)){
            for (SysCheckConfigVo sysCheckConfig:sysCheckConfigVoList) {
                //判断是否需要审核  暂时先写这三个审核类型 后期确定下来写成枚举类
                if(sysCheckConfig.getFunctionCode().equals("C0002")){
                    i+=1;
                }
            }
        }

        if(i>0){
            //查询结果如果需要审核审核状态为待审核
            mktActivityPOWithBLOBs.setCheckStatus(CheckStatusEnum.CHECK_STATUS_PENDING.getCode());
            //活动状态设置为待执行
            mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_PENDING.getCode());


        }else{
            //查询结果如果不需要审核审核状态为已审核
            mktActivityPOWithBLOBs.setCheckStatus(CheckStatusEnum.CHECK_STATUS_APPROVED.getCode());
            //活动状态设置为执行中
            mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());

        }

        //新增活动主表
        mktActivityPOWithBLOBs.setCreateDate(new Date());
        mktActivityPOWithBLOBs.setCreateUserId(stageUser.getSysAccountId());
        mktActivityPOWithBLOBs.setCreateUserName(stageUser.getName());
        log.info("新增主表数据="+ JSON.toJSONString(mktActivityPOWithBLOBs));
        mktActivityPOWithBLOBs.setActivityName("签到活动");
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
        
        if (i>0){
            //如果是待审核数据则需要增加一条审核数据
            log.info("增加审核中心一条数据");
            SysCheckPo po = new SysCheckPo();
            po.setSysBrandId(mktActivityPOWithBLOBs.getSysBrandId());
            po.setSysCompanyId(mktActivityPOWithBLOBs.getSysCompanyId());
            po.setBusinessCode(mktActivityPOWithBLOBs.getActivityCode());
            po.setBusinessName("签到活动");
            po.setBusinessType(ActivityTypeEnum.ACTIVITY_TYPE_SIGNIN.getCode());
            po.setFunctionCode("C0002");
            po.setCheckStatus(CheckStatusEnum.CHECK_STATUS_PENDING.getCode());
            po.setBizName("签到活动");
            po.setBusinessId(mktActivityId);
            po.setCreateDate(new Date());
            po.setCreateUserId(stageUser.getSysAccountId());
            po.setCreateUserName(stageUser.getName());
            sysCheckServiceRpc.addCheck(po);
        }
        //新增会员签到活动表
        MktActivitySignin mktActivitySignin = new MktActivitySignin();
        BeanUtils.copyProperties(mktActivityPOWithBLOBs,mktActivitySignin);
        mktActivitySignin.setMktActivityId(mktActivityId);
        mktActivitySignin.setIsStoreLimit(activityVO.getStoreLimit());
        if (true==activityVO.getStoreLimit()){
            mktActivitySignin.setStoreLimitList(activityVO.getStoreLimitList());
            mktActivitySignin.setStoreLimitType(activityVO.getStoreLimitType());
        }
        log.info("新增签到表数据="+ JSON.toJSONString(mktActivitySignin));
        mktActivitySigninMapper.insertSelective(mktActivitySignin);
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }

    /**
     * 查看活动详情
     * @param businessCode
     * @return
     */
    @Override
    public ResponseData<ActivityBO> selectActivitySigninById(String businessCode) {
        log.info("查询签到详情");
        ResponseData responseData = new ResponseData();
        ActivityBO bo = new ActivityBO();
        ActivityVO vo= new ActivityVO();
        vo.setActivityCode(businessCode);
        List<ActivityVO> signinList = mktActivitySigninMapper.getActivitySigninList(vo);
        if (CollectionUtils.isEmpty(signinList)){
            responseData.setCode(SysResponseEnum.OPERATE_FAILED_DATA_NOT_EXISTS.getCode());
            responseData.setMessage(SysResponseEnum.OPERATE_FAILED_DATA_NOT_EXISTS.getMessage());
            return responseData;
        }
        if(!CollectionUtils.isEmpty(signinList)){
            bo.setActivityVO(signinList.get(0));
            if (!StringUtils.isEmpty(signinList.get(0).getStoreLimitList())){
                String ids =signinList.get(0).getStoreLimitList();
                //查询适用门店
                List<Long> listIds = Arrays.asList(ids.split(",")).stream().map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
                ResponseData<List<SysStorePo>> sysStorePOs = storeServiceRpc.getIdStoreLists(listIds);

                if(!CollectionUtils.isEmpty(sysStorePOs.getData())){
                    bo.getActivityVO().setSysStorePos(sysStorePOs.getData());
                }
            }
        }
        //查询活动卷
        MktCouponPOExample example = new  MktCouponPOExample();
        example.createCriteria().andBizIdEqualTo(signinList.get(0).getMktActivityId()).andValidEqualTo(true).andBizTypeEqualTo(1);
        List<MktCouponPO> mktCouponPOs= mktCouponPOMapper.selectByExample(example);
        //查询券接口
        List<CouponDetailResponseVO> lists = new ArrayList<>();
        //查询券接口
        if(!CollectionUtils.isEmpty(mktCouponPOs)){
            for (MktCouponPO po:mktCouponPOs) {
                ResponseData<CouponDetailResponseVO>  entityAndDefinition = couponQueryServiceFeign.getCouponDefinition(po.getCouponDefinitionId());
                lists.add(entityAndDefinition.getData());
            }
        }
        //查询消息模板
        log.info("查询消息模板");
        MktMessagePOExample exampl = new MktMessagePOExample();
        exampl.createCriteria().andBizIdEqualTo(signinList.get(0).getMktActivityId()).andValidEqualTo(true);
        List<MktMessagePO> listMktMessage = mktMessagePOMapper.selectByExample(exampl);
        if(!CollectionUtils.isEmpty(signinList)){
            bo.setActivityVO(signinList.get(0));
        }
            bo.setCouponEntityAndDefinitionVOList(lists);
        if(!CollectionUtils.isEmpty(listMktMessage)){
            bo.setMessageVOList(listMktMessage);
        }
        responseData.setData(bo);
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }

    /**
     * 执行活动
     * @param vo
     * @return
     */
    @Override
    @Transactional
    public ResponseData<Integer> executeActivitySignin(MemberInfoModel vo) {
        //返回对象
        ResponseData responseData = new ResponseData();
        log.info("执行签到活动="+vo.getBrandId()+"="+vo.getMemberCode()+"服务id==="+vo.getServiceStoreId());
        log.info("服务门店为!======================="+vo.getServiceStoreId());
        //判断今天是否是执行过签到活动
        MktActivityRecordPO example = new MktActivityRecordPO();
        example.setMemberCode(vo.getMemberCode());
        example.setSysBrandId(vo.getBrandId());
        List<MktActivityRecordPO> lists =mktActivityRecordPOMapper.selectRecordPOList(example);
        if (lists.size()>=1){
            responseData.setCode(SysResponseEnum.OPERATE_FAILED_ADD_ERROR.getCode());
            responseData.setMessage("该会员今天已经签到!");
            return responseData;
        }
        //查询品牌下所有执行中的活动
        ActivityVO activity = new ActivityVO();
        activity.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
        activity.setSysBrandId(vo.getBrandId());
        activity.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_SIGNIN.getCode());
        List<ActivityVO> signinList = mktActivitySigninMapper.getActivitySigninList(activity);
        if (CollectionUtils.isEmpty(signinList)){
            responseData.setCode(SysResponseEnum.OPERATE_FAILED_DATA_NOT_EXISTS.getCode());
            responseData.setMessage(SysResponseEnum.OPERATE_FAILED_DATA_NOT_EXISTS.getMessage());
            return responseData;
        }
        int a =0;
        for (ActivityVO activityVO:signinList) {
            //过滤门店
            if (!ExecuteParamCheckUtil.implementActivitCheck(vo,activityVO)){
                //判断如果没有合适的提示它没有合适的活动
                a+=1;
                if(a==signinList.size()){
                    responseData.setCode(SysResponseEnum.FAILED.getCode());
                    responseData.setMessage("没有适用的签到活动哦");
                    return responseData;
                }
                continue;
            }
            //增加积分奖励新增接口
            AwardBO bo = new AwardBO();
            IntegralChangeRequestModel integralChangeRequestModel =new IntegralChangeRequestModel();
            integralChangeRequestModel.setSysCompanyId(activityVO.getSysCompanyId());
            integralChangeRequestModel.setBrandId(activityVO.getSysBrandId());
            integralChangeRequestModel.setMemberCode(vo.getMemberCode());
            integralChangeRequestModel.setChangeBills(activityVO.getActivityCode());
            integralChangeRequestModel.setChangeIntegral(activityVO.getPoints());
            integralChangeRequestModel.setChangeType(IntegralChangeTypeEnum.INCOME.getCode());
            integralChangeRequestModel.setBusinessType(BusinessTypeEnum.ACTIVITY_TYPE_SIGNIN.getCode());
            integralChangeRequestModel.setChangeDate(new Date());
           /* bo.setIntegralRecordModel(integralChangeRequestModel);
            bo.setMktType(MktSmartTypeEnum.SMART_TYPE_INTEGRAL.getCode());*/
            log.info("新增积分奖励");
            //award.execute(bo);
            log.info("开始执行新增积分操作参数="+ JSON.toJSONString(integralChangeRequestModel));
            IntegralChangeResponseModel integralChangeResponseModel =integralChangeApiService.integralChangeOperate(integralChangeRequestModel);
            log.info("发积分结果打印======"+JSON.toJSONString(integralChangeResponseModel));
            //新增积分到会员参与活动记录表中数据
            MktActivityRecordPO po = new MktActivityRecordPO();
            po.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_SIGNIN.getCode());
            po.setMemberCode(vo.getMemberCode());
            po.setParticipateDate(new Date());
            po.setPoints(activityVO.getPoints());
            po.setAcitivityId(activityVO.getMktActivityId());
            po.setSysBrandId(activityVO.getSysBrandId());
            log.info("新增积分记录表");
            mktActivityRecordPOMapper.insertSelective(po);
            
            mktActivityCountPOMapper.updateSum(po.getAcitivityId(), 1, BigDecimal.ZERO, po.getPoints());
        }
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }

    /**
     * 审核会员签到活动
     * @param
     * @param sysAccountPO
     * @return
     */
    @Override
    public ResponseData<Integer> checkActivitySignin(SysCheckPo po, SysAccountPO sysAccountPO) {
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
        if(bs.getCheckStatus()==CheckStatusEnum.CHECK_STATUS_APPROVED.getCode()){
                //将活动状态变更为执行中
                 log.info("更新活动状态");
                bs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
        }else{
            log.info("更新活动状态");
            bs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_FINISHED.getCode());

        }
        log.info("更新审核状态的参数是+======="+ JSON.toJSONString(bs));
        int i = mktActivityPOMapper.updateByPrimaryKeySelective(bs);
        //更新审核中心状态
        sysCheckServiceRpc.updateCheck(po);
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }
}
