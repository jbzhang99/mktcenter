package com.bizvane.messageservice.service.impl;

import com.bizvane.messageservice.mappers.RocketLogPOMapper;
import com.bizvane.messageservice.mongo.RockeLogPOMongoDao;
import com.bizvane.messageservice.service.RocketLogService;
import com.bizvane.messagefacade.models.po.RocketLogPO;
import com.bizvane.messagefacade.models.po.RocketLogPOExample;
import com.bizvane.messagefacade.models.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 记录rocketMQ消息队列生产、消费日志
 * 
 * @author 董争光 2018年5月21日下午2:01:52
 */
@Service
public class RocketLogServiceImpl implements RocketLogService {

  @Autowired
  private RocketLogPOMapper rocketLogPOMapper;
  
  @Autowired
  private RockeLogPOMongoDao rocketLogPOMongoDao;
  
  

  @Override
  public Result<String> insert(RocketLogPO rocketLogPO) {

    Result<String> result = new Result<>();

    rocketLogPO.setCreateDate(new Date());
//    this.rocketLogPOMapper.insertSelective(rocketLogPO);
//    result.setData(rocketLogPO.getRocketLogId());
      
      //修改保全到Monggodb
      String logid = rocketLogPOMongoDao.saveRocketLogPO(rocketLogPO);
      result.setData(logid);


    return result;
  }
  
  

  @Override
  public Result<Object> update(RocketLogPO rocketLogPO) {
    rocketLogPO.setUpdateDate(new Date());

//    this.rocketLogPOMapper.updateByPrimaryKeySelective(rocketLogPO);
      rocketLogPOMongoDao.updateRocketLogPO(rocketLogPO);

    return new Result<>();
  }

  @Override
  public Result<Object> update(RocketLogPO po, RocketLogPOExample example) {
    po.setUpdateDate(new Date());

    this.rocketLogPOMapper.updateByExampleSelective(po, example);

    return new Result<>();
  }

}
