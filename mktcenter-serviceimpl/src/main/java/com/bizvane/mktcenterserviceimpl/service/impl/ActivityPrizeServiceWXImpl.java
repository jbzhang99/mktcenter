package com.bizvane.mktcenterserviceimpl.service.impl;

import com.alibaba.fastjson.JSON;
import com.bizvane.couponfacade.enums.SendTypeEnum;
import com.bizvane.couponfacade.models.vo.SendCouponSimpleRequestVO;
import com.bizvane.members.facade.enums.IntegralChangeTypeEnum;
import com.bizvane.members.facade.service.card.request.IntegralChangeRequestModel;
import com.bizvane.mktcenterservice.interfaces.ActivityPriceService;
import com.bizvane.mktcenterservice.interfaces.ActivityPrizeServiceWX;
import com.bizvane.mktcenterservice.models.bo.AwardBO;
import com.bizvane.mktcenterservice.models.bo.PrizeGradeSectionBO;
import com.bizvane.mktcenterservice.models.po.*;
import com.bizvane.mktcenterservice.models.vo.ActivityPriceBO;
import com.bizvane.mktcenterservice.models.vo.MktActivityPrizeRecordVO;
import com.bizvane.mktcenterserviceimpl.common.award.Award;
import com.bizvane.mktcenterserviceimpl.common.enums.ActivityStatusEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.ActivityTypeEnum;
import com.bizvane.mktcenterserviceimpl.common.enums.MktSmartTypeEnum;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPrizePOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPrizeRecordPOMapper;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by agan on 2018/12/19.
 */
@Service
@Slf4j
public class ActivityPrizeServiceWXImpl implements ActivityPrizeServiceWX {
    @Autowired
    private MktActivityPrizeRecordPOMapper mktActivityPrizeRecordPOMapper;

    @Autowired
    private MktActivityPOMapper mktActivityPOMapper;
    @Autowired
    private ActivityPriceService activityPriceService;
    @Autowired
    private MktActivityPrizePOMapper mktActivityPrizePOMapper;
    @Autowired
    private Award award;
    /**
     *获取小程序中奖纪录列表
     * @param po
     * @return
     */
    @Override
    public ResponseData<List<MktActivityPrizeRecordPO>> getPrizeRecordList(MktActivityPrizeRecordPO po) {
        log.info("查询大转盘中奖纪录列表开始参数为："+ JSON.toJSONString(po));
        ResponseData responseData = new ResponseData();
        MktActivityPrizeRecordPOExample example = new MktActivityPrizeRecordPOExample();
        BeanUtils.copyProperties(po,example);
        List<MktActivityPrizeRecordPO> lists = mktActivityPrizeRecordPOMapper.selectByExample(example);
        log.info("大转盘中奖纪录列表查询结束");
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        responseData.setData(lists);
        return responseData;
    }

    /**
     * 小程序抽奖活动获取规则
     * @param vo
     * @return
     */
    @Override
    public ResponseData<ActivityPriceBO> selectPrizeList(MktActivityPrizeRecordVO vo) {
        log.info("查询大转盘中奖规则开始参数为："+ JSON.toJSONString(vo));
        ResponseData responseData = new ResponseData();
        vo.setActivityStatus(ActivityStatusEnum.ACTIVITY_STATUS_EXECUTING.getCode());
        vo.setActivityType(ActivityTypeEnum.ACTIVITY_TYPE_PRIZE.getCode());
        List<MktActivityPO> activityList = mktActivityPOMapper.selectActivity(vo);
        return null;
    }

