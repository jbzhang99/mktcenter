package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktActivitySmartGroupPO;
import com.bizvane.mktcenterservice.models.po.MktActivitySmartGroupPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MktActivitySmartGroupPOMapper {
    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-02 20:38:44
     */
    long countByExample(MktActivitySmartGroupPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-02 20:38:44
     */
    int deleteByExample(MktActivitySmartGroupPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-02 20:38:44
     */
    int deleteByPrimaryKey(Long mktActivitySmartGroupId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-02 20:38:44
     */
    int insert(MktActivitySmartGroupPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-02 20:38:44
     */
    int insertSelective(MktActivitySmartGroupPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-02 20:38:44
     */
    List<MktActivitySmartGroupPO> selectByExampleWithBLOBs(MktActivitySmartGroupPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-02 20:38:44
     */
    List<MktActivitySmartGroupPO> selectByExample(MktActivitySmartGroupPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-02 20:38:44
     */
    MktActivitySmartGroupPO selectByPrimaryKey(Long mktActivitySmartGroupId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-02 20:38:44
     */
    int updateByExampleSelective(@Param("record") MktActivitySmartGroupPO record, @Param("example") MktActivitySmartGroupPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-02 20:38:44
     */
    int updateByExampleWithBLOBs(@Param("record") MktActivitySmartGroupPO record, @Param("example") MktActivitySmartGroupPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-02 20:38:44
     */
    int updateByExample(@Param("record") MktActivitySmartGroupPO record, @Param("example") MktActivitySmartGroupPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-02 20:38:44
     */
    int updateByPrimaryKeySelective(MktActivitySmartGroupPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-02 20:38:44
     */
    int updateByPrimaryKeyWithBLOBs(MktActivitySmartGroupPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-02 20:38:44
     */
    int updateByPrimaryKey(MktActivitySmartGroupPO record);
}