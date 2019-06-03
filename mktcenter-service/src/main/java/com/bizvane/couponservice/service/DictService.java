package com.bizvane.couponservice.service;

import com.bizvane.couponfacade.models.po.SysCodeValuePO;

import java.util.List;
import java.util.Map;


/**
 * 字典表service
 * @author 董争光 2018年5月28日下午2:52:04
 */
public interface DictService {

  /**
   * 通过dictType获取值集list格式
   * 
   * @param dictType
   * @return
   */
  List<SysCodeValuePO> getDicts(String dictType);


  /**
   * 通过dictType获取值集Map格式
   * 
   * @param dictType
   * @return
   */
  Map<String, SysCodeValuePO> getDictMap(String dictType);

  /**
   * 通过dictType和值code获取字典对象
   * 
   * @param dictType
   * @return
   */
  SysCodeValuePO getSysCodeValue(String dictType, String itemCode);

  /**
   * 通过dictType批量获取值集list格式
   * @param dictType
   * @return
   */
  Map<String,List<SysCodeValuePO>> getDictsBatch(String dictType);

  /**
   * 初始化数据，重新从数据库加载
   */
  void init();

}



/**
 * Revision history -------------------------------------------------------------------------
 * 
 * Date Author Note -------------------------------------------------------------------------
 * 2017年7月14日 win7 创建版本
 */
