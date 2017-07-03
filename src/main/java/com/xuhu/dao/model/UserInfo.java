package com.xuhu.dao.model;

import com.alibaba.fastjson.JSON;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Table(name = "USER_INFO")
public class UserInfo extends BaseEntity {

    @NotBlank(message = "姓名不能为空")
    @Column(name = "USER_NAME")
    private String name;

    @NotNull(message = "年龄不能为空")
    @Min(value = 0, message = "年龄不能小于0岁")
    @Max(value = 100, message = "年龄不能大于100岁")
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