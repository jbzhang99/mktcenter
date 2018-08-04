package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.service.api.MemberInfoApiService;
import com.bizvane.mktcenterservice.interfaces.ActivitySmartService;
import com.bizvane.mktcenterservice.models.bo.ActivitySmartBO;
import com.bizvane.mktcenterservice.models.bo.AwardBO;
import com.bizvane.mktcenterservice.models.po.*;
import com.bizvane.mktcenterservice.models.vo.ActivitySmartVO;
import com.bizvane.mktcenterservice.models.vo.MessageVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterserviceimpl.common.award.Award;
import com.bizvane.mktcenterserviceimpl.common.constants.ActivityConstants;
import com.bizvane.mktcenterserviceimpl.common.constants.ResponseConstants;
import com.bizvane.mktcenterserviceimpl.common.constants.SystemConstants;
import com.bizvane.mktcenterserviceimpl.common.enums.*;
import com.bizvane.mktcenterserviceimpl.common.utils.CodeUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.JobUtil;
import com.bizvane.mktcenterserviceimpl.mappers.*;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.poi.ss.formula.functions.T;
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
    private MktCouponPOMapper mktCouponPOMapper;

    @Autowired
    private MktMessagePOMapper mktMessagePOMapper;

    @Autowired
    private Award award;

    @Autowired
    private MemberInfoApiService memberInfoApiService;

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
            criteria.andMemberGroupNameLike(SystemConstants.LIKE_SYMBOL+vo.getMemberGroupName()+SystemConstants.LIKE_SYMBOL);
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
        //活动分组id不能为空
        if(vo.getMktActivitySmartGroupId()==null){
            responseData.setCode(ResponseConstants.ERROR);
            responseData.setMessage(ActivityConstants.SMART_ACTIVITY_GROUP_ID_EMPTY);
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
    public ResponseData<ActivitySmartVO> getActivityDetailById(Long mktActivityId,Integer mktSmartType) {
        ResponseData responseData = new ResponseData();
        //活动分组id不能为空
        if(mktActivityId==null){
            responseData.setCode(ResponseConstants.ERROR);
            responseData.setMessage(ActivityConstants.ERROR_MSG_ACTIVITY_ID_EMPTY);
            return responseData;
        }

        MktSmartTypeEnum mktSmartTypeEnum = MktSmartTypeEnum.getMktSmartTypeEnumByCode(mktSmartType);
        if(mktSmartTypeEnum==null){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.MODEL_FAILED_VALIDATION.getMessage());
            return responseData;
        }
        switch (mktSmartTypeEnum){
            case SMART_TYPE_COUPON:
                responseData =getCouponActivityDetailById(mktActivityId);
                break;
            case SMART_TYPE_INTEGRAL:
                responseData =getIntegralActivityDetailById(mktActivityId);
                break;
            case SMART_TYPE_SMS:
            case SMART_TYPE_WXMESSAGE:
                responseData =getMessageActivityDetailById(mktActivityId);
                break;
            default:break;
        }
        return responseData;
    }

    /**
     * 查询券营销详情
     * @return
     */
    public ResponseData<ActivitySmartVO> getCouponActivityDetailById(Long mktActivityId){
        ResponseData responseData = new ResponseData();
        ActivitySmartVO activitySmartVO = new ActivitySmartVO();
        //主表
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = mktActivityPOMapper.selectByPrimaryKey(mktActivityId);
        BeanUtils.copyProperties(mktActivityPOWithBLOBs,activitySmartVO);
        //智能营销规则表
        MktActivitySmartPOExample mktActivitySmartPOExample = new MktActivitySmartPOExample();
        mktActivitySmartPOExample.createCriteria().andValidEqualTo(Boolean.TRUE).andMktActivityIdEqualTo(mktActivityId);
        List<MktActivitySmartPO> mktActivitySmartPOS = mktActivitySmartPOMapper.selectByExample(mktActivitySmartPOExample);
        if(!CollectionUtils.isEmpty(mktActivitySmartPOS)){
            activitySmartVO.setTargetMbr(mktActivitySmartPOS.get(0).getTargetMbr());
        }
        //券表
        MktCouponPOExample mktCouponPOExample = new MktCouponPOExample();
        mktCouponPOExample.createCriteria().andValidEqualTo(Boolean.TRUE).andBizTypeEqualTo(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode()).andBizIdEqualTo(mktActivityId);
        List<MktCouponPO> mktCouponPOS = mktCouponPOMapper.selectByExample(mktCouponPOExample);
        activitySmartVO.setMktCouponPOS(mktCouponPOS);
        responseData.setData(activitySmartVO);
        return responseData;
    }

    /**
     * 查询积分营销详情
     * @return
     */
    public ResponseData<ActivitySmartVO> getIntegralActivityDetailById(Long mktActivityId){
        ResponseData responseData = new ResponseData();
        ActivitySmartVO activitySmartVO = new ActivitySmartVO();
        //主表
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = mktActivityPOMapper.selectByPrimaryKey(mktActivityId);
        BeanUtils.copyProperties(mktActivityPOWithBLOBs,activitySmartVO);
        //智能营销规则表
        MktActivitySmartPOExample mktActivitySmartPOExample = new MktActivitySmartPOExample();
        mktActivitySmartPOExample.createCriteria().andValidEqualTo(Boolean.TRUE).andMktActivityIdEqualTo(mktActivityId);
        List<MktActivitySmartPO> mktActivitySmartPOS = mktActivitySmartPOMapper.selectByExample(mktActivitySmartPOExample);
        if(!CollectionUtils.isEmpty(mktActivitySmartPOS)){
            activitySmartVO.setTargetMbr(mktActivitySmartPOS.get(0).getTargetMbr());
        }
        responseData.setData(activitySmartVO);
        return responseData;
    }

    /**
     * 查询短信/模板消息营销详情
     * @return
     */
    public ResponseData<ActivitySmartVO> getMessageActivityDetailById(Long mktActivityId){
        ResponseData responseData = new ResponseData();
        ActivitySmartVO activitySmartVO = new ActivitySmartVO();
        //主表
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = mktActivityPOMapper.selectByPrimaryKey(mktActivityId);
        BeanUtils.copyProperties(mktActivityPOWithBLOBs,activitySmartVO);
        //智能营销规则表
        MktActivitySmartPOExample mktActivitySmartPOExample = new MktActivitySmartPOExample();
        mktActivitySmartPOExample.createCriteria().andValidEqualTo(Boolean.TRUE).andMktActivityIdEqualTo(mktActivityId);
        List<MktActivitySmartPO> mktActivitySmartPOS = mktActivitySmartPOMapper.selectByExample(mktActivitySmartPOExample);
        if(!CollectionUtils.isEmpty(mktActivitySmartPOS)){
            activitySmartVO.setTargetMbr(mktActivitySmartPOS.get(0).getTargetMbr());
        }
        //消息表
        MktMessagePOExample mktMessagePOExample = new MktMessagePOExample();
        mktMessagePOExample.createCriteria().andValidEqualTo(Boolean.TRUE).andBizTypeEqualTo(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode()).andBizIdEqualTo(mktActivityId);
        List<MktMessagePO> mktMessagePOS = mktMessagePOMapper.selectByExample(mktMessagePOExample);
        if(!CollectionUtils.isEmpty(mktMessagePOS)){
            activitySmartVO.setMktMessagePO(mktMessagePOS.get(0));
        }
        responseData.setData(activitySmartVO);
        return responseData;
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

        mktActivitySmartPO.setMemberGroupCode(CodeUtil.getMemberGroupCode());
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
     * 对某个智能营销组创建任务，需要给mktSmartActivityGroupId
     * 任务类型：1优惠券营销
     * @return
     */
    @Override
    public ResponseData<Integer> addCouponActivity(ActivitySmartVO vo, List<MktCouponPO> couponCodeList, SysAccountPO stageUser) {
        ResponseData responseData = new ResponseData();

        //关联的智能营销分组不能为空
        if(vo.getMktActivitySmartGroupId()==null){
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
        mktActivityPOWithBLOBs.setSysCompanyId(stageUser.getSysCompanyId());
        mktActivityPOWithBLOBs.setSysBrandId(stageUser.getBrandId());
        mktActivityPOWithBLOBs.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_SMART.getCode());

        Boolean execute = Boolean.FALSE;
        //如果活动时间滞后
        if(new Date().before(vo.getStartTime())){
            //活动状态设置为待执行
            mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_PENDING.getCode());
            //创建任务调度
            jobUtil.addSmartActivityJob(stageUser,vo);
        }else{
            //活动状态设置为执行中
            mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
            //需要立即执行
            execute = Boolean.TRUE;
        }
        //新增活动主表
        mktActivityPOMapper.insertSelective(mktActivityPOWithBLOBs);
        //获取新增后数据id
        Long mktActivityId = mktActivityPOWithBLOBs.getMktActivityId();

        //新增智能营销表
        MktActivitySmartPO mktActivitySmartPO = new MktActivitySmartPO();
        BeanUtils.copyProperties(vo,mktActivitySmartPO);
        mktActivitySmartPO.setMktActivityId(mktActivityId);
        mktActivitySmartPOMapper.insertSelective(mktActivitySmartPO);

        //新增奖励券表
        if(!CollectionUtils.isEmpty(couponCodeList)){
            for(MktCouponPO mktCouponPO : couponCodeList){
                mktCouponPO.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode());
                mktCouponPO.setBizId(mktActivityId);
                mktCouponPO.setCreateDate(new Date());
                mktCouponPO.setCreateUserId(stageUser.getSysAccountId());
                mktCouponPO.setCreateUserName(stageUser.getName());
                mktCouponPOMapper.insertSelective(mktCouponPO);
            }
        }

        //执行
        //根据条件获取人，再遍历
        AwardBO awardBO = new AwardBO();
        awardBO.setMktSmartType(MktSmartTypeEnum.SMART_TYPE_COUPON.getCode());
        award.execute(awardBO);

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

        //关联的智能营销分组不能为空
        if(vo.getMktActivitySmartGroupId()==null){
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
        mktActivityPOWithBLOBs.setSysCompanyId(stageUser.getSysCompanyId());
        mktActivityPOWithBLOBs.setSysBrandId(stageUser.getBrandId());
        mktActivityPOWithBLOBs.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_SMART.getCode());

        Boolean execute = Boolean.FALSE;
        //如果活动时间滞后
        if(new Date().before(vo.getStartTime())){
            //活动状态设置为待执行
            mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_PENDING.getCode());
            //创建任务调度
            jobUtil.addSmartActivityJob(stageUser,vo);
        }else{
            //活动状态设置为执行中
            mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
            //需要立即执行
            execute = Boolean.TRUE;
        }
        //新增活动主表
        mktActivityPOMapper.insertSelective(mktActivityPOWithBLOBs);
        //获取新增后数据id
        Long mktActivityId = mktActivityPOWithBLOBs.getMktActivityId();

        //新增智能营销表
        MktActivitySmartPO mktActivitySmartPO = new MktActivitySmartPO();
        BeanUtils.copyProperties(vo,mktActivitySmartPO);
        mktActivitySmartPO.setMktActivityId(mktActivityId);
        mktActivitySmartPOMapper.insertSelective(mktActivitySmartPO);

        //执行
        AwardBO awardBO = new AwardBO();
        award.execute(awardBO);

        responseData.setMessage(ResponseConstants.SUCCESS_MSG);
        return responseData;
    }

    /**
     * 对某个智能营销组创建任务
     * 任务类型：3短信营销/4微信模板消息营销
     * @param vo
     * @return
     */
    @Override
    public ResponseData<Integer> addMessageActivity(ActivitySmartVO vo, MessageVO messageVO, SysAccountPO stageUser) {
        ResponseData responseData = new ResponseData();

        //关联的智能营销分组不能为空
        if(vo.getMktActivitySmartGroupId()==null){
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
        mktActivityPOWithBLOBs.setSysCompanyId(stageUser.getSysCompanyId());
        mktActivityPOWithBLOBs.setSysBrandId(stageUser.getBrandId());
        mktActivityPOWithBLOBs.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_SMART.getCode());

        Boolean execute = Boolean.FALSE;
        //如果活动时间滞后
        if(new Date().before(vo.getStartTime())){
            //活动状态设置为待执行
            mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_PENDING.getCode());
            //创建任务调度
            jobUtil.addSmartActivityJob(stageUser,vo);
        }else{
            //活动状态设置为执行中
            mktActivityPOWithBLOBs.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
            //需要立即执行
            execute = Boolean.TRUE;
        }
        //新增活动主表
        mktActivityPOMapper.insertSelective(mktActivityPOWithBLOBs);
        //获取新增后数据id
        Long mktActivityId = mktActivityPOWithBLOBs.getMktActivityId();

        //新增智能营销表
        MktActivitySmartPO mktActivitySmartPO = new MktActivitySmartPO();
        BeanUtils.copyProperties(vo,mktActivitySmartPO);
        mktActivitySmartPO.setMktActivityId(mktActivityId);
        mktActivitySmartPOMapper.insertSelective(mktActivitySmartPO);

        //新增消息表
        MktMessagePO mktMessagePO = new MktMessagePO();
        mktMessagePO.setBizType(BusinessTypeEnum.ACTIVITY_TYPE_ACTIVITY.getCode());
        mktMessagePO.setBizId(mktActivityId);
        mktMessagePO.setCreateDate(new Date());
        mktMessagePO.setCreateUserId(stageUser.getSysAccountId());
        mktMessagePO.setCreateUserName(stageUser.getName());
        mktMessagePOMapper.insertSelective(mktMessagePO);

        //执行
        AwardBO awardBO = new AwardBO();
        award.execute(awardBO);

        responseData.setMessage(ResponseConstants.SUCCESS_MSG);
        return responseData;
    }

    /**
     * 执行智能营销策略
     * @return
     */
    public ResponseData<T> execute(ActivitySmartBO bo){
        ResponseData responseData = new ResponseData();
        return responseData;
    }
}
