package com.bizvane.mktcenterserviceimpl.service.jobhandler;

import com.bizvane.mktcenterservice.interfaces.ActivitySmartService;
import com.bizvane.mktcenterservice.models.bo.ActivitySmartBO;
import com.bizvane.mktcenterserviceimpl.common.constants.ResponseConstants;
import com.bizvane.utils.responseinfo.ResponseData;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chen.li
 * @date on 2018/8/3 14:05
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@JobHandler(value="activity")
@Component
public class ActivitySmartJobHandler extends IJobHandler {

    @Autowired
    private ActivitySmartService activitySmartService;

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        ReturnT returnT = new ReturnT();
        String[] split = param.split("&");
        if(split.length>1){
            Integer mktSmartType = Integer.valueOf(split[0]);
            String activitiCode = split[1];
            ResponseData<T> execute = activitySmartService.execute(new ActivitySmartBO());
            returnT.setCode(ResponseConstants.SUCCESS);
            returnT.setContent(ResponseConstants.SUCCESS_MSG);
            returnT.setMsg(ResponseConstants.SUCCESS_MSG);
        }else{
            returnT.setCode(ResponseConstants.ERROR);
            returnT.setContent(ResponseConstants.ERROR_MSG);
            returnT.setMsg(ResponseConstants.ERROR_MSG);
        }
        return null;
    }
}
