package com.abt.java.load_class;

/**
 * @描述： @Tester
 * @作者： @黄卫旗
 * @创建时间： @30/06/2018
 */
public class Tester {
    static {
        System.out.println("Tester类被加载了，这是类的静态初始化快");
    }

    // static final String compileConstant = "常量，编译时自动替换，不会导致Tester被加载";
    static final String compileConstant = System.currentTimeMillis() + "";
}
