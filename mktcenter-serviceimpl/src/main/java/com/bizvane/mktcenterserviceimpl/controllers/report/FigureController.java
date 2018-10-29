package com.bizvane.mktcenterserviceimpl.controllers.report;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.centerstageservice.models.po.SysCompanyPo;
import com.bizvane.centerstageservice.models.po.SysStorePo;
import com.bizvane.centerstageservice.models.vo.SysStoreVo;
import com.bizvane.centerstageservice.rpc.CompanyServiceRpc;
import com.bizvane.centerstageservice.rpc.StoreGroupServiceRpc;
import com.bizvane.centerstageservice.rpc.StoreServiceRpc;
import com.bizvane.mktcenterservice.interfaces.ReportTempService;
import com.bizvane.mktcenterservice.models.po.FileReportTempPO;
import com.bizvane.mktcenterservice.models.po.FileReportTempPOExample;
import com.bizvane.mktcenterservice.models.requestvo.BackDataTime;
import com.bizvane.mktcenterservice.models.requestvo.BackDataTimeDtail;
import com.bizvane.mktcenterservice.models.requestvo.BackDataTimeDtailtu;
import com.bizvane.mktcenterservice.models.requestvo.postvo.IncomeTotalListGroup;
import com.bizvane.mktcenterserviceimpl.common.report.BaseUrl;
import com.bizvane.mktcenterserviceimpl.common.utils.FigureUtilGroupFigure;
import com.bizvane.mktcenterserviceimpl.mappers.FileReportTempPOMapper;
import com.bizvane.utils.responseinfo.PageInfo;
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
@RequestMapping("figure")
public class FigureController {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private  FileReportTempPOMapper fileReportTempPOMapper;
	
	@Autowired
	private ReportTempService  reportTempService;
	
//	@Autowired
//	private  MemberLifecycleParameterService memberLifecycleParameterService;
	@Autowired
	private BaseUrl BaseUrl; 
	
	@Autowired
	private  StoreServiceRpc storeServiceRpc;
	
	@Autowired
	private   CompanyServiceRpc companyServiceRpc;
	
	@Autowired
	private    StoreGroupServiceRpc storeGroupServiceRpc;

	
    @RequestMapping("vipIncomeAnalysis")
    public ResponseData<BackDataTimeDtail> vipIncomeAnalysis( IncomeTotalListGroup sendVO, HttpServletRequest request){
 	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("vipIncomeAnalysis").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
	     
//	     选择周期后，时间范围无论怎么选，不改变折线图的周期。
		  if(sendVO.getParticleSize()!=null&&sendVO.getCycle()!=null&&sendVO.getCycle().equals("1")) {
					SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
					String minDateStr = "";
					Calendar calc =Calendar.getInstance();
					    calc.setTime(new Date());
					    sendVO.setEndDate(sdf.format(new Date())+" 00:00:00");
			   if(sendVO.getParticleSize().endsWith("1")){
					calc.add(Calendar.DATE, -30);
					SimpleDateFormat sdfdate  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					sendVO.setEndDate(sdfdate.format(new Date()));
			   }else if(sendVO.getParticleSize().endsWith("2")) {
				   calc.add(Calendar.DATE, -210);
			   }else if(sendVO.getParticleSize().endsWith("3")) {
				   calc.add(Calendar.DATE, -365);
			   }else if(sendVO.getParticleSize().endsWith("4")) {
				   calc.add(Calendar.DATE, -2555);
			   }
				Date minDate = calc.getTime();
				minDateStr = sdf.format(minDate);
				sendVO.setStartDate(minDateStr+" 00:00:00");
		  }
	     
 	 return sendpostHaveTime(BaseUrl.getLoadUrl("vipIncomeAnalysis"),sendVO,FileReportTempPOlist,sysAccountPO);
   }

