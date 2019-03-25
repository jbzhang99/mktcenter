package com.bizvane.couponservice.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.spire.barcode.BarCodeGenerator;
import com.spire.barcode.BarCodeType;
import com.spire.barcode.BarcodeSettings;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.UUID;

/**
 * Created by yunjie.tian on 2018/11/6.
 */
public class BarcodeUtil {

    private static Logger logger = LoggerFactory.getLogger(BarcodeUtil.class);

    //图片类型
    private static final String FORMAT_NAME = "PNG";

    /**
     * 生成到流
     *
     * @param msg
     */
    public static String generateBarCode(String msg) {

        logger.info("enter BarcodeUtil generateBarCode param:msg:{}",msg);

        String qiniuUrl = "";

        if (StringUtils.isEmpty(msg)) {
            return qiniuUrl;
        }

        //创建BarcodeSettings实例
        BarcodeSettings settings = new BarcodeSettings();
        //设置条形码类型
        settings.setType(BarCodeType.CODE_128);
        //设置条形码数据
        settings.setData(msg);
        settings.setShowText(false);
        //设置条形码显示数据
       // settings.setData2D(msg);
        //在底部显示数据
        settings.setShowTextOnBottom(false);
        //设置边框为不可见
        settings.hasBorder(false);
        //创建BarCodeGenerator实例
        BarCodeGenerator barCodeGenerator = new BarCodeGenerator(settings);
        //根据settings生成图像数据，保存至BufferedImage实例
        BufferedImage image = barCodeGenerator.generateImage();

        try {
            /**
             * 1.上传到阿里云OSS
             */
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(image, FORMAT_NAME, os);

            InputStream is = new ByteArrayInputStream(os.toByteArray());

            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            qiniuUrl = QiNiuUtil.upload(is,uuid);

            os.close();
            is.close();
        }catch (Exception e){
            logger.info("enter BarcodeUtil generateBarCode Exception:e:{}", JSONObject.toJSONString(e));
        }

        return qiniuUrl;

    }

  /*    public void ssss(@RequestParam("qq")String qq) {
        String msg = "701-11255403";
        String path = generateBarCode(qq);
        String aa = "0";
    }
*/

}
