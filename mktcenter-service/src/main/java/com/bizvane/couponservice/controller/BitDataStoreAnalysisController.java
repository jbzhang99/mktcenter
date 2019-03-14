package com.bizvane.couponservice.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.bizvane.centerstageservice.models.po.SysBrandPo;
import com.bizvane.centerstageservice.models.po.SysCompanyPo;
import com.bizvane.centerstageservice.models.po.SysStoreGroupPo;
import com.bizvane.centerstageservice.models.po.SysStorePo;
import com.bizvane.centerstageservice.models.vo.SysAccountVo;
import com.bizvane.centerstageservice.models.vo.SysStoreVo;
import com.bizvane.centerstageservice.rpc.BrandServiceRpc;
import com.bizvane.centerstageservice.rpc.CompanyServiceRpc;
import com.bizvane.centerstageservice.rpc.StoreGroupServiceRpc;
import com.bizvane.centerstageservice.rpc.StoreServiceRpc;
import com.bizvane.couponfacade.models.vo.FindMembersVO;
import com.bizvane.couponservice.common.datavo.BackBitDataVO;
import com.bizvane.couponservice.common.datavo.BitDataVO;
import com.bizvane.couponservice.common.datavo.ReportTempPO;
import com.bizvane.couponservice.common.datavo.SortDataVO;
import com.bizvane.couponservice.common.utils.BaseData;
import com.bizvane.couponservice.mappers.CouponEntityPOMapper;
import com.bizvane.couponservice.service.CouponReportTempService;
import com.bizvane.mktcenterservice.common.report.BaseUrl;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.utils.tokens.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by yunjie.tian on 2018/7/20.
 */
@RestController
@RequestMapping("/bitDataStoreAnalysis")
public class BitDataStoreAnalysisController {
    private static final Logger logger = LoggerFactory.getLogger(BitDataStoreAnalysisController.class);
    
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private com.bizvane.mktcenterservice.common.report.BaseUrl BaseUrl;
    
	@Autowired
	private   CompanyServiceRpc companyServiceRpc;

	@Autowired
	private   CouponReportTempService couponReportTempService;

	@Autowired
	private  StoreServiceRpc storeServiceRpc;

	@Autowired
	private   StoreGroupServiceRpc storeGroupServiceRpc;
	
	@Autowired
	private    BrandServiceRpc brandServiceRpc;

	@Autowired
	private CouponEntityPOMapper couponEntityPOMapper;



     //店铺top10
    @RequestMapping("storeTop")
    public ResponseData<JSONObject> storeTop(BitDataVO sendVO, HttpServletRequest request){
		ResponseData<JSONObject> ResponseData = new ResponseData<JSONObject>();

		JSONObject backJSONObject = new JSONObject();
		
		JSONArray jSONArray = new JSONArray();
		JSONObject jSONObject = new JSONObject();
//		jSONObject.put("1", "10");
//		jSONObject.put("名字2", "4");
//		jSONArray.add(jSONObject);
		backJSONObject.put("achieveMap", jSONArray);
		

		JSONArray jSONArray2 = new JSONArray();
		JSONObject jSONObject2 = new JSONObject();
//		jSONObject2.put("1", "10");
//		jSONObject2.put("名字22", "4");
//		jSONArray2.add(jSONObject2);
		
		backJSONObject.put("guestPriceMap", jSONArray2);

		ResponseData = backJSONObjectTop10(sendVO, backJSONObject, BaseUrl.getLoadUrl("storeTop"), request);

		return ResponseData;
   }
    //群组top10
   @RequestMapping("areaTop")
   public ResponseData<JSONObject> areaTop(BitDataVO sendVO, HttpServletRequest request){
		ResponseData<JSONObject> ResponseData = new ResponseData<JSONObject>();

		JSONObject backJSONObject = new JSONObject();

		JSONArray jSONArray = new JSONArray();
		JSONObject jSONObject = new JSONObject();
//		jSONObject.put("5", "10");
//		jSONObject.put("161", "4");
//		jSONArray.add(jSONObject);
		backJSONObject.put("achieveMap", jSONArray);


		JSONArray jSONArray2 = new JSONArray();
		JSONObject jSONObject2 = new JSONObject();
//		jSONObject2.put("5", "222");
//		jSONObject2.put("161", "22");
//		jSONArray2.add(jSONObject2);

		backJSONObject.put("guestPriceMap", jSONArray2);

		// 用户下所有的群主
		List<Object> List =getStoreGroupIds(request,"");
		sendVO.setStoreIdsInArea((Map<String, java.util.List>) List.get(0));
        //转换群主名称
		JSONObject jSONGroup =(JSONObject) List.get(1);
		JSONObject jSONGroupName =new JSONObject();
		for (Object k : jSONGroup.keySet()) {
			SysStoreGroupPo sysStoreGroupPo=(SysStoreGroupPo) jSONGroup.get(k.toString());
			jSONGroupName.put(k.toString(), sysStoreGroupPo.getStoreGroupName());
		}
		//转换群主名称

		ResponseData = backJSONObjectGroupTop10(sendVO, jSONGroupName,backJSONObject, BaseUrl.getLoadUrl("areaTop"), request);
		return ResponseData;
  }
   
