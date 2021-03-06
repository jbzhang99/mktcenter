package com.bizvane.mktcenterservice.mappers;

import com.bizvane.mktcenterfacade.models.bo.ActivityAnalysisCountBO;
import com.bizvane.mktcenterfacade.models.bo.ActivityRedPacketBO;
import com.bizvane.mktcenterfacade.models.bo.CtivityAnalysisBO;
import com.bizvane.mktcenterfacade.models.po.MktActivityPO;
import com.bizvane.mktcenterfacade.models.po.MktActivityPOExample;
import com.bizvane.mktcenterfacade.models.po.MktActivityPOWithBLOBs;
import com.bizvane.mktcenterfacade.models.responsevo.StoreActivityResponseVO;
import com.bizvane.mktcenterfacade.models.vo.*;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MktActivityPOMapper {

	/**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  long countByExample(MktActivityPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  int deleteByExample(MktActivityPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  int deleteByPrimaryKey(Long mktActivityId);

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  int insert(MktActivityPOWithBLOBs record);

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  int insertSelective(MktActivityPOWithBLOBs record);

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  List<MktActivityPOWithBLOBs> selectByExampleWithBLOBs(MktActivityPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  List<MktActivityPO> selectByExample(MktActivityPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  MktActivityPOWithBLOBs selectByPrimaryKey(Long mktActivityId);

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  int updateByExampleSelective(@Param("record") MktActivityPOWithBLOBs record,
      @Param("example") MktActivityPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  int updateByExampleWithBLOBs(@Param("record") MktActivityPOWithBLOBs record,
      @Param("example") MktActivityPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  int updateByExample(@Param("record") MktActivityPO record, @Param("example") MktActivityPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  int updateByPrimaryKeySelective(MktActivityPOWithBLOBs record);

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
   */
  int updateByPrimaryKeyWithBLOBs(MktActivityPOWithBLOBs record);

  /**
   * 只读. 
   * @mbg.generated  2019-05-24 15:35:50
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

	List<StoreActivityResponseVO> getMyFinishedStoreActivity(StoreActivityVO storeActivityVO);
}