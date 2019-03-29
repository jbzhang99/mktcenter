package com.bizvane.mktcenterservice;

import com.bizvane.mktcenterservice.common.utils.CodeUtil;

/**
 * @author chen.li
 * @date on 2018/8/2 15:25
 * @description  编号生成工具类测试
 *
 */
public class CodeUtilTest {

    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            String activityCode = CodeUtil.getActivityCode();
            System.out.println(activityCode);
        }
    }
}
