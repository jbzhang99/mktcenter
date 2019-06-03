package com.bizvane.couponservice.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.centerstageservice.models.po.SysAccountPo;
import com.bizvane.centerstageservice.models.po.SysStaffPo;
import com.bizvane.centerstageservice.rpc.StaffServiceRpc;
import com.bizvane.couponfacade.models.po.CouponDefinitionPOWithBLOBs;
import com.bizvane.couponfacade.models.po.CouponQuotaDetailPO;
import com.bizvane.couponfacade.models.po.CouponQuotaDetailPOExample;
import com.bizvane.couponfacade.models.po.CouponQuotaPO;
import com.bizvane.couponfacade.models.vo.CouponQuotaDetailVO;
import com.bizvane.couponfacade.models.vo.CouponQuotaVO;
import com.bizvane.couponfacade.utils.PageFormUtil;
import com.bizvane.couponfacade.utils.TimeUtils;
import com.bizvane.couponservice.mappers.CouponDefinitionPOMapper;
import com.bizvane.couponservice.mappers.CouponQuotaDetailPOMapper;
import com.bizvane.couponservice.mappers.CouponQuotaPOMapper;
import com.bizvane.couponservice.service.CouponQuotaService;
import com.github.pagehelper.PageInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class CouponQuotaServiceImpl implements CouponQuotaService{

    private static Logger logger = LoggerFactory.getLogger(CouponQuotaServiceImpl.class);
    
    @Autowired 
    private CouponQuotaDetailPOMapper couponQuotaDetailPOMapper;
    
    @Autowired
    private  CouponQuotaPOMapper couponQuotaPOMapper;
    
    @Autowired
    private CouponDefinitionPOMapper couponDefinitionPOMapper;
    
    @Autowired
    private   StaffServiceRpc staffServiceRpc;
    
	@Override
	public ResponseData<String> updateBycouponQuotaId(CouponQuotaVO vo, SysAccountPo accountPo) {
		 ResponseData<String> responseData = new ResponseData<>();
		 
		     vo.setModifiedDate(new Date());
            //	券配额
		    couponQuotaPOMapper.updateByPrimaryKeySelective(vo);
           //	员工张数
		    CouponQuotaDetailPO failLogPO = new CouponQuotaDetailPO();
	        failLogPO.setValid(vo.getState());
	        failLogPO.setModifiedDate(new Date());
	        
	        CouponQuotaDetailPOExample example = new CouponQuotaDetailPOExample();
	        example.createCriteria().andCouponQuotaIdEqualTo(vo.getCouponQuotaId());
	      int responseDatalong=couponQuotaDetailPOMapper.updateByExampleSelective(failLogPO, example);
        responseData.setData(String.valueOf(responseDatalong));
        return responseData;
	}
    


    /**
     * 添加券定义
     * @param po
     * @return
     */
    @Override
    public ResponseData<Long> add(CouponQuotaVO po, SysAccountPo accountPo) {
      logger.info("enter CouponQuotaServiceImpl add method"+JSONObject.toJSONString(po));
      ResponseData<Long> responseData = new ResponseData<>();

//      基本信息
      po.setSysCompanyId(accountPo.getSysCompanyId());
      po.setSysBrandId(accountPo.getBrandId());
      po.setCreateUserId(accountPo.getSysAccountId());
      po.setCreateUserName(accountPo.getName());
      po.setCreateDate(TimeUtils.getNowTime());
      po.setState(true);
      po.setValid(true);
      
     
         //  券信息
        CouponDefinitionPOWithBLOBs couponDefinitionPOWithBLOBs = couponDefinitionPOMapper.selectByPrimaryKey(po.getCouponDefinitionId());
        
        po.setCouponName(couponDefinitionPOWithBLOBs.getCouponName());
         // 分配人数
        po.setMemberCount(po.getStaffCodeList().size());
         // 分配总张数 =人数*人均   
        po.setTotalNumber(po.getMemberCount()*po.getMemberAverage());
//        使用张数
        Map<String,Integer> zhangshuMap= new HashMap<String, Integer>();
        String couponQuotaId=null;
        if(po.getCouponQuotaId()==null) {
        	 couponQuotaPOMapper.insertSelective(po);
        }else {
        	couponQuotaId="notUNLL";
//        	更新
        	couponQuotaPOMapper.updateByPrimaryKeySelective(po);
        	
 	        CouponQuotaDetailPOExample examplefind = new CouponQuotaDetailPOExample();
 	        examplefind.createCriteria().andCouponQuotaIdEqualTo(po.getCouponQuotaId());
 	     	List<CouponQuotaDetailPO> selectByExamplelist= couponQuotaDetailPOMapper.selectByExample(examplefind);
 	     	for(CouponQuotaDetailPO selectByExample: selectByExamplelist) {
 	 	     	Integer totalNumber =	selectByExample.getTotalNumber();
 	 	     	Integer unuseNumber =	selectByExample.getUnuseNumber();
// 	 	     	使用张数
 	 	     	Integer useNumber =	totalNumber-unuseNumber;
 	 	     	zhangshuMap.put(selectByExample.getStaffCode(), useNumber);
 	     	}

//        	删数原来数据
 	        CouponQuotaDetailPOExample example = new CouponQuotaDetailPOExample();
 	        example.createCriteria().andCouponQuotaIdEqualTo(po.getCouponQuotaId());
        	 couponQuotaDetailPOMapper.deleteByExample(example);
        	
        }
       
      
      
//      券配额与员工关系表
        CouponQuotaDetailPO  couponQuotaDetailPO =new CouponQuotaDetailPO();
        couponQuotaDetailPO.setSysCompanyId(accountPo.getSysCompanyId());
        couponQuotaDetailPO.setSysBrandId(accountPo.getBrandId());
        couponQuotaDetailPO.setCreateUserId(accountPo.getSysAccountId());
        couponQuotaDetailPO.setCreateUserName(accountPo.getName());
        couponQuotaDetailPO.setCreateDate(TimeUtils.getNowTime());

	       couponQuotaDetailPO.setCouponQuotaId(po.getCouponQuotaId());//'券配额表主键',
	       couponQuotaDetailPO.setQuotaTopic(po.getQuotaTopic());//'分配主题',
	       couponQuotaDetailPO.setTotalNumber(po.getMemberAverage());//'个人配额总数',
	       couponQuotaDetailPO.setUnuseNumber(po.getMemberAverage());//'剩余张数',
//
	       couponQuotaDetailPO.setCouponDefinitionCode(couponDefinitionPOWithBLOBs.getCouponDefinitionCode());
	       couponQuotaDetailPO.setCouponDefinitionId(po.getCouponDefinitionId());
	       couponQuotaDetailPO.setPreferentialType(couponDefinitionPOWithBLOBs.getPreferentialType());
	       couponQuotaDetailPO.setCouponName(couponDefinitionPOWithBLOBs.getCouponName());
	       couponQuotaDetailPO.setMoney(couponDefinitionPOWithBLOBs.getMoney());
	       couponQuotaDetailPO.setDiscount(couponDefinitionPOWithBLOBs.getDiscount());
	       couponQuotaDetailPO.setInfo(couponDefinitionPOWithBLOBs.getInfo());
	       
	       
	       //券可发送有效时间
	       couponQuotaDetailPO.setStartDateStart(po.getStartDate());
	       couponQuotaDetailPO.setStartDateEnd(po.getEndDate());
	       //券使用有效时间
	       couponQuotaDetailPO.setValidDateStart(couponDefinitionPOWithBLOBs.getValidDateStart());
	       couponQuotaDetailPO.setValidDateEnd(couponDefinitionPOWithBLOBs.getValidDateEnd());
	       couponQuotaDetailPO.setValidType(couponDefinitionPOWithBLOBs.getValidType());
	       couponQuotaDetailPO.setValidDay(couponDefinitionPOWithBLOBs.getValidDay());
	       couponQuotaDetailPO.setMinConsume(couponDefinitionPOWithBLOBs.getMinConsume());
	       couponQuotaDetailPO.setValid(true);
        //根据员工id找店铺信息TODO 中台提供接口  
	       String staffCodes = ""; 
	       
	       for(SysStaffPo staffCode:po.getStaffCodeList()) {
	    	   staffCodes=staffCodes+","+staffCode.getStaffCode();
	       }
	       ResponseData<Map<String,String>> getStoreNamesMap =  staffServiceRpc.getStoreNamesByStaffCodes(staffCodes);
	       
	    //没有id就是新增
	    if(couponQuotaId==null) {
	    	 
	         for(SysStaffPo staffCode:po.getStaffCodeList()) {
	         	couponQuotaDetailPO.setStaffCode(staffCode.getStaffCode());
	         	couponQuotaDetailPO.setStaffName(staffCode.getStaffName());
	         	couponQuotaDetailPO.setSysStaffId(staffCode.getSysStaffId());
	         	couponQuotaDetailPO.setStoreName(getStoreNamesMap.getData().get(staffCode.getStaffCode()));
	             couponQuotaDetailPOMapper.insertSelective(couponQuotaDetailPO);
	         }
	    	 
	         responseData.setData(po.getCouponDefinitionId());
	         return responseData;
	     }
	       
	     
	     //修改
        for(SysStaffPo staffCode:po.getStaffCodeList()) {
        	couponQuotaDetailPO.setStaffCode(staffCode.getStaffCode());
        	couponQuotaDetailPO.setStaffName(staffCode.getStaffName());
        	couponQuotaDetailPO.setSysStaffId(staffCode.getSysStaffId());
        	couponQuotaDetailPO.setStoreName(getStoreNamesMap.getData().get(staffCode.getStaffCode()));
        	
        	if(zhangshuMap.get(staffCode.getStaffCode())!=null) {
        		Integer zhangshu = po.getMemberAverage()-zhangshuMap.get(staffCode.getStaffCode());
        		//配置张数
        		if(zhangshu>0) {
        			couponQuotaDetailPO.setUnuseNumber(zhangshu);//'剩余张数',
        		}else {
        			couponQuotaDetailPO.setUnuseNumber(0);//'剩余张数',
        		}
        		
        	}
        	
            couponQuotaDetailPOMapper.insertSelective(couponQuotaDetailPO);
        }


      responseData.setData(po.getCouponDefinitionId());
      return responseData;
    }

	@Override
	public ResponseData<PageInfo<CouponQuotaPO>> getCouponQuotaList(CouponQuotaVO vo, SysAccountPo accountPo,PageFormUtil pageForm) {
			
        logger.info("enter CouponEntityServiceImpl getList method");
        ResponseData<PageInfo<CouponQuotaPO>> responseData = new ResponseData<>();

        //本品牌
        vo.setSysBrandId(accountPo.getBrandId());

        PageHelper.startPage(pageForm.getPageNumber(),pageForm.getPageSize(),true);


        List<CouponQuotaPO> entityVOList = couponQuotaPOMapper.findCouponEntityByConditions(vo);

        PageInfo<CouponQuotaPO> pageInfo = new PageInfo<CouponQuotaPO>(entityVOList);

        responseData.setData(pageInfo);
        return responseData;
	}

	@Override
	public ResponseData<PageInfo<CouponQuotaDetailPO>> getCouponQuotaListDetail(CouponQuotaDetailVO vo,
			SysAccountPo accountPo, PageFormUtil pageForm) {
        logger.info("enter CouponEntityServiceImpl getList method");
        ResponseData<PageInfo<CouponQuotaDetailPO>> responseData = new ResponseData<>();

        //本品牌
        vo.setSysBrandId(accountPo.getBrandId());

        PageHelper.startPage(pageForm.getPageNumber(),pageForm.getPageSize(),true);


        List<CouponQuotaDetailPO> entityVOList = couponQuotaDetailPOMapper.findCouponQuotaDetailPOByConditionsall(vo);
//
        PageInfo<CouponQuotaDetailPO> pageInfo = new PageInfo<CouponQuotaDetailPO>(entityVOList);

        responseData.setData(pageInfo);
        return responseData;
	}
	
	
	@Override
	public ResponseData<List<CouponQuotaDetailPO>> getCouponQuotaListDetailforupdate(CouponQuotaDetailVO vo,
			SysAccountPo accountPo) {
        logger.info("enter CouponEntityServiceImpl getList method");
        ResponseData<List<CouponQuotaDetailPO>> responseData = new ResponseData<>();

        vo.setSysBrandId(accountPo.getBrandId());
        
        List<CouponQuotaDetailPO> entityVOList = couponQuotaDetailPOMapper.findCouponQuotaDetailPOByConditionsall(vo);
        
        responseData.setData(entityVOList);
        return responseData;
	}




}
