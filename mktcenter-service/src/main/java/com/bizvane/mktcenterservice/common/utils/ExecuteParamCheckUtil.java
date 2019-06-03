package com.bizvane.mktcenterservice.common.utils;

import com.alibaba.fastjson.JSON;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.mktcenterfacade.models.bo.ActivityBO;
import com.bizvane.mktcenterfacade.models.bo.OrderModelBo;
import com.bizvane.mktcenterfacade.models.vo.ActivityCouponVO;
import com.bizvane.mktcenterfacade.models.vo.ActivityVO;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class ExecuteParamCheckUtil {
    /**
     * 针对会员类型 会员范围判断
     * @param memberTypeVo
     * @param memberType
     * @return
     */
    public static Boolean CheckMemberType(Integer memberTypeVo,Integer memberType){
        boolean  falg;
        if (memberType.equals(memberTypeVo)){
            falg = true;
        }else{
            falg=false;
        }
        return falg;
    }

    /**
     * 判断会员等级
     * @param levelId
     * @param mbrLevelCode
     * @return
     */
    public static Boolean CheckMbrLevelCode(Long levelId,String mbrLevelCode){
        boolean  falg;
        if (mbrLevelCode.equals(levelId.toString())){
            falg = true;
        }else {
            falg=false;
        }
        return falg;
    }

    /**
     * 判断订单来源
     * @param orderFrom
     * @param orderSource
     * @return
     */
    public static Boolean CheckOrderFrom(Integer orderFrom,Integer orderSource){
        boolean  falg;
        if(0==orderSource || orderSource.equals(orderFrom)){
            falg = true;
        }else {
            falg=false;
        }
        return falg;
    }

    /**
     * 判断金额是否满足
     * @param payMoney
     * @param orderMinPrice
     * @return
     */
    public static Boolean CheckPayMoney(BigDecimal payMoney,BigDecimal orderMinPrice){
        boolean  falg;
        if (payMoney.compareTo(orderMinPrice) >=0){
            falg = true;
        }else{
            falg=false;
        }
        return falg;
    }

    /**
     * 判断商品是否满足
     * @param vo
     * @param activityVO
     * @return
     */
    public  static Boolean CheckCommodity(OrderModelBo vo,ActivityVO activityVO) {
        Boolean falg = Boolean.FALSE;
        Boolean storeLimit =Boolean.FALSE;
        if(activityVO.getStoreLimit()==null){
            storeLimit=activityVO.getIsStoreLimit();
        }
        if (Boolean.FALSE.equals(storeLimit)) {
            falg = true;
        } else {
            //判断是否是黑名单\
            if (activityVO.getCommodityLimitType()==1) {
                String commodityBlacklist = activityVO.getCommodityLimitList();
                List<String> result = Arrays.asList(commodityBlacklist.split(","));
                String productNos = vo.getProductNos();
                List<String> productNoList = Arrays.asList(productNos.split(","));
                result.retainAll(productNoList);
                boolean fa=result.size()>0;
                    if (fa==true){
                        falg=false;
                    }else {
                        falg=true;
                    }

            }
            //判断是否是白名单
            if (activityVO.getCommodityLimitType()==2) {
                String commodityWhitelist = activityVO.getCommodityLimitList();
                List<String> result = Arrays.asList(commodityWhitelist.split(","));
                log.info("活动查出来的白名单集合："+ JSON.toJSONString(result));
                String productNos = vo.getProductNos();
                List<String> productNoList = Arrays.asList(productNos.split(","));
                log.info("消费时候传过来的集合："+ JSON.toJSONString(productNoList));
                    boolean contains = result.containsAll(productNoList);
                        falg=contains;
            }

        }
        return falg;
    }

    /**
     * 判断门店
     * @param vo
     * @param activityVO
     * @return
     */
    public  static Boolean CheckserviceStore(OrderModelBo vo,ActivityVO activityVO) {
        Boolean falg = Boolean.FALSE;
        Boolean storeLimit =Boolean.FALSE;
        if(activityVO.getStoreLimit()==null){
            storeLimit=activityVO.getIsStoreLimit();
        }
        if (Boolean.FALSE.equals(storeLimit)) {
            falg = true;
        }else{
            //判断是都是黑名单
            if (activityVO.getStoreLimitType()==1) {
                String StoreBlacklist = activityVO.getStoreLimitList();
                List<String> result = Arrays.asList(StoreBlacklist.split(","));
                 boolean contains  =result.contains(vo.getServiceStoreId());
                 if (contains==true){
                     falg=false;
                 }else{
                     falg=true;
                 }
            }

            //判断是否是白名单
            if (activityVO.getStoreLimitType()==2) {
                String StoreWhitelist = activityVO.getStoreLimitList();
                List<String> result = Arrays.asList(StoreWhitelist.split(","));
                falg=result.contains(vo.getServiceStoreId());
            }

        }
        return falg;
    }

    /**
     * 创建长期活动门店验证
     * @return
     */
    public  static Boolean addActivitCheck(ActivityBO bo, ActivityVO activityVO) {
        Boolean falg = Boolean.FALSE;
        Boolean storeLimit =Boolean.FALSE;
        if(activityVO.getStoreLimit()==null){
            storeLimit=activityVO.getIsStoreLimit();
        }
        if (Boolean.FALSE.equals(storeLimit)) {
            falg = false;
        } else {
            //判断是白名单
            if (bo.getActivityVO().getStoreLimitType()==2) {
                //前端传过来的
                String storeLimitList = bo.getActivityVO().getStoreLimitList();
                List<String> result = Arrays.asList(storeLimitList.split(","));
                List res = new ArrayList(result);
                //表里查出来的
                String stroeList = activityVO.getStoreLimitList();
                List<String> productNoList = Arrays.asList(stroeList.split(","));
                List productList = new ArrayList(productNoList);
                productList.retainAll(res);
                boolean fa=productList.size()>0;
                if (fa==true){
                    falg=false;
                }else {
                    falg=true;
                }

            }
            //判断是否是白名单

        }
        return falg;
    }

    /**
     * 执行活动时的验证
     * @return
     */
    public  static Boolean implementActivitCheck(MemberInfoModel vo, ActivityCouponVO activityCouponVO) {
        Boolean falg = Boolean.FALSE;
        Boolean storeLimit =Boolean.FALSE;
        if(activityCouponVO.getIsStoreLimit()==null){
            storeLimit = activityCouponVO.getIsStoreLimit();
        }
        if (Boolean.FALSE.equals(storeLimit)) {
            falg = true;
        } else {
            //判断是白名单
            if (activityCouponVO.getStoreLimitType()==2) {
                if (null!=vo.getServiceStoreId()){
                    //表里查出来的
                    String stroeList = activityCouponVO.getStoreLimitList();
                    log.info("表里查出来数据为=============="+stroeList);
                    List<String> productNoList = Arrays.asList(stroeList.split(","));
                    log.info("服务门店的id为=============="+vo.getServiceStoreId().toString());
                    falg=productNoList.contains(vo.getServiceStoreId().toString());
                }else{
                    falg = false;
                }


            }
            //判断是否是白名单

        }
        return falg;
    }
    
    public  static Boolean implementActivitCheck(MemberInfoModel vo, ActivityVO activityVO) {
      Boolean falg = Boolean.FALSE;
      Boolean storeLimit =Boolean.FALSE;
      if(activityVO.getStoreLimit()==null){
          storeLimit=activityVO.getIsStoreLimit();
      }
      if (Boolean.FALSE.equals(storeLimit)) {
          falg = true;
      } else {
          //判断是白名单
          if (activityVO.getStoreLimitType()==2) {
              if (null!=vo.getServiceStoreId()){
                  //表里查出来的
                  String stroeList = activityVO.getStoreLimitList();
                  log.info("表里查出来数据为=============="+stroeList);
                  List<String> productNoList = Arrays.asList(stroeList.split(","));
                  log.info("服务门店的id为=============="+vo.getServiceStoreId().toString());
                  falg=productNoList.contains(vo.getServiceStoreId().toString());
              }else{
                  falg = false;
              }


          }
          //判断是否是白名单

      }
      return falg;
  }
}
