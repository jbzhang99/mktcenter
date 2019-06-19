package com.bizvane.mktcenterserviceimpl.common.award;

import com.bizvane.members.facade.exception.MemberException;
import com.bizvane.mktcenterservice.common.tools.CommonExportCallBack;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

/**
 * 从excel中读数据(xls和xlsx),支持从文件或流中读数据
 */
public class CommonExportExcelUtil {

    private Workbook wb;

    /**
     * @param fileName 文件名称
     * @throws InvalidFormatException
     * @throws IOException
     */
    public CommonExportExcelUtil(String fileName) throws InvalidFormatException, IOException {
        wb = WorkbookFactory.create(new File(fileName));
    }

    /**
     * @param is 输入流
     * @throws InvalidFormatException
     * @throws IOException
     */
    public CommonExportExcelUtil(InputStream is) throws InvalidFormatException, IOException {
        wb = WorkbookFactory.create(is);
    }

    /**
     * 返回sheet数量
     *
     * @return
     */
    public int getNumberOfSheets() {
        return wb.getNumberOfSheets();
    }

    /**
     * 得到第几个sheet
     *
     * @param num
     * @return
     */
    private Sheet getSheetAt(int num) {
        return wb.getSheetAt(num);
    }

    /**
     * @param beginRowNum    开始行数（默认读到当前sheet最后一行）
     * @param beginColumnNum 开始列数
     * @param endColumnNum   结束列数
     * @param sheetNum       读第几个sheet
     * @param callback       读完一行数据时的回调函数
     * @throws Exception 异常返回
     */
    @SuppressWarnings("deprecation")
    public void read(int beginRowNum, int beginColumnNum, int endColumnNum, int sheetNum, CommonExportCallBack callback)
            throws MemberException {
        Sheet sheet = this.getSheetAt(sheetNum);
        int endRowNum = sheet.getLastRowNum();
        if (beginRowNum > endRowNum) {
            throw new MemberException("开始行数不能大于结束行数");
        }
        if (beginColumnNum > endColumnNum) {
            throw new MemberException("开始列数不能大于结束列数");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        for (int rowNum = beginRowNum; rowNum <= endRowNum; rowNum++) {
            String[] array = new String[endColumnNum - beginColumnNum + 1];
            Row row = sheet.getRow(rowNum);
            if (row == null) {
                // This whole row is empty Handle it as needed
                continue;
            }
            for (int column = beginColumnNum; column <= endColumnNum; column++) {
                Cell cell = row.getCell(column, Row.RETURN_BLANK_AS_NULL);
                if (cell == null) {
                    // The spreadsheet is empty in this cell
                    array[column - beginColumnNum] = null;
                } else {
                    //以string类型读取excel单元格
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    array[column - beginColumnNum] = cell.getRichStringCellValue().getString();
                    /*switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_STRING:
                            array[column - beginColumnNum] = cell.getRichStringCellValue().getString();
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                array[column - beginColumnNum] = sdf.format(cell.getDateCellValue());
                            } else {
                                array[column - beginColumnNum] = cell.getNumericCellValue() + "";
                            }
                            break;
                        case Cell.CELL_TYPE_BOOLEAN:
                            array[column - beginColumnNum] = cell.getBooleanCellValue() ? "0" : "1";
                            break;
                        case Cell.CELL_TYPE_FORMULA:
                            array[column - beginColumnNum] = cell.getCellFormula();
                            break;
                        case Cell.CELL_TYPE_BLANK:
                            array[column - beginColumnNum] = "";
                            break;
                        default:
                            array[column - beginColumnNum] = "";
                    }*/
                }
            }
            callback.onRowCompletion(array);
        }
    }

    public static void main(String[] args) {
        try {
            CommonExportExcelUtil re = new CommonExportExcelUtil("E:\\123456xxx.xlsx");
            int numOfSheets = re.getNumberOfSheets();
            for (int i = 0; i < numOfSheets; i++) {
                try {
                    re.read(0, 0, 4, i, (row) -> {
                        System.out.println(row[0]);
                        System.out.println(row[1]);
                        System.out.println(row[2]);
                        System.out.println("---------");
                    });
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (InvalidFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
