package com.bizvane.mktcenterserviceimpl.common.utils;

import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.mktcenterservice.models.bo.ActivityBO;
import com.bizvane.mktcenterservice.models.bo.OrderModelBo;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.StringUtil;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Created by agan on 2018/7/30.
 */
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
        boolean falg = false;
        if (false == activityVO.getCommodityLimit()) {
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
                String productNos = vo.getProductNos();
                List<String> productNoList = Arrays.asList(productNos.split(","));
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
        boolean falg = false;
        if (false == activityVO.getStoreLimit()) {
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
        boolean falg = false;
        if (false == activityVO.getStoreLimit() && false==bo.getActivityVO().getStoreLimit()) {
            falg = true;
        } else {
            //判断是白名单
            if (bo.getActivityVO().getStoreLimitType()==2) {
                //前端传过来的
                String storeLimitList = bo.getActivityVO().getStoreLimitList();
                List<String> result = Arrays.asList(storeLimitList.split(","));
                //表里查出来的
                String stroeList = activityVO.getStoreLimitList();
                List<String> productNoList = Arrays.asList(stroeList.split(","));
                productNoList.retainAll(result);
                boolean fa=productNoList.size()>0;
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
    public  static Boolean implementActivitCheck(MemberInfoModel vo, ActivityVO activityVO) {
        boolean falg = false;
        if (false == activityVO.getStoreLimit()) {
            falg = true;
        } else {
            //判断是白名单
            if (activityVO.getStoreLimitType()==2) {
                //表里查出来的
                String stroeList = activityVO.getStoreLimitList();
                List<String> productNoList = Arrays.asList(stroeList.split(","));
                falg=productNoList.contains(vo.getOpenCardStoreId());

            }
            //判断是否是白名单

        }
        return falg;
    }
}
