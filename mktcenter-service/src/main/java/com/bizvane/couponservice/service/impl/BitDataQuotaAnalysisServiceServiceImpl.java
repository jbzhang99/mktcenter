package com.bizvane.couponservice.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.centerstageservice.models.po.SysAccountPo;
import com.bizvane.couponfacade.models.po.CouponBatchSendDetailPO;
import com.bizvane.couponfacade.models.po.CouponBatchSendDetailPOExample;
import com.bizvane.couponfacade.models.po.CouponDefinitionPO;
import com.bizvane.couponfacade.models.po.CouponManualPO;
import com.bizvane.couponservice.common.constants.SystemConstants;
import com.bizvane.couponservice.common.datavo.BitDataRequestVO;
import com.bizvane.couponservice.common.datavo.BitDataVO;
import com.bizvane.couponservice.common.datavo.BitDataXiaLaiVO;
import com.bizvane.couponservice.mappers.CouponBatchSendDetailPOMapper;
import com.bizvane.couponservice.mappers.CouponDefinitionPOMapper;
import com.bizvane.couponservice.mappers.CouponManualPOMapper;
import com.bizvane.couponservice.service.BitDataAnalysisService;
import com.bizvane.utils.responseinfo.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by yunjie.tian on 2018/7/20.
 */
@Service
public class BitDataQuotaAnalysisServiceServiceImpl implements BitDataAnalysisService{
	
    @Autowired
    private CouponManualPOMapper couponManualPOMapper;
    
    @Autowired
    private  CouponDefinitionPOMapper couponDefinitionPOMapper;
    
    @Autowired
    private   CouponBatchSendDetailPOMapper couponBatchSendDetailPOMapper;

	@Override
	public ResponseData<BitDataRequestVO> getCouponQuotaAnalysisDetail(BitDataVO vo, SysAccountPo accountPo) {
		ResponseData<BitDataRequestVO> bitDataRequestVOResponse= new ResponseData<BitDataRequestVO>();
		BitDataRequestVO bitDataRequestVO=new BitDataRequestVO();
		
		CouponManualPO couponManualPO = couponManualPOMapper.selectByPrimaryKey(vo.getCouponManualId());
		
		bitDataRequestVO.setTaskName(couponManualPO.getTaskName());
		bitDataRequestVO.setCreateDate(couponManualPO.getCreateDate());
		// 核销计算
		if(couponManualPO.getStoreids()!=null) {
			JSONObject  jsonObject= JSONObject.parseObject(couponManualPO.getStoreids());
			bitDataRequestVO.setStoresSum(String.valueOf(jsonObject.size()));
		}else {
			bitDataRequestVO.setStoresSum("0");
		}
		
		 JSONObject  jsonObject =new JSONObject();
		// 发送的优惠券
		List<CouponDefinitionPO> couponDefinitionPOList=new ArrayList<CouponDefinitionPO>();
		for(String couponDefinitionId:couponManualPO.getCouponDefinitionId().split(",")) {
			jsonObject.put(couponDefinitionId, Long.valueOf(couponDefinitionId));
		}
		
		
	  for (Object k : jsonObject.keySet()) {
			CouponDefinitionPO couponDefinitionPO =couponDefinitionPOMapper.selectByPrimaryKey(jsonObject.getLong(k.toString()));
			couponDefinitionPOList.add(couponDefinitionPO);
		}

		
	  // 下拉数据券数
	  CouponBatchSendDetailPOExample example = new CouponBatchSendDetailPOExample();
            example.createCriteria().andCouponManualIdEqualTo(couponManualPO.getCouponManualId().toString());
	  List<CouponBatchSendDetailPO> selectByExamplelist=couponBatchSendDetailPOMapper.selectByExample(example);
				   
		List<BitDataXiaLaiVO> BitDataXiaLaiVOList=new ArrayList<BitDataXiaLaiVO>();
		for(CouponBatchSendDetailPO couponDefinitionName:selectByExamplelist) {
			BitDataXiaLaiVO  bitDataXiaLaiVO =new BitDataXiaLaiVO();
			bitDataXiaLaiVO.setCode(couponDefinitionName.getBatchSendCodeDetail());
			bitDataXiaLaiVO.setName(couponDefinitionName.getCouponName());
			CouponDefinitionPO couponDefinitionPO =couponDefinitionPOMapper.selectByPrimaryKey(Long.valueOf(couponDefinitionName.getCouponDefinitionId()));
			
	        //计算有效期开始到结束区间
	        Calendar calendar = Calendar.getInstance();

	        if (couponDefinitionPO.getValidType().equals(SystemConstants.VALID_TYPE__SOMEDAY)) {
	            calendar.add(Calendar.DATE, couponDefinitionPO.getValidDay());
	            calendar.set(Calendar.HOUR_OF_DAY,23);
	            calendar.set(Calendar.SECOND, 59);
	            calendar.set(Calendar.MINUTE, 59);
	            calendar.set(Calendar.MILLISECOND, 59);

	            bitDataXiaLaiVO.setValidDateStart(couponDefinitionName.getCreateDate());
	            bitDataXiaLaiVO.setValidDateEnd(calendar.getTime());
	        }else{
	        	bitDataXiaLaiVO.setValidDateStart(couponDefinitionPO.getValidDateStart());
	            bitDataXiaLaiVO.setValidDateEnd(couponDefinitionPO.getValidDateEnd());
	        }

			BitDataXiaLaiVOList.add(bitDataXiaLaiVO);
			// 有效时间
			for(CouponDefinitionPO couponDefinitionvo:couponDefinitionPOList) {
				if(couponDefinitionvo.getCouponDefinitionId().equals(couponDefinitionPO.getCouponDefinitionId())) {
					couponDefinitionvo.setValidDateStart(bitDataXiaLaiVO.getValidDateStart());
					couponDefinitionvo.setValidDateEnd(bitDataXiaLaiVO.getValidDateEnd());
				}
			}
		}
		
		bitDataRequestVO.setCouponDefinitionPOList(couponDefinitionPOList);
		bitDataRequestVO.setBitDataXiaLaiVOList(BitDataXiaLaiVOList);
		
		bitDataRequestVOResponse.setData(bitDataRequestVO);
		return bitDataRequestVOResponse;
	}


}
