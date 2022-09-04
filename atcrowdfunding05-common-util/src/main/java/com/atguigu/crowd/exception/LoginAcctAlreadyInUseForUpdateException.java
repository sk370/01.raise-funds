/**
 * 
 */
package com.atguigu.crowd.exception;

/**
 * @ClassName: LoginAcctAlreadyInUseForUpdateException
 * @Description: 描述这个类的作用
 * @author: zhuyuqi
 * @Company: http://sk370.github.io
 * @date: 2022年9月1日 下午10:04:14
 * @param:
 */
public class LoginAcctAlreadyInUseForUpdateException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public LoginAcctAlreadyInUseForUpdateException() {
        super();
    }

    public LoginAcctAlreadyInUseForUpdateException(String message, Throwable cause, boolean enableSuppression,
        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public LoginAcctAlreadyInUseForUpdateException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginAcctAlreadyInUseForUpdateException(String message) {
        super(message);
    }

    public LoginAcctAlreadyInUseForUpdateException(Throwable cause) {
        super(cause);
    }

}
