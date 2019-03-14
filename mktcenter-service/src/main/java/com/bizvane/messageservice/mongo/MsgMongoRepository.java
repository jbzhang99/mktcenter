package com.bizvane.messageservice.mongo;

import com.bizvane.messagefacade.models.vo.SysSmsConfigVO;
import com.bizvane.utils.mongoutils.MongoTemplateService;

/**
 * @Author: lijunwei
 * @Time: 2018/7/19 12:39
 */
public interface MsgMongoRepository extends MongoTemplateService<SysSmsConfigVO,Long> {
}


