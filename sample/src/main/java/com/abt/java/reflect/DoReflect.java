package com.abt.java.reflect;

import java.lang.reflect.Method;

/**
 * @描述： @DoReflect
 * @作者： @黄卫旗
 * @创建时间： @24/05/2018
 */
public class DoReflect {

    public static void main(String[] args) {
        System.out.println();
        printClassMethodMessage(new Printer());
        System.out.println();
        reflectCall();
    }

    /**
     * 获取方法
     * @param obj 该对象所属类的信息
     */
    public static void printClassMethodMessage(Object obj) {
        Class clazz = obj.getClass();
        System.out.println("类的名称是:\n" + clazz.getName());
        System.out.println();
        Method[] ms = clazz.getMethods();
        for (int i = 0; i < ms.length; i++) {
            Class returnType = ms[i].getReturnType();
            System.out.print(returnType.getName() + " ");
            System.out.print(ms[i].getName() + "(");
            Class[] paramTypes = ms[i].getParameterTypes();
            StringBuilder sb = new StringBuilder();
            for (Class type : paramTypes) {
                sb.append(type.getName() + ",");
            }
            int lastIndex = sb.length() - 1;
            if (lastIndex < 0) {
                lastIndex = 0;
            }
            if (sb.lastIndexOf(",") == lastIndex) {
                System.out.print(sb.substring(0, lastIndex));
            } else {
                System.out.print(sb);
            }
            System.out.println(")");
        }
    }

    public static void reflectCall() {
        Printer printer = new Printer();
        Class pClass = printer.getClass();
        try {
            pClass.getMethod("print").invoke(printer);
            pClass.getMethod("print", int.class, int.class).invoke(printer, 10, 20);
            pClass.getMethod("print", String.class, String.class).invoke(printer, "hello", "WORLD");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class Printer {
        public void print() {
            System.out.println("hello_world");
        }

        public void print(int a, int b) {
            System.out.println(a + b);
        }

        public void print(String a, String b) {
            System.out.println(a.toUpperCase() + "," + b.toLowerCase());
        }
    }

}
