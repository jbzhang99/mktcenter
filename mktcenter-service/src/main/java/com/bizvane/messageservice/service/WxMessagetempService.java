package com.bizvane.messageservice.service;

import com.bizvane.messagefacade.models.po.MsgWxTempPO;
import com.bizvane.messagefacade.models.po.MsgWxTempPOExample;
import com.bizvane.messagefacade.models.vo.Result;
import com.bizvane.utils.responseinfo.ResponseData;

import java.util.List;

/**
 * 获取微信模板service
 * 
 * @author 董争光 2018年5月28日下午2:45:55
 */
public interface WxMessagetempService {

  /**
   * 通过模板类型和公众号id获取模板
   * 
   * @param type
   * @param wxPublicId
   * @return
   */
	MsgWxTempPO findMessagetempPOByType(String type, Long wxPublicId);

  /**
   * 通过模板类型和公众号id获取可以发送模板消息的模板
   * 
   * @param type
   * @param wxPublicId
   * @return
   */
  Result<MsgWxTempPO> findCanSendMessagetempPOByType(String type, Long wxPublicId);

  /**
   * 根据wx_public_id和valid查询集合
   * @return
   */
    List<MsgWxTempPO> findByPublicIdAndValid(Long wxPublicId, Boolean valid);

  /**
   * 通过主键字符串查找
   * @param temp_id_str
   * @return
   */
  List<MsgWxTempPO> findByIdStr(String temp_id_str);

  /**
   * 根据模板id和公众号id查询模板数量
   * @param template_id
   * @param public_id
   * @return
   */
  long findCountByTemplateIdAndPublicId(String template_id, long public_id);


  /**
   * 根据short_code和public_id查询数量
   * @param short_code
   * @param public_id
   * @return
   */
  long findCountByShortCodeAndPublicId(String short_code, long public_id);
  /**
   * 根据short_code和public_id查询id
   * @param short_code
   * @param public_id
   * @return
   */
  Long findIdByShortCodeAndPublicId(String short_code, long public_id);

  /**
   * 根据publicId和shortCode查找集合
   * @param public_id
   * @param opentm207128229
   * @return
   */
  List<MsgWxTempPO> findByPublicIdAndShortCode(Long public_id, String opentm207128229);

  /**
   * 根据类型type和publicId查询数据
   * @param templateMessageType
   * @param wxPublicId
   * @return
   */
    List<MsgWxTempPO> findByTypeAndPublicId(String templateMessageType, long wxPublicId);

    //====增删改查

  /**
   * 保存message_temp对象
   * @param po
   * @return
   */
  long saveMessageTemp(MsgWxTempPO po);

  /**
   * 根据id删除
   * @param wxMessageTempId
   */
  int deleteById(long wxMessageTempId);

  /**
   * 根据条件删除
   * @param example
   * @return
   */
  int deleteByExample(MsgWxTempPOExample example);

  /**
   * 根据id更新
   */
  ResponseData<Object> updateWxMessageIsSend(Long wxMessageTempId, Boolean issendmessage);

  /**
   * 根据id更新
   */
  ResponseData<Object> updateWxMessageTempById(MsgWxTempPO msgWxTempPO);

  /**
   * 根据条件更新
   * @param wxMessageTempPO
   * @param example
   */
  void updateWxMessageTemp(MsgWxTempPO wxMessageTempPO, MsgWxTempPOExample example);

  /**
   * 根据id查询
   * @param wxMessageTempId
   * @return
   */
  MsgWxTempPO findById(long wxMessageTempId);

  /**
   * 根据条件查询
   * @param example
   * @return
   */
  List<MsgWxTempPO> findByExample(MsgWxTempPOExample example);

  /**
   * 查询不同的模板
   * @param public_id
   * @return
   */
    List<MsgWxTempPO> findBypublicDiff(long public_id);

  /**
   * 根据模板类型查询微信模板消息
   * @param businessType
   * @return
   */
    ResponseData<Object> getTemplateByType(String businessType);

  /**
   * 根据模板类型查询
   * @param templateType
   * @return
   */
    ResponseData<Object> getTemplateByType(Long sysBrandId, String businessType, String templateType);
    
    /**
     * 根据id更新
     */
    ResponseData<Object> updateMsgSmsTempById(MsgWxTempPO po);

	ResponseData<Object> insert(MsgWxTempPO po);


}
