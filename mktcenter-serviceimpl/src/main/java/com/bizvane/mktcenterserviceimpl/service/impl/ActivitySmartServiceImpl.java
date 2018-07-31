package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.mktcenterservice.interfaces.ActivitySmartService;
import com.bizvane.mktcenterservice.models.po.MktActivitySmartPO;
import com.bizvane.mktcenterservice.models.po.MktActivitySmartPOExample;
import com.bizvane.mktcenterservice.models.po.MktCouponPO;
import com.bizvane.mktcenterservice.models.vo.ActivitySmartVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterserviceimpl.common.constants.ActivityConstants;
import com.bizvane.mktcenterserviceimpl.common.constants.ResponseConstants;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivitySmartPOMapper;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

    /**
     * 查询智能营销活动列表(方块)
     * @param vo
     * @return
     */
    @Override
    public ResponseData<PageInfo<MktActivitySmartPO>> getActivityList(ActivitySmartVO vo, PageForm pageForm) {
        ResponseData responseData = new ResponseData();
        PageHelper.startPage(pageForm.getPageNumber(),pageForm.getPageSize());
//        //品牌id不能为空
//        if(vo.getSysBrandId()==null){
//            responseData.setCode(ResponseConstants.ERROR);
//            responseData.setMessage(ResponseConstants.ERROR_MSG);
//            return responseData;
//        }
        MktActivitySmartPOExample example = new MktActivitySmartPOExample();
        MktActivitySmartPOExample.Criteria criteria = example.createCriteria();
        criteria.andValidEqualTo(Boolean.TRUE).andMktActivityIdEqualTo(ActivityConstants.SMART_ACTIVITY_GROUP);

        if(!StringUtils.isEmpty(vo.getMktTaskName())){
            criteria.andMktTaskNameLike(vo.getMktTaskName());
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
     * 对某个智能营销组创建任务
     * 任务类型：1优惠券营销
     * @return
     */
    @Override
    public ResponseData<Integer> addCouponActivity(ActivitySmartVO vo, List<MktCouponPO> couponCodeList, SysAccountPO stageUser) {
        ResponseData responseData = new ResponseData();

        //新增活动主表

        //新增智能营销表

        //新增奖励券表

        return responseData;
    }

    /**
     * 查询某个智能营销分组
     * @param mktActivitySmartId
     * @return
     */
    @Override
    public ResponseData<MktActivitySmartPO> getActivityById(Long mktActivitySmartId) {
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
//        MktActivitySmartPO mktActivitySmartPO = mktActivitySmartPOMapper.selectByPrimaryKey(mktActivitySmartId);
//        responseData.setData(mktActivitySmartPO);
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
//        MktActivitySmartPO mktActivitySmartPO = mktActivitySmartPOMapper.selectByPrimaryKey(mktActivitySmartId);
//        responseData.setData(mktActivitySmartPO);
        return responseData;
    }
}
