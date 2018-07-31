package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.centerstageservice.rpc.SysCheckConfigServiceRpc;
import com.bizvane.couponfacade.interfaces.SendCouponServiceFeign;
import com.bizvane.members.facade.service.api.IntegralRecordApiService;
import com.bizvane.mktcenterservice.interfaces.ActivitySmartService;
import com.bizvane.mktcenterservice.models.po.*;
import com.bizvane.mktcenterservice.models.vo.ActivitySmartVO;
import com.bizvane.mktcenterservice.models.vo.MessageVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterserviceimpl.common.constants.ActivityConstants;
import com.bizvane.mktcenterserviceimpl.common.constants.ResponseConstants;
import com.bizvane.mktcenterserviceimpl.common.constants.SystemConstants;
import com.bizvane.mktcenterserviceimpl.common.enums.MktTypeEnum;
import com.bizvane.mktcenterserviceimpl.common.utils.JobUtil;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivitySmartPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktCouponPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktMessagePOMapper;
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
    public ResponseData<PageInfo<MktActivitySmartPO>> getSmartActivityList(ActivitySmartVO vo, PageForm pageForm) {
        ResponseData responseData = new ResponseData();
        PageHelper.startPage(pageForm.getPageNumber(),pageForm.getPageSize());

        MktActivitySmartPOExample example = new MktActivitySmartPOExample();
        MktActivitySmartPOExample.Criteria criteria = example.createCriteria();
        criteria.andValidEqualTo(Boolean.TRUE).andMktActivityIdEqualTo(ActivityConstants.SMART_ACTIVITY_GROUP);

        if(!StringUtils.isEmpty(vo.getMktTaskName())){
            criteria.andMktTaskNameLike(SystemConstants.LIKE_SYMBOL+vo.getMktTaskName()+SystemConstants.LIKE_SYMBOL);
        }

        List<MktActivitySmartPO> mktActivitySmartPOS = mktActivitySmartPOMapper.selectByExampleWithBLOBs(example);
        PageInfo<MktActivitySmartPO> pageInfo = new PageInfo<>(mktActivitySmartPOS);
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
        if(vo.getMktActivityId()==null){
            responseData.setCode(ResponseConstants.ERROR);
            responseData.setMessage(ResponseConstants.ERROR_MSG);
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
     * @param mktActivitySmartId
     * @return
     */
    @Override
    public ResponseData<MktActivitySmartPO> getSmartActivityById(Long mktActivitySmartId) {
        ResponseData responseData = new ResponseData();
        MktActivitySmartPO mktActivitySmartPO = mktActivitySmartPOMapper.selectByPrimaryKey(mktActivitySmartId);
        responseData.setData(mktActivitySmartPO);
        return responseData;
    }

    /**
     * 添加智能营销分组
     * @param vo
     * @return
     */
    @Override
    public ResponseData<Integer> addSmartActivity(ActivitySmartVO vo) {
        ResponseData responseData = new ResponseData();

        //营销名称为空
        if(StringUtils.isEmpty(vo.getMktTaskName())){
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
        MktActivitySmartPO mktActivitySmartPO = new MktActivitySmartPO();
        BeanUtils.copyProperties(vo,mktActivitySmartPO);
        mktActivitySmartPO.setMktActivityId(ActivityConstants.SMART_ACTIVITY_GROUP);
        mktActivitySmartPO.setMktType(MktTypeEnum.TASK_STATUS_ALL.getCode());
        mktActivitySmartPOMapper.insertSelective(mktActivitySmartPO);
        responseData.setMessage(ResponseConstants.SUCCESS_MSG);
        return responseData;
    }

    /**
     * 修改智能营销分组
     * @param vo
     * @return
     */
    @Override
    public ResponseData<Integer> updateSmartActivity(ActivitySmartVO vo) {
        ResponseData responseData = new ResponseData();
        //营销名称为空
        if(StringUtils.isEmpty(vo.getMktTaskName())){
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
        MktActivitySmartPO mktActivitySmartPO = new MktActivitySmartPO();
        BeanUtils.copyProperties(vo,mktActivitySmartPO);
        mktActivitySmartPOMapper.updateByPrimaryKeySelective(mktActivitySmartPO);
        responseData.setMessage(ResponseConstants.SUCCESS_MSG);
        return responseData;
    }

    /**
     * 对某个智能营销组创建任务
     * 任务类型：1优惠券营销
     * @return
     */
    @Override
    public ResponseData<Integer> addCouponActivity(ActivitySmartVO vo, List<MktCouponPO> couponCodeList, SysAccountPO stageUser) {
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
        //新增奖励券表
        if(!CollectionUtils.isEmpty(couponCodeList)){
            for(MktCouponPO mktCouponPO : couponCodeList){
                mktCouponPOMapper.insertSelective(mktCouponPO);
            }
        }
        responseData.setMessage(ResponseConstants.SUCCESS_MSG);
        return responseData;
    }

    @Override
    public ResponseData<Integer> addIntegralActivity(ActivitySmartVO vo) {
        return null;
    }

    @Override
    public ResponseData<Integer> addSmsActivity(ActivitySmartVO vo, MessageVO messageVO) {
        return null;
    }

    @Override
    public ResponseData<Integer> addTemplateMsgActivity(ActivitySmartVO vo, MessageVO messageVO) {
        return null;
    }
}
