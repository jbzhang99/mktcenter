package com.bizvane.couponservice.service.impl;

import com.bizvane.centerstageservice.models.po.SysAccountPo;
import com.bizvane.centerstageservice.models.po.SysDimSkuPo;
import com.bizvane.centerstageservice.models.po.SysStorePo;
import com.bizvane.centerstageservice.rpc.StoreServiceRpc;
import com.bizvane.centerstageservice.rpc.SysDimSkuServiceRpc;
import com.bizvane.couponfacade.models.po.*;
import com.bizvane.couponfacade.models.vo.CouponDefinitionCodeQueryVO;
import com.bizvane.couponfacade.models.vo.CouponDefinitionListQueryVO;
import com.bizvane.couponfacade.utils.PageFormUtil;
import com.bizvane.couponfacade.utils.TimeUtils;
import com.bizvane.couponservice.common.constants.SysResponseEnum;
import com.bizvane.couponservice.common.constants.SystemConstants;
import com.bizvane.couponservice.common.utils.BusinessCodeUtil;
import com.bizvane.couponservice.mappers.CouponDefinitionCodePOMapper;
import com.bizvane.couponservice.mappers.CouponDefinitionMoneyPOMapper;
import com.bizvane.couponservice.mappers.CouponDefinitionPOMapper;
import com.bizvane.couponservice.service.CouponDefinitionService;
import com.github.pagehelper.PageInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import com.github.pagehelper.PageHelper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class CouponDefinitionServiceImpl implements CouponDefinitionService {

    private static Logger logger = LoggerFactory.getLogger(CouponDefinitionServiceImpl.class);

    @Autowired
    private CouponDefinitionPOMapper couponDefinitionPOMapper;
    
    @Autowired
    private  CouponDefinitionMoneyPOMapper couponDefinitionMoneyPOMapper;

    @Autowired
    private SysDimSkuServiceRpc sysDimSkuServiceRpc;

    @Autowired
    private StoreServiceRpc storeServiceRpc;
    
    @Autowired
    private  CouponDefinitionCodePOMapper couponDefinitionCodePOMapper;

    /**
     * 券定义列表分页查询
     *
     * @param vo
     * @return
     */
    @Override
    public ResponseData<PageInfo<CouponDefinitionPO>> getList(CouponDefinitionListQueryVO vo, PageFormUtil pageForm, Long sysBrandId, Long companyId) {
        logger.info("enter CouponDefinitionServiceImpl getList method");
        ResponseData<PageInfo<CouponDefinitionPO>> responseData = new ResponseData<>();

        PageHelper.startPage(pageForm.getPageNumber(), pageForm.getPageSize());

        List<CouponDefinitionPO> list = couponDefinitionPOMapper.findCouponDefinitionListByConds(vo, sysBrandId, companyId);

        PageInfo<CouponDefinitionPO> pageInfo = new PageInfo<>(list);

        responseData.setData(pageInfo);
        return responseData;
    }
    
    
	@Override
	public ResponseData<PageInfo<CouponDefinitionCodePO>> getListDefinitionCode(CouponDefinitionCodeQueryVO vo,
			PageFormUtil pageForm, Long sysBrandId, Long sysCompanyId) {
        logger.info("enter CouponDefinitionServiceImpl getListDefinitionCode method");
        ResponseData<PageInfo<CouponDefinitionCodePO>> responseData = new ResponseData<>();

        PageHelper.startPage(pageForm.getPageNumber(), pageForm.getPageSize());

        List<CouponDefinitionCodePO> list = couponDefinitionCodePOMapper.findCouponCode(vo, sysBrandId, sysCompanyId);

        PageInfo<CouponDefinitionCodePO> pageInfo = new PageInfo<>(list);

        responseData.setData(pageInfo);
        return responseData;
	}

    /**
     * 券定义列表分页查询
     *
     * @param vo
     * @return
     */
    @Override
    public ResponseData<PageInfo<CouponDefinitionPO>> getListRpc(CouponDefinitionListQueryVO vo, PageFormUtil pageForm) {
        logger.info("enter CouponDefinitionServiceImpl getList method");
        ResponseData<PageInfo<CouponDefinitionPO>> responseData = new ResponseData<>();

        if (null == vo.getSysBrandId()) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.SYS_BRAND_ID_NOT_NULL.getMessage());
            return responseData;
        }

        PageHelper.startPage(pageForm.getPageNumber(), pageForm.getPageSize());

        List<CouponDefinitionPO> list = couponDefinitionPOMapper.findCouponDefinitionListByConds(vo, vo.getSysBrandId(), vo.getSysCompanyId());

        PageInfo<CouponDefinitionPO> pageInfo = new PageInfo<>(list);

        responseData.setData(pageInfo);
        return responseData;
    }


    /**
     * 添加券定义
     *
     * @param po
     * @return
     */
    @Override
    public ResponseData<Long> add(CouponDefinitionPOWithBLOBs po, SysAccountPo accountPo) {
        logger.info("enter CouponDefinitionServiceImpl add method");
        ResponseData<Long> responseData = new ResponseData<>();

        //如果是线下券或全渠道券，线下券code不能为空
        if (SystemConstants.USE_CHANNEL_OFFLINE.equals(po.getErpCouponDefinitionCode()) ||
                SystemConstants.USE_CHANNEL_ANY.equals(po.getErpCouponDefinitionCode())) {
            if (StringUtils.isBlank(po.getErpCouponDefinitionCode())) {
                responseData.setCode(SysResponseEnum.FAILED.getCode());
                responseData.setMessage(SysResponseEnum.ERP_COUPON_DEFINITION_CODE_NOT_NULL.getMessage());
                return responseData;
            }
        }

        po.setCouponDefinitionCode(BusinessCodeUtil.getCouponDefinitionCode());
        po.setSysCompanyId(accountPo.getSysCompanyId());
        po.setSysBrandId(accountPo.getBrandId());
        po.setCouponDefinitionType(SystemConstants.COUPON_DEFINITION_TYPE_ONLINE);
        po.setCreateUserId(accountPo.getSysAccountId());
        po.setCreateUserName(accountPo.getName());
        po.setCreateDate(TimeUtils.getNowTime());
        //最低消费金额不能为空，否则线下发券报错
        po.setMinConsume(po.getMinConsume() == null ? BigDecimal.ZERO : po.getMinConsume());

        //计算有效期开始到结束区间
    /*if (po.getValidType().equals(SystemConstants.VALID_TYPE__SOMEDAY)) {
      Calendar calendar = Calendar.getInstance();
      calendar.add(Calendar.DATE, po.getValidDay());
      po.setValidDateStart(TimeUtils.getNowTime());
      po.setValidDateEnd(calendar.getTime());
    }*/

        couponDefinitionPOMapper.insertSelective(po);

        responseData.setData(po.getCouponDefinitionId());
        return responseData;
    }


    /**
     * 修改券定义
     *
     * @param po
     * @return
     */
    @Override
    public ResponseData<Object> update(CouponDefinitionPOWithBLOBs po) {
        logger.info("enter CouponDefinitionServiceImpl update method");
        ResponseData<Object> responseData = new ResponseData<>();

        if (null == po.getCouponDefinitionId()) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_DEFINITION_ID_NOT_NULL.getMessage());
            return responseData;
        }

        po.setModifiedDate(TimeUtils.getNowTime());
        int result = couponDefinitionPOMapper.updateByPrimaryKeySelective(po);

        responseData.setData(result);
        return responseData;
    }
    
    

    /**
     * 修改券定义
     *
     * @param po
     * @return
     */
    @Transactional
    @Override
    public ResponseData<Object> definitionMoneyRpc(CouponDefinitionMoneyPO po) {
        logger.info("enter CouponDefinitionServiceImpl definitionMoneyRpc method");
        ResponseData<Object> responseData = new ResponseData<>();

           //没有找到就更新
        CouponDefinitionMoneyPOExample  example= new CouponDefinitionMoneyPOExample();
        example.createCriteria().andTaskIdEqualTo(po.getTaskId());
        List<CouponDefinitionMoneyPO> selectByExamplelist =  couponDefinitionMoneyPOMapper.selectByExample(example);
        
        if(CollectionUtils.isEmpty(selectByExamplelist)) {
        	po.setNumber((byte)1);
            int result = couponDefinitionMoneyPOMapper.insert(po);
            responseData.setData(result);
            return responseData;
        }

        
        po.setModifiedDate(TimeUtils.getNowTime());
    	CouponDefinitionMoneyPO couponDefinitionMoneyOld =selectByExamplelist.get(0);
    	po.setMoneyAdd(po.getMoneyAdd().add(couponDefinitionMoneyOld.getMoneyAdd()));
        po.setNumber ((byte) (couponDefinitionMoneyOld.getNumber()+1));
        po.setCouponDefinitionMoneyId(couponDefinitionMoneyOld.getCouponDefinitionMoneyId());
        int result = couponDefinitionMoneyPOMapper.updateByPrimaryKeySelective(po);

        responseData.setData(result);
        return responseData;
    }



	/**
     * 获取券定义详情
     *
     * @param couponDefinitionId
     * @return
     */
    @Override
    public ResponseData<CouponDefinitionPOWithBLOBs> getCouponDefinition(Long couponDefinitionId) {
        logger.info("enter CouponDefinitionServiceImpl getCouponDefinition method");
        ResponseData<CouponDefinitionPOWithBLOBs> responseData = new ResponseData<>();

        if (null == couponDefinitionId) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_DEFINITION_ID_NOT_NULL.getMessage());
            return responseData;
        }

        CouponDefinitionPOWithBLOBs couponDefinitionPOWithBLOBs = couponDefinitionPOMapper.selectByPrimaryKey(couponDefinitionId);

        responseData.setData(couponDefinitionPOWithBLOBs);
        return responseData;
    }

    /**
     * 券自定义模板查询
     *
     * @param couponDefinitionPO
     * @return
     */
    @Override
    public ResponseData<PageInfo> getTemplate(CouponDefinitionPO couponDefinitionPO, PageFormUtil pageFormUtil, SysAccountPo accountPo) {
        logger.info("enter CouponDefinitionServiceImpl getTemplate method");
        ResponseData<PageInfo> responseData = new ResponseData<>();

        CouponDefinitionPOExample example = new CouponDefinitionPOExample();
        CouponDefinitionPOExample.Criteria criteria = example.createCriteria();
        criteria.andValidEqualTo(SystemConstants.TABLE_VALID_EFFECTIVE);
        criteria.andCreateUserIdEqualTo(accountPo.getSysAccountId());
        criteria.andIsAddTemplateEqualTo(SystemConstants.TABLE_VALID_EFFECTIVE);
        criteria.andSysBrandIdEqualTo(accountPo.getBrandId());
        criteria.andStatusEqualTo(SystemConstants.TABLE_VALID_EFFECTIVE);

        if (StringUtils.isNotBlank(couponDefinitionPO.getCouponName())) {
            criteria.andCouponNameLike("%" + couponDefinitionPO.getCouponName() + "%");
        }
        if (couponDefinitionPO.getPreferentialType() != null) {
            criteria.andPreferentialTypeEqualTo(couponDefinitionPO.getPreferentialType());
        }
        if (couponDefinitionPO.getUseChannel() != null) {
            criteria.andUseChannelEqualTo(couponDefinitionPO.getUseChannel());
        }
        example.setOrderByClause("create_date DESC");

        PageHelper.startPage(pageFormUtil.getPageNumber(), pageFormUtil.getPageSize());

        List<CouponDefinitionPO> list = couponDefinitionPOMapper.selectByExample(example);

        PageInfo<List<CouponDefinitionPO>> pageInfo = new PageInfo(list);

        responseData.setData(pageInfo);
        return responseData;
    }


    /**
     * 查询可用的券信息
     *
     * @param vo
     * @return
     */
    @Override
    public ResponseData<PageInfo<CouponDefinitionPO>> getUseList(CouponDefinitionListQueryVO vo, PageFormUtil pageForm, Long brandId) {

        ResponseData<PageInfo<CouponDefinitionPO>> responseData = new ResponseData<>();

    /*CouponDefinitionPOExample definitionExample = new CouponDefinitionPOExample();
    CouponDefinitionPOExample.Criteria criteria = definitionExample.createCriteria();
    criteria.andValidEqualTo(SystemConstants.TABLE_VALID_EFFECTIVE)
            .andSysBrandIdEqualTo(brandId).andStatusEqualTo(SystemConstants.COUPON_DEFINITION_STATUS_USE);*/

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Date date = format.parse(format.format(new Date()), new ParsePosition(0));

        //criteria.andValidDateEndGreaterThanOrEqualTo(format.parse(format.format(new Date()),new ParsePosition(0)));
    /*if(vo.getCouponName() != null){
      criteria.andCouponNameLike("%"+vo.getCouponName()+"%");
    }
    if(vo.getCouponDefinitionId() != null){
      criteria.andCouponDefinitionIdEqualTo(vo.getCouponDefinitionId());
    }
    definitionExample.setOrderByClause("create_date DESC");*/

        PageHelper.startPage(pageForm.getPageNumber(), pageForm.getPageSize());

        //List<CouponDefinitionPOWithBLOBs> definitionPOList = couponDefinitionPOMapper.selectByExampleWithBLOBs(definitionExample);

        List<CouponDefinitionPOWithBLOBs> definitionPOList = couponDefinitionPOMapper.getUseList(vo.getTransferFission(),vo.getPreferentialType(), brandId, date, SystemConstants.TABLE_VALID_EFFECTIVE,
                SystemConstants.COUPON_DEFINITION_STATUS_USE,
                vo.getCouponDefinitionId(), vo.getCouponName(),
                SystemConstants.VALID_TYPE__INTERVAL, SystemConstants.VALID_TYPE__SOMEDAY);

        PageInfo pageInfo = new PageInfo(definitionPOList);
        responseData.setData(pageInfo);
        return responseData;
    }


    /**
     * 根据id字符串查找商品集合
     *
     * @param order
     * @param sysAccountPo
     * @return
     */
    @Override
    public ResponseData<PageInfo<SysDimSkuPo>> getIdSysDimSkuList(String order, String productCode, String productName, PageFormUtil page,
                                                                  SysAccountPo sysAccountPo) {

        ResponseData<PageInfo<SysDimSkuPo>> responseData = new ResponseData<>();
        if (StringUtils.isBlank(order)) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.SYSTEM_DATA_NOT_EMPTY.getMessage());
            return responseData;
        }
        List<String> sysDimSkuIdList = Arrays.asList(order.split(","));

        List<String> id = new ArrayList<>();

        for (String value : sysDimSkuIdList) {
            id.add(value);
        }

        responseData = sysDimSkuServiceRpc.getIdSysDimProductList(id, productCode, productName, page.getPageNumber(),
                page.getPageSize());
        return responseData;
    }


    /**
     * 查询门店信息列表
     *
     * @return
     */
    @Override
    public ResponseData<PageInfo<SysStorePo>> getIdStoreList(String store, String sysStoreOfflineCode, String storeName,
                                                             PageFormUtil page, SysAccountPo sysAccountPo) {

        ResponseData<PageInfo<SysStorePo>> responseData = new ResponseData<>();
        if (StringUtils.isBlank(store)) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.SYSTEM_DATA_NOT_EMPTY.getMessage());
            return responseData;
        }

        List<String> storeList = Arrays.asList(store.split(","));

        List<Long> id = new ArrayList<>();

        for (String value : storeList) {
        	// code 转id
        	ResponseData<Long> getStoreIdByCode  =	storeServiceRpc.getStoreIdByCode(value);
            id.add(getStoreIdByCode.getData());
        }

        responseData = storeServiceRpc.getIdStoreList(id, sysStoreOfflineCode, storeName, page.getPageNumber(), page.getPageSize());

        return responseData;
    }


    /**
     * 判断券是否过期
     *
     * @param couponDefinitionId
     * @return
     */
    @Override
    public ResponseData<Boolean> couponDefinitionExpire(Long couponDefinitionId)throws Exception{

        ResponseData responseData = new ResponseData();

        Boolean ifExpire = Boolean.FALSE;

        CouponDefinitionPO couponDefinitionPO = couponDefinitionPOMapper.selectByPrimaryKey(couponDefinitionId);

        if(couponDefinitionPO.getValidType().equals(SystemConstants.VALID_TYPE__INTERVAL)){

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            Date endDate = format.parse(format.format(couponDefinitionPO.getValidDateEnd()));

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(endDate);
            calendar.add(Calendar.DATE,1);
            endDate = calendar.getTime();

            Date now = format.parse(format.format(new Date()));


            if(endDate.getTime()<now.getTime()){
                ifExpire = Boolean.TRUE;
            }
        }

        responseData.setData(ifExpire);
        return responseData;
    }


}
