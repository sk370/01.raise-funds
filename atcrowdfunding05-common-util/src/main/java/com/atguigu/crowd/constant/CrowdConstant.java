/**
 * 
 */
package com.atguigu.crowd.constant;

/**
 * @ClassName: CrowdConstant
 * @Description: 描述这个类的作用
 * @author: zhuyuqi
 * @Company: http://sk370.github.io
 * @date: 2022年8月31日 下午9:34:19
 * @param:
 */
public class CrowdConstant {
    public static final String MESSAGE_LOGIN_FAILD = "抱歉，账号或密码错误，请重新输入。";
    public static final String MESSAGE_LOGIN_ACC_ALREADY_USED = "抱歉，此账号已存在。";
    public static final String MESSAGE_ACCESS_FORBIDEN = "抱歉，当前未登录，无法查看。";
    public static final String MESSAGE_STRING_INVALIDATE = "字符串不合法，字符串为空。";
    public static final String MESSAGE_SYSTEM_ERROR_LOGIN_NOT_UNIQUE = "系统错误，账号不唯一";
    public static final String MESSAGE_LOGIN_MESSAGE_NOT_EQUAL = "密码不匹配，登录失败";
    public static final String MESSAGE_ACCESS_DENIED = "权限不足";
    public static final String MESSAGE_CODE_NOT_EXISTS = "验证码不存在，请检查手机号或在15分钟内输入";
    public static final String MESSAGE_CODE_INVALID = "验证码输入错误";
    public static final String MESSAGE_HEADER_PICTURE_UPLOAD_FAILED = "头图上传失败";
    public static final String MESSAGE_HEADER_PICTURE_EMPTY = "头图不可为空！";
    public static final String MESSAGE_DETAIL_PICTURE_EMPTY = "详情图不可为空";
    public static final String MESSAGE_DETAIL_PICTURE_UPLOAD_FAILED = "详情图上传失败";
    public static final String MESSAGE_TEMPLE_PROJECT_MISSING = "临时存储的projectvo对象丢失";

    public static final String ATTR_NAME_EXCEPTION = "exception";// 异常
    public static final String ATTR_LOGIN_NAME_ADMIN = "loginAdmin";
    public static final String ATTR_NAME_LOGIN_MEMBER = "loginMember";
    public static final String ATTR_NAME_PAGE_INFO = "pageInfo";
    public static final String ATTR_NAME_MESSAGE = "message";
    public static final String ATTR_NAME_TEMPLATE_PROJECT = "projectVo";

    public static final String REDIS_CODE_PREFIX = "REDIS_CODE_PREFIX_";
}
