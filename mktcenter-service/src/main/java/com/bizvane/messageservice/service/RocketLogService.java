package com.bizvane.messageservice.service;

import com.bizvane.messagefacade.models.po.RocketLogPO;
import com.bizvane.messagefacade.models.po.RocketLogPOExample;
import com.bizvane.messagefacade.models.vo.Result;

/**
 * 记录rocketMQ消息队列生产、消费日志
 * 
 * @author 董争光 2018年5月21日下午2:01:52
 */
public interface RocketLogService {

  Result<String> insert(RocketLogPO po);

  Result<Object> update(RocketLogPO po);

  Result<Object> update(RocketLogPO po, RocketLogPOExample example);

}
