package com.bizvane.mktcenterserviceimpl.controllers.report;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.T;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.mktcenterservice.models.requestvo.BackData;
import com.bizvane.mktcenterservice.models.requestvo.BaseUrl;
import com.bizvane.mktcenterservice.models.requestvo.exvo.ExportStoreVo;
import com.bizvane.mktcenterservice.models.requestvo.postvo.ActiveMemberAllInterface;
import com.bizvane.mktcenterservice.models.requestvo.postvo.IncomeTotalList;
import com.bizvane.mktcenterservice.models.requestvo.postvo.IncomeVip;
import com.bizvane.mktcenterservice.models.requestvo.postvo.IncreaseVip;
import com.bizvane.mktcenterservice.models.requestvo.postvo.IncreaseVipNum;
import com.bizvane.mktcenterservice.models.requestvo.postvo.NewOldMemberInterface;
import com.bizvane.mktcenterservice.models.requestvo.postvo.OfflineVipIncome;
import com.bizvane.mktcenterservice.models.requestvo.postvo.OnlineVipIncome;
import com.bizvane.mktcenterservice.models.requestvo.postvo.RePurchaseMemberAllInterface;
import com.bizvane.mktcenterservice.models.requestvo.postvo.TouristIncome;
import com.bizvane.mktcenterservice.models.requestvo.postvo.VipIncomeAnalysis;
import com.bizvane.mktcenterservice.models.requestvo.postvo.VipNum;
import com.bizvane.mktcenterserviceimpl.common.utils.POIUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.QiNiuUtil;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.TokenUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liangzanwen
 * @date on 2018/09/18
 * @description 报表分析
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@Slf4j
@RestController
@RequestMapping("reportest")
public class ReportIncomeControllertest {
	@Autowired
	private RestTemplate restTemplate;

    @RequestMapping("vipIncomeAnalysis")
    public ResponseData<List<BackData>> vipIncomeAnalysis(@RequestBody VipIncomeAnalysis vipIncomeAnalysis, HttpServletRequest request){
//         vipIncomeAnalysis.setCorpId(TokenUtils.getStageUser(request).getCompanyCode());
    	
    	 return sendpost(BaseUrl.getLoadUrl("vipIncomeAnalysis"),vipIncomeAnalysis);
    } 

    public ResponseData<List<BackData>> sendpost(String url,Object vipIncomeAnalysis){
    log.info("报表查询ReportIncomeController："+url+vipIncomeAnalysis.toString());
		 ResponseEntity<String> response = this.restTemplate.postForEntity(url, vipIncomeAnalysis,String.class, new Object[0]);
	     ResponseData<List<BackData>> ResponseData =new ResponseData<List<BackData>>();
	     JSONObject job = JSONObject.parseObject(response.getBody());
	   
	     if(job.get("successFlag").equals("1")) {
	    	 ResponseData.setCode(0);
	  	    ResponseData.setMessage(job.get("message").toString());
		    ResponseData.setData(parseJSON2Map(job.get("data").toString()));
	     }else {
	    	 ResponseData.setCode(1);
	  	    ResponseData.setMessage(job.get("message").toString());
	  	    List<BackData> listdata =new ArrayList<BackData>();
		    ResponseData.setData(listdata);
	    	 
	     }
	     

        return ResponseData;
    }
    
    
    
