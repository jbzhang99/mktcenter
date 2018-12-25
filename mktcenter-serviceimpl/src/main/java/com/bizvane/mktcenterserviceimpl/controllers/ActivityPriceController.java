package com.bizvane.mktcenterserviceimpl.controllers;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.mktcenterservice.interfaces.ActivityPriceService;
import com.bizvane.mktcenterservice.interfaces.ActivityPrizeServiceWX;
import com.bizvane.mktcenterservice.models.po.MktActivityPOWithBLOBs;
import com.bizvane.mktcenterservice.models.po.MktActivityPrizePO;
import com.bizvane.mktcenterservice.models.po.MktActivityPrizeRecordPO;
import com.bizvane.mktcenterservice.models.vo.ActivityPriceBO;
import com.bizvane.mktcenterservice.models.vo.ActivityPriceParamVO;
import com.bizvane.mktcenterservice.models.vo.AnalysisPriceResultVO;
import com.bizvane.utils.responseinfo.ResponseData;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;

/**
 * @Author: lijunwei
 * @Time: 2018/12/21 10:55
 */
@RestController
@RequestMapping("activityPrice")
public class ActivityPriceController {
    @Autowired
    private ActivityPriceService activityPriceService;
    @Autowired
    private ActivityPrizeServiceWX activityPrizeServiceWX;

    /**
     * 新增
     */
    @RequestMapping("addActivityPrice")
    public ResponseData<JSONObject> addActivityPrice(ActivityPriceBO bo, HttpServletRequest request) throws ParseException {
        return activityPriceService.addActivityPrice(bo, request);
    }

    /**
     * 查询详情  id
     */
    @RequestMapping("selectActivityPriceById")
    public ResponseData<ActivityPriceBO> selectActivityPrice(Long mktActivityId, HttpServletRequest request) {
        return activityPriceService.selectActivityPrice(mktActivityId, request);
    }

    /**
     * 查询详情  code
     */
    @RequestMapping("selectActivityPriceByCode")
    public ResponseData<ActivityPriceBO> selectActivityPrice(String activePriceCode) {
        return activityPriceService.selectActivityPrice(activePriceCode);
    }

    /**
     * 活动列表
     */
    @RequestMapping("selectActivityPriceLists")
    public ResponseData<PageInfo<MktActivityPOWithBLOBs>> selectActivityPriceLists(ActivityPriceParamVO vo, HttpServletRequest request) {
        return activityPriceService.selectActivityPriceLists(vo, request);
    }

    /**
     * 禁用
     */
    @RequestMapping("stopActivityPrice")
    public ResponseData<Integer> stopActivityPrice(MktActivityPOWithBLOBs po, HttpServletRequest request) {
        return activityPriceService.stopActivityPrice(po, request);
    }

    /**
     * 统计
     */
    @RequestMapping("selectAnalysisPrice")
    public ResponseData<PageInfo<AnalysisPriceResultVO>> selectAnalysisPrice(ActivityPriceParamVO vo, HttpServletRequest request) {
        return activityPriceService.selectAnalysisPrice(vo, request);
    }

    /**
     * 中奖会员展示
     */
    @RequestMapping("selectPrizePeople")
    public ResponseData<PageInfo<MktActivityPrizeRecordPO>> selectPrizePeople(ActivityPriceParamVO vo) {
        return activityPriceService.selectPrizePeople(vo);
    }

    /**
     * 核销
     */
    @RequestMapping("doVerificationCoupon")
    public ResponseData<String> doVerificationCoupon(ActivityPriceParamVO vo, HttpServletRequest request) {
        return activityPriceService.doVerificationCoupon(vo, request);
    }

    /**
     * 下载
     */
    @RequestMapping("exportQRCodes")
    public ResponseData<String> exportQRCodes(ActivityPriceParamVO vo, HttpServletRequest request, HttpServletResponse response) {
        return activityPriceService.exportQRCodes(vo, request, response);
    }

    /**
     * wang keqiang 自测
     * @param activePriceCode
     * @param memberCode
     * @return
     */
    @RequestMapping("executePrize")
    public ResponseData<MktActivityPrizePO> executePrize( String activePriceCode,String memberCode) {
        return activityPrizeServiceWX.executeActivityPrize(activePriceCode, memberCode);
    }
}
