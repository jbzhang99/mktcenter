package com.bizvane.mktcenterserviceimpl.controllers.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.centerstageservice.models.po.SysCompanyPo;
import com.bizvane.centerstageservice.models.po.SysStoreGroupPo;
import com.bizvane.centerstageservice.models.po.SysStorePo;
import com.bizvane.centerstageservice.models.vo.SysStoreVo;
import com.bizvane.centerstageservice.rpc.CompanyServiceRpc;
import com.bizvane.centerstageservice.rpc.StoreGroupServiceRpc;
import com.bizvane.centerstageservice.rpc.StoreServiceRpc;
import com.bizvane.mktcenterservice.interfaces.ReportTempService;
import com.bizvane.mktcenterservice.models.po.FileReportTempPO;
import com.bizvane.mktcenterservice.models.po.FileReportTempPOExample;
import com.bizvane.mktcenterservice.models.requestvo.BackData;
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
import com.bizvane.mktcenterservice.models.requestvo.postvo.VipNum;
import com.bizvane.mktcenterserviceimpl.common.report.BaseUrl;
import com.bizvane.mktcenterserviceimpl.common.utils.FigureUtil;
import com.bizvane.mktcenterserviceimpl.mappers.FileReportTempPOMapper;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
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
@RequestMapping("report")
public class ReportIncomeController {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private  FileReportTempPOMapper fileReportTempPOMapper;
	
	@Autowired
	private  ReportTempService reportTempService;
	@Autowired
	private   StoreServiceRpc storeServiceRpc;
	
	@Autowired
	private   CompanyServiceRpc companyServiceRpc;
	
	@Autowired
	private    StoreGroupServiceRpc storeGroupServiceRpc;

	@Autowired
	private BaseUrl BaseUrl;
    
// 收入01- 收入总表
   @RequestMapping("incomeTotalList")
   public ResponseData<List<BackData>> incomeTotalListGroup( IncomeTotalList sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("incomeTotalList").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
	     
   	 return sendpost(BaseUrl.getLoadUrl("incomeTotalList"),sendVO,FileReportTempPOlist,sysAccountPO);
   }
   
// 请求放回数据
 public ResponseData<List<BackData>> sendpost(String url,Object vipIncomeAnalysis,List<FileReportTempPO> fileReportTempPOlist,SysAccountPO currentUser){
           log.info("报表查询ReportIncomeController："+url+vipIncomeAnalysis.toString());
	    	 JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(vipIncomeAnalysis));
	    	 
	    	   //如果是导出，或者群主，就修改查询条数（因为大数据那边不知道有多少条数据）
	    	    String postTem = jsonObject.getString("postTem");
	    	    String dimension = jsonObject.getString("dimension");
	    		 if(StringUtils.isNotBlank(postTem)&&postTem.equals("export")||dimension.equals("3")){
	    		  jsonObject.put("startRecord", 1); // 直接put相同的key
	    		  jsonObject.put("queryNum", 1048576); // / xlsx最大行1048576
	    		 }
	    		 
	    		 //组织转换
		    	    String organizationContentStr = jsonObject.getString("organizationContentStr");
		    	   
		    		 if(StringUtils.isNotBlank(organizationContentStr)){
		    		
		    		 int i=0;
		             for( String trLong : organizationContentStr.split(",")) {
		            	 i++;
		             }
		             String[] al= new String[i];
		             i=0;
		             for( String trLong : organizationContentStr.split(",")) {
		            	 al[i++] = trLong;
		             }
		    		 
		    		  jsonObject.put("organizationContent", al); // 直接put相同的key
		    		 }
		    		 
		    		 //默认页 sendVO.setCorpId("C10291");
		    	   		ResponseData<SysCompanyPo>   SysCompanyP=	companyServiceRpc.getCompanyById(currentUser.getSysCompanyId());
		    	   	    jsonObject.put("corpId", SysCompanyP.getData().getCompanyCode()); 
		    		 
