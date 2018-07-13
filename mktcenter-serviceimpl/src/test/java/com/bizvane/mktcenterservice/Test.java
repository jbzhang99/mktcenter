package com.bizvane.mktcenterservice;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Optional;

/**
 * @author chen.li
 * @date on 2018/7/4 18:34
 * @description
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public class Test {

    public static void main(String[] args) {
        // \u000d System.out.println("hello world");
        List<Integer> nums = Lists.newArrayList(1,null,3,4,null,6,6);
        long count = nums.stream().filter(num -> num != null).count();

        System.out.println("--获取具体的数据="+count);

        Optional<Integer> first = nums.stream().filter(num -> Integer.valueOf(6).equals(num)).findFirst();
        System.out.println(first);
    }
}
