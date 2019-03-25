package com.bizvane.couponservice.service.impl;

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
import com.bizvane.couponfacade.models.bo.BigDataPartBo;
import com.bizvane.couponfacade.models.bo.CouponPartBo;
import com.bizvane.couponfacade.models.bo.GetCouponSurveyBo;
import com.bizvane.couponfacade.models.bo.VouTypeListBo;
import com.bizvane.couponfacade.models.po.CouponDefinitionPO;
import com.bizvane.couponfacade.models.vo.CouponDefinitionPartVo;
import com.bizvane.couponfacade.models.vo.CouponStoreGroupVo;
import com.bizvane.couponfacade.models.vo.CouponStoreVo;
import com.bizvane.couponservice.common.constants.SysResponseEnum;
import com.bizvane.couponservice.common.datavo.ReportTempPO;
import com.bizvane.couponservice.common.utils.DateConversionUtil;
import com.bizvane.couponservice.common.utils.SetBasicBigDataPartBoUtil;
import com.bizvane.couponservice.mappers.CouponDefinitionPOMapper;
import com.bizvane.couponservice.mappers.CouponEntityPOMapper;
import com.bizvane.couponservice.service.CouponAnalysisService;
import com.bizvane.couponservice.service.CouponReportTempService;
import com.bizvane.mktcenterservice.common.report.BaseUrl;
import com.bizvane.utils.responseinfo.PageInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.TokenUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author liufq
 */
@Service
public class CouponAnalysisServiceImpl implements CouponAnalysisService {

    Logger logger = LoggerFactory.getLogger(CouponAnalysisServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CouponEntityPOMapper couponEntityPOMapper;

    @Autowired
    private CompanyServiceRpc companyServiceRpc;

    @Autowired
    private BrandServiceRpc brandServiceRpc;

    @Autowired
    private StoreServiceRpc storeServiceRpc;

    @Autowired
    private StoreGroupServiceRpc storeGroupServiceRpc;

    @Autowired
    private CouponReportTempService couponReportTempService;

    @Autowired
    SetBasicBigDataPartBoUtil setBasicBigDataPartBoUtil;

    @Autowired
    private com.bizvane.mktcenterservice.common.report.BaseUrl BaseUrl;

    @Autowired
    private CouponDefinitionPOMapper couponDefinitionPOMapper;

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private static DecimalFormat df = new DecimalFormat("0.00");

    @Override
    public ResponseData getCouponSurvey(Long sysBrandId) {
        logger.info("======入参:" + sysBrandId);
        ResponseData responseData = new ResponseData();
        responseData.setCode(SysResponseEnum.FAILED.getCode());
        if (sysBrandId == null) {
            responseData.setMessage("品牌id不能为空!");
            return responseData;
        }

        GetCouponSurveyBo getCouponSurveyBo = couponEntityPOMapper.getCouponSurvey(sysBrandId);
        if (getCouponSurveyBo != null) {
            //待核销发券数量
            double couponUnusedSum = getCouponSurveyBo.getCouponUnusedSum();
            //已过期的发券数量
            double couponOverdueSum = getCouponSurveyBo.getCouponOverdueSum();
            //已核销数量
            double couponUsedSum = getCouponSurveyBo.getCouponUsedSum();
            //累计发券总数量
            double couponCountSum = couponUnusedSum + couponOverdueSum + couponUsedSum;
            logger.info("couponCountSum:" + couponCountSum);
            double writeOffRate = couponUsedSum / couponCountSum;
            DecimalFormat df = new DecimalFormat("0.00%");
            logger.info("writeOffRate:" + writeOffRate);
            String writeOffRates = df.format(writeOffRate);

            getCouponSurveyBo.setCouponCountSum(couponCountSum);
            getCouponSurveyBo.setWriteOffRate(writeOffRates);
        }
        double couponAmountSum = couponEntityPOMapper.getBusinessAmount(sysBrandId);
        getCouponSurveyBo.setCouponAmountSum("￥"+df.format(couponAmountSum));
        logger.info("======出参:" + getCouponSurveyBo);
        responseData.setData(getCouponSurveyBo);
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());

        return responseData;
    }

