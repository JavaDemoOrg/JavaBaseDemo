package com.abt.android.sparse_array;

import android.util.SparseArray;

/**
 * @描述： @TestSparseArray
 * @作者： @黄卫旗
 * @创建时间： @16/06/2018
 */
public class TestSparseArray {

    public static void main(String[] args) {
        SparseArray<String> sparse = new SparseArray<>();
        long start_sparse = System.currentTimeMillis();
        for(int i=0;i<Integer.MAX_VALUE;i++){
            sparse.put(i, String.valueOf(i));
        }
        long sparse_memory = Runtime.getRuntime().totalMemory();
        long end_sparse = System.currentTimeMillis()-start_sparse;
        System.out.println("<---Sparse的插入时间--->"+end_sparse+"<---Sparse占用的内存--->"+sparse_memory);
    }


}