   //店铺优惠券
  @RequestMapping("storeVou")
  public ResponseData<BackBitDataVO> storeVou(BitDataVO sendVO, HttpServletRequest request){

		
		JSONArray jSONArray = new JSONArray();
		JSONObject backJSONObject = new JSONObject();
		backJSONObject.put("id", "1");
		backJSONObject.put("storeName", "");
		backJSONObject.put("salesVolume", "0");
		backJSONObject.put("guestPrice", "0");
		backJSONObject.put("jointRate", "0");
		backJSONObject.put("voucherUsedPerson", "0");
  		backJSONObject.put("pieceNumber", "2");//		件数
  		backJSONObject.put("achievements", "100");//	总业绩	
		backJSONObject.put("penNumber", "2");//		笔数
//		jSONArray.add(backJSONObject);

        //默认线下店铺id  "storeIds":["112","22","4"],
		
		sendVO.setStoreIds(getSysStoreIdstr(request,sendVO.getStoreIdstr()));
       
		//返回data
		ResponseData<BackBitDataVO> responseDataBack = new ResponseData<BackBitDataVO>();
        
		BackBitDataVO backBitDataVO =new BackBitDataVO();
		ResponseData<JSONArray> ResponseData = new ResponseData<JSONArray>();
		ResponseData = backJSONObjectHaveID(sendVO, jSONArray, BaseUrl.getLoadUrl("storeVou"), request);
		backBitDataVO.setList(ResponseData.getData());
		
		//计算总数条数
		ResponseData<JSONArray> ResponseDatatoTotal = new ResponseData<JSONArray>();
		
		sendVO.setStartRecord("1");
		sendVO.setQueryNum("10000000");
		ResponseDatatoTotal = backJSONObjectHaveID(sendVO, jSONArray, BaseUrl.getLoadUrl("storeVou"), request);
		JSONArray JSONArray=ResponseDatatoTotal.getData();
		backBitDataVO.setTotal(String.valueOf(JSONArray.size()));
		responseDataBack.setData(backBitDataVO);
		
		
		//导出
		if(sendVO.getExport()!=null) {
			ReportTempPO reportTempPO= new ReportTempPO();
			reportTempPO.setTemplateName("门店优惠券导出");
			reportTempPO.setReportDataName("参与门店,核销量,用券客单价,连带率,使用会员");
			reportTempPO.setReportData("storeName,salesVolume,guestPrice,jointRate,voucherUsedPerson");
			couponReportTempService.Export(TokenUtils.getStageUser(request), "", ResponseDatatoTotal.getData().toString(), reportTempPO);
			responseDataBack.setMessage("导出中");
		}
		
		return responseDataBack;
		
 }
  
  //群组-优惠券
 @RequestMapping("areaVou")
 public ResponseData<BackBitDataVO> areaVou(BitDataVO sendVO, HttpServletRequest request){
		ResponseData<JSONArray> ResponseData = new ResponseData<JSONArray>();

		JSONArray jSONArray = new JSONArray();
		JSONObject backJSONObject = new JSONObject();
//		backJSONObject.put("id", "5");
//		backJSONObject.put("groupName", "");
//		backJSONObject.put("salesVolume", "0");
//		backJSONObject.put("guestPrice", "0");
//		backJSONObject.put("jointRate", "0");
//		backJSONObject.put("voucherUsedPerson", "0");
//		backJSONObject.put("pieceNumber", "2");//		件数
//		backJSONObject.put("achievements", "100");//	总业绩	
//		backJSONObject.put("penNumber", "2");//		笔数
//		jSONArray.add(backJSONObject);

		
		// 用户下所有的群主
		List<Object> List =getStoreGroupIds(request,"");
		
		//找群主id对应的店铺关系
		if(StringUtils.isBlank(sendVO.getStoreIdstr())) {
			sendVO.setStoreIdsInArea((Map<String, java.util.List>) List.get(0));
		}else {
			//搜索框群主
			Map<String, java.util.List> mapAll= (Map<String, java.util.List>) List.get(0);
			Map<String, java.util.List> mapSend= new HashMap<>();
			for (String AreaId : sendVO.getStoreIdstr().split(",")) {
				mapSend.put(AreaId, mapAll.get(AreaId));
			}
			sendVO.setStoreIdsInArea((mapSend));
		}
		
        //转换群主名称
		JSONObject jSONGroup =(JSONObject) List.get(1);
		JSONObject jSONGroupName =new JSONObject();
		for (Object k : jSONGroup.keySet()) {
			SysStoreGroupPo sysStoreGroupPo=(SysStoreGroupPo) jSONGroup.get(k.toString());
			jSONGroupName.put(k.toString(), sysStoreGroupPo.getStoreGroupName());
		}
		//转换群主名称

//		ResponseData = backJSONObjectHaveGroup(sendVO, jSONGroupName,jSONArray, BaseUrl.getLoadUrl("areaVou"), request);
		
		//返回data
		ResponseData<BackBitDataVO> responseDataBack = new ResponseData<BackBitDataVO>();
        
		BackBitDataVO backBitDataVO =new BackBitDataVO();
        ResponseData = backJSONObjectHaveGroup(sendVO, jSONGroupName,jSONArray, BaseUrl.getLoadUrl("areaVou"), request);
		backBitDataVO.setList(ResponseData.getData());
		
		//计算总数条数
		ResponseData<JSONArray> ResponseDatatoTotal = new ResponseData<JSONArray>();
		
		sendVO.setStartRecord("1");
		sendVO.setQueryNum("10000000");
		ResponseDatatoTotal = backJSONObjectHaveGroup(sendVO, jSONGroupName,jSONArray, BaseUrl.getLoadUrl("areaVou"), request);
		JSONArray JSONArray=ResponseDatatoTotal.getData();
		backBitDataVO.setTotal(String.valueOf(JSONArray.size()));
		responseDataBack.setData(backBitDataVO);

		//导出
		if(sendVO.getExport()!=null) {
			ReportTempPO reportTempPO= new ReportTempPO();
			reportTempPO.setTemplateName("群组优惠券导出");
			reportTempPO.setReportDataName("所属群组,核销量,用券客单价,连带率,使用会员");
			reportTempPO.setReportData("groupName,salesVolume,guestPrice,jointRate,voucherUsedPerson");
			couponReportTempService.Export(TokenUtils.getStageUser(request), "", ResponseDatatoTotal.getData().toString(), reportTempPO);
			ResponseData.setMessage("导出中");
		}

		return responseDataBack;
		
}
  
