package com.bizvane.mktcenterserviceimpl.controllers.report;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
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
import com.bizvane.mktcenterservice.interfaces.ReportTempService;
import com.bizvane.mktcenterservice.models.po.FileReportTempPO;
import com.bizvane.mktcenterservice.models.po.FileReportTempPOExample;
import com.bizvane.mktcenterservice.models.po.MktCouponPOExample;
import com.bizvane.mktcenterservice.models.requestvo.BackData;
import com.bizvane.mktcenterservice.models.requestvo.BackDataBiaotou;
import com.bizvane.mktcenterservice.models.requestvo.BackDataTime;
import com.bizvane.mktcenterservice.models.requestvo.BaseUrl;
import com.bizvane.mktcenterservice.models.requestvo.postvo.ActiveMemberAllInterface;
import com.bizvane.mktcenterservice.models.requestvo.postvo.IncomeTotalList;
import com.bizvane.mktcenterservice.models.requestvo.postvo.IncomeTotalListGroup;
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
import com.bizvane.mktcenterserviceimpl.common.utils.FigureUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.FigureUtilGroup;
import com.bizvane.mktcenterserviceimpl.common.utils.FigureUtilGroupFigure;
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

    
	
    @RequestMapping("vipIncomeAnalysis")
    public ResponseData<List<BackDataTime>> vipIncomeAnalysis( IncomeTotalListGroup sendVO, HttpServletRequest request){
 	   sendVO.setCorpId("C10153");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
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
    public ResponseData<List<BackDataTime>> operatingIncomeAnalysis( IncomeTotalListGroup sendVO, HttpServletRequest request){
 	   sendVO.setCorpId("C10153");  SysAccountPO sysAccountPO =TokenUtils.getStageUser(request);
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
 public ResponseData<List<BackDataTime>> sendpostHaveTime(String url,IncomeTotalListGroup vipIncomeAnalysis,List<FileReportTempPO> fileReportTempPOlist,SysAccountPO sysAccountPO){
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
	    		 String[] al= organizationContentStr.toString().split(",");
	    		  jsonObject.put("organizationContent", al); // 直接put相同的key
	    	}
			 
		 ResponseEntity<String> response = this.restTemplate.postForEntity(url, jsonObject,String.class, new Object[0]);
	     ResponseData<List<BackDataTime>> ResponseData =new ResponseData<List<BackDataTime>>();
	     JSONObject job = JSONObject.parseObject(response.getBody());
	     
	     if(job.get("successFlag").equals("1")) {
	    	 
             // 导出表格
	    	 String postTem = jsonObject.getString("postTem");
	    	 if(StringUtils.isNotBlank(postTem)&&postTem.equals("export")){
	    		 reportTempService.Export(sysAccountPO,"_cycle",job.get("data").toString(),fileReportTempPOlist.get(0));
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
public ResponseData<List<BackDataTime>> sendpostHaveTimeOpera(String url,IncomeTotalListGroup vipIncomeAnalysis,List<FileReportTempPO> fileReportTempPOlist,SysAccountPO sysAccountPO){
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
	    		 String[] al= organizationContentStr.toString().split(",");
	    		  jsonObject.put("organizationContent", al); // 直接put相同的key
	    	}
			 
		 ResponseEntity<String> response = this.restTemplate.postForEntity(url, jsonObject,String.class, new Object[0]);
	     ResponseData<List<BackDataTime>> ResponseData =new ResponseData<List<BackDataTime>>();
	     JSONObject job = JSONObject.parseObject(response.getBody());
	     
	     if(job.get("successFlag").equals("1")) {
	    	 
           // 导出表格
	    	 String postTem = jsonObject.getString("postTem");
	    	 if(StringUtils.isNotBlank(postTem)&&postTem.equals("export")){
	    		 reportTempService.Export(sysAccountPO,"_cycle",job.get("data").toString(),fileReportTempPOlist.get(0));
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
