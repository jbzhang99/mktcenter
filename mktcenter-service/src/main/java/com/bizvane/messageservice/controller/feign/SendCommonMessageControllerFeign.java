package com.bizvane.messageservice.controller.feign;

import com.bizvane.messagefacade.interfaces.SendCommonMessageFeign;
import com.bizvane.messagefacade.models.vo.SysSmsConfigVO;
import com.bizvane.messageservice.service.SendCommonMessageService;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chen.li
 * @date on 2019/6/26 18:31
 * @description
 */
@RestController
public class SendCommonMessageControllerFeign implements SendCommonMessageFeign {

    @Autowired
    private SendCommonMessageService sendCommonMessageService;

    @Override
    public ResponseData<Integer> sendSmg(SysSmsConfigVO vo) {
        return sendCommonMessageService.sendSmg(vo);
    }
}
