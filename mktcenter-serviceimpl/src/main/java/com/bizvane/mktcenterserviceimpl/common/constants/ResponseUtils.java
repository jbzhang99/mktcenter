package com.bizvane.mktcenterserviceimpl.common.constants;

import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.ResponseData;


/**
 * @Author: lijunwei
 * @Time: 2018/7/28 13:35
 */
public class ResponseUtils<T> {

    private  ResponseData<T> result=null;

    public   ResponseData<T>  getResponseData(SysResponseEnum enue, T data){
        result=new ResponseData<T>(enue.getCode(),enue.getMessage(), data);
        return result;
    }
    public   ResponseData<T>  getResponseData(int code,String msg, T data){
        result=new ResponseData<T>(code,msg,data);
        return result;
    }
}
