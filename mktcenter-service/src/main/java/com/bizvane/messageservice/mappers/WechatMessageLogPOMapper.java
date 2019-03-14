package com.bizvane.messageservice.mappers;

import com.bizvane.messagefacade.models.po.WechatMessageLogPO;
import com.bizvane.messagefacade.models.po.WechatMessageLogPOExample;
import com.bizvane.messagefacade.models.vo.WechatMessageLogVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WechatMessageLogPOMapper {
    /**
   * 只读. 
   * @mbg.generated  2018-07-31 16:15:01
   */
  long countByExample(WechatMessageLogPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-07-31 16:15:01
   */
  int deleteByExample(WechatMessageLogPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-07-31 16:15:01
   */
  int deleteByPrimaryKey(Long wechatMessageLogId);

  /**
   * 只读. 
   * @mbg.generated  2018-07-31 16:15:01
   */
  int insert(WechatMessageLogPO record);

  /**
   * 只读. 
   * @mbg.generated  2018-07-31 16:15:01
   */
  int insertSelective(WechatMessageLogPO record);

  /**
   * 只读. 
   * @mbg.generated  2018-07-31 16:15:01
   */
  List<WechatMessageLogPO> selectByExample(WechatMessageLogPOExample example);

  /**
   * 只读. 
   * @mbg.generated  2018-07-31 16:15:01
   */
  WechatMessageLogPO selectByPrimaryKey(Long wechatMessageLogId);

  /**
   * 只读. 
   * @mbg.generated  2018-07-31 16:15:01
   */
  int updateByExampleSelective(@Param("record") WechatMessageLogPO record,
                               @Param("example") WechatMessageLogPOExample example);

  /**
   * 只读.
   * @mbg.generated  2018-07-31 16:15:01
   */
  int updateByExample(@Param("record") WechatMessageLogPO record, @Param("example") WechatMessageLogPOExample example);

  /**
   * 只读.
   * @mbg.generated  2018-07-31 16:15:01
   */
  int updateByPrimaryKeySelective(WechatMessageLogPO record);

  /**
   * 只读.
   * @mbg.generated  2018-07-31 16:15:01
   */
  int updateByPrimaryKey(WechatMessageLogPO record);

    /**
     * 查找微信消息日志分页
     * @param vo
     * @return
     */
    List<WechatMessageLogVO> findPage(@Param("vo") WechatMessageLogVO vo);
}