package com.bizvane.mktcenterfacade.interfaces;


import com.bizvane.centerstageservice.models.po.SysCheckPo;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.mktcenterfacade.models.bo.ActivityBO;
import com.bizvane.mktcenterfacade.models.vo.PageForm;
import com.bizvane.mktcenterfacade.models.vo.ActivityManualVO;
import com.bizvane.mktcenterfacade.models.vo.ActivityVO;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;

import java.util.List;


public interface ActivityManualService {

  ResponseData<ActivityVO> getActivityManualList(ActivityVO vo , PageForm pageForm, SysAccountPO stageUser);

  ResponseData<Integer> addActivityManual(ActivityBO bo, SysAccountPO stageUser);

  ResponseData<ActivityManualVO> executeActivity(ActivityManualVO vo);

  ResponseData<List<ActivityBO>> getActivityManualEffect(ActivityVO vo);

  ResponseData<ActivityBO> selectActivityManualByBusinessCode(String businessCode);

  ResponseData<List<ActivityVO>>  getActivityByMemberInfo(MemberInfoModel memberInfoModel,Integer activityType);
  ResponseData<ActivityVO>  getActivityByQrcode(MemberInfoModel memberInfoModel,String activityCode,Integer activityType);

  ResponseData<Integer>  checkActivity(SysCheckPo po, SysAccountPO sysAccountPO);


}