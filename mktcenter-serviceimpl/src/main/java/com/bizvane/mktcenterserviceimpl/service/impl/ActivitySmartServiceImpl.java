package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.centerstageservice.rpc.SysCheckConfigServiceRpc;
import com.bizvane.couponfacade.interfaces.SendCouponServiceFeign;
import com.bizvane.members.facade.service.api.IntegralRecordApiService;
import com.bizvane.mktcenterservice.interfaces.ActivitySmartService;
import com.bizvane.mktcenterservice.models.bo.ActivitySmartBO;
import com.bizvane.mktcenterservice.models.po.*;
import com.bizvane.mktcenterservice.models.vo.ActivitySmartVO;
import com.bizvane.mktcenterservice.models.vo.MessageVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterserviceimpl.common.constants.ActivityConstants;
import com.bizvane.mktcenterserviceimpl.common.constants.ResponseConstants;
import com.bizvane.mktcenterserviceimpl.common.constants.SystemConstants;
import com.bizvane.mktcenterserviceimpl.common.enums.ActivityStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.CheckStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.MktTypeEnum;
import com.bizvane.mktcenterserviceimpl.common.utils.CodeUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.JobUtil;
import com.bizvane.mktcenterserviceimpl.mappers.*;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/13 18:52
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@Service
public class ActivitySmartServiceImpl implements ActivitySmartService {

    @Autowired
    private MktActivitySmartPOMapper mktActivitySmartPOMapper;

    @Autowired
    private MktActivitySmartGroupPOMapper mktActivitySmartGroupPOMapper;

    @Autowired
    private MktActivityPOMapper mktActivityPOMapper;

    @Autowired
    private JobUtil jobUtil;

    @Autowired
    private SysCheckConfigServiceRpc sysCheckConfigServiceRpc;

    @Autowired
    private MktCouponPOMapper mktCouponPOMapper;

    @Autowired
    private MktMessagePOMapper mktMessagePOMapper;

    @Autowired
    private IntegralRecordApiService integralRecordApiService;

    @Autowired
    private SendCouponServiceFeign sendCouponServiceFeign;

    /**
     * 查询智能营销分组列表(方块)
     * @param vo
     * @return
     */
    @Override
    public ResponseData<PageInfo<MktActivitySmartGroupPO>> getSmartActivityGroupList(ActivitySmartVO vo, PageForm pageForm) {
        ResponseData responseData = new ResponseData();
        PageHelper.startPage(pageForm.getPageNumber(),pageForm.getPageSize());

        MktActivitySmartGroupPOExample example = new MktActivitySmartGroupPOExample();
        MktActivitySmartGroupPOExample.Criteria criteria = example.createCriteria();
        criteria.andValidEqualTo(Boolean.TRUE);

        if(!StringUtils.isEmpty(vo.getMemberGroupName())){
            criteria.andMemberGroupNameEqualTo(SystemConstants.LIKE_SYMBOL+vo.getMemberGroupName()+SystemConstants.LIKE_SYMBOL);
        }

        List<MktActivitySmartGroupPO> mktActivitySmartGroupPOS = mktActivitySmartGroupPOMapper.selectByExampleWithBLOBs(example);
        PageInfo<MktActivitySmartGroupPO> pageInfo = new PageInfo<>(mktActivitySmartGroupPOS);
        responseData.setData(pageInfo);
        return responseData;
    }

    /**
     * 查询历史营销活动列表
     * @param vo
     * @param pageForm
     * @return
     */
    @Override
    public ResponseData<PageInfo<MktActivitySmartPO>> getActivityHistoryList(ActivitySmartVO vo, PageForm pageForm) {
        ResponseData responseData = new ResponseData();
        //活动id不能为空
        if(vo.getMktActivitySmartId()==null){
            responseData.setCode(ResponseConstants.ERROR);
            responseData.setMessage(ActivityConstants.SMART_ACTIVITY_ID_EMPTY);
            return responseData;
        }
        PageHelper.startPage(pageForm.getPageNumber(),pageForm.getPageSize());
        List<ActivitySmartVO> activityList = mktActivitySmartPOMapper.getActivityList(vo);

        PageInfo<ActivitySmartVO> pageInfo = new PageInfo<>(activityList);
        responseData.setData(pageInfo);
        return responseData;
    }

