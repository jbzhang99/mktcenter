package com.bizvane.mktcenterserviceimpl.common.tools;

import com.alibaba.fastjson.JSONArray;
import com.bizvane.centerstageservice.models.po.FileTaskPo;
import com.bizvane.centerstageservice.models.vo.QiNiuVo;
import com.bizvane.centerstageservice.rpc.FileTaskServiceRpc;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 导出Excel公共方法
 * Created by liufq on 2018/7/3.
 */
public class ExportExcelUtil {

    @Autowired
    private QiNiuConfigs qiNiuConfig;

    //显示的导出表的标题
    private String sheetName;
    //导出表的列名
    private String[] rowName;

    private List<JSONArray> dataList = new ArrayList<JSONArray>();

    HttpServletResponse response;

    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

    //构造方法，传入要导出的数据
    public ExportExcelUtil(String sheetName, String[] rowName, List<JSONArray> dataList, HttpServletResponse response) {
        this.dataList = dataList;
        this.rowName = rowName;
        this.sheetName = sheetName;
        this.response = response;
    }

    /**
     * excel导出
     */
    public void export() throws Exception {
        try {
            Workbook workbook = new SXSSFWorkbook();// 创建工作簿对象

            Sheet sheet = workbook.createSheet(sheetName);// 创建工作表
            // 产生表格标题行
            //Row rowm = sheet.createRow(0);
            //Cell cellTiltle = rowm.createCell(0);
            //
            ////sheet样式定义【getColumnTopStyle()/getStyle()均为自定义方法 - 在下面  - 可扩展】
            CellStyle columnTopStyle = this.getColumnTopStyle(workbook);//获取列头样式对象
            CellStyle style = this.getStyle(workbook);//单元格样式对象
            //
            //sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, (rowName.length - 1)));
            //cellTiltle.setCellStyle(columnTopStyle);
            //cellTiltle.setCellValue(sheetName);
            //
            //// 定义所需列数
            int columnNum = rowName.length;
            Row rowRowName = sheet.createRow(0);// 在索引2的位置创建行(最顶端的行开始的第二行)

            //将列头设置到sheet的单元格中
            for (int n = 0; n < columnNum; n++) {
                Cell cellRowName = rowRowName.createCell(n);//创建列头对应个数的单元格
                cellRowName.setCellType(HSSFCell.CELL_TYPE_STRING);//设置列头单元格的数据类型
                HSSFRichTextString text = new HSSFRichTextString(rowName[n]);
                cellRowName.setCellValue(text);//设置列头单元格的值
                cellRowName.setCellStyle(columnTopStyle);//设置列头单元格样式
            }

            //将查询出的数据设置到sheet对应的单元格中
            for (int i = 0; i < dataList.size(); i++) {

                JSONArray arrayData = dataList.get(i);//遍历每个对象
                Row row = sheet.createRow(i + 1);//创建所需的行数
                for (int j = 0; j < arrayData.size(); j++) {
                    Cell cell = null;//设置单元格的数据类型
                    String data = arrayData.getString(j);

                    cell = row.createCell(j, HSSFCell.CELL_TYPE_STRING);
                    if (!"".equals(data) && data != null) {
                        cell.setCellValue(data);//设置单元格的值
                    } else {
                        cell.setCellValue("");//如果为空,则为空字符串
                    }
                    cell.setCellStyle(style);//设置单元格样式
                }
            }

            //让列宽随着导出的列长自动适应
            for (int colNum = 0; colNum < columnNum; colNum++) {
                int columnWidth = sheet.getColumnWidth(colNum) / 256;
                //for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
                //    Row currentRow;
                //    //当前行未被使用过
                //    if (sheet.getRow(rowNum) == null) {
                //        currentRow = sheet.createRow(rowNum);
                //    } else {
                //        currentRow = sheet.getRow(rowNum);
                //    }
                //    if (currentRow.getCell(colNum) != null) {
                //        Cell currentCell = currentRow.getCell(colNum);
                //        if (currentCell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                //            int length = currentCell.getStringCellValue().getBytes().length;
                //            if (columnWidth < length) {
                //                columnWidth = length;
                //            }
                //        }
                //    }
                //}
                if (colNum == 0) {
                    sheet.setColumnWidth(colNum, (columnWidth - 2) * 256);
                } else {
                    int width = (columnWidth + 4) * 256;
                    if (width > 10000) {
                        width = 10000;
                    }
                    sheet.setColumnWidth(colNum, width);
                }
            }

            if (workbook != null) {
                try {
                    String fileNames = sheetName + ".xlsx";
                    //String fileNames = title + dates + ".zip";
                    String fileName = new String(fileNames.getBytes("GBK"), "iso8859-1");
                    String headStr = "attachment; filename=" + fileName;
                    response.reset();
                    response.setContentType("APPLICATION/OCTET-STREAM");
                    response.setHeader("Content-Disposition", headStr);
                    response.setHeader("x-frame-options","SAMEORIGIN");
                    OutputStream out = response.getOutputStream();
                    workbook.write(out);
                    //
                    //ZipOutputStream zip = new ZipOutputStream(out, Charset.forName("GBK"));
                    //ZipEntry entry = new ZipEntry(title + ".xlsx");
                    //zip.putNextEntry(entry);
                    //workbook.write(zip);
                    //zip.flush();
                    //zip.close();
                    System.out.println("导出"+sheetName+"成功");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("导出"+sheetName+"失败");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    /**
     * 将excel上传到七牛并更新导出任务进度
     *
     * @param fileTaskPo
     * @param excelUtil
     * @param fileTaskServiceRpc
     * @param moduleName
     */
    public static void exportAndUpdateTask(FileTaskPo fileTaskPo, StreamingExportExcelUtil<?> excelUtil, FileTaskServiceRpc fileTaskServiceRpc, String moduleName) {
        OutputStream out = null;
        ByteArrayInputStream in = null;
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
                    // 导出完成
                    fileTaskPo.setFileStatus(99L);
                    fileTaskServiceRpc.update(fileTaskPo);

                    //拼接上传路径
                    out=new  ByteArrayOutputStream();
                  
                   excelUtil.exportToOutputStream(out);
                   in = new ByteArrayInputStream(((ByteArrayOutputStream) out).toByteArray());
                   QiNiuUtils niuUtil = new QiNiuUtils();

                   String bucket = SpringContextHolders.getApplicationContext().getBean(QiNiuConfigs.class).getBucket();
                   QiNiuVo qiniuUrl = niuUtil.upload(bucket, in, FileNameUtil.getExportStoreFileName(moduleName));

                   //保存成功会写数据库
                   fileTaskPo.setFileStatus(100L);
                   String domain = SpringContextHolders.getApplicationContext().getBean(QiNiuConfigs.class).getDoMain();
                   fileTaskPo.setFileUnl("https://" + domain + "/" + qiniuUrl.getUrl().toString());
                   /*fileTaskPo.setModifiedDate(new Date());*/
        		   fileTaskServiceRpc.update(fileTaskPo);
                    break;
                }
                //每秒更新一下进度
                fileTaskPo.setFileStatus(process.multiply(new BigDecimal(100)).longValue());
                fileTaskServiceRpc.update(fileTaskPo);
                Thread.sleep(500);
            } while (true);

        } catch (Exception e) {
            e.printStackTrace();
            // 导出报错
            fileTaskPo.setFileStatus(-1L);
            fileTaskServiceRpc.update(fileTaskPo);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    /*
     * 列头单元格样式
     */
    public CellStyle getColumnTopStyle(Workbook workbook) {

        // 设置字体
        Font font = workbook.createFont();
        //设置字体大小
        font.setFontHeightInPoints((short) 11);
        //字体加粗
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //设置字体名字
        font.setFontName("Courier New");
        //设置样式;
        CellStyle style = workbook.createCellStyle();
        //设置底边框;
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //设置底边框颜色;
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        //设置左边框;
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        //设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        //设置右边框;
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        //设置右边框颜色;
        style.setRightBorderColor(HSSFColor.BLACK.index);
        //设置顶边框;
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.BLACK.index);
        //在样式用应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(false);
        //设置水平对齐的样式为居中对齐;
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        return style;

    }

    /*
     * 列数据信息单元格样式
     */
    public CellStyle getStyle(Workbook workbook) {
        // 设置字体
        Font font = workbook.createFont();
        //设置字体大小
        //font.setFontHeightInPoints((short)10);
        //字体加粗
        //font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //设置字体名字
        font.setFontName("Courier New");
        //设置样式;
        CellStyle style = workbook.createCellStyle();
        //设置底边框;
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //设置底边框颜色;
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        //设置左边框;
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        //设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        //设置右边框;
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        //设置右边框颜色;
        style.setRightBorderColor(HSSFColor.BLACK.index);
        //设置顶边框;
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.BLACK.index);
        //在样式用应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(false);
        //设置水平对齐的样式为居中对齐;
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        return style;
    }
}
