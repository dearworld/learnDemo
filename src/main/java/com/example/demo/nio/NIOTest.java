package com.example.demo.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;

public class NIOTest {
	
	/**
	 * 向文件中写入数据
	 */
	@Test
	public void test1() throws Exception{
		// 1. 创建输出流
		// 2. 从流中获取通道
		// 3. 创建缓冲区
		// 4. 向缓冲区写入数据
		// 5. 反转缓冲区
		// 6. 缓冲区写入通道
		// 7. 关闭资源
		FileOutputStream bos = new FileOutputStream("nio.txt");
		FileChannel channel = bos.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		String msg = "Hello BIO!!!!";
		buffer.put(msg.getBytes());
		buffer.flip();
		
		byte[] data = buffer.array();
		System.out.println(data.length);
		System.out.println(new String(data));
		channel.write(buffer);
		bos.close();
	}
	
	/**
	 * 从文件中读取数据
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception{
		File file = new File("nio.txt");
		System.out.println(file.length());
		FileInputStream fis = new FileInputStream(file);
		FileChannel channel = fis.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate((int)channel.size());
		channel.read(buffer);
		System.out.println(new String(buffer.array()));
		fis.close();
	}
	
	/**
	 * nio复制文件
	 * @throws Exception
	 */
	@Test
	public void nioCopy() throws Exception{
		FileInputStream fis = new FileInputStream("bio.txt");
		FileOutputStream fos = new FileOutputStream("nioCopy.txt");
		FileChannel srcChannel = fis.getChannel();
		FileChannel destChannel = fos.getChannel();
		//srcChannel.transferTo(0, srcChannel.size(), destChannel);
		destChannel.transferFrom(srcChannel, 0, srcChannel.size());
		fos.close();
		fis.close();
	}
	
	@Test
	public void nioCopy2() throws Exception{
		FileInputStream fis = new FileInputStream("bio.txt");
		FileOutputStream fos = new FileOutputStream("nioCopy.txt");
		FileChannel srcChannel = fis.getChannel();
		FileChannel destChannel = fos.getChannel();
		
		MappedByteBuffer mbb = srcChannel.map(FileChannel.MapMode.READ_ONLY, 0, srcChannel.size());
		destChannel.write(mbb);
		fos.close();
		fis.close();
	}
}
