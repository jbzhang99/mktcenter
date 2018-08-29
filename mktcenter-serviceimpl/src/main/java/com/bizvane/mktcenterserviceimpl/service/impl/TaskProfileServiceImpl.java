package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.centerstageservice.models.po.SysCheckPo;
import com.bizvane.centerstageservice.models.vo.SysCheckConfigVo;
import com.bizvane.centerstageservice.rpc.SysCheckConfigServiceRpc;
import com.bizvane.centerstageservice.rpc.SysCheckServiceRpc;
import com.bizvane.couponfacade.interfaces.CouponDefinitionServiceFeign;
import com.bizvane.couponfacade.interfaces.CouponQueryServiceFeign;
import com.bizvane.couponfacade.interfaces.SendCouponServiceFeign;
import com.bizvane.couponfacade.models.po.CouponDefinitionPO;
import com.bizvane.couponfacade.models.vo.CouponEntityVO;
import com.bizvane.couponfacade.models.vo.CouponFindCouponCountResponseVO;
import com.bizvane.couponfacade.models.vo.SendCouponSimpleRequestVO;
import com.bizvane.members.facade.models.IntegralRecordModel;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.service.api.IntegralRecordApiService;
import com.bizvane.members.facade.service.api.MemberInfoApiService;
import com.bizvane.members.facade.service.api.WxAppletApiService;
import com.bizvane.members.facade.vo.ExtendPropertyVO;
import com.bizvane.members.facade.vo.MemberInfoApiModel;
import com.bizvane.messagefacade.models.vo.MemberMessageVO;
import com.bizvane.messagefacade.models.vo.SysSmsConfigVO;
import com.bizvane.mktcenterservice.interfaces.TaskCouponService;
import com.bizvane.mktcenterservice.interfaces.TaskMessageService;
import com.bizvane.mktcenterservice.interfaces.TaskProfileService;
import com.bizvane.mktcenterservice.interfaces.TaskService;
import com.bizvane.mktcenterservice.models.bo.AwardBO;
import com.bizvane.mktcenterservice.models.bo.TaskBO;
import com.bizvane.mktcenterservice.models.po.*;
import com.bizvane.mktcenterservice.models.vo.*;
import com.bizvane.mktcenterserviceimpl.common.award.Award;
import com.bizvane.mktcenterserviceimpl.common.constants.ResponseConstants;
import com.bizvane.mktcenterserviceimpl.common.constants.SystemConstants;
import com.bizvane.mktcenterserviceimpl.common.constants.TaskConstants;
import com.bizvane.mktcenterserviceimpl.common.enums.*;
import com.bizvane.mktcenterserviceimpl.common.utils.CodeUtil;
import com.bizvane.mktcenterserviceimpl.common.job.JobUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.TaskParamCheckUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.TimeUtils;
import com.bizvane.mktcenterserviceimpl.mappers.*;
//import com.bizvane.utils.commonutils.PageForm;
import com.bizvane.utils.enumutils.SysResponseEnum;

import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.github.pagehelper.PageHelper;

import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.util.*;

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
    private Award award;
    @Autowired
    private CouponDefinitionServiceFeign couponDefinitionServiceFeign;
    @Autowired
    private CouponQueryServiceFeign couponQueryServiceFeign;
    @Autowired
    private MemberInfoApiService memberInfoApiService;
    @Autowired
    private WxAppletApiService wxAppletApiService;
    @Autowired
    protected TaskService taskService;
    @Autowired
    private TaskCouponService taskCouponService;
    @Autowired
    private TaskMessageService taskMessageService;

/**
 * 查询完善资料的字段
 * 微信小程序端是否可见,1=不可见,2=可见
 */