    /**
     * 执行抽奖活动
     * @param activePriceCode
     * @return
     */
    @Override
    public ResponseData<MktActivityPrizePO> executeActivityPrize(String activePriceCode) {
        ResponseData responseData = new ResponseData();
        log.info("执行抽奖活动开始参数为："+ activePriceCode);
        //查询抽奖活动规则
        ResponseData<ActivityPriceBO> activityPriceBOs =activityPriceService.selectActivityPrice(activePriceCode);
        ActivityPriceBO activityPriceBO = activityPriceBOs.getData();
        //定义一个list集合来放每个等级奖项小数位数来比较小数位数大小确定稀释多少倍
        List<Integer> str = new ArrayList<>();
        List<MktActivityPrizePO> activityPrizePOList = activityPriceBO.getActivityPrizePOList();
        //循环每个及等级奖项
        for (int i=0;i<activityPrizePOList.size();i++){
            if (null!=activityPrizePOList.get(i).getProbability()){
                String ba = activityPrizePOList.get(i).getProbability().toString();
                //判断是否含有小数点
                if (ba.contains(".")){
                    //如果有小数点 算出有几位小数
                    int xs =ba.substring(ba.lastIndexOf(".")+1,ba.length()).length();
                    //把几位小数放到str里
                    str.add(xs);
                }
            }
        }
        //得到最大的那个小数位
        int max =0;
        if (!CollectionUtils.isEmpty(str)){
            for (int i=0;i<str.size();i++){
                if (str.get(i)>max){
                    max =str.get(i);
                }
            }
        }
        PrizeGradeSectionBO prizeGradeSectionBO= new PrizeGradeSectionBO();
        //算出各个奖等级的区间
        calculationCount(activityPrizePOList, max, prizeGradeSectionBO,10);
        calculationCount(activityPrizePOList, max, prizeGradeSectionBO,20);
        calculationCount(activityPrizePOList, max, prizeGradeSectionBO,30);
        calculationCount(activityPrizePOList, max, prizeGradeSectionBO,40);

        //取随机数 计算随机数在哪个中奖区间
        int vv = (int) Math.pow(10,max);
        //取相应的随机数
        Random rand = new Random();
        int su = rand.nextInt(100*vv) + 1;
        //计算是否在特等奖区间
        int type =0;
        if (1<=su &&su<=prizeGradeSectionBO.getSuperCount()){
            type=10;
        }else
        //计算是否在一等奖区间
        if (prizeGradeSectionBO.getSuperCount()<su &&su<=prizeGradeSectionBO.getClassA()){
            type=20;
        }else
        //计算是否在二等奖等奖区间
        if (prizeGradeSectionBO.getClassA()<su && su<=prizeGradeSectionBO.getSecondLevel()){
            type=30;
        }else
        //计算是否在三等奖区间
        if (prizeGradeSectionBO.getSecondLevel()<su && su<=prizeGradeSectionBO.getLevelThree()){
            type=40;
        }else {
            //谢谢惠顾
            type=50;
        }

        //得到中奖规则
        MktActivityPrizePOExample example = new MktActivityPrizePOExample();
        example.createCriteria().andMktActivityIdEqualTo(activityPriceBO.getActivityPO().getMktActivityId()).andPrizeTypeEqualTo(type).andValidEqualTo(Boolean.TRUE);
        List<MktActivityPrizePO> mktActivityPrizePOS = mktActivityPrizePOMapper.selectByExample(example);
       //如果中奖了走if里面
        if (type!=50){
            //定义个变量 10 中奖 20没中奖
            int bl =10;
            //得到抽奖次数
            MktActivityPrizeRecordPOExample ex = new MktActivityPrizeRecordPOExample();
            ex.createCriteria().andMktActivityIdEqualTo(activityPriceBO.getActivityPO().getMktActivityId()).andValidEqualTo(Boolean.TRUE);
            Long count =  mktActivityPrizeRecordPOMapper.countByExample(ex);
            //得到抽到了奖品数量
            MktActivityPrizeRecordPOExample exe = new MktActivityPrizeRecordPOExample();
            exe.createCriteria().andMktActivityIdEqualTo(activityPriceBO.getActivityPO().getMktActivityId()).andIsWinPrizeEqualTo(Boolean.TRUE).andValidEqualTo(Boolean.TRUE);
            Long cou =  mktActivityPrizeRecordPOMapper.countByExample(exe);

            //得到一个会员抽中了几次
            MktActivityPrizeRecordPOExample examp = new MktActivityPrizeRecordPOExample();
            examp.createCriteria().andMktActivityIdEqualTo(activityPriceBO.getActivityPO().getMktActivityId()).andIsWinPrizeEqualTo(Boolean.TRUE).andValidEqualTo(Boolean.TRUE).andMemberCodeEqualTo("假的假的");
            Long exeCount =  mktActivityPrizeRecordPOMapper.countByExample(examp);
            //判断中奖前几次不中
            if (null!=mktActivityPrizePOS.get(0).getInvalidCount() && mktActivityPrizePOS.get(0).getInvalidCount()<= count){
                //没中奖
                type=50;
            }
            //判断奖品数量
            if(mktActivityPrizePOS.get(0).getPrizeSum()<=cou){
                //没中奖
                type=50;
            }
            //判断每个人限制
            if(null!=mktActivityPrizePOS.get(0).getUserLimitSum() && mktActivityPrizePOS.get(0).getUserLimitSum()<=exeCount){
                //没中奖
                type=50;
            }
            //判断验证完之后type是不是50 中奖没中奖
            if (type!=50){
                //判断送积分还是券
                if (mktActivityPrizePOS.get(0).getAwadType()==10){
                    AwardBO bo = new AwardBO();
                    //用这个实体类
                    IntegralChangeRequestModel integralChangeRequestModel =new IntegralChangeRequestModel();
                    integralChangeRequestModel.setSysCompanyId(activityPriceBO.getActivityPO().getSysCompanyId());
                    integralChangeRequestModel.setBrandId(activityPriceBO.getActivityPO().getSysBrandId());
                    // TODO: 2018/12/24  会员code
                    integralChangeRequestModel.setMemberCode("假的假的");
                    integralChangeRequestModel.setChangeBills(activityPriceBO.getActivityPO().getActivityCode());
                    integralChangeRequestModel.setChangeIntegral(mktActivityPrizePOS.get(0).getPrizePoints());
                    integralChangeRequestModel.setChangeType(IntegralChangeTypeEnum.INCOME.getCode());
                    // TODO: 2018/12/24  类型加上
                    integralChangeRequestModel.setBusinessType(com.bizvane.members.facade.enums.BusinessTypeEnum.ACTIVITY_TYPE_REGISGER.getCode());
                    integralChangeRequestModel.setChangeDate(new Date());
                    bo.setIntegralRecordModel(integralChangeRequestModel);
                    bo.setMktType(MktSmartTypeEnum.SMART_TYPE_INTEGRAL.getCode());
                    log.info("社交活动-社交活动合格开始增加积分+++++++++");
                    award.execute(bo);
                }else {
                    //奖励券
                    AwardBO awardBO = new AwardBO();
                    SendCouponSimpleRequestVO sendCouponSimpleRequestVO = new SendCouponSimpleRequestVO();
                    sendCouponSimpleRequestVO.setMemberCode("假的 假的");
                    sendCouponSimpleRequestVO.setCouponDefinitionId(mktActivityPrizePOS.get(0).getCouponDefinitionId());
                    sendCouponSimpleRequestVO.setSendBussienId(activityPriceBO.getActivityPO().getMktActivityId());
                    // TODO: 2018/12/24  加个类型
                    sendCouponSimpleRequestVO.setSendType(SendTypeEnum.SEND_COUPON_OPNE_CARD.getCode());
                    sendCouponSimpleRequestVO.setCompanyId(activityPriceBO.getActivityPO().getSysCompanyId());
                    sendCouponSimpleRequestVO.setBrandId(activityPriceBO.getActivityPO().getSysBrandId());
                    sendCouponSimpleRequestVO.setBusinessName(activityPriceBO.getActivityPO().getActivityName());
                    awardBO.setSendCouponSimpleRequestVO(sendCouponSimpleRequestVO);
                    awardBO.setMktType(MktSmartTypeEnum.SMART_TYPE_COUPON.getCode());
                    log.info("社交活动-社交活动合格开始增加券+++++++++");
                    award.execute(awardBO);
                }
                //把中奖的规则返回给前端
                responseData.setData(mktActivityPrizePOS.get(0));
            }else{
                MktActivityPrizePOExample el = new MktActivityPrizePOExample();
                example.createCriteria().andMktActivityIdEqualTo(activityPriceBO.getActivityPO().getMktActivityId()).andPrizeTypeEqualTo(type).andValidEqualTo(Boolean.TRUE);
                List<MktActivityPrizePO> mktActivityPrizelist = mktActivityPrizePOMapper.selectByExample(el);
                //谢谢惠顾判断是否会赠送积分
                if(mktActivityPrizePOS.get(0).getParticipatePrize()==true){
                    AwardBO bo = new AwardBO();
                    //用这个实体类
                    IntegralChangeRequestModel integralChangeRequestModel =new IntegralChangeRequestModel();
                    integralChangeRequestModel.setSysCompanyId(activityPriceBO.getActivityPO().getSysCompanyId());
                    integralChangeRequestModel.setBrandId(activityPriceBO.getActivityPO().getSysBrandId());
                    // TODO: 2018/12/24  会员code
                    integralChangeRequestModel.setMemberCode("假的假的");
                    integralChangeRequestModel.setChangeBills(activityPriceBO.getActivityPO().getActivityCode());
                    integralChangeRequestModel.setChangeIntegral(mktActivityPrizelist.get(0).getPrizePoints());
                    integralChangeRequestModel.setChangeType(IntegralChangeTypeEnum.INCOME.getCode());
                    // TODO: 2018/12/24  类型加上
                    integralChangeRequestModel.setBusinessType(com.bizvane.members.facade.enums.BusinessTypeEnum.ACTIVITY_TYPE_REGISGER.getCode());
                    integralChangeRequestModel.setChangeDate(new Date());
                    bo.setIntegralRecordModel(integralChangeRequestModel);
                    bo.setMktType(MktSmartTypeEnum.SMART_TYPE_INTEGRAL.getCode());
                    log.info("社交活动-社交活动谢谢惠顾赠送积分开始增加积分+++++++++");
                    award.execute(bo);
                }
                    responseData.setData(mktActivityPrizelist.get(0));
            }

        }else{
            //谢谢惠顾
            AwardBO bo = new AwardBO();
            //用这个实体类
            IntegralChangeRequestModel integralChangeRequestModel =new IntegralChangeRequestModel();
            integralChangeRequestModel.setSysCompanyId(activityPriceBO.getActivityPO().getSysCompanyId());
            integralChangeRequestModel.setBrandId(activityPriceBO.getActivityPO().getSysBrandId());
            // TODO: 2018/12/24  会员code
            integralChangeRequestModel.setMemberCode("假的假的");
            integralChangeRequestModel.setChangeBills(activityPriceBO.getActivityPO().getActivityCode());
            integralChangeRequestModel.setChangeIntegral(mktActivityPrizePOS.get(0).getPrizePoints());
            integralChangeRequestModel.setChangeType(IntegralChangeTypeEnum.INCOME.getCode());
            // TODO: 2018/12/24  类型加上
            integralChangeRequestModel.setBusinessType(com.bizvane.members.facade.enums.BusinessTypeEnum.ACTIVITY_TYPE_REGISGER.getCode());
            integralChangeRequestModel.setChangeDate(new Date());
            bo.setIntegralRecordModel(integralChangeRequestModel);
            bo.setMktType(MktSmartTypeEnum.SMART_TYPE_INTEGRAL.getCode());
            log.info("社交活动-社交活动谢谢惠顾赠送积分开始增加积分+++++++++");
            award.execute(bo);
            responseData.setData(mktActivityPrizePOS.get(0));
        }
        return responseData;
    }

