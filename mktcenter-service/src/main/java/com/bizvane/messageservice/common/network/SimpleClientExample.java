package com.bizvane.messageservice.common.network;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.HttpException;
import org.apache.http.HttpStatus;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/**
 * @Author: lijunwei
 * @Time: 2018/7/18 14:46
 */
public class SimpleClientExample {
    private String mtUrl = "http://esms6.10690007.net/sms/mt";

    /**
     * @throws Exception
     */
    public void testSingleMt() throws Exception {
        String command = "MT_REQUEST";
        String spid = "100982";
        String sppassword = "iC0a9EJW";
        String spsc = "00";
        String sa = "10657109053657";
        String da = "18652083705";
        int dc = 15;
        String ecodeform = "GBK";
        String sm = new String(Hex.encodeHex("验证码：9771".getBytes(ecodeform)));

        StringBuilder smsUrl = new StringBuilder();
        smsUrl.append(mtUrl);
        smsUrl.append("?command=" + command);
        smsUrl.append("&spid=" + spid);
        smsUrl.append("&sppassword=" + sppassword);
        smsUrl.append("&spsc=" + spsc);
        smsUrl.append("&sa=" + sa);
        smsUrl.append("&da=" + da);
        smsUrl.append("&sm=" + sm);
        smsUrl.append("&dc=" + dc);

        String resStr = doGetRequest(smsUrl.toString());
        System.out.println(resStr);

        HashMap<String, String> pp = parseResStr(resStr);
        System.out.println(pp.get("command"));
        System.out.println(pp.get("spid"));
        System.out.println(pp.get("mtmsgid"));
        System.out.println(pp.get("mtstat"));
        System.out.println(pp.get("mterrcode"));
    }

    /**
     * @throws Exception
     */
    public void testMultiMt() throws Exception {
        String command = "MULTI_MT_REQUEST";
        String spid = "1234";
        String sppassword = "1234";
        String spsc = "00";
        String sa = "10657109053657";
        String das = "8613811111111,8613011111111";
        int dc = 15;
        String ecodeform = "GBK";
        String sm = new String(Hex.encodeHex("".getBytes(ecodeform)));

        StringBuilder smsUrl = new StringBuilder();
        smsUrl.append(mtUrl);
        smsUrl.append("?command=" + command);
        smsUrl.append("&spid=" + spid);
        smsUrl.append("&sppassword=" + sppassword);
        smsUrl.append("&spsc=" + spsc);
        smsUrl.append("&sa=" + sa);
        smsUrl.append("&das=" + das);
        smsUrl.append("&sm=" + sm);
        smsUrl.append("&dc=" + dc);

        String resStr = doGetRequest(smsUrl.toString());
        System.out.println(resStr);

        HashMap<String, String> pp = parseResStr(resStr);
        System.out.println(pp.get("command"));
        System.out.println(pp.get("spid"));
        System.out.println(pp.get("mtmsgids"));
        System.out.println(pp.get("mtstat"));
        System.out.println(pp.get("mterrcode"));
    }

    /**
     * @throws Exception
     */
    public void testMultiXMt() throws Exception {
        String command = "MULTIX_MT_REQUEST";
        String spid = "1234";
        String sppassword = "1234";
        String spsc = "00";
        String sa = "10657109053657";
        int dc = 15;
        String ecodeform = "GBK";

        StringBuffer dasm = new StringBuffer();
        dasm.append("8613811111111/");
        dasm.append(new String(Hex.encodeHex("".getBytes(ecodeform))));
        dasm.append(",");
        dasm.append("8613011111111/");
        dasm.append(new String(Hex.encodeHex("".getBytes(ecodeform))));

        StringBuilder smsUrl = new StringBuilder();
        smsUrl.append(mtUrl);
        smsUrl.append("?command=" + command);
        smsUrl.append("&spid=" + spid);
        smsUrl.append("&sppassword=" + sppassword);
        smsUrl.append("&spsc=" + spsc);
        smsUrl.append("&sa=" + sa);
        smsUrl.append("&dasm=" + dasm.toString());
        smsUrl.append("&dc=" + dc);


        String resStr = doPostRequest(smsUrl.toString());
        System.out.println(resStr);

        HashMap<String, String> pp = parseResStr(resStr);
        System.out.println(pp.get("command"));
        System.out.println(pp.get("spid"));
        System.out.println(pp.get("mtmsgids"));
        System.out.println(pp.get("mtstat"));
        System.out.println(pp.get("mterrcode"));
    }

