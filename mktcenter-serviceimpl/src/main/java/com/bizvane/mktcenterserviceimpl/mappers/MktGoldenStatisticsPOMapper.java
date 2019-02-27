package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.bo.ActivityGoldenStatisticsBo;
import com.bizvane.mktcenterservice.models.po.MktGoldenStatisticsPO;
import com.bizvane.mktcenterservice.models.po.MktGoldenStatisticsPOExample;
import java.util.List;

import com.bizvane.mktcenterservice.models.vo.MktGoldenStatisticsVO;
import org.apache.ibatis.annotations.Param;

public interface MktGoldenStatisticsPOMapper {
    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    long countByExample(MktGoldenStatisticsPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    int deleteByExample(MktGoldenStatisticsPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    int deleteByPrimaryKey(Long mktGoldenStatisticsId);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    int insert(MktGoldenStatisticsPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    int insertSelective(MktGoldenStatisticsPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    List<MktGoldenStatisticsPO> selectByExampleWithBLOBs(MktGoldenStatisticsPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    List<MktGoldenStatisticsPO> selectByExample(MktGoldenStatisticsPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    MktGoldenStatisticsPO selectByPrimaryKey(Long mktGoldenStatisticsId);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    int updateByExampleSelective(@Param("record") MktGoldenStatisticsPO record, @Param("example") MktGoldenStatisticsPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    int updateByExampleWithBLOBs(@Param("record") MktGoldenStatisticsPO record, @Param("example") MktGoldenStatisticsPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    int updateByExample(@Param("record") MktGoldenStatisticsPO record, @Param("example") MktGoldenStatisticsPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    int updateByPrimaryKeySelective(MktGoldenStatisticsPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    int updateByPrimaryKeyWithBLOBs(MktGoldenStatisticsPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2019-02-19 16:54:15
     */
    int updateByPrimaryKey(MktGoldenStatisticsPO record);

    MktGoldenStatisticsPO getTotalGoldenStatistics(Long activityId);

    MktGoldenStatisticsPO getTotalGoldenStatisticsDate(@Param("activityId") Long activityId, @Param("startDates") String startDates, @Param("endDates") String endDates);

    List<MktGoldenStatisticsVO> getTotalGoldenStatisticsDates(@Param("activityId") Long activityId, @Param("startDates") String startDates, @Param("endDates") String endDates);
}