    /**
     * 查询某个智能营销分组
     * @param mktActivitySmartGroupId
     * @return
     */
    @Override
    public ResponseData<MktActivitySmartGroupPO> getSmartActivityGroupById(Long mktActivitySmartGroupId) {
        ResponseData responseData = new ResponseData();
        MktActivitySmartGroupPO mktActivitySmartGroupPO = mktActivitySmartGroupPOMapper.selectByPrimaryKey(mktActivitySmartGroupId);
        responseData.setData(mktActivitySmartGroupPO);
        return responseData;
    }

    /**
     * 查询某个智能营销活动详情
     * @param mktActivityId
     * @return
     */
    @Override
    public ResponseData<ActivitySmartBO> getActivityDetailById(Long mktActivityId) {
        return null;
    }

    /**
     * 添加智能营销分组
     * @param vo
     * @return
     */
    @Override
    public ResponseData<Integer> addSmartActivityGroup(ActivitySmartVO vo) {
        ResponseData responseData = new ResponseData();

        //营销名称为空
        if(StringUtils.isEmpty(vo.getMemberGroupName())){
            responseData.setCode(ResponseConstants.ERROR);
            responseData.setMessage(ActivityConstants.SMART_ACTIVITY_TASK_NAME_EMPTY);
            return responseData;
        }

        //会员条件
        if(StringUtils.isEmpty(vo.getTargetMbr())){
            responseData.setCode(ResponseConstants.ERROR);
            responseData.setMessage(ActivityConstants.SMART_ACTIVITY_TARGET_MEMBER_EMPTY);
            return responseData;
        }
        MktActivitySmartGroupPO mktActivitySmartPO = new MktActivitySmartGroupPO();
        BeanUtils.copyProperties(vo,mktActivitySmartPO);
        mktActivitySmartGroupPOMapper.insertSelective(mktActivitySmartPO);
        responseData.setMessage(ResponseConstants.SUCCESS_MSG);
        return responseData;
    }

    /**
     * 修改智能营销分组
     * @param vo
     * @return
     */
    @Override
    public ResponseData<Integer> updateSmartActivityGroup(ActivitySmartVO vo) {
        ResponseData responseData = new ResponseData();
        //营销名称为空
        if(StringUtils.isEmpty(vo.getMemberGroupName())){
            responseData.setCode(ResponseConstants.ERROR);
            responseData.setMessage(ActivityConstants.SMART_ACTIVITY_TASK_NAME_EMPTY);
            return responseData;
        }

        //会员条件
        if(StringUtils.isEmpty(vo.getTargetMbr())){
            responseData.setCode(ResponseConstants.ERROR);
            responseData.setMessage(ActivityConstants.SMART_ACTIVITY_TARGET_MEMBER_EMPTY);
            return responseData;
        }
        MktActivitySmartGroupPO mktActivitySmartPO = new MktActivitySmartGroupPO();
        BeanUtils.copyProperties(vo,mktActivitySmartPO);
        mktActivitySmartGroupPOMapper.updateByPrimaryKeySelective(mktActivitySmartPO);
        responseData.setMessage(ResponseConstants.SUCCESS_MSG);
        return responseData;
    }

    /**
     * 启用/禁用智能营销分组
     * @param vo
     * @return
     */
    @Override
    public ResponseData<Integer> updateSmartActivityGroupStatus(ActivitySmartVO vo) {
        ResponseData responseData = new ResponseData();
        MktActivitySmartGroupPO mktActivitySmartPO = new MktActivitySmartGroupPO();
        BeanUtils.copyProperties(vo,mktActivitySmartPO);
        mktActivitySmartGroupPOMapper.updateByPrimaryKeySelective(mktActivitySmartPO);
        responseData.setMessage(ResponseConstants.SUCCESS_MSG);
        return responseData;
    }

