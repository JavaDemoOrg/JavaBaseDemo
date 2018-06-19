package com.abt.java.nio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @描述： @NIOClient
 * @作者： @黄卫旗
 * @创建时间： @24/05/2018
 */
public class NIOClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8888);
        OutputStream outStream = socket.getOutputStream();
        PrintWriter out = new PrintWriter(outStream, true);
        out.println("客户端请求PublicKey！！");
        out.flush(); // 输出
        socket.shutdownOutput();// 输出结束

        InputStream inStream = socket.getInputStream();
        Scanner in = new Scanner(inStream); // 输入
        StringBuilder sb = new StringBuilder();
        while (in.hasNextLine()) {
            String line = in.nextLine();
            sb.append(line);
        }
        String response = sb.toString();
        System.out.println("服务器response: " + response);
    }
}
