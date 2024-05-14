package com.sky.annotation;

import com.sky.enumeration.OperationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解，用于表示某个方法需要进行公告字段填充
 */
@Target(ElementType.METHOD)//指定注解只能加在方法上面
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoFill {
    //数据库操作的类型  update,insert
    OperationType value();
}
