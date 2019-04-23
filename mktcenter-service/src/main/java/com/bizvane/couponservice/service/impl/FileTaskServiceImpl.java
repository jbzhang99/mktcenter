package com.bizvane.couponservice.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.centerstageservice.models.po.FileTaskPo;
import com.bizvane.centerstageservice.models.po.SysAccountPo;
import com.bizvane.centerstageservice.models.vo.SysStoreVo;
import com.bizvane.centerstageservice.rpc.FileTaskServiceRpc;
import com.bizvane.centerstageservice.rpc.StoreServiceRpc;
import com.bizvane.couponfacade.models.vo.CouponEntityVO;
import com.bizvane.couponfacade.models.vo.CouponStatusEntitySuccessVO;
import com.bizvane.couponservice.common.constants.SysResponseEnum;
import com.bizvane.couponfacade.constants.CouponConstants;
import com.bizvane.couponservice.common.utils.DateUtil;
import com.bizvane.couponservice.common.utils.QiNiuUtil;
import com.bizvane.couponservice.common.utils.StreamingExportExcelUtil;
import com.bizvane.couponservice.mappers.CouponEntityPOMapper;
import com.bizvane.couponservice.service.FileTaskService;
import com.bizvane.couponservice.service.StreamingCallBack;
import com.bizvane.members.facade.service.api.WxChannelInfoApiService;
import com.bizvane.utils.responseinfo.ResponseData;
import org.apache.poi.ss.usermodel.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.bizvane.couponservice.common.utils.FileNameUtil.DATE_YYYYMMDDHHMMSS_MIDDLE;

/**
 * @date 
 */
@Service
public class FileTaskServiceImpl implements FileTaskService {

    Logger logger = LoggerFactory.getLogger(FileTaskServiceImpl.class);

    @Autowired
    private CouponEntityPOMapper couponEntityPOMapper;

    @Autowired
    private FileTaskServiceRpc fileTaskServiceRpc;
    
    @Autowired
    private StoreServiceRpc storeServiceRpc;
    
    @Autowired
    private WxChannelInfoApiService wxChannelInfoApiService;


