package com.abt.java.xor;

/**
 * @描述： @异或运算^
 * @作者： @黄卫旗
 * @创建时间： @15/06/2018
 */
public class TestXor {

    public static void main(String[] args) {
        baseRule();
        reversal();
    }

    private static void baseRule() {
        System.out.println("0^0="+(0^0));
        System.out.println("0^1="+(0^1));
        System.out.println("1^0="+(1^0));
        System.out.println("1^1="+(1^1));
    }

    private static void reversal() {
        String a1 = "a1"; // 10100001
        String a6 = "06"; // 00000110
        System.out.println("10100001^10000110="+(10100001^10000110));

    }
}
