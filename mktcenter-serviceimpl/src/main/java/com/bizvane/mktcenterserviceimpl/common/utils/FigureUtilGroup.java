package com.bizvane.mktcenterserviceimpl.common.utils;

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
import com.bizvane.mktcenterservice.models.requestvo.postvo.IncomeTotalListGroup;

public class FigureUtilGroup {
	

  
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

      //解析带时间的json数据，
		//	   最外层解析  
		       if(jsonStr!=null&&jsonStr.startsWith("{")&&jsonStr.endsWith("}")){
		           JSONObject json = JSONObject.parseObject(jsonStr);  
		           
		           for(Object k : json.keySet()){
		        	   ino++;
//		        	   分页显示，如[10,25），则从第10条查询出25条数据
		        	   if(vipIncomeAnalysis.getStartRecord()<=ino&&ino<(vipIncomeAnalysis.getStartRecord()+vipIncomeAnalysis.getQueryNum())) {
			        	   BackDataTime backData =new BackDataTime();
			        	   JSONObject  jsonObje= JSONObject.parseObject(json.get(k).toString());
			        	   jsonObje.put("time", k.toString());
			               backData.setJosonData(jsonObje);
			               listdata2.add(backData); 
		        	   }

		           }  
		       }
		       
		      
				//查询表头
				BackDataTime backDataOne =new BackDataTime();
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
					listdata.add(backDataOne);
				}
				listdata.addAll(listdata2);
		} catch (Exception e) {
		}
	   
	   return listdata; 
  }    

}
