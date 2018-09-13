package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.bo.TaskDetailBO;
import com.bizvane.mktcenterservice.models.po.MktTaskOrderPO;
import com.bizvane.mktcenterservice.models.po.MktTaskOrderPOExample;
import java.util.List;
import com.bizvane.mktcenterservice.models.vo.TaskVO;
import org.apache.ibatis.annotations.Param;

public interface MktTaskOrderPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	long countByExample(MktTaskOrderPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	int deleteByExample(MktTaskOrderPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	int deleteByPrimaryKey(Long mktTaskOrderId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	int insert(MktTaskOrderPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	int insertSelective(MktTaskOrderPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	List<MktTaskOrderPO> selectByExampleWithBLOBs(MktTaskOrderPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	List<MktTaskOrderPO> selectByExample(MktTaskOrderPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	MktTaskOrderPO selectByPrimaryKey(Long mktTaskOrderId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	int updateByExampleSelective(@Param("record") MktTaskOrderPO record,
			@Param("example") MktTaskOrderPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	int updateByExampleWithBLOBs(@Param("record") MktTaskOrderPO record,
			@Param("example") MktTaskOrderPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	int updateByExample(@Param("record") MktTaskOrderPO record, @Param("example") MktTaskOrderPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	int updateByPrimaryKeySelective(MktTaskOrderPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	int updateByPrimaryKeyWithBLOBs(MktTaskOrderPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	int updateByPrimaryKey(MktTaskOrderPO record);

	List<TaskVO> getTaskList(TaskVO vo);

	/**
	 * 查询次数任务详情
	 */
	public  List<TaskDetailBO> getOrderTaskDetails(@Param("mktTaskId") Long mktTaskId);
}