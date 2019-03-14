package com.bizvane.mktcenterservice.common.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.mktcenterfacade.models.po.FileReportTempPO;
import com.bizvane.mktcenterfacade.models.requestvo.BackData;
import com.bizvane.mktcenterfacade.models.requestvo.BackDataBiaotou;
import com.bizvane.mktcenterfacade.models.requestvo.BackDataTime;
import com.bizvane.mktcenterfacade.models.requestvo.BackDataTimeDtail;
import com.bizvane.mktcenterfacade.models.requestvo.BackDataTimeDtailtu;
import com.bizvane.mktcenterfacade.models.requestvo.postvo.IncomeTotalListGroup;

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
   
  public static  BackDataTimeDtail parseJSON2MapTime(String jsonStr,List<FileReportTempPO> fileReportTempPOlist,IncomeTotalListGroup vipIncomeAnalysis){  
	   List<BackDataTime> listdata =new ArrayList<BackDataTime>();
	   List<BackDataTime> listdata2 =new ArrayList<BackDataTime>();
	   BackDataTimeDtail backDataTimeDtail =new BackDataTimeDtail();
	   List<JSONObject> JSONObjectlist =new ArrayList<JSONObject>();
	   
	   try {
		   int ino=0;
			//查询表头
			BackDataTime backDataOne =new BackDataTime();
			
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

		        	   
		        	   Map<String,JSONObject> mapjsonObje=new TreeMap<String,JSONObject>();
			           for(Object k : json.keySet()){
			        	   ino++;
			        	   BackDataTime backData =new BackDataTime();
			               backData.setTime(k.toString());
			               backData.setJosonData(JSONObject.parseObject(json.get(k).toString()));
			        	   if(k.toString().equals("all")) {
				               //计算总数
			        		   try {
			        			   total=   new BigDecimal(backData.getJosonData().getString("total"));
					               vipData=  new BigDecimal(backData.getJosonData().getString("vipData"));
					               touristsData=  new BigDecimal(backData.getJosonData().getString("touristsData"));
					               onlineData=  new BigDecimal(backData.getJosonData().getString("onlineData"));
					               offlineData=  new BigDecimal(backData.getJosonData().getString("offlineData"));
							   } catch (Exception e) {
								// TODO: handle exception
							  }
				               
			        		   
			        	   }else {
			        		   
			        		   JSONObject  jsonObje= JSONObject.parseObject(json.get(k).toString());
				        	   jsonObje.put("time", k.toString());
//				        	   JSONObjectlist.add(jsonObje);
				        	   
				               SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				               Date date = simpleDateFormat.parse(k.toString());
				               long ts = date.getTime();
				               
				        	   mapjsonObje.put(String.valueOf(ts), jsonObje);
			        	   }
				               
			           } 
			                 //排序
			                 for (String key : mapjsonObje.keySet()) {
			                	 JSONObjectlist.add(mapjsonObje.get(key));
			                 }
			                 
			           if(JSONObjectlist.size()>0) {
			        	   backDataTimeDtail.setJosonData(JSONObjectlist);
			           }
			          

			           backDataTimeDtail.setTotal(total.toString());
			           backDataTimeDtail.setVipData(vipData.toString());
			           backDataTimeDtail.setTouristsData(touristsData.toString());
			           backDataTimeDtail.setOnlineData(onlineData.toString());
			           backDataTimeDtail.setOfflineData(offlineData.toString());
			           
			           try {
						
			           backDataTimeDtail.setVipDataAccountedfor(vipData.multiply(new BigDecimal(100)).divide(total, 2, RoundingMode.HALF_UP).toString());
			           backDataTimeDtail.setTouristsDataAccountedfor(touristsData.multiply(new BigDecimal(100)).divide(total, 2, RoundingMode.HALF_UP).toString());
			           backDataTimeDtail.setOnlineDataAccountedfor(onlineData.multiply(new BigDecimal(100)).divide(total, 2, RoundingMode.HALF_UP).toString());
			           backDataTimeDtail.setOfflineDataAccountedfor(offlineData.multiply(new BigDecimal(100)).divide(total, 2, RoundingMode.HALF_UP).toString());
						} catch (Exception e) {
							// TODO: handle exception
						}
			           //显示下拉
			           String [] str =new String [7] ;
			           String str1="";
			           
			           if(vipIncomeAnalysis.getIndicators().equals("0")) {
			        	   str1="总收入（元）,会员收入（元）,非会员收入（元）,线上会员收入（元）,线下会员收入（元）";
			           }else if(vipIncomeAnalysis.getIndicators().equals("1")) {
			        	   str1=" 总人数,会员人数,非会员人数,线上会员人数,线下会员人数";
			           }else if(vipIncomeAnalysis.getIndicators().equals("2")) {
			        	   str1=" 总新增人数,会员新增人数,非会员新增人数,线上会员人数,线下会员人数";
			           }else if(vipIncomeAnalysis.getIndicators().equals("3")) {
			        	   str1=" 总件数,会员件数,非会员件数,线上会员件数,线下会员件数";
			           }else if(vipIncomeAnalysis.getIndicators().equals("4")) {
			        	   str1=" 总笔数,会员笔数,非会员笔数,线上会员笔数,线下会员笔数";
			           }else if(vipIncomeAnalysis.getIndicators().equals("5")) {
			        	   str1=" 件单价,会员件单价,非会员件单价,线上会员件单价,线下会员件单价";
			           }else if(vipIncomeAnalysis.getIndicators().equals("6")) {
			        	   str1=" 客单价,会员客单价,非会员客单价,线上会员客单价,线下会员客单价";
			           }else if(vipIncomeAnalysis.getIndicators().equals("7")) {
			        	   str1="连带率,会员连带率,非会员连带率,线上会员连带率,线下会员连带率";
			           }else if(vipIncomeAnalysis.getIndicators().equals("8")) {
			        	   str1="折扣率,会员折扣率,非会员折扣率,线上会员折扣率,线下会员折扣率";
			           }
			           
		        	    int i=1;
						for(String string :str1.split(",")) {
							str[i]=string;
							i++;
						}

			           backDataTimeDtail.setTotalName(str[1]);
			           backDataTimeDtail.setVipDataName(str[2]);
			           backDataTimeDtail.setTouristsDataName(str[3]);
			           backDataTimeDtail.setOnlineDataName(str[4]);
			           backDataTimeDtail.setOfflineDataName(str[5]);
			         //显示下拉
		        	   
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
			//解析异常
			System.out.println("报表解析异常"+e);
		}
	   
	   return backDataTimeDtail; 
  }   
  
  
  public static  BackDataTimeDtailtu parseJSON2MapTimeOpera(String jsonStr,List<FileReportTempPO> fileReportTempPOlist,IncomeTotalListGroup vipIncomeAnalysis){  
	   List<BackDataTime> listdata =new ArrayList<BackDataTime>();
	   List<BackDataTime> listdata2 =new ArrayList<BackDataTime>();
	   List<JSONObject> JSONObjectlist =new ArrayList<JSONObject>();
	   
	   BackDataTimeDtailtu backDataTimeDtail =new BackDataTimeDtailtu();
	   try {
		   int ino=0;
			//查询表头
			BackDataTime backDataOne =new BackDataTime();
			
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
		        	   Map<String,JSONObject> mapjsonObje=new TreeMap<String,JSONObject>();
			           for(Object k : json.keySet()){
			        	   ino++;
				        	   BackDataTime backData =new BackDataTime();
				               backData.setTime(k.toString());
				               backData.setJosonData(JSONObject.parseObject(json.get(k).toString()));
				               
				        	   if(k.toString().equals("all")) {
					               //计算总数
				        		   try {
							               vipData =  vipData.add(new BigDecimal(backData.getJosonData().getString("vipData")));
							               inactivityVipData =  inactivityVipData.add(new BigDecimal(backData.getJosonData().getString("inactivityVipData")));
							               activityVipData =  activityVipData.add(new BigDecimal(backData.getJosonData().getString("activityVipData")));
							               oldVipData =  oldVipData.add(new BigDecimal(backData.getJosonData().getString("oldVipData")));
							               newVipData =  newVipData.add(new BigDecimal(backData.getJosonData().getString("newVipData")));
									} catch (Exception e) {
										// TODO: handle exception
									}
				        	   }else {
				        		   JSONObject  jsonObje= JSONObject.parseObject(json.get(k).toString());
					        	   jsonObje.put("time", k.toString());
//					        	   JSONObjectlist.add(jsonObje);
				        		   
					               SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					               Date date = simpleDateFormat.parse(k.toString());
					               long ts = date.getTime();
					        	   mapjsonObje.put(String.valueOf(ts), jsonObje);
					        	   
				        	   } 
				               
				               
				               
			           } 
			           
		                 //排序
		                 for (String key : mapjsonObje.keySet()) {
		                	 JSONObjectlist.add(mapjsonObje.get(key));
		                 }
			           
                      backDataTimeDtail.setJosonData(JSONObjectlist);
			           backDataTimeDtail.setVipData(vipData.toString());
			           backDataTimeDtail.setInactivityVipData(inactivityVipData.toString());
			           backDataTimeDtail.setActivityVipData(activityVipData.toString());
			           backDataTimeDtail.setOldVipData(oldVipData.toString());
			           backDataTimeDtail.setNewVipData(newVipData.toString());
//			           t
			           try {
						
					
			           backDataTimeDtail.setInactivityVipDataAccountedfor(inactivityVipData.multiply(new BigDecimal(100)).divide(vipData, 2, RoundingMode.HALF_UP).toString());
			           backDataTimeDtail.setActivityVipDataAccountedfor(activityVipData.multiply(new BigDecimal(100)).divide(vipData, 2, RoundingMode.HALF_UP).toString());
			           backDataTimeDtail.setOldVipDataAccountedfor(oldVipData.multiply(new BigDecimal(100)).divide(vipData, 2, RoundingMode.HALF_UP).toString());
			           backDataTimeDtail.setNewVipDataAccountedfor(newVipData.multiply(new BigDecimal(100)).divide(vipData, 2, RoundingMode.HALF_UP).toString());
		           
			           } catch (Exception e) {
							// TODO: handle exception
					}

		       
		       
	           //显示下拉
	           String [] str =new String [7] ;
	           String str1="";
	           
	           if(vipIncomeAnalysis.getIndicators().equals("0")) {
	        	   str1="总收入（元）,新会员收入（元）,老会员收入（元）,活跃会员收入（元）,非活跃会员收入（元）";
	           }else if(vipIncomeAnalysis.getIndicators().equals("1")) {
	        	   str1=" 总件数,新会员件数,老会员件数,活跃会员件数,非活跃会员件数";
	           }else if(vipIncomeAnalysis.getIndicators().equals("2")) {
	        	   str1=" 总笔数,新会员笔数,老会员笔数,活跃会员笔数,非活跃会员笔数";
	           }else if(vipIncomeAnalysis.getIndicators().equals("3")) {
	        	   str1=" 件单价,新会员件单价,老会员件单价,活跃会员件单价,非活跃会员件单价";
	           }else if(vipIncomeAnalysis.getIndicators().equals("4")) {
	        	   str1=" 客单价,新会员客单价,老会员客单价,活跃会员客单价,非活跃会员客单价";
	           }else if(vipIncomeAnalysis.getIndicators().equals("5")) {
	        	   str1="连带率,新会员连带率,老会员连带率,活跃会员连带率,非活跃会员连带率";
	           }else if(vipIncomeAnalysis.getIndicators().equals("6")) {
	        	   str1="折扣率,新会员折扣率,老会员折扣率,活跃会员折扣率,非活跃会员折扣率";
	           }
	           
        	    int i=0;
				for(String string :str1.split(",")) {
					str[i]=string;
					i++;
				}
				

	            backDataTimeDtail.setVipDataName(str[0]);
				backDataTimeDtail.setNewVipDataName(str[1]);
				backDataTimeDtail.setOldVipDataName(str[2]);
				backDataTimeDtail.setActivityVipDataName(str[3]);
	            backDataTimeDtail.setInactivityVipDataName(str[4]);
	           
	         //显示下拉
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
	   
	   return backDataTimeDtail; 
 }  

}
