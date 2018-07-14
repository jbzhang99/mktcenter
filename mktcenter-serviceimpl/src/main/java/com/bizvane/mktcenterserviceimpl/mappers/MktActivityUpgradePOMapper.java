package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktActivityUpgradePO;
import com.bizvane.mktcenterservice.models.po.MktActivityUpgradePOExample;
import java.util.List;

import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import org.apache.ibatis.annotations.Param;

public interface MktActivityUpgradePOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	long countByExample(MktActivityUpgradePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int deleteByExample(MktActivityUpgradePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int deleteByPrimaryKey(Long mktActivityUpgradeId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int insert(MktActivityUpgradePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int insertSelective(MktActivityUpgradePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	List<MktActivityUpgradePO> selectByExample(MktActivityUpgradePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	MktActivityUpgradePO selectByPrimaryKey(Long mktActivityUpgradeId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int updateByExampleSelective(@Param("record") MktActivityUpgradePO record,
			@Param("example") MktActivityUpgradePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int updateByExample(@Param("record") MktActivityUpgradePO record,
			@Param("example") MktActivityUpgradePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int updateByPrimaryKeySelective(MktActivityUpgradePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int updateByPrimaryKey(MktActivityUpgradePO record);

	List<ActivityVO> getActivityList(ActivityVO vo);

}