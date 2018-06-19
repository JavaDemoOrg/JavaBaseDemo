package com.abt.java.shift;

/**
 * @描述： @TestShift
 * @作者： @黄卫旗
 * @创建时间： @14/06/2018
 */
public class TestShift {
    public static void main(String[] args) {
        int number = 10;
        //二进制原始数
        printInfo(number);
        number = number << 1;
        //左移一位
        printInfo(number);
        number = number >> 1;
        //右移一位
        printInfo(number);
        number = Integer.MAX_VALUE;
        printInfo(number);
        number = number >> 1;
        //右移一位
        printInfo(number);
        number = number << 1;
        printInfo(number);
    }

    /**
     * 输出一个int的二进制数
     * @param num
     */
    private static void printInfo(int num) {
        String str = Integer.toBinaryString(num);
        System.out.println(str + " - len="+str.length());
    }
}
