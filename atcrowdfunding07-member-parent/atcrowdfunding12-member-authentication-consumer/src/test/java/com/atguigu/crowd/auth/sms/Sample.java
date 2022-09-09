package com.atguigu.crowd.auth.sms;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.tea.TeaException;
import com.aliyun.teaopenapi.models.Config;
import com.aliyun.teautil.Common;
import com.aliyun.teautil.models.RuntimeOptions;

import java.util.List;

/**
 * @author zhuyuqi
 * @version v0.0.1
 * @className Sample
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/08 14:55
 */

public class Sample {
    /**
     * 使用AK&SK初始化账号Client
     * @param accessKeyId
     * @param accessKeySecret
     * @return Client
     * @throws Exception
     */
    public static Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        Config config = new Config()
                // 您的 AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 您的 AccessKey Secret
                .setAccessKeySecret(accessKeySecret);
        // 访问的域名
        config.endpoint = "dysmsapi.aliyuncs.com";
        return new Client(config);
    }


    //LTAI5t7vJ5HhNKR2y5RVcirt
    //yXeqlGqN6P8LsV9wbCHj2ckf2GUJQr
    public static void main(String[] args_) throws Exception {
//        List<String> args = java.util.Arrays.asList(args_);
        Client client = Sample.createClient("LTAI5t7vJ5HhNKR2y5RVcirt", "yXeqlGqN6P8LsV9wbCHj2ckf2GUJQr");
        SendSmsRequest sendSmsRequest = new SendSmsRequest()
                .setSignName("阿里云短信测试")
                .setTemplateCode("SMS_154950909")
                .setPhoneNumbers("13087515838")
                .setTemplateParam("{\"code\":\"1234\"}");
        RuntimeOptions runtime = new RuntimeOptions();
        try {
            // 复制代码运行请自行打印 API 的返回值
            SendSmsResponse sendSmsResponse = client.sendSmsWithOptions(sendSmsRequest, runtime);
            Integer statusCode = sendSmsResponse.statusCode;
            System.out.println(sendSmsResponse);
            System.out.println(statusCode);
        }  catch (Exception _error) {
            TeaException error = new TeaException(_error.getMessage(), _error);
            // 如有需要，请打印 error
            Common.assertAsString(error.message);
        }
    }
}
