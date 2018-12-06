package com.bizvane.mktcenterserviceimpl.mappers;

import com.bizvane.mktcenterservice.models.bo.ActivityAnalysisCountBO;
import com.bizvane.mktcenterservice.models.bo.CtivityAnalysisBO;
import com.bizvane.mktcenterservice.models.po.MktActivityPO;
import com.bizvane.mktcenterservice.models.po.MktActivityPOExample;
import com.bizvane.mktcenterservice.models.po.MktActivityPOWithBLOBs;
import java.util.List;

import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.models.vo.WhiteStoreVO;
import org.apache.ibatis.annotations.Param;
import sun.security.x509.AVA;

public interface MktActivityPOMapper {

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-20 09:44:33
	 */
	long countByExample(MktActivityPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-20 09:44:33
	 */
	int deleteByExample(MktActivityPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-20 09:44:33
	 */
	int deleteByPrimaryKey(Long mktActivityId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-20 09:44:33
	 */
	int insert(MktActivityPOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-20 09:44:33
	 */
	int insertSelective(MktActivityPOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-20 09:44:33
	 */
	List<MktActivityPOWithBLOBs> selectByExampleWithBLOBs(MktActivityPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-20 09:44:33
	 */
	List<MktActivityPO> selectByExample(MktActivityPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-20 09:44:33
	 */
	MktActivityPOWithBLOBs selectByPrimaryKey(Long mktActivityId);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-20 09:44:33
	 */
	int updateByExampleSelective(@Param("record") MktActivityPOWithBLOBs record,
			@Param("example") MktActivityPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-20 09:44:33
	 */
	int updateByExampleWithBLOBs(@Param("record") MktActivityPOWithBLOBs record,
			@Param("example") MktActivityPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-20 09:44:33
	 */
	int updateByExample(@Param("record") MktActivityPO record, @Param("example") MktActivityPOExample example);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-20 09:44:33
	 */
	int updateByPrimaryKeySelective(MktActivityPOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-20 09:44:33
	 */
	int updateByPrimaryKeyWithBLOBs(MktActivityPOWithBLOBs record);

	/**
	 * 只读. 
	 * @mbg.generated  2018-09-20 09:44:33
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

	Integer getPictureMessageCount(@Param("activitySmartGroupId")Long activitySmartGroupId,@Param("mbrGroupDefId")Long mbrGroupDefId,@Param("time")String time);
}