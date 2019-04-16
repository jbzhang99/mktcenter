package com.bizvane.couponfacade.interfaces;

import com.bizvane.couponfacade.models.po.CouponEntityPO;
import com.bizvane.couponfacade.models.vo.*;
import com.bizvane.members.facade.vo.WxChannelInfoVo;
import com.github.pagehelper.PageInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value="${feign.client.mktcenter.name}",path="${feign.client.mktcenter.path}/couponQueryRpc")
@Api(value = "券查询",tags = {"API"})
public interface CouponQueryServiceFeign {

  /**
   * 根据会员code查询券实例
   * @param vo
   * @return
   */
  @ApiOperation(value = "查询某个会员拥有的券", notes = "查询某个会员拥有的券", tags = {"券查询接口"},httpMethod = "POST")
  @RequestMapping(value="/getCouponListRpc", method = RequestMethod.POST)
  ResponseData<PageInfo<CouponEntityAndDefinitionVO>> getCouponListByMemeberCode(@RequestBody CouponListByMemberCodeRequestVO vo);

  /**
   * 根据会员code查询券实例
   * @param vo
   * @return
   */
  @ApiOperation(value = "查询某个会员拥有的券", notes = "查询某个会员拥有的券", tags = {"券查询接口"},httpMethod = "POST")
  @RequestMapping(value="/getMemberCoupon", method = RequestMethod.POST)
  ResponseData<List<CouponEntityAndDefinitionVO>> getMemberCoupon(@RequestBody CouponListByMemberCodeRequestVO vo);

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
  ResponseData<PageInfo<CouponEntityVO>> getListRpc(@RequestBody CouponEntityVO vo);

  /**
   * 根据券号获取券实例信息
   * @param couponCode
   * @return
   */
  @ApiOperation(value = "根据券号获取券实例接口", notes = "根据券号获取券实例接口", tags = {"券查询接口"},httpMethod = "POST")
  @RequestMapping(value="/findCouponRpc/{couponCode}", method = RequestMethod.POST)
  ResponseData<CouponDetailModelVO> findCouponByCouponCode(@PathVariable("couponCode") String couponCode);

  /**
   * 根据券号获取券实例和券定义详情
   * @param couponCode
   * @return
   */
  @ApiOperation(value = "根据券号获取券实例和券定义详情", notes = "根据券号获取券实例和券定义详情", tags = {"券查询接口"},httpMethod = "POST")
  @RequestMapping(value="/findCouponDetailRpc", method = RequestMethod.POST)
  ResponseData<CouponDetailResponseVO> findCouponDetailByCouponCode(@RequestParam(value = "couponCode", required = false) String couponCode,
                                                                    @RequestParam(value = "brandId", required = false) Long brandId);

  /**
   * 根据会员code统计使用状况
   * @param memberCode
   * @return
   */
  @ApiOperation(value = "根据memberCode统计券的使用状况", notes = "根据memberCode统计券的使用状况", tags = {"券查询接口"},httpMethod = "POST")
  @ApiImplicitParams({
          @ApiImplicitParam(name = "memberCode", value = "会员号", required = false, dataType = "String"),
  })
  @RequestMapping(value="/findCountByMemberCode", method = RequestMethod.POST)
  ResponseData<CouponFindCouponCountResponseVO> findCouponCountByMemberCode(@RequestParam(value = "memberCode") String memberCode);

  /**
   * 根据发送业务单号和时间统计券使用状况
   * @return
   */
  @ApiOperation(value = "根据sendBusinessId统计券的使用状况", notes = "根据sendBusinessId统计券的使用状况", tags = {"券查询接口"},httpMethod = "POST")
  @ApiImplicitParams({
          @ApiImplicitParam(name = "sendBusinessId", value = "发券业务单号", required = false, dataType = "Long"),
          @ApiImplicitParam(name = "sendType", value = "业务类型", required = false, dataType = "String"),
          @ApiImplicitParam(name = "sysBrandId", value = "品牌id", required = false, dataType = "Long"),
          @ApiImplicitParam(name = "dtStart", value = "开始时间", required = false, dataType = "Date"),
          @ApiImplicitParam(name = "dtEnd", value = "结束时间", required = false, dataType = "Date"),
  })
  @RequestMapping(value="/findCouponCountByDate", method = RequestMethod.POST)
  ResponseData<CouponFindCouponCountResponseVO> findCouponCountByDate(@RequestBody CouponEntityVO vo);

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
  ResponseData<CouponFindCouponCountResponseVO> findCouponCountBySendBusinessId(@RequestParam(value = "sendBusinessId", required = false) Long sendBusinessId,
                                                                                @RequestParam(value = "sendType", required = false) String sendType,
                                                                                @RequestParam(value = "sysBrandId", required = false) Long sysBrandId);


