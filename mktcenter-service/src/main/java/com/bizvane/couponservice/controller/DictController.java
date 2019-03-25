package com.bizvane.couponservice.controller;

import com.bizvane.couponfacade.models.po.SysCodeValuePO;
import com.bizvane.couponservice.service.DictService;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by yunjie.tian on 2018/7/30.
 */
@RestController
@RequestMapping("/dict")
public class DictController {
    private static final Logger logger = LoggerFactory.getLogger(DictController.class);
    @Autowired
    private DictService dictService;

    /**
     * 根据参数类型获取集合
     * @param dictType
     * @return
     */
    @ApiOperation(value = "根据参数类型查询参数", notes = "根据参数类型查询参数", tags = {"参数查询"},httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dictType", value = "参数类型", required = true, dataType = "String"),
    })
    @RequestMapping("/get.do")
    public ResponseData<Object> getDict(@RequestParam(value = "dictType",required = false)String dictType){
        logger.info("enter getDict method param: dictType:{}",dictType);
        ResponseData<Object> responseData = new ResponseData<>();

        if(StringUtils.isBlank(dictType)){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage("参数类型不能为空");
            return responseData;
        }
        List<SysCodeValuePO> list = dictService.getDicts(dictType);

        responseData.setData(list);
        return responseData;
    }



    /**
     * 根据参数类型获取集合（批量）
     * @param dictType
     * @return
     */
    @ApiOperation(value = "根据参数类型查询参数(批量)", notes = "根据参数类型查询参数(批量)", tags = {"参数查询"},httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dictType", value = "参数类型", required = true, dataType = "String",example = "A,B,C"),
    })
    @RequestMapping("/getBatch.do")
    public ResponseData<Map<String,List<SysCodeValuePO>>> getDictBatch(@RequestParam(value = "dictType",required = false)String dictType){
        logger.info("enter getDictBatch method param: dictType:{}",dictType);
        ResponseData<Map<String,List<SysCodeValuePO>>> responseData = new ResponseData<>();

        if(StringUtils.isBlank(dictType)){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage("参数类型不能为空");
            return responseData;
        }
        Map<String,List<SysCodeValuePO>> map = dictService.getDictsBatch(dictType);

        responseData.setData(map);
        return responseData;
    }
}
