package com.bizvane.messageservice.controller;

import com.bizvane.messageservice.service.WechatMessageLogService;
import com.bizvane.messageservice.service.WechatTuWenMessageLogService;
import com.bizvane.messagefacade.models.vo.WechatMessageLogVO;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.utils.tokens.TokenUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yunjie.tian on 2018/7/31.
 */
@RestController
@RequestMapping("/messageLog")
public class WechatMessageLogController {

    @Autowired
    private WechatMessageLogService wechatMessageLogService;
    
    @Autowired
    private  WechatTuWenMessageLogService  wechatTuWenMessageLogService;

    /**
     * 查找微信消息日志分页
     * @param vo
     * @return
     */
    @ApiOperation(value = "根据条件查询微信消息记录", notes = "根据条件查询微信消息记录", tags = {"微信模板配置"},httpMethod = "POST")
    @RequestMapping("/findPage")
    public ResponseData<Object> findPage(WechatMessageLogVO vo){

        return wechatMessageLogService.findPage(vo);
    }
    
    
    
    /**
     * 查找微信消息日志分页
     * @param vo
     * @return
     */
    @ApiOperation(value = "图文消息接口", notes = "图文消息", tags = {"图文消息"},httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "searchValue", value = "基本查询条件", required = true, dataType = "String"),
            @ApiImplicitParam(name = "sendTimeStart", value = "发送开始时间", required = true, dataType = "String"),
            @ApiImplicitParam(name = "sendTimeEnd", value = "发送结束时间", required = true, dataType = "String"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", required = true, dataType = "String"),
            @ApiImplicitParam(name = "headlTitle", value = "消息名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "groupName", value = "分组名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "sendState", value = "发送状态：0发送成功、1发送失败、 2发送中、3已删除", required = true, dataType = "String")
    })
    @RequestMapping("/findTuWenPage")
    public ResponseData<Object> findTuWenPage(WechatMessageLogVO vo, HttpServletRequest request){
    	
        SysAccountPO stageUser = TokenUtils.getStageUser(request);
        vo.setSysBrandId(stageUser.getBrandId());
        return wechatTuWenMessageLogService.findPage(vo);
    }
    
    /**
     * 微信发送统计
     * @param smsMessageLogVo
     * @return
     */
    @RequestMapping("getStatistics")
    public ResponseData getStatistics(WechatMessageLogVO wechatMessageLogVO){

        return wechatMessageLogService.getStatistics(wechatMessageLogVO);
    }
}
