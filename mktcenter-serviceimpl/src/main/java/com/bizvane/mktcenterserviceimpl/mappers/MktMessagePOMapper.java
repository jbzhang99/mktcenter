package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktMessagePO;
import com.bizvane.mktcenterservice.models.po.MktMessagePOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MktMessagePOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-16 14:33:24
	 */
	long countByExample(MktMessagePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-16 14:33:24
	 */
	int deleteByExample(MktMessagePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-16 14:33:24
	 */
	int deleteByPrimaryKey(Long mktMsgId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-16 14:33:24
	 */
	int insert(MktMessagePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-16 14:33:24
	 */
	int insertSelective(MktMessagePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-16 14:33:24
	 */
	List<MktMessagePO> selectByExampleWithBLOBs(MktMessagePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-16 14:33:24
	 */
	List<MktMessagePO> selectByExample(MktMessagePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-16 14:33:24
	 */
	MktMessagePO selectByPrimaryKey(Long mktMsgId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-16 14:33:24
	 */
	int updateByExampleSelective(@Param("record") MktMessagePO record, @Param("example") MktMessagePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-16 14:33:24
	 */
	int updateByExampleWithBLOBs(@Param("record") MktMessagePO record, @Param("example") MktMessagePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-16 14:33:24
	 */
	int updateByExample(@Param("record") MktMessagePO record, @Param("example") MktMessagePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-16 14:33:24
	 */
	int updateByPrimaryKeySelective(MktMessagePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-16 14:33:24
	 */
	int updateByPrimaryKeyWithBLOBs(MktMessagePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-16 14:33:24
	 */
	int updateByPrimaryKey(MktMessagePO record);
}