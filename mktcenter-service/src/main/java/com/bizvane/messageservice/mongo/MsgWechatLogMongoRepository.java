package com.bizvane.messageservice.mongo;

import com.bizvane.messagefacade.models.po.MsgWxLogPO;
import com.bizvane.utils.mongoutils.MongoTemplateService;

public interface MsgWechatLogMongoRepository extends MongoTemplateService<MsgWxLogPO,Long> {
}