		    		 String organization = jsonObject.getString("organization");
		    		         if(organization.equals("0")) {
		    		             //获取当前用户，所有店铺id
		    		        	 String[] str = new String[]{};
		    		        	 try {
			    		        	 SysStoreVo staffVo =new SysStoreVo();
			    		             staffVo.setSysCompanyId(currentUser.getSysCompanyId());
			    		             staffVo.setSysBrandId(currentUser.getBrandId());
			    		             staffVo.setSysAccountId(currentUser.getSysAccountId());
			    		             
			    		             ResponseData<com.github.pagehelper.PageInfo<SysStoreVo>> SysStoreVo = storeServiceRpc.getSysStoreList(staffVo);
			    		             
			    		             staffVo.setPageSize(Integer.parseInt(String.valueOf(SysStoreVo.getData().getTotal())));
			    		             ResponseData<com.github.pagehelper.PageInfo<com.bizvane.centerstageservice.models.vo.SysStoreVo>> SysStoreVo2 = storeServiceRpc.getSysStoreList(staffVo);
			    		             str = new String[SysStoreVo2.getData().getList().size()];
			    		            int i=0;
			    		             for( SysStoreVo sysStore : SysStoreVo2.getData().getList()) {
			    		            	 str[i++] = sysStore.getStoreId();
			    		             }
							     } catch (Exception e) {
										System.out.println("获取当前用户，所有店铺id出错");
			    				    	 ResponseData<List<BackData>> ResponseData =new ResponseData<List<BackData>>();
				    				       ResponseData.setCode(0);
				    					   ResponseData.setMessage("获取当前用户，所有店铺id出错"+e.toString());
				    					   return ResponseData;
									}
		    		        	 System.out.println("当前用户"+JSONObject.toJSONString(currentUser));
		    		        	 jsonObject.put("organization", "1"); // 直接put相同的key
		    		        	 jsonObject.put("organizationContent", str); // / 
		    		         }else if(organization.equals("3")) {
		       		        	 
		       		        	 try {

		    		//   		        	 选择群主
		    		   		      	if(StringUtils.isNotBlank(organizationContentStr)){
		    		//   		      	根据群组id列表查询群组下所有的店铺
		    			   		        List<Long> storeGroupIds=new ArrayList<Long>();
		    			   	             for( String trLong : organizationContentStr.split(",")) {
		    			   	            	storeGroupIds.add(Long.parseLong(trLong));
		    				             }
		    			   	          ResponseData<List<Long>> getStoreIdsByGroupIds = storeGroupServiceRpc.getStoreIdsByGroupIds(storeGroupIds);
		    			   	         jsonObject.put("organization", "1"); // 直接put相同的key
		    			   	         jsonObject.put("dimension", "1"); // 直接put相同的key
		    			   	          if(getStoreIdsByGroupIds.getData()!=null) {
		    		//   		      	根据群组id列表查询群组下所有的店铺
			    			   	          ResponseData<List<SysStorePo>>getStoreIds= storeServiceRpc.getIdStoreLists(getStoreIdsByGroupIds.getData());
			    			   	          String[] str = new String[getStoreIds.getData().size()];
			    				             int i=0;
			    				             for( SysStorePo sysStore : getStoreIds.getData()) {
			    				            	 str[i++] = sysStore.getStoreId();
			    				             }
			    		   		        	 jsonObject.put("organization", "1"); // 直接put相同的key
			    		   		        	 jsonObject.put("organizationContent", str); // / 
			    		   		      	} 
		    			   	          
		    		   		      	}
		     					} catch (Exception e) {
		    				    	 log.info("获取当前群主，所有店铺id出错");
		    				    	 ResponseData<List<BackData>> ResponseData =new ResponseData<List<BackData>>();
		    				       ResponseData.setCode(0);
		    					   ResponseData.setMessage("获取当前群主，所有店铺id出错"+e.toString());
		    					   return ResponseData;
		    					}
		       		        	 
		       		         }
		    		       //默认页     
		    		         
		 //用户key
		   jsonObject.put("businessNum", BaseUrl.getBusinessNum());
		   jsonObject.put("apiKey", BaseUrl.getApiKey());
		 log.info("综合报表查询发送内容:ReportIncomeController："+url+jsonObject.toString());
		 ResponseEntity<String> response = this.restTemplate.postForEntity(url, jsonObject,String.class, new Object[0]);
	     ResponseData<List<BackData>> ResponseData =new ResponseData<List<BackData>>();
	     JSONObject job = JSONObject.parseObject(response.getBody());

	     //转换群主名称   	 
	     
