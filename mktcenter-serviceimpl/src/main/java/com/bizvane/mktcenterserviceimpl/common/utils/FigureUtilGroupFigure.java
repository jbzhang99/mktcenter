package com.bizvane.mktcenterserviceimpl.common.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.mktcenterservice.models.po.FileReportTempPO;
import com.bizvane.mktcenterservice.models.requestvo.BackData;
import com.bizvane.mktcenterservice.models.requestvo.BackDataBiaotou;
import com.bizvane.mktcenterservice.models.requestvo.BackDataTime;
import com.bizvane.mktcenterservice.models.requestvo.BackDataTimeDtail;
import com.bizvane.mktcenterservice.models.requestvo.BackDataTimeDtailtu;
import com.bizvane.mktcenterservice.models.requestvo.postvo.IncomeTotalListGroup;

public class FigureUtilGroupFigure {
	

  
//查询表头和转json数据
  public static  List<BackData> parseJSON2Map(String jsonStr,List<FileReportTempPO> fileReportTempPOlist){  
	   List<BackData> listdata =new ArrayList<BackData>();
 	try {
 		
 		//查询表头
 		BackData backDataOne =new BackData();
 		if(null!=fileReportTempPOlist&&fileReportTempPOlist.size()>0) {
 			List<BackDataBiaotou> biaotoulist =new ArrayList<BackDataBiaotou>();
 			
 			Map<Integer,String> map=new HashMap<Integer,String>();
 			int i=1;
 			for(String string :fileReportTempPOlist.get(0).getReportData().split(",")) {
 				map.put(i++, string);
 			}
 			 i=1;
 			for(String string :fileReportTempPOlist.get(0).getReportDataName().split(",")) {
 				BackDataBiaotou biaotou= new BackDataBiaotou();
 				biaotou.setHeaderType(string);
 				biaotou.setHeaderName(map.get(i++));
 				biaotoulist.add(biaotou);

 			}
 			
 			backDataOne.setHeader(biaotoulist);
 			listdata.add(backDataOne);
 		}
 		//查询表头
 		
 		if(jsonStr.equals("false")) {
 			 return listdata;  
 		}
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
   
  public static  List<BackDataTime> parseJSON2MapTime(String jsonStr,List<FileReportTempPO> fileReportTempPOlist,IncomeTotalListGroup vipIncomeAnalysis){  
	   List<BackDataTime> listdata =new ArrayList<BackDataTime>();
	   List<BackDataTime> listdata2 =new ArrayList<BackDataTime>();
	   
	   try {
		   int ino=0;
			//查询表头
			BackDataTime backDataOne =new BackDataTime();
			BackDataTimeDtail backDataTimeDtail =new BackDataTimeDtail();
      //解析带时间的json数据，
		//	   最外层解析  
		       if(jsonStr!=null&&jsonStr.startsWith("{")&&jsonStr.endsWith("}")){
		           JSONObject json = JSONObject.parseObject(jsonStr);  
		           
		           if(fileReportTempPOlist.get(0).getTemplateDimension().equals("figure")) {
		        	   //不用分页
		        	   
		        	   BigDecimal total= new BigDecimal(0.00);
		        	   BigDecimal vipData= new BigDecimal(0.00);
		        	   BigDecimal touristsData= new BigDecimal(0.00);
		        	   BigDecimal onlineData= new BigDecimal(0.00);
		        	   BigDecimal offlineData= new BigDecimal(0.00);

			           for(Object k : json.keySet()){
			        	   ino++;
			        	   BackDataTime backData =new BackDataTime();
				        	
			               backData.setTime(k.toString());
			               backData.setJosonData(JSONObject.parseObject(json.get(k).toString()));
			        	   if(k.toString().equals("all")) {
				               //计算总数
				               total=   new BigDecimal(backData.getJosonData().getString("total"));
				               vipData=  new BigDecimal(backData.getJosonData().getString("vipData"));
				               touristsData=  new BigDecimal(backData.getJosonData().getString("touristsData"));
				               onlineData=  new BigDecimal(backData.getJosonData().getString("onlineData"));
				               offlineData=  new BigDecimal(backData.getJosonData().getString("offlineData"));
			        		   
			        	   }else {
				               listdata2.add(backData); 
			        	   }
				               
			           } 
			           

			           backDataTimeDtail.setTotal(total.toString());
			           backDataTimeDtail.setVipData(vipData.toString());
			           backDataTimeDtail.setTouristsData(touristsData.toString());
			           backDataTimeDtail.setOnlineData(onlineData.toString());
			           backDataTimeDtail.setOfflineData(offlineData.toString());
			           
			           
			           backDataTimeDtail.setVipDataAccountedfor(vipData.multiply(new BigDecimal(100)).divide(total, 2, RoundingMode.HALF_UP).toString());
			           backDataTimeDtail.setTouristsDataAccountedfor(touristsData.multiply(new BigDecimal(100)).divide(total, 2, RoundingMode.HALF_UP).toString());
			           backDataTimeDtail.setOnlineDataAccountedfor(onlineData.multiply(new BigDecimal(100)).divide(total, 2, RoundingMode.HALF_UP).toString());
			           backDataTimeDtail.setOfflineDataAccountedfor(offlineData.multiply(new BigDecimal(100)).divide(total, 2, RoundingMode.HALF_UP).toString());
			           
		        	   
		           }else {
//		        	   分页显示，如[10,25），则从第10条查询出25条数据
			           for(Object k : json.keySet()){
			        	   ino++;
			        	   if(vipIncomeAnalysis.getStartRecord()<=ino&&ino<(vipIncomeAnalysis.getStartRecord()+vipIncomeAnalysis.getQueryNum())) {
				        	   BackDataTime backData =new BackDataTime();
				               backData.setTime(k.toString());
				               backData.setJosonData(JSONObject.parseObject(json.get(k).toString()));
				               listdata2.add(backData); 
			        	   }
			           }  
		           }

		           
		           
		           
		       }
		       
		      

				if(null!=fileReportTempPOlist&&fileReportTempPOlist.size()>0) {
					List<BackDataBiaotou> biaotoulist =new ArrayList<BackDataBiaotou>();
					Map<Integer,String> map=new HashMap<Integer,String>();
					int i=1;
					for(String string :fileReportTempPOlist.get(0).getReportData().split(",")) {
						map.put(i++, string);
					}
					 i=1;
					for(String string :fileReportTempPOlist.get(0).getReportDataName().split(",")) {
						BackDataBiaotou biaotou= new BackDataBiaotou();
						biaotou.setHeaderType(string);
						biaotou.setHeaderName(map.get(i++));
						biaotoulist.add(biaotou);

					}
					backDataOne.setHeader(biaotoulist);
					backDataOne.setTotalNumber(ino);
					backDataOne.setJosonData(JSONObject.parseObject(JSONObject.toJSONString(backDataTimeDtail)));
					listdata.add(backDataOne);
				}
				listdata.addAll(listdata2);
		} catch (Exception e) {
		}
	   
	   return listdata; 
  }   
  
  
  public static  List<BackDataTime> parseJSON2MapTimeOpera(String jsonStr,List<FileReportTempPO> fileReportTempPOlist,IncomeTotalListGroup vipIncomeAnalysis){  
	   List<BackDataTime> listdata =new ArrayList<BackDataTime>();
	   List<BackDataTime> listdata2 =new ArrayList<BackDataTime>();
	   
	   try {
		   int ino=0;
			//查询表头
			BackDataTime backDataOne =new BackDataTime();
			BackDataTimeDtailtu backDataTimeDtail =new BackDataTimeDtailtu();
     //解析带时间的json数据，
		//	   最外层解析  
		       if(jsonStr!=null&&jsonStr.startsWith("{")&&jsonStr.endsWith("}")){
		           JSONObject json = JSONObject.parseObject(jsonStr);  
		           
		        	   //不用分页
		        	   
		        	   BigDecimal vipData= new BigDecimal(0.00);
		        	   BigDecimal inactivityVipData= new BigDecimal(0.00);
		        	   BigDecimal activityVipData= new BigDecimal(0.00);
		        	   BigDecimal oldVipData= new BigDecimal(0.00);
		        	   BigDecimal newVipData= new BigDecimal(0.00);

			           for(Object k : json.keySet()){
			        	   ino++;
				        	   BackDataTime backData =new BackDataTime();
				               backData.setTime(k.toString());
				               backData.setJosonData(JSONObject.parseObject(json.get(k).toString()));
				               
				        	   if(k.toString().equals("all")) {
					               //计算总数
					               vipData =  vipData.add(new BigDecimal(backData.getJosonData().getString("vipData")));
					               inactivityVipData =  inactivityVipData.add(new BigDecimal(backData.getJosonData().getString("inactivityVipData")));
					               activityVipData =  activityVipData.add(new BigDecimal(backData.getJosonData().getString("activityVipData")));
					               oldVipData =  oldVipData.add(new BigDecimal(backData.getJosonData().getString("oldVipData")));
					               newVipData =  newVipData.add(new BigDecimal(backData.getJosonData().getString("newVipData")));
				        		   
				        	   }else {
					               listdata2.add(backData); 
				        	   } 
				               
				               
				               
			           } 
			           
//V
			           backDataTimeDtail.setVipData(vipData.toString());
			           backDataTimeDtail.setInactivityVipData(inactivityVipData.toString());
			           backDataTimeDtail.setActivityVipData(activityVipData.toString());
			           backDataTimeDtail.setOldVipData(oldVipData.toString());
			           backDataTimeDtail.setNewVipData(newVipData.toString());
//			           
			           backDataTimeDtail.setInactivityVipDataAccountedfor(inactivityVipData.multiply(new BigDecimal(100)).divide(vipData, 2, RoundingMode.HALF_UP).toString());
			           backDataTimeDtail.setActivityVipDataAccountedfor(activityVipData.multiply(new BigDecimal(100)).divide(vipData, 2, RoundingMode.HALF_UP).toString());
			           backDataTimeDtail.setOldVipDataAccountedfor(oldVipData.multiply(new BigDecimal(100)).divide(vipData, 2, RoundingMode.HALF_UP).toString());
			           backDataTimeDtail.setNewVipDataAccountedfor(newVipData.multiply(new BigDecimal(100)).divide(vipData, 2, RoundingMode.HALF_UP).toString());
		           
		       }
		       
				if(null!=fileReportTempPOlist&&fileReportTempPOlist.size()>0) {
					List<BackDataBiaotou> biaotoulist =new ArrayList<BackDataBiaotou>();
					Map<Integer,String> map=new HashMap<Integer,String>();
					int i=1;
					for(String string :fileReportTempPOlist.get(0).getReportData().split(",")) {
						map.put(i++, string);
					}
					 i=1;
					for(String string :fileReportTempPOlist.get(0).getReportDataName().split(",")) {
						BackDataBiaotou biaotou= new BackDataBiaotou();
						biaotou.setHeaderType(string);
						biaotou.setHeaderName(map.get(i++));
						biaotoulist.add(biaotou);

					}
					backDataOne.setHeader(biaotoulist);
					backDataOne.setTotalNumber(ino);
					backDataOne.setJosonData(JSONObject.parseObject(JSONObject.toJSONString(backDataTimeDtail)));
					listdata.add(backDataOne);
//					if(null!=vipIncomeAnalysis.getCycle()&&vipIncomeAnalysis.getCycle().equals("")) {
//						listdata.add(backDataOne);
//					}else {
//						listdata.addAll(listdata2);
//					}
				}

				
				listdata.addAll(listdata2);
		} catch (Exception e) {
			System.out.println("报表解析异常");
		}
	   
	   return listdata; 
 }  

}
