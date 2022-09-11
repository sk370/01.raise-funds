package com.atguigu.crowd.auth.handler;

import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crowd.api.MySqlRemoteService;
import com.atguigu.crowd.api.RedisRemoteService;
import com.atguigu.crowd.auth.config.ShortMessageProperties;
import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.entity.po.MemberPO;
import com.atguigu.crowd.entity.vo.MemberLoginVO;
import com.atguigu.crowd.entity.vo.MemberVO;
import com.atguigu.crowd.util.CrowdUtil;
import com.atguigu.crowd.util.ResultEntity;

/**
 * @author zhuyuqi
 * @version v0.0.1
 * @className MemberHandler
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/08 18:16
 */
@Controller
public class MemberHandler {
    @Autowired
    private ShortMessageProperties shortMessageProperties;
    @Autowired
    private RedisRemoteService redisRemoteService;
    @Autowired
    private MySqlRemoteService mySqlRemoteService;

    /**
     * 退出登录
     * 
     * @param session
     * @return
     */
    @RequestMapping("auth/member/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:http://localhost:81/";
    }

    /**
     * 用户登录
     * 
     * @param loginacct
     * @param userpswd
     * @param modelMap
     * @return
     */
    @RequestMapping("auth/member/do/login")
    public String login(@RequestParam("loginacct") String loginacct, @RequestParam("userpswd") String userpswd,
        ModelMap modelMap, HttpSession session) {
        ResultEntity<MemberPO> loginAcctRemote = mySqlRemoteService.getMemberPOByLoginAcctRemote(loginacct);
        if (ResultEntity.FAILED.equals(loginAcctRemote.getResult())) {
            modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, loginAcctRemote.getMessage());
            return "member-login";
        }
        MemberPO memberPO = loginAcctRemote.getData();
        if (memberPO == null) {
            modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_LOGIN_FAILD);
            return "member-login";
        }

        String dataBaseUserPswd = memberPO.getUserpswd();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean matches = passwordEncoder.matches(userpswd, dataBaseUserPswd);

        if (!matches) {
            modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_LOGIN_FAILD);
            return "member-login";
        }

        MemberLoginVO memberLoginVO = new MemberLoginVO();
        memberLoginVO.setId(memberPO.getId());
        memberLoginVO.setUsername(memberPO.getUsername());
        memberLoginVO.setEmail(memberPO.getEmail());

        session.setAttribute(CrowdConstant.ATTR_NAME_LOGIN_MEMBER, memberLoginVO);
        // return "redirect:/auth/member/to/center/page";//这个重定向会指向auth的端口，和zuul是两个网站，会找不到session
        return "redirect:http://localhost:81/auth/member/to/center/page";
    }

    /**
     * 注册用户
     * 
     * @param memberVO
     * @param modelMap
     * @return
     */
    @RequestMapping("auth/do/member/register")
    public String register(MemberVO memberVO, ModelMap modelMap) {
        // 1. 获取表单信息
        String phoneNum = memberVO.getPhoneNum();
        String formCode = memberVO.getCode();
        String formPswd = memberVO.getUserpswd();
        // 2. 在redis中查找key，比较value
        String key = CrowdConstant.REDIS_CODE_PREFIX + phoneNum;
        ResultEntity<String> resultEntity = redisRemoteService.getRedisStringValueByKey(key);
        String result = resultEntity.getResult();
        if (ResultEntity.FAILED.equals(result)) {
            modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, resultEntity.getMessage());
            return "member-reg";
        }
        String code = resultEntity.getData();
        if (code == null) {
            modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_CODE_NOT_EXISTS);
            return "member-reg";
        }
        if (!code.equals(formCode)) {
            modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_CODE_INVALID);
            return "member-reg";
        }
        // 3. value一致，执行加密
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodePswd = bCryptPasswordEncoder.encode(formPswd);
        redisRemoteService.removeRedisStringValueByKey(key);
        memberVO.setUserpswd(encodePswd);
        MemberPO memberPO = new MemberPO();
        BeanUtils.copyProperties(memberVO, memberPO);
        // 4. 保存到数据库
        ResultEntity<String> saveMemberResultEntity = mySqlRemoteService.saveMember(memberPO);
        if (ResultEntity.FAILED.equals(saveMemberResultEntity.getResult())) {
            modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, saveMemberResultEntity.getMessage());
            return "member-reg";
        }
        // 使用重定向避免刷新浏览器导致重新执行注册流程
        return "redirect:/auth/member/to/login/page";
    }

    /**
     * 短信验证
     *
     * @param phoneNum
     * @return
     */
    @ResponseBody
    @RequestMapping("auth/member/send/short/message.json")
    public ResultEntity<String> sendMessage(@RequestParam("phoneNum") String phoneNum) {
        System.out.println(phoneNum + "+++++++++++++++++++++++++++++++");
        // 1.发送验证码到手机
        ResultEntity<String> stringResultEntity = CrowdUtil.sendShortMessage(shortMessageProperties.getAccessKeyId(),
            shortMessageProperties.getAccessKeySecret(), shortMessageProperties.getEndpoint(),
            shortMessageProperties.getSignName(), shortMessageProperties.getTemplateCode(), phoneNum);
        // System.out.println(stringResultEntity + "+++++++++++++++++++++++++++++++handler调用完了");
        // 2.判断发送结果
        if (ResultEntity.SUCCESS.equals(stringResultEntity.getResult())) {
            // 2.1发送成功，将验证码保存到redis
            String code = stringResultEntity.getData();// 验证码
            // System.out.println("handler执行完的成功验证码++++++++++++++++++++" + code);
            String key = CrowdConstant.REDIS_CODE_PREFIX + phoneNum;
            ResultEntity<String> saveRedisResultEntity =
                redisRemoteService.setRedisKeyValueRemoteWithTimeout(key, code, 15, TimeUnit.MINUTES);

            if (ResultEntity.SUCCESS.equals(saveRedisResultEntity.getResult())) {
                return ResultEntity.successWithoutData();
            } else {
                // 2.2.1验证码保存失败，返回的提示信息
                return saveRedisResultEntity;// redis的返回，把它再转给前端
            }
        } else {
            // 2.2.2验证码发送失败，返回的提示信息
            return stringResultEntity;
        }
    }
}