    /**
     * 删除智能营销分组
     * @param vo
     * @return
     */
    @Override
    public ResponseData<Integer> deleteSmartActivityGroup(ActivitySmartVO vo) {
        ResponseData responseData = new ResponseData();
        MktActivitySmartGroupPO mktActivitySmartPO = new MktActivitySmartGroupPO();
        BeanUtils.copyProperties(vo,mktActivitySmartPO);
        mktActivitySmartPO.setValid(Boolean.FALSE);
        mktActivitySmartGroupPOMapper.updateByPrimaryKeySelective(mktActivitySmartPO);
        responseData.setMessage(ResponseConstants.SUCCESS_MSG);
        return responseData;
    }

    /**
     * 复制智能营销分组
     * @param vo
     * @return
     */
    @Override
    public ResponseData<Integer> copySmartActivityGroup(ActivitySmartVO vo) {
        ResponseData responseData = new ResponseData();

        MktActivitySmartGroupPO mktActivitySmartGroupPO = mktActivitySmartGroupPOMapper.selectByPrimaryKey(vo.getMktActivitySmartId());

        mktActivitySmartGroupPO.setCreateDate(new Date());
        mktActivitySmartGroupPO.setCreateUserId(vo.getCreateUserId());
        mktActivitySmartGroupPO.setCreateUserName(vo.getCreateUserName());

        mktActivitySmartGroupPO.setModifiedDate(null);
        mktActivitySmartGroupPO.setModifiedUserId(null);
        mktActivitySmartGroupPO.setModifiedUserName(null);

        mktActivitySmartGroupPO.setMemberGroupName(mktActivitySmartGroupPO.getMemberGroupName()+ActivityConstants.SMART_ACTIVITY_COPY);

        mktActivitySmartGroupPOMapper.insertSelective(mktActivitySmartGroupPO);

        responseData.setMessage(ResponseConstants.SUCCESS_MSG);
        return responseData;
    }

    /**
     * 对某个智能营销组创建任务，需要给mktSmartActivityId
     * 任务类型：1优惠券营销
     * @return
     */
    @Override
    public ResponseData<Integer> addCouponActivity(ActivitySmartVO vo, List<MktCouponPO> couponCodeList, SysAccountPO stageUser) {
        ResponseData responseData = new ResponseData();

        //关联的智能营销分组不能为空
        if(vo.getMktActivitySmartId()==null){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.MODEL_FAILED_VALIDATION.getMessage());
            return responseData;
        }

        vo.setCreateUserId(stageUser.getSysAccountId());
        vo.setCreateDate(new Date());
        vo.setCreateUserName(stageUser.getName());

        //生成活动编号
        String activityCode = CodeUtil.getActivityCode();
        //拷贝属性
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = new MktActivityPOWithBLOBs();
        BeanUtils.copyProperties(vo,mktActivityPOWithBLOBs);
        //活动编号
        mktActivityPOWithBLOBs.setActivityCode(activityCode);
        //设置审核状态为已审核
        mktActivityPOWithBLOBs.setCheckStatus(CheckStatusEnum.CHECK_STATUS_APPROVED.getCode());

