package com.abt.java.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * @描述： @DoIO
 * @作者： @黄卫旗
 * @创建时间： @23/05/2018
 */
public class DoIO {

    private static final String path = "/Users/huangweiqi/StudioProjects/JavaBaseDemo";

    public static void main(String[] args) {
        System.out.println();
        write(path + "/file/path.txt", path);
        String readData = read(path + "/file/path.txt");
        System.out.println("readData=\n"+readData);
    }

    /**
     * 将数据写入文件.
     * @param fileName 文件名
     * @param data     要写的数据.
     */
    public static void write(String fileName, String data) {
        PrintWriter out = null;
        FileOutputStream fos = null;
        boolean append = true;
        try {
            fos = new FileOutputStream(fileName, append);
            out = new PrintWriter(new OutputStreamWriter(fos, "UTF-8"));
            out.print(data);
            out.println(data);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
            System.out.println("writeData=\n"+data);
            System.out.println();
        }
    }

    /**
     * 从文件fileName中读取数据
     * @param fileName 文件名
     * @return 读取的结果
     */
    public static String read(String fileName) {
        StringBuilder sb = new StringBuilder(4096);
        FileInputStream fis = null;
        BufferedReader in = null;
        try {
            fis = new FileInputStream(fileName);
            in = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
            String lineTmp = null;
            while ((lineTmp = in.readLine()) != null) {
                sb.append(lineTmp + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
}
