package com.bizvane.mktcenterservice.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.bizvane.centerstageservice.models.po.SysCheckPo;
import com.bizvane.centerstageservice.models.po.SysDimSkuPo;
import com.bizvane.centerstageservice.models.po.SysStorePo;
import com.bizvane.centerstageservice.models.vo.SysCheckConfigVo;
import com.bizvane.centerstageservice.rpc.StoreServiceRpc;
import com.bizvane.centerstageservice.rpc.SysCheckConfigServiceRpc;
import com.bizvane.centerstageservice.rpc.SysCheckServiceRpc;
import com.bizvane.centerstageservice.rpc.SysDimSkuServiceRpc;
import com.bizvane.couponfacade.enums.SendTypeEnum;
import com.bizvane.couponfacade.interfaces.CouponQueryServiceFeign;
import com.bizvane.couponfacade.models.vo.CouponDetailResponseVO;
import com.bizvane.couponfacade.models.vo.SendCouponSimpleRequestVO;
import com.bizvane.members.facade.enums.IntegralChangeTypeEnum;
import com.bizvane.members.facade.es.vo.MembersInfoSearchVo;
import com.bizvane.members.facade.service.card.request.IntegralChangeRequestModel;
import com.bizvane.mktcenterfacade.interfaces.ActivityOrderService;
import com.bizvane.mktcenterfacade.models.bo.ActivityBO;
import com.bizvane.mktcenterfacade.models.bo.AwardBO;
import com.bizvane.mktcenterfacade.models.bo.OrderModelBo;
import com.bizvane.mktcenterfacade.models.po.MktActivityCountPO;
import com.bizvane.mktcenterfacade.models.po.MktActivityOrderPOWithBLOBs;
import com.bizvane.mktcenterfacade.models.po.MktActivityPOWithBLOBs;
import com.bizvane.mktcenterfacade.models.po.MktActivityRecordPO;
import com.bizvane.mktcenterfacade.models.po.MktCouponPO;
import com.bizvane.mktcenterfacade.models.po.MktCouponPOExample;
import com.bizvane.mktcenterfacade.models.po.MktMessagePO;
import com.bizvane.mktcenterfacade.models.po.MktMessagePOExample;
import com.bizvane.mktcenterfacade.models.vo.ActivityVO;
import com.bizvane.mktcenterfacade.models.vo.PageForm;
import com.bizvane.mktcenterservice.common.award.Award;
import com.bizvane.mktcenterservice.common.award.MemberMessageSend;
import com.bizvane.mktcenterservice.common.enums.ActivityStatusEnum;
import com.bizvane.mktcenterservice.common.enums.ActivityTypeEnum;
import com.bizvane.mktcenterservice.common.enums.BusinessTypeEnum;
import com.bizvane.mktcenterservice.common.enums.CheckStatusEnum;
import com.bizvane.mktcenterservice.common.enums.MktSmartTypeEnum;
import com.bizvane.mktcenterservice.common.job.JobUtil;
import com.bizvane.mktcenterservice.common.utils.CodeUtil;
import com.bizvane.mktcenterservice.common.utils.ExecuteParamCheckUtil;
import com.bizvane.mktcenterservice.mappers.MktActivityCountPOMapper;
import com.bizvane.mktcenterservice.mappers.MktActivityOrderPOMapper;
import com.bizvane.mktcenterservice.mappers.MktActivityPOMapper;
import com.bizvane.mktcenterservice.mappers.MktActivityRecordPOMapper;
import com.bizvane.mktcenterservice.mappers.MktCouponPOMapper;
import com.bizvane.mktcenterservice.mappers.MktMessagePOMapper;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.jobutils.JobClient;
import com.bizvane.utils.jobutils.XxlJobInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;

/**
 * @author chen.li
 * @date on 2018/7/13 18:50
 * @description
 *
 */
@Service
@Slf4j
public class ActivityOrderServiceImpl implements ActivityOrderService {