	     if(job.get("successFlag").equals("1")) {
		     String jsonStr= job.get("data").toString();
		     
		     //计算翻会店铺数据，技术群主数据
		     if(organization.equals("3")) {
		     try {
		    	 //隐藏平均折扣，复购率
		    	 FileReportTempPO fileReportTemp =fileReportTempPOlist.get(0);
		    	 
		    	String setReportData="";
		    	for( String trLong : fileReportTempPOlist.get(0).getReportData().split(",")) {
		    		boolean status = trLong.contains("平均折扣");
		    		boolean statusf = trLong.contains("复购率");
		    		if(!status){
		    			if(!statusf){
		    				if(setReportData.equals("")) {
		    					setReportData=trLong+",";
		    				}else {
		    					setReportData=setReportData+trLong+",";
		    				}
		    				
		    			}
		    		}
		    	 }
		    	 fileReportTemp.setReportData(setReportData);
		    	 fileReportTemp.setReportDataName(fileReportTempPOlist.get(0).getReportDataName().replaceAll("averageDiscount,", "").replaceAll("complexPurchaseRate,", ""));
		    	 fileReportTempPOlist=new ArrayList<FileReportTempPO>();
		    	 fileReportTempPOlist.add(fileReportTemp);
		    	 
                   // 找到店铺对应群主信息
	    		  List<Long> storeGroupIds =new ArrayList<>();
	    		
   	             for( String trLong : organizationContentStr.split(",")) {
   	            	storeGroupIds.add(Long.valueOf(trLong));
	             }
   	            ResponseData<Map<String,SysStoreGroupPo>> getStoreIdLis =	 storeGroupServiceRpc.getStoreIdListByGroupIds(storeGroupIds);
   	            Map<String,SysStoreGroupPo> sysStoreGroupmap=   getStoreIdLis.getData();
   	            if(getStoreIdLis.getData()==null) {
   	              ResponseData.setCode(0);
    		  	  ResponseData.setMessage("群主接口返回空店铺！"+organizationContentStr);
    		  	  ResponseData.setData(FigureUtil.parseJSON2Map("false",dimension,0,fileReportTempPOlist));
    		  	  return ResponseData;
   	           }
   		 
   	          
		    	       //获取所有店铺数据数据
   	                     log.info("店铺数据"+jsonStr);
						JSONArray arr=new JSONArray(jsonStr);
						//计算出群主数据
						org.codehaus.jettison.json.JSONObject jsongroup =new org.codehaus.jettison.json.JSONObject();
						    	  for(int i=0;i<arr.length();i++){
		
						    		  org.codehaus.jettison.json.JSONObject jsonObjtarr=  arr.getJSONObject(i);
				                      //店铺storeCode
						    		  String  storeCode =  jsonObjtarr.get("storeCode").toString();
				                      //更具店铺找群主
						    		  SysStoreGroupPo SysStoreGroupPo= sysStoreGroupmap.get(storeCode);
						    		  if(SysStoreGroupPo!=null) {
						    			  //找到群主数据todo
						    				Iterator<String> itnewjsongro = jsongroup.keys();
						    				org.codehaus.jettison.json.JSONObject jsongro =null;
				    		 				while(itnewjsongro.hasNext()){
				    		 					if(itnewjsongro.next().equals(SysStoreGroupPo.getSysStoreGroupId().toString())) {
				    		 						 jsongro =(org.codehaus.jettison.json.JSONObject) jsongroup.get(SysStoreGroupPo.getSysStoreGroupId().toString());
				    		 					}
				    		 				}
						    			  if(jsongro==null) {
						    				  jsonObjtarr.put("groupCode", SysStoreGroupPo.getSysStoreGroupCode());
						    				  jsonObjtarr.put("groupName", SysStoreGroupPo.getStoreGroupName());
						    				  
						    				//如果是业绩占比，总业绩除占比
					    		 				Iterator<String> it = jsonObjtarr.keys(); 
					    		 				while(it.hasNext()){
						    		 				if(it.next().equals("percentOfAchievements")) {
						    		 					//如果是业绩占比，总业绩除占比
						    		 						BigDecimal achievements= new BigDecimal(jsonObjtarr.get("achievements").toString());
						    		 						achievements=achievements.multiply(new BigDecimal("100"));
						    		 						jsonObjtarr.put("percentOfAchievements", achievements.divide(new BigDecimal(jsonObjtarr.get("percentOfAchievements").toString()),2,BigDecimal.ROUND_HALF_UP));
						    		 				}
					    		 				}
						    				  
						    				  jsongroup.put(SysStoreGroupPo.getSysStoreGroupId().toString(), jsonObjtarr);
						    			  }else {
						    				  // 相加
//						    				  业绩
						    				  String achievementsstr ="";
						    		 			for(String string :fileReportTempPOlist.get(0).getReportDataName().split(",")) {
						    		 				
						    		 				if(string.equals("achievements")) {
							    		 				BigDecimal valueData= new BigDecimal("0");
							    		 				Iterator<String> it = jsonObjtarr.keys(); 
							    		 				while(it.hasNext()){
								    		 				if(it.next().equals(string)) {
								    		 					 achievementsstr =jsonObjtarr.get("achievements").toString();
								    		 					}
								    		 				}
						    		 				}
						    		 				
						    		 			   // 新加
						    		 				BigDecimal valueData= new BigDecimal("0");
						    		 				Iterator<String> it = jsonObjtarr.keys(); 
						    		 				while(it.hasNext()){
							    		 				if(it.next().equals(string)) {
							    		 					//如果是业绩占比，总业绩除占比
							    		 					if(string.equals("percentOfAchievements")) {
							    		 						BigDecimal achievements= new BigDecimal(achievementsstr);
							    		 						achievements=achievements.multiply(new BigDecimal("100"));
							    		 						valueData= achievements.divide(new BigDecimal(jsonObjtarr.get(string).toString()),2,BigDecimal.ROUND_HALF_UP);
							    		 					}else {
							    		 						valueData= valueData.add(new BigDecimal(jsonObjtarr.get(string).toString()));
							    		 					}
							    		 					
							    		 					  break;
							    		 				}
						    		 				}
						    		 			// 累加新数据
						    		 				Iterator<String> itnew = jsongro.keys(); 
						    		 				while(itnew.hasNext()){
							    		 				if(itnew.next().equals(string)) {
							    		 					valueData= valueData.add(new BigDecimal(jsongro.get(string).toString()));
							    		 					 break;
							    		 				}
						    		 				}
						    		 				
						    		 				jsonObjtarr.put(string, valueData);
						    		 			 }
							    				  jsonObjtarr.put("groupCode", SysStoreGroupPo.getSysStoreGroupCode());
							    				  jsonObjtarr.put("groupName", SysStoreGroupPo.getStoreGroupName());
						    		 			//群主数据累加
						    		 			jsongroup.put(SysStoreGroupPo.getSysStoreGroupId().toString(), jsonObjtarr);
						    		 		   }
							    		  
						    		  }else {
						    			  log.info("找不到群主店铺code："+storeCode);
						    		  }
		
						    	  }
						    	  
						  //计算后的结果  	  
                //	现在数据报表是这样算的   件单价=总业绩/件数，客单价=总业绩/笔数，连带率=件数/笔数，平均消费次数=笔数/人数 平均消费次数=笔数/人数     	 ,平均折扣=总业绩/零售总价格, 
				  Iterator<String> itnew = jsongroup.keys(); 
				  JSONArray jsongroupArr=new JSONArray();
			 	   while(itnew.hasNext()){
//			 		  achievements	业绩
//			 		 number	人数
//			 		 pieceNumber	件数
//			 		 penNumber	笔数
//			 		 unitPrice	件单价
//			 		 guestPrice	客单价
//			 		 averageDiscount	平均折扣
//			 		 jointRate	连带率
//			 		 complexPurchaseRate	复购率
//			 		 averageConsumptionTimes	平均消费次数
//			 		 percentOfAchievements	业绩占比
//			 		  业绩占比=*/总业绩，
//			 		  平均折扣，复购率，不要 

			 		  org.codehaus.jettison.json.JSONObject jsongroupnew =(org.codehaus.jettison.json.JSONObject) jsongroup.get(itnew.next());
			 		  
		 				Iterator<String> itnewjsongroupnew = jsongroupnew.keys(); 
		 				while(itnewjsongroupnew.hasNext()){
		 					
		 				String itnewjsong =	itnewjsongroupnew.next();

		 		 				if(itnewjsong.equals("unitPrice")) {
		 		 					if(jsongroupnew.getString("pieceNumber").equals("0")) {
		 		 						jsongroupnew.put("unitPrice", 0);//  如果除数是0
		 		 						continue;
		 		 					}
		 					          BigDecimal   achievements   =   new   BigDecimal(jsongroupnew.getString("achievements"));
		 					          achievements=achievements.divide(new BigDecimal(jsongroupnew.getString("pieceNumber")),2,BigDecimal.ROUND_HALF_UP);
		 					 		  jsongroupnew.put("unitPrice", achievements.toString());// 件单价=总业绩/件数
		 					 		continue;
		 		 				}
 		 				        
		 		 				if(itnewjsong.equals("guestPrice")) {
		 		 					if(jsongroupnew.getString("penNumber").equals("0")) {
		 		 						jsongroupnew.put("guestPrice", 0);//  如果除数是0
		 		 						continue;
		 		 					}
		 					          BigDecimal   achievements   =   new   BigDecimal(jsongroupnew.getString("pieceNumber"));
		 					          achievements=achievements.divide(new BigDecimal(jsongroupnew.getString("penNumber")),2,BigDecimal.ROUND_HALF_UP);
		 					 		  jsongroupnew.put("guestPrice", achievements.toString());// 客单价=总业绩/笔数
		 					 		continue;
		 		 				}
		 		 				
		 		 				if(itnewjsong.equals("jointRate")) {
		 		 					if(jsongroupnew.getString("penNumber").equals("0")) {
		 		 						jsongroupnew.put("jointRate", 0);//  如果除数是0
		 		 						continue;
		 		 					}
		 					          BigDecimal   achievements   =   new   BigDecimal(jsongroupnew.getString("achievements"));
		 					          achievements=achievements.divide(new BigDecimal(jsongroupnew.getString("penNumber")),2,BigDecimal.ROUND_HALF_UP);
		 					 		  jsongroupnew.put("jointRate", achievements.toString());// 连带率=件数/笔数，
		 					 		continue;
		 		 				}
		 		 				
		 		 				if(itnewjsong.equals("averageConsumptionTimes")) {
		 		 					if(jsongroupnew.getString("number").equals("0")) {
		 		 						jsongroupnew.put("averageConsumptionTimes", 0);//  如果除数是0
		 		 						continue;
		 		 					}
		 					          BigDecimal   achievements   =   new   BigDecimal(jsongroupnew.getString("penNumber"));
		 					          achievements=achievements.divide(new BigDecimal(jsongroupnew.getString("number")),2,BigDecimal.ROUND_HALF_UP);
		 					 		  jsongroupnew.put("averageConsumptionTimes", achievements.toString());//  平均消费次数=笔数/人数,
		 		 				}
		 		 				
		 		 				if(itnewjsong.equals("percentOfAchievements")) {
		 		 					if(jsongroupnew.getString("percentOfAchievements").equals("0")) {
		 		 						jsongroupnew.put("percentOfAchievements", 0);//  如果除数是0
		 		 						continue;
		 		 					}
		 					          BigDecimal   achievements   =   new   BigDecimal(jsongroupnew.getString("achievements"));
		 					          achievements=achievements.divide(new BigDecimal(jsongroupnew.getString("percentOfAchievements")),4,BigDecimal.ROUND_HALF_UP);
		 					 		  jsongroupnew.put("percentOfAchievements", achievements.multiply(new BigDecimal(100)));//  平均消费次数=笔数/人数,
		 		 				}
		 		 				
		 		 				
		 		 				
 		 				
		 				}
			 		  
			 		  jsongroupArr.put(jsongroupnew);
			 		}
		    		 	   
				log.info("计算群主数据"+jsongroupArr);
//				jsonStr= jsongroupArr.toString();    	  

				} catch (JSONException e) {
					 log.info("技术群主数据出错："+e.getMessage());
					e.printStackTrace();
				}
		     
		     }
		     
			     //转换群主名称     
			     if(organization.equals("0")||organization.equals("1")) {
			    	 JSONArray havegroupIdarr=new JSONArray();
			      try {
			    	  JSONArray arr=new JSONArray(job.get("data").toString());
			    	 
			    	  for(int i=0;i<arr.length();i++){
			    		  org.codehaus.jettison.json.JSONObject jsonObjtarr=  arr.getJSONObject(i);
	                      //店铺id
			    		  String  storeCode =  jsonObjtarr.get("storeCode").toString();
			    		//根据storeCode找店铺名称
			    		  
	                      //更具店铺id找群主名称
			    		  List<String> storellist =new ArrayList<>();
			    		  storellist.add(storeCode);
			    		  SysStoreVo sysStoreVo =new SysStoreVo();
			    		  sysStoreVo.setStoreCodes(storellist);
			    		  sysStoreVo.setSysCompanyId(currentUser.getSysCompanyId());
			    		  ResponseData<Map<String,String>> getStore	=  storeServiceRpc.getStoreGroupNameByStoreCodes(sysStoreVo);
			    		  if(getStore.getData().get(storeCode)==null) {
			    			  jsonObjtarr.put("groupId", "");
			    		  }else {
			    			  jsonObjtarr.put("groupId", getStore.getData().get(storeCode));
			    		  }
			    		  
			    		  //找店铺名
			    	     com.bizvane.utils.responseinfo.ResponseData<String> storeCodename = storeServiceRpc.getStoreNameByCode(storeCode);
			    	      
			    		  jsonObjtarr.put("storeName", storeCodename.getData());
			    		  
			    		  havegroupIdarr.put(jsonObjtarr);
			    		  
			    		  
			    		  
			    	  }
						
			    	  jsonStr=havegroupIdarr.toString();
					} catch (JSONException e) {
						log.info("群主需要转换，出错");
						e.printStackTrace();
					}
			     }
			   //转换群主名称     
			     
			     
	             // 导出表格
		    	 if(StringUtils.isNotBlank(postTem)&&postTem.equals("export")){
		    		 
		    		 //表头字段
		    		 FileReportTempPO fileReportTempPO=fileReportTempPOlist.get(0);
		    		 
					 if(dimension.equals("0")) {
						 fileReportTempPO.setReportDataName("storeId,"+fileReportTempPO.getReportDataName());
						 fileReportTempPO.setReportData("所属店铺,"+fileReportTempPO.getReportData());
						 
						 fileReportTempPO.setReportDataName("empName,"+fileReportTempPO.getReportDataName());
						 fileReportTempPO.setReportData("员工姓名,"+fileReportTempPO.getReportData());
						 
						 fileReportTempPO.setReportDataName("empCode,"+fileReportTempPO.getReportDataName());
						 fileReportTempPO.setReportData("员工编号,"+fileReportTempPO.getReportData());

					 }else if(dimension.equals("1")) {
						 fileReportTempPO.setReportDataName("groupId,"+fileReportTempPO.getReportDataName());
						 fileReportTempPO.setReportData("所属群组,"+fileReportTempPO.getReportData());
						 
						 fileReportTempPO.setReportDataName("storeName,"+fileReportTempPO.getReportDataName());
						 fileReportTempPO.setReportData("店铺名称,"+fileReportTempPO.getReportData());
						 
						 fileReportTempPO.setReportDataName("storeCode,"+fileReportTempPO.getReportDataName());
						 fileReportTempPO.setReportData("店铺编号,"+fileReportTempPO.getReportData());
						 
					 }else if(dimension.equals("2")) {
						 
						 fileReportTempPO.setReportDataName("brandCode,"+fileReportTempPO.getReportDataName());
						 fileReportTempPO.setReportData("品牌编号,"+fileReportTempPO.getReportData());
						 
						 fileReportTempPO.setReportDataName("brandName,"+fileReportTempPO.getReportDataName());
						 fileReportTempPO.setReportData("品牌名称,"+fileReportTempPO.getReportData());
						 
					 }else if(dimension.equals("3")) {
						 fileReportTempPO.setReportDataName("groupName,"+fileReportTempPO.getReportDataName());
						 fileReportTempPO.setReportData("群组名称,"+fileReportTempPO.getReportData());
						 fileReportTempPO.setReportDataName("groupCode,"+fileReportTempPO.getReportDataName());
						 fileReportTempPO.setReportData("群组编号,"+fileReportTempPO.getReportData());
					 }
		    		 
		    		 reportTempService.Export(currentUser,"_summary",jsonStr, fileReportTempPO);
		    		 ResponseData.setMessage("导出中");
		    	 }else {
		    		 ResponseData.setMessage(job.get("message").toString());
			    }
		    	 // 导出表格end
		    	 
                    //	 查询条数，为了实现获取末页
		    	 int tiaoshu=100;
			     try {
			    	 //这里多查询一次 ，只为了获取中条数，为了分页
			    	 //查询总条数
		    		  jsonObject.put("startRecord", 1); // 直接put相同的key
		    		  jsonObject.put("queryNum", 1048576); // / xlsx最大行1048576
		 			 //用户key
			   		   jsonObject.put("businessNum", BaseUrl.getBusinessNum());
			   		   jsonObject.put("apiKey", BaseUrl.getApiKey());
			   		 //用户key
			   		 log.info("报表查询ReportIncomeController："+url+jsonObject.toString());
					 ResponseEntity<String> responseall = this.restTemplate.postForEntity(url, jsonObject,String.class, new Object[0]);
				     JSONObject jsonall = JSONObject.parseObject(responseall.getBody());
					 JSONArray arr=new JSONArray(jsonall.get("data").toString());
					 tiaoshu=arr.length();
					 
				  } catch (JSONException e) {
					  System.out.println("查询条数报错！");
					}
                     // 查询条数，为了实现获取末页
	
                     //  返回前端数据转换
				     ResponseData.setData(FigureUtil.parseJSON2Map(jsonStr,dimension,tiaoshu,fileReportTempPOlist));
		             ResponseData.setCode(0);

	     }else {
	      ResponseData.setCode(0);
	  	  ResponseData.setMessage(job.get("message").toString());
	  	  ResponseData.setData(FigureUtil.parseJSON2Map("false",dimension,0,fileReportTempPOlist));
	    	 
	     }

