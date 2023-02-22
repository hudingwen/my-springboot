package com.hudingwen.springboot.redis;

import com.hudingwen.springboot.SpringbootApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * ClassName:RedisTest
 * Package:com.hudingwen.redis
 * Description:描述
 * Date:2022-10-20 13:42:21
 * Author:胡丁文
 * E-mail:admin@aiwanyun.cn
 **/
@SpringBootTest(classes = SpringbootApplication.class)
public class RedisTest {
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void setRedisKey(){
        redisTemplate.boundValueOps("name").set("胡丁文");
    }
    @Test
    public void getRedisKey(){
        Object name = redisTemplate.boundValueOps("name").get();
        System.out.println(name);
    }

}
