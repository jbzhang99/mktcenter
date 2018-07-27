package com.bizvane.mktcenterservice.rpc;

import com.bizvane.mktcenterservice.models.po.MktActivityPOWithBLOBs;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by agan on 2018/7/27.
 */
@FeignClient("${feign.client.mktcenter.name}")
@RequestMapping("${feign.client.mktcenter.path}/activity")
public interface ActivityServiceRpc {
    /**
     * 审核
     * @param bs
     * @return
     */
    @RequestMapping("checkActivityById")
   ResponseData<Integer> checkActivityByIdRpc(@RequestBody MktActivityPOWithBLOBs bs);
}