     return ResponseData;
 }
 

   
// 收入01- 会销收入表汇总
   @RequestMapping("incomeVip")
   public ResponseData<List<BackData>> incomeVip( IncomeVip sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("incomeVip").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
   	 return sendpost(BaseUrl.getLoadUrl("incomeVip"),sendVO,FileReportTempPOlist,sysAccountPO);
   }
   

   
// 收入01- 游客收入表汇总
   @RequestMapping("touristIncome")
   public ResponseData<List<BackData>> touristIncome( TouristIncome sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("touristIncome").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
   	 return sendpost(BaseUrl.getLoadUrl("touristIncome"),sendVO,FileReportTempPOlist,sysAccountPO);
   }
   
// 02渠道-线上会销收入表汇总
   @RequestMapping("onlineVipIncome")
   public ResponseData<List<BackData>> onlineVipIncome( OnlineVipIncome sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("onlineVipIncome").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
   	 return sendpost(BaseUrl.getLoadUrl("onlineVipIncome"),sendVO,FileReportTempPOlist,sysAccountPO);
   }
   
// 02渠道-线下
   @RequestMapping("offlineVipIncome")
   public ResponseData<List<BackData>> offlineVipIncome( OfflineVipIncome sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("offlineVipIncome").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
   	 return sendpost(BaseUrl.getLoadUrl("offlineVipIncome"),sendVO,FileReportTempPOlist,sysAccountPO);
   }
   
