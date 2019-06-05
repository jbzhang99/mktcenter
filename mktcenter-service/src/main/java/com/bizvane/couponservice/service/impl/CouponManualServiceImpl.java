package com.bizvane.couponservice.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.centerstageservice.models.po.SysAccountPo;
import com.bizvane.centerstageservice.models.po.SysCheckPo;
import com.bizvane.centerstageservice.rpc.SysCheckServiceRpc;
import com.bizvane.couponfacade.enums.CouponEnum;
import com.bizvane.couponfacade.enums.CouponManualTaskStatusEnum;
import com.bizvane.couponfacade.enums.SendTypeEnum;
import com.bizvane.couponfacade.models.po.CouponBatchSendRecordPO;
import com.bizvane.couponfacade.models.po.CouponDefinitionPOWithBLOBs;
import com.bizvane.couponfacade.models.po.CouponManualPO;
import com.bizvane.couponfacade.models.vo.CouponDetailResponseVO;
import com.bizvane.couponfacade.models.vo.CouponManualVO;
import com.bizvane.couponfacade.models.vo.CouponSendCheckRequestVO;
import com.bizvane.couponfacade.models.vo.SendCouponBatchRequestVO;
import com.bizvane.couponfacade.utils.PageFormUtil;
import com.bizvane.couponfacade.utils.TimeUtils;
import com.bizvane.couponservice.common.constants.SysResponseEnum;
import com.bizvane.couponfacade.constants.CouponConstants;
import com.bizvane.couponservice.common.utils.BusinessCodeUtil;
import com.bizvane.couponservice.common.utils.CouponJobUtil;
import com.bizvane.couponservice.mappers.CouponDefinitionPOMapper;
import com.bizvane.couponservice.mappers.CouponManualPOMapper;
import com.bizvane.couponservice.service.CouponManualService;
import com.bizvane.couponservice.service.SendCouponService;
import com.bizvane.members.facade.es.vo.MembersInfoSearchVo;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.service.api.MemberInfoApiService;
import com.github.pagehelper.PageInfo;
import com.bizvane.utils.responseinfo.ResponseData;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class CouponManualServiceImpl implements CouponManualService {
    private static final Logger logger = LoggerFactory.getLogger(CouponManualServiceImpl.class);

    @Autowired
    private CouponManualPOMapper couponManualPOMapper;
    @Autowired
    private SysCheckServiceRpc sysCheckServiceRpc;
    @Autowired
    private CouponDefinitionPOMapper couponDefinitionPOMapper;
    @Autowired
    private CouponJobUtil jobUtil;
    @Autowired
    private MemberInfoApiService memberInfoApiService;
    @Autowired
    private SendCouponService sendCouponService;

    /**
     * 手动发券（列表）
     *
     * @param vo
     * @return
     */
    @Override
    public ResponseData<PageInfo<CouponManualVO>> getList(CouponManualVO vo, Long sysBrandId, PageFormUtil pageForm) {
        logger.info("enter CouponManualServiceImpl getList method");
        ResponseData<PageInfo<CouponManualVO>> responseData = new ResponseData<>();

        PageHelper.startPage(pageForm.getPageNumber(), pageForm.getPageSize());


        List<CouponManualVO> list = couponManualPOMapper.findCouponManualListByConditions(vo, sysBrandId);

        PageInfo<CouponManualVO> pageInfo = new PageInfo<>(list);

        responseData.setData(pageInfo);
        return responseData;
    }

    /**
     * 手动发券（列表）
     *
     * @param vo
     * @return
     */
    @Override
    public ResponseData<PageInfo<CouponManualVO>> getListRpc(CouponManualVO vo, PageFormUtil pageForm) {
        logger.info("enter CouponManualServiceImpl getList method");
        ResponseData<PageInfo<CouponManualVO>> responseData = new ResponseData<>();


        if (null == vo.getSysBrandId()) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.SYS_BRAND_ID_NOT_NULL.getMessage());
            return responseData;
        }
        PageHelper.startPage(pageForm.getPageNumber(), pageForm.getPageSize());


        List<CouponManualVO> list = couponManualPOMapper.findCouponManualListByConditions(vo, vo.getSysBrandId());

        PageInfo<CouponManualVO> pageInfo = new PageInfo<>(list);

        responseData.setData(pageInfo);
        return responseData;
    }

    /**
     * 指定时间发券
     */
    public void addSendCouponBatchJob(SendCouponBatchRequestVO requestVO) {

        //更新手动发券状态为-待执行
        updateTaskStatus(requestVO.getBusinessId(), CouponManualTaskStatusEnum.TASK_STATUS_CHECK_PASS.getCode().byteValue());

        //定时发券，调用定时任务
        jobUtil.addSendCouponBatchJob(requestVO);

    }


    /**
     * 根据id修改taskStatus
     *
     * @param po
     * @return
     */
    @Override
    public ResponseData<Integer> changeTask(CouponManualPO po) {
        logger.info("enter CouponManualServiceImpl changeTask method");
        ResponseData<Integer> responseData = new ResponseData<>();

        if (null == po.getCouponManualId()) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_MANUAL_ID_NOT_NULL.getMessage());
            return responseData;
        }
        if (null == po.getTaskStatus()) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.CHECK_STATUS_NOT_NULL.getMessage());
            return responseData;
        }

        po.setModifiedDate(TimeUtils.getNowTime());

        int count = couponManualPOMapper.updateByPrimaryKeySelective(po);

        responseData.setData(count);
        return responseData;
    }


    /**
     * 停止发送任务
     *
     * @param couponManualId
     * @return
     */
    @Override
    public ResponseData<Integer> suspendTask(Long couponManualId) {

        logger.info("enter CouponManualServiceImpl suspendTask method");
        ResponseData<Integer> responseData = new ResponseData<>();

        if (null == couponManualId) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_MANUAL_ID_NOT_NULL.getMessage());
            return responseData;
        }

        CouponManualPO manualPO = new CouponManualPO();

        manualPO.setCouponManualId(couponManualId);
        manualPO.setTaskStatus(CouponManualTaskStatusEnum.TASK_STATUS_CANCEL.getCode().byteValue());
        manualPO.setModifiedDate(TimeUtils.getNowTime());

        int count = couponManualPOMapper.updateByPrimaryKeySelective(manualPO);

        responseData.setData(count);
        return responseData;
    }

    /**
     * 更改审核状态
     *
     * @param param
     * @return
     */
    @Override
    public ResponseData<String> changeCheckStatus(CouponSendCheckRequestVO param) {

        logger.info("enter CouponManualServiceImpl changeCheckStatus method:param:{}",param);
        ResponseData<String> responseData = new ResponseData<>();

        if (null == param.getCouponManualId()) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_MANUAL_ID_NOT_NULL.getMessage());
            return responseData;
        }

        if(null == param.getTaskStatus()){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.TASK_STATUS_NOT_NULL.getMessage());
            return responseData;
        }

        //更改手动发券状态（审核通过或者不通过）
        updateTaskStatus(param.getCouponManualId(),param.getTaskStatus());

        //更改审核状态
        SysCheckPo checkPo = new SysCheckPo();
        checkPo.setBusinessId(param.getCouponManualId());
        checkPo.setFunctionCode(CouponConstants.COUPON_CHECK_FUNCTION_CODE);

        if (CouponManualTaskStatusEnum.TASK_STATUS_CHECK_PASS.getCode().byteValue() == param.getTaskStatus()) {
            checkPo.setCheckStatus(CouponConstants.CHECK_STATUS_CHECKED);
        }
        if (CouponManualTaskStatusEnum.TASK_STATUS_CHECK_UNPASS.getCode().byteValue() == param.getTaskStatus()) {
            checkPo.setCheckStatus(CouponConstants.CHECK_STATUS_REJECTED);
        }
        ResponseData<Integer> checkResult = sysCheckServiceRpc.updateCheck(checkPo);

        if (SysResponseEnum.SUCCESS.getCode() != checkResult.getCode()) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(checkResult.getMessage());
            return responseData;
        }

        //审核通过，发券
        if (CouponManualTaskStatusEnum.TASK_STATUS_CHECK_PASS.getCode().byteValue() == param.getTaskStatus()) {

            CouponManualPO couponManualPO = couponManualPOMapper.selectByPrimaryKey(param.getCouponManualId());
            String ids = couponManualPO.getCouponDefinitionId();
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
            //CouponDefinitionPOWithBLOBs definitionPO = couponDefinitionPOMapper.selectByPrimaryKey(Long.valueOf(couponManualPO.getCouponDefinitionId()));

            SendCouponBatchRequestVO requestVO = new SendCouponBatchRequestVO();

            //requestVO.setCouponDefinitionId(Long.valueOf(couponManualPO.getCouponDefinitionId()));
            requestVO.setCouponDefinitionIds(couponManualPO.getCouponDefinitionId());
            requestVO.setSendType(couponManualPO.getSendType());
            requestVO.setSendTime(couponManualPO.getSendTime());
            requestVO.setBusinessId(couponManualPO.getCouponManualId());
            requestVO.setBusinessName(couponManualPO.getTaskName());
            requestVO.setBusinessType(SendTypeEnum.SEND_COUPON_BATCH.getCode());
            //requestVO.setTotalNumber(param.getTotalNumber());


            sendNewCouponBySendType(definitionPOList,requestVO);

        }


        return responseData;
    }


    /**
     * 发券效果分析列表
     *
     * @param vo
     * @return
     */
    @Override
    public ResponseData<PageInfo> findResult(CouponManualVO vo, PageFormUtil pageForm, SysAccountPo accountPo) {
        logger.info("enter CouponManualServiceImpl findResult method");
        ResponseData<PageInfo> responseData = new ResponseData<>();

        vo.setSysBrandId(accountPo.getBrandId());

        PageHelper.startPage(pageForm.getPageNumber(), pageForm.getPageSize());

        List<CouponManualVO> po = couponManualPOMapper.findResult(vo);

        PageInfo pageInfo = new PageInfo(po);
        responseData.setData(pageInfo);
        return responseData;
    }

    /**
     * 发券效果分析合计
     *
     * @param vo
     * @return
     */
    @Override
    public ResponseData<CouponManualVO> findTotal(CouponManualVO vo, SysAccountPo accountPo) {
        logger.info("enter CouponManualServiceImpl findTotal method");
        ResponseData<CouponManualVO> responseData = new ResponseData<>();

        CouponManualVO manualVO = couponManualPOMapper.findTotal(vo,accountPo.getBrandId());
        responseData.setData(manualVO);
        return responseData;
    }

    /**
     * 根据手动发券id查询发券信息
     *
     * @param couponManualId
     * @return
     */
    @Override
    public ResponseData<CouponDetailResponseVO> findById(Long couponManualId) {
        logger.info("enter CouponManualServiceImpl findById method");
        ResponseData<CouponDetailResponseVO> responseData = new ResponseData<>();

        CouponDetailResponseVO detailVO = new CouponDetailResponseVO();

        if (null == couponManualId) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_MANUAL_ID_NOT_NULL.getMessage());
            return responseData;
        }
        CouponManualPO manualPO = couponManualPOMapper.selectByPrimaryKey(couponManualId);
        CouponDefinitionPOWithBLOBs definitionPO = couponDefinitionPOMapper.selectByPrimaryKey(Long.parseLong(manualPO.getCouponDefinitionId()));

        detailVO.setCouponDefinitionPO(definitionPO);
        detailVO.setCouponManualPO(manualPO);
        responseData.setData(detailVO);
        return responseData;
    }


    /**
     * 修改手动发券任务
     *
     * @param param
     * @return
     */
    @Override
    public ResponseData<String> changeManualTask(CouponManualVO param,MembersInfoSearchVo memberInfo,SysAccountPo accountPo) throws Exception {

        logger.info("enter CouponManualServiceImpl changeManualTask method");
        ResponseData<String> responseData = new ResponseData<>();

        if (null == param.getCouponManualId()) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_MANUAL_ID_NOT_NULL.getMessage());
            return responseData;
        }
        if (null == param.getCouponDefinitionId()) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_DEFINITION_ID_NOT_NULL.getMessage());
            return responseData;
        }
        if (StringUtils.isBlank(param.getMemberCodeList())) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_MEMBER_CODE_NOT_NULL.getMessage());
            return responseData;
        }

        if (null == param.getSendType()) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_SEND_TYPE_NOT_NULL.getMessage());
            return responseData;
        } else {
            if (CouponEnum.COUPON_MANUAL_SEND_TYPE_SOMEDAY.getCode().equals(param.getSendType()) &&
                    StringUtils.isBlank(param.getSendTimeStr())) {
                responseData.setCode(SysResponseEnum.FAILED.getCode());
                responseData.setMessage(SysResponseEnum.SEND_TIME_NOT_NULL.getMessage());
                return responseData;
            }
        }

        CouponDefinitionPOWithBLOBs definitionPO = couponDefinitionPOMapper.selectByPrimaryKey(Long.valueOf(param.getCouponDefinitionId()));

        if (null == definitionPO) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_NOT_EXIST.getMessage());
            return responseData;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        CouponManualPO manualUpdate = new CouponManualPO();

        //手动发券id
        manualUpdate.setCouponManualId(param.getCouponManualId());

        //更新手动发券信息
        if (CouponEnum.COUPON_MANUAL_SEND_TYPE_NOW.getCode().equals(param.getSendType() + "")) {
            //如果是立即发送
            manualUpdate.setSendTime(TimeUtils.getNowTime());

        } else {
            //如果是指定时间发送
            manualUpdate.setSendTime(dateFormat.parse(param.getSendTimeStr()));
        }
        manualUpdate.setSysCompanyId(definitionPO.getSysCompanyId());
        manualUpdate.setSysBrandId(definitionPO.getSysBrandId());
        manualUpdate.setBrandCode(definitionPO.getBrandCode());
        manualUpdate.setTaskName(param.getTaskName());
        manualUpdate.setCouponDefinitionId(param.getCouponDefinitionId());
        manualUpdate.setCouponDefinitionName(definitionPO.getCouponName());
        manualUpdate.setSendType(param.getSendType());
        manualUpdate.setDiscountMoney(definitionPO.getMoney());
        manualUpdate.setValid(CouponConstants.TABLE_VALID_EFFECTIVE);
        //将条件转为String格式，存入数据库
        memberInfo.setBrandId(accountPo.getBrandId());
        manualUpdate.setMemberCondition(JSONObject.toJSONString(memberInfo));
        manualUpdate.setTaskStatus(CouponManualTaskStatusEnum.TASK_STATUS_CHECK_WAIT.getCode().byteValue());
        manualUpdate.setMemberCount(param.getTotalNumber());
        manualUpdate.setModifiedDate(TimeUtils.getNowTime());
        manualUpdate.setModifiedUserId(accountPo.getSysAccountId());
        manualUpdate.setModifiedUserName(accountPo.getName());

        couponManualPOMapper.updateByPrimaryKeySelective(manualUpdate);

        CouponManualPO couponManualPO = couponManualPOMapper.selectByPrimaryKey(param.getCouponManualId());


        //更新审核记录
        SysCheckPo checkPo = new SysCheckPo();
        //审核id
        checkPo.setSysCheckId(param.getSysCheckId());

        checkPo.setSysBrandId(couponManualPO.getSysBrandId());
        checkPo.setFunctionCode(CouponConstants.COUPON_CHECK_FUNCTION_CODE);
        checkPo.setBusinessType(Integer.parseInt(SendTypeEnum.SEND_COUPON_BATCH.getCode()));
        checkPo.setBusinessId(couponManualPO.getCouponManualId());
        checkPo.setBusinessCode(couponManualPO.getCouponManualId() + "");
        checkPo.setBusinessName(couponManualPO.getTaskName());
        checkPo.setBizName(couponManualPO.getCouponDefinitionName());
        checkPo.setCheckStatus(CouponConstants.CHECK_STATUS_WAIT);
        checkPo.setCreateDate(TimeUtils.getNowTime());
        checkPo.setCreateUserId(accountPo.getSysAccountId());
        checkPo.setCreateUserName(accountPo.getName());
        checkPo.setValid(CouponConstants.TABLE_VALID_EFFECTIVE);

        sysCheckServiceRpc.updateCheck(checkPo);

        return responseData;

    }


    /**
     * 查询创建手动发券任务选中的会员
     *
     * @param couponManualId
     * @return
     */
    @Override
    public ResponseData<PageInfo<MemberInfoModel>> findManualMembers(Long couponManualId, String name, String phone, PageFormUtil pageForm) {

        ResponseData<PageInfo<MemberInfoModel>> responseData = new ResponseData();
        CouponManualPO manualPO = couponManualPOMapper.selectByPrimaryKey(couponManualId);
        ResponseData<PageInfo<MemberInfoModel>> memberInfoResult = memberInfoApiService.getMemberInfoByMembersCode(pageForm.getPageNumber(), pageForm.getPageSize(),
                name, phone, manualPO.getMemberCodeList());

        return memberInfoResult;
    }


    /**
     * 更新手动发券任务状态
     *
     * @param couponManualId
     * @param taskStatus
     */
    @Override
    public void updateTaskStatus(Long couponManualId, Byte taskStatus) {

        CouponManualPO updateManual = new CouponManualPO();
        updateManual.setCouponManualId(couponManualId);
        updateManual.setTaskStatus(taskStatus);
        couponManualPOMapper.updateByPrimaryKeySelective(updateManual);

    }


    /**
     * 判断发券类型时间发券
     *
     * @param definitionPO
     * @param requestVO
     * @return
     */
    public ResponseData<String> sendCouponBySendType(CouponDefinitionPOWithBLOBs definitionPO, SendCouponBatchRequestVO requestVO) {

        ResponseData<String> responseData = new ResponseData<>();

        if (CouponEnum.COUPON_MANUAL_SEND_TYPE_NOW.getCode().equals(requestVO.getSendType() + "")) {
            //立刻发券

            //判断发券渠道
            sendCouponByUseChannel(definitionPO,requestVO);

        } else if (CouponEnum.COUPON_MANUAL_SEND_TYPE_SOMEDAY.getCode().equals(requestVO.getSendType() + "")) {
            //指定时间发券

            //创建定时发券任务
            addSendCouponBatchJob(requestVO);

        } else {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.SEND_TYPE_NOT_EXISTS.getMessage());
            return responseData;
        }

        return responseData;
    }


    /**
     * 判断发券渠道-批量发券
     * @param definitionPO
     * @param requestVO
     * @return
     */
    @Override
    public ResponseData<String> sendCouponByUseChannel(CouponDefinitionPOWithBLOBs definitionPO, SendCouponBatchRequestVO requestVO){

        ResponseData<String> responseData = new ResponseData<>();

        //保存发券批次记录
        CouponBatchSendRecordPO batchPO = sendCouponService.saveCouponBatchRecord(definitionPO, requestVO);


        //判断发券渠道
        if (CouponConstants.USE_CHANNEL_ONLINE.equals(definitionPO.getUseChannel())) {

            //更新手动发券状态为-发送中
            updateTaskStatus(requestVO.getBusinessId(),CouponManualTaskStatusEnum.TASK_STATUS_SENDING.getCode().byteValue());

            //线上发券
            ResponseData<String> sendNowResult = sendCouponService.sendCouponBatchOnlineNow(definitionPO, requestVO, batchPO);

            if (SysResponseEnum.SUCCESS.getCode() != sendNowResult.getCode()) {
                responseData.setCode(SysResponseEnum.FAILED.getCode());
                responseData.setMessage(sendNowResult.getMessage());
                return sendNowResult;
            }

        } else if (CouponConstants.USE_CHANNEL_OFFLINE.equals(definitionPO.getUseChannel())) {

            //更新手动发券状态为-同步中
            updateTaskStatus(requestVO.getBusinessId(), CouponManualTaskStatusEnum.TASK_STATUS_SYNCING.getCode().byteValue());

            //线下发券
            ResponseData<String> offlineResult = sendCouponService.sendCouponBatchOfflineNow(definitionPO, requestVO,batchPO);

            if (SysResponseEnum.SUCCESS.getCode() != offlineResult.getCode()) {
                responseData.setCode(SysResponseEnum.FAILED.getCode());
                responseData.setMessage(offlineResult.getMessage());
                return offlineResult;
            }

        } else if (CouponConstants.USE_CHANNEL_ANY.equals(definitionPO.getUseChannel())) {


            //全渠道
            ResponseData<String> onlineResult = sendCouponService.sendCouponBatchAnyNow(definitionPO, requestVO,batchPO);

            if (SysResponseEnum.SUCCESS.getCode() != onlineResult.getCode()) {
                responseData.setCode(SysResponseEnum.FAILED.getCode());
                responseData.setMessage(onlineResult.getMessage());
                return onlineResult;
            }

        } else {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.USE_CHANNEL_NOT_EXISTS.getMessage());
            return responseData;
        }

        return responseData;
    }

    /**
     * 更新手动发券核销数量
     * @param manualId
     * @param profitMoney
     * @param discountMoney
     */
    @Transactional
    @Override
    public void updateCouponManualCount(Long useStoreId, Long manualId, BigDecimal profitMoney,BigDecimal discountMoney) {


        CouponManualPO manualPO = couponManualPOMapper.selectByPrimaryKey(manualId);

        //核销数量
        Integer cancelCount = manualPO.getCancelCount() == null ? 0 : manualPO.getCancelCount() + 1;
        //核销金额
        if(profitMoney != null) {
            profitMoney = (manualPO.getProfitMoney() == null ? BigDecimal.ZERO : manualPO.getProfitMoney()).add(profitMoney);
        }
        //优惠金额
        if(discountMoney != null) {
            discountMoney = manualPO.getDiscountMoney() == null ? BigDecimal.ZERO : manualPO.getDiscountMoney().add(discountMoney);
        }
        //参与门店
        if(useStoreId!=null) {
        	JSONObject useStores=new JSONObject();
        	if(StringUtils.isNoneEmpty(manualPO.getStoreids())) {
        		 useStores=JSONObject.parseObject(manualPO.getStoreids());
        	}
            useStores.put(useStoreId.toString(), useStoreId.toString());
            manualPO.setStoreids(useStores.toString());
        }

        manualPO.setCancelCount(cancelCount);
        manualPO.setProfitMoney(profitMoney);
        manualPO.setDiscountMoney(discountMoney);

        couponManualPOMapper.updateByPrimaryKeySelective(manualPO);

    }

    @Transactional
    @Override
    public ResponseData<String> addNewTask(CouponManualVO param, MembersInfoSearchVo memberInfo, SysAccountPo accountPo) throws Exception {
        logger.info("enter CouponManualServiceImpl addTask method:CouponManualVO:{},MembersInfoSearchVo:{}",JSONObject.toJSONString(param),JSONObject.toJSONString(memberInfo));
        ResponseData<String> responseData = new ResponseData<>();

        if (StringUtils.isBlank(param.getTaskName())) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.TASK_NAME_NOT_NULL.getMessage());
            return responseData;
        }
        if (StringUtils.isEmpty(param.getCouponDefinitionIds())) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_DEFINITION_ID_LIST_NOT_NULL.getMessage());
            return responseData;
        }else if (param.getCouponDefinitionIds().contains(",")){
            if (param.getCouponDefinitionIds().split(",").length > 20) {
                responseData.setCode(SysResponseEnum.FAILED.getCode());
                responseData.setMessage(SysResponseEnum.COUPON_DEFINITION_ID_LIST_MORE_20.getMessage());
                return responseData;
            }
        }

        if (null == param.getSendType()) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_SEND_TYPE_NOT_NULL.getMessage());
            return responseData;
        } else if (CouponEnum.COUPON_MANUAL_SEND_TYPE_SOMEDAY.getCode().equals(param.getSendType() + "") &&
                StringUtils.isBlank(param.getSendTimeStr())) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.SEND_TIME_NOT_NULL.getMessage());
            return responseData;
        }

        if(param.getTotalNumber() == 0){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.MEMBER_IS_NULL.getMessage());
            return responseData;
        }

        List<CouponDefinitionPOWithBLOBs> definitionPOList = new ArrayList<>();
        String definitionIdStr = "";
        String definitionNameStr = "";
        if (param.getCouponDefinitionIds().contains(",")) {
            String[] idArray = param.getCouponDefinitionIds().split(",");
            for (int i = 0;i<idArray.length;i++) {
                CouponDefinitionPOWithBLOBs definitionPO = couponDefinitionPOMapper.selectByPrimaryKey(Long.parseLong(idArray[i]));
                if (definitionPO == null) {
                    continue;
                }
                //判断是否过期,日期区间存在过期情况
                if(CouponConstants.VALID_TYPE__INTERVAL.equals(definitionPO.getValidType())){

                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date endDate = format.parse(format.format(definitionPO.getValidDateEnd()));
                    Date today = format.parse(format.format(new Date()));

                    logger.info("manual send coupon endDate:{},today:{}",JSONObject.toJSONString(endDate),JSONObject.toJSONString(today));

                    //判断券是否过期
                    if(endDate.getTime()<today.getTime()){
                        continue;
                    }
                }
                definitionPOList.add(definitionPO);
                if (i != idArray.length - 1) {
                    definitionIdStr += String.valueOf(idArray[i]) + ",";
                    definitionNameStr += definitionPO.getCouponName() + "、";
                }else {
                    definitionIdStr += String.valueOf(idArray[i]);
                    definitionNameStr += definitionPO.getCouponName();
                }

            }
        }else {
            CouponDefinitionPOWithBLOBs definitionPO = couponDefinitionPOMapper.selectByPrimaryKey(Long.parseLong(param.getCouponDefinitionIds()));
            if (definitionPO != null) {
                //判断是否过期,日期区间存在过期情况
                if(CouponConstants.VALID_TYPE__INTERVAL.equals(definitionPO.getValidType())){

                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date endDate = format.parse(format.format(definitionPO.getValidDateEnd()));
                    Date today = format.parse(format.format(new Date()));

                    logger.info("bbbbbbbbbbbbbbbbbbbbbbbbbbbb endDate:{},today:{}",JSONObject.toJSONString(endDate),JSONObject.toJSONString(today));

                    //判断券是否过期
                    if(endDate.getTime()<today.getTime()){
                        responseData.setCode(SysResponseEnum.FAILED.getCode());
                        responseData.setMessage(SysResponseEnum.COUPON_EXPIRED.getMessage());
                        return responseData;
                    }
                }
            }else {
                responseData.setCode(SysResponseEnum.FAILED.getCode());
                responseData.setMessage(SysResponseEnum.COUPON_NOT_EXIST.getMessage());
                return responseData;
            }
            definitionIdStr += param.getCouponDefinitionIds();
            definitionNameStr += definitionPO.getCouponName();
            definitionPOList.add(definitionPO);
        }

        //新增手动发券
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        CouponManualPO couponManualPO = new CouponManualPO();
        if (CouponEnum.COUPON_MANUAL_SEND_TYPE_NOW.getCode().equals(param.getSendType() + "")) {
            //如果是立即发送
            couponManualPO.setSendTime(TimeUtils.getNowTime());

        } else {
            //如果是指定时间发送
            couponManualPO.setSendTime(dateFormat.parse(param.getSendTimeStr()));
        }
        couponManualPO.setSysCompanyId(definitionPOList.get(0).getSysCompanyId());
        couponManualPO.setSysBrandId(definitionPOList.get(0).getSysBrandId());
        couponManualPO.setBrandCode(definitionPOList.get(0).getBrandCode());
        couponManualPO.setTaskName(param.getTaskName());
        // 将劵定义id集合转为String，用逗号隔开
        couponManualPO.setCouponDefinitionId(definitionIdStr);
        couponManualPO.setCouponDefinitionName(definitionNameStr);
        couponManualPO.setSendType(param.getSendType());
        //couponManualPO.setDiscountMoney(definitionPO.getMoney());
        couponManualPO.setCreateDate(TimeUtils.getNowTime());
        couponManualPO.setCreateUserId(accountPo.getSysAccountId());
        couponManualPO.setCreateUserName(accountPo.getName());
        couponManualPO.setValid(CouponConstants.TABLE_VALID_EFFECTIVE);
        //将条件转为String格式，存入数据库
        memberInfo.setBrandId(accountPo.getBrandId());

        couponManualPO.setMemberCondition(JSONObject.toJSONString(memberInfo));
        couponManualPO.setTaskStatus(CouponManualTaskStatusEnum.TASK_STATUS_NEW.getCode().byteValue());
        couponManualPO.setMemberNum(param.getTotalNumber());
        couponManualPOMapper.insertSelective(couponManualPO);

        //发券参数
        SendCouponBatchRequestVO requestVO = new SendCouponBatchRequestVO();

        requestVO.setCouponDefinitionIds(couponManualPO.getCouponDefinitionId());
        requestVO.setSendType(couponManualPO.getSendType());
        requestVO.setSendTime(couponManualPO.getSendTime());
        requestVO.setBusinessName(couponManualPO.getTaskName());
        requestVO.setBusinessId(couponManualPO.getCouponManualId());
        requestVO.setBusinessType(SendTypeEnum.SEND_COUPON_BATCH.getCode());
        requestVO.setCreateUserId(accountPo.getSysAccountId());
        requestVO.setCreateUserName(accountPo.getCreateUserName());

        //立即发送
        sendNewCouponBySendType(definitionPOList, requestVO);

        return responseData;
    }


    /**
     * 判断发券类型时间发券(新)
     *
     * @param definitionPOList
     * @param requestVO
     * @return
     */
    private ResponseData<String> sendNewCouponBySendType(List<CouponDefinitionPOWithBLOBs> definitionPOList, SendCouponBatchRequestVO requestVO) {

        ResponseData<String> responseData = new ResponseData<>();
        if (CouponEnum.COUPON_MANUAL_SEND_TYPE_NOW.getCode().equals(requestVO.getSendType() + "")) {
            //立刻发券
            sendNewCouponByUseChannel(definitionPOList,requestVO);
        } else if (CouponEnum.COUPON_MANUAL_SEND_TYPE_SOMEDAY.getCode().equals(requestVO.getSendType() + "")) {
            //指定时间发券，创建定时发券任务
            addSendCouponBatchJob(requestVO);
        } else {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.SEND_TYPE_NOT_EXISTS.getMessage());
            return responseData;
        }
        return responseData;
    }


    /**
     * 判断发券渠道-批量发券(新)
     * @param definitionPOList
     * @param requestVO
     * @return
     */
    @Override
    public ResponseData<String> sendNewCouponByUseChannel(List<CouponDefinitionPOWithBLOBs> definitionPOList, SendCouponBatchRequestVO requestVO){

        ResponseData<String> responseData = new ResponseData<>();

        //保存发券批次记录
        CouponBatchSendRecordPO batchPO = sendCouponService.saveNewCouponBatchRecord(definitionPOList.get(0).getSysCompanyId(),
                definitionPOList.get(0).getSysBrandId(),definitionPOList.get(0).getBrandCode(),requestVO.getCouponDefinitionIds(),requestVO);
        
        requestVO.setBatchSendCode(batchPO.getBatchSendCode());
        JSONObject  jsonObject =new JSONObject();
        definitionPOList.forEach(po -> {
        
        	if(jsonObject.get(po.getCouponDefinitionId().toString())!=null) {
        		po.setBatchSendCodeDetail(jsonObject.getLong(po.getCouponDefinitionId().toString()));
        	}else {
            	//生成二级批次号 
            	requestVO.setBatchSendCodeDetail(BusinessCodeUtil.getCouponBatchSendCodelong());
            	po.setBatchSendCodeDetail(requestVO.getBatchSendCodeDetail());
            	jsonObject.put(po.getCouponDefinitionId().toString(), requestVO.getBatchSendCodeDetail());
            	//保存发送批次
            	sendCouponService.saveNewCouponBatchRecordDetail(definitionPOList.get(0).getSysCompanyId(),
                        definitionPOList.get(0).getSysBrandId(),definitionPOList.get(0).getBrandCode(),po,requestVO);
        	}

            //更新手动发券状态为-发送中
            updateTaskStatus(requestVO.getBusinessId(),CouponManualTaskStatusEnum.TASK_STATUS_SENDING.getCode().byteValue());

            //线上发券
            sendCouponService.sendCouponBatchOnlineNow(po, requestVO, batchPO);

        });
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }

    @Override
    public ResponseData<String> changeNewManualTask(CouponManualVO param, MembersInfoSearchVo memberInfo, SysAccountPo accountPo) throws Exception {
        logger.info("enter CouponManualServiceImpl changeNewManualTask method");
        ResponseData<String> responseData = new ResponseData<>();

        if (null == param.getCouponManualId()) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_MANUAL_ID_NOT_NULL.getMessage());
            return responseData;
        }
        if (StringUtils.isEmpty(param.getCouponDefinitionIds())) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_DEFINITION_ID_NOT_NULL.getMessage());
            return responseData;
        }else if (param.getCouponDefinitionIds().contains(",")) {
            if (param.getCouponDefinitionIds().split(",").length > 20) {
                responseData.setCode(SysResponseEnum.FAILED.getCode());
                responseData.setMessage(SysResponseEnum.COUPON_DEFINITION_ID_LIST_MORE_20.getMessage());
                return responseData;
            }
        }
        if (StringUtils.isBlank(param.getMemberCodeList())) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_MEMBER_CODE_NOT_NULL.getMessage());
            return responseData;
        }

        if (null == param.getSendType()) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_SEND_TYPE_NOT_NULL.getMessage());
            return responseData;
        } else {
            if (CouponEnum.COUPON_MANUAL_SEND_TYPE_SOMEDAY.getCode().equals(param.getSendType()) &&
                    StringUtils.isBlank(param.getSendTimeStr())) {
                responseData.setCode(SysResponseEnum.FAILED.getCode());
                responseData.setMessage(SysResponseEnum.SEND_TIME_NOT_NULL.getMessage());
                return responseData;
            }
        }

        List<CouponDefinitionPOWithBLOBs> definitionPOList = new ArrayList<>();
        String definitionIdStr = "";
        String definitionNameStr = "";
        if (param.getCouponDefinitionIds().contains(",")) {
            String[] idArray = param.getCouponDefinitionIds().split(",");
            for (int i = 0;i<idArray.length;i++) {
                CouponDefinitionPOWithBLOBs definitionPO = couponDefinitionPOMapper.selectByPrimaryKey(Long.parseLong(idArray[i]));
                if (definitionPO == null) {
                    continue;
                }
                //判断是否过期,日期区间存在过期情况
                if(CouponConstants.VALID_TYPE__INTERVAL.equals(definitionPO.getValidType())){

                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date endDate = format.parse(format.format(definitionPO.getValidDateEnd()));
                    Date today = format.parse(format.format(new Date()));

                    logger.info("bbbbbbbbbbbbbbbbbbbbbbbbbbbb endDate:{},today:{}",JSONObject.toJSONString(endDate),JSONObject.toJSONString(today));

                    //判断券是否过期
                    if(endDate.getTime()<today.getTime()){
                        continue;
                    }
                }
                definitionPOList.add(definitionPO);
                if (i != idArray.length - 1) {
                    definitionIdStr += idArray[i] + ",";
                    definitionNameStr += definitionPO.getCouponName() + "、";
                }else {
                    definitionIdStr += idArray[i];
                    definitionNameStr += definitionPO.getCouponName();
                }

            }
        }else {
            CouponDefinitionPOWithBLOBs definitionPO = couponDefinitionPOMapper.selectByPrimaryKey(Long.parseLong(param.getCouponDefinitionIds()));
            if (definitionPO != null) {
                //判断是否过期,日期区间存在过期情况
                if(CouponConstants.VALID_TYPE__INTERVAL.equals(definitionPO.getValidType())){

                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date endDate = format.parse(format.format(definitionPO.getValidDateEnd()));
                    Date today = format.parse(format.format(new Date()));

                    logger.info("bbbbbbbbbbbbbbbbbbbbbbbbbbbb endDate:{},today:{}",JSONObject.toJSONString(endDate),JSONObject.toJSONString(today));

                    //判断券是否过期
                    if(endDate.getTime()<today.getTime()){
                        responseData.setCode(SysResponseEnum.FAILED.getCode());
                        responseData.setMessage(SysResponseEnum.COUPON_EXPIRED.getMessage());
                        return responseData;
                    }
                }
                definitionIdStr += param.getCouponDefinitionIds();
                definitionNameStr += definitionPO.getCouponName();
            }else {
                responseData.setCode(SysResponseEnum.FAILED.getCode());
                responseData.setMessage(SysResponseEnum.COUPON_NOT_EXIST.getMessage());
                return responseData;
            }
            definitionPOList.add(definitionPO);

        }

        /*CouponDefinitionPOWithBLOBs definitionPO = couponDefinitionPOMapper.selectByPrimaryKey(Long.valueOf(param.getCouponDefinitionId()));

        if (null == definitionPO) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_NOT_EXIST.getMessage());
            return responseData;
        }*/

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        CouponManualPO manualUpdate = new CouponManualPO();

        //手动发券id
        manualUpdate.setCouponManualId(param.getCouponManualId());

        //更新手动发券信息
        if (CouponEnum.COUPON_MANUAL_SEND_TYPE_NOW.getCode().equals(param.getSendType() + "")) {
            //如果是立即发送
            manualUpdate.setSendTime(TimeUtils.getNowTime());

        } else {
            //如果是指定时间发送
            manualUpdate.setSendTime(dateFormat.parse(param.getSendTimeStr()));
        }
        manualUpdate.setSysCompanyId(definitionPOList.get(0).getSysCompanyId());
        manualUpdate.setSysBrandId(definitionPOList.get(0).getSysBrandId());
        manualUpdate.setBrandCode(definitionPOList.get(0).getBrandCode());
        manualUpdate.setTaskName(param.getTaskName());
        manualUpdate.setCouponDefinitionId(definitionIdStr);
        manualUpdate.setCouponDefinitionName(definitionNameStr);
        manualUpdate.setSendType(param.getSendType());
        //manualUpdate.setDiscountMoney(definitionPO.getMoney());
        manualUpdate.setValid(CouponConstants.TABLE_VALID_EFFECTIVE);
        //将条件转为String格式，存入数据库
        memberInfo.setBrandId(accountPo.getBrandId());
        manualUpdate.setMemberCondition(JSONObject.toJSONString(memberInfo));
        manualUpdate.setTaskStatus(CouponManualTaskStatusEnum.TASK_STATUS_CHECK_WAIT.getCode().byteValue());
        manualUpdate.setMemberCount(param.getTotalNumber());
        manualUpdate.setModifiedDate(TimeUtils.getNowTime());
        manualUpdate.setModifiedUserId(accountPo.getSysAccountId());
        manualUpdate.setModifiedUserName(accountPo.getName());

        couponManualPOMapper.updateByPrimaryKeySelective(manualUpdate);

        CouponManualPO couponManualPO = couponManualPOMapper.selectByPrimaryKey(param.getCouponManualId());


        //更新审核记录
        SysCheckPo checkPo = new SysCheckPo();
        //审核id
        checkPo.setSysCheckId(param.getSysCheckId());

        checkPo.setSysBrandId(couponManualPO.getSysBrandId());
        checkPo.setFunctionCode(CouponConstants.COUPON_CHECK_FUNCTION_CODE);
        checkPo.setBusinessType(Integer.parseInt(SendTypeEnum.SEND_COUPON_BATCH.getCode()));
        checkPo.setBusinessId(couponManualPO.getCouponManualId());
        checkPo.setBusinessCode(couponManualPO.getCouponManualId() + "");
        checkPo.setBusinessName(couponManualPO.getTaskName());
        checkPo.setBizName(couponManualPO.getCouponDefinitionName());
        checkPo.setCheckStatus(CouponConstants.CHECK_STATUS_WAIT);
        checkPo.setCreateDate(TimeUtils.getNowTime());
        checkPo.setCreateUserId(accountPo.getSysAccountId());
        checkPo.setCreateUserName(accountPo.getName());
        checkPo.setValid(CouponConstants.TABLE_VALID_EFFECTIVE);

        sysCheckServiceRpc.updateCheck(checkPo);

        return responseData;
    }

    @Override
    public ResponseData<CouponDetailResponseVO> findNewById(Long couponManualId) {
        logger.info("enter CouponManualServiceImpl findById method");
        ResponseData<CouponDetailResponseVO> responseData = new ResponseData<>();

        CouponDetailResponseVO detailVO = new CouponDetailResponseVO();

        if (null == couponManualId) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.COUPON_MANUAL_ID_NOT_NULL.getMessage());
            return responseData;
        }
        CouponManualPO manualPO = couponManualPOMapper.selectByPrimaryKey(couponManualId);


        //获取劵定义id群
        List<CouponDefinitionPOWithBLOBs> definitionPOList = new ArrayList<>();
        String definitionIds = manualPO.getCouponDefinitionId();
        if (definitionIds.contains(",")) {
            for (String id : definitionIds.split(",")) {
                CouponDefinitionPOWithBLOBs definitionPO = couponDefinitionPOMapper.selectByPrimaryKey(Long.valueOf(id));
                definitionPOList.add(definitionPO);
            }
        }else {
            CouponDefinitionPOWithBLOBs definitionPO = couponDefinitionPOMapper.selectByPrimaryKey(Long.valueOf(definitionIds));
            definitionPOList.add(definitionPO);
        }

        detailVO.setCouponDefinitionPOList(definitionPOList);
        detailVO.setCouponManualPO(manualPO);
        responseData.setData(detailVO);
        return responseData;
    }
}
