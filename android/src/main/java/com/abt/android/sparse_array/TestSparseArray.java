package com.abt.android.sparse_array;

import android.util.SparseArray;

import com.abt.android.util.TimeUtil;

/**
 * @描述： @TestSparseArray
 * @作者： @黄卫旗
 * @创建时间： @16/06/2018
 */
public class TestSparseArray {
    //06-19 22:32:41.983 20935-20935/com.abt.android I/System.out: 2018-06-19 22:32:28:500
    //06-19 22:32:41.983 20935-20935/com.abt.android I/System.out: 2018-06-19 22:32:41:989
    //06-19 22:32:41.993 20935-20935/com.abt.android I/System.out: GetTime: 146667
    private static int MAX = 1000000;

    public static void main(String[] args) {
        //testSparseArray();
        testMemoryTime();
    }

    public static final void testSparseArray() {
        SparseArray sparseArray = new SparseArray();
        String startStr = TimeUtil.getFormatStr(System.currentTimeMillis());
        for (int i=0; i<MAX; i++) {
            sparseArray.put(i, "value-"+i);
            //System.out.println("key-"+i+" value-"+i);
        }
        String endStr = TimeUtil.getFormatStr(System.currentTimeMillis());
        System.out.println(startStr);
        System.out.println(endStr);

        long start = System.nanoTime();
        String res = (String) sparseArray.get(999995);
        long end = System.nanoTime();
        System.out.println("GetTime: " + (end - start));
        System.out.println("res: "+res);
    }

    public static final void testMemoryTime() {
        SparseArray sparse = new SparseArray(MAX);
        long startSparse = System.currentTimeMillis();
        for(int i=0;i<MAX;i++){
            sparse.put(i, i);
        }
        long sparseMemory = Runtime.getRuntime().totalMemory();
        long endSparse = System.currentTimeMillis()-startSparse;
        System.out.println("<---Sparse的插入时间--->"+endSparse+
                "<---Sparse占用的内存--->"+sparseMemory);
    }

}
