package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.po.MktTaskMsgPO;
import com.bizvane.mktcenterservice.models.po.MktTaskMsgPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MktTaskMsgPOMapper {
    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    long countByExample(MktTaskMsgPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int deleteByExample(MktTaskMsgPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int deleteByPrimaryKey(Long mktTaskMsgId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int insert(MktTaskMsgPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int insertSelective(MktTaskMsgPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    List<MktTaskMsgPO> selectByExampleWithBLOBs(MktTaskMsgPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    List<MktTaskMsgPO> selectByExample(MktTaskMsgPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    MktTaskMsgPO selectByPrimaryKey(Long mktTaskMsgId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int updateByExampleSelective(@Param("record") MktTaskMsgPO record, @Param("example") MktTaskMsgPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int updateByExampleWithBLOBs(@Param("record") MktTaskMsgPO record, @Param("example") MktTaskMsgPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int updateByExample(@Param("record") MktTaskMsgPO record, @Param("example") MktTaskMsgPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int updateByPrimaryKeySelective(MktTaskMsgPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int updateByPrimaryKeyWithBLOBs(MktTaskMsgPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-12 11:48:54
     */
    int updateByPrimaryKey(MktTaskMsgPO record);
}