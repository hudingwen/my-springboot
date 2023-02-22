package com.hudingwen.springboot.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageRowBounds;
import com.hudingwen.springboot.config.PersonInfoConfig;
import com.hudingwen.springboot.entity.Book;
import com.hudingwen.springboot.exception.BusinessException;
import com.hudingwen.springboot.exception.Code;
import com.hudingwen.springboot.exception.SystemException;
import com.hudingwen.springboot.mapper.BookMapper;
import com.hudingwen.springboot.mapperPlus.BookMapperPlus;
import com.hudingwen.springboot.quartz.TestJob;
import com.hudingwen.springboot.service.ScheduleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName:TestController
 * Package:com.hudingwen.controller
 * Description:描述
 * Date:2022-10-20 10:02:57
 * Author:胡丁文
 * E-mail:admin@aiwanyun.cn
 **/
@Tag( name = "测试 Swagger")
@RestController
@RequestMapping("/api/test")
//@Slf4

public class TestController {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TestController.class);
    @Value("${version}")
    private String version;
    @Value("${person.name}")
    private String name;
    @Value("${person.address[0]}")
    private String address;
    @Value("${person.address2[0]}")
    private String address2;

    @Autowired
    private Environment env;

    @Autowired
    private PersonInfoConfig personInfo;

    @Autowired
    private BookMapper bookMapper;

    @Operation(summary = "测试")
    @GetMapping("/test")
    public String Test(){
        return  "ok";
    }
    @GetMapping("/test2")
    public String Test2(){
        return  version;
    }
    @GetMapping("/test3")
    public String Test3(){
        return  name;
    }
    @GetMapping("/test4")
    public String Test4(){
        return  address;
    }
    @GetMapping("/test5")
    public String Test5(){
        return  address2;
    }
    @GetMapping("/test6")
    public String Test6(){
        return  env.getProperty("person.name");
    }
    @GetMapping("/test7")
    public PersonInfoConfig Test7(){
        return personInfo;
    }
    @GetMapping("/test8")
    public List<Book> Test8(){
        List<Book> book = bookMapper.findBook();
        return book;
    }
    @GetMapping("/test9")
    @Transactional
    public int Test9(){
        Book book = new Book();
        book.name = "胡丁文";
        book.type = "男";
        book.description="大个子";
        int i = bookMapper.insertBook(book);
        return i;
    }
    @GetMapping("/test10")
    @Transactional
    public String Test10(){
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
        return "ok";
    }


    @Autowired
    private ScheduleService scheduleService;
    @GetMapping("/test11")
    public String Test11(){
        String jobName = scheduleService.scheduleFixTimeJob(TestJob.class, "0 */1 * * * ?", "数据");
        log.info("执行定时任务:"+ jobName);
        return "ok";
    }


    @GetMapping("/test12")
    public void Test12(){
        throw new BusinessException(Code.BUSINESS_ERR,"业务异常");
    }
    @GetMapping("/test13")
    public void Test13(){
        throw new SystemException(Code.SYSTEM_TIMEOUT_ERR,"系统自定义异常");
    }
    @GetMapping("/test14")
    public void Test14(){
        throw new RuntimeException("系统未知异常");
    }


    @Resource
    private BookMapperPlus bookMapperPlus;
    @GetMapping("/test15")
    public List<Book>  Test15(){
        Page<Object> objects = PageHelper.startPage(1, 1);
        List<Book> book = bookMapperPlus.findBook();
        return book;
    }
    @GetMapping("/test16")
    public List<Book>  Test16(){
        Page<Object> objects = PageHelper.startPage(1, 1);
        List<Book> book = bookMapperPlus.selectList(null);
        return book;
    }


    @GetMapping("/test17")
    public List<Book> Test17(){
        Page<Object> objects = PageHelper.startPage(1, 1);
        List<Book> book = bookMapper.findBook();
        long total = objects.getTotal();
        return book;
    }
    @GetMapping("/test18")
    public List<Book> Test18(){
        PageRowBounds rowBounds = new PageRowBounds(1, 1);
        List<Book> book = bookMapper.findBookPage(rowBounds);
        return book;
    }



}
