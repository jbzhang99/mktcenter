package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktActivityRegisterPO;
import com.bizvane.mktcenterservice.models.po.MktActivityRegisterPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MktActivityRegisterPOMapper {
    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    long countByExample(MktActivityRegisterPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int deleteByExample(MktActivityRegisterPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int deleteByPrimaryKey(Long mktActivityResigterId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int insert(MktActivityRegisterPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int insertSelective(MktActivityRegisterPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    List<MktActivityRegisterPO> selectByExample(MktActivityRegisterPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    MktActivityRegisterPO selectByPrimaryKey(Long mktActivityResigterId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int updateByExampleSelective(@Param("record") MktActivityRegisterPO record, @Param("example") MktActivityRegisterPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int updateByExample(@Param("record") MktActivityRegisterPO record, @Param("example") MktActivityRegisterPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int updateByPrimaryKeySelective(MktActivityRegisterPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int updateByPrimaryKey(MktActivityRegisterPO record);
}