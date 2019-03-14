package com.bizvane.messageservice.template;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bizvane.messageservice.common.constants.WxApiUrlConstants;
import com.bizvane.messageservice.common.utils.AsyncHttpUtil;
import com.bizvane.messageservice.service.WxMessagetempService;
import com.bizvane.messagefacade.models.po.MsgWxTempPO;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.wechatfacade.interfaces.WxPublicServiceFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 获取模板列表
 * Created by server on 2016/8/17.
 */
public class GetAllTemplateMethod{

    @Autowired
    private WxPublicServiceFeign wxPublicServiceFeign;
    @Autowired
    private WxMessagetempService wxMessagetempService;

    private static Logger log = LoggerFactory.getLogger(GetAllTemplateMethod.class);
    //private static SpringJdbcService jdbcService;

    /**
     *
     * @param jo
     * @return
     */
    public ResponseData<Object> execute(JSONObject jo) {
        log.info("------------->进来了GetAllTemplateMethod类");
        //if (jdbcService == null) jdbcService = JdbcBeans.springJdbcService;
        ResponseData<Object> responseData = new ResponseData<>();
        /*Data data = db.data;
        String dataStr = data.data;*/
        JSONObject returnjo;
        Long user_id;
        Long ad_client_id;
        int public_id;
        try {
            //JSONObject oj = new JSONObject(dataStr);
            if (jo == null || !jo.containsKey("params")) {
                responseData.setCode(SysResponseEnum.FAILED.getCode());
                responseData.setMessage("获取模板列表失败，请重试0");
                return responseData;
            }
            log.info("==========oj=" + jo.toString());
            if (jo == null || !jo.containsKey("ad_client_id") || !jo.containsKey("public_id") || !jo.containsKey("user_id")) {
                responseData.setCode(SysResponseEnum.FAILED.getCode());
                responseData.setMessage("获取模板列表失败，请重试1");
                return responseData;
            }
            user_id = jo.getLong("user_id");
            ad_client_id = jo.getLong("ad_client_id");
            public_id = jo.getInteger("public_id");
            returnjo = gettoken(user_id, ad_client_id, public_id);

            responseData.setCode(returnjo.getInteger("code"));
            responseData.setMessage(returnjo.getString("message"));
            responseData.setData(returnjo);
        } catch (Exception e) {
            e.printStackTrace();
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(e.getMessage());
        }
        return responseData;
    }


    /**
     *
     * @param user_id
     * @param ad_client_id
     * @param public_id
     * @return
     * @throws Exception
     */
    public JSONObject gettoken(long user_id, long ad_client_id, long public_id) throws Exception {
        JSONObject resultjo = new JSONObject();
        //获取access_token
        log.info(user_id + "==" + ad_client_id + "==" + public_id);
        ResponseData<String> tokenResponseData = wxPublicServiceFeign.getAccessTokenByPublicId(public_id);
        String token = tokenResponseData.getData();
       /* WeUtils wu = WeUtilsManager.getInstance().getById(public_id);
        WxPublicControl wc = WxPublicControl.getInstance(wu.getAppid());
        String token = wc.getAccessToken();*/
        if (token == null) {
            resultjo.put("code", "-1");
            resultjo.put("message", "请重新授权");
            return resultjo;
        }
        JSONObject jsonObject;
        jsonObject = JSONObject.parseObject(AsyncHttpUtil.doGet(WxApiUrlConstants.wx_get_all_template_url + token, ""));
        log.info("==========jsonObject" + jsonObject);
        if (jsonObject == null) {
            resultjo.put("code", "-1");
            resultjo.put("message", "微信调用错误" + jsonObject.toString());
            return resultjo;
        } else {
            JSONArray ja = jsonObject.getJSONArray("template_list");
            log.info("==========ja" + ja);
            for (int i = 0; i < ja.size(); i++) {
                JSONObject jo = JSONObject.parseObject(ja.get(i).toString());
                String template_id = jo.getString("template_id");//模板ID
                String title = jo.getString("title");//模板标题
                String primary_industry = jo.getString("primary_industry");//模板所属行业的一级行业
                String deputy_industry = jo.getString("deputy_industry");//模板所属行业的二级行业
                String content = jo.getString("content");//模板内容
                String example = jo.getString("example");//模板示例
                System.out.println(template_id + "==" + title + "==" + primary_industry + "==" + deputy_industry);
                //int itemCount = QueryEngine.doQueryObject("SELECT COUNT(1) FROM wx_messagetemp WHERE WX_TEMPLATE_ID=? AND WX_PUBLIC_ID=?", new Object[]{template_id, public_id}, Integer.class);
                long itemCount = wxMessagetempService.findCountByTemplateIdAndPublicId(template_id,public_id);
                if (itemCount > 0) {
                    log.info("==================模板ID为:" + template_id + "在该模板数据库中已存在");
                } else {
                    String insertM = "insert into wx_messagetemp (AD_CLIENT_ID,CREATEID,MODIFYID,WX_TEMPLATE_ID,PRIMARY_INDUSTRY,DEPUTY_INDESTRY,TITLE,CONTENT,EXAMPLE,WX_PUBLIC_ID) values(?,?,?,?,?,?,?,?,?,?);";
                   // long result = QueryEngine.doInsert(insertM, new Object[]{ad_client_id, user_id, user_id, template_id, primary_industry, deputy_industry, title, content, example, public_id});
                    MsgWxTempPO po = new MsgWxTempPO();
                    po.setCreateUserId(user_id);
                    po.setModifiedUserId(user_id);
                    po.setWxTemplateId(template_id);
                    po.setPrimaryIndustry(primary_industry);
                    po.setDeputyIndestry(deputy_industry);
                    po.setTitle(title);
                    po.setContent(content);
                    po.setExample(example);
                    po.setWxPublicId(public_id);
                    long result = wxMessagetempService.saveMessageTemp(po);
                    log.info("==================插入模板ID为:" + template_id + "的模板时：" + result);
                }
            }
        }
        resultjo.put("data", jsonObject);
        return resultjo;
    }
}