        //如果活动时间滞后
        if(new Date().before(vo.getStartTime())){
            //活动状态设置为待执行
            mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_PENDING.getCode());
            //创建任务调度任务开始时间
//            jobUtil.addJob(stageUser,vo,activityCode);
            //创建任务调度任务结束时间
//            jobUtil.addJobEndTime(stageUser,vo,activityCode);
        }else{
            //活动状态设置为执行中
            mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
        }
        //新增活动主表
        mktActivityPOMapper.insertSelective(mktActivityPOWithBLOBs);
        //新增智能营销表
        MktActivitySmartPO mktActivitySmartPO = new MktActivitySmartPO();
        BeanUtils.copyProperties(vo,mktActivitySmartPO);
        mktActivitySmartPOMapper.insertSelective(mktActivitySmartPO);

        //获取新增后数据id
        Long mktActivityId = mktActivityPOWithBLOBs.getMktActivityId();

        //新增奖励券表
        if(!CollectionUtils.isEmpty(couponCodeList)){
            for(MktCouponPO mktCouponPO : couponCodeList){
                mktCouponPOMapper.insertSelective(mktCouponPO);
            }
        }
        responseData.setMessage(ResponseConstants.SUCCESS_MSG);
        return responseData;
    }

    /**
     * 对某个智能营销组创建任务
     * 任务类型：2积分营销
     * @param vo
     * @return
     */
    @Override
    public ResponseData<Integer> addIntegralActivity(ActivitySmartVO vo, SysAccountPO stageUser) {
        ResponseData responseData = new ResponseData();

        vo.setCreateUserId(stageUser.getSysAccountId());
        vo.setCreateDate(new Date());
        vo.setCreateUserName(stageUser.getName());

        //新增活动主表
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = new MktActivityPOWithBLOBs();
        BeanUtils.copyProperties(vo,mktActivityPOWithBLOBs);
        mktActivityPOMapper.insertSelective(mktActivityPOWithBLOBs);

        //新增智能营销表
        MktActivitySmartPO mktActivitySmartPO = new MktActivitySmartPO();
        BeanUtils.copyProperties(vo,mktActivitySmartPO);
        mktActivitySmartPOMapper.insertSelective(mktActivitySmartPO);

        responseData.setMessage(ResponseConstants.SUCCESS_MSG);
        return responseData;
    }

    /**
     * 对某个智能营销组创建任务
     * 任务类型：3短信营销
     * @param vo
     * @return
     */
    @Override
    public ResponseData<Integer> addSmsActivity(ActivitySmartVO vo, MessageVO messageVO, SysAccountPO stageUser) {
        ResponseData responseData = new ResponseData();

        vo.setCreateUserId(stageUser.getSysAccountId());
        vo.setCreateDate(new Date());
        vo.setCreateUserName(stageUser.getName());

        //新增活动主表
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = new MktActivityPOWithBLOBs();
        BeanUtils.copyProperties(vo,mktActivityPOWithBLOBs);
        mktActivityPOMapper.insertSelective(mktActivityPOWithBLOBs);

        //新增智能营销表
        MktActivitySmartPO mktActivitySmartPO = new MktActivitySmartPO();
        BeanUtils.copyProperties(vo,mktActivitySmartPO);
        mktActivitySmartPOMapper.insertSelective(mktActivitySmartPO);

        //新增消息表
        MktMessagePO mktMessagePO = new MktMessagePO();
        BeanUtils.copyProperties(vo,mktMessagePO);
        mktMessagePOMapper.insertSelective(mktMessagePO);

        responseData.setMessage(ResponseConstants.SUCCESS_MSG);
        return responseData;
    }

    /**
     * 对某个智能营销组创建任务
     * 任务类型：4微信模板消息营销
     * @param vo
     * @return
     */
    @Override
    public ResponseData<Integer> addTemplateMsgActivity(ActivitySmartVO vo, MessageVO messageVO, SysAccountPO stageUser) {
        ResponseData responseData = new ResponseData();

        vo.setCreateUserId(stageUser.getSysAccountId());
        vo.setCreateDate(new Date());
        vo.setCreateUserName(stageUser.getName());

        //新增活动主表
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = new MktActivityPOWithBLOBs();
        BeanUtils.copyProperties(vo,mktActivityPOWithBLOBs);
        mktActivityPOMapper.insertSelective(mktActivityPOWithBLOBs);

        //新增智能营销表
        MktActivitySmartPO mktActivitySmartPO = new MktActivitySmartPO();
        BeanUtils.copyProperties(vo,mktActivitySmartPO);
        mktActivitySmartPOMapper.insertSelective(mktActivitySmartPO);

        //新增消息表
        MktMessagePO mktMessagePO = new MktMessagePO();
        BeanUtils.copyProperties(vo,mktMessagePO);
        mktMessagePOMapper.insertSelective(mktMessagePO);

        responseData.setMessage(ResponseConstants.SUCCESS_MSG);
        return responseData;
    }
}
