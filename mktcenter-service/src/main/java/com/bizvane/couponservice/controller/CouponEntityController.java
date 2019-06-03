package com.bizvane.couponservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.centerstageservice.models.po.SysAccountPo;
import com.bizvane.couponfacade.es.CouponEntityInfoSearchPojo;
import com.bizvane.couponfacade.models.vo.CouponDetailResponseVO;
import com.bizvane.couponfacade.models.vo.CouponEntityVO;
import com.bizvane.couponfacade.models.vo.CouponSendLogExportVO;
import com.bizvane.couponfacade.models.vo.QiNiuVo;
import com.bizvane.couponfacade.utils.PageFormUtil;
import com.bizvane.couponservice.common.constants.SysResponseEnum;
import com.bizvane.couponservice.common.utils.HttpUtils;
import com.bizvane.couponservice.common.utils.POIUtil;
import com.bizvane.couponservice.common.utils.QiNiuLocation;
import com.bizvane.couponservice.common.utils.QiNiuUtil;
import com.bizvane.couponservice.service.CouponEntityService;
import com.bizvane.couponservice.service.FileTaskService;
import com.bizvane.utils.responseinfo.ResponseData;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/couponEntity")
public class CouponEntityController {
    private static final Logger logger = LoggerFactory.getLogger(CouponEntityController.class);

    @Autowired
    private CouponEntityService couponEntityService;

    @Autowired
    private FileTaskService fileTaskService;


