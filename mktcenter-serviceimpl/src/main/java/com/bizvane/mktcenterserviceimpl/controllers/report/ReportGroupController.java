package com.bizvane.mktcenterserviceimpl.controllers.report;

import java.text.SimpleDateFormat;
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
import com.bizvane.centerstageservice.models.vo.SysStoreVo;
import com.bizvane.centerstageservice.rpc.CompanyServiceRpc;
import com.bizvane.centerstageservice.rpc.StoreServiceRpc;
import com.bizvane.mktcenterservice.interfaces.ReportTempService;
import com.bizvane.mktcenterservice.models.po.FileReportTempPO;
import com.bizvane.mktcenterservice.models.po.FileReportTempPOExample;
import com.bizvane.mktcenterservice.models.requestvo.BackDataTime;
import com.bizvane.mktcenterservice.models.requestvo.postvo.IncomeTotalListGroup;
import com.bizvane.mktcenterserviceimpl.common.report.BaseUrl;
import com.bizvane.mktcenterserviceimpl.common.utils.FigureUtilGroup;
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
@RequestMapping("reportGroup")
public class ReportGroupController {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private  FileReportTempPOMapper fileReportTempPOMapper;
	
	@Autowired
	private ReportTempService  reportTempService;
	
	@Autowired
	private BaseUrl BaseUrl;
	
	@Autowired
	private  	StoreServiceRpc storeServiceRpc;
	
	@Autowired
	private   CompanyServiceRpc companyServiceRpc;
	
//	@Autowired
//	private  MemberLifecycleParameterService memberLifecycleParameterService;

    
	
    @RequestMapping("vipIncomeAnalysis")
    public ResponseData<List<BackDataTime>> vipIncomeAnalysis( IncomeTotalListGroup sendVO, HttpServletRequest request){
 	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("vipIncomeAnalysis").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
	     

	     
 	 return sendpostHaveTime(BaseUrl.getLoadUrl("vipIncomeAnalysis"),sendVO,FileReportTempPOlist,sysAccountPO);
   }

