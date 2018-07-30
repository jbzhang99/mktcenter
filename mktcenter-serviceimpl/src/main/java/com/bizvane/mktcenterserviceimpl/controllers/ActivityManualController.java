package com.bizvane.mktcenterserviceimpl.controllers;

import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.mktcenterservice.interfaces.ActivityManualService;
import com.bizvane.mktcenterservice.models.bo.ActivityBO;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterserviceimpl.common.utils.ActivityParamCheckUtil;
import com.bizvane.utils.tokens.SysAccountPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bizvane.utils.responseinfo.ResponseData;
import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("activityManual")
public class ActivityManualController {

    @Autowired
    private ActivityManualService activityManualService;

     /*查询活动列表*/
    @RequestMapping("/getActivityList")
    public  ResponseData<ActivityVO> getActivityList(ActivityVO vo, PageForm  pageForm){
        ResponseData<ActivityVO> activityManualList = activityManualService.getActivityManualList(vo,pageForm);
       return activityManualList;
    }

    /*
    * 查询优惠券
    */

    /**
     *创建活动
     */
    @RequestMapping("/addActivity")
   public  ResponseData<Integer> addActivity(Long couponId, ActivityVO activityVO,HttpServletRequest request){
        //1.入参校验
        ActivityParamCheckUtil.checkManualParam(activityVO,couponId) ;
        //取缓存
        // SysAccountPO stageUser = TokenUtils.getStageUser(request);
        SysAccountPO stageUser = new SysAccountPO();
        ResponseData<Integer> activityManualResponseData = activityManualService.addActivityManual(couponId,activityVO,stageUser);
       return activityManualResponseData;
   }

   /*
   *查询会员是否满足规则
   * */


   /*
   * 执行活动
   * */

  /*  @RequestMapping("/executeActivity")
    public  ResponseData<Integer> executeActivity(MemberInfoModel  model){

        return activityManualService.executeActivity(model);
    }*/


    /**
     * 修改活动
     * @param activityVO
     * @return
     */

   /*
   * 查询活动效果
   * */
   @RequestMapping("/getActivityManualEffect")
 public ResponseData<ActivityBO>getActivityManualEffect(ActivityVO activityVO){
       ResponseData responseData = activityManualService.getActivityManualEffect(activityVO);
       return  responseData;
 }

    /**
     * 查看活动详情
     */
    @RequestMapping("/selectActivityManualById")
    public ResponseData<ActivityVO> selectActivityManualById(Long mktActivityId){
        return activityManualService.selectActivityManualById(mktActivityId);
    }
}
