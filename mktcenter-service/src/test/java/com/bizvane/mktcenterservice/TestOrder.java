package com.bizvane.mktcenterservice;

import com.alibaba.fastjson.JSON;
import com.bizvane.MktcenterApplication;
import com.bizvane.mktcenterfacade.interfaces.TaskOrderService;
import com.bizvane.mktcenterfacade.models.bo.TaskDetailBO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2018/7/31 14:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes={MktcenterApplication.class})
public class TestOrder {

    @Autowired
    private TaskOrderService  taskOrderService;

    @Test
    public   void  test01(){

        List<TaskDetailBO> orderTaskDetails = taskOrderService.getOrderTaskDetails(3L);
        System.out.println(JSON.toJSONString("----数据-------"+JSON.toJSONString(orderTaskDetails)));
    }
}
