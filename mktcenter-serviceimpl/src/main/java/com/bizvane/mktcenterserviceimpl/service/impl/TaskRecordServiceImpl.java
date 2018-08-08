package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.mktcenterservice.interfaces.TaskRecordService;
import com.bizvane.mktcenterservice.models.po.MktTaskRecordPO;
import com.bizvane.mktcenterservice.models.po.MktTaskRecordPOExample;
import com.bizvane.mktcenterserviceimpl.common.utils.TimeUtils;
import com.bizvane.mktcenterserviceimpl.mappers.MktTaskRecordPOMapper;
import com.bizvane.utils.tokens.SysAccountPO;
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
     *
     * @param po
     * @param stageUser
     * @return
     */
    @Override
    public Integer addTaskRecord(MktTaskRecordPO po, SysAccountPO stageUser) {
        po.setCreateDate(TimeUtils.getNowTime());
        po.setCreateUserId(stageUser.getSysAccountId());
        po.setCreateUserName(stageUser.getName());
        return mktTaskRecordPOMapper.insertSelective(po);

    }

    /**
     * 修改记录
     */
    @Override
    public Integer updateTaskRecord(MktTaskRecordPO po, SysAccountPO stageUser) {
        po.setModifiedDate(TimeUtils.getNowTime());
        po.setModifiedUserId(stageUser.getSysAccountId());
        po.setModifiedUserName(stageUser.getName());
        return mktTaskRecordPOMapper.insertSelective(po);
    }

    @Override
    public  List<MktTaskRecordPO> getTaskRecord(MktTaskRecordPO po) {
        Long sysBrandId = po.getSysBrandId();
        //任务类型：1完善资料，2分享任务，3邀请注册，4累计消费次数，5累计消费金额',
        Integer taskType = po.getTaskType();
        Long taskId = po.getTaskId();
        String memberCode = po.getMemberCode();
         // 是否奖励过/奖励次数（当前只做到1次）
       // Integer rewarded = po.getRewarded();
        MktTaskRecordPOExample excamle = new MktTaskRecordPOExample();
        excamle.createCriteria().andSysBrandIdEqualTo(sysBrandId).andTaskIdEqualTo(taskId).andMemberCodeEqualTo(memberCode)
                                .andRewardedEqualTo(Integer.valueOf(0)).andValidEqualTo(Boolean.TRUE);

        List<MktTaskRecordPO> mktTaskRecordPOS = mktTaskRecordPOMapper.selectByExample(excamle);
        return mktTaskRecordPOS;
    }

}
