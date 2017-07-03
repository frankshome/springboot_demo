package com.xuhu.controller;

import com.xuhu.biz.IUserInfoService;
import com.xuhu.constant.ResultCodeEnum;
import com.xuhu.dao.model.UserInfo;
import com.xuhu.utils.IDUtil;
import com.xuhu.utils.Result;
import com.xuhu.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by xuhu on 2017/2/18.
 */
@Api(value = "用户信息管理", tags = {"用户管理API"})
@RestController
@RequestMapping("/user")
public class UserInfoController {

    private Logger logger = LoggerFactory.getLogger(getClass());

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
    public Result add(@RequestBody @Valid UserInfo userInfo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            String errMsg = bindingResult.getFieldError().getDefaultMessage();
            return ResultUtil.error(ResultCodeEnum.ILLEGAL_PARAM, errMsg);
        }
        userInfo.setId(IDUtil.UUID());
        userInfoService.addUser(userInfo);

        return ResultUtil.success(userInfo);
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
