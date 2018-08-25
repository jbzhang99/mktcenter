package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.centerstageservice.models.po.SysCheckConfigPo;
import com.bizvane.centerstageservice.models.po.SysCheckPo;
import com.bizvane.centerstageservice.rpc.SysCheckConfigServiceRpc;
import com.bizvane.centerstageservice.rpc.SysCheckServiceRpc;
import com.bizvane.couponfacade.enums.SendTypeEnum;
import com.bizvane.couponfacade.interfaces.CouponQueryServiceFeign;
import com.bizvane.couponfacade.models.po.CouponDefinitionPO;
import com.bizvane.couponfacade.models.vo.CouponFindCouponCountResponseVO;
import com.bizvane.couponfacade.models.vo.SendCouponSimpleRequestVO;
import com.bizvane.members.facade.models.IntegralRecordModel;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.service.api.MemberInfoApiService;
import com.bizvane.members.facade.vo.MemberInfoApiModel;
import com.bizvane.messagefacade.models.vo.MemberMessageVO;
import com.bizvane.messagefacade.models.vo.SysSmsConfigVO;
import com.bizvane.mktcenterservice.interfaces.TaskMessageService;
import com.bizvane.mktcenterservice.interfaces.TaskRecordService;
import com.bizvane.mktcenterservice.interfaces.TaskService;
import com.bizvane.mktcenterservice.models.bo.AddTaskBO;
import com.bizvane.mktcenterservice.models.bo.AwardBO;
import com.bizvane.mktcenterservice.models.bo.TaskAwardBO;
import com.bizvane.mktcenterservice.models.bo.TaskBO;
import com.bizvane.mktcenterservice.models.po.*;
import com.bizvane.mktcenterservice.models.vo.*;
import com.bizvane.mktcenterserviceimpl.common.award.Award;
import com.bizvane.mktcenterserviceimpl.common.constants.ResponseConstants;
import com.bizvane.mktcenterserviceimpl.common.constants.TaskConstants;
import com.bizvane.mktcenterserviceimpl.common.enums.CheckStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.MktSmartTypeEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.TaskStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.job.JobUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.TimeUtils;
import com.bizvane.mktcenterserviceimpl.mappers.MktCouponPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktMessagePOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktTaskPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktTaskRecordPOMapper;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.bizvane.mktcenterserviceimpl.common.enums.TaskTypeEnum;

