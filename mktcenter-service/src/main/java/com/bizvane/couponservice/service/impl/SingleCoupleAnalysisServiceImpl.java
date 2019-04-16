package com.bizvane.couponservice.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.internal.org.apache.commons.lang3.StringUtils;
import com.bizvane.centerstageservice.models.po.SysBrandPo;
import com.bizvane.centerstageservice.models.po.SysCompanyPo;
import com.bizvane.centerstageservice.rpc.BrandServiceRpc;
import com.bizvane.centerstageservice.rpc.CompanyServiceRpc;
import com.bizvane.couponfacade.enums.SendTypeEnum;
import com.bizvane.couponfacade.models.bo.*;
import com.bizvane.couponservice.common.datavo.SalesNumVO;
import com.bizvane.couponservice.common.utils.BaseData;
import com.bizvane.couponservice.common.utils.DateConversionUtil;
import com.bizvane.couponservice.common.utils.SetBasicBigDataPartBoUtil;
import com.bizvane.couponservice.controller.BitDataAnalysisController;
import com.bizvane.couponservice.service.SingleCoupleAnalysisService;
import com.bizvane.mktcenterservice.common.report.BaseUrl;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.github.pagehelper.PageInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 26095 on 2019/1/21.
 */
@Service
public class SingleCoupleAnalysisServiceImpl implements SingleCoupleAnalysisService {
    private static final Logger logger = LoggerFactory.getLogger(BitDataAnalysisController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CompanyServiceRpc companyServiceRpc;

    @Autowired
    private BrandServiceRpc brandServiceRpc;

    @Autowired
    private BaseUrl baseUrl;

    @Autowired
    private SetBasicBigDataPartBoUtil setBasicBigDataPartBoUtil;

    //设置Double类型的格式
    final DecimalFormat  df = new DecimalFormat("0.00");

    @Override
    public ResponseData getCouponSurvey(CouponPartBo bo) {
        ResponseData responseData = new ResponseData<>();
        //用传递给参数的实体类
        SingleCouponSurveyBo singleCouponSurveyBo = new SingleCouponSurveyBo();
        //用来给大数据传递接口的实体类
        BigDataPartBo bigDataPartBo = new BigDataPartBo();
        //得到企业code
        SysCompanyPo sysCompanyPo = companyServiceRpc.getCompanyById(bo.getSysCompanyId()).getData();
        bigDataPartBo.setCorpId(sysCompanyPo.getCompanyCode());
        bigDataPartBo.setBusinessNum(baseUrl.getBusinessNum());
        bigDataPartBo.setApiKey(baseUrl.getApiKey());
        if(StringUtils.isNotBlank(bo.getVouTypeId())){
            bigDataPartBo.setVouTypeId(bo.getVouTypeId());
        }
        //调用大数据接口(先自己模拟写一个)
        String  analysisUrl = baseUrl.url+"vouTaskAnalysis";
        ResponseEntity<String> response = null;
        try {
            logger.info("大数据请求入参BitDataController：" + analysisUrl + bigDataPartBo.toString());
            response = this.restTemplate.postForEntity(analysisUrl, bigDataPartBo, String.class, new Object[0]);
        } catch (Exception e) {
            responseData.setCode(500);
            responseData.setMessage("大数据连接异常" + e.getMessage() + analysisUrl + bigDataPartBo.toString());
            responseData.setData(bigDataPartBo);
            return responseData;
        }
        //解析得到的JSON
        JSONObject jsonObject = JSONObject.parseObject(response.getBody());
        String flag = jsonObject.getString("successFlag");
        if("0".equals(flag)){
            responseData.setData("没有得到数据！");
            return responseData;
        }
        String data = jsonObject.getString("data");
        JSONObject dataJson = JSONObject.parseObject(data);
        //发券量
        Double totleTickets = dataJson.getDouble("totalTickets");
        singleCouponSurveyBo.setTotalTickets(eraseZero(totleTickets));
        //核销量
        Double salesVolume = dataJson.getDouble("salesVolume");
        singleCouponSurveyBo.setSalesVolume(eraseZero(salesVolume));
        //核销率
        Double saleRate;
        if(totleTickets == 0.0){
            saleRate = 0.0;
        }else{
            saleRate = (salesVolume/totleTickets)*100;
        }
        singleCouponSurveyBo.setSaleRate(eraseZero(saleRate)+"%");
        //券成交订单
        singleCouponSurveyBo.setOrderNum(dataJson.getString("orderNum"));
        //券成交金额(券收益)
        Double achievements = dataJson.getDouble("achievements");
        singleCouponSurveyBo.setAchievements("￥"+df.format(achievements));
        //用券订单笔数
        Double penNumber = dataJson.getDouble("penNumber");
        singleCouponSurveyBo.setPenNumber(eraseZero(penNumber));
        //客单价
        Double clientPrice = achievements/penNumber;
        //df.setMinimumFractionDigits(2);
        String clientPriceString = df.format(clientPrice);
        singleCouponSurveyBo.setClientPrice("￥"+clientPriceString);
        //连带率
        Double jointRate = salesVolume/penNumber;
        String jointRageString = df.format(jointRate);
        singleCouponSurveyBo.setJointRate(jointRageString);
        //券优惠金额
        Double discount = dataJson.getDouble("discount");
        //ROI
        Double ROI = (achievements/discount)*100;
        singleCouponSurveyBo.setROI(eraseZero(ROI)+"%");

        responseData.setData(singleCouponSurveyBo);
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        return responseData;
    }

    @Override
    public ResponseData singleSaleNum(CouponPartBo couponPartBo) {
        ResponseData responseData = new ResponseData();
        //创建返回参数的实体类
        SingleSalesNum singleSalesNum = new SingleSalesNum();
        //创建给大数据传递参数的实体类
        BigDataPartBo bigDataPartBo = new BigDataPartBo();
        bigDataPartBo.setBusinessNum(baseUrl.getBusinessNum());
        bigDataPartBo.setApiKey(baseUrl.getApiKey());
        //得到企业code
        SysCompanyPo sysCompanyPo = companyServiceRpc.getCompanyById(couponPartBo.getSysCompanyId()).getData();
        bigDataPartBo.setCorpId(sysCompanyPo.getCompanyCode());
        //得到品牌code
        SysBrandPo sysBrandPo = brandServiceRpc.getBrandByID(couponPartBo.getSysBrandId()).getData();
        bigDataPartBo.setBrandId(sysBrandPo.getBrandCode());

        bigDataPartBo.setStartDate(couponPartBo.getStartDate());
        bigDataPartBo.setEndDate(couponPartBo.getEndDate());
        if(StringUtils.isNotBlank(couponPartBo.getVouTypeId())){
            bigDataPartBo.setVouTypeId(couponPartBo.getVouTypeId());
        }

        //创建用于计算同比环比时间的实体类
        SalesNumVO salesNumVO = new SalesNumVO();
        salesNumVO.setStartDate(couponPartBo.getStartDate());
        salesNumVO.setEndDate(couponPartBo.getEndDate());
        //调用实体类
        BaseData baseData = new BaseData();
        SalesNumVO salesNumVO1 = baseData.salesNumVODate(salesNumVO);
        //给大数据传递参数的实体类赋值
        bigDataPartBo.setYesteryearStartDate(salesNumVO1.getYesteryearStartDate());
        bigDataPartBo.setYesteryearEndDate(salesNumVO1.getYesteryearEndDate());
        bigDataPartBo.setLastStartDate(salesNumVO1.getLastStartDate());
        bigDataPartBo.setLastEndDate(salesNumVO1.getLastEndDate());
        if(StringUtils.isBlank(couponPartBo.getOrderNumOrTurnVolume())){
            responseData.setData("订单量成交额类型不能为空");
            responseData.setMessage(SysResponseEnum.FAILED.getMessage());
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            return responseData;
        }
        String analysisUrl;
        if("订单量".equals(couponPartBo.getOrderNumOrTurnVolume())){
            analysisUrl = baseUrl.url+"salesNum";
        }else{
            analysisUrl = baseUrl.url+"salesAchievements";
        }

        //调用大数据接口
        ResponseEntity<String> response = null;
        try {
            logger.info("大数据请求入参BitDataController：" + analysisUrl + bigDataPartBo.toString());
            response = this.restTemplate.postForEntity(analysisUrl, bigDataPartBo, String.class, new Object[0]);
        } catch (Exception e) {
            responseData.setCode(500);
            responseData.setMessage("大数据连接异常" + e.getMessage() + analysisUrl + bigDataPartBo.toString());
            responseData.setData(bigDataPartBo);
            return responseData;
        }

        JSONObject jsonObject = JSONObject.parseObject(response.getBody());
        String successFlag = jsonObject.getString("successFlag");
        if("0".equals(successFlag)){
            responseData.setCode(SysResponseEnum.SUCCESS.getCode());
            responseData.setMessage("调用大数据接口，没有得到数据~");
            responseData.setData(new ArrayList<>());
            return responseData;
        }
        String data = jsonObject.getString("data");
        JSONObject dataJson = JSONObject.parseObject(data);
        Double yesteryearData = dataJson.getDouble("yesteryearData");
        Double lastData = dataJson.getDouble("lastData");
        Double currentData = dataJson.getDouble("currentData");
        Double useVouData = dataJson.getDouble("useVouData");
        Double elseData = dataJson.getDouble("elseData");
        //同比上升
        Double yesterdayDataPercent;
        if(currentData == 0.0 || yesteryearData==0.0){
            yesterdayDataPercent = 0.0;
        }else{
            yesterdayDataPercent = (currentData-yesteryearData)/yesteryearData*100;
        }
        //环比上升
        Double lastDataPercent;
        if(currentData==0.0||lastData==0.0){
            lastDataPercent = 0.0;
        }else{
            lastDataPercent = (currentData-lastData)/lastData*100;
        }
        //将得到的数据存放到实体类中
        singleSalesNum.setYesteryearData(eraseZero(yesteryearData));
        singleSalesNum.setLastData(eraseZero(lastData));
        //当前订单量 = 本期订单量 = 总订单量
        singleSalesNum.setCurrentData(eraseZero(currentData));
        singleSalesNum.setUseVouData(eraseZero(useVouData));
        singleSalesNum.setElseData(eraseZero(elseData));
        //给同比上升，环比上升赋值
        singleSalesNum.setYesterdayDataPercent(eraseZero(yesterdayDataPercent)+"%");
        singleSalesNum.setLastDataPercent(eraseZero(lastDataPercent)+"%");
        responseData.setData(singleSalesNum);
        return responseData;
    }

    @Override
    public ResponseData singleSendWayList(CouponPartBo bo) {
        ResponseData responseData = new ResponseData();
        //创建分页插件
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNum(bo.getPageNumber());
        pageInfo.setPageSize(bo.getPageSize());

        //日期转化的实体类
        DateConversionUtil dateConversionUtil = new DateConversionUtil();
        //创建给大数据传递参数的实体类
        BigDataPartBo bigDataPartBo = new BigDataPartBo();
        bigDataPartBo.setApiKey(baseUrl.getApiKey());
        bigDataPartBo.setBusinessNum(baseUrl.getBusinessNum());
        //得到企业code
        SysCompanyPo sysCompanyPo = companyServiceRpc.getCompanyById(bo.getSysCompanyId()).getData();
        bigDataPartBo.setCorpId(sysCompanyPo.getCompanyCode());
        //得到品牌code
        SysBrandPo sysBrandPo = brandServiceRpc.getBrandByID(bo.getSysBrandId()).getData();
        bigDataPartBo.setBrandId(sysBrandPo.getBrandCode());
        //调用工具类给起始时间，结束时间，apiKey,bussnessNum赋值
        bigDataPartBo = setBasicBigDataPartBoUtil.setBigDataPartBo(bigDataPartBo,bo);
        bigDataPartBo.setVouTypeId(bo.getVouTypeId());

        bigDataPartBo.setStartRecord("1");
        bigDataPartBo.setQueryNum(1000);
        String analysisUrl = baseUrl.url+"sendWayList";
        //调用大数据接口
        ResponseEntity<String> response = null;
        String text = JSONObject.toJSONString(bigDataPartBo);
        try {
            logger.info("大数据请求入参BitDataController：" + analysisUrl + bigDataPartBo.toString());
            response = this.restTemplate.postForEntity(analysisUrl, bigDataPartBo, String.class, new Object[0]);
        } catch (Exception e) {
            responseData.setCode(500);
            responseData.setMessage("大数据连接异常" + e.getMessage() + analysisUrl + bigDataPartBo.toString());
            responseData.setData(bigDataPartBo);
            return responseData;
        }
        JSONObject jsonObject = JSONObject.parseObject(response.getBody());
        String successFlag = jsonObject.getString("successFlag");
        if("0".equals(successFlag)){
            responseData.setCode(SysResponseEnum.SUCCESS.getCode());
            responseData.setMessage("调用大数据接口，没有得到所有数据:"+jsonObject.getString("message"));
            pageInfo.setList(new ArrayList());
            pageInfo.setTotal(0);
            responseData.setData(pageInfo);
            return responseData;
        }
        //得到数据进行处理
        //先查询出所有数据用于得到数据的总个数
        JSONArray jsonArray= jsonObject.getJSONArray("data");
        Integer totalSize = jsonArray.size();

        pageInfo.setTotal(totalSize);


        bigDataPartBo.setQueryNum(bo.getPageSize());
        bigDataPartBo.setStartRecord(String.valueOf((bo.getPageNumber() - 1) * bo.getPageSize() + 1));
        //TODO:再次调用大数据接口得到分页数据
        ResponseEntity<String> response1 = null;

        try {
            logger.info("大数据请求入参BitDataController：" + analysisUrl + bigDataPartBo.toString());
            response1 = this.restTemplate.postForEntity(analysisUrl, bigDataPartBo, String.class, new Object[0]);
        } catch (Exception e) {
            responseData.setCode(500);
            responseData.setMessage("大数据连接异常" + e.getMessage() + analysisUrl + bigDataPartBo.toString());
            responseData.setData(bigDataPartBo);
            return responseData;
        }
        JSONObject jsonObject1 = JSONObject.parseObject(response1.getBody());
        String successFlag1 = jsonObject.getString("successFlag");
        if("0".equals(successFlag1)){
            responseData.setCode(SysResponseEnum.SUCCESS.getCode());
            responseData.setMessage("调用大数据接口，没有得到部分数据:"+jsonObject.getString("message"));
            pageInfo.setList(new ArrayList());
            responseData.setData(pageInfo);
            return responseData;
        }
        JSONArray jsonArray1 = jsonObject1.getJSONArray("data");
        List<SingleSendCouponWayBo> singleSendCouponWayBoList = new ArrayList<>();

        if(jsonArray1!=null){
            for(int i=0;i<jsonArray1.size();i++){
                SingleSendCouponWayBo singleSendCouponWayBo = new SingleSendCouponWayBo();
                JSONObject mapObject = jsonArray1.getJSONObject(i);
                String sendCouponId = mapObject.getString("id");
                String sendCouponWay = SendTypeEnum.getValue(sendCouponId);
                //发券数量
                Double sendCouponNum = mapObject.getDouble("totalTickets");
                //核销数量
                Double salesVolume = mapObject.getDouble("salesVolume");
                //核销率
                Double saleRate;
                if(sendCouponNum==0.0 || salesVolume ==0.0){
                    saleRate = 0.0;
                }else{
                    saleRate = (salesVolume/sendCouponNum)*100;
                }
                //券收益
                Double achievements = mapObject.getDouble("achievements");
                //用券订单笔数
                Double penNumber = mapObject.getDouble("penNumber");
                //客单价
                Double clientPrice;
                if(achievements==0.0 && penNumber==0.0){
                    clientPrice = 0.0;
                }else{
                    clientPrice = achievements/penNumber;
                }
                String clientPriceString = df.format(clientPrice);

                //连带率
                Double jointRate =  mapObject.getDouble("jointRate");
                if(salesVolume==0.0 || penNumber==0.0){
                    jointRate = 0.0;
                }else{
                    jointRate = salesVolume/penNumber;
                }
                //券优惠金额
                Double discount = mapObject.getDouble("discount");
                //ROI
                Double ROI;
                if(achievements ==0.0 || discount == 0.0){
                    ROI = 0.0;
                }else{
                    ROI = (achievements/discount)*100;
                }
                //将数据放到实体类中
                singleSendCouponWayBo.setSendCouponWay(sendCouponWay);
                singleSendCouponWayBo.setSendCouponNum(eraseZero(sendCouponNum));
                singleSendCouponWayBo.setSalesVolume(eraseZero(salesVolume));

                singleSendCouponWayBo.setSaleRate(eraseZero(saleRate)+"%");
                singleSendCouponWayBo.setClientPrice("￥"+clientPriceString);
                singleSendCouponWayBo.setJointRate(jointRate+"");
                singleSendCouponWayBo.setAchievements("￥"+df.format(achievements));
                singleSendCouponWayBo.setROI(eraseZero(ROI)+"%");

                singleSendCouponWayBoList.add(singleSendCouponWayBo);
            }
        }
        pageInfo.setList(singleSendCouponWayBoList);
        responseData.setData(pageInfo);
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        return responseData;
    }


    /**
     * 将Double类型装换为String，并且没有小数点
     * */
    public String eraseZero(Double number){
        String numberString = df.format(number);
        //对于得到的百分比后面要去零操作
        if(numberString.indexOf(".")>0){
            numberString = numberString.replaceAll("0+?$","");
            numberString = numberString.replaceAll("[.]$", "");
        }
        return numberString;
    }

}
