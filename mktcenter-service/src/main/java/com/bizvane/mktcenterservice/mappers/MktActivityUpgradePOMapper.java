package com.bizvane.mktcenterservice.mappers;

import com.bizvane.mktcenterfacade.models.po.MktActivityUpgradePO;
import com.bizvane.mktcenterfacade.models.po.MktActivityUpgradePOExample;
import java.util.List;

import com.bizvane.mktcenterfacade.models.vo.ActivityVO;
import org.apache.ibatis.annotations.Param;

public interface MktActivityUpgradePOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	long countByExample(MktActivityUpgradePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int deleteByExample(MktActivityUpgradePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int deleteByPrimaryKey(Long mktActivityUpgradeId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int insert(MktActivityUpgradePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int insertSelective(MktActivityUpgradePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	List<MktActivityUpgradePO> selectByExampleWithBLOBs(MktActivityUpgradePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	List<MktActivityUpgradePO> selectByExample(MktActivityUpgradePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	MktActivityUpgradePO selectByPrimaryKey(Long mktActivityUpgradeId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int updateByExampleSelective(@Param("record") MktActivityUpgradePO record,
			@Param("example") MktActivityUpgradePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int updateByExampleWithBLOBs(@Param("record") MktActivityUpgradePO record,
			@Param("example") MktActivityUpgradePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int updateByExample(@Param("record") MktActivityUpgradePO record,
			@Param("example") MktActivityUpgradePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int updateByPrimaryKeySelective(MktActivityUpgradePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int updateByPrimaryKeyWithBLOBs(MktActivityUpgradePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-31 12:40:26
	 */
	int updateByPrimaryKey(MktActivityUpgradePO record);

	/**
	 * 分页查询会员升级活动列表
	 * @param vo
	 * @return
	 */
	List<ActivityVO> getActivityUpgradeList(ActivityVO vo);

}