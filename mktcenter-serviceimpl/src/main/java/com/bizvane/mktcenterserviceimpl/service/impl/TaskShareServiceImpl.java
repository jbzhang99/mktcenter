package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.centerstageservice.models.po.SysCheckConfigPo;
import com.bizvane.centerstageservice.models.po.SysCheckPo;
import com.bizvane.centerstageservice.rpc.SysCheckConfigServiceRpc;
import com.bizvane.centerstageservice.rpc.SysCheckServiceRpc;
import com.bizvane.couponfacade.interfaces.CouponDefinitionServiceFeign;
import com.bizvane.couponfacade.interfaces.CouponQueryServiceFeign;
import com.bizvane.couponfacade.interfaces.SendCouponServiceFeign;
import com.bizvane.couponfacade.models.po.CouponDefinitionPO;
import com.bizvane.couponfacade.models.po.CouponEntityPO;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.service.api.IntegralRecordApiService;
import com.bizvane.mktcenterservice.interfaces.TaskShareService;
import com.bizvane.mktcenterservice.models.bo.AwardBO;
import com.bizvane.mktcenterservice.models.bo.TaskBO;
import com.bizvane.mktcenterservice.models.po.*;
import com.bizvane.mktcenterservice.models.vo.*;
import com.bizvane.mktcenterserviceimpl.common.award.Award;
import com.bizvane.mktcenterserviceimpl.common.constants.ResponseConstants;
import com.bizvane.mktcenterserviceimpl.common.enums.*;
import com.bizvane.mktcenterserviceimpl.common.utils.CodeUtil;
import com.bizvane.mktcenterserviceimpl.common.job.JobUtil;
import com.bizvane.mktcenterserviceimpl.mappers.*;
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

import java.util.*;

