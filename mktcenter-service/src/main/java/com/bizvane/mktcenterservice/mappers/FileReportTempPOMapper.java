package com.bizvane.mktcenterservice.mappers;

import com.bizvane.mktcenterfacade.models.po.FileReportTempPO;
import com.bizvane.mktcenterfacade.models.po.FileReportTempPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FileReportTempPOMapper {

	/**
	 *
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	long countByExample(FileReportTempPOExample example);

	/**
	 *
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	int deleteByExample(FileReportTempPOExample example);

	/**
	 *
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	int deleteByPrimaryKey(Long fileReportTempId);

	/**
	 *
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	int insert(FileReportTempPO record);

	/**
	 *
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	int insertSelective(FileReportTempPO record);

	/**
	 *
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	List<FileReportTempPO> selectByExample(FileReportTempPOExample example);

	/**
	 *
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	FileReportTempPO selectByPrimaryKey(Long fileReportTempId);

	/**
	 *
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	int updateByExampleSelective(@Param("record") FileReportTempPO record,
			@Param("example") FileReportTempPOExample example);

	/**
	 *
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	int updateByExample(@Param("record") FileReportTempPO record, @Param("example") FileReportTempPOExample example);

	/**
	 *
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	int updateByPrimaryKeySelective(FileReportTempPO record);

	/**
	 *
	 * @mbg.generated  2018-09-26 11:14:00
	 */
	int updateByPrimaryKey(FileReportTempPO record);
}