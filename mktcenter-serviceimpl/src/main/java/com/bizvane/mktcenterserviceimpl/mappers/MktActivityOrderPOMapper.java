package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktActivityOrderPO;
import com.bizvane.mktcenterservice.models.po.MktActivityOrderPOExample;
import com.bizvane.mktcenterservice.models.po.MktActivityOrderPOWithBLOBs;
import java.util.List;

import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import org.apache.ibatis.annotations.Param;

public interface MktActivityOrderPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-16 16:31:22
	 */
	long countByExample(MktActivityOrderPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-16 16:31:22
	 */
	int deleteByExample(MktActivityOrderPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-16 16:31:22
	 */
	int deleteByPrimaryKey(Long mktActivityOrderId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-16 16:31:22
	 */
	int insert(MktActivityOrderPOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-16 16:31:22
	 */
	int insertSelective(MktActivityOrderPOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-16 16:31:22
	 */
	List<MktActivityOrderPOWithBLOBs> selectByExampleWithBLOBs(MktActivityOrderPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-16 16:31:22
	 */
	List<MktActivityOrderPO> selectByExample(MktActivityOrderPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-16 16:31:22
	 */
	MktActivityOrderPOWithBLOBs selectByPrimaryKey(Long mktActivityOrderId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-16 16:31:22
	 */
	int updateByExampleSelective(@Param("record") MktActivityOrderPOWithBLOBs record,
			@Param("example") MktActivityOrderPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-16 16:31:22
	 */
	int updateByExampleWithBLOBs(@Param("record") MktActivityOrderPOWithBLOBs record,
			@Param("example") MktActivityOrderPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-16 16:31:22
	 */
	int updateByExample(@Param("record") MktActivityOrderPO record,
			@Param("example") MktActivityOrderPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-16 16:31:22
	 */
	int updateByPrimaryKeySelective(MktActivityOrderPOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-16 16:31:22
	 */
	int updateByPrimaryKeyWithBLOBs(MktActivityOrderPOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-16 16:31:22
	 */
	int updateByPrimaryKey(MktActivityOrderPO record);

	List<ActivityVO> getActivityOrderList(ActivityVO vo);
}