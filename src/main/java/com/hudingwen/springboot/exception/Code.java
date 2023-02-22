package com.hudingwen.springboot.exception;

/**
 * ClassName:Code
 * Package:com.hudingwen.springboot.exception
 * Description:描述
 * Date:2022-10-22 12:14:25
 * Author:胡丁文
 * E-mail:admin@aiwanyun.cn
 **/
public class Code {
    public static final Integer OK = 200;
    public static final Integer SAVE_OK = 200100;
    public static final Integer UPDATE_OK = 200200;
    public static final Integer DELETE_OK = 200300;
    public static final Integer SAVE_ERR = 200101;
    public static final Integer UPDATE_ERR = 200201;
    public static final Integer DELETE_ERR = 200301;


    public static final Integer NO_FOUNT = 404;
    public static final Integer NO_LOGIN = 401;
    public static final Integer NO_PERMISSION = 403;


    public static final Integer ERR = 500;
    public static final Integer BUSINESS_ERR = 500001;
    public static final Integer SYSTEM_UNKNOWN_ERR = 599999;
    public static final Integer SYSTEM_TIMEOUT_ERR = 500002;


}
