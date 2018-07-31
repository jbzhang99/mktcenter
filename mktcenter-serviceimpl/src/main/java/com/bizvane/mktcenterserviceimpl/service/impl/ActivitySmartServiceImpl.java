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
    public ResponseData<List<ActivitySmartVO>> getActivityList(ActivitySmartVO vo) {
        ResponseData responseData = new ResponseData();
        //品牌id不能为空
        if(vo.getSysBrandId()==null){
            responseData.setCode(ResponseConstants.ERROR);
            responseData.setMessage(ResponseConstants.ERROR_MSG);
            return responseData;
        }
        MktActivitySmartPOExample example = new MktActivitySmartPOExample();
        example.createCriteria().andValidEqualTo(Boolean.TRUE).andMktActivityIdEqualTo(ActivityConstants.SMART_ACTIVITY_GROUP);
        List<MktActivitySmartPO> mktActivitySmartPOS = mktActivitySmartPOMapper.selectByExampleWithBLOBs(example);
        responseData.setData(mktActivitySmartPOS);
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
}
