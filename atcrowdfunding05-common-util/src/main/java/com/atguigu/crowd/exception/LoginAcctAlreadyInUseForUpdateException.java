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
        // TODO Auto-generated constructor stub
    }

    public LoginAcctAlreadyInUseForUpdateException(String message, Throwable cause, boolean enableSuppression,
        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

    public LoginAcctAlreadyInUseForUpdateException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public LoginAcctAlreadyInUseForUpdateException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public LoginAcctAlreadyInUseForUpdateException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

}
