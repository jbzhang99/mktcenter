package com.bizvane.messageservice.mongo;

import com.bizvane.messagefacade.models.po.MsgWxLogPO;
import com.bizvane.utils.mongoutils.MongoTemplateService;

public interface MsgWxLogMongoRepository extends MongoTemplateService<MsgWxLogPO,Long> {
}


