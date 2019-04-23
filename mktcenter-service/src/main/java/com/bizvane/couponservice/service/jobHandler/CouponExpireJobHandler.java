package com.bizvane.couponservice.service.jobHandler;

import com.bizvane.couponfacade.models.po.CouponEntityPO;
import com.bizvane.couponfacade.models.po.CouponEntityPOExample;
import com.bizvane.couponfacade.models.po.SysCodeValuePO;
import com.bizvane.couponfacade.models.po.SysCodeValuePOExample;
import com.bizvane.couponservice.common.constants.SysResponseEnum;
import com.bizvane.couponfacade.constants.CouponConstants;
import com.bizvane.couponservice.mappers.CouponEntityPOMapper;
import com.bizvane.couponservice.mappers.CouponSysCodeValuePOMapper;
import com.bizvane.members.facade.service.api.WxChannelInfoApiService;
import com.bizvane.members.facade.vo.WxChannelAndMemberVo;
import com.bizvane.members.facade.vo.WxChannelInfoVo;
import com.bizvane.messagefacade.interfaces.WechatCouponServiceFeign;
import com.bizvane.messagefacade.models.vo.CouponMessageVO;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.wechatfacade.interfaces.WxPublicServiceFeign;
import com.bizvane.wechatfacade.models.po.WxPublicPO;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
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
 * 券到期提醒
 * Created by yunjie.tian on 2018/8/10.
 */
@JobHandler("couponExpireJobHandler")
@Component
public class CouponExpireJobHandler extends IJobHandler{

    private static final Logger logger = LoggerFactory.getLogger(CouponExpireJobHandler.class);

    @Autowired
    private CouponEntityPOMapper couponEntityPOMapper;


    @Autowired
    private WechatCouponServiceFeign wechatCouponServiceFeign;

    @Autowired
    private CouponSysCodeValuePOMapper sysCodeValuePOMapper;

    @Autowired
    private WxChannelInfoApiService wxChannelInfoApiService;

    @Autowired
    private WxPublicServiceFeign wxPublicServiceFeign;


    @Override
    public ReturnT<String> execute(String nullStr) throws Exception {
        logger.info("enter CouponExpireJobHandler execute method");

        ReturnT<String> returnT = new ReturnT<>();

        SysCodeValuePOExample codeExample = new SysCodeValuePOExample();
        codeExample.createCriteria().andCodeTypeEqualTo(CouponConstants.COUPON_EXPIRE_CODE_TYPE);
        List<SysCodeValuePO> sysCodeValuePOList = sysCodeValuePOMapper.selectByExample(codeExample);

        String expireDay = sysCodeValuePOList.get(0).getItemCode();

        if(StringUtils.isBlank(expireDay)){
            returnT.setMsg(SysResponseEnum.SYSTEM_DATA_NOT_EMPTY.getMessage());
            return returnT;
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,Integer.parseInt(expireDay));
        Date date = format.parse(format.format(calendar.getTime()));

        CouponEntityPOExample entityPOExample = new CouponEntityPOExample();
        entityPOExample.createCriteria().andValidDateEndEqualTo(date)
                .andValidEqualTo(CouponConstants.TABLE_VALID_EFFECTIVE);

        List<CouponEntityPO> entityPOList = couponEntityPOMapper.selectByExample(entityPOExample);


        for(int i=0;i<entityPOList.size();i++) {

            CouponEntityPO couponEntityPO = couponEntityPOMapper.selectByPrimaryKey(entityPOList.get(i).getCouponEntityId());

            CouponMessageVO messageVO = new CouponMessageVO();
            messageVO.setMemberCode(couponEntityPO.getMemberCode());
            messageVO.setCouponCode(couponEntityPO.getCouponCode());
            messageVO.setCouponName(couponEntityPO.getCouponName());
            messageVO.setPreferentialType(couponEntityPO.getPreferentialType() + "");
            messageVO.setDenomination(couponEntityPO.getMoney() + "");
            messageVO.setValidDateStart(couponEntityPO.getValidDateStart());
            messageVO.setValidDateEnd(couponEntityPO.getValidDateEnd());

//            //查询会员信息
//            WxChannelInfoVo channelVO = new WxChannelInfoVo();
//            channelVO.setMemberCode(entityPOList.get(i).getMemberCode());
//            ResponseData<WxChannelInfoVo> channelResult = wxChannelInfoApiService.getWxChannelInfo(channelVO);
            //查询会员信息 新接口
            WxChannelInfoVo channelVO = new WxChannelInfoVo();
            channelVO.setMemberCode(entityPOList.get(i).getMemberCode());
            channelVO.setBrandId(entityPOList.get(i).getSysBrandId());
            channelVO.setMiniProgram(1);
            ResponseData<WxChannelAndMemberVo> channelResult = wxChannelInfoApiService.getWxChannelInfoAndMemberInfo(channelVO);
            if (channelResult.getData() != null) {
                WxChannelInfoVo channelInfoVo = channelResult.getData().getWxChannelInfoVo();
                messageVO.setMemberName(channelInfoVo.getName());
                messageVO.setMemberPhone(channelInfoVo.getPhone());
                messageVO.setSendWxmember(channelInfoVo.getFocus()+"");
                messageVO.setSysCompanyId(channelInfoVo.getSysCompanyId());
            }
            

    

            ResponseData<WxPublicPO> publicPO = wxPublicServiceFeign.getWxPublicBySysBrandId(couponEntityPO.getSysBrandId());
            if(publicPO.getData() != null){
                messageVO.setNickName(publicPO.getData().getNickName());
            }
//不用的旧接口
            ResponseData<String> entityResult = wechatCouponServiceFeign.couponExpire(messageVO);

        }

        return returnT;
    }


}
