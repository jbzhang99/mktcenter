package com.bizvane.messageservice.service;

import com.bizvane.messagefacade.models.po.WxStorePO;

import java.util.List;

/**
 * 获取门店信息service
 * 
 * @author 董争光 2018年5月28日下午2:40:49
 */
public interface WxStoreService {

  /**
   * 通过erpStoreId和wxpublicid查询门店列表
   * 
   * @param erpStoreId
   * @param wxPublicId
   * @return
   */
  List<WxStorePO> getWxStorePOListByErpStoreId(String erpStoreId, Long wxPublicId);

}
