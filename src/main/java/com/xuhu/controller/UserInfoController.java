package com.xuhu.controller;

import com.xuhu.biz.IUserInfoService;
import com.xuhu.dao.model.UserInfo;
import com.xuhu.utils.IDUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by xuhu on 2017/2/18.
 */
@Api(value = "用户信息管理", tags = {"用户管理API"})
@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private IUserInfoService userInfoService;


    @ApiOperation("获取用户列表")
    @GetMapping("/getAll")
    public List<UserInfo> getAll(){
        List<UserInfo> userInfos = userInfoService.findAll();
        return userInfos;
//        return null;
    }

    @ApiOperation("添加用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "age", value = "年龄", required = true, dataType = "Integer")
    })

    @PostMapping("/addUser")
    public String add(UserInfo userInfo){
        userInfo.setId(IDUtil.UUID());

        userInfoService.addUser(userInfo);

        return "SUCCESS";
    }

    @ApiOperation(value = "获取用户列表信息", notes = "根据用户传入的page获取用户列表")
    @ApiImplicitParam(name = "page", value = "页码", required = true, paramType = "path", dataType = "Integer")
    @GetMapping("/getByPage/{page}")
    public List<UserInfo> getByPage(@PathVariable("page") Integer page){
        UserInfo userInfo = new UserInfo();
        userInfo.setPage(page);
        return userInfoService.findByPage(userInfo);
    }

    @RequestMapping("/remove/{userId}")
    public String removeUser(@PathVariable("userId") String userId){
        int count = userInfoService.removeUser(userId);
        return count > 0 ? "SUCCESS" : "FAILED";
    }

    @RequestMapping("/getUser/{userId}")
    public UserInfo getUser(@PathVariable("userId") String userId){
        return userInfoService.getUserById(userId);
    }



}
