package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktMessagePO;
import com.bizvane.mktcenterservice.models.po.MktMessagePOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MktMessagePOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 19:30:17
	 */
	long countByExample(MktMessagePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 19:30:17
	 */
	int deleteByExample(MktMessagePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 19:30:17
	 */
	int deleteByPrimaryKey(Long mktMsgId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 19:30:17
	 */
	int insert(MktMessagePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 19:30:17
	 */
	int insertSelective(MktMessagePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 19:30:17
	 */
	List<MktMessagePO> selectByExampleWithBLOBs(MktMessagePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 19:30:17
	 */
	List<MktMessagePO> selectByExample(MktMessagePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 19:30:17
	 */
	MktMessagePO selectByPrimaryKey(Long mktMsgId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 19:30:17
	 */
	int updateByExampleSelective(@Param("record") MktMessagePO record, @Param("example") MktMessagePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 19:30:17
	 */
	int updateByExampleWithBLOBs(@Param("record") MktMessagePO record, @Param("example") MktMessagePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 19:30:17
	 */
	int updateByExample(@Param("record") MktMessagePO record, @Param("example") MktMessagePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 19:30:17
	 */
	int updateByPrimaryKeySelective(MktMessagePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 19:30:17
	 */
	int updateByPrimaryKeyWithBLOBs(MktMessagePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-27 19:30:17
	 */
	int updateByPrimaryKey(MktMessagePO record);
}