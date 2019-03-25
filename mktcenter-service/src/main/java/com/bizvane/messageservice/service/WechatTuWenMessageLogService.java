package com.bizvane.messageservice.service;

import com.bizvane.messagefacade.models.po.MsgWxLogPOExample;
import com.bizvane.messagefacade.models.po.MsgWxTuWenPO;
import com.bizvane.messagefacade.models.vo.Result;
import com.bizvane.messagefacade.models.vo.WechatMessageLogVO;
import com.bizvane.utils.responseinfo.ResponseData;

/**
 * 记录发送微信模板消息日志
 * 
 * @author 董争光 2018年5月21日下午2:00:22
 */
public interface WechatTuWenMessageLogService {

  
  Result<String> insert(MsgWxTuWenPO po);

  Result<Object> update(MsgWxTuWenPO po);

  Result<Object> update(MsgWxTuWenPO po, MsgWxLogPOExample example);
  
  ResponseData<Object> getStatistics(WechatMessageLogVO wechatMessageLogVO);

  /**
   * 查找微信消息日志分页
   * @param vo
   * @return
   */
  ResponseData<Object> findPage(WechatMessageLogVO vo);
}
