package com.bizvane.mktcenterservice.rpc;

import com.bizvane.mktcenterservice.models.vo.WhiteStoreVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2018/11/5 13:53
 */
@FeignClient(value = "${feign.client.mktcenter.name}",path = "${feign.client.mktcenter.path}/taskRpc")
public interface TaskServiceRpc {
    @RequestMapping("getWhiteStoreIds")
    public List<Long> getWhiteStoreIds(@RequestBody WhiteStoreVO vo);
}