/**
 * @author chen.li
 * @date on 2018/7/16 14:11
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private MktTaskPOMapper mktTaskPOMapper;
    @Autowired
    private SysCheckConfigServiceRpc sysCheckConfigServiceRpc;
    @Autowired
    private MemberInfoApiService memberInfoApiService;
    @Autowired
    private Award award;
    @Autowired
    private TaskMessageService taskMessageService;
    @Autowired
    private JobUtil jobUtil;
    @Autowired
    private TaskRecordService taskRecordService;
    @Autowired
    private CouponQueryServiceFeign couponQueryService;
    @Autowired
    private MktTaskRecordPOMapper mktTaskRecordPOMapper;
    @Autowired
    private   SysCheckServiceRpc sysCheckServiceRpc;
    @Autowired
    private MktCouponPOMapper mktCouponPOMapper;
    @Autowired
    private MktMessagePOMapper mktMessagePOMapper;

    @Override
    public ResponseData<TaskBO> selectTaskById(Long mktTaskId) {
        ResponseData responseData = new ResponseData();

        try {

            TaskBO taskBO = new TaskBO();
            TaskVO taskVO = new TaskVO();
            taskVO.setMktTaskId(mktTaskId);
            //联表查询查询任务详情
            List<TaskVO> taskVOList = mktTaskPOMapper.getTaskList(mktTaskId);
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
            if (!org.springframework.util.CollectionUtils.isEmpty(mktCouponPOList)){
                taskBO.setMktCouponPOList(mktCouponPOList);
            }
            if (!org.springframework.util.CollectionUtils.isEmpty(mktMessagePOList)){
                taskBO.setMessagePOList(mktMessagePOList);
            }
            if (!org.springframework.util.CollectionUtils.isEmpty(couponDefinitionPOS)){
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
     * 根据公司id和品牌id查询执行中的消费类任务
     * @param sysCompanyId
     * @param sysBrandId
     * @return
     */
    @Override
    public List<TaskAwardBO> getTaskOrderAwardList(Long sysCompanyId, Long sysBrandId, Date placeOrderTime){
        return mktTaskPOMapper.getTaskOrderAwardList(sysCompanyId,sysBrandId,placeOrderTime);
    }
    /**
     * 根据公司id和品牌id查询执行中的邀请类任务
     * @param sysCompanyId
     * @param sysBrandId
     * @return
     */
    @Override
    public List<TaskAwardBO> getTaskInviteAwardList(Long sysCompanyId, Long sysBrandId,Date placeOrderTime){
        return mktTaskPOMapper.getTaskInviteAwardList(sysCompanyId, sysBrandId,placeOrderTime);
    }

    /**
     * 消费  邀请任务都可使用,查询任务详情(TaskDetailVO)
     *
     * @param mktTaskId
     * @return
     */
    @Override
    public List<TaskDetailVO> getTaskDetailByTaskId(Long mktTaskId) {
        return mktTaskPOMapper.getTaskDetailByTaskId(mktTaskId);
    }

    /**
     * 设置审核和执行状态
     */
    @Override
    public MktTaskPOWithBLOBs isOrNoCheckState(MktTaskPOWithBLOBs po) throws ParseException {
        //1.判断是否需要审核  1=需要审核   0=不需要
        SysCheckConfigPo sysCheckConfigPo = new SysCheckConfigPo();
        sysCheckConfigPo.setSysBrandId(po.getSysBrandId());
        Integer checkStatus = this.getCheckStatus(sysCheckConfigPo);
        //判断时间是否滞后   2=滞后执行    1=立即执行
        Integer ImmediatelyRunStatus = TimeUtils.IsImmediatelyRun(po.getStartTime());
        // checkStatus=1=需要审核
        if (TaskConstants.FIRST.equals(checkStatus)) {
            //待审核=1
            po.setCheckStatus(CheckStatusEnum.CHECK_STATUS_PENDING.getCode());
            //待执行=1
            po.setTaskStatus(TaskStatusEnum.TASK_STATUS_PENDING.getCode());
        } else {
            // checkStatus=0=不需要审核
            //已审核=3
            po.setCheckStatus(CheckStatusEnum.CHECK_STATUS_APPROVED.getCode());
            if (TaskConstants.SECOND.equals(ImmediatelyRunStatus)) {
                //1=待执行
                po.setTaskStatus(TaskStatusEnum.TASK_STATUS_PENDING.getCode());
            } else {
                //2.执行中
                po.setTaskStatus(TaskStatusEnum.TASK_STATUS_EXECUTING.getCode());
            }
        }
        return po;
    }


    /**
     * 判断时间是否滞后,已经是否立即执行,还是创建job执行
     */
    @Override
    public void doOrderTask(MktTaskPOWithBLOBs mktTaskPOWithBLOBs, SysAccountPO stageUser) {
        Long mktTaskId = mktTaskPOWithBLOBs.getMktTaskId();
        //公司id
        Long sysCompanyId = mktTaskPOWithBLOBs.getSysCompanyId();
        //审核状态
        Integer checkStatus = mktTaskPOWithBLOBs.getCheckStatus();
        //执行状态
        Integer taskStatus = mktTaskPOWithBLOBs.getTaskStatus();
        //已审核   执行中  执行时间小于当前时间 或等于当前时间
        if (TaskConstants.THREE.equals(checkStatus) && TaskConstants.SECOND.equals(taskStatus)) {
            //判断是否需要发送消息和短信
         List<MktMessagePO> mktmessagePOList = taskMessageService.getMktMessagePOS(mktTaskId);
         this.sendSmg(sysCompanyId);
         jobUtil.addTaskEndJob(stageUser, mktTaskPOWithBLOBs);
        }
        //已审核   待执行,创建job
        if (TaskConstants.THREE.equals(checkStatus) && TaskConstants.FIRST.equals(taskStatus)) {
            //先清除一下job

            //判断是否需要发送消息和短信,创建job
            jobUtil.addTaskStartJob(stageUser, mktTaskPOWithBLOBs);
            jobUtil.addTaskEndJob(stageUser, mktTaskPOWithBLOBs);
        }
    }

    /**
     * 发送消息和短信
     */
    @Override
    public void sendSmg(Long sysCompanyId) {
        List<MktMessagePO> mktmessagePOList = taskMessageService.getMktMessagePOS(sysCompanyId);
        if (CollectionUtils.isNotEmpty(mktmessagePOList)) {
            List<MemberInfoModel> companyMemebers = this.getCompanyMemebers(sysCompanyId);
            mktmessagePOList.stream().forEach(
                    message -> {
                        String msgType = message.getMsgType();
                        companyMemebers.stream().forEach(
                                obj -> {
                                    AwardBO bo = new AwardBO();
                                    //1模板消息，2短信'
                                    if (TaskConstants.FIRST.equals(msgType)) {
                                        //1券，2积分，3短信，4模板消息
                                        SysSmsConfigVO sysSmsConfigVO = new SysSmsConfigVO();
                                        sysSmsConfigVO.setPhone(obj.getPhone());
                                        bo.setSysSmsConfigVO(sysSmsConfigVO);
                                        bo.setMktType(MktSmartTypeEnum.SMART_TYPE_SMS.getCode());
                                    } else {
                                        MemberMessageVO memberMessageVO = new MemberMessageVO();
                                        bo.setMemberMessageVO(memberMessageVO);
                                        bo.setMktType(MktSmartTypeEnum.SMART_TYPE_WXMESSAGE.getCode());
                                    }

                                    award.execute(bo);
                                }
                        );

                    }
            );
        }
    }



    /**
     * 发送券和积分
     */
    @Override
    public void sendCouponAndPoint(String memberCode,String carNo,TaskAwardBO orderAwardBO){
        List<MktCouponPO> mktCouponPOList = orderAwardBO.getMktCouponPOList();
        Integer points = orderAwardBO.getPoints();

        AwardBO bo = new AwardBO();
        //会员code
//        bo.setMemberCode(memberCode);
        //任务务id
//        bo.setSendBussienId(orderAwardBO.getMktTaskId());
        //暂定
        //  bo.setMemberName();
//        bo.setCardNo(carNo);

        if (points!=null && points>0){
            //2=积分营销
            IntegralRecordModel integralRecordModel = new IntegralRecordModel();
            integralRecordModel.setChangeIntegral(orderAwardBO.getPoints());
            bo.setMktType(MktSmartTypeEnum.SMART_TYPE_INTEGRAL.getCode());
            bo.setIntegralRecordModel(integralRecordModel);
            award.execute(bo);
        }
        if(CollectionUtils.isNotEmpty(mktCouponPOList)){
            //1=优惠券营销
            bo.setMktType(MktSmartTypeEnum.SMART_TYPE_COUPON.getCode());
            mktCouponPOList.stream().forEach(param->{
                //券id
                SendCouponSimpleRequestVO sendCouponSimpleRequestVO = new SendCouponSimpleRequestVO();
                sendCouponSimpleRequestVO.setCouponDefinitionId(param.getCouponDefinitionId());
                bo.setSendCouponSimpleRequestVO(sendCouponSimpleRequestVO);
                award.execute(bo);
            });


        }


    }
    /**
     * 根据品牌Id 查询审核配置，是否需要审核然后判断
     * 1:需要审核 0:不需要
     *
     * @return
     */
    @Override
    public Integer getCheckStatus(SysCheckConfigPo sysCheckConfigPo) {
        ResponseData<Integer> responseData = sysCheckConfigServiceRpc.ifCheckConfig(sysCheckConfigPo);
        return responseData.getData();

    }



    /**
     * 禁用/停用任务
     *
     * @param mktTaskId
     * @param sysAccountPO
     * @return
     */
    @Override
    public ResponseData<Integer> stopTaskById(Long mktTaskId, SysAccountPO sysAccountPO) {
        ResponseData responseData = new ResponseData();
        MktTaskPOWithBLOBs mktTaskPOWithBLOBs = new MktTaskPOWithBLOBs();
        mktTaskPOWithBLOBs.setMktTaskId(mktTaskId);
        mktTaskPOWithBLOBs.setTaskStatus(TaskStatusEnum.TASK_STATUS_DISABLED.getCode());
        mktTaskPOWithBLOBs.setModifiedDate(new Date());
        mktTaskPOWithBLOBs.setModifiedUserId(sysAccountPO.getSysAccountId());
        mktTaskPOWithBLOBs.setModifiedUserName(sysAccountPO.getName());
        mktTaskPOMapper.updateByPrimaryKeySelective(mktTaskPOWithBLOBs);
        responseData.setData(ResponseConstants.SUCCESS_MSG);
        return responseData;
    }

    /**
     * 任务审核:通过/驳回
     * 需要传递任务开始时间,修改执行状态
     *
     * @param mktTaskId
     * @param sysAccountPO
     * @return  todo   审核时间超过任务结束时间
     */
    @Override
    public ResponseData<Integer> checkTaskById(Long mktTaskId, Integer checkStatus,String remark, SysAccountPO sysAccountPO,Date startTime,Date endTime) throws ParseException {
        ResponseData<Integer> result = new ResponseData<Integer>(SysResponseEnum.FAILED.getCode(), SysResponseEnum.FAILED.getMessage(), null);
        ResponseData responseData = new ResponseData();
        MktTaskPOWithBLOBs mktTaskPOWithBLOBs = new MktTaskPOWithBLOBs();
        //判断时间是否滞后   2=滞后执行    1=立即执行
        Integer ImmediatelyRunStatus = TimeUtils.IsImmediatelyRun(startTime);
        if (TaskConstants.THREE.equals(checkStatus)) {
            //判断时间是否滞后   2=滞后执行    1=立即执行
            if (TaskConstants.SECOND.equals(ImmediatelyRunStatus)) {
                //1=待执行
                mktTaskPOWithBLOBs.setTaskStatus(TaskStatusEnum.TASK_STATUS_PENDING.getCode());
            } else {
                //2.执行中
                mktTaskPOWithBLOBs.setTaskStatus(TaskStatusEnum.TASK_STATUS_EXECUTING.getCode());
            }
        }
        mktTaskPOWithBLOBs.setMktTaskId(mktTaskId);
        mktTaskPOWithBLOBs.setCheckStatus(checkStatus);
        mktTaskPOWithBLOBs.setRemark(remark);
        mktTaskPOWithBLOBs.setModifiedDate(new Date());
        mktTaskPOWithBLOBs.setModifiedUserId(sysAccountPO.getSysAccountId());
        mktTaskPOWithBLOBs.setModifiedUserName(sysAccountPO.getName());
        int i = mktTaskPOMapper.updateByPrimaryKeySelective(mktTaskPOWithBLOBs);
        this.updateCheckData(mktTaskPOWithBLOBs);

        if (i > 0) {
            result.setCode(SysResponseEnum.SUCCESS.getCode());
            result.setMessage(SysResponseEnum.SUCCESS.getMessage());
            //3=已审核
            if (TaskConstants.THREE.equals(checkStatus)) {
                List<TaskDetailVO> taskDetails = this.getTaskDetailByTaskId(mktTaskId);
                if (CollectionUtils.isNotEmpty(taskDetails)) {
                    TaskDetailVO taskdetailvo = taskDetails.get(0);
                    mktTaskPOWithBLOBs = new MktTaskPOWithBLOBs();
                    BeanUtils.copyProperties(taskdetailvo, mktTaskPOWithBLOBs);
                    this.doOrderTask(mktTaskPOWithBLOBs,sysAccountPO);
                }
            }

        }
        return responseData;
    }

    /**
     * 效果分析的明细
     */
    @Override
    public ResponseData<TaskRecordVO> doAnalysis(TaskAnalysisVo vo){
        ResponseData<TaskRecordVO> result = new ResponseData<TaskRecordVO>(SysResponseEnum.SUCCESS.getCode(),SysResponseEnum.SUCCESS.getMessage(),null);
        Long sysBrandId = vo.getBrandId();
        //每个任务的券,积分,会员 总数
        PageHelper.startPage(vo.getPageNumber(),vo.getPageSize());
        List<DayTaskRecordVo> analysisall = mktTaskRecordPOMapper.getAnalysisResult(vo);
        PageInfo<DayTaskRecordVo> dayTaskRecordVoPage = new PageInfo<>(analysisall);
        List<DayTaskRecordVo> analysislists = dayTaskRecordVoPage.getList();
        //赠送总积分数
        Long allPoints=0L;
        //发行券总张数
        Long allCountCoupon=0L;
        //参与任务总人数
        Long allCountMbr=0L;
        //被核销优惠券总数
        Long allinvalidCountCoupon=0L;

//        if (CollectionUtils.isNotEmpty(analysislists)){
//            for (DayTaskRecordVo task: analysislists) {
//                TaskTypeEnum taskTypeEnum = TaskTypeEnum.getTaskTypeEnumByCode(vo.getTaskType());
//                String sendType=null;
//                switch (taskTypeEnum){
//                    case TASK_TYPE_CONSUME_TIMES:
//                        // 累计消费次数
//                        sendType=SendTypeEnum.SEND_COUPON_COUSUME_TIMES_TASK.getCode();
//                        break;
//                    case TASK_TYPE_CONSUME_AMOUNT:
//                        //累计消费金额
//                        sendType=SendTypeEnum.SEND_COUPON_COUSUME_MONEY_TASK.getCode();
//                        break;
//
//                    case TASK_TYPE_INVITE:
//                        //邀请注册
//                        sendType=SendTypeEnum.SEND_COUPON_INVITE_OPENCARD_TASK.getCode();
//                        break;
//                }
//                ResponseData<CouponFindCouponCountResponseVO> couponCount= couponQueryService.findCouponCountBySendBusinessId(task.getTaskId(), sendType, sysBrandId);
//                CouponFindCouponCountResponseVO data = couponCount.getData();
//                Long couponSum = data.getCouponSum();
//                task.setOneTaskInvalidCountCoupon(couponSum);
//
//                allPoints=allPoints+task.getOneTaskPoints();
//                allCountCoupon= allCountCoupon+task.getOneTaskCountCoupon();
//                allCountMbr=allCountMbr+task.getOneTaskCountMbr();
//                allinvalidCountCoupon = allinvalidCountCoupon+Long.valueOf(couponSum);
//            }
//        }
        TaskRecordVO taskRecordVO = new TaskRecordVO();
        taskRecordVO.setAllPoints(allPoints);
        taskRecordVO.setAllCountCoupon(allCountCoupon);
        taskRecordVO.setAllCountMbr(allCountMbr);
        taskRecordVO.setAllinvalidCountCoupon(allinvalidCountCoupon);
        taskRecordVO.setDayTaskRecordVoList(dayTaskRecordVoPage);

        result.setData(taskRecordVO);
        return result;
    }
    /**
     * 新增任务主表任务数据
     *
     * @param task
     * @param stageUser
     * @return
     */
    @Override
    public Long addTask(MktTaskPOWithBLOBs task, SysAccountPO stageUser) {
        mktTaskPOMapper.insertSelective(task);
        return task.getMktTaskId();
    }

    /**
     * 修改任务
     */
    @Override
    public Integer updateTask(MktTaskPOWithBLOBs task, SysAccountPO stageUser) {
        return mktTaskPOMapper.updateByPrimaryKeySelective(task);
    }

    /**
     * 将需要审核的任务添加到中台
     * @param po
     */
    @Override
    public  void addCheckData(MktTaskPOWithBLOBs po) {
        Integer taskType = po.getTaskType();
        //待审核=1
        if(TaskConstants.FIRST.equals(taskType)) {
            SysCheckPo checkPo = new SysCheckPo();
            checkPo.setSysBrandId(po.getSysBrandId());
            checkPo.setBusinessType(taskType);
            checkPo.setBusinessId(po.getMktTaskId());
            checkPo.setBusinessCode(po.getTaskCode());
            checkPo.setBusinessName(po.getTaskName());
            checkPo.setCheckStatus(CheckStatusEnum.CHECK_STATUS_PENDING.getCode());
            sysCheckServiceRpc.addCheck(checkPo);
        }

    }
    /**
     *修改添加到中台任务的状态
     * @param po
     */
    @Override
    public  void updateCheckData(MktTaskPOWithBLOBs po) {
        //已审核=3
        SysCheckPo checkPo = new SysCheckPo();
        //checkPo.setSysBrandId(po.getSysBrandId());
        checkPo.setBusinessId(po.getMktTaskId());
        checkPo.setCheckStatus(po.getCheckStatus());
        sysCheckServiceRpc.updateCheck(checkPo);
    }

    /**
     * 查询公司下的所有会员  todo  注释掉
     */
    @Override
    public List<MemberInfoModel> getCompanyMemebers(Long sysCompanyId) {
        MemberInfoApiModel members = new MemberInfoApiModel();
        members.setCompanyId(sysCompanyId);
       /* ResponseData<List<MemberInfoModel>> memberInfo = memberInfoApiService.getMemberInfo(members);
        List<MemberInfoModel> list = memberInfo.getData();*/
        return null;//list;

    }
    /**
     * 查询公司下的某一会员的详情 todo  注释掉不报错
     */
    @Override
    public MemberInfoModel getCompanyMemeberDetail(String  memberCode) {
        MemberInfoApiModel members = new MemberInfoApiModel();
        members.setMemberCode(memberCode);
       /* ResponseData<List<MemberInfoModel>> memberInfo = memberInfoApiService.getMemberInfo(members);
        List<MemberInfoModel> list = memberInfo.getData();
        MemberInfoModel memberInfoModel=null;
        if (CollectionUtils.isNotEmpty(list)){
            memberInfoModel=list.get(0);
        }*/
        return null;//memberInfoModel;

    }

    /**
     * 根据任务类型查询任务-已起用
     */
    @Override
    public ResponseData<PageInfo<MktTaskPOWithBLOBs>> getTaskByTaskType(TaskVO vo, PageForm pageForm) {
        ResponseData<PageInfo<MktTaskPOWithBLOBs>> result = new ResponseData<PageInfo<MktTaskPOWithBLOBs>>(SysResponseEnum.FAILED.getCode(), SysResponseEnum.FAILED.getMessage(), null);
        Integer showType = vo.getShowType();
        //1完善资料，2分享任务，3邀请注册，4累计消费次数，5累计消费金额',
        PageHelper.startPage(pageForm.getPageNumber(), pageForm.getPageSize());

        MktTaskPOExample mktTaskPOExample = new MktTaskPOExample();
        //查询所有
        if (TaskConstants.FIRST.equals(showType)) {
            mktTaskPOExample.createCriteria().andTaskTypeEqualTo(vo.getTaskType());
        } else if (TaskConstants.SECOND.equals(showType)) {
            //查询已启用
            mktTaskPOExample.createCriteria().andTaskTypeEqualTo(vo.getTaskType()).andValidEqualTo(Boolean.TRUE);
        } else if (TaskConstants.THREE.equals(showType)) {
            //查询已禁用
            mktTaskPOExample.createCriteria().andTaskTypeEqualTo(vo.getTaskType()).andValidEqualTo(Boolean.FALSE);
        }
        mktTaskPOExample.setOrderByClause("create_date desc");

        List<MktTaskPOWithBLOBs> lists = mktTaskPOMapper.selectByExampleWithBLOBs(mktTaskPOExample);

        if (CollectionUtils.isNotEmpty(lists)) {
            PageInfo<MktTaskPOWithBLOBs> pageInfo = new PageInfo<MktTaskPOWithBLOBs>(lists);
            result.setData(pageInfo);
            result.setCode(SysResponseEnum.SUCCESS.getCode());
            result.setMessage(SysResponseEnum.SUCCESS.getMessage());
        }

        return result;

    }
}
