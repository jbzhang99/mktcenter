package com.bizvane.mktcenterserviceimpl.controllers.report;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
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

    @RequestMapping("vipIncomeAnalysis")
    public ResponseData<String> vipIncomeAnalysis(VipIncomeAnalysis vipIncomeAnalysis, HttpServletRequest request){
         vipIncomeAnalysis.setCorpId(TokenUtils.getStageUser(request).getCompanyCode());
    	 return sendpost2(BaseUrl.getLoadUrl("vipIncomeAnalysis"),vipIncomeAnalysis);
    } 
    

    public ResponseData<String> sendpost2(String url,Object vipIncomeAnalysis){
    log.info("报表查询ReportIncomeController："+url+vipIncomeAnalysis.toString());
		 ResponseEntity<String> response = this.restTemplate.postForEntity(url, vipIncomeAnalysis,String.class, new Object[0]);
	     ResponseData<String> ResponseData =new ResponseData<String>();
	     JSONObject job = JSONObject.parseObject(response.getBody());
	     
	     if(job.get("successFlag").equals("1")) {
	    	 ResponseData.setCode(0);
	 	    ResponseData.setMessage(job.get("message").toString());
		    ResponseData.setData(job.get("data").toString());
	     }else {
	    	ResponseData.setCode(1);
	 	    ResponseData.setMessage(job.get("message").toString());
		    ResponseData.setData("{}");
	     }
        return ResponseData;
    }
    
    
// 收入01- 收入总表
   @RequestMapping("incomeTotalList")
   public ResponseData<String> incomeTotalListGroup(IncomeTotalList sendVO, HttpServletRequest request){
	   sendVO.setCorpId(TokenUtils.getStageUser(request).getCompanyCode());
   	 return sendpost(BaseUrl.getLoadUrl("incomeTotalList"),sendVO);
   }
   
// 收入01- 会销收入表汇总
   @RequestMapping("incomeVip")
   public ResponseData<String> incomeVip(IncomeVip sendVO, HttpServletRequest request){
	   sendVO.setCorpId(TokenUtils.getStageUser(request).getCompanyCode());
   	 return sendpost(BaseUrl.getLoadUrl("incomeVip"),sendVO);
   }
   

   
// 收入01- 会销收入表汇总
   @RequestMapping("touristIncome")
   public ResponseData<String> touristIncome(TouristIncome sendVO, HttpServletRequest request){
	   sendVO.setCorpId(TokenUtils.getStageUser(request).getCompanyCode());
   	 return sendpost(BaseUrl.getLoadUrl("touristIncome"),sendVO);
   }
   
// 02渠道-线上会销收入表汇总
   @RequestMapping("onlineVipIncome")
   public ResponseData<String> onlineVipIncome(OnlineVipIncome sendVO, HttpServletRequest request){
	   sendVO.setCorpId(TokenUtils.getStageUser(request).getCompanyCode());
   	 return sendpost(BaseUrl.getLoadUrl("onlineVipIncome"),sendVO);
   }
   
// 02渠道-线下
   @RequestMapping("offlineVipIncome")
   public ResponseData<String> offlineVipIncome(OfflineVipIncome sendVO, HttpServletRequest request){
	   sendVO.setCorpId(TokenUtils.getStageUser(request).getCompanyCode());
   	 return sendpost(BaseUrl.getLoadUrl("offlineVipIncome"),sendVO);
   }
   
// 03开绑卡分析-开卡
//   @RequestMapping("offlineVipIncome")
//   public ResponseData<String> offlineVipIncome(OfflineVipIncome sendVO, HttpServletRequest request){
//	   sendVO.setCorpId(TokenUtils.getStageUser(request).getCompanyCode());
//   	 return sendpost(BaseUrl.getLoadUrl("offlineVipIncome"),sendVO);
//   }
   
// 03开绑卡分析-绑卡
// @RequestMapping("offlineVipIncome")
// public ResponseData<String> offlineVipIncome(OfflineVipIncome sendVO, HttpServletRequest request){
//	   sendVO.setCorpId(TokenUtils.getStageUser(request).getCompanyCode());
// 	 return sendpost(BaseUrl.getLoadUrl("offlineVipIncome"),sendVO);
// }
   
