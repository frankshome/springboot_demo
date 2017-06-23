package com.xuhu.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by xuhu on 2017/2/19.
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
