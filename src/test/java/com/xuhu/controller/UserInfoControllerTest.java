package com.xuhu.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

/**
 * Created by xuhu on 2017/7/18.
 */
public class UserInfoControllerTest extends ControllerBaseTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getAll() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/user/getAll"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("0000"));
    }

}