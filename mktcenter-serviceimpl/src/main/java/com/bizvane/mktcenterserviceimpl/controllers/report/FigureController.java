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
@RequestMapping("figure")
public class FigureController {
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
    

    

	//  请求放回数据
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
		  	    List<BackData> listdata =new ArrayList<BackData>();
		  	  ResponseData.setData(FigureUtil.parseJSON2Map("false",fileReportTempPOlist));
		    	 
		     }
	
	      return ResponseData;
	  }
  
	//请求放回数据带时间格式的json
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
