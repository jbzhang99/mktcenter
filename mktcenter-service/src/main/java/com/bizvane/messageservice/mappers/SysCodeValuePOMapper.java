package com.bizvane.messageservice.mappers;

import com.bizvane.messagefacade.models.po.SysCodeValuePO;
import com.bizvane.messagefacade.models.po.SysCodeValuePOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysCodeValuePOMapper {
    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    long countByExample(SysCodeValuePOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    int deleteByExample(SysCodeValuePOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    int deleteByPrimaryKey(Integer sysCodeValueId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    int insert(SysCodeValuePO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    int insertSelective(SysCodeValuePO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    List<SysCodeValuePO> selectByExample(SysCodeValuePOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    SysCodeValuePO selectByPrimaryKey(Integer sysCodeValueId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    int updateByExampleSelective(@Param("record") SysCodeValuePO record, @Param("example") SysCodeValuePOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    int updateByExample(@Param("record") SysCodeValuePO record, @Param("example") SysCodeValuePOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    int updateByPrimaryKeySelective(SysCodeValuePO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    int updateByPrimaryKey(SysCodeValuePO record);
}