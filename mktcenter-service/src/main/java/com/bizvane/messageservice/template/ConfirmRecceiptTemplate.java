package com.bizvane.messageservice.template;

/**
 * 确认收货模板消息
 * Created by wx on 2016/12/6.
 */
public class ConfirmRecceiptTemplate{

   /* @Autowired
    private WxPublicServiceFeign wxPublicServiceFeign;
    @Autowired
    private WxChannelInfoApiService wxChannelInfoApiService;

    private static Logger logger = LoggerFactory.getLogger(ConfirmRecceiptTemplate.class);
    private static ConfirmRecceiptTemplate instance = null;

    public static synchronized ConfirmRecceiptTemplate getInstance() {
        if (instance == null) {
            instance = new ConfirmRecceiptTemplate();
        }
        return instance;
    }

    public Result<String> execute(long id, JSONObject jo)*//* throws ApiException *//*{
        logger.info("------------->ConfirmRecceiptTemplate");
        Result<String> result = new Result<>();
       // JSONObject returnjo;
        JSONObject datajo = new JSONObject();
        try {
            //JSONObject paramjo = jo.optJSONObject("params");
           // logger.info("===========paramjo" + paramjo);
            Long public_id = jo.getLong("public_id");
            Long vipid = jo.getLong("vipid");
            if (null == public_id){
                result.setStatus(SysRespConstants.FAILED.getStatus());
                result.setMsg("public_id值为空");
                return result;
            }

            *//*WeUtils wu = WeUtilsManager.getInstance().getById(public_id);
            WXPublicManager wxpm = WXPublicManager.getInstance();
            WXPublicInfo wxp = wxpm.getById(public_id);*//*
            WxPublicPO wxPublicPO = wxPublicServiceFeign.selectByPrimaryKey(public_id);

            //查询openid
            String tousersql = "SELECT v.OPENID  FROM wx_vip v where v.id =?";
            JSONObject touser_json = QueryEngine.doQueryJSONObject(tousersql, new Object[]{vipid});
            String touser = touser_json.optString("openid");
            if (StringUtils.isBlank(touser)) {
                result.setStatus(SysRespConstants.FAILED.getStatus());
                result.setMsg("openid值为空");
                return result;
            }
            //查询data
            String select = "select o.order_no as keyword1,\n" +
                    "       GROUP_CONCAT(c.NAME) as keyword2,\n" +
                    "       o.order_time as keyword3,\n" +
                    "       o.SENDTIME as keyword4,\n" +
                    "       o.PAYMONEY as keyword6,\n" +
                    "       o.comfirmtime as keyword5 from wx_order o INNER JOIN wx_orderitem b on o.ID= b.WX_ORDER_ID INNER JOIN wx_product c on b.WX_PRODUCT_ID= c.ID WHERE o.id= ?";
            JSONObject da = QueryEngine.doQueryJSONObject(select, new Object[]{id});
            logger.info("da=========" + da);



            String keyword1 = da.optString("keyword1");
            String keyword2 = da.optString("keyword2");
            String keyword3 = da.optString("keyword3");
            String keyword4 = da.optString("keyword4");
            String keyword5 = da.optString("keyword5");
            String keyword6 = da.optString("keyword6");

            //获取会员信息
            String vipsql = "select a.*,b.name as wx_store_name from wx_vip a left join wx_store b on a.wx_store_id=b.id  where a.id= ? ";
            JSONObject vipdata = QueryEngine.doQueryJSONObject(vipsql, new Object[]{vipid});
            //确认收货模板消息
            datajo.put("first", "亲：您在我们商城买的宝贝已经确认收货。");
            datajo.put("keyword1", keyword1);
            datajo.put("keyword2", keyword2);
            datajo.put("keyword3", keyword3);
            datajo.put("keyword4", keyword4);
            datajo.put("keyword5", keyword5);
            datajo.put("remark", "感谢您的支持与厚爱。");
            datajo.put("id", id);
            result = UseTemplate.sendMessage(wxPublicPO, ETemplate.t_order_sure_goods.toString(), touser, datajo);
            //String url = getUrl(wxp, wu,  vipdata, keyword1);
          //售后评价模板消息
            if("C10272".equals(wxPublicPO.getSysBrandId())) {
            	 //logger.info("================>123456："+url);
                 JSONObject datajo2 = new JSONObject();
                 datajo2.put("first", "亲爱的顾客，以下是您的消费账单，期待您对我们服务的点评");
                 datajo2.put("keyword1", keyword6);
                 datajo2.put("keyword2", keyword2);
                 datajo2.put("keyword3", keyword3);
                 datajo2.put("keyword4", vipdata.optString("wx_store_name"));
                 datajo2.put("remark", "感谢您的支持与厚爱。");
                 //datajo2.put("url", url);
                 UseTemplate.sendMessage(wxPublicPO, ETemplate.t_vip_Questionnaireinvestigation.toString(), touser, datajo2);
            }

            result.setStatus(SysRespConstants.SUCCESS.getStatus());
            result.setMsg();
            result.setData();
           *//* rv.code = "0";
            rv.message = returnjo.toString();
            rv.data = new com.bizvane.sun.ice.wx.common.Data(returnjo.toString(), ValueType.JSON);*//*
        } catch (Exception e) {
            logger.info("send recc template message errro:" + e.getLocalizedMessage(), e);
            result.setStatus(SysRespConstants.FAILED.getStatus());
            result.setMsg(e.getLocalizedMessage());
        }
        return result;
    }

   *//* public String getUrl(WxPublicPO wxPublicPO, WeUtils wu,JSONObject vipdata,String order_no) {

        Map<String, Data> dataList1 = new HashMap<>();
        String url = "";
        try {
   			dataList1.put("order_no", new Data("order_no", order_no, com.bizvane.sun.v1.common.ValueType.PARAM));
   	        dataList1.put("corp_code", new Data("corp_code", wxp.getCrop_code(), com.bizvane.sun.v1.common.ValueType.PARAM));
   	        dataList1.put("open_id", new Data("open_id", vipdata.optString("openid"), com.bizvane.sun.v1.common.ValueType.PARAM));
   	        dataList1.put("card_no", new Data("card_no", vipdata.optString("off_card_id"), com.bizvane.sun.v1.common.ValueType.PARAM));
   	        dataList1.put("app_id", new Data("app_id", wu.getAppid(), com.bizvane.sun.v1.common.ValueType.PARAM));
   	        logger.info("order_no:"+order_no+",corp_code"+wxp.getCrop_code()+",open_id:"+ vipdata.optString("openid")+",card_no"+vipdata.optString("off_card_id")+",app_id"+wu.getAppid());
   	        //调用接口 获取问卷调查url
   	        DataBox dataBox = new DataBox("1", Status.ONGOING, "", "com.bizvane.sun.api.method.AfterSaleEvaluation", dataList1, null, new Sign(), System.currentTimeMillis());

   	        ResultValue rv1 = HbaseClient.put(dataBox);
   	        if(rv1.message!=null) {
   	            JSONObject jsob = new JSONObject(rv1.data.data);
   	            url = jsob.optString("url");
   	        }
   	        logger.info("================>问卷调查连接地址："+url);
   		} catch (org.codehaus.jettison.json.JSONException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}

    	return url;
    }*/
}
