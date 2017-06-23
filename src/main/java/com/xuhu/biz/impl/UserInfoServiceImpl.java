package com.xuhu.biz.impl;

import com.github.pagehelper.PageHelper;
import com.xuhu.biz.IUserInfoService;
import com.xuhu.dao.mapper.UserInfoMapper;
import com.xuhu.dao.model.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * Created by xuhu on 2017/2/18.
 */

@Service
public class UserInfoServiceImpl implements IUserInfoService {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    @Cacheable(value = "usercache",keyGenerator = "wiselyKeyGenerator")
    public List<UserInfo> findAll() {
        logger.info("查询用户信息 date:{}", new Date());
        return userInfoMapper.selectAll();
    }

    @Override
    @CachePut(value = "usercache",keyGenerator = "wiselyKeyGenerator")
    public int addUser(UserInfo userInfo) {
        return userInfoMapper.insert(userInfo);
    }

    @Override
    @Cacheable(value = "usercache",keyGenerator = "wiselyKeyGenerator")
    public List<UserInfo> findByPage(UserInfo userInfo) {

        if (userInfo.getPage() != null && userInfo.getRows() != null){
            PageHelper.startPage(userInfo.getPage(), userInfo.getRows());
        }

        Example example = new Example(UserInfo.class);
        Example.Criteria criteria = example.createCriteria();

        return userInfoMapper.selectByExample(example);
    }

    @Override
    @CacheEvict(value = "usercache",keyGenerator = "wiselyKeyGenerator")
    public int removeUser(String userId) {
        return userInfoMapper.deleteByPrimaryKey(userId);
    }

    @Override
    @Cacheable(value = "usercache",keyGenerator = "wiselyKeyGenerator")
    public UserInfo getUserById(String userId) {
        return userInfoMapper.selectByPrimaryKey(userId);
    }


}
