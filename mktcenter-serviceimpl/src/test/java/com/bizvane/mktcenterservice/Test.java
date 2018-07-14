package com.bizvane.mktcenterservice;

import com.bizvane.mktcenterservice.models.po.MktActivityPOWithBLOBs;
import com.bizvane.mktcenterservice.models.po.MktMessagePO;
import com.bizvane.mktcenterservice.models.vo.MessageVO;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author chen.li
 * @date on 2018/7/4 18:34
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public class Test {

    public void test1(){
        // \u000d System.out.println("hello world");
        List<Integer> nums = Lists.newArrayList(1,null,3,4,null,6,6);
        long count = nums.stream().filter(num -> num != null).count();

        System.out.println("--获取具体的数据="+count);

        Optional<Integer> first = nums.stream().filter(num -> Integer.valueOf(6).equals(num)).findFirst();
        System.out.println(first);
    }

    public void test2(){
        MktActivityPOWithBLOBs mktActivityPOWithBLOBs = new MktActivityPOWithBLOBs();
        mktActivityPOWithBLOBs.setCreateUserId(100L);
        mktActivityPOWithBLOBs.setCreateUserName("lichen");
        mktActivityPOWithBLOBs.setCreateDate(new Date());

        MktMessagePO mktMessagePO = new MktMessagePO();

        BeanUtils.copyProperties(mktActivityPOWithBLOBs,mktMessagePO);

        MessageVO messageVO = new MessageVO();
        messageVO.setMsgCode("M20000");
        messageVO.setMsgContent("您好，欢迎注册moco");

        BeanUtils.copyProperties(messageVO,mktMessagePO);

        System.out.println(mktMessagePO.toString());
    }

    public static void main(String[] args) throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      Date date1 = new Date();
      Date date2 = format.parse("2018-07-15 13:15:11");

      System.out.println(date2.before(date1));
    }
}