    @RequestMapping("operatingIncomeAnalysis")
    public ResponseData<List<BackDataTime>> operatingIncomeAnalysis( IncomeTotalListGroup sendVO, HttpServletRequest request){
 	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("operatingIncomeAnalysis").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
 	 return sendpostHaveTime(BaseUrl.getLoadUrl("operatingIncomeAnalysis"),sendVO,FileReportTempPOlist,sysAccountPO);
   }
    
    
// 收入01- 收入总表
   @RequestMapping("incomeTotalListGroup")
   public ResponseData<List<BackDataTime>> incomeTotalListGroup( IncomeTotalListGroup sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("incomeTotalListGroup").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
	     
   	 return sendpostHaveTime(BaseUrl.getLoadUrl("incomeTotalListGroup"),sendVO,FileReportTempPOlist,sysAccountPO);
   }
   
// 收入01- 会销收入表汇总
   @RequestMapping("incomeVipGroup")
   public ResponseData<List<BackDataTime>> incomeVip( IncomeTotalListGroup sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("incomeVipGroup").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
   	 return sendpostHaveTime(BaseUrl.getLoadUrl("incomeVipGroup"),sendVO,FileReportTempPOlist,sysAccountPO);
   }
   

   
// 收入01- 游客收入表汇总
   @RequestMapping("touristIncomeGroup")
   public ResponseData<List<BackDataTime>> touristIncome( IncomeTotalListGroup sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("touristIncomeGroup").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
   	 return sendpostHaveTime(BaseUrl.getLoadUrl("touristIncomeGroup"),sendVO,FileReportTempPOlist,sysAccountPO);
   }
   
// 02渠道-线上会销收入表汇总
   @RequestMapping("onlineVipIncomeGroup")
   public ResponseData<List<BackDataTime>> onlineVipIncome( IncomeTotalListGroup sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("onlineVipIncomeGroup").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
   	 return sendpostHaveTime(BaseUrl.getLoadUrl("onlineVipIncomeGroup"),sendVO,FileReportTempPOlist,sysAccountPO);
   }
   
// 02渠道-线下
   @RequestMapping("offlineVipIncomeGroup")
   public ResponseData<List<BackDataTime>> offlineVipIncome( IncomeTotalListGroup sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("offlineVipIncomeGroup").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
   	 return sendpostHaveTime(BaseUrl.getLoadUrl("offlineVipIncomeGroup"),sendVO,FileReportTempPOlist,sysAccountPO);
   }
   
// 03开绑卡分析-开卡
//   @RequestMapping("offlineVipIncome")
//   public ResponseData<List<BackDataTime>> offlineVipIncome(OfflineVipIncome sendVO, HttpServletRequest request){
//	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
//   	 return sendpostHaveTime(BaseUrl.getLoadUrl("offlineVipIncome"),sendVO,FileReportTempPOlist,sysAccountPO);
//   }
   
// 03开绑卡分析-绑卡
// @RequestMapping("offlineVipIncome")
// public ResponseData<List<BackDataTime>> offlineVipIncome(OfflineVipIncome sendVO, HttpServletRequest request){
//	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
// 	 return sendpostHaveTime(BaseUrl.getLoadUrl("offlineVipIncome"),sendVO,FileReportTempPOlist,sysAccountPO);
// }
   
// 04会员数量
   @RequestMapping("vipNumGroup")
   public ResponseData<List<BackDataTime>> vipNum( IncomeTotalListGroup sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("vipNumGroup").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
   	 return sendpostHaveTime(BaseUrl.getLoadUrl("vipNumGroup"),sendVO,FileReportTempPOlist,sysAccountPO);
   }
   
// 05新增会员-新增会员收入
   @RequestMapping("increaseVipGroup")
   public ResponseData<List<BackDataTime>> increaseVip( IncomeTotalListGroup sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("increaseVipGroup").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
   	 return sendpostHaveTime(BaseUrl.getLoadUrl("increaseVipGroup"),sendVO,FileReportTempPOlist,sysAccountPO);
   }
// 05新增会员-新增会员数量
   @RequestMapping("increaseVipNumGroup")
   public ResponseData<List<BackDataTime>> increaseVipNum( IncomeTotalListGroup sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("increaseVipNumGroup").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
   	 return sendpostHaveTime(BaseUrl.getLoadUrl("increaseVipNumGroup"),sendVO,FileReportTempPOlist,sysAccountPO);
   }
   
// 06会员卡分析-类型1
//   @RequestMapping("increaseVipNum")
//   public ResponseData<List<BackDataTime>> increaseVipNum(IncreaseVipNum sendVO, HttpServletRequest request){
//	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
//   	 return sendpostHaveTime(BaseUrl.getLoadUrl("increaseVipNum"),sendVO,FileReportTempPOlist,sysAccountPO);
//   }
// 06会员卡分析-类型2
// @RequestMapping("increaseVipNum")
// public ResponseData<List<BackDataTime>> increaseVipNum(IncreaseVipNum sendVO, HttpServletRequest request){
//	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
// 	 return sendpostHaveTime(BaseUrl.getLoadUrl("increaseVipNum"),sendVO,FileReportTempPOlist,sysAccountPO);
// }
   
// 07新老会员分析-新会员
   @RequestMapping("newOldMemberInterfaceGroup")
   public ResponseData<List<BackDataTime>> newOldMemberInterface( IncomeTotalListGroup sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("newOldMemberInterfaceGroup").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
   	 return sendpostHaveTime(BaseUrl.getLoadUrl("newOldMemberInterfaceGroup"),sendVO,FileReportTempPOlist,sysAccountPO);
   }
   
// 08活跃会员表汇总
   @RequestMapping("activeMemberAllInterfaceGroup")
   public ResponseData<List<BackDataTime>> activeMemberAllInterface( IncomeTotalListGroup sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("activeMemberAllInterfaceGroup").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
   	 return sendpostHaveTime(BaseUrl.getLoadUrl("activeMemberAllInterfaceGroup"),sendVO,FileReportTempPOlist,sysAccountPO);
   }
   
// 09复购-会员表汇总
   @RequestMapping("rePurchaseMemberAllInterfaceGroup")
   public ResponseData<List<BackDataTime>> rePurchaseMemberAllInterface( IncomeTotalListGroup sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("rePurchaseMemberAllInterfaceGroup").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
   	 return sendpostHaveTime(BaseUrl.getLoadUrl("rePurchaseMemberAllInterfaceGroup"),sendVO,FileReportTempPOlist,sysAccountPO);
   }
   
// 10回购-会员表汇总
//   @RequestMapping("activeMemberAllInterface")
//   public ResponseData<List<BackDataTime>> activeMemberAllInterface(ActiveMemberAllInterface sendVO, HttpServletRequest request){
//	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
//   	 return sendpostHaveTime(BaseUrl.getLoadUrl("activeMemberAllInterface"),sendVO,FileReportTempPOlist,sysAccountPO);
//   }

   
   @RequestMapping("genderGroup")
   public ResponseData<List<BackDataTime>> genderGroup( IncomeTotalListGroup sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("genderGroup").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
   	 return sendpostHaveTime(BaseUrl.getLoadUrl("genderGroup"),sendVO,FileReportTempPOlist,sysAccountPO);
   }
   
