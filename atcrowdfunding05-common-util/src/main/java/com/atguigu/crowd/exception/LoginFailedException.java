/**
 * 
 */
package com.atguigu.crowd.exception;

/**
 * @ClassName: LoginFailedException
 * @Description: 登录失败
 * @author: zhuyuqi
 * @Company: http://sk370.github.io
 * @date: 2022年9月1日 上午9:24:49
 * @param:
 */
public class LoginFailedException extends RuntimeException {
    static final long serialVersionUID = 1L;

    public LoginFailedException() {
        super();
    }

    public LoginFailedException(String message, Throwable cause, boolean enableSuppression,
        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public LoginFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginFailedException(String message) {
        super(message);
    }

    public LoginFailedException(Throwable cause) {
        super(cause);
    }
}