// 03开绑卡分析-开卡
//   @RequestMapping("offlineVipIncome")
//   public ResponseData<List<BackData>> offlineVipIncome(OfflineVipIncome sendVO, HttpServletRequest request){
//	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
//   	 return sendpost(BaseUrl.getLoadUrl("offlineVipIncome"),sendVO,FileReportTempPOlist,sysAccountPO);
//   }
   
// 03开绑卡分析-绑卡
// @RequestMapping("offlineVipIncome")
// public ResponseData<List<BackData>> offlineVipIncome(OfflineVipIncome sendVO, HttpServletRequest request){
//	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
// 	 return sendpost(BaseUrl.getLoadUrl("offlineVipIncome"),sendVO,FileReportTempPOlist,sysAccountPO);
// }
   
// 04会员数量
   @RequestMapping("vipNum")
   public ResponseData<List<BackData>> vipNum( VipNum sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("vipNum").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
   	 return sendpost(BaseUrl.getLoadUrl("vipNum"),sendVO,FileReportTempPOlist,sysAccountPO);
   }
   
// 05新增会员-新增会员收入
   @RequestMapping("increaseVip")
   public ResponseData<List<BackData>> increaseVip( IncreaseVip sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("increaseVip").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
   	 return sendpost(BaseUrl.getLoadUrl("increaseVip"),sendVO,FileReportTempPOlist,sysAccountPO);
   }
