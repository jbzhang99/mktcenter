package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktActivityPO;
import com.bizvane.mktcenterservice.models.po.MktActivityPOExample;
import com.bizvane.mktcenterservice.models.po.MktActivityPOWithBLOBs;
import java.util.List;

import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import org.apache.ibatis.annotations.Param;
import sun.security.x509.AVA;

public interface MktActivityPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:38:44
	 */
	long countByExample(MktActivityPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:38:44
	 */
	int deleteByExample(MktActivityPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:38:44
	 */
	int deleteByPrimaryKey(Long mktActivityId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:38:44
	 */
	int insert(MktActivityPOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:38:44
	 */
	int insertSelective(MktActivityPOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:38:44
	 */
	List<MktActivityPOWithBLOBs> selectByExampleWithBLOBs(MktActivityPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:38:44
	 */
	List<MktActivityPO> selectByExample(MktActivityPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:38:44
	 */
	MktActivityPOWithBLOBs selectByPrimaryKey(Long mktActivityId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:38:44
	 */
	int updateByExampleSelective(@Param("record") MktActivityPOWithBLOBs record,
			@Param("example") MktActivityPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:38:44
	 */
	int updateByExampleWithBLOBs(@Param("record") MktActivityPOWithBLOBs record,
			@Param("example") MktActivityPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:38:44
	 */
	int updateByExample(@Param("record") MktActivityPO record, @Param("example") MktActivityPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:38:44
	 */
	int updateByPrimaryKeySelective(MktActivityPOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:38:44
	 */
	int updateByPrimaryKeyWithBLOBs(MktActivityPOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-08-02 20:38:44
	 */
	int updateByPrimaryKey(MktActivityPO record);

	/**
	 * 更新活动执行状态
	 * @param po
	 * @return
	 */
	int updateActivityStatus(MktActivityPO  po);

	ActivityVO selectActivity(ActivityVO vo);
}