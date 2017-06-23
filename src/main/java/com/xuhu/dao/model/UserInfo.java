package com.xuhu.dao.model;

import com.alibaba.fastjson.JSON;

import javax.persistence.*;

@Table(name = "USER_INFO")
public class UserInfo extends BaseEntity {

    @Column(name = "USER_NAME")
    private String name;

    @Column(name = "AGE")
    private Integer age;


    /**
     * @return NAME
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return AGE
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

//    @Override
//    public String toString() {
//        return super.toString().concat(JSON.toJSONString(this));
//    }
}