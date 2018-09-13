package com.bizvane.mktcenterserviceimpl.service.impl;

import com.alibaba.fastjson.JSON;
import com.bizvane.centerstageservice.models.po.SysCheckConfigPo;
import com.bizvane.centerstageservice.models.po.SysCheckPo;
import com.bizvane.centerstageservice.models.po.SysStorePo;
import com.bizvane.centerstageservice.models.vo.SysCheckConfigVo;
import com.bizvane.centerstageservice.rpc.StoreServiceRpc;
import com.bizvane.centerstageservice.rpc.SysCheckConfigServiceRpc;
import com.bizvane.centerstageservice.rpc.SysCheckServiceRpc;
import com.bizvane.centerstageservice.rpc.SysDimSkuServiceRpc;
import com.bizvane.couponfacade.enums.SendTypeEnum;
import com.bizvane.couponfacade.interfaces.CouponEntityServiceFeign;
import com.bizvane.couponfacade.interfaces.CouponQueryServiceFeign;
import com.bizvane.couponfacade.interfaces.SendCouponServiceFeign;
import com.bizvane.couponfacade.models.po.CouponEntityPO;
import com.bizvane.couponfacade.models.vo.CouponDetailResponseVO;
import com.bizvane.couponfacade.models.vo.CouponEntityAndDefinitionVO;
import com.bizvane.couponfacade.models.vo.SendCouponSimpleRequestVO;
import com.bizvane.members.facade.enums.IntegralChangeTypeEnum;
import com.bizvane.members.facade.models.IntegralRecordModel;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.service.api.IntegralChangeApiService;
import com.bizvane.members.facade.service.api.IntegralRecordApiService;
import com.bizvane.members.facade.service.card.request.IntegralChangeRequestModel;
import com.bizvane.members.facade.vo.IntegralRecordVo;
import com.bizvane.mktcenterservice.interfaces.ActivityBirthdayService;
import com.bizvane.mktcenterservice.models.bo.ActivityBO;
import com.bizvane.mktcenterservice.models.po.*;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.models.vo.MessageVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterserviceimpl.common.enums.*;
import com.bizvane.mktcenterserviceimpl.common.job.JobUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.CodeUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.ExecuteParamCheckUtil;
import com.bizvane.mktcenterserviceimpl.mappers.*;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.jobutils.JobClient;
import com.bizvane.utils.jobutils.XxlJobInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.xml.internal.rngom.dt.CachedDatatypeLibraryFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author chen.li
 * @date on 2018/7/13 18:49
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@Service
@Slf4j
public class ActivityBirthdayServiceImpl implements ActivityBirthdayService {

    @Autowired
    private MktActivityBirthdayPOMapper mktActivityBirthdayPOMapper;
    @Autowired
    private MktActivityPOMapper mktActivityPOMapper;
    @Autowired
    private MktCouponPOMapper mktCouponPOMapper;
    @Autowired
    private MktMessagePOMapper mktMessagePOMapper;
    @Autowired
    private JobUtil jobUtil;
    @Autowired
    private SysCheckConfigServiceRpc sysCheckConfigServiceRpc;
    @Autowired
    private SysCheckServiceRpc sysCheckServiceRpc;
    @Autowired
    private CouponQueryServiceFeign couponQueryServiceFeign;
    @Autowired
    private JobClient jobClient;
    @Autowired
    private CouponEntityServiceFeign couponEntityServiceFeign;
    @Autowired
    private SendCouponServiceFeign sendCouponServiceFeign;
    @Autowired
    private MktActivityRecordPOMapper mktActivityRecordPOMapper;
    @Autowired
    private IntegralChangeApiService integralChangeApiService;
    @Autowired
    private IntegralRecordApiService integralRecordApiService;
    @Autowired
    private SysDimSkuServiceRpc sysDimSkuServiceRpc;
    @Autowired
    private StoreServiceRpc storeServiceRpc;
    /**
     * 查询生日活动列表
     * @param vo
     * @param pageForm
     * @return
     */
    @Override
    public ResponseData<ActivityVO> getActivityBirthdayList(ActivityVO vo, PageForm pageForm) {
        log.info("查询生日活动列表开始");
        ResponseData responseData = new ResponseData();
        PageHelper.startPage(pageForm.getPageNumber(),pageForm.getPageSize());
        List<ActivityVO> activityBirthdayList = mktActivityBirthdayPOMapper.getActivityBirthdayList(vo);
        PageInfo<ActivityVO> pageInfo = new PageInfo<>(activityBirthdayList);
        responseData.setData(pageInfo);
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }

