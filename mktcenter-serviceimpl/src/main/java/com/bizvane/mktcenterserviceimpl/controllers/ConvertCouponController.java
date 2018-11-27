package com.bizvane.mktcenterserviceimpl.controllers;

import com.bizvane.mktcenterservice.interfaces.ConvertCouponService;
import com.bizvane.mktcenterservice.models.po.MktConvertCouponRecordPO;
import com.bizvane.mktcenterservice.models.vo.CouponRecordVO;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.utils.tokens.TokenUtils;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2018/11/23 11:29
 */
@RestController
@RequestMapping("convertRecord")
public class ConvertCouponController {

    @Autowired
    private ConvertCouponService convertCouponService;
    /**
     * 获取兑换订单集合
     * @param vo
     */
    @RequestMapping("getCouponRecordLists")
    public ResponseData<PageInfo<MktConvertCouponRecordPO>>  getCouponRecordLists(CouponRecordVO vo,HttpServletRequest request){
        //SysAccountPO sysAccountPo = TokenUtils.getStageUser(request);
        SysAccountPO sysAccountPo=new SysAccountPO();
        sysAccountPo.setBrandId(96L);
        sysAccountPo.setName("测试测试");
        sysAccountPo.setSysAccountId(12867L);
        sysAccountPo.setSysCompanyId(3841L);
        vo.setBrandId(sysAccountPo.getBrandId());
        return convertCouponService.getCouponRecordLists(vo);
    }

    /**
     * 导出
     */
    @RequestMapping("doExportData")
    public void  doExportData(CouponRecordVO vo, HttpServletRequest request) throws IOException {
        convertCouponService.doExportData001(vo,request);
    }
}