// 05新增会员-新增会员数量
   @RequestMapping("increaseVipNum")
   public ResponseData<List<BackData>> increaseVipNum( IncreaseVipNum sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("increaseVipNum").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
   	 return sendpost(BaseUrl.getLoadUrl("increaseVipNum"),sendVO,FileReportTempPOlist,sysAccountPO);
   }
   
// 06会员卡分析-类型1
//   @RequestMapping("increaseVipNum")
//   public ResponseData<List<BackData>> increaseVipNum(IncreaseVipNum sendVO, HttpServletRequest request){
//	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
//   	 return sendpost(BaseUrl.getLoadUrl("increaseVipNum"),sendVO,FileReportTempPOlist,sysAccountPO);
//   }
// 06会员卡分析-类型2
// @RequestMapping("increaseVipNum")
// public ResponseData<List<BackData>> increaseVipNum(IncreaseVipNum sendVO, HttpServletRequest request){
//	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
// 	 return sendpost(BaseUrl.getLoadUrl("increaseVipNum"),sendVO,FileReportTempPOlist,sysAccountPO);
// }
   
// 07新老会员分析-新会员
   @RequestMapping("newOldMemberInterface")
   public ResponseData<List<BackData>> newOldMemberInterface( NewOldMemberInterface sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("newOldMemberInterface").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
//	     TODO
	     sendVO.setNewVipCycle("40");
   	 return sendpost(BaseUrl.getLoadUrl("newOldMemberInterface"),sendVO,FileReportTempPOlist,sysAccountPO);
   }
   
