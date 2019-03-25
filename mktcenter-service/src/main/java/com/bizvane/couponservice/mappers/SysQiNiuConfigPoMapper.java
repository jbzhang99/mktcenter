package com.bizvane.couponservice.mappers;

import com.bizvane.couponfacade.models.po.SysQiNiuConfigPo;
import com.bizvane.couponfacade.models.po.SysQiNiuConfigPoExample;
import com.bizvane.utils.tenant.QuarantineAnnotation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@QuarantineAnnotation
public interface SysQiNiuConfigPoMapper {
    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    int countByExample(SysQiNiuConfigPoExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    int deleteByExample(SysQiNiuConfigPoExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    int deleteByPrimaryKey(Long sysQiniuConfigId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    int insert(SysQiNiuConfigPo record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    int insertSelective(SysQiNiuConfigPo record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    List<SysQiNiuConfigPo> selectByExample(SysQiNiuConfigPoExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    SysQiNiuConfigPo selectByPrimaryKey(Long sysQiniuConfigId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    int updateByExampleSelective(@Param("record") SysQiNiuConfigPo record, @Param("example") SysQiNiuConfigPoExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    int updateByExample(@Param("record") SysQiNiuConfigPo record, @Param("example") SysQiNiuConfigPoExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    int updateByPrimaryKeySelective(SysQiNiuConfigPo record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-13 20:46:12
     */
    int updateByPrimaryKey(SysQiNiuConfigPo record);
}