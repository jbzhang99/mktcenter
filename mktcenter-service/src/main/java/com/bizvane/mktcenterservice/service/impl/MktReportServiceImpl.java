package com.bizvane.mktcenterservice.service.impl;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.bizvane.couponservice.common.utils.QiNiuUtil;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bizvane.centerstageservice.models.po.FileTaskPo;
import com.bizvane.centerstageservice.rpc.FileTaskServiceRpc;
import com.bizvane.mktcenterfacade.interfaces.ReportTempService;
import com.bizvane.mktcenterfacade.models.po.FileReportTempPO;
import com.bizvane.mktcenterfacade.models.requestvo.exvo.ExportStoreVo;
import com.bizvane.mktcenterservice.common.utils.POIUtil;
import com.bizvane.utils.tokens.SysAccountPO;

/**
 * @author chen.li
 * @date on 2018/8/11 11:41
 * @description
 *
 */
@Service
public class MktReportServiceImpl implements ReportTempService {
    @Autowired
    private FileTaskServiceRpc fileTaskServiceRpc;
	
	
     @Override
    public void Export(SysAccountPO sysAccountPO,String nameEnd,String jsonStr,FileReportTempPO fileReportTempPOlist){ 
    	 Long taskId = (long) Integer.parseInt(String.valueOf(UUID.randomUUID().hashCode()).replaceAll("-", ""));
    	 FileTaskPo fileTaskPo = new FileTaskPo();
    	 fileTaskPo.setTaskId(taskId);
    	 

       		
	        
         new Thread(() -> {
	       	try {
		       		
		       		JSONArray arr=null;
		       		if(nameEnd.equals("_cycle")) {
		       			
		       			Map<String,JSONObject> mapjsonObje=new TreeMap<String,JSONObject>();
		       			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		       			arr=new JSONArray();
				        if(jsonStr!=null&&jsonStr.startsWith("{")&&jsonStr.endsWith("}")){
				           JSONObject json = JSONObject.parseObject(jsonStr);  
				           for(Object k : json.keySet()){
					               JSONObject jsonObject1 = JSONObject.parseObject(json.get(k).toString());
//					               SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					               if(k.toString().length()>9) {
					            	   jsonObject1.put("time", k.toString().substring(0,k.toString().length() - 9));
					               }else {
					            	   jsonObject1.put("time",k.toString());
					               }
					               
					              if(k.toString().equals("all")) {
					            	  arr.put(jsonObject1);
					              }else {
										try {
										    Date date;
											date = simpleDateFormat.parse(k.toString());
											long ts = date.getTime();
								             mapjsonObje.put(String.valueOf(ts), jsonObject1);
										} catch (ParseException e) {
											e.printStackTrace();
										}
					            	  
					              }

					               
				           }
				           
				           //排序
				           mapjsonObje = ((TreeMap) mapjsonObje).descendingMap();
				           for (String key : mapjsonObje.keySet()) {
				        	   arr.put(mapjsonObje.get(key));
				            }
			           
				       }
		       			
		       		}else {
		       			 arr=new JSONArray(jsonStr);
		       		}
	       		
		
		             //  创建人等信息必填
		             fileTaskPo.setTaskId(taskId);
		             fileTaskPo.setFileId(String.valueOf(taskId));
		             fileTaskPo.setTaskTypeCode(String.valueOf(arr.length()) + "条");
		             fileTaskPo.setTaskName(fileReportTempPOlist.getTemplateName()+nameEnd);
		             if(sysAccountPO != null) {
		            	 fileTaskPo.setSysCompanyId(sysAccountPO.getSysCompanyId());
		                 fileTaskPo.setSysBrandId(sysAccountPO.getBrandId());
		                 fileTaskPo.setCreateUserId(sysAccountPO.getSysAccountId());
		                 fileTaskPo.setCreateUserName(sysAccountPO.getName());
		             }
		             fileTaskPo.setCreateDate(new Date());
		             fileTaskPo.setFileStatus(0L);
		             fileTaskPo.setFileType("EXPORT");
		             fileTaskPo.setValid(true);
		             fileTaskServiceRpc.addFileTask(fileTaskPo);

    	            String  qiniuUrl=null;
	       			
	     			Map<Integer,String> map=new HashMap<Integer,String>();
	     			Map<String,String> mapbiaotou=new HashMap<String,String>();
	     			int i=1;
	     			for(String string :fileReportTempPOlist.getReportData().split(",")) {
	     				map.put(i++, string);
	     			}
	     			 i=1;
	     			for(String string :fileReportTempPOlist.getReportDataName().split(",")) {
	     				mapbiaotou.put(string, map.get(i++));

	     			}
		             fileTaskPo.setFileStatus(30L);
		             fileTaskServiceRpc.update(fileTaskPo);
	     			 //Excel导出工具类
	     		    POIUtil<ExportStoreVo> poiUtil = new POIUtil<>();
	     		    //生成输出流
	     		    OutputStream out = new ByteArrayOutputStream();
	     		    
		             fileTaskPo.setFileStatus(80L);
		             fileTaskServiceRpc.update(fileTaskPo);
		              //导出表格
	     		     poiUtil.exportExcel(out,fileReportTempPOlist.getTemplateName(), arr, nameEnd,mapbiaotou,map);
	     			 ByteArrayInputStream in = new ByteArrayInputStream(((ByteArrayOutputStream) out).toByteArray());
	     			  //时间格式化
	     			  SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
	     			 String filename =fileReportTempPOlist.getTemplateName()+nameEnd+ format.format(new Date());
		             //压缩包导出
	                 ByteArrayOutputStream tempByteOStream = null;
	                 BufferedOutputStream tempBufferOStream = null;
	                 ZipOutputStream tempZStream = null;
	                 ZipEntry tempEntry = null;

	                 tempByteOStream = new ByteArrayOutputStream();
	                 tempZStream = new ZipOutputStream(tempByteOStream);
	                 tempBufferOStream = new BufferedOutputStream(tempZStream);
                     tempEntry = new ZipEntry(filename+".xlsx");
                     tempZStream.putNextEntry(tempEntry);
                     int len = 0;
                     byte[] buff = new byte[1024];
                     while ((len = in.read(buff)) != -1) {
                         tempZStream.write(buff, 0, len);
                     }
	     			 
                     
                     tempBufferOStream.flush();
                     tempByteOStream.flush();
                     tempZStream.closeEntry();
                     tempZStream.close();
                     tempByteOStream.close();
                     tempBufferOStream.close();
                     ByteArrayInputStream into = new ByteArrayInputStream(((ByteArrayOutputStream) tempByteOStream).toByteArray());
                     
                     //压缩包导出
	     			 
	     			 fileTaskPo.setFileStatus(99L);
		             fileTaskServiceRpc.update(fileTaskPo);

	     			  
	     			    qiniuUrl = "https://"+ QiNiuUtil.upload(into, filename+ ".zip");
	     			  System.out.println("报表上传到七牛ReportIncomeController："+qiniuUrl);
	     			  in.close();
	     			  out.close();
	     			  
	                   //保存成功会写数据库
	                   fileTaskPo.setFileStatus(100l);
	                   fileTaskPo.setFileUnl(qiniuUrl);
	        		   fileTaskServiceRpc.update(fileTaskPo);
	     			  
	       		} catch (JSONException e) {
	       			e.printStackTrace();
	     			 fileTaskPo.setFileStatus(-1L);
		             fileTaskServiceRpc.addFileTask(fileTaskPo);
	       		} catch (IOException e) {
					e.printStackTrace();
	     			 fileTaskPo.setFileStatus(-1L);
		             fileTaskServiceRpc.addFileTask(fileTaskPo);
				}
	       		
         }).start(); 
	       		
    }
}