// 08活跃会员表汇总
   @RequestMapping("activeMemberAllInterface")
   public ResponseData<List<BackData>> activeMemberAllInterface( ActiveMemberAllInterface sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("activeMemberAllInterface").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
//	     TODO
	     sendVO.setActiveCycle("180");
   	 return sendpost(BaseUrl.getLoadUrl("activeMemberAllInterface"),sendVO,FileReportTempPOlist,sysAccountPO);
   }
   
// 09复购-会员表汇总
   @RequestMapping("rePurchaseMemberAllInterface")
   public ResponseData<List<BackData>> rePurchaseMemberAllInterface( RePurchaseMemberAllInterface sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("rePurchaseMemberAllInterface").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
   	 return sendpost(BaseUrl.getLoadUrl("rePurchaseMemberAllInterface"),sendVO,FileReportTempPOlist,sysAccountPO);
   }
   
// 10回购-会员表汇总
//   @RequestMapping("activeMemberAllInterface")
//   public ResponseData<List<BackData>> activeMemberAllInterface(ActiveMemberAllInterface sendVO, HttpServletRequest request){
//	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
//   	 return sendpost(BaseUrl.getLoadUrl("activeMemberAllInterface"),sendVO,FileReportTempPOlist,sysAccountPO);
//   }
   
   
   