@Override
public  ResponseData<List<ExtendPropertyVO>> getMemberField(Long sysBrandId){
    ExtendPropertyVO extendPropertyVO = new ExtendPropertyVO();
    extendPropertyVO.setWxVisible("2");
    extendPropertyVO.setBrandId(sysBrandId);
    return  wxAppletApiService.getBaseAndExtendPropertyList(extendPropertyVO);
}

    /**
     * 新建完善资料任务
     * @param bo
     * @param stageUser
     * @return
     */
    @Override
    @Transactional
    public ResponseData<Integer> addTask(TaskBO bo, SysAccountPO stageUser) throws ParseException {
        //0.参数的检验
        ResponseData responseData = TaskParamCheckUtil.checkParam(bo);
        //参数校验不通过
        if(responseData.getCode()>0){
            return responseData;
        }
        TaskVO taskVO = bo.getTaskVO();
        taskVO.setValid(Boolean.TRUE);
        taskVO.setCreateDate(TimeUtils.getNowTime());
        taskVO.setCreateUserId(stageUser.getSysAccountId());
        taskVO.setCreateUserName(stageUser.getName());

        //1.生成任务编号
        String taskCode = CodeUtil.getTaskCode();
        //2.任务主表新增
        MktTaskPOWithBLOBs mktTaskPOWithBLOBs = new MktTaskPOWithBLOBs();
        BeanUtils.copyProperties(taskVO, mktTaskPOWithBLOBs);
        mktTaskPOWithBLOBs.setTaskCode(taskCode);

        mktTaskPOWithBLOBs = taskService.isOrNoCheckState(mktTaskPOWithBLOBs);

        Long mktTaskId = taskService.addTask(mktTaskPOWithBLOBs, stageUser);
        taskService.addCheckData(mktTaskPOWithBLOBs);
        //3.任务消费表新增
        MktTaskProfilePO mktTaskProfilePO = new MktTaskProfilePO();
        BeanUtils.copyProperties(taskVO, mktTaskProfilePO);
        mktTaskProfilePO.setMktTaskId(mktTaskId);
        this.insertProfileTask(mktTaskProfilePO,stageUser);

        //4.新增奖励新增   业务类型：1活动，2任务
        List<MktCouponPO> mktCouponPOList = bo.getMktCouponPOList();
        if (org.apache.commons.collections.CollectionUtils.isNotEmpty(mktCouponPOList)) {
            mktCouponPOList.stream().forEach(param -> {
                param.setBizId(mktTaskId);
                param.setBizType(TaskConstants.TASK_TYPE);
                taskCouponService.addTaskCoupon(param, stageUser);
            });
        }
        //5.新增消息新增  消息业务类型：1活动，2任务
        List<MktMessagePO> mktmessagePOList = bo.getMessagePOList();
        if (org.apache.commons.collections.CollectionUtils.isNotEmpty(mktmessagePOList)) {
            mktmessagePOList.stream().forEach(param -> {
                        param.setBizId(mktTaskId);
                        param.setBizType(TaskConstants.TASK_TYPE);
                        taskMessageService.addTaskMessage(param, stageUser);
                    }
            );
        }

        //6.处理任务
        taskService.doOrderTask(mktTaskPOWithBLOBs,mktmessagePOList,stageUser);

        responseData.setCode(SystemConstants.SUCCESS_CODE);
        responseData.setMessage(SystemConstants.SUCCESS_MESSAGE);
        return responseData;
    }
    /**
     * 新增完善资料的单表信息
     */
      public  ResponseData<Integer> insertProfileTask(MktTaskProfilePO po,SysAccountPO stageUser){
          ResponseData<Integer> result = new ResponseData<Integer>(SysResponseEnum.FAILED.getCode(),SysResponseEnum.FAILED.getMessage(),null);
          po.setCreateUserId(stageUser.getSysAccountId());
          po.setCreateUserName(stageUser.getName());
          po.setCreateDate(new Date());
          int i = mktTaskProfilePOMapper.insertSelective(po);
          MktTaskProfilePOExample mktTaskProfilePOExample = new MktTaskProfilePOExample();
          if (i>0){
              result.setCode(SysResponseEnum.SUCCESS.getCode());
              result.setMessage(SysResponseEnum.SUCCESS.getMessage());
          }
      return result;
      }


    /**
     * 修改任务
     * @param bo
     * @param stageUser
     * @return
     */
    @Override
    @Transactional
    public ResponseData updateTask(TaskBO bo, SysAccountPO stageUser) {
        ResponseData responseData = new ResponseData();
        TaskVO taskVO = bo.getTaskVO();
        //接收需要修改的任务vo对象判断是否状态为待审核
        //状态为待审核或者被驳回时才可修改,其他状态为不可修改
        if (taskVO.getCheckStatus()!=CheckStatusEnum.CHECK_STATUS_PENDING.getCode()&&taskVO.getCheckStatus()!=CheckStatusEnum.CHECK_STATUS_REJECTED.getCode()){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage("该任务不可修改");
            return responseData;
        }
      //0.参数的检验
        responseData = TaskParamCheckUtil.checkParam(bo);
        //参数校验不通过
        if(responseData.getCode()>0){
            return responseData;
        }
        TaskVO vo = bo.getTaskVO();
        vo.setValid(Boolean.TRUE);
        vo.setModifiedDate(TimeUtils.getNowTime());
        vo.setModifiedUserName(stageUser.getName());
        vo.setModifiedUserId(stageUser.getSysAccountId());
        Long mktTaskId = vo.getMktTaskId();
        // String taskCode = vo.getTaskCode();
        //1.任务主表修改
        MktTaskPOWithBLOBs mktTaskPOWithBLOBs = new MktTaskPOWithBLOBs();
        BeanUtils.copyProperties(vo, mktTaskPOWithBLOBs);
        taskService.updateTask(mktTaskPOWithBLOBs, stageUser);

        //3.任务消费表修改
        MktTaskProfilePO mktTaskProfilePO = new MktTaskProfilePO();
        BeanUtils.copyProperties(taskVO, mktTaskProfilePO);
        mktTaskProfilePO.setMktTaskId(mktTaskId);
        this.updateProfileTask(mktTaskProfilePO, stageUser);

        //4.奖励修改 biz_type 活动类型  1=活动
        taskCouponService.deleteTaskCoupon(mktTaskId, stageUser);
        List<MktCouponPO> mktCouponPOList = bo.getMktCouponPOList();
        if (org.apache.commons.collections.CollectionUtils.isNotEmpty(mktCouponPOList)) {
            mktCouponPOList.stream().forEach(param -> {
                param.setBizId(mktTaskId);
                param.setBizType(TaskConstants.TASK_TYPE);
                taskCouponService.addTaskCoupon(param, stageUser);
            });
        }
        //5.修改消息
        taskMessageService.deleteTaskMessage(mktTaskId,stageUser);
        List<MktMessagePO> mktmessagePOList = bo.getMessagePOList();
        if (org.apache.commons.collections.CollectionUtils.isNotEmpty(mktmessagePOList)) {
            mktmessagePOList.stream().forEach(param -> {
                        param.setBizId(mktTaskId);
                        param.setBizType(TaskConstants.TASK_TYPE);
                        taskMessageService.addTaskMessage(param, stageUser);
                    }
            );
        }
        //6.处理任务
        taskService.doOrderTask(mktTaskPOWithBLOBs,mktmessagePOList,stageUser);

        responseData.setCode(SystemConstants.SUCCESS_CODE);
        responseData.setMessage(SystemConstants.SUCCESS_MESSAGE);
        return responseData;

    }
    /**
     * 修改完善资料的单表信息
     */
    public  ResponseData<Integer> updateProfileTask(MktTaskProfilePO po,SysAccountPO stageUser){
        ResponseData<Integer> result = new ResponseData<Integer>(SysResponseEnum.FAILED.getCode(),SysResponseEnum.FAILED.getMessage(),null);
        po.setModifiedUserId(stageUser.getSysAccountId());
        po.setModifiedUserName(stageUser.getName());
        po.setModifiedDate(new Date());
        int i = mktTaskProfilePOMapper.updateByPrimaryKeySelective(po);
        if (i>0){
            result.setCode(SysResponseEnum.SUCCESS.getCode());
            result.setMessage(SysResponseEnum.SUCCESS.getMessage());
        }
        return result;
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
     * 执行任务
     * @param vo 或者传回的是任务编号？
     * @param memberInfoModel 或者传回的是会员编号？
     * @return
     */
    @Override
    @Transactional
    public ResponseData executeTask(TaskVO vo, MemberInfoModel memberInfoModel) {
        ResponseData responseData = new ResponseData();

        try {

            //一、券

            //1.从coupon表中查出该业务单号对应的券的id（可能多张，所以遍历添加）
            MktCouponPOExample mktCouponPOExample = new MktCouponPOExample();
            MktCouponPOExample.Criteria criteria = mktCouponPOExample.createCriteria();
            criteria.andBizIdEqualTo(vo.getMktTaskId()).andBizTypeEqualTo(BusinessTypeEnum.ACTIVITY_TYPE_TASK.getCode()).andValidEqualTo(true);

            List<MktCouponPO> mktCouponPOList = mktCouponPOMapper.selectByExample(mktCouponPOExample);

            //判断一下是否为空
            if (!CollectionUtils.isEmpty(mktCouponPOList)){
                //2.如果不为空则有券奖励   创建AwardBo对象 添加通用信息 并遍历该业务的券信息添加券的信息
                AwardBO bo = new AwardBO();
                SendCouponSimpleRequestVO sendCouponSimpleRequestVO = new SendCouponSimpleRequestVO();
                sendCouponSimpleRequestVO.setMemberCode(memberInfoModel.getMemberCode());
                sendCouponSimpleRequestVO.setSendBussienId(vo.getMktTaskId());
                bo.setSendCouponSimpleRequestVO(sendCouponSimpleRequestVO);
                bo.setMktType(MktSmartTypeEnum.SMART_TYPE_COUPON.getCode());
                for (MktCouponPO mktCouponPO:mktCouponPOList){
                    Long couponDefId = mktCouponPO.getCouponDefinitionId();
                    sendCouponSimpleRequestVO.setCouponDefinitionId(couponDefId);
                    award.execute(bo);
                }

            }


            //二、积分

            ////根据taskid从任务主表中查出该task

            MktTaskPOWithBLOBs mktTaskPOWithBLOBs =  mktTaskPOMapper.selectByPrimaryKey(vo.getMktTaskId());

            if (mktTaskPOWithBLOBs.getPoints()!=null){
                AwardBO bo2 = new AwardBO();
                IntegralRecordModel integralRecordModel = new IntegralRecordModel();
                integralRecordModel.setChangeBills(UUID.randomUUID().toString().replaceAll("-",""));//todo 暂时用uuid生成
                integralRecordModel.setBusinessWay(BusinessTypeEnum.ACTIVITY_TYPE_TASK.getMessage());
                integralRecordModel.setMemberCode(memberInfoModel.getMemberCode());
                integralRecordModel.setMemberName(memberInfoModel.getName());
                integralRecordModel.setChangeIntegral(mktTaskPOWithBLOBs.getPoints());
                bo2.setIntegralRecordModel(integralRecordModel);
                bo2.setBusinessId(vo.getMktTaskId());
                bo2.setMktType(MktSmartTypeEnum.SMART_TYPE_INTEGRAL.getCode());
                award.execute(bo2);
            }


            //三、将完成任务的信息添加进taskrecord表中
            MktTaskPO mktTaskPO = mktTaskPOMapper.selectByPrimaryKey(vo.getMktTaskId());

            MktTaskRecordPO mktTaskRecordPO = new MktTaskRecordPO();

            mktTaskRecordPO.setTaskType(TaskTypeEnum.TASK_TYPE_PROFILE.getCode());
            mktTaskRecordPO.setTaskId(vo.getMktTaskId());
            mktTaskRecordPO.setMemberCode(memberInfoModel.getMemberCode());
            mktTaskRecordPO.setPoints(mktTaskPOWithBLOBs.getPoints());//奖励积分是不是也该去掉？？Todo
            mktTaskRecordPO.setParticipateDate(new Date());
            BeanUtils.copyProperties(mktTaskPO,mktTaskRecordPO);
            //是否奖励过 奖励次数？
            mktTaskRecordPO.setRewarded(1);
            mktTaskRecordPO.setCouponNum(mktCouponPOList.size());
            mktTaskRecordPOMapper.insertSelective(mktTaskRecordPO);

            responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
            responseData.setCode(SysResponseEnum.SUCCESS.getCode());

        }catch(Exception e){
            e.printStackTrace();
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.FAILED.getMessage());
            return responseData;

        }

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

        try {

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
            }else if(date1==null&&date2==null){
                date1 = mktTaskPO.getStartTime();
                date2=new Date();
            }
            Long countMbr = mktTaskRecordPOMapper.countByExample(example);
            TaskRecordVO taskRecordVO = new TaskRecordVO();

            //二、算出赠送总积分


            Integer taskPoints = mktTaskPO.getPoints();
            Long lTaskPoints = (long)taskPoints;
            Long allPoints = (countMbr*lTaskPoints);


            //三、算出每个任务赠送总券数
            //根据taskid查出该任务赠送券数

            MktCouponPOExample mktCouponPOExample = new MktCouponPOExample();
            MktCouponPOExample.Criteria criteria2 = mktCouponPOExample.createCriteria();
            criteria2.andBizIdEqualTo(mktTaskPO.getMktTaskId()).andValidEqualTo(true);
            Long oneTaskCoupon = mktCouponPOMapper.countByExample(mktCouponPOExample);
            /*Long allCountCoupon = countMbr*oneTaskCoupon;*/


            //四、已被核销的优惠券？todo

            //核销的优惠券

            CouponEntityVO couponEntityVO = new CouponEntityVO();
            couponEntityVO.setSendBusinessId(mktTaskPO.getMktTaskId());
            couponEntityVO.setSendType("60");
            couponEntityVO.setSysBrandId(stageUser.getBrandId());
            couponEntityVO.setDtStart(date1);
            couponEntityVO.setDtEnd(date2);
            ResponseData<CouponFindCouponCountResponseVO> responseVOResponseData = couponQueryServiceFeign.findCouponCountByDate(couponEntityVO);
            CouponFindCouponCountResponseVO data = responseVOResponseData.getData();
            Long couponUsedSum = data.getCouponUsedSum();


            //赠送总券数
            Long allCountCoupon = data.getCouponSum();

            //五、根据日期查询

            List<DayTaskRecordVo> dayTaskRecordVoList = new ArrayList<>();
            for (Date i = date1;i.before(date2);i=TimeUtils.getNextDay(i)){
                DayTaskRecordVo dayTaskRecordVo = new DayTaskRecordVo();
                //1.根据日期，任务类型，品牌id查询出任务得出每天所有参与该类型任务人数

                MktTaskRecordPOExample mktTaskRecordPOExample = new MktTaskRecordPOExample();
                MktTaskRecordPOExample.Criteria criteria3 = mktTaskRecordPOExample.createCriteria();
                criteria3.andParticipateDateEqualTo(i).andSysBrandIdEqualTo(stageUser.getBrandId()).andValidEqualTo(true).andTaskTypeEqualTo(TaskTypeEnum.TASK_TYPE_PROFILE.getCode());
                Long dayCountMbr = mktTaskRecordPOMapper.countByExample(mktTaskRecordPOExample);
                //每天参与任务的人所获总积分 todo  调用接口
                Long daycountpoints = dayCountMbr*lTaskPoints;
                //券
                Long dayCountCoupon = dayCountMbr*oneTaskCoupon;

                dayTaskRecordVo.setDayCountCoupon(dayCountCoupon);
                dayTaskRecordVo.setDayCountMbr(dayCountMbr);
                dayTaskRecordVo.setDayPoints(daycountpoints);
                dayTaskRecordVo.setPartDate(i);
                dayTaskRecordVoList.add(dayTaskRecordVo);

            }

            PageHelper.startPage(pageForm.getPageNumber(),pageForm.getPageSize());
            PageInfo<DayTaskRecordVo> pageInfo = new PageInfo<>(dayTaskRecordVoList);

            taskRecordVO.setAllCountCoupon(allCountCoupon);
            taskRecordVO.setAllPoints(allPoints);
            taskRecordVO.setDayTaskRecordVoList(pageInfo);
            taskRecordVO.setAllCountMbr(countMbr);
            taskRecordVO.setAllinvalidCountCoupon(couponUsedSum);


            responseData.setData(taskRecordVO);
            responseData.setCode(SysResponseEnum.SUCCESS.getCode());
            responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());

        }catch (Exception e){
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
    @Override
    @Transactional
    public ResponseData addToRecord(TaskVO vo, MemberInfoModel memberInfoModel){
        ResponseData responseData = new ResponseData();
        try {
            //在添加记录之前判断是否此次分享完成之后就会完成该任务

            //将完成任务的信息添加进taskrecord表中
            MktTaskPO mktTaskPO = mktTaskPOMapper.selectByPrimaryKey(vo.getMktTaskId());

            MktTaskRecordPO mktTaskRecordPO = new MktTaskRecordPO();

            mktTaskRecordPO.setTaskType(TaskTypeEnum.TASK_TYPE_PROFILE.getCode());
            mktTaskRecordPO.setTaskId(vo.getMktTaskId());
            mktTaskRecordPO.setMemberCode(memberInfoModel.getMemberCode());
            mktTaskRecordPO.setPoints(vo.getPoints());//奖励积分是不是也该去掉？？
            mktTaskRecordPO.setParticipateDate(new Date());
            BeanUtils.copyProperties(mktTaskPO,mktTaskRecordPO);
            //是否奖励过 奖励次数？
            mktTaskRecordPOMapper.insertSelective(mktTaskRecordPO);
            responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
            responseData.setCode(SysResponseEnum.SUCCESS.getCode());

        }catch (Exception e){
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

        }catch (Exception e){
            e.printStackTrace();
            responseData.setMessage(SysResponseEnum.FAILED.getMessage());
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            return responseData;
        }

        return responseData;
    }

    /**
     * 任务审核
     * @param taskId
     * @param stageUser
     * @param checkStatus
     * @return
     */
    public ResponseData checkTaskProfile(Long taskId,SysAccountPO stageUser,Integer checkStatus){
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
                mktTaskPOWithBLOBs.setCheckStatus(CheckStatusEnum.CHECK_STATUS_APPROVED.getCode());

                //调用审核接口修改审核单状态
                SysCheckPo sysCheckPo = new SysCheckPo();
                sysCheckPo.setBusinessId(taskId);
                sysCheckPo.setBusinessCode(mktTaskPOWithBLOBs.getTaskCode());
                sysCheckPo.setCheckStatus(CheckStatusEnum.CHECK_STATUS_APPROVED.getCode());

                //sysCheckServiceRpc.updateCheck(sysCheckPo);
                /*//审核时间未超过任务结束时间
                if (new Date().before(mktTaskPOWithBLOBs.getEndTime())){
                    //审核时间超过任务开始时间
                    if(new Date().after(mktTaskPOWithBLOBs.getStartTime())){
                        mktTaskPOWithBLOBs.setTaskStatus(TaskStatusEnum.TASK_STATUS_EXECUTING.getCode());
                        //todo 执行发送消息
                            //sendMsg(mktTaskPOWithBLOBs.getSysBrandId(),mktMessagePOList);


                    }//审核时间未超过任务开始时间
                    else{
                        mktTaskPOWithBLOBs.setTaskStatus(TaskStatusEnum.TASK_STATUS_PENDING.getCode());
                    }

                }//审核时间超过任务结束时间
                else{
                    mktTaskPOWithBLOBs.setTaskStatus(TaskStatusEnum.TASK_STATUS_FINISHED.getCode());
                }*/
                //sendMsg(mktTaskPOWithBLOBs.getSysBrandId(),mktMessagePOList);

                mktTaskPOWithBLOBs.setTaskStatus(TaskStatusEnum.TASK_STATUS_EXECUTING.getCode());
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


}
