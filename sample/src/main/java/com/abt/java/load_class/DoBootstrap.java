package com.abt.java.load_class;

import java.net.URL;

import sun.misc.Launcher;

/**
 * @描述： @DoBootstrap
 * @作者： @黄卫旗
 * @创建时间： @30/06/2018
 */
public class DoBootstrap {

    public static void main(String[] args) {
        URL[] urls = Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls) {
            System.out.println(url.toExternalForm());
        }
    }
}
