package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktActivitySmartPO;
import com.bizvane.mktcenterservice.models.po.MktActivitySmartPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MktActivitySmartPOMapper {
    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    long countByExample(MktActivitySmartPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int deleteByExample(MktActivitySmartPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int deleteByPrimaryKey(Long mktActivityBirthdayId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int insert(MktActivitySmartPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int insertSelective(MktActivitySmartPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    List<MktActivitySmartPO> selectByExampleWithBLOBs(MktActivitySmartPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    List<MktActivitySmartPO> selectByExample(MktActivitySmartPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    MktActivitySmartPO selectByPrimaryKey(Long mktActivityBirthdayId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int updateByExampleSelective(@Param("record") MktActivitySmartPO record, @Param("example") MktActivitySmartPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int updateByExampleWithBLOBs(@Param("record") MktActivitySmartPO record, @Param("example") MktActivitySmartPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int updateByExample(@Param("record") MktActivitySmartPO record, @Param("example") MktActivitySmartPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int updateByPrimaryKeySelective(MktActivitySmartPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int updateByPrimaryKeyWithBLOBs(MktActivitySmartPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int updateByPrimaryKey(MktActivitySmartPO record);
}