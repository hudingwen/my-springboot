package com.hudingwen.springboot.mysql;

import com.hudingwen.springboot.SpringbootApplication;
import com.hudingwen.springboot.entity.Book;
import com.hudingwen.springboot.mapper.BookMapper;
import com.hudingwen.springboot.mapper.BookXmlMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * ClassName:MysqlTest
 * Package:com.hudingwen.springboot.mysql
 * Description:描述
 * Date:2022-10-20 14:23:19
 * Author:胡丁文
 * E-mail:admin@aiwanyun.cn
 **/
@SpringBootTest(classes = SpringbootApplication.class)
public class MysqlTest {
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BookXmlMapper bookXmlMapper;

    @Test
    public void getBookData(){
        List<Book> book = bookMapper.findBook();
        System.out.println(book);
    }
    @Test
    public void getBookData2(){
        List<Book> book = bookXmlMapper.findBook();
        System.out.println(book);
    }
}