   @RequestMapping("ageAnalysisGroup")
   public ResponseData<List<BackDataTime>> ageAnalysisGroup( IncomeTotalListGroup sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10291");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("ageAnalysisGroup").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
   	 return sendpostHaveTime(BaseUrl.getLoadUrl("ageAnalysisGroup"),sendVO,FileReportTempPOlist,sysAccountPO);
   }
   

   
// 请求放回数据带时间格式的json
 public ResponseData<List<BackDataTime>> sendpostHaveTime(String url,IncomeTotalListGroup vipIncomeAnalysis,List<FileReportTempPO> fileReportTempPOlist,SysAccountPO currentUser){
 log.info("报表查询ReportIncomeController："+url+vipIncomeAnalysis.toString());
 
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
   		         if(organization.equals("0")) {
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
    		            	 str[i++] = sysStore.getSysStoreId().toString();
    		             }
				    } catch (Exception e) {
								System.out.println("获取当前用户，所有店铺id出错");
							}
   		        	 System.out.println("当前用户"+JSONObject.toJSONString(currentUser));
   		        	 jsonObject.put("organization", "1"); // 直接put相同的key
   		        	 jsonObject.put("organizationContent", str); // / 
   		         }
   		       //默认页  
   		         
   				 //用户key
  	   		   jsonObject.put("businessNum", BaseUrl.getBusinessNum());
  	   		   jsonObject.put("apiKey", BaseUrl.getApiKey());
  	   		 //用户key
		 ResponseEntity<String> response = this.restTemplate.postForEntity(url, jsonObject,String.class, new Object[0]);
	     ResponseData<List<BackDataTime>> ResponseData =new ResponseData<List<BackDataTime>>();
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
		    ResponseData.setData(FigureUtilGroup.parseJSON2MapTime(job.get("data").toString(),fileReportTempPOlist,vipIncomeAnalysis));
	     }else {
	    	 ResponseData.setCode(0);
	  	    ResponseData.setMessage(job.get("message").toString());
	  	  ResponseData.setData(FigureUtilGroup.parseJSON2MapTime("false",fileReportTempPOlist,vipIncomeAnalysis));
	    	 
	     }

     return ResponseData;
 }
   
   
 
// 选择周期后，时间范围无论怎么选，不改变折线图的周期。
//  if(sendVO.getParticleSize()!=null&&sendVO.getCycle()!=null&&!sendVO.getCycle().equals("1")) {
//			SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
//			String minDateStr = "";
//			Calendar calc =Calendar.getInstance();
//			    calc.setTime(new Date());
//			    sendVO.setEndDate(sdf.format(new Date())+" 00:00:00");
//	   if(sendVO.getParticleSize().endsWith("1")){
//			calc.add(Calendar.DATE, -30);
//			SimpleDateFormat sdfdate  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			sendVO.setEndDate(sdfdate.format(new Date()));
//	   }else if(sendVO.getParticleSize().endsWith("2")) {
//		   calc.add(Calendar.DATE, -210);
//	   }else if(sendVO.getParticleSize().endsWith("3")) {
//		   calc.add(Calendar.DATE, -365);
//	   }else if(sendVO.getParticleSize().endsWith("4")) {
//		   calc.add(Calendar.DATE, -2555);
//	   }
//		Date minDate = calc.getTime();
//		minDateStr = sdf.format(minDate);
//		sendVO.setStartDate(minDateStr+" 00:00:00");
//  }

}
