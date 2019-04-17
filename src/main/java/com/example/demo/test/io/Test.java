package com.example.demo.test.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.stream.FileImageOutputStream;

import org.springframework.beans.factory.annotation.Value;

public class Test {
	
	public static void main(String[] args) {
		try {
			//method();
			//method2();
			//method3();
			//method4();
			
			method5();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("复制成功");
	}
	
	/**
	 * 缓冲流使用特有的读取方法
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static void method5() throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("c://a.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("d://b.txt"));
		
		String line;
		while((line=br.readLine())!=null) {
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		
		bw.close();
		br.close();
	}

	/**
	 * 缓冲流读取字符数组
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static void method4() throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("c://a.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("d://b.txt"));
		
		int len;
		char[] chs = new char[1024];
		while((len = br.read(chs))!=-1) {
			bw.write(chs, 0, len);
		}
		bw.close();
		br.close();
	}

	/**
	 * 缓冲流读取单个字符
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static void method3() throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("c://a.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("d://b.txt"));
		
		int len;
		while((len = br.read())!=-1) {
			bw.write(len);
		}
		bw.close();
		br.close();
	}

	/**
	 * 标准流读取字符数组
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static void method2() throws FileNotFoundException, IOException {
		FileReader fr = new FileReader("c://a.txt");
		FileWriter fw = new FileWriter("d://b.txt");
		
		int len;
		char[] chs = new char[1024];
		while((len = fr.read(chs))!=-1) {
			fw.write(len);
		}
		
		fw.close();
		fr.close();
	}

	/**
	 * 标准流单字符读取
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static void method() throws FileNotFoundException, IOException {
		FileReader fr = new FileReader("c://a.txt");
		FileWriter fw = new FileWriter("d://b.txt");
		
		int len;
		while((len = fr.read())!=-1) {
			fw.write(len);
		}
		
		fw.close();
		fr.close();
	}
}
