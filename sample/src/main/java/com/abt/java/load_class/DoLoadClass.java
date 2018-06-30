package com.abt.java.load_class;

/**
 * @描述： @DoLoadClass
 * @作者： @黄卫旗
 * @创建时间： @30/06/2018
 */
public class DoLoadClass {

    public static void main(String[] args) throws ClassNotFoundException {
        //System.out.println(Tester.compileConstant);

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        //classLoader.loadClass("Tester"); // 这样找不到Tester
        classLoader.loadClass("com.abt.java.load_class.Tester");
        System.out.println("系统加载Tester类");
        Class.forName("com.abt.java.load_class.Tester");
    }

}