    private void calculationCount(List<MktActivityPrizePO> activityPrizePOList, int max, PrizeGradeSectionBO prizeGradeSectionBO, int prizeTy) {
        for (int a=0;a<activityPrizePOList.size();a++){
            //计算特等奖
            if (activityPrizePOList.get(a).getPrizeType()==prizeTy){
                BigDecimal suc = activityPrizePOList.get(a).getProbability();
                //判断各等级奖项是否有小数位有的话需要稀释
                if (max==0){
                    //计算特等奖区间
                    if (prizeTy==10){
                        prizeGradeSectionBO.setSuperCount(suc.intValue());
                    }
                    //计算一等奖区间
                    if (prizeTy==20){
                        prizeGradeSectionBO.setClassA(prizeGradeSectionBO.getSuperCount()+suc.intValue());
                    }
                    //计算二等奖区间
                    if (prizeTy==30){
                        prizeGradeSectionBO.setSecondLevel(prizeGradeSectionBO.getClassA()+suc.intValue());
                    }
                    //计算三等奖区间
                    if (prizeTy==40){
                        prizeGradeSectionBO.setLevelThree(prizeGradeSectionBO.getSecondLevel()+suc.intValue());
                    }
                }else{
                    int gradeCount = getSectionCount(max, suc);
                    //计算特等奖区间
                    if (prizeTy==10){
                        prizeGradeSectionBO.setSuperCount(gradeCount);
                    }
                    //计算一等奖区间
                    if (prizeTy==20){
                        prizeGradeSectionBO.setClassA(prizeGradeSectionBO.getSuperCount()+gradeCount);
                    }
                    //计算二等奖区间
                    if (prizeTy==30){
                        prizeGradeSectionBO.setSecondLevel(prizeGradeSectionBO.getClassA()+gradeCount);
                    }
                    //计算三等奖区间
                    if (prizeTy==40){
                        prizeGradeSectionBO.setLevelThree(prizeGradeSectionBO.getSecondLevel()+gradeCount);
                    }
                }
            }
        }
    }

