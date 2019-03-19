package com.bizvane.couponfacade.interfaces;

import com.bizvane.couponfacade.models.po.CouponEntityPO;
import com.bizvane.couponfacade.models.vo.CouponSendMemberListRequestVO;
import com.bizvane.couponfacade.models.vo.CouponSendMemberListResponseVO;
import com.bizvane.couponfacade.models.vo.CouponStatusUpdateBatchRequestVO;
import com.bizvane.utils.responseinfo.ResponseData;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by yunjie.tian on 2018/8/7.
 */
@FeignClient(value="${feign.client.mktcenter.name}",path="${feign.client.mktcenter.path}/couponEntityRpc")
@Api(value = "券实例接口",tags = {"券实例接口"})
public interface CouponEntityServiceFeign {

    @ApiOperation(value = "查询会员是否有某个券", notes = "查询会员是否有某个券", tags = {"券实例接口"},httpMethod = "POST")
    @RequestMapping(value="/findCouponHave", method = RequestMethod.POST)
    public ResponseData<List<CouponEntityPO>> findCouponHave(@RequestParam(value = "memberCode", required = false) String memberCode,
                                                             @RequestParam(value = "sendBusinessId", required = false) Long sendBusinessId,
                                                             @RequestParam(value = "date", required = false) String date);

    @ApiOperation(value = "单张发券收到线下处理结果", notes = "根据couponCode更新券状态", tags = {"券实例接口"},httpMethod = "POST")
    @RequestMapping(value="/updateCouponStatus", method = RequestMethod.POST)
    public ResponseData<Integer> updateCouponStatus(@RequestParam("couponCode") String couponCode,
                                                    @RequestParam("couponStatus") Byte couponStatus,
                                                    @RequestParam("ifSendAgain") Integer ifSendAgain);

    @ApiOperation(value = "批量发券收到线下处理结果", notes = "根据couponCode批量更新券状态", tags = {"券实例接口"},httpMethod = "POST")
    @RequestMapping(value="/updateCouponStatusBatch", method = RequestMethod.POST)
    public ResponseData<Integer> updateCouponStatusBatch(@RequestBody CouponStatusUpdateBatchRequestVO vo);


    @ApiOperation(value = "查询活动/任务发送的券的会员列表", notes = "查询活动/任务发送的券的会员列表", tags = {"券实例接口"},httpMethod = "POST")
    @RequestMapping(value="/findCouponSendMemberList", method = RequestMethod.POST)
    public ResponseData<PageInfo<CouponSendMemberListResponseVO>> findCouponSendMemberList(@RequestBody(required = false) CouponSendMemberListRequestVO requestVO);
}
