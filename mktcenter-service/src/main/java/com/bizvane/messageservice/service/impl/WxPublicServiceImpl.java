package com.bizvane.messageservice.service.impl;

import com.bizvane.messageservice.mappers.WxPublicPOMapper;
import com.bizvane.messageservice.service.WxPublicService;
import com.bizvane.messagefacade.models.po.WxPublicPO;
import com.bizvane.messagefacade.models.po.WxPublicPOExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 获取公众号信息service
 * 
 * @author 董争光 2018年5月28日下午2:44:02
 */
@Service
public class WxPublicServiceImpl implements WxPublicService {

  @Autowired
  private WxPublicPOMapper wxPublicPOMapper;

  /**
   * 通过corpCode获取微信列表
   * 
   * @param corpCode
   * @return
   */
  @Override
  public List<WxPublicPO> getWxPublicPOListByCorpCode(String corpCode) {

    WxPublicPOExample example = new WxPublicPOExample();
    //example.createCriteria().andCropCodeEqualTo(corpCode);

    return this.wxPublicPOMapper.selectByExample(example);
  }


}
