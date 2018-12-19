package com.bizvane.mktcenterserviceimpl.service.impl;

import com.alibaba.fastjson.JSON;
import com.bizvane.mktcenterservice.interfaces.ActivityPrizeServiceWX;
import com.bizvane.mktcenterservice.models.po.MktActivityPrizeRecordPO;
import com.bizvane.mktcenterservice.models.po.MktActivityPrizeRecordPOExample;
import com.bizvane.mktcenterserviceimpl.mappers.MktActivityPrizeRecordPOMapper;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by agan on 2018/12/19.
 */
@Service
@Slf4j
public class ActivityPrizeServiceWXImpl implements ActivityPrizeServiceWX {
    @Autowired
    private MktActivityPrizeRecordPOMapper mktActivityPrizeRecordPOMapper;
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
}
