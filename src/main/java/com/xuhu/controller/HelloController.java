package com.xuhu.controller;

import com.xuhu.dao.model.LombokModel;
import com.xuhu.prop.DataProp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by xuhu on 2017/2/11.
 */

@ApiIgnore
@RestController
public class HelloController {

    @Autowired
    private DataProp dataProp;

    @RequestMapping("/")
    public String hello(){
        return "Hello world->" + dataProp.getMsg();
    }


    @GetMapping("/getLombok")
    public LombokModel getLombok(){

        LombokModel lombokModel = LombokModel.of("test", 25);
        return lombokModel;
    }

}