    /**
     * �ļ�Ⱥ��ʵ��
     *
     * @throws Exception
     */
    public void testBatchMt() throws Exception {
        String command = "BATCH_MT_REQUEST";
        String spid = "1234";
        String sppassword = "1234";
        String spsc = "00";
        int taskid = 10001;

        int bmttype = 1;
        String title = java.net.URLEncoder.encode("", "GBK");
        int dc = 15;
        String ecodeform = "GBK";
        String content = new String(Hex.encodeHex("".getBytes(ecodeform)));
        String fileurl = "http://10.8.1.103:9001/testxiangtong.txt";

        /*/��ͬ�����ļ�Ⱥ��
        int bmttype = 2;
        String title = java.net.URLEncoder.encode("abc,���Բ�ͬ�����ļ�Ⱥ��", "GBK");
        int dc = 15;
        String content = "";//�˴�content���ÿ�
        String fileurl = "http://10.8.1.103:9001/testbutong.txt";
        //*/

        /*/��̬ģ���ļ�Ⱥ����
        int bmttype = 3;
        String title = java.net.URLEncoder.encode("abc,���Զ�̬ģ���ļ�Ⱥ��", "GBK");
        int dc = 15;
        String ecodeform = "GBK";
        String content = new String(Hex.encodeHex("��ã�������ͨ���綯̬ģ��Ⱥ�����Զ��ţ�ռλ���Բ���#p_1#��#p_2#".getBytes(ecodeform)));
        String fileurl = "http://10.8.1.103:9001/testdongtai2.txt";
        //*/

        int priority = 1;//

        StringBuilder smsUrl = new StringBuilder();
        smsUrl.append(mtUrl);
        smsUrl.append("?command=" + command);
        smsUrl.append("&spid=" + spid);
        smsUrl.append("&sppassword=" + sppassword);
        smsUrl.append("&spsc=" + spsc);
        smsUrl.append("&taskid=" + taskid);
        smsUrl.append("&bmttype=" + bmttype);
        smsUrl.append("&title=" + title);
        smsUrl.append("&dc=" + dc);
        smsUrl.append("&content=" + content);
        smsUrl.append("&url=" + fileurl);
        smsUrl.append("&priority=" + priority);
        //smsUrl.append("&attime=" + attime);
        //smsUrl.append("&validtime=" + validtime);

        String resStr = doGetRequest(smsUrl.toString());
        System.out.println(resStr);

        HashMap<String, String> pp = parseResStr(resStr);
        System.out.println(pp.get("command"));
        System.out.println(pp.get("spid"));
        System.out.println(pp.get("bmtmsgid"));
        System.out.println(pp.get("mtstat"));
        System.out.println(pp.get("mterrcode"));
    }

    /**
     * ����ͨ�ַ���ת����Hex�����ַ���
     *
     * @param dataCoding �����ʽ��15��ʾGBK���룬8��ʾUnicodeBigUnmarked���룬0��ʾISO8859-1����
     * @param realStr    ��ͨ�ַ���
     * @return Hex�����ַ���
     * @throws UnsupportedEncodingException
     */
    public static String encodeHexStr(int dataCoding, String realStr) {
        String hexStr = null;
        if (realStr != null) {
            try {
                if (dataCoding == 15) {
                    hexStr = new String(Hex.encodeHex(realStr.getBytes("GBK")));
                } else if ((dataCoding & 0x0C) == 0x08) {
                    hexStr = new String(Hex.encodeHex(realStr.getBytes("UnicodeBigUnmarked")));
                } else {
                    hexStr = new String(Hex.encodeHex(realStr.getBytes("ISO8859-1")));
                }
            } catch (UnsupportedEncodingException e) {
                System.out.println(e.toString());
            }
        }
        return hexStr;
    }

    /**
     * ��Hex�����ַ���ת������ͨ�ַ���
     *
     * @param dataCoding �������ʽ��15��ʾGBK���룬8��ʾUnicodeBigUnmarked���룬0��ʾISO8859-1����
     * @param hexStr     Hex�����ַ���
     * @return ��ͨ�ַ���
     */
    public static String decodeHexStr(int dataCoding, String hexStr) {
        String realStr = null;
        try {
            if (hexStr != null) {
                if (dataCoding == 15) {
                    realStr = new String(Hex.decodeHex(hexStr.toCharArray()), "GBK");
                } else if ((dataCoding & 0x0C) == 0x08) {
                    realStr = new String(Hex.decodeHex(hexStr.toCharArray()), "UnicodeBigUnmarked");
                } else {
                    realStr = new String(Hex.decodeHex(hexStr.toCharArray()), "ISO8859-1");
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return realStr;
    }

    /**
     * @return
     */
    public static String doGetRequest(String urlstr) {
        String res = null;
        HttpClient client = new HttpClient(new MultiThreadedHttpConnectionManager());
        client.getParams().setIntParameter("http.socket.timeout", 10000);
        client.getParams().setIntParameter("http.connection.timeout", 5000);

        HttpMethod httpmethod = new GetMethod(urlstr);
        try {
            int statusCode = client.executeMethod(httpmethod);
            if (statusCode == HttpStatus.SC_OK) {
                res = httpmethod.getResponseBodyAsString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpmethod.releaseConnection();
        }
        return res;
    }

    /**
     * @param urlstr
     * @return
     */
    public static String doPostRequest(String urlstr) {
        String res = null;
        HttpClient client = new HttpClient(new MultiThreadedHttpConnectionManager());
        client.getParams().setIntParameter("http.socket.timeout", 10000);
        client.getParams().setIntParameter("http.connection.timeout", 5000);

        HttpMethod httpmethod = new PostMethod(urlstr);
        try {
            int statusCode = client.executeMethod(httpmethod);
            if (statusCode == HttpStatus.SC_OK) {
                res = httpmethod.getResponseBodyAsString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpmethod.releaseConnection();
        }
        return res;
    }

    /**
     * @param resStr
     * @return
     */
    public static HashMap<String, String> parseResStr(String resStr) {
        HashMap<String, String> pp = new HashMap<String, String>();
        try {
            String[] ps = resStr.split("&");
            for (int i = 0; i < ps.length; i++) {
                int ix = ps[i].indexOf("=");
                if (ix != -1) {
                    pp.put(ps[i].substring(0, ix), ps[i].substring(ix + 1));
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return pp;
    }

}

