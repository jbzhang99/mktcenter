package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktActivitySmartPO;
import com.bizvane.mktcenterservice.models.po.MktActivitySmartPOExample;
import com.bizvane.mktcenterservice.models.vo.ActivitySmartVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MktActivitySmartPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	long countByExample(MktActivitySmartPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	int deleteByExample(MktActivitySmartPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	int deleteByPrimaryKey(Long mktActivitySmartId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	int insert(MktActivitySmartPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	int insertSelective(MktActivitySmartPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	List<MktActivitySmartPO> selectByExampleWithBLOBs(MktActivitySmartPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	List<MktActivitySmartPO> selectByExample(MktActivitySmartPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	MktActivitySmartPO selectByPrimaryKey(Long mktActivitySmartId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	int updateByExampleSelective(@Param("record") MktActivitySmartPO record,
			@Param("example") MktActivitySmartPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	int updateByExampleWithBLOBs(@Param("record") MktActivitySmartPO record,
			@Param("example") MktActivitySmartPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	int updateByExample(@Param("record") MktActivitySmartPO record,
			@Param("example") MktActivitySmartPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	int updateByPrimaryKeySelective(MktActivitySmartPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	int updateByPrimaryKeyWithBLOBs(MktActivitySmartPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:03:31
	 */
	int updateByPrimaryKey(MktActivitySmartPO record);

	List<ActivitySmartVO> getActivityList(ActivitySmartVO vo);
}