  //店铺-业绩
  @RequestMapping("storeAchievements")
  public ResponseData<BackBitDataVO> storeAchievements(BitDataVO sendVO, HttpServletRequest request){
  		ResponseData<JSONArray> ResponseData = new ResponseData<JSONArray>();
  		JSONArray jSONArray = new JSONArray();
  		JSONObject backJSONObject = new JSONObject();
  		backJSONObject.put("id", "1");
  		backJSONObject.put("storeName", "");
  		backJSONObject.put("totalAchievements", "0");//		totalAchievements	总成交额
  		backJSONObject.put("useVouAchievements", "0");//		useVouAchievements	用券成交额
  		backJSONObject.put("useVouAchievementsGrowth", "0");//		useVouAchievementsGrowth	成交额占比
  		backJSONObject.put("totalNum", "0");//		totalNum	总订单量
  		backJSONObject.put("useVouNum", "0");//		useVouNum	用券订单量
  		backJSONObject.put("useVouNumGrowth", "0");//		useVouNumGrowth	用券订单量占比
  		backJSONObject.put("discount", "0");//		discount	券优惠金额
  		backJSONObject.put("roi", "0");//		Roi	券ROI
  		
  		backJSONObject.put("pieceNumber", "100");//		总业绩
  		backJSONObject.put("achievements", "2");//		件数
		backJSONObject.put("penNumber", "2");//		笔数
//  		jSONArray.add(backJSONObject);

		
        //默认线下店铺id  "storeIds":["112","22","4"],
		sendVO.setStoreIds(getSysStoreIdstr(request,sendVO.getStoreIdstr()));

		
		
		
		//返回data
		ResponseData<BackBitDataVO> responseDataBack = new ResponseData<BackBitDataVO>();
        
		BackBitDataVO backBitDataVO =new BackBitDataVO();
		ResponseData = backJSONObjectHaveID(sendVO, jSONArray, BaseUrl.getLoadUrl("storeAchievements"), request);
		backBitDataVO.setList(ResponseData.getData());
		
		//计算总数条数
		ResponseData<JSONArray> ResponseDatatoTotal = new ResponseData<JSONArray>();
		
		sendVO.setStartRecord("1");
		sendVO.setQueryNum("10000000");
		ResponseDatatoTotal = backJSONObjectHaveID(sendVO, jSONArray, BaseUrl.getLoadUrl("storeAchievements"), request);
		JSONArray JSONArray=ResponseDatatoTotal.getData();
		backBitDataVO.setTotal(String.valueOf(JSONArray.size()));
		responseDataBack.setData(backBitDataVO);
		

		//导出
		if(sendVO.getExport()!=null) {
			ReportTempPO reportTempPO= new ReportTempPO();
			reportTempPO.setTemplateName("门店业绩导出");
			reportTempPO.setReportDataName("参与门店,总成交额,券成交额,成交额占比,总订单量,用券订单量,用券订单量占比,券优惠金额,券ROI");
			reportTempPO.setReportData("storeName,totalAchievements,useVouAchievements,useVouAchievementsGrowth,totalNum,useVouNum,useVouNumGrowth,discount,roi");
			couponReportTempService.Export(TokenUtils.getStageUser(request), "", responseDataBack.getData().toString(), reportTempPO);
			ResponseData.setMessage("导出中");
		}
  		return responseDataBack;

  }
  

 


//群组业绩
@RequestMapping("areaAchievements")
public ResponseData<BackBitDataVO> areaAchievements(BitDataVO sendVO, HttpServletRequest request){
		ResponseData<JSONArray> ResponseData = new ResponseData<JSONArray>();
		JSONArray jSONArray = new JSONArray();
		JSONObject backJSONObject = new JSONObject();
		
		backJSONObject.put("id", "5");
		backJSONObject.put("groupName", "群主ID名称");
		backJSONObject.put("totalAchievements", "0");//		totalAchievements	总成交额
		backJSONObject.put("useVouAchievements", "0");//		useVouAchievements	用券成交额
		backJSONObject.put("useVouAchievementsGrowth", "0");//		useVouAchievementsGrowth	成交额占比
		backJSONObject.put("totalNum", "0");//		totalNum	总订单量
		backJSONObject.put("useVouNum", "0");//		useVouNum	用券订单量
		backJSONObject.put("useVouNumGrowth", "0");//		useVouNumGrowth	用券订单量占比
		backJSONObject.put("discount", "0");//		discount	券优惠金额
		backJSONObject.put("roi", "0");//		Roi	券ROI
//		jSONArray.add(backJSONObject);
		// 用户下所有的群主
		List<Object> List =getStoreGroupIds(request,"");
		
		//找群主id对应的店铺关系
		if(StringUtils.isBlank(sendVO.getStoreIdstr())) {
			sendVO.setStoreIdsInArea((Map<String, java.util.List>) List.get(0));
		}else {
			//搜索框群主
			Map<String, java.util.List> mapAll= (Map<String, java.util.List>) List.get(0);
			Map<String, java.util.List> mapSend= new HashMap<>();
			for (String AreaId : sendVO.getStoreIdstr().split(",")) {
				mapSend.put(AreaId, mapAll.get(AreaId));
			}
			sendVO.setStoreIdsInArea((mapSend));
		}
        //转换群主名称
		JSONObject jSONGroup =(JSONObject) List.get(1);
		JSONObject jSONGroupName =new JSONObject();
		for (Object k : jSONGroup.keySet()) {
			SysStoreGroupPo sysStoreGroupPo=(SysStoreGroupPo) jSONGroup.get(k.toString());
			jSONGroupName.put(k.toString(), sysStoreGroupPo.getStoreGroupName());
		}
		//转换群主名称

		
		//返回data
		ResponseData<BackBitDataVO> responseDataBack = new ResponseData<BackBitDataVO>();
        
		BackBitDataVO backBitDataVO =new BackBitDataVO();
		ResponseData = backJSONObjectHaveGroup(sendVO, jSONGroupName,jSONArray, BaseUrl.getLoadUrl("areaAchievements"), request);
		backBitDataVO.setList(ResponseData.getData());
		
		//计算总数条数
		ResponseData<JSONArray> ResponseDatatoTotal = new ResponseData<JSONArray>();
		
		sendVO.setStartRecord("1");
		sendVO.setQueryNum("10000000");
		ResponseDatatoTotal = backJSONObjectHaveGroup(sendVO, jSONGroupName,jSONArray, BaseUrl.getLoadUrl("areaAchievements"), request);
		JSONArray JSONArray=ResponseDatatoTotal.getData();
		backBitDataVO.setTotal(String.valueOf(JSONArray.size()));
		responseDataBack.setData(backBitDataVO);
		
		
		
		//导出
		if(sendVO.getExport()!=null) {
			ReportTempPO reportTempPO= new ReportTempPO();
			reportTempPO.setTemplateName("群组业绩导出");
			reportTempPO.setReportDataName("所属群组,总成交额,券成交额,成交额占比,总订单量,用券订单量,用券订单量占比,券优惠金额,券ROI");
			reportTempPO.setReportData("groupName,totalAchievements,useVouAchievements,useVouAchievementsGrowth,totalNum,useVouNum,useVouNumGrowth,discount,roi");
			couponReportTempService.Export(TokenUtils.getStageUser(request), "", ResponseData.getData().toString(), reportTempPO);
			ResponseData.setMessage("导出中");
		}
		return responseDataBack;

}



// 店铺top10
public ResponseData<JSONObject> backJSONObjectTop10(BitDataVO sendVO, JSONObject backJSONObject, String analysisUrl,HttpServletRequest request) {

	// 获取用户key和企业编号
	JSONObject jsonObject = getSendApiKeyJSONObject(JSONObject.parseObject(JSONObject.toJSONString(sendVO)),request);
	SysAccountPO sysAccountPO = TokenUtils.getStageUser(request);
	ResponseData<JSONObject> ResponseData = new ResponseData<JSONObject>();
	ResponseEntity<String> response = null;
	try {
		logger.info("大数据请求入参BitDataController：" + analysisUrl + jsonObject.toString());
		response = this.restTemplate.postForEntity(analysisUrl, jsonObject, String.class, new Object[0]);
	} catch (Exception e) {
		ResponseData.setCode(500);
		ResponseData.setMessage("大数据服务异常" + e.getMessage() );
		ResponseData.setData(backJSONObject);
		return ResponseData;
	}

	JSONObject jobObject = JSONObject.parseObject(response.getBody());
	if (jobObject.get("successFlag").equals("1")) {
		 backJSONObject = jobObject.getJSONObject("data");
	}


		JSONObject backJSONObjectend = new JSONObject();
		JSONArray jSONArrayAchieveMap = new JSONArray();
		JSONArray jSONArrayGuestPriceMap = new JSONArray();

		JSONArray   achieveMap =backJSONObject.getJSONArray("achieveMap");
		JSONArray   guestPriceMap =backJSONObject.getJSONArray("guestPriceMap");

		JSONObject jSONObjectAchieveMap = new JSONObject(true);
		JSONObject jSONObjectGuestPriceMap = new JSONObject(true);
		
		List<SortDataVO> listA  = new ArrayList<>();
		for(int i=0;i<achieveMap.size();i++){
			JSONObject jobtopID = achieveMap.getJSONObject(i); // 遍历 jsonarray 数组，把每一个对象转成
			for (Object k : jobtopID.keySet()) {
				//top 10排序
				SortDataVO testA2 = new SortDataVO();
				testA2.setNameKey(getStoreNameBystoreid(sysAccountPO.getSysCompanyId(),k.toString()));
				testA2.setBigDecimalVal(new BigDecimal(jobtopID.get(k).toString()));
				listA.add(testA2);
			}
		}

		
		
		List<SortDataVO> list  = new ArrayList<>();
		for(int i=0;i<guestPriceMap.size();i++){
			JSONObject jobtopID = guestPriceMap.getJSONObject(i); // 遍历 jsonarray 数组，把每一个对象转成
			for (Object k : jobtopID.keySet()) {
				SortDataVO testA2 = new SortDataVO();
				testA2.setNameKey(getStoreNameBystoreid(sysAccountPO.getSysCompanyId(),k.toString()));
				testA2.setBigDecimalVal(new BigDecimal(jobtopID.get(k).toString()));
				list.add(testA2);
			}

		}
		Collections.sort(listA, new Comparator<SortDataVO>() {
            @Override
            public int compare(SortDataVO o1, SortDataVO o2) {
              //升序
            	 return o1.getBigDecimalVal().compareTo(o2.getBigDecimalVal());
              //降序
//                return o2.getBigDecimalVal().compareTo(o1.getBigDecimalVal());
            }
        });
		
		for (SortDataVO sortDataVO : listA) {
			jSONObjectAchieveMap.put(sortDataVO.getNameKey(), sortDataVO.getBigDecimalVal());
		}
		
		Collections.sort(list, new Comparator<SortDataVO>() {
            @Override
            public int compare(SortDataVO o1, SortDataVO o2) {
              //升序
            	 return o1.getBigDecimalVal().compareTo(o2.getBigDecimalVal());
              //降序
//                return o2.getBigDecimalVal().compareTo(o1.getBigDecimalVal());
            }
        });
		
		for (SortDataVO sortDataVO : list) {
			jSONObjectGuestPriceMap.put(sortDataVO.getNameKey(), sortDataVO.getBigDecimalVal());
		}
		
		jSONArrayAchieveMap.add(jSONObjectAchieveMap);
		jSONArrayGuestPriceMap.add(jSONObjectGuestPriceMap);
		backJSONObjectend.put("achieveMap", jSONArrayAchieveMap);
		backJSONObjectend.put("guestPriceMap", jSONArrayGuestPriceMap);
		ResponseData.setData(backJSONObjectend);
	

	ResponseData.setCode(0);
	ResponseData.setMessage(jobObject.toString()+"大数据请求:" + analysisUrl + jsonObject.toString());
	return ResponseData;

}


//群主top10
public ResponseData<JSONObject> backJSONObjectGroupTop10(BitDataVO sendVO, JSONObject groupJSONObject,  JSONObject backJSONObject, String analysisUrl,HttpServletRequest request) {

	// 获取用户key和企业编号
	JSONObject jsonObject = getSendApiKeyJSONObject(JSONObject.parseObject(JSONObject.toJSONString(sendVO)),request);
	ResponseData<JSONObject> ResponseData = new ResponseData<JSONObject>();
	ResponseEntity<String> response = null;
	try {
		logger.info("大数据请求入参BitDataController：" + analysisUrl + jsonObject.toString());
		response = this.restTemplate.postForEntity(analysisUrl, jsonObject, String.class, new Object[0]);
	} catch (Exception e) {
		ResponseData.setCode(500);
		ResponseData.setMessage("大数据服务异常" + e.getMessage() );
		ResponseData.setData(backJSONObject);
		return ResponseData;
	}

	JSONObject jobObject = JSONObject.parseObject(response.getBody());
	if (jobObject.get("successFlag").equals("1")) {
		 backJSONObject = jobObject.getJSONObject("data");
	}


	List<SortDataVO> listA  = new ArrayList<>();
	List<SortDataVO> list = new ArrayList<>();
	
		JSONObject backJSONObjectend = new JSONObject();
		JSONArray jSONArrayAchieveMap = new JSONArray();
		JSONArray jSONArrayGuestPriceMap = new JSONArray();

		JSONArray   achieveMap =backJSONObject.getJSONArray("achieveMap");
		JSONArray   guestPriceMap =backJSONObject.getJSONArray("guestPriceMap");

		JSONObject jSONObjectAchieveMap = new JSONObject(true);
		JSONObject jSONObjectGuestPriceMap = new JSONObject(true);
		for(int i=0;i<achieveMap.size();i++){
			JSONObject jobtopID = achieveMap.getJSONObject(i); // 遍历 jsonarray 数组，把每一个对象转成
			for (Object k : jobtopID.keySet()) {
//				jSONObjectAchieveMap.put(groupJSONObject.getString(k.toString()), jobtopID.get(k).toString());
				SortDataVO testA2 = new SortDataVO();
				testA2.setNameKey(groupJSONObject.getString(k.toString()));
				testA2.setBigDecimalVal(new BigDecimal(jobtopID.get(k).toString()));
				listA.add(testA2);
				
			}
		}

		for(int i=0;i<guestPriceMap.size();i++){
			JSONObject jobtopID = guestPriceMap.getJSONObject(i); // 遍历 jsonarray 数组，把每一个对象转成
			for (Object k : jobtopID.keySet()) {
//				jSONObjectGuestPriceMap.put(groupJSONObject.getString(k.toString()), jobtopID.get(k).toString());
				
				SortDataVO testA2 = new SortDataVO();
				testA2.setNameKey(groupJSONObject.getString(k.toString()));
				testA2.setBigDecimalVal(new BigDecimal(jobtopID.get(k).toString()));
				list.add(testA2);
			}
		}
		
		
		Collections.sort(listA, new Comparator<SortDataVO>() {
            @Override
            public int compare(SortDataVO o1, SortDataVO o2) {
              //升序
            	 return o1.getBigDecimalVal().compareTo(o2.getBigDecimalVal());
              //降序
//                return o2.getBigDecimalVal().compareTo(o1.getBigDecimalVal());
            }
        });
		
		for (SortDataVO sortDataVO : listA) {
			jSONObjectAchieveMap.put(sortDataVO.getNameKey(), sortDataVO.getBigDecimalVal());
		}
		
		Collections.sort(list, new Comparator<SortDataVO>() {
            @Override
            public int compare(SortDataVO o1, SortDataVO o2) {
              //升序
            	 return o1.getBigDecimalVal().compareTo(o2.getBigDecimalVal());
              //降序
//                return o2.getBigDecimalVal().compareTo(o1.getBigDecimalVal());
            }
        });
		
		for (SortDataVO sortDataVO : list) {
			jSONObjectGuestPriceMap.put(sortDataVO.getNameKey(), sortDataVO.getBigDecimalVal());
		}

		jSONArrayAchieveMap.add(jSONObjectAchieveMap);
		jSONArrayGuestPriceMap.add(jSONObjectGuestPriceMap);
		backJSONObjectend.put("achieveMap", jSONArrayAchieveMap);
		backJSONObjectend.put("guestPriceMap", jSONArrayGuestPriceMap);
		ResponseData.setData(backJSONObjectend);
	
	
	ResponseData.setCode(0);
	ResponseData.setMessage(jobObject.toString()+"大数据请求:" + analysisUrl + jsonObject.toString());
	return ResponseData;

}
//前提是String的格式是map或json类型的
//String 转Json
//JSONObject  jasonObject = JSONObject.fromObject(str);
//String 转Map
//JSONObject  jasonObject = JSONObject.fromObject(str);
//Map map = (Map)jasonObject;	
//使用会员列表
//线下店铺id和券批次号， 搜索，会员姓名/昵称  ，会员卡号，会员手机号
//群组业绩
	@RequestMapping("findMembersList")
	public ResponseData<PageInfo<FindMembersVO>> findMembersList(FindMembersVO findMembersVO, HttpServletRequest request){
		List<FindMembersVO> findMemberslist=null;
		ResponseData<PageInfo<FindMembersVO>> responseData = new ResponseData<>();
		if(findMembersVO.getExport()!=null) {
		findMemberslist = couponEntityPOMapper.getFindMembersVo(findMembersVO);
			//导出
			ReportTempPO reportTempPO= new ReportTempPO();
			reportTempPO.setTemplateName("会员列表导出");
			reportTempPO.setReportDataName("使用时间,会员姓名,会员微信昵称,会员卡号,会员手机号");
			reportTempPO.setReportData("time,membersName,nickname,cardNo,phone");
			
			JSONArray jSONArray = new JSONArray();
			for(FindMembersVO findMembers:findMemberslist ) {
				jSONArray.add(JSONObject.toJSON(findMembers));
				
			}
			
			couponReportTempService.Export(TokenUtils.getStageUser(request), "", jSONArray.toString(), reportTempPO);
			responseData.setMessage("导出中");
		}else {
			PageHelper.startPage(findMembersVO.getPageNumber(),findMembersVO.getPageSize());
			findMemberslist = couponEntityPOMapper.getFindMembersVo(findMembersVO);
		}

    
    PageInfo<FindMembersVO> pageInfonewEntityVOList = new PageInfo<>(findMemberslist);
    responseData.setData(pageInfonewEntityVOList);
    
	return responseData;
	
	}
   
