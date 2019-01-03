package com.bizvane.mktcenterserviceimpl.service.impl;

import com.alibaba.fastjson.JSON;
import com.bizvane.mktcenterservice.interfaces.TaskRecordService;
import com.bizvane.mktcenterservice.models.bo.TotalStatisticsBO;
import com.bizvane.mktcenterservice.models.po.MktTaskRecordPO;
import com.bizvane.mktcenterservice.models.po.MktTaskRecordPOExample;
import com.bizvane.mktcenterservice.models.vo.DayTaskRecordVo;
import com.bizvane.mktcenterservice.models.vo.MktTaskRecordVO;
import com.bizvane.mktcenterservice.models.vo.TaskAnalysisVo;
import com.bizvane.mktcenterserviceimpl.common.constants.TaskConstants;
import com.bizvane.mktcenterserviceimpl.mappers.MktTaskCountPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktTaskRecordPOMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2018/8/6 23:43
 */
@Slf4j
@Service
public class TaskRecordServiceImpl implements TaskRecordService {

    @Autowired
    private MktTaskRecordPOMapper mktTaskRecordPOMapper;
    
    @Autowired
    private MktTaskCountPOMapper mktTaskCountPOMapper;

    /**
     * 添加记录
     * @return
     */
    @Override
    public Long addTaskRecord(MktTaskRecordPO po) {
        int i = mktTaskRecordPOMapper.insertSelective(po);
        
        BigDecimal consumeAmount = po.getConsumeAmount() == null ? BigDecimal.ZERO : po.getConsumeAmount();
        Integer couponNum = po.getCouponNum() == null ? 0 : po.getCouponNum();
        Integer points = po.getPoints() == null ? 0 : po.getPoints();
        Integer shareNum = po.getShareNum() == null ? 0 : po.getShareNum();
        
        mktTaskCountPOMapper.updateSum(po.getTaskId(), 1, consumeAmount, 0, 0, 1);
        return  po.getMktTaskRecordId();
    }

    /**
     * 修改记录
     */
    @Override
    public Integer updateTaskRecord(MktTaskRecordPO po) {
      
      
      BigDecimal consumeAmount = po.getConsumeAmount() == null ? BigDecimal.ZERO : po.getConsumeAmount();
      Integer couponNum = po.getCouponNum() == null ? 0 : po.getCouponNum();
      Integer points = po.getPoints() == null ? 0 : po.getPoints();
      Integer shareNum = po.getShareNum() == null ? 0 : po.getShareNum();
      
      mktTaskCountPOMapper.updateSum(po.getTaskId(), 0, BigDecimal.ZERO, couponNum, points, 0);
      
      return  mktTaskRecordPOMapper.updateByPrimaryKeySelective(po);

    }

    /**
     * 获取会员参与某一任务的总金额和总次数
     * @param vo
     * @return
     */
    @Override
    public TotalStatisticsBO getTotalStatistics(MktTaskRecordVO vo) {
        log.info("TotalStatisticsBO任务的总金额和总次数--参数--"+ JSON.toJSONString(vo));
        TotalStatisticsBO bo= null;
        List<TotalStatisticsBO> totalStatistics = mktTaskRecordPOMapper.getTotalStatistics(vo);
        if (CollectionUtils.isNotEmpty(totalStatistics)){
            bo= totalStatistics.get(0);
        }
        log.info("TotalStatisticsBO任务的总金额和总次数--出参--"+ JSON.toJSONString(bo));
        return  bo;
    }

    /**
     * 判断是否获取过奖励
     * @param vo
     * @return
     */
    @Override
    public Boolean getIsOrNoAward(MktTaskRecordVO vo){
        Long sysBrandId = vo.getSysBrandId();
        //任务类型：1完善资料，2分享任务，3邀请注册，4累计消费次数，5累计消费金额',
        Integer taskType = vo.getTaskType();
        Long taskId = vo.getTaskId();
        String memberCode = vo.getMemberCode();
        MktTaskRecordPOExample excamle = new MktTaskRecordPOExample();
        excamle.createCriteria().andSysBrandIdEqualTo(sysBrandId).andTaskIdEqualTo(taskId).andMemberCodeEqualTo(memberCode)
                .andRewardedEqualTo(Integer.valueOf(1)).andTaskTypeEqualTo(taskType).andValidEqualTo(Boolean.TRUE);
        List<MktTaskRecordPO> list= mktTaskRecordPOMapper.selectByExample(excamle);
        if (CollectionUtils.isNotEmpty(list) && list.get(0)!=null && TaskConstants.FIRST.equals(list.get(0).getRewarded()) ){
            return  Boolean.TRUE;
        }
        return  Boolean.FALSE;
    }
    /**
     * 分析效果分析
     * @param vo
     * @return
     */
    @Override
    public   List<DayTaskRecordVo> getAnalysisResult(TaskAnalysisVo vo){
        return   mktTaskRecordPOMapper.getAnalysisResult(vo);
    }
}
