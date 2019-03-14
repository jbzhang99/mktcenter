package com.bizvane.messageservice.service.impl;

import com.bizvane.centerstageservice.models.po.FileTaskPo;
import com.bizvane.centerstageservice.models.vo.SysAccountVo;
import com.bizvane.couponservice.common.utils.QiNiuUtil;
import com.bizvane.messageservice.common.constants.SysResponseEnum;
import com.bizvane.messageservice.common.constants.SystemConstants;
import com.bizvane.messageservice.mappers.MsgCoupontimePOMapper;
import com.bizvane.messageservice.service.MsgCouponTimeService;
import com.bizvane.messageservice.wxpublicapi.StreamingExportExcelUtil;
import com.bizvane.messagefacade.models.po.MsgCoupontimePO;
import com.bizvane.messagefacade.models.po.MsgCoupontimePOExample;
import com.bizvane.utils.responseinfo.ResponseData;
import com.bizvane.utils.tokens.SysAccountPO;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Geng on 2018/8/20.
 */
@Service
@Slf4j
public class MsgCouponServiceImpl implements MsgCouponTimeService {


    @Autowired
    private MsgCoupontimePOMapper msgCoupontimePOMapper;
    
//    @Autowired
//    private FileTaskServiceRpc fileTaskServiceRpc;
    