// 收入01- 性别表汇总
   @RequestMapping("gender")
   public ResponseData<List<BackData>> gender( IncomeTotalList sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("gender").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
	     
   	 return sendpost(BaseUrl.getLoadUrl("gender"),sendVO,FileReportTempPOlist,sysAccountPO);
   }
   
// 收入01- 年龄分析
   @RequestMapping("ageAnalysis")
   public ResponseData<List<BackData>> ageAnalysis( IncomeTotalList sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("ageAnalysis").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
	     
   	 return sendpost(BaseUrl.getLoadUrl("ageAnalysis"),sendVO,FileReportTempPOlist,sysAccountPO);
   }
   
   
////收入01- 生日分析
// @RequestMapping("gender")
// public ResponseData<List<BackData>> gender( IncomeTotalList sendVO, HttpServletRequest request){
//	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
//	     FileReportTempPOExample example = new FileReportTempPOExample();
//	     example.createCriteria().andTemplateTypeEqualTo("gender").andValidEqualTo(Boolean.TRUE);
//	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
//	     
// 	 return sendpost(BaseUrl.getLoadUrl("gender"),sendVO,FileReportTempPOlist,sysAccountPO);
// }

   
////收入01- 线上渠道分析
//@RequestMapping("gender")
//public ResponseData<List<BackData>> gender( IncomeTotalList sendVO, HttpServletRequest request){
//	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
//	     FileReportTempPOExample example = new FileReportTempPOExample();
//	     example.createCriteria().andTemplateTypeEqualTo("gender").andValidEqualTo(Boolean.TRUE);
//	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
//	     
//	 return sendpost(BaseUrl.getLoadUrl("gender"),sendVO,FileReportTempPOlist,sysAccountPO);
//}

   
   

   

   

    
  
 


}
