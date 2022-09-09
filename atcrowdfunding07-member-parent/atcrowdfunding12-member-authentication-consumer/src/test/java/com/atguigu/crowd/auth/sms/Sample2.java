package com.atguigu.crowd.auth.sms;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.tea.TeaException;
import com.aliyun.teaopenapi.models.Config;
import com.aliyun.teautil.Common;
import com.aliyun.teautil.models.RuntimeOptions;
import com.atguigu.crowd.api.RedisRemoteService;
import com.atguigu.crowd.auth.config.ShortMessageProperties;
import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.util.CrowdUtil;
import com.atguigu.crowd.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

/**
 * @author zhuyuqi
 * @version v0.0.1
 * @className Sample2
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/08 22:32
 */
public class Sample2 {

    public static void main(String[] args) {
        String phoneNum = "13087515838";

        Config config = new Config();
        config.setAccessKeyId("LTAI5t7vJ5HhNKR2y5RVcirt");
        config.setAccessKeySecret("yXeqlGqN6P8LsV9wbCHj2ckf2GUJQr");
        config.endpoint = "dysmsapi.aliyuncs.com";

        Client client = null;
        try {
            client = new Client(config);
        } catch (Exception e) {
            e.printStackTrace();
        }

        SendSmsRequest sendSmsRequest = new SendSmsRequest();
        sendSmsRequest.setSignName("阿里云短信测试");
        sendSmsRequest.setTemplateCode("SMS_154950909");
        sendSmsRequest.setPhoneNumbers(phoneNum);
        //生成验证码
        String code = "";
        int rand;
        for (int i = 0; i < 4; i++) {
            rand = (int) (Math.random() * 10);
            code += rand + "";
        }

        sendSmsRequest.setTemplateParam("{\"code\":\"" + code + "\"}");

        RuntimeOptions runtimeOptions = new RuntimeOptions();
        int statusCode;
        try {
            SendSmsResponse sendSmsResponse = client.sendSmsWithOptions(sendSmsRequest, runtimeOptions);
            statusCode = sendSmsResponse.statusCode;
            if (statusCode == 200) {
                System.out.println(sendSmsResponse.toString() + "刚发送，看看sendSmsResponse是个啥++++++++++++++++++++++++++++++++++");
                System.out.println(statusCode);
            }
            System.out.println(statusCode + "如果发送没成功，打印发送玩的响应码是啥++++++++++++++++++++");
        } catch (TeaException error) {
            String errMessage = Common.assertAsString(error.message);
            System.out.println("+++++++++++++++++++++TeaException:" + errMessage);
        } catch (Exception e) {
            TeaException error = new TeaException(e.getMessage(), e);
            String errMessage = Common.assertAsString(error.message);
            System.out.println("+++++++++++++++++++++Exception:" + errMessage);
        }
    }
}
