package com.abt.java.annotation;

import java.lang.reflect.Method;

/**
 * @描述： @DoAnno
 * @作者： @黄卫旗
 * @创建时间： @25/05/2018
 */
public class DoAnno {

    public static void main(String[] args) throws ClassNotFoundException {
        process("com.abt.java.annotation.Person");
    }

    private static void process(String clazz) throws ClassNotFoundException {
        int passed = 0, failed = 0;
        // 遍历clazz对应类的所有方法
        for (Method method : Class.forName(clazz).getMethods()) {
            // 如果该方法使用了自定义注解@Anno修饰
            if (method.isAnnotationPresent(Anno.class)) {
                try {
                    method.invoke(null);
                    passed++;
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("方法 " + method + " 测试失败，出现异常");
                    failed++;
                }
            }
        }
        System.out.println("一共运行了 " + (passed + failed) + " 个方法");
        System.out.println("成功运行方法 " + passed + " 个");
        System.out.println("失败运行方法 " + failed + " 个");
    }
}
