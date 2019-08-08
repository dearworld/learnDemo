package com.example.demo.hutool;

import cn.hutool.core.util.ArrayUtil;

public class HutoolTest1 {
	public static void main(String[] args) {
		String[] language = {"java","python","go"};
		boolean empty = ArrayUtil.isEmpty(language);
		System.out.println(empty);
	}
}
