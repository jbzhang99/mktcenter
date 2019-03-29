package com.bizvane.mktcenterservice;

import com.bizvane.MktcenterApplication;
import com.bizvane.mktcenterfacade.interfaces.ThreadService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author chen.li
 * @date on 2018/8/11 11:40
 * @description
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes={MktcenterApplication.class})
@Slf4j
public class ThreadTest {

    @Autowired
    private ThreadService threadService;

    @Test
    public void test(){

        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currdate = format.format(d);
        System.out.println("现在的日期是：" + currdate);

        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, 10);// num为增加的天数，可以改变的
        d = ca.getTime();
        String enddate = format.format(d);
        System.out.println("增加天数以后的日期：" + enddate);
    }
}
