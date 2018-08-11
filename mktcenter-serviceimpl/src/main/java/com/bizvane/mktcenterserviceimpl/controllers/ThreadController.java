package com.bizvane.mktcenterserviceimpl.controllers;

import com.bizvane.mktcenterservice.interfaces.ThreadService;
import com.bizvane.mktcenterservice.models.bo.ActivityAnalysisCountBO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterserviceimpl.common.utils.DateUtil;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author chen.li
 * @date on 2018/8/11 14:25
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@RestController("threadController")
public class ThreadController {

    @Autowired
    private ThreadService threadService;

    /**
     * 查询效果分析统计
     * @param bo
     * @param pageForm
     * @return
     */
    @RequestMapping("test")
    public ResponseData<ActivityAnalysisCountBO> test(ActivityAnalysisCountBO bo, PageForm pageForm){
        Date date1 = new Date();
        for (int i = 0; i < 100000; i++) {
            threadService.count(i);
        }
        Date date2 = new Date();

        System.out.println(DateUtil.getIntervalBetweenTwoDate(date1,date2));
        return new ResponseData<>();
    }
}
