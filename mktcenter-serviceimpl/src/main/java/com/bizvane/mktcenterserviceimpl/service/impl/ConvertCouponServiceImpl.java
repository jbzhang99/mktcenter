package com.bizvane.mktcenterserviceimpl.service.impl;

import com.alibaba.fastjson.JSON;
import com.bizvane.couponfacade.interfaces.CouponDefinitionServiceFeign;
import com.bizvane.couponfacade.interfaces.SendCouponServiceFeign;
import com.bizvane.couponfacade.models.po.CouponDefinitionPO;
import com.bizvane.couponfacade.models.vo.SendCouponSimpleRequestVO;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.mktcenterservice.interfaces.ConvertCouponService;
import com.bizvane.mktcenterservice.interfaces.TaskService;
import com.bizvane.mktcenterservice.models.po.MktConvertCouponRecordPO;
import com.bizvane.mktcenterservice.models.po.MktCouponIntegralExchangePO;
import com.bizvane.mktcenterservice.models.po.MktCouponIntegralExchangePOExample;
import com.bizvane.mktcenterservice.models.vo.CouponRecordVO;
import com.bizvane.mktcenterservice.models.vo.MktCouponIntegralExchangeVO;
import com.bizvane.mktcenterserviceimpl.common.utils.CodeUtil;
import com.bizvane.mktcenterserviceimpl.mappers.MktConvertCouponRecordPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktCouponIntegralExchangePOMapper;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.utils.tokens.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: lijunwei
 * @Time: 2018/11/23 11:28
 */
@Slf4j
@Service
public class ConvertCouponServiceImpl implements ConvertCouponService {
    @Autowired
    private MktConvertCouponRecordPOMapper mktConvertCouponRecordPOMapper;
    @Autowired
    private MktCouponIntegralExchangePOMapper mktCouponIntegralExchangePOMapper;
    @Autowired
    private CouponDefinitionServiceFeign couponDefinitionServiceFeign;
    @Autowired
    private SendCouponServiceFeign sendCouponServiceFeign;
    @Autowired
    private TaskService taskService;

    /**
     * 积分兑换订单的查询
     */
    @Override
    public ResponseData<PageInfo<MktConvertCouponRecordPO>> getCouponRecordLists(CouponRecordVO vo) {
        ResponseData<PageInfo<MktConvertCouponRecordPO>> responseData = new ResponseData<>();
        PageInfo<MktConvertCouponRecordPO> page = null;
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        List<MktConvertCouponRecordPO> couponRecordLists = mktConvertCouponRecordPOMapper.getCouponRecordLists(vo);
        if (CollectionUtils.isEmpty(couponRecordLists)) {
            page = new PageInfo<>(new ArrayList<MktConvertCouponRecordPO>());
            List<MktConvertCouponRecordPO> list = page.getList();
        } else {
            page = new PageInfo<>(couponRecordLists);
        }
        responseData.setData(page);
        return responseData;
    }

    /**
     * 查询兑换的券 全部或可兑换 列表
     */
    @Override
    public ResponseData<PageInfo<MktCouponIntegralExchangeVO>> getConvernCouponLists(CouponRecordVO vo) {
        if (vo.getCanConvertCoupon()) {
            //可兑换券的列表
            List<Long> exchangeIds = mktCouponIntegralExchangePOMapper.getExchangeIds(vo);
            vo.setExchangeIds(exchangeIds);
        } else {
            //品牌下的券列表
            vo.setExchangeIds(null);
            vo.setCountIntegral(null);
        }
        ResponseData<PageInfo<MktCouponIntegralExchangeVO>> responseData = new ResponseData<>();
        PageInfo<MktCouponIntegralExchangeVO> page = null;
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        List<MktCouponIntegralExchangeVO> exchangeLists = mktCouponIntegralExchangePOMapper.getExchangeLists(vo);
        if (CollectionUtils.isEmpty(exchangeLists)) {
            page = new PageInfo<>(new ArrayList<MktCouponIntegralExchangeVO>());
            List<MktCouponIntegralExchangeVO> list = page.getList();
            for (MktCouponIntegralExchangeVO exchangeVO : list) {
                Long couponEntityId = exchangeVO.getCouponEntityId();
                ResponseData<CouponDefinitionPO> coupon = couponDefinitionServiceFeign.findByIdRpc(couponEntityId);
                exchangeVO.setCouponDefinitionPO(coupon.getData());
            }
        } else {
            page = new PageInfo<>(exchangeLists);
        }
        responseData.setData(page);
        return responseData;
    }

