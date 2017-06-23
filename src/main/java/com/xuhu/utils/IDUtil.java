package com.xuhu.utils;

import java.util.UUID;

/**
 * Created by xuhu on 2017/2/19.
 */
public class IDUtil {
    public static String UUID(){
        return UUID.randomUUID().toString().replaceAll("-","").toUpperCase();
    }
}
