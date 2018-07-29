package com.bizvane.mktcenterservice.interfaces;

import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.mktcenterservice.models.bo.ActivityBO;
import com.bizvane.mktcenterservice.models.vo.ActivityManualVO;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;

import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;

import java.util.List;

public interface ActivityManualService {

  ResponseData<ActivityVO> getActivityManualList(ActivityVO vo , PageForm pageForm);

  ResponseData<Integer> addActivityManual(Long couponId, ActivityVO activityVO, ActivityManualVO activityManualVO,SysAccountPO stageUser);

/*  ResponseData<Integer> executeActivity(MemberInfoModel vo);*/

  ResponseData<ActivityBO> getActivityManualEffect(ActivityVO vo);

  ResponseData<List<ActivityVO>> selectActivityManualById(Long mktActivityId);
}
