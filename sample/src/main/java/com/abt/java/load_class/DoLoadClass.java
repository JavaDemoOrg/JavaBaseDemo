package com.abt.java.load_class;

/**
 * @描述： @DoLoadClass
 * @作者： @黄卫旗
 * @创建时间： @30/06/2018
 */
public class DoLoadClass {

    public static void main(String[] args) throws ClassNotFoundException {
        //Scene-1
        //new Tester();

        //Scene-2
        //System.out.println(Tester.compileConstant);

        //Scene-3
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        //classLoader.loadClass("Tester"); // 这样找不到Tester
        classLoader.loadClass("com.abt.java.load_class.Tester");
        System.out.println("系统加载了Tester类");
        Class.forName("com.abt.java.load_class.Tester");
    }

}
