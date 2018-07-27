package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.centerstageservice.models.po.SysCheckConfigPo;
import com.bizvane.centerstageservice.models.vo.SysCheckConfigVo;
import com.bizvane.centerstageservice.rpc.SysCheckConfigServiceRpc;
import com.bizvane.mktcenterservice.interfaces.ActivityBirthdayService;
import com.bizvane.mktcenterservice.models.bo.ActivityBO;
import com.bizvane.mktcenterservice.models.po.*;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.models.vo.MessageVO;
import com.bizvane.mktcenterserviceimpl.common.constants.JobHandlerConstants;
import com.bizvane.mktcenterserviceimpl.common.enums.ActivityStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.ActivityTypeEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.BusinessTypeEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.CheckStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.job.XxlJobConfig;
import com.bizvane.mktcenterserviceimpl.common.utils.DateUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.JobUtil;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityBirthdayPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktCouponPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktMessagePOMapper;
import com.bizvane.utils.commonutils.PageForm;
import com.bizvane.utils.enumutils.JobEnum;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.jobutils.JobClient;
import com.bizvane.utils.jobutils.XxlJobInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author chen.li
 * @date on 2018/7/13 18:49
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@Service
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
    /**
     * 查询生日活动列表
     * @param vo
     * @param pageForm
     * @return
     */
    @Override
    public ResponseData<ActivityVO> getActivityBirthdayList(ActivityVO vo, PageForm pageForm) {
        ResponseData responseData = new ResponseData();
        PageHelper.startPage(pageForm.getPageNumber(),pageForm.getPageSize());
        List<ActivityVO> activityBirthdayList = mktActivityBirthdayPOMapper.getActivityBirthdayList(vo);
        PageInfo<ActivityVO> pageInfo = new PageInfo<>(activityBirthdayList);
        responseData.setData(pageInfo);
        return responseData;
    }

    /**
     * 创建活动
     * @param bo
     * @param stageUser
     * @return
     */
    @Override
    public ResponseData<Integer> addActivityBirthday(ActivityBO bo, SysAccountPO stageUser) {
        //返回对象
        ResponseData responseData = new ResponseData();
        //得到大实体类
        ActivityVO activityVO = bo.getActivityVO();
        //暂时用uuid生成活动编号9
        String activityCode = "AC"+ UUID.randomUUID().toString().replaceAll("-", "");
        activityVO.setActivityCode(activityCode);
        //增加活动类型是消费活动
        activityVO.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_BIRTHDAY.getCode());
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = new MktActivityPOWithBLOBs();
        BeanUtils.copyProperties(activityVO,mktActivityPOWithBLOBs);

        //查询判断长期活动同一会员等级是否有重复
        if(1 == bo.getActivityVO().getLongTerm()){
            ActivityVO vo = new ActivityVO();
            vo.setMbrLevelCode(bo.getActivityVO().getMbrLevelCode());
            vo.setLongTerm(bo.getActivityVO().getLongTerm());
            List<ActivityVO> registerList = mktActivityBirthdayPOMapper.getActivityBirthdayList(vo);
            if(!CollectionUtils.isEmpty(registerList)){
                responseData.setCode(SysResponseEnum.FAILED.getCode());
                responseData.setMessage("已存在同一类型的长期活动!");
                return responseData;
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
            if(1 != bo.getActivityVO().getLongTerm() && new Date().before(activityVO.getStartTime())){
                //创建任务调度任务开始时间
                jobUtil.addJob(stageUser,activityVO,mktActivityPOWithBLOBs,activityCode);
                //创建任务调度任务结束时间
                jobUtil.addJobEndTime(stageUser,activityVO,mktActivityPOWithBLOBs,activityCode);
            }
        }else{
            //查询结果如果不需要审核审核状态为已审核
            mktActivityPOWithBLOBs.setCheckStatus(CheckStatusEnum.CHECK_STATUS_APPROVED.getCode());
            //getStartTime 开始时间>当前时间增加job
            if(1 != bo.getActivityVO().getLongTerm() && new Date().before(activityVO.getStartTime())){
                //活动状态设置为待执行
                mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_PENDING.getCode());
                //创建任务调度任务开始时间
                jobUtil.addJob(stageUser,activityVO,mktActivityPOWithBLOBs,activityCode);
                //创建任务调度任务结束时间
                jobUtil.addJobEndTime(stageUser,activityVO,mktActivityPOWithBLOBs,activityCode);
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


        //新增生日活动表
        MktActivityBirthdayPO mktActivityBirthdayPO = new MktActivityBirthdayPO();
        BeanUtils.copyProperties(mktActivityPOWithBLOBs,mktActivityBirthdayPO);
        mktActivityBirthdayPO.setMktActivityId(mktActivityId);
        mktActivityBirthdayPOMapper.insertSelective(mktActivityBirthdayPO);

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
     * 查询生日活动详情
     * @param mktActivityId
     * @return
     */
    @Override
    public ResponseData<List<ActivityVO>> selectActivityBirthdayById(Long mktActivityId) {
        ResponseData responseData = new ResponseData();
        ActivityVO vo= new ActivityVO();
        vo.setMktActivityId(mktActivityId);
        List<ActivityVO> registerList = mktActivityBirthdayPOMapper.getActivityBirthdayList(vo);
        responseData.setData(registerList);
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
    public ResponseData<Integer> checkActivityBirthday(MktActivityPOWithBLOBs bs, SysAccountPO sysAccountPO) {
        ResponseData responseData = new ResponseData();
        bs.setModifiedUserId(sysAccountPO.getSysAccountId());
        bs.setModifiedDate(new Date());
        bs.setModifiedUserName(sysAccountPO.getName());
        //根据id查询出审核活动的详细信息
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = mktActivityPOMapper.selectByPrimaryKey(bs.getMktActivityId());
        //判断是审核通过还是审核驳回
        if(bs.getCheckStatus()==CheckStatusEnum.CHECK_STATUS_APPROVED.getCode()){
            //活动开始时间<当前时间<活动结束时间  或者长期活动 也就是StartTime=null
            if(1== mktActivityPOWithBLOBs.getLongTerm() ||(new Date().after(mktActivityPOWithBLOBs.getStartTime()) && new Date().before(mktActivityPOWithBLOBs.getEndTime()))){
                //将活动状态变更为执行中 并且发送消息
                bs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
                int i = mktActivityPOMapper.updateByPrimaryKeySelective(bs);
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

        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }
}
