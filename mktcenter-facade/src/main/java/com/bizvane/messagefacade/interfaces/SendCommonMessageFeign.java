package com.bizvane.messagefacade.interfaces;

import com.bizvane.messagefacade.models.vo.SysSmsConfigVO;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: lijunwei
 * @Time: 2018/7/19 14:11
 */
@FeignClient(value="${feign.client.mktcenter.name}",path="${feign.client.mktcenter.path}/msg")
public interface SendCommonMessageFeign {
    /**
     * 发送短信
     * @param vo
     * @return
     */
    @RequestMapping(value ="/sendsmg",method = RequestMethod.POST)
    public ResponseData<Integer> sendSmg(@RequestBody SysSmsConfigVO vo);
}
