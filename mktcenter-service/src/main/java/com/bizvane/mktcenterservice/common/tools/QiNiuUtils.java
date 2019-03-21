package com.bizvane.mktcenterservice.common.tools;

import com.bizvane.centerstageservice.models.po.SysQiNiuConfigPo;
import com.bizvane.centerstageservice.models.vo.QiNiuVo;
import com.bizvane.centerstageservice.rpc.QiNiuServiceRpc;
import com.bizvane.utils.responseinfo.ResponseData;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.BatchStatus;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

/**
 * @author chen.li
 * @date on 2018/7/24 15:14
 * @description 七牛工具类
 * @Copyright (c) 2018 上商帆信息科技有限公司-版权所有
 */
@Service
@Data
public class QiNiuUtils {
    @Autowired
    private QiNiuServiceRpc qiNiuServiceRpc;

    //官网地址
    //https://developer.qiniu.com/kodo/sdk/1239/java
    @Value("${qiniu.accessKey}")
    private static String accessKey;
    
    @Value("${qiniu.secretKey}")
    private static String secretKey;

    /**
     * 获取bucket里面所有文件的信息
     *
     * @param bucketNm
     */
    public void getFileInfo(String bucketNm) {
        try {
            BucketManager bucketManager = getBucketManager();

            //文件名前缀
            String prefix = "";
            //每次迭代的长度限制，最大1000，推荐值 1000
            int limit = 1000;
            //指定目录分隔符，列出所有公共前缀（模拟列出目录效果）。缺省值为空字符串
            String delimiter = "";

            //列举空间文件列表
            BucketManager.FileListIterator fileListIterator = bucketManager.createFileListIterator(bucketNm, prefix, limit, delimiter);
            while (fileListIterator.hasNext()) {
                //处理获取的file list结果
                FileInfo[] items = fileListIterator.next();
                for (FileInfo item : items) {
                    System.out.println(item.key);
                    /*System.out.println(item.hash);
                    System.out.println(item.fsize);
                    System.out.println(item.mimeType);
                    System.out.println(item.putTime);
                    System.out.println(item.endUser);*/
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取所有的bucket
     */
    public void getBucketsInfo() {
        try {
            BucketManager bucketManager = getBucketManager();
            //获取所有的bucket信息
            String[]  bucketNms = bucketManager.buckets();
            for(String bucket:bucketNms) {
                System.out.println(bucket);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 删除多个文件
     * @param bucketNm bucket的名称
     * @param keys     文件名称数组
     * //单次批量请求的文件数量不得超过1000 , 这个是七牛所规定的
     * @return
     */
    public QiNiuVo deletes(String bucketNm , String [] keys) {
        QiNiuVo qiNiuVo = null;
        try {
            //当文件大于1000的时候，就直接不处理
            if(keys.length >1000) {
                return new QiNiuVo(false);
            }

            //设定删除的数据
            BucketManager.BatchOperations batchOperations = new BucketManager.BatchOperations();
            batchOperations.addDeleteOp(bucketNm, keys);
            BucketManager bucketManager = getBucketManager();
            //发送请求
            Response response = bucketManager.batch(batchOperations);

            //返回数据
            BatchStatus[] batchStatusList = response.jsonToObject(BatchStatus[].class);
            for (int i = 0; i < keys.length; i++) {
                BatchStatus status = batchStatusList[i];
                String key = keys[i];
                System.out.print(key + "\t");
                if (status.code == 200) {
                    System.out.println("delete success");
                } else {
                    System.out.println(status.data.error);
                    return new QiNiuVo(false);
                }
            }
            qiNiuVo = new QiNiuVo(true);
        }catch (Exception e) {
            qiNiuVo = new QiNiuVo(false);
        }
        return qiNiuVo;
    }
    /**
     * 删除bucket中的文件名称
     * @param bucketNm bucker名称
     * @param key 文件名称
     * @return
     */
    public QiNiuVo delete(String bucketNm , String key) {
        QiNiuVo result = null;
        try {
            BucketManager mg = getBucketManager();
            mg.delete(bucketNm, key);
            result = new QiNiuVo(true);
        }catch (Exception e) {
            result = new QiNiuVo(false);
        }
        return result;
    }

    /**
     * 上传输入流
     * @param bucketNm  bucket的名称
     * @param in        输入流
     * @return
     */
    public QiNiuVo upload(String bucketNm, InputStream in, String key) {
        QiNiuVo result = null;
        try {
            UploadManager uploadManager = getUploadManager(bucketNm);

            //获取token
            String token = getToken(bucketNm);

            //上传输入流
            Response response = uploadManager.put(in,key,token, null,null);

            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);

            result = new QiNiuVo(true,putRet.key);
        }catch (Exception e) {
            result = new QiNiuVo(false);
        }
        return result;
    }
    /**
     * 通过文件来传递数据
     * @param bucketNm
     * @param file
     * @return
     */
    public QiNiuVo upload(String bucketNm, File file) {
        QiNiuVo result = null;
        try {

            UploadManager uploadManager = getUploadManager(bucketNm);

            String token = getToken(bucketNm);
            Response response = uploadManager.put(file.getAbsolutePath(),newName(file.getName()), token);

            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);

            result = new QiNiuVo(true,putRet.key);
        } catch (QiniuException e) {
            e.printStackTrace();
            result = new QiNiuVo(false);
        }
        return result;

    }

    /**
     * 通过老文件的名称自动生成新的文件
     *
     * @param oldName
     * @return
     */
    public  String newName(String oldName) {
        String[] datas = oldName.split("\\.");
        String type = datas[datas.length - 1];
        String newName = UUID.randomUUID().toString() + "." + type;
        return newName;
    }

    /**
     * 获取上传管理器
     * @param bucketNm
     * @return
     */
    public  UploadManager getUploadManager(String bucketNm) {
        //构造一个带指定Zone对象的配置类
        //区域要和自己的bucket对上，不然就上传不成功
        //华东    Zone.zone0()
        //华北    Zone.zone1()
        //华南    Zone.zone2()
        //北美    Zone.zoneNa0()
        Configuration cfg = new Configuration(Zone.zone0());
        UploadManager uploadManager = new UploadManager(cfg);
        return uploadManager;
    }
    /**
     * 获取Bucket的管理对象
     * @return
     */
    public  BucketManager getBucketManager() {
        //构造一个带指定Zone对象的配置类
        //区域要和自己的bucket对上，不然就上传不成功
        //华东    Zone.zone0()
        //华北    Zone.zone1()
        //华南    Zone.zone2()
        //北美    Zone.zoneNa0()
        Configuration cfg = new Configuration(Zone.zone0());
        Auth auth = Auth.create(accessKey, secretKey);
        BucketManager bucketManager = new BucketManager(auth, cfg);
        return bucketManager;
    }
    /**
     * 获取七牛云的上传Token
     * @param bucketNm
     * @return
     */
    public  String getToken(String bucketNm) {
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucketNm);
        return upToken;
    }


}
