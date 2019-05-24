package com.bizvane.mktcenterfacade.interfaces;


import java.util.List;

import com.bizvane.centerstageservice.models.po.SysCheckPo;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.mktcenterfacade.models.bo.ActivityBO;
import com.bizvane.mktcenterfacade.models.vo.ActivityCouponVO;
import com.bizvane.mktcenterfacade.models.vo.ActivityManualVO;
import com.bizvane.mktcenterfacade.models.vo.ActivityVO;
import com.bizvane.mktcenterfacade.models.vo.PageForm;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;

public interface ActivityManualService {

  ResponseData<ActivityVO> getActivityManualList(ActivityVO vo , PageForm pageForm, SysAccountPO stageUser);

  ResponseData<Integer> addActivityManual(ActivityBO bo, SysAccountPO stageUser);

  ResponseData<ActivityManualVO> executeActivity(ActivityManualVO vo);

  ResponseData<List<ActivityBO>> getActivityManualEffect(ActivityVO vo);

  ResponseData<ActivityBO> selectActivityManualByBusinessCode(String businessCode);

  /**
   * 堂倌
   * 通过会员查询活动领券中心list
   * @param memberInfoModel
   * @param activityType
   * @return
   */
  ResponseData<List<ActivityCouponVO>>  getActivityByMemberInfo(MemberInfoModel memberInfoModel,Integer activityType);
  
  ResponseData<ActivityVO>  getActivityByQrcode(MemberInfoModel memberInfoModel,String activityCode,Integer activityType);

  ResponseData<Integer>  checkActivity(SysCheckPo po, SysAccountPO sysAccountPO);


}