    /**
     * 券的发放记录列表
     *
     * @param vo
     * @return
     */
    @ApiOperation(value = "券的发放记录列表", notes = "券的发放记录列表", tags = {"券的发放记录"}, httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "createDtStart", value = "发券开始时间", required = true, dataType = "String"),
            @ApiImplicitParam(name = "createDtEnd", value = "发券结束时间", required = true, dataType = "String"),
            @ApiImplicitParam(name = "couponDefinitionId", value = "券定义id", required = true, dataType = "String"),
            @ApiImplicitParam(name = "memberCode", value = "会员号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "couponCode", value = "券号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "couponName", value = "券名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "isUse", value = "是否使用", required = true, dataType = "Boolean"),
            @ApiImplicitParam(name = "preferentialType", value = "优惠类型（1现金，2折扣，3礼品）", required = true, dataType = "Byte"),
            @ApiImplicitParam(name = "sendType", value = "发送类型：10-开卡发券，15生日发券，105-受赠，115-积分兑换）", required = true, dataType = "Byte"),

            @ApiImplicitParam(name = "createDate", value = "发券时间", required = true, dataType = "Date"),
            @ApiImplicitParam(name = "validDateStart", value = "有效期开始", required = true, dataType = "Date"),
            @ApiImplicitParam(name = "validDateEnd", value = "有效期结束", required = true, dataType = "Date")
    })
    @ResponseBody
    @RequestMapping(value = "/getListOld", method = RequestMethod.POST)
    ResponseData<PageInfo<CouponEntityVO>> getListOld(CouponEntityVO vo, HttpServletRequest request, PageFormUtil pageForm) {
        logger.info("enter getList method param: CouponEntityVO:{},PageFormUtil:{}", vo, pageForm);
        SysAccountPo accountPo = HttpUtils.getLoginUser(request);
        return couponEntityService.getList(vo, accountPo, pageForm);

    }
    
    @ResponseBody
    @RequestMapping(value = "/getList", method = RequestMethod.POST)
    ResponseData<PageInfo<CouponEntityInfoSearchPojo>> getList(CouponEntityVO vo, HttpServletRequest request, PageFormUtil pageForm) {
        logger.info("enter getList method param: CouponEntityVO:{},PageFormUtil:{}", vo, pageForm);
        SysAccountPo accountPo = HttpUtils.getLoginUser(request);
        return couponEntityService.getListEs(vo, accountPo, pageForm);

    }


    /**
     * 券发放总数查询
     * @param entityParam
     * @param request
     * @return
     */
    @RequestMapping("/getCouponTotal")
    ResponseData<Long> getCouponTotal(CouponEntityVO entityParam,HttpServletRequest request){
       /* logger.info("enter getList method param: CouponEntityVO:{}",entityParam);
        SysAccountPo accountPo = HttpUtils.getLoginUser(request);
        return couponEntityService.getCouponTotal(entityParam,s);*/
       return null;

    }



    /**
     * 券的发放记录详细查询
     *
     * @return
     */
    @ApiOperation(value = "券的发放记录详细", notes = "券的发放记录详细", tags = {"券的发放记录"}, httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "couponEntityId", value = "券实例id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "couponDefinitionId", value = "券定义id", required = true, dataType = "Long")
    })
    @ResponseBody
    @RequestMapping(value = "/getAll", method = RequestMethod.POST)
    ResponseData<CouponDetailResponseVO> getAll(@RequestParam(value = "couponEntityId", required = false) Long couponEntityId,
                                                @RequestParam(value = "couponDefinitionId", required = false) Long couponDefinitionId) {
        logger.info("enter getAll method param: couponEntityId:{},couponDefinitionId:{}", couponEntityId, couponDefinitionId);
        return couponEntityService.getCouponEntityAndDefinitionById(couponEntityId, couponDefinitionId);
    }


    /**
     * 券的发放记录导出
     *
     * @return
     */
    @RequestMapping(value = "/exportExcel1", method = RequestMethod.POST)
    @ApiOperation(value = "券的发放记录导出", notes = "券的发放记录导出", tags = {"券的发放记录"})
    public ResponseData<String> exportExcel1(CouponEntityVO vo, HttpServletRequest request) {
        logger.info("enter exportExcel method param: CouponEntityVO:{}", JSONObject.toJSONString(vo));
        ResponseData responseData = new ResponseData();

        SysAccountPo accountPo = HttpUtils.getLoginUser(request);
        List<CouponSendLogExportVO> entityPOList = couponEntityService.getListExport(vo, accountPo);

        QiNiuUtil qiNiuUtil = new QiNiuUtil();
        StringBuffer qiNiuUrl = null;
        try {
            //Excel导出工具类
            POIUtil<CouponSendLogExportVO> poiUtil = new POIUtil<>();
            //导出的标题列
            String[] headers = {"发券时间", "券号", "券定义ID", "券名称", "优惠形式", "有效期", "是否使用", "手机号", "会员卡号"};
            //时间格式化
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
            //要保存的文件名
            String filename = "Coupon_" + format.format(new Date()) + ".xls";

            //生成输出流
            OutputStream out = new ByteArrayOutputStream();

            //实例化Excel表格
            HSSFWorkbook workbook = new HSSFWorkbook();
            //创建工作表单
            String[] sheetNames = {"coupon_send_log"};
            for (int i = 0; i < sheetNames.length; i++) {
                workbook.createSheet(sheetNames[i]);
            }
            //导出到Excel
            poiUtil.exportExcel(sheetNames[0], headers, entityPOList, out, "yyyy-MM-dd HH:mm", workbook);
            QiNiuVo upload = null;
            try {
                //保存文件
                workbook.write(out);
                ByteArrayInputStream in = new ByteArrayInputStream(((ByteArrayOutputStream) out).toByteArray());
               // upload = qiNiuUtil.upload(QiNiuLocation.CENTERSTAGE.getBucket(), in, filename);
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.close();
            //将导出的excel文件上传到七牛服务器
            qiNiuUrl = new StringBuffer();
            qiNiuUrl.append("http://").append(QiNiuLocation.CENTERSTAGE.getDomain()).append(File.separator).append(upload.getUrl());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /*if (tempFile != null && tempFile.exists()) {
                tempFile.delete();// 删除临时文件
            }*/
        }

        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setData(qiNiuUrl.toString());
        responseData.setMessage("数据导出成功");
        return responseData;

    }



    /**
     * 券的发放记录导出
     * @return
     */
    @RequestMapping(value = "/exportExcel", method = RequestMethod.POST)
    @ApiOperation(value = "券的发放记录导出", notes = "券的发放记录导出", tags = {"券的发放记录"})
    public ResponseData<String> exportExcel(CouponEntityVO vo, HttpServletRequest request) {
        logger.info("enter exportExcel method param: CouponEntityVO:{}", JSONObject.toJSONString(vo));
        ResponseData responseData = new ResponseData();

        SysAccountPo accountPo = HttpUtils.getLoginUser(request);

        try {
            responseData = fileTaskService.exportEntityExcel(vo, accountPo);
        }catch(Exception e){
            logger.info("enter CouponEntityController exportExcel method! Exception:{}",JSONObject.toJSONString(e));
        }


        return responseData;

    }



}