package com.abt.java.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @描述： @TcpClient
 * @作者： @黄卫旗
 * @创建时间： @24/05/2018
 */
public class TcpClient extends Thread {

    private static final int MAX_THREADS = 5;
    private static int mId = 0;
    private static int mThreadCount = 0;
    private Socket mSocket;
    private BufferedReader mBufReader;
    private BufferedWriter mBufWriter;
    private PrintWriter mWriter;

    public static void main(String args[]) throws IOException, InterruptedException {
        InetAddress inetAddress = InetAddress.getByName(null); // null mean localhost
        while (true) {
            if (getThreadCount() < MAX_THREADS) {
                new TcpClient(inetAddress);
            } else {
                break;
            }
            Thread.currentThread().sleep(1000);
        }
    }

    public static int getThreadCount() {
        return mThreadCount;
    }

    public TcpClient(InetAddress netAddress) {
        mThreadCount++;
        mId++;
        System.out.println("Making client: " + mId);
        try {
            mSocket = new Socket(netAddress, TcpServer.mPort);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mBufReader = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));
            mBufWriter = new BufferedWriter(new OutputStreamWriter(mSocket.getOutputStream()));
            mWriter = new PrintWriter(mBufWriter, true);
            start();
        } catch (IOException e1) {
            try {
                mSocket.close();
            } catch (IOException e2) {
                System.out.println("Error BufReader Client\n");
            }
        }
    }

    public void run() {
        try {
            String str;
            for (int i = 0; i < 5; i++) {
                mWriter.println("Client #" + mId + ":" + i);
                str = mBufReader.readLine();
                System.out.println("Client send message: " + mId + ":" + i + "\n" + "Server reply: " + str);
            }
            mWriter.println("end");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                mSocket.close();
            } catch (IOException e) {
            }
        }
    }

}