    @RequestMapping("operatingIncomeAnalysis")
    public ResponseData<BackDataTimeDtailtu> operatingIncomeAnalysis( IncomeTotalListGroup sendVO, HttpServletRequest request){
 	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("operatingIncomeAnalysis").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
	     
//	     选择周期后，时间范围无论怎么选，不改变折线图的周期。
		  if(sendVO.getParticleSize()!=null&&sendVO.getCycle()!=null&&sendVO.getCycle().equals("1")) {
					SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
					String minDateStr = "";
					Calendar calc =Calendar.getInstance();
					    calc.setTime(new Date());
					    sendVO.setEndDate(sdf.format(new Date())+" 00:00:00");
			   if(sendVO.getParticleSize().endsWith("1")){
					calc.add(Calendar.DATE, -30);
					SimpleDateFormat sdfdate  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					sendVO.setEndDate(sdfdate.format(new Date()));
			   }else if(sendVO.getParticleSize().endsWith("2")) {
				   calc.add(Calendar.DATE, -210);
			   }else if(sendVO.getParticleSize().endsWith("3")) {
				   calc.add(Calendar.DATE, -365);
			   }else if(sendVO.getParticleSize().endsWith("4")) {
				   calc.add(Calendar.DATE, -2555);
			   }
				Date minDate = calc.getTime();
				minDateStr = sdf.format(minDate);
				sendVO.setStartDate(minDateStr+" 00:00:00");
		  }
		  
 	 return sendpostHaveTimeOpera(BaseUrl.getLoadUrl("operatingIncomeAnalysis"),sendVO,FileReportTempPOlist,sysAccountPO);
   }
    
    



   
// 请求放回数据带时间格式的json
 public ResponseData<BackDataTimeDtail> sendpostHaveTime(String url,IncomeTotalListGroup vipIncomeAnalysis,List<FileReportTempPO> fileReportTempPOlist,SysAccountPO currentUser){
 log.info("报表查询ReportIncomeController："+url+JSONObject.toJSONString(vipIncomeAnalysis).toString());
 
            //TODO 获取活跃度
//			 ResponseData<MemberLifecycleParameterModel> Member =  memberLifecycleParameterService.findMemberLifecycleParameterByBrandId(1L);
//			 vipIncomeAnalysis.setNewVipCycle(Member.getData().getNewMember().toString());  
//			 vipIncomeAnalysis.setActiveCycle(Member.getData().getActiveMember().toString());
			 vipIncomeAnalysis.setActiveCycle("180");//活跃会员
			 vipIncomeAnalysis.setNewVipCycle("40");//新会员
	    	 
    		//组织转换
		    JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(vipIncomeAnalysis));
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
	   		         if(StringUtils.isBlank(organizationContentStr)) {
	   		             //获取当前用户，所有店铺id
	   		        	 String[] str = new String[]{};
	   		        	 try {
				    		        	 SysStoreVo staffVo =new SysStoreVo();
				    		             staffVo.setSysCompanyId(currentUser.getSysCompanyId());
				    		             staffVo.setSysBrandId(currentUser.getBrandId());
				    		             staffVo.setSysAccountId(currentUser.getSysAccountId());
				    		             
				    		             ResponseData<PageInfo<SysStoreVo>> SysStoreVo = storeServiceRpc.getSysStoreList(staffVo);
				    		             
				    		             staffVo.setPageSize(Integer.parseInt(String.valueOf(SysStoreVo.getData().getTotal())));
				    		             ResponseData<PageInfo<SysStoreVo>> SysStoreVo2 = storeServiceRpc.getSysStoreList(staffVo);
				    		             str = new String[SysStoreVo2.getData().getList().size()];
				    		            int i=0;
				    		             for( SysStoreVo sysStore : SysStoreVo2.getData().getList()) {
				    		            	 str[i++] = sysStore.getStoreId();
				    		             }
								} catch (Exception e) {
									 e.printStackTrace();
									log.info("获取当前用户，所有店铺id出错");
									
							    	 ResponseData<BackDataTimeDtail> ResponseData =new ResponseData<BackDataTimeDtail>();
								       ResponseData.setCode(0);
									   ResponseData.setMessage("获取当前用户，所有店铺id出错"+e.toString());
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
	   		      	
	 					} catch (Exception e) {
	 						 e.printStackTrace();
					    	 log.info("获取当前群主，所有店铺id出错");
					    	 ResponseData<BackDataTimeDtail> ResponseData =new ResponseData<BackDataTimeDtail>();
					       ResponseData.setCode(0);
						   ResponseData.setMessage("获取当前群主，所有店铺id出错"+e.toString());
						   return ResponseData;
						}
	   		        	 
	   		         }
	   		       //默认页  
			 //用户key
	   		   jsonObject.put("businessNum", BaseUrl.getBusinessNum());
	   		   jsonObject.put("apiKey", BaseUrl.getApiKey());
	   		 //用户key
	   		log.info("报表查询ReportIncomeController："+url+jsonObject.toString());
		 ResponseEntity<String> response = this.restTemplate.postForEntity(url, jsonObject,String.class, new Object[0]);
	     ResponseData<BackDataTimeDtail> ResponseData =new ResponseData<BackDataTimeDtail>();
	     JSONObject job = JSONObject.parseObject(response.getBody());
	     
