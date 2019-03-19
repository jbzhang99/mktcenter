package com.bizvane.messagefacade.interfaces;

import com.bizvane.messagefacade.models.vo.WechatMessageLogVO;
import com.bizvane.utils.responseinfo.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yunjie.tian on 2018/7/31.
 */
@FeignClient(value="${feign.client.mktcenter.name}",path="${feign.client.mktcenter.path}/messageLog")
@Api(value = "微信消息记录",tags = {"微信消息记录"})
public interface WechatMessageLogFeign {

    /**
     * 查找微信消息日志分页
     * @param vo
     * @return
     */
    @ApiOperation(value = "微信消息记录")
    @RequestMapping(value = "/findPage", method = RequestMethod.POST)
    ResponseData<Object> findPage(@RequestBody WechatMessageLogVO vo);

}
