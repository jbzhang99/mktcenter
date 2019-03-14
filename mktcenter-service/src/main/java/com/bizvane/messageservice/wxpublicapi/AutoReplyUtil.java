package com.bizvane.messageservice.wxpublicapi;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bizvane.wechatfacade.models.po.WxPublicPO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自动回复
 */
public class AutoReplyUtil {

   // private static final String GET_SUBSCRIBE_MESSAGE = "select reply_type,wx_material_id,content from wx_subscribemessage where isactive='Y' and wx_public_id=?";
    //private static final String GET_MEDIA_ID = "select media_id from wx_material where id=?";
    //private static final String GET_NEWS_REPLY_SQL = "select content from wx_material where id=?";

    private static Logger logger = LoggerFactory.getLogger(AutoReplyUtil.class);

    private static final String REPLY_TYPE_TEXT = "1";
    private static final String REPLY_TYPE_IMAGE = "2";
    private static final String REPLY_TYPE_NEWS = "3";

    private static final SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmm");

    /**
     * 关注自动回复
     *
     * @param wu
     * @param jo
     * @return xml
     */
    public static String getSubscribeReply(WxPublicPO wu, JSONObject jo) {
        logger.info("------------->关注回复：" + jo.toString());
        String result = null;

        String touser = jo.getString("ToUserName");
        String fromuser = jo.getString("FromUserName");

        //JSONObject subscribeReply_jo = QueryEngine.doQueryJSONObject(GET_SUBSCRIBE_MESSAGE, new Object[]{wu.getId()});
        //TODO-待补充
        JSONObject subscribeReply_jo = new JSONObject();
        if (subscribeReply_jo != null) {
            result = getReply(fromuser, touser, subscribeReply_jo);
        }
        return result;
    }


    /**
     * @param fromuser
     * @param touser
     * @param replyjo  reply_type,wx_media_id,content
     * @return
     */
    private static String getReply(String fromuser, String touser, JSONObject replyjo) {
        String reply_type = replyjo.getString("reply_type");

        logger.info("------------>reply_type:" + reply_type);

        StringBuilder sbd = new StringBuilder();

        sbd.append("<xml><ToUserName><![CDATA[").append(fromuser).append("]]></ToUserName><FromUserName><![CDATA[")
                .append(touser).append("]]></FromUserName><CreateTime>").append(sdf.format(new Date())).append("</CreateTime>");


        if (REPLY_TYPE_TEXT.equals(reply_type)) {
            //文本消息回复

            //未实现文本中包含插入链接

            String content = replyjo.getString("content");
            if (StringUtils.isBlank(content)) {
                return "";
            }

            content = textToChange(content);
            sbd.append("<MsgType><![CDATA[text]]></MsgType><Content><![CDATA[")
                    .append(content).append("]]></Content></xml>");

        } else {


            if (REPLY_TYPE_IMAGE.equals(reply_type)) {
                //String media_id = QueryEngine.doQueryObject(GET_MEDIA_ID, new Object[]{replyjo.optLong("wx_material_id")}, String.class);
                String media_id = "";
                //TODO-待补充
                sbd.append("<MsgType><![CDATA[image]]></MsgType><Image><MediaId><![CDATA[").append(media_id)
                        .append("]]></MediaId></Image></xml>");
            } else if (REPLY_TYPE_NEWS.equals(reply_type)) {

                try {
                    //JSONArray newsja = new JSONArray(QueryEngine.doQueryObject(GET_NEWS_REPLY_SQL, new Object[]{replyjo.optLong("wx_material_id")}, String.class));
                    JSONArray newsja = new JSONArray();//TODO-待解决
                    int articleCount = newsja.size();
                    sbd.append("<MsgType><![CDATA[news]]></MsgType>"
                            + "<ArticleCount>").append(articleCount).append("</ArticleCount>"
                            + "<Articles>");

                    JSONObject ajo;
                    for (int j = 0; j < articleCount; j++) {
                        ajo = newsja.getJSONObject(j);
                        sbd.append("<item><Title><![CDATA[").append(ajo.getString("title"));
                        sbd.append("]]></Title><Description><![CDATA[").append(ajo.getString("digest"));
                        sbd.append("]]></Description><PicUrl><![CDATA[").append(ajo.getString("thumb_url"));
                        sbd.append("]]></PicUrl><Url><![CDATA[").append(ajo.getString("url"));
                        sbd.append("]]></Url></item>");
                    }
                    sbd.append("</Articles></xml>");
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error("fromuser news reply error:" + e.getMessage());
                    return null;
                }
            } else {
                sbd = new StringBuilder("success");
            }
        }
        logger.info("------------>sbd:" + sbd.toString());
        return sbd.toString();
    }


    //文本中有标签的处理
    private static String textToChange(String context) {
        context = context.replace("&nbsp;", " ");
        context = context.replace("&amp;", "&");
        context = context.replaceAll("<br[^>]+>", "\n");
        context = context.replaceAll("<br+>", "\n");
        return context;
    }

}
