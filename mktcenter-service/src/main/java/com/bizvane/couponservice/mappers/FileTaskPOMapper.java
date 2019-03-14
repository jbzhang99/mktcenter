package com.bizvane.couponservice.mappers;

import com.bizvane.couponfacade.models.po.FileTaskPO;
import com.bizvane.couponfacade.models.po.FileTaskPOExample;
import com.bizvane.couponfacade.models.vo.FileTaskVO;
import com.bizvane.utils.tenant.QuarantineAnnotation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@QuarantineAnnotation
public interface FileTaskPOMapper {
    /**
     * 只读.
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    int countByExample(FileTaskPOExample example);

    /**
     * 只读.
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    int deleteByExample(FileTaskPOExample example);

    /**
     * 只读.
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    int deleteByPrimaryKey(Long fileTaskId);

    /**
     * 只读.
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    int insert(FileTaskPO record);

    /**
     * 只读.
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    int insertSelective(FileTaskPO record);

    /**
     * 只读.
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    List<FileTaskPO> selectByExample(FileTaskPOExample example);

    /**
     * 只读.
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    FileTaskPO selectByPrimaryKey(Long fileTaskId);

    /**
     * 只读.
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    int updateByExampleSelective(@Param("record") FileTaskPO record, @Param("example") FileTaskPOExample example);

    /**
     * 只读.
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    int updateByExample(@Param("record") FileTaskPO record, @Param("example") FileTaskPOExample example);

    /**
     * 只读.
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    int updateByPrimaryKeySelective(FileTaskPO record);

    /**
     * 只读.
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    int updateByPrimaryKey(FileTaskPO record);


    //非系统sql

    /**
     *
     * @param fileTaskPO
     * @param limit
     * @param to
     * @return
     */
    List<FileTaskPO> fileTaskPoList(FileTaskPO fileTaskPO, Long limit, Long to);


    /**
     *
     * @param vo
     * @return
     */
    List<FileTaskPO> getFileTaskList(FileTaskVO vo);

    FileTaskPO selectByTaskId(Long taskid);
}