	     if(job.get("successFlag").equals("1")) {
	    	 
             // 导出表格
	    	 String postTem = jsonObject.getString("postTem");
	    	 if(StringUtils.isNotBlank(postTem)&&postTem.equals("export")){
	    		 reportTempService.Export(currentUser,"_cycle",job.get("data").toString(),fileReportTempPOlist.get(0));
	    		 ResponseData.setMessage("导出中");
	    	 }else {
	    		 ResponseData.setMessage(job.get("message").toString());
		    }
	    	 
	    	 
	    	ResponseData.setCode(0);
		    ResponseData.setData(FigureUtilGroupFigure.parseJSON2MapTime(job.get("data").toString(),fileReportTempPOlist,vipIncomeAnalysis));
	     }else {
	    	 ResponseData.setCode(0);
	  	    ResponseData.setMessage(job.get("message").toString());
	  	  ResponseData.setData(FigureUtilGroupFigure.parseJSON2MapTime("false",fileReportTempPOlist,vipIncomeAnalysis));
	    	 
	     }

     return ResponseData;
 }
//请求放回数据带时间格式的json
public ResponseData<BackDataTimeDtailtu> sendpostHaveTimeOpera(String url,IncomeTotalListGroup vipIncomeAnalysis,List<FileReportTempPO> fileReportTempPOlist,SysAccountPO currentUser){
log.info("报表查询ReportIncomeController："+url+JSONObject.toJSONString(vipIncomeAnalysis).toString());

          //TODO 获取活跃度
//			 ResponseData<MemberLifecycleParameterModel> Member =  memberLifecycleParameterService.findMemberLifecycleParameterByBrandId(1L);
//			 vipIncomeAnalysis.setNewVipCycle(Member.getData().getNewMember().toString());  
//			 vipIncomeAnalysis.setActiveCycle(Member.getData().getActiveMember().toString());
			 vipIncomeAnalysis.setActiveCycle("180");//活跃会员
			 vipIncomeAnalysis.setNewVipCycle("40");//新会员
	    	 
  		//组织转换
		    JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(vipIncomeAnalysis));
	    	String organizationContentStr = jsonObject.getString("organizationContentStr");
	    	if(StringUtils.isNotBlank(organizationContentStr)){
	    		 String[] al= organizationContentStr.toString().split(",");
	    		  jsonObject.put("organizationContent", al); // 直接put相同的key
	    	}
	    	
   		 //默认页 sendVO.setCorpId("C10291");
	   		ResponseData<SysCompanyPo>   SysCompanyP=	companyServiceRpc.getCompanyById(currentUser.getSysCompanyId());
	   	    jsonObject.put("corpId", SysCompanyP.getData().getCompanyCode()); 
	   		 String organization = jsonObject.getString("organization");
   		         if(StringUtils.isBlank(organizationContentStr)) {
   		             //获取当前用户，所有店铺id
   		        	 String[] str = new String[]{};
   		        	 try {
    		        	 SysStoreVo staffVo =new SysStoreVo();
    		             staffVo.setSysCompanyId(currentUser.getSysCompanyId());
    		             staffVo.setSysBrandId(currentUser.getBrandId());
    		             staffVo.setSysAccountId(currentUser.getSysAccountId());
    		             
    		             ResponseData<PageInfo<SysStoreVo>> SysStoreVo = storeServiceRpc.getSysStoreList(staffVo);
    		             
    		             staffVo.setPageSize(Integer.parseInt(String.valueOf(SysStoreVo.getData().getTotal())));
    		             ResponseData<PageInfo<SysStoreVo>> SysStoreVo2 = storeServiceRpc.getSysStoreList(staffVo);
    		             str = new String[SysStoreVo2.getData().getList().size()];
    		            int i=0;
    		             for( SysStoreVo sysStore : SysStoreVo2.getData().getList()) {
    		            	 str[i++] = sysStore.getStoreId().toString();
    		             }
				        } catch (Exception e) {
				        	 e.printStackTrace();
				        	log.info("获取当前用户，所有店铺id出错");
					    	 ResponseData<BackDataTimeDtail> ResponseData =new ResponseData<BackDataTimeDtail>();
						       ResponseData.setCode(0);
							   ResponseData.setMessage("获取当前用户，所有店铺id出错"+e.toString());
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
   		      	
 					} catch (Exception e) {
 						 e.printStackTrace();
				    	 log.info("获取当前群主，所有店铺id出错");
				    	    ResponseData<BackDataTimeDtailtu> ResponseData =new ResponseData<BackDataTimeDtailtu>();
				       ResponseData.setCode(0);
					   ResponseData.setMessage("获取当前群主，所有店铺id出错"+e.toString());
					   return ResponseData;
					}
   		        	 
   		         }
   		       //默认页  
  	   		   jsonObject.put("businessNum", BaseUrl.getBusinessNum());
  	   		   jsonObject.put("apiKey", BaseUrl.getApiKey());
  	   		log.info("报表查询ReportIncomeController："+url+jsonObject.toString());
		 ResponseEntity<String> response = this.restTemplate.postForEntity(url, jsonObject,String.class, new Object[0]);
	     ResponseData<BackDataTimeDtailtu> ResponseData =new ResponseData<BackDataTimeDtailtu>();
	     JSONObject job = JSONObject.parseObject(response.getBody());
	     
	     if(job.get("successFlag").equals("1")) {
	    	 
           // 导出表格
	    	 String postTem = jsonObject.getString("postTem");
	    	 if(StringUtils.isNotBlank(postTem)&&postTem.equals("export")){
	    		 reportTempService.Export(currentUser,"_cycle",job.get("data").toString(),fileReportTempPOlist.get(0));
	    		 ResponseData.setMessage("导出中");
	    	 }else {
	    		 ResponseData.setMessage(job.get("message").toString());
		    }
	    	 
	    	 
	    	ResponseData.setCode(0);
		    ResponseData.setData(FigureUtilGroupFigure.parseJSON2MapTimeOpera(job.get("data").toString(),fileReportTempPOlist,vipIncomeAnalysis));
	     }else {
	    	 ResponseData.setCode(0);
	  	    ResponseData.setMessage(job.get("message").toString());
	  	  ResponseData.setData(FigureUtilGroupFigure.parseJSON2MapTimeOpera("false",fileReportTempPOlist,vipIncomeAnalysis));
	    	 
	     }

   return ResponseData;
}
   
 
 

}
