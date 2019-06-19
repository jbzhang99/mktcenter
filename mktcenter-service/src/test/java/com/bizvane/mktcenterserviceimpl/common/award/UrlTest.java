package com.bizvane.mktcenterserviceimpl.common.award;

import jdk.internal.util.xml.impl.Input;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author chen.li
 * @date on 2019/6/19 10:19
 * @description
 */
public class UrlTest {
    public static InputStream urlToStream(String urlPath) {
        InputStream in = null;
        try {
            // 统一资源
            URL url = new URL(urlPath);
            // 连接类的父类，抽象类
            URLConnection urlConnection = url.openConnection();
            // http的连接类
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
            // 设定请求的方法，默认是GET
            httpURLConnection.setRequestMethod("POST");
            // 设置字符编码
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            // 打开到此 URL 引用的资源的通信链接（如果尚未建立这样的连接）。
            httpURLConnection.connect();

            // 文件大小
            int fileLength = httpURLConnection.getContentLength();

            // 文件名
            String filePathUrl = httpURLConnection.getURL().getFile();
            String fileFullName = filePathUrl.substring(filePathUrl.lastIndexOf(File.separatorChar) + 1);

            System.out.println("file length---->" + fileLength);

            URLConnection con = url.openConnection();

            in = httpURLConnection.getInputStream();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return in;
    }

    public static void main(String[] args) {
        String[] url = new String[]{
                "https://static.bizvane.com/30/22/memberScreen/file_1560758697463",
                "https://static.bizvane.com/30/22/memberScreen/file_1560758327966"
        };

        for(int i=0;i<2000;i++){
             new Thread(new Runnable() {
                 @Override
                 public void run() {
                     InputStream inputStream=null;
                     DownLoadFileUtil.urlToExcel(url[0]);
                 }
             }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    InputStream inputStream=null;
                    DownLoadFileUtil.urlToExcel(url[1]);
                }
            }).start();
        }
    }
}
