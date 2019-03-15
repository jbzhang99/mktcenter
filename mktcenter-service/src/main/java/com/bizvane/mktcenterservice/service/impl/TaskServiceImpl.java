package com.bizvane.mktcenterservice.service.impl;

import com.alibaba.fastjson.JSON;
import com.bizvane.centercontrolservice.models.po.SysSmsConfigPo;
import com.bizvane.centercontrolservice.models.vo.SmsConfigVo;
import com.bizvane.centercontrolservice.rpc.SysSmsConfigServiceRpc;
import com.bizvane.centerstageservice.models.po.SysBrandPo;
import com.bizvane.centerstageservice.models.po.SysCheckConfigPo;
import com.bizvane.centerstageservice.models.po.SysCheckPo;
import com.bizvane.centerstageservice.models.po.SysStorePo;
import com.bizvane.centerstageservice.models.vo.SysStoreVo;
import com.bizvane.centerstageservice.rpc.BrandServiceRpc;
import com.bizvane.centerstageservice.rpc.StoreServiceRpc;
import com.bizvane.centerstageservice.rpc.SysCheckConfigServiceRpc;
import com.bizvane.centerstageservice.rpc.SysCheckServiceRpc;
import com.bizvane.couponfacade.enums.SendTypeEnum;
import com.bizvane.couponfacade.interfaces.CouponDefinitionServiceFeign;
import com.bizvane.couponfacade.interfaces.CouponEntityServiceFeign;
import com.bizvane.couponfacade.interfaces.CouponQueryServiceFeign;
import com.bizvane.couponfacade.interfaces.SendCouponServiceFeign;
import com.bizvane.couponfacade.models.po.CouponDefinitionPO;
import com.bizvane.couponfacade.models.vo.CouponFindCouponCountResponseVO;
import com.bizvane.couponfacade.models.vo.CouponSendMemberListRequestVO;
import com.bizvane.couponfacade.models.vo.CouponSendMemberListResponseVO;
import com.bizvane.couponfacade.models.vo.SendCouponSimpleRequestVO;
import com.bizvane.members.facade.enums.BusinessTypeEnum;
import com.bizvane.members.facade.enums.IntegralChangeTypeEnum;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.service.api.IntegralChangeApiService;
import com.bizvane.members.facade.service.api.MemberInfoApiService;
import com.bizvane.members.facade.service.api.WxChannelInfoApiService;
import com.bizvane.members.facade.service.card.request.IntegralChangeRequestModel;
import com.bizvane.members.facade.service.card.response.IntegralChangeResponseModel;
import com.bizvane.members.facade.vo.MemberInfoApiModel;
import com.bizvane.members.facade.vo.PageVo;
import com.bizvane.members.facade.vo.WxChannelInfoVo;
import com.bizvane.messagefacade.interfaces.SendBatchMessageFeign;
import com.bizvane.messagefacade.interfaces.TemplateMessageServiceFeign;
import com.bizvane.messagefacade.models.vo.ActivityMessageVO;
import com.bizvane.messagefacade.models.vo.GenrealGetMessageVO;
import com.bizvane.messagefacade.models.vo.SmsStatisticsVO;
import com.bizvane.messagefacade.models.vo.SysSmsConfigVO;
import com.bizvane.mktcenterfacade.interfaces.TaskService;
import com.bizvane.mktcenterfacade.models.bo.AwardBO;
import com.bizvane.mktcenterfacade.models.bo.TaskAwardBO;
import com.bizvane.mktcenterfacade.models.bo.TaskBO;
import com.bizvane.mktcenterfacade.models.bo.TaskDetailBO;
import com.bizvane.mktcenterfacade.models.po.*;
import com.bizvane.mktcenterfacade.models.vo.*;
import com.bizvane.mktcenterservice.mappers.*;


import com.bizvane.mktcenterservice.common.constants.ResponseConstants;
import com.bizvane.mktcenterservice.common.constants.TaskConstants;
import com.bizvane.mktcenterservice.common.enums.CheckStatusEnum;
import com.bizvane.mktcenterservice.common.enums.MktSmartTypeEnum;
import com.bizvane.mktcenterservice.common.enums.TaskStatusEnum;
import com.bizvane.mktcenterservice.common.job.JobUtil;
import com.bizvane.mktcenterservice.common.utils.TimeUtils;

