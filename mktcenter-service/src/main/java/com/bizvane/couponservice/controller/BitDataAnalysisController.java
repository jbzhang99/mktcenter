package com.bizvane.couponservice.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bizvane.centerstageservice.models.po.SysAccountPo;
import com.bizvane.centerstageservice.models.po.SysBrandPo;
import com.bizvane.centerstageservice.models.po.SysCompanyPo;
import com.bizvane.centerstageservice.rpc.BrandServiceRpc;
import com.bizvane.centerstageservice.rpc.CompanyServiceRpc;
import com.bizvane.couponfacade.models.vo.CouponFindCouponCountResponseVO;
import com.bizvane.couponservice.common.constants.BitDataConstants;
import com.bizvane.couponservice.common.datavo.BitDataRequestVO;
import com.bizvane.couponservice.common.datavo.BitDataVO;
import com.bizvane.couponservice.common.datavo.SalesNumVO;
import com.bizvane.couponservice.common.utils.BaseData;
import com.bizvane.couponservice.common.utils.HttpUtils;
import com.bizvane.couponservice.service.BitDataAnalysisService;
import com.bizvane.couponservice.service.CouponService;
import com.bizvane.mktcenterservice.common.report.BaseUrl;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.utils.tokens.TokenUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/bitDataAnalysis")
public class BitDataAnalysisController {
    private static final Logger logger = LoggerFactory.getLogger(BitDataAnalysisController.class);
    
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private com.bizvane.mktcenterservice.common.report.BaseUrl BaseUrl;
    
    @Autowired
    private BitDataAnalysisService bitDataAnalysisService;
    
	@Autowired
	private   CompanyServiceRpc companyServiceRpc;
	@Autowired
	private  CouponService couponService;
	@Autowired
	private   BrandServiceRpc brandServiceRpc;
	

