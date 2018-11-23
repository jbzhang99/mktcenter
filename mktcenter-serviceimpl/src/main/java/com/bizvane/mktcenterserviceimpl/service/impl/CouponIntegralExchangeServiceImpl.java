package com.bizvane.mktcenterserviceimpl.service.impl;

import com.alibaba.fastjson.JSON;
import com.bizvane.centerstageservice.models.po.SysStorePo;
import com.bizvane.centerstageservice.rpc.StoreServiceRpc;
import com.bizvane.mktcenterservice.interfaces.CouponIntegralExchangeService;
import com.bizvane.mktcenterservice.models.po.MktActivityPOWithBLOBs;
import com.bizvane.mktcenterservice.models.po.MktCouponIntegralExchangePO;
import com.bizvane.mktcenterservice.models.vo.ActivityVO;
import com.bizvane.mktcenterservice.models.vo.MktCouponIntegralExchangeVO;
import com.bizvane.mktcenterservice.models.vo.PageForm;
import com.bizvane.mktcenterserviceimpl.common.utils.CodeUtil;
import com.bizvane.mktcenterserviceimpl.mappers.MktCouponIntegralExchangePOMapper;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by agan on 2018/11/22.
 */
@Service
@Slf4j
public class CouponIntegralExchangeServiceImpl implements CouponIntegralExchangeService {

    @Autowired
    private MktCouponIntegralExchangePOMapper mktCouponIntegralExchangePOMapper;

    @Autowired
    private StoreServiceRpc storeServiceRpc;
    /**
     * 积分兑换券列表
     * @param vo
     * @param pageForm
     * @param stageUser
     * @return
     */
    @Override
    public ResponseData<MktCouponIntegralExchangeVO> getCouponIntegralExchangeList(MktCouponIntegralExchangeVO vo, PageForm pageForm, SysAccountPO stageUser) {
        ResponseData responseData = new ResponseData();
        PageHelper.startPage(pageForm.getPageNumber(),pageForm.getPageSize());
        vo.setSysBrandId(stageUser.getBrandId());
        log.info("积分兑换券列表开始，参数="+ JSON.toJSONString(vo));
        List<MktCouponIntegralExchangeVO> mktCouponIntegralExchangeVOList = mktCouponIntegralExchangePOMapper.getCouponIntegralExchangeList(vo);
        PageInfo<MktCouponIntegralExchangeVO> pageInfo = new PageInfo<>(mktCouponIntegralExchangeVOList);
        responseData.setData(pageInfo);
        return responseData;
    }

    /**
     * 新增积分兑换规则
     * @param vo
     * @param stageUser
     * @return
     */
    @Override
    public ResponseData<Integer> addCouponIntegralExchange(MktCouponIntegralExchangeVO vo, SysAccountPO stageUser) {
        log.info("新增积分兑换券规则开始，参数="+ JSON.toJSONString(vo));
        ResponseData responseData = new ResponseData();
        //工具类生成活动编码
        String exchangeCode = CodeUtil.getCouponIntegralExchangeCode();
        vo.setExchangeCode(exchangeCode);
        vo.setSysBrandId(stageUser.getBrandId());
        vo.setSysCompanyId(stageUser.getSysCompanyId());
        vo.setCreateUserId(stageUser.getCreateUserId());
        vo.setCreateUserName(stageUser.getCreateUserName());
        vo.setCreateDate(new Date());
        MktCouponIntegralExchangePO mktCouponIntegralExchangePO = new MktCouponIntegralExchangePO();
        BeanUtils.copyProperties(vo,mktCouponIntegralExchangePO);
        mktCouponIntegralExchangePOMapper.insertSelective(mktCouponIntegralExchangePO);
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        log.info("积分兑换-创建成功");
        return responseData;
    }

    /**
     * 修改积分兑换规则
     * @param vo
     * @param stageUser
     * @return
     */
    @Override
    public ResponseData<Integer> updateCouponIntegralExchange(MktCouponIntegralExchangeVO vo, SysAccountPO stageUser) {
        log.info("修改积分兑换券规则开始，参数="+ JSON.toJSONString(vo));
        ResponseData responseData = new ResponseData();
        vo.setModifyUserId(stageUser.getCreateUserId());
        vo.setModifyUserName(stageUser.getCreateUserName());
        vo.setModifiedDate(new Date());
        MktCouponIntegralExchangePO mktCouponIntegralExchangePO = new MktCouponIntegralExchangePO();
        BeanUtils.copyProperties(vo,mktCouponIntegralExchangePO);
        mktCouponIntegralExchangePOMapper.updateByPrimaryKeySelective(mktCouponIntegralExchangePO);
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        log.info("积分兑换-修改成功");
        return responseData;
    }

    /**
     * 查看积分兑换规则
     * @param exchangeId
     * @return
     */
    @Override
    public ResponseData<MktCouponIntegralExchangeVO> selectCouponIntegralExchange(Long exchangeId) {
        log.info("查询积分兑换规则详情参数="+exchangeId);
        ResponseData responseData = new ResponseData();
        MktCouponIntegralExchangeVO mktCouponIntegralExchangeVO = new MktCouponIntegralExchangeVO();
        mktCouponIntegralExchangeVO.setExchangeId(exchangeId);
        //查询兑换表详情
        List<MktCouponIntegralExchangeVO> mktCouponIntegralExchangeVOList = mktCouponIntegralExchangePOMapper.getCouponIntegralExchangeList(mktCouponIntegralExchangeVO);
        MktCouponIntegralExchangeVO couponIntegralExchangeVO = mktCouponIntegralExchangeVOList.get(0);
        //查询门店
        String ids =couponIntegralExchangeVO.getStoreList();
        //查询适用门店
        List<Long> listIds = Arrays.asList(ids.split(",")).stream().map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
        ResponseData<List<SysStorePo>> sysStorePOs = storeServiceRpc.getIdStoreLists(listIds);
        if(!CollectionUtils.isEmpty(sysStorePOs.getData())){
            couponIntegralExchangeVO.setSysStorePos(sysStorePOs.getData());
        }
        //查询券

        return null;
    }
}
