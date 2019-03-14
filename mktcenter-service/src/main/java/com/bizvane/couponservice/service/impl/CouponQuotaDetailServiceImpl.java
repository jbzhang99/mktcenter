package com.bizvane.couponservice.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.centerstageservice.models.po.SysAccountPo;
import com.bizvane.couponfacade.models.po.*;
import com.bizvane.couponfacade.models.vo.CouponEntityVO;
import com.bizvane.couponfacade.models.vo.CouponQuotaDetailVO;
import com.bizvane.couponfacade.models.vo.CouponStatusEntitySuccessVO;
import com.bizvane.couponfacade.models.vo.SendCouponQuotaBatchRequestVO;
import com.bizvane.couponfacade.utils.PageFormUtil;
import com.bizvane.couponfacade.utils.TimeUtils;
import com.bizvane.couponservice.common.constants.SystemConstants;
import com.bizvane.couponservice.mappers.CouponDefinitionPOMapper;
import com.bizvane.couponservice.mappers.CouponEntityPOMapper;
import com.bizvane.couponservice.mappers.CouponQuotaDetailPOMapper;
import com.bizvane.couponservice.mappers.CouponQuotaSendDetailPOMapper;
import com.bizvane.couponservice.service.CouponQuotaDetailService;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.models.query.CouponMemberPo;
import com.bizvane.members.facade.service.api.MemberInfoApiService;
import com.bizvane.utils.responseinfo.PageInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import com.github.pagehelper.PageHelper;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by yunjie.tian on 2018/7/20.
 */
@Service
public class CouponQuotaDetailServiceImpl implements CouponQuotaDetailService{

    private static Logger logger = LoggerFactory.getLogger(CouponQuotaDetailServiceImpl.class);
    
    @Autowired 
    private CouponQuotaDetailPOMapper couponQuotaDetailPOMapper;
    
    @Autowired 
    private   CouponQuotaSendDetailPOMapper  couponQuotaSendDetailPOMapper;
    
    @Autowired
    private CouponDefinitionPOMapper couponDefinitionPOMapper;
    

    @Autowired
    private  CouponEntityPOMapper couponEntityPOMapper;
    
    @Autowired
    private    MemberInfoApiService memberInfoApiService;


	@Override
	public ResponseData<PageInfo<CouponQuotaDetailPO>> getCouponQuotaListDetail(CouponQuotaDetailVO vo,
			SysAccountPo accountPo, PageFormUtil pageForm) {
        logger.info("enter CouponEntityServiceImpl getList method");
        ResponseData<PageInfo<CouponQuotaDetailPO>> responseData = new ResponseData<>();

        //本品牌
        vo.setSysBrandId(accountPo.getBrandId());

        PageHelper.startPage(pageForm.getPageNumber(),pageForm.getPageSize(),true);

//        加时间
        List<CouponQuotaDetailPO> entityVOList = couponQuotaDetailPOMapper.findCouponQuotaDetailPOByConditions(vo);
//
        PageInfo<CouponQuotaDetailPO> pageInfo = new PageInfo<CouponQuotaDetailPO>(entityVOList);

        responseData.setData(pageInfo);
        return responseData;
	}
	@Override
	public ResponseData<CouponQuotaDetailPO> getCouponQuotaListDetail(CouponQuotaDetailVO vo) {
        logger.info("enter CouponEntityServiceImpl getList method");
        ResponseData<CouponQuotaDetailPO> responseData = new ResponseData<>();

        List<CouponQuotaDetailPO> entityVOList = couponQuotaDetailPOMapper.findCouponQuotaDetailPOByConditions(vo);

        responseData.setData(entityVOList.get(0));
        return responseData;
	}


