package com.xuhu.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.ibatis.annotations.Case;

import java.util.Date;

/**
 * Created by xuhu on 2017/6/9.
 */
public class SpringSimpleJob implements SimpleJob {

    @Override
    public void execute(ShardingContext context) {
        switch (context.getShardingItem()){
            case 0:
                System.out.println("000000000000000");
                break;
            case 1:
                System.out.println("111111111111111");
                break;
            case 2:
                System.out.println("222222222222222");
            default:
                break;
        }

    }
}
