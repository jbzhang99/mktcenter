package com.bizvane.mktcenterservice.common.tools;

import java.util.Date;

/**
 * @Author: Hou Hong Bin
 * @CreateTime: 2018/8/29.
 */
public class FileNameUtil {
    public static final String EXPORT_STORE_ORCODE = "EXPORT_STORE_ORCODE_";
    
    public static final String EXPORT_STORE_INFO_ORCODE = "EXPORT_STORE_INFO_ORCODE_";

    public static final String EXTEND_PROPERTY_PREFIX = "EXTEND_PROPERTY_";

    public static final String BASE_MEMBER_INFO_PREFIX = "BASE_MEMBER_INFO_";

    public static final String DISTRIBUTION_MEMBER_INFO_PREFIX = "DISTRIBUTION_MEMBER_INFO_";

    public static final String XLS_SUFFIX = ".xls";

    public static final String XLSX_SUFFIX = ".xlsx";

    public static final String ZIP_SUFFIX = ".zip";

    public static final String DATE_YYYYMMDD_MIDDLE = "yyyyMMdd";

    public static final String DATE_YYYYMMDDHHMMSS_MIDDLE = "yyyyMMddHHmmss";

    /**
     * 中台导出店铺二维码
     * @return
     */
    public static String getExportStoreOrcodeFileName(){
        return getFileName(EXPORT_STORE_ORCODE, DateUtil.format(new Date(),DATE_YYYYMMDDHHMMSS_MIDDLE),ZIP_SUFFIX);
    }
    /**
       * 中台店铺
     * @return
     */
    public static String getExportStoreFileName(String name){
        return getFileName(name,DateUtil.format(new Date(),DATE_YYYYMMDDHHMMSS_MIDDLE),XLSX_SUFFIX);
    }

    /**
     * 获取扩展属性文件名
     * @return
     */
    public static String getExtendPropertyExcelFileName(){
        return getFileName(EXTEND_PROPERTY_PREFIX,DateUtil.format(new Date(),DATE_YYYYMMDDHHMMSS_MIDDLE),XLSX_SUFFIX);
    }

    /**
     * 获取基本会员信息文件名
     * @return
     */
    public static String getBaseMemberInfoExcelFileName(){
        return getFileName(BASE_MEMBER_INFO_PREFIX,DateUtil.format(new Date(),DATE_YYYYMMDDHHMMSS_MIDDLE),XLSX_SUFFIX);
    }

    /**
     * 获取分销会员信息文件名
     * @return
     */
    public static String getDistributionMemberInfoExcelFileName(){
        return getFileName(DISTRIBUTION_MEMBER_INFO_PREFIX,DateUtil.format(new Date(),DATE_YYYYMMDDHHMMSS_MIDDLE),XLSX_SUFFIX);
    }

    public static String getFileName(String prefix,String middle,String suffix){
        StringBuffer buffer = new StringBuffer();
        buffer.append(prefix);
        buffer.append(middle);
        buffer.append(suffix);
        return buffer.toString();
    }
}
