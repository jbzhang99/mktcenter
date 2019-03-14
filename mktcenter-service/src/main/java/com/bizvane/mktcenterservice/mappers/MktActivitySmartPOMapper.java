package com.bizvane.mktcenterservice.mappers;

import com.bizvane.mktcenterfacade.models.po.MktActivitySmartPO;
import com.bizvane.mktcenterfacade.models.po.MktActivitySmartPOExample;
import com.bizvane.mktcenterfacade.models.vo.ActivitySmartVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MktActivitySmartPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	long countByExample(MktActivitySmartPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int deleteByExample(MktActivitySmartPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int deleteByPrimaryKey(Long mktActivitySmartId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int insert(MktActivitySmartPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int insertSelective(MktActivitySmartPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	List<MktActivitySmartPO> selectByExampleWithBLOBs(MktActivitySmartPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	List<MktActivitySmartPO> selectByExample(MktActivitySmartPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	MktActivitySmartPO selectByPrimaryKey(Long mktActivitySmartId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int updateByExampleSelective(@Param("record") MktActivitySmartPO record,
			@Param("example") MktActivitySmartPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int updateByExampleWithBLOBs(@Param("record") MktActivitySmartPO record,
			@Param("example") MktActivitySmartPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int updateByExample(@Param("record") MktActivitySmartPO record,
			@Param("example") MktActivitySmartPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int updateByPrimaryKeySelective(MktActivitySmartPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int updateByPrimaryKeyWithBLOBs(MktActivitySmartPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int updateByPrimaryKey(MktActivitySmartPO record);

	List<ActivitySmartVO> getActivityList(ActivitySmartVO vo);
}