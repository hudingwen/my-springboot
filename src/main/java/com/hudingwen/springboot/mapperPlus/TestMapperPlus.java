package com.hudingwen.springboot.mapperPlus;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hudingwen.springboot.entity.Test;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * ClassName:BookMapperPlus
 * Package:com.hudingwen.springboot.mapper
 * Description:描述
 * Date:2022-10-28 13:24:44
 * Author:胡丁文
 * E-mail:admin@aiwanyun.cn
 **/
public interface TestMapperPlus extends BaseMapper<Test> {
    @Select("select * from test")
    public List<Test> findBook();

    @Delete("delete from test")
    public int deleteBook();
}
