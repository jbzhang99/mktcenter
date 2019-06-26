package com.bizvane.messageservice.service;

import com.bizvane.messagefacade.models.vo.SysSmsConfigVO;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author chen.li
 * @date on 2019/6/26 18:32
 * @description
 */
public interface SendCommonMessageService {

    public ResponseData<Integer> sendSmg(@RequestBody SysSmsConfigVO vo);
}
