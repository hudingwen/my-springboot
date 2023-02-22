package com.hudingwen.springboot.exception;

/**
 * ClassName:SystemException
 * Package:com.hudingwen.springboot.exception
 * Description:描述
 * Date:2022-10-22 12:10:53
 * Author:系统异常
 * E-mail:admin@aiwanyun.cn
 **/
public class SystemException extends RuntimeException{
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public SystemException(Integer code,String message) {
        super(message);
        this.code = code;
    }

    public SystemException(Integer code,String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
