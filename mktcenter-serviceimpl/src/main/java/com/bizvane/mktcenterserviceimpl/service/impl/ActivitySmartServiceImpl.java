package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.mktcenterservice.interfaces.ActivitySmartService;
import com.bizvane.mktcenterservice.models.po.MktActivitySmartPO;
import com.bizvane.mktcenterservice.models.po.MktActivitySmartPOExample;
import com.bizvane.mktcenterservice.models.vo.ActivitySmartVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterserviceimpl.common.constants.ResponseConstants;
import com.bizvane.mktcenterserviceimpl.common.enums.MktTypeEnum;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivitySmartPOMapper;
import com.bizvane.utils.responseinfo.ResponseData;
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
     * 查询智能营销活动列表
     * @param vo
     * @return
     */
    @Override
    public ResponseData<ActivitySmartVO> getActivityList(ActivitySmartVO vo) {
        ResponseData responseData = new ResponseData();
        List<ActivitySmartVO> activityRegisterList = mktActivitySmartPOMapper.getActivityList(vo);
        responseData.setData(activityRegisterList);
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
        MktActivitySmartPOExample example = new MktActivitySmartPOExample();
        MktActivitySmartPOExample.Criteria criteria = example.createCriteria();
        criteria.andMktActivityIdEqualTo(vo.getMktActivityId()).andValidEqualTo(Boolean.TRUE);
        if(vo.getCreateDateStart()!=null){
            criteria.andCreateDateGreaterThanOrEqualTo(vo.getCreateDateStart());
        }
        if(vo.getCreateDateEnd()!= null){
            criteria.andCreateDateLessThanOrEqualTo(vo.getCreateDateEnd());
        }
        if(vo.getMktType()!=null && vo.getMktType().intValue()!=MktTypeEnum.TASK_STATUS_ALL.getCode()){
            criteria.andMktTypeEqualTo(vo.getMktType());
        }
        List<MktActivitySmartPO> mktActivitySmartPOS = mktActivitySmartPOMapper.selectByExampleWithBLOBs(example);
        PageInfo<MktActivitySmartPO> pageInfo = new PageInfo<>(mktActivitySmartPOS);
        responseData.setData(pageInfo);
        return responseData;
    }
}
