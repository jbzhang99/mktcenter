package com.bizvane.couponservice.controller.rpc;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.couponservice.common.constants.SysResponseEnum;
import com.bizvane.couponservice.common.utils.BarcodeUtil;
import com.bizvane.utils.responseinfo.ResponseData;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/barcode")
public class UtilsRpcController {

    private static final Logger logger = LoggerFactory.getLogger(UtilsRpcController.class);

    /**
     * 生成条形码
     * @return
     */
    @ApiOperation(value = "生成条形码", notes = "生成条形码", tags = {"其它接口"},httpMethod = "POST")
    @RequestMapping(value="/getBarcode", method = RequestMethod.POST)
    ResponseData<String> getBarcode(@RequestParam(value = "msg",required = false)String msg){

        logger.info("enter UtilsRpcController getBarcode method param:{}", JSONObject.toJSONString(msg));

        ResponseData<String> responseData = new ResponseData<>();
        if(StringUtils.isBlank(msg)){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.SYSTEM_DATA_NOT_EMPTY.getMessage());
            return responseData;
        }
        String url = BarcodeUtil.generateBarCode(msg);

        responseData.setData(url);
        return responseData;
    }

}
