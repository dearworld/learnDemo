package com.example.demo.test;

import java.util.Arrays;
import java.util.List;

public class byteTest {

	private static final Object Byte = null;

	public static byte[] intToByteArray(int i) {
		byte[] result = new byte[4];
		result[0] = (byte) ((i >> 24) & 0xFF);
		result[1] = (byte) ((i >> 16) & 0xFF);
		result[2] = (byte) ((i >> 8) & 0xFF);
		result[3] = (byte) (i & 0xFF);
		return result;
	}

	public static int byteArrayToInt(byte[] bytes) {
		int value = 0;
		// 由高位到低位
		for (int i = 0; i < 4; i++) {
			int shift = (4 - 1 - i) * 8;
			value += (bytes[i] & 0x000000FF) << shift;// 往高位游
		}
		return value;
	}

	public static int bytes2Int(byte[] bytes) {
		// 如果不与0xff进行按位与操作，转换结果将出错，有兴趣的同学可以试一下。
		int int1 = bytes[0] & 0xff;
		int int2 = (bytes[1] & 0xff) << 8;
		int int3 = (bytes[2] & 0xff) << 16;
		int int4 = (bytes[3] & 0xff) << 24;
		return int1 | int2 | int3 | int4;
	}
	
	public static int byteArrayToInt2(byte[] data) {
		int mLength = (data[0] & 0xff) | ((data[1] & 0xff) << 8) 
				| ((data[2] & 0xff) << 16) | ((data[3] & 0xff) << 24);
		return mLength;
	}

	public static void main(String[] args) {
		Integer count = 2019;
		byte[] bytes = byteTest.intToByteArray(count);
		
	}
}
