package com.bizvane.mktcenterservice.interfaces;


import com.bizvane.centerstageservice.models.po.SysCheckPo;
import com.bizvane.couponfacade.models.vo.CouponDetailResponseVO;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.mktcenterservice.models.bo.ActivityBO;
import com.bizvane.mktcenterservice.models.po.MktActivityPOWithBLOBs;
import com.bizvane.mktcenterservice.models.vo.ActivityManualVO;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;

import java.util.List;


public interface ActivityManualService {

  ResponseData<ActivityVO> getActivityManualList(ActivityVO vo , PageForm pageForm);

  ResponseData<Integer> addActivityManual(ActivityBO bo,SysAccountPO stageUser);

  ResponseData<Integer> executeActivity(ActivityManualVO vo);

  ResponseData<List<ActivityBO>> getActivityManualEffect(ActivityVO vo);

  ResponseData<ActivityBO> selectActivityManualByBusinessCode(String businessCode);

  ResponseData<List<ActivityVO>>  getActivityByMemberInfo(MemberInfoModel memberInfoModel,Integer activityType);
  ResponseData<ActivityVO>  getActivityByQrcode(MemberInfoModel memberInfoModel,String activityCode,Integer activityType);

  ResponseData<Integer>  checkActivity(SysCheckPo po, SysAccountPO sysAccountPO);


}
