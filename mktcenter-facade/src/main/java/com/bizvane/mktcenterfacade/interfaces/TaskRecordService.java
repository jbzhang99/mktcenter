package com.bizvane.mktcenterfacade.interfaces;

import com.bizvane.mktcenterfacade.models.po.MktTaskRecordPO;
import com.bizvane.mktcenterfacade.models.vo.DayTaskRecordVo;
import com.bizvane.mktcenterfacade.models.vo.MktTaskRecordVO;
import com.bizvane.mktcenterfacade.models.vo.TaskAnalysisVo;
import com.bizvane.mktcenterfacade.models.bo.TotalStatisticsBO;

import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2018/8/6 23:44
 */
public interface TaskRecordService {
    /**
     * 添加记录
     * @param vo
     * @return
     */
    public Long addTaskRecord(MktTaskRecordPO vo);

    /**
     * 修改记录
     * @return
     */
    public Integer updateTaskRecord(MktTaskRecordPO po);

    /**
     * 查询
     * @param vo
     * @return
     */
    public TotalStatisticsBO getTotalStatistics(MktTaskRecordVO vo) ;

    /**
     * 判断是否获取过奖励
     * @param vo
     * @return
     */
    public Boolean getIsOrNoAward(MktTaskRecordVO vo);

    /**
     * 效果分析
     * @param vo
     * @return
     */
    List<DayTaskRecordVo> getAnalysisResult(TaskAnalysisVo vo);
}
