package com.example.demo.test.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ClientDemo {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		//创建socket
		//创建输出流
		//写入数据
		//释放资源
		
		Socket socket = new Socket("DESKTOP-RBQRFKC", 8085);
		OutputStream os = socket.getOutputStream();
		String str = "本节探讨如何通过FileInputStream读取本地文件。本地文件是指存储在本地磁盘中的文件，我们存储到电脑中的图片、视频、音乐、文档资料都属于本地文件。\r\n" + 
				"\r\n" + 
				"这些本地文件都可以用相对应的程序打开。图片可以用Windows自带的照片查看器或画图程序打开查看；音乐和视频可以用Windows自带的Media Player或暴风影音等播放器打开；文档资料可以用办公软件Word等程序打开编辑。这些程序在开发过程中，都需要使用编程语言提供的文件读写技术。\r\n" + 
				"\r\n" + 
				"在介绍文件读写技术之前，有必要先了解一下二进制文件和文本文件。其实二进制文件和文本文件在物理存储上并没有什么区别，存储在硬盘上的文件都是以二进制方式存储的。二者的区别在于解释数据的逻辑不同。程序读取文本文件时，可以以字符方式读取，也可以以字节方式读取，将读取的数据解释为ASCII或unicode编码，也就是解释为字符，读取的字符可以直接输出到屏幕上显示出来；当程序读取二进制文件时，是以字节方式读取的，对读取数据的解释由读取程序决定。如读取图片文件时，读取图片的程序需要了解该文件的结构，并解释读取的数据，如果不了解该图片文件的结构，读取图片文件就会失败，也就无法把图片显示出来了。\r\n" + 
				"\r\n" + 
				"从前面的讨论可知，Java提供的FileInputStream类适合于读取二进制文件，而不太适合读取文本文件。当然也可以读取文本文件，不过需要做相应地读取处理，否则遇到中文就会出现乱码378";
		os.write(str.getBytes());
		os.close();
		socket.close();
	}
}
