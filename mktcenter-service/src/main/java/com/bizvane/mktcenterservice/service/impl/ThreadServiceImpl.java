package com.bizvane.mktcenterservice.service.impl;

import com.bizvane.mktcenterfacade.interfaces.ThreadService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author chen.li
 * @date on 2018/8/11 11:41
 * @description
 *
 */
@Service
public class ThreadServiceImpl implements ThreadService {

    @Async("asyncServiceExecutor")
    public void count(int i){
        System.out.println(i);
    }
}
