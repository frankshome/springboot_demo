package com.xuhu.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;
import com.xuhu.dao.model.UserInfo;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuhu on 2017/7/7.
 */
public class MyDataFlowJob implements DataflowJob<UserInfo> {

    @Override
    public List<UserInfo> fetchData(ShardingContext shardingContext) {

        if (shardingContext.getShardingItem() == 0){
            List<UserInfo> userInfoList = new ArrayList<>();
            UserInfo u1 = new UserInfo();
            u1.setId("0001");

            UserInfo u2 = new UserInfo();
            u2.setId("0002");

            UserInfo u3 = new UserInfo();
            u3.setId("0003");

            userInfoList.add(u1);
            userInfoList.add(u2);
            userInfoList.add(u3);

            return userInfoList;
        }else if (shardingContext.getShardingItem() == 1){
            List<UserInfo> userInfoList = new ArrayList<>();
            UserInfo u1 = new UserInfo();
            u1.setId("0011");

            UserInfo u2 = new UserInfo();
            u2.setId("0012");

            UserInfo u3 = new UserInfo();
            u3.setId("0013");

            userInfoList.add(u1);
            userInfoList.add(u2);
            userInfoList.add(u3);

            return userInfoList;
        }else if (shardingContext.getShardingItem() == 2){
            List<UserInfo> userInfoList = new ArrayList<>();
            UserInfo u1 = new UserInfo();
            u1.setId("0021");

            UserInfo u2 = new UserInfo();
            u2.setId("0032");

            UserInfo u3 = new UserInfo();
            u3.setId("0033");

            userInfoList.add(u1);
            userInfoList.add(u2);
            userInfoList.add(u3);

            return userInfoList;
        }
        return null;
    }

    @Override
    public void processData(ShardingContext shardingContext, List<UserInfo> list) {
        System.out.println(shardingContext.getShardingItem()+"###"+
                StringUtils.join(list, ","));
    }
}
