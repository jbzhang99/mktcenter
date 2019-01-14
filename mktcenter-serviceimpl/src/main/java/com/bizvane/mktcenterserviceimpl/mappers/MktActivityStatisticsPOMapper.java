package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.bo.ActivityStatisticsBO;
import com.bizvane.mktcenterservice.models.po.MktActivityStatisticsPO;
import com.bizvane.mktcenterservice.models.po.MktActivityStatisticsPOExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface MktActivityStatisticsPOMapper {
    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    long countByExample(MktActivityStatisticsPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    int deleteByExample(MktActivityStatisticsPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    int deleteByPrimaryKey(Long mktActivityStatisticsId);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    int insert(MktActivityStatisticsPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    int insertSelective(MktActivityStatisticsPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    List<MktActivityStatisticsPO> selectByExampleWithBLOBs(MktActivityStatisticsPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    List<MktActivityStatisticsPO> selectByExample(MktActivityStatisticsPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    MktActivityStatisticsPO selectByPrimaryKey(Long mktActivityStatisticsId);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    int updateByExampleSelective(@Param("record") MktActivityStatisticsPO record, @Param("example") MktActivityStatisticsPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    int updateByExampleWithBLOBs(@Param("record") MktActivityStatisticsPO record, @Param("example") MktActivityStatisticsPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    int updateByExample(@Param("record") MktActivityStatisticsPO record, @Param("example") MktActivityStatisticsPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    int updateByPrimaryKeySelective(MktActivityStatisticsPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    int updateByPrimaryKeyWithBLOBs(MktActivityStatisticsPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-01-11 11:03:19
     */
    int updateByPrimaryKey(MktActivityStatisticsPO record);

    /**
     * 得到所有日期
     * @return
     */
    List<String> getAllDate();


    ActivityStatisticsBO getBo(Map map);
}