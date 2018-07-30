package com.bizvane.mktcenterservice.interfaces;


import com.bizvane.mktcenterservice.models.bo.ActivityBO;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;


public interface ActivityManualService {

  ResponseData<ActivityVO> getActivityManualList(ActivityVO vo , PageForm pageForm);

  ResponseData<Integer> addActivityManual(Long couponId, ActivityVO activityVO,SysAccountPO stageUser);

/*  ResponseData<Integer> executeActivity(MemberInfoModel vo);*/

  ResponseData<ActivityBO> getActivityManualEffect(ActivityVO vo);

  ResponseData<ActivityVO> selectActivityManualById(Long mktActivityId);
}
