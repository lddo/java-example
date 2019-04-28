package cn.uppp.java.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Socket 服务端
 */
public class SocketServerDemo {
    public static void main(String[] args) throws IOException {
        // 创建ServerSocket对象
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("启动服务器端......");
        // 开始监听
        Socket socket = serverSocket.accept();
        System.out.println("客户端" + socket.getInetAddress().getHostAddress() + "已连接服务器");
        // 获取输入流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // 接收消息
        System.out.println("客户端消息：" + bufferedReader.readLine());
        // 发送消息，\n结尾代表一行结束
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("Hello Python\n");
        bufferedWriter.flush();
        System.out.println("结束");
    }

}
