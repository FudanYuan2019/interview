package javalearning.nio;

import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @Author: Jeremy
 * @Date: 2019/7/10 13:13
 */
public class SocketTest {
    public SocketChannel socketChannel;

    public void open() throws Exception{
        socketChannel = SocketChannel.open();

    }

    public void connect() throws Exception{
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));
        SocketChannel socketChannel = serverSocketChannel.accept();
        // do something...
        socketChannel.close();
        serverSocketChannel.close();
    }

    public void close() throws Exception{
        socketChannel.close();
    }
}
