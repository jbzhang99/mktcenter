package com.bizvane.couponservice.service.jobHandler;

import com.bizvane.couponfacade.models.vo.CouponSendAgainRequestVO;
import com.bizvane.couponservice.common.constants.SysResponseEnum;
import com.bizvane.couponfacade.constants.CouponConstants;
import com.bizvane.couponservice.mappers.CouponSendFailLogPOMapper;
import com.bizvane.couponservice.service.SendCouponService;
import com.bizvane.utils.responseinfo.ResponseData;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 补发券定时任务
 * Created by yunjie.tian on 2018/8/20.
 */
@JobHandler("sendBatchAgainJobHandler")
@Component
public class SendBatchAgainJobHandler extends IJobHandler{

    private static final Logger logger = LoggerFactory.getLogger(SendBatchAgainJobHandler.class);

    @Autowired
    private CouponSendFailLogPOMapper couponSendFailLogPOMapper;

    @Autowired
    private SendCouponService sendCouponService;

    /**
     * 发券失败重新发送
     * @param  sendNum 发送数量
     * @return
     * @throws Exception
     */
    @Override
    public ReturnT<String> execute(String sendNum) throws Exception {

        logger.info("enter SendBatchAgainJobHandler execute method:param:{}",sendNum);
        ReturnT<String> returnT = new ReturnT<>();

        if(StringUtils.isBlank(sendNum)){
            returnT.setCode(SysResponseEnum.FAILED.getCode());
            returnT.setMsg(SysResponseEnum.SYSTEM_DATA_NOT_EMPTY.getMessage());
            return returnT;
        }

        Byte tryZero = CouponConstants.COUPON_SEND_FAIL_TIMES_ZERO;//重试0次

        //根据数量查询要发的券
        List<CouponSendAgainRequestVO> againList = couponSendFailLogPOMapper.getListBySendNum(sendNum,tryZero);

        //单张发券批量补发
        List<CouponSendAgainRequestVO> singleBatchList = new ArrayList<>();
        //批量发券补发
        List<CouponSendAgainRequestVO> batchList = new ArrayList<>();

        for(int i=0;i<againList.size();i++){

            if(StringUtils.isBlank(againList.get(i).getBatchSendCode())){
                //如果没有批次信息-为单张发券批量补发
                singleBatchList.add(againList.get(i));
            }else{
                //如果有批次信息-为批量发券补发
                batchList.add(againList.get(i));
            }
        }

        //如果没有批次信息-为单张发券批量补发
        if(CollectionUtils.isNotEmpty(singleBatchList)){
            ResponseData<Integer> executeResult = sendCouponService.sendSingleBatchAgainExecute(singleBatchList);
        }

        //如果有批次信息-为批量发券补发
        if(CollectionUtils.isNotEmpty(batchList)) {
            ResponseData<Integer> executeResult = sendCouponService.sendBatchAgainExecute(batchList);
        }

        returnT.setCode(SysResponseEnum.SUCCESS.getCode());
        returnT.setMsg(SysResponseEnum.SUCCESS.getMessage());
        return returnT;
    }
}
