package com.hudingwen.springboot.config;

import com.hudingwen.springboot.controller.TestController;
import com.hudingwen.springboot.exception.BusinessException;
import com.hudingwen.springboot.exception.Code;
import com.hudingwen.springboot.exception.Result;
import com.hudingwen.springboot.exception.SystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ClassName:ExceptionConfig
 * Package:com.hudingwen.springboot.config
 * Description:描述
 * Date:2022-10-22 12:08:13
 * Author:胡丁文
 * E-mail:admin@aiwanyun.cn
 **/
@RestControllerAdvice
public class ExceptionConfig {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ExceptionConfig.class);

    @ExceptionHandler(Exception.class)
    public Result DoException(Exception ex){
        //记录日志(错误堆栈)
        //发送邮件给开发人员
        //发送短信给运维人员
        log.error("系统未知异常信息:{}",ex.getMessage());
        log.error("系统未知异常堆栈",ex);
        return Result.Fail("系统繁忙,请稍后再试!",null, Code.SYSTEM_UNKNOWN_ERR);
    }

    @ExceptionHandler(SystemException.class)
    public Result DoException(SystemException ex){
        //记录日志(错误堆栈)
        //发送邮件给开发人员
        //发送短信给运维人员
        log.error("系统自定义异常信息:{}",ex.getMessage());
        log.error("系统自定义异常堆栈",ex);
        return Result.Fail(ex.getMessage(),null,ex.getCode());
    }
    @ExceptionHandler(BusinessException.class)
    public Result DoException(BusinessException ex){
        //记录日志(错误堆栈)
        //发送邮件给开发人员
        //发送短信给运维人员
        log.error("业务异常信息:{}",ex.getMessage());
        log.error("业务异常堆栈",ex);
        return Result.Fail(ex.getMessage(),null,ex.getCode());
    }

}
