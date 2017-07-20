package com.xuhu.handle;

import com.xuhu.constant.ResultCodeEnum;
import com.xuhu.utils.DemoException;
import com.xuhu.utils.Result;
import com.xuhu.utils.ResultUtil;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by xuhu on 2017/7/16.
 */
@RestControllerAdvice
public class ExceptionHandle {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(Throwable.class)
    public Result handle(Throwable e){

        ResultCodeEnum resultCodeEnum = ResultCodeEnum.FAIL;
        if (e instanceof DemoException){
            DemoException de = (DemoException) e;
            resultCodeEnum = de.getCodeEnum();
        }

        logger.error("请求异常:{},{}", resultCodeEnum.desc(), ExceptionUtils.getStackTrace(e));
        return ResultUtil.error(resultCodeEnum, e.getMessage());

    }
}
