package com.example.demo.mina.test1;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyClientHandler extends IoHandlerAdapter{

	private static Logger logger = LoggerFactory.getLogger(MinaServer.class);
	
	@Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        logger.error("客户端发生异常",cause);
    }
 
    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        logger.info("客户端接收到数据：" + message);
        System.out.println("客户端接收到数据：" +Thread.currentThread().getName()+ message);
    }
}
