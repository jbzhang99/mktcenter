package com.bizvane.messageservice.service.impl;

import com.bizvane.messageservice.mappers.WxStorePOMapper;
import com.bizvane.messageservice.service.WxStoreService;
import com.bizvane.messagefacade.models.po.WxStorePO;
import com.bizvane.messagefacade.models.po.WxStorePOExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 门店信息service
 * 
 * @author 董争光 2018年5月28日下午2:40:49
 */
@Service
public class WxStoreServiceImpl implements WxStoreService {

  @Autowired
  private WxStorePOMapper wxStorePOMapper;

  /**
   * 通过erpStoreId和wxpublicid查询门店列表
   * 
   * @param erpStoreId
   * @param wxPublicId
   * @return
   */
  @Override
  public List<WxStorePO> getWxStorePOListByErpStoreId(String erpStoreId, Long wxPublicId) {

    WxStorePOExample example = new WxStorePOExample();
    example.createCriteria().andErpStoreIdEqualTo(erpStoreId).andWxPublicIdEqualTo(wxPublicId);

    return this.wxStorePOMapper.selectByExample(example);
  }

}
