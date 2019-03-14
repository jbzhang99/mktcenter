package com.bizvane.messageservice.common.utils;

/**
 * 统一异常处理
 * 
 * @author 董争光 2018年5月21日下午1:46:56
 */
public class BusinessException extends RuntimeException {

  private static final long serialVersionUID = -2607505309366204212L;
  private Integer status;
  private String msg;

  public BusinessException() {}

  public BusinessException(Integer status) {
    this.status = status;
  }

  public BusinessException(Throwable arg0) {
    super(arg0);
  }

  public BusinessException(Integer status, Throwable cause) {
    super(cause);
    this.status = status;
  }

  public BusinessException(Integer status, String msg) {
    this.status = status;
    this.msg = msg;
  }

  public BusinessException(Integer status, String msg, Throwable cause) {
    super(cause);
    this.status = status;
    this.msg = msg;
  }

  public Integer getStatus() {
    return this.status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getMsg() {
    return this.msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }


}
