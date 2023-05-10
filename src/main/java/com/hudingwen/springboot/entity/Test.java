package com.hudingwen.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * 达梦测试实体
 */
@TableName("test")
public class Test {
    @TableId
    public String TiD;
    public Date TdATE;
    public Date TtIMESTAMP;
    public Date TdATETIME;
    public Date TtIME;
}
