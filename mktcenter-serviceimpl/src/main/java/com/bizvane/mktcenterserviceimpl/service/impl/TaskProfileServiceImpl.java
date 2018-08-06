package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.centerstageservice.interfaces.SysCheckService;
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
import com.bizvane.couponfacade.models.vo.CouponFindCouponCountResponseVO;
import com.bizvane.couponfacade.models.vo.SendCouponSimpleRequestVO;
import com.bizvane.members.facade.enums.IntegralBusinessTypeEnum;
import com.bizvane.members.facade.enums.IntegralChangeTypeEnum;
import com.bizvane.members.facade.models.IntegralRecordModel;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.service.api.IntegralRecordApiService;
import com.bizvane.mktcenterservice.interfaces.TaskProfileService;
import com.bizvane.mktcenterservice.models.bo.AwardBO;
import com.bizvane.mktcenterservice.models.bo.TaskBO;
import com.bizvane.mktcenterservice.models.po.*;
import com.bizvane.mktcenterservice.models.vo.*;
import com.bizvane.mktcenterserviceimpl.common.award.Award;
import com.bizvane.mktcenterserviceimpl.common.enums.*;
import com.bizvane.mktcenterserviceimpl.common.utils.CodeUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.JobUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.TaskParamCheckUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.TimeUtils;
import com.bizvane.mktcenterserviceimpl.mappers.*;
//import com.bizvane.utils.commonutils.PageForm;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;

import static javafx.scene.input.KeyCode.L;

