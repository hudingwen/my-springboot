package com.hudingwen.springboot.exception;

/**
 * ClassName:Result
 * Package:com.hudingwen.springboot.exception
 * Description:描述
 * Date:2022-10-22 12:14:13
 * Author:胡丁文
 * E-mail:admin@aiwanyun.cn
 **/
public class Result {
    private int code = Code.OK;
    private boolean success = true;
    private String msg;
    private Object data;
    public static Result Success(String msg){
        return new Result(true,msg);
    }
    public static Result Success(String msg,Object data){
        return new Result(true,msg,data);
    }
    public static Result Success(String msg,Object data,int code){
        return new Result(code,true,msg,data);
    }
    public static Result Fail(String msg){
        return new Result(false,msg);
    }
    public static Result Fail(String msg,Object data){
        return new Result(false,msg,data);
    }
    public static Result Fail(String msg,Object data,int code){
        return new Result(code,false,msg,data);
    }
    public Result(boolean success) {
        this.success = success;
    }

    public Result(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public Result(boolean success, String msg, Object data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    public Result(int code, boolean success, String msg, Object data) {
        this.code = code;
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}