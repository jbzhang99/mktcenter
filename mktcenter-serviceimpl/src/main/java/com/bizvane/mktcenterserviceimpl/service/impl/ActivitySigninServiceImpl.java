package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.mktcenterservice.interfaces.ActivitySigninService;
import com.bizvane.mktcenterservice.models.bo.ActivityBO;
import com.bizvane.mktcenterservice.models.po.MktActivityOrderPOWithBLOBs;
import com.bizvane.mktcenterservice.models.po.MktActivityPOWithBLOBs;
import com.bizvane.mktcenterservice.models.po.MktActivitySignin;
import com.bizvane.mktcenterservice.models.po.MktMessagePO;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.models.vo.MessageVO;
import com.bizvane.mktcenterserviceimpl.common.constants.JobHandlerConstants;
import com.bizvane.mktcenterserviceimpl.common.enums.ActivityStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.BusinessTypeEnum;
import com.bizvane.mktcenterserviceimpl.common.job.XxlJobConfig;
import com.bizvane.mktcenterserviceimpl.common.utils.DateUtil;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivitySigninMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktMessagePOMapper;
import com.bizvane.utils.commonutils.PageForm;
import com.bizvane.utils.enumutils.JobEnum;
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

/**
 * @author chen.li
 * @date on 2018/7/13 18:52
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@Service
public class ActivitySigninServiceImpl implements ActivitySigninService {

    @Autowired
    private MktActivitySigninMapper mktActivitySigninMapper;
    @Autowired
    private MktActivityPOMapper mktActivityPOMapper;
    @Autowired
    private XxlJobConfig xxlJobConfig;
    @Autowired
    private JobClient jobClient;
    @Autowired
    private MktMessagePOMapper mktMessagePOMapper;
    /**
     * 查询签到活动列表
     * @param vo
     * @param pageForm
     * @return
     */
    @Override
    public ResponseData<ActivityVO> getActivitySigninList(ActivityVO vo, PageForm pageForm) {
        ResponseData responseData = new ResponseData();
        PageHelper.startPage(pageForm.getPageNumber(),pageForm.getPageSize());
        List<ActivityVO> activitySigninList = mktActivitySigninMapper.getActivitySigninList(vo);
        PageInfo<ActivityVO> pageInfo = new PageInfo<>(activitySigninList);
        responseData.setData(pageInfo);
        return responseData;
    }

    /**
     * 创建会员签到积分活动
     * @param bo
     * @param stageUser
     * @return
     */
    @Override
    public ResponseData<Integer> addActivitySignin(ActivityBO bo, SysAccountPO stageUser) {
        //返回对象
        ResponseData responseData = new ResponseData();

        ActivityVO activityVO = bo.getActivityVO();

        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = new MktActivityPOWithBLOBs();
        BeanUtils.copyProperties(activityVO,mktActivityPOWithBLOBs);

        //查询审核配置，是否需要审核


        //如果活动时间在当前时间之后，需要启用job调度
        if(new Date().before(activityVO.getStartTime())){
            //活动状态设置为待执行
            mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_PENDING.getCode());
        }else{
            mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
        }

        //新增活动主表
        mktActivityPOWithBLOBs.setCreateDate(new Date());
        mktActivityPOWithBLOBs.setCreateUserId(stageUser.getSysAccountId());
        mktActivityPOWithBLOBs.setCreateUserName(stageUser.getName());
        mktActivityPOMapper.insertSelective(mktActivityPOWithBLOBs);

        //获取新增后数据id
        Long mktActivityId = mktActivityPOWithBLOBs.getMktActivityId();

        //根据上面的状态添加调度，参数是活动id
        if(ActivityStatusEnum.ACTIVITY_STATUS_PENDING.getCode() == mktActivityPOWithBLOBs.getActivityStatus()){
            //活动状态设置为待执行
            mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_PENDING.getCode());
            //构建job对象
            XxlJobInfo xxlJobInfo = new XxlJobInfo();
            //设置appName
            xxlJobInfo.setAppName(xxlJobConfig.getAppName());
            //设置路由策略
            xxlJobInfo.setExecutorRouteStrategy(JobEnum.EXECUTOR_ROUTE_STRATEGY_FIRST.getValue());
            //设置job定时器
            xxlJobInfo.setJobCron(DateUtil.getCronExpression(activityVO.getStartTime()));
            //设置运行模式
            xxlJobInfo.setGlueType(JobEnum.GLUE_TYPE_BEAN.getValue());
            //设置job处理器
            xxlJobInfo.setExecutorHandler(JobHandlerConstants.activity);
            //设置job描述
            xxlJobInfo.setJobDesc(activityVO.getActivityInfo());
            //设置执行参数
            xxlJobInfo.setExecutorParam(mktActivityId.toString());
            //设置阻塞处理策略
            xxlJobInfo.setExecutorBlockStrategy(JobEnum.EXECUTOR_BLOCK_SERIAL_EXECUTION.getValue());
            //设置失败处理策略
            xxlJobInfo.setExecutorFailStrategy(JobEnum.EXECUTOR_FAIL_STRATEGY_NULL.getValue());
            //设置负责人
            xxlJobInfo.setAuthor(stageUser.getName());
            //添加job
            jobClient.addJob(xxlJobInfo);
        }

        //新增会员签到活动表
        MktActivitySignin mktActivitySignin = new MktActivitySignin();
        BeanUtils.copyProperties(mktActivityPOWithBLOBs,mktActivitySignin);
        mktActivitySignin.setMktActivityId(mktActivityId);
        mktActivitySigninMapper.insertSelective(mktActivitySignin);
        //TODO

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
}
