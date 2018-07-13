package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktActivityUpgradePO;
import com.bizvane.mktcenterservice.models.po.MktActivityUpgradePOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MktActivityUpgradePOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 11:45:27
	 */
	long countByExample(MktActivityUpgradePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 11:45:27
	 */
	int deleteByExample(MktActivityUpgradePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 11:45:27
	 */
	int deleteByPrimaryKey(Long mktActivityUpgradeId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 11:45:27
	 */
	int insert(MktActivityUpgradePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 11:45:27
	 */
	int insertSelective(MktActivityUpgradePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 11:45:27
	 */
	List<MktActivityUpgradePO> selectByExample(MktActivityUpgradePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 11:45:27
	 */
	MktActivityUpgradePO selectByPrimaryKey(Long mktActivityUpgradeId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 11:45:27
	 */
	int updateByExampleSelective(@Param("record") MktActivityUpgradePO record,
			@Param("example") MktActivityUpgradePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 11:45:27
	 */
	int updateByExample(@Param("record") MktActivityUpgradePO record,
			@Param("example") MktActivityUpgradePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 11:45:27
	 */
	int updateByPrimaryKeySelective(MktActivityUpgradePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-13 11:45:27
	 */
	int updateByPrimaryKey(MktActivityUpgradePO record);
}