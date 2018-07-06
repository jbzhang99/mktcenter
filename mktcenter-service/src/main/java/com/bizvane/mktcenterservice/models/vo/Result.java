package com.bizvane.mktcenterservice.models.vo;

import java.io.Serializable;

public class  Result<T> implements Serializable {

    private static final long serialVersionUID = 2797695294117691139L;

    /**
     * 返回状态
     */
    private int status;

    /**
     * 返回提示信息
     */
    private String message;
    /**
     * 返回数据
     */
    private T data;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