  /**
   * 根据发券业务单号集合统计券使用状况
   * @param vo
   * @return
   */
  @ApiOperation(value = "根据发券业务单号集合统计券的使用状况", notes = "根据发券业务单号集合统计券的使用状况", tags = {"券实例接口"},httpMethod = "POST")
  @ApiImplicitParams({
          @ApiImplicitParam(name = "sendIdList", value = "id集合", required = true, dataType = "List"),
  })
  @RequestMapping(value="/findCouponCountByList", method = RequestMethod.POST)
  ResponseData<CouponFindCouponCountResponseVO> findCouponCountByList(@RequestBody CouponEntityVO vo);

  /**
   * 根据条件查询券定义和券实例所有信息
   * @param couponEntityId
   * @return
   */
  @ApiOperation(value = "查询优惠券详情", notes = "查询优惠券详情", tags = {"券查询接口"},httpMethod = "POST")
  @RequestMapping(value="/getCouponDetailRpc", method = RequestMethod.POST)
  ResponseData<CouponDetailResponseVO> getCouponDetail(@RequestParam(value = "couponEntityId", required = false) Long couponEntityId);


  /**
   * 查询券详情（根据实例id）
   * @param couponEntityId
   * @return
   */
  @ApiOperation(value = "查询券详情（根据实例id）", notes = "查询券详情（根据实例id）", tags = {"券查询接口"},httpMethod = "POST")
  @RequestMapping(value="/getAllDetailRpc", method = RequestMethod.POST)
  ResponseData<CouponDetailResponseVO> getAllDetailRpc(@RequestParam(value = "couponEntityId", required = false) Long couponEntityId);


  /**
   * 查询单张券定义信息
   * @param couponDefinitionId
   * @return
   */
  @ApiOperation(value = "查询单张券定义信息", notes = "查询单张券定义信息", tags = {"券查询接口"},httpMethod = "POST")
  @RequestMapping(value="/getCouponDefinitionRpc", method = RequestMethod.POST)
  ResponseData<CouponDetailResponseVO> getCouponDefinition(@RequestParam(value = "couponDefinitionId", required = false) Long couponDefinitionId);


  /**
   * 根据会员code查询可使用券列表
   * @param memberCode
   * @return
   */
  @ApiOperation(value = "根据会员code查询可使用券列表", notes = "根据会员code查询可使用券列表", tags = {"券查询接口"},httpMethod = "POST")
  @RequestMapping(value="/getCouponUnused", method = RequestMethod.POST)
  ResponseData<List<CouponEntityPO>> getCouponUnusedByMemberCode(@RequestParam("memberCode") String memberCode);


  /**
   * 根据发送类型（活动，任务）查询券数量
   * @param sendType
   * @param sysBrandId
   * @return
   */
  @ApiOperation(value = "根据发送类型（活动，任务）查询券数量", notes = "根据发送类型（活动，任务）查询券数量", tags = {"券查询接口"},httpMethod = "POST")
  @RequestMapping(value="/getCountBySendType", method = RequestMethod.POST)
  ResponseData<CouponFindCouponCountResponseVO> getCountBySendType(@RequestParam(value = "sendType", required = false) String sendType,
                                                                   @RequestParam(value = "sysBrandId", required = false) Long sysBrandId);


  /**
   * 查询受赠人信息
   * @param fromOpenId
   * @param couponCode
   * @return
   */
  @ApiOperation(value = "查询受赠人信息", notes = "查询受赠人信息", tags = {"券查询接口"},httpMethod = "POST")
  @RequestMapping(value="/findTOMemberInfo", method = RequestMethod.POST)
  ResponseData<WxChannelInfoVo> findTOMemberInfo(@RequestParam("fromOpenId") String fromOpenId,
                                                 @RequestParam("couponCode") String couponCode,
                                                 @RequestParam("sysBrandId") Long sysBrandId);



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
  ResponseData<CouponFindCouponCountResponseVO> findCountBySendType(@RequestParam(value = "sendType") String sendType,
                                                                    @RequestParam(value = "createDate") String createDate,
                                                                    @RequestParam(value = "sysBrandId") Long sysBrandId);


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
  ResponseData<CouponFindCouponCountResponseVO> findCouponCount(@RequestParam(value = "sendBusinessId", required = false) List<String> sendBusinessId,
                                                                @RequestParam(value = "sendType", required = false) Byte sendType,
                                                                @RequestParam(value = "sysBrandId", required = false) Long sysBrandId);



  /**
   * 查询企业微信核销券历史
   * @return
   */
  @ApiOperation(value = "查询企业微信核销券历史", notes = "查询企业微信核销券历史", tags = {"企业微信接口"},httpMethod = "POST")
  @ApiImplicitParams({
          @ApiImplicitParam(name = "searchValue", value = "查询", required = false, dataType = "String")
  })
  @RequestMapping(value="/findQyCouponUseHistory", method = RequestMethod.POST)
  ResponseData<PageInfo<CouponEntityVO>> findQyCouponUseHistory(@RequestParam(value = "staffCode", required = false) String staffCode,
                                                                @RequestParam(value = "searchValue", required = false) String searchValue,
                                                                @RequestParam(value = "pageNumber", required = false) int pageNumber,
                                                                @RequestParam(value = "pageSize", required = false) int pageSize);


}