    /**
     * 保存配额表记录
     * @param vo
     * @return
     */
	@Override
	public ResponseData<String> batchRpc(SendCouponQuotaBatchRequestVO vo) {
		
		ResponseData<String> responseData = new ResponseData<>();
		CouponQuotaSendDetailPO  couponQuotaSendDetailPO  =new CouponQuotaSendDetailPO();
		
		  int  unuseNumberend=0;
		//扣数量，
		  CouponQuotaDetailPOExample example = new CouponQuotaDetailPOExample();
		  example.createCriteria().andStaffCodeEqualTo(vo.getStaffCode()).andCouponQuotaIdEqualTo(vo.getCouponQuotaId());
	     List<CouponQuotaDetailPO>  couponQuotaDetaillist =	couponQuotaDetailPOMapper.selectByExample(example);
          if(CollectionUtils.isNotEmpty(couponQuotaDetaillist)) {
        	  int  unuseNumber= couponQuotaDetaillist.get(0).getUnuseNumber().intValue();
        	  int  memberNum= Integer.valueOf(vo.getMemberNum()).intValue();
        	  if(memberNum>unuseNumber) {
              //数量不够 
        		    responseData.setCode(100);
        		    responseData.setMessage("剩余数量不够！");
        	        return responseData;
        	  }
        	  unuseNumberend=unuseNumber-memberNum;
        	  
          }
          
          // 减数量
          CouponQuotaDetailPO couponQuotaDetailPO =new CouponQuotaDetailPO();
          couponQuotaDetailPO.setUnuseNumber(unuseNumberend);
          couponQuotaDetailPOMapper.updateByExampleSelective(couponQuotaDetailPO, example);
        //  人信息
       couponQuotaSendDetailPO.setStaffCode(vo.getStaffCode());//
       couponQuotaSendDetailPO.setStaffName(vo.getStaffName());//
       couponQuotaSendDetailPO.setSysCompanyId(vo.getSysCompanyId());
       couponQuotaSendDetailPO.setSysBrandId(vo.getSysBrandId());
       
       couponQuotaSendDetailPO.setCouponQuotaDetailId(couponQuotaDetaillist.get(0).getCouponQuotaDetailId());

       couponQuotaSendDetailPO.setMemberCodeList(vo.getMemberCodeStr());
       couponQuotaSendDetailPO.setMemberNameList(vo.getMemberNameStr());
       couponQuotaSendDetailPO.setMemberNum(vo.getMemberNum());

        //  根据券定义id 找券信息
       CouponDefinitionPOWithBLOBs couponDefinitionPOWithBLOBs= couponDefinitionPOMapper.selectByPrimaryKey(vo.getCouponDefinitionId());
       
       couponQuotaSendDetailPO.setCouponDefinitionCode(couponDefinitionPOWithBLOBs.getCouponDefinitionCode());
       couponQuotaSendDetailPO.setCouponDefinitionId(couponDefinitionPOWithBLOBs.getCouponDefinitionId());
       couponQuotaSendDetailPO.setPreferentialType(couponDefinitionPOWithBLOBs.getPreferentialType());
       couponQuotaSendDetailPO.setCouponName(couponDefinitionPOWithBLOBs.getCouponName());
       couponQuotaSendDetailPO.setMoney(couponDefinitionPOWithBLOBs.getMoney());
       couponQuotaSendDetailPO.setDiscount(couponDefinitionPOWithBLOBs.getDiscount());
       couponQuotaSendDetailPO.setInfo(couponDefinitionPOWithBLOBs.getInfo());
       couponQuotaSendDetailPO.setValidDateStart(couponDefinitionPOWithBLOBs.getValidDateStart());
       couponQuotaSendDetailPO.setValidDateEnd(couponDefinitionPOWithBLOBs.getValidDateEnd());
       couponQuotaSendDetailPO.setCreateDate(TimeUtils.getNowTime());
       couponQuotaSendDetailPO.setValid(SystemConstants.TABLE_VALID_EFFECTIVE);
       couponQuotaSendDetailPO.setValidDay(couponDefinitionPOWithBLOBs.getValidDay());
       couponQuotaSendDetailPO.setValidType(couponDefinitionPOWithBLOBs.getValidType());
       couponQuotaSendDetailPO.setMinConsume(couponDefinitionPOWithBLOBs.getMinConsume());
       
       
       
		//券历史表
		int data=couponQuotaSendDetailPOMapper.insertSelective(couponQuotaSendDetailPO);
		
		
        responseData.setData(couponQuotaSendDetailPO.getCouponQuotaSendDetailId()+"");
        return responseData;
	}




    //我的优惠券列表
	@Override
	public ResponseData<PageInfo<CouponQuotaSendDetailPO>> getSendCouponQuotaListDetail(CouponQuotaDetailVO vo,
			SysAccountPo accountPo, PageFormUtil pageForm) {
        logger.info("enter CouponEntityServiceImpl getList method");
        ResponseData<PageInfo<CouponQuotaSendDetailPO>> responseData = new ResponseData<>();

        //本品牌
        vo.setSysBrandId(accountPo.getBrandId());

        PageHelper.startPage(pageForm.getPageNumber(),pageForm.getPageSize(),true);
        
//        CouponQuotaSendDetailPO couponQuotaSendDetailPO =new CouponQuotaSendDetailPO();
//        couponQuotaSendDetailPO.setSysBrandId(vo.getSysBrandId());
//        couponQuotaSendDetailPO.setStateCode(vo.getStaffCode());

        CouponQuotaSendDetailPOExample example = new CouponQuotaSendDetailPOExample();
        example.createCriteria().andSysBrandIdEqualTo(vo.getSysBrandId()).andStaffCodeEqualTo(vo.getStaffCode());
        List<CouponQuotaSendDetailPO> entityVOList = couponQuotaSendDetailPOMapper.selectByExample(example);
        
        PageInfo<CouponQuotaSendDetailPO> pageInfo = new PageInfo<CouponQuotaSendDetailPO>(entityVOList);

        responseData.setData(pageInfo);
        return responseData;
	}