    @Override
    public ResponseData getCouponUsed(CouponPartBo bo) {
        ResponseData responseData = new ResponseData();
        responseData.setCode(SysResponseEnum.FAILED.getCode());
        if (StringUtils.isBlank(bo.getParticleSize())) {
            responseData.setMessage("报表粒度不能为空!");
            return responseData;
        }
        if (StringUtils.isBlank(bo.getNumber()+"")) {
            responseData.setMessage("粒度条件不能为空!");
            return responseData;
        }
        DateConversionUtil dateConversionUtil = new DateConversionUtil();
        BigDataPartBo bigDataPartBo = new BigDataPartBo();
        bigDataPartBo.setBusinessNum(BaseUrl.businessNum);
        bigDataPartBo.setApiKey(BaseUrl.apiKey);
        bigDataPartBo.setParticleSize(bo.getParticleSize());
        if(StringUtils.isNotBlank(bo.getVouTypeId())){
            bigDataPartBo.setVouTypeId(bo.getVouTypeId());
        }

        //得到大数据查询条件
        bigDataPartBo = getBigDataPart(bo.getSysCompanyId(), bo.getSysBrandId(), bo.getNumber(), bo.getParticleSize(), dateConversionUtil, bigDataPartBo);

        //判断是否自定义日期，number为0则是自定义日期
        if ("1".equals(bo.getParticleSize()) && bo.getNumber() == 0) {
            if (StringUtils.isBlank(bo.getStartDate()) || StringUtils.isBlank(bo.getEndDate())) {
                responseData.setMessage("开始时间和结束时间不能为空!");
                return responseData;
            }
            bigDataPartBo.setStartDate(bo.getStartDate());
            bigDataPartBo.setEndDate(bo.getEndDate());
        }
        // TODO: 2019/1/22 从大数据接口获取数据，先模拟数据
        //JSONObject json = getCouponUsedData(bigDataPartBo);
        String  analysisUrl = BaseUrl.url+"vouSalesVolume";
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
            responseData.setCode(com.bizvane.utils.enumutils.SysResponseEnum.SUCCESS.getCode());
            responseData.setMessage("调用大数据接口，没有得到数据:"+jsonObject.getString("message"));
            responseData.setData(new ArrayList<>());
            return responseData;
        }

        //数据处理
        JSONObject dataJson = jsonObject.getJSONObject("data");
        JSONArray resultJson = dateConversionUtil.getDataHandle(dataJson, bo.getParticleSize());

