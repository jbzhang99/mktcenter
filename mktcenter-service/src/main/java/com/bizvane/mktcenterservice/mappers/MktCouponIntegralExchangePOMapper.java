package com.bizvane.mktcenterservice.mappers;

import com.bizvane.mktcenterfacade.models.po.MktCouponIntegralExchangePO;
import com.bizvane.mktcenterfacade.models.po.MktCouponIntegralExchangePOExample;
import java.util.List;

import com.bizvane.mktcenterfacade.models.vo.CouponRecordVO;
import com.bizvane.mktcenterfacade.models.vo.MktCouponIntegralExchangeVO;
import org.apache.ibatis.annotations.Param;

public interface MktCouponIntegralExchangePOMapper {
    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    long countByExample(MktCouponIntegralExchangePOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    int deleteByExample(MktCouponIntegralExchangePOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    int deleteByPrimaryKey(Long exchangeId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    int insert(MktCouponIntegralExchangePO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    int insertSelective(MktCouponIntegralExchangePO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    List<MktCouponIntegralExchangePO> selectByExampleWithBLOBs(MktCouponIntegralExchangePOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    List<MktCouponIntegralExchangePO> selectByExample(MktCouponIntegralExchangePOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    MktCouponIntegralExchangePO selectByPrimaryKey(Long exchangeId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    int updateByExampleSelective(@Param("record") MktCouponIntegralExchangePO record, @Param("example") MktCouponIntegralExchangePOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    int updateByExampleWithBLOBs(@Param("record") MktCouponIntegralExchangePO record, @Param("example") MktCouponIntegralExchangePOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    int updateByExample(@Param("record") MktCouponIntegralExchangePO record, @Param("example") MktCouponIntegralExchangePOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    int updateByPrimaryKeySelective(MktCouponIntegralExchangePO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    int updateByPrimaryKeyWithBLOBs(MktCouponIntegralExchangePO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-11-22 16:07:57
     */
    int updateByPrimaryKey(MktCouponIntegralExchangePO record);

    /**
     * 查询列表
     * @param vo
     * @return
     */
    List<MktCouponIntegralExchangeVO> getCouponIntegralExchangeList(MktCouponIntegralExchangeVO vo);

    /**
     * 批量上下架
     * @param vo
     * @return
     */
    int batchUpdateCouponIntegralExchange(MktCouponIntegralExchangeVO vo);

    List<MktCouponIntegralExchangeVO> getExchangeLists(CouponRecordVO vo);
    List<Long> getExchangeIds(CouponRecordVO vo);
}