    //取得计算后的数据
    private int getSectionCount(int max, BigDecimal suc) {
        int vv = (int) Math.pow(10,max);
        return suc.multiply(BigDecimal.valueOf(vv)).intValue();
    }

    public static void main(String[] args){
        //计算小数点后有几位小数
        BigDecimal numStr = new BigDecimal("23.2");
        System.out.println("得到的数据numStr"+numStr);
        String big =numStr.toString();
        //得到小数点位数
        int s =big.substring(big.lastIndexOf(".")+1,big.length()).length();
        System.out.println("一共几位小数"+s);

        //得到一个算概率的正整数
        int vv = (int) Math.pow(10,s);
        int yy =numStr.multiply(BigDecimal.valueOf(vv)).intValue();
        System.out.println("得到的数据"+yy);

        //取相应的随机数
        Random rand = new Random();
        int a = rand.nextInt(100*vv) + 1;
        System.out.println("取到的随机数"+a);
        //判断这个数字在不在区间内 在的话就中奖了
        if (1<=a && a<=yy){
            System.out.println("抽奖抽中了啦啦啦啦啦啦啦");
        }
        //判断是否是整数
        if (big.contains(".")){
            System.out.println(true);
        }

        /////////////////
        List<Integer> str = new ArrayList<>();
        str.add(2);
        str.add(7);
        str.add(27);
        str.add(78);
        int max =0;
        for (int i=0;i<str.size();i++){
            if (str.get(i)>max){
                max =str.get(i);
            }
        }
        System.out.println("得到最大数据是+=="+max);

        int cc = (int) Math.pow(10,0);
        System.out.println("10的0次方+=="+cc);

        int b =5;
        Long ss =7L;
        if (ss>b){
            System.out.println("我来试一试");
        }
    }
}