        responseData.setData(resultJson);
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        return responseData;
    }

    @Override
    public ResponseData getCouponStore(CouponStoreVo vo,HttpServletRequest request) {
        ResponseData responseData = new ResponseData();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNum(vo.getPageNumber());
        pageInfo.setPageSize(vo.getPageSize());
        responseData.setCode(SysResponseEnum.FAILED.getCode());
        if (StringUtils.isBlank(vo.getParticleSize())) {
            responseData.setMessage("报表粒度不能为空!");
            return responseData;
        }
        if (StringUtils.isBlank(vo.getNumber()+"")) {
            responseData.setMessage("粒度条件不能为空!");
            return responseData;
        }
        DateConversionUtil dateConversionUtil = new DateConversionUtil();
        BigDataPartBo bigDataPartBo = new BigDataPartBo();
        bigDataPartBo.setBusinessNum(BaseUrl.businessNum);
        bigDataPartBo.setApiKey(BaseUrl.apiKey);
        bigDataPartBo.setParticleSize(vo.getParticleSize());
        //得到大数据查询条件
        bigDataPartBo = getBigDataPart(vo.getSysCompanyId(), vo.getSysBrandId(), vo.getNumber(), vo.getParticleSize(), dateConversionUtil, bigDataPartBo);
        if(StringUtils.isNotBlank(vo.getVouTypeId())){
            bigDataPartBo.setVouTypeId(vo.getVouTypeId());
        }
        //判断是否自定义日期，number为0则是自定义日期
        if ("1".equals(vo.getParticleSize()) && vo.getNumber() == 0) {
            if (StringUtils.isBlank(vo.getStartDate()) || StringUtils.isBlank(vo.getEndDate())) {
                responseData.setMessage("开始时间和结束时间不能为空!");
                return responseData;
            }
            bigDataPartBo.setStartDate(vo.getStartDate());
            bigDataPartBo.setEndDate(vo.getEndDate());
        }
        //查询品牌下的店铺列表
        SysStoreVo sysStoreVo = new SysStoreVo();
        sysStoreVo.setSysBrandId(vo.getSysBrandId());
        if(StringUtils.isNotBlank(vo.getStoreCode())){
            sysStoreVo.setSysStoreOfflineCode(vo.getStoreCode());
        }
        if(StringUtils.isNotBlank(vo.getStoreName())){
            sysStoreVo.setStoreName(vo.getStoreName());
        }
        JSONObject storeJson = new JSONObject();
        //条件查询的情况下
        if (StringUtils.isNotBlank(vo.getStoreCode()) || StringUtils.isNotBlank(vo.getStoreName())) {
            List<SysStorePo> sysStorePoList = storeServiceRpc.getCouponStoreList(sysStoreVo).getData();
            if (sysStorePoList.size() > 0) {
                String[] storeIds = new String[sysStorePoList.size()];
                for (int i = 0; i < sysStorePoList.size(); i++) {
                    String storeId = sysStorePoList.get(i).getStoreId();
                    storeIds[i] = storeId;
                    storeJson.put(storeId, sysStorePoList.get(i));
                }
                bigDataPartBo.setStoreIds(storeIds);
            }else{
                pageInfo.setStartRow(1);
                pageInfo.setPageSize(10);
                pageInfo.setList(new ArrayList());
                responseData.setCode(SysResponseEnum.SUCCESS.getCode());
                responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
                responseData.setData(pageInfo);
                return responseData;
            }
        }

        bigDataPartBo.setStartRecord("1");
        bigDataPartBo.setQueryNum(10000);
        //TODO: 2019/2/13 第一次调用大数据接口，得到数据的总条数（得到总的个数用于分页）
        String  analysisUrl = BaseUrl.url+"storeVou";
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
            responseData.setCode(SysResponseEnum.SUCCESS.getCode());
            responseData.setMessage("调用大数据接口，没有得到全部数据:"+jsonObject.getString("message"));
            pageInfo.setTotal(0);
            pageInfo.setList(new ArrayList());
            responseData.setData(pageInfo);
            return responseData;
        }
        //对数据进行处理
        JSONArray dataJsonSum = jsonObject.getJSONArray("data");

        logger.info("bigData总条数:" + dataJsonSum.size());
        Long sysBrandId = vo.getSysBrandId();
        Long sysCompanyId = vo.getSysCompanyId();

        //用于得到分页的总条数，（取数与未取数的交集）
        if (bigDataPartBo.getStoreIds() == null || bigDataPartBo.getStoreIds().length == 0) {
            List<String> storeIds = new ArrayList<>();
            for(int i=0;i<dataJsonSum.size();i++){
                String id = dataJsonSum.getJSONObject(i).get("id").toString();
                storeIds.add(id);
                logger.info("storeIds=============>>"+ storeIds.toString());
            }
            if (storeIds.size() > 0) {
                List<SysStorePo> sysStorePoList = storeServiceRpc.getCouponStoreIdList1(storeIds,sysBrandId,sysCompanyId).getData();
                if (sysStorePoList.size() > 0) {
                    pageInfo.setTotal(sysStorePoList.size());
                }
            }
        }
        if ("1".equals(vo.getIsExport())) {
            // TODO: 2019/1/23 导出从大数据接口获取数据，先模拟数据
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
            //解析得到的JSON
            JSONObject jsonObject1 = JSONObject.parseObject(response1.getBody());
            String flag1 = jsonObject.getString("successFlag");
            if("0".equals(flag1)){
                responseData.setCode(SysResponseEnum.SUCCESS.getCode());
                responseData.setMessage("调用大数据接口，没有得到部分数据:"+jsonObject.getString("message"));
                pageInfo.setList(new ArrayList());
                responseData.setData(pageInfo);
                return responseData;
            }

            JSONArray dataJson = jsonObject1.getJSONArray("data");
            //非条件查询下(分页)，给storeJson赋值
            if (bigDataPartBo.getStoreIds() == null || bigDataPartBo.getStoreIds().length == 0) {
                List<String> storeIds = new ArrayList<>();
                for(int i=0;i<dataJson.size();i++){
                    String id = dataJson.getJSONObject(i).get("id").toString();
                    storeIds.add(id);
                }
                if (storeIds.size() > 0) {
                    List<SysStorePo> sysStorePoList = storeServiceRpc.getCouponStoreIdList1(storeIds,sysBrandId,sysCompanyId).getData();
                    if (sysStorePoList.size() > 0) {
                        for (int i = 0; i < sysStorePoList.size(); i++) {
                            String storeId = sysStorePoList.get(i).getStoreId();
                            storeJson.put(storeId, sysStorePoList.get(i));
                        }
                    }
                }
            }
            JSONArray couponStoreResultVoArray = dateConversionUtil.getCouponStore(dataJson, storeJson,"store");
            ReportTempPO reportTempPO = new ReportTempPO();
            reportTempPO.setTemplateName("券效果分析店铺群组导出");
            reportTempPO.setReportDataName("门店编号,门店名称,核销数量,客单价,连带率,券收益,ROI");
            reportTempPO.setReportData("storeCode,storeName,salesVolume,unitPrice,jointRate,achievements,roi");
            couponReportTempService.Export(TokenUtils.getStageUser(request), "", couponStoreResultVoArray.toString(), reportTempPO);

            responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
            responseData.setCode(SysResponseEnum.SUCCESS.getCode());

            return responseData;
        }

        bigDataPartBo.setStartRecord(String.valueOf((vo.getPageNumber() - 1) * vo.getPageSize() + 1));
        bigDataPartBo.setQueryNum(vo.getPageSize());
        // TODO: 2019/1/23 第二次再从大数据接口获取数据，先模拟数据
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
        //解析得到的JSON
        JSONObject jsonObject1 = JSONObject.parseObject(response1.getBody());
        String flag1 = jsonObject.getString("successFlag");
        if("0".equals(flag1)){
            responseData.setCode(SysResponseEnum.SUCCESS.getCode());
            responseData.setMessage("调用大数据接口，没有得到部分数据:"+jsonObject.getString("message"));
            pageInfo.setList(new ArrayList());
            responseData.setData(pageInfo);
            return responseData;
        }

        JSONArray dataJson = jsonObject1.getJSONArray("data");
        //非条件查询下(分页)，给storeJson赋值
        if (bigDataPartBo.getStoreIds() == null || bigDataPartBo.getStoreIds().length == 0) {
            List<String> storeIds = new ArrayList<>();
            for(int i=0;i<dataJson.size();i++){
                String id = dataJson.getJSONObject(i).get("id").toString();
                storeIds.add(id);
            }
            if (storeIds.size() > 0) {
                List<SysStorePo> sysStorePoList = storeServiceRpc.getCouponStoreIdList1(storeIds,sysBrandId,sysCompanyId).getData();
                if (sysStorePoList.size() > 0) {
                    for (int i = 0; i < sysStorePoList.size(); i++) {
                        String storeId = sysStorePoList.get(i).getStoreId();
                        storeJson.put(storeId, sysStorePoList.get(i));
                    }
                }
            }
        }
        JSONArray couponStoreResultVoArray = dateConversionUtil.getCouponStore(dataJson, storeJson,"store");
        pageInfo.setList(couponStoreResultVoArray);
        responseData.setData(pageInfo);
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        return responseData;
    }

    private BigDataPartBo getBigDataPart(Long sysCompanyId, Long sysBrandId, int number, String particleSize, DateConversionUtil dateConversionUtil, BigDataPartBo bigDataPartBo) {
        //得到企业code
        SysCompanyPo sysCompanyPo = companyServiceRpc.getCompanyById(sysCompanyId).getData();
        bigDataPartBo.setCorpId(sysCompanyPo.getCompanyCode());
        //得到品牌code
        SysBrandPo sysBrandPo = brandServiceRpc.getBrandByID(sysBrandId).getData();
        bigDataPartBo.setBrandId(sysBrandPo.getBrandCode());

        if (number != 0) {
            //获取前一天的日期(结束时间)
            String yesterday = dateConversionUtil.getYesterday();
            bigDataPartBo.setEndDate(yesterday+" 23:59:59");
            //获取开始时间
            String startDate = dateConversionUtil.getStartAndEndDate(yesterday, number, particleSize);
            bigDataPartBo.setStartDate(startDate+" 00:00:00");
        }
        return bigDataPartBo;
    }

    @Override
    public ResponseData getCouponStoreGroup(CouponStoreGroupVo vo, HttpServletRequest request)  {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNum(vo.getPageNumber());
        pageInfo.setPageSize(vo.getPageSize());
        ResponseData responseData = new ResponseData();
        responseData.setCode(SysResponseEnum.FAILED.getCode());
        if (StringUtils.isBlank(vo.getParticleSize())) {
            responseData.setMessage("报表粒度不能为空!");
            return responseData;
        }
        if (StringUtils.isBlank(vo.getNumber()+"")) {
            responseData.setMessage("粒度条件不能为空!");
            return responseData;
        }

        DateConversionUtil dateConversionUtil = new DateConversionUtil();
        BigDataPartBo bigDataPartBo = new BigDataPartBo();
        bigDataPartBo.setBusinessNum(BaseUrl.businessNum);
        bigDataPartBo.setApiKey(BaseUrl.apiKey);
        //得到大数据查询条件
        bigDataPartBo = getBigDataPart(vo.getSysCompanyId(), vo.getSysBrandId(), vo.getNumber(), vo.getParticleSize(), dateConversionUtil, bigDataPartBo);
        if(StringUtils.isNotBlank(vo.getVouTypeId())){
            bigDataPartBo.setVouTypeId(vo.getVouTypeId());
        }
        //判断是否自定义日期，number为0则是自定义日期
        if ("1".equals(vo.getParticleSize()) && vo.getNumber() == 0) {
            if (StringUtils.isBlank(vo.getStartDate()) || StringUtils.isBlank(vo.getEndDate())) {
                responseData.setMessage("开始时间和结束时间不能为空!");
                return responseData;
            }
            bigDataPartBo.setStartDate(vo.getStartDate());
            bigDataPartBo.setEndDate(vo.getEndDate());
        }

        //查询品牌下的店铺列表
        SysAccountVo sysAccountVo = new SysAccountVo();
        sysAccountVo.setSysBrandId(String.valueOf(vo.getSysBrandId()));
        sysAccountVo.setSysAccountId(vo.getSysAccountId());
        if(StringUtils.isNotBlank(vo.getStoreGroupName())){
            sysAccountVo.setStoreGroupName(vo.getStoreGroupName());
        }
        JSONObject storeGroupJson = storeGroupServiceRpc.getCounponStoreGroupList(sysAccountVo).getData();
        if(storeGroupJson==null || storeGroupJson.size()==0){
            pageInfo.setList(null);
            pageInfo.setPageSize(vo.getPageSize());
            pageInfo.setPageNum(vo.getPageNumber());
            responseData.setData(pageInfo);
            responseData.setCode(SysResponseEnum.SUCCESS.getCode());
            responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
            return responseData;
        }
        JSONObject storeGroupDataJson = new JSONObject();
        if (storeGroupJson != null) {
            LinkedHashMap<String, String> jsonMap = JSON.parseObject(JSON.toJSONString(storeGroupJson), new TypeReference<LinkedHashMap<String, String>>() {
            });
            Map<String, List> storeGroupList = new HashMap<>();
            for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
                String[] key = entry.getKey().split(",");
                String[] list = entry.getValue().replace("[", "").replace("]", "").split(",");
                storeGroupList.put(key[0], Arrays.asList(list));
                SysStoreGroupPo sysStoreGroupPo = new SysStoreGroupPo();
                sysStoreGroupPo.setSysStoreGroupCode(key[1]);
                sysStoreGroupPo.setStoreGroupName(key[2]);
                storeGroupDataJson.put(key[0], sysStoreGroupPo);
            }
            bigDataPartBo.setStoreIdsInArea(storeGroupList);
        }
        // TODO: 2019/1/23 第一次从大数据接口获取数据，所有数据得到总条数
        bigDataPartBo.setStartRecord("1");
        bigDataPartBo.setQueryNum(10000);
        String  analysisUrl = BaseUrl.url+"areaVou";
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
            responseData.setCode(SysResponseEnum.SUCCESS.getCode());
            responseData.setMessage("调用大数据接口，没有得到全部数据:"+jsonObject.getString("message"));
            pageInfo.setTotal(0);
            pageInfo.setList(new ArrayList());
            responseData.setData(pageInfo);
            return responseData;
        }

        JSONArray dataJsonSum = jsonObject.getJSONArray("data");
        logger.info("bigData总条数:" + dataJsonSum.size());


        pageInfo.setTotal(dataJsonSum.size());
        if ("1".equals(vo.getIsExport())) {
            // TODO: 2019/1/23 从大数据接口获取数据，先模拟数据
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
            //解析得到的JSON
            JSONObject jsonObject1 = JSONObject.parseObject(response1.getBody());
            String flag1 = jsonObject.getString("successFlag");
            if("0".equals(flag1)){
                responseData.setCode(SysResponseEnum.SUCCESS.getCode());
                responseData.setMessage("调用大数据接口，没有得到部分数据:"+jsonObject.getString("message"));
                pageInfo.setList(new ArrayList());
                responseData.setData(pageInfo);
                return responseData;
            }

            JSONArray dataJson = jsonObject1.getJSONArray("data");
            JSONArray couponStoreResultVoArray = dateConversionUtil.getCouponStore(dataJson, storeGroupDataJson,"storeGroup");
            ReportTempPO reportTempPO = new ReportTempPO();
            reportTempPO.setTemplateName("券效果分析店铺群组导出");
            reportTempPO.setReportDataName("群组编号,群组名称,核销数量,客单价,连带率,券收益,ROI");
            reportTempPO.setReportData("storeGroupCode,storeGroupName,salesVolume,unitPrice,jointRate,achievements,roi");
            couponReportTempService.Export(TokenUtils.getStageUser(request), "", couponStoreResultVoArray.toString(), reportTempPO);
            responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
            responseData.setCode(SysResponseEnum.SUCCESS.getCode());
            return responseData;
        }

        bigDataPartBo.setStartRecord(String.valueOf((vo.getPageNumber() - 1) * vo.getPageSize() + 1));
        bigDataPartBo.setQueryNum(vo.getPageSize());
        // TODO: 2019/1/23 第二次从大数据接口获取数据，先模拟数据
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
        //解析得到的JSON
        JSONObject jsonObject1 = JSONObject.parseObject(response1.getBody());
        String flag1 = jsonObject.getString("successFlag");
        if("0".equals(flag1)){
            responseData.setCode(SysResponseEnum.SUCCESS.getCode());
            responseData.setMessage("调用大数据接口，没有得到部分数据:"+jsonObject.getString("message"));
            pageInfo.setList(new ArrayList());
            responseData.setData(pageInfo);
            return responseData;
        }

        JSONArray dataJson = jsonObject1.getJSONArray("data");
        JSONArray couponStoreResultVoArray = dateConversionUtil.getCouponStore(dataJson, storeGroupDataJson,"storeGroup");
        pageInfo.setList(couponStoreResultVoArray);
        responseData.setData(pageInfo);
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());

        return responseData;
    }

    @Override
    public ResponseData couponOrders(CouponPartBo bo) {
        ResponseData responseData = new ResponseData();
        if (StringUtils.isBlank(bo.getParticleSize())) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.FAILED.getMessage());
            responseData.setData("报表粒度不能为空!");
            return responseData;
        }
        if (bo.getNumber()==0) {
            if(bo.getStartDate()==null||bo.getEndDate()==null){
                responseData.setCode(SysResponseEnum.FAILED.getCode());
                responseData.setMessage(SysResponseEnum.FAILED.getMessage());
                responseData.setMessage("粒度条件为零时，开始时间和结束时间不能为null");
                return responseData;
            }
        }
        //创建给大数据传递参数的实体类
        BigDataPartBo bigDataPartBo = new BigDataPartBo();
        bigDataPartBo.setApiKey(BaseUrl.getApiKey());
        bigDataPartBo.setBusinessNum(BaseUrl.getBusinessNum());
        //得到企业code
        SysCompanyPo sysCompanyPo = companyServiceRpc.getCompanyById(bo.getSysCompanyId()).getData();
        bigDataPartBo.setCorpId(sysCompanyPo.getCompanyCode());
        //得到品牌code
       SysBrandPo sysBrandPo = brandServiceRpc.getBrandByID(bo.getSysBrandId()).getData();
        bigDataPartBo.setBrandId(sysBrandPo.getBrandCode());
        //调用工具类
        bigDataPartBo = setBasicBigDataPartBoUtil.setBigDataPartBo(bigDataPartBo,bo);
        bigDataPartBo.setParticleSize(bo.getParticleSize());
        //TODO:调用大数据接口对数据进行模拟;
        String analysisUrl = "";
        if("订单量".equals(bo.getOrderNumOrTurnVolume())){
            analysisUrl = BaseUrl.url+"couponOrders";
        }else if("成交额".equals(bo.getOrderNumOrTurnVolume())){
            analysisUrl = BaseUrl.url+"couponVouIncome";
        }else if("核销量".equals(bo.getOrderNumOrTurnVolume())){
            analysisUrl = BaseUrl.url+"vouSalesVolume";
        }
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
            responseData.setCode(com.bizvane.utils.enumutils.SysResponseEnum.SUCCESS.getCode());
            responseData.setMessage("调用大数据接口，没有得到数据~");
            responseData.setData(new ArrayList<>());
            return responseData;
        }

        //数据处理
        DateConversionUtil dateConversionUtil = new DateConversionUtil();
        JSONObject dataJson = jsonObject.getJSONObject("data");
        JSONArray resultJson = dateConversionUtil.getDataHandle(dataJson, bo.getParticleSize());

        responseData.setData(resultJson);
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());

        return responseData;

    }

    @Override
    public ResponseData couponDisplay(CouponDefinitionPartVo vo) {
        //券显示
        ResponseData responseData = new ResponseData();
        //分页
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNum(vo.getPageNumber());
        pageInfo.setPageSize(vo.getPageSize());
        //创建大数据给大数据传递的实体类
        BigDataPartBo bigDataPartBo = new BigDataPartBo();
        bigDataPartBo.setApiKey(BaseUrl.getApiKey());
        bigDataPartBo.setBusinessNum(BaseUrl.getBusinessNum());
        //得到企业code
        SysCompanyPo sysCompanyPo = companyServiceRpc.getCompanyById(vo.getSysCompanyId()).getData();
        bigDataPartBo.setCorpId(sysCompanyPo.getCompanyCode());
        //得到品牌code
        SysBrandPo sysBrandPo = brandServiceRpc.getBrandByID(vo.getSysBrandId()).getData();
        bigDataPartBo.setBrandId(sysBrandPo.getBrandCode());
        //调用工具类
        bigDataPartBo = setBasicBigDataPartBoUtil.setBigDataPartBo(bigDataPartBo,vo);
        //根据条件查询得到给大数据传递的数组
        CouponDefinitionPO couponDefinitionPO = new CouponDefinitionPO();
        couponDefinitionPO.setSysBrandId(vo.getSysBrandId());
        Long couponDefinitionId = vo.getCouponDefinitionId();
        //用于查询所有数据的JSON
        JSONObject couponDefinitionIdJson = new JSONObject();
        String couponName = vo.getCouponName();
        if(couponDefinitionId != null||StringUtils.isNotBlank(couponName)){

            CouponDefinitionPO couponDefinitionPO1 = new CouponDefinitionPO();
            if(couponDefinitionId!=null){
                couponDefinitionPO1.setCouponDefinitionId(couponDefinitionId);
            }
            if(StringUtils.isNotBlank(couponName)){
                couponDefinitionPO1.setCouponName(couponName);
            }
            List<CouponDefinitionPO> couponDefinitionPOList = couponDefinitionPOMapper.selectByDefinitionAndCouponName(couponDefinitionPO1);

            String[] vouTypeIdList = new String[couponDefinitionPOList.size()];
            if(couponDefinitionPOList != null && couponDefinitionPOList.size()>0){
                for(int i=0;i<couponDefinitionPOList.size();i++){
                    String couponDefinitionId1 = couponDefinitionPOList.get(i).getCouponDefinitionId()+"";
                    vouTypeIdList[i] = couponDefinitionId1;
                    couponDefinitionIdJson.put(couponDefinitionId+"",couponDefinitionPOList.get(i).getCouponDefinitionId()+"");
                }
                bigDataPartBo.setVouTypeIdList(vouTypeIdList);
            }else{
              pageInfo.setList(new ArrayList());
              responseData.setData(pageInfo);
              responseData.setCode(SysResponseEnum.SUCCESS.getCode());
              responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
              return responseData;
            }

        }
        bigDataPartBo.setQueryNum(10000);
        bigDataPartBo.setStartRecord("1");
        //TODO:第一次调用大数据接口(先尽可能多得查出所有数据)
        String  analysisUrl = BaseUrl.url+"vouTypeList";
        ResponseEntity<String> response = null;
        try {
            JSONObject bigDataPartBoJson = JSONObject.parseObject(JSONObject.toJSONString(bigDataPartBo));
            logger.info("大数据请求入参BitDataController：" + analysisUrl + bigDataPartBoJson.toString());
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
            responseData.setCode(SysResponseEnum.SUCCESS.getCode());
            responseData.setMessage("调用大数据接口，没有得到全部数据:"+jsonObject.getString("message"));
            pageInfo.setTotal(0);
            pageInfo.setList(new ArrayList());
            responseData.setData(pageInfo);
            return responseData;
        }
        JSONArray sumObject = jsonObject.getJSONArray("data");

        logger.info("所有数据的总条数:"+sumObject.size());
        pageInfo.setTotal(sumObject.size());

        bigDataPartBo.setStartRecord(String.valueOf((vo.getPageNumber() -1) * vo.getPageSize()+1));
        bigDataPartBo.setQueryNum(vo.getPageSize());
        //TODO:第二次调用大数据接口得到分页数据
        ResponseEntity<String> response1 = null;
        try {
            JSONObject bigDataPartBoJson = JSONObject.parseObject(JSONObject.toJSONString(bigDataPartBo));
            logger.info("大数据请求入参BitDataController：" + analysisUrl + bigDataPartBoJson.toString());
            response1 = this.restTemplate.postForEntity(analysisUrl, bigDataPartBo, String.class, new Object[0]);
        } catch (Exception e) {
            responseData.setCode(500);
            responseData.setMessage("大数据连接异常" + e.getMessage() + analysisUrl + bigDataPartBo.toString());
            responseData.setData(bigDataPartBo);
            return responseData;
        }
        //解析得到的JSON

        JSONObject jsonObject1 = JSONObject.parseObject(response1.getBody());
        String flag1 = jsonObject1.getString("successFlag");
        if("0".equals(flag1)){
            responseData.setCode(com.bizvane.utils.enumutils.SysResponseEnum.SUCCESS.getCode());
            responseData.setMessage("调用大数据接口，没有得到分页数据:"+jsonObject.getString("message"));
            pageInfo.setList(new ArrayList());
            responseData.setData(pageInfo);
            return responseData;
        }
        JSONArray jsonArray = jsonObject1.getJSONArray("data");
        List<VouTypeListBo> vouTypeListBoList = new ArrayList<>();

        if(jsonArray!=null){
            for(int i=0;i<jsonArray.size();i++){
                VouTypeListBo vouTypeListBo = new VouTypeListBo();
                JSONObject mapObject = jsonArray.getJSONObject(i);
                Long vouTypeId = mapObject.getLong("id");

                Double salesVolume = mapObject.getDouble("salesVolume");
                Double achievements = mapObject.getDouble("achievements");
                Double totalTickets = mapObject.getDouble("totalTickets");
                //大数据返回数据赋值
                vouTypeListBo.setVouTypeId(vouTypeId+"");

                vouTypeListBo.setSalesVolume(eraseZero(salesVolume));
                vouTypeListBo.setAchievements("￥"+df.format(achievements));
                vouTypeListBo.setTotalTickets(eraseZero(totalTickets));
                //计算核销率并进行赋值;
                Double saleRate;
                if(salesVolume == 0.0 || totalTickets == 0.0 ){
                    saleRate = 0.0;
                }else{
                    saleRate = (salesVolume/totalTickets)*100;
                }
                vouTypeListBo.setSaleRate(eraseZero(saleRate)+"%");
                //根据voutypeid得到实体类中其他信息
                //用example不行啊(不知道为啥)
              /*  CouponDefinitionPOExample example = new CouponDefinitionPOExample();
                example.createCriteria().andCouponDefinitionIdEqualTo(vouTypeId);
                List<CouponDefinitionPO> couponDefinitionPOList1 = couponDefinitionPOMapper.selectByExample(example);*/

                List<CouponDefinitionPO> couponDefinitionPOList1 = couponDefinitionPOMapper.selectByDefinitionId(vouTypeId);
                if(couponDefinitionPOList1.size()>0){
                    CouponDefinitionPO po = couponDefinitionPOList1.get(0);
                    vouTypeListBo.setVouName(po.getCouponName());
                    vouTypeListBo.setCreateDate((sdf.format(po.getCreateDate())));
                    if(po.getPreferentialType()==1){
                        vouTypeListBo.setMoneyOrDiscount("￥"+po.getMoney()+"");
                    }else if (po.getPreferentialType() == 2){
                        vouTypeListBo.setMoneyOrDiscount("享受"+po.getDiscount()+"折优惠");
                    }
                    //给有效期赋值
                    String validDate;
                    if(po.getValidType() ==1 ){
                        String startDate = sdf.format(po.getValidDateStart());
                        String endDate = sdf.format(po.getValidDateEnd());
                        vouTypeListBo.setValidDate(startDate+"~"+endDate);
                    }else if (po.getValidType() == 2){
                        vouTypeListBo.setValidDate("领取后"+po.getValidDay()+"天");
                    }
                    vouTypeListBoList.add(vouTypeListBo);
                }


            }
        }
        pageInfo.setList(vouTypeListBoList);
        responseData.setData(pageInfo);
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        return responseData;
    }

    /**
     * 将Double类型装换为String，并且没有小数点
     * */
    public String eraseZero(Double number){
        //设置Double类型的格式
        DecimalFormat df = new DecimalFormat("0.00");
        String numberString = df.format(number);
        //对于得到的百分比后面要去零操作
        if(numberString.indexOf(".")>0){
            numberString = numberString.replaceAll("0+?$","");
            numberString = numberString.replaceAll("[.]$", "");
        }
        return numberString;
    }

}
