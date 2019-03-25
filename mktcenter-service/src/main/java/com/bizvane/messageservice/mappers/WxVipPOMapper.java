package com.bizvane.messageservice.mappers;

import com.bizvane.messagefacade.models.po.WxVipPO;
import com.bizvane.messagefacade.models.po.WxVipPOExample;
import com.bizvane.messagefacade.models.po.WxVipPOWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WxVipPOMapper {
    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    long countByExample(WxVipPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    int deleteByExample(WxVipPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    int insert(WxVipPOWithBLOBs record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    int insertSelective(WxVipPOWithBLOBs record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    List<WxVipPOWithBLOBs> selectByExampleWithBLOBs(WxVipPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    List<WxVipPO> selectByExample(WxVipPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    WxVipPOWithBLOBs selectByPrimaryKey(Long id);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    int updateByExampleSelective(@Param("record") WxVipPOWithBLOBs record, @Param("example") WxVipPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    int updateByExampleWithBLOBs(@Param("record") WxVipPOWithBLOBs record, @Param("example") WxVipPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    int updateByExample(@Param("record") WxVipPO record, @Param("example") WxVipPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    int updateByPrimaryKeySelective(WxVipPOWithBLOBs record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    int updateByPrimaryKeyWithBLOBs(WxVipPOWithBLOBs record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    int updateByPrimaryKey(WxVipPO record);
}