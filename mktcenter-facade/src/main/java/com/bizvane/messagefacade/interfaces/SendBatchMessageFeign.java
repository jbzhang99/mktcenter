package com.bizvane.messagefacade.interfaces;

import com.bizvane.messagefacade.models.vo.SysSmsConfigVO;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: lijunwei
 * @Time: 2018/8/20 10:20
 * 批量发送短信
 */
@FeignClient(value="${feign.client.mktcenter.name}",path="${feign.client.mktcenter.path}/msg")
public interface SendBatchMessageFeign {
    /**
     * 批量发送短信
     * @param vo
     * @return
     */
    @RequestMapping(value ="/sendBatchsmg",method = RequestMethod.POST)
    public ResponseData<Integer> sendSmgBatch(@RequestBody SysSmsConfigVO vo);

}
