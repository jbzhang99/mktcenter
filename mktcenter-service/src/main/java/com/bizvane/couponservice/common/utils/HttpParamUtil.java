package com.bizvane.couponservice.common.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: houkai
 * @Date: 2018/9/20 10:54
 * @Description:获取请求参数工具类
 */
public class HttpParamUtil {
    /**
     * 获取前端ajax参数
     *
     * @param request
     * @return
     */
    public static String getJSONParam(HttpServletRequest request) {
        String jsonParam = null;
        //JSONObject jsonParam = null;
        BufferedReader streamReader = null;
        try {
            // 获取输入流
            streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));

            // 写入数据到Stringbuilder
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = streamReader.readLine()) != null) {
                sb.append(line);
            }
            //jsonParam = JSONObject.parseObject(sb.toString());
            jsonParam = sb.toString();
            streamReader.close();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if(streamReader != null){
                    streamReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return jsonParam;
    }
}
