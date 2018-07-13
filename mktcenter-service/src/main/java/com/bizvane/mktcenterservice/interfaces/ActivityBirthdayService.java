package com.bizvane.mktcenterservice.interfaces;

import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.utils.commonutils.PageForm;
import com.bizvane.utils.responseinfo.ResponseData;

/**
 * @author chen.li
 * @date on 2018/7/13 18:46
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public interface ActivityBirthdayService {

    /**
     * 查询生日活动列表
     * @param vo
     * @return
     */
    public ResponseData<ActivityVO> getActivityList(ActivityVO vo, PageForm pageForm);
}
