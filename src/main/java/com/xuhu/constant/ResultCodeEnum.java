package com.xuhu.constant;

/**
 * Created by xuhu on 2017/7/3.
 */
public enum ResultCodeEnum {
    SUCCESS("0000", "成功"),
    FAIL("0001", "失败"),
    ILLEGAL_PARAM("0002", "参数不合法");

    ResultCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private String code;
    private String desc;

    public String code() {
        return code;
    }

    public String desc() {
        return desc;
    }
}
