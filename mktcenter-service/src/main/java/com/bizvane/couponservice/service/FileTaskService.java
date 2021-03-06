package com.bizvane.couponservice.service;

import com.bizvane.centerstageservice.models.po.SysAccountPo;
import com.bizvane.couponfacade.models.vo.CouponEntityVO;
import com.bizvane.utils.responseinfo.ResponseData;

import javax.mail.MessagingException;

/**
 * @description
 * / 文件接口
 */
public interface FileTaskService {


    /**
     * 导出
     * @param entityVO
     * @param accountPo
     * @return
     * @throws MessagingException
     */
	ResponseData<String> exportEntityExcel(CouponEntityVO entityVO, SysAccountPo accountPo) throws MessagingException;


}
