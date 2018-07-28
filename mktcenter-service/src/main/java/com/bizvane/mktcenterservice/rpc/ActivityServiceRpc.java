package com.bizvane.mktcenterservice.rpc;

import com.bizvane.mktcenterservice.models.po.MktActivityPOWithBLOBs;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by agan on 2018/7/27.
 */
@FeignClient("${feign.client.mktcenter.name}")
@RequestMapping("${feign.client.mktcenter.path}/activityRpc")
public interface ActivityServiceRpc {
    /**
     * 审核
     * @param bs
     * @return
     */
    @RequestMapping("checkActivityById")
   ResponseData<Integer> checkActivityByIdRpc(@RequestBody MktActivityPOWithBLOBs bs);

    /**
     * 禁用/启用活动
     * @param vo
     * @return
     */
    @RequestMapping("updateActivityStatusById")
    public ResponseData<Integer> stopActivityById(@RequestBody ActivityVO vo);
}