    /**
     * 创建活动
     * @param bo
     * @param stageUser
     * @return
     */
    @Override
    @Transactional
    public ResponseData<Integer> addActivityBirthday(ActivityBO bo, SysAccountPO stageUser) {
        log.info("创建生日活动开始");
        //返回对象
        ResponseData responseData = new ResponseData();
        //得到大实体类
        ActivityVO activityVO = bo.getActivityVO();
        //工具类生成活动编码
        String activityCode = CodeUtil.getActivityCode();
        activityVO.setActivityCode(activityCode);
        //增加活动类型是消费活动
        activityVO.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_BIRTHDAY.getCode());
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

        //查询判断长期活动同一会员等级是否有重复
        if(1 == bo.getActivityVO().getLongTerm()){
            ActivityVO vo = new ActivityVO();
            vo.setMbrLevelCode(bo.getActivityVO().getMbrLevelCode());
            vo.setLongTerm(bo.getActivityVO().getLongTerm());
            vo.setSysBrandId(activityVO.getSysBrandId());
            vo.setSysBrandId(activityVO.getSysBrandId());
            vo.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_BIRTHDAY.getCode());
            List<ActivityVO> registerList = mktActivityBirthdayPOMapper.getActivityBirthdayList(vo);
            if(!CollectionUtils.isEmpty(registerList)){
                for (ActivityVO activity:registerList) {
                    //判断适用商品
                    if (!ExecuteParamCheckUtil.addActivitCheck(bo,activity)){
                        responseData.setCode(SysResponseEnum.FAILED.getCode());
                        responseData.setMessage("已存在同一类型的长期活动!");
                        return responseData;
                    }
                }

            }
        }

        //查询审核配置，是否需要审核然后判断
        SysCheckConfigVo so = new SysCheckConfigVo();
        so.setSysBrandId(activityVO.getSysBrandId());
        ResponseData<List<SysCheckConfigVo>> sysCheckConfigVo =sysCheckConfigServiceRpc.getCheckConfigListAll(so);
        List<SysCheckConfigVo> sysCheckConfigVoList = sysCheckConfigVo.getData();
        //判断是否有审核配置
        int i = 0;
        if(!CollectionUtils.isEmpty(sysCheckConfigVoList)){
            for (SysCheckConfigVo sysCheckConfig:sysCheckConfigVoList) {
                //判断是否需要审核  暂时先写这三个审核类型 后期确定下来写成枚举类
                if(sysCheckConfig.getFunctionCode().equals("C0001") || sysCheckConfig.getFunctionCode().equals("C0002") || sysCheckConfig.getFunctionCode().equals("C0003")){
                    i+=1;
                }
            }
        }

        if(i>0){
            //查询结果如果需要审核审核状态为待审核
            mktActivityPOWithBLOBs.setCheckStatus(CheckStatusEnum.CHECK_STATUS_PENDING.getCode());
            //活动状态设置为待执行
            mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_PENDING.getCode());

            //如果是待审核数据则需要增加一条审核数据l
            SysCheckPo po = new SysCheckPo();
            po.setSysBrandId(mktActivityPOWithBLOBs.getSysBrandId());
            po.setBusinessCode(mktActivityPOWithBLOBs.getActivityCode());
            po.setBusinessName(mktActivityPOWithBLOBs.getActivityName());
            po.setBusinessType(ActivityTypeEnum.ACTIVITY_TYPE_BIRTHDAY.getCode());
            po.setFunctionCode("C0002");
            po.setCheckStatus(CheckStatusEnum.CHECK_STATUS_PENDING.getCode());
            po.setCreateDate(new Date());
            po.setCreateUserId(stageUser.getSysAccountId());
            po.setCreateUserName(stageUser.getName());
            log.info("增加一条数据到审核中心");
            sysCheckServiceRpc.addCheck(po);
            //getStartTime 开始时间>当前时间增加job
            if(1 != bo.getActivityVO().getLongTerm() && new Date().before(activityVO.getStartTime())){
                //创建任务调度任务开始时间
                jobUtil.addStratBirthdayJob(stageUser,activityVO,activityCode);
                //创建任务调度任务结束时间
                jobUtil.addEndBirthdayJob(stageUser,activityVO,activityCode);
            }
        }else{
            //查询结果如果不需要审核审核状态为已审核
            mktActivityPOWithBLOBs.setCheckStatus(CheckStatusEnum.CHECK_STATUS_APPROVED.getCode());
            //getStartTime 开始时间>当前时间增加job
            if(1 != bo.getActivityVO().getLongTerm() && new Date().before(activityVO.getStartTime())){
                //活动状态设置为待执行
                mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_PENDING.getCode());
                //创建任务调度任务开始时间
                jobUtil.addStratBirthdayJob(stageUser,activityVO,activityCode);
                //创建任务调度任务结束时间
                jobUtil.addEndBirthdayJob(stageUser,activityVO,activityCode);
            }else{
                //活动状态设置为执行中
                mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
            }
        }
        //新增活动主表
        mktActivityPOWithBLOBs.setCreateDate(new Date());
        mktActivityPOWithBLOBs.setCreateUserId(stageUser.getSysAccountId());
        mktActivityPOWithBLOBs.setCreateUserName(stageUser.getName());
        log.info("增加一条数据到主表参数为："+ JSON.toJSONString(mktActivityPOWithBLOBs));
        mktActivityPOMapper.insertSelective(mktActivityPOWithBLOBs);
        //获取新增后数据id
        Long mktActivityId = mktActivityPOWithBLOBs.getMktActivityId();

        //新增生日活动表
        MktActivityBirthdayPO mktActivityBirthdayPO = new MktActivityBirthdayPO();
        BeanUtils.copyProperties(mktActivityPOWithBLOBs,mktActivityBirthdayPO);
        mktActivityBirthdayPO.setMktActivityId(mktActivityId);
        mktActivityBirthdayPO.setMbrLevelCode(activityVO.getMbrLevelCode());
        mktActivityBirthdayPO.setMbrLevelName(activityVO.getMbrLevelName());
        mktActivityBirthdayPO.setDaysAhead(activityVO.getDaysAhead());
        mktActivityBirthdayPO.setIsStoreLimit(activityVO.getStoreLimit());
        if (true==activityVO.getStoreLimit()){
            mktActivityBirthdayPO.setStoreLimitList(activityVO.getStoreLimitList());
            mktActivityBirthdayPO.setStoreLimitType(activityVO.getStoreLimitType());
        }
        log.info("增加一条数据到生日表参数为："+ JSON.toJSONString(mktActivityBirthdayPO));
        mktActivityBirthdayPOMapper.insertSelective(mktActivityBirthdayPO);

        //新增券奖励
        List<MktCouponPO> couponCodeList = bo.getCouponCodeList();
        if(!CollectionUtils.isEmpty(couponCodeList)){
            for(MktCouponPO couponCode : couponCodeList){
                MktCouponPO mktCouponPO = new MktCouponPO();
                BeanUtils.copyProperties(mktActivityPOWithBLOBs,mktCouponPO);
                mktCouponPO.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode());
                mktCouponPO.setBizId(mktActivityId);
                mktCouponPO.setCouponName(couponCode.getCouponName());
                mktCouponPO.setCouponDefinitionId(couponCode.getCouponDefinitionId());
                mktCouponPO.setBizId(couponCode.getBizId());
                mktCouponPOMapper.insertSelective(mktCouponPO);
            }
        }

        //新增活动消息
       /* List<MktMessagePO> messageVOList = bo.getMessageVOList();
        if(!CollectionUtils.isEmpty(messageVOList)){
            for(MktMessagePO messageVO : messageVOList){
                MktMessagePO mktMessagePO = new MktMessagePO();
                BeanUtils.copyProperties(mktActivityPOWithBLOBs,mktMessagePO);
                BeanUtils.copyProperties(messageVO,mktMessagePO);
                mktMessagePO.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode());
                mktMessagePO.setBizId(mktActivityId);
                mktMessagePOMapper.insertSelective(mktMessagePO);
            }
        }*/
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }

    /**
     * 查询生日活动详情
     * @param businessCode
     * @return
     */
    @Override
    public ResponseData<ActivityBO> selectActivityBirthdayById(String businessCode) {
        ActivityBO bo = new ActivityBO();
        log.info("查询生日详情参数="+businessCode);
        ResponseData responseData = new ResponseData();
        ActivityVO vo= new ActivityVO();
        vo.setActivityCode(businessCode);
        //查询主表和字表数据
        List<ActivityVO> registerList = mktActivityBirthdayPOMapper.getActivityBirthdayList(vo);
        if (CollectionUtils.isEmpty(registerList)){
            responseData.setCode(SysResponseEnum.OPERATE_FAILED_DATA_NOT_EXISTS.getCode());
            responseData.setMessage(SysResponseEnum.OPERATE_FAILED_DATA_NOT_EXISTS.getMessage());
            return responseData;
        }
        if (!StringUtils.isEmpty(registerList.get(0).getStoreLimitList())){
            String ids =registerList.get(0).getStoreLimitList();
            //查询适用门店
            List<Long> listIds = Arrays.asList(ids.split(",")).stream().map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
            List<SysStorePo> sysStorePOs = (List<SysStorePo>) storeServiceRpc.getIdStoreList(listIds,null,null,null,null).getData();
            if(!CollectionUtils.isEmpty(sysStorePOs)){
                bo.getActivityVO().setSysStorePos(sysStorePOs);
            }
        }

        //查询活动卷
        MktCouponPOExample example = new  MktCouponPOExample();
        example.createCriteria().andBizIdEqualTo(registerList.get(0).getMktActivityId()).andValidEqualTo(true);
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
        MktMessagePOExample exampl = new MktMessagePOExample();
        exampl.createCriteria().andBizIdEqualTo(registerList.get(0).getMktActivityId()).andValidEqualTo(true);
        List<MktMessagePO> listMktMessage = mktMessagePOMapper.selectByExample(exampl);
        if(!CollectionUtils.isEmpty(registerList)){
            bo.setActivityVO(registerList.get(0));
        }
        if(!CollectionUtils.isEmpty(lists)){
            bo.setCouponEntityAndDefinitionVOList(lists);
        }
        if(!CollectionUtils.isEmpty(listMktMessage)){
            bo.setMessageVOList(listMktMessage);
        }

        responseData.setData(bo);
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }

    /*
     * 审核生日活动
     * @param bs
     * @param sysAccountPO
     * @return
     */
    @Override
    @Transactional
    public ResponseData<Integer> checkActivityBirthday(SysCheckPo po, SysAccountPO sysAccountPO) {
        log.info("审核生日活动开始参数ActivityCode="+po.getBusinessCode()+"checkStatus="+po.getCheckStatus());
        ResponseData responseData = new ResponseData();
        MktActivityPOWithBLOBs bs = new MktActivityPOWithBLOBs();
        bs.setModifiedUserId(sysAccountPO.getSysAccountId());
        bs.setModifiedDate(new Date());
        bs.setModifiedUserName(sysAccountPO.getName());
        bs.setCheckStatus(po.getCheckStatus());
        bs.setActivityCode(po.getBusinessCode());
        bs.setMktActivityId(po.getBusinessId());
        //根据code查询出审核活动的详细信息
        MktActivityPOExample exampl = new MktActivityPOExample();
        exampl.createCriteria().andActivityCodeEqualTo(bs.getActivityCode()).andValidEqualTo(true);
        List<MktActivityPO> mktActivityPO = mktActivityPOMapper.selectByExample(exampl);
        if (org.apache.commons.collections.CollectionUtils.isEmpty(mktActivityPO)){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.OPERATE_FAILED_DATA_NOT_EXISTS.getMessage());
            return responseData;
        }
        MktActivityPO activityPO = mktActivityPO.get(0);
        //判断是审核通过还是审核驳回
        if(bs.getCheckStatus()==CheckStatusEnum.CHECK_STATUS_APPROVED.getCode()){
            //活动开始时间<当前时间<活动结束时间  或者长期活动 也就是StartTime=null
            if(1== activityPO.getLongTerm() ||(new Date().after(activityPO.getStartTime()) && new Date().before(activityPO.getEndTime()))){
                //将活动状态变更为执行中 并且发送消息
                bs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
                int i = mktActivityPOMapper.updateByPrimaryKeySelective(bs);
            }
            //判断审核时间 >活动结束时间  将活动状态变为已结束
            if(new Date().after(activityPO.getEndTime())){
                bs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_FINISHED.getCode());
                int i = mktActivityPOMapper.updateByPrimaryKeySelective(bs);
            }

        }else{
            bs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_FINISHED.getCode());
            int i = mktActivityPOMapper.updateByPrimaryKeySelective(bs);
        }
        //更新审核中心状态
        sysCheckServiceRpc.updateCheck(po);
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }

    /**
     * 修改活动
     * @param bo
     * @param stageUser
     * @return
     */
    @Override
    @Transactional
    public ResponseData<Integer> updateActivityBirthday(ActivityBO bo, SysAccountPO stageUser) {
        log.info("生日活动修改开始");
        //返回对象
        ResponseData responseData = new ResponseData();
        //得到大实体类
        ActivityVO activityVO = bo.getActivityVO();
        if(activityVO.getCheckStatus()!=CheckStatusEnum.CHECK_STATUS_PENDING.getCode()||activityVO.getCheckStatus()!=CheckStatusEnum.CHECK_STATUS_REJECTED.getCode()){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage("该任务不能修改!");
            return responseData;
        }

        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = new MktActivityPOWithBLOBs();
        BeanUtils.copyProperties(activityVO,mktActivityPOWithBLOBs);
        //job类
        XxlJobInfo xxlJobInfo = new XxlJobInfo();
        xxlJobInfo.setExecutorParam(activityVO.getActivityCode());
        xxlJobInfo.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode());
        //查询审核配置，是否需要审核然后判断
        SysCheckConfigVo so = new SysCheckConfigVo();
        so.setSysBrandId(activityVO.getSysBrandId());
        ResponseData<List<SysCheckConfigVo>> sysCheckConfigVo =sysCheckConfigServiceRpc.getCheckConfigListAll(so);
        List<SysCheckConfigVo> sysCheckConfigVoList = sysCheckConfigVo.getData();
        //判断是否有审核配置
        int i = 0;
        if(!CollectionUtils.isEmpty(sysCheckConfigVoList)){
            for (SysCheckConfigVo sysCheckConfig:sysCheckConfigVoList) {
                //判断是否需要审核  暂时先写这三个审核类型 后期确定下来写成枚举类
                if(sysCheckConfig.getFunctionCode().equals("C0001") || sysCheckConfig.getFunctionCode().equals("C0002") || sysCheckConfig.getFunctionCode().equals("C0003")){
                    i+=1;
                }
            }
        }

        if(i>0){
            //查询结果如果需要审核审核状态为待审核
            mktActivityPOWithBLOBs.setCheckStatus(CheckStatusEnum.CHECK_STATUS_PENDING.getCode());
            //活动状态设置为待执行
            mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_PENDING.getCode());

            //如果是待审核数据则需要增加一条审核数据
            //已驳回的可以新建审核
            if(activityVO.getCheckStatus() == CheckStatusEnum.CHECK_STATUS_REJECTED.getCode()){
                SysCheckPo po = new SysCheckPo();
                po.setSysBrandId(mktActivityPOWithBLOBs.getSysBrandId());
                po.setFunctionCode(mktActivityPOWithBLOBs.getActivityCode());
                po.setBusinessName(mktActivityPOWithBLOBs.getActivityName());
                po.setBusinessType(ActivityTypeEnum.ACTIVITY_TYPE_BIRTHDAY.getCode());
                po.setFunctionCode("C0002");
                po.setCheckStatus(CheckStatusEnum.CHECK_STATUS_PENDING.getCode());
                po.setCreateDate(new Date());
                po.setCreateUserId(stageUser.getSysAccountId());
                po.setCreateUserName(stageUser.getName());
                sysCheckServiceRpc.addCheck(po);
            }

            //getStartTime 开始时间>当前时间增加job
            if( new Date().before(activityVO.getStartTime())){
                //先删除原来创建的job任务
                jobClient.removeByBiz(xxlJobInfo);
                //创建任务调度任务开始时间
                jobUtil.addStratBirthdayJob(stageUser,activityVO,mktActivityPOWithBLOBs.getActivityCode());
                //创建任务调度任务结束时间
                jobUtil.addEndBirthdayJob(stageUser,activityVO,mktActivityPOWithBLOBs.getActivityCode());
            }
        }else{
            //查询结果如果不需要审核审核状态为已审核
            mktActivityPOWithBLOBs.setCheckStatus(CheckStatusEnum.CHECK_STATUS_APPROVED.getCode());
            //getStartTime 开始时间>当前时间增加job
            if( new Date().before(activityVO.getStartTime())){
                //活动状态设置为待执行
                mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_PENDING.getCode());
                //先删除原来创建的job任务
                jobClient.removeByBiz(xxlJobInfo);
                //创建任务调度任务开始时间
                jobUtil.addStratBirthdayJob(stageUser,activityVO,mktActivityPOWithBLOBs.getActivityCode());
                //创建任务调度任务结束时间
                jobUtil.addEndBirthdayJob(stageUser,activityVO,mktActivityPOWithBLOBs.getActivityCode());
            }else{
                //活动状态设置为执行中
                mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());

            }
        }

        //修改活动主表
        mktActivityPOWithBLOBs.setModifiedDate(new Date());
        mktActivityPOWithBLOBs.setModifiedUserId(stageUser.getSysAccountId());
        mktActivityPOWithBLOBs.setModifiedUserName(stageUser.getName());
        mktActivityPOMapper.updateByPrimaryKeySelective(mktActivityPOWithBLOBs);

        //获取新增后数据id
        Long mktActivityId = mktActivityPOWithBLOBs.getMktActivityId();


        //修改生日活动表
        MktActivityBirthdayPO mktActivityBirthdayPO = new MktActivityBirthdayPO();
        BeanUtils.copyProperties(mktActivityPOWithBLOBs,mktActivityBirthdayPO);
        mktActivityBirthdayPO.setMktActivityId(mktActivityId);
        mktActivityBirthdayPOMapper.updateByPrimaryKeySelective(mktActivityBirthdayPO);

        //先删除在新增
        MktCouponPO record = new MktCouponPO();
        record.setValid(false);
        MktCouponPOExample example = new MktCouponPOExample();
        example.createCriteria().andBizIdEqualTo(mktActivityId);
        mktCouponPOMapper.updateByExampleSelective(record,example);
        //修改券奖励
        List<MktCouponPO> couponCodeList = bo.getCouponCodeList();
        if(!CollectionUtils.isEmpty(couponCodeList)){
            for(MktCouponPO couponCode : couponCodeList){
                MktCouponPO mktCouponPO = new MktCouponPO();
                BeanUtils.copyProperties(mktActivityPOWithBLOBs,mktCouponPO);
                mktCouponPO.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode());
                mktCouponPO.setBizId(mktActivityId);
                mktCouponPO.setCouponName(couponCode.getCouponName());
                mktCouponPO.setCouponDefinitionId(couponCode.getCouponDefinitionId());
                mktCouponPO.setBizId(couponCode.getBizId());
                mktCouponPOMapper.insertSelective(mktCouponPO);
            }
        }


        //先删除在新增
        MktMessagePO message = new MktMessagePO();
        message.setValid(false);
        MktMessagePOExample exam = new MktMessagePOExample();
        exam.createCriteria().andBizIdEqualTo(mktActivityId);
        mktMessagePOMapper.updateByExampleSelective(message,exam);
        //修改活动消息
        List<MktMessagePO> messageVOList = bo.getMessageVOList();
        if(!CollectionUtils.isEmpty(messageVOList)){
            for(MktMessagePO messageVO : messageVOList){
                MktMessagePO mktMessagePO = new MktMessagePO();
                BeanUtils.copyProperties(mktActivityPOWithBLOBs,mktMessagePO);
                BeanUtils.copyProperties(messageVO,mktMessagePO);
                mktMessagePO.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode());
                mktMessagePO.setBizId(mktActivityId);
                mktMessagePOMapper.insertSelective(mktMessagePO);
            }
        }
        log.info("任务修改结束");
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }

    /**
     * 生日定时发送奖励
     * 1. 获取提前多少天执行
     * 2. 提前的天数最大值还没到第二年，判断今年这个会员是否收到过此券
     * 3. 否则，判断会员生日有没有到明年，如果到了明年，再看明年的券是否发过
     * @param activityBirthday
     * @param memberInfoModelList
     */
    @Override
    @Async("asyncServiceExecutor")
    public void birthdayReward(ActivityVO activityBirthday, List<MemberInfoModel> memberInfoModelList) {
        for (MemberInfoModel memberInfo:memberInfoModelList) {
            //判断生日适用门店信息
            if (!ExecuteParamCheckUtil.implementActivitCheck(memberInfo,activityBirthday)){
                continue;
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            Date date = new Date();// 取时间
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            calendar.add(Calendar.YEAR, 1);// 把日期往后增加一年.整数往后推,负数往前移动
            date = calendar.getTime();
            //明年
            String s1 =sdf.format(date);
            Date toyear = null;
            try {
                 toyear = sdf.parse(s1);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //今年
            String s2 =sdf.format(new Date());
            Date year = null;
            try {
                year = sdf.parse(s2);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //判断当前时间加上发送天数是都是今年还是明年
            //如果为true 说明是今年
            if (true==dateSize(activityBirthday)){
                //判断今年有没有发券
                ResponseData<List<CouponEntityPO>> couponEntityPOs = couponEntityServiceFeign.findCouponHave(memberInfo.getMemberCode(),activityBirthday.getMktActivityId(),year);
                List<CouponEntityPO> couponEntityPO =couponEntityPOs.getData();
                if (!CollectionUtils.isEmpty(couponEntityPO)){
                    continue;
                }
                //判断今年有没有发积分
                IntegralRecordVo vs = new IntegralRecordVo();
                vs.setMemberCode(memberInfo.getMemberCode());
                vs.setChangeBills(activityBirthday.getActivityCode());
                vs.setYear(s2);
                ResponseData<List<IntegralRecordModel>> integralRecordModels = integralRecordApiService.queryIntegralRecord(vs);
                List<IntegralRecordModel> integralRecordModel = integralRecordModels.getData();
                if (!CollectionUtils.isEmpty(integralRecordModel)){
                    continue;
                }
            }else{
                //说明是明年 判断生日加上提前发送天数有没到明年
                //true 说明是到了明年
                if (true==dateMonth(activityBirthday,memberInfo)){
                    //判断明年有没有发券
                    ResponseData<List<CouponEntityPO>> couponEntityPOs = couponEntityServiceFeign.findCouponHave(memberInfo.getMemberCode(),activityBirthday.getMktActivityId(),toyear);
                    List<CouponEntityPO> couponEntityPO =couponEntityPOs.getData();
                    if (!CollectionUtils.isEmpty(couponEntityPO)){
                        continue;
                    }
                    //判断明年有没有发积分
                    IntegralRecordVo vs = new IntegralRecordVo();
                    vs.setMemberCode(memberInfo.getMemberCode());
                    vs.setChangeBills(activityBirthday.getActivityCode());
                    vs.setYear(s1);
                    ResponseData<List<IntegralRecordModel>> integralRecordModels = integralRecordApiService.queryIntegralRecord(vs);
                    List<IntegralRecordModel> integralRecordModel = integralRecordModels.getData();
                    if (!CollectionUtils.isEmpty(integralRecordModel)){
                        continue;
                    }
                }else{
                    //判断今年有没有发券
                    ResponseData<List<CouponEntityPO>> couponEntityPOs = couponEntityServiceFeign.findCouponHave(memberInfo.getMemberCode(),activityBirthday.getMktActivityId(),year);
                    List<CouponEntityPO> couponEntityPO =couponEntityPOs.getData();
                    if (!CollectionUtils.isEmpty(couponEntityPO)){
                        continue;
                    }
                    //判断今年有没有发积分
                    IntegralRecordVo vs = new IntegralRecordVo();
                    vs.setMemberCode(memberInfo.getMemberCode());
                    vs.setChangeBills(activityBirthday.getActivityCode());
                    vs.setYear(s2);
                    ResponseData<List<IntegralRecordModel>> integralRecordModels = integralRecordApiService.queryIntegralRecord(vs);
                    List<IntegralRecordModel> integralRecordModel = integralRecordModels.getData();
                    if (!CollectionUtils.isEmpty(integralRecordModel)){
                        continue;
                    }
                }

            }

            //增加积分奖励新增接口
            IntegralChangeRequestModel integralChangeRequestModel =new IntegralChangeRequestModel();
            integralChangeRequestModel.setSysCompanyId(activityBirthday.getSysCompanyId());
            integralChangeRequestModel.setBrandId(activityBirthday.getSysBrandId());
            integralChangeRequestModel.setMemberCode(memberInfo.getMemberCode());
            integralChangeRequestModel.setChangeBills(activityBirthday.getActivityCode());
            integralChangeRequestModel.setChangeIntegral(activityBirthday.getPoints());
            integralChangeRequestModel.setChangeType(IntegralChangeTypeEnum.INCOME.getCode());
            integralChangeRequestModel.setBusinessType(String.valueOf(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode()));
            integralChangeRequestModel.setChangeDate(new Date());
            integralChangeApiService.integralChangeOperate(integralChangeRequestModel);
            // 增加卷奖励接口
            MktCouponPOExample example = new  MktCouponPOExample();
            example.createCriteria().andBizIdEqualTo(activityBirthday.getMktActivityId()).andValidEqualTo(true);
            List<MktCouponPO> mktCouponPOs= mktCouponPOMapper.selectByExample(example);
            for (MktCouponPO mktCouponPO:mktCouponPOs) {
                SendCouponSimpleRequestVO va = new SendCouponSimpleRequestVO();
                va.setMemberCode(memberInfo.getMemberCode());
                va.setCouponDefinitionId(mktCouponPO.getCouponDefinitionId());
                va.setSendBussienId(mktCouponPO.getBizId());
                va.setSendType(SendTypeEnum.SEND_COUPON_BIRTH.getCode());
                sendCouponServiceFeign.simple(va);
            }
            //新增积分到会员参与活动记录表中数据
            MktActivityRecordPO po = new MktActivityRecordPO();
            po.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_BIRTHDAY.getCode());
            po.setMemberCode(memberInfo.getMemberCode());
            po.setParticipateDate(new Date());
            po.setPoints(activityBirthday.getPoints());
            po.setAcitivityId(activityBirthday.getMktActivityId());
            po.setSysBrandId(activityBirthday.getSysBrandId());
            mktActivityRecordPOMapper.insertSelective(po);

        }
    }

    private Boolean dateMonth(ActivityVO activityBirthday,MemberInfoModel memberInfo) {
        boolean  falg;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date birthday = memberInfo.getBirthday();
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, activityBirthday.getDaysAhead());// num为增加的天数，可以改变的
        birthday = ca.getTime();
        String enddate = format.format(birthday);
        System.out.println("增加天数以后的日期：" + enddate);

        //获取生日月份和增加天数后的月份
        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        String s1 = sdf.format(memberInfo.getBirthday());
        String s2 = sdf.format(birthday);
        System.out.println("日期1：" + s1);
        System.out.println("日期1：" + s2);
        if (Integer.parseInt(s1) > Integer.parseInt(s2)){
            falg=true;
        }else{
            falg=false;
        }
        return falg;
    }

    private Boolean dateSize(ActivityVO activityBirthday) {
        boolean  falg;
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //得到当年日期
        String currdate = format.format(d);
        System.out.println("现在的日期是：" + currdate);
        //获取增加天数后得到的日期
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, activityBirthday.getDaysAhead());// num为增加的天数，可以改变的
        d = ca.getTime();
        String enddate = format.format(d);
        System.out.println("增加天数以后的日期：" + enddate);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        //获取当前年份
        String date = sdf.format(new Date());
        System.out.println("获取当前年份：" + date);
        //获取增加日期后得到的年份
        Date today = null;
        try {
            today = format.parse(enddate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String formatDate = sdf.format(today);
        System.out.println("增加天数以后的日期得到的年份：" + formatDate);
        if (Integer.parseInt(date)>=Integer.parseInt(formatDate)){
            falg=true;
        }else{
            falg=false;
        }
        return falg;
    }
    public static void main(String[] args){
        String ids= "1,2,3,4,5,6";
        List<Long> listIds = Arrays.asList(ids.split(",")).stream().map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
        System.out.println(Arrays.toString(listIds .toArray()));//[1,2,3,3,4,5,6]
    }
}
