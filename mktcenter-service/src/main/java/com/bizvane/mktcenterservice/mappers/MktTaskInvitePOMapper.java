package com.bizvane.mktcenterservice.mappers;

import com.bizvane.mktcenterfacade.models.po.MktTaskInvitePO;
import com.bizvane.mktcenterfacade.models.po.MktTaskInvitePOExample;
import java.util.List;

import com.bizvane.mktcenterfacade.models.vo.TaskVO;
import org.apache.ibatis.annotations.Param;

public interface MktTaskInvitePOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	long countByExample(MktTaskInvitePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	int deleteByExample(MktTaskInvitePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	int deleteByPrimaryKey(Long mktTaskInviteId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	int insert(MktTaskInvitePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	int insertSelective(MktTaskInvitePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	List<MktTaskInvitePO> selectByExampleWithBLOBs(MktTaskInvitePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	List<MktTaskInvitePO> selectByExample(MktTaskInvitePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	MktTaskInvitePO selectByPrimaryKey(Long mktTaskInviteId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	int updateByExampleSelective(@Param("record") MktTaskInvitePO record,
			@Param("example") MktTaskInvitePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	int updateByExampleWithBLOBs(@Param("record") MktTaskInvitePO record,
			@Param("example") MktTaskInvitePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	int updateByExample(@Param("record") MktTaskInvitePO record, @Param("example") MktTaskInvitePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	int updateByPrimaryKeySelective(MktTaskInvitePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	int updateByPrimaryKeyWithBLOBs(MktTaskInvitePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-12 11:00:25
	 */
	int updateByPrimaryKey(MktTaskInvitePO record);

	List<TaskVO> getTaskList(TaskVO vo);
}