package com.bizvane.mktcenterservice;

import com.bizvane.mktcenterservice.interfaces.ThreadService;
import com.bizvane.mktcenterserviceimpl.MktcenterApplication;
import com.bizvane.mktcenterserviceimpl.common.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author chen.li
 * @date on 2018/8/11 11:40
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes={MktcenterApplication.class})
@Slf4j
public class ThreadTest {

    @Autowired
    private ThreadService threadService;

    @Test
    public void test(){

        log.info("开始"+DateUtil.formatDateByPattern(new Date(),"yyyy-MM-dd HH:mm:ss"));
        for(int i=0;i<=100;i++){
//            threadService.count(i);
            System.out.println(i);
        }
        log.info("结束"+DateUtil.formatDateByPattern(new Date(),"yyyy-MM-dd HH:mm:ss"));
    }
}
