package com.bizvane.messageservice.mappers;

import com.bizvane.messagefacade.models.po.WxMessageTempPO;
import com.bizvane.messagefacade.models.po.WxMessageTempPOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WxMessageTempPOMapper {

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  long countByExample(WxMessageTempPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  int deleteByExample(WxMessageTempPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  int deleteByPrimaryKey(Long wxMessageTempId);

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  int insert(WxMessageTempPO record);

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  int insertSelective(WxMessageTempPO record);

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  List<WxMessageTempPO> selectByExample(WxMessageTempPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  WxMessageTempPO selectByPrimaryKey(Long wxMessageTempId);

  /**
   * 只读. 
   * @mbg.generated  2018-08-02 15:58:49
   */
  int updateByExampleSelective(@Param("record") WxMessageTempPO record,
                               @Param("example") WxMessageTempPOExample example);

  /**
   * 只读.
   * @mbg.generated  2018-08-02 15:58:49
   */
  int updateByExample(@Param("record") WxMessageTempPO record, @Param("example") WxMessageTempPOExample example);

  /**
   * 只读.
   * @mbg.generated  2018-08-02 15:58:49
   */
  int updateByPrimaryKeySelective(WxMessageTempPO record);

  /**
   * 只读.
   * @mbg.generated  2018-08-02 15:58:49
   */
  int updateByPrimaryKey(WxMessageTempPO record);

  /**
     * 根据id字符串查询
     * @param temp_id_str
     */
    List<WxMessageTempPO> getWxMessagetempByIdStr(@Param("idStr") String temp_id_str);

    List<WxMessageTempPO> getTemplateByPublicId(@Param("publicId") long public_id);

    List<WxMessageTempPO> getTemplateByPublicIdAndType(@Param("publicId") long public_id, @Param("type") String template_type);
  /**
   * 通过主键字符串查找
   * @param temp_id_str
   * @return
   */
    List<WxMessageTempPO> findByIdStr(@Param("idStr") String temp_id_str);

  /**
   * 查询不同的模板
   * @param public_id
   * @return
   */
    List<WxMessageTempPO> findBypublicDiff(@Param("publicId") long public_id);
}