import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.jobutils.JobClient;
import com.bizvane.utils.jobutils.XxlJobInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;
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
    private JobUtil jobUtil;

    @Autowired
    private CouponQueryServiceFeign couponQueryService;
    @Autowired
    private MktTaskRecordPOMapper mktTaskRecordPOMapper;
    @Autowired
    private SysCheckServiceRpc sysCheckServiceRpc;
    @Autowired
    private MktCouponPOMapper mktCouponPOMapper;
    @Autowired
    private MktMessagePOMapper mktMessagePOMapper;
    @Autowired
    private WxChannelInfoApiService wxChannelInfoApiService;
    @Autowired
    private SysSmsConfigServiceRpc sysSmsConfigServiceRpc;
    @Autowired
    private CouponDefinitionServiceFeign couponDefinitionServiceFeign;
    @Autowired
    private StoreServiceRpc storeServiceRpc;
    @Autowired
    private TemplateMessageServiceFeign templateMessageServiceFeign;
    @Autowired
    private JobClient jobClient;
    @Autowired
    private CouponEntityServiceFeign couponEntityServiceFeign;

    @Autowired
    private BrandServiceRpc brandServiceRpc;
    @Autowired
    private SendBatchMessageFeign sendBatchMessageFeign;
    @Autowired
    private IntegralChangeApiService integralChangeApiService;
    @Autowired
    private SendCouponServiceFeign sendCouponServiceFeign;
    
    @Autowired
    private MktTaskCountPOMapper mktTaskCountPOMapper;

    /**
     * 通过id查询店铺列表
     */
    @Override
    public List<SysStorePo> getStoreListByIds(List<Long> sysStoreIdList) {
        List<SysStorePo> data = null;
        try {
            ResponseData<List<SysStorePo>> storeLists = storeServiceRpc.getIdStoreLists(sysStoreIdList);
            data = storeLists.getData();
        } catch (Exception e) {
            log.info("通过storeId查询中台店铺列表异常!---getStoreListByIds方法");
            e.printStackTrace();
        } finally {
            return data;
        }

    }

    /**
     * 查询短信数量
     */
    @Override
    public String searchSmsNum(GenrealGetMessageVO vo) {
        log.info("获取短信接口参数====" + JSON.toJSONString(vo));
        String result = "0/0";
        try {
            ResponseData<SmsStatisticsVO> returnData = templateMessageServiceFeign.getReturnMessage(vo);
            log.info("获取短信接口出参---" + JSON.toJSONString(returnData));
            SmsStatisticsVO data = returnData.getData();
            if (data != null) {
                Long allCountSms = data.getAllCountSms();
                Long failedSms = data.getFailedSms();
                // StringBuilder builder = new StringBuilder();
                StringBuffer builder = new StringBuffer();
                builder.append(failedSms);
                builder.append("/");
                builder.append(allCountSms);
                result = builder.toString();
            }
        } catch (Exception e) {
            log.info("获取短信接口异常!");
            e.printStackTrace();
        } finally {
            return result;
        }
    }

    /**
     * 查询店铺列表
     */
    @Override
    public ResponseData<List<SysStoreVo>> getWhiteStoreList(SysStoreVo vo, SysAccountPO sysAccountPo) {
        ResponseData<List<SysStoreVo>> responseData = new ResponseData<>();
        List<SysStoreVo> list = null;
        vo.setSysAccountId(sysAccountPo.getSysAccountId());
        vo.setSysCompanyId(sysAccountPo.getSysCompanyId());
        ResponseData<PageInfo<SysStoreVo>> returnData = storeServiceRpc.getSysStoreList(vo);
        PageInfo<SysStoreVo> data = returnData.getData();
        if (data != null) {
            list = data.getList();
            responseData.setData(list);
        } else {
            responseData.setMessage("没有相关的店铺列表!");
        }
        return responseData;
    }

    /**
     * '任务类型：1完善资料，2分享任务，3邀请注册，4累计消费次数，5累计消费金额'
     * 查询任务详情--已经核对
     *
     * @param mktTaskId
     * @return
     */
    @Override
    public ResponseData<TaskBO> selectTaskById(Long mktTaskId, Integer taskType) {
        ResponseData<TaskBO> responseData = new ResponseData<TaskBO>();
        try {
            TaskBO taskBO = new TaskBO();
            List<TaskVO> taskVOList = null;
            //联表查询查询任务详情
            if (TaskConstants.FIRST.equals(taskType)) {
                taskVOList = mktTaskPOMapper.getProfileTaskList(mktTaskId);
            } else if (TaskConstants.SECOND.equals(taskType)) {
                taskVOList = mktTaskPOMapper.getShareTaskList(mktTaskId);
            } else if (TaskConstants.THREE.equals(taskType)) {
                taskVOList = mktTaskPOMapper.getInviteTaskList(mktTaskId);
            } else {
                taskVOList = mktTaskPOMapper.getOrderTaskList(mktTaskId);
            }
            //查询券信息
            MktCouponPOExample example = new MktCouponPOExample();
            example.createCriteria().andValidEqualTo(true).andBizIdEqualTo(mktTaskId).andBizTypeEqualTo(2);
            List<MktCouponPO> mktCouponPOList = mktCouponPOMapper.selectByExample(example);
            //查询消息
            List<MktMessagePO> mktMessagePOList = new ArrayList<MktMessagePO>();
            MktMessagePOExample mktMessagePOExample = new MktMessagePOExample();
            mktMessagePOExample.createCriteria().andValidEqualTo(true).andBizIdEqualTo(mktTaskId).andBizTypeEqualTo(2);
            mktMessagePOList = mktMessagePOMapper.selectByExampleWithBLOBs(mktMessagePOExample);

            List<CouponDefinitionPO> couponDefinitionPOS = new ArrayList<>();
            if (CollectionUtils.isNotEmpty(mktCouponPOList)) {
                mktCouponPOList.stream().forEach(mktCouponPO -> {
                    Long couponDefinitionId = mktCouponPO.getCouponDefinitionId();
                    ResponseData<CouponDefinitionPO> coupon = couponDefinitionServiceFeign.findByIdRpc(couponDefinitionId);
                    CouponDefinitionPO couponDefinitionPO = coupon.getData();
                    couponDefinitionPOS.add(couponDefinitionPO);
                });
            }
            TaskVO taskVO = new TaskVO();
            List<SysStorePo> storeList = new ArrayList<SysStorePo>();
            if (CollectionUtils.isNotEmpty(taskVOList)) {
                taskVO = taskVOList.get(0);
                taskBO.setTaskVO(taskVO);
                String storeLimitList = taskVO.getStoreLimitList();
                if (taskVO != null && StringUtils.isNotBlank(storeLimitList)) {
                    List<Long> storeIdList = Arrays.asList(storeLimitList.split(",")).stream().map(element -> Long.valueOf(element)).collect(Collectors.toList());
                    //查询店铺列表
                    storeList = this.getStoreListByIds(storeIdList);
                    log.info("---------通过品牌Ids--" + JSON.toJSONString(storeList) + "-----获取店铺列表----------" + JSON.toJSONString(storeList));
                }
            }
            taskBO.setStoreList(storeList);
            taskBO.setTaskVO(taskVO);
            taskBO.setMessagePOList(mktMessagePOList);
            taskBO.setCouponDefinitionPOList(couponDefinitionPOS);

            responseData.setData(taskBO);
            responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
            responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        } catch (Exception e) {
            e.printStackTrace();
            responseData.setMessage(SysResponseEnum.FAILED.getMessage());
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            return responseData;
        }
        return responseData;
    }

    /**
     * 根据公司id和品牌id查询执行中的消费类任务
     *
     * @param sysCompanyId
     * @param sysBrandId
     * @return
     */
    @Override
    public List<TaskAwardBO> getTaskOrderAwardList(Long sysCompanyId, Long sysBrandId, Date placeOrderTime, Integer orderSource,Integer taskType) {
        String orderTime = "";
        if (placeOrderTime != null) {
            orderTime = TimeUtils.sdf.format(placeOrderTime);
        }else{
            orderTime = TimeUtils.sdf.format(new Date());
        }
        List<TaskAwardBO> taskOrderAwardList = mktTaskPOMapper.getTaskOrderAwardList(sysCompanyId, sysBrandId, orderTime, orderSource,taskType);
        log.info("--getTaskOrderAwardList订单奖励列表--" + sysCompanyId + "--" + sysBrandId + "--" + orderTime + "--" + orderSource + JSON.toJSONString(taskOrderAwardList));
        return taskOrderAwardList;
    }

    /**
     * 根据公司id和品牌id查询执行中的邀请类任务
     *
     * @param sysCompanyId
     * @param sysBrandId
     * @return
     */
    @Override
    public List<TaskAwardBO> getTaskInviteAwardList(Long mktTaskIdParam, Long sysCompanyId, Long sysBrandId, Date openCardTime) {
        String openCardStr = "";
        if (openCardTime == null) {
            openCardStr = TimeUtils.formatter.format(new Date());
        } else {
            openCardStr = TimeUtils.formatter.format(openCardTime);
        }
        log.info("邀请开卡的任务列表查询参数getTaskInviteAwardList-参数-" + mktTaskIdParam + "--" + sysCompanyId + "--" + sysBrandId + "--" + openCardStr);
        return mktTaskPOMapper.getTaskInviteAwardList(mktTaskIdParam, sysCompanyId, sysBrandId, openCardStr);
    }

    /**
     * 完善资料任务的奖励与详情
     *
     * @return
     */
    @Override
    public List<TaskAwardBO> getTaskProfileAwardList(Long mktTaskIdParam, Long sysCompanyId, Long sysBrandId, Date profileDate) {
        return mktTaskPOMapper.getTaskProfileAwardList(mktTaskIdParam, sysCompanyId, sysBrandId, profileDate);
    }
    @Override
    public List<TaskDetailBO> getTaskProfileListApp(ProfileSuccessVO vo) {
        return mktTaskPOMapper.getTaskProfileListApp(vo);
    }
    /**
     * 分享任务的奖励与详情
     *
     * @return
     */
    @Override
    public List<TaskAwardBO> getTaskShareAwardList(Long mktTaskIdparam, Long sysCompanyId, Long sysBrandId, Date shareDate) {
        String shareDateStr = "";
        if (shareDate == null) {
            shareDateStr = TimeUtils.formatter.format(new Date());
        } else {
            shareDateStr = TimeUtils.formatter.format(shareDate);
        }
        log.info("分享任务的奖励getTaskShareAwardList-参数-" + mktTaskIdparam + "--" + sysCompanyId + "--" + sysBrandId + "--" + shareDateStr);
        return mktTaskPOMapper.getTaskShareAwardList(mktTaskIdparam, sysCompanyId, sysBrandId, shareDateStr);
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
    public MktTaskPOWithBLOBs isOrNoCheckState(MktTaskPOWithBLOBs po, Integer centeStagecheckStatus) throws ParseException {
        //1.判断是否需要审核  1=需要审核   0=不需要
        // Integer checkStatus = this.getCenterStageCheckStage(po);
        //判断时间是否滞后   2=滞后执行    1=立即执行
        Integer ImmediatelyRunStatus = TimeUtils.IsImmediatelyRun(po.getStartTime());
        // checkStatus=1=需要审核
        if (TaskConstants.FIRST.equals(centeStagecheckStatus)) {
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
     * 在中台通过品牌Id查询任务是否需要审核
     *
     * @param po
     * @return
     */
    @Override
    public Integer getCenterStageCheckStage(MktTaskPOWithBLOBs po) {
        SysCheckConfigPo sysCheckConfigPo = new SysCheckConfigPo();
        sysCheckConfigPo.setSysBrandId(po.getSysBrandId());
        sysCheckConfigPo.setFunctionCode("C0003");
        return this.getCheckStatus(sysCheckConfigPo);
    }

    /**
     * 执行完善资料任务相关功能
     */
    @Override
    @Async
    public void doProfileTask(MktTaskPOWithBLOBs mktTaskPOWithBLOBs, List<MktMessagePO> mktmessagePOList, SysAccountPO stageUser) {
        //审核状态:1未审核，2审核中，3已审核，4已驳回',
        Integer checkStatus = mktTaskPOWithBLOBs.getCheckStatus();
        //执行状态:1待执行，2执行中，3已禁用，4已结束',
        Integer taskStatus = mktTaskPOWithBLOBs.getTaskStatus();
        if (TaskConstants.THREE.equals(checkStatus) && TaskConstants.SECOND.equals(taskStatus)) {
            this.sendSmg(mktTaskPOWithBLOBs, mktmessagePOList, stageUser);
        }
    }

    /**
     * 判断时间是否滞后,已经是否立即执行,还是创建job执行-已经核对
     */
    @Override
    @Async
    public void doOrderTask(MktTaskPOWithBLOBs mktTaskPOWithBLOBs, List<MktMessagePO> mktmessagePOList, SysAccountPO stageUser) {
        //审核状态:1未审核，2审核中，3已审核，4已驳回',
        Integer checkStatus = mktTaskPOWithBLOBs.getCheckStatus();
        //执行状态:1待执行，2执行中，3已禁用，4已结束',
        Integer taskStatus = mktTaskPOWithBLOBs.getTaskStatus();

        if (TaskConstants.THREE.equals(checkStatus) && TaskConstants.FIRST.equals(taskStatus)) {
            log.info("doOrderTask 已审核 待执行--" + checkStatus + "--" + taskStatus);
            //已审核 待执行,创建开始任务job和结束任务job,并且对发送短信和消息进行判断
            jobUtil.addTaskStartJob(stageUser, mktTaskPOWithBLOBs);
            jobUtil.addTaskEndJob(stageUser, mktTaskPOWithBLOBs);
            this.sendSmg(mktTaskPOWithBLOBs, mktmessagePOList, stageUser);
        } else if (TaskConstants.THREE.equals(checkStatus) && TaskConstants.SECOND.equals(taskStatus)) {
            log.info("doOrderTask 已审核 执中中--" + checkStatus + "--" + taskStatus);
            //已审核 执中中, 创建结束任务job,并且对发送短信和消息进行判断
            jobUtil.addTaskEndJob(stageUser, mktTaskPOWithBLOBs);
            this.sendSmg(mktTaskPOWithBLOBs, mktmessagePOList, stageUser);
        }
    }

    /**
     * 发送消息和短信 -已经核对
     */
    @Async
    @Override
    public void sendSmg(MktTaskPOWithBLOBs mktTaskPOWithBLOBs, List<MktMessagePO> mktmessagePOList, SysAccountPO stageUser) {
        Integer taskType = mktTaskPOWithBLOBs.getTaskType();
        log.info("完善资料任务发送消息或短信--" + taskType);
        if (TaskConstants.FIRST.equals(taskType)) {
            this.doSendprofilMsg(mktTaskPOWithBLOBs, mktmessagePOList, stageUser, taskType);
        } else {
            this.doSendNoprofilMsg(mktTaskPOWithBLOBs, mktmessagePOList, stageUser, taskType);
        }

    }

    //除了完善资料之外的其他任务发送消息和短信逻辑判断
    @Async
    public void doSendNoprofilMsg(MktTaskPOWithBLOBs mktTaskPOWithBLOBs, List<MktMessagePO> mktmessagePOList, SysAccountPO stageUser, Integer taskType) {
        log.info("doSendNoprofilMsg---参数--" + JSON.toJSONString(mktTaskPOWithBLOBs) + "--消息与短信--" + JSON.toJSONString(mktmessagePOList));
        if (CollectionUtils.isNotEmpty(mktmessagePOList)) {
            SendMessageVO sendMessageVO = this.getSendMessageVO(mktTaskPOWithBLOBs);
            mktmessagePOList.stream().forEach(
                    message -> {
                        Boolean exceptWechat = message.getExceptWechat();
                        String msgType = message.getMsgType();
                        String msgContent = message.getMsgContent();
                        sendMessageVO.setExceptWechat(exceptWechat);
                        sendMessageVO.setMsgType(msgType);
                        sendMessageVO.setMsgContent(msgContent);
                        //true=立刻   false=定时发送
                        Boolean sendImmediately = message.getSendImmediately();
                        //发送时间
                        Date sendTime = message.getSendTime();
                        //1=模板消息   所有的会员
                        if (TaskConstants.FIRST_STR.equals(msgType)) {
                            //立即发送
                            if (sendImmediately) {
                                this.sendMemberMessage(sendMessageVO);
                            } else if (!sendImmediately && sendTime != null) {
                                jobUtil.addMessageXXTaskJob(stageUser, mktTaskPOWithBLOBs, message);
                            }
                        }

                        //2=短信     所有粉丝
                        if (TaskConstants.SECOND_STR.equals(msgType)) {
                            if (sendImmediately) {
                                this.sendBachMSM(sendMessageVO);
                            } else if (!sendImmediately && sendTime != null) {
                                jobUtil.addMessageDXTaskJob(stageUser, mktTaskPOWithBLOBs, message);
                            }
                        }

                    }
            );
        }
    }

    //完善资料任务发送短信和消息任务的逻辑判断
    @Async
    public void doSendprofilMsg(MktTaskPOWithBLOBs mktTaskPOWithBLOBs, List<MktMessagePO> mktmessagePOList, SysAccountPO stageUser, Integer taskType) {
        log.info("---完善资料任务doSendprofilMsg---" + JSON.toJSONString(mktTaskPOWithBLOBs) + "--" + JSON.toJSONString(mktmessagePOList));
        if (CollectionUtils.isNotEmpty(mktmessagePOList)) {
            SendMessageVO sendMessageVO = this.getSendMessageVO(mktTaskPOWithBLOBs);
            mktmessagePOList.stream().forEach(
                    message -> {
                        log.info("循环中的信息发送---" + JSON.toJSONString(message));
                        Boolean exceptWechat = message.getExceptWechat();
                        String msgType = message.getMsgType();
                        String msgContent = message.getMsgContent();
                        sendMessageVO.setExceptWechat(exceptWechat);
                        sendMessageVO.setMsgType(msgType);
                        sendMessageVO.setMsgContent(msgContent);
                        //1=模板消息   所有的会员
                        if (TaskConstants.FIRST_STR.equals(msgType)) {
                            //立即发送
                            log.info("完善资料 模板消息---" + JSON.toJSONString(sendMessageVO));
                            this.sendMemberMessage(sendMessageVO);
                        }
                        //2=短信     所有粉丝
                        if (TaskConstants.SECOND_STR.equals(msgType)) {
                            log.info("完善资料 短信---" + JSON.toJSONString(sendMessageVO));
                            this.sendBachMSM(sendMessageVO);
                        }

                    }
            );
        }
    }

    /**
     * 获取发送消息和短信的VO
     *
     * @param mktTaskPOWithBLOBs
     * @return
     */
    @Override
    public SendMessageVO getSendMessageVO(MktTaskPOWithBLOBs mktTaskPOWithBLOBs) {
        SendMessageVO sendMessageVO = new SendMessageVO();
        sendMessageVO.setMktTaskId(mktTaskPOWithBLOBs.getMktTaskId());
        sendMessageVO.setTaskName(mktTaskPOWithBLOBs.getTaskName());
        sendMessageVO.setTaskType(mktTaskPOWithBLOBs.getTaskType());
        sendMessageVO.setSysCompanyId(mktTaskPOWithBLOBs.getSysCompanyId());
        sendMessageVO.setSysBrandId(mktTaskPOWithBLOBs.getSysBrandId());
        sendMessageVO.setStartTime(mktTaskPOWithBLOBs.getStartTime());
        sendMessageVO.setEndTime(mktTaskPOWithBLOBs.getEndTime());
        Integer points = mktTaskPOWithBLOBs.getPoints();
        if (points == null) {
            points = 0;
        }
        sendMessageVO.setPoints(points);
        return sendMessageVO;
    }

    //给会员发送微信消息
    @Async
    @Override
    public void sendMemberMessage(SendMessageVO sendMessageVO) {
        sendMessageVO.setExceptWechat(Boolean.FALSE);
        log.info("sendMemberMessage发送模板消息--参数--" + JSON.toJSONString(sendMessageVO));
        Long sysBrandId = sendMessageVO.getSysBrandId();
        ResponseData<SysBrandPo> brandByID = brandServiceRpc.getBrandByID(sysBrandId);
        SysBrandPo sysBrandPo = brandByID.getData();
        MktCouponPOExample mktCouponPOExample = new MktCouponPOExample();
        mktCouponPOExample.createCriteria().andBizIdEqualTo(sendMessageVO.getMktTaskId()).andBizTypeEqualTo(2).andValidEqualTo(Boolean.TRUE);
        List<MktCouponPO> mktCouponPOS = mktCouponPOMapper.selectByExample(mktCouponPOExample);
        StringBuffer stringBuffer = new StringBuffer();
        Integer points = sendMessageVO.getPoints();
        if (CollectionUtils.isNotEmpty(mktCouponPOS)) {
            String couponNames = mktCouponPOS.stream().map(fan -> fan.getCouponName()).collect(Collectors.joining("-"));
            stringBuffer.append(couponNames);
        }
        if (StringUtils.isNotBlank(stringBuffer.toString())) {
            stringBuffer.append("-");
        }
        if (points != null && points > 0) {
            stringBuffer.append(points).append("积分");
        }
        String activityInterests = stringBuffer.toString();
        com.bizvane.utils.responseinfo.PageInfo<MemberInfoModel> memeberspage = this.getCompanyMemebers(sendMessageVO, 1, 10000);
        if (memeberspage == null) {
            log.info("sendMemberMessage发送模板消息--无法查询到会员数据!");
            return;
        }
        List<MemberInfoModel> maemberlist = memeberspage.getList();
        int pages = memeberspage.getPages();
        if (CollectionUtils.isNotEmpty(maemberlist)) {
            for (int i = 1; i <= pages; i++) {
                com.bizvane.utils.responseinfo.PageInfo<MemberInfoModel> pagesdata = this.getCompanyMemebers(sendMessageVO, i, 10000);
                List<MemberInfoModel> list = pagesdata.getList();
                log.info("sendMemberMessage发送消息获取的会员列表--" + JSON.toJSONString(list));
                AwardBO memberBO = new AwardBO();
                //4=微信模板消息  营销
                memberBO.setMktType(MktSmartTypeEnum.SMART_TYPE_WXMESSAGE.getCode());
                list.stream().forEach(member -> {
                    ActivityMessageVO memberMessageVO = this.getActivityMessageVO(sendMessageVO, sysBrandId, sysBrandPo, activityInterests, member);
                    memberBO.setActivityMessageVO(memberMessageVO);
                    log.info("sendMemberMessage发送消息获取的每个会员详情--" + JSON.toJSONString(memberBO));
                    ResponseData<String> response = templateMessageServiceFeign.sendTemplateMessage(memberMessageVO);
                    log.info("sendMemberMessage发送微信返回参数=" + JSON.toJSONString(response));
                    // award.execute(memberBO);
                });
            }

        }
    }

    private ActivityMessageVO getActivityMessageVO(SendMessageVO sendMessageVO, Long sysBrandId, SysBrandPo sysBrandPo, String activityInterests, MemberInfoModel member) {
        ActivityMessageVO memberMessageVO = new ActivityMessageVO();
        memberMessageVO.setMemberCode(member.getMemberCode());
        memberMessageVO.setSysCompanyId(sendMessageVO.getSysCompanyId());
        memberMessageVO.setSysBrandId(sysBrandId);
        memberMessageVO.setSysBrandName(sysBrandPo.getBrandName());
        memberMessageVO.setActivityName(sendMessageVO.getTaskName());
        memberMessageVO.setActivityInterests(activityInterests);
        memberMessageVO.setMemberPhone(member.getPhone());
        memberMessageVO.setActivityStartDate(sendMessageVO.getStartTime());
        memberMessageVO.setActivityEndDate(sendMessageVO.getEndTime());
        memberMessageVO.setTemplateType("TASK_TEMPLATE_MESSAGE");
        memberMessageVO.setUnl(new StringBuilder(TaskConstants.WX_URL).append(sendMessageVO.getMktTaskId()).toString());
        return memberMessageVO;
    }

    //给粉丝 批量发送短信
    @Override
    public void sendBachMSM(SendMessageVO sendMessageVO) {
        log.info("批量发送短信--sendBachMSM--" + JSON.toJSONString(sendMessageVO));
        Integer batchNum = 500;
        Long sysBrandId = sendMessageVO.getSysBrandId();
        //获取营销短信通道
        SmsConfigVo smsConfigVo = new SmsConfigVo();
        smsConfigVo.setSysBrandId(sysBrandId);
        smsConfigVo.setChannelType(Integer.valueOf(10));
        smsConfigVo.setCompanyChannel(Boolean.FALSE);
        SysSmsConfigPo smsConfigPo = sysSmsConfigServiceRpc.getCenterControlChannel(smsConfigVo);
        if (smsConfigPo != null) {
            batchNum = smsConfigPo.getBatchNum();
        }
        log.info("sendBachMSM发送短信之获取短信通道的相关信息--出参" + JSON.toJSONString(smsConfigVo) + "--出参--" + JSON.toJSONString(smsConfigPo));
        com.bizvane.utils.responseinfo.PageInfo<MemberInfoModel> memeberspage = this.getCompanyMemebers(sendMessageVO, 1, batchNum);
        if (memeberspage == null) {
            log.info("sendBachMSM发送短信--无法查询到会员数据!");
            return;
        }
        List<MemberInfoModel> memberlist = memeberspage.getList();
        int pages = memeberspage.getPages();
        log.info("sendBachMSM获取页数---" + pages + "--" + JSON.toJSONString(memberlist));
        AwardBO fanBO = new AwardBO();
        //7=批量短信
        fanBO.setMktType(MktSmartTypeEnum.SMART_TYPE_MESSAGE_BATCH.getCode());
        SysSmsConfigVO messageVO = new SysSmsConfigVO();
        messageVO.setSysBrandId(sysBrandId);
        messageVO.setSysCompanyId(String.valueOf(sendMessageVO.getSysCompanyId()));
        messageVO.setMsgContent(sendMessageVO.getMsgContent());
        messageVO.setMsgId(String.valueOf(sendMessageVO.getMktTaskId()));

        if (CollectionUtils.isNotEmpty(memberlist)) {
            for (int i = 1; i <= pages; i++) {
                com.bizvane.utils.responseinfo.PageInfo<MemberInfoModel> onepagememebers = this.getCompanyMemebers(sendMessageVO, i, batchNum);
                List<MemberInfoModel> onelist = onepagememebers.getList();
                String pnones = onelist.stream().filter(fan -> StringUtils.isNotBlank(fan.getPhone())).map(fan -> fan.getPhone()).collect(Collectors.joining(","));
                messageVO.setPhones(pnones);
                fanBO.setSysSmsConfigVO(messageVO);
                log.info("sendBachMSM发送短信时的入参手机号--" + i + "--页数--" + JSON.toJSONString(fanBO));
                ResponseData<Integer> responseData = sendBatchMessageFeign.sendSmgBatch(messageVO);
                log.info("sendBachMSM发送短信返回参数=" + JSON.toJSONString(responseData));
                // award.execute(fanBO);
            }

        }
    }

    /**
     * 发送券和积分--已经核对
     * 任务类型：1完善资料，2分享任务，3邀请注册，4累计消费次数，5累计消费金额
     */
    @Override
    @Async("asyncServiceExecutor")
    public void sendCouponAndPoint(String memberCode, TaskAwardBO orderAwardBO) {
        log.info("发送券和积分sendCouponAndPoint--参数--" + memberCode + "---" + JSON.toJSONString(orderAwardBO));
        Long mktTaskId = orderAwardBO.getMktTaskId();
        String taskCode = orderAwardBO.getTaskCode();
        String taskName = orderAwardBO.getTaskName();
        List<MktCouponPO> mktCouponPOList = orderAwardBO.getMktCouponPOList();
        Integer points = orderAwardBO.getPoints();
        ChangeTaskTypeVO changeTaskTypeVO = this.changeTaskType(orderAwardBO.getTaskType());

        if (points != null && points > 0) {
            AwardBO bo = new AwardBO();
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
            log.info("任务发送积分的参数--" + JSON.toJSONString(integralRecordModel));
            IntegralChangeResponseModel integralChangeResponseModel = integralChangeApiService.integralChangeOperate(integralRecordModel);
            log.info("任务发积分结果打印======" + JSON.toJSONString(integralChangeResponseModel));
        }

        if (CollectionUtils.isNotEmpty(mktCouponPOList)) {
            //1=优惠券营销
            mktCouponPOList.stream().forEach(coupon -> {
                AwardBO bo = new AwardBO();
                bo.setMktType(MktSmartTypeEnum.SMART_TYPE_COUPON.getCode());
                Integer bizType = coupon.getBizType();
                //券id
                SendCouponSimpleRequestVO onecouponVO = new SendCouponSimpleRequestVO();
                onecouponVO.setMemberCode(memberCode);
                onecouponVO.setSendBussienId(mktTaskId);
                onecouponVO.setBusinessName(taskName);
                onecouponVO.setSendType(changeTaskTypeVO.getCouponTaskType());
                onecouponVO.setCouponDefinitionId(coupon.getCouponDefinitionId());
                onecouponVO.setBrandId(orderAwardBO.getSysBrandId());
                bo.setSendCouponSimpleRequestVO(onecouponVO);
                log.info("任务发送券的参数-----" + JSON.toJSONString(bo));
                // award.execute(bo);
                ResponseData<String> simple = sendCouponServiceFeign.simple(onecouponVO);
                log.info("任务发送券的结果------" + JSON.toJSONString(simple));
            });


        }
    }

    //发券和修改积分时的任务类型转换
    // 任务类型：1完善资料，2分享任务，3邀请注册，4累计消费次数，5累计消费金额
    @Override
    public ChangeTaskTypeVO changeTaskType(Integer taskType) {
        ChangeTaskTypeVO vo = new ChangeTaskTypeVO();
        switch (taskType) {
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
        //审核通过 执行中的任务不能被禁用
        MktTaskPOWithBLOBs po = mktTaskPOMapper.selectByPrimaryKey(mktTaskId);
        if (po != null && TaskConstants.THREE.equals(po.getCheckStatus()) && TaskConstants.SECOND.equals(po.getTaskStatus())) {
            responseData.setData(ResponseConstants.DATA_NOT_STOP);
        }

        MktTaskPOWithBLOBs mktTaskPOWithBLOBs = new MktTaskPOWithBLOBs();
        mktTaskPOWithBLOBs.setMktTaskId(mktTaskId);
        mktTaskPOWithBLOBs.setTaskStatus(TaskStatusEnum.TASK_STATUS_DISABLED.getCode());
        mktTaskPOWithBLOBs.setModifiedDate(new Date());
        mktTaskPOWithBLOBs.setModifiedUserId(sysAccountPO.getSysAccountId());
        mktTaskPOWithBLOBs.setModifiedUserName(sysAccountPO.getName());
        //mktTaskPOWithBLOBs.setValid(Boolean.FALSE);
        mktTaskPOMapper.updateByPrimaryKeySelective(mktTaskPOWithBLOBs);

        //禁用后要清除所有的job
        XxlJobInfo xxlJobInfo = new XxlJobInfo();
        xxlJobInfo.setBizCode(po.getTaskCode());
        jobClient.removeByBiz(xxlJobInfo);

        responseData.setData(ResponseConstants.SUCCESS_MSG);
        return responseData;
    }

    /**
     * 任务审核:通过/驳回
     * 需要传递任务开始时间,修改执行状态
     *
     * @param sysAccountPO
     * @return `checkStatus` '审核状态：1未审核，2审核中，3已审核，4已驳回'
     * `taskStatus` '任务状态：1待执行，2执行中，3已禁用，4已结束'
     */
    @Override
    public ResponseData<Integer> checkTaskById(CheckTaskVO vo, SysAccountPO sysAccountPO) throws ParseException {
        log.info("checkTaskById修改中台审核配置-----" + JSON.toJSONString(vo));
        ResponseData<Integer> responseData = new ResponseData<Integer>();
        Long mktTaskId = vo.getBusinessId();
        Integer businessType = vo.getBusinessType();
        Integer checkStatus = vo.getCheckStatus();
        String remark = vo.getRemark();
        Date startTime = vo.getStartTime();
        Date endTime = vo.getEndTime();
        Long sysCheckId = vo.getSysCheckId();
        String functionCode = vo.getFunctionCode();
        //审核时间超过任务结束时间
        if (endTime != null && endTime.before(new Date())) {
            responseData.setMessage("审核时间超过了任务的结束时间,已经无法审核!");
            return responseData;
        }
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
        } else {
            // 已驳回   待执行
            mktTaskPOWithBLOBs.setTaskStatus(TaskStatusEnum.TASK_STATUS_PENDING.getCode());
        }
        mktTaskPOWithBLOBs.setMktTaskId(mktTaskId);
        mktTaskPOWithBLOBs.setCheckStatus(checkStatus);
        mktTaskPOWithBLOBs.setRemark(remark);
        mktTaskPOWithBLOBs.setModifiedDate(new Date());
        mktTaskPOWithBLOBs.setModifiedUserId(sysAccountPO.getSysAccountId());
        mktTaskPOWithBLOBs.setModifiedUserName(sysAccountPO.getName());
        int i = mktTaskPOMapper.updateByPrimaryKeySelective(mktTaskPOWithBLOBs);
        //修改中台审核表的数据
        this.updateCheckData(mktTaskId, checkStatus, functionCode, sysAccountPO);
        log.info("checkTaskById审核通过后的任务状态---checkStatus--" + checkStatus + "--TaskStatus--" + mktTaskPOWithBLOBs.getTaskStatus());
        if (i > 0) {
            //3=已审核
            if (TaskConstants.THREE.equals(checkStatus)) {
                MktMessagePOExample exampleMSG = new MktMessagePOExample();
                exampleMSG.createCriteria().andBizIdEqualTo(mktTaskId).andValidEqualTo(Boolean.TRUE).andBizTypeEqualTo(2);
                List<MktMessagePO> mktMessagePOS = mktMessagePOMapper.selectByExample(exampleMSG);
                //List<TaskDetailVO> taskDetails = this.getTaskDetailByTaskId(mktTaskId);
                MktTaskPOWithBLOBs mktTaskPOWithBLOBsData = mktTaskPOMapper.selectByPrimaryKey(mktTaskId);
                this.doOrderTask(mktTaskPOWithBLOBsData, mktMessagePOS, sysAccountPO);
            }

        }
        return responseData;
    }

    /**
     * 效果分析的明细--已经审核
     */
    @Override
    public ResponseData<TaskRecordVO> doAnalysis(TaskAnalysisVo vo, SysAccountPO sysAccountPo) throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        System.out.println("-----开始时间" + startTime);
        ThreadPoolExecutor asyncExecutor = new ThreadPoolExecutor(
                10, 30, 60L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(120),
                new ThreadPoolExecutor.CallerRunsPolicy());
        ResponseData<TaskRecordVO> result = new ResponseData<TaskRecordVO>(SysResponseEnum.SUCCESS.getCode(), SysResponseEnum.SUCCESS.getMessage(), null);
        Long sysBrandId = sysAccountPo.getBrandId();
        vo.setBrandId(sysBrandId);
        TaskRecordVO taskRecordVO = new TaskRecordVO();
        //赠送总积分数
        final Long[] allPoints = {0L};
        //发行券总张数
        final Long[] allCountCoupon = {0L};
        //参与任务总人数
        final Long[] allCountMbr = {0L};
        //被核销优惠券总数
        final Long[] allinvalidCountCoupon = {0L};

        //任务类型
        Integer taskType = vo.getTaskType();
        String sendType = this.changeTaskType(taskType).getCouponTaskType();
        List<DayTaskRecordVo> analysisTotalData = mktTaskRecordPOMapper.getAnalysisTotalData(vo);

        if (CollectionUtils.isNotEmpty(analysisTotalData)) {
            // TaskRecordVO analysisTotalData1 = this.getAnalysisTotalData(vo, sysBrandId, taskRecordVO, allPoints, allCountCoupon, allCountMbr, allinvalidCountCoupon, sendType, analysisTotalData, asyncExecutor);
            analysisTotalData.stream().forEach(task -> {
                allPoints[0] = allPoints[0] + task.getOneTaskPoints();
                ResponseData<CouponFindCouponCountResponseVO> couponCount = couponQueryService.findCouponCountBySendBusinessId(task.getTaskId(), sendType, sysBrandId);
                CouponFindCouponCountResponseVO data = couponCount.getData();
                if (data != null) {
                    allCountCoupon[0] = allCountCoupon[0] + data.getCouponSum();
                    allinvalidCountCoupon[0] = allinvalidCountCoupon[0] + data.getCouponUsedSum();
                }
            });
            Long analysisTotalCompletePeple = mktTaskRecordPOMapper.getAnalysisTotalCompletePeple(vo);
            allCountMbr[0] = analysisTotalCompletePeple;
            //所有积分和
            taskRecordVO.setAllPoints(allPoints[0]);
            //所有券数量和
            taskRecordVO.setAllCountCoupon(allCountCoupon[0]);
            //所有参数人数和
            taskRecordVO.setAllCountMbr(allCountMbr[0]);
            //被核销优惠券总数
            taskRecordVO.setAllinvalidCountCoupon(allinvalidCountCoupon[0]);
        }

        //每个任务的券,积分,会员 总数
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        List<DayTaskRecordVo> data = mktTaskRecordPOMapper.getAnalysisResult(vo);
        PageInfo<DayTaskRecordVo> dayTaskRecordVoPage = new PageInfo<>(data);
        List<DayTaskRecordVo> analysislists = dayTaskRecordVoPage.getList();
        if (CollectionUtils.isNotEmpty(analysislists)) {
            ArrayList<DayTaskRecordVo> dayTaskRecordVos = new ArrayList<>();
            analysislists.parallelStream().forEach(task -> {
                Future<DayTaskRecordVo> submit = asyncExecutor.submit(() -> {
                    return this.getAnalysisData(sysBrandId, taskType, task, asyncExecutor, sendType);
                });
                try {
                    dayTaskRecordVos.add(submit.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            });
        }


        //每天或每条记录 的分页结果
        taskRecordVO.setDayTaskRecordVoList(dayTaskRecordVoPage);

        result.setData(taskRecordVO);
        long endTime = System.currentTimeMillis();
        System.out.println("----结束时间---" + (endTime - startTime));
        return result;
    }

    private TaskRecordVO getAnalysisTotalData(TaskAnalysisVo vo, Long sysBrandId, TaskRecordVO taskRecordVO, Long[] allPoints, Long[] allCountCoupon, Long[] allCountMbr, Long[] allinvalidCountCoupon, String sendType, List<DayTaskRecordVo> analysisTotalData, ThreadPoolExecutor asyncExecutor) throws ExecutionException, InterruptedException {
        Future<TaskRecordVO> submit = asyncExecutor.submit(() -> {
            analysisTotalData.parallelStream().forEach(task -> {
                allPoints[0] = allPoints[0] + task.getOneTaskPoints();
                ResponseData<CouponFindCouponCountResponseVO> couponCount = couponQueryService.findCouponCountBySendBusinessId(task.getTaskId(), sendType, sysBrandId);
                CouponFindCouponCountResponseVO data = couponCount.getData();
                if (data != null) {
                    allCountCoupon[0] = allCountCoupon[0] + data.getCouponSum();
                    allinvalidCountCoupon[0] = allinvalidCountCoupon[0] + data.getCouponUsedSum();
                }
            });
            Long analysisTotalCompletePeple = mktTaskRecordPOMapper.getAnalysisTotalCompletePeple(vo);
            allCountMbr[0] = analysisTotalCompletePeple;
            //所有积分和
            taskRecordVO.setAllPoints(allPoints[0]);
            //所有券数量和
            taskRecordVO.setAllCountCoupon(allCountCoupon[0]);
            //所有参数人数和
            taskRecordVO.setAllCountMbr(allCountMbr[0]);
            //被核销优惠券总数
            taskRecordVO.setAllinvalidCountCoupon(allinvalidCountCoupon[0]);
            return taskRecordVO;
        });
        return submit.get();
    }

    private DayTaskRecordVo getAnalysisData(Long sysBrandId, Integer taskType, DayTaskRecordVo task, ThreadPoolExecutor asyncExecutor, String sendType) {
        Long taskId = task.getTaskId();
        //查询每个任务的完成人数
        MktTaskRecordPOExample example = new MktTaskRecordPOExample();
        example.createCriteria().andTaskIdEqualTo(taskId).andRewardedEqualTo(1).andValidEqualTo(Boolean.TRUE);

        List<MktTaskRecordPO> mktTaskRecordresponse = mktTaskRecordPOMapper.selectByExampleWithBLOBs(example);
        if (CollectionUtils.isNotEmpty(mktTaskRecordresponse)) {
            task.setOneTaskCompleteCountMbr(Long.valueOf(mktTaskRecordresponse.size()));
        } else {
            task.setOneTaskCompleteCountMbr(0L);
        }
        Integer taskDates = task.getTaskDates();
        if (taskDates == null || taskDates < 0) {
            task.setTaskDates(0);
        }
        //查询短信数量
        GenrealGetMessageVO genrealGetMessageVO = new GenrealGetMessageVO();
        genrealGetMessageVO.setTaskId(taskId);
        genrealGetMessageVO.setSysBrandId(sysBrandId);
        String msgNUM = this.searchSmsNum(genrealGetMessageVO);
        task.setMsgNUM(msgNUM);

        //转换任务类型
        //String sendType = this.changeTaskType(taskType).getCouponTaskType();
        //查询券模块的统计出的相关数量
        ResponseData<CouponFindCouponCountResponseVO> couponCount = couponQueryService.findCouponCountBySendBusinessId(taskId, sendType, sysBrandId);
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
        return task;
    }

    /**
     * 新增任务主表任务数据
     *
     * @param task
     * @param stageUser todo   品牌  公司   创建人  创建时间
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
        
        MktTaskCountPO mktTaskCountPO = new MktTaskCountPO();
        mktTaskCountPO.setSysCompanyId(stageUser.getSysCompanyId());
        mktTaskCountPO.setSysBrandId(stageUser.getBrandId());
        mktTaskCountPO.setMktTaskId(task.getMktTaskId());
        mktTaskCountPO.setCreateUserName(stageUser.getName());
        mktTaskCountPO.setCreateUserId(stageUser.getSysAccountId());
        mktTaskCountPO.setCreateDate(new Date());
        
        mktTaskCountPOMapper.insertSelective(mktTaskCountPO);

        return task.getMktTaskId();
    }

    /**
     * 修改任务
     */
    @Override
    public Integer updateTask(MktTaskPOWithBLOBs task, SysAccountPO stageUser) {
        task.setModifiedDate(TimeUtils.getNowTime());
        task.setModifiedUserId(stageUser.getSysAccountId());
        task.setModifiedUserName(stageUser.getName());
        return mktTaskPOMapper.updateByPrimaryKeySelective(task);
    }

    /**
     * 将需要审核的任务添加到中台 --已经审核
     *
     * @param po
     */
    @Override
    public void addCheckData(MktTaskPOWithBLOBs po) {
        Integer checkStatus = po.getCheckStatus();
        log.info("-------addCheckData-----参数--" + checkStatus + "-----" + JSON.toJSONString(po));
        //待审核=1
        if (TaskConstants.FIRST.equals(checkStatus)) {
            SysCheckPo checkPo = new SysCheckPo();
            checkPo.setSysCompanyId(po.getSysCompanyId());
            checkPo.setSysBrandId(po.getSysBrandId());
            checkPo.setBusinessType(po.getTaskType());
            checkPo.setBusinessId(po.getMktTaskId());
            checkPo.setBusinessCode(po.getTaskCode());
            checkPo.setBusinessName(po.getTaskName());
            checkPo.setBizName(po.getTaskName());
            checkPo.setCheckStatus(CheckStatusEnum.CHECK_STATUS_PENDING.getCode());
            checkPo.setFunctionCode("C0003");
            checkPo.setCreateDate(po.getCreateDate());
            log.info("---addCheck--参数--" + JSON.toJSONString(checkPo));
            sysCheckServiceRpc.addCheck(checkPo);
        }

    }

    /**
     * 修改添加到中台任务的状态--已经审核
     */
    @Override
    public ResponseData<Integer> updateCheckData(Long mktTaskId, Integer checkStatus, String functionCode, SysAccountPO sysAccountPO) {
        log.info("修改中台审核配置---updateCheckData--" + mktTaskId + "----" + checkStatus);
        //已审核=3
        SysCheckPo checkPo = new SysCheckPo();
        checkPo.setBusinessId(mktTaskId);
        checkPo.setCheckStatus(checkStatus);
        checkPo.setFunctionCode(functionCode);
        checkPo.setModifiedDate(new Date());
        checkPo.setModifiedUserId(sysAccountPO.getCtrlAccountId());
        checkPo.setModifiedUserName(sysAccountPO.getName());
        return sysCheckServiceRpc.updateCheck(checkPo);
    }

    /**
     * 查询品牌下的所有会员,分页-已经审核
     */
    @Override
    public com.bizvane.utils.responseinfo.PageInfo<MemberInfoModel> getCompanyMemebers(SendMessageVO sendMessageVO, Integer pageNumber, Integer pageSize) {
        log.info("getCompanyMemebers查询相应的会员--参数--" + JSON.toJSONString(sendMessageVO) + "--" + pageNumber + "--" + pageSize);
        MemberInfoApiModel members = new MemberInfoApiModel();
        members.setSysCompanyId(sendMessageVO.getSysCompanyId());
        members.setBrandId(sendMessageVO.getSysBrandId());
        members.setPageNumber(pageNumber);
        members.setPageSize(pageSize);
        Boolean exceptWechat = sendMessageVO.getExceptWechat();
        log.info("getCompanyMemebers查询相应的会员--ExceptWechat--" + exceptWechat);
        // 会员范围(1:微信会员，2：全部会员(排除微信会员) 3真正的全部会员)
        members.setMemberScope(TaskConstants.ALL_REALY_MEMBER);
        //当是完善资料任务时,查询完善资料和未完善资料的任务
        if (TaskConstants.FIRST.equals(sendMessageVO.getTaskType())) {
            members.setDataIntegrityPercentage(0);
        }
        // 当except_wechat==true时,需要排除微信会员
        if (exceptWechat != null && exceptWechat) {
            members.setMemberScope(TaskConstants.ALL_MEMBER);
        }

        ResponseData<com.bizvane.utils.responseinfo.PageInfo<MemberInfoModel>> memberInfo = memberInfoApiService.getMemberInfo(members);
        com.bizvane.utils.responseinfo.PageInfo<MemberInfoModel> data = memberInfo.getData();
        log.info("会员数据------出参---"+JSON.toJSONString(members)+"------------------"+ JSON.toJSONString(data));
        return data;

    }

    /**
     * 查询某品牌下的粉丝---已经审核(废弃)
     */
    @Override
    public com.bizvane.utils.responseinfo.PageInfo<WxChannelInfoVo> getCompanyFans(Long sysBrandId, Integer pageNumber, Integer pageSize) {
        PageVo pageVo = new PageVo();
        pageVo.setPageNumber(pageNumber);
        pageVo.setPageSize(pageSize);
        ResponseData<com.bizvane.utils.responseinfo.PageInfo<WxChannelInfoVo>> data = wxChannelInfoApiService.queryWeChatFansAndMemberByBrandId(pageVo, sysBrandId);
        return data.getData();
    }

    /**
     * 查询公司下的某一会员的详情-已经审核
     */
    @Override
    public MemberInfoModel getCompanyMemeberDetail(String memberCode) {
        log.info("getCompanyMemeberDetail会员详情--参数--" + JSON.toJSONString(memberCode));
        MemberInfoApiModel members = new MemberInfoApiModel();
        members.setMemberCode(memberCode);
        ResponseData<MemberInfoModel> memberModel = memberInfoApiService.getMemberModel(members);
        MemberInfoModel memberInfoModel = memberModel.getData();
        log.info("getCompanyMemeberDetail会员详情--出参--" + JSON.toJSONString(memberInfoModel));
        return memberInfoModel;
    }

    /**
     * 根据任务类型查询任务-已经审核
     * 查询进行中的任务
     */
    @Override
    public ResponseData<PageInfo<MktTaskPOWithBLOBs>> getTaskByTaskType(TaskSearchVO vo) throws ParseException {
        log.info("---查询进行中的任务---参数--" + JSON.toJSONString(vo));
        List<MktTaskPOWithBLOBs> lists = null;
        ResponseData<PageInfo<MktTaskPOWithBLOBs>> result = new ResponseData<PageInfo<MktTaskPOWithBLOBs>>();

        //1完善资料，2分享任务，3邀请注册，4累计消费次数，5累计消费金额',
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        MktTaskPOExample mktTaskPOExample = new MktTaskPOExample();
        MktTaskPOExample.Criteria criteria = mktTaskPOExample.createCriteria();
        criteria.andTaskTypeEqualTo(vo.getTaskType()).andSysBrandIdEqualTo(vo.getBrandId());
        String taskName = vo.getTaskName();
        if (StringUtils.isNotBlank(taskName)) {
            criteria.andTaskNameLike(new StringBuilder().append("%").append(taskName).append("%").toString());
        }
        String taskCode = vo.getTaskCode();
        if (StringUtils.isNotBlank(taskCode)) {
            criteria.andTaskCodeLike(new StringBuilder().append("%").append(taskCode).append("%").toString());
        }
        //时间
        Date startTime = vo.getStartTime();
        if (startTime != null) {
            criteria.andCreateDateGreaterThanOrEqualTo(TimeUtils.formatter.parse(TimeUtils.sdf.format(startTime) + " 00:00:00"));
        }
        Date endTime = vo.getEndTime();
        if (endTime != null) {
            criteria.andCreateDateLessThanOrEqualTo(TimeUtils.formatter.parse(TimeUtils.sdf.format(endTime) + " 23:59:59"));
        }
        //"审核状态：1未审核，2审核中，3已审核，4已驳回"
        Integer checkStatus = vo.getCheckStatus();
        if (checkStatus != null) {
            criteria.andCheckStatusEqualTo(checkStatus);
        }
        //1待执行，2执行中，3已禁用，4已结束
        Integer taskStatus = vo.getTaskStatus();
        if (taskStatus != null) {
            criteria.andTaskStatusEqualTo(taskStatus);
        }
        mktTaskPOExample.setOrderByClause("create_date desc");

        lists = mktTaskPOMapper.selectByExampleWithBLOBs(mktTaskPOExample);

        if (CollectionUtils.isEmpty(lists)) {
            lists = new ArrayList<MktTaskPOWithBLOBs>();
        }
        PageInfo<MktTaskPOWithBLOBs> pageInfo = new PageInfo<MktTaskPOWithBLOBs>(lists);
        result.setData(pageInfo);
        return result;
    }


    /**
     * 活动、任务效果分析“发行优惠券”添加会员明细弹框；
     *
     * @return
     */
    @Override
    public ResponseData<PageInfo<CouponSendMemberListResponseVO>> findCouponSendResultTask(Long id, Integer type,
                                                                                           SysAccountPO stageUser, PageForm pageForm,
                                                                                           String name, String cardNo) {
        ResponseData responseData = new ResponseData();

        if (null == id) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.MODEL_FAILED_VALIDATION.getMessage());
            return responseData;
        }

        if (null == type) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.MODEL_FAILED_VALIDATION.getMessage());
            return responseData;
        }

        CouponSendMemberListRequestVO requestVO = new CouponSendMemberListRequestVO();
        requestVO.setSendBusinessId(id);
        //类型转换
        ChangeTaskTypeVO taskTypeVO = changeTaskType(type);
        requestVO.setSendType(taskTypeVO.getCouponTaskType());

        requestVO.setBrandId(stageUser.getBrandId());
        requestVO.setPageNumber(pageForm.getPageNumber());
        requestVO.setPageSize(pageForm.getPageSize());
        requestVO.setName(name);
        requestVO.setCardNo(cardNo);

        ResponseData<PageInfo<CouponSendMemberListResponseVO>> sendMemberListResult = couponEntityServiceFeign.findCouponSendMemberList(requestVO);

        responseData.setData(sendMemberListResult.getData());
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }

    /**
     * 查询白名单店铺Id
     * mktTaskProfilePOMapper   mktTaskSharePOMapper  mktTaskInvitePOMapper  mktTaskOrderPOMapper
     */
    @Override
    public List<Long> getWhiteStoreIds(WhiteStoreVO vo) {
        List<Long> storeIds = null;
        Date startTime = vo.getStartTime();
        Date endTime = vo.getEndTime();
        if (startTime != null) {
            vo.setDate1(TimeUtils.formatter.format(startTime));
        }
        if (endTime != null) {
            vo.setDate2(TimeUtils.formatter.format(endTime));
        }
        try {
            List<WhiteStoreResultVO> whiteStoreIds = mktTaskPOMapper.getWhiteStoreIds(vo);
            if (CollectionUtils.isEmpty(whiteStoreIds)) {
                return storeIds;
            }
            WhiteStoreResultVO whiteStoreResultVO = whiteStoreIds.get(0);
            String storeLimitType = whiteStoreResultVO.getStoreLimitType();
            if (StringUtils.isNotBlank(storeLimitType) && storeLimitType.contains("0")) {
                storeIds = brandServiceRpc.getStoreIdsByBrandId(vo.getSysbrandId()).getData();
                return storeIds;
            }
            String storeLimitList = whiteStoreResultVO.getStoreLimitList();
            if (StringUtils.isNotBlank(storeLimitList)) {
                storeIds = Arrays.asList(storeLimitList.split(",")).stream().filter(element -> StringUtils.isNotBlank(element)).
                        map(element -> Long.valueOf(element)).distinct().collect(Collectors.toList());
                return storeIds;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("getWhiteStoreIds--异常--");
        } finally {
            log.info("getWhiteStoreIds---出参-----" + JSON.toJSONString(storeIds));
            return storeIds;
        }
    }
}