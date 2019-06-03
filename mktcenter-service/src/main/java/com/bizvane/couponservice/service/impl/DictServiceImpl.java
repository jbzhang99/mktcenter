package com.bizvane.couponservice.service.impl;

import com.bizvane.couponfacade.models.po.SysCodeValuePO;
import com.bizvane.couponfacade.models.po.SysCodeValuePOExample;
import com.bizvane.couponservice.common.system.DictHelper;
import com.bizvane.couponservice.mappers.CouponSysCodeValuePOMapper;
import com.bizvane.couponservice.service.DictService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 缓存service
 * @author 董争光 2018年5月28日下午2:52:04
 */
@Service
public class DictServiceImpl implements DictService {

  private static final Logger logger = LoggerFactory.getLogger(DictServiceImpl.class);

  @Autowired
  private CouponSysCodeValuePOMapper sysCodeValuePOMapper;

  /**
   * 通过dictType获取值集list格式
   * 
   * @param dictType
   * @return
   */
  @Override
  public List<SysCodeValuePO> getDicts(String dictType) {

    return DictHelper.getDicts(dictType);
  }

  /**
   * 通过dictType获取值集Map格式
   * 
   * @param dictType
   * @return
   */
  @Override
  public Map<String, SysCodeValuePO> getDictMap(String dictType) {

    return DictHelper.getDictMap(dictType);
  }

  /**
   * 初始化数据，重新从数据库加载
   */
  @Override
  @PostConstruct
  public void init() {
    SysCodeValuePOExample sysCodeValueExample = new SysCodeValuePOExample();
    List<SysCodeValuePO> list = this.sysCodeValuePOMapper.selectByExample(sysCodeValueExample);

    DictHelper.getDictMap().clear();
    for (SysCodeValuePO dict : list) {
      this.initData(dict);
    }
  }

  protected void initData(SysCodeValuePO dict) {

    List<SysCodeValuePO> list = DictHelper.getDictMap().get(dict.getCodeType());
    if ((list == null) || list.isEmpty()) {
      List<SysCodeValuePO> dicts = new ArrayList<>();
      dicts.add(dict);
      DictHelper.getDictMap().put(dict.getCodeType(), dicts);
    } else {
      DictHelper.getDictMap().get(dict.getCodeType()).add(dict);
    }
  }

  public void reload() {
    DictServiceImpl.logger
        .info("======================================reload dict data start================================");
    this.init();
    DictServiceImpl.logger
        .info("======================================reload dict data end================================");
  }

  /**
   * 通过dictType和值code获取字典对象
   * 
   * @param dictType
   * @return
   */
  @Override
  public SysCodeValuePO getSysCodeValue(String dictType, String itemCode) {
    List<SysCodeValuePO> sysCodeValues = DictHelper.getDicts(dictType);
    for (SysCodeValuePO sysCodeValue : sysCodeValues) {
      String item = sysCodeValue.getItemCode();
      if (item.contains(itemCode)) {
        return sysCodeValue;
      }
    }
    return null;
  }

  /**
   * 通过dictType批量获取值集list格式
   * @param dictType
   * @return
   */
  @Override
  public Map<String,List<SysCodeValuePO>> getDictsBatch(String dictType) {

    Map<String,List<SysCodeValuePO>> map = new HashMap<>();

    String[] dictArr = dictType.split(",");

    if(dictArr.length > 0){

      for(int i=0;i<dictArr.length;i++){

        List<SysCodeValuePO> list = DictHelper.getDicts(dictArr[i]);
        map.put(dictArr[i],list);
      }

    }

    return map;
  }
}


/**
 * Revision history -------------------------------------------------------------------------
 *
 * Date Author Note -------------------------------------------------------------------------
 * 2017年7月14日 win7 创建版本
 */