// 04会员数量
   @RequestMapping("vipNum")
   public ResponseData<String> vipNum(VipNum sendVO, HttpServletRequest request){
	   sendVO.setCorpId(TokenUtils.getStageUser(request).getCompanyCode());
   	 return sendpost(BaseUrl.getLoadUrl("vipNum"),sendVO);
   }
   
// 05新增会员-新增会员收入
   @RequestMapping("increaseVip")
   public ResponseData<String> increaseVip(IncreaseVip sendVO, HttpServletRequest request){
	   sendVO.setCorpId(TokenUtils.getStageUser(request).getCompanyCode());
   	 return sendpost(BaseUrl.getLoadUrl("increaseVip"),sendVO);
   }
// 05新增会员-新增会员数量
   @RequestMapping("increaseVipNum")
   public ResponseData<String> increaseVipNum(IncreaseVipNum sendVO, HttpServletRequest request){
	   sendVO.setCorpId(TokenUtils.getStageUser(request).getCompanyCode());
   	 return sendpost(BaseUrl.getLoadUrl("increaseVipNum"),sendVO);
   }
   
// 06会员卡分析-类型1
//   @RequestMapping("increaseVipNum")
//   public ResponseData<String> increaseVipNum(IncreaseVipNum sendVO, HttpServletRequest request){
//	   sendVO.setCorpId(TokenUtils.getStageUser(request).getCompanyCode());
//   	 return sendpost(BaseUrl.getLoadUrl("increaseVipNum"),sendVO);
//   }
// 06会员卡分析-类型2
// @RequestMapping("increaseVipNum")
// public ResponseData<String> increaseVipNum(IncreaseVipNum sendVO, HttpServletRequest request){
//	   sendVO.setCorpId(TokenUtils.getStageUser(request).getCompanyCode());
// 	 return sendpost(BaseUrl.getLoadUrl("increaseVipNum"),sendVO);
// }
   
// 07新老会员分析-新会员
   @RequestMapping("newOldMemberInterface")
   public ResponseData<String> newOldMemberInterface(NewOldMemberInterface sendVO, HttpServletRequest request){
	   sendVO.setCorpId(TokenUtils.getStageUser(request).getCompanyCode());
   	 return sendpost(BaseUrl.getLoadUrl("newOldMemberInterface"),sendVO);
   }
   
// 08活跃会员表汇总
   @RequestMapping("activeMemberAllInterface")
   public ResponseData<String> activeMemberAllInterface(ActiveMemberAllInterface sendVO, HttpServletRequest request){
	   sendVO.setCorpId(TokenUtils.getStageUser(request).getCompanyCode());
   	 return sendpost(BaseUrl.getLoadUrl("activeMemberAllInterface"),sendVO);
   }
   
// 09复购-会员表汇总
   @RequestMapping("rePurchaseMemberAllInterface")
   public ResponseData<String> rePurchaseMemberAllInterface(RePurchaseMemberAllInterface sendVO, HttpServletRequest request){
	   sendVO.setCorpId(TokenUtils.getStageUser(request).getCompanyCode());
   	 return sendpost(BaseUrl.getLoadUrl("rePurchaseMemberAllInterface"),sendVO);
   }
   
// 10回购-会员表汇总
//   @RequestMapping("activeMemberAllInterface")
//   public ResponseData<String> activeMemberAllInterface(ActiveMemberAllInterface sendVO, HttpServletRequest request){
//	   sendVO.setCorpId(TokenUtils.getStageUser(request).getCompanyCode());
//   	 return sendpost(BaseUrl.getLoadUrl("activeMemberAllInterface"),sendVO);
//   }


    public ResponseData<String> sendpost(String url,Object vipIncomeAnalysis){
    log.info("报表查询ReportIncomeController："+url+vipIncomeAnalysis.toString());
		 ResponseEntity<String> response = this.restTemplate.postForEntity(url, vipIncomeAnalysis,String.class, new Object[0]);
	     ResponseData<String> ResponseData =new ResponseData<String>();
	     JSONObject job = JSONObject.parseObject(response.getBody());
	     
	     if(job.get("successFlag").equals("1")) {
	    	 ResponseData.setCode(0);
	 	    ResponseData.setMessage(job.get("message").toString());
		    ResponseData.setData(job.get("data").toString());
	    	 
	     }else {
	    	ResponseData.setCode(1);
	 	    ResponseData.setMessage(job.get("message").toString());
		    ResponseData.setData("{}");
	     }
        return ResponseData;
    }


}
