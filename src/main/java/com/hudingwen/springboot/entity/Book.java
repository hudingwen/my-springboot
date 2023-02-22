package com.hudingwen.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * ClassName:Book
 * Package:com.hudingwen.springboot.entity
 * Description:描述
 * Date:2022-10-20 14:12:45
 * Author:胡丁文
 * E-mail:admin@aiwanyun.cn
 **/
@TableName("book")
public class Book {
    @TableId
    public String id;
    public String type;
    public String name;
    public String description;

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
