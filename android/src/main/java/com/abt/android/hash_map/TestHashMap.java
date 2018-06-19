package com.abt.android.hash_map;

import com.abt.android.util.TimeUtil;

import java.util.HashMap;

/**
 * @描述： @TestHashMap
 * @作者： @黄卫旗
 * @创建时间： @15/06/2018
 */
public class TestHashMap {
    //06-19 22:35:37.593 24740-24740/com.abt.android I/System.out: 2018-06-19 22:35:20:887
    //06-19 22:35:37.593 24740-24740/com.abt.android I/System.out: 2018-06-19 22:35:37:604
    //06-19 22:35:37.643 24740-24740/com.abt.android I/System.out: GetTime: 209531
    private static int MAX = 1000000;

    public static void main(String[] arg) {
        // testHashCode();
        testHashMap();
    }

    public static final void testHashMap() {
        HashMap map = new HashMap();
        String startStr = TimeUtil.getFormatStr(System.currentTimeMillis());
        for (int i=0; i<MAX; i++) {
            map.put("key-"+i, "value-"+i);
            //System.out.println("key-"+i+" value-"+i);
        }
        String endStr = TimeUtil.getFormatStr(System.currentTimeMillis());
        System.out.println(startStr);
        System.out.println(endStr);

        long start = System.nanoTime();
        String res = (String) map.get("key-999995");
        long end = System.nanoTime();
        System.out.println("GetTime: " + (end - start));
        System.out.println("res: "+res);
    }

    static final void testHashCode() {
        HashMap hash = new HashMap();
        hash.put("key", "value");
        System.out.println("hash: "+hash(hash));
        System.out.println("hashCode: "+hash.hashCode());
    }

    static final int hash(Object key) {
        int h;
        System.out.println("key.hashCode: "+key.hashCode());
        return (key == null) ? 0 : ((h = key.hashCode()) ^ h >>> 16);
    }

}
