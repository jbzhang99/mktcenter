package com.bizvane.couponservice.mappers;

import com.bizvane.couponfacade.models.po.SysCodeValuePO;
import com.bizvane.couponfacade.models.po.SysCodeValuePOExample;
import com.bizvane.utils.tenant.QuarantineAnnotation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@QuarantineAnnotation
public interface CouponSysCodeValuePOMapper {
    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:28:06
     */
    long countByExample(SysCodeValuePOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:28:06
     */
    int deleteByExample(SysCodeValuePOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:28:06
     */
    int deleteByPrimaryKey(Integer sysCodeValueId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:28:06
     */
    int insert(SysCodeValuePO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:28:06
     */
    int insertSelective(SysCodeValuePO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:28:06
     */
    List<SysCodeValuePO> selectByExample(SysCodeValuePOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:28:06
     */
    SysCodeValuePO selectByPrimaryKey(Integer sysCodeValueId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:28:06
     */
    int updateByExampleSelective(@Param("record") SysCodeValuePO record, @Param("example") SysCodeValuePOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:28:06
     */
    int updateByExample(@Param("record") SysCodeValuePO record, @Param("example") SysCodeValuePOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:28:06
     */
    int updateByPrimaryKeySelective(SysCodeValuePO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-07-13 19:28:06
     */
    int updateByPrimaryKey(SysCodeValuePO record);
}