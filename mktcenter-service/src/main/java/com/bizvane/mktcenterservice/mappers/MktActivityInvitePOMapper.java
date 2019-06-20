package com.bizvane.mktcenterservice.mappers;

import com.bizvane.mktcenterfacade.models.po.MktActivityInvitePO;
import com.bizvane.mktcenterfacade.models.po.MktActivityInvitePOExample;
import java.util.List;

import com.bizvane.mktcenterfacade.models.vo.ActivityInviteVO;
import com.bizvane.mktcenterfacade.models.vo.ActivityVO;
import org.apache.ibatis.annotations.Param;

public interface MktActivityInvitePOMapper {
    /**
     * 只读. 
     *
     * @mbg.generated
     */
    long countByExample(MktActivityInvitePOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated
     */
    int deleteByExample(MktActivityInvitePOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long mktActivityInviteId);

    /**
     * 只读. 
     *
     * @mbg.generated
     */
    int insert(MktActivityInvitePO record);

    /**
     * 只读. 
     *
     * @mbg.generated
     */
    int insertSelective(MktActivityInvitePO record);

    /**
     * 只读. 
     *
     * @mbg.generated
     */
    List<MktActivityInvitePO> selectByExample(MktActivityInvitePOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated
     */
    MktActivityInvitePO selectByPrimaryKey(Long mktActivityInviteId);

    /**
     * 只读. 
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") MktActivityInvitePO record, @Param("example") MktActivityInvitePOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") MktActivityInvitePO record, @Param("example") MktActivityInvitePOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(MktActivityInvitePO record);

    /**
     * 只读. 
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(MktActivityInvitePO record);

    List<ActivityVO> getActivityList(ActivityVO vo);

    List<ActivityInviteVO> getExecutingActivityList(Long sysCompanyId);
}