package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.centerstageservice.models.po.SysCheckConfigPo;
import com.bizvane.centerstageservice.models.vo.SysCheckConfigVo;
import com.bizvane.centerstageservice.rpc.SysCheckConfigServiceRpc;
import com.bizvane.couponfacade.interfaces.SendCouponServiceFeign;
import com.bizvane.couponfacade.models.vo.SendCouponSimpleRequestVO;
import com.bizvane.members.facade.enums.IntegralChangeTypeEnum;
import com.bizvane.members.facade.models.IntegralRecordModel;
import com.bizvane.members.facade.service.api.IntegralRecordApiService;
import com.bizvane.mktcenterservice.interfaces.ActivityOrderService;
import com.bizvane.mktcenterservice.models.bo.ActivityBO;
import com.bizvane.mktcenterservice.models.bo.OrderModelBo;
import com.bizvane.mktcenterservice.models.po.*;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.models.vo.MessageVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterserviceimpl.common.enums.ActivityStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.ActivityTypeEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.BusinessTypeEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.CheckStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.job.XxlJobConfig;
import com.bizvane.mktcenterserviceimpl.common.utils.CodeUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.ExecuteParamCheckUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.JobUtil;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityOrderPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktCouponPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktMessagePOMapper;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.jobutils.JobClient;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author chen.li
 * @date on 2018/7/13 18:50
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@Service
public class ActivityOrderServiceImpl implements ActivityOrderService {

