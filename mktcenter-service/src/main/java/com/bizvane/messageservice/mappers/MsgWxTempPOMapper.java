package com.bizvane.messageservice.mappers;

import com.bizvane.messagefacade.models.po.MsgWxTempPO;
import com.bizvane.messagefacade.models.po.MsgWxTempPOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MsgWxTempPOMapper {
    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    long countByExample(MsgWxTempPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    int deleteByExample(MsgWxTempPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    int deleteByPrimaryKey(Long wxMessageTempId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    int insert(MsgWxTempPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    int insertSelective(MsgWxTempPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    List<MsgWxTempPO> selectByExample(MsgWxTempPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    MsgWxTempPO selectByPrimaryKey(Long wxMessageTempId);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    int updateByExampleSelective(@Param("record") MsgWxTempPO record, @Param("example") MsgWxTempPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    int updateByExample(@Param("record") MsgWxTempPO record, @Param("example") MsgWxTempPOExample example);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    int updateByPrimaryKeySelective(MsgWxTempPO record);

    /**
     * 只读. 
     *
     * @mbg.generated 2018-08-08 16:00:02
     */
    int updateByPrimaryKey(MsgWxTempPO record);
    
    /**
     * 根据id字符串查询
     * @param temp_id_str
     */
    List<MsgWxTempPO> getWxMessagetempByIdStr(@Param("idStr") String temp_id_str);

    List<MsgWxTempPO> getTemplateByPublicId(@Param("publicId") long public_id);

    List<MsgWxTempPO> getTemplateByPublicIdAndType(@Param("publicId") long public_id, @Param("type") String template_type);
  /**
   * 通过主键字符串查找
   * @param temp_id_str
   * @return
   */
    List<MsgWxTempPO> findByIdStr(@Param("idStr") String temp_id_str);

  /**
   * 查询不同的模板
   * @param public_id
   * @return
   */
    List<MsgWxTempPO> findBypublicDiff(@Param("publicId") long public_id);
    
    
    
}