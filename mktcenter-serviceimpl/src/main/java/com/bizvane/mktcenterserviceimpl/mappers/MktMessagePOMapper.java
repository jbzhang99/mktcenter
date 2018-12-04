package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktMessagePO;
import com.bizvane.mktcenterservice.models.po.MktMessagePOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MktMessagePOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-04 15:51:25
	 */
	long countByExample(MktMessagePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-04 15:51:25
	 */
	int deleteByExample(MktMessagePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-04 15:51:25
	 */
	int deleteByPrimaryKey(Long mktMsgId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-04 15:51:25
	 */
	int insert(MktMessagePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-04 15:51:25
	 */
	int insertSelective(MktMessagePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-04 15:51:25
	 */
	List<MktMessagePO> selectByExampleWithBLOBs(MktMessagePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-04 15:51:25
	 */
	List<MktMessagePO> selectByExample(MktMessagePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-04 15:51:25
	 */
	MktMessagePO selectByPrimaryKey(Long mktMsgId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-04 15:51:25
	 */
	int updateByExampleSelective(@Param("record") MktMessagePO record, @Param("example") MktMessagePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-04 15:51:25
	 */
	int updateByExampleWithBLOBs(@Param("record") MktMessagePO record, @Param("example") MktMessagePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-04 15:51:25
	 */
	int updateByExample(@Param("record") MktMessagePO record, @Param("example") MktMessagePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-04 15:51:25
	 */
	int updateByPrimaryKeySelective(MktMessagePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-04 15:51:25
	 */
	int updateByPrimaryKeyWithBLOBs(MktMessagePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-04 15:51:25
	 */
	int updateByPrimaryKey(MktMessagePO record);
}