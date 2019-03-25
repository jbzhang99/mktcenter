package com.bizvane.messagefacade.models.vo;


import java.io.Serializable;

public class Result<T> implements Serializable {

    private static final long serialVersionUID = 2797695294117691139L;
    private long status;//返回状态
    private String msg;//返回提示信息
    private T data;//返回数据

    public Result(){
      
    }
    
    public Result(SysRespConstants sysRespConstants){
      this.status = sysRespConstants.getStatus();
      this.msg = sysRespConstants.getMsg();
    }
    
    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
