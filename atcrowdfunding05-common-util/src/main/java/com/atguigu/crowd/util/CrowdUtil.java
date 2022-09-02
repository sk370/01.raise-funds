/**
 * 
 */
package com.atguigu.crowd.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.exception.AccessForbiddenException;

/**
 * @ClassName: CrowdUtil
 * @Description: 描述这个类的作用
 * @author: zhuyuqi
 * @Company: http://sk370.github.io
 * @date: 2022年8月31日 下午6:38:58
 * @param:
 */
public class CrowdUtil {

    /**
     * MD5密码加密
     * 
     * @param source 明文字符串
     * @return 加密结果
     */
    public static String md5(String source) {
        if (source == null || source.length() == 0) {
            throw new AccessForbiddenException(CrowdConstant.MESSAGE_STRING_INVALIDATE);
        }
        String algorithm = "md5";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);// Java提供的md5加密类
            byte[] bytes = source.getBytes();
            byte[] digest = messageDigest.digest(bytes);// 对source加密
            int signum = 1;
            BigInteger bigInteger = new BigInteger(signum, digest);// 创建一个正大整数，signum为-1表示负数，为0表示0
            int radix = 16;
            String encoded = bigInteger.toString(radix).toUpperCase();// 将正大整数转换为16进制字符串
            return encoded;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 判断当前请求是否为ajax请求
     * 
     * @param request
     * @return
     */
    public static boolean judgeRequestType(HttpServletRequest request) {
        String acceptHeader = request.getHeader("Accept");
        String xRequestHeader = request.getHeader("X-Requested-With");
        return (acceptHeader != null && acceptHeader.contains("application/json"))
            || (xRequestHeader != null && xRequestHeader.contains("XMLHttpRequest"));
    }
}