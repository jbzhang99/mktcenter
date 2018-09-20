package com.bizvane.mktcenterserviceimpl.controllers.report;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.mktcenterservice.models.po.FileReportTempPO;
import com.bizvane.mktcenterservice.models.po.FileReportTempPOExample;
import com.bizvane.mktcenterservice.models.requestvo.BackDataTime;
import com.bizvane.mktcenterservice.models.requestvo.BaseUrl;
import com.bizvane.mktcenterservice.models.requestvo.postvo.IncomeTotalListGroup;
import com.bizvane.mktcenterserviceimpl.common.utils.FigureUtilGroup;
import com.bizvane.mktcenterserviceimpl.mappers.FileReportTempPOMapper;
import com.bizvane.utils.responseinfo.ResponseData;

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

    

    
// 收入01- 收入总表
   @RequestMapping("incomeTotalListGroup")
   public ResponseData<List<BackDataTime>> incomeTotalListGroup( IncomeTotalListGroup sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10153");
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("incomeTotalList").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
	     
   	 return sendpostHaveTime(BaseUrl.getLoadUrl("incomeTotalListGroup"),sendVO,FileReportTempPOlist);
   }
   
// 收入01- 会销收入表汇总
   @RequestMapping("incomeVipGroup")
   public ResponseData<List<BackDataTime>> incomeVip( IncomeTotalListGroup sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10153");
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("incomeVip").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
   	 return sendpostHaveTime(BaseUrl.getLoadUrl("incomeVipGroup"),sendVO,FileReportTempPOlist);
   }
   

   
// 收入01- 游客收入表汇总
   @RequestMapping("touristIncomeGroup")
   public ResponseData<List<BackDataTime>> touristIncome( IncomeTotalListGroup sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10153");
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("touristIncome").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
   	 return sendpostHaveTime(BaseUrl.getLoadUrl("touristIncomeGroup"),sendVO,FileReportTempPOlist);
   }
   
// 02渠道-线上会销收入表汇总
   @RequestMapping("onlineVipIncomeGroup")
   public ResponseData<List<BackDataTime>> onlineVipIncome( IncomeTotalListGroup sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10153");
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("onlineVipIncome").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
   	 return sendpostHaveTime(BaseUrl.getLoadUrl("onlineVipIncomeGroup"),sendVO,FileReportTempPOlist);
   }
   
// 02渠道-线下
   @RequestMapping("offlineVipIncomeGroup")
   public ResponseData<List<BackDataTime>> offlineVipIncome( IncomeTotalListGroup sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10153");
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("offlineVipIncome").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
   	 return sendpostHaveTime(BaseUrl.getLoadUrl("offlineVipIncomeGroup"),sendVO,FileReportTempPOlist);
   }
   
// 03开绑卡分析-开卡
//   @RequestMapping("offlineVipIncome")
//   public ResponseData<List<BackDataTime>> offlineVipIncome(OfflineVipIncome sendVO, HttpServletRequest request){
//	   sendVO.setCorpId("C10153");
//   	 return sendpostHaveTime(BaseUrl.getLoadUrl("offlineVipIncome"),sendVO,FileReportTempPOlist);
//   }
   
// 03开绑卡分析-绑卡
// @RequestMapping("offlineVipIncome")
// public ResponseData<List<BackDataTime>> offlineVipIncome(OfflineVipIncome sendVO, HttpServletRequest request){
//	   sendVO.setCorpId("C10153");
// 	 return sendpostHaveTime(BaseUrl.getLoadUrl("offlineVipIncome"),sendVO,FileReportTempPOlist);
// }
   
// 04会员数量
   @RequestMapping("vipNumGroup")
   public ResponseData<List<BackDataTime>> vipNum( IncomeTotalListGroup sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10153");
	   
	   //TODO
	   sendVO.setActiveCycle("40");
	   sendVO.setNewVipCycle("180");
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("vipNum").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
   	 return sendpostHaveTime(BaseUrl.getLoadUrl("vipNumGroup"),sendVO,FileReportTempPOlist);
   }
   
// 05新增会员-新增会员收入
   @RequestMapping("increaseVipGroup")
   public ResponseData<List<BackDataTime>> increaseVip( IncomeTotalListGroup sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10153");
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("increaseVip").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
   	 return sendpostHaveTime(BaseUrl.getLoadUrl("increaseVipGroup"),sendVO,FileReportTempPOlist);
   }
