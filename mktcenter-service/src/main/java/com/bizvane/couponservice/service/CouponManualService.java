package com.bizvane.couponservice.service;

import com.bizvane.centerstageservice.models.po.SysAccountPo;
import com.bizvane.couponfacade.models.po.CouponDefinitionPOWithBLOBs;
import com.bizvane.couponfacade.models.po.CouponManualPO;
import com.bizvane.couponfacade.models.vo.CouponDetailResponseVO;
import com.bizvane.couponfacade.models.vo.CouponManualVO;
import com.bizvane.couponfacade.models.vo.CouponSendCheckRequestVO;
import com.bizvane.couponfacade.models.vo.SendCouponBatchRequestVO;
import com.bizvane.couponfacade.utils.PageFormUtil;
import com.bizvane.members.facade.es.vo.MembersInfoSearchVo;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.utils.responseinfo.PageInfo;
import com.bizvane.utils.responseinfo.ResponseData;

import java.math.BigDecimal;
import java.util.List;

public interface CouponManualService {
  /**
   * 手动发券（列表）
   * @param vo
   * @return
   */
  ResponseData<PageInfo<CouponManualVO>> getList(CouponManualVO vo, Long sysBrandId, PageFormUtil pageForm);

  /**
   * 手动发券（列表）
   * @param vo
   * @return
   */
  ResponseData<PageInfo<CouponManualVO>> getListRpc(CouponManualVO vo, PageFormUtil pageForm);

  /**
   * 创建发券任务
   * @param
   * @return
   */
  ResponseData<String> addTask(CouponManualVO couponManualVO, MembersInfoSearchVo memberInfo, SysAccountPo accountPo)throws Exception;


  /**
   * 更改任务状态
   * @param po
   * @return
   */
  ResponseData<Integer> changeTask(CouponManualPO po);

  /**
   * 停止发送任务
   * @param couponManualId
   * @return
   */
  ResponseData<Integer> suspendTask(Long couponManualId);

  /**
   * 修改审核状态
   * @param param
   * @return
   */
  ResponseData<String> changeCheckStatus(CouponSendCheckRequestVO param);

  /**
   * 发券效果分析列表
   * @param vo
   * @return
   */
    ResponseData<PageInfo> findResult(CouponManualVO vo, PageFormUtil pageForm, SysAccountPo accountPo);

  /**
   * 发券效果分析合计
   * @param vo
   * @return
   */
  ResponseData<CouponManualVO> findTotal(CouponManualVO vo, SysAccountPo accountPo);

  /**
   * 根据手动发券id查询发券信息
   * @param couponManualId
   * @return
   */
    ResponseData<CouponDetailResponseVO> findById(Long couponManualId);


  /**
   * 修改手动发券任务
    * @param couponManualVO
   * @return
   */
  ResponseData<String> changeManualTask(CouponManualVO couponManualVO, MembersInfoSearchVo memberInfo, SysAccountPo accountPo)throws Exception;

  /**
   * 查询创建手动发券任务选中的会员
   * @param couponManualId
   * @return
   */
  ResponseData<PageInfo<MemberInfoModel>> findManualMembers(Long couponManualId, String name, String phone, PageFormUtil pageFormUtil);

  /**
   * 更新手动发券任务状态
   * @param couponManualId
   * @param taskStatus
   */
  public void updateTaskStatus(Long couponManualId, Byte taskStatus);

  /**
   * 判断发券渠道
   * @param definitionPO
   * @param requestVO
   * @return
   */
  public ResponseData<String> sendCouponByUseChannel(CouponDefinitionPOWithBLOBs definitionPO, SendCouponBatchRequestVO requestVO);


  /**
   * 更新手动发券数量
   * @param manualId
   * @param profitMoney
   * @param discountMoney
   */
  public  void updateCouponManualCount(Long useStoreId, Long manualId, BigDecimal profitMoney, BigDecimal discountMoney);


  /**
   * 创建发券任务(新)
   * @param
   * @return
   */
  ResponseData<String> addNewTask(CouponManualVO couponManualVO, MembersInfoSearchVo memberInfo, SysAccountPo accountPo)throws Exception;


  /**
   * 判断发券渠道(新)
   * @param
   * @param requestVO
   * @return
   */
  public ResponseData<String> sendNewCouponByUseChannel(List<CouponDefinitionPOWithBLOBs> definitionPOList, SendCouponBatchRequestVO requestVO);


  /**
   * 修改手动发券任务
   * @param couponManualVO
   * @return
   */
  ResponseData<String> changeNewManualTask(CouponManualVO couponManualVO, MembersInfoSearchVo memberInfo, SysAccountPo accountPo)throws Exception;


  /**
   * 根据手动发券id查询发券信息
   * @param couponManualId
   * @return
   */
  ResponseData<CouponDetailResponseVO> findNewById(Long couponManualId);
}
