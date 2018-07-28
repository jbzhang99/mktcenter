package com.bizvane.mktcenterservice.rpc;

import com.bizvane.mktcenterservice.models.vo.ActivitySmartVO;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chen.li
 * @date on 2018/7/27 15:16
 * @description 智能营销对外接口
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@FeignClient("${feign.client.mktcenter.name}")
@RequestMapping("${feign.client.mktcenter.path}/activitySmartRpc")
public interface ActivitySmartServiceRpc {

    @RequestMapping("getActivityById")
    public ResponseData<Integer> getActivityById(ActivitySmartVO vo);

    @RequestMapping("getActivityList")
    public ResponseData<Integer> getActivityList(ActivitySmartVO vo);

    @RequestMapping("addActivity")
    public ResponseData<Integer> addActivity(ActivitySmartVO vo);

    @RequestMapping("updateActivity")
    public ResponseData<Integer> updateActivity(ActivitySmartVO vo);

}
