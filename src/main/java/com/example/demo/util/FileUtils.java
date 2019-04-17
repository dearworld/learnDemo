package com.example.demo.util;

import java.util.UUID;

public class FileUtils {
	
	public static String renameToUUID(String fileName) {
		return FileUtils.renameToUUID(fileName, true);
	}
	
	public static String renameToUUID(String fileName,boolean isUpperCase) {
		String uuid = FileUtils.getUUID();
		String suffixName = FileUtils.getSuffixName(fileName);
		if(isUpperCase) {
			return uuid.toUpperCase()+ "." + suffixName;
		}
		return  uuid+ "." + suffixName;
	}
	
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-","");
	}
	
	public static String getSuffixName(String fileName) {
		return fileName.substring(fileName.lastIndexOf(".") + 1);
	}
	
	public static void main(String[] args) {
		System.out.println(FileUtils.getUUID());
		System.out.println(FileUtils.renameToUUID("1.doc",false));
	}
}