    /**
     * 导出券发放记录
     * @param entityVO
     * @param accountPo
     * @throws MessagingException
     */
    @Override
    public ResponseData <String> exportEntityExcel(CouponEntityVO entityParam, SysAccountPo accountPo) {

        logger.info("enter FileTaskServiceImpl exportEntityExcel method !");

        ResponseData<String> responseData = new ResponseData<>();
        //大于=5个返回code=100，message=同时导出任务个数最多5个，无法导出！
        ResponseData<String> findFileTaskNumResponseData =   fileTaskServiceRpc.findFileTaskNum(accountPo.getSysAccountId());
        if(findFileTaskNumResponseData.getCode()>0) {
        	 return findFileTaskNumResponseData;
        }
        
        Long taskId =  (long) Integer.parseInt(String.valueOf(UUID.randomUUID().hashCode()).replaceAll("-", ""));
        String fileName = "券发放记录导出"+ DateUtil.format(new Date(),DATE_YYYYMMDDHHMMSS_MIDDLE);

        CouponStatusEntitySuccessVO successVO = new CouponStatusEntitySuccessVO();
        //successVO.setCouponStatusSyncSuccess(CouponConstants.COUPON_STATUS_SYNC_SUCCESS);
        successVO.setCouponStatusUnused(CouponConstants.COUPON_STATUS_UNUSED);
        successVO.setCouponStatusOverdue(CouponConstants.COUPON_STATUS_OVERDUE);
        successVO.setCouponStatusUsed(CouponConstants.COUPON_STATUS_USED);
        
        if(entityParam.getListType().equals("1")) {
            entityParam.setListType("85");
            entityParam.setListTypeBusinessName("任务名称");
        }else if(entityParam.getListType().equals("2")) {
            entityParam.setListType("10,15,30,35,45,50,55,56,90,100,103,104,105");
            entityParam.setListTypeBusinessName("活动名称");
        }else if(entityParam.getListType().equals("3")) {
            entityParam.setListType("60,65,70,75,80");
            entityParam.setListTypeBusinessName("任务名称");
        }else if(entityParam.getListType().equals("4")) {
            entityParam.setListType("95");
            entityParam.setListTypeBusinessName("分组名称");
        }else if(entityParam.getListType().equals("5")) {
            entityParam.setListType("94");
            entityParam.setListTypeBusinessName("智能营销");
        }else if(entityParam.getListType().equals("6")) {
            entityParam.setListType("20");
            entityParam.setListTypeBusinessName("编号");
        }else if(entityParam.getListType().equals("7")) {
            entityParam.setListType("101");
            entityParam.setListTypeBusinessName("积分订单");
        }else if(entityParam.getListType().equals("8")) {
            entityParam.setListType("102");
            entityParam.setListTypeBusinessName("导购名称/工号");
        }
        
        int  count = couponEntityPOMapper.findListExportByConditionscount(entityParam,successVO,accountPo.getBrandId(),null,null);

        if(count == 0){
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setMessage(SysResponseEnum.OPERATE_FAILED_DATA_NOT_EXISTS.getMessage());
            return responseData;
        }
        if(count >500000) {
            responseData.setCode(SysResponseEnum.FAILED.getCode());
            responseData.setData(String.valueOf(count));
            responseData.setMessage("最多导出50万条数据");
            return responseData;
        	
        }

        StreamingExportExcelUtil<CouponEntityVO> exportExcelUtil = new StreamingExportExcelUtil<CouponEntityVO>(Long.parseLong(count+""));
        //添加导出任务
        FileTaskPo fileTaskPo = addExportTask(accountPo,taskId,fileName,count);
        //设置导出进度监控id
        exportExcelUtil.setExportProcessId(taskId);
        //导出数据
        new Thread(() -> {
            try {
                Method method = couponEntityPOMapper.getClass().getMethod("findListExportByConditions",CouponEntityVO.class,CouponStatusEntitySuccessVO.class,Long.class,Long.class,Long.class);
                exportExcelUtil.read("couponEntityPOMapper",method, new StreamingCallBack<CouponEntityVO>() {
                    @Override
                    public void onCompletion(CouponEntityVO couponLogVO, Row row) {

                        if(row.getRowNum() == 0){
                        	
                            row.createCell(0).setCellValue(entityParam.getListTypeBusinessName());
                            row.createCell(1).setCellValue("会员姓名");
                            row.createCell(2).setCellValue("会员手机号");
                            row.createCell(3).setCellValue("会员卡号");
                            
                            row.createCell(4).setCellValue("券名称");
                            row.createCell(5).setCellValue("券号");
                            row.createCell(6).setCellValue("券定义ID");
                            row.createCell(7).setCellValue("发送时间");
                            row.createCell(8).setCellValue("券状态");
                          //  ：订单号、订单金额、成交金额、核销时间；核销门店、
                            row.createCell(9).setCellValue("订单号");
                            row.createCell(10).setCellValue("订单金额");
                            row.createCell(11).setCellValue("成交金额");
                            row.createCell(12).setCellValue("核销时间");
                            row.createCell(13).setCellValue("核销门店");
                            
                            
                            
                        }else{
                            try {


                                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                row.createCell(0).setCellValue(couponLogVO.getBusinessName() == null?"":couponLogVO.getBusinessName());
                                row.createCell(1).setCellValue(couponLogVO.getName() == null?"":couponLogVO.getName());
                                row.createCell(2).setCellValue(couponLogVO.getPhone() == null?"":couponLogVO.getPhone());
                                row.createCell(3).setCellValue(couponLogVO.getCardNo() == null?"":couponLogVO.getCardNo());

                                row.createCell(4).setCellValue(couponLogVO.getCouponName() == null?"":couponLogVO.getCouponName());
                                row.createCell(5).setCellValue(couponLogVO.getCouponCode() == null?"":couponLogVO.getCouponCode());
                                row.createCell(6).setCellValue(couponLogVO.getCouponDefinitionId() == null?"":couponLogVO.getCouponDefinitionId());
                                row.createCell(7).setCellValue(couponLogVO.getCreateDate() == null?"":format.format(couponLogVO.getCreateDate()));
                                //20-未使用，25-已过期，30-已核销
                                String valueName=couponLogVO.getCouponStatus().toString();
                                if(couponLogVO.getCouponStatus()==20){
                                	 valueName="未使用";
                                }else if(couponLogVO.getCouponStatus()==25) {
                                	 valueName="已过期";
                                }else if(couponLogVO.getCouponStatus()==30) {
                                	 valueName="已核销";
                                }
                                row.createCell(8).setCellValue(valueName);
                                //  ：订单号、订单金额、成交金额、核销时间；核销门店、
                                row.createCell(9).setCellValue(couponLogVO.getUseBusinessCode()== null?"":couponLogVO.getUseBusinessCode());
                                row.createCell(10).setCellValue(couponLogVO.getUseBusinessAmount()== null?"":couponLogVO.getUseBusinessAmount()+"");
                                row.createCell(11).setCellValue(couponLogVO.getUseBusinessAmount()== null?"":couponLogVO.getUseBusinessAmount()+"");
                                row.createCell(12).setCellValue(couponLogVO.getUseTime() == null?"":format.format(couponLogVO.getUseTime()));
                                if(couponLogVO.getUseStoreId()!=null) {
          	                      //更具店铺id找群主名称
                                	  List<String> storellist =new ArrayList<>();
                                	  storellist.add(couponLogVO.getUseStoreId()+"");
                                	  SysStoreVo sysStoreVo=new SysStoreVo();
          			    		  sysStoreVo.setStoreIds(storellist);
          			    		  sysStoreVo.setSysCompanyId(couponLogVO.getSysCompanyId());
          				    	  ResponseData<Map<String, SysStoreVo>> getStore	=  storeServiceRpc.getStoreGroupNameByStoreCodes(sysStoreVo);
          				    	  Map<String, SysStoreVo> storeVoMap=  getStore.getData();
          				    	  SysStoreVo storeVo=  storeVoMap.get(couponLogVO.getUseStoreId()+"");
          				    	  String getStoreName=storeVo.getStoreName();
                                  row.createCell(13).setCellValue(getStoreName);
                          	   }else {
                                	// 	核销来源 1CRM后台、3微商城、4线下、5导购助手
                          		   	if(couponLogVO.getUseFrom()==null) {
                          		   	row.createCell(13).setCellValue("");
                                	}else if(couponLogVO.getUseFrom()==5) {
                                		row.createCell(13).setCellValue("导购助手");
                                	}else if(couponLogVO.getUseFrom()==3) {
                                		row.createCell(13).setCellValue("微商城");
                                	}else if(couponLogVO.getUseFrom()==1) {
                                		row.createCell(13).setCellValue("CRM后台");
                                	}else {
                                	  row.createCell(13).setCellValue("");
                                	}
                                }
                                
                                
                            }catch (Exception e){
                                logger.info("enter FileTaskServiceImpl exportEntityExcel Error:{}",e);
                            }

                        }

                    }
                }, entityParam,successVO,accountPo.getBrandId());

            }catch(Exception e){
                logger.info("FileTaskServiceImpl exportEntityExcel method error ! Exception:{}", JSONObject.toJSONString(e));
            }
        }).start();
        //监控导出百分比
        monitorExportPercentage(fileName,fileTaskPo,exportExcelUtil);

        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        return responseData;
    }