    /**
     * 持久化消息到期设置入数据库
     * @param sendTimeStart
     * @param sendTimeEnd
     * @param stageUser
     * @return
     */
    @Override
    public ResponseData<Long> saveSendTime(long days,  SysAccountPO stageUser) {
    	ResponseData<Long>  responseData = new ResponseData<Long> ();

        MsgCoupontimePOExample MsgCoupontimePOExample = new MsgCoupontimePOExample();
        MsgCoupontimePOExample.createCriteria().andValidEqualTo(true).andSysBrandIdEqualTo(stageUser.getBrandId());
        MsgCoupontimePO record = new MsgCoupontimePO();
        record.setModifiedDate(new Date());
        record.setModifiedUserId(stageUser.getSysAccountId());
        record.setCreateUserName(stageUser.getModifiedUserName());
        record.setValid(false);

        msgCoupontimePOMapper.updateByExampleSelective(record,MsgCoupontimePOExample);
        //新增
    
        record.setCreateDate(new Date());
        record.setCreateUserId(stageUser.getSysAccountId());
        record.setCreateUserName(stageUser.getCreateUserName());
        record.setSysBrandId(stageUser.getBrandId());
        record.setDays(days);
        record.setValid(true);
        int insert=   msgCoupontimePOMapper.insert(record);

        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        responseData.setData((long) insert);
        return responseData;
    }
    
    
//	导出任务例子	,插入一条任务日志5%，查询数据》生成表格98%（任务时间同步到任务日志），保存表格七牛，最后回写任务日志100%
    @Override
	public ResponseData<Long> testCoupon() {
		
         //插入导出任务
         Long taskId =  (long) Integer.parseInt(String.valueOf(UUID.randomUUID().hashCode()).replaceAll("-", ""));
		//      	查找一共要导出多少行数据
		      MsgCoupontimePOExample MsgCoupontimePOExample  =  new MsgCoupontimePOExample();
		      List<MsgCoupontimePO> selectByExamplete =  msgCoupontimePOMapper.selectByExampletest(MsgCoupontimePOExample, 1L, 100L);
		      long sum=selectByExamplete.size();
		          //  以下字段必填
		//        SysAccountPO sysAccountPO = TokenUtils.getStageUser(request);
		       	FileTaskPo FileTaskPoNEW =new FileTaskPo();
		       	FileTaskPoNEW.setTaskId(taskId);
		       	FileTaskPoNEW.setSysBrandId(1l);
		        FileTaskPoNEW.setCreateUserId(1111111111111l);
		        FileTaskPoNEW.setCreateUserName("test");
		       	FileTaskPoNEW.setTaskTypeCode(String.valueOf(sum)+"条");//任务记录
		       	FileTaskPoNEW.setTaskName("短信test导出任务");
		      	FileTaskPoNEW.setFileStatus(5L);
		      	FileTaskPoNEW.setValid(true);
//		      	文件类型（导入IMPORT，导出EXPORT）',
		      	FileTaskPoNEW.setFileType("IMPORT");
		      	
//		      	fileTaskServiceRpc.addFileTask(FileTaskPoNEW);
		      	
		      //new线程安全的原子类，
		 AtomicInteger    account = new AtomicInteger();
         new Thread(() -> { 
        	 //++操作
        	 account.incrementAndGet();

                 StreamingExportExcelUtil<MsgCoupontimePO> exportExcelUtil = new StreamingExportExcelUtil<>(sum);
                 try {
                 	exportExcelUtil.setExportProcessId(taskId);
                     Method method = msgCoupontimePOMapper.getClass().getMethod("selectByExampletest",MsgCoupontimePOExample.class,Long.class,Long.class);
                     exportExcelUtil.read("msgCoupontimePOMapper", method,(model, row) -> {
                     	if(row.getRowNum()==0) {
                     		  Cell cell0 = row.createCell(0);
                               cell0.setCellValue("TaskId");
                               Cell cell1 = row.createCell(1);
                               cell1.setCellValue("UNl");
                     	}else {
                     		
                         Cell cell0 = row.createCell(0);
                         cell0.setCellValue(model.getSysBrandId());
                         Cell cell1 = row.createCell(1);
                         cell1.setCellValue(model.getValid());
//                         cell1.setCellValue(model.getStatus() == 0 ? "禁用" : "启用");
                     	}
                     },MsgCoupontimePOExample);
                     
//        			  上传到七牛TODO，会写地址，进度完成100%
//                     OutputStream out = new ByteArrayOutputStream();
//                     exportExcelUtil.exportToOutputStream(out);
//                     ByteArrayInputStream in = new ByteArrayInputStream(((ByteArrayOutputStream) out).toByteArray());
//                     String  qiniuUrl = QiNiuUtil.upload(in, FileNameUtil.getExtendPropertyExcelFileName());
//	                 in.close();
//	                 out.close();
	                 
	                 
	                 
	                 //生成模板例子
	                 File file = new File("C:\\Users\\pc1\\Desktop\\tem\\线上店铺编号导入模板.xlsx");
	                 InputStream inputStream = new FileInputStream(file);
	                 String  qiniuUrl2 = QiNiuUtil.upload(inputStream, "FileImportTemp_"+"ONLINE_SHOP_CODE_TEM.xlsx");
	                 log.info("地址!"+qiniuUrl2);
                     
//	                 ResponseData<FileImportTempPo>  qwew =fileTaskServiceRpc.getUrlByFileTemplateType("BUKL_IMPORT_LABEL");
         			//保存成功会写数据库
//         			FileTaskPoNEW.setFileStatus(100l);
//         			FileTaskPoNEW.setFileUnl(qiniuUrl);
//                     GenrealSendMessageVO vo =new  GenrealSendMessageVO();
//                     vo.setMemberName("批量");
//                     vo.setSysBrandId(111L);
//                     vo.setTaskId(1111111L);
//                     vo.setTemplateType("BATCH_TEMPLATE_MESSAGE");
//                     vo.setPhoneStr("15677378674,15677371111");
//                     vo.setMessageBody("批量test");
//                     templateMessageServiceFeign.sendGenrealBatch(vo);
//                     
//                     GenrealGetMessageVO genrealGetMessageVO =new GenrealGetMessageVO();
//                     
//                     genrealGetMessageVO.setTaskId(vo.getTaskId());
//                     
//                     ResponseData<SmsStatisticsVO>  getReturnM=  templateMessageServiceFeign.getReturnMessage(genrealGetMessageVO);
                     
//         			fileTaskServiceRpc.update(FileTaskPoNEW);
                 }catch (NoSuchMethodException e) {
                     e.printStackTrace();
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
             }).start();
         
         
		 new Thread(() -> {
			long count = 0;
			do {
				try {
//					休息2秒
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				count = StreamingExportExcelUtil.getExportPercentageProcess(taskId).multiply(new BigDecimal("100")).longValue();
				// 更新进度到缓存 占进度的99%
				FileTaskPoNEW.setFileStatus(count);
//				fileTaskServiceRpc.update(FileTaskPoNEW);

				log.info("处理行数!"+count);

				// 更新进度生成数据 占进度的99%
			} while (count < 99);

		}).start();
    	
    	  
		//返回任务Taskid，前端根据具任务id轮询查询进度，地址centerstage-test/fileTask/getTaskId
		return null;
		
		
	 }

    /**
     * 查询到期设置
     * @param sysBrandId
     * @return
     */

    @Transactional
    @Override
    public ResponseData<MsgCoupontimePO> getSendTime(long sysBrandId) {
    	ResponseData<MsgCoupontimePO>  responseData = new ResponseData<MsgCoupontimePO> ();
    	FileTaskPo fileTaskPo =new FileTaskPo();
        fileTaskPo.setCreateUserId(1l);
        SysAccountVo untVo= new SysAccountVo();
    	
        //查询出该品牌设置

        MsgCoupontimePOExample MsgCoupontimePOExample  =  new MsgCoupontimePOExample();
        MsgCoupontimePOExample.createCriteria().andSysBrandIdEqualTo(sysBrandId).andValidEqualTo(true);
        List<MsgCoupontimePO> MsgCoupontimePOS  = msgCoupontimePOMapper.selectByExample(MsgCoupontimePOExample);
        
         if(MsgCoupontimePOS!=null&MsgCoupontimePOS.size()>0) {
		    responseData.setData(MsgCoupontimePOS.get(0));
		  }else {
			  responseData.setData(new MsgCoupontimePO());
		  }

        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        return responseData;
    }


    /**
     * 查询优惠券到期通知集合
     * @return
     */
    @Override
    public ResponseData<List<MsgCoupontimePO>> getCouponTimeList() {

        ResponseData<List<MsgCoupontimePO>> responseData = new ResponseData<>();

        MsgCoupontimePOExample coupontimePOExample = new MsgCoupontimePOExample();

        coupontimePOExample.createCriteria().andValidEqualTo(SystemConstants.TABLE_VALID_EFFECTIVE);

        List<MsgCoupontimePO> list = msgCoupontimePOMapper.selectByExample(coupontimePOExample);

        responseData.setData(list);
        responseData.setMessage(SysResponseEnum.SUCCESS.getMessage());
        responseData.setCode(SysResponseEnum.SUCCESS.getCode());
        return responseData;
    }


}
