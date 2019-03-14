package com.bizvane.mktcenterservice.mappers;

import com.bizvane.mktcenterfacade.models.po.MktActivityVipAniversaryPO;
import com.bizvane.mktcenterfacade.models.po.MktActivityVipAniversaryPOExample;
import com.bizvane.mktcenterfacade.models.vo.ActivityVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MktActivityVipAniversaryPOMapper {
    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-06 10:48:57
     */
    long countByExample(MktActivityVipAniversaryPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-06 10:48:57
     */
    int deleteByExample(MktActivityVipAniversaryPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-06 10:48:57
     */
    int deleteByPrimaryKey(Long mktActivityVipAniversaryId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-06 10:48:57
     */
    int insert(MktActivityVipAniversaryPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-06 10:48:57
     */
    int insertSelective(MktActivityVipAniversaryPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-06 10:48:57
     */
    List<MktActivityVipAniversaryPO> selectByExampleWithBLOBs(MktActivityVipAniversaryPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-06 10:48:57
     */
    List<MktActivityVipAniversaryPO> selectByExample(MktActivityVipAniversaryPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-06 10:48:57
     */
    MktActivityVipAniversaryPO selectByPrimaryKey(Long mktActivityVipAniversaryId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-06 10:48:57
     */
    int updateByExampleSelective(@Param("record") MktActivityVipAniversaryPO record, @Param("example") MktActivityVipAniversaryPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-06 10:48:57
     */
    int updateByExampleWithBLOBs(@Param("record") MktActivityVipAniversaryPO record, @Param("example") MktActivityVipAniversaryPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-06 10:48:57
     */
    int updateByExample(@Param("record") MktActivityVipAniversaryPO record, @Param("example") MktActivityVipAniversaryPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-06 10:48:57
     */
    int updateByPrimaryKeySelective(MktActivityVipAniversaryPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-06 10:48:57
     */
    int updateByPrimaryKeyWithBLOBs(MktActivityVipAniversaryPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-06 10:48:57
     */
    int updateByPrimaryKey(MktActivityVipAniversaryPO record);

    List<ActivityVO> getActivityAniversaryList(ActivityVO vo);
}