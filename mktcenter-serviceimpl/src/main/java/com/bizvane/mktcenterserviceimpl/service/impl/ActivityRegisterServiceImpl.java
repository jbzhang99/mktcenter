package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.centerstageservice.models.po.SysCheckConfigPo;
import com.bizvane.centerstageservice.rpc.SysCheckConfigServiceRpc;
import com.bizvane.mktcenterservice.interfaces.ActivityRegisterService;
import com.bizvane.mktcenterservice.models.bo.ActivityBO;
import com.bizvane.mktcenterservice.models.po.*;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.models.vo.MessageVO;
import com.bizvane.mktcenterserviceimpl.common.enums.ActivityStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.BusinessTypeEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.CheckStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.job.XxlJobConfig;
import com.bizvane.mktcenterserviceimpl.common.utils.JobUtil;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityRegisterPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktCouponPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktMessagePOMapper;
import com.bizvane.utils.commonutils.PageForm;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.jobutils.JobClient;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author chen.li
 * @date on 2018/7/13 15:10
 * @description 开卡活动
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@Service
public class ActivityRegisterServiceImpl implements ActivityRegisterService {

    @Autowired
    private MktActivityRegisterPOMapper mktActivityRegisterPOMapper;

    @Autowired
    private MktActivityPOMapper mktActivityPOMapper;

    @Autowired
    private MktCouponPOMapper mktCouponPOMapper;

    @Autowired
    private MktMessagePOMapper mktMessagePOMapper;

    @Autowired
    private  XxlJobConfig xxlJobConfig;

    @Autowired
    private JobClient jobClient;
    @Autowired
    private JobUtil jobUtil;
    @Autowired
    private SysCheckConfigServiceRpc sysCheckConfigServiceRpc;
    /**
     * 查询活动列表
     * @param vo
     * @param pageForm
     * @return
     */
    @Override
    public ResponseData<ActivityVO> getActivityList(ActivityVO vo,PageForm pageForm) {
        ResponseData responseData = new ResponseData();
        PageHelper.startPage(pageForm.getPageNumber(),pageForm.getPageSize());
        List<ActivityVO> activityRegisterList = mktActivityRegisterPOMapper.getActivityList(vo);
        PageInfo<ActivityVO> pageInfo = new PageInfo<>(activityRegisterList);
        responseData.setData(pageInfo);
        return responseData;
    }

    /**
     * 创建活动
     * @param bo
     * @return
     */
    @Override
    @Transactional
    public ResponseData<Integer> addActivity(ActivityBO bo,SysAccountPO stageUser) {
        //返回对象
        ResponseData responseData = new ResponseData();
        //得到大实体类
        ActivityVO activityVO = bo.getActivityVO();
        //暂时用uuid生成活动编号
        activityVO.setActivityCode("AC"+ UUID.randomUUID().toString().replaceAll("-", ""));
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = new MktActivityPOWithBLOBs();
        BeanUtils.copyProperties(activityVO,mktActivityPOWithBLOBs);
        //查询判断长期活动同一会员等级是否有重复
        ActivityVO vo = new ActivityVO();
        vo.setMbrLevelCode(bo.getActivityVO().getMbrLevelCode());
        vo.setLongTerm(bo.getActivityVO().getLongTerm());
        List<ActivityVO> RegisterList = mktActivityRegisterPOMapper.getActivityList(vo);
        if(!CollectionUtils.isEmpty(RegisterList)){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage("已存在同一类型的长期活动!");
            return responseData;

        }
        //查询审核配置，是否需要审核然后判断TODO

        if(1==1){
            //查询结果如果需要审核审核状态为待审核
            mktActivityPOWithBLOBs.setCheckStatus(CheckStatusEnum.CHECK_STATUS_PENDING.getCode());
            //活动状态设置为待执行
            mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_PENDING.getCode());
            //新增活动主表
            mktActivityPOWithBLOBs.setCreateDate(new Date());
            mktActivityPOWithBLOBs.setCreateUserId(stageUser.getSysAccountId());
            mktActivityPOWithBLOBs.setCreateUserName(stageUser.getName());
            mktActivityPOMapper.insertSelective(mktActivityPOWithBLOBs);
            //获取新增后数据id
            Long mktActivityId = mktActivityPOWithBLOBs.getMktActivityId();

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
            if(new Date().before(activityVO.getStartTime())){
                //创建任务调度任务开始时间
                jobUtil.addJob(stageUser,activityVO,mktActivityPOWithBLOBs,mktActivityId);
                //创建任务调度任务结束时间
                jobUtil.addJobEndTime(stageUser,activityVO,mktActivityPOWithBLOBs,mktActivityId);
            }
        }else{
            //查询结果如果不需要审核审核状态为已审核
            mktActivityPOWithBLOBs.setCheckStatus(CheckStatusEnum.CHECK_STATUS_APPROVED.getCode());
            //getStartTime 开始时间>当前时间增加job
            if(null !=activityVO.getStartTime() && new Date().before(activityVO.getStartTime())){
                //活动状态设置为待执行
                mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_PENDING.getCode());
                //新增活动主表
                mktActivityPOWithBLOBs.setCreateDate(new Date());
                mktActivityPOWithBLOBs.setCreateUserId(stageUser.getSysAccountId());
                mktActivityPOWithBLOBs.setCreateUserName(stageUser.getName());
                mktActivityPOMapper.insertSelective(mktActivityPOWithBLOBs);
                //获取新增后数据id
                Long mktActivityId = mktActivityPOWithBLOBs.getMktActivityId();
                //创建任务调度任务开始时间
                jobUtil.addJob(stageUser,activityVO,mktActivityPOWithBLOBs,mktActivityId);
                //创建任务调度任务结束时间
                jobUtil.addJobEndTime(stageUser,activityVO,mktActivityPOWithBLOBs,mktActivityId);
            }else{
                //活动状态设置为执行中
                mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
                //新增活动主表
                mktActivityPOWithBLOBs.setCreateDate(new Date());
                mktActivityPOWithBLOBs.setCreateUserId(stageUser.getSysAccountId());
                mktActivityPOWithBLOBs.setCreateUserName(stageUser.getName());
                mktActivityPOMapper.insertSelective(mktActivityPOWithBLOBs);
                //发送模板消息和短信消息TODO

            }
        }
        //获取新增后数据id
        Long mktActivityId = mktActivityPOWithBLOBs.getMktActivityId();

        //新增开卡活动表
        MktActivityRegisterPO mktActivityRegisterPO = new MktActivityRegisterPO();
        BeanUtils.copyProperties(mktActivityPOWithBLOBs,mktActivityRegisterPO);
        mktActivityRegisterPO.setMktActivityId(mktActivityId);
        mktActivityRegisterPOMapper.insertSelective(mktActivityRegisterPO);

        //新增券奖励
        List<String> couponCodeList = bo.getCouponCodeList();
        if(!CollectionUtils.isEmpty(couponCodeList)){
            for(String couponCode : couponCodeList){
                MktCouponPO mktCouponPO = new MktCouponPO();
                BeanUtils.copyProperties(mktActivityPOWithBLOBs,mktCouponPO);
                mktCouponPO.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode());
                mktCouponPO.setBizId(mktActivityId);
                mktCouponPO.setCouponCode(couponCode);
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

        //结束
        return responseData;
    }


    /**
     * 执行活动
     * @param mktActivityId
     * @return
     */
    @Override
    public ResponseData<Integer> executeActivity(Long mktActivityId) {
        return null;
    }
}
