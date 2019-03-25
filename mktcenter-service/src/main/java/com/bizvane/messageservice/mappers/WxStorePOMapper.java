package com.bizvane.messageservice.mappers;

import com.bizvane.messagefacade.models.po.WxStorePO;
import com.bizvane.messagefacade.models.po.WxStorePOExample;
import com.bizvane.messagefacade.models.po.WxStorePOWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WxStorePOMapper {
    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    long countByExample(WxStorePOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    int deleteByExample(WxStorePOExample example);

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
    int insert(WxStorePOWithBLOBs record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    int insertSelective(WxStorePOWithBLOBs record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    List<WxStorePOWithBLOBs> selectByExampleWithBLOBs(WxStorePOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    List<WxStorePO> selectByExample(WxStorePOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    WxStorePOWithBLOBs selectByPrimaryKey(Long id);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    int updateByExampleSelective(@Param("record") WxStorePOWithBLOBs record, @Param("example") WxStorePOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    int updateByExampleWithBLOBs(@Param("record") WxStorePOWithBLOBs record, @Param("example") WxStorePOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    int updateByExample(@Param("record") WxStorePO record, @Param("example") WxStorePOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    int updateByPrimaryKeySelective(WxStorePOWithBLOBs record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    int updateByPrimaryKeyWithBLOBs(WxStorePOWithBLOBs record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-07 17:52:51
     */
    int updateByPrimaryKey(WxStorePO record);
}