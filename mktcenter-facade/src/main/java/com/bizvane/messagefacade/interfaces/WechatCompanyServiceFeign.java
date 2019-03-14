package com.bizvane.messagefacade.interfaces;

import com.bizvane.messagefacade.models.vo.Result;
import com.bizvane.messagefacade.models.vo.WechatEnterpriseMessageVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yunjie.tian on 2019/1/11.
 */
@FeignClient(value="${feign.client.message.name}",path="${feign.client.message.path}/wechatCompany")
public interface WechatCompanyServiceFeign {

    /**
     * 离线消息
     * @return
     */
    @RequestMapping(value = "/offlineInfo", method = RequestMethod.POST)
    public Result<String> offlineInfo(@RequestBody WechatEnterpriseMessageVO requestVO);

}
