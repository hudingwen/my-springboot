package com.hudingwen.springboot.mapper;

import com.hudingwen.springboot.entity.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * ClassName:UserMapper
 * Package:com.hudingwen.springboot.mapper
 * Description:mapper的注解实现
 * Date:2022-10-20 14:15:33
 * Author:胡丁文
 * E-mail:admin@aiwanyun.cn
 **/

@Mapper
@Repository
public interface BookMapper {

    @Select("select * from book")
    public List<Book> findBook();
    @Select("select * from book")
    public List<Book> findBookPage(RowBounds rowBounds);

    @Delete("delete from book")
    public int deleteBook();

    @Insert("insert into book(type,name,description) value(#{name},#{type},#{description})")
    public int insertBook(Book book);
}