    /**
     * 新增任务
     * @param accountPo
     * @param taskId
     * @param fileName
     * @param count
     * @return
     */
    public FileTaskPo addExportTask(SysAccountPo accountPo,Long taskId,String fileName,int count){

        FileTaskPo taskPO = new FileTaskPo();

        taskPO.setSysCompanyId(accountPo.getSysCompanyId());
        taskPO.setSysBrandId(accountPo.getBrandId());
        taskPO.setTaskId(taskId);
        taskPO.setFileName(fileName);
        taskPO.setCreateUserId(accountPo.getSysAccountId());
        taskPO.setCreateUserName(accountPo.getName());
       // taskPO.setCreateDate(TimeUtils.getNowTime());
        taskPO.setValid(CouponConstants.TABLE_VALID_EFFECTIVE);
        taskPO.setTaskName(SysResponseEnum.COUPON_EXPORT_LOG.getMessage());
        taskPO.setTaskTypeCode(count+"条");
        taskPO.setFileStatus(0L);
        //taskPO.setFileTaskDate(TimeUtils.getNowTime());
        taskPO.setFileType(CouponConstants.FILE_TYPE_EXPORT);
        ResponseData<String> responseData = fileTaskServiceRpc.addFileTask(taskPO);

        taskPO.setFileTaskId(Long.parseLong(responseData.getData()));
        return taskPO;

    }

    /**
     * 监控导出百分比
     * @param exportFileName
     * @param fileTaskPo
     * @param exportExcelUtil
     */
    private void monitorExportPercentage(String exportFileName, FileTaskPo fileTaskPo, StreamingExportExcelUtil exportExcelUtil){
        new Thread(() -> {
            try {
                BigDecimal process = null;
                do {
                    process = StreamingExportExcelUtil.getExportPercentageProcess(fileTaskPo.getTaskId());
                    if (process.compareTo(new BigDecimal(0)) < 0) {
                        // 导出报错
                        fileTaskPo.setFileStatus(-1L);
                        fileTaskServiceRpc.update(fileTaskPo);
                        break;
                    } else if (process.compareTo(new BigDecimal(1)) == 0) {
                        // 导出完成，由于需要上传文件到七牛，强制的将导出进去写为99%
                        fileTaskPo.setFileStatus(99L);
                        fileTaskServiceRpc.update(fileTaskPo);
                        OutputStream out = new ByteArrayOutputStream();
                        exportExcelUtil.exprotToZipOutputStream(out,exportFileName+".xlsx",exportFileName+".zip");
                        ByteArrayInputStream in = new ByteArrayInputStream(
                                ((ByteArrayOutputStream) out).toByteArray());
                        String qiniuUrl = QiNiuUtil.upload(in, exportFileName+".zip");
                        logger.info("enter FileTaskServiceImpl monitorExportPercentage method param:qiniuUrl:{}",qiniuUrl);
                        in.close();
                        out.close();
                        //上传文件成功，将导出进度改为100%
                        fileTaskPo.setFileStatus(100L);
                        fileTaskPo.setFileUnl(qiniuUrl);
                        fileTaskServiceRpc.update(fileTaskPo);
                        break;
                    }
                    fileTaskPo.setFileStatus(process.multiply(new BigDecimal(100)).longValue());
                    fileTaskServiceRpc.update(fileTaskPo);
                    Thread.sleep(1000);
                } while (true);

            } catch (Exception e) {
                // 导出报错
                fileTaskPo.setFileStatus(-1L);
                fileTaskServiceRpc.update(fileTaskPo);
                e.printStackTrace();
            }
        }).start();
    }

  }




