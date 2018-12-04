package com.bizvane.mktcenterservice.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bizvane.mktcenterservice.models.requestvo.EmpDailyback;
import com.bizvane.mktcenterservice.models.requestvo.postvo.EmpDaily;
import com.bizvane.utils.responseinfo.ResponseData;

/**
 * @Author: lijunwei
 * @Time: 2018/11/5 13:53
 */
@FeignClient("${feign.client.mktcenter.name}")
@RequestMapping("${feign.client.mktcenter.path}/quotaRpc")
public interface QuotaServiceRpc {
    
    
    @RequestMapping("empDaily")
    public ResponseData<EmpDailyback> empDaily(@RequestBody EmpDaily sendVO);
}

