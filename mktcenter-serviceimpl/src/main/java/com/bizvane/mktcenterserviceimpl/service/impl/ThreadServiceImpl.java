package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.mktcenterservice.interfaces.ThreadService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author chen.li
 * @date on 2018/8/11 11:41
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@Service
public class ThreadServiceImpl implements ThreadService {

    @Async("asyncServiceExecutor")
    public void count(int i){
        System.out.println(i);
    }
}
