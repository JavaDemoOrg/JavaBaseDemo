package com.abt.java.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @描述： @自定义一个Java注解
 *        @1. @Retention(RetentionPolicy.RUNTIME)运行时读取并处理注解信息
 *        @2. @Target(ElementType.METHOD)自定义注解只能修饰方法
 * @作者：    @黄卫旗
 * @创建时间： @25/05/2018
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Anno {

}
