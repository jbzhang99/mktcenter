package com.bizvane.mktcenterservice.common.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bizvane.couponservice.common.utils.QiNiuUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.mktcenterfacade.models.po.FileReportTempPO;
import com.bizvane.mktcenterfacade.models.requestvo.BackData;
import com.bizvane.mktcenterfacade.models.requestvo.BackDataBiaotou;
import com.bizvane.mktcenterfacade.models.requestvo.BackDataTime;
import com.bizvane.mktcenterfacade.models.requestvo.exvo.ExportStoreVo;

public class FigureUtil {
	//jion 表格导出
    public static  String Export(String jsonStr,FileReportTempPO fileReportTempPOlist){ 
    	String  qiniuUrl=null;
	       		try {
	       			JSONArray arr=new JSONArray(jsonStr);
	       			
	     			Map<Integer,String> map=new HashMap<Integer,String>();
	     			Map<String,String> mapbiaotou=new HashMap<String,String>();
	     			int i=1;
	     			for(String string :fileReportTempPOlist.getReportData().split(",")) {
	     				map.put(i++, string);
	     			}
	     			 i=1;
	     			for(String string :fileReportTempPOlist.getReportDataName().split(",")) {
	     				mapbiaotou.put(string, map.get(i++));

	     			}
	     			 //Excel导出工具类
	     		    POIUtil<ExportStoreVo> poiUtil = new POIUtil<>();
	     		    //生成输出流
	     		    OutputStream out = new ByteArrayOutputStream();
	     		    
	     		     poiUtil.exportExcel(out,fileReportTempPOlist.getTemplateName(), arr, "文件夹",mapbiaotou,map);
	     			 ByteArrayInputStream in = new ByteArrayInputStream(((ByteArrayOutputStream) out).toByteArray());
	     			  
	     			  //时间格式化
	     			  SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
	     			  String filename =fileReportTempPOlist.getTemplateName()+ format.format(new Date()) + ".xls";
	     			    qiniuUrl = QiNiuUtil.upload(in, filename);
	     			  System.out.println("报表上传到七牛ReportIncomeController："+qiniuUrl);
	     			  in.close();
	     			  out.close();
	     			  
	       		} catch (JSONException e) {
	       			// TODO Auto-generated catch block
	       			e.printStackTrace();
	       		} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	       		
	       	 return qiniuUrl; 
    }

    
    
 public static  void biaoge(String jsonStr,FileReportTempPO fileReportTempPOlist){ 
	           
//	    String headers = fileReportTempPOlist.get(0).getReportDataName();
	    String headers = "商帆系统编号,店铺线下编号";
	try {
	    //Excel导出工具类
	    POIUtil<ExportStoreVo> poiUtil = new POIUtil<>();
	    //导出的标题列
	   
	    //时间格式化
	    SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
	    //要保存的文件名
	    String filename =fileReportTempPOlist.getTemplateName()+ format.format(new Date()) + ".xls";
	
	    //生成输出流
	    OutputStream out = new ByteArrayOutputStream();
	
	    //实例化Excel表格
	    HSSFWorkbook workbook = new HSSFWorkbook();
	    //创建工作表单
	    String[] sheetNames = {"store"};
	    for (int i = 0; i < sheetNames.length; i++) {
	        workbook.createSheet(sheetNames[i]);
	    }
	    //导出到Excel
//	    poiUtil.exportExcel(sheetNames[0], headers, storeVos, out, "yyyy-MM-dd HH:mm", workbook);
	    workbook.write(out);
	  ByteArrayInputStream in = new ByteArrayInputStream(((ByteArrayOutputStream) out).toByteArray());
	  String  qiniuUrl = QiNiuUtil.upload(in, filename);
	  System.out.println("报表上传到七牛ReportIncomeController："+qiniuUrl);
	  in.close();
	  out.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
  
//查询表头和转json数据
  public static  List<BackData> parseJSON2Map(String jsonStr,String dimension,Integer tiaoshu,List<FileReportTempPO> fileReportTempPOlist){  
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
 			 
			 BackDataBiaotou biaotouDimension= new BackDataBiaotou();
			 
			 if(dimension.equals("0")) {
				 biaotouDimension.setHeaderType("empCode");
				 biaotouDimension.setHeaderName("员工编号");
				 biaotoulist.add(biaotouDimension);
				 biaotouDimension= new BackDataBiaotou();
				 biaotouDimension.setHeaderType("empName");
				 biaotouDimension.setHeaderName("员工姓名");
				 biaotoulist.add(biaotouDimension);
				 biaotouDimension= new BackDataBiaotou();
				 biaotouDimension.setHeaderType("storeId");
				 biaotouDimension.setHeaderName("所属店铺");
				 biaotoulist.add(biaotouDimension);

			 }else if(dimension.equals("1")) {
				 biaotouDimension.setHeaderType("storeCode");
				 biaotouDimension.setHeaderName("店铺编号");
				 biaotoulist.add(biaotouDimension);
				 
				 biaotouDimension= new BackDataBiaotou();
				 biaotouDimension.setHeaderType("storeName");
				 biaotouDimension.setHeaderName("店铺名称");
				 biaotoulist.add(biaotouDimension);
				 
				 biaotouDimension= new BackDataBiaotou();
				 biaotouDimension.setHeaderType("groupId");
				 biaotouDimension.setHeaderName("所属群组");
				 biaotoulist.add(biaotouDimension);
				 
			 }else if(dimension.equals("2")) {
				 biaotouDimension.setHeaderType("brandCode");
				 biaotouDimension.setHeaderName("品牌编号");
				 biaotoulist.add(biaotouDimension);
				 biaotouDimension= new BackDataBiaotou();
				 biaotouDimension.setHeaderType("brandName");
				 biaotouDimension.setHeaderName("品牌名称");
				 biaotoulist.add(biaotouDimension);
				 
			 }else if(dimension.equals("3")) {
				 biaotouDimension.setHeaderType("groupCode");
				 biaotouDimension.setHeaderName("群组编号");
				 biaotoulist.add(biaotouDimension);
				 biaotouDimension= new BackDataBiaotou();
				 biaotouDimension.setHeaderType("groupName");
				 biaotouDimension.setHeaderName("群组名称");
				 biaotoulist.add(biaotouDimension);
				 
			 }
 			for(String string :fileReportTempPOlist.get(0).getReportDataName().split(",")) {
 				BackDataBiaotou biaotou= new BackDataBiaotou();
 				biaotou.setHeaderType(string);
 				biaotou.setHeaderName(map.get(i++));
 				biaotoulist.add(biaotou);

 			}
 			
 			//TODO
 			backDataOne.setTotalNumber(tiaoshu);
 			
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
