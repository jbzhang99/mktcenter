package com.bizvane.couponservice.service;

import com.bizvane.centerstageservice.models.po.SysAccountPo;
import com.bizvane.couponfacade.models.po.*;
import com.bizvane.couponfacade.models.vo.CouponSendAgainRequestVO;
import com.bizvane.couponfacade.models.vo.CouponSendFailLogVO;
import com.bizvane.couponfacade.models.vo.SendCouponBatchRequestVO;
import com.bizvane.couponfacade.models.vo.SendCouponSimpleRequestVO;
import com.bizvane.couponfacade.utils.PageFormUtil;
import com.github.pagehelper.PageInfo;
import com.bizvane.utils.responseinfo.ResponseData;

import java.util.List;

/**
 * 发券
 * @author 董争光
 * 2018年7月6日下午2:16:04
 */
public interface SendCouponService {

  /**
   * 单张发券(优惠券入账)
   * @return
   */
  ResponseData<String> simple(SendCouponSimpleRequestVO vo);


  /**
   * 批量发券
   * @return
   */
  ResponseData<String> batchRpc(SendCouponBatchRequestVO vo);

  /**
   * 发券失败查询
   * @param vo
   * @return
   */
    ResponseData<PageInfo> couponSendFail(CouponSendFailLogVO vo, SysAccountPo accountPo, PageFormUtil pageForm);

  /**
   * 根据id修改券发放失败信息
   * @param couponSendFailLogPO
   * @return
   */
    ResponseData<Object> update(CouponSendFailLogPO couponSendFailLogPO);

  /**
   * 券到期提醒
   * @param expireDay
   * @return
   */
    ResponseData<Integer> expire(String expireDay);


  /**
   * 补发券(单张)
   * @return
   */
  ResponseData<Integer> sendSingleAgain(Long couponSendFailLogId);

  /**
   * 补发券(批量)
   * @return
   */
  ResponseData<Integer> sendBatchAgain(String ids);


  /**
   * 线上批量发券
   * @param definitionPO
   * @param entityPOList
   * @return
   */
  ResponseData<String> sendCouponBatchOnline(CouponDefinitionPO definitionPO, List<CouponEntityPO> entityPOList);

  /**
   * 线下批量发券
   * @param definitionPO
   * @param entityPOList
   * @return
   */
  ResponseData<String> sendCouponBatchOffline(CouponDefinitionPOWithBLOBs definitionPO, List<CouponEntityPO> entityPOList,
                                              CouponBatchSendRecordPO batchPO);

  /**
   * 保存发券记录（券批次和券实例）
   * @param requestVO
   * @return
   */
  public List<CouponEntityPO> saveEntityList(CouponDefinitionPOWithBLOBs definitionPO, SendCouponBatchRequestVO requestVO,
                                             Long batchRecodeId, Byte couponStatus);

  /**
   * 执行批量补发
   * @param againList
   * @return
   */
  public ResponseData<Integer> sendBatchAgainExecute(List<CouponSendAgainRequestVO> againList);

  /**
   * 单张发券批量补发
   * @param againList
   * @return
   */
  ResponseData<Integer> sendSingleBatchAgainExecute(List<CouponSendAgainRequestVO> againList);

  /**
   * 保存发券批次记录
   * @param definitionPO
   * @param requestVO
   * @return
   */
  public CouponBatchSendRecordPO saveCouponBatchRecord(CouponDefinitionPO definitionPO, SendCouponBatchRequestVO requestVO);

  /**
   * 线上立刻发券
   * @param definitionPO
   * @param requestVO
   * @return
   */
  public ResponseData<String> sendCouponBatchOnlineNow(CouponDefinitionPOWithBLOBs definitionPO, SendCouponBatchRequestVO requestVO,
                                                       CouponBatchSendRecordPO batchPO);

  /**
   * 线下立刻发券
   */
  ResponseData<String> sendCouponBatchOfflineNow(CouponDefinitionPOWithBLOBs definitionPO, SendCouponBatchRequestVO requestVO,
                                                 CouponBatchSendRecordPO batchPO);

  /**
   * 全渠道立刻发券
   * @param definitionPO
   * @param requestVO
   * @param batchPO
   * @return
   */
  ResponseData<String> sendCouponBatchAnyNow(CouponDefinitionPOWithBLOBs definitionPO, SendCouponBatchRequestVO requestVO, CouponBatchSendRecordPO batchPO);


  /**
   * 单张发券发送短信微信模板消息
   *
   * @param definitionPO
   * @param entityPO
   * @return
   */
  public ResponseData<String> sendCouponOnline(CouponDefinitionPOWithBLOBs definitionPO, CouponEntityPO entityPO);

  /**
   * 单张券生成条形码
   * @param entityPO
   */
  public void updateBarcodeUrl(CouponEntityPO entityPO);


  /**
   * 保存发券批次记录(新)
   * @param
   * @param requestVO
   * @return
   */
  public CouponBatchSendRecordPO saveNewCouponBatchRecord(Long companyId, Long brandId, String brandCode, String ids, SendCouponBatchRequestVO requestVO);


  void saveNewCouponBatchRecordDetail(Long sysCompanyId, Long sysBrandId, String brandCode, CouponDefinitionPOWithBLOBs couponDefinitionPOWithBLOBs, SendCouponBatchRequestVO requestVO);
		

}
