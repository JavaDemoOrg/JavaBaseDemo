package com.abt.java.udp;

import java.io.Closeable;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @描述： @UdpServer
 * @作者： @黄卫旗
 * @创建时间： @20/05/2018
 */
public class UdpServer implements Runnable {

    private volatile boolean mStop = false;
    private static final int LOCAL_UDP_PORT = 10000;    /** Udp端口号 */
    private static final int UDP_CACHE_SIZE = 1024;    /** Udp缓存大小 */

    public static void main(String[] args) {
        System.out.println();
        Thread thread = new Thread(new UdpServer());
        thread.start();
    }

    @Override
    public void run() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(LOCAL_UDP_PORT);
            final byte[] data = new byte[UDP_CACHE_SIZE];
            DatagramPacket packet = new DatagramPacket(data, data.length);
            while (!mStop) {
                System.out.println("等待UdpClient发送数据...");
                socket.receive(packet);
                responseClient(socket, packet);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeIO(socket);
        }
    }

    /** 与客户端进行交互 */
    private final void responseClient(DatagramSocket socket, DatagramPacket packet) {
        if (null != packet && null != packet.getData()) {
            final byte[] len = new byte[packet.getLength()];
            System.arraycopy(packet.getData(), 0, len, 0, packet.getLength());
            final String receiveStr = new String(len);
            System.out.println("接收UdpClient发送过来的数据为 ---> " + receiveStr);
            try {
                final byte[] receiveBytes = receiveStr.getBytes();
                DatagramPacket pack = new DatagramPacket(receiveBytes,
                        receiveBytes.length, packet.getAddress(), packet.getPort());
                socket.send(pack);
                System.out.println("发送给UdpClient<" + packet.getAddress() + "> ---> " + new String(receiveBytes));
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("发送给UdpClient<" + packet.getAddress() + "> ---> 失败");
            }
        }
    }

    /**
     * 关闭IO
     * @param closeables closeables
     */
    public static final void closeIO(final Closeable... closeables) {
        if (closeables == null) return;
        for (Closeable closeable : closeables) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
