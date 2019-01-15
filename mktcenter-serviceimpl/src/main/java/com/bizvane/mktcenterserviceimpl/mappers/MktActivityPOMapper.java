package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.bo.ActivityAnalysisCountBO;
import com.bizvane.mktcenterservice.models.bo.ActivityRedPacketBO;
import com.bizvane.mktcenterservice.models.bo.CtivityAnalysisBO;
import com.bizvane.mktcenterservice.models.po.MktActivityPO;
import com.bizvane.mktcenterservice.models.po.MktActivityPOExample;
import com.bizvane.mktcenterservice.models.po.MktActivityPOWithBLOBs;
import com.bizvane.mktcenterservice.models.vo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MktActivityPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	long countByExample(MktActivityPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	int deleteByExample(MktActivityPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	int deleteByPrimaryKey(Long mktActivityId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	int insert(MktActivityPOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	int insertSelective(MktActivityPOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	List<MktActivityPOWithBLOBs> selectByExampleWithBLOBs(MktActivityPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	List<MktActivityPO> selectByExample(MktActivityPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	MktActivityPOWithBLOBs selectByPrimaryKey(Long mktActivityId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	int updateByExampleSelective(@Param("record") MktActivityPOWithBLOBs record,
			@Param("example") MktActivityPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	int updateByExampleWithBLOBs(@Param("record") MktActivityPOWithBLOBs record,
			@Param("example") MktActivityPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	int updateByExample(@Param("record") MktActivityPO record, @Param("example") MktActivityPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	int updateByPrimaryKeySelective(MktActivityPOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	int updateByPrimaryKeyWithBLOBs(MktActivityPOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-12-18 15:22:31
	 */
	int updateByPrimaryKey(MktActivityPO record);

	/**
	 * 更新活动执行状态
	 * @param po
	 * @return
	 */
	int updateActivityStatus(MktActivityPO  po);

	List<ActivityVO> getActivityList(ActivityVO vo);
	//活动效果分析查询
	List<ActivityAnalysisCountBO>  getActivityAnalysisCountpage(ActivityAnalysisCountBO bo);
	//查询活动人数统计和积分数量
	CtivityAnalysisBO getActivityAnalysisTotal(ActivityAnalysisCountBO bo);
	//白名单店铺
	public  String  getActivityWhiteStoreIds(WhiteStoreVO vo);
	public  String  getActivityWhiteStoreIdsOther(WhiteStoreVO vo);
	Integer getPictureMessageCount(@Param("mktActivitySmartGroupId")Long mktActivitySmartGroupId,@Param("mbrGroupDefId")Long mbrGroupDefId,@Param("time")String time);
	//查询抽奖主表
	List<MktActivityPO> selectActivity(MktActivityPrizeRecordVO vo);

	List<MktActivityPOWithBLOBs> selectActivityPriceLists(ActivityPriceParamVO vo);

	ActivityRedPacketBO selectActivityRedPacketDetail(ActivityRedPacketVO vo);
//	List<ActivityRedPacketListBO> selectActivityRedPacketLists(ActivityRedPacketVO vo);
}