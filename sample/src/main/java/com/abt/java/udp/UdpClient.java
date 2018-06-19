package com.abt.java.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * @描述： @UdpClient
 * @作者： @黄卫旗
 * @创建时间： @23/05/2018
 */
public class UdpClient implements Runnable {

    private static DatagramSocket mDatagramSocket;
    private DatagramPacket mDatagramPacket;

    private String mSendStr = "Hey Server, I am Client!!";
    private String mNetAddress = "127.0.0.1";
    private final int mPort = 10000;
    private static volatile boolean mStop = false;

    public static void main(String[] args) {
        Thread thread = new Thread(new UdpClient());
        thread.start();
    }

    @Override
    public void run() {
        try {
            mDatagramSocket = new DatagramSocket();
            byte[] buf = mSendStr.getBytes();
            InetAddress address = InetAddress.getByName(mNetAddress);
            mDatagramPacket = new DatagramPacket(buf, buf.length, address, mPort);
            new Thread(new ReceiverRunnable()).start(); // 开启接收线程
            while (!mStop) {
                mDatagramSocket.send(mDatagramPacket); // 发送数据
                Thread.sleep(2*1000);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (mDatagramSocket != null) {
                mDatagramSocket.close(); // 关闭socket
            }
        }
    }

    private static class ReceiverRunnable implements Runnable {
        @Override
        public void run() {
            byte[] receiverBuf = new byte[1024];
            DatagramPacket receiverPacket = new DatagramPacket(receiverBuf, receiverBuf.length);
            while (!mStop) {
                try {
                    mDatagramSocket.receive(receiverPacket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String receiverStr = new String(receiverPacket.getData(), 0, receiverPacket.getLength());
                System.out.println("Client Receive Ack: " + receiverStr);
                System.out.println("Receive Packet Port: " + receiverPacket.getPort());
            }
        }
    }

}
