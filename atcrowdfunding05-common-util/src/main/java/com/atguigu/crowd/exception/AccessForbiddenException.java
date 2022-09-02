/**
 * 
 */
package com.atguigu.crowd.exception;

/**
 * @ClassName: AccessForbiddenException
 * @Description: 描述这个类的作用
 * @author: zhuyuqi
 * @Company: http://sk370.github.io
 * @date: 2022年9月1日 下午1:44:24
 * @param:
 */
public class AccessForbiddenException extends RuntimeException {
    static final long serialVersionUID = 1L;

    public AccessForbiddenException() {
        super();
    }

    public AccessForbiddenException(String message, Throwable cause, boolean enableSuppression,
        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public AccessForbiddenException(String message, Throwable cause) {
        super(message, cause);;
    }

    public AccessForbiddenException(String message) {
        super(message);;
    }

    public AccessForbiddenException(Throwable cause) {
        super(cause);;
    }

}