    // 解析大数据,店铺优惠券
	public ResponseData<JSONArray> backJSONObjectHaveID(BitDataVO sendVO, JSONArray backJSONObject, String analysisUrl,HttpServletRequest request) {

		// 获取用户key和企业编号
		JSONObject jsonObject = getSendApiKeyJSONObject(JSONObject.parseObject(JSONObject.toJSONString(sendVO)),request);

		ResponseData<JSONArray> ResponseData = new ResponseData<JSONArray>();
		ResponseEntity<String> response = null;
		ResponseEntity<String> responseALL = null;
		try {
			logger.info("大数据请求入参BitDataController：" + analysisUrl + jsonObject.toString());
			response = this.restTemplate.postForEntity(analysisUrl, jsonObject, String.class, new Object[0]);
			
			//总数
			jsonObject.put("startRecord", "1");
			jsonObject.put("queryNum", "10000000");
			
			responseALL = this.restTemplate.postForEntity(analysisUrl, jsonObject, String.class, new Object[0]);
		} catch (Exception e) {
			ResponseData.setCode(500);
			ResponseData.setMessage("大数据服务异常" + e.getMessage() );
			ResponseData.setData(backJSONObject);
			return ResponseData;
		}
		JSONObject jobObject = JSONObject.parseObject(response.getBody());


		List<String> JSONStringTOlist=BaseData.JSONStringTOlist(backJSONObject.toString());
		//如果有数据就用不补0数据
		if (jobObject.get("successFlag").equals("1")) {
			  JSONStringTOlist=BaseData.JSONStringTOlist(jobObject.getString("data"));
		}
		JSONArray backJSONObjectadd= new JSONArray();
		 for (String string: JSONStringTOlist) {
			JSONObject json = JSONObject.parseObject(string);
			// 店铺名称转换 根据id找名字
            List<String> storeIds = new ArrayList<>();
            storeIds.add(json.get("id").toString());
            List<SysStorePo> sysStorePoList = storeServiceRpc.getCouponStoreIdList(storeIds).getData();
            if(CollectionUtils.isNotEmpty(sysStorePoList)) {
            	json.put("storeName", sysStorePoList.get(0).getStoreName());
            }
               //  如果是业绩
				if(analysisUrl.endsWith("storeAchievements")) {
					json.put("useVouAchievementsGrowth", BaseData.growthNot(json.getString("useVouAchievements"),json.getString("totalAchievements")));
					json.put("useVouNumGrowth", BaseData.growthNot(json.getString("useVouNum"),json.getString("totalAchievements")));
					json.put("roi", BaseData.growthNot(json.getString("useVouAchievements"),json.getString("discount")));
					
				}else {
					 json.put("guestPrice", BaseData.guestPrice(json.getString("achievements"),json.getString("pieceNumber")));//用券客单价 总业绩/件数
					 json.put("jointRate", BaseData.growthNotTow(json.getString("pieceNumber"),json.getString("penNumber")));//连带率：销售总数量 ÷ 销售小票数量；连带率=件数/笔数
				}
				
				//加元符号
				for (Object k : json.keySet()) {
					if(k.toString().equals("totalAchievements")) {
						json.put("totalAchievements", "¥"+json.get(k));
					}else if(k.toString().equals("useVouAchievements")) {
						json.put("useVouAchievements", "¥"+json.get(k));
					}if(k.toString().equals("discount")) {
						json.put("discount", "¥"+json.get(k));
					}if(k.toString().equals("guestPrice")) {
						json.put("guestPrice", "¥"+json.get(k));
					}	
				}
			
            backJSONObjectadd.add(json);
		}
		ResponseData.setCode(0);
		ResponseData.setMessage(jobObject.toString()+"大数据请求:" + analysisUrl + jsonObject.toString());
		ResponseData.setData(backJSONObjectadd);
		return ResponseData;

	}
	
	
    // 群主-优惠券
	public ResponseData<JSONArray> backJSONObjectHaveGroup(BitDataVO sendVO,JSONObject jSONGroupName,JSONArray backJSONObject, String analysisUrl,HttpServletRequest request) {

		// 获取用户key和企业编号
		JSONObject jsonObject = getSendApiKeyJSONObject(JSONObject.parseObject(JSONObject.toJSONString(sendVO)),request);

		ResponseData<JSONArray> ResponseData = new ResponseData<JSONArray>();
		ResponseEntity<String> response = null;
		try {
			logger.info("大数据请求入参BitDataController：" + analysisUrl + jsonObject.toString());
			response = this.restTemplate.postForEntity(analysisUrl, jsonObject, String.class, new Object[0]);
		} catch (Exception e) {
			ResponseData.setCode(500);
			ResponseData.setMessage("大数据服务异常" + e.getMessage() );
			ResponseData.setData(backJSONObject);
			return ResponseData;
		}
		JSONObject jobObject = JSONObject.parseObject(response.getBody());


		List<String> JSONStringTOlist=BaseData.JSONStringTOlist(backJSONObject.toString());
		//如果有数据就用不补0数据
		if (jobObject.get("successFlag").equals("1")) {
			  JSONStringTOlist=BaseData.JSONStringTOlist(jobObject.getString("data"));
		}
		JSONArray backJSONObjectadd= new JSONArray();
		 for (String string: JSONStringTOlist) {
			JSONObject json = JSONObject.parseObject(string);
			// 群主名称
			
			 json.put("groupName", jSONGroupName.getString(json.getString("id")));
			 
             //  如果是业绩
				if(analysisUrl.endsWith("areaAchievements")) {
					json.put("useVouAchievementsGrowth", BaseData.growthNot(json.getString("useVouAchievements"),json.getString("totalAchievements")));
					json.put("useVouNumGrowth", BaseData.growthNot(json.getString("useVouNum"),json.getString("totalNum")));
					json.put("roi", BaseData.growthNot(json.getString("useVouAchievements"),json.getString("discount")));
				}else {
					 json.put("guestPrice", BaseData.guestPrice(json.getString("achievements"),json.getString("pieceNumber")));//用券客单价 总业绩/件数
					 json.put("jointRate", BaseData.growthNotTow(json.getString("pieceNumber"),json.getString("penNumber")));//连带率：销售总数量 ÷ 销售小票数量；连带率=件数/笔数
				}
				
				//加元符号
				for (Object k : json.keySet()) {
					if(k.toString().equals("totalAchievements")) {
						json.put("totalAchievements", "¥"+json.get(k));
					}else if(k.toString().equals("useVouAchievements")) {
						json.put("useVouAchievements", "¥"+json.get(k));
					}if(k.toString().equals("discount")) {
						json.put("discount", "¥"+json.get(k));
					}if(k.toString().equals("guestPrice")) {
						json.put("guestPrice", "¥"+json.get(k));
					}	 
				}
				
            backJSONObjectadd.add(json);
		}
		ResponseData.setCode(0);
		ResponseData.setMessage(jobObject.toString()+"大数据请求:" + analysisUrl + jsonObject.toString());
		ResponseData.setData(backJSONObjectadd);
		return ResponseData;

	}
	
