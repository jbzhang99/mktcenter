package com.bizvane.mktcenterservice.interfaces;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.mktcenterservice.models.po.MktActivityPOWithBLOBs;
import com.bizvane.mktcenterservice.models.po.MktActivityPrizeRecordPO;
import com.bizvane.mktcenterservice.models.vo.ActivityPriceBO;
import com.bizvane.mktcenterservice.models.vo.ActivityPriceParamVO;
import com.bizvane.mktcenterservice.models.vo.ActivityPrizeBO;
import com.bizvane.mktcenterservice.models.vo.AnalysisPriceResultVO;
import com.bizvane.utils.responseinfo.ResponseData;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;

/**
 * @Author: lijunwei
 * @Time: 2018/12/19 14:21
 */
public interface ActivityPriceService {

    public ResponseData<JSONObject> addActivityPrice(ActivityPriceBO bo, HttpServletRequest request) throws ParseException;
    public ResponseData<ActivityPriceBO> selectActivityPrice(Long mktActivityId,HttpServletRequest request);
    public ResponseData<ActivityPrizeBO> selectActivityPrice(String activePriceCode);
    public ResponseData<PageInfo<MktActivityPOWithBLOBs>> selectActivityPriceLists(ActivityPriceParamVO vo, HttpServletRequest request);
    public ResponseData<Integer> stopActivityPrice(MktActivityPOWithBLOBs po, HttpServletRequest request);
    public ResponseData<PageInfo<AnalysisPriceResultVO>> selectAnalysisPrice(ActivityPriceParamVO vo, HttpServletRequest request);
    public ResponseData<PageInfo<MktActivityPrizeRecordPO>> selectPrizePeople(ActivityPriceParamVO vo);
    public ResponseData<String> doVerificationCoupon(ActivityPriceParamVO vo, HttpServletRequest request);
    public ResponseData<String> exportQRCodes(ActivityPriceParamVO vo, HttpServletRequest request, HttpServletResponse response);
}
