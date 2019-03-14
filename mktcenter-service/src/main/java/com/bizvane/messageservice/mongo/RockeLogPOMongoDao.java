package com.bizvane.messageservice.mongo;

import com.bizvane.messagefacade.models.po.RocketLogPO;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RockeLogPOMongoDao extends BaseMongoDao<RocketLogPO> {

  public String saveRocketLogPO(RocketLogPO rocketLogPO) {

    RocketLogPO item = super.insert(rocketLogPO);
    return item.get_id();
  }
  
  public void updateRocketLogPO(RocketLogPO rocketLogPO) {

	  RocketLogPO item =super.save(rocketLogPO);
  }


  public List<RocketLogPO> getRocketLogPOList() {
    Query query = new Query();
    return super.find(query);
  }
}

