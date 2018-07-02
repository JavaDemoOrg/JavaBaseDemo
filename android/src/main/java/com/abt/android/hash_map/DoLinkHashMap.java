package com.abt.android.hash_map;

import android.util.LruCache;

import java.util.LinkedHashMap;

/**
 * @描述： @DoLinkHashMap
 * @作者： @黄卫旗
 * @创建时间： @01/07/2018
 */
public class DoLinkHashMap {

    public static void main(String[] args) {
        LruCache lruCache = new LruCache(16);
        lruCache.size();

        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("key", "value");
        linkedHashMap.get("key");
    }
}
