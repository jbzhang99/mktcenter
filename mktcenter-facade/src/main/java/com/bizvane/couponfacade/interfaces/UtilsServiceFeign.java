package com.bizvane.couponfacade.interfaces;

import com.bizvane.utils.responseinfo.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by yunjie.tian on 2018/9/6.
 */
@FeignClient(value="${feign.client.coupon.name}",path="${feign.client.coupon.path}/barcode")
@Api(value = "条形码",tags = {"API"})
public interface UtilsServiceFeign {

    /**
     * 生成条形码
     * @return
     */
    @ApiOperation(value = "生成条形码", notes = "生成条形码", tags = {"其它接口"},httpMethod = "POST")
    @RequestMapping(value="/getBarcode", method = RequestMethod.POST)
    ResponseData<String> getBarcode(@RequestParam("msg") String msg);
}
