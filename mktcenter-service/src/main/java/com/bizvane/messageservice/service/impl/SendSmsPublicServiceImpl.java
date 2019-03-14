package com.bizvane.messageservice.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.bizvane.couponfacade.interfaces.CouponQueryServiceFeign;
import com.bizvane.couponfacade.models.po.CouponEntityPO;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.service.api.MemberInfoApiService;
import com.bizvane.members.facade.vo.MemberInfoApiModel;
import com.bizvane.messageservice.service.SendSmsPublicMessageService;
import com.bizvane.utils.responseinfo.PageInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author 张迪
 * 
 * @date 2018/08/15
 * 
 * @获取会员信息，获取优惠券信息，获取公众号信息
 */
@Service
public class SendSmsPublicServiceImpl implements SendSmsPublicMessageService {

	private static final Logger logger = LoggerFactory.getLogger(SendSmsPublicServiceImpl.class);
	  
    @Autowired
    private MemberInfoApiService memberInfoApiService;
    
    @Autowired
    private CouponQueryServiceFeign CouponQueryServiceFeign;
	
	@Override
	public MemberInfoModel GetMemberEntityByMemberCode(String memberName) {
		MemberInfoModel wxVip = new MemberInfoModel();
		try {
			 MemberInfoApiModel infoModel = new MemberInfoApiModel();
	         infoModel.setMemberCode(memberName);
	         ResponseData<PageInfo<MemberInfoModel>> memberResult= memberInfoApiService.getMemberInfo(infoModel);
	         @SuppressWarnings("rawtypes")
	         ArrayList memberList = (ArrayList) memberResult.getData().getList();
	         if(memberList.size()>0){
		         ObjectMapper mapper = new ObjectMapper();
		         wxVip = mapper.convertValue(memberList.get(0), MemberInfoModel.class);
		         
	         }
	         return wxVip;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("exception:"+e.getMessage().toString());
		}
		return wxVip;
	}
	
	@Override
	public CouponEntityPO GetCouponEntityByCouponCode(String CouponName) {
		CouponEntityPO couponentity = new CouponEntityPO();
		try {
			
//			ResponseData<CouponEntityPO> couponentitys = CouponQueryServiceFeign.findCouponByCouponCode(CouponName);
//			if(couponentitys.getCode()==0){
//				couponentity = couponentitys.getData();
//			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("exception:"+e.getMessage().toString());
		}
		
		return couponentity;
         
	}

	@Override
	public String GetReplaceContent(JSONObject jsonObject) {
			String Content = "";
			try {
				if(StringUtils.isNotBlank(jsonObject.getString("content").toString())){}
					String content = jsonObject.getString("content").toString();
		        	if(jsonObject.containsKey("memberName")){
		        		Content = content.replace("#memberName#",jsonObject.getString("memberName"));
		        	}
		        	
		        	if(jsonObject.containsKey("couponName")){
		        		Content = Content.replace("#couponName#",jsonObject.getString("couponName"));
		        	}
		        	
		        	if(jsonObject.containsKey("denomination")){
		        		Content = Content.replace("#denomination#",jsonObject.getString("denomination"));
		        	}
		        	
		        	if(jsonObject.containsKey("couponCode")){
		        		Content = Content.replace("#couponCode#",jsonObject.getString("couponCode"));
		        	}
		        	
		        	if(jsonObject.containsKey("orderNo")){
		        		Content = Content.replace("#orderNo#",jsonObject.getString("orderNo"));
		        	}
		        	
		        	if(jsonObject.containsKey("publicName")){
		        		Content = Content.replace("#publicName#",jsonObject.getString("publicName"));
		        	}
		           
				} catch (Exception e) {
					e.printStackTrace();
					logger.info("exception==========="+e.getMessage().toString());
				}
			return Content;
	}


}
