package com.abt.java.string;

/**
 * @描述： @DoString
 * @作者： @黄卫旗
 * @创建时间： @13/06/2018
 */
public class DoString {

    public static void main(String[] args) {
        testEquals();
    }

    private static void testEquals() {
        String str1 = new String("aaa");
        String str2 = new String("aaa");

        System.out.println(str1.equals(str2));
        System.out.println(str1==str2);
    }

}
