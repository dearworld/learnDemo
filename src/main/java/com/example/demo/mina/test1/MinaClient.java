package com.example.demo.mina.test1;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

public class MinaClient {
	 
    // 定义IP地址
    private static final String MINA_HOST = "127.0.0.1";
    // 定义端口
    private static final int MINA_PORT = 8081;
 
    public static void main(String[] args) {
        IoSession ioSession;
        // 创建一个非阻塞的客户端
        IoConnector ioConnector = new NioSocketConnector();
        // 设置超时时间
        ioConnector.setConnectTimeoutMillis(30000);
        // 设置编码解码器
        ioConnector.getFilterChain().addLast("codec", new ProtocolCodecFilter(
                (ProtocolCodecFactory) new TextLineCodecFactory(
                        Charset.forName("UTF-8"),
                        LineDelimiter.WINDOWS.getValue(),
                        LineDelimiter.WINDOWS.getValue()
                )
        ));

        // 绑定逻辑处理类
        ioConnector.setHandler(new MyClientHandler());
        // 创建连接
        ConnectFuture future = ioConnector.connect(new InetSocketAddress(MINA_HOST, MINA_PORT));
        // 等待连接创建完成
        future.awaitUninterruptibly();
        // 获取连接session
        ioSession = future.getSession();
        // 发送数据
        ioSession.write(Thread.currentThread().getName()+"你好啊，Mina");
        // 等待关闭连接
        ioSession.getCloseFuture().awaitUninterruptibly();
        ioConnector.dispose();
    }
}
