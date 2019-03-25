package com.bizvane.mktcenterserviceimpl.common.award;

import com.bizvane.mktcenterfacade.models.bo.AwardBO;
import com.bizvane.MktcenterApplication;
import com.bizvane.mktcenterservice.common.award.AwardFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author chen.li
 * @date on 2018/8/24 20:57
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes={MktcenterApplication.class})
public class AwardFactoryTest {

    @Autowired
    private AwardFactory awardFactory;

    @Test
    public void awardCouponSimple() {
        for (int i = 0; i <500 ; i++) {
            awardFactory.awardCouponSimple(new AwardBO());
            System.out.println("============="+i);
        }
    }
}