package com.bizvane.couponservice.mappers;

import com.bizvane.couponfacade.models.po.CouponManualPO;
import com.bizvane.couponfacade.models.po.CouponManualPOExample;
import com.bizvane.couponfacade.models.vo.CouponManualVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CouponManualPOMapper {
    
    
    
    
//非系统生成sql
    
    /**
	 * 只读. 
	 * @mbg.generated  2018-12-20 14:02:30
	 */
	long countByExample(CouponManualPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-20 14:02:30
	 */
	int deleteByExample(CouponManualPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-20 14:02:30
	 */
	int deleteByPrimaryKey(Long couponManualId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-20 14:02:30
	 */
	int insert(CouponManualPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-20 14:02:30
	 */
	int insertSelective(CouponManualPO record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-20 14:02:30
	 */
	List<CouponManualPO> selectByExample(CouponManualPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-20 14:02:30
	 */
	CouponManualPO selectByPrimaryKey(Long couponManualId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-20 14:02:30
	 */
	int updateByExampleSelective(@Param("record") CouponManualPO record,
                                 @Param("example") CouponManualPOExample example);

	/**
	 * 只读.
	 * @mbg.generated  2018-12-20 14:02:30
	 */
	int updateByExample(@Param("record") CouponManualPO record, @Param("example") CouponManualPOExample example);

	/**
	 * 只读.
	 * @mbg.generated  2018-12-20 14:02:30
	 */
	int updateByPrimaryKeySelective(CouponManualPO record);

	/**
	 * 只读.
	 * @mbg.generated  2018-12-20 14:02:30
	 */
	int updateByPrimaryKey(CouponManualPO record);

	/**
     * 通过条件查询手动发券列表
     * @param vo
     * @return
     */
    List<CouponManualVO> findCouponManualListByConditions(@Param("vo") CouponManualVO vo, @Param("sysBrandId") Long sysBrandId);

    /**
     * 发券任务效果分析合计
     * @param vo
     * @return
     */
    CouponManualVO findTotal(@Param("vo") CouponManualVO vo, @Param("sysBrandId") Long sysBrandId);

    /**
     * 根据发券时间查询发券结果
     * @param vo
     * @return
     */
    List<CouponManualVO> findResult(@Param("vo") CouponManualVO vo);

    /**
     * 更新发券成功数量
     * @param successCount
     */
    void updateCouponManualSuccessCount(@Param("successCount") int successCount, @Param("couponManualId") Long couponManualId);

    /**
     * 更新发券失败数量
     * @param failCount
     */
    void updateCouponManualFailCount(@Param("failCount") int failCount, @Param("syncFailCount") int syncFailCount, @Param("couponManualId") Long couponManualId);

    /**
     * 更新手动发券数量
     * @param couponManualId
     * @param successCount
     * @param failCount
     * @param syncFailCount
     */
    void updateCouponManualCount(@Param("couponManualId") Long couponManualId, @Param("successCount") int successCount,
                                 @Param("failCount") int failCount, @Param("syncFailCount") int syncFailCount);





	int updateMemberCount(@Param("memberCount") Integer memberCount, @Param("couponManualId") Long couponManualId);





}