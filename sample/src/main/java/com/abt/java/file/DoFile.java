package com.abt.java.file;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * @描述： @DoFile
 * @作者： @黄卫旗
 * @创建时间： @23/05/2018
 */
public class DoFile {

    private static final String path = "/Users/huangweiqi/StudioProjects/JavaBaseDemo";

    public static void main(String[] args) throws IOException {
        File f1 = new File(path + "/file/1.txt");
        File f2 = new File(path + "/file/", "2.txt");
        File f3 = new File(path + File.separator + "file/sub/"); // separator跨平台分隔符
        File f4 = new File(f3, "3.txt");

        System.out.println();
        createFile(f1);
        createFile(f2);
        createFile(f4);

        try {
            System.out.println();
            // listFile(new File(path + "/file"));
            showDir(new File(path + "/file"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();
        fileFilter(new File(path + "/file"));

        System.out.println();
        moveFile(new File(path + "/file"));
    }

    private static void createFile(File file) throws IOException {
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdir();
                System.out.println();
                System.out.println("makeDir: " + file.getParentFile());
                System.out.println();
            }
            file.createNewFile();
            System.out.println("createNewFile: " + file);
        }
    }

    private static void listFile(File path) throws Exception {
        File[] files = path.listFiles();
        for (File file : files) {
            System.out.println(file);
            if (file.length() > 0) {
                String[] filenames = file.list();
                if (filenames == null) {
                    continue;
                }
                for (String filename : filenames) {
                    System.out.println(filename);
                }
            }
        }
    }

    private static void fileFilter(File path) {
        String[] filenames = path.list(new FilenameFilter() {
            // file过滤目录name文件名
            public boolean accept(File file, String filename) {
                return filename.endsWith(".txt");
            }
        });
        if (filenames == null) {
            return;
        }
        for (String filename : filenames) {
            System.out.println(filename);
        }
    }

    public static void showDir(File dir) {
        System.out.println(dir);
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                showDir(file);
            } else {
                System.out.println(file);
            }
        }
    }

    public static void moveFile(File dir) {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                moveFile(file);
            } else {
                if (file.getName().endsWith(".txt")) {
                    String fileName = file.getName().substring(0, file.getName().lastIndexOf('.'));
                    File newFile = new File(path + "/file/pdf/" + fileName + ".pdf");
                    if (!newFile.getParentFile().exists()) {
                        newFile.getParentFile().mkdir();
                    }
                    file.renameTo(newFile);
                    System.out.println(newFile);
                }
            }
        }
    }

}