    public static  List<BackData> parseJSON2Map(String jsonStr){  
    	 List<BackData> listdata =new ArrayList<BackData>();
    	try {
			JSONArray arr=new JSONArray(jsonStr);
			for(int i=0;i<arr.length();i++){
				BackData backData =new BackData();
				  backData.setJosonData(JSONObject.parseObject(arr.getJSONObject(i).toString()));
				  listdata.add(backData);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
            return listdata;  
    
    } 
    
// 收入01- 收入总表
   @RequestMapping("incomeTotalList")
   public ResponseData<List<BackData>> incomeTotalListGroup(@RequestBody IncomeTotalList sendVO, HttpServletRequest request){
	   sendVO.setCorpId(TokenUtils.getStageUser(request).getCompanyCode());
   	 return sendpost(BaseUrl.getLoadUrl("incomeTotalList"),sendVO);
   }
   
// 收入01- 会销收入表汇总
   @RequestMapping("incomeVip")
   public ResponseData<List<BackData>> incomeVip(@RequestBody IncomeVip sendVO, HttpServletRequest request){
	   sendVO.setCorpId(TokenUtils.getStageUser(request).getCompanyCode());
   	 return sendpost(BaseUrl.getLoadUrl("incomeVip"),sendVO);
   }
   

   
// 收入01- 游客收入表汇总
   @RequestMapping("touristIncome")
   public ResponseData<List<BackData>> touristIncome(@RequestBody TouristIncome sendVO, HttpServletRequest request){
	   sendVO.setCorpId(TokenUtils.getStageUser(request).getCompanyCode());
   	 return sendpost(BaseUrl.getLoadUrl("touristIncome"),sendVO);
   }
   
// 02渠道-线上会销收入表汇总
   @RequestMapping("onlineVipIncome")
   public ResponseData<List<BackData>> onlineVipIncome(@RequestBody OnlineVipIncome sendVO, HttpServletRequest request){
	   sendVO.setCorpId(TokenUtils.getStageUser(request).getCompanyCode());
   	 return sendpost(BaseUrl.getLoadUrl("onlineVipIncome"),sendVO);
   }
   
// 02渠道-线下
   @RequestMapping("offlineVipIncome")
   public ResponseData<List<BackData>> offlineVipIncome(@RequestBody OfflineVipIncome sendVO, HttpServletRequest request){
	   sendVO.setCorpId(TokenUtils.getStageUser(request).getCompanyCode());
   	 return sendpost(BaseUrl.getLoadUrl("offlineVipIncome"),sendVO);
   }
   
// 03开绑卡分析-开卡
//   @RequestMapping("offlineVipIncome")
//   public ResponseData<List<BackData>> offlineVipIncome(OfflineVipIncome sendVO, HttpServletRequest request){
//	   sendVO.setCorpId(TokenUtils.getStageUser(request).getCompanyCode());
//   	 return sendpost(BaseUrl.getLoadUrl("offlineVipIncome"),sendVO);
//   }
   
// 03开绑卡分析-绑卡
// @RequestMapping("offlineVipIncome")
// public ResponseData<List<BackData>> offlineVipIncome(OfflineVipIncome sendVO, HttpServletRequest request){
//	   sendVO.setCorpId(TokenUtils.getStageUser(request).getCompanyCode());
// 	 return sendpost(BaseUrl.getLoadUrl("offlineVipIncome"),sendVO);
// }
   
// 04会员数量
   @RequestMapping("vipNum")
   public ResponseData<List<BackData>> vipNum(@RequestBody VipNum sendVO, HttpServletRequest request){
	   sendVO.setCorpId(TokenUtils.getStageUser(request).getCompanyCode());
   	 return sendpost(BaseUrl.getLoadUrl("vipNum"),sendVO);
   }
   
// 05新增会员-新增会员收入
   @RequestMapping("increaseVip")
   public ResponseData<List<BackData>> increaseVip(@RequestBody IncreaseVip sendVO, HttpServletRequest request){
	   sendVO.setCorpId(TokenUtils.getStageUser(request).getCompanyCode());
   	 return sendpost(BaseUrl.getLoadUrl("increaseVip"),sendVO);
   }
// 05新增会员-新增会员数量
   @RequestMapping("increaseVipNum")
   public ResponseData<List<BackData>> increaseVipNum(@RequestBody IncreaseVipNum sendVO, HttpServletRequest request){
	   sendVO.setCorpId(TokenUtils.getStageUser(request).getCompanyCode());
   	 return sendpost(BaseUrl.getLoadUrl("increaseVipNum"),sendVO);
   }
   
// 06会员卡分析-类型1
//   @RequestMapping("increaseVipNum")
//   public ResponseData<List<BackData>> increaseVipNum(IncreaseVipNum sendVO, HttpServletRequest request){
//	   sendVO.setCorpId(TokenUtils.getStageUser(request).getCompanyCode());
//   	 return sendpost(BaseUrl.getLoadUrl("increaseVipNum"),sendVO);
//   }
// 06会员卡分析-类型2
// @RequestMapping("increaseVipNum")
// public ResponseData<List<BackData>> increaseVipNum(IncreaseVipNum sendVO, HttpServletRequest request){
//	   sendVO.setCorpId(TokenUtils.getStageUser(request).getCompanyCode());
// 	 return sendpost(BaseUrl.getLoadUrl("increaseVipNum"),sendVO);
// }
   
// 07新老会员分析-新会员
   @RequestMapping("newOldMemberInterface")
   public ResponseData<List<BackData>> newOldMemberInterface(@RequestBody NewOldMemberInterface sendVO, HttpServletRequest request){
	   sendVO.setCorpId(TokenUtils.getStageUser(request).getCompanyCode());
   	 return sendpost(BaseUrl.getLoadUrl("newOldMemberInterface"),sendVO);
   }
   
// 08活跃会员表汇总
   @RequestMapping("activeMemberAllInterface")
   public ResponseData<List<BackData>> activeMemberAllInterface(@RequestBody ActiveMemberAllInterface sendVO, HttpServletRequest request){
	   sendVO.setCorpId(TokenUtils.getStageUser(request).getCompanyCode());
   	 return sendpost(BaseUrl.getLoadUrl("activeMemberAllInterface"),sendVO);
   }
   
// 09复购-会员表汇总
   @RequestMapping("rePurchaseMemberAllInterface")
   public ResponseData<List<BackData>> rePurchaseMemberAllInterface(@RequestBody RePurchaseMemberAllInterface sendVO, HttpServletRequest request){
	   sendVO.setCorpId(TokenUtils.getStageUser(request).getCompanyCode());
   	 return sendpost(BaseUrl.getLoadUrl("rePurchaseMemberAllInterface"),sendVO);
   }
   
// 10回购-会员表汇总
//   @RequestMapping("activeMemberAllInterface")
//   public ResponseData<List<BackData>> activeMemberAllInterface(ActiveMemberAllInterface sendVO, HttpServletRequest request){
//	   sendVO.setCorpId(TokenUtils.getStageUser(request).getCompanyCode());
//   	 return sendpost(BaseUrl.getLoadUrl("activeMemberAllInterface"),sendVO);
//   }



    
   public static  List<BackData> parseJSON2MapTime(String jsonStr){  

       //最外层解析  
       if(jsonStr!=null&&jsonStr.startsWith("{")&&jsonStr.endsWith("}")){
           Map<String, Object> map = new HashMap<String, Object>();  
           
           JSONObject json = JSONObject.parseObject(jsonStr);  
           List<BackData> listdata =new ArrayList<BackData>();
           for(Object k : json.keySet()){
           	BackData backData =new BackData();
//               backData.setTime(k.toString());
//               backData.setJosonData(json.get(k).toString());
               listdata.add(backData);
           }  
//           JSON.toJSON(listdata).toString()
           return listdata;  
       }else{
           return null;
       }
   }    
 


}
