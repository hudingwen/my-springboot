package com.hudingwen.springboot.mapperPlus;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hudingwen.springboot.entity.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClassName:BookMapperPlus
 * Package:com.hudingwen.springboot.mapper
 * Description:描述
 * Date:2022-10-28 13:24:44
 * Author:胡丁文
 * E-mail:admin@aiwanyun.cn
 **/
public interface BookMapperPlus extends BaseMapper<Book> {
    @Select("select * from book")
    public List<Book> findBook();

    @Delete("delete from book")
    public int deleteBook();
}
