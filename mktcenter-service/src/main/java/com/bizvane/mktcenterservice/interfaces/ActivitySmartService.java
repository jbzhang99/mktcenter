package com.bizvane.mktcenterservice.interfaces;

import com.bizvane.mktcenterservice.models.vo.ActivitySmartVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.utils.responseinfo.ResponseData;
import com.github.pagehelper.PageInfo;

/**
 * @author chen.li
 * @date on 2018/7/13 18:44
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public interface ActivitySmartService {

    /**
     * 查询智能营销活动列表
     * @param vo
     * @return
     */
    public ResponseData<PageInfo<ActivitySmartVO>> getActivityList(ActivitySmartVO vo, PageForm pageForm);
}
