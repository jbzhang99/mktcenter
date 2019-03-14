package com.bizvane.couponservice.controller.rpc;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.couponfacade.models.po.CouponEntityPO;
import com.bizvane.couponfacade.models.vo.*;
import com.bizvane.couponfacade.utils.PageFormUtil;
import com.bizvane.couponservice.common.constants.SysResponseEnum;
import com.bizvane.couponservice.service.CouponEntityService;
import com.bizvane.couponservice.service.CouponService;
import com.bizvane.members.facade.vo.WxChannelInfoVo;
import com.bizvane.utils.responseinfo.ResponseData;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yunjie.tian on 2018/8/8.
 */
@RestController
@RequestMapping("/couponQueryRpc")
public class CouponQueryRpcController {

    private static Logger logger = LoggerFactory.getLogger(CouponQueryRpcController.class);

    @Autowired
    private CouponService couponService;
    @Autowired
    private CouponEntityService couponEntityService;

    /**
     * 根据会员code查询券实例
     * @param vo
     * @return
     */
    @ApiOperation(value = "根据memberCode查询券实例接口", notes = "根据memberCode查询券实例接口", tags = {"券查询接口"},httpMethod = "POST")
    @RequestMapping(value="/getCouponListRpc", method = RequestMethod.POST)
    ResponseData<PageInfo<CouponEntityAndDefinitionVO>> getCouponListByMemeberCode(@RequestBody CouponListByMemberCodeRequestVO vo){
        logger.info("enter getCouponListByMemeberCode method param:CouponListByMemberCodeRequestVO:{}", JSONObject.toJSONString(vo));
        PageFormUtil pageFormUtil = new PageFormUtil();
        pageFormUtil.setPageNumber(vo.getPageNumber());
        pageFormUtil.setPageSize(vo.getPageSize());
        return couponService.getCouponListByMemeberCode(vo,pageFormUtil);

    }


    /**
     * 根据会员code查询券实例
     * @param vo
     * @return
     */
    @ApiOperation(value = "查询某个会员拥有的券", notes = "查询某个会员拥有的券", tags = {"券查询接口"},httpMethod = "POST")
    @RequestMapping(value="/getMemberCoupon", method = RequestMethod.POST)
    ResponseData<List<CouponEntityAndDefinitionVO>> getMemberCoupon(@RequestBody CouponListByMemberCodeRequestVO vo){
        logger.info("enter getMemberCoupon method param:getMemberCoupon:{}", JSONObject.toJSONString(vo));
        return couponService.getMemberCoupon(vo);
    }


