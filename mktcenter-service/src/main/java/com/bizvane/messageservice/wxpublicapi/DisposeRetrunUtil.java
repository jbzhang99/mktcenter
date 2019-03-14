package com.bizvane.messageservice.wxpublicapi;


import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.bizvane.messagefacade.models.vo.Result;

/**
 * Created by admin on 2016/7/14.
 */
public class DisposeRetrunUtil {
    public static Result<Object> getReturnJo(String code, String message){
        Result<Object> result = new Result<>();
       // JSONObject rjo = new JSONObject();
        try {
            result.setStatus(Integer.parseInt(code));
            result.setMsg(message);
            //rjo.put("code",code);
            //rjo.put("message",message);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String getReturnJostr(String code,String message){
        return getReturnJo(code,message).toString();
    }

    public static JSONObject getReturnJo(String code,String message,Object result){
        JSONObject rjo = new JSONObject();
        try {
            rjo.put("code",code);
            rjo.put("message",message);
            rjo.put("result",result);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return rjo;
    }
}
