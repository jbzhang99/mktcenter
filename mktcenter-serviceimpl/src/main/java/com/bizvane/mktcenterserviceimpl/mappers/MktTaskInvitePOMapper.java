package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktTaskInvitePO;
import com.bizvane.mktcenterservice.models.po.MktTaskInvitePOExample;
import java.util.List;

import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.models.vo.TaskVO;
import org.apache.ibatis.annotations.Param;

public interface MktTaskInvitePOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-25 16:02:16
	 */
	long countByExample(MktTaskInvitePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-25 16:02:16
	 */
	int deleteByExample(MktTaskInvitePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-25 16:02:16
	 */
	int deleteByPrimaryKey(Long mktTaskInviteId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-25 16:02:16
	 */
	int insert(MktTaskInvitePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-25 16:02:16
	 */
	int insertSelective(MktTaskInvitePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-25 16:02:16
	 */
	List<MktTaskInvitePO> selectByExample(MktTaskInvitePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-25 16:02:16
	 */
	MktTaskInvitePO selectByPrimaryKey(Long mktTaskInviteId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-25 16:02:16
	 */
	int updateByExampleSelective(@Param("record") MktTaskInvitePO record,
			@Param("example") MktTaskInvitePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-25 16:02:16
	 */
	int updateByExample(@Param("record") MktTaskInvitePO record, @Param("example") MktTaskInvitePOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-25 16:02:16
	 */
	int updateByPrimaryKeySelective(MktTaskInvitePO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-07-25 16:02:16
	 */
	int updateByPrimaryKey(MktTaskInvitePO record);

	List<TaskVO> getTaskList(TaskVO vo);
}