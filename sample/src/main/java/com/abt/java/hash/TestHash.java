package com.abt.java.hash;

import java.util.HashMap;

/**
 * @描述： @TestHash
 * @作者： @黄卫旗
 * @创建时间： @13/06/2018
 */
public class TestHash {

    public static void main(String[] args) {
        testHash();
    }

    private static void testHash() {
        TestHash test = new TestHash();
        String str1 = new String("gdejicbeghijk");//gdejicbegh
        String str2 = new String("hgebcijedgijk");//hgebcijedg
        System.out.println("hashCode = "+str1.hashCode());//test.hashCode(str1));
        System.out.println("hashCode = "+str2.hashCode());//test.hashCode(str2));

        System.out.println("str1==str2 : "+(str1==str2));
        System.out.println("str1.equals(str2) : "+ str1.equals(str2));
    }

    private int hash = 0;
    private int hashCode(String str) {
        System.out.println("hashCode str = "+str);
        System.out.println("hashCode hash = "+hash);
        int h = hash;
        final int len = str.length();
        if (h == 0 && len > 0) {
            for (int i = 0; i < len; i++) {
                h = 31 * h + str.charAt(i);
                System.out.println("str.charAt("+i+") = "+str.charAt(i)*1);
            }
            hash = h;
        }
        return h;
    }

    private void testHashMap() {
        HashMap map = new HashMap();
        map.hashCode();
    }

}
