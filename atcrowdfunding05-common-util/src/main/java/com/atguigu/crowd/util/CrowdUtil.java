/**
 *
 */
package com.atguigu.crowd.util;

import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.comm.ResponseMessage;
import com.aliyun.oss.model.PutObjectResult;
import com.aliyun.tea.TeaException;
import com.aliyun.teaopenapi.models.Config;
import com.aliyun.teautil.Common;
import com.aliyun.teautil.models.RuntimeOptions;
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
     * 阿里云OSS：上传功能
     *
     * @param endpoint
     * @param accessKeyId
     * @param accessKeySecret
     * @param inputStream
     * @param bucketName
     * @param originalName
     * @return
     */
    public static ResultEntity<String> uploadFileToOss(String endpoint, String accessKeyId, String accessKeySecret,
        InputStream inputStream, String bucketName, String originalName) {
        // 生成OSSClient
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try {
            // 判断Bucket是否存在
            if (ossClient.doesBucketExist(bucketName)) {
                System.out.println("您已经创建Bucket：" + bucketName + "。");
            } else {
                System.out.println("您的Bucket不存在，创建Bucket：" + bucketName + "。");
                // 创建Bucket。
                ossClient.createBucket(bucketName);
            }
            // 查看Bucket信息
            // BucketInfo info = ossClient.getBucketInfo(bucketName);
            // System.out.println("Bucket " + bucketName + "的信息如下：");
            // System.out.println("\t数据中心：" + info.getBucket().getLocation());
            // System.out.println("\t创建时间：" + info.getBucket().getCreationDate());
            // System.out.println("\t用户标志：" + info.getBucket().getOwner());

            // 生成上传文件的目录
            String folderName = new SimpleDateFormat("yyyyMMdd").format(new Date());
            // 使用 UUID 生成文件主体名称
            String fileMainName = UUID.randomUUID().toString().replace("-", "");
            // 从原始文件名中获取文件扩展名
            String extensionName = originalName.substring(originalName.lastIndexOf("."));
            // 使用目录、 文件主体名称、 文件扩展名称拼接得到对象名称
            String objectName = folderName + "/" + fileMainName + extensionName;

            // 把字符串存入OSS，Object的名称为objectName。
            PutObjectResult putObjectResult = ossClient.putObject(bucketName, objectName, inputStream);
            // System.out.println("Object：" + objectName + "存入OSS成功。");

            ResponseMessage response = putObjectResult.getResponse();
            // 根据响应状态码判断请求是否成功
            if (response == null) {
                // 拼接访问刚刚上传的文件的路径
                String ossFileAccessPath = bucketName + "/" + objectName;
                // 当前方法返回成功
                return ResultEntity.successWithData(ossFileAccessPath);
            } else {
                // 获取响应状态码
                int statusCode = response.getStatusCode();
                // 如果请求没有成功， 获取错误消息
                String errorMessage = response.getErrorResponseAsString();
                return ResultEntity.failed("当前响应状态码=" + statusCode + "，错误消息=" + errorMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }

    /**
     * 阿里云短信服务
     *
     * @param accessKeyId 私有id
     * @param accessKeySecret 私有key
     * @param endpoint 短信服务域名
     * @param signName 短信签名
     * @param templateCode 短信模板
     * @param phoneNum 电话号码
     * @return 发送成功返回验证码，失败返回失败消息
     */
    public static ResultEntity<String> sendShortMessage(String accessKeyId, String accessKeySecret, String endpoint,
        String signName, String templateCode, String phoneNum) {
        Config config = new Config();
        config.setAccessKeyId(accessKeyId);
        config.setAccessKeySecret(accessKeySecret);
        config.endpoint = endpoint;

        Client client = null;
        try {
            client = new Client(config);
        } catch (Exception e) {
            e.printStackTrace();
        }

        SendSmsRequest sendSmsRequest = new SendSmsRequest();
        sendSmsRequest.setSignName(signName);
        sendSmsRequest.setTemplateCode(templateCode);
        sendSmsRequest.setPhoneNumbers(phoneNum);
        // 生成验证码
        String code = "";
        int rand;
        for (int i = 0; i < 4; i++) {
            rand = (int)(Math.random() * 10);
            code += rand + "";
        }

        sendSmsRequest.setTemplateParam("{\"code\":\"" + code + "\"}");

        RuntimeOptions runtimeOptions = new RuntimeOptions();
        int statusCode;
        try {
            SendSmsResponse sendSmsResponse = client.sendSmsWithOptions(sendSmsRequest, runtimeOptions);
            // System.out.println(sendSmsResponse.toString() +
            // "刚发送，看看sendSmsResponse是个啥++++++++++++++++++++++++++++++++++");
            statusCode = sendSmsResponse.statusCode;
            if (statusCode == 200) {
                return ResultEntity.successWithData(code);
            }
            return ResultEntity.failed(sendSmsResponse.toString());
        } catch (TeaException error) {
            String errMessage = Common.assertAsString(error.message);
            // System.out.println("+++++++++++++++++++++TeaException" + errMessage);
            return ResultEntity.failed(errMessage);
        } catch (Exception e) {
            TeaException error = new TeaException(e.getMessage(), e);
            String errMessage = Common.assertAsString(error.message);
            // System.out.println("+++++++++++++++++++++Exception" + errMessage);
            return ResultEntity.failed(errMessage);
        }
    }

    /**
     * MD5密码加密：引入springsecurity后不使用
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
