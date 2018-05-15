package com.abt.java.reference;

import java.awt.Point;
import java.lang.ref.WeakReference;

/**
 * @描述： @DoWeakReference
 * @作者： @黄卫旗
 * @创建时间： @15/05/2018
 */
public class DoWeakReference {

    public static void main(String[] args) {
        Point point = new Point(100,200); // 弱引用
        WeakReference<Point> reference = new WeakReference<Point>(point);
        while (true) {
            if (reference.get() == null) {
                System.out.println("对象被回收");
                break;
            } else {
                System.out.println("对象没有被回收");
                try {
                    Double x = reference.get().getX();
                    Double y = reference.get().getY();
                    System.out.println("{"+x+", "+y+"}");
                } catch (Exception e) {
                    System.out.println("-->");
                    System.out.println("对象被回收");
                    break;
                }
            }
        }
    }

}


