package com.bizvane.mktcenterserviceimpl.controllers;

import com.bizvane.couponfacade.models.vo.CouponDetailResponseVO;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.mktcenterservice.interfaces.ActivityManualService;
import com.bizvane.mktcenterservice.models.bo.ActivityBO;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterserviceimpl.common.constants.SystemConstants;
import com.bizvane.mktcenterserviceimpl.common.utils.ActivityParamCheckUtil;
import com.bizvane.utils.tokens.SysAccountPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bizvane.utils.responseinfo.ResponseData;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("activityManual")
@Slf4j
public class ActivityManualController {

    @Autowired
    private ActivityManualService activityManualService;

     /**
      * 查询活动列表
      * */
    @RequestMapping("/getActivityList")
    public  ResponseData<ActivityVO> getActivityList(ActivityVO vo, PageForm  pageForm){
        log.info("领券活动查询活动列表入参:ActivityVO:"+vo);
        ResponseData<ActivityVO> activityManualList = activityManualService.getActivityManualList(vo,pageForm);
       log.info("领券活动查询活动列表出参:"+activityManualList);
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


   /**
   *领券中心查询
   *
   * */
   @RequestMapping("/getActivityByMemberInfo")
    public ResponseData<List<ActivityVO>> getActivityByMemberInfo(MemberInfoModel memberInfoModel){
       ResponseData responseData =  new ResponseData();
           //入参校验
       if(null==memberInfoModel){
           responseData.setCode(SystemConstants.ERROR_CODE);
           responseData.setMessage("会员信息为空");
       }
       ResponseData<List<ActivityVO>> activityVoList=activityManualService.getActivityByMemberInfo(memberInfoModel);
        return activityVoList;
    }

   /**
   * 执行活动，增加领券记录，加人和券绑定
   * */

    @RequestMapping("/executeActivity")
    public  ResponseData<Integer> executeActivity(MemberInfoModel  model,String couponCode){
        return activityManualService.executeActivity(model,couponCode);
    }


    /**
    *
    * 扫码领券查询
    * */

    @RequestMapping("/getActivityByQrcode")
    public ResponseData<ActivityVO> getActivityByQrcode(MemberInfoModel memberInfoModel,String activityCode  ){
        ResponseData responseData =  new ResponseData();
        //入参校验
    if(null==memberInfoModel){
        responseData.setCode(SystemConstants.ERROR_CODE);
        responseData.setMessage(SystemConstants.ERROR_MSG_PARAM_EMPTY);
    }
    if(StringUtils.isEmpty(activityCode)){
        responseData.setCode(SystemConstants.ERROR_CODE);
        responseData.setMessage(SystemConstants.ERROR_MSG_PARAM_EMPTY);
    }
        ResponseData<ActivityVO> activityVo=activityManualService.getActivityByQrcode(memberInfoModel,activityCode);
        responseData.setData(activityVo);
        responseData.setMessage(SystemConstants.SUCCESS_MESSAGE);
        responseData.setCode(SystemConstants.ERROR_CODE);
        return responseData;
    }

   /**
   * 查询活动效果分析
   * */
   @RequestMapping("/getActivityManualEffect")
   public ResponseData<List<ActivityBO>>getActivityManualEffect(ActivityVO activityVO){
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