    /**
     * 根据条件查询券实例
     * @param vo
     * @return
     */
    @ApiOperation(value = "根据条件查询券实例接口", notes = "根据条件查询券实例接口", tags = {"券查询接口"},httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysBrandId", value = "品牌id", required = true, dataType = "Long"),
    })
    @RequestMapping(value="/getListRpc", method = RequestMethod.POST)
    ResponseData<PageInfo<CouponEntityVO>> getListRpc(@RequestBody CouponEntityVO vo){
        logger.info("enter getListRpc method param:CouponEntityVO:{}",JSONObject.toJSONString(vo));
        PageFormUtil pageForm = new PageFormUtil();
        pageForm.setPageNumber(vo.getPageNumber());
        pageForm.setPageSize(vo.getPageSize());
        return couponEntityService.getListRpc(vo,pageForm);

    }

    /**
     * 根据券code查询券详情
     * @param couponCode
     * @return
     */
    @ApiOperation(value = "根据券号获取券实例接口", notes = "根据券号获取券实例接口", tags = {"券查询接口"},httpMethod = "POST")
    @RequestMapping(value="/findCouponRpc/{couponCode}", method = RequestMethod.POST)
    ResponseData<CouponDetailModelVO> findCouponByCouponCode(@PathVariable("couponCode") String couponCode){
        logger.info("enter findCouponByCouponCode method param:couponCode:{}",couponCode);
        return couponService.findCouponByCouponCode(couponCode);

    }

    /**
     * 根据券号获取券实例和券定义详情
     * @param couponCode
     * @return
     */
    @RequestMapping(value="/findCouponDetailRpc", method = RequestMethod.POST)
    ResponseData<CouponDetailResponseVO> findCouponDetailByCouponCode(@RequestParam(value = "couponCode",required = false) String couponCode,
                                                                      @RequestParam(value = "brandId",required = false)Long brandId){
        logger.info("enter findCouponDetailByCouponCode method param:couponCode:{}",couponCode);
        return couponService.findCouponDetailByCouponCode(couponCode,brandId);
    }

    /**
     * 根据会员code统计使用状况
     * @param memberCode
     * @return
     */
    @ApiOperation(value = "根据会员code统计使用状况", notes = "根据会员code统计使用状况", tags = {"券查询接口"},httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "memberCode", value = "会员号", required = false, dataType = "String"),
    })
    @RequestMapping(value="/findCountByMemberCode", method = RequestMethod.POST)
    public ResponseData<CouponFindCouponCountResponseVO> findCouponCountByMemberCode(@RequestParam(value = "memberCode",required = false) String memberCode){
        logger.info("enter findCouponCountByMemberCode method param:memberCode:{}",memberCode);
        ResponseData<CouponFindCouponCountResponseVO> responseData = couponService.findCouponCountByMemberCode(memberCode);
        return responseData;
    }


    /**
     * 根据发送业务单号和时间统计券使用状况
     * @return
     */
    @ApiOperation(value = "根据sendBusinessId和时间统计券的使用状况", notes = "根据sendBusinessId统计券的使用状况", tags = {"券查询接口"},httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sendBusinessId", value = "发券业务单号", required = false, dataType = "Long"),
            @ApiImplicitParam(name = "sendType", value = "业务类型", required = false, dataType = "String"),
            @ApiImplicitParam(name = "sysBrandId", value = "品牌id", required = false, dataType = "Long"),
            @ApiImplicitParam(name = "dtStart", value = "开始时间", required = false, dataType = "Date"),
            @ApiImplicitParam(name = "dtEnd", value = "结束时间", required = false, dataType = "Date")
    })
    @RequestMapping(value="/findCouponCountByDate", method = RequestMethod.POST)
    ResponseData<CouponFindCouponCountResponseVO> findCouponCountByDate(@RequestBody CouponEntityVO vo){
        logger.info("enter findCouponCountBySendBusinessId method param:CouponEntityVO:{}",JSONObject.toJSONString(vo));
        ResponseData<CouponFindCouponCountResponseVO> responseData = couponService.findCouponCountByDate(vo);
        return responseData;
    };


    /**
     * 统计券使用状况
     * @param sendBusinessId
     * @param sendType
     * @param sysBrandId
     * @return
     */
    @ApiOperation(value = "统计券使用状况", notes = "统计券使用状况", tags = {"券查询接口"},httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sendBusinessId", value = "发券业务单号", required = false, dataType = "Long"),
            @ApiImplicitParam(name = "sendType", value = "发送类型", required = false, dataType = "String"),
            @ApiImplicitParam(name = "sysBrandId", value = "品牌id", required = false, dataType = "Long")
    })
    @RequestMapping(value="/findCouponCountBySendBusinessId", method = RequestMethod.POST)
    ResponseData<CouponFindCouponCountResponseVO> findCouponCountBySendBusinessId(@RequestParam(value = "sendBusinessId",required = false) Long sendBusinessId,
                                                                                  @RequestParam(value = "sendType",required = false) String sendType,
                                                                                  @RequestParam(value = "sysBrandId",required = false) Long sysBrandId){
        logger.info("enter findCouponCountBySendBusinessId method param:sendBusinessId:{},sendType:{},sysBrandId:{}",sendBusinessId,sendType,sysBrandId);
        ResponseData<CouponFindCouponCountResponseVO> responseData = couponService.findCouponCountBySendBusinessId(sendBusinessId,sendType,sysBrandId);
        return responseData;
    }


    /**
     * 根据发券业务单号集合统计券使用状况
     * @param vo
     * @return
     */
    @ApiOperation(value = "根据发券业务单号集合统计券的使用状况", notes = "根据发券业务单号集合统计券的使用状况", tags = {"券查询接口"},httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sendIdList", value = "id集合", required = true, dataType = "List"),
    })
    @RequestMapping(value="/findCouponCountByList", method = RequestMethod.POST)
    ResponseData<CouponFindCouponCountResponseVO> findCouponCountByList(@RequestBody CouponEntityVO vo){
        logger.info("enter findCouponCountByList method param:CouponEntityVO:{}",JSONObject.toJSONString(vo));
        return couponService.findCouponCountByList(vo);
    }

    /**
     * 根据条件查询券定义和券实例所有信息
     * @param couponEntityId
     * @return
     */
    @ApiOperation(value = "根据券实例id查询券详情", notes = "根据券实例id查询券详情", tags = {"券查询接口"},httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "couponEntityId", value = "券实例id", required = true, dataType = "Long"),
    })
    @RequestMapping(value="/getCouponDetailRpc", method = RequestMethod.POST)
    ResponseData<CouponDetailResponseVO> getCouponDetail(@RequestParam(value = "couponEntityId",required = false)Long couponEntityId){
        logger.info("enter getCouponDetail method param:couponEntityId:{}",couponEntityId);
        return couponEntityService.getCouponEntityAndDefinitionByEntityId(couponEntityId);
    }

    /**
     * 查询券详情（根据实例id）
     * @param couponEntityId
     * @return
     */
    @ApiOperation(value = "查询券详情（根据实例id）", notes = "查询券详情（根据实例id）", tags = {"券查询接口"},httpMethod = "POST")
    @RequestMapping(value="/getAllDetailRpc", method = RequestMethod.POST)
    ResponseData<CouponDetailResponseVO> getAllDetailRpc(@RequestParam(value = "couponEntityId",required = false) Long couponEntityId){

        logger.info("enter getAllDetailRpc method param:couponEntityId:{}",couponEntityId);
        return couponEntityService.getAllDetailRpc(couponEntityId);
    }


    /**
     * 查询单张券定义信息
     * @param couponDefinitionId
     * @return
     */
    @ApiOperation(value = "查询单张券定义信息", notes = "查询单张券定义信息", tags = {"券查询接口"},httpMethod = "POST")
    @RequestMapping(value="/getCouponDefinitionRpc", method = RequestMethod.POST)
    ResponseData<CouponDetailResponseVO> getCouponDefinition(@RequestParam(value = "couponDefinitionId",required = false) Long couponDefinitionId){

        logger.info("enter getCouponDefinition method param:couponDefinitionId:{}",couponDefinitionId);
        return couponEntityService.getCouponDefinition(couponDefinitionId);

    }



    /**
     * 根据会员code查询可使用券列表
     * @param memberCode
     * @return
     */
    @ApiOperation(value = "根据会员code查询可使用券列表", notes = "根据会员code查询可使用券列表", tags = {"券查询接口"},httpMethod = "POST")
    @RequestMapping(value="/getCouponUnused", method = RequestMethod.POST)
    ResponseData<List<CouponEntityPO>> getCouponUnusedByMemberCode(@RequestParam("memberCode")String memberCode){
        logger.info("enter getCouponUnusedByMemberCode method param:memberCode:{}",memberCode);
        return couponService.getCouponUnusedByMemberCode(memberCode);
    }


    /**
     * 根据发送类型（活动，任务）查询券数量
     * @param sendType
     * @param sysBrandId
     * @return
     */
    @ApiOperation(value = "根据发送类型（活动，任务）查询券数量", notes = "根据发送类型（活动，任务）查询券数量", tags = {"券查询接口"},httpMethod = "POST")
    @RequestMapping(value="/getCountBySendType", method = RequestMethod.POST)
    ResponseData<CouponFindCouponCountResponseVO> getCountBySendType(@RequestParam(value = "sendType",required = false)String sendType,
                                                                     @RequestParam(value = "sysBrandId",required = false)Long sysBrandId){
        logger.info("enter getCountBySendType method param:sendType:{},sysBrandId:{}",sendType,sysBrandId);
        return couponService.getCountBySendType(sendType,sysBrandId);
    }


    /**
     * 查询受赠人信息
     * @param fromOpenId
     * @param couponCode
     * @return
     */
    @ApiOperation(value = "查询受赠人信息", notes = "查询受赠人信息", tags = {"券查询接口"},httpMethod = "POST")
    @RequestMapping(value="/findTOMemberInfo", method = RequestMethod.POST)
    ResponseData<WxChannelInfoVo> findTOMemberInfo(@RequestParam(value = "fromOpenId",required = false)String fromOpenId,
                                                   @RequestParam(value = "couponCode",required = false)String couponCode,
                                                   @RequestParam(value = "sysBrandId",required = false)Long sysBrandId){
        logger.info("enter findTOMemberInfo method param:fromOpenId:{},couponCode:{},sysBrandId:{}",fromOpenId,couponCode,sysBrandId);
        ResponseData<WxChannelInfoVo> responseData = couponService.findTOMemberInfo(fromOpenId,couponCode,sysBrandId);
        return responseData;
    }



    /**
     * 根据发券时间和券类型统计券使用状况
     * @param sendType
     * @param createDate
     * @return
     */
    @ApiOperation(value = "根据发券时间和券类型统计券使用状况", notes = "根据发券时间和券类型统计券使用状况", tags = {"券查询接口"},httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sendType", value = "发送类型", required = false, dataType = "String"),
            @ApiImplicitParam(name = "createDate", value = "发送时间", required = false, dataType = "String"),
            @ApiImplicitParam(name = "sysBrandId", value = "品牌id", required = false, dataType = "Long")
    })
    @RequestMapping(value="/findCountBySendType", method = RequestMethod.POST)
    ResponseData<CouponFindCouponCountResponseVO> findCountBySendType(@RequestParam(value = "sendType",required = false) String sendType,
                                                                      @RequestParam(value = "createDate",required = false) String createDate,
                                                                      @RequestParam(value = "sysBrandId",required = false) Long sysBrandId){
        logger.info("enter findCouponCountBySendBusinessId method param:sendType:{},createDate:{},sysBrandId:{}",sendType,createDate,sysBrandId);
        ResponseData<CouponFindCouponCountResponseVO> responseData = null;
        try {
            responseData = couponService.findCountBySendType(sendType,createDate,sysBrandId);
        }catch (Exception e){
            logger.info(SysResponseEnum.DATE_TRANSFER_EXCEPTION.getMessage());
        }

        return responseData;
    }




    /**
     * 根据多个业务id和业务类型统计券的使用状况
     * @return
     */
    @ApiOperation(value = "根据多个业务id和业务类型统计券的使用状况", notes = "根据多个业务id和业务类型统计券的使用状况", tags = {"券查询接口"},httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sendType", value = "发送类型", required = false, dataType = "String"),
            @ApiImplicitParam(name = "createDate", value = "发送时间", required = false, dataType = "String"),
            @ApiImplicitParam(name = "sysBrandId", value = "品牌id", required = false, dataType = "Long")
    })
    @RequestMapping(value="/findCouponCountBySendBusinessIdList", method = RequestMethod.POST)
    ResponseData<CouponFindCouponCountResponseVO> findCouponCount(@RequestParam(value = "sendBusinessId",required = false)List<String> sendBusinessId,
                                                                  @RequestParam(value = "sendType",required = false)Byte sendType,
                                                                  @RequestParam(value = "sysBrandId",required = false)Long sysBrandId){
        logger.info("enter findCouponCount method param:sendType:{},sendBusinessId:{}",sendType,JSONObject.toJSONString(sendBusinessId));

        ResponseData<CouponFindCouponCountResponseVO> responseData = couponService.findCouponCount(sendBusinessId,sendType,sysBrandId);

        return responseData;
    }



    /**
     * 查询企业微信核销券历史
     * @return
     */
    @ApiOperation(value = "查询企业微信核销券历史", notes = "查询企业微信核销券历史", tags = {"企业微信接口"},httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "searchValue", value = "查询", required = false, dataType = "String")
    })
    @RequestMapping(value="/findQyCouponUseHistory", method = RequestMethod.POST)
    ResponseData<PageInfo<CouponEntityVO>> findQyCouponUseHistory(@RequestParam(value = "staffCode",required = false)String staffCode,
                                                                  @RequestParam(value = "searchValue",required = false)String searchValue,
                                                                  @RequestParam(value = "pageNumber",required = false)int pageNumber,
                                                                  @RequestParam(value = "pageSize",required = false)int pageSize){
        ResponseData<PageInfo<CouponEntityVO>> responseData = couponService.findQyCouponUseHistory(staffCode,searchValue,pageNumber,pageSize);
        return responseData;
    }



}
