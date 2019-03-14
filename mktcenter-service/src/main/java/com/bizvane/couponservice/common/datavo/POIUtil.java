package com.bizvane.couponservice.common.datavo;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class POIUtil<T> {
	
	public  void exportExcel(OutputStream out,String name,JSONArray ja,String tbName,Map<String,String> map,Map<Integer, String> map2){
        XSSFWorkbook  workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(name);
        XSSFRow row = sheet.createRow(0);
        int index = 0;
        try {
//        JSONObject first = ja.getJSONObject(0); 
//        Iterator<String> iterator = first.keys(); // 得到第一项的key集合 
//        while (iterator.hasNext()) { // 遍历key集合  
//            String key = (String) iterator.next(); // 得到key  
//            if(null!=map.get(key)) {
//            XSSFCell cell = row.createCell(index);
//            	cell.setCellValue(map.get(key));
//            	index++;
//            }
//            
//        }  
        	
//        	时间
        	Map<String,Integer> mapdata=new HashMap<String,Integer>();
        	//表头
	        for (Integer in : map2.keySet()) {
	            XSSFCell cell = row.createCell(index);
            	cell.setCellValue(map2.get(in));
            	index++;
            	mapdata.put(map2.get(in), in);
	        	
	        }
        	        
        
        
        for (int i = 0; i < ja.length(); i++) {
            row = sheet.createRow(i+1);
            JSONObject jaa = ja.getJSONObject(i);
            Iterator<String> iterator1 = jaa.keys();
            int index1 = 0;
            while (iterator1.hasNext()) { // 遍历key集合  
                String key1 = (String) iterator1.next(); // 得到key
                if(null!=map.get(key1)) {
                String value = jaa.getString(key1); 
                 
                XSSFCell cell = row.createCell(mapdata.get(map.get(key1))-1);
                	  cell.setCellValue(value);
                	  index1++;
                }
              
                
            }  
        }
            workbook.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	
	public  void exportExcelSting(OutputStream out,String name,JSONArray ja,String tbName,Map<String,String> map){
        XSSFWorkbook  workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(name);
        XSSFRow row = sheet.createRow(0);
        int index = 0;
        try {
        JSONObject first = ja.getJSONObject(0); 
        Iterator<String> iterator = first.keys(); // 得到第一项的key集合 
        while (iterator.hasNext()) { // 遍历key集合  
            String key = (String) iterator.next(); // 得到key  
            if(null!=map.get(key)) {
            XSSFCell cell = row.createCell(index);
            	cell.setCellValue(map.get(key));
            	index++;
            }
            
        }       
        for (int i = 0; i < ja.length(); i++) {
            row = sheet.createRow(i+1);
            JSONObject jaa = ja.getJSONObject(i);
            Iterator<String> iterator1 = jaa.keys();
            int index1 = 0;
            while (iterator1.hasNext()) { // 遍历key集合  
                String key1 = (String) iterator1.next(); // 得到key
                if(null!=map.get(key1)) {
                String value = jaa.getString(key1); 
                XSSFCell cell = row.createCell(index1);
                	  cell.setCellValue(value);
                	  index1++;
                }
              
                
            }  
        }
            workbook.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public void exportExcel(String title, String headers, Collection<Object> storeVos, OutputStream out, String pattern,HSSFWorkbook workbook)  
    {  
        // 声明一个工作薄   生成一个表格  
        HSSFSheet sheet = workbook.getSheet(title);
        // 设置表格默认列宽度为15个字节  
        sheet.setDefaultColumnWidth((short) 15);  
        // 生成一个样式  
        HSSFCellStyle style = workbook.createCellStyle();  
        // 设置这些样式  
        style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);  
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);  
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);  
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);  
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
        // 生成一个字体  
        HSSFFont font = workbook.createFont();  
        font.setColor(HSSFColor.VIOLET.index);  
        font.setFontHeightInPoints((short) 12);  
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);  
        // 把字体应用到当前的样式  
        style.setFont(font);  
        // 生成并设置另一个样式  
        HSSFCellStyle style2 = workbook.createCellStyle();  
        style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);  
        style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);  
        style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
        style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
        style2.setBorderRight(HSSFCellStyle.BORDER_THIN);  
        style2.setBorderTop(HSSFCellStyle.BORDER_THIN);  
        style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
        style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);  
        // 生成另一个字体  
        HSSFFont font2 = workbook.createFont();  
        font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);  
        // 把字体应用到当前的样式  
        style2.setFont(font2);  
        // 声明一个画图的顶级管理器  
        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();  
        // 定义注释的大小和位置,详见文档  
        HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0, 0, 0, 0, (short) 4, 2, (short) 6, 5));  
        // 设置注释内容  
        comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));  
        // 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.  
        comment.setAuthor("leno");  

        // 产生表格标题行  
        HSSFRow row = sheet.createRow(0);  
