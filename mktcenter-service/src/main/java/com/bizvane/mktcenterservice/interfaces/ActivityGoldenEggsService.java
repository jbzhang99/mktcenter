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
import java.text.ParseException;

/**
 * @Author: lijunwei
 * @Time: 2019/2/25 10:17
 */
public interface ActivityGoldenEggsService {
    public ResponseData<JSONObject> addActivityGE(ActivityPriceBO bo, HttpServletRequest request) throws ParseException;
    public ResponseData<ActivityPriceBO> selectActivityGEById(Long mktActivityId, HttpServletRequest request);
    public ResponseData<ActivityPrizeBO> selectActivityGEByCode(String activePriceCode);
    public ResponseData<PageInfo<MktActivityPOWithBLOBs>> selectActivityEGLists(ActivityPriceParamVO vo, HttpServletRequest request);
    public ResponseData<JSONObject> updateActivityGE(ActivityPriceBO bo, HttpServletRequest request) throws ParseException;
    public ResponseData<Integer> stopActivityEG(MktActivityPOWithBLOBs po, HttpServletRequest request);
    public ResponseData<PageInfo<AnalysisPriceResultVO>> selectAnalysisEG(ActivityPriceParamVO vo, HttpServletRequest request);
    public ResponseData<PageInfo<MktActivityPrizeRecordPO>> selectPrizePeople(ActivityPriceParamVO vo);
    public ResponseData<String> doVerificationCoupon(ActivityPriceParamVO vo, HttpServletRequest request);
}
