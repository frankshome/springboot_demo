package com.xuhu.utils;

import com.xuhu.constant.ResultCodeEnum;

/**
 * Created by xuhu on 2017/7/16.
 */
public class DemoException extends Exception {
    private ResultCodeEnum codeEnum;

    public DemoException(ResultCodeEnum codeEnum, String errMsg) {
        super(errMsg);
        this.codeEnum = codeEnum;
    }

    public DemoException(ResultCodeEnum codeEnum, Exception e) {
        super(e);
        this.codeEnum = codeEnum;
    }

    public ResultCodeEnum getCodeEnum() {
        return codeEnum;
    }

    public void setCodeEnum(ResultCodeEnum codeEnum) {
        this.codeEnum = codeEnum;
    }
}
