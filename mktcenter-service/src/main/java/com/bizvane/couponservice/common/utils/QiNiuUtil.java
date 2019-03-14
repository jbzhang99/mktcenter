package com.bizvane.couponservice.common.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;


/**
 * @author chen.li
 * @date on 2018/7/24 15:14
 * @description 七牛工具类
 * @Copyright (c) 2018 上海商帆信息科技有限公司-版权所有
 */
@Component
public class QiNiuUtil {

  private static Configuration cfg = new Configuration(Zone.zone0());
  private static UploadManager uploadManager = new UploadManager(cfg);
  /**
   * 上传输入流
   * 
   * @param bucketNm bucket的名称
   * @param in 输入流
   * @return
   */
  public static String uploadUrl(String url, String key) {
    InputStream in = null;
    try {
      in = new URL(url).openStream();
    } catch (MalformedURLException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    } catch (IOException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }

    try {
      UploadManager uploadManager = QiNiuUtil.getUploadManager();

      // 获取token
      String token = QiNiuUtil.getToken();

      // 上传输入流
      Response response = uploadManager.put(in, key, token, null, null);

      // 解析上传成功的结果
      DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);


      String domain = CouponSpringContextUtil.getBean(QiNiuConfig.class).getDomain();
      String qiniuUrl = domain + "/" + putRet.key;

      return qiniuUrl;
    } catch (Exception e) {
      ;
    }
    return null;
  }
  
  /**
   * 上传输入流
   * 
   * @param bucketNm bucket的名称
   * @param in 输入流
   * @return
   */
  public static String upload(InputStream in, String key) {

    try {
      UploadManager uploadManager = QiNiuUtil.getUploadManager();

      // 获取token
      String token = QiNiuUtil.getToken();

      // 上传输入流
      Response response = uploadManager.put(in, key, token, null, null);

      // 解析上传成功的结果
      DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);


      String domain = CouponSpringContextUtil.getBean(QiNiuConfig.class).getDomain();
      String url = domain + "/" + putRet.key;

      return url;
    } catch (Exception e) {
      ;
    }
    return null;
  }

  /**
   * 通过文件来传递数据
   * 
   * @param bucketNm
   * @param file
   * @return
   */
  public static String upload(String bucketNm, File file) {
    try {

      UploadManager uploadManager = QiNiuUtil.getUploadManager();

      String token = QiNiuUtil.getToken();
      Response response = uploadManager.put(file.getAbsolutePath(), QiNiuUtil.newName(file.getName()), token);

      // 解析上传成功的结果
      DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
      String domain = CouponSpringContextUtil.getBean(QiNiuConfig.class).getDomain();
      String url = domain + "/" + putRet.key;

      return url;
    } catch (QiniuException e) {
      e.printStackTrace();

    }
    return null;

  }

  /**
   * 通过老文件的名称自动生成新的文件
   *
   * @param oldName
   * @return
   */
  public static String newName(String oldName) {
    String[] datas = oldName.split("\\.");
    String type = datas[datas.length - 1];
    String newName = UUID.randomUUID().toString() + "." + type;
    return newName;
  }

  /**
   * 获取上传管理器
   * 
   * @param bucketNm
   * @return
   */
  public static UploadManager getUploadManager() {
    // 构造一个带指定Zone对象的配置类
    // 区域要和自己的bucket对上，不然就上传不成功
    // 华东 Zone.zone0()
    // 华北 Zone.zone1()
    // 华南 Zone.zone2()
    // 北美 Zone.zoneNa0()
    return uploadManager;
  }

  /**
   * 获取七牛云的上传Token
   * 
   * @param bucketNm
   * @return
   */
  private static String getToken() {
    QiNiuConfig qiNiuConfig = CouponSpringContextUtil.getBean(QiNiuConfig.class);

    Auth auth = Auth.create(qiNiuConfig.getAccessKey(), qiNiuConfig.getSecretKey());
    String upToken = auth.uploadToken(qiNiuConfig.getBucketNm());
    return upToken;
  }



}
