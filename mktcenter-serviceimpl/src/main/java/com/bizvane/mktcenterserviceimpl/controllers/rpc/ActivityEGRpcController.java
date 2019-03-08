package com.bizvane.mktcenterserviceimpl.controllers.rpc;

import com.bizvane.mktcenterservice.interfaces.ActivityGoldenEggsService;
import com.bizvane.mktcenterservice.models.po.MktActivityPOWithBLOBs;
import com.bizvane.mktcenterservice.models.po.MktActivityPrizeRecordPO;
import com.bizvane.mktcenterservice.models.vo.ProbabilityVO;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2019/2/26 11:18
 */
@RestController
@RequestMapping("activityEGRpc")
public class ActivityEGRpcController {
   @Autowired
   private  ActivityGoldenEggsService activityGoldenEggsService;

    @RequestMapping("getMktActivityPOWithBLOBs")
    public ResponseData<MktActivityPOWithBLOBs> getMktActivityPOWithBLOBs(@RequestBody ProbabilityVO vo){
        ResponseData<MktActivityPOWithBLOBs> responseData = new ResponseData<>();
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = activityGoldenEggsService.getMktActivityPOWithBLOBs(vo);
        responseData.setData(mktActivityPOWithBLOBs);
        return responseData;
    }

    @RequestMapping("doEggFrenzy")
    public ResponseData<String> doEggFrenzy(@RequestBody ProbabilityVO vo) throws ParseException{
        return activityGoldenEggsService.doEggFrenzy(vo);
    }
    @RequestMapping("getEGPrizeRecordList")
    public ResponseData<List<MktActivityPrizeRecordPO>> getEGPrizeRecordList(@RequestBody MktActivityPrizeRecordPO po){
        return activityGoldenEggsService.getEGPrizeRecordList(po);
    }

    @RequestMapping("residueMemberNumber")
    public ResponseData<Integer>  residueMemberNumber(@RequestBody ProbabilityVO vo) throws ParseException{
        return activityGoldenEggsService.residueMemberNumber(vo);
    }

    @RequestMapping("addMemberNumber")
    public ResponseData<Integer> addMemberNumber(@RequestBody ProbabilityVO vo) throws ParseException{
        return activityGoldenEggsService.addMemberNumber(vo);
    }
    @RequestMapping("getActivityId")
    public ResponseData<MktActivityPOWithBLOBs>  getActivityId(@RequestBody ProbabilityVO vo){
        return activityGoldenEggsService.getActivityId(vo);
    }
}
