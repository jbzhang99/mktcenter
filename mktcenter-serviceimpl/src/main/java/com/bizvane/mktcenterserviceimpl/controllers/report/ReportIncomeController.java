package com.bizvane.mktcenterserviceimpl.controllers.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import com.bizvane.mktcenterserviceimpl.mappers.FileReportTempPOMapper;
import com.bizvane.utils.responseinfo.ResponseData;
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

    @RequestMapping("vipIncomeAnalysis")
    public ResponseData<List<BackData>> vipIncomeAnalysis( VipIncomeAnalysis sendVO, HttpServletRequest request){
    	sendVO.setCorpId(TokenUtils.getStageUser(request).getCompanyCode());
//         TokenUtils.getStageUser(request).getCompanyCode()
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("incomeTotalList").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
    	 return sendpost(BaseUrl.getLoadUrl("vipIncomeAnalysis"),sendVO,FileReportTempPOlist);
    } 
    
    

    
// 收入01- 收入总表
   @RequestMapping("incomeTotalList")
   public ResponseData<List<BackData>> incomeTotalListGroup( IncomeTotalList sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10153");
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("incomeTotalList").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
	     
   	 return sendpost(BaseUrl.getLoadUrl("incomeTotalList"),sendVO,FileReportTempPOlist);
   }
   
// 收入01- 会销收入表汇总
   @RequestMapping("incomeVip")
   public ResponseData<List<BackData>> incomeVip( IncomeVip sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10153");
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("incomeVip").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
   	 return sendpost(BaseUrl.getLoadUrl("incomeVip"),sendVO,FileReportTempPOlist);
   }
   

   
// 收入01- 游客收入表汇总
   @RequestMapping("touristIncome")
   public ResponseData<List<BackData>> touristIncome( TouristIncome sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10153");
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("touristIncome").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
   	 return sendpost(BaseUrl.getLoadUrl("touristIncome"),sendVO,FileReportTempPOlist);
   }
   
// 02渠道-线上会销收入表汇总
   @RequestMapping("onlineVipIncome")
   public ResponseData<List<BackData>> onlineVipIncome( OnlineVipIncome sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10153");
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("onlineVipIncome").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
   	 return sendpost(BaseUrl.getLoadUrl("onlineVipIncome"),sendVO,FileReportTempPOlist);
   }
   
// 02渠道-线下
   @RequestMapping("offlineVipIncome")
   public ResponseData<List<BackData>> offlineVipIncome( OfflineVipIncome sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10153");
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("offlineVipIncome").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
   	 return sendpost(BaseUrl.getLoadUrl("offlineVipIncome"),sendVO,FileReportTempPOlist);
   }
   
// 03开绑卡分析-开卡
//   @RequestMapping("offlineVipIncome")
//   public ResponseData<List<BackData>> offlineVipIncome(OfflineVipIncome sendVO, HttpServletRequest request){
//	   sendVO.setCorpId("C10153");
//   	 return sendpost(BaseUrl.getLoadUrl("offlineVipIncome"),sendVO,FileReportTempPOlist);
//   }
   
// 03开绑卡分析-绑卡
// @RequestMapping("offlineVipIncome")
// public ResponseData<List<BackData>> offlineVipIncome(OfflineVipIncome sendVO, HttpServletRequest request){
//	   sendVO.setCorpId("C10153");
// 	 return sendpost(BaseUrl.getLoadUrl("offlineVipIncome"),sendVO,FileReportTempPOlist);
// }
   
// 04会员数量
   @RequestMapping("vipNum")
   public ResponseData<List<BackData>> vipNum( VipNum sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10153");
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("vipNum").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
   	 return sendpost(BaseUrl.getLoadUrl("vipNum"),sendVO,FileReportTempPOlist);
   }
   
// 05新增会员-新增会员收入
   @RequestMapping("increaseVip")
   public ResponseData<List<BackData>> increaseVip( IncreaseVip sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10153");
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("increaseVip").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
   	 return sendpost(BaseUrl.getLoadUrl("increaseVip"),sendVO,FileReportTempPOlist);
   }
// 05新增会员-新增会员数量
   @RequestMapping("increaseVipNum")
   public ResponseData<List<BackData>> increaseVipNum( IncreaseVipNum sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10153");
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("increaseVipNum").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
   	 return sendpost(BaseUrl.getLoadUrl("increaseVipNum"),sendVO,FileReportTempPOlist);
   }
   
