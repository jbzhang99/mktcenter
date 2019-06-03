package com.bizvane.couponservice.service;

import com.bizvane.centerstageservice.models.po.SysAccountPo;
import com.bizvane.centerstageservice.models.po.SysDimSkuPo;
import com.bizvane.centerstageservice.models.po.SysStorePo;
import com.bizvane.couponfacade.models.po.CouponDefinitionCodePO;
import com.bizvane.couponfacade.models.po.CouponDefinitionMoneyPO;
import com.bizvane.couponfacade.models.po.CouponDefinitionPO;
import com.bizvane.couponfacade.models.po.CouponDefinitionPOWithBLOBs;
import com.bizvane.couponfacade.models.vo.CouponDefinitionCodeQueryVO;
import com.bizvane.couponfacade.models.vo.CouponDefinitionListQueryVO;
import com.bizvane.couponfacade.utils.PageFormUtil;
import com.github.pagehelper.PageInfo;
import com.bizvane.utils.responseinfo.ResponseData;

/**
 * 券定义相关
 * @author 董争光
 * 2018年7月6日下午2:18:22
 */
public interface CouponDefinitionService {

    /**
     * 查询券定义列表
     *
     * @param vo
     * @return
     */
    ResponseData<PageInfo<CouponDefinitionPO>> getList(CouponDefinitionListQueryVO vo, PageFormUtil pageForm, Long sysBrandId, Long sysCompanyId);

    /**
     * 查询券定义列表
     *
     * @param vo
     * @return
     */
    ResponseData<PageInfo<CouponDefinitionPO>> getListRpc(CouponDefinitionListQueryVO vo, PageFormUtil pageForm);

    /**
     * 添加券定义
     *
     * @param po
     * @return
     */
    ResponseData<Long> add(CouponDefinitionPOWithBLOBs po, SysAccountPo accountPo);


    /**
     * 修改券定义
     *
     * @param po
     * @return
     */
    ResponseData<Object> update(CouponDefinitionPOWithBLOBs po);


    /**
     * 获取券定义详情
     *
     * @param couponDefinitionId
     * @return
     */
    ResponseData<CouponDefinitionPOWithBLOBs> getCouponDefinition(Long couponDefinitionId);

    /**
     * 券自定义模板查询
     *
     * @param couponDefinitionPO
     * @return
     */
    ResponseData<PageInfo> getTemplate(CouponDefinitionPO couponDefinitionPO, PageFormUtil pageFormUtil, SysAccountPo accountPo);

    /**
     * 查询可用的券信息
     *
     * @param vo
     * @return
     */
    ResponseData<PageInfo<CouponDefinitionPO>> getUseList(CouponDefinitionListQueryVO vo, PageFormUtil pageForm, Long brandId);

    /**
     * 根据id字符串查找商品集合
     *
     * @param order
     * @param sysAccountPo
     * @return
     */
    ResponseData<PageInfo<SysDimSkuPo>> getIdSysDimSkuList(String order, String productCode, String productName, PageFormUtil page, SysAccountPo sysAccountPo);

    /**
     * 查询门店信息列表
     *
     * @return
     */
    ResponseData<PageInfo<SysStorePo>> getIdStoreList(String store, String sysStoreOfflineCode, String storeName,
                                                      PageFormUtil page, SysAccountPo sysAccountPo);

    /**
     * 判断券是否过期
     * @param couponDefinitionId
     * @return
     */
    ResponseData<Boolean> couponDefinitionExpire(Long couponDefinitionId)throws Exception;

	ResponseData<Object> definitionMoneyRpc(CouponDefinitionMoneyPO po);

	ResponseData<PageInfo<CouponDefinitionCodePO>> getListDefinitionCode(CouponDefinitionCodeQueryVO vo,
                                                                         PageFormUtil pageForm, Long brandId, Long sysCompanyId);
}
