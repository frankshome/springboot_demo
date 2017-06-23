package com.xuhu.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * Created by xuhu on 2017/5/17.
 */
@Data
@AllArgsConstructor(staticName = "of")
public class LombokModel {
    private String name;
    private Integer age;


    public static void main(String[] args) {
        LombokModel lombokModel = LombokModel.of("test", 20);
        lombokModel.setAge(22);
        System.out.println(lombokModel);

    }
}
