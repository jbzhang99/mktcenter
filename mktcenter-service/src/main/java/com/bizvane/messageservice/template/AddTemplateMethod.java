package com.bizvane.messageservice.template;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bizvane.messageservice.common.constants.SysRespConstants;
import com.bizvane.messageservice.common.constants.WxApiUrlConstants;
import com.bizvane.messageservice.common.redis.RedisManager;
import com.bizvane.messageservice.common.utils.AsyncHttpUtil;
import com.bizvane.messageservice.service.WxMessagetempService;
import com.bizvane.messagefacade.models.po.MsgWxTempPO;
import com.bizvane.messagefacade.models.po.MsgWxTempPOExample;
import com.bizvane.messagefacade.models.vo.Result;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.redisutils.RedisClient;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.wechatfacade.interfaces.WxPublicServiceFeign;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 获取模块消息ID
 * Created by server on 2016/8/15.
 */
public class AddTemplateMethod{

    @Autowired
    private WxMessagetempService wxMessagetempService;
    @Autowired
    private WxPublicServiceFeign wxPublicServiceFeign;

    private static Logger log = LoggerFactory.getLogger(AddTemplateMethod.class);
    private static String wx_add_template_url = WxApiUrlConstants.wx_add_template_url;

    private Map<String, String> wx_template_list = null;

    /**
     *
     * @return
     */
    public ResponseData<Object> execute(JSONObject jo) {
        log.info("------------->进来了AddtemplateMethod类");
        ResponseData<Object> responseData = new ResponseData<>();

        Result<Object> result = new Result<>();


        long user_id = jo.getLong("user_id");
        long public_id = jo.getLong("public_id");

        //region 删除所有缓存
        RedisClient redisClient = RedisManager.getInstince();
        redisClient.remove("wx-templage-" + public_id + "-*");

        List<MsgWxTempPO> wxMessageTempPOList = null;
        List<String> list = new ArrayList<>();

        boolean is_wx_has = false;
        String temp_id_str = jo.getString("id_str");
        JSONArray temp_list = jo.getJSONArray("selectids");
        if (StringUtils.isBlank(temp_id_str) && temp_list != null && temp_list.size() > 0) {
            int count = temp_list.size();
            StringBuffer temp_id_sb = new StringBuffer();
            for (int i = 0; i < count; i++) {
                if (i > 0) {
                    temp_id_sb.append(",");
                }
                temp_id_sb.append(temp_list.getString(i));
            }
            temp_id_str = temp_id_sb.toString();
        }

        if (StringUtils.isBlank(temp_id_str)) {
            wxMessageTempPOList = wxMessagetempService.findByPublicIdAndValid(public_id,true);
        } else {
            wxMessageTempPOList = wxMessagetempService.findByIdStr(temp_id_str);
        }

        if (wxMessageTempPOList == null || wxMessageTempPOList.size() < 1) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage("模板数据不存在");
            return responseData;
        }


        MsgWxTempPO wxMessageTempPO;
        for (int i = 0; i < wxMessageTempPOList.size(); i++) {
            wxMessageTempPO = wxMessageTempPOList.get(i);


            log.info("==============jodata=" + wxMessageTempPO);


            boolean is_active_str = wxMessageTempPO.getValid();
            if (!is_active_str) {
                log.error("template not acitve");
                continue;
            }
            String short_code = wxMessageTempPO.getShortCode();//模板编号TM
            String template_wx_id = wxMessageTempPO.getWxTemplateId();


            if (StringUtils.isNotBlank(template_wx_id)) {
                is_wx_has = is_has_template(public_id, template_wx_id);
                log.info("wx has template id:" + template_wx_id + " has:" + is_wx_has);
                if (is_wx_has) {
                    continue;
                }
            }


            try {
                result = gettoken(short_code, public_id, user_id);
                String code = result.getStatus()+"";
                if (!"0".equals(code)) {
                    list.add(code + "," + result.getMsg());
                }
            } catch (Exception e) {
                log.error("AddTemplateMethod error:" + e.getMessage());
            }
        }

