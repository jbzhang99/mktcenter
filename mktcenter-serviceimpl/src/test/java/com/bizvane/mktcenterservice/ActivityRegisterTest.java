//package com.bizvane.mktcenterservice;
//
//import com.bizvane.mktcenterservice.interfaces.ActivityUpgradeService;
//import com.bizvane.mktcenterservice.models.bo.ActivityBO;
//import com.bizvane.mktcenterservice.models.po.MktCouponPO;
//import com.bizvane.mktcenterservice.models.vo.ActivityVO;
//import com.bizvane.mktcenterservice.models.vo.MessageVO;
//import com.bizvane.mktcenterserviceimpl.MktcenterApplication;
//import com.bizvane.utils.tokens.SysAccountPO;
//import org.junit.*;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
///**
// * @author chen.li
// * @date on 2018/7/14 14:08
// * @description
// * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes={MktcenterApplication.class})
//public class ActivityRegisterTest {
//    @Autowired
//    private ActivityUpgradeService activityUpgradeService;
////    {
////        "activityName": "测试活动-001",
////            "longTerm": "1",
////            "startTime": "Sat Jul 14 14:05:52 CST 2018",
////            "endTime": "Sat Jul 30 14:05:52 CST 2018",
////            "activityInfo": "模块内测试活动",
////            "activityType": "1",
////            "offlineCardStatus": "0",
////            "mbrLevelCode": "m002",
////            "mbrLevelName": "银卡会员"
////    }
//    @Test
//    public void add(){
//        ActivityVO activityVO = new ActivityVO();
//        activityVO.setSysCompanyId(2L);
//        activityVO.setSysBrandId(2L);
//        activityVO.setActivityType(2);
//        activityVO.setActivityName("无线会员升级");
//        activityVO.setStartTime(new Date());
//        activityVO.setEndTime(new Date());
//        activityVO.setPoints(222);
//        activityVO.setActivityStatus(3);
//        activityVO.setMbrLevelCode("AC999999");
//        activityVO.setMbrLevelName("铂金会员");
//        activityVO.setMemberType(1);
//        List<MktCouponPO> couponCodeList = null;
//       // couponCodeList.add("1");
//        List<MessageVO> messageVOList = new ArrayList<>();
//        ActivityBO s= new ActivityBO();
//        s.setActivityVO(activityVO);
//        s.setCouponCodeList(couponCodeList);
//        s.setMessageVOList(messageVOList);
//        SysAccountPO stageUser = new SysAccountPO();
//        activityUpgradeService.addActivityUpgrade(s,stageUser);
//        System.out.println("11");
//    }
//}