    // 群主-优惠券
	public ResponseData<List<JSONObject>> backJSONObjectHaveIDVou(JSONObject jsonObjectVou, List<JSONObject> backJSONObject, String analysisUrl,HttpServletRequest request) {

		// 获取用户key和企业编号
		JSONObject jsonObject = getSendApiKeyJSONObject(jsonObjectVou,request);
				
		ResponseData<List<JSONObject>> ResponseData = new ResponseData<List<JSONObject>>();
		ResponseEntity<String> response = null;
		try {
			logger.info("大数据请求入参BitDataController：" + analysisUrl + jsonObject.toString());
			response = this.restTemplate.postForEntity(analysisUrl, jsonObject, String.class, new Object[0]);
		} catch (Exception e) {
			ResponseData.setCode(500);
			ResponseData.setMessage("大数据服务异常" + e.getMessage() );
			ResponseData.setData(backJSONObject);
			return ResponseData;
		}

		JSONObject jobObject = JSONObject.parseObject(response.getBody());
		if (jobObject.get("successFlag").equals("1")) {
			JSONObject job = jobObject.getJSONObject("data");
			for (Object k : job.keySet()) {
				JSONObject json = JSONObject.parseObject(job.get(k).toString());
				// TODO 店铺名称转换
				json.put(k.toString(), "店铺群主TODO");
				backJSONObject.add(json);
				
			}
		}
		ResponseData.setCode(0);
		ResponseData.setMessage(jobObject.toString()+"大数据请求:" + analysisUrl + jsonObject.toString());
		ResponseData.setData(backJSONObject);
		return ResponseData;

	}
	
	 // 解析大数据不带时间的数据
		public ResponseData<JSONObject> backJSONObject(BitDataVO sendVO, JSONObject backJSONObject, String analysisUrl,HttpServletRequest request) {

			// 获取用户key和企业编号
			JSONObject jsonObject = getSendApiKeyJSONObject(JSONObject.parseObject(JSONObject.toJSONString(sendVO)),request);
					
			ResponseData<JSONObject> ResponseData = new ResponseData<JSONObject>();
			ResponseEntity<String> response = null;
			try {
				logger.info("大数据请求入参BitDataController：" + analysisUrl + jsonObject.toString());
				response = this.restTemplate.postForEntity(analysisUrl, jsonObject, String.class, new Object[0]);
			} catch (Exception e) {
				ResponseData.setCode(500);
				ResponseData.setMessage("大数据服务异常" + e.getMessage() );
				ResponseData.setData(backJSONObject);
				return ResponseData;
			}

			JSONObject jobObject = JSONObject.parseObject(response.getBody());
			if (jobObject.get("successFlag").equals("1")) {
				JSONObject job = jobObject.getJSONObject("data");
				for (Object k : job.keySet()) {
					JSONObject json = JSONObject.parseObject(job.get(k).toString());
					for (Object kk : json.keySet()) {
						backJSONObject.put(kk.toString(), json.get(kk).toString());
					}
				}
			}
			ResponseData.setCode(0);
			ResponseData.setMessage(jobObject.toString()+"大数据请求:" + analysisUrl + jsonObject.toString());
			ResponseData.setData(backJSONObject);
			return ResponseData;

		}
		  //根据线下店铺id找店铺名称
		public String getStoreNameBystoreid(Long sysCompanyId,String storeid ) {

		  List<String> storellist =new ArrayList<>();
		  storellist.add(storeid);

		  SysStoreVo sysStoreVo =new SysStoreVo();
		  sysStoreVo.setStoreIds(storellist);
		  sysStoreVo.setSysCompanyId(sysCompanyId);
		  ResponseData<Map<String, SysStoreVo>> getStore = storeServiceRpc.getStoreGroupNameByStoreCodes(sysStoreVo);
		  Map<String, SysStoreVo> storeVoMap=  getStore.getData();
		  SysStoreVo storeVo=  storeVoMap.get(storeid);
		  String storeName="";
		  if(storeVo!=null&&storeVo.getStoreName()!=null) {
			  storeName=storeVo.getStoreName();
		  }
		  return  storeName;
		}
		public List<Object> getStoreGroupIds(HttpServletRequest request,String organizationContentStr ) {

	        //查询品牌下的店铺列表
	        SysAccountPO vo = TokenUtils.getStageUser(request);
	        SysAccountVo sysAccountVo = new SysAccountVo();
	        sysAccountVo.setSysBrandId(vo.getBrandId().toString());
	        sysAccountVo.setSysAccountId(vo.getSysAccountId());

	        JSONObject storeGroupJson = storeGroupServiceRpc.getCounponStoreGroupList(sysAccountVo).getData();
	        JSONObject storeGroupDataJson = new JSONObject();
	        Map<String, List> storeGroupList = new HashMap<>();
	        if (storeGroupJson != null) {
	            LinkedHashMap<String, String> jsonMap = JSON.parseObject(JSON.toJSONString(storeGroupJson), new TypeReference<LinkedHashMap<String, String>>() {
	            });

	            for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
	                String[] key = entry.getKey().split(",");
	                String[] list = entry.getValue().replace("[", "").replace("]", "").split(",");
	                storeGroupList.put(key[0], Arrays.asList(list));
	                SysStoreGroupPo sysStoreGroupPo = new SysStoreGroupPo();
	                sysStoreGroupPo.setSysStoreGroupCode(key[1]);
	                sysStoreGroupPo.setStoreGroupName(key[2]);
	                storeGroupDataJson.put(key[0], sysStoreGroupPo);
	            }
	        }
	        List<Object> List =new ArrayList<>();
	        List.add(storeGroupList);
	        List.add(storeGroupDataJson);
			return List;
		}
		//店铺id
		public String[] getSysStoreIdstr(HttpServletRequest request,String organizationContentStr ) {


			 //组织转换
			if (StringUtils.isNotBlank(organizationContentStr)) {

				int i = 0;
				for (String tr : organizationContentStr.split(",")) {
					i++;
				}
				String[] al = new String[i];
				i = 0;
				for (String trLong : organizationContentStr.split(",")) {
					al[i++] = trLong;
				}
				return al;
			}

	       //是空就获取当前用户，所有店铺id
			String[] str = new String[] {};
			try {
				SysStoreVo staffVo = new SysStoreVo();
				SysAccountPO currentUser = TokenUtils.getStageUser(request);
				System.out.println("当前用户" + JSONObject.toJSONString(currentUser));
				staffVo.setSysCompanyId(currentUser.getSysCompanyId());
				staffVo.setSysBrandId(currentUser.getBrandId());
				staffVo.setSysAccountId(currentUser.getSysAccountId());

				ResponseData<PageInfo<SysStoreVo>> SysStoreVo = storeServiceRpc
						.getSysStoreList(staffVo);

				staffVo.setPageSize(Integer.parseInt(String.valueOf(SysStoreVo.getData().getTotal())));
				ResponseData<PageInfo<com.bizvane.centerstageservice.models.vo.SysStoreVo>> SysStoreVo2 = storeServiceRpc
						.getSysStoreList(staffVo);
				str = new String[SysStoreVo2.getData().getList().size()];
				int i = 0;
				for (SysStoreVo sysStore : SysStoreVo2.getData().getList()) {
					str[i++] = sysStore.getStoreId();
				}
			} catch (Exception e) {
				System.out.println("获取当前用户，所有店铺id出错" + e);

			}
			return str;
		}
	// 获取用户key和企业编号
	public JSONObject getSendApiKeyJSONObject(JSONObject jsonObject, HttpServletRequest request) {
		
		jsonObject.put("businessNum", BaseUrl.getBusinessNum());
		jsonObject.put("apiKey", BaseUrl.getApiKey());
		SysAccountPO sysAccountPO = TokenUtils.getStageUser(request);
		
		// 获取线下的品牌code
		SysBrandPo sysBrandPo = brandServiceRpc.getBrandByID(sysAccountPO.getBrandId()).getData();
		jsonObject.put("brandId", sysBrandPo.getBrandCode());

		ResponseData<SysCompanyPo> SysCompanyP = companyServiceRpc.getCompanyById(sysAccountPO.getSysCompanyId());
		jsonObject.put("corpId", SysCompanyP.getData().getCompanyCode());

		return jsonObject;
	}

   


}