//        for (short i = 0; i < headers.length; i++)  
//        	
//        {  
//            HSSFCell cell = row.createCell(i);  
//            cell.setCellStyle(style);  
//            HSSFRichTextString text = new HSSFRichTextString(headers[i]);  
//            cell.setCellValue(text);  
//        }  
        
        short j=0;
		for(String string :headers.split(",")) {
          HSSFCell cell = row.createCell(j);
          j++;
          cell.setCellStyle(style);  
          HSSFRichTextString text = new HSSFRichTextString(string);  
          cell.setCellValue(text);  

			}
        // 遍历集合数据，产生数据行  
        Iterator<Object> it = storeVos.iterator();  
        int index = 0;  
        while (it.hasNext())  
        {  
            index++;  
            row = sheet.createRow(index);  
            T t = (T) it.next();  
            // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值  
            Field[] fields = t.getClass().getDeclaredFields();  
            for (short i = 0; i < fields.length; i++)  
            {  
                HSSFCell cell = row.createCell(i);  
                cell.setCellStyle(style2);  
                Field field = fields[i];  
                String fieldName = field.getName();  
                String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);  
                try  
                {  
                    Class tCls = t.getClass();  
                    Method getMethod = tCls.getMethod(getMethodName, new Class[] {});  
                    Object value = getMethod.invoke(t, new Object[] {});  
                    // 判断值的类型后进行强制类型转换  
                    String textValue = null;  
                    if (value instanceof Boolean)  
                    {  
                        boolean bValue = (Boolean) value;  
                        textValue = "男";  
                        if (!bValue)  
                        {  
                            textValue = "女";  
                        }  
                    }  
                    else if (value instanceof Date)  
                    {  
                        Date date = (Date) value;  
                        SimpleDateFormat sdf = new SimpleDateFormat(pattern);  
                        textValue = sdf.format(date);  
                    }  
                    else if (value instanceof byte[])  
                    {  
                        // 有图片时，设置行高为60px;  
                        row.setHeightInPoints(60);  
                        // 设置图片所在列宽度为80px,注意这里单位的一个换算  
                        sheet.setColumnWidth(i, (short) (35.7 * 80));  
                        // sheet.autoSizeColumn(i);  
                        byte[] bsValue = (byte[]) value;  
                        HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0,1023, 255, (short) 6, index, (short) 6, index);  
                        anchor.setAnchorType(2);  
                        patriarch.createPicture(anchor, workbook.addPicture(bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));  
                    }  
                    else  
                    {  
                        // 其它数据类型都当作字符串简单处理  
                        textValue = value == null? "": value.toString();  
                    }  
                    // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成  
                    if (textValue != null)  
                    {  
                        Pattern p = Pattern.compile("^//d+(//.//d+)?$");  
                        Matcher matcher = p.matcher(textValue);  
                        if (matcher.matches())  
                        {  
                            // 是数字当作double处理  
                            cell.setCellValue(Double.parseDouble(textValue));  
                        }  
                        else  
                        {  
                            HSSFRichTextString richString = new HSSFRichTextString(textValue);  
                            HSSFFont font3 = workbook.createFont();  
                            font3.setColor(HSSFColor.BLUE.index);  
                            richString.applyFont(font3);  
                            cell.setCellValue(richString);  
                        }  
                    }  
                }  
                catch (SecurityException e)  
                {  
                    e.printStackTrace();  
                }  
                catch (NoSuchMethodException e)  
                {  
                    e.printStackTrace();  
                }  
                catch (IllegalArgumentException e)  
                {  
                    e.printStackTrace();  
                }  
                catch (IllegalAccessException e)  
                {  
                    e.printStackTrace();  
                }  
                catch (InvocationTargetException e)  
                {  
                    e.printStackTrace();  
                }  
                finally  
                {  
                    // 清理资源  
                }  
            }  
        }  
    } 
}
