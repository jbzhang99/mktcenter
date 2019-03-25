package com.bizvane.messageservice.service;

import com.bizvane.messagefacade.models.po.WxPublicPO;

import java.util.List;

/**
 * 获取公众号信息service
 * @author 董争光
 * 2018年5月28日下午2:44:02
 */
public interface WxPublicService {

  /**
   * 通过corpCode获取微信列表
   * @param corpCode
   * @return
   */
  List<WxPublicPO> getWxPublicPOListByCorpCode(String corpCode);
}
