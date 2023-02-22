package com.hudingwen.springboot.exception;

/**
 * ClassName:BusinessException
 * Package:com.hudingwen.springboot.exception
 * Description:业务异常
 * Date:2022-10-22 12:18:23
 * Author:胡丁文
 * E-mail:admin@aiwanyun.cn
 **/
public class BusinessException extends RuntimeException{
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public BusinessException(Integer code,String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(Integer code,String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
