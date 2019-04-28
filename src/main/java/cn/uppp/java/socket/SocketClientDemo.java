package cn.uppp.java.socket;

import java.io.*;
import java.net.Socket;

/**
 * Socket 客户端
 */
public class SocketClientDemo {
    public static void main(String[] args) throws IOException {
        // 创建Socket对象
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream os = socket.getOutputStream();
        InputStream is = socket.getInputStream();
        // 获取写入字符流
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os));
        // 发送消息，\n结尾代表一行结束
        bufferedWriter.write("Hello Java\n");
        bufferedWriter.flush();
        // 获取读取字符流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        // 接收消息
        System.out.println("服务端消息：" + bufferedReader.readLine());
        System.out.println("结束");
    }
}
