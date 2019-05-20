package com.example.demo.mina.basic;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CilentTest {
	
	 public static void main(String[] args) throws InterruptedException {
		 while(true){
			 IoConnector connector = new NioSocketConnector();
			 connector.setConnectTimeoutMillis(30000);
			 connector.getFilterChain().addLast("codec",
					 new ProtocolCodecFilter(
					 new TextLineCodecFactory(
					 Charset.forName("UTF-8"),
					 LineDelimiter.WINDOWS.getValue(),
					 LineDelimiter.WINDOWS.getValue()
					 )
				 )
			 );
			 connector.setHandler(new ClientHandler("Hello world!!\r\n hajjsjdjwwwwwwwwwwwwww"));
			 //connector.connect(new InetSocketAddress("39.104.137.131", 9123));
			 connector.connect(new InetSocketAddress("localhost", 9123));
			 Thread.sleep(2000);
		 }
		 
	}
}
class ClientHandler extends IoHandlerAdapter {
	private final static Logger LOGGER = LoggerFactory.getLogger(ClientHandler.class);
	private final String values;
	public ClientHandler(String values) {
		this.values = values;
	}
	@Override
	public void sessionOpened(IoSession session) {
		session.write(values);
	}
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		 System.out.println(":"+message);
		 session.closeOnFlush();
	}
	
}