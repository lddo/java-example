package cn.uppp.java.io.bio;


import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;

/**
 * 同步阻塞IO（Blocking IO）
 */
public class BIODemo {
    public static void main(String[] args) throws IOException {
        // 定义端口
        int port = 8888;
        ServerSocket serverSocket = new ServerSocket(port);
        InputStream is = serverSocket.accept().getInputStream();
        System.out.println("服务端已启动！");
        byte[] byteArray = new byte[1024];
        int len = 0;
        while ((len = is.read(byteArray)) > 0) {
            System.out.println(new String(byteArray, 0, len));
        }
        System.out.println("已结束！");
    }
}
