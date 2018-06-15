package com.abt.java.hash;

import java.util.HashMap;

/**
 * @描述： @TestHashMap
 * @作者： @黄卫旗
 * @创建时间： @15/06/2018
 */
public class TestHashMap {

    public static void main(String[] arg) {
        HashMap hash = new HashMap();
        hash.put("key", "value");
        System.out.println("hash: "+hash(hash));

        System.out.println("hashCode: "+hash.hashCode());
        Object obj = hash;
        System.out.println("obj.hashCode: "+obj.hashCode());
    }

    static final int hash(Object key) {
        int h;
        System.out.println("key.hashCode: "+key.hashCode());
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

}
