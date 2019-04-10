package cn.uppp.java.core.io.bio;

import java.io.IOException;
import java.net.Socket;

/**
 * 同步阻塞IO Client
 */
public class BIOClient {
    public static void main(String[] args) throws IOException {
        String host = "127.0.0.1";
        int port = 8888;
        Socket socket = new Socket(host, port);
        socket.getOutputStream().write("Hello Word!".getBytes());
    }
}
