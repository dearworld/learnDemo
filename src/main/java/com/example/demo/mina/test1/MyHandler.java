package com.example.demo.mina.test1;

import java.util.Date;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyHandler extends IoHandlerAdapter{
	
	private static Logger logger = LoggerFactory.getLogger(MinaServer.class);
	@Override
    public void sessionCreated(IoSession session) throws Exception {
        logger.info("服务端与客户端连接成功");
    }
 
    @Override
    public void sessionOpened(IoSession session) throws Exception {
        logger.info("服务端与客户端连接打开");
    }
 
    @Override
    public void sessionClosed(IoSession session) throws Exception {
        logger.info("服务端与客户端连接关闭");
    }
 
    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        logger.info("服务端进入空闲状态");
    }
 
    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        logger.error("服务端发生异常", cause);
    }
 
    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        logger.info("服务端接受到消息：" + message);
        System.out.println("服务端接受到消息：" + message);
        // 如果接受到exit，则退出程序
        if (message.equals("exit")) {
            session.closeNow();
        }
        Date date = new Date();
        session.write(date);
    }
 
    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        logger.info("服务端发送消息成功");
    }
 
    @Override
    public void inputClosed(IoSession session) throws Exception {
        logger.info("输入关闭");
    }

}
