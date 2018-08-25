package com.abt.java.file;

import java.io.RandomAccessFile;

/**
 * @描述： @RandomAccessFile
 * @作者： @黄卫旗
 * @创时间： @25/08/2018
 */
public class DoRandomAccessFile {

    public static void main(String[] args) {
        String path = "/Users/huangweiqi/Downloads/test.txt";
        int seekPointer = 20;
        randomRed(path, seekPointer);//读取的方法
        //randomWrite(path);//追加写的方法
        //insert(path, 33, "\nlucene是一个优秀的全文检索库");
    }

    /**
     * 读的方法
     * @param path   文件路径
     * @param pointe 指针位置
     **/
    public static void randomRed(String path, int pointe) {
        try {
            //RandomAccessFile raf=new RandomAccessFile(new File("D:\\3\\test.txt"), "r");
            /**
             * model各个参数详解
             * r 代表以只读方式打开指定文件
             * rw 以读写方式打开指定文件
             * rws 读写方式打开，并对内容或元数据都同步写入底层存储设备
             * rwd 读写方式打开，对文件内容的更新同步更新至底层存储设备
             *
             * **/
            RandomAccessFile raf = new RandomAccessFile(path, "r");
            //获取RandomAccessFile对象文件指针的位置，初始位置是0
            System.out.println("RandomAccessFile文件指针的初始位置:" + raf.getFilePointer());
            raf.seek(pointe);//移动文件指针位置
            byte[] buff = new byte[1024];
            //用于保存实际读取的字节数
            int hasRead = 0;
            //循环读取
            while ((hasRead = raf.read(buff)) > 0) {
                //打印读取的内容,并将字节转为字符串输入
                System.out.println(new String(buff, 0, hasRead));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
