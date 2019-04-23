//package com.bizvane.couponservice.kafka.consumer;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.bizvane.centerstageservice.models.po.SysBrandPo;
//import com.bizvane.centerstageservice.rpc.BrandServiceRpc;
//import com.bizvane.centerstageservice.rpc.CompanyServiceRpc;
//import com.bizvane.couponfacade.models.po.CouponDefinitionCodePO;
//import com.bizvane.couponfacade.models.po.CouponDefinitionPO;
//import com.bizvane.couponfacade.models.po.CouponDefinitionPOExample;
//import com.bizvane.couponfacade.models.vo.CouponOfflineCreateResponseVO;
//import com.bizvane.couponservice.common.constants.SysResponseEnum;
//import com.bizvane.couponfacade.constants.CouponConstants;
//import com.bizvane.couponservice.mappers.CouponDefinitionCodePOMapper;
//import com.bizvane.couponservice.mappers.CouponDefinitionPOMapper;
//import com.bizvane.couponservice.mappers.CouponEntityPOMapper;
//import com.bizvane.utils.responseinfo.ResponseData;
//import org.apache.commons.collections.CollectionUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Service;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
////增量同步线下生成券号
//@Service("KAFKA_TOPIC_COUPON_OFFLINE_CREATE")
//public class KafkaConsumerCouponOfflineCreate implements KafkaConsumerService {
//
//  private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerCouponOfflineCreate.class);
//
//  @Autowired
//  private CouponDefinitionPOMapper couponDefinitionPOMapper;
//
//  @Autowired
//  private CouponEntityPOMapper couponEntityPOMapper;
//
//  @Autowired
//  private CompanyServiceRpc companyServiceRpc;
//
//  @Autowired
//  private BrandServiceRpc brandServiceRpc;
//
//  @Autowired
//  private  CouponDefinitionCodePOMapper couponDefinitionCodePOMapper;
//
//  @Async
//  @Override
//  public void consumer(String topic, String key,String value) {
//
//    logger.info("enter KafkaConsumerCouponOfflineCreate consumer method! value:{}",value);
//
//    if(StringUtils.isBlank(value)){
//      logger.info(SysResponseEnum.SYSTEM_DATA_NOT_EMPTY.getMessage());
//      return;
//    }
//
//    JSONObject jsonObject = JSON.parseObject(value);
//
//    CouponOfflineCreateResponseVO offlineVO = JSONObject.toJavaObject(jsonObject, CouponOfflineCreateResponseVO.class);
//
//    if(StringUtils.isBlank(offlineVO.getBrandCode())){
//      logger.info("enter KafkaConsumerAllCouponOfflineUse consumer method ! brandCode is null!"+JSONObject.toJSONString(offlineVO));
//      return;
//    }
//
//    if(StringUtils.isBlank(offlineVO.getCouponCode())){
//      logger.info("enter KafkaConsumerAllCouponOfflineUse consumer method ! couponCode is null!"+JSONObject.toJSONString(offlineVO));
//      return;
//    }
//
//    if(StringUtils.isBlank(offlineVO.getCouponDefinitioncode())){
//      logger.info("enter KafkaConsumerAllCouponOfflineUse consumer method ! couponDefinitionCode is null!"+JSONObject.toJSONString(offlineVO));
//      return;
//    }
//
//
//    //获取品牌id
//    Long brandId = findBrandId(offlineVO.getBrandCode(),offlineVO.getCompanyCode());
//
//
//    //查询券定义是否存在
//    List<CouponDefinitionPO> definitionList = findCouponDefinition(offlineVO.getCouponDefinitioncode());
//
//    CouponDefinitionPO definitionPO = new CouponDefinitionPO();
//    if(CollectionUtils.isEmpty(definitionList)){
//    	 logger.info("enter KafkaConsumerAllCouponOfflineUse consumer method ! definitionList is null!"+offlineVO.getCouponDefinitioncode());
//    	  return;
//    }else {
//    	 definitionPO = definitionList.get(0);
//    }
//
//
//    //查询企业id
//    Long companyId = null;
//    if(StringUtils.isNotBlank(offlineVO.getCompanyCode())) {
//      companyId = companyServiceRpc.getIdByCode(offlineVO.getCompanyCode()).getData();
//    }
//
//    CouponDefinitionCodePO couponDefinitionCodePO=new CouponDefinitionCodePO();
//
//    couponDefinitionCodePO.setSysCompanyId(companyId);
//    couponDefinitionCodePO.setSysBrandId(brandId);
//    couponDefinitionCodePO.setBrandCode(offlineVO.getBrandCode());
//    couponDefinitionCodePO.setCouponCode(offlineVO.getCouponCode());
//
//    couponDefinitionCodePO.setCouponDefinitionId(definitionPO.getCouponDefinitionId());
//    couponDefinitionCodePO.setCouponName(definitionPO.getCouponName());
//    couponDefinitionCodePO.setPreferentialType(definitionPO.getPreferentialType());
//    couponDefinitionCodePO.setCreateDate(new Date());
//
//
//    try {
//    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        couponDefinitionCodePO.setValidDateStart(dateFormat.parse(offlineVO.getCouponStartDate()));
//        couponDefinitionCodePO.setValidDateEnd(dateFormat.parse(offlineVO.getCouponEndDate()));
//        couponDefinitionCodePO.setModifiedDate(dateFormat.parse(offlineVO.getOfflineUpdateDate()));
//    }catch(Exception e){
//        logger.info(SysResponseEnum.DATE_TRANSFER_EXCEPTION.getMessage());
//    }
//
//
//    couponDefinitionCodePOMapper.insertSelective(couponDefinitionCodePO);
//   // 组装券信息
//
//
//  }
//
//
//  /**
//   * 查找品牌
//   * @param brandCode
//   * @param companyCode
//   * @return
//   */
//  public Long findBrandId(String brandCode,String companyCode){
//
//    ResponseData<Long> companyResult = companyServiceRpc.getIdByCode(companyCode);
//
//    SysBrandPo brandPo = new SysBrandPo();
//    brandPo.setBrandCode(brandCode);
//    brandPo.setSysCompanyId(companyResult.getData());
//
//    ResponseData<Long> brandResult = brandServiceRpc.getBrandIdByCode(brandPo);
//
//    return brandResult.getData();
//
//  }
//
//  /**
//   * 查找券定义
//   * @param couponDefinitionCode
//   * @return
//   */
//  public List<CouponDefinitionPO> findCouponDefinition(String couponDefinitionCode){
//
//    CouponDefinitionPOExample example = new CouponDefinitionPOExample();
//    example.createCriteria().andCouponDefinitionCodeEqualTo(couponDefinitionCode).andValidEqualTo(SystemConstants.TABLE_VALID_EFFECTIVE);
//
//    List<CouponDefinitionPO> definitionPOList = couponDefinitionPOMapper.selectByExample(example);
//
//    return definitionPOList;
//
//  }
//
//}
