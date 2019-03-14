package com.bizvane.mktcenterfacade.models.vo;

import com.bizvane.mktcenterfacade.models.po.MktMessagePO;

import java.util.Date;

/**
 * @author chen.li
 * @date on 2018/7/14 11:54
 * @description 消息对象
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
public class MessageVO extends MktMessagePO {

    /**
     * 消息编号
     */
    private String msgCode;
    /**
     * 消息类型
     */
    private String msgType;
    /**
     * 模板消息id
     */
    private String template_msg_id;
    /**
     * 消息内容
     */
    private String msgContent;

    /**
     * 发送时间
     */
    private Date sendTime;

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getTemplate_msg_id() {
        return template_msg_id;
    }

    public void setTemplate_msg_id(String template_msg_id) {
        this.template_msg_id = template_msg_id;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}
