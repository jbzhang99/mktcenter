package com.bizvane.messageservice.template;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bizvane.messageservice.service.WxMessagetempService;
import com.bizvane.messagefacade.models.po.MsgWxTempPO;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 初始化消息模板列表
 * Created by server on 2016/8/30.
 * {
 * "first": {
 * "value": "{{first}}",
 * "color": "#173177"
 * },
 * "keyword1": {
 * "value": "{{keyword1}}",
 * "color": "#173177"
 * },
 * "keyword2": {
 * "value": "{{keyword2}}",
 * "color": "#173177"
 * },
 * "keyword3": {
 * "value": "{{keyword3}}",
 * "color": "#173177"
 * },
 * "keyword4": {
 * "value": "{{keyword4}}",
 * "color": "#173177"
 * },
 * "remark": {
 * "value": "{{remark}}",
 * "color": "#173177"
 * }
 * }
 */
public class InitializeTemplateMethod{

    @Autowired
    private WxMessagetempService wxMessagetempService;

    private static final String regex = "(?<=\\{\\{)\\w+(?=\\.DATA\\}\\})";
    private static Logger log = LoggerFactory.getLogger(InitializeTemplateMethod.class);

    public ResponseData<Object> execute(JSONObject jo) {
        log.info("------------->进来了InitializeTemplateMethod类");
        ResponseData<Object> responseData = new ResponseData<>();

        Long user_id;
        Long ad_client_id;
        long public_id;
        JSONObject data = new JSONObject();

        try {

            log.info("==========jo=" + jo.toString());

            if (jo == null || !jo.containsKey("ad_client_id") || !jo.containsKey("public_id") || !jo.containsKey("user_id")) {
                responseData.setCode(SysResponseEnum.FAILED.getCode());
                responseData.setMessage("no find ad_client_id or public_id or user_id");
                return responseData;
            }

            user_id = jo.getLong("user_id");
            ad_client_id = jo.getLong("ad_client_id");
            public_id = jo.getInteger("public_id");

            List<MsgWxTempPO> poList = null;

            JSONArray temp_list = jo.getJSONArray("selectids");
            //TODO-待补充
            if (temp_list == null || temp_list.size() <= 0) {
                poList = wxMessagetempService.findBypublicDiff(public_id);
            } else {
                int count = temp_list.size();
                StringBuffer temp_id_sb = new StringBuffer();
                for (int i = 0; i < count; i++) {
                    if (i > 0) {
                        temp_id_sb.append(",");
                    }
                    temp_id_sb.append(temp_list.getString(i));
                }

                try {
                    data.put("id_str", temp_id_sb.toString());
                } catch (Exception e) {
                    log.error(" error:" + e.getLocalizedMessage(), e);
                }
                try {
                    poList = wxMessagetempService.findByIdStr(temp_id_sb.toString());
                } catch (Exception e) {
                    log.error("get part template error:" + e.getLocalizedMessage(), e);
                }
            }
            if (poList == null) {
                poList = new ArrayList<>();
            }

            /**
             * {{first.DATA}}
             金额：{{keyword1.DATA}}
             使用期限：{{keyword2.DATA}}
             {{remark.DATA}}
             * */
            Pattern pattern;
            Matcher mtag;
            MsgWxTempPO poData;
            int count = poList.size();
            for (int i = 0; i < count; i++) {

                poData = poList.get(i);

                log.info("==============jodata=" + poData);
                String short_code = poData.getShortCode();//模板编号TM
                String title = poData.getTitle();//模板标题
                String url = poData.getUrl(); /*StringUtil.valueOf(*//*poData.getString("url")*//*, null)*///url
                String primary_industry = poData.getPrimaryIndustry();//模板所属行业的一级行业
                String deputy_industry = poData.getDeputyIndestry();//模板所属行业的二级行业
                String content = poData.getContent();//模板内容
                String example = poData.getExample();//模板示例
                String message = poData.getMessage();/*StringUtil.valueOf(*//*jodata.getString("message")*//*, null)*///用户报存值
                String first = poData.getFirst();
                String type = poData.getTemplateType();
                String class_path = poData.getClassPath();

                Boolean valid = poData.getValid();//是否需要授权信息

                if (StringUtils.isBlank(message)) {
                    log.info("-------->message:" + message);
                    pattern = Pattern.compile(regex);
                    mtag = pattern.matcher(content);
                    JSONObject messagejo = new JSONObject();
                    while (mtag.find()) {
                        messagejo.put(mtag.group(),JSONObject.parse("{\"value\":\"{{" + mtag.group() + "}}\",\"color\":\"#173177\"}"));
                    }
                    message = messagejo.toString();
                }
                long itemCount = wxMessagetempService.findCountByShortCodeAndPublicId(short_code,public_id);
                if (itemCount > 0) {
                    Long id = wxMessagetempService.findIdByShortCodeAndPublicId(short_code,public_id);

                    log.info("id:" + id);

                    MsgWxTempPO po = new MsgWxTempPO();
                    po.setModifiedDate(new Date());
                    po.setMessage(message);
                    po.setShortCode(short_code);
                    po.setPrimaryIndustry(primary_industry);
                    po.setDeputyIndestry(deputy_industry);
                    po.setTitle(title);
                    po.setContent(content);
                    po.setExample(example);
                    po.setUrl(url);
                    po.setValid(valid);
                    po.setFirst(first);
                    po.setTemplateType(type);
                    po.setClassPath(class_path);
                    po.setWxMessageTempId(id);
                    wxMessagetempService.updateWxMessageTempById(po);
                } else {
                	MsgWxTempPO po = new MsgWxTempPO();
                    po.setCreateUserId(user_id);
                    po.setModifiedUserId(user_id);
                    po.setShortCode(short_code);
                    po.setPrimaryIndustry(primary_industry);
                    po.setDeputyIndestry(deputy_industry);
                    po.setTitle(title);
                    po.setContent(content);
                    po.setExample(example);
                    po.setWxPublicId(public_id);
                    po.setUrl(url);
                    po.setMessage(message);
                    po.setValid(valid);
                    po.setFirst(first);
                    po.setTemplateType(type);
                    po.setClassPath(class_path);
                    wxMessagetempService.saveMessageTemp(po);
                }
            }
        } catch (Exception e) {
            log.info("InitializeTemplateMethod error:" + e.getMessage(), e);
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage("初始化微信模板失败");
            return responseData;
        }
        //调用获取模板ID方法
        try {
            AddTemplateMethod at = new AddTemplateMethod();
            return at.execute(jo);
        } catch (Exception e) {
            log.error("send order AddTemplate error:" + e.getLocalizedMessage());
        }

        return responseData;
    }
}
