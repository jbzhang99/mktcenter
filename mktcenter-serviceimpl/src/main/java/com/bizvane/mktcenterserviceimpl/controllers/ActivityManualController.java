package com.bizvane.mktcenterserviceimpl.controllers;

import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.mktcenterservice.interfaces.ActivityManualService;
import com.bizvane.mktcenterservice.models.bo.ActivityBO;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterserviceimpl.common.utils.ActivityParamCheckUtil;
import com.bizvane.utils.tokens.SysAccountPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
       log.info("创建活动，入参,couponId:"+couponId+",activityVo"+activityVO+",httpServletRequest:"+request);
        //1.入参校验
        ActivityParamCheckUtil.checkManualParam(activityVO,couponId) ;
        //取缓存
        // SysAccountPO stageUser = TokenUtils.getStageUser(request);
        SysAccountPO stageUser = new SysAccountPO();

        ResponseData<Integer> activityManualResponseData = activityManualService.addActivityManual(couponId,activityVO,stageUser);
        log.info("创建活动出参:"+activityManualResponseData);
       return activityManualResponseData;
   }


   /**
   *领券中心查询
   *
   * */
   @RequestMapping("/getActivityByMemberInfo")
    public ResponseData<List<ActivityVO>> getActivityByMemberInfo(MemberInfoModel memberInfoModel,Integer activityType){
       ResponseData<List<ActivityVO>> activityVoList=activityManualService.getActivityByMemberInfo(memberInfoModel,activityType);
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
    public ResponseData<ActivityVO> getActivityByQrcode(MemberInfoModel memberInfoModel,String activityCode,Integer activityType  ){
        ResponseData<ActivityVO> activityVo=activityManualService.getActivityByQrcode(memberInfoModel,activityCode,activityType);
        return activityVo;
    }

   /**
   * 查询活动效果分析
   * */
   @RequestMapping("/getActivityManualEffect")
   public ResponseData<List<ActivityBO>>getActivityManualEffect(ActivityVO activityVO){
      return activityManualService.getActivityManualEffect(activityVO);
 }

    /**
     * 查看活动详情
     */
    @RequestMapping("/selectActivityManualById")
    public ResponseData<ActivityVO> selectActivityManualById(Long mktActivityId){
        return activityManualService.selectActivityManualById(mktActivityId);
    }

}
