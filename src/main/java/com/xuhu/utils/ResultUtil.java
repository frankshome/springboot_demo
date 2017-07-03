package com.xuhu.utils;

import com.xuhu.constant.ResultCodeEnum;

/**
 * Created by xuhu on 2017/7/3.
 */
public class ResultUtil {

    public static <T> Result<T> success(T t){
        Result<T> result = new Result<T>();
        result.setCode(ResultCodeEnum.SUCCESS.code());
        result.setMsg(ResultCodeEnum.SUCCESS.desc());
        result.setData(t);

        return result;
    }

    public static <T> Result success(){
        Result result = new Result();
        result.setCode(ResultCodeEnum.SUCCESS.code());
        result.setMsg(ResultCodeEnum.SUCCESS.desc());

        return result;
    }

    public static Result error(ResultCodeEnum codeEnum, String errMsg){
        Result result = new Result();
        result.setCode(codeEnum.code());
        result.setMsg(String.format("%s:%s", codeEnum.desc(), errMsg));

        return result;
    }
}
