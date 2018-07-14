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
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	long countByExample(MktActivityOrderPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int deleteByExample(MktActivityOrderPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int deleteByPrimaryKey(Long mktActivityOrderId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int insert(MktActivityOrderPOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int insertSelective(MktActivityOrderPOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	List<MktActivityOrderPOWithBLOBs> selectByExampleWithBLOBs(MktActivityOrderPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	List<MktActivityOrderPO> selectByExample(MktActivityOrderPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	MktActivityOrderPOWithBLOBs selectByPrimaryKey(Long mktActivityOrderId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int updateByExampleSelective(@Param("record") MktActivityOrderPOWithBLOBs record,
			@Param("example") MktActivityOrderPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int updateByExampleWithBLOBs(@Param("record") MktActivityOrderPOWithBLOBs record,
			@Param("example") MktActivityOrderPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int updateByExample(@Param("record") MktActivityOrderPO record,
			@Param("example") MktActivityOrderPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int updateByPrimaryKeySelective(MktActivityOrderPOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int updateByPrimaryKeyWithBLOBs(MktActivityOrderPOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int updateByPrimaryKey(MktActivityOrderPO record);

	List<ActivityVO> getActivityList(ActivityVO vo);
}