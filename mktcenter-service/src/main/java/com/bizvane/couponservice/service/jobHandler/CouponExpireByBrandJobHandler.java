package com.bizvane.couponservice.service.jobHandler;

import com.bizvane.couponfacade.models.vo.CouponEntityVO;
import com.bizvane.couponfacade.constants.CouponConstants;
import com.bizvane.couponservice.mappers.CouponEntityPOMapper;
import com.bizvane.members.facade.service.api.WxChannelInfoApiService;
import com.bizvane.members.facade.vo.WxChannelAndMemberVo;
import com.bizvane.members.facade.vo.WxChannelInfoVo;
import com.bizvane.messagefacade.interfaces.MsgCouponTimeServiceFeign;
import com.bizvane.messagefacade.interfaces.WechatCouponServiceFeign;
import com.bizvane.messagefacade.models.po.MsgCoupontimePO;
import com.bizvane.messagefacade.models.vo.CouponMessageVO;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.wechatfacade.interfaces.WxPublicServiceFeign;
import com.bizvane.wechatfacade.models.po.WxPublicPO;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 券到期提醒(根据品牌)
 * Created by yunjie.tian on 2018/9/5.
 */
@JobHandler("couponExpireByBrandJobHandler")
@Component
public class CouponExpireByBrandJobHandler extends IJobHandler {


    private static final Logger logger = LoggerFactory.getLogger(CouponExpireByBrandJobHandler.class);

    @Autowired
    private MsgCouponTimeServiceFeign msgCouponTimeServiceFeign;

    @Autowired
    private CouponEntityPOMapper couponEntityPOMapper;
    @Autowired
    private WxChannelInfoApiService wxChannelInfoApiService;

    @Autowired
    private WechatCouponServiceFeign wechatCouponServiceFeign;

    @Autowired
    private WxPublicServiceFeign wxPublicServiceFeign;


    @Override
    public ReturnT<String> execute(String nullStr) throws Exception {
        logger.info("enter CouponExpireByBrandJobHandler execute method !");

        ReturnT<String> returnT = new ReturnT<>();

        ResponseData<List<MsgCoupontimePO>> couponTimeResult = msgCouponTimeServiceFeign.getCouponTimeList();

        if(CollectionUtils.isNotEmpty(couponTimeResult.getData())){

            for(MsgCoupontimePO coupon : couponTimeResult.getData()){

                String expireDay = coupon.getDays()+"";

                if(StringUtils.isBlank(expireDay)){
                    continue;
                }

                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date());
                calendar.add(Calendar.DATE,Integer.parseInt(expireDay));
                Date date = format.parse(format.format(calendar.getTime()));
                
                calendar.add(Calendar.DATE, 1);
                Date  dateEnd = format.parse(format.format(calendar.getTime()));
                logger.info("enter CouponExpireByBrandJobHandler execute method calendar!"+date.getTime()+"dateEnd"+dateEnd.getTime());
                List<CouponEntityVO> entityPOLIst = couponEntityPOMapper.findWxCouponList(date,dateEnd,coupon.getSysBrandId(),CouponConstants.COUPON_STATUS_UNUSED);

                //微信公众号信息
                ResponseData<WxPublicPO> publicPO = wxPublicServiceFeign.getWxPublicBySysBrandId(coupon.getSysBrandId());

                if(CollectionUtils.isNotEmpty(entityPOLIst)) {

                    for (int i = 0; i < entityPOLIst.size(); i++) {

                        CouponEntityVO entityVO = entityPOLIst.get(i);

                        //发送微信
                        CouponMessageVO messageVO = new CouponMessageVO();
                        messageVO.setMemberCode(entityVO.getMemberCode());
                        messageVO.setCouponCode(entityVO.getCouponCode());
                        messageVO.setCouponName(entityVO.getCouponName());
                        messageVO.setPreferentialType(entityVO.getPreferentialType() + "");
                        //填入折扣或金额
                        if(entityVO.getPreferentialType().equals(CouponConstants.PREFERENTIAL_TYPE_MONEY)){
                            messageVO.setDenomination(entityVO.getMoney()+"");
                        }else if(entityVO.getPreferentialType().equals(CouponConstants.PREFERENTIAL_TYPE_DISCOUNT)){
                            messageVO.setDenomination(entityVO.getDiscount()+"");
                        }
                        messageVO.setUseTime(entityVO.getUseTime());
                        messageVO.setValidDateStart(entityVO.getValidDateStart());
                        messageVO.setValidDateEnd(entityVO.getValidDateEnd());
                        messageVO.setMemberName(entityVO.getName());
                        messageVO.setSysBrandId(entityVO.getSysBrandId());

                        //查询会员信息
                        WxChannelInfoVo channelVO = new WxChannelInfoVo();
                        channelVO.setMemberCode(entityVO.getMemberCode());
                        channelVO.setBrandId(entityVO.getSysBrandId());
                        channelVO.setMiniProgram(1);
                        ResponseData<WxChannelAndMemberVo> channelResult = wxChannelInfoApiService.getWxChannelInfoAndMemberInfo(channelVO);

                        if (channelResult.getData() != null) {
                            WxChannelInfoVo channelInfoVo = channelResult.getData().getWxChannelInfoVo();
                            messageVO.setMemberName(channelInfoVo.getName());
                            messageVO.setMemberPhone(channelInfoVo.getPhone());
                            messageVO.setSendWxmember(channelInfoVo.getFocus()+"");
                            messageVO.setSysCompanyId(channelInfoVo.getSysCompanyId());
                        }
                        if(publicPO.getData() != null){
                            messageVO.setNickName(publicPO.getData().getNickName());
                        }

                        ResponseData<String> entityResult = wechatCouponServiceFeign.couponExpire(messageVO);


                    }





                }


            }

        }



        return returnT;
    }

}
