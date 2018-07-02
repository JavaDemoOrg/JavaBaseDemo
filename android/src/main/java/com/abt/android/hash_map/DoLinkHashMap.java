package com.abt.android.hash_map;

import java.util.LinkedHashMap;

/**
 * @描述： @DoLinkHashMap
 * @作者： @黄卫旗
 * @创建时间： @01/07/2018
 */
public class DoLinkHashMap {

    public static void main(String[] args) {
        //LruCache lruCache = new LruCache(16);
        //lruCache.size();

        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("key-1", 1);
        linkedHashMap.put("key-2", 2);
        linkedHashMap.put("key-3", 3);
        linkedHashMap.put("key-4", 4);
        linkedHashMap.put("key-5", 5);
        linkedHashMap.get("key-1");
    }
}
