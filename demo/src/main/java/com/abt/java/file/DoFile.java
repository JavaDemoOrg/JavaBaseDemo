package com.abt.java.file;

import java.io.File;
import java.io.IOException;

/**
 * @描述： @DoFile
 * @作者： @黄卫旗
 * @创建时间： @23/05/2018
 */
public class DoFile {

    private static final String demo = "/Users/huangweiqi/StudioProjects/JavaBaseDemo";

    public static void main(String[] args) throws IOException {
        File f1 = new File(demo+"/file/1.txt");
        File f2 = new File(demo+"/file/", "2.txt");
        File f3 = new File(demo+File.separator+"file/sub/"); // separator跨平台分隔符
        File f4 = new File(f3, "3.txt");

        createFile(f1);
        createFile(f2);
        createFile(f4);
    }

    private static void createFile(File file) throws IOException {
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdir();
                System.out.println();
                System.out.println("makeDir: "+file.getParentFile());
                System.out.println();
            }
            file.createNewFile();
            System.out.println("createNewFile: "+file);
        }
    }
}
