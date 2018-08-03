package com.bizvane.mktcenterservice.interfaces;


import com.bizvane.couponfacade.models.vo.CouponDetailResponseVO;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.mktcenterservice.models.bo.ActivityBO;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;

import java.util.List;


public interface ActivityManualService {

  ResponseData<ActivityVO> getActivityManualList(ActivityVO vo , PageForm pageForm);

  ResponseData<Integer> addActivityManual(Long couponId, ActivityVO activityVO,SysAccountPO stageUser);

  ResponseData<Integer> executeActivity(MemberInfoModel vo,String couponCode,Integer activityType);

  ResponseData<List<ActivityBO>> getActivityManualEffect(ActivityVO vo);

  ResponseData<ActivityVO> selectActivityManualById(Long mktActivityId);

  ResponseData<List<ActivityVO>>  getActivityByMemberInfo(MemberInfoModel memberInfoModel,Integer activityType);
  ResponseData<ActivityVO>  getActivityByQrcode(MemberInfoModel memberInfoModel,String activityCode,Integer activityType);
}
