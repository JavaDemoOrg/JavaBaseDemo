package com.abt.android.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @描述： @TimeUtil
 * @作者： @黄卫旗
 * @创建时间： @19/06/2018
 */
public class TimeUtil {

    public static final String TO_MILLI_SECOND = "yyyy-MM-dd HH:mm:ss:SSS";

    public static String getFormatStr(long time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(TO_MILLI_SECOND);
        return dateFormat.format(time);
    }

    public static long getTime(String formatStr) {
        long time=0;
        SimpleDateFormat dateFormat = new SimpleDateFormat(TO_MILLI_SECOND);
        try {
            time = dateFormat.parse(formatStr).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

}