    //兑换券
    @Override
    public ResponseData<Integer> doConvernCoupon(CouponRecordVO vo) {
        log.info("doConvernCoupon----参数--"+ JSON.toJSONString(vo));
        ResponseData<Integer> responseData = new ResponseData<>();
        MktCouponIntegralExchangePOExample example = new MktCouponIntegralExchangePOExample();
        example.createCriteria().andExchangeIdEqualTo(vo.getExchangeId());
        List<MktCouponIntegralExchangePO> mktCouponIntegralExchangePOS = mktCouponIntegralExchangePOMapper.selectByExampleWithBLOBs(example);
        if (CollectionUtils.isEmpty(mktCouponIntegralExchangePOS)) {
            responseData.setCode(100);
            responseData.setMessage("兑换规则不存在!");
            return responseData;
        }
        String memberCode = vo.getMemberCode();//会员code
        MktCouponIntegralExchangePO mktCouponIntegralExchangePO = mktCouponIntegralExchangePOS.get(0);
        
        Integer exchangeStatus = mktCouponIntegralExchangePO.getExchangeStatus();
        if (Integer.valueOf(1).equals(exchangeStatus)){
            //获取此会员兑换此券的数量
            Integer memberConvertNumber = mktConvertCouponRecordPOMapper.getConvertNumber(vo);
            Long exchangeCount = mktCouponIntegralExchangePO.getExchangeCount();
            exchangeCount=exchangeCount==null?0L:exchangeCount;
            if (exchangeCount>=Long.valueOf(memberConvertNumber)){
                responseData.setCode(100);
                responseData.setMessage("超过限制券兑换数量!");
                return responseData;
            }
        }

        Integer storeStatus = mktCouponIntegralExchangePO.getStoreStatus();
        Long storeCount = mktCouponIntegralExchangePO.getStoreCount();
        if (Integer.valueOf(1).equals(storeStatus)){
            //此规则下券已被兑换的总数
            vo.setMemberCode(null);
            Integer convertNumber = mktConvertCouponRecordPOMapper.getConvertNumber(vo);
            convertNumber=convertNumber==null?0:convertNumber;
            long num = storeCount - convertNumber;
            if (num<vo.getExchangeNum()){
                responseData.setCode(100);
                responseData.setMessage("剩余优惠券不足!");
                return responseData;
            }
        }

        Integer exchangeNum = vo.getExchangeNum();
        Integer exchangePrice = mktCouponIntegralExchangePO.getExchangePrice();
        String couponRecordCode = CodeUtil.getCouponRecordCode();
        MemberInfoModel memeberDetail = taskService.getCompanyMemeberDetail(memberCode);
        MktConvertCouponRecordPO record=new MktConvertCouponRecordPO();
        record.setConvertCouponRecordCode(couponRecordCode);
        record.setExchangeId(mktCouponIntegralExchangePO.getExchangeId());
        record.setExchangeCode(mktCouponIntegralExchangePO.getExchangeCode());
        record.setCouponName(mktCouponIntegralExchangePO.getCouponName());
        record.setConvertNum(vo.getExchangeNum());
        record.setConvertPrice(exchangePrice);
        record.setConvertTatalIntegral(exchangeNum*exchangePrice);
        record.setCardNo(memeberDetail.getCardNo());
        record.setMemberCode(memeberDetail.getMemberCode());
        record.setMemberName(memeberDetail.getName());
        record.setConvertTime(new Date());
        record.setValid(Boolean.TRUE);
        mktConvertCouponRecordPOMapper.insertSelective(record);


        for (int i = 1; i <= exchangeNum; i++){
            SendCouponSimpleRequestVO onecouponVO = new SendCouponSimpleRequestVO();
            onecouponVO.setMemberCode(memberCode);
            onecouponVO.setSendBussienId(record.getConvertCouponRecordId());
            onecouponVO.setBusinessName(couponRecordCode);
            onecouponVO.setSendType("100");
            onecouponVO.setCouponDefinitionId(mktCouponIntegralExchangePO.getCouponEntityId());
            ResponseData<Object> simple = sendCouponServiceFeign.simple(onecouponVO);
            log.info("doConvernCoupon----发券----参数--"+JSON.toJSONString(onecouponVO)+"----出参--"+JSON.toJSONString(simple));
        }
        return responseData;
    }

}
