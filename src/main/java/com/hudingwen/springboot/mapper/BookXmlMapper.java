package com.hudingwen.springboot.mapper;

import com.hudingwen.springboot.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClassName:BookXmlMapper
 * Package:com.hudingwen.springboot.mapper
 * Description:mapper的xml实现
 * Date:2022-10-20 14:39:37
 * Author:胡丁文
 * E-mail:admin@aiwanyun.cn
 **/
@Mapper
@Repository
public interface BookXmlMapper {
    public List<Book> findBook();
}
