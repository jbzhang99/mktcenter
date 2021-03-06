package com.bizvane.mktcenterservice.controllers;

import com.bizvane.mktcenterfacade.interfaces.ActivityRecordService;
import com.bizvane.mktcenterfacade.models.po.MktActivityRecordPO;
import com.bizvane.mktcenterfacade.models.vo.MktActivityRecordVO;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chen.li
 * @date on 2018/7/13 13:40
 * @description
 *
 */
@RestController
@RequestMapping("activityRecord")
public class ActivityRecordController {
    @Autowired
    private ActivityRecordService activityRecordService;
    /**
     * 查询活动记录
     * @param vo
     * @return
     */
    @RequestMapping("getActivityRecordPOList")
    public ResponseData<List<MktActivityRecordPO>> getActivityRecordPOList(MktActivityRecordVO vo){
        return activityRecordService.getActivityRecordPOList(vo);
    }
}