	@Override
	public ResponseData<PageInfo<CouponEntityVO>> getList(CouponEntityVO entityParam, SysAccountPo accountPo,
			PageFormUtil pageForm) {

        logger.info("enter CouponEntityServiceImpl getList method");
        ResponseData<PageInfo<CouponEntityVO>> responseData = new ResponseData<>();

        //本品牌
        entityParam.setSysBrandId(accountPo.getBrandId());

        CouponStatusEntitySuccessVO successVO = new CouponStatusEntitySuccessVO();
        successVO.setCouponStatusUnused(SystemConstants.COUPON_STATUS_UNUSED);
        successVO.setCouponStatusOverdue(SystemConstants.COUPON_STATUS_OVERDUE);
        successVO.setCouponStatusUsed(SystemConstants.COUPON_STATUS_USED);

//      8.企业微信券-102
        entityParam.setListType("102");
        
//       couponStatus 20-未使用，25-已过期，30-已核销',
        PageHelper.startPage(pageForm.getPageNumber(),pageForm.getPageSize());
        logger.info("企业微信历史查询时间吧2--" + new Date().getTime()+JSONObject.toJSONString(entityParam));
        
        CouponMemberPo couponMember = new CouponMemberPo();
        if(entityParam.getBaseSearchValue()!=null&&!entityParam.getBaseSearchValue().equals("")) {
        	couponMember.setConditions(entityParam.getBaseSearchValue());
            ResponseData<List<MemberInfoModel>> getMemberInfoByCodeList = memberInfoApiService.getMemberInfoByCodeList(couponMember);
            if (getMemberInfoByCodeList.getData() != null) {
            	for(MemberInfoModel memberInfoModel : getMemberInfoByCodeList.getData()) {
            		entityParam.setMemberCode(memberInfoModel.getMemberCode());
            		entityParam.setBaseSearchValue("");
            	}
            }
        }

        //查询券
        entityParam.setFingType("ASC");
        entityParam.setCreateUserName(entityParam.getStaffcode());
        List<CouponEntityVO> entityVOList = couponEntityPOMapper.findCouponEntityByConditions(entityParam,successVO);
        
        //统计会员code
        List<String> memberCodeList = new ArrayList<>();
        for(CouponEntityVO entityVO : entityVOList){
            memberCodeList.add(entityVO.getMemberCode());
        }

        //查询会员接口
       CouponMemberPo couponMemberPo = new CouponMemberPo();
        couponMemberPo.setMemberCodeList(memberCodeList);
        ResponseData<List<MemberInfoModel>> getMemberInfoByCodeList = memberInfoApiService.getMemberInfoByCodeList(couponMemberPo);


        Map<String, MemberInfoModel> map = new HashMap<>();
        if (getMemberInfoByCodeList.getData() != null) {
        	for(MemberInfoModel memberInfoModel : getMemberInfoByCodeList.getData()) {
        		map.put(memberInfoModel.getMemberCode(), memberInfoModel);
        	}
        }

            for(CouponEntityVO couponEntityVO : entityVOList){
            	MemberInfoModel MemberNamePojoNEW 	= map.get(couponEntityVO.getMemberCode());
                if(MemberNamePojoNEW!=null) {
                    couponEntityVO.setCardNo(MemberNamePojoNEW.getCardNo());
                    couponEntityVO.setMemberName(MemberNamePojoNEW.getName());
                 
                    couponEntityVO.setExternalUserId(MemberNamePojoNEW.getExternalUserId());
                    couponEntityVO.setHeadPortraits(MemberNamePojoNEW.getHeadPortraits());
                    
                    couponEntityVO.setMemberComment(MemberNamePojoNEW.getMemberComment());
                    couponEntityVO.setName(MemberNamePojoNEW.getName());
                    couponEntityVO.setPhone(MemberNamePojoNEW.getPhone());
                    
                }

            }
            //查询会员接口
        
        
        for(CouponEntityVO  couponEntityVO:entityVOList) {
        	
        	if(couponEntityVO.getCouponStatus().toString().equals("20")) {
        		try {
        	   Date currentTime = new Date();
        	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        	  String ValidDateEnd = formatter.format(couponEntityVO.getValidDateEnd());
        	  String ValidDate = formatter.format(currentTime);
        	       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        	        Date oDate = sdf.parse(ValidDateEnd);
        	        Date fDate=sdf.parse(ValidDate);
        	        long days=(oDate.getTime()-fDate.getTime())/(1000*3600*24);
        	        couponEntityVO.setDateDue(String.valueOf(days+1)+"天后到期");
				} catch (ParseException e) {
					logger.info("天数出错--");
					e.printStackTrace();
				}
        	}
        	
        }

        PageInfo<CouponEntityVO> pageInfo = new PageInfo<>(entityVOList);

        responseData.setData(pageInfo);
        return responseData;
    }


}
