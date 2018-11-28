package com.bizvane.mktcenterserviceimpl.service.impl;

import com.alibaba.fastjson.JSON;
import com.bizvane.centerstageservice.models.po.FileTaskPo;
import com.bizvane.centerstageservice.rpc.FileTaskServiceRpc;
import com.bizvane.couponfacade.interfaces.CouponDefinitionServiceFeign;
import com.bizvane.couponfacade.interfaces.SendCouponServiceFeign;
import com.bizvane.couponfacade.models.po.CouponDefinitionPO;
import com.bizvane.couponfacade.models.vo.SendCouponSimpleRequestVO;
import com.bizvane.members.facade.enums.IntegralChangeTypeEnum;
import com.bizvane.members.facade.models.MemberInfoModel;
import com.bizvane.members.facade.service.api.IntegralChangeApiService;
import com.bizvane.members.facade.service.card.request.IntegralChangeRequestModel;
import com.bizvane.members.facade.service.card.response.IntegralChangeResponseModel;
import com.bizvane.mktcenterservice.interfaces.ConvertCouponService;
import com.bizvane.mktcenterservice.interfaces.TaskService;
import com.bizvane.mktcenterservice.models.bo.CouponIntegralExchangeBO;
import com.bizvane.mktcenterservice.models.po.MktConvertCouponRecordPO;
import com.bizvane.mktcenterservice.models.po.MktConvertCouponRecordPOExample;
import com.bizvane.mktcenterservice.models.po.MktCouponIntegralExchangePO;
import com.bizvane.mktcenterservice.models.po.MktCouponIntegralExchangePOExample;
import com.bizvane.mktcenterservice.models.vo.CouponIntegralExchangeVO;
import com.bizvane.mktcenterservice.models.vo.CouponRecordVO;
import com.bizvane.mktcenterservice.models.vo.MktCouponIntegralExchangeVO;
import com.bizvane.mktcenterserviceimpl.common.utils.CodeUtil;
import com.bizvane.mktcenterserviceimpl.common.tools.ExportExcelUtil;
import com.bizvane.mktcenterserviceimpl.common.tools.StreamingExportExcelUtil;
import com.bizvane.mktcenterserviceimpl.common.utils.TimeUtils;
import com.bizvane.mktcenterserviceimpl.mappers.MktConvertCouponRecordPOMapper;
import com.bizvane.mktcenterserviceimpl.mappers.MktCouponIntegralExchangePOMapper;
import com.bizvane.utils.enumutils.SysResponseEnum;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import com.bizvane.utils.tokens.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
    @Autowired
    private FileTaskServiceRpc fileTaskServiceRpc;

    /**
     * 积分兑换订单的查询
     */
    @Override
    public ResponseData<PageInfo<MktConvertCouponRecordPO>> getCouponRecordLists(CouponRecordVO vo) {
        ResponseData<PageInfo<MktConvertCouponRecordPO>> responseData = new ResponseData<>();
        if (vo.getStartTime() != null) {
            vo.setStartTimestr(TimeUtils.formatter.format(vo.getStartTime()));
        }
        if (vo.getEndTime() != null) {
            vo.setEndTimestr(TimeUtils.formatter.format(vo.getEndTime()));
        }
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
    public void doExportData(CouponRecordVO vo, HttpServletResponse response) throws IOException {
        // 导出excel
        HSSFWorkbook workbook = new HSSFWorkbook();
        //在工作簿中创建新工作表(迭代器，空)
        HSSFSheet sheet = workbook.createSheet();
        HSSFRow headerRow = headerRow = sheet.createRow(0);
        String nameArray[] = {"积分订单号", "编号", "会员名称", "会员卡号", "券名称", "积分兑换价格", "兑换数量", "总兑换积分数", "兑换时间"};
        for (int i = 0, lengtn = nameArray.length; i < lengtn; i++) {
            headerRow.createCell(i).setCellValue(nameArray[i]);
        }
        // 查询数据列表
        List<MktConvertCouponRecordPO> couponRecordLists = mktConvertCouponRecordPOMapper.getCouponRecordLists(vo);
        if (CollectionUtils.isNotEmpty(couponRecordLists)) {
            String keyArray[] = {"convertCouponRecordCode", "exchangeCode", "memberName", "cardNo", "couponName", "convertPrice", "convertNum", "convertTatalIntegral", "convertTime"};
            for (int i = 0, size = couponRecordLists.size(); i < size; i++) {
                int lastRowNum = sheet.getLastRowNum();
                HSSFRow dataRow = sheet.createRow(lastRowNum + 1);
                for (int k = 0, lengtn = keyArray.length; k < lengtn; k++) {
                    HSSFCell cell = dataRow.createCell(k);
                    Object o = getFieldValueByName(keyArray[k], couponRecordLists.get(i));
                    if (o instanceof Date) {
                        cell.setCellValue(TimeUtils.formatter.format((Date) o));
                    } else {
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
            return method.invoke(o) == null ? "" : method.invoke(o);
        } catch (Exception e) {
            return "";
        }
    }

    @Override
    public ResponseData doExportData001(CouponRecordVO vo, HttpServletRequest request) {
        SysAccountPO sysAccountPO = TokenUtils.getStageUser(request);
//        SysAccountPO sysAccountPO=new SysAccountPO();
//        sysAccountPO.setBrandId(96L);
//        sysAccountPO.setName("测试测试");
//        sysAccountPO.setSysAccountId(12867L);
//        sysAccountPO.setSysCompanyId(3841L);
        vo.setBrandId(sysAccountPO.getBrandId());
        ResponseData responseData = new ResponseData();
        responseData.setCode(SysResponseEnum.FAILED.getCode());
        try {
            //创建导出的数据集合
            List<MktConvertCouponRecordPO> couponRecordLists = mktConvertCouponRecordPOMapper.getCouponRecordLists(vo);
            long sum = couponRecordLists.size();
            Long taskId = (long) Integer.parseInt(String.valueOf(UUID.randomUUID().hashCode()).replaceAll("-", ""));
            //  创建人等信息必填
            FileTaskPo fileTaskPo = new FileTaskPo();
            fileTaskPo.setTaskId(taskId);
            fileTaskPo.setFileId(String.valueOf(taskId));
            fileTaskPo.setTaskTypeCode(sum + "条");
            fileTaskPo.setTaskName("导出积分订单");
            if (sysAccountPO != null) {
                fileTaskPo.setSysBrandId(sysAccountPO.getBrandId());
                fileTaskPo.setCreateUserId(sysAccountPO.getSysAccountId());
                fileTaskPo.setCreateUserName(sysAccountPO.getName());
            }
            fileTaskPo.setCreateDate(new Date());
            fileTaskPo.setFileStatus(0L);
            fileTaskPo.setFileType("EXPORT");
            fileTaskPo.setValid(true);
            fileTaskServiceRpc.addFileTask(fileTaskPo);
            StreamingExportExcelUtil<MktConvertCouponRecordPO> exportExcelUtil = new StreamingExportExcelUtil<>(sum);
            new Thread(() -> {
                try {
                    exportExcelUtil.setExportProcessId(taskId);
                    Method method = mktConvertCouponRecordPOMapper.getClass().getMethod("getCouponRecordLists002", CouponRecordVO.class, Long.class, Long.class);
                    exportExcelUtil.read("mktConvertCouponRecordPOMapper", method, (model, row) -> {
                        if (row.getRowNum() == 0) {
                            String nameArray[] = {"积分订单号", "编号", "会员名称", "会员卡号", "券名称", "积分兑换价格", "兑换数量", "总兑换积分数", "兑换时间"};
                            for (int i = 0, lengtn = nameArray.length; i < lengtn; i++) {
                                row.createCell(i).setCellValue(nameArray[i]);
                            }
                        } else {
                            String keyArray[] = {"convertCouponRecordCode", "exchangeCode", "memberName", "cardNo", "couponName", "convertPrice", "convertNum", "convertTatalIntegral", "convertTime"};

                            //for (int i = 0, size = couponRecordLists.size(); i < size; i++) {
                                for (int k = 0, lengtn = keyArray.length; k < lengtn; k++) {
                                    Cell cell = row.createCell(k);
                                    Object o = getFieldValueByName(keyArray[k], model);
                                    if (o instanceof Date) {
                                        cell.setCellValue(TimeUtils.formatter.format((Date) o));
                                    } else {
                                        cell.setCellValue(String.valueOf(o));
                                    }
                                }
                           // }
                        }
                    }, vo);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

            //上传excel到七牛并更新导出任务进度
            new Thread(() -> {
                SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
                ExportExcelUtil.exportAndUpdateTask(fileTaskPo, exportExcelUtil, fileTaskServiceRpc, "积分订单_" + format.format(new Date()));
            }).start();

        } catch (Exception e) {
            e.printStackTrace();
            responseData.setMessage(SysResponseEnum.FAILED.getMessage());
            return responseData;
        }

        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage("添加导出任务成功!");
        return responseData;
    }


    /**
     * 查询兑换的券 全部或可兑换 列表
     */
    @Override
    public ResponseData<CouponIntegralExchangeBO> getConvernCouponLists(CouponRecordVO vo) {
        if (vo.getCanConvertCoupon()) {
            //可兑换券的列表
            List<Long> exchangeIds = mktCouponIntegralExchangePOMapper.getExchangeIds(vo);
            vo.setExchangeIds(exchangeIds);
        } else {
            //品牌下的券列表
            vo.setExchangeIds(null);
            vo.setCountIntegral(null);
        }
        ResponseData<CouponIntegralExchangeBO> responseData = new ResponseData<>();
        PageInfo<MktCouponIntegralExchangeVO> page = null;
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        List<MktCouponIntegralExchangeVO> exchangeLists = mktCouponIntegralExchangePOMapper.getExchangeLists(vo);
        if (CollectionUtils.isNotEmpty(exchangeLists)) {
            page = new PageInfo<>(exchangeLists);
            List<MktCouponIntegralExchangeVO> list = page.getList();
            for (MktCouponIntegralExchangeVO exchangeVO : list) {
                Long couponEntityId = exchangeVO.getCouponEntityId();
                ResponseData<CouponDefinitionPO> coupon = couponDefinitionServiceFeign.findByIdRpc(couponEntityId);
                exchangeVO.setCouponDefinitionPO(coupon.getData());
            }
        } else {
            page = new PageInfo<>(new ArrayList<MktCouponIntegralExchangeVO>());
        }
        CouponIntegralExchangeBO exchangeBO = new CouponIntegralExchangeBO();
        exchangeBO.setCountIntegral(vo.getCountIntegral());
        exchangeBO.setPageInfo(page);
        responseData.setData(exchangeBO);
        return responseData;
    }
    /**
     * 查询券详情和兑换单价
     */
    @Override
    public ResponseData<CouponIntegralExchangeVO> getCouponAndPrice(CouponRecordVO vo){
        ResponseData<CouponIntegralExchangeVO> responseData = new ResponseData<CouponIntegralExchangeVO>();

        MktCouponIntegralExchangePO mktCouponIntegralExchangePO = mktCouponIntegralExchangePOMapper.selectByPrimaryKey(vo.getExchangeId());
        if (mktCouponIntegralExchangePO==null){
            responseData.setMessage("兑换规则不存在!");
            return responseData;
        }
        Long couponEntityId = mktCouponIntegralExchangePO.getCouponEntityId();
        ResponseData<CouponDefinitionPO> data = couponDefinitionServiceFeign.findByIdRpc(couponEntityId);
        CouponDefinitionPO coupon = data.getData();
        if (coupon==null){
            responseData.setMessage("券不存在!");
            return responseData;
        }
        CouponIntegralExchangeVO couponIntegralExchangeVO = new CouponIntegralExchangeVO();
        couponIntegralExchangeVO.setExchangeId(couponEntityId);
        couponIntegralExchangeVO.setExchangePrice(mktCouponIntegralExchangePO.getExchangePrice());
        couponIntegralExchangeVO.setCouponDefinitionPO(coupon);
        couponIntegralExchangeVO.setExchangeInfo(mktCouponIntegralExchangePO.getExchangeInfo());
        responseData.setData(couponIntegralExchangeVO);
        return responseData;
    }

    //兑换券
    @Override
    public ResponseData<Integer> doConvernCoupon(CouponRecordVO vo) {
        log.info("doConvernCoupon----参数--" + JSON.toJSONString(vo));
        ResponseData<Integer> responseData = new ResponseData<>();
        responseData.setMessage("兑换成功!");
        MktCouponIntegralExchangePOExample example = new MktCouponIntegralExchangePOExample();
        example.createCriteria().andExchangeIdEqualTo(vo.getExchangeId());
        //查询兑换规则详情
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

        Integer exchangeNum = vo.getExchangeNum();//要要兑换的数量
        Integer exchangePrice = mktCouponIntegralExchangePO.getExchangePrice();//兑换的单价
        String couponRecordCode = CodeUtil.getCouponRecordCode();//兑换记录code
        MemberInfoModel memeberDetail = taskService.getCompanyMemeberDetail(memberCode);
        if (memeberDetail == null) {
            responseData.setCode(100);
            responseData.setMessage("会员不存在!");
            return responseData;
        }
        Integer countIntegral = memeberDetail.getCountIntegral();
        if (countIntegral < exchangeNum * exchangePrice) {
            responseData.setCode(100);
            responseData.setMessage("可用积分不足!");
            return responseData;
        }
        //插入记录表数据
        MktConvertCouponRecordPO record = InsertMktConvertCouponRecordPO(vo, mktCouponIntegralExchangePO, exchangeNum, exchangePrice, couponRecordCode, memeberDetail);
        //调整积分
        IntegralChangeResponseModel integralChangeResponseModel = doIntegralChangeResponseModel(exchangeNum, exchangePrice, couponRecordCode, memeberDetail);
        Integer code = integralChangeResponseModel.getCode();
        if (Integer.valueOf(0).equals(code)) {
            for (int i = 1; i <= exchangeNum; i++) {
                SendCouponSimpleRequestVO onecouponVO = new SendCouponSimpleRequestVO();
                onecouponVO.setMemberCode(memberCode);
                onecouponVO.setSendBussienId(record.getConvertCouponRecordId());
                onecouponVO.setBusinessName(couponRecordCode);
                // SendTypeEnum.SEND_COUPON_INVITE_OPENCARD_TASK.getCode();
                onecouponVO.setSendType("101");
                onecouponVO.setCouponDefinitionId(mktCouponIntegralExchangePO.getCouponEntityId());
                ResponseData<Object> simple = sendCouponServiceFeign.simple(onecouponVO);
                log.info("doConvernCoupon----发券----参数--" + JSON.toJSONString(onecouponVO) + "----出参--" + JSON.toJSONString(simple));
            }
        } else {
            responseData.setCode(100);
            responseData.setMessage("兑换失败!");
            return responseData;
        }
        return responseData;
    }

    //修改积分
    public IntegralChangeResponseModel doIntegralChangeResponseModel(Integer exchangeNum, Integer exchangePrice, String couponRecordCode, MemberInfoModel memeberDetail) {
        IntegralChangeRequestModel integralRecordModel = new IntegralChangeRequestModel();
        integralRecordModel.setSysCompanyId(memeberDetail.getSysCompanyId());
        integralRecordModel.setBrandId(memeberDetail.getBrandId());
        integralRecordModel.setMemberCode(memeberDetail.getMemberCode());
        //BusinessTypeEnum  会员定义的任务类型
        // BusinessTypeEnum.TASK_TYPE_PREFECT.getCode()
        integralRecordModel.setBusinessType("26");
        //2=收入积分(新增积分)      1=支出积分(减少积分)
        integralRecordModel.setChangeType(IntegralChangeTypeEnum.Expend.getCode());
        integralRecordModel.setChangeBills(couponRecordCode);
        integralRecordModel.setChangeIntegral(exchangeNum * exchangePrice);
        return integralChangeApiService.integralChangeOperate(integralRecordModel);
    }

    //插入记录表
    public MktConvertCouponRecordPO InsertMktConvertCouponRecordPO(CouponRecordVO vo, MktCouponIntegralExchangePO mktCouponIntegralExchangePO, Integer exchangeNum, Integer exchangePrice, String couponRecordCode, MemberInfoModel memeberDetail) {
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
        return record;
    }

    //查询已兑换券列表
    @Override
    public ResponseData<PageInfo<MktConvertCouponRecordPO>> getConvernConpouByMember(CouponRecordVO vo) {
        ResponseData<PageInfo<MktConvertCouponRecordPO>> responseData = new ResponseData<>();
        PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
        MktConvertCouponRecordPOExample example = new MktConvertCouponRecordPOExample();
        example.createCriteria().andMemberCodeEqualTo(vo.getMemberCode()).andValidEqualTo(Boolean.TRUE);
        List<MktConvertCouponRecordPO> mktConvertCouponRecordPOS = mktConvertCouponRecordPOMapper.selectByExampleWithBLOBs(example);
        PageInfo<MktConvertCouponRecordPO> page = new PageInfo<>(mktConvertCouponRecordPOS);
        responseData.setData(page);
        return responseData;
    }


}
