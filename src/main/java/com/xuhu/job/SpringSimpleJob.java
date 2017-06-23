package com.xuhu.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.FastDateFormat;

import java.util.Date;

/**
 * Created by xuhu on 2017/6/9.
 */
public class SpringSimpleJob implements SimpleJob {

    @Override
    public void execute(ShardingContext shardingContext) {
        System.out.println(String.format("Date:%s,Item:%s,Thread:%s",
                DateFormatUtils.ISO_8601_EXTENDED_DATETIME_TIME_ZONE_FORMAT.format(new Date()),
                shardingContext.getShardingParameter(), Thread.currentThread().getName()));
    }
}
