package cn.mailu.LushX.util;

import cn.mailu.LushX.exception.LushXException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Jsoup 工具类
 * Created by Silence on 2017/1/25.
 */
public class JsoupUtils {

    private static Logger logger= LoggerFactory.getLogger(JsoupUtils.class);
    private static final String UA_PHONE = "Mozilla/5.0 (Linux; Android 4.3; Nexus 10 Build/JSS15Q) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.23 Safari/537.36";
    private static final String UA_PC = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36";
    private static final String UA_PAD = "Mozilla/5.0 (iPad; CPU OS 9_1 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13B143 Safari/601.1";
    private static final int TIME_OUT = 10 * 1000;

    public static Document getDocWithPC(String url) {
        try {
            return Jsoup.connect(url).userAgent(UA_PC).timeout(TIME_OUT).ignoreContentType(true).get();
        } catch (IOException e) {
            logger.error("网址请求失败：" + url);
            throw new LushXException("网址请求失败：" + url);
        }
    }

    public static Document getDocWithPhone(String url) {
        try {
            return Jsoup.connect(url).userAgent(UA_PHONE).timeout(TIME_OUT).ignoreContentType(true).validateTLSCertificates(false).get();
        } catch (IOException e) {
            logger.error("网址请求失败：" + url);
            throw new LushXException("网址请求失败：" + url);
        }
    }

    public static Document getDocWithPad(String url) {
        try {
            return Jsoup.connect(url).userAgent(UA_PAD).timeout(TIME_OUT).ignoreContentType(true).validateTLSCertificates(false).get();
        } catch (IOException e) {
            logger.error("网址请求失败：" + url);
            throw new LushXException("网址请求失败：" + url);
        }
    }

    public static Document getDocWithPhone(String url, String cookie) {
        try {
            return Jsoup.connect(url).userAgent(UA_PHONE).timeout(TIME_OUT).header("Cookie", cookie).ignoreContentType(true).get();
        } catch (IOException e) {
            logger.error("网址请求失败：" + url);
            throw new LushXException("网址请求失败：" + url);
        }
    }

    public static Document getDocWithPC(String url, String cookie) {
        try {
            return Jsoup.connect(url).userAgent(UA_PHONE).timeout(TIME_OUT).header("Cookie", cookie).ignoreContentType(true).get();
        } catch (IOException e) {
            logger.error("网址请求失败：" + url);
            throw new LushXException("网址请求失败：" + url);
        }
    }

    public static String getUaPad(){
        return UA_PAD;
    }

}
