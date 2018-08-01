package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.centerstageservice.interfaces.SysCheckService;
import com.bizvane.centerstageservice.models.po.SysCheckConfigPo;
import com.bizvane.centerstageservice.models.po.SysCheckPo;
import com.bizvane.centerstageservice.models.vo.SysCheckConfigVo;
import com.bizvane.centerstageservice.rpc.SysCheckConfigServiceRpc;
import com.bizvane.centerstageservice.rpc.SysCheckServiceRpc;
import com.bizvane.couponfacade.interfaces.SendCouponServiceFeign;
import com.bizvane.couponfacade.models.vo.SendCouponSimpleRequestVO;
import com.bizvane.members.facade.enums.IntegralBusinessTypeEnum;
import com.bizvane.members.facade.enums.IntegralChangeTypeEnum;
import com.bizvane.members.facade.models.IntegralRecordModel;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.service.api.IntegralRecordApiService;
import com.bizvane.mktcenterservice.interfaces.TaskProfileService;
import com.bizvane.mktcenterservice.models.bo.TaskBO;
import com.bizvane.mktcenterservice.models.po.*;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.models.vo.MessageVO;
import com.bizvane.mktcenterservice.models.vo.TaskVO;
import com.bizvane.mktcenterserviceimpl.common.enums.BusinessTypeEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.CheckStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.TaskStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.TaskTypeEnum;
import com.bizvane.mktcenterserviceimpl.common.utils.CodeUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.JobUtil;
import com.bizvane.mktcenterserviceimpl.mappers.*;
import com.bizvane.utils.commonutils.PageForm;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author gengxiaoyu
 * @date on 2018/7/16 14:13
 * @description 完善资料任务
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@Service
public class TaskProfileServiceImpl implements TaskProfileService {

    @Autowired
    private MktTaskProfilePOMapper mktTaskProfilePOMapper;

    @Autowired
    private SysCheckConfigServiceRpc sysCheckConfigServiceRpc;

    @Autowired
    private JobUtil jobUtil;

    @Autowired
    private MktTaskPOMapper mktTaskPOMapper;

    @Autowired
    private MktCouponPOMapper mktCouponPOMapper;

    @Autowired
    private MktMessagePOMapper mktMessagePOMapper;

    @Autowired
    private SysCheckServiceRpc sysCheckServiceRpc;

    @Autowired
    private MktTaskRecordPOMapper mktTaskRecordPOMapper;

    @Autowired
    private IntegralRecordApiService integralRecordApiService;

    @Autowired
    private SendCouponServiceFeign sendCouponServiceFeign;

    @Autowired
    private MktCouponPOMapper mktCouponPOMapper;



    /**
     * 新建完善资料任务
     * @param bo
     * @param stageUser
     * @return
     */
    @Override
    public ResponseData<Integer> addTask(TaskBO bo, SysAccountPO stageUser) {
        //创建任务对象
        TaskVO taskVO = bo.getTaskVO();
        //需要返回的对象
        ResponseData responseData = new ResponseData();

        String taskCode = CodeUtil.getTaskCode();
        //将任务编号添加进vo对象
        taskVO.setTaskCode(taskCode);
        //添加任务类型为完善资料  或者任务类型是前端传回来的？
        taskVO.setTaskType(TaskTypeEnum.TASK_TYPE_PROFILE.getCode());



        //判断完善资料任务是否有重复
        TaskVO vo =  new TaskVO();
        //完善资料是针对品牌还是商家？conpany or brand？and此处的id到底是stageuser携带过来额还是taskvo携带来的
        vo.setSysCompanyId(stageUser.getSysCompanyId());
        vo.setTaskType(taskVO.getTaskType());//或者直接填完善资料的任务类型???
        List<TaskVO> taskVOList = mktTaskProfilePOMapper.getTaskList(vo);
        //集合不为空，则说明设置重复
        if (!CollectionUtils.isEmpty(taskVOList)){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage("完善资料任务已存在，不可重复创建");
            return responseData;
        }


        //判断任务是否需要审核

        SysCheckConfigVo sysCheckConfigVo = new SysCheckConfigVo();
        sysCheckConfigVo.setSysBrandId(taskVO.getSysBrandId());
        //sysCheckConfigVo.setFunctionCode(taskVO.);
        ResponseData<List<SysCheckConfigVo>> rls = sysCheckConfigServiceRpc.getCheckConfigListAll(sysCheckConfigVo);
        List<SysCheckConfigVo> sysCheckConfigVoList = rls.getData();
        int i = 0;


        //所查集合不为空 该品牌可能有功能需要审核
        if(!CollectionUtils.isEmpty(sysCheckConfigVoList)){
            for(SysCheckConfigVo sysCheckConfigVo1:sysCheckConfigVoList){
                //会员任务需要审核   会员任务的编号是C0003？
                if (sysCheckConfigVo1.getFunctionCode().equals("C0003")){
                    i+=1;
                    }
                }
            }
         //会员任务需要审核
        if(i>0){
            //新增审核单  任务状态为：待审核
            taskVO.setCheckStatus(CheckStatusEnum.CHECK_STATUS_PENDING.getCode());

            /*//新增一条审核配置单，审核配置单是不需要任务模块添加的吧
            SysCheckConfigPo sysCheckConfigPo = new SysCheckConfigPo();
            sysCheckConfigPo.setSysBrandId(taskVO.getSysBrandId());
            sysCheckConfigPo.setFunctionName("会员任务");
            sysCheckConfigPo.setFunctionCode("C0003");//写成枚举？
            sysCheckConfigPo.setCreateDate(new Date());
            sysCheckConfigPo.setCreateUserName(stageUser.getName());
            sysCheckConfigPo.setCreateUserId(stageUser.getSysAccountId());
            sysCheckConfigServiceRpc.addCheckConfig(sysCheckConfigPo);*/


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
            sysCheckServiceRpc.addCheck(sysCheckPo);


            //任务时间不滞后

            taskVO.setTaskStatus(TaskStatusEnum.TASK_STATUS_PENDING.getCode());
        }//如果不需要审核
        else{
            //任务时间不滞后
            taskVO.setCheckStatus(CheckStatusEnum.CHECK_STATUS_APPROVED.getCode());
            taskVO.setTaskStatus(TaskStatusEnum.TASK_STATUS_EXECUTING.getCode());
        }

        //将数据插入任务主表
        taskVO.setCreateDate(new Date());
        taskVO.setCreateUserName(stageUser.getName());
        taskVO.setCreateUserId(stageUser.getSysAccountId());

        MktTaskPOWithBLOBs mktTaskPOWithBLOBs = new MktTaskPOWithBLOBs();
        BeanUtils.copyProperties(taskVO,mktTaskPOWithBLOBs);
        mktTaskPOMapper.insert(mktTaskPOWithBLOBs);

        Long taskVOId = mktTaskPOWithBLOBs.getMktTaskId();

        //将数据插入完善资料任务表
        MktTaskProfilePO mktTaskProfilePO = new MktTaskProfilePO();
        mktTaskProfilePO.setCreateDate(new Date());
        mktTaskProfilePO.setCreateUserId(stageUser.getSysAccountId());
        mktTaskProfilePO.setCreateUserName(stageUser.getName());
        mktTaskProfilePO.setMktTaskId(taskVOId);
        //将客户选择会员需要完善的扩展属性添加进完善资料任务表
        mktTaskProfilePO.setPropertyCode(taskVO.getPropertyCode());
        mktTaskProfilePOMapper.insertSelective(mktTaskProfilePO);

        //需要发奖励
        if (!CollectionUtils.isEmpty(bo.getMktCouponPOList())){
            for (MktCouponPO mktCouponPO:bo.getMktCouponPOList()){
                //增加券
                MktCouponPO mktCouponPO1 = new MktCouponPO();
                mktCouponPO1.setCreateUserName(stageUser.getName());
                mktCouponPO1.setCreateUserId(stageUser.getSysAccountId());
                mktCouponPO1.setCreateDate(new Date());
                mktCouponPO1.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_TASK.getCode());
                mktCouponPO1.setCouponName(mktCouponPO.getCouponName());
                mktCouponPO1.setCouponId(mktCouponPO.getCouponId());//是id还是code
                mktCouponPO1.setCouponCode(mktCouponPO.getCouponCode());
                mktCouponPO1.setBizId(taskVOId);

                mktCouponPOMapper.insertSelective(mktCouponPO1);

            }
        }

        //需要发消息

        if(!CollectionUtils.isEmpty(bo.getMessageVOList())){
            for (MessageVO messageVO:bo.getMessageVOList()){
                MessageVO messageVO1 = new MessageVO();
                messageVO1.setMsgType(messageVO.getMsgType());
                messageVO1.setSendTime(messageVO.getSendTime());//开始发送时间是当创建任务之后立即发送还是？

                MktMessagePO mktMessagePO = new MktMessagePO();
                BeanUtils.copyProperties(messageVO1,mktMessagePO);
                mktMessagePO.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_TASK.getCode());
                mktMessagePO.setCreateDate(new Date());
                BeanUtils.copyProperties(mktTaskProfilePO,mktMessagePO);
                mktMessagePO.setMsgContent(messageVO.getMsgContent());
                mktMessagePO.setBizId(taskVOId);
                //模板消息id？哪里的？
                mktMessagePOMapper.insertSelective(mktMessagePO);
            }
        }

        return responseData;
    }



    /**
     * 修改任务
     * @param bo
     * @param stageUser
     * @return
     */
    @Override
    public ResponseData<Integer> updateTask(TaskBO bo, SysAccountPO stageUser) {

        ResponseData responseData = new ResponseData();
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

        //更新完善资料任务表

        MktTaskProfilePO mktTaskProfilePO = new MktTaskProfilePO();
        mktTaskProfilePO.setModifiedDate(new Date());
        mktTaskProfilePO.setModifiedUserId(stageUser.getSysAccountId());
        mktTaskProfilePO.setModifiedUserName(stageUser.getName());

        mktTaskProfilePO.setPropertyCode(taskVO.getPropertyCode());
        mktTaskProfilePOMapper.updateByPrimaryKeySelective(mktTaskProfilePO);

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
                mktCouponPO2.setCouponCode(mktCouponPO1.getCouponCode());
                mktCouponPO2.setCouponName(mktCouponPO1.getCouponName());
                mktCouponPO2.setCouponId(mktCouponPO1.getCouponId());
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
        List<MessageVO> mktMessageVOList = bo.getMessageVOList();

        if(!CollectionUtils.isEmpty(mktMessageVOList)){
            for(MessageVO messageVO:mktMessageVOList){
                MktMessagePO mktMessagePO = new MktMessagePO();
                mktMessagePO.setMsgContent(messageVO.getMsgContent());
                mktMessagePO.setCreateDate(new Date());
                mktMessagePO.setBizId(taskVO.getMktTaskId());
                mktMessagePO.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_TASK.getCode());
                mktMessagePO.setCreateUserId(stageUser.getSysAccountId());
                mktMessagePO.setCreateUserName(stageUser.getName());
                mktMessagePO.setMsgType(messageVO.getMsgType());
                mktMessagePO.setSendTime(messageVO.getSendTime());
                //消息编号？模板？
                mktMessagePOMapper.insertSelective(mktMessagePO);
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
    public ResponseData<List<TaskVO>> selectTaskById(Long mktTaskId) {
        ResponseData responseData = new ResponseData();
        TaskVO taskVO = new TaskVO();
        taskVO.setMktTaskId(mktTaskId);
        List<TaskVO> taskVOList = mktTaskProfilePOMapper.getTaskList(taskVO);
        responseData.setData(taskVOList);
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        return responseData;
    }

    /*@Override
    public ResponseData getChosenExtendProperty(Long brandId) {
        return null;
    }*/

    /**
     * 查询商家选择出的让会员完善的扩展信息字段   用不到了！！！！！
     * @param brandId
     * @return
     *//*
    @Override
    public ResponseData<List<String>> getChosenExtendProperty(Long brandId){
        ResponseData responseData = new ResponseData();
        TaskVO taskVO = new TaskVO();
        taskVO.setSysBrandId(brandId);
        String properties = mktTaskProfilePOMapper.getChosenExtendProperties(taskVO);
        String[] property = properties.split(",");
        List<String> list = new ArrayList<>();
        for(String p:property){
            list.add(p);
        }
        responseData.setData(list);
        return responseData;
    }*/


    /**
     * 根据时间查询完善资料的人数及发行的优惠券以及积分
     * @param date1
     * @param date2
     * @return
     */
   @Override
    public ResponseData<List<MktTaskRecordPO>> getTaskProfileRecordByTime(Date date1,Date date2){
        ResponseData responseData = new ResponseData();
        MktTaskRecordPOExample example = new MktTaskRecordPOExample();
        MktTaskRecordPOExample.Criteria criteria = example.createCriteria();
        criteria.andParticipateDateBetween(date1,date2);
        List<MktTaskRecordPO> mktTaskRecordPOList = mktTaskRecordPOMapper.selectByExample(example);
        responseData.setData(mktTaskRecordPOList);

        return null;
    }


    /**
     * 任务审核
     * @param taskVO
     * @param sysAccountPO
     * @return
     */
    @Override
    public ResponseData checkTaskProfile(TaskVO taskVO,SysAccountPO sysAccountPO){
        ResponseData data = new ResponseData();

        return null;
    }

    /**
     * 执行任务
     * @param vo 或者传回的是任务编号？
     * @param memberInfoModel 或者传回的是会员编号？
     * @return
     */
    @Override
    public ResponseData executeTask(TaskVO vo, MemberInfoModel memberInfoModel) {
        ResponseData responseData = new ResponseData();
        //查询出该品牌下完善资料的任务   so传过来的参数到底是什么呢
/*        TaskVO taskVO = new TaskVO();
        taskVO.setSysBrandId(memberInfoModel.getBrandId());
        taskVO.setTaskCode(taskVO.getTaskCode());
        taskVO.setTaskType(TaskTypeEnum.TASK_TYPE_PROFILE.getCode());*/
        MktTaskPO mktTaskPO = mktTaskPOMapper.selectByPrimaryKey(vo.getMktTaskId());


            //调用会员模块为会员加积分
            IntegralRecordModel integralRecordModel = new IntegralRecordModel();
            integralRecordModel.setMemberCode(memberInfoModel.getMemberCode());
            integralRecordModel.setMemberName(memberInfoModel.getName());
            integralRecordModel.setChangeBills(UUID.randomUUID().toString().replaceAll("-",""));
            integralRecordModel.setChangeDate(new Date());
            integralRecordModel.setChangeIntegral(vo.getPoints());
            integralRecordModel.setChangeWay(IntegralChangeTypeEnum.INCOME.getCode());
            integralRecordModel.setBusinessWay(IntegralBusinessTypeEnum.TASK_INCOME.getCode());

            integralRecordApiService.updateMemberIntegral(integralRecordModel);

            //调用发券模块为会员发券   券可能多张，且券的消息需要从task_coupon中查出来

            MktCouponPOExample mktCouponPOExample = new MktCouponPOExample();
            MktCouponPOExample.Criteria criteria = mktCouponPOExample.createCriteria();
            criteria.andBizIdEqualTo(vo.getMktTaskId()).andBizTypeEqualTo(BusinessTypeEnum.ACTIVITY_TYPE_TASK.getCode()).andValidEqualTo(true);


            List<MktCouponPO> mktCouponPOList = mktCouponPOMapper.selectByExample(mktCouponPOExample);

            //遍历券信息添加

            for (MktCouponPO mktCouponPO:mktCouponPOList){
                SendCouponSimpleRequestVO sendCouponSimpleRequestVO = new SendCouponSimpleRequestVO();
                sendCouponSimpleRequestVO.setMemberCode(memberInfoModel.getMemberCode());
                sendCouponSimpleRequestVO.setSendBussienId(mktCouponPO.getBizId());
                sendCouponSimpleRequestVO.setCouponDefinitionId(mktCouponPO.getCouponId());//id还是code？？？
                sendCouponSimpleRequestVO.getSendType();//sendtype是？？
                sendCouponServiceFeign.simple(sendCouponSimpleRequestVO);
            }



        return responseData;
    }




}
