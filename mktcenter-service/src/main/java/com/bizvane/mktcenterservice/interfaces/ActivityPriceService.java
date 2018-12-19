package com.bizvane.mktcenterservice.interfaces;

import com.bizvane.mktcenterservice.models.vo.ActivityPriceBO;
import com.bizvane.utils.responseinfo.ResponseData;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: lijunwei
 * @Time: 2018/12/19 14:21
 */
public interface ActivityPriceService {

    public ResponseData<String> addActivityPrice(ActivityPriceBO bo, HttpServletRequest request);
    public ResponseData<ActivityPriceBO> selectActivityPrice(Long mktActivityId,HttpServletRequest request);
}
