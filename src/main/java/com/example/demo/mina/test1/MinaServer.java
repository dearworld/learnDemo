package com.example.demo.mina.test1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MinaServer {
	
	private static Logger logger = LoggerFactory.getLogger(MinaServer.class);
    // 绑定的端口
    private static final int MINA_PORT = 8081;
 
    public static void main(String[] args) {
        IoAcceptor acceptor;
        try {
            // 创建一个非阻塞的server端的Socket
            acceptor = new NioSocketAcceptor();
            // 设置编码过滤器（使用Mina提供的文本换行符编解码器）
            acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(
                    (ProtocolCodecFactory) new TextLineCodecFactory(
                            Charset.forName("UTF-8"),
                            LineDelimiter.WINDOWS.getValue(),
                            LineDelimiter.WINDOWS.getValue()
                    )
            ));
            // 添加自定义的过滤器
            // 设置读取数据的缓冲区大小
            acceptor.getSessionConfig().setReadBufferSize(1024);
            // 设置读写通道无操作进入空闲状态的时间 10ms
            acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
            // 绑定真正的逻辑处理
            acceptor.setHandler(new MyHandler());
            // 绑定端口
            acceptor.bind(new InetSocketAddress(MINA_PORT));
            System.out.println("Mina服务端启动成功，监听：" + MINA_PORT);
            logger.info("Mina服务端启动成功，监听：" + MINA_PORT);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务端启动出错-----" + e);
            logger.error("服务端启动出错-----" + e);
        }
    }
}
