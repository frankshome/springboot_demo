package com.xuhu.biz;

import com.xuhu.dao.model.UserInfo;

import java.util.List;

/**
 * Created by xuhu on 2017/2/18.
 */
public interface IUserInfoService {

    List<UserInfo> findAll();

    int addUser(UserInfo userInfo);

    List<UserInfo> findByPage(UserInfo userInfo);

    int removeUser(String userId);

    UserInfo getUserById(String userId);
}
