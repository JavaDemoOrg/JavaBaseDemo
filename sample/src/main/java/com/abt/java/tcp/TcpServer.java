package com.abt.java.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @描述： @TcpServer
 * @作者： @黄卫旗
 * @创建时间： @24/05/2018
 */
public class TcpServer {

    public static final int mPort = 8888;

    public static void main(String args[]) {
        TcpServer server = new TcpServer();
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(mPort);
        InetAddress address = InetAddress.getByName(null);
        System.out.println("start@" + address + ":" + mPort);
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                try {
                    new ServerOne(socket);
                } catch (IOException e) {
                    socket.close();
                }
            }
        } finally {
            serverSocket.close();
            System.out.println("end@" + address + ":" + mPort);
        }
    }

    class ServerOne extends Thread {

        private Socket socket;
        private BufferedReader bufferedReader;
        private BufferedWriter bufferedWriter;
        private PrintWriter writer;

        public ServerOne(Socket sock) throws IOException {
            this.socket = sock;
            bufferedReader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
            writer = new PrintWriter(bufferedWriter, true);
            start();
        }

        public void run() {
            try {
                while (true) {
                    String str = bufferedReader.readLine();
                    if (str.equals("end")) break;
                    System.out.println("Server receive information: " + str);
                    writer.println("Echo " + str);
                }
                System.out.println("closing...");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}