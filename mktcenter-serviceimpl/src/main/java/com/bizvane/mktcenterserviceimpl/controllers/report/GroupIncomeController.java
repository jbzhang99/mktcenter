package com.bizvane.mktcenterserviceimpl.controllers.report;

import java.util.List;

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
import com.bizvane.mktcenterservice.interfaces.ReportTempService;
import com.bizvane.mktcenterservice.models.po.FileReportTempPO;
import com.bizvane.mktcenterservice.models.po.FileReportTempPOExample;
import com.bizvane.mktcenterservice.models.requestvo.BackData;
import com.bizvane.mktcenterservice.models.requestvo.BackDataTime;
import com.bizvane.mktcenterservice.models.requestvo.postvo.IncomeTotalListGroup;
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
//@Slf4j
//@RestController
//@RequestMapping("Groupreport")
//public class GroupIncomeController {
//	@Autowired
//	private RestTemplate restTemplate;
//	@Autowired
//	private  FileReportTempPOMapper fileReportTempPOMapper;
//	
//	@Autowired
//	private  ReportTempService reportTempService;
//
//	@Autowired
//	private BaseUrl BaseUrl;
//    
//
//    
//// 收入01- 收入总表
//   @RequestMapping("incomeTotalListGroup")
//   public ResponseData<List<BackData>> incomeTotalListGroup( IncomeTotalListGroup sendVO, HttpServletRequest request){
//	   sendVO.setCorpId("C10153");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
//	     FileReportTempPOExample example = new FileReportTempPOExample();
//	     example.createCriteria().andTemplateTypeEqualTo("incomeTotalListGroup").andValidEqualTo(Boolean.TRUE);
//	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
//	     
//   	 return sendpost(BaseUrl.getLoadUrl("incomeTotalListGroup"),sendVO,FileReportTempPOlist,sysAccountPO);
//   }
//   
//// 请求放回数据
// public ResponseData<List<BackData>> sendpost(String url,Object vipIncomeAnalysis,List<FileReportTempPO> fileReportTempPOlist,SysAccountPO sysAccountPO){
//           log.info("报表查询ReportIncomeController："+url+vipIncomeAnalysis.toString());
//	    	 JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(vipIncomeAnalysis));
//	    	 
//	    	   //如果是导出，就修改查询条数
//	    	    String postTem = jsonObject.getString("postTem");
//	    		 if(StringUtils.isNotBlank(postTem)&&postTem.equals("export")){
//	    		  jsonObject.put("startRecord", 1); // 直接put相同的key
//	    		  jsonObject.put("queryNum", 1048576); // / xlsx最大行1048576
//	    		 }
//	    		 
//	    		 //组织转换
//	    		 
//		    	    String organizationContentStr = jsonObject.getString("organizationContentStr");
//		    		 if(StringUtils.isNotBlank(organizationContentStr)){
////		    			 ["12","33","56"]
//		    		 String[] al= organizationContentStr.toString().split(",");
//		    		  jsonObject.put("organizationContent", al); // 直接put相同的key
//		    		 }
//	    	 
//		 ResponseEntity<String> response = this.restTemplate.postForEntity(url, jsonObject,String.class, new Object[0]);
//	     ResponseData<List<BackData>> ResponseData =new ResponseData<List<BackData>>();
//	     JSONObject job = JSONObject.parseObject(response.getBody());
//	     
//	     if(job.get("successFlag").equals("1")) {
//	             // 导出表格
//		    	 if(StringUtils.isNotBlank(postTem)&&postTem.equals("export")){
//		    		 reportTempService.Export(sysAccountPO,"_summary",job.get("data").toString(), fileReportTempPOlist.get(0));
//		    		 ResponseData.setMessage("导出中");
//		    	 }else {
//		    		 ResponseData.setMessage(job.get("message").toString());
//			    }
//		    	 // 导出表格end
//		    	 
////		    	 查询条数
//		    	 int tiaoshu=100;
//			     try {
//			    	 //查询总条数
//		    		  jsonObject.put("startRecord", 1); // 直接put相同的key
//		    		  jsonObject.put("queryNum", 1048576); // / xlsx最大行1048576
//					  ResponseEntity<String> responseall = this.restTemplate.postForEntity(url, jsonObject,String.class, new Object[0]);
//				     JSONObject jsonall = JSONObject.parseObject(responseall.getBody());
//					 JSONArray arr=new JSONArray(jsonall.get("data").toString());
//					 tiaoshu=arr.length();
//				  } catch (JSONException e) {
//					  System.out.println("查询条数报错！");
//					}
//			     
//			     ResponseData.setData(FigureUtil.parseJSON2Map(job.get("data").toString(),tiaoshu,fileReportTempPOlist));
//	             ResponseData.setCode(0);
//	  	     
//
//	     }else {
//	      ResponseData.setCode(0);
//	  	  ResponseData.setMessage(job.get("message").toString());
//	  	  ResponseData.setData(FigureUtil.parseJSON2Map("false",0,fileReportTempPOlist));
//	    	 
//	     }
//
//     return ResponseData;
// }
// 
//
//   
//// 收入01- 会销收入表汇总
//   @RequestMapping("incomeVipGroup")
//   public ResponseData<List<BackData>> incomeVip( IncomeTotalListGroup sendVO, HttpServletRequest request){
//	   sendVO.setCorpId("C10153");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
//	     FileReportTempPOExample example = new FileReportTempPOExample();
//	     example.createCriteria().andTemplateTypeEqualTo("incomeVipGroup").andValidEqualTo(Boolean.TRUE);
//	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
//   	 return sendpost(BaseUrl.getLoadUrl("incomeVipGroup"),sendVO,FileReportTempPOlist,sysAccountPO);
//   }
//   
//
//   
//// 收入01- 游客收入表汇总
//   @RequestMapping("touristIncomeGroup")
//   public ResponseData<List<BackData>> touristIncome( IncomeTotalListGroup sendVO, HttpServletRequest request){
//	   sendVO.setCorpId("C10153");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
//	     FileReportTempPOExample example = new FileReportTempPOExample();
//	     example.createCriteria().andTemplateTypeEqualTo("touristIncomeGroup").andValidEqualTo(Boolean.TRUE);
//	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
//   	 return sendpost(BaseUrl.getLoadUrl("touristIncomeGroup"),sendVO,FileReportTempPOlist,sysAccountPO);
//   }
//   
//// 02渠道-线上会销收入表汇总
//   @RequestMapping("onlineVipIncomeGroup")
//   public ResponseData<List<BackData>> onlineVipIncome( IncomeTotalListGroup sendVO, HttpServletRequest request){
//	   sendVO.setCorpId("C10153");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
//	     FileReportTempPOExample example = new FileReportTempPOExample();
//	     example.createCriteria().andTemplateTypeEqualTo("onlineVipIncomeGroup").andValidEqualTo(Boolean.TRUE);
//	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
//   	 return sendpost(BaseUrl.getLoadUrl("onlineVipIncomeGroup"),sendVO,FileReportTempPOlist,sysAccountPO);
//   }
//   
//// 02渠道-线下
//   @RequestMapping("offlineVipIncomeGroup")
//   public ResponseData<List<BackData>> offlineVipIncome( IncomeTotalListGroup sendVO, HttpServletRequest request){
//	   sendVO.setCorpId("C10153");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
//	     FileReportTempPOExample example = new FileReportTempPOExample();
//	     example.createCriteria().andTemplateTypeEqualTo("offlineVipIncomeGroup").andValidEqualTo(Boolean.TRUE);
//	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
//   	 return sendpost(BaseUrl.getLoadUrl("offlineVipIncomeGroup"),sendVO,FileReportTempPOlist,sysAccountPO);
//   }
//   
//// 03开绑卡分析-开卡
////   @RequestMapping("offlineVipIncome")
////   public ResponseData<List<BackData>> offlineVipIncome(OfflineVipIncome sendVO, HttpServletRequest request){
////	   sendVO.setCorpId("C10153");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
////   	 return sendpost(BaseUrl.getLoadUrl("offlineVipIncome"),sendVO,FileReportTempPOlist,sysAccountPO);
////   }
//   
//// 03开绑卡分析-绑卡
//// @RequestMapping("offlineVipIncome")
//// public ResponseData<List<BackData>> offlineVipIncome(OfflineVipIncome sendVO, HttpServletRequest request){
////	   sendVO.setCorpId("C10153");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
//// 	 return sendpost(BaseUrl.getLoadUrl("offlineVipIncome"),sendVO,FileReportTempPOlist,sysAccountPO);
//// }
//   
//// 04会员数量
//   @RequestMapping("vipNumGroup")
//   public ResponseData<List<BackData>> vipNum( IncomeTotalListGroup sendVO, HttpServletRequest request){
//	   sendVO.setCorpId("C10153");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
//	     FileReportTempPOExample example = new FileReportTempPOExample();
//	     example.createCriteria().andTemplateTypeEqualTo("vipNumGroup").andValidEqualTo(Boolean.TRUE);
//	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
//   	 return sendpost(BaseUrl.getLoadUrl("vipNumGroup"),sendVO,FileReportTempPOlist,sysAccountPO);
//   }
//   
//// 05新增会员-新增会员收入
//   @RequestMapping("increaseVipGroup")
//   public ResponseData<List<BackData>> increaseVip( IncomeTotalListGroup sendVO, HttpServletRequest request){
//	   sendVO.setCorpId("C10153");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
//	     FileReportTempPOExample example = new FileReportTempPOExample();
//	     example.createCriteria().andTemplateTypeEqualTo("increaseVipGroup").andValidEqualTo(Boolean.TRUE);
//	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
//   	 return sendpost(BaseUrl.getLoadUrl("increaseVipGroup"),sendVO,FileReportTempPOlist,sysAccountPO);
//   }
//// 05新增会员-新增会员数量
//   @RequestMapping("increaseVipNumGroup")
//   public ResponseData<List<BackData>> increaseVipNum( IncomeTotalListGroup sendVO, HttpServletRequest request){
//	   sendVO.setCorpId("C10153");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
//	     FileReportTempPOExample example = new FileReportTempPOExample();
//	     example.createCriteria().andTemplateTypeEqualTo("increaseVipNumGroup").andValidEqualTo(Boolean.TRUE);
//	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
//   	 return sendpost(BaseUrl.getLoadUrl("increaseVipNumGroup"),sendVO,FileReportTempPOlist,sysAccountPO);
//   }
//   
//// 06会员卡分析-类型1
////   @RequestMapping("increaseVipNum")
////   public ResponseData<List<BackData>> increaseVipNum(IncreaseVipNum sendVO, HttpServletRequest request){
////	   sendVO.setCorpId("C10153");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
////   	 return sendpost(BaseUrl.getLoadUrl("increaseVipNum"),sendVO,FileReportTempPOlist,sysAccountPO);
////   }
//// 06会员卡分析-类型2
//// @RequestMapping("increaseVipNum")
//// public ResponseData<List<BackData>> increaseVipNum(IncreaseVipNum sendVO, HttpServletRequest request){
////	   sendVO.setCorpId("C10153");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
//// 	 return sendpost(BaseUrl.getLoadUrl("increaseVipNum"),sendVO,FileReportTempPOlist,sysAccountPO);
//// }
//   
//// 07新老会员分析-新会员
//   @RequestMapping("newOldMemberInterfaceGroup")
//   public ResponseData<List<BackData>> newOldMemberInterface( IncomeTotalListGroup sendVO, HttpServletRequest request){
//	   sendVO.setCorpId("C10153");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
//	     FileReportTempPOExample example = new FileReportTempPOExample();
//	     example.createCriteria().andTemplateTypeEqualTo("newOldMemberInterfaceGroup").andValidEqualTo(Boolean.TRUE);
//	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
//   	 return sendpost(BaseUrl.getLoadUrl("newOldMemberInterfaceGroup"),sendVO,FileReportTempPOlist,sysAccountPO);
//   }
//   
//// 08活跃会员表汇总
//   @RequestMapping("activeMemberAllInterfaceGroup")
//   public ResponseData<List<BackData>> activeMemberAllInterface( IncomeTotalListGroup sendVO, HttpServletRequest request){
//	   sendVO.setCorpId("C10153");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
//	     FileReportTempPOExample example = new FileReportTempPOExample();
//	     example.createCriteria().andTemplateTypeEqualTo("activeMemberAllInterfaceGroup").andValidEqualTo(Boolean.TRUE);
//	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
//   	 return sendpost(BaseUrl.getLoadUrl("activeMemberAllInterfaceGroup"),sendVO,FileReportTempPOlist,sysAccountPO);
//   }
//   
//// 09复购-会员表汇总
//   @RequestMapping("rePurchaseMemberAllInterfaceGroup")
//   public ResponseData<List<BackData>> rePurchaseMemberAllInterface( IncomeTotalListGroup sendVO, HttpServletRequest request){
//	   sendVO.setCorpId("C10153");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
//	     FileReportTempPOExample example = new FileReportTempPOExample();
//	     example.createCriteria().andTemplateTypeEqualTo("rePurchaseMemberAllInterfaceGroup").andValidEqualTo(Boolean.TRUE);
//	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
//   	 return sendpost(BaseUrl.getLoadUrl("rePurchaseMemberAllInterfaceGroup"),sendVO,FileReportTempPOlist,sysAccountPO);
//   }
//   
//// 10回购-会员表汇总
////   @RequestMapping("activeMemberAllInterface")
////   public ResponseData<List<BackData>> activeMemberAllInterface(ActiveMemberAllInterface sendVO, HttpServletRequest request){
////	   sendVO.setCorpId("C10153");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
////   	 return sendpost(BaseUrl.getLoadUrl("activeMemberAllInterface"),sendVO,FileReportTempPOlist,sysAccountPO);
////   }
//
//   
//   @RequestMapping("genderGroup")
//   public ResponseData<List<BackData>> genderGroup( IncomeTotalListGroup sendVO, HttpServletRequest request){
//	   sendVO.setCorpId("C10153");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
//	     FileReportTempPOExample example = new FileReportTempPOExample();
//	     example.createCriteria().andTemplateTypeEqualTo("genderGroup").andValidEqualTo(Boolean.TRUE);
//	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
//   	 return sendpost(BaseUrl.getLoadUrl("genderGroup"),sendVO,FileReportTempPOlist,sysAccountPO);
//   }
//   
//   @RequestMapping("ageAnalysisGroup")
//   public ResponseData<List<BackData>> ageAnalysisGroup( IncomeTotalListGroup sendVO, HttpServletRequest request){
//	   sendVO.setCorpId("C10153");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
//	     FileReportTempPOExample example = new FileReportTempPOExample();
//	     example.createCriteria().andTemplateTypeEqualTo("ageAnalysisGroup").andValidEqualTo(Boolean.TRUE);
//	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
//   	 return sendpost(BaseUrl.getLoadUrl("ageAnalysisGroup"),sendVO,FileReportTempPOlist,sysAccountPO);
//   }
//
//   
//// 请求放回数据带时间格式的json
// public ResponseData<List<BackDataTime>> sendpostHaveTime(String url,Object vipIncomeAnalysis,List<FileReportTempPO> fileReportTempPOlist){
// log.info("报表查询ReportIncomeController："+url+vipIncomeAnalysis.toString());
//		 ResponseEntity<String> response = this.restTemplate.postForEntity(url, vipIncomeAnalysis,String.class, new Object[0]);
//	     ResponseData<List<BackDataTime>> ResponseData =new ResponseData<List<BackDataTime>>();
//	     JSONObject job = JSONObject.parseObject(response.getBody());
//	     
//	     if(job.get("successFlag").equals("1")) {
//	    	 ResponseData.setCode(0);
//	  	    ResponseData.setMessage(job.get("message").toString());
//		    ResponseData.setData(FigureUtil.parseJSON2MapTime(job.get("data").toString(),fileReportTempPOlist));
//	     }else {
//	    	 ResponseData.setCode(0);
//	  	    ResponseData.setMessage(job.get("message").toString());
//	  	  ResponseData.setData(FigureUtil.parseJSON2MapTime("false",fileReportTempPOlist));
//	    	 
//	     }
//
//     return ResponseData;
// }
//   
//
//    
//  
// 
//
//
//}
