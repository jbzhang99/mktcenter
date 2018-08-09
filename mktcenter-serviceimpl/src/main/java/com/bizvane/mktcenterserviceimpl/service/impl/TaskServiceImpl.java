package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.centerstageservice.models.po.SysCheckConfigPo;
import com.bizvane.centerstageservice.rpc.SysCheckConfigServiceRpc;
import com.bizvane.couponfacade.enums.SendTypeEnum;
import com.bizvane.couponfacade.interfaces.CouponQueryServiceFeign;
import com.bizvane.couponfacade.models.vo.CouponFindCouponCountResponseVO;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.models.OrderServeModel;
import com.bizvane.members.facade.service.api.MemberInfoApiService;
import com.bizvane.mktcenterservice.interfaces.TaskMessageService;
import com.bizvane.mktcenterservice.interfaces.TaskRecordService;
import com.bizvane.mktcenterservice.interfaces.TaskService;
import com.bizvane.mktcenterservice.models.bo.AwardBO;
import com.bizvane.mktcenterservice.models.bo.TaskInviteAwardBO;
import com.bizvane.mktcenterservice.models.bo.TaskAwardBO;
import com.bizvane.mktcenterservice.models.po.*;
import com.bizvane.mktcenterservice.models.vo.*;
import com.bizvane.mktcenterserviceimpl.common.award.Award;
import com.bizvane.mktcenterserviceimpl.common.constants.ResponseConstants;
import com.bizvane.mktcenterserviceimpl.common.constants.SystemConstants;
import com.bizvane.mktcenterserviceimpl.common.constants.TaskConstants;
import com.bizvane.mktcenterserviceimpl.common.enums.CheckStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.MktSmartTypeEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.TaskStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.utils.JobUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.TimeUtils;
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
        //1.判断是否需要审核  1:需要审核 0:不需要
        SysCheckConfigPo sysCheckConfigPo = new SysCheckConfigPo();
        sysCheckConfigPo.setSysBrandId(po.getSysBrandId());
        Integer checkStatus = this.getCheckStatus(sysCheckConfigPo);
        //判断时间是否滞后   2=滞后执行    3和1=立即执行
        Integer ImmediatelyRunStatus = TimeUtils.IsImmediatelyRun(po.getStartTime());
        if (TaskConstants.ZERO.equals(checkStatus)) {
            //待审核=1
            po.setCheckStatus(CheckStatusEnum.CHECK_STATUS_PENDING.getCode());
            //待执行=1
            po.setCheckStatus(TaskStatusEnum.TASK_STATUS_PENDING.getCode());
        } else {
            //已审核=3
            po.setCheckStatus(TaskConstants.THREE);
            if (TaskConstants.THREE.equals(ImmediatelyRunStatus)) {
                //待执行
                po.setCheckStatus(TaskStatusEnum.TASK_STATUS_PENDING.getCode());
            } else {
                //执行中
                po.setCheckStatus(TaskStatusEnum.TASK_STATUS_EXECUTING.getCode());
            }
        }
        return po;
    }

    /**
     * 判断时间是否滞后,已经是否立即执行,还是创建job执行
     */
    @Override
    public void doOrderTask(TaskDetailVO vo, MktTaskPOWithBLOBs mktTaskPOWithBLOBs, SysAccountPO stageUser) {
        //公司id
        Long sysCompanyId = vo.getSysCompanyId();
        //审核状态
        Integer checkStatus = vo.getCheckStatus();
        //执行状态
        Integer taskStatus = vo.getTaskStatus();
        //已审核   执行中  执行时间小于当前时间 或等于当前时间
        if (TaskConstants.THREE.equals(checkStatus) && TaskConstants.SECOND.equals(taskStatus)) {
            //判断是否需要发送消息和短信
            List<MktMessagePO> mktmessagePOList = vo.getMktmessagePOList();
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
                                    //会员code
                                    bo.setMemberCode(obj.getMemberCode());
                                    bo.setSendBussienId(message.getBizId());
                                    bo.setMemberName(obj.getName());
                                    bo.setCardNo(obj.getCardNo());
                                    //1模板消息，2短信'
                                    if (TaskConstants.FIRST.equals(msgType)) {
                                        //1券，2积分，3短信，4模板消息
                                        bo.setMktSmartType(MktSmartTypeEnum.SMART_TYPE_SMS.getCode());
                                    } else {
                                        bo.setMktSmartType(MktSmartTypeEnum.SMART_TYPE_WXMESSAGE.getCode());
                                    }

                                    award.execute(bo);
                                }
                        );

                    }
            );
        }
    }

    /**
     * 查询公司下的所有会员
     */
    @Override
    public List<MemberInfoModel> getCompanyMemebers(Long sysCompanyId) {
        MemberInfoModel members = new MemberInfoModel();
        members.setCompanyId(sysCompanyId);
        ResponseData<List<MemberInfoModel>> memberInfo = memberInfoApiService.getMemberInfo(members);
        List<MemberInfoModel> list = memberInfo.getData();
        return list;

    }
    /**
     * 查询公司下的某一会员的详情
     */
    @Override
    public MemberInfoModel getCompanyMemeberDetail(String  memberCode) {
        MemberInfoModel members = new MemberInfoModel();
        members.setMemberCode(memberCode);
        ResponseData<List<MemberInfoModel>> memberInfo = memberInfoApiService.getMemberInfo(members);
        List<MemberInfoModel> list = memberInfo.getData();
        MemberInfoModel memberInfoModel=null;
        if (CollectionUtils.isNotEmpty(list)){
            memberInfoModel=list.get(0);
        }
        return memberInfoModel;

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
        bo.setMemberCode(memberCode);
        //任务务id
        bo.setSendBussienId(orderAwardBO.getMktTaskId());
        //暂定
        //  bo.setMemberName();
        bo.setCardNo(carNo);

        if (points!=null && points>0){
            //2=积分营销
            bo.setChangeIntegral(orderAwardBO.getPoints());
            bo.setMktSmartType(MktSmartTypeEnum.SMART_TYPE_INTEGRAL.getCode());
            award.execute(bo);
        }
        if(CollectionUtils.isNotEmpty(mktCouponPOList)){
            //1=优惠券营销
            bo.setMktSmartType(MktSmartTypeEnum.SMART_TYPE_COUPON.getCode());
            mktCouponPOList.stream().forEach(param->{
                //券id
                bo.setCouponDefinitionId(param.getCouponDefinitionId());
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
     * 根据任务类型查询任务
     */
    @Override
    public ResponseData<PageInfo<MktTaskPOWithBLOBs>> getTaskByTaskType(TaskVO vo, PageForm pageForm) {
        ResponseData<PageInfo<MktTaskPOWithBLOBs>> result = new ResponseData<PageInfo<MktTaskPOWithBLOBs>>(SysResponseEnum.FAILED.getCode(), SysResponseEnum.FAILED.getMessage(), null);
        String showType = vo.getShowType();
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
            //查询已启用
            mktTaskPOExample.createCriteria().andTaskTypeEqualTo(vo.getTaskType()).andValidEqualTo(Boolean.FALSE);
        }
        mktTaskPOExample.setOrderByClause("create_date desc");

        List<MktTaskPOWithBLOBs> lists = mktTaskPOMapper.selectByExampleWithBLOBs(mktTaskPOExample);

        if (CollectionUtils.isNotEmpty(lists)) {
            PageInfo<MktTaskPOWithBLOBs> pageInfo = new PageInfo<MktTaskPOWithBLOBs>();
            result.setData(pageInfo);
            result.setCode(SysResponseEnum.SUCCESS.getCode());
            result.setMessage(SysResponseEnum.SUCCESS.getMessage());
        }

        return result;

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
     * 任务审核:通过/驳回
     *
     * @param mktTaskId
     * @param sysAccountPO
     * @return
     */
    @Override
    public ResponseData<Integer> checkTaskById(Long mktTaskId, Integer checkStatus, SysAccountPO sysAccountPO) {
        ResponseData<Integer> result = new ResponseData<Integer>(SysResponseEnum.FAILED.getCode(), SysResponseEnum.FAILED.getMessage(), null);

        ResponseData responseData = new ResponseData();
        MktTaskPOWithBLOBs mktTaskPOWithBLOBs = new MktTaskPOWithBLOBs();
        mktTaskPOWithBLOBs.setMktTaskId(mktTaskId);
        mktTaskPOWithBLOBs.setTaskStatus(checkStatus);
        mktTaskPOWithBLOBs.setModifiedDate(new Date());
        mktTaskPOWithBLOBs.setModifiedUserId(sysAccountPO.getSysAccountId());
        mktTaskPOWithBLOBs.setModifiedUserName(sysAccountPO.getName());
        int i = mktTaskPOMapper.updateByPrimaryKeySelective(mktTaskPOWithBLOBs);

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
                    this.doOrderTask(taskdetailvo,mktTaskPOWithBLOBs,sysAccountPO);
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
        Long sysBrandId = vo.getSysBrandId();
        //每个任务的券,积分,会员 总数
        PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
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

        if (CollectionUtils.isNotEmpty(analysislists)){
            for (DayTaskRecordVo task: analysislists) {
                TaskTypeEnum taskTypeEnum = TaskTypeEnum.getTaskTypeEnumByCode(vo.getTaskType());
                String sendType=null;
                switch (taskTypeEnum){
                    case TASK_TYPE_CONSUME_TIMES:
                        // 累计消费次数
                        sendType=SendTypeEnum.SEND_COUPON_COUSUME_TIMES_TASK.getCode();
                        break;
                    case TASK_TYPE_CONSUME_AMOUNT:
                        //累计消费金额
                        sendType=SendTypeEnum.SEND_COUPON_COUSUME_MONEY_TASK.getCode();
                        break;

                    case TASK_TYPE_INVITE:
                        //邀请注册
                        sendType=SendTypeEnum.SEND_COUPON_INVITE_OPENCARD_TASK.getCode();
                        break;
                }
                ResponseData<CouponFindCouponCountResponseVO> couponCount= couponQueryService.findCouponCountBySendBusinessId(task.getTaskId(), sendType, sysBrandId);
                CouponFindCouponCountResponseVO data = couponCount.getData();
                int couponSum = data.getCouponSum();
                task.setOneTaskInvalidCountCoupon(Long.valueOf(couponSum));

                allPoints=allPoints+task.getOneTaskPoints();
                allCountCoupon= allCountCoupon+task.getOneTaskCountCoupon();
                allCountMbr=allCountMbr+task.getOneTaskCountMbr();
                allinvalidCountCoupon = allinvalidCountCoupon+Long.valueOf(couponSum);
            }
        }
        TaskRecordVO taskRecordVO = new TaskRecordVO();
        taskRecordVO.setAllPoints(allPoints);
        taskRecordVO.setAllCountCoupon(allCountCoupon);
        taskRecordVO.setAllCountMbr(allCountMbr);
        taskRecordVO.setAllinvalidCountCoupon(allinvalidCountCoupon);
        taskRecordVO.setDayTaskRecordVoList(dayTaskRecordVoPage);

        result.setData(taskRecordVO);
        return result;
    }
}
