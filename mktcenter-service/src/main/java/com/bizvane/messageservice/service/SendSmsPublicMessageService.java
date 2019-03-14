package com.bizvane.messageservice.service;


import com.alibaba.fastjson.JSONObject;
import com.bizvane.couponfacade.models.po.CouponEntityPO;
import com.bizvane.members.facade.models.MemberInfoModel;

/**
 * @发送短信模板消息service
 * 
 * @author 张迪
 * 
 * @date 2018/08/09
 */
public interface SendSmsPublicMessageService {

  /**
   * @根据会员编号获取会员信息
   * 
   * @param MemberInfoModel
   * 
   * @return Result<String>
   */
    public MemberInfoModel GetMemberEntityByMemberCode(String memberName);
    
    
    /**
     * @根据优惠券编号获取劵信息
     * 
     * @param CouponName
     * 
     * @return Result<String>
     */
      public CouponEntityPO GetCouponEntityByCouponCode(String couponName);
      
      
      
      /**
       * @根据优惠券编号获取劵信息
       * 
       * @param CouponName
       * 
       * @return Result<String>
       */
      public String GetReplaceContent(JSONObject jsonobj);


}
