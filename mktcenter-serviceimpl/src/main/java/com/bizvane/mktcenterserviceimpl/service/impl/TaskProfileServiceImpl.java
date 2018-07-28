package com.bizvane.mktcenterserviceimpl.service.impl;

import com.bizvane.centerstageservice.models.po.SysCheckConfigPo;
import com.bizvane.centerstageservice.models.vo.SysCheckConfigVo;
import com.bizvane.centerstageservice.rpc.SysCheckConfigServiceRpc;
import com.bizvane.mktcenterservice.interfaces.TaskProfileService;
import com.bizvane.mktcenterservice.models.bo.TaskBO;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.models.vo.TaskVO;
import com.bizvane.mktcenterserviceimpl.common.enums.TaskTypeEnum;
import com.bizvane.mktcenterserviceimpl.mappers.MktTaskProfilePOMapper;
import com.bizvane.utils.commonutils.PageForm;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * @author chen.li
 * @date on 2018/7/16 14:13
 * @description 完善资料任务
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@Service
public class TaskProfileServiceImpl implements TaskProfileService {

    @Autowired
    private MktTaskProfilePOMapper mktTaskProfilePOMapper;

    @Autowired
    private SysCheckConfigServiceRpc sysCheckConfigServiceRpc;

    /**
     * 获取任务列表
     * @param vo
     * @param pageForm
     * @return
     */
    @Override
    public ResponseData<TaskVO> getTaskList(TaskVO vo, PageForm pageForm) {
        ResponseData responseData = new ResponseData();
        PageHelper.startPage(pageForm.getPageNumber(),pageForm.getPageSize());
        List<TaskVO> activityRegisterList = mktTaskProfilePOMapper.getTaskList(vo);
        PageInfo<TaskVO> pageInfo = new PageInfo<>(activityRegisterList);
        responseData.setData(pageInfo);
        return responseData;
    }

    /**
     * 新建完善资料任务
     * @param bo
     * @param stageUser
     * @return
     */
    @Override
    public ResponseData<Integer> addTask(TaskBO bo, SysAccountPO stageUser) {
        //创建任务对象
        TaskVO taskVO = bo.getTaskVO();
        //需要返回的对象
        ResponseData responseData = new ResponseData();
        //UUID生成任务编号 实际生成规则？？？？
        String taskCode = "TC"+UUID.randomUUID().toString().replaceAll("-","");
        //将任务编号添加进vo对象
        taskVO.setTaskCode(taskCode);
        //添加任务类型为完善资料
        taskVO.setTaskType(TaskTypeEnum.TASK_TYPE_PROFILE.getCode());



        //判断完善资料任务是否有重复
        TaskVO vo =  new TaskVO();
        //完善资料是针对品牌还是商家？conpany or brand？and此处的id到底是stageuser携带过来额还是taskvo携带来的
        vo.setSysCompanyId(stageUser.getSysCompanyId());
        vo.setTaskType(taskVO.getTaskType());//或者直接填完善资料的任务类型???
        List<TaskVO> taskVOList = mktTaskProfilePOMapper.getTaskList(vo);
        //集合不为空，则说明设置重复
        if (!CollectionUtils.isEmpty(taskVOList)){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage("完善资料任务已存在");
            return responseData;
        }


        //判断任务是否需要审核(未完成)

        SysCheckConfigVo sysCheckConfigVo = new SysCheckConfigVo();
        sysCheckConfigVo.setSysBrandId(taskVO.getSysBrandId());
        sysCheckConfigVo.setFunctionCode(taskVO.);
        ResponseData<List<SysCheckConfigVo>> rls = sysCheckConfigServiceRpc.getCheckConfigListAll(sysCheckConfigVo);
        List<SysCheckConfigVo> sysCheckConfigVoList = rls.getData();
        int i = 0;

        if(!CollectionUtils.isEmpty(sysCheckConfigVoList)){
            for(SysCheckConfigVo sysCheckConfigVo1:sysCheckConfigVoList){



            }

        }
        //如果需要审核









        return null;
    }

    @Override
    public ResponseData<Integer> executeTask(TaskVO vo) {
        return null;
    }

    @Override
    public ResponseData<Integer> updateTask(TaskBO bo, SysAccountPO stageUser) {
        return null;
    }

    @Override
    public ResponseData<List<TaskVO>> selectTaskById(Long mktTaskId) {
        return null;
    }
}
