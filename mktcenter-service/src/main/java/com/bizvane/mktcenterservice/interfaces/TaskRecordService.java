package com.bizvane.mktcenterservice.interfaces;

import com.bizvane.mktcenterservice.models.bo.TotalStatisticsBO;
import com.bizvane.mktcenterservice.models.po.MktTaskRecordPO;
import com.bizvane.mktcenterservice.models.vo.DayTaskRecordVo;
import com.bizvane.mktcenterservice.models.vo.MktTaskRecordVO;
import com.bizvane.mktcenterservice.models.vo.TaskAnalysisVo;
import com.bizvane.utils.tokens.SysAccountPO;

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
    public Integer addTaskRecord(MktTaskRecordPO vo);

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
