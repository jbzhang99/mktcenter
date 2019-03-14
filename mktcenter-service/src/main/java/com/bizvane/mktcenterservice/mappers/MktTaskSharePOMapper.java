package com.bizvane.mktcenterservice.mappers;

import com.bizvane.mktcenterfacade.models.po.MktTaskSharePO;
import com.bizvane.mktcenterfacade.models.po.MktTaskSharePOExample;
import java.util.List;

import com.bizvane.mktcenterfacade.models.vo.TaskVO;
import org.apache.ibatis.annotations.Param;
import com.bizvane.mktcenterfacade.models.po.MktTaskSharePOWithBLOBs;

public interface MktTaskSharePOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	long countByExample(MktTaskSharePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	int deleteByExample(MktTaskSharePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	int deleteByPrimaryKey(Long mktTaskShareId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	int insert(MktTaskSharePOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	int insertSelective(MktTaskSharePOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	List<MktTaskSharePOWithBLOBs> selectByExampleWithBLOBs(MktTaskSharePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	List<MktTaskSharePO> selectByExample(MktTaskSharePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	MktTaskSharePOWithBLOBs selectByPrimaryKey(Long mktTaskShareId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	int updateByExampleSelective(@Param("record") MktTaskSharePOWithBLOBs record,
			@Param("example") MktTaskSharePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	int updateByExampleWithBLOBs(@Param("record") MktTaskSharePOWithBLOBs record,
			@Param("example") MktTaskSharePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	int updateByExample(@Param("record") MktTaskSharePO record, @Param("example") MktTaskSharePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	int updateByPrimaryKeySelective(MktTaskSharePOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	int updateByPrimaryKeyWithBLOBs(MktTaskSharePOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	int updateByPrimaryKey(MktTaskSharePO record);

	List<TaskVO> getTaskList(TaskVO vo);
}