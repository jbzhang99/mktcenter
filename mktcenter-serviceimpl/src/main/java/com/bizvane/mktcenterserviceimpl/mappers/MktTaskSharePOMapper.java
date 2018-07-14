package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktTaskSharePO;
import com.bizvane.mktcenterservice.models.po.MktTaskSharePOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MktTaskSharePOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	long countByExample(MktTaskSharePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int deleteByExample(MktTaskSharePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int deleteByPrimaryKey(Long mktTaskProfileId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int insert(MktTaskSharePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int insertSelective(MktTaskSharePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	List<MktTaskSharePO> selectByExampleWithBLOBs(MktTaskSharePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	List<MktTaskSharePO> selectByExample(MktTaskSharePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	MktTaskSharePO selectByPrimaryKey(Long mktTaskProfileId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int updateByExampleSelective(@Param("record") MktTaskSharePO record,
			@Param("example") MktTaskSharePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int updateByExampleWithBLOBs(@Param("record") MktTaskSharePO record,
			@Param("example") MktTaskSharePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int updateByExample(@Param("record") MktTaskSharePO record, @Param("example") MktTaskSharePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int updateByPrimaryKeySelective(MktTaskSharePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int updateByPrimaryKeyWithBLOBs(MktTaskSharePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-14 13:26:02
	 */
	int updateByPrimaryKey(MktTaskSharePO record);
}