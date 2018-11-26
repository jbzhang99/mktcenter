package com.bizvane.mktcenterserviceimpl.service.impl;

import com.alibaba.fastjson.JSON;
import com.bizvane.couponfacade.enums.SendTypeEnum;
import com.bizvane.couponfacade.interfaces.CouponDefinitionServiceFeign;
import com.bizvane.couponfacade.interfaces.SendCouponServiceFeign;
import com.bizvane.couponfacade.models.po.CouponDefinitionPO;
import com.bizvane.couponfacade.models.vo.SendCouponSimpleRequestVO;
import com.bizvane.members.facade.enums.BusinessTypeEnum;
import com.bizvane.members.facade.enums.IntegralChangeTypeEnum;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.service.api.IntegralChangeApiService;
import com.bizvane.members.facade.service.card.request.IntegralChangeRequestModel;
import com.bizvane.members.facade.service.card.response.IntegralChangeResponseModel;
import com.bizvane.mktcenterservice.interfaces.ConvertCouponService;
import com.bizvane.mktcenterservice.interfaces.TaskService;
import com.bizvane.mktcenterservice.models.po.MktConvertCouponRecordPO;
import com.bizvane.mktcenterservice.models.po.MktConvertCouponRecordPOExample;
import com.bizvane.mktcenterservice.models.po.MktCouponIntegralExchangePO;
import com.bizvane.mktcenterservice.models.po.MktCouponIntegralExchangePOExample;
import com.bizvane.mktcenterservice.models.vo.CouponRecordVO;
import com.bizvane.mktcenterservice.models.vo.MktCouponIntegralExchangeVO;
import com.bizvane.mktcenterserviceimpl.common.utils.CodeUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.TimeUtils;
import com.bizvane.mktcenterserviceimpl.mappers.MktConvertCouponRecordPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktCouponIntegralExchangePOMapper;
import com.bizvane.utils.commonutils.DateUtils;
import com.bizvane.utils.responseinfo.ResponseData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
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
    @Autowired
    private IntegralChangeApiService integralChangeApiService;

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
    //导出列表
    @Override
    public void doExportData(CouponRecordVO vo,HttpServletResponse response) throws IOException {
        // 导出excel
        HSSFWorkbook workbook = new HSSFWorkbook();
        //在工作簿中创建新工作表(迭代器，空)
        HSSFSheet sheet = workbook.createSheet();
        HSSFRow headerRow = headerRow = sheet.createRow(0);
        String  nameArray[] = {"积分订单号","编号","会员名称","会员卡号","券名称","积分兑换价格","兑换数量","总兑换积分数","兑换时间"};
        for (int i=0,lengtn=nameArray.length;i<lengtn;i++){
            headerRow.createCell(i).setCellValue(nameArray[i]);
        }
        // 查询数据列表
        List<MktConvertCouponRecordPO> couponRecordLists = mktConvertCouponRecordPOMapper.getCouponRecordLists(vo);
        if (CollectionUtils.isNotEmpty(couponRecordLists)) {
            String  keyArray[] ={"convertCouponRecordCode","exchangeCode","memberName","cardNo","couponName","convertPrice","convertNum","convertTatalIntegral","convertTime"};
            for (int i = 0,size=couponRecordLists.size();i<size; i++) {
                int lastRowNum = sheet.getLastRowNum();
                HSSFRow dataRow = sheet.createRow(lastRowNum + 1);
                for (int k=0,lengtn=keyArray.length;k<lengtn;k++){
                    HSSFCell cell = dataRow.createCell(k);
                    Object o= getFieldValueByName(keyArray[k],couponRecordLists.get(i));
                    if (o instanceof Date){
                        cell.setCellValue(TimeUtils.formatter.format((Date) o));
                    }else {
                        cell.setCellValue(String.valueOf(o));
                    }
                }
            }
        }
        String downFilename = "积分订单导出.xls";
//      ServletContext servletContext = request.getSession().getServletContext();
//      String contentType = servletContext.getMimeType(downFilename);
//      response.setContentType(contentType);
//      String agent = request.getHeader("user-agent");
        String contentDisposition = "attachment;filename=" + new String(downFilename.getBytes(), "ISO-8859-1");
        response.setHeader("Content-Disposition", contentDisposition);
        workbook.write(response.getOutputStream());
    }
    private static Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter);
            return method.invoke(o)==null?"":method.invoke(o);
        } catch (Exception e) {
            return "";
        }
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
        log.info("doConvernCoupon----参数--" + JSON.toJSONString(vo));
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
        if (Integer.valueOf(1).equals(exchangeStatus)) {
            //获取此会员兑换此券的数量
            Integer memberConvertNumber = mktConvertCouponRecordPOMapper.getConvertNumber(vo);
            Long exchangeCount = mktCouponIntegralExchangePO.getExchangeCount();
            exchangeCount = exchangeCount == null ? 0L : exchangeCount;
            if (exchangeCount >= Long.valueOf(memberConvertNumber)) {
                responseData.setCode(100);
                responseData.setMessage("超过限制券兑换数量!");
                return responseData;
            }
        }

        Integer storeStatus = mktCouponIntegralExchangePO.getStoreStatus();
        Long storeCount = mktCouponIntegralExchangePO.getStoreCount();
        if (Integer.valueOf(1).equals(storeStatus)) {
            //此规则下券已被兑换的总数
            vo.setMemberCode(null);
            Integer convertNumber = mktConvertCouponRecordPOMapper.getConvertNumber(vo);
            convertNumber = convertNumber == null ? 0 : convertNumber;
            long num = storeCount - convertNumber;
            if (num < vo.getExchangeNum()) {
                responseData.setCode(100);
                responseData.setMessage("剩余优惠券不足!");
                return responseData;
            }
        }

        Integer exchangeNum = vo.getExchangeNum();
        Integer exchangePrice = mktCouponIntegralExchangePO.getExchangePrice();
        String couponRecordCode = CodeUtil.getCouponRecordCode();
        MemberInfoModel memeberDetail = taskService.getCompanyMemeberDetail(memberCode);
        MktConvertCouponRecordPO record = new MktConvertCouponRecordPO();
        record.setConvertCouponRecordCode(couponRecordCode);
        record.setExchangeId(mktCouponIntegralExchangePO.getExchangeId());
        record.setExchangeCode(mktCouponIntegralExchangePO.getExchangeCode());
        record.setCouponEntityId(mktCouponIntegralExchangePO.getCouponEntityId());
        record.setCouponName(mktCouponIntegralExchangePO.getCouponName());
        record.setConvertNum(vo.getExchangeNum());
        record.setConvertPrice(exchangePrice);
        record.setConvertTatalIntegral(exchangeNum * exchangePrice);
        record.setCardNo(memeberDetail.getCardNo());
        record.setMemberCode(memeberDetail.getMemberCode());
        record.setMemberName(memeberDetail.getName());
        record.setConvertTime(new Date());
        record.setValid(Boolean.TRUE);
        mktConvertCouponRecordPOMapper.insertSelective(record);

        IntegralChangeRequestModel integralRecordModel = new IntegralChangeRequestModel();
        integralRecordModel.setSysCompanyId(memeberDetail.getSysCompanyId());
        integralRecordModel.setBrandId(memeberDetail.getBrandId());
        integralRecordModel.setMemberCode(memeberDetail.getMemberCode());
        //BusinessTypeEnum  会员定义的任务类型
        //BusinessTypeEnum.TASK_TYPE_PREFECT.getCode()
        integralRecordModel.setBusinessType("26");
        //2=收入积分(新增积分)      1=支出积分(减少积分)
        integralRecordModel.setChangeType(IntegralChangeTypeEnum.Expend.getCode());
        integralRecordModel.setChangeBills(couponRecordCode);
        integralRecordModel.setChangeIntegral(exchangeNum * exchangePrice);
        IntegralChangeResponseModel integralChangeResponseModel = integralChangeApiService.integralChangeOperate(integralRecordModel);
        Integer code = integralChangeResponseModel.getCode();

        if (Integer.valueOf(0).equals(code)) {
            for (int i = 1; i <= exchangeNum; i++) {
                SendCouponSimpleRequestVO onecouponVO = new SendCouponSimpleRequestVO();
                onecouponVO.setMemberCode(memberCode);
                onecouponVO.setSendBussienId(record.getConvertCouponRecordId());
                onecouponVO.setBusinessName(couponRecordCode);
                //  SendTypeEnum.SEND_COUPON_INVITE_OPENCARD_TASK.getCode();
                onecouponVO.setSendType("101");
                onecouponVO.setCouponDefinitionId(mktCouponIntegralExchangePO.getCouponEntityId());
                ResponseData<Object> simple = sendCouponServiceFeign.simple(onecouponVO);
                log.info("doConvernCoupon----发券----参数--" + JSON.toJSONString(onecouponVO) + "----出参--" + JSON.toJSONString(simple));
            }
        }

        return responseData;
    }

    //查询已兑换券列表
    @Override
    public ResponseData<List<MktConvertCouponRecordPO>> getConvernConpouByMember(CouponRecordVO vo) {
        ResponseData<List<MktConvertCouponRecordPO>> responseData = new ResponseData<>();
        MktConvertCouponRecordPOExample example = new MktConvertCouponRecordPOExample();
        example.createCriteria().andMemberCodeEqualTo(vo.getMemberCode()).andValidEqualTo(Boolean.TRUE);
        List<MktConvertCouponRecordPO> mktConvertCouponRecordPOS = mktConvertCouponRecordPOMapper.selectByExampleWithBLOBs(example);
        responseData.setData(mktConvertCouponRecordPOS);
        return responseData;
    }


}
