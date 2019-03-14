package com.bizvane.couponservice.service.jobHandler;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.couponfacade.models.po.CouponDefinitionPOWithBLOBs;
import com.bizvane.couponfacade.models.vo.SendCouponBatchRequestVO;
import com.bizvane.couponservice.common.constants.SysResponseEnum;
import com.bizvane.couponservice.mappers.CouponDefinitionPOMapper;
import com.bizvane.couponservice.service.CouponManualService;
import com.bizvane.utils.responseinfo.ResponseData;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yunjie.tian on 2018/8/9.
 */
@JobHandler("sendBatchJobHandler")
@Component
public class SendBatchJobHandler extends IJobHandler{

    private static final Logger logger = LoggerFactory.getLogger(SendBatchJobHandler.class);


    @Autowired
    private CouponDefinitionPOMapper couponDefinitionPOMapper;
    @Autowired
    private CouponManualService couponManualService;

    /**
     * 执行批量发券定时任务
     * @param param
     * @return
     * @throws Exception
     */
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        logger.info("enter 666666666666666 SendBatchJobHandler execute method !");

        ReturnT<String> returnT = new ReturnT<>();

        if(StringUtils.isBlank(param)){
            returnT.setCode(SysResponseEnum.FAILED.getCode());
            returnT.setMsg(SysResponseEnum.SYSTEM_DATA_NOT_EMPTY.getMessage());
            return returnT;
        }

        SendCouponBatchRequestVO requestVO = JSONObject.parseObject(param, SendCouponBatchRequestVO.class);
        //获取劵定义id群
        String ids = requestVO.getCouponDefinitionIds();
        List<String> idList = new ArrayList<>();
        if (StringUtils.isNotBlank(ids)) {
            if (ids.contains(",")) {
                Collections.addAll(idList,ids.split(","));
            }else {
                idList.add(ids);
            }
        }

        List<CouponDefinitionPOWithBLOBs> definitionPOList = new ArrayList<>();

        for (String id:idList) {
            CouponDefinitionPOWithBLOBs definitionPO = couponDefinitionPOMapper.selectByPrimaryKey(Long.parseLong(id));

            if(null == definitionPO){
                continue;
            }
            definitionPOList.add(definitionPO);
        }
        //查询券定义数据
        /*CouponDefinitionPOWithBLOBs definitionPO = couponDefinitionPOMapper.selectByPrimaryKey(requestVO.getCouponDefinitionId());

        if(null == definitionPO){
            returnT.setCode(SysResponseEnum.FAILED.getCode());
            returnT.setMsg(SysResponseEnum.OPERATE_FAILED_DATA_NOT_EXISTS.getMessage());
            return returnT;
        }*/

        //ResponseData<String> responseData = couponManualService.sendCouponByUseChannel(definitionPO,requestVO);

        ResponseData<String> responseData = couponManualService.sendNewCouponByUseChannel(definitionPOList,requestVO);


        if(SysResponseEnum.SUCCESS.getCode() != responseData.getCode()){

            returnT.setCode(SysResponseEnum.FAILED.getCode());
            returnT.setMsg(responseData.getMessage());
            return returnT;

        }

        returnT.setCode(SysResponseEnum.SUCCESS.getCode());
        returnT.setMsg(SysResponseEnum.SUCCESS.getMessage());
        return returnT;
    }

}
