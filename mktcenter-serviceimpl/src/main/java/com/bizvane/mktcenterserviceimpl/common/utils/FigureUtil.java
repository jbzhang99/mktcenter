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

public class FigureUtil {
	

  
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
 			
 			//TODO
 			backDataOne.setTotalNumber(100);
 			
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
   
  public static  List<BackDataTime> parseJSON2MapTime(String jsonStr,List<FileReportTempPO> fileReportTempPOlist){  
	   List<BackDataTime> listdata =new ArrayList<BackDataTime>();
	   
	   try {
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
			
			//TODO
			backDataOne.setTotalNumber(100);
			listdata.add(backDataOne);
		}
		//查询表头

      //解析带时间的json数据，
		//	   最外层解析  
		       if(jsonStr!=null&&jsonStr.startsWith("{")&&jsonStr.endsWith("}")){
		           Map<String, Object> map = new HashMap<String, Object>();  
		           JSONObject json = JSONObject.parseObject(jsonStr);  
		           for(Object k : json.keySet()){
		        	   BackDataTime backData =new BackDataTime();
		               backData.setTime(k.toString());
		               backData.setJosonData(JSONObject.parseObject(json.get(k).toString()));
		               listdata.add(backData);
		           }  
		//           JSON.toJSON(listdata).toString()
		       }
      
		} catch (Exception e) {
		}
	   
	   return listdata; 
  }    

}
