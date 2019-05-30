package com.bizvane.mktcenterfacade.models.bo;

import java.util.List;

public class ObtainGraphicBo {
    Long brandId;
    //搜索关键字
    String fuzzySearch;
    String offset;
    String count;
    String type;
    //图文返回
    String obtainGraphic;
    //总行数
    String counts;

    List<String> openId;
    //图文 id(最少两个，最多10000个)
    String mediaId;
    //数据类型
    String msgType;
    //图文消息被判定为转载时，是否继续群发。 1为继续群发（转载），0为停止群发。 该参数默认为0。
    String sendIgnoreReprint;

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getFuzzySearch() {
        return fuzzySearch;
    }

    public void setFuzzySearch(String fuzzySearch) {
        this.fuzzySearch = fuzzySearch;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getObtainGraphic() {
        return obtainGraphic;
    }

    public void setObtainGraphic(String obtainGraphic) {
        this.obtainGraphic = obtainGraphic;
    }

    public String getCounts() {
        return counts;
    }

    public void setCounts(String counts) {
        this.counts = counts;
    }

    public List<String> getOpenId() {
        return openId;
    }

    public void setOpenId(List<String> openId) {
        this.openId = openId;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getSendIgnoreReprint() {
        return sendIgnoreReprint;
    }

    public void setSendIgnoreReprint(String sendIgnoreReprint) {
        this.sendIgnoreReprint = sendIgnoreReprint;
    }
}
