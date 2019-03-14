package com.bizvane.couponservice.common.utils;

import com.bizvane.couponservice.common.datavo.SalesNumVO;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BaseData {

    public static String growthNot(String currentDataStr,String yesteryearDataStr) {
    	
			if (yesteryearDataStr == null) {
				return "0%";
			}
			if (yesteryearDataStr.equals("0")) {
				return "0%";
			}
			//未用券百分比：（未用券÷全部）×100%；
			BigDecimal currentData = new BigDecimal(currentDataStr);
			BigDecimal yesteryearData = new BigDecimal(yesteryearDataStr);
    	return currentData.divide(yesteryearData, 2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).setScale(0, BigDecimal.ROUND_HALF_UP).toString()+"%";
    }
    public static String growthNotTow(String currentDataStr,String yesteryearDataStr) {
    	
			if (yesteryearDataStr == null) {
				return "0%";
			}
			if (yesteryearDataStr.equals("0")) {
				return "0%";
			}
			//未用券百分比：（未用券÷全部）×100%；
			BigDecimal currentData = new BigDecimal(currentDataStr);
			BigDecimal yesteryearData = new BigDecimal(yesteryearDataStr);
    	return currentData.divide(yesteryearData, 2, BigDecimal.ROUND_HALF_UP).toString();
    }


    public static String guestPrice(String currentDataStr,String yesteryearDataStr) {
    	
			if (yesteryearDataStr == null) {
				return "0";
			}
			if (yesteryearDataStr.equals("0")) {
				return "0";
			}
			//用券客单价 总业绩/件数（A÷B）
			BigDecimal currentData = new BigDecimal(currentDataStr);
			BigDecimal yesteryearData = new BigDecimal(yesteryearDataStr);
    	return currentData.divide(yesteryearData, 2, BigDecimal.ROUND_HALF_UP).toString();
    }
    public static String growth(String currentDataStr,String yesteryearDataStr) {
			if (yesteryearDataStr == null) {
				return "0%";
			}
			if (yesteryearDataStr.equals("0")) {
				return "0%";
			}
			// （本期数－同比去年同期数）÷同比去年同期数×100%；
			BigDecimal currentData = new BigDecimal(currentDataStr);
			BigDecimal yesteryearData = new BigDecimal(yesteryearDataStr);
			BigDecimal dividend = currentData.subtract(yesteryearData);
    	    return dividend.divide(yesteryearData, 2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).setScale(0, BigDecimal.ROUND_HALF_UP).toString()+"%";
    }


    public static List<String> JSONStringTOlist(String string) {
    	List<String> listjson= new ArrayList<>();
    	try {
			JSONArray arr=new JSONArray(string);
	    	  for(int i=0;i<arr.length();i++){
	    		  listjson.add(arr.getJSONObject(i).toString());
	    	  }
		} catch (JSONException e) {
			e.printStackTrace();
		}
    	
		return listjson;
    }
    
    public static SalesNumVO salesNumVODate(SalesNumVO sendVO) {
		//同比去年时间
		sendVO.setYesteryearStartDate(DateUtil.getSpecifiedDayBeforeString(sendVO.getStartDate(),365));
		sendVO.setYesteryearEndDate(DateUtil.getSpecifiedDayBeforeString(sendVO.getEndDate(),365));
		//环比上周期时间
		int datint= DateUtil.differentDaysByMillisecond(sendVO.getStartDate(),sendVO.getEndDate());
		sendVO.setLastStartDate(DateUtil.getSpecifiedDayBeforeString(sendVO.getStartDate(),datint));
		sendVO.setLastEndDate(DateUtil.getSpecifiedDayBeforeString(sendVO.getEndDate(),datint));
    	return sendVO;
    }
	
	
}
