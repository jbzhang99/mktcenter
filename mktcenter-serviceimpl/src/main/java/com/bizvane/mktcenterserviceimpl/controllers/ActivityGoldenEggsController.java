package com.bizvane.mktcenterserviceimpl.controllers;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.mktcenterservice.interfaces.ActivityGoldenEggsService;
import com.bizvane.mktcenterservice.models.po.MktActivityPOWithBLOBs;
import com.bizvane.mktcenterservice.models.po.MktActivityPrizeRecordPO;
import com.bizvane.mktcenterservice.models.vo.*;
import com.bizvane.utils.responseinfo.ResponseData;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * @Author: lijunwei
 * @Time: 2019/2/25 11:12
 */
@RestController
@RequestMapping("activityeg")
public class ActivityGoldenEggsController {
    @Autowired
   private ActivityGoldenEggsService activityGoldenEggsService;

    @RequestMapping("addActivityGE")
    public ResponseData<JSONObject> addActivityGE(ActivityPriceBO bo, HttpServletRequest request) throws ParseException{
        return activityGoldenEggsService.addActivityGE(bo,request);
    }
    @RequestMapping("selectActivityGEById")
    public ResponseData<ActivityPriceBO> selectActivityGEById(ProbabilityVO vo){
        return activityGoldenEggsService.selectActivityGEById(vo);
    }
    @RequestMapping("selectActivityGEByCode")
    public ResponseData<ActivityPrizeBO> selectActivityGEByCode(String activePriceCode){
        return activityGoldenEggsService.selectActivityGEByCode(activePriceCode);
    }
    @RequestMapping("selectActivityEGLists")
    public ResponseData<PageInfo<MktActivityPOWithBLOBs>> selectActivityEGLists(ActivityPriceParamVO vo, HttpServletRequest request){
        return activityGoldenEggsService.selectActivityEGLists(vo,request);
    }
    @RequestMapping("updateActivityGE")
    public ResponseData<JSONObject> updateActivityGE(ActivityPriceBO bo, HttpServletRequest request) throws ParseException{
        return activityGoldenEggsService.updateActivityGE(bo,request);
    }
    @RequestMapping("stopActivityEG")
    public ResponseData<Integer> stopActivityEG(MktActivityPOWithBLOBs po, HttpServletRequest request){
        return activityGoldenEggsService.stopActivityEG(po,request);
    }
    @RequestMapping("selectAnalysisEG")
    public ResponseData<PageInfo<AnalysisPriceResultVO>> selectAnalysisEG(ActivityPriceParamVO vo, HttpServletRequest request){
        return activityGoldenEggsService.selectAnalysisEG(vo,request);
    }
    @RequestMapping("selectPrizePeople")
    public ResponseData<PageInfo<MktActivityPrizeRecordPO>> selectPrizePeople(ActivityPriceParamVO vo){
        return activityGoldenEggsService.selectPrizePeople(vo);
    }
    @RequestMapping("doVerificationCoupon")
    public ResponseData<String> doVerificationCoupon(ActivityPriceParamVO vo, HttpServletRequest request){
        return activityGoldenEggsService.doVerificationCoupon(vo,request);
    }
    @RequestMapping("getMktActivityPOWithBLOBs")
    public MktActivityPOWithBLOBs getMktActivityPOWithBLOBs(ProbabilityVO vo){
        return activityGoldenEggsService.getMktActivityPOWithBLOBs(vo);
    }
}