// 06会员卡分析-类型1
//   @RequestMapping("increaseVipNum")
//   public ResponseData<List<BackData>> increaseVipNum(IncreaseVipNum sendVO, HttpServletRequest request){
//	   sendVO.setCorpId("C10153");
//   	 return sendpost(BaseUrl.getLoadUrl("increaseVipNum"),sendVO,FileReportTempPOlist);
//   }
// 06会员卡分析-类型2
// @RequestMapping("increaseVipNum")
// public ResponseData<List<BackData>> increaseVipNum(IncreaseVipNum sendVO, HttpServletRequest request){
//	   sendVO.setCorpId("C10153");
// 	 return sendpost(BaseUrl.getLoadUrl("increaseVipNum"),sendVO,FileReportTempPOlist);
// }
   
// 07新老会员分析-新会员
   @RequestMapping("newOldMemberInterface")
   public ResponseData<List<BackData>> newOldMemberInterface( NewOldMemberInterface sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10153");
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("newOldMemberInterface").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
   	 return sendpost(BaseUrl.getLoadUrl("newOldMemberInterface"),sendVO,FileReportTempPOlist);
   }
   
// 08活跃会员表汇总
   @RequestMapping("activeMemberAllInterface")
   public ResponseData<List<BackData>> activeMemberAllInterface( ActiveMemberAllInterface sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10153");
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("activeMemberAllInterface").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
   	 return sendpost(BaseUrl.getLoadUrl("activeMemberAllInterface"),sendVO,FileReportTempPOlist);
   }
   
// 09复购-会员表汇总
   @RequestMapping("rePurchaseMemberAllInterface")
   public ResponseData<List<BackData>> rePurchaseMemberAllInterface( RePurchaseMemberAllInterface sendVO, HttpServletRequest request){
	   sendVO.setCorpId("C10153");
	     FileReportTempPOExample example = new FileReportTempPOExample();
	     example.createCriteria().andTemplateTypeEqualTo("rePurchaseMemberAllInterface").andValidEqualTo(Boolean.TRUE);
	     List<FileReportTempPO>  FileReportTempPOlist = fileReportTempPOMapper.selectByExample(example);
   	 return sendpost(BaseUrl.getLoadUrl("rePurchaseMemberAllInterface"),sendVO,FileReportTempPOlist);
   }
   
// 10回购-会员表汇总
//   @RequestMapping("activeMemberAllInterface")
//   public ResponseData<List<BackData>> activeMemberAllInterface(ActiveMemberAllInterface sendVO, HttpServletRequest request){
//	   sendVO.setCorpId("C10153");
//   	 return sendpost(BaseUrl.getLoadUrl("activeMemberAllInterface"),sendVO,FileReportTempPOlist);
//   }

//   请求放回数据
   public ResponseData<List<BackData>> sendpost(String url,Object vipIncomeAnalysis,List<FileReportTempPO> fileReportTempPOlist){
   log.info("报表查询ReportIncomeController："+url+vipIncomeAnalysis.toString());
		 ResponseEntity<String> response = this.restTemplate.postForEntity(url, vipIncomeAnalysis,String.class, new Object[0]);
	     ResponseData<List<BackData>> ResponseData =new ResponseData<List<BackData>>();
	     JSONObject job = JSONObject.parseObject(response.getBody());
	     
	     if(job.get("successFlag").equals("1")) {
	    	 ResponseData.setCode(0);
	  	    ResponseData.setMessage(job.get("message").toString());
		    ResponseData.setData(FigureUtil.parseJSON2Map(job.get("data").toString(),fileReportTempPOlist));
	     }else {
	    	 ResponseData.setCode(1);
	  	    ResponseData.setMessage(job.get("message").toString());
	  	  ResponseData.setData(FigureUtil.parseJSON2Map("false",fileReportTempPOlist));
	    	 
	     }

       return ResponseData;
   }
   
// 请求放回数据带时间格式的json
 public ResponseData<List<BackDataTime>> sendpostHaveTime(String url,Object vipIncomeAnalysis,List<FileReportTempPO> fileReportTempPOlist){
 log.info("报表查询ReportIncomeController："+url+vipIncomeAnalysis.toString());
		 ResponseEntity<String> response = this.restTemplate.postForEntity(url, vipIncomeAnalysis,String.class, new Object[0]);
	     ResponseData<List<BackDataTime>> ResponseData =new ResponseData<List<BackDataTime>>();
	     JSONObject job = JSONObject.parseObject(response.getBody());
	     
	     if(job.get("successFlag").equals("1")) {
	    	 ResponseData.setCode(0);
	  	    ResponseData.setMessage(job.get("message").toString());
		    ResponseData.setData(FigureUtil.parseJSON2MapTime(job.get("data").toString(),fileReportTempPOlist));
	     }else {
	    	 ResponseData.setCode(1);
	  	    ResponseData.setMessage(job.get("message").toString());
	  	  ResponseData.setData(FigureUtil.parseJSON2MapTime("false",fileReportTempPOlist));
	    	 
	     }

     return ResponseData;
 }
   

    
  
 


}
