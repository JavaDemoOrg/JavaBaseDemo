package com.abt.android.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.abt.android.hash_map.DoHashMap;

/**
 * @描述： @MainActivity
 * @作者： @黄卫旗
 * @创建时间： @19/06/2018
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //DoSparseArray.testSparseArray();
        //DoSparseArray.testMemoryTime();
        DoHashMap.testHashMap();
    }
}
