package com.hudingwen.springboot.service;

import com.hudingwen.springboot.SpringbootApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * ClassName:TestServiceTest
 * Package:com.hudingwen.service
 * Description:描述
 * Date:2022-10-20 13:29:42
 * Author:胡丁文
 * E-mail:admin@aiwanyun.cn
 **/
@SpringBootTest(classes = SpringbootApplication.class)
public class TestServiceTest {
    @Autowired
    TestService testService;

    @Test
    public void  testAdd(){
        testService.add();
    }
}
