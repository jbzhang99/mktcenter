package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.mktcenterservice.interfaces.TaskRecordService;
import com.bizvane.mktcenterservice.models.bo.TotalStatisticsBO;
import com.bizvane.mktcenterservice.models.po.MktTaskRecordPO;
import com.bizvane.mktcenterservice.models.po.MktTaskRecordPOExample;
import com.bizvane.mktcenterservice.models.vo.DayTaskRecordVo;
import com.bizvane.mktcenterservice.models.vo.MktTaskRecordVO;
import com.bizvane.mktcenterservice.models.vo.TaskAnalysisVo;
import com.bizvane.mktcenterserviceimpl.common.constants.TaskConstants;
import com.bizvane.mktcenterserviceimpl.common.utils.TimeUtils;
import com.bizvane.mktcenterserviceimpl.mappers.MktTaskRecordPOMapper;
import com.bizvane.utils.tokens.SysAccountPO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2018/8/6 23:43
 */
@Service
public class TaskRecordServiceImpl implements TaskRecordService {

    @Autowired
    private MktTaskRecordPOMapper mktTaskRecordPOMapper;

    /**
     * 添加记录
     * @return
     */
    @Override
    public Integer addTaskRecord(MktTaskRecordPO po) {
        return  mktTaskRecordPOMapper.insertSelective(po);


    }

    /**
     * 修改记录
     */
    @Override
    public Integer updateTaskRecord(MktTaskRecordPO po) {
        return  mktTaskRecordPOMapper.updateByPrimaryKeySelective(po);

    }

    /**
     * 获取会员参与某一活动的总金额和总次数
     * @param vo
     * @return
     */
    @Override
    public TotalStatisticsBO getTotalStatistics(MktTaskRecordVO vo) {
        TotalStatisticsBO bo= null;
        List<TotalStatisticsBO> totalStatistics = mktTaskRecordPOMapper.getTotalStatistics(vo);
        if (CollectionUtils.isNotEmpty(totalStatistics)){
            bo= totalStatistics.get(0);
        }
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
