package com.xuhu.utils;

/**
 * Created by xuhu on 2017/6/25.
 */
public class Result<T> {

    private String code;
    private String msg;
    private T data;

    public Result() {
        this.code = "0000";
    }

    public Result(T data) {
        this.code = "0000";
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