    @Autowired
    private MktActivityOrderPOMapper mktActivityOrderPOMapper;
    @Autowired
    private XxlJobConfig xxlJobConfig;
    @Autowired
    private JobClient jobClient;
    @Autowired
    private MktActivityPOMapper mktActivityPOMapper;
    @Autowired
    private MktCouponPOMapper mktCouponPOMapper;
    @Autowired
    private MktMessagePOMapper mktMessagePOMapper;
    @Autowired
    private SysCheckConfigServiceRpc sysCheckConfigServiceRpc;
    @Autowired
    private JobUtil jobUtil;
    @Autowired
    private IntegralRecordApiService integralRecordApiService;
    @Autowired
    private SendCouponServiceFeign sendCouponServiceFeign;
    /**
     * 查询消费活动列表
     * @param vo
     * @param pageForm
     * @return
     */
    @Override
    public ResponseData<ActivityVO> getActivityOrderList(ActivityVO vo, PageForm pageForm) {
        ResponseData responseData = new ResponseData();
        PageHelper.startPage(pageForm.getPageNumber(),pageForm.getPageSize());
        List<ActivityVO> activityOrderList = mktActivityOrderPOMapper.getActivityOrderList(vo);
        PageInfo<ActivityVO> pageInfo = new PageInfo<>(activityOrderList);
        responseData.setData(pageInfo);
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
        //返回对象
        ResponseData responseData = new ResponseData();
        //得到大实体类
        ActivityVO activityVO = bo.getActivityVO();
        //工具类生成活动编码
        String activityCode = CodeUtil.getActivityCode();
        activityVO.setActivityCode(activityCode);
        //增加活动类型是消费活动
        activityVO.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_ORDER.getCode());
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = new MktActivityPOWithBLOBs();
        BeanUtils.copyProperties(activityVO,mktActivityPOWithBLOBs);

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
            SysCheckConfigPo po = new SysCheckConfigPo();
            po.setSysBrandId(mktActivityPOWithBLOBs.getSysBrandId());
            po.setFunctionCode(mktActivityPOWithBLOBs.getActivityCode());
            po.setFunctionName(mktActivityPOWithBLOBs.getActivityName());
            po.setCreateDate(new Date());
            po.setCreateUserId(stageUser.getSysAccountId());
            po.setCreateUserName(stageUser.getName());
            sysCheckConfigServiceRpc.addCheckConfig(po);
            //getStartTime 开始时间>当前时间增加job
            if( new Date().before(activityVO.getStartTime())){
                //创建任务调度任务开始时间
                jobUtil.addJob(stageUser,activityVO,activityCode);
                //创建任务调度任务结束时间
                jobUtil.addJobEndTime(stageUser,activityVO,activityCode);
            }
        }else{
            //查询结果如果不需要审核审核状态为已审核
            mktActivityPOWithBLOBs.setCheckStatus(CheckStatusEnum.CHECK_STATUS_APPROVED.getCode());
            //getStartTime 开始时间>当前时间增加job
            if(new Date().before(activityVO.getStartTime())){
                //活动状态设置为待执行
                mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_PENDING.getCode());
                //创建任务调度任务开始时间
                jobUtil.addJob(stageUser,activityVO,activityCode);
                //创建任务调度任务结束时间
                jobUtil.addJobEndTime(stageUser,activityVO,activityCode);
            }else{
                //活动状态设置为执行中
                mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
                //发送模板消息和短信消息TODO

            }
        }


        //新增活动主表
        mktActivityPOWithBLOBs.setCreateDate(new Date());
        mktActivityPOWithBLOBs.setCreateUserId(stageUser.getSysAccountId());
        mktActivityPOWithBLOBs.setCreateUserName(stageUser.getName());
        mktActivityPOMapper.insertSelective(mktActivityPOWithBLOBs);

        //获取新增后数据id
        Long mktActivityId = mktActivityPOWithBLOBs.getMktActivityId();


        //新增会员消费活动表
        MktActivityOrderPOWithBLOBs mktActivityOrderPOWithBLOBs = new MktActivityOrderPOWithBLOBs();
        BeanUtils.copyProperties(mktActivityPOWithBLOBs,mktActivityOrderPOWithBLOBs);
        mktActivityOrderPOWithBLOBs.setMktActivityId(mktActivityId);
        mktActivityOrderPOMapper.insertSelective(mktActivityOrderPOWithBLOBs);

        //新增券奖励
        List<MktCouponPO> couponCodeList = bo.getCouponCodeList();
        if(!CollectionUtils.isEmpty(couponCodeList)){
            for(MktCouponPO couponCode : couponCodeList){
                MktCouponPO mktCouponPO = new MktCouponPO();
                BeanUtils.copyProperties(mktActivityPOWithBLOBs,mktCouponPO);
                mktCouponPO.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode());
                mktCouponPO.setBizId(mktActivityId);
                mktCouponPO.setCouponCode(couponCode.getCouponCode());
                mktCouponPO.setCouponName(couponCode.getCouponName());
                mktCouponPO.setCouponId(couponCode.getCouponId());
                mktCouponPO.setBizId(couponCode.getBizId());
                mktCouponPOMapper.insertSelective(mktCouponPO);
            }
        }

        //新增活动消息
        List<MessageVO> messageVOList = bo.getMessageVOList();
        if(!CollectionUtils.isEmpty(messageVOList)){
            for(MessageVO messageVO : messageVOList){
                MktMessagePO mktMessagePO = new MktMessagePO();
                BeanUtils.copyProperties(mktActivityPOWithBLOBs,mktMessagePO);
                BeanUtils.copyProperties(messageVO,mktMessagePO);
                mktMessagePO.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode());
                mktMessagePO.setBizId(mktActivityId);
                mktMessagePOMapper.insertSelective(mktMessagePO);
            }
        }
        return responseData;
    }

    /**
     * 查询活动
     * @param mktActivityId
     * @return
     */
    @Override
    public ResponseData<List<ActivityVO>> selectActivityOrderById(Long mktActivityId) {
        ResponseData responseData = new ResponseData();
        ActivityVO vo= new ActivityVO();
        vo.setMktActivityId(mktActivityId);
        List<ActivityVO> orderList = mktActivityOrderPOMapper.getActivityOrderList(vo);
        responseData.setData(orderList);
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
                SysCheckConfigPo po = new SysCheckConfigPo();
                po.setSysBrandId(mktActivityPOWithBLOBs.getSysBrandId());
                po.setFunctionCode(mktActivityPOWithBLOBs.getActivityCode());
                po.setFunctionName(mktActivityPOWithBLOBs.getActivityName());
                po.setCreateDate(new Date());
                po.setCreateUserId(stageUser.getSysAccountId());
                po.setCreateUserName(stageUser.getName());
                sysCheckConfigServiceRpc.addCheckConfig(po);
            }

            //getStartTime 开始时间>当前时间增加job
            if( new Date().before(activityVO.getStartTime())){
                //创建任务调度任务开始时间
                jobUtil.addJob(stageUser,activityVO,mktActivityPOWithBLOBs.getActivityCode());
                //创建任务调度任务结束时间
                jobUtil.addJobEndTime(stageUser,activityVO,mktActivityPOWithBLOBs.getActivityCode());
            }
        }else{
            //查询结果如果不需要审核审核状态为已审核
            mktActivityPOWithBLOBs.setCheckStatus(CheckStatusEnum.CHECK_STATUS_APPROVED.getCode());
            //getStartTime 开始时间>当前时间增加job
            if( new Date().before(activityVO.getStartTime())){
                //活动状态设置为待执行
                mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_PENDING.getCode());
                //创建任务调度任务开始时间
                jobUtil.addJob(stageUser,activityVO,mktActivityPOWithBLOBs.getActivityCode());
                //创建任务调度任务结束时间
                jobUtil.addJobEndTime(stageUser,activityVO,mktActivityPOWithBLOBs.getActivityCode());
            }else{
                //活动状态设置为执行中
                mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
                //发送模板消息和短信消息TODO

            }
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
                mktCouponPO.setCouponCode(couponCode.getCouponCode());
                mktCouponPO.setCouponName(couponCode.getCouponName());
                mktCouponPO.setCouponId(couponCode.getCouponId());
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
        List<MessageVO> messageVOList = bo.getMessageVOList();
        if(!CollectionUtils.isEmpty(messageVOList)){
            for(MessageVO messageVO : messageVOList){
                MktMessagePO mktMessagePO = new MktMessagePO();
                BeanUtils.copyProperties(mktActivityPOWithBLOBs,mktMessagePO);
                BeanUtils.copyProperties(messageVO,mktMessagePO);
                mktMessagePO.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode());
                mktMessagePO.setBizId(mktActivityId);
                mktMessagePOMapper.insertSelective(mktMessagePO);
            }
        }
        return responseData;
    }

    /**
     * 审核消费活动
     * @param bs
     * @param sysAccountPO
     * @return
     */
    @Override
    public ResponseData<Integer> checkActivityOrder(MktActivityPOWithBLOBs bs, SysAccountPO sysAccountPO) {
        ResponseData responseData = new ResponseData();
        bs.setModifiedUserId(sysAccountPO.getSysAccountId());
        bs.setModifiedDate(new Date());
        bs.setModifiedUserName(sysAccountPO.getName());
        //根据id查询出审核活动的详细信息
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = mktActivityPOMapper.selectByPrimaryKey(bs.getMktActivityId());
        //判断是审核通过还是审核驳回
        if(bs.getCheckStatus()==CheckStatusEnum.CHECK_STATUS_APPROVED.getCode()){
            //活动开始时间<当前时间<活动结束时间  或者长期活动 也就是StartTime=null
            if(new Date().after(mktActivityPOWithBLOBs.getStartTime()) && new Date().before(mktActivityPOWithBLOBs.getEndTime())){
                //将活动状态变更为执行中 并且发送消息（当前活动适用会员）
                bs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
                int i = mktActivityPOMapper.updateByPrimaryKeySelective(bs);
                //发送模板消息TODO
                //查询消息集合
                MktMessagePOExample example = new MktMessagePOExample();
                example.createCriteria().andBizIdEqualTo(bs.getMktActivityId());
                List<MktMessagePO> ListMktMessage = mktMessagePOMapper.selectByExample(example);

            }
            //判断审核时间 >活动结束时间  将活动状态变为已结束
            if(new Date().after(mktActivityPOWithBLOBs.getEndTime())){
                bs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_FINISHED.getCode());
                int i = mktActivityPOMapper.updateByPrimaryKeySelective(bs);
            }

        }else{
            bs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_FINISHED.getCode());
            int i = mktActivityPOMapper.updateByPrimaryKeySelective(bs);
        }

        return responseData;
    }

    /**
     * 执行活动
     * @param vo
     * @return
     */
    @Override
    public ResponseData<Integer> executeOrder(OrderModelBo vo) {
        //返回对象
        ResponseData responseData = new ResponseData();
        //查询品牌下所有执行中的活动
        ActivityVO activity = new ActivityVO();
        activity.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
        activity.setSysBrandId(vo.getBrandId().longValue());
        activity.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_REGISGER.getCode());
        List<ActivityVO> OrderList = mktActivityOrderPOMapper.getActivityOrderList(activity);
        for (ActivityVO activityVO:OrderList) {
            //判断金额是否满足
            if (!ExecuteParamCheckUtil.CheckPayMoney(vo.getPayMoney(),new BigDecimal(activityVO.getOrderMinPrice()))){
                continue;
            }
            //判断会员范围 会员类型
            if(!ExecuteParamCheckUtil.CheckMemberType(vo.getMemberType(),activityVO.getMemberType())){
                continue;
            }
            //判断会员等级
            if(!ExecuteParamCheckUtil.CheckMbrLevelCode(vo.getLevelId(),activityVO.getMbrLevelCode())){
                continue;
            }
            //判断订单来源
            if(!ExecuteParamCheckUtil.CheckOrderFrom(vo.getOrderFrom(),activityVO.getOrderSource())){
                continue;
            }

            //判断适用商品
            if (!ExecuteParamCheckUtil.CheckCommodity(vo,activityVO)){
                continue;
            }
            //判断适用门店
            if (!ExecuteParamCheckUtil.CheckserviceStore(vo,activityVO)){
                continue;
            }


            //增加积分奖励新增接口
            IntegralRecordModel var1 = new IntegralRecordModel();
            var1.setMemberCode(vo.getMemberCode().toString());
            var1.setChangeBills(activityVO.getActivityCode());
            var1.setChangeIntegral(activityVO.getPoints());
            var1.setChangeWay(IntegralChangeTypeEnum.INCOME.getCode());
            integralRecordApiService.updateMemberIntegral(var1);

            // 增加卷奖励接口
            MktCouponPOExample example = new  MktCouponPOExample();
            example.createCriteria().andBizIdEqualTo(activityVO.getMktActivityId());
            example.createCriteria().andValidEqualTo(true);
            List<MktCouponPO> mktCouponPOs= mktCouponPOMapper.selectByExample(example);
            for (MktCouponPO mktCouponPO:mktCouponPOs) {
                SendCouponSimpleRequestVO va = new SendCouponSimpleRequestVO();
                va.setMemberCode(vo.getMemberCode().toString());
                va.setCouponDefinitionId(mktCouponPO.getCouponId());
                va.setSendBussienId(mktCouponPO.getBizId());
                va.setSendType("10");
                sendCouponServiceFeign.simple(va);
            }
        }
        return responseData;
    }

}