// 05新增会员-新增会员数量
   @RequestMapping("increaseVipNumGroup")
   public ResponseData<List<BackDataTime>> increaseVipNum( IncomeTotalListGroup sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10153");
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("increaseVipNum").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
   	 return sendpostHaveTime(BaseUrl.getLoadUrl("increaseVipNumGroup"),sendVO,FileReportTempPOlist);
   }
   
// 06会员卡分析-类型1
//   @RequestMapping("increaseVipNum")
//   public ResponseData<List<BackDataTime>> increaseVipNum(IncreaseVipNum sendVO, HttpServletRequest request){
//	   sendVO.setCorpId("C10153");
//   	 return sendpostHaveTime(BaseUrl.getLoadUrl("increaseVipNum"),sendVO,FileReportTempPOlist);
//   }
// 06会员卡分析-类型2
// @RequestMapping("increaseVipNum")
// public ResponseData<List<BackDataTime>> increaseVipNum(IncreaseVipNum sendVO, HttpServletRequest request){
//	   sendVO.setCorpId("C10153");
// 	 return sendpostHaveTime(BaseUrl.getLoadUrl("increaseVipNum"),sendVO,FileReportTempPOlist);
// }
   
// 07新老会员分析-新会员
   @RequestMapping("newOldMemberInterfaceGroup")
   public ResponseData<List<BackDataTime>> newOldMemberInterface( IncomeTotalListGroup sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10153");
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("newOldMemberInterface").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
   	 return sendpostHaveTime(BaseUrl.getLoadUrl("newOldMemberInterfaceGroup"),sendVO,FileReportTempPOlist);
   }
   
// 08活跃会员表汇总
   @RequestMapping("activeMemberAllInterfaceGroup")
   public ResponseData<List<BackDataTime>> activeMemberAllInterface( IncomeTotalListGroup sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10153");
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("activeMemberAllInterface").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
   	 return sendpostHaveTime(BaseUrl.getLoadUrl("activeMemberAllInterfaceGroup"),sendVO,FileReportTempPOlist);
   }
   
// 09复购-会员表汇总
   @RequestMapping("rePurchaseMemberAllInterfaceGroup")
   public ResponseData<List<BackDataTime>> rePurchaseMemberAllInterface( IncomeTotalListGroup sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10153");
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("rePurchaseMemberAllInterface").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
   	 return sendpostHaveTime(BaseUrl.getLoadUrl("rePurchaseMemberAllInterfaceGroup"),sendVO,FileReportTempPOlist);
   }
   
// 10回购-会员表汇总
//   @RequestMapping("activeMemberAllInterface")
//   public ResponseData<List<BackDataTime>> activeMemberAllInterface(ActiveMemberAllInterface sendVO, HttpServletRequest request){
//	   sendVO.setCorpId("C10153");
//   	 return sendpostHaveTime(BaseUrl.getLoadUrl("activeMemberAllInterface"),sendVO,FileReportTempPOlist);
//   }


   
// 请求放回数据带时间格式的json
 public ResponseData<List<BackDataTime>> sendpostHaveTime(String url,IncomeTotalListGroup vipIncomeAnalysis,List<FileReportTempPO> fileReportTempPOlist){
 log.info("报表查询ReportIncomeController："+url+vipIncomeAnalysis.toString());
		 ResponseEntity<String> response = this.restTemplate.postForEntity(url, vipIncomeAnalysis,String.class, new Object[0]);
	     ResponseData<List<BackDataTime>> ResponseData =new ResponseData<List<BackDataTime>>();
	     JSONObject job = JSONObject.parseObject(response.getBody());
	     
	     if(job.get("successFlag").equals("1")) {
	    	 ResponseData.setCode(0);
	  	    ResponseData.setMessage(job.get("message").toString());
		    ResponseData.setData(FigureUtilGroup.parseJSON2MapTime(job.get("data").toString(),fileReportTempPOlist,vipIncomeAnalysis));
	     }else {
	    	 ResponseData.setCode(1);
	  	    ResponseData.setMessage(job.get("message").toString());
	  	  ResponseData.setData(FigureUtilGroup.parseJSON2MapTime("false",fileReportTempPOlist,vipIncomeAnalysis));
	    	 
	     }

     return ResponseData;
 }
   
   
 


}