/**
 * @author gengxiaoyu
 * @date on 2018/7/16 14:14
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@Service
public class TaskShareServiceImpl implements TaskShareService {

    @Autowired
    private MktTaskSharePOMapper mktTaskSharePOMapper;

    @Autowired
    private SysCheckConfigServiceRpc sysCheckConfigServiceRpc;

    @Autowired
    private SysCheckServiceRpc sysCheckServiceRpc;

    @Autowired
    private JobUtil jobUtil;

    @Autowired
    private MktTaskPOMapper mktTaskPOMapper;

    @Autowired
    private MktCouponPOMapper mktCouponPOMapper;

    @Autowired
    private MktMessagePOMapper mktMessagePOMapper;

    @Autowired
    private IntegralRecordApiService integralRecordApiService;

    @Autowired
    private SendCouponServiceFeign sendCouponServiceFeign;

    @Autowired
    private MktTaskRecordPOMapper mktTaskRecordPOMapper;

    @Autowired
    private CouponQueryServiceFeign couponQueryService;

    @Autowired
    private Award award;

    @Autowired
    private CouponDefinitionServiceFeign couponDefinitionServiceFeign;

    @Autowired
    private JobClient jobClient;


    /**
     * 获取任务列表
     * @param vo
     * @param pageForm
     * @return
     */

    @Transactional
    @Override
    public ResponseData<PageInfo<TaskVO>> getTaskList(TaskVO vo, PageForm pageForm) {
        ResponseData responseData = new ResponseData();

        try {

            PageHelper.startPage(pageForm.getPageNumber(),pageForm.getPageSize());

            List<TaskVO> activityRegisterList = mktTaskSharePOMapper.getTaskList(vo);
            PageInfo<TaskVO> pageInfo = new PageInfo<>(activityRegisterList);
            responseData.setData(pageInfo);
            responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
            responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        }catch(Exception e){
            e.printStackTrace();
            responseData.setMessage(SysResponseEnum.FAILED.getMessage());
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            return responseData;
        }


        return responseData;
    }

    /**
     * 添加微信分享任务
     * @param bo
     * @param stageUser
     * @return
     */
    @Transactional
    @Override
    public ResponseData<Integer> addTask(TaskBO bo, SysAccountPO stageUser) {
        ResponseData responseData = new ResponseData();
        try {
            
            //创建任务对象
            TaskVO taskVO = bo.getTaskVO();
            //需要返回的对象

            MktTaskPOWithBLOBs mktTaskPOWithBLOBs = new MktTaskPOWithBLOBs();
            String taskCode = CodeUtil.getTaskCode();
            //将任务编号添加进vo对象
            taskVO.setTaskCode(taskCode);
            //添加任务类型为微信分享  或者任务类型是前端传回来的？
            taskVO.setTaskType(TaskTypeEnum.TASK_TYPE_SHARE.getCode());

            //无需判断分享任务是否重复,分享任务可以有多个

            //判断任务是否需要审核
            // TODO: 2018/8/8 任务审核
            //SysCheckConfigVo sysCheckConfigVo = new SysCheckConfigVo();
            SysCheckConfigPo sysCheckConfigPo = new SysCheckConfigPo();
            sysCheckConfigPo.setSysBrandId(taskVO.getSysBrandId());
            //根据品牌id和任务/活动/发券来判断是否需要审核
            sysCheckConfigPo.setFunctionName("会员任务");
            sysCheckConfigPo.setFunctionCode("C0003");//会员任务编号是C0003吗？？？？？
            //1:需要审核 0:不需要
          // ResponseData<Integer> data = sysCheckConfigServiceRpc.ifCheckConfig(sysCheckConfigPo);
            Integer i = 3 ;/*data.getData();*/


            //会员任务需要审核  todo记得把i=1改回来
            if(i==1){
                //新增审核单  任务状态为：待审核
                taskVO.setCheckStatus(CheckStatusEnum.CHECK_STATUS_PENDING.getCode());


                //新增一条审核单
                //functioncode和functionname分别指的是什么？
                SysCheckPo sysCheckPo = new SysCheckPo();
                sysCheckPo.setSysBrandId(taskVO.getSysBrandId());
                sysCheckPo.setFunctionCode("C0003");//写成枚举？
                sysCheckPo.setCreateDate(new Date());
                sysCheckPo.setCreateUserName(stageUser.getName());
                sysCheckPo.setCreateUserId(stageUser.getSysAccountId());
                sysCheckPo.setSysBrandId(taskVO.getSysBrandId());
                sysCheckPo.setCheckStatus(CheckStatusEnum.CHECK_STATUS_PENDING.getCode());
                sysCheckPo.setBusinessType(BusinessTypeEnum.ACTIVITY_TYPE_TASK.getCode());
                sysCheckPo.setBusinessCode(taskVO.getTaskCode());
                sysCheckPo.setBusinessId(taskVO.getMktTaskId());
                sysCheckServiceRpc.addCheck(sysCheckPo);
            

                //任务时间滞后
                if (taskVO.getStartTime().after(new Date())){
                    //创建调度job  任务状态为待执行
                    //创建job开始时间
                    jobUtil.addStartTaskJob(stageUser,mktTaskPOWithBLOBs);
                    //创建job结束时间
                    jobUtil.addEndTaskJob(stageUser,mktTaskPOWithBLOBs);
                /*//将任务状态设置为待执行,无需手动设置
                taskVO.setTaskStatus(TaskStatusEnum.TASK_STATUS_PENDING.getCode());*/
                }//任务时间不滞后
                else{
                    taskVO.setTaskStatus(TaskStatusEnum.TASK_STATUS_PENDING.getCode());
                }

            }//如果不需要审核
            else{
                //任务时间滞后
                if(taskVO.getStartTime().after(new Date())){
                    //添加job任务开始时间
                    //jobUtil
                    //添加job任务结束时间
                    //jobUtil
                    taskVO.setCheckStatus(CheckStatusEnum.CHECK_STATUS_APPROVED.getCode());
                    taskVO.setTaskStatus(TaskStatusEnum.TASK_STATUS_PENDING.getCode());
                }
                //任务时间不滞后
                taskVO.setCheckStatus(CheckStatusEnum.CHECK_STATUS_APPROVED.getCode());
                taskVO.setTaskStatus(TaskStatusEnum.TASK_STATUS_EXECUTING.getCode());
            }

            //将数据插入任务主表
            taskVO.setCreateDate(new Date());
            taskVO.setCreateUserName(stageUser.getName());
            taskVO.setCreateUserId(stageUser.getSysAccountId());

            BeanUtils.copyProperties(taskVO,mktTaskPOWithBLOBs);
            mktTaskPOMapper.insert(mktTaskPOWithBLOBs);
            Long taskVOId = mktTaskPOWithBLOBs.getMktTaskId();

            //将数据插入微信分享任务表
            MktTaskSharePO mktTaskSharePO = new MktTaskSharePO();
            mktTaskSharePO.setCreateDate(new Date());
            mktTaskSharePO.setCreateUserId(stageUser.getSysAccountId());
            mktTaskSharePO.setCreateUserName(stageUser.getName());
            mktTaskSharePO.setMktTaskId(taskVOId);
            mktTaskSharePO.setShareTimes(taskVO.getShareTimes());
            mktTaskSharePO.setShareUrl(taskVO.getShareUrl());
            mktTaskSharePO.setShareUrlType(taskVO.getShareUrlType());

            mktTaskSharePOMapper.insertSelective(mktTaskSharePO);


            //需要发奖励
            if (!CollectionUtils.isEmpty(bo.getMktCouponPOList())){
                for (MktCouponPO mktCouponPO:bo.getMktCouponPOList()){
                    //增加券
                    MktCouponPO mktCouponPO1 = new MktCouponPO();
                    mktCouponPO1.setCreateUserName(stageUser.getName());
                    mktCouponPO1.setCreateUserId(stageUser.getSysAccountId());
                    mktCouponPO1.setCreateDate(new Date());
                    mktCouponPO1.setBizId(taskVOId);
                    mktCouponPO1.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_TASK.getCode());
                    mktCouponPO1.setCouponName(mktCouponPO.getCouponName());
                    mktCouponPO1.setCouponDefinitionId(mktCouponPO.getCouponDefinitionId());//是id还是code
                    mktCouponPOMapper.insertSelective(mktCouponPO1);

                }
            }

            //需要发消息

            if(!CollectionUtils.isEmpty(bo.getMessagePOList())){
                for (MktMessagePO messagePO:bo.getMessagePOList()){


                    MktMessagePO mktMessagePO = new MktMessagePO();
                    BeanUtils.copyProperties(messagePO,mktMessagePO);
                    mktMessagePO.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_TASK.getCode());
                    mktMessagePO.setCreateDate(new Date());
                    BeanUtils.copyProperties(mktTaskSharePO,mktMessagePO);

                    mktMessagePO.setBizId(taskVOId);
                    mktMessagePOMapper.insertSelective(mktMessagePO);
                }
            }

            responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
            responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        }catch(Exception e){
            e.printStackTrace();
            responseData.setMessage(SysResponseEnum.FAILED.getMessage());
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            return responseData;
        }

        return responseData;
    }




    /**
     * 修改任务
     * @param bo
     * @param stageUser
     * @return
     */
    @Transactional
    @Override
    public ResponseData<Integer> updateTask(TaskBO bo, SysAccountPO stageUser) {

        ResponseData responseData = new ResponseData();

        try {

            TaskVO taskVO = bo.getTaskVO();
            //接收需要修改的任务vo对象判断是否状态为待审核
            //状态为待审核或者被驳回时才可修改,其他状态为不可修改
            if (taskVO.getCheckStatus()!=CheckStatusEnum.CHECK_STATUS_PENDING.getCode()&&taskVO.getCheckStatus()!=CheckStatusEnum.CHECK_STATUS_REJECTED.getCode()){
                responseData.setCode(SysResponseEnum.FAILED.getCode());
                responseData.setMessage("该任务不可修改");
            }


            //如果状态为已驳回，需新增审核单
            if(taskVO.getCheckStatus()==CheckStatusEnum.CHECK_STATUS_REJECTED.getCode()){
                SysCheckPo sysCheckPo = new SysCheckPo();
                sysCheckPo.setSysBrandId(taskVO.getSysBrandId());
                sysCheckPo.setFunctionCode("C0003");//写成枚举？
                sysCheckPo.setCreateDate(new Date());
                sysCheckPo.setCreateUserName(stageUser.getName());
                sysCheckPo.setCreateUserId(stageUser.getSysAccountId());
                sysCheckPo.setSysBrandId(taskVO.getSysBrandId());
                sysCheckPo.setCheckStatus(CheckStatusEnum.CHECK_STATUS_PENDING.getCode());
                sysCheckPo.setBusinessType(BusinessTypeEnum.ACTIVITY_TYPE_TASK.getCode());
                sysCheckServiceRpc.addCheck(sysCheckPo);

            }
            //判断任务开始时间是否修改
            //根据tskid查询出原任务开始时间
            MktTaskPO mktTaskOldPO = mktTaskPOMapper.selectByPrimaryKey(taskVO.getMktTaskId());
            //与修改后的时间进行对比,若修改过则i=1,未修改则i=0
            int i = 0;
            if (mktTaskOldPO.getStartTime()!=taskVO.getStartTime()){
                i++;
            }
            //修改任务状态为待审核和待执行
            taskVO.setCheckStatus(CheckStatusEnum.CHECK_STATUS_PENDING.getCode());
            taskVO.setTaskStatus(TaskStatusEnum.TASK_STATUS_PENDING.getCode());
            //修改任务其他信息
            taskVO.setModifiedDate(new Date());
            taskVO.setModifiedUserId(stageUser.getSysAccountId());
            taskVO.setModifiedUserName(stageUser.getName());

            //更新任务主表
            MktTaskPOWithBLOBs mktTaskPOWithBLOBs = new MktTaskPOWithBLOBs();
            BeanUtils.copyProperties(taskVO,mktTaskPOWithBLOBs);
            mktTaskPOMapper.updateByPrimaryKeySelective(mktTaskPOWithBLOBs);

            //更新微信分享任务表

            MktTaskSharePO mktTaskSharePO = new MktTaskSharePO();
            mktTaskSharePO.setModifiedDate(new Date());
            mktTaskSharePO.setModifiedUserId(stageUser.getSysAccountId());
            mktTaskSharePO.setModifiedUserName(stageUser.getName());
            mktTaskSharePO.setShareTimes(taskVO.getShareTimes());
            mktTaskSharePO.setShareUrl(taskVO.getShareUrl());
            mktTaskSharePO.setShareUrlType(taskVO.getShareUrlType());

            mktTaskSharePOMapper.updateByPrimaryKeySelective(mktTaskSharePO);

            //若任务时间修改
            if (i>0){
                //原任务时间已开始？
                if (mktTaskOldPO.getStartTime().before(new Date())){
                    //新任务时间滞后？
                    if (taskVO.getStartTime().after(new Date())){

                        //将原job删除  防止冲突
                       /* XxlJobInfo xxlJobInfo = new XxlJobInfo();
                        xxlJobInfo.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_TASK.getCode());
                        xxlJobInfo.setBizCode(taskVO.getTaskCode());
                        jobClient.removeByBiz(xxlJobInfo);

                        //新建job调度开始时间
                        jobUtil.addStartTaskJob(stageUser,mktTaskPOWithBLOBs);
                        //结束时间
                        jobUtil.addEndTaskJob(stageUser,mktTaskPOWithBLOBs);*/
                    }
                }//原任务时间未开始
                else{
                    //新任务时间滞后？
                    if (taskVO.getStartTime().after(new Date())){
                        //调整job调度开始时间

                        //将原job删除  防止冲突
                        /*XxlJobInfo xxlJobInfo = new XxlJobInfo();
                        xxlJobInfo.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_TASK.getCode());
                        xxlJobInfo.setBizCode(taskVO.getTaskCode());
                        jobClient.removeByBiz(xxlJobInfo);

                        jobUtil.addStartTaskJob(stageUser,mktTaskPOWithBLOBs);
                        jobUtil.addEndTaskJob(stageUser,mktTaskPOWithBLOBs);*/
                    }

                }
            }

            //修改奖励
            //修改券  修改前后券的数量可能不一样  so无法直接进行修改

            MktCouponPO mktCouponPO = new MktCouponPO();
            mktCouponPO.setValid(false);
            MktCouponPOExample mktCouponPOExample = new MktCouponPOExample();
            MktCouponPOExample.Criteria criteria = mktCouponPOExample.createCriteria();
            criteria.andBizIdEqualTo(taskVO.getMktTaskId());


            mktCouponPOMapper.updateByExampleSelective(mktCouponPO,mktCouponPOExample);
            List<MktCouponPO> mktCouponPOList = bo.getMktCouponPOList();
            if (!CollectionUtils.isEmpty(mktCouponPOList)){
                for (MktCouponPO mktCouponPO1:mktCouponPOList){
                    MktCouponPO mktCouponPO2 = new MktCouponPO();
                    mktCouponPO2.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_TASK.getCode());
                    mktCouponPO2.setCouponName(mktCouponPO1.getCouponName());
                    mktCouponPO2.setCouponDefinitionId(mktCouponPO1.getCouponDefinitionId());
                    BeanUtils.copyProperties(taskVO,mktCouponPO2);
                    mktCouponPOMapper.insertSelective(mktCouponPO2);
                }
            }

            //修改消息
            MktMessagePO record = new MktMessagePO();
            record.setValid(false);
            MktMessagePOExample mktMessagePOExample = new MktMessagePOExample();
            MktMessagePOExample.Criteria criteria1 = mktMessagePOExample.createCriteria();
            criteria1.andBizIdEqualTo(taskVO.getMktTaskId());
            mktMessagePOMapper.updateByExampleSelective(record,mktMessagePOExample);


            //添加新消息
            List<MktMessagePO> mktMessagePOList = bo.getMessagePOList();

            if(!CollectionUtils.isEmpty(mktMessagePOList)){
                for(MktMessagePO messagePO:mktMessagePOList){
                    MktMessagePO mktMessagePO = new MktMessagePO();
                    mktMessagePO.setMsgContent(messagePO.getMsgContent());
                    mktMessagePO.setCreateDate(new Date());
                    mktMessagePO.setBizId(taskVO.getMktTaskId());
                    mktMessagePO.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_TASK.getCode());
                    mktMessagePO.setCreateUserId(stageUser.getSysAccountId());
                    mktMessagePO.setCreateUserName(stageUser.getName());
                    mktMessagePO.setMsgType(messagePO.getMsgType());
                    mktMessagePO.setSendTime(messagePO.getSendTime());
                    //消息编号？模板？
                    mktMessagePOMapper.insertSelective(mktMessagePO);
                }

            }

            //消息时间滞后？todo


            responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
            responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        }catch(Exception e){
            e.printStackTrace();
            responseData.setMessage(SysResponseEnum.FAILED.getMessage());
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            return responseData;
        }



        return responseData;
    }

    /**
     * 查询任务详情
     * @param mktTaskId
     * @return
     */

    @Override
    public ResponseData<TaskBO> selectTaskById(Long mktTaskId) {
        ResponseData responseData = new ResponseData();

        try {

            TaskBO taskBO = new TaskBO();
            TaskVO taskVO = new TaskVO();
            taskVO.setMktTaskId(mktTaskId);
            //联表查询查询任务详情
            List<TaskVO> taskVOList = mktTaskSharePOMapper.getTaskList(taskVO);
            TaskVO taskVo = taskVOList.get(0);

            //查询券信息
            MktCouponPOExample example = new MktCouponPOExample();
            example.createCriteria().andValidEqualTo(true).andBizIdEqualTo(mktTaskId);
            List<MktCouponPO> mktCouponPOList = mktCouponPOMapper.selectByExample(example);

            //查询消息
            MktMessagePOExample mktMessagePOExample = new MktMessagePOExample();
            mktMessagePOExample.createCriteria().andValidEqualTo(true).andBizIdEqualTo(mktTaskId);
            List<MktMessagePO> mktMessagePOList = mktMessagePOMapper.selectByExample(mktMessagePOExample);


            List<CouponDefinitionPO> couponDefinitionPOS = new ArrayList<>();
       /* //查询券定义 todo
        for (MktCouponPO mktCouponPO:mktCouponPOList){
            Long couponDefinitionId = mktCouponPO.getCouponDefinitionId();

            ResponseData<CouponDefinitionPO> coupon = couponDefinitionServiceFeign.findRpc(couponDefinitionId);
            CouponDefinitionPO couponDefinitionPO = coupon.getData();
            couponDefinitionPOS.add(couponDefinitionPO);
        }*/



            if (taskVo!=null){
                taskBO.setTaskVO(taskVo);
            }
            if (!CollectionUtils.isEmpty(mktCouponPOList)){
                taskBO.setMktCouponPOList(mktCouponPOList);
            }
            if (!CollectionUtils.isEmpty(mktMessagePOList)){
                taskBO.setMessagePOList(mktMessagePOList);
            }
            if (!CollectionUtils.isEmpty(couponDefinitionPOS)){
                taskBO.setCouponDefinitionPOList(couponDefinitionPOS);
            }


            responseData.setData(taskBO);
            responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
            responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        }catch(Exception e){
            e.printStackTrace();
            responseData.setMessage(SysResponseEnum.FAILED.getMessage());
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            return responseData;
        }

        return responseData;
    }

    /**
     * 执行任务
     * @param vo 或者传回的是任务编号？
     * @param memberInfoModel 或者传回的是会员编号？
     * @return
     */
    @Transactional
    @Override
    public ResponseData executeTask(TaskVO vo, MemberInfoModel memberInfoModel) {
        ResponseData responseData = new ResponseData();


        try {

//一、券

            //1.从coupon表中查出该业务单号对应的券的id（可能多张，所以遍历添加）
            MktCouponPOExample mktCouponPOExample = new MktCouponPOExample();
            MktCouponPOExample.Criteria criteria = mktCouponPOExample.createCriteria();
            criteria.andBizIdEqualTo(vo.getMktTaskId()).andBizTypeEqualTo(BusinessTypeEnum.ACTIVITY_TYPE_TASK.getCode()).andValidEqualTo(true);

            List<MktCouponPO> mktCouponPOList = mktCouponPOMapper.selectByExample(mktCouponPOExample);

            //2.创建AwardBo对象 添加通用信息 并遍历该业务的券信息添加券的信息
            AwardBO bo = new AwardBO();
            bo.setMemberCode(memberInfoModel.getMemberCode());
            bo.setMemberName(memberInfoModel.getName());
            bo.setMktSmartType(MktSmartTypeEnum.SMART_TYPE_COUPON.getCode());
            bo.setBusinessWay(BusinessTypeEnum.ACTIVITY_TYPE_TASK.getMessage());
            bo.setSendBussienId(vo.getMktTaskId());
            for (MktCouponPO mktCouponPO:mktCouponPOList){
                Long couponDefId = mktCouponPO.getBizId();
                bo.setCouponDefinitionId(couponDefId);
                //award.execute(bo);
            }

            //二、积分

            AwardBO bo2 = new AwardBO();
            bo2.setChangeBills(UUID.randomUUID().toString().replaceAll("-",""));//todo 暂时用uuid生成
            bo2.setBusinessWay(BusinessTypeEnum.ACTIVITY_TYPE_TASK.getMessage());
            bo2.setSendBussienId(vo.getMktTaskId());
            bo2.setMemberCode(memberInfoModel.getMemberCode());
            bo2.setMemberName(memberInfoModel.getName());
            bo2.setMktSmartType(MktSmartTypeEnum.SMART_TYPE_INTEGRAL.getCode());
            bo2.setChangeIntegral(vo.getPoints());
            //award.execute(bo2);



            responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
            responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        }catch(Exception e){
            e.printStackTrace();
            responseData.setMessage(SysResponseEnum.FAILED.getMessage());
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            return responseData;
        }


        return responseData;
    }

    /**
     * 添加任务记录
     * @param vo
     * @param memberInfoModel
     * @return
     */
    @Transactional
    @Override
    public ResponseData addToRecord(TaskVO vo, MemberInfoModel memberInfoModel){
        ResponseData responseData = new ResponseData();

        try {

            //将完成任务的信息添加进taskrecord表中
            MktTaskPO mktTaskPO = mktTaskPOMapper.selectByPrimaryKey(vo.getMktTaskId());


            MktTaskRecordPO mktTaskRecordPO = new MktTaskRecordPO();

            mktTaskRecordPO.setTaskType(TaskTypeEnum.TASK_TYPE_SHARE.getCode());
            mktTaskRecordPO.setTaskId(vo.getMktTaskId());
            mktTaskRecordPO.setMemberCode(memberInfoModel.getMemberCode());
            mktTaskRecordPO.setPoints(vo.getPoints());//奖励积分是不是也该去掉？？
            mktTaskRecordPO.setParticipateDate(new Date());
            BeanUtils.copyProperties(mktTaskPO,mktTaskRecordPO);
            //是否奖励过 奖励次数？
            mktTaskRecordPOMapper.insertSelective(mktTaskRecordPO);


            responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
            responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        }catch(Exception e){
            e.printStackTrace();
            responseData.setMessage(SysResponseEnum.FAILED.getMessage());
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            return responseData;
        }


        return responseData;
    }

    /**
     * 效果分析
     * @param date1
     * @param date2
     * @param stageUser
     * @param taskName
     * @param pageForm
     * @return
     */
    @Transactional
    @Override
    public ResponseData<TaskRecordVO> getTaskShareRecordByTime(Date date1, Date date2, SysAccountPO stageUser,String taskName,PageForm pageForm){
        ResponseData responseData = new ResponseData();

        try {


            TaskRecordVO taskRecordVO = new TaskRecordVO();


            //1.从任务主表中根据brandid和任务类型（或者还有任务名称）、还有创建时间/查出所有的分享任务的taskid以及名称
            MktTaskPOExample mktTaskPOExample = new MktTaskPOExample();
            MktTaskPOExample.Criteria criteria1 = mktTaskPOExample.createCriteria();
            criteria1.andValidEqualTo(true).andSysBrandIdEqualTo(stageUser.getBrandId()).andTaskTypeEqualTo(TaskTypeEnum.TASK_TYPE_SHARE.getCode());
            if (taskName!=null&&taskName!=""){
                criteria1.andTaskNameLike(taskName);
            }
            if (date1!=null&&date2!=null){
                criteria1.andCreateDateBetween(date1,date2);
            }else if(date1!=null&&date2==null){
                criteria1.andCreateDateBetween(date1,new Date());
            }else if(date1==null&&date2!=null){
                criteria1.andCreateDateLessThanOrEqualTo(date2);
            }

            List<MktTaskPO> mktTaskPOList = mktTaskPOMapper.selectByExample(mktTaskPOExample);
            Long countPoints = 0L;
            Long countCoupon = 0L;
            Long allTaskInvaildCountCoupon = 0L;
            Long countMbr = 0L;
            List<DayTaskRecordVo> dayTaskRecordVoList = new ArrayList<>();
            //
            for (MktTaskPO mktTaskPO:mktTaskPOList){

                Long taskId = mktTaskPO.getMktTaskId();
                Integer points = mktTaskPO.getPoints();
                //根据taskid在记录表中查出对应的人数再乘以相应的积分
                MktTaskRecordPOExample mktTaskRecordPOExample = new MktTaskRecordPOExample();
                MktTaskRecordPOExample.Criteria criteria2 = mktTaskRecordPOExample.createCriteria();
                criteria2.andTaskIdEqualTo(taskId).andValidEqualTo(true);
                Long oneTaskcountMbr = mktTaskRecordPOMapper.countByExample(mktTaskRecordPOExample);
                countMbr = countMbr+oneTaskcountMbr;
                Long oneTaskCountPoints = points*oneTaskcountMbr;
                countPoints = countPoints+oneTaskCountPoints;

                //根据taskid查出该任务赠送券数

                MktCouponPOExample mktCouponPOExample = new MktCouponPOExample();
                MktCouponPOExample.Criteria criteria4 = mktCouponPOExample.createCriteria();
                criteria4.andBizIdEqualTo(taskId).andValidEqualTo(true);
                Long oneTaskCoupon = mktCouponPOMapper.countByExample(mktCouponPOExample);
                Long oneTaskCountCoupon = oneTaskcountMbr*oneTaskCoupon;
                countCoupon = countCoupon+oneTaskCountCoupon;

                //根据taskid去分享任务表查出该任务需要完成的分享次数   最终查出完成任务的总人数
                MktTaskSharePOExample mktTaskSharePOExample = new MktTaskSharePOExample();
                MktTaskSharePOExample.Criteria criteria3 = mktTaskSharePOExample.createCriteria();
                criteria3.andMktTaskIdEqualTo(taskId).andValidEqualTo(true);
                List<MktTaskSharePO> mktTaskSharePOList  =mktTaskSharePOMapper.selectByExample(mktTaskSharePOExample);
                MktTaskSharePO mktTaskSharePO = mktTaskSharePOList.get(0);
                Integer oneTaskShareTimes = mktTaskSharePO.getShareTimes();

                //根据taskid count出该任务的条数 即该任务的分享次数

                MktTaskRecordPOExample mktTaskRecordPOExample1 = new MktTaskRecordPOExample();
                MktTaskRecordPOExample.Criteria criteria5 = mktTaskRecordPOExample1.createCriteria();
                criteria5.andTaskIdEqualTo(taskId);
                Long oneTaskCountShareTimes = mktTaskRecordPOMapper.countByExample(mktTaskRecordPOExample1);


                //根据会员编号  taskid  查出该任务完成的人数

                Map<String,Long> map = new HashMap<>();
                if (taskId!=null&&oneTaskShareTimes!=null){
                    map.put("taskId",taskId);
                    map.put("oneTaskShareTimes",(long)oneTaskShareTimes);
                }else{
                    responseData.setCode(SysResponseEnum.FAILED.getCode());
                }
                //每个任务完成的会员人数
                Long comlpeteMbr = mktTaskRecordPOMapper.countCompleteMbr(map);


                //每个taskid核销的优惠券数
                CouponEntityPO couponEntityPO = new CouponEntityPO();

                couponEntityPO.setSendBusinessId(taskId);
                //ResponseData<CouponFindCouponCountResponseVO> allInvalidCountCouponResp = couponQueryServiceFeign.findCouponCountBySendBusinessId(taskId,null,null);

                //CouponFindCouponCountResponseVO allInvalidCountCoupon = allInvalidCountCouponResp.getData();
                //int count =  allInvalidCountCoupon.getCouponUsedSum();


                //allTaskInvaildCountCoupon = allTaskInvaildCountCoupon+count;
                //将每个分享任务的内容添加进list中

                DayTaskRecordVo dayTaskRecordVo = new DayTaskRecordVo();
                dayTaskRecordVo.setTaskName(mktTaskPO.getTaskName());
                dayTaskRecordVo.setOneTaskCountMbr(oneTaskcountMbr);
                dayTaskRecordVo.setOneTaskPoints(oneTaskCountPoints);
                //dayTaskRecordVo.setOneTaskInvalidCountCoupon((long)count);
                dayTaskRecordVo.setOneTaskCountCoupon(oneTaskCountCoupon);
                dayTaskRecordVo.setOneTaskCompleteCountMbr(comlpeteMbr);
                dayTaskRecordVo.setOneTaskShareTimes(oneTaskCountShareTimes);

                dayTaskRecordVoList.add(dayTaskRecordVo);
            }

            PageHelper.startPage(pageForm.getPageNumber(),pageForm.getPageSize());
            PageInfo<DayTaskRecordVo> pageInfo = new PageInfo<>(dayTaskRecordVoList);
            taskRecordVO.setAllPoints(countPoints);
            taskRecordVO.setAllCountCoupon(countCoupon);
            taskRecordVO.setAllCountMbr(countMbr);
            //taskRecordVO.setAllinvalidCountCoupon(allTaskInvaildCountCoupon);
            taskRecordVO.setDayTaskRecordVoList(pageInfo);

            responseData.setData(taskRecordVO);

            responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
            responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        }catch(Exception e){
            e.printStackTrace();
            responseData.setMessage(SysResponseEnum.FAILED.getMessage());
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            return responseData;
        }



        return responseData;
    }


    /**
     * 禁用任务
     * @param taskId
     * @param stageUser
     * @return
     */
    public ResponseData stopTask(Long taskId,SysAccountPO stageUser){
        ResponseData responseData = new ResponseData();

        try {

            //根据taskid查出该任务

            MktTaskPOWithBLOBs mktTaskPOWithBLOBs =  mktTaskPOMapper.selectByPrimaryKey(taskId);
            mktTaskPOWithBLOBs.setModifiedDate(new Date());
            mktTaskPOWithBLOBs.setModifiedUserId(stageUser.getSysAccountId());
            mktTaskPOWithBLOBs.setModifiedUserName(stageUser.getName());
            mktTaskPOWithBLOBs.setTaskStatus(TaskStatusEnum.TASK_STATUS_DISABLED.getCode());
            mktTaskPOMapper.updateByPrimaryKeySelective(mktTaskPOWithBLOBs);
            responseData.setData(ResponseConstants.SUCCESS_MSG);

            responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
            responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        }catch(Exception e){
            e.printStackTrace();
            responseData.setMessage(SysResponseEnum.FAILED.getMessage());
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            return responseData;
        }

        return responseData;
    }


    /**
     * 审核任务
     * @return
     */
    public ResponseData checkTaskShare(Long taskId,SysAccountPO stageUser,Integer checkStatus){
        ResponseData responseData = new ResponseData();

        try {


            //根据taskId查询出该任务

            MktTaskPOWithBLOBs mktTaskPOWithBLOBs = mktTaskPOMapper.selectByPrimaryKey(taskId);
            //审核通过
            if (checkStatus==CheckStatusEnum.CHECK_STATUS_APPROVED.getCode()){
                mktTaskPOWithBLOBs.setCheckStatus(CheckStatusEnum.CHECK_STATUS_APPROVED.getCode());
                //审核时间未超过任务结束时间
                if (new Date().before(mktTaskPOWithBLOBs.getEndTime())){
                    //审核时间超过任务开始时间
                    if(new Date().after(mktTaskPOWithBLOBs.getStartTime())){
                        mktTaskPOWithBLOBs.setTaskStatus(TaskStatusEnum.TASK_STATUS_EXECUTING.getCode());
                        //todo 执行发送消息
                    }//审核时间未超过任务开始时间
                    else{
                        mktTaskPOWithBLOBs.setTaskStatus(TaskStatusEnum.TASK_STATUS_PENDING.getCode());
                    }

                }//审核时间超过任务结束时间
                else{
                    mktTaskPOWithBLOBs.setTaskStatus(TaskStatusEnum.TASK_STATUS_FINISHED.getCode());
                }
            }//审核驳回
            else{
                mktTaskPOWithBLOBs.setCheckStatus(CheckStatusEnum.CHECK_STATUS_REJECTED.getCode());
                mktTaskPOWithBLOBs.setTaskStatus(TaskStatusEnum.TASK_STATUS_PENDING.getCode());
            }

            mktTaskPOMapper.updateByPrimaryKeySelective(mktTaskPOWithBLOBs);

            responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
            responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        }catch(Exception e){
            e.printStackTrace();
            responseData.setMessage(SysResponseEnum.FAILED.getMessage());
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            return responseData;
        }

        return responseData;
    }



}
