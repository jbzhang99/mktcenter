package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.appletservice.Rpc.MenberMadeServiceRpc;
import com.bizvane.centerstageservice.models.po.SysCheckConfigPo;
import com.bizvane.centerstageservice.models.po.SysCheckPo;
import com.bizvane.centerstageservice.models.vo.SysCheckConfigVo;
import com.bizvane.centerstageservice.rpc.SysCheckConfigServiceRpc;
import com.bizvane.centerstageservice.rpc.SysCheckServiceRpc;
import com.bizvane.couponfacade.interfaces.CouponDefinitionServiceFeign;
import com.bizvane.couponfacade.interfaces.CouponQueryServiceFeign;
import com.bizvane.couponfacade.interfaces.SendCouponServiceFeign;
import com.bizvane.couponfacade.models.po.CouponDefinitionPO;
import com.bizvane.couponfacade.models.po.CouponEntityPO;
import com.bizvane.couponfacade.models.vo.CouponEntityVO;
import com.bizvane.couponfacade.models.vo.CouponFindCouponCountResponseVO;
import com.bizvane.couponfacade.models.vo.SendCouponSimpleRequestVO;
import com.bizvane.members.facade.enums.IntegralBusinessTypeEnum;
import com.bizvane.members.facade.enums.IntegralChangeTypeEnum;
import com.bizvane.members.facade.models.IntegralRecordModel;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.service.api.IntegralRecordApiService;
import com.bizvane.members.facade.service.api.MemberInfoApiService;
import com.bizvane.members.facade.vo.MemberInfoApiModel;
import com.bizvane.messagefacade.interfaces.SendCommonMessageFeign;
import com.bizvane.messagefacade.models.vo.MemberMessageVO;
import com.bizvane.messagefacade.models.vo.SysSmsConfigVO;
import com.bizvane.mktcenterservice.interfaces.TaskShareService;
import com.bizvane.mktcenterservice.models.bo.AwardBO;
import com.bizvane.mktcenterservice.models.bo.TaskBO;
import com.bizvane.mktcenterservice.models.po.*;
import com.bizvane.mktcenterservice.models.vo.*;
import com.bizvane.mktcenterserviceimpl.common.award.Award;
import com.bizvane.mktcenterserviceimpl.common.constants.ResponseConstants;
import com.bizvane.mktcenterserviceimpl.common.enums.*;
import com.bizvane.mktcenterserviceimpl.common.job.JobUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.CodeUtil;
import com.bizvane.mktcenterserviceimpl.mappers.*;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.jobutils.JobClient;
import com.bizvane.utils.jobutils.XxlJobInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.netflix.discovery.converters.Auto;
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

    @Autowired
    private SendCommonMessageFeign sendCommonMessageFeign;

    @Autowired
    private MemberInfoApiService memberInfoApiService;




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
          ResponseData<Integer> data = sysCheckConfigServiceRpc.ifCheckConfig(sysCheckConfigPo);
            Integer i = data.getData();


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
                sysCheckPo.setValid(true);
                sysCheckServiceRpc.addCheck(sysCheckPo);
            

                //任务时间滞后
                if (taskVO.getStartTime().after(new Date())){
                    //创建调度job  任务状态为待执行
                    //创建job开始时间
                    jobUtil.addTaskStartJob(stageUser,mktTaskPOWithBLOBs);
                    //创建job结束时间
                    jobUtil.addTaskEndJob(stageUser,mktTaskPOWithBLOBs);
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
                    jobUtil.addTaskStartJob(stageUser,mktTaskPOWithBLOBs);
                    //添加job任务结束时间
                    jobUtil.addTaskEndJob(stageUser,mktTaskPOWithBLOBs);
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
            taskVO.setValid(true);
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

            mktTaskSharePO.setValid(true);
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
                    mktCouponPO1.setValid(true);
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
                    mktMessagePO.setValid(true);
                    mktMessagePO.setBizId(taskVOId);
                    mktMessagePOMapper.insertSelective(mktMessagePO);
                }
            }

            //如果任务状态为执行中  则发送消息

            if (taskVO.getTaskStatus()==TaskStatusEnum.TASK_STATUS_EXECUTING.getCode()){
                sendMsg(taskVO.getSysBrandId(),bo.getMessagePOList());

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
            //根据taskid查询出原任务开始时间
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
                       XxlJobInfo xxlJobInfo = new XxlJobInfo();
                        xxlJobInfo.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_TASK.getCode());
                        xxlJobInfo.setBizCode(taskVO.getTaskCode());
                        jobClient.removeByBiz(xxlJobInfo);

                        //新建job调度开始时间
                        jobUtil.addTaskStartJob(stageUser,mktTaskPOWithBLOBs);
                        //结束时间
                        jobUtil.addTaskEndJob(stageUser,mktTaskPOWithBLOBs);
                    }
                }//原任务时间未开始
                else{
                    //新任务时间滞后？
                    if (taskVO.getStartTime().after(new Date())){
                        //调整job调度开始时间

                        //将原job删除  防止冲突 todo
                        XxlJobInfo xxlJobInfo = new XxlJobInfo();
                        xxlJobInfo.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_TASK.getCode());
                        xxlJobInfo.setBizCode(taskVO.getTaskCode());
                        jobClient.removeByBiz(xxlJobInfo);

                        jobUtil.addTaskStartJob(stageUser,mktTaskPOWithBLOBs);
                        jobUtil.addTaskEndJob(stageUser,mktTaskPOWithBLOBs);
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

            //如果任务状态为执行中  则发送消息

            if (taskVO.getTaskStatus()==TaskStatusEnum.TASK_STATUS_EXECUTING.getCode()){
                sendMsg(taskVO.getSysBrandId(),bo.getMessagePOList());

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
     * 发送消息
     * @param brandId
     * @param list
     * @return
     */
    public ResponseData sendMsg(Long brandId,List<MktMessagePO> list){
        ResponseData responseData = new ResponseData();

        //获取会员信息

        MemberInfoApiModel memberInfoModel = new MemberInfoApiModel();
        memberInfoModel.setBrandId(brandId);
        memberInfoModel.setValid(1);
        ResponseData<List<MemberInfoModel>> memberInfo =memberInfoApiService.getMemberInfo(memberInfoModel);
        List<MemberInfoModel> memberInfoModelList = memberInfo.getData();

        //创建AwardBO对象

        AwardBO awardBO = new AwardBO();
//        awardBO.setBusinessWay(BusinessTypeEnum.ACTIVITY_TYPE_TASK.getMessage());

        if(!CollectionUtils.isEmpty(list)){
            //遍历会员信息
            for (MemberInfoModel memberInfoModel1:memberInfoModelList){

//                awardBO.setMemberName(memberInfoModel1.getName());
//                awardBO.setMemberCode(memberInfoModel1.getMemberCode());

                for (MktMessagePO messagePO:list){
                    //发送短信
                    if (messagePO.getMsgType()=="2"){
                        SysSmsConfigVO sysSmsConfigVO = new SysSmsConfigVO();
                        awardBO.setMktType(MktSmartTypeEnum.SMART_TYPE_SMS.getCode());
                        sysSmsConfigVO.setPhone(memberInfoModel1.getPhone());
                        awardBO.setSysSmsConfigVO(sysSmsConfigVO);
                        //awardBO   消息内容？？？
                        responseData = award.execute(awardBO);
                    }

                    //发送微信模板

                    if (messagePO.getMsgType()=="1"){
                        MemberMessageVO memberMessageVO = new MemberMessageVO();
                        awardBO.setMemberMessageVO(memberMessageVO);
                        awardBO.setMktType(MktSmartTypeEnum.SMART_TYPE_WXMESSAGE.getCode());

                        responseData = award.execute(awardBO);
                    }
                }
            }
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
     * @param vo 或者传回的是任务编号？mkttaskid
     * @param memberInfoModel 或者传回的是会员编号？memberCode memberCode
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
            SendCouponSimpleRequestVO sendCouponSimpleRequestVO = new SendCouponSimpleRequestVO();
            sendCouponSimpleRequestVO.setMemberCode(memberInfoModel.getMemberCode());
//            sendCouponSimpleRequestVO.setMemberName(memberInfoModel.getName());
            bo.setMktType(MktSmartTypeEnum.SMART_TYPE_COUPON.getCode());
//            sendCouponSimpleRequestVO.setBusinessWay(BusinessTypeEnum.ACTIVITY_TYPE_TASK.getMessage());
            sendCouponSimpleRequestVO.setSendBussienId(vo.getMktTaskId());
            bo.setSendCouponSimpleRequestVO(sendCouponSimpleRequestVO);
            for (MktCouponPO mktCouponPO:mktCouponPOList){
                Long couponDefId = mktCouponPO.getBizId();
                sendCouponSimpleRequestVO.setCouponDefinitionId(couponDefId);
                //award.execute(bo);
            }

            //二、积分

            //根据taskid从任务主表中查出该task

            MktTaskPOWithBLOBs mktTaskPOWithBLOBs =  mktTaskPOMapper.selectByPrimaryKey(vo.getMktTaskId());

            AwardBO bo2 = new AwardBO();
            IntegralRecordModel integralRecordModel = new IntegralRecordModel();
            integralRecordModel.setChangeBills(UUID.randomUUID().toString().replaceAll("-",""));//todo 暂时用uuid生成
            integralRecordModel.setBusinessWay(BusinessTypeEnum.ACTIVITY_TYPE_TASK.getMessage());
//            integralRecordModel.setSendBussienId(vo.getMktTaskId());
            integralRecordModel.setMemberCode(memberInfoModel.getMemberCode());
            integralRecordModel.setMemberName(memberInfoModel.getName());
            bo2.setMktType(MktSmartTypeEnum.SMART_TYPE_INTEGRAL.getCode());
            integralRecordModel.setChangeIntegral(mktTaskPOWithBLOBs.getPoints());
            bo2.setIntegralRecordModel(integralRecordModel);
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



    //判断是否完成任务

    //taskid   membercode
    public Integer ifCompleteTask(TaskVO taskVO,MemberInfoModel memberInfoModel){
        Integer i = 0;

        //根据taskid以及会员任务查出该会员有几条该任务的信息
        MktTaskRecordPOExample mktTaskRecordPOExample = new MktTaskRecordPOExample();
        MktTaskRecordPOExample.Criteria criteria = mktTaskRecordPOExample.createCriteria();
        criteria.andTaskIdEqualTo(taskVO.getMktTaskId()).andMemberCodeEqualTo(memberInfoModel.getMemberCode()).andValidEqualTo(true);

        Long oneTaskcCountRecord  = mktTaskRecordPOMapper.countByExample(mktTaskRecordPOExample);
        //根据taskid查出该任务需要分享的次数

        MktTaskSharePOExample mktTaskSharePOExample = new MktTaskSharePOExample();
        mktTaskSharePOExample.createCriteria().andMktTaskIdEqualTo(taskVO.getMktTaskId()).andValidEqualTo(true);
        List<MktTaskSharePO> mktTaskSharePOList = mktTaskSharePOMapper.selectByExample(mktTaskSharePOExample);
        MktTaskSharePO mktTaskSharePO = mktTaskSharePOList.get(0);
        Integer oneTaskShareTimes = mktTaskSharePO.getShareTimes();

        //如果分享次数小于应分享次数-1 直接加进去
        if(oneTaskcCountRecord<(oneTaskShareTimes-1)){
            i=1;
        }//分享次数=应分享次数-1  要加进去奖励
        else if(oneTaskcCountRecord==(oneTaskShareTimes-1)){
            i=2;
        }//分享次数>=分享次数     不管

            return i;
    }

    /**
     * 添加任务记录(根据taskid以及membercode)
     * @param vo  taskid
     * @param memberInfoModel
     * @return
     */
    @Transactional
    @Override
    public ResponseData addToRecord(TaskVO vo, MemberInfoModel memberInfoModel){
        ResponseData responseData = new ResponseData();

        try {

            //根据taskid从任务主表中查出该任务
            MktTaskPO mktTaskPO = mktTaskPOMapper.selectByPrimaryKey(vo.getMktTaskId());

            //根据taskid从coupon表中count出每个任务对应的券数量

            MktCouponPOExample mktCouponPOExample = new MktCouponPOExample();
            mktCouponPOExample.createCriteria().andValidEqualTo(true).andBizIdEqualTo(vo.getMktTaskId());

            Long couponCount = mktCouponPOMapper.countByExample(mktCouponPOExample);

            int i = new Long(couponCount).intValue();
            MktTaskRecordPO mktTaskRecordPO = new MktTaskRecordPO();

            //不加奖励  仅添加记录
            if(ifCompleteTask(vo,memberInfoModel)==1){
                mktTaskRecordPO.setTaskType(TaskTypeEnum.TASK_TYPE_SHARE.getCode());
                mktTaskRecordPO.setTaskId(vo.getMktTaskId());
                mktTaskRecordPO.setMemberCode(memberInfoModel.getMemberCode());
                mktTaskRecordPO.setParticipateDate(new Date());
                BeanUtils.copyProperties(mktTaskPO,mktTaskRecordPO);
                mktTaskRecordPOMapper.insertSelective(mktTaskRecordPO);
                responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
                responseData.setCode(SysResponseEnum.SUCCESS.getCode());
            }else if(ifCompleteTask(vo,memberInfoModel)==2){
                mktTaskRecordPO.setTaskType(TaskTypeEnum.TASK_TYPE_SHARE.getCode());
                mktTaskRecordPO.setTaskId(vo.getMktTaskId());
                mktTaskRecordPO.setMemberCode(memberInfoModel.getMemberCode());
                mktTaskRecordPO.setParticipateDate(new Date());
                BeanUtils.copyProperties(mktTaskPO,mktTaskRecordPO);
                mktTaskRecordPO.setPoints(mktTaskPO.getPoints());
                mktTaskRecordPO.setRewarded(1);
                mktTaskRecordPO.setCouponNum(i);
                mktTaskRecordPOMapper.insertSelective(mktTaskRecordPO);
                responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
                responseData.setCode(SysResponseEnum.SUCCESS.getCode());
            }else{
                responseData.setMessage("已参与过该任务");

            }

            /*mktTaskRecordPO.setTaskType(TaskTypeEnum.TASK_TYPE_SHARE.getCode());
            mktTaskRecordPO.setTaskId(vo.getMktTaskId());
            mktTaskRecordPO.setMemberCode(memberInfoModel.getMemberCode());
            mktTaskRecordPO.setPoints(vo.getPoints());//奖励积分是不是也该去掉？？
            mktTaskRecordPO.setParticipateDate(new Date());
            BeanUtils.copyProperties(mktTaskPO,mktTaskRecordPO);
            //是否奖励过 奖励次数？*/



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
     *//*
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
                criteria1.andTaskNameLike("%"+taskName+"%");
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
    }*/


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


            //根据taskid查出该任务对应的消息

            MktMessagePOExample mktMessagePOExample = new MktMessagePOExample();
            mktMessagePOExample.createCriteria().andBizIdEqualTo(taskId).andValidEqualTo(true);

            List<MktMessagePO> mktMessagePOList = mktMessagePOMapper.selectByExample(mktMessagePOExample);
            //审核通过
            if (checkStatus==CheckStatusEnum.CHECK_STATUS_APPROVED.getCode()){
                //调用审核接口修改审核单状态
                SysCheckPo sysCheckPo = new SysCheckPo();
                sysCheckPo.setBusinessId(taskId);
                sysCheckPo.setBusinessCode(mktTaskPOWithBLOBs.getTaskCode());
                sysCheckPo.setCheckStatus(CheckStatusEnum.CHECK_STATUS_APPROVED.getCode());

                sysCheckServiceRpc.updateCheck(sysCheckPo);
                mktTaskPOWithBLOBs.setCheckStatus(CheckStatusEnum.CHECK_STATUS_APPROVED.getCode());
                //审核时间未超过任务结束时间
                if (new Date().before(mktTaskPOWithBLOBs.getEndTime())){
                    //审核时间超过任务开始时间
                    if(new Date().after(mktTaskPOWithBLOBs.getStartTime())){
                        mktTaskPOWithBLOBs.setTaskStatus(TaskStatusEnum.TASK_STATUS_EXECUTING.getCode());
                        //todo 执行发送消息
                        sendMsg(mktTaskPOWithBLOBs.getSysBrandId(),mktMessagePOList);
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

                //调用审核接口修改审核单状态
                SysCheckPo sysCheckPo = new SysCheckPo();
                sysCheckPo.setBusinessId(taskId);
                sysCheckPo.setBusinessCode(mktTaskPOWithBLOBs.getTaskCode());
                sysCheckPo.setCheckStatus(CheckStatusEnum.CHECK_STATUS_REJECTED.getCode());
                sysCheckServiceRpc.updateCheck(sysCheckPo);
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
        TaskRecordVO taskRecordVO = new TaskRecordVO();

        Long allPoints=0L;
        Long allCountCoupon=0L;
        Long allCountMbr=0L;
        Long allinvalidCountCoupon=0L;


        try {

            //查出每个任务的一个list集合 根据任务名称 任务创建时间 任务类型 品牌id

            TaskAnalysisVo taskAnalysisVo = new TaskAnalysisVo();
            taskAnalysisVo.setEndTime(date2);
            taskAnalysisVo.setStartTime(date1);
            taskAnalysisVo.setSysBrandId(stageUser.getBrandId());
            taskAnalysisVo.setTaskName(taskName);
            taskAnalysisVo.setTaskType(TaskTypeEnum.TASK_TYPE_SHARE.getCode());
            List<DayTaskRecordVo> dayTaskRecordVoList = mktTaskRecordPOMapper.getAnalysisResult(taskAnalysisVo);

            //遍历dayTaskrecordVo  添加核销优惠券、任务参与人数、分享次数、
            for (DayTaskRecordVo dayTaskRecordVo:dayTaskRecordVoList){
                Long taskId = dayTaskRecordVo.getTaskId();

                //根据taskid从任务分享表中查出
                MktTaskSharePOExample mktTaskSharePOExample = new MktTaskSharePOExample();
                mktTaskSharePOExample.createCriteria().andValidEqualTo(true).andMktTaskIdEqualTo(taskId);

                List<MktTaskSharePO> mktTaskSharePOList = mktTaskSharePOMapper.selectByExample(mktTaskSharePOExample);
                MktTaskSharePO mktTaskSharePO = mktTaskSharePOList.get(0);

                //某个任务的参与人数
                Long countPartMbr = mktTaskRecordPOMapper.countPartMbr(mktTaskSharePO);

               //某个任务的参与人次

               /* MktTaskRecordPOExample mktTaskRecordPOExample = new MktTaskRecordPOExample();
                mktTaskRecordPOExample.createCriteria().andTaskIdEqualTo(taskId).andValidEqualTo(true);
               Long countPartMbr= mktTaskRecordPOMapper.countByExample(mktTaskRecordPOExample);*/
                dayTaskRecordVo.setOneTaskCountMbr(countPartMbr);

                //某个任务的完成人数
                Long oneTaskCountMbr = dayTaskRecordVo.getOneTaskCountMbr();
                allCountMbr = allCountMbr+oneTaskCountMbr;

                //根据taskid查出记录条数 即为该任务分享次数

                MktTaskRecordPOExample mktTaskRecordPOExample1 = new MktTaskRecordPOExample();
                mktTaskRecordPOExample1.createCriteria().andTaskIdEqualTo(taskId).andValidEqualTo(true);
                Long oneTaskCountShareTimes = mktTaskRecordPOMapper.countByExample(mktTaskRecordPOExample1);
                dayTaskRecordVo.setOneTaskShareTimes(oneTaskCountShareTimes);


                //核销的优惠券

                CouponEntityVO couponEntityVO = new CouponEntityVO();
                couponEntityVO.setSendBusinessId(taskId);
                couponEntityVO.setSendType("65");
                couponEntityVO.setSysBrandId(stageUser.getBrandId());
                ResponseData<CouponFindCouponCountResponseVO> responseVOResponseData = couponQueryService.findCouponCountByDate(couponEntityVO);
                CouponFindCouponCountResponseVO data = responseVOResponseData.getData();
                Long couponUsedSum = data.getCouponUsedSum();
                dayTaskRecordVo.setOneTaskInvalidCountCoupon(couponUsedSum);

                allinvalidCountCoupon=allinvalidCountCoupon+couponUsedSum;

                //某个任务的发行优惠券 todo  到底是自己的还是调用？
               /* Long oneTaskCountCoupon = dayTaskRecordVo.getOneTaskCountCoupon();
                allCountCoupon = allCountCoupon+oneTaskCountCoupon;*/
                Long oneTaskCountCoupon =data.getCouponSum();
                allCountCoupon = allCountCoupon+oneTaskCountCoupon;
                //赠送的积分数

                Long oneTaskCountPoints = dayTaskRecordVo.getOneTaskPoints();
                allPoints = allPoints+oneTaskCountPoints;

            }

            PageHelper.startPage(pageForm.getPageNum(),pageForm.getPageSize());
            PageInfo<DayTaskRecordVo> pageInfo = new PageInfo<>(dayTaskRecordVoList);

            taskRecordVO.setAllCountMbr(allCountMbr);
            taskRecordVO.setAllinvalidCountCoupon(allinvalidCountCoupon);
            taskRecordVO.setAllCountCoupon(allCountCoupon);
            taskRecordVO.setAllPoints(allPoints);
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




}
