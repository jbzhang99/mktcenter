package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.FileReportTempPO;
import com.bizvane.mktcenterservice.models.po.FileReportTempPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FileReportTempPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	long countByExample(FileReportTempPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	int deleteByExample(FileReportTempPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	int deleteByPrimaryKey(Long fileReportTempId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	int insert(FileReportTempPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	int insertSelective(FileReportTempPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	List<FileReportTempPO> selectByExample(FileReportTempPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	FileReportTempPO selectByPrimaryKey(Long fileReportTempId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	int updateByExampleSelective(@Param("record") FileReportTempPO record,
			@Param("example") FileReportTempPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	int updateByExample(@Param("record") FileReportTempPO record, @Param("example") FileReportTempPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	int updateByPrimaryKeySelective(FileReportTempPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-19 18:34:41
	 */
	int updateByPrimaryKey(FileReportTempPO record);
}