/**
 * @author gengxiaoyu
 * @date on 2018/7/16 14:13
 * @description 完善资料任务
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@Service
@Slf4j
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


    @Autowired
    private CouponQueryServiceFeign couponQueryServiceFeign;

    @Autowired
    private Award award;

    @Autowired
    private CouponDefinitionServiceFeign couponDefinitionServiceFeign;



    /**
     * 新建完善资料任务
     * @param bo
     * @param stageUser
     * @return
     */
    @Override
    @Transactional

    public ResponseData<Integer> addTask(TaskBO bo, SysAccountPO stageUser) {
        //创建任务对象
        TaskVO taskVO = bo.getTaskVO();
        //需要返回的对象
        ResponseData responseData = new ResponseData();

        String taskCode = CodeUtil.getTaskCode();
        //将任务编号添加进vo对象
        taskVO.setTaskCode(taskCode);
        //添加任务类型为完善资料
        taskVO.setTaskType(TaskTypeEnum.TASK_TYPE_PROFILE.getCode());

        //判断完善资料任务是否有重复
        TaskVO vo =  new TaskVO();
        //完善资料是针对品牌还是商家？conpany or brand？and此处的id到底是stageuser携带过来额还是taskvo携带来的
        vo.setSysBrandId(stageUser.getBrandId());
        vo.setTaskType(taskVO.getTaskType());//或者直接填完善资料的任务类型???

        MktTaskPOExample mktTaskPOExample = new MktTaskPOExample();
        mktTaskPOExample.createCriteria().andValidEqualTo(true).andSysBrandIdEqualTo(taskVO.getSysBrandId()).andTaskTypeEqualTo(TaskTypeEnum.TASK_TYPE_PROFILE.getCode());
        List<MktTaskPO> taskPOList = mktTaskPOMapper.selectByExample(mktTaskPOExample);
        //集合不为空，则说明设置重复
        if (!CollectionUtils.isEmpty(taskPOList)){
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


            //新增一条审核单
            //functioncode和functionname分别指的是什么？
            SysCheckPo sysCheckPo = new SysCheckPo();
            sysCheckPo.setSysBrandId(taskVO.getSysBrandId());
            sysCheckPo.setFunctionCode("C0003");//写成枚举？
//            sysCheckPo.setb
            sysCheckPo.setCreateDate(new Date());
            sysCheckPo.setCreateUserName(stageUser.getName());
            sysCheckPo.setCreateUserId(stageUser.getSysAccountId());
            sysCheckPo.setSysBrandId(taskVO.getSysBrandId());
            sysCheckPo.setCheckStatus(CheckStatusEnum.CHECK_STATUS_PENDING.getCode());
            sysCheckPo.setBusinessType(BusinessTypeEnum.ACTIVITY_TYPE_TASK.getCode());
            sysCheckPo.setBusinessId(taskVO.getMktTaskId());
            sysCheckPo.setBusinessCode(taskVO.getTaskCode());
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

        if(!CollectionUtils.isEmpty(bo.getMessagePOList())){
            for (MktMessagePO messagePO:bo.getMessagePOList()){
                MktMessagePO messageVO1 = new MessageVO();
                messageVO1.setMsgType(messagePO.getMsgType());
                messageVO1.setSendTime(new Date());//完善资料任务无开始时间  so……创建任务之后立即发送消息？

                MktMessagePO mktMessagePO = new MktMessagePO();
                BeanUtils.copyProperties(messageVO1,mktMessagePO);
                mktMessagePO.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_TASK.getCode());
                mktMessagePO.setCreateDate(new Date());
                BeanUtils.copyProperties(mktTaskProfilePO,mktMessagePO);
                mktMessagePO.setMsgContent(messagePO.getMsgContent());
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
    @Transactional
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
            sysCheckPo.setBusinessId(taskVO.getMktTaskId());
            sysCheckPo.setBusinessCode(taskVO.getTaskCode());
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

        return responseData;
    }

    /**
     * 查询任务详情
     * @param mktTaskId
     * @return
     */
    @Override
    @Transactional
    public ResponseData<TaskBO> selectTaskById(Long mktTaskId) {
        ResponseData responseData = new ResponseData();
        TaskBO taskBO = new TaskBO();
        TaskVO taskVO = new TaskVO();
        taskVO.setMktTaskId(mktTaskId);
        //联表查询查询任务详情
        List<TaskVO> taskVOList = mktTaskProfilePOMapper.getTaskList(taskVO);
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
        //查询券定义
        for (MktCouponPO mktCouponPO:mktCouponPOList){
            Long couponDefinitionId = mktCouponPO.getCouponId();

            ResponseData<CouponDefinitionPO> coupon = couponDefinitionServiceFeign.findRpc(couponDefinitionId);
            CouponDefinitionPO couponDefinitionPO = coupon.getData();
            couponDefinitionPOS.add(couponDefinitionPO);
        }



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
        return responseData;
    }



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
     * 任务审核
     * @param taskVO
     * @param sysAccountPO
     * @return
     */
    @Override
    @Transactional
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
    @Transactional
    public ResponseData executeTask(TaskVO vo, MemberInfoModel memberInfoModel) {
        ResponseData responseData = new ResponseData();

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
            Long couponDefId = mktCouponPO.getCouponId();
            bo.setCouponDefinitionId(couponDefId);
            award.execute(bo);
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
        award.execute(bo2);

        return responseData;
    }

    /**
     * 效果分析
     * @param date1
     * @param date2
     * @param stageUser
     * @param pageForm
     * @return
     */
    @Override
    @Transactional
    public ResponseData<TaskRecordVO> getTaskProfileRecordByTime(Date date1, Date date2,SysAccountPO stageUser,PageForm pageForm){
        ResponseData responseData = new ResponseData();


        //根据任务类型，品牌id查询出任务得出所有参与该类型任务人数
        MktTaskRecordPOExample example = new MktTaskRecordPOExample();
        MktTaskRecordPOExample.Criteria criteria = example.createCriteria();
        criteria.andTaskTypeEqualTo(TaskTypeEnum.TASK_TYPE_PROFILE.getCode()).andSysBrandIdEqualTo(stageUser.getBrandId()).andValidEqualTo(true);

        //根据品牌id  任务类型查出该品牌下的完善资料任务
        MktTaskPOExample mktTaskPOExample = new MktTaskPOExample();
        MktTaskPOExample.Criteria criteria1 = mktTaskPOExample.createCriteria();
        criteria1.andTaskTypeEqualTo(TaskTypeEnum.TASK_TYPE_PROFILE.getCode()).andSysBrandIdEqualTo(stageUser.getBrandId()).andValidEqualTo(true);

        List<MktTaskPO> mktTaskPOList = mktTaskPOMapper.selectByExample(mktTaskPOExample);
        MktTaskPO mktTaskPO = mktTaskPOList.get(0);


        //一、查出时间之内参与该任务的总人数
        if(date1!=null&&date2!=null){
            criteria.andParticipateDateBetween(date1,date2);
        }else if (date1!=null&&date2==null){
            criteria.andParticipateDateGreaterThanOrEqualTo(date1);
            date2=new Date();
        }else if (date1==null&&date2!=null){
            criteria.andParticipateDateLessThanOrEqualTo(date2);
            date1 = mktTaskPO.getStartTime();
        }
        Long countMbr = mktTaskRecordPOMapper.countByExample(example);
        TaskRecordVO taskRecordVO = new TaskRecordVO();

        //二、算出赠送总积分


        Integer taskPoints = mktTaskPO.getPoints();
        Long lTaskPoints = (long)taskPoints;
        Long allPoints = (countMbr*lTaskPoints);


        //三、算出赠送总券数
        //根据taskid查出该任务赠送券数

        MktCouponPOExample mktCouponPOExample = new MktCouponPOExample();
        MktCouponPOExample.Criteria criteria2 = mktCouponPOExample.createCriteria();
        criteria2.andBizIdEqualTo(mktTaskPO.getMktTaskId()).andValidEqualTo(true);
        Long oneTaskCoupon = mktCouponPOMapper.countByExample(mktCouponPOExample);
        Long allCountCoupon = countMbr*oneTaskCoupon;


        //四、已被核销的优惠券？todo

       /* CouponEntityPO couponEntityPO = new CouponEntityPO();

        couponEntityPO.setSendBusinessId(mktTaskPO.getMktTaskId());
        ResponseData<CouponFindCouponCountResponseVO> allInvalidCountCouponResp = couponQueryServiceFeign.findCouponCount(couponEntityPO);

        CouponFindCouponCountResponseVO allInvalidCountCoupon = allInvalidCountCouponResp.getData();
        int count =  allInvalidCountCoupon.getCouponUsedSum();*/


        //五、根据日期查询

        List<DayTaskRecordVo> dayTaskRecordVoList = new ArrayList<>();
        for (Date i = date1;i.after(date2);i=TimeUtils.getNextDay(i)){
            DayTaskRecordVo dayTaskRecordVo = new DayTaskRecordVo();
            //1.根据日期，任务类型，品牌id查询出任务得出每天所有参与该类型任务人数

            MktTaskRecordPOExample mktTaskRecordPOExample = new MktTaskRecordPOExample();
            MktTaskRecordPOExample.Criteria criteria3 = mktTaskRecordPOExample.createCriteria();
            criteria3.andParticipateDateEqualTo(i).andSysBrandIdEqualTo(stageUser.getBrandId()).andValidEqualTo(true).andTaskTypeEqualTo(TaskTypeEnum.TASK_TYPE_PROFILE.getCode());
            Long dayCountMbr = mktTaskRecordPOMapper.countByExample(mktTaskRecordPOExample);
            //每天参与任务的人所获总积分
            Long daycountpoints = dayCountMbr*lTaskPoints;
            //券
            Long dayCountCoupon = dayCountMbr*oneTaskCoupon;

            dayTaskRecordVo.setDayCountCoupon(dayCountCoupon);
            dayTaskRecordVo.setDayCountMbr(dayCountMbr);
            dayTaskRecordVo.setDayPoints(daycountpoints);
            dayTaskRecordVoList.add(dayTaskRecordVo);

        }

        PageHelper.startPage(pageForm.getPageNumber(),pageForm.getPageSize());
        PageInfo<DayTaskRecordVo> pageInfo = new PageInfo<>(dayTaskRecordVoList);
        //taskRecordVO.setAllinvalidCountCoupon((long)count);todo
        taskRecordVO.setAllCountCoupon(allCountCoupon);
        taskRecordVO.setAllPoints(allPoints);
        taskRecordVO.setDayTaskRecordVoList(pageInfo);
        taskRecordVO.setAllCountMbr(countMbr);

        responseData.setData(taskRecordVO);

        return responseData;
    }

    /**
     * 添加任务记录
     * @param vo
     * @param memberInfoModel
     * @return
     */
    @Override
    @Transactional
    public ResponseData addToRecord(TaskVO vo, MemberInfoModel memberInfoModel){
        //将完成任务的信息添加进taskrecord表中
        MktTaskPO mktTaskPO = mktTaskPOMapper.selectByPrimaryKey(vo.getMktTaskId());

        ResponseData responseData = new ResponseData();
        MktTaskRecordPO mktTaskRecordPO = new MktTaskRecordPO();

        mktTaskRecordPO.setTaskType(TaskTypeEnum.TASK_TYPE_PROFILE.getCode());
        mktTaskRecordPO.setTaskId(vo.getMktTaskId());
        mktTaskRecordPO.setMemberCode(memberInfoModel.getMemberCode());
        mktTaskRecordPO.setPoints(vo.getPoints());//奖励积分是不是也该去掉？？
        mktTaskRecordPO.setParticipateDate(new Date());
        BeanUtils.copyProperties(mktTaskPO,mktTaskRecordPO);
        //是否奖励过 奖励次数？
        mktTaskRecordPOMapper.insertSelective(mktTaskRecordPO);
        return responseData;
    }


}