    @Autowired
    private MktActivityOrderPOMapper mktActivityOrderPOMapper;
    @Autowired
    private JobClient jobClient;
    @Autowired
    private MktActivityPOMapper mktActivityPOMapper;
    @Autowired
    private MktCouponPOMapper mktCouponPOMapper;
    @Autowired
    private MktMessagePOMapper mktMessagePOMapper;

    @Autowired
    private JobUtil jobUtil;

    @Autowired
    private CouponQueryServiceFeign couponQueryServiceFeign;
    @Autowired
    private Award award;
    @Autowired
    private MktActivityRecordPOMapper mktActivityRecordPOMapper;
    @Autowired
    private MemberMessageSend memberMessage;
    @Autowired
    private StoreServiceRpc storeServiceRpc;
    @Autowired
    private SysDimSkuServiceRpc sysDimSkuServiceRpc;
    
    @Autowired
    private MktActivityCountPOMapper mktActivityCountPOMapper;
    
    /**
     * 查询消费活动列表
     * @param vo
     * @param pageForm
     * @return
     */
    @Override
    public ResponseData<ActivityVO> getActivityOrderList(ActivityVO vo, PageForm pageForm,SysAccountPO stageUser) {
        log.info("查询消费活动列表开始");
        ResponseData responseData = new ResponseData();
        PageHelper.startPage(pageForm.getPageNumber(),pageForm.getPageSize());
        vo.setSysBrandId(stageUser.getBrandId());
        vo.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_ORDER.getCode());
        List<ActivityVO> activityOrderList = mktActivityOrderPOMapper.getActivityOrderList(vo);
        PageInfo<ActivityVO> pageInfo = new PageInfo<>(activityOrderList);
        responseData.setData(pageInfo);
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }

    /**
     * 创建会员消费活动
     * @param bo
     * @param stageUser
     * @return
     */
    @Override
    public ResponseData<Integer> addActivityOrder(ActivityBO bo, SysAccountPO stageUser) {
        log.info("创建消费活动开始");
        //返回对象
        ResponseData responseData = new ResponseData();
        //得到大实体类
        ActivityVO activityVO = bo.getActivityVO();
        //判断是否是全部等级
        if (activityVO.getMbrLevelCode().equals("0")){
            activityVO.setMbrLevelName("全部等级");
        }
        //判断活动开始时间是否大于当前时间
        if( new Date().after(activityVO.getStartTime())){
            responseData.setCode(SysResponseEnum.MODEL_FAILED_VALIDATION.getCode());
            responseData.setMessage("活动开始时间不能比当前时间小!");
            return responseData;
        }
        //工具类生成活动编码
        String activityCode = CodeUtil.getActivityCode();
        activityVO.setActivityCode(activityCode);
        //增加活动类型是消费活动
        activityVO.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_ORDER.getCode());
        //增加品牌id
        log.info("获取的品牌id是="+stageUser.getBrandId()+"企业id="+stageUser.getSysCompanyId()+"创建人id 名称="+stageUser.getCreateUserId()+""+stageUser.getCreateUserName());
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

        //查询结果如果不需要审核审核状态为已审核
        mktActivityPOWithBLOBs.setCheckStatus(CheckStatusEnum.CHECK_STATUS_APPROVED.getCode());
        //getStartTime 开始时间>当前时间增加job
        if( new Date().before(activityVO.getStartTime())){
            //活动状态设置为待执行
            mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_PENDING.getCode());
            //创建任务调度任务开始时间
            jobUtil.addJob(stageUser,activityVO,activityCode);
            //创建任务调度任务结束时间
            jobUtil.addJobEndTime(stageUser,activityVO,activityCode);
        }else{
            //活动状态设置为执行中
            mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());


        }

        //新增活动主表
        mktActivityPOWithBLOBs.setCreateDate(new Date());
        mktActivityPOWithBLOBs.setCreateUserId(stageUser.getSysAccountId());
        mktActivityPOWithBLOBs.setCreateUserName(stageUser.getName());
        log.info("生成消费活动主表参数="+ JSON.toJSONString(mktActivityPOWithBLOBs));
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
        
        //新增会员消费活动表
        MktActivityOrderPOWithBLOBs mktActivityOrderPOWithBLOBs = new MktActivityOrderPOWithBLOBs();
        BeanUtils.copyProperties(mktActivityPOWithBLOBs,mktActivityOrderPOWithBLOBs);
        mktActivityOrderPOWithBLOBs.setMktActivityId(mktActivityId);
        mktActivityOrderPOWithBLOBs.setMbrLevelCode(activityVO.getMbrLevelCode());
        mktActivityOrderPOWithBLOBs.setMbrLevelName(activityVO.getMbrLevelName());
        mktActivityOrderPOWithBLOBs.setIsCommodityLimit(activityVO.getCommodityLimit());
        mktActivityOrderPOWithBLOBs.setCommodityLimitList(activityVO.getCommodityLimitList());
        mktActivityOrderPOWithBLOBs.setCommodityLimitType(activityVO.getCommodityLimitType());
        mktActivityOrderPOWithBLOBs.setStoreLimitList(activityVO.getStoreLimitList());
        mktActivityOrderPOWithBLOBs.setStoreLimitType(activityVO.getStoreLimitType());
        mktActivityOrderPOWithBLOBs.setIsStoreLimit(activityVO.getStoreLimit());
        mktActivityOrderPOWithBLOBs.setMemberType(activityVO.getMemberType());
        mktActivityOrderPOWithBLOBs.setOrderSource(activityVO.getOrderSource());
        mktActivityOrderPOWithBLOBs.setOrderMinPrice(activityVO.getOrderMinPrice());
        log.info("生成消费活动消费表参数="+ JSON.toJSONString(mktActivityOrderPOWithBLOBs));
        mktActivityOrderPOMapper.insertSelective(mktActivityOrderPOWithBLOBs);

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
                //mktCouponPO.setBizId(couponCode.getBizId());
                mktCouponPOMapper.insertSelective(mktCouponPO);
            }
        }

        //新增活动消息
        List<MktMessagePO> messageVOList = bo.getMessageVOList();
        if(!CollectionUtils.isEmpty(messageVOList)){
            for(MktMessagePO messageVO : messageVOList){
                MktMessagePO mktMessagePO = new MktMessagePO();
                BeanUtils.copyProperties(mktActivityPOWithBLOBs,mktMessagePO);
                BeanUtils.copyProperties(messageVO,mktMessagePO);
                mktMessagePO.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode());
                mktMessagePO.setBizId(mktActivityId);
                mktMessagePO.setSendImmediately(activityVO.getSendImmediately());
                mktMessagePO.setSendTime(activityVO.getSendTime());
                mktMessagePOMapper.insertSelective(mktMessagePO);
            }
        }
        ////如果是立即发送 则发送短息
        if(!CollectionUtils.isEmpty(messageVOList) ){
            if(true==activityVO.getSendImmediately()){
                log.info("我看看进来了吗");
                //分页查询会员信息发送短信
                MembersInfoSearchVo membersInfoSearchVo = new MembersInfoSearchVo();
                membersInfoSearchVo.setPageNumber(1);
                membersInfoSearchVo.setPageSize(10000);
                //判断下是否是全部会员等级
                if(!activityVO.getMbrLevelCode().equals("0")){
                    List<Long> level = new ArrayList<>();
                    level.add(Long.parseLong(activityVO.getMbrLevelCode()));
                    membersInfoSearchVo.setLevelID(level);
                }

                membersInfoSearchVo.setBrandId(activityVO.getSysBrandId());
                membersInfoSearchVo.setSysCompanyId(activityVO.getSysCompanyId());
                //加个是否是长期活动
                activityVO.setLongTerm(0);
                log.info("查询会员参数==============="+ JSON.toJSONString(membersInfoSearchVo));
                memberMessage.getMemberList(messageVOList, membersInfoSearchVo,activityVO);
            }else{
                //自定义时间发送 加人job任务
                jobUtil.addSendMessageJob(stageUser,activityVO,activityCode);
            }


        }
        log.info("消费活动创建结束");
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }


    /**
     * 查询活动
     * @param businessCode
     * @return
     */
    @Override
    public ResponseData<ActivityBO> selectActivityOrderById(String businessCode) {
        ActivityBO bo = new ActivityBO();
        log.info("查询消费活动详情开始参数="+businessCode);
        ResponseData responseData = new ResponseData();
        ActivityVO vo= new ActivityVO();
        vo.setActivityCode(businessCode);
        vo.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_ORDER.getCode());
        List<ActivityVO> orderList = mktActivityOrderPOMapper.getActivityOrderList(vo);
        if (CollectionUtils.isEmpty(orderList)){
            log.warn("没有查询到数据");
            responseData.setCode(SysResponseEnum.OPERATE_FAILED_DATA_NOT_EXISTS.getCode());
            responseData.setMessage(SysResponseEnum.OPERATE_FAILED_DATA_NOT_EXISTS.getMessage());
            return responseData;
        }
        if(!CollectionUtils.isEmpty(orderList)){
            bo.setActivityVO(orderList.get(0));
            if (!StringUtils.isEmpty(orderList.get(0).getStoreLimitList())){
                String ids =orderList.get(0).getStoreLimitList();
                //查询适用门店
                List<Long> listIds = Arrays.asList(ids.split(",")).stream().map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
                ResponseData<List<SysStorePo>> sysStorePOs = storeServiceRpc.getIdStoreLists(listIds);
                if(!CollectionUtils.isEmpty(sysStorePOs.getData())){
                    bo.getActivityVO().setSysStorePos(sysStorePOs.getData());
                }
            }
            if (!StringUtils.isEmpty(orderList.get(0).getCommodityLimitList())){
                //查询适用商品
                String cos =orderList.get(0).getCommodityLimitList();
                List<Long> listId = Arrays.asList(cos.split(",")).stream().map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
                ResponseData<List<SysDimSkuPo>> sysDimSkuPos = sysDimSkuServiceRpc.getIdSysDimSkuLists(listId);
                if(!CollectionUtils.isEmpty(sysDimSkuPos.getData())){
                    bo.getActivityVO().setSysDimSkuPos(sysDimSkuPos.getData());
                }
            }
        }

        //查询活动卷
        MktCouponPOExample example = new  MktCouponPOExample();
        example.createCriteria().andBizIdEqualTo(orderList.get(0).getMktActivityId()).andValidEqualTo(true).andBizTypeEqualTo(1);
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
        exampl.createCriteria().andBizIdEqualTo(orderList.get(0).getMktActivityId()).andValidEqualTo(true);
        List<MktMessagePO> listMktMessage = mktMessagePOMapper.selectByExampleWithBLOBs(exampl);
            bo.setCouponEntityAndDefinitionVOList(lists);
        if(!CollectionUtils.isEmpty(listMktMessage)){
            bo.setMessageVOList(listMktMessage);
        }
        log.info("查询消费活动详情结束");
        responseData.setData(bo);
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
    public ResponseData<Integer> updateActivityOrder(ActivityBO bo, SysAccountPO stageUser) {
        log.info("修改消费活动开始");
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

        //查询结果如果不需要审核审核状态为已审核
        mktActivityPOWithBLOBs.setCheckStatus(CheckStatusEnum.CHECK_STATUS_APPROVED.getCode());
        //getStartTime 开始时间>当前时间增加job
        if( new Date().before(activityVO.getStartTime())){
            //活动状态设置为待执行
            mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_PENDING.getCode());
            //先删除原来创建的job任务
            jobClient.removeByBiz(xxlJobInfo);
            //创建任务调度任务开始时间
            jobUtil.addJob(stageUser,activityVO,mktActivityPOWithBLOBs.getActivityCode());
            //创建任务调度任务结束时间
            jobUtil.addJobEndTime(stageUser,activityVO,mktActivityPOWithBLOBs.getActivityCode());
        }else{
            //活动状态设置为执行中
            mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());

        }
        //修改活动主表
        mktActivityPOWithBLOBs.setModifiedDate(new Date());
        mktActivityPOWithBLOBs.setModifiedUserId(stageUser.getSysAccountId());
        mktActivityPOWithBLOBs.setModifiedUserName(stageUser.getName());
        mktActivityPOMapper.updateByPrimaryKeySelective(mktActivityPOWithBLOBs);

        //获取新增后数据id
        Long mktActivityId = mktActivityPOWithBLOBs.getMktActivityId();


        //修改会员消费活动表
        MktActivityOrderPOWithBLOBs mktActivityOrderPOWithBLOBs = new MktActivityOrderPOWithBLOBs();
        BeanUtils.copyProperties(mktActivityPOWithBLOBs,mktActivityOrderPOWithBLOBs);
        mktActivityOrderPOWithBLOBs.setMktActivityId(mktActivityId);
        mktActivityOrderPOMapper.updateByPrimaryKeySelective(mktActivityOrderPOWithBLOBs);

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
        //发送模板消息和短信消息
        //如果执行状态为执行中 就要发送消息
        if(!CollectionUtils.isEmpty(messageVOList) && mktActivityPOWithBLOBs.getActivityStatus()==ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode()){
            //分页查询会员信息发送短信
            MembersInfoSearchVo membersInfoSearchVo = new MembersInfoSearchVo();
            membersInfoSearchVo.setPageNumber(1);
            membersInfoSearchVo.setPageSize(10000);
            if (!activityVO.getMbrLevelCode().equals("0")){
               // membersInfoSearchVo.setLevelId(Long.parseLong(activityVO.getMbrLevelCode()));
            }
            membersInfoSearchVo.setBrandId(activityVO.getSysBrandId());
            memberMessage.getMemberList(messageVOList, membersInfoSearchVo,activityVO);

        }
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
    public ResponseData<Integer> executeOrder(OrderModelBo vo) {
        log.info("执行消费活动开始开始了开始了开始了开始了开始了开始了");
        //返回对象
        log.info("执行消费活动+======="+ JSON.toJSONString(vo));
        ResponseData responseData = new ResponseData();
        //查询品牌下所有执行中的活动
        ActivityVO activity = new ActivityVO();
        activity.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
        activity.setSysBrandId(vo.getBrandId());
        activity.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_REGISGER.getCode());
        List<ActivityVO> orderList = mktActivityOrderPOMapper.getActivityOrderList(activity);
        if (CollectionUtils.isEmpty(orderList)){
            log.warn("查询数据不存在");
            responseData.setCode(SysResponseEnum.OPERATE_FAILED_DATA_NOT_EXISTS.getCode());
            responseData.setMessage(SysResponseEnum.OPERATE_FAILED_DATA_NOT_EXISTS.getMessage());
            return responseData;
        }
        log.info("执行消费活动查询到的进行中活动+======="+ JSON.toJSONString(orderList));
        for (ActivityVO activityVO:orderList) {
            log.info("执行消费活动要开始验证验证验证验证验证了啦啦啦啦啦啦啦啦");
            //判断金额是否满足
            if (!ExecuteParamCheckUtil.CheckPayMoney(vo.getPayMoney(),new BigDecimal(activityVO.getOrderMinPrice()))){
                continue;
            }
            log.info("消费金额验证完毕");
            //判断会员范围 会员类型
            if(!ExecuteParamCheckUtil.CheckMemberType(vo.getMemberType(),activityVO.getMemberType())){
                continue;
            }
            log.info("消费会员范围验证完毕");
            //判断会员等级
            if (!"0".equals(activityVO.getMbrLevelCode())){
                if(!ExecuteParamCheckUtil.CheckMbrLevelCode(vo.getLevelId(),activityVO.getMbrLevelCode()) ){
                    continue;
                }
            }
            log.info("消费会员等级验证完毕");
            //判断订单来源
            if(!ExecuteParamCheckUtil.CheckOrderFrom(vo.getOrderFrom(),activityVO.getOrderSource())){
                continue;
            }
            log.info("消费会员订单来源验证完毕");
            //判断适用商品
            if (!ExecuteParamCheckUtil.CheckCommodity(vo,activityVO)){
                continue;
            }
            log.info("消费会员适用商品来源验证完毕");
            //判断适用门店
            if (!ExecuteParamCheckUtil.CheckserviceStore(vo,activityVO)){
                continue;
            }
            log.info("消费会员适用门店来源验证完毕");
            log.info("消费活动验证通过了通过了通过了通过了通过了通过了通过了通过了通过了通过了通过了通过了+++++++++++++++");

            //增加积分奖励新增接口
            if (null!=activityVO.getPoints()){
                log.info("新增消费活动积分奖励奖励+++++++++++++++");
                AwardBO bo = new AwardBO();
                IntegralChangeRequestModel integralChangeRequestModel =new IntegralChangeRequestModel();
                integralChangeRequestModel.setSysCompanyId(activityVO.getSysCompanyId());
                integralChangeRequestModel.setBrandId(activityVO.getSysBrandId());
                integralChangeRequestModel.setMemberCode(vo.getMemberCode());
                integralChangeRequestModel.setChangeBills(activityVO.getActivityCode());
                integralChangeRequestModel.setChangeIntegral(activityVO.getPoints());
                integralChangeRequestModel.setChangeType(IntegralChangeTypeEnum.INCOME.getCode());
                integralChangeRequestModel.setBusinessType(com.bizvane.members.facade.enums.BusinessTypeEnum.ACTIVITY_TYPE_ORDER.getCode());
                integralChangeRequestModel.setChangeDate(new Date());
                bo.setIntegralRecordModel(integralChangeRequestModel);
                bo.setMktType(MktSmartTypeEnum.SMART_TYPE_INTEGRAL.getCode());
                log.info("新增积分奖励========================"+activityVO.getPoints());
                award.execute(bo);
            }


            // 增加卷奖励接口
            log.info("新增消费活动券奖励券奖励奖励奖励奖励奖励奖励奖励奖励");
            MktCouponPOExample example = new  MktCouponPOExample();
            example.createCriteria().andBizIdEqualTo(activityVO.getMktActivityId()).andValidEqualTo(true).andBizTypeEqualTo(1);
            List<MktCouponPO> mktCouponPOs= mktCouponPOMapper.selectByExample(example);
            if (!CollectionUtils.isEmpty(mktCouponPOs)){
                for (MktCouponPO mktCouponPO:mktCouponPOs) {
                    AwardBO awardBO = new AwardBO();
                    SendCouponSimpleRequestVO sendCouponSimpleRequestVO = new SendCouponSimpleRequestVO();
                    sendCouponSimpleRequestVO.setMemberCode(vo.getMemberCode().toString());
                    sendCouponSimpleRequestVO.setCouponDefinitionId(mktCouponPO.getCouponDefinitionId());
                    sendCouponSimpleRequestVO.setSendBussienId(mktCouponPO.getBizId());
                    sendCouponSimpleRequestVO.setSendType(SendTypeEnum.SEND_COUPON_COUSUME_ACTIVITY.getCode());
                    sendCouponSimpleRequestVO.setBrandId(vo.getBrandId().longValue());
                    sendCouponSimpleRequestVO.setCompanyId(vo.getCompanyId());
                    sendCouponSimpleRequestVO.setBusinessName(activityVO.getActivityName());
                    awardBO.setSendCouponSimpleRequestVO(sendCouponSimpleRequestVO);
                    awardBO.setMktType(MktSmartTypeEnum.SMART_TYPE_COUPON.getCode());
                    award.execute(awardBO);
                }
            }
            //新增积分到会员参与活动记录表中数据
            MktActivityRecordPO po = new MktActivityRecordPO();
            po.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_ORDER.getCode());
            po.setMemberCode(vo.getMemberCode().toString());
            po.setParticipateDate(new Date());
            po.setPoints(activityVO.getPoints());
            po.setAcitivityId(activityVO.getMktActivityId());
            po.setSysBrandId(activityVO.getSysBrandId());
            po.setSysCompanyId(activityVO.getSysCompanyId());
            po.setOrderAmount(new BigDecimal(activityVO.getOrderMinPrice()));
            log.info("新增积分记录表");
            mktActivityRecordPOMapper.insertSelective(po);
            
            mktActivityCountPOMapper.updateSum(po.getAcitivityId(), 1, po.getOrderAmount(), po.getPoints());

        }
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }

}
