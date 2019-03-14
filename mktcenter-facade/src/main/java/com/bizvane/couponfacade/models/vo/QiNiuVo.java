package com.bizvane.couponfacade.models.vo;

/**
 * Created by Gavin on 2018/7/26.
 */
public class QiNiuVo {
    private String url;
    private boolean error;

    public QiNiuVo(boolean error) {
        super();
        this.error = error;
    }

    public QiNiuVo(boolean error, String url) {
        super();
        this.url = url;
        this.error = error;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public boolean isError() {
        return error;
    }
    public void setError(boolean error) {
        this.error = error;
    }
}

