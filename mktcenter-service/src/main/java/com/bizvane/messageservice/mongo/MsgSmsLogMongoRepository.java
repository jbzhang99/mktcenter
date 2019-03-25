package com.bizvane.messageservice.mongo;

import com.bizvane.messagefacade.models.po.MsgSmsLogPO;
import com.bizvane.utils.mongoutils.MongoTemplateService;

public interface MsgSmsLogMongoRepository extends MongoTemplateService<MsgSmsLogPO,Long> {
}


