package com.abt.java.load_class;

/**
 * @描述： @Tester
 * @作者： @黄卫旗
 * @创建时间： @30/06/2018
 */
public class Tester extends Parent {
    static {
        System.out.println("类Tester被加载了，正在执行类的静态初始化块");
    }

    // static final String compileConstant = "常量，编译时自动替换，不会导致Tester被加载";
    static final String compileConstant = System.currentTimeMillis() + "";
}