        if (list == null || list.size() < 1) {
            responseData.setCode(SysResponseEnum.SUCCESS.getCode());
            responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        } else {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage("存在失败情况，失败数量：" + list.size() + ",失败原因：" + list.get(0));
        }
        return responseData;
    }

    /**
     *
     * @param short_code
     * @param public_id
     * @param user_id
     * @return
     * @throws Exception
     */
    public Result<Object> gettoken(String short_code, long public_id, long user_id) throws Exception {
        Result<Object> result = new Result<>();
        //获取access_token
        ResponseData<String> tokenData = wxPublicServiceFeign.getAccessTokenByPublicId(public_id);
        String token = tokenData.getData();

        log.info("------------->AddtemplateMethod,token:"+token);
        if (token == null) {
            result.setStatus(SysRespConstants.FAILED.getStatus());
            result.setMsg("请重新授权");
            return result;
        }
        JSONObject temjson = new JSONObject();
        temjson.put("template_id_short", short_code);
        JSONObject jsonObject;
        jsonObject = JSONObject.parseObject(AsyncHttpUtil.doPost(wx_add_template_url + token, temjson.toString()));
        log.info("------------->AddtemplateMethod,jsonObject:"+jsonObject);
        if (jsonObject == null) {
            result.setStatus(SysRespConstants.FAILED.getStatus());
            result.setMsg("微信调用错误");
            return result;
        }

        MsgWxTempPO wxMessageTempPO = new MsgWxTempPO();
        MsgWxTempPOExample example = new MsgWxTempPOExample();
        if (!"0".equals(jsonObject.getString("errcode"))) {
            wxMessageTempPO.setModifiedUserId(user_id);
            example.createCriteria().andWxPublicIdEqualTo(public_id).andShortCodeEqualTo(short_code);
            wxMessagetempService.updateWxMessageTemp(wxMessageTempPO,example);
            //return DisposeRetrunUtil.getReturnJo(jsonObject.getString("errcode"), jsonObject.getString("errmsg"));
            return null;
        }

        result.setData(jsonObject);

        String wx_temolate_id = jsonObject.getString("template_id");

        wxMessageTempPO.setWxTemplateId(wx_temolate_id);
        wxMessageTempPO.setModifiedUserId(user_id);
        example.createCriteria().andWxPublicIdEqualTo(public_id).andShortCodeEqualTo(short_code);
        wxMessagetempService.updateWxMessageTemp(wxMessageTempPO,example);

        result.setStatus(SysRespConstants.SUCCESS.getStatus());
        result.setMsg(SysRespConstants.SUCCESS.getMsg());
        return result;
    }

    /**
     *
     * @param template_wx_id
     * @param public_id
     */
    public void delete_template(String template_wx_id, long public_id) {

        ResponseData<String> tokenData = wxPublicServiceFeign.getAccessTokenByPublicId(public_id);
        String token = tokenData.getData();
        JSONObject jsonObject = null;
        JSONObject temjson = new JSONObject();
        try {
            temjson.put("template_id", template_wx_id);
            jsonObject = JSONObject.parseObject(AsyncHttpUtil.doPost(String.format(WxApiUrlConstants.wx_delete_template_url, token), temjson.toString()));
        } catch (Exception e) {
            log.error("delete wx template error:" + e.getLocalizedMessage(), e);
        }

    }

    /**
     *
     * @param public_id
     * @param template_id
     * @return
     */
    private boolean is_has_template(long public_id, String template_id) {
        boolean is_has = false;

        if (wx_template_list == null) {
            JSONArray wx_template = null;
            try {
                wx_template = get_wx_template_list(public_id);
            } catch (Exception e) {
                log.error(" error:" + e.getLocalizedMessage(), e);
                return is_has;
            }

            if (wx_template == null || wx_template.size() <= 0) {
                log.error("not find wx tempalte");
                return is_has;
            }

            String wx_template_id = null;
            wx_template_list = new HashMap<>();
            JSONObject temp_message = null;
            int count = wx_template.size();
            for (int i = 0; i < count; i++) {
                temp_message = wx_template.getJSONObject(i);
                if (temp_message == null || temp_message.size() <= 0) {
                    log.error("index:" + i + " data is null");
                    continue;
                }

                wx_template_id = temp_message.getString("template_id");
                if (StringUtils.isBlank(wx_template_id)) {
                    log.error("index:" + i + " template_id is null");
                    continue;
                }
                log.info("wx_id:" + wx_template_id);
                wx_template_list.put(wx_template_id, wx_template_id);
            }
        }


        return wx_template_list.containsKey(template_id);
    }

    /**
     *
     * @param public_id
     * @return
     * @throws
     */
    private JSONArray get_wx_template_list(long public_id)/* throws ApiException */{
        JSONArray template_list = new JSONArray();

        ResponseData<String> tokenData = wxPublicServiceFeign.getAccessTokenByPublicId(public_id);
        String token = tokenData.getData();

        String url = WxApiUrlConstants.wx_get_all_template_url;
        JSONObject temp_info = new JSONObject();
        try {
            temp_info = JSONObject.parseObject(AsyncHttpUtil.doGet(url + token, ""));
        } catch (Exception e) {
            log.error("get wx template list error:" + e.getLocalizedMessage(), e);
        }

        template_list = temp_info.getJSONArray("template_list");
        return template_list;
    }
}
