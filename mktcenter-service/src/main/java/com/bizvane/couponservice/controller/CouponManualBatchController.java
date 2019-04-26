package com.bizvane.couponservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.centerstageservice.models.po.SysAccountPo;
import com.bizvane.couponfacade.models.vo.CouponDetailResponseVO;
import com.bizvane.couponfacade.models.vo.CouponManualRequestVO;
import com.bizvane.couponfacade.models.vo.CouponManualVO;
import com.bizvane.couponservice.common.constants.SysResponseEnum;
import com.bizvane.couponservice.common.utils.HttpUtils;
import com.bizvane.couponservice.service.CouponManualService;
import com.bizvane.members.facade.es.vo.MembersInfoSearchVo;
import com.bizvane.utils.responseinfo.ResponseData;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 批量发劵新controller
 */
@RestController
@RequestMapping("/couponBatchManual")
public class CouponManualBatchController {

    private static final Logger logger = LoggerFactory.getLogger(CouponManualBatchController.class);

    @Autowired
    private CouponManualService couponManualService;
    /**
     * 创建发券任务 手动发券接口(新接口)
     * @return
     */
    @ApiOperation(value = "创建发券任务", notes = "创建发券任务", tags = {"手动发券"},httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "taskName", value = "任务名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "sendTimeStr", value = "发券时间", required = true, dataType = "String"),
            @ApiImplicitParam(name = "sendType", value = "发送类型：1-立即发送，2-指定时间", required = true, dataType = "Byte"),
            @ApiImplicitParam(name = "couponDefinitionIds", value = "券定义id列表", required = true, dataType = "List"),
            @ApiImplicitParam(name = "memberInfo", value = "会员查询条件", required = true, dataType = "MembersInfoSearchVo")
    })
    @RequestMapping(value="/addNewTask", method = RequestMethod.POST)
    ResponseData<String> addNewTask(@RequestBody CouponManualRequestVO requestVO, HttpServletRequest request){

        ResponseData<String> responseData = new ResponseData<>();

        /*CouponManualRequestVO requestVO = JacksonUtil.json2Objs(HttpParamUtil.getJSONParam(request),
                CouponManualRequestVO.class);*/

        if(null == requestVO){
            requestVO = new CouponManualRequestVO();
        }
        SysAccountPo accountPo = HttpUtils.getLoginUser(request);
        CouponManualVO couponManualVO = new CouponManualVO();
        //couponManualVO.setCouponDefinitionId(requestVO.getCouponDefinitionId());
        //set卷定义列表
        couponManualVO.setCouponDefinitionIds(requestVO.getCouponDefinitionIds());

        couponManualVO.setTaskName(requestVO.getTaskName());
        couponManualVO.setSendTimeStr(requestVO.getSendTimeStr());
        couponManualVO.setSendType(requestVO.getSendType());
        couponManualVO.setTotalNumber(requestVO.getTotalNumber());

        MembersInfoSearchVo membersInfoSearchVo = requestVO.getSearchVo();

        logger.info("enter CouponManualBatchController addNewTask method param: SearchVo:{}", JSONObject.toJSONString(membersInfoSearchVo));
        logger.info("enter CouponManualBatchController addNewTask method param: CouponManualVO:{}",JSONObject.toJSONString(couponManualVO));
        logger.info("enter CouponManualBatchController addNewTask method param: SysAccountPo:{}",JSONObject.toJSONString(accountPo));

        try {
            responseData = couponManualService.addNewTask(couponManualVO,membersInfoSearchVo,accountPo);
        }catch (Exception e){
            logger.info(SysResponseEnum.DATE_TRANSFER_EXCEPTION.getMessage());
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.FAILED.getMessage());
            return responseData;
        }
        return responseData;

    }


    /**
     * 根据手动发券id查询发券信息
     * @param couponManualId
     * @return
     */
    @ApiOperation(value = "根据手动发券id查询发券信息", notes = "根据手动发券id查询发券信息", tags = {"手动发券"},httpMethod = "POST")
    @RequestMapping(value="/findNew", method = RequestMethod.POST)
    public ResponseData<CouponDetailResponseVO> findNewById(@RequestParam(value = "couponManualId",required = false) Long couponManualId){
        logger.info("enter findById method param: couponManualId:{}", couponManualId);
        return couponManualService.findNewById(couponManualId);

    }


    /**
     * 修改手动发券任务
     * @param couponManualVO
     * @return
     */
    @ApiOperation(value = "修改手动发券任务", notes = "修改手动发券任务", tags = {"手动发券"},httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "taskName", value = "任务名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "sendTimeStr", value = "发券时间", required = true, dataType = "String"),
            @ApiImplicitParam(name = "sendType", value = "发送类型：1-立即发送，2-指定时间", required = true, dataType = "Byte"),
            @ApiImplicitParam(name = "couponDefinitionIds", value = "券定义id群", required = true, dataType = "String"),
            @ApiImplicitParam(name = "couponManualId", value = "手动发券id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "memberInfo", value = "会员条件", required = true, dataType = "MembersInfoSearchVo")
    })
    @RequestMapping(value="/changeNewManualTask", method = RequestMethod.POST)
    ResponseData<String> changeNewManualTask(CouponManualVO couponManualVO,MembersInfoSearchVo memberInfo,HttpServletRequest request){
        logger.info("enter changeManualTask method param: couponManualVO:{}",JSONObject.toJSONString(couponManualVO));
        ResponseData<String> responseData = new ResponseData<>();
        SysAccountPo accountPo = HttpUtils.getLoginUser(request);
        try {
            responseData = couponManualService.changeNewManualTask(couponManualVO,memberInfo,accountPo);
        }catch (Exception e){
            logger.info(SysResponseEnum.DATE_TRANSFER_EXCEPTION.getMessage());
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.FAILED.getMessage());
            return responseData;
        }

        return responseData;

    }
}
