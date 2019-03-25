package com.bizvane.couponservice.common.utils;/*
package com.bizvane.couponservice.common.utils;


import org.apache.commons.lang3.StringUtils;
import org.krysalis.barcode4j.HumanReadablePlacement;
import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.UUID;

*/
/**
 * 条形码工具类
 *
 * @author yunjie.tian
 *
 *//*

@Controller
public class BarcodeUtil111 {

    //图片类型
    private static final String FORMAT_NAME = "PNG";


    */
/**
     * 生成到流
     *
     * @param msg
     *//*

    public static String generateBarCode(String msg) {

        String qiniuUrl = "";

        if (StringUtils.isEmpty(msg)) {
            return qiniuUrl;
        }

        Code39Bean bean = new Code39Bean();

        // 精细度
        final int dpi = 150;
        // module宽度
        final double moduleWidth = UnitConv.in2mm(1.0f / dpi);

        // 配置对象
        bean.setModuleWidth(moduleWidth);
        bean.setWideFactor(3);
        bean.doQuietZone(false);
        bean.setMsgPosition(HumanReadablePlacement.HRP_NONE);

        String format = "image/png";
        try {

            // 输出到流
            BitmapCanvasProvider canvas = new BitmapCanvasProvider(null,format,dpi,
                    BufferedImage.TYPE_BYTE_BINARY, false, 0);

            // 生成条形码
            bean.generateBarcode(canvas, msg);

            BufferedImage image = canvas.getBufferedImage();

            */
/**
             * 1.上传到阿里云OSS
             *//*

            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(image, FORMAT_NAME, os);

            InputStream is = new ByteArrayInputStream(os.toByteArray());

            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            qiniuUrl = QiNiuUtil.upload(is,uuid);

            os.close();
            is.close();
            // 结束绘制
            canvas.finish();



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return qiniuUrl;
    }

    @RequestMapping("ssssss")
    public void ssss(@RequestParam("qq")String qq) {
        String msg = "701-11255403";
        String path = generateBarCode(qq);
        String aa = "0";
    }


}*/
