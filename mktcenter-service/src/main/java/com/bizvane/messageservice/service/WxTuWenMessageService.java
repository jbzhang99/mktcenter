package com.bizvane.messageservice.service;

import com.bizvane.mktcenterfacade.models.bo.ObtainGraphicBo;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author chen.li
 * @date on 2019/6/28 18:00
 * @description
 */
public interface WxTuWenMessageService {

    public ResponseData groupSending(ObtainGraphicBo obtainGraphicBo);
}
