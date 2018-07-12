package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktActivityOrderPO;
import com.bizvane.mktcenterservice.models.po.MktActivityOrderPOExample;
import com.bizvane.mktcenterservice.models.po.MktActivityOrderPOWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MktActivityOrderPOMapper {
    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    long countByExample(MktActivityOrderPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int deleteByExample(MktActivityOrderPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int deleteByPrimaryKey(Long mktActivityOrderId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int insert(MktActivityOrderPOWithBLOBs record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int insertSelective(MktActivityOrderPOWithBLOBs record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    List<MktActivityOrderPOWithBLOBs> selectByExampleWithBLOBs(MktActivityOrderPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    List<MktActivityOrderPO> selectByExample(MktActivityOrderPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    MktActivityOrderPOWithBLOBs selectByPrimaryKey(Long mktActivityOrderId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int updateByExampleSelective(@Param("record") MktActivityOrderPOWithBLOBs record, @Param("example") MktActivityOrderPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int updateByExampleWithBLOBs(@Param("record") MktActivityOrderPOWithBLOBs record, @Param("example") MktActivityOrderPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int updateByExample(@Param("record") MktActivityOrderPO record, @Param("example") MktActivityOrderPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int updateByPrimaryKeySelective(MktActivityOrderPOWithBLOBs record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int updateByPrimaryKeyWithBLOBs(MktActivityOrderPOWithBLOBs record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int updateByPrimaryKey(MktActivityOrderPO record);
}