package com.example.demo.bio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import org.junit.Test;


public class BIOTest {
	
	/**
	 * 向本地文件中写数据
	 * @throws Exception 
	 */
	@Test
	public void test1() throws Exception {
		//1. 创建文件
		//2. 创建输出流
		//3. 使用输出流向文件中写入数据
		//4. 关闭资源
		
		File file = new File("bio.txt");
		OutputStream os = new BufferedOutputStream(new FileOutputStream(file));
		String msg = "Hello bio!!!!";
		os.write(msg.getBytes());
		os.close();
	}
	
	/**
	 * 读取文件内容打印在控制台上
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception{
		//1. 创建文件
		//2. 创建输入流
		//3. 使用输入流读取文件中的数据
		//4. 处理输出数据
		//5. 关闭资源
		InputStream is =  new BufferedInputStream(new FileInputStream(new File("bio.txt")));
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] bys = new byte[1024];
		System.out.println("1111111");
		System.out.println(is.available());
		System.out.println("2222222");
		int len;
		while ((len = is.read(bys))!= -1) {
			bos.write(bys, 0, len);
		}
		byte[] data = bos.toByteArray();
		String msg = new String(data);
		System.out.println(msg);
		bos.close();
		is.close();
	}
	
	/**
	 * 复制文件
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception{
		long time1 = System.nanoTime();
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("bio.txt"));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("bioCopy.txt"));
		
/*		byte[] bys = new byte[1024];
		int len;
		while((len = bis.read(bys))!= -1) {
			bos.write(bys, 0, len);
		}*/
		int len = bis.available();
		byte[] bys = new byte[len];
		bis.read(bys);
		bos.write(bys);
		
		bos.close();
		bis.close();
		long time2 = System.nanoTime();
		System.out.println("time1:"+time1);
		System.out.println("time2:"+time2);
		System.out.println("复制该文件需要的时间为:"+ (time2 - time1));
	}
	
	@Test
	public void test4() throws Exception{
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("bio.txt"));
		int len = bis.available();
		byte[] bys = new byte[len];
		bis.read(bys);
		System.out.println(new String(bys));
		bis.close();
	}
}