    @ApiOperation(value = "发送的优惠券：", notes = "发送的优惠券：", tags = {"手动发券结果分析"}, httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "couponManualId", value = "手工发券id", required = true, dataType = "Integer"),
    })
    @RequestMapping(value = "/bitDataAnalysis", method = RequestMethod.POST)
    ResponseData<BitDataRequestVO> bitDataAnalysis(BitDataVO vo, HttpServletRequest request ) {
        logger.info("enter getList method param: getCouponQuotaAnalysisDetail:{},PageFormUtil:{}", vo);

        SysAccountPo accountPo = HttpUtils.getLoginUser(request);
        return bitDataAnalysisService.getCouponQuotaAnalysisDetail(vo, accountPo);

    }



    @ApiOperation(value = "券任务分析", notes = "券任务分析", tags = {"券任务分析"}, httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "batchNo", value = "batchNo", required = true, dataType = "batchNo"),
    })
    @RequestMapping("vouTaskAnalysis")
    public ResponseData<JSONObject> vouTaskAnalysis(BitDataVO sendVO, HttpServletRequest request){
		ResponseData<JSONObject> ResponseData = new ResponseData<JSONObject>();
		JSONObject backJSONObject = new JSONObject();
		for (String key : BitDataConstants.vipIncomeAnalysis.split(",")) {
			backJSONObject.put(key, "0");
		}
		
		ResponseData = backJSONObject(JSONObject.parseObject(JSONObject.toJSONString(sendVO)), backJSONObject, BaseUrl.getLoadUrl("vouTaskAnalysis"), request);
		//计算数据
		JSONObject jSONObject= ResponseData.getData();
		//发券量,核销量,核销率
		CouponFindCouponCountResponseVO couponFindCouponCountResponseVO =couponService.findCouponCountbatchSend(Long.valueOf(sendVO.getBatchNo()), null,null,null);
		jSONObject.put("couponSum", couponFindCouponCountResponseVO.getCouponSum());
		jSONObject.put("couponUsedSum", couponFindCouponCountResponseVO.getCouponUsedSum());
		jSONObject.put("couponRate", couponFindCouponCountResponseVO.getCouponRate());
		
        
		//用券客单价：使用券的成交额÷使用券的顾客总数；总业绩/件数
		//连带率：销售总数量 ÷ 销售小票数量；连带率=件数/笔数
		//Roi券成交额÷券优惠金额）×100%
		jSONObject.put("guestPrice", "¥"+BaseData.guestPrice(jSONObject.getString("achievements"),jSONObject.getString("penNumber")).toString());//用券客单价 总业绩/件数
		jSONObject.put("jointRate", BaseData.growthNotTow(jSONObject.getString("pieceNumber"),jSONObject.getString("penNumber")));//连带率：销售总数量 ÷ 销售小票数量；连带率=件数/笔数
		jSONObject.put("roi", BaseData.growthNot(jSONObject.getString("achievements"),jSONObject.getString("discount")));
		jSONObject.put("achievements", "¥"+jSONObject.getString("achievements"));
		ResponseData.setData(jSONObject);
		return ResponseData;
   }
    
    
    @ApiOperation(value = "核销量", notes = "核销量", tags = {"核销量"}, httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "batchNo", value = "batchNo", required = true, dataType = "batchNo"),
    })
    @RequestMapping("vouSalesVolume")
    public ResponseData<JSONArray> vouSalesVolume(BitDataVO sendVO, HttpServletRequest request){
		ResponseData<JSONArray> ResponseData = new ResponseData<JSONArray>();
		JSONArray jSONArray = new JSONArray();

		ResponseData = backJSONArray(JSONObject.parseObject(JSONObject.toJSONString(sendVO)), jSONArray, BaseUrl.getLoadUrl("vouSalesVolume"), request);
		ResponseData.setData(jSONArray);
		return ResponseData;
   }
    
     // 订单量
    @RequestMapping("salesNum")
    public ResponseData<JSONObject> salesNum(SalesNumVO sendVO, HttpServletRequest request){
		ResponseData<JSONObject> ResponseData = new ResponseData<JSONObject>();
		//没有补0
		JSONObject backJSONObject = new JSONObject();
		for (String key : BitDataConstants.salesNum.split(",")) {
			backJSONObject.put(key, "0");
		}
		//获取品牌id
		SysAccountPO sysAccountPO = TokenUtils.getStageUser(request);
		sendVO.setBrandId(sysAccountPO.getBrandId().toString());
		
		//计算同比去年时间 环比时间
		BaseData.salesNumVODate(sendVO);
		//查询数据
		ResponseData = backJSONObject(JSONObject.parseObject(JSONObject.toJSONString(sendVO)), backJSONObject, BaseUrl.getLoadUrl("salesNum"), request);
        
		//计算数据
		JSONObject jSONObject= ResponseData.getData();
		
		//同比增长=（本期数－同比去年同期数）÷同比去年同期数×100%；
		jSONObject.put("yesteryearDataGrowth", BaseData.growth(jSONObject.getString("currentData"),jSONObject.getString("yesteryearData")));
		
		//环比增长：（本期数－环比上一周期数）÷环比上一周期数×100%；
		jSONObject.put("lastDataGrowth", BaseData.growth(jSONObject.getString("currentData"),jSONObject.getString("lastData")));
		
		//未用券百分比：（未用券÷全部）×100%；
		jSONObject.put("elseDataGrowth", BaseData.growthNot(jSONObject.getString("elseData"),jSONObject.getString("currentData")));
		jSONObject.put("useVouDataGrowth", BaseData.growthNot(jSONObject.getString("useVouData"),jSONObject.getString("currentData")));
		
		ResponseData.setData(jSONObject);
		return ResponseData;
   }
    
    // 成交额
   @RequestMapping("salesAchievements")
   public ResponseData<JSONObject> salesAchievements(SalesNumVO sendVO, HttpServletRequest request){
		ResponseData<JSONObject> ResponseData = new ResponseData<JSONObject>();
		//没有补0
		JSONObject backJSONObject = new JSONObject();
		for (String key : BitDataConstants.salesNum.split(",")) {
			backJSONObject.put(key, "0");
		}
		//获取品牌id
		SysAccountPO sysAccountPO = TokenUtils.getStageUser(request);
		sendVO.setBrandId(sysAccountPO.getBrandId().toString());
		
		//计算同比去年时间 环比时间
		BaseData.salesNumVODate(sendVO);
		//查询数据
		ResponseData = backJSONObject(JSONObject.parseObject(JSONObject.toJSONString(sendVO)), backJSONObject, BaseUrl.getLoadUrl("salesAchievements"), request);
       
		//计算数据
		JSONObject jSONObject= ResponseData.getData();
		
		//同比增长=（本期数－同比去年同期数）÷同比去年同期数×100%；
		jSONObject.put("yesteryearDataGrowth", BaseData.growth(jSONObject.getString("currentData"),jSONObject.getString("yesteryearData")));
		
		//环比增长：（本期数－环比上一周期数）÷环比上一周期数×100%；
		jSONObject.put("lastDataGrowth", BaseData.growth(jSONObject.getString("currentData"),jSONObject.getString("lastData")));
		
		//未用券百分比：（未用券÷全部）×100%；
		jSONObject.put("elseDataGrowth", BaseData.growthNot(jSONObject.getString("elseData"),jSONObject.getString("currentData")));
		jSONObject.put("useVouDataGrowth", BaseData.growthNot(jSONObject.getString("useVouData"),jSONObject.getString("currentData")));
		
		ResponseData.setData(jSONObject);
		return ResponseData;
  }

    
     //店铺top10
    @RequestMapping("storeTop")
    public ResponseData<JSONObject> storeTop(BitDataVO sendVO, HttpServletRequest request){
		ResponseData<JSONObject> ResponseData = new ResponseData<JSONObject>();
		JSONObject backJSONObject = new JSONObject();
		// TODO
		ResponseData = backJSONObject(JSONObject.parseObject(JSONObject.toJSONString(sendVO)), backJSONObject, BaseUrl.getLoadUrl("storeTop"), request);
		return ResponseData;
   }
    //群组top10
   @RequestMapping("areaTop")
   public ResponseData<JSONObject> areaTop(BitDataVO sendVO, HttpServletRequest request){
		ResponseData<JSONObject> ResponseData = new ResponseData<JSONObject>();
		JSONObject backJSONObject = new JSONObject();
		// TODO
		ResponseData = backJSONObject(JSONObject.parseObject(JSONObject.toJSONString(sendVO)), backJSONObject, BaseUrl.getLoadUrl("areaTop"), request);
		return ResponseData;
  }
   
   //店铺优惠券
  @RequestMapping("storeVou")
  public ResponseData<List<JSONObject>> storeVou(BitDataVO sendVO, HttpServletRequest request){
		ResponseData<List<JSONObject>> ResponseData = new ResponseData<List<JSONObject>>();
		List<JSONObject> backJSONObject = new ArrayList<JSONObject>();
		// TODO 
		ResponseData = backJSONObjectHaveID(sendVO, backJSONObject, BaseUrl.getLoadUrl("storeVou"), request);
		return ResponseData;
 }
  
  //群组优惠券
 @RequestMapping("areaVou")
 public ResponseData<List<JSONObject>> areaVou(BitDataVO sendVO, HttpServletRequest request){
		ResponseData<List<JSONObject>> ResponseData = new ResponseData<List<JSONObject>>();
		List<JSONObject> backJSONObject = new ArrayList<JSONObject>();
		// TODO 
		Map<String,List> map = new HashMap<String,List>();
		
		
		JSONObject jSONObjectsendVO  =	JSONObject.parseObject(JSONObject.toJSONString(sendVO));

		ResponseData = backJSONObjectHaveIDVou(jSONObjectsendVO, backJSONObject, BaseUrl.getLoadUrl("storeVou"), request);
		return ResponseData;
}
    
    // 解析大数据不带时间的数据 数据
	public ResponseData<JSONArray> backJSONArray(JSONObject sendVO, JSONArray backJSONObject, String analysisUrl,HttpServletRequest request) {

		// 获取用户key和企业编号
		JSONObject jsonObject = getSendApiKeyJSONObject(sendVO,request);
				
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
		if (jobObject.get("successFlag").equals("1")) {
			JSONObject job = jobObject.getJSONObject("data");
			
			 Map<String,Object> mapjsonObje=new TreeMap<String,Object>();
             SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for (Object kk : job.keySet()) {
                   //	排序          
					try {
						Date date = simpleDateFormat.parse(kk.toString());
						long ts = date.getTime();
		                mapjsonObje.put(String.valueOf(ts), kk.toString());
		                mapjsonObje = ((TreeMap) mapjsonObje);
				 	} catch (ParseException e) {
						e.printStackTrace();
					}
			}
			
			 for(Object k : mapjsonObje.keySet()){
				JSONObject backObject = new JSONObject();
				backObject.put("time", mapjsonObje.get(k));
				backObject.put( "value", job.get(mapjsonObje.get(k)));
				backJSONObject.add(backObject);
			}
		}
		ResponseData.setCode(0);
		ResponseData.setMessage(jobObject.toString()+"大数据入参请求:" + analysisUrl + jsonObject.toString());
		ResponseData.setData(backJSONObject);
		return ResponseData;

	}
	
    // 解析大数据不带时间的数据
	public ResponseData<JSONObject> backJSONObject(JSONObject sendVO, JSONObject backJSONObject, String analysisUrl,HttpServletRequest request) {

		// 获取用户key和企业编号
		JSONObject jsonObject = getSendApiKeyJSONObject(sendVO,request);
				
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
			for (Object kk : job.keySet()) {
					backJSONObject.put(kk.toString(), job.get(kk).toString());
			}
		}
		ResponseData.setCode(0);
		ResponseData.setMessage(jobObject.toString()+"大数据入参请求:" + analysisUrl + jsonObject.toString());
		ResponseData.setData(backJSONObject);
		return ResponseData;

	}
	
    // 解析大数据带店铺优惠券
	public ResponseData<List<JSONObject>> backJSONObjectHaveID(BitDataVO sendVO, List<JSONObject> backJSONObject, String analysisUrl,HttpServletRequest request) {

		// 获取用户key和企业编号
		JSONObject jsonObject = getSendApiKeyJSONObject(JSONObject.parseObject(JSONObject.toJSONString(sendVO)),request);
				
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
	
    // 解析大数据群主优惠券
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
	// 获取用户key和企业编号
	public JSONObject getSendApiKeyJSONObject(JSONObject jsonObject, HttpServletRequest request) {
		
		jsonObject.put("businessNum", BaseUrl.getBusinessNum());
		jsonObject.put("apiKey", BaseUrl.getApiKey());
		SysAccountPO sysAccountPO = TokenUtils.getStageUser(request);
		ResponseData<SysCompanyPo> SysCompanyP = companyServiceRpc.getCompanyById(sysAccountPO.getSysCompanyId());
		jsonObject.put("corpId", SysCompanyP.getData().getCompanyCode());
		
		// 获取线下的品牌code
		SysBrandPo sysBrandPo = brandServiceRpc.getBrandByID(sysAccountPO.getBrandId()).getData();
		jsonObject.put("brandId", sysBrandPo.getBrandCode());
		
		return jsonObject;
	}

   


}