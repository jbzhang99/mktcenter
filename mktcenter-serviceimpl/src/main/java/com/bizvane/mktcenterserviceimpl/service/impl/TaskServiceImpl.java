package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.centercontrolservice.models.po.SysSmsConfigPo;
import com.bizvane.centercontrolservice.models.vo.SmsConfigVo;
import com.bizvane.centercontrolservice.rpc.SysSmsConfigServiceRpc;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.centerstageservice.models.po.SysCheckConfigPo;
import com.bizvane.centerstageservice.models.po.SysCheckPo;
import com.bizvane.centerstageservice.models.vo.SysStoreVo;
import com.bizvane.centerstageservice.rpc.StoreServiceRpc;
import com.bizvane.centerstageservice.rpc.SysCheckConfigServiceRpc;
import com.bizvane.centerstageservice.rpc.SysCheckServiceRpc;
import com.bizvane.couponfacade.enums.SendTypeEnum;
import com.bizvane.couponfacade.interfaces.CouponDefinitionServiceFeign;
import com.bizvane.couponfacade.interfaces.CouponQueryServiceFeign;
import com.bizvane.couponfacade.models.po.CouponDefinitionPO;
import com.bizvane.couponfacade.models.vo.CouponFindCouponCountResponseVO;
import com.bizvane.couponfacade.models.vo.SendCouponSimpleRequestVO;
import com.bizvane.members.facade.enums.BusinessTypeEnum;
import com.bizvane.members.facade.enums.IntegralChangeTypeEnum;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.service.api.MemberInfoApiService;
import com.bizvane.members.facade.service.api.WxChannelInfoApiService;
import com.bizvane.members.facade.service.card.request.IntegralChangeRequestModel;
import com.bizvane.members.facade.vo.MemberInfoApiModel;
import com.bizvane.members.facade.vo.PageVo;
import com.bizvane.members.facade.vo.WxChannelInfoVo;
import com.bizvane.messagefacade.interfaces.SendCommonMessageFeign;
import com.bizvane.messagefacade.models.vo.MemberMessageVO;
import com.bizvane.messagefacade.models.vo.SysSmsConfigVO;
import com.bizvane.mktcenterservice.interfaces.TaskMessageService;
import com.bizvane.mktcenterservice.interfaces.TaskRecordService;
import com.bizvane.mktcenterservice.interfaces.TaskService;
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
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chen.li
 * @date on 2018/7/16 14:11
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@Slf4j
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
    @Autowired
    private WxChannelInfoApiService wxChannelInfoApiService;
    @Autowired
    private  SysSmsConfigServiceRpc  sysSmsConfigServiceRpc;
    @Autowired
    private SendCommonMessageFeign sendCommonMessageFeign;
    @Autowired
    private CouponDefinitionServiceFeign couponDefinitionServiceFeign;
    @Autowired
    private StoreServiceRpc  storeServiceRpc;
    /**
     * 查询店铺列表
     */
    @Override
    public ResponseData<List<SysStoreVo>> getWhiteStoreList(SysStoreVo vo,SysAccountPO sysAccountPo){
        ResponseData<List<SysStoreVo>> responseData = new ResponseData<>();
        List<SysStoreVo> list=null;
        vo.setSysAccountId(sysAccountPo.getSysAccountId());
        vo.setSysCompanyId(sysAccountPo.getSysCompanyId());
        ResponseData<com.bizvane.utils.responseinfo.PageInfo<SysStoreVo>> returnData = storeServiceRpc.getSysStoreList(vo);
        com.bizvane.utils.responseinfo.PageInfo<SysStoreVo> data = returnData.getData();
        if (data!=null){
            list = data.getList();
            responseData.setData(list);
        }else{
            responseData.setMessage("没有相关的店铺列表!");
        }
        return responseData;
    }

    /**
     * '任务类型：1完善资料，2分享任务，3邀请注册，4累计消费次数，5累计消费金额'
     * 查询任务详情--已经核对
     * @param mktTaskId
     * @return
     */
    @Override
    public ResponseData<TaskBO> selectTaskById(Long mktTaskId,Integer taskType) {
        ResponseData<TaskBO> responseData = new ResponseData<TaskBO>();
        try {
            TaskBO taskBO = new TaskBO();
            List<TaskVO> taskVOList=null;
            //联表查询查询任务详情
            if (TaskConstants.FIRST.equals(taskType)){
                taskVOList = mktTaskPOMapper.getProfileTaskList(mktTaskId);
            }else if(TaskConstants.SECOND.equals(taskType)){
                taskVOList = mktTaskPOMapper.getShareTaskList(mktTaskId);
            }else if (TaskConstants.THREE.equals(taskType)){
                taskVOList = mktTaskPOMapper.getInviteTaskList(mktTaskId);
            }else{
                taskVOList = mktTaskPOMapper.getOrderTaskList(mktTaskId);
            }
            //查询券信息
            MktCouponPOExample example = new MktCouponPOExample();
            example.createCriteria().andValidEqualTo(true).andBizIdEqualTo(mktTaskId);
            List<MktCouponPO> mktCouponPOList = mktCouponPOMapper.selectByExample(example);
            //查询消息
            MktMessagePOExample mktMessagePOExample = new MktMessagePOExample();
            mktMessagePOExample.createCriteria().andValidEqualTo(true).andBizIdEqualTo(mktTaskId);
            List<MktMessagePO> mktMessagePOList = mktMessagePOMapper.selectByExample(mktMessagePOExample);

            List<CouponDefinitionPO> couponDefinitionPOS = new ArrayList<>();
            //查询券定义 todo
            for (MktCouponPO mktCouponPO:mktCouponPOList){
                Long couponDefinitionId = mktCouponPO.getCouponDefinitionId();
                ResponseData<CouponDefinitionPO> coupon = couponDefinitionServiceFeign.findByIdRpc(couponDefinitionId);
                CouponDefinitionPO couponDefinitionPO = coupon.getData();
                couponDefinitionPOS.add(couponDefinitionPO);
            }

            if (CollectionUtils.isNotEmpty(taskVOList)){
                taskBO.setTaskVO(taskVOList.get(0));
            }
            if (CollectionUtils.isNotEmpty(mktCouponPOList)){
                taskBO.setMktCouponPOList(mktCouponPOList);
            }
            if (CollectionUtils.isNotEmpty(mktMessagePOList)){
                taskBO.setMessagePOList(mktMessagePOList);
            }
            if (CollectionUtils.isNotEmpty(couponDefinitionPOS)){
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
     * 完善资料任务的奖励与详情
     * @return
     */
    @Override
    public List<TaskAwardBO> getTaskProfileAwardList(Long sysCompanyId, Long sysBrandId,Date profileDate){
        return mktTaskPOMapper.getTaskProfileAwardList(sysCompanyId, sysBrandId,profileDate);
    }

    /**
     * 分享任务的奖励与详情
     * @return
     */
    @Override
    public List<TaskAwardBO> getTaskShareAwardList(Long sysCompanyId, Long sysBrandId,Date shareDate){
        return mktTaskPOMapper.getTaskShareAwardList(sysCompanyId, sysBrandId,shareDate);
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
     * 判断时间是否滞后,已经是否立即执行,还是创建job执行-已经核对
     */
    @Override
    @Async
    public void doOrderTask(MktTaskPOWithBLOBs mktTaskPOWithBLOBs,List<MktMessagePO> mktmessagePOList, SysAccountPO stageUser) {
        //任务Id
        Long mktTaskId = mktTaskPOWithBLOBs.getMktTaskId();
        //品牌id
        Long sysBrandId = mktTaskPOWithBLOBs.getSysBrandId();
        //公司id
        Long sysCompanyId = mktTaskPOWithBLOBs.getSysCompanyId();
        //审核状态:1未审核，2审核中，3已审核，4已驳回',
        Integer checkStatus = mktTaskPOWithBLOBs.getCheckStatus();
        //执行状态:1待执行，2执行中，3已禁用，4已结束',
        Integer taskStatus = mktTaskPOWithBLOBs.getTaskStatus();
        //已审核   执行中  执行时间小于当前时间 或等于当前时间
        if (TaskConstants.THREE.equals(checkStatus) && TaskConstants.SECOND.equals(taskStatus)) {
            //判断是否需要发送消息和短信 业务类型：1活动，2任务
            this.sendSmg(mktTaskPOWithBLOBs,mktmessagePOList);
            jobUtil.addTaskEndJob(stageUser, mktTaskPOWithBLOBs);
        }
        //已审核   待执行,创建job
        if (TaskConstants.THREE.equals(checkStatus) && TaskConstants.FIRST.equals(taskStatus)) {
            //判断是否需要发送消息和短信,创建job
            jobUtil.addTaskStartJob(stageUser, mktTaskPOWithBLOBs);
            jobUtil.addTaskEndJob(stageUser, mktTaskPOWithBLOBs);
        }
    }

    /**
     * 发送消息和短信 -已经核对
     */
    @Override
    @Async
    public void sendSmg(MktTaskPOWithBLOBs mktTaskPOWithBLOBs,List<MktMessagePO> mktmessagePOList) {
        Long sysBrandId = mktTaskPOWithBLOBs.getSysBrandId();
        Integer taskType = mktTaskPOWithBLOBs.getTaskType();
        if (CollectionUtils.isNotEmpty(mktmessagePOList)) {
            mktmessagePOList.stream().forEach(
                    message -> {
                        String msgType = message.getMsgType();
                        //1=模板消息   所有的会员
                        if (TaskConstants.FIRST.equals(msgType)) {
                            //查询短信通道
                            com.bizvane.utils.responseinfo.PageInfo<MemberInfoModel> memeberspage = this.getCompanyMemebers(sysBrandId, 1, 10000);
                            List<MemberInfoModel> maemberlist = memeberspage.getList();
                            int pages = memeberspage.getPages();
                            if (CollectionUtils.isNotEmpty(maemberlist)){
                                for (int i=1;i<pages;i++){
                                    com.bizvane.utils.responseinfo.PageInfo<MemberInfoModel> pagesdata= this.getCompanyMemebers(sysBrandId, i, 10000);
                                    List<MemberInfoModel> list = pagesdata.getList();
                                    AwardBO memberBO = new AwardBO();
                                    //4=微信模板消息营销
                                    memberBO.setMktType(MktSmartTypeEnum.SMART_TYPE_WXMESSAGE.getCode());
                                    list.stream().forEach(member->{
                                        MemberMessageVO memberMessageVO = new MemberMessageVO();
                                        memberMessageVO.setMemberCode(member.getMemberCode());
                                        memberMessageVO.setOpenId(member.getWxOpenId());
                                        memberMessageVO.setSysBrandId(sysBrandId);
                                        memberBO.setMemberMessageVO(memberMessageVO);
                                        award.execute(memberBO);
                                    });
                                }

                            }
                        }
                        //2=短信     所有粉丝
                        if (TaskConstants.SECOND.equals(msgType)){
                            String msgContent = message.getMsgContent();
                            //获取营销短信通道
                            SmsConfigVo smsConfigVo = new SmsConfigVo();
                            smsConfigVo.setSysBrandId(sysBrandId);
                            smsConfigVo.setChannelType(Integer.valueOf(10));
                            smsConfigVo.setCompanyChannel(Boolean.FALSE);
                            SysSmsConfigPo smsConfigPo = sysSmsConfigServiceRpc.getCenterControlChannel(smsConfigVo);
                            Integer batchNum = smsConfigPo.getBatchNum();

                            com.bizvane.utils.responseinfo.PageInfo<WxChannelInfoVo> fanspage = this.getCompanyFans(sysBrandId, 1, batchNum);
                            List<WxChannelInfoVo> list = fanspage.getList();
                            int pages = fanspage.getPages();

                            SysSmsConfigVO sysSmsConfigVO = new SysSmsConfigVO();
                            BeanUtils.copyProperties(smsConfigPo,sysSmsConfigVO);
                            sysSmsConfigVO.setMsgContent(msgContent);
                            AwardBO fanBO = new AwardBO();
                            //3=短信
                            fanBO.setMktType(MktSmartTypeEnum.SMART_TYPE_SMS.getCode());

                            if (CollectionUtils.isNotEmpty(list)){
                                for (int i=1;i<pages;i++){
                                    com.bizvane.utils.responseinfo.PageInfo<WxChannelInfoVo> companyFans = this.getCompanyFans(sysBrandId, i, batchNum);
                                    List<WxChannelInfoVo> listData = companyFans.getList();
                                    String pnones = listData.stream().filter(fan -> StringUtils.isNotBlank(fan.getPhone())).map(fan -> fan.getPhone()).collect(Collectors.joining(","));
                                    sysSmsConfigVO.setPhones(pnones);
                                    fanBO.setSysSmsConfigVO(sysSmsConfigVO);
                                    award.execute(fanBO);
                                }

                            }
                        }

                    }
            );
        }
    }

    /**
     * 发送券和积分--已经核对
     * 任务类型：1完善资料，2分享任务，3邀请注册，4累计消费次数，5累计消费金额
     */
    @Override
    @Async
    public void sendCouponAndPoint(String memberCode,TaskAwardBO orderAwardBO){
        Long mktTaskId = orderAwardBO.getMktTaskId();
        String taskCode = orderAwardBO.getTaskCode();
        List<MktCouponPO> mktCouponPOList = orderAwardBO.getMktCouponPOList();
        Integer points = orderAwardBO.getPoints();
        ChangeTaskTypeVO changeTaskTypeVO = this.changeTaskType(orderAwardBO.getTaskType());

        if (points!=null && points>0){
            AwardBO  bo = new AwardBO();
            //2=积分营销
            IntegralChangeRequestModel integralRecordModel = new IntegralChangeRequestModel();
            integralRecordModel.setSysCompanyId(orderAwardBO.getSysCompanyId());
            integralRecordModel.setBrandId(orderAwardBO.getSysBrandId());
            integralRecordModel.setMemberCode(memberCode);
            //BusinessTypeEnum  会员定义的任务类型
            String memberTaskType = changeTaskTypeVO.getMemberTaskType();
            integralRecordModel.setBusinessType(memberTaskType);
            //2=收入积分(新增积分)      1=支出积分(减少积分)
            integralRecordModel.setChangeType(IntegralChangeTypeEnum.INCOME.getCode());
            integralRecordModel.setChangeBills(taskCode);
            integralRecordModel.setChangeIntegral(orderAwardBO.getPoints());

            bo.setMktType(MktSmartTypeEnum.SMART_TYPE_INTEGRAL.getCode());
            bo.setIntegralRecordModel(integralRecordModel);
            award.execute(bo);
        }

        if(CollectionUtils.isNotEmpty(mktCouponPOList)){
            //1=优惠券营销
            mktCouponPOList.stream().forEach(coupon->{
                AwardBO  bo = new AwardBO();
                bo.setMktType(MktSmartTypeEnum.SMART_TYPE_COUPON.getCode());
                Integer bizType = coupon.getBizType();
                //券id
                SendCouponSimpleRequestVO onecouponVO = new SendCouponSimpleRequestVO();
                onecouponVO.setMemberCode(memberCode);
                onecouponVO.setSendBussienId(mktTaskId);
                onecouponVO.setSendType(changeTaskTypeVO.getCouponTaskType());
                onecouponVO.setCouponDefinitionId(coupon.getCouponDefinitionId());
                bo.setSendCouponSimpleRequestVO(onecouponVO);
                award.execute(bo);
            });


        }
    }

    //发券和修改积分时的任务类型转换
    // 任务类型：1完善资料，2分享任务，3邀请注册，4累计消费次数，5累计消费金额
    @Override
    public  ChangeTaskTypeVO  changeTaskType(Integer taskType){
        ChangeTaskTypeVO vo = new ChangeTaskTypeVO();
        switch(taskType){
            case 1:
                vo.setMemberTaskType(BusinessTypeEnum.TASK_TYPE_PREFECT.getCode());
                vo.setCouponTaskType(SendTypeEnum.SEND_COUPON_INFORM_TASK.getCode());
                break;
            case 2:
                vo.setMemberTaskType(BusinessTypeEnum.TASK_TYPE_SHARE.getCode());
                vo.setCouponTaskType(SendTypeEnum.SEND_COUPON_WX_SHARE_TASK.getCode());
                break;
            case 3:
                vo.setMemberTaskType(BusinessTypeEnum.TASK_TYPE_INVITATION_OPENCARD.getCode());
                vo.setCouponTaskType(SendTypeEnum.SEND_COUPON_INVITE_OPENCARD_TASK.getCode());
                break;
            case 4:
                vo.setMemberTaskType(BusinessTypeEnum.TASK_TYPE_COMSUMPTION_COUNT.getCode());
                vo.setCouponTaskType(SendTypeEnum.SEND_COUPON_COUSUME_TIMES_TASK.getCode());
                break;
            case 5:
                vo.setMemberTaskType(BusinessTypeEnum.TASK_TYPE_COMSUMPTION_MONEY.getCode());
                vo.setCouponTaskType(SendTypeEnum.SEND_COUPON_COUSUME_MONEY_TASK.getCode());
                break;
        }
        return vo;
    }

    /**
     * 根据品牌Id 查询审核配置，是否需要审核然后判断
     * 1:需要审核 0:不需要
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
                MktMessagePOExample exampleMSG = new MktMessagePOExample();
                exampleMSG.createCriteria().andBizIdEqualTo(mktTaskId).andValidEqualTo(Boolean.TRUE);
                List<MktMessagePO> mktMessagePOS = mktMessagePOMapper.selectByExample(exampleMSG);
                List<TaskDetailVO> taskDetails = this.getTaskDetailByTaskId(mktTaskId);
                if (CollectionUtils.isNotEmpty(taskDetails)) {
                    TaskDetailVO taskdetailvo = taskDetails.get(0);
                    mktTaskPOWithBLOBs = new MktTaskPOWithBLOBs();
                    BeanUtils.copyProperties(taskdetailvo, mktTaskPOWithBLOBs);
                    this.doOrderTask(mktTaskPOWithBLOBs,mktMessagePOS,sysAccountPO);
                }
            }

        }
        return responseData;
    }

    /**
     * 效果分析的明细--已经审核(除了完善资料任务)
     */
    @Override
    public ResponseData<TaskRecordVO> doAnalysis(TaskAnalysisVo vo,SysAccountPO sysAccountPo){
        ResponseData<TaskRecordVO> result = new ResponseData<TaskRecordVO>(SysResponseEnum.SUCCESS.getCode(),SysResponseEnum.SUCCESS.getMessage(),null);
        Long sysBrandId = sysAccountPo.getBrandId();
        vo.setBrandId(sysBrandId);
        Integer taskType = vo.getTaskType();
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

        if (CollectionUtils.isNotEmpty(analysislists)){
            for (DayTaskRecordVo task: analysislists) {
                //

                String sendType = this.changeTaskType(taskType).getCouponTaskType();
                //查询券模块的统计出的相关数量
                ResponseData<CouponFindCouponCountResponseVO> couponCount= couponQueryService.findCouponCountBySendBusinessId(task.getTaskId(), sendType, sysBrandId);
                CouponFindCouponCountResponseVO data = couponCount.getData();
                //一个任务的券总数量
                Long couponSum = data.getCouponSum();
                //一个任务的券核销总数量
                Long couponUsedSum = data.getCouponUsedSum();
                //一个任务的券数量
                task.setOneTaskInvalidCountCoupon(couponUsedSum);
                //某任务的发行券总张数
                // task.setDayCountCoupon(couponUsedSum);
                task.setOneTaskCountCoupon(couponSum);
                allPoints=allPoints+task.getOneTaskPoints();
                allCountCoupon= allCountCoupon+task.getOneTaskCountCoupon();
                allCountMbr=allCountMbr+task.getOneTaskCompleteCountMbr();
                allinvalidCountCoupon = allinvalidCountCoupon+Long.valueOf(couponSum);
            }
        }
        TaskRecordVO taskRecordVO = new TaskRecordVO();
        //所有积分和
        taskRecordVO.setAllPoints(allPoints);
        //所有券数量和
        taskRecordVO.setAllCountCoupon(allCountCoupon);
        //所有参数人数和
        taskRecordVO.setAllCountMbr(allCountMbr);
        //被核销优惠券总数
        taskRecordVO.setAllinvalidCountCoupon(allinvalidCountCoupon);
        //每天或每条记录 的分页结果
        taskRecordVO.setDayTaskRecordVoList(dayTaskRecordVoPage);

        result.setData(taskRecordVO);
        return result;
    }
    /**
     * 新增任务主表任务数据
     *
     * @param task
     * @param stageUser    todo   品牌  公司   创建人  创建时间
     * @return
     */
    @Override
    public Long addTask(MktTaskPOWithBLOBs task, SysAccountPO stageUser) {
        task.setSysCompanyId(stageUser.getSysCompanyId());
        task.setSysBrandId(stageUser.getBrandId());
        task.setCreateUserName(stageUser.getName());
        task.setCreateUserId(stageUser.getSysAccountId());
        task.setCreateDate(new Date());
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
     * 将需要审核的任务添加到中台 --已经审核
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
     *修改添加到中台任务的状态--已经审核
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
     * 查询品牌下的所有会员,分页-已经审核
     */
    @Override
    public com.bizvane.utils.responseinfo.PageInfo<MemberInfoModel> getCompanyMemebers(Long sysBrandId,Integer pageNumber,Integer pageSize) {
        MemberInfoApiModel members = new MemberInfoApiModel();
        members.setBrandId(sysBrandId);
        members.setPageNumber(pageNumber);
        members.setPageSize(pageSize);
        ResponseData<com.bizvane.utils.responseinfo.PageInfo<MemberInfoModel>> memberInfo = memberInfoApiService.getMemberInfo(members);
        com.bizvane.utils.responseinfo.PageInfo<MemberInfoModel> data = memberInfo.getData();
        return data;

    }
    /**
     * 查询某品牌下的粉丝---已经审核
     */
    @Override
    public  com.bizvane.utils.responseinfo.PageInfo<WxChannelInfoVo>  getCompanyFans(Long sysBrandId,Integer pageNumber,Integer pageSize){
        PageVo pageVo = new PageVo();
        pageVo.setPageNumber(pageNumber);
        pageVo.setPageSize(pageSize);
        ResponseData<com.bizvane.utils.responseinfo.PageInfo<WxChannelInfoVo>> data = wxChannelInfoApiService.queryWeChatFansAndMemberByBrandId(pageVo,sysBrandId);
        return data.getData();
    }
    /**
     * 查询公司下的某一会员的详情-已经审核
     */
    @Override
    public MemberInfoModel getCompanyMemeberDetail(String  memberCode) {
        MemberInfoApiModel members = new MemberInfoApiModel();
        members.setMemberCode(memberCode);
        ResponseData<com.bizvane.utils.responseinfo.PageInfo<MemberInfoModel>> memberInfo = memberInfoApiService.getMemberInfo(members);
        com.bizvane.utils.responseinfo.PageInfo<MemberInfoModel> data = memberInfo.getData();
        List<MemberInfoModel> list = data.getList();
        MemberInfoModel memberInfoModel=null;
        if (CollectionUtils.isNotEmpty(list)){
            memberInfoModel=list.get(0);
        }
        return memberInfoModel;
    }

    /**
     * 根据任务类型查询任务-已经审核
     */
    @Override
    public ResponseData<PageInfo<MktTaskPOWithBLOBs>> getTaskByTaskType(TaskVO vo, PageForm pageForm) {
        ResponseData<PageInfo<MktTaskPOWithBLOBs>> result = new ResponseData<PageInfo<MktTaskPOWithBLOBs>>(SysResponseEnum.SUCCESS.getCode(), TaskConstants.NO_RESPONSE, null);
        Integer showType = vo.getShowType();
        //1完善资料，2分享任务，3邀请注册，4累计消费次数，5累计消费金额',
        PageHelper.startPage(pageForm.getPageNumber(), pageForm.getPageSize());

        MktTaskPOExample mktTaskPOExample = new MktTaskPOExample();
        //查询所有
        if (TaskConstants.FIRST.equals(showType)) {
            mktTaskPOExample.createCriteria().andTaskTypeEqualTo(vo.getTaskType()).andSysBrandIdEqualTo(vo.getBrandId());
        } else if (TaskConstants.SECOND.equals(showType)) {
            //查询已启用
            mktTaskPOExample.createCriteria().andTaskTypeEqualTo(vo.getTaskType()).andSysBrandIdEqualTo(vo.getBrandId()).andValidEqualTo(Boolean.TRUE);
        } else if (TaskConstants.THREE.equals(showType)) {
            //查询已禁用
            mktTaskPOExample.createCriteria().andTaskTypeEqualTo(vo.getTaskType()).andSysBrandIdEqualTo(vo.getBrandId()).andValidEqualTo(Boolean.FALSE);
        }
        mktTaskPOExample.setOrderByClause("create_date desc");

        List<MktTaskPOWithBLOBs> lists = mktTaskPOMapper.selectByExampleWithBLOBs(mktTaskPOExample);

        if (CollectionUtils.isNotEmpty(lists)) {
            PageInfo<MktTaskPOWithBLOBs> pageInfo = new PageInfo<MktTaskPOWithBLOBs>(lists);
            result.setData(pageInfo);
            // result.setCode(SysResponseEnum.SUCCESS.getCode());
            result.setMessage(SysResponseEnum.SUCCESS.getMessage());
        }
        return result;
    }
}
