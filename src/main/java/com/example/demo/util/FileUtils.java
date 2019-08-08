package com.example.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	
	public static void main(String[] args) throws Exception {
		String fileName = "864082010105727-2019-07-03-11_51_19.flv";
		int start = fileName.indexOf("-");
		int end = fileName.indexOf(".");
		String dateStr = fileName.substring(start+1, end);
		System.out.println(dateStr);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH_mm_ss");
		Date date = format.parse(dateStr);
		System.out.println(date);
		
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(format2.format(date));
		
		String outputPath = "D:/flvs_final".concat("/").concat("10086").concat("/").
				concat(UUID.randomUUID().toString().replace("-","").toUpperCase()).concat(".flv");
		System.out.println(outputPath);
	}
	
	public static Date getFileDate(String fileName) throws Exception {
		int start = fileName.indexOf("-");
		int end = fileName.indexOf(".");
		String dateStr = fileName.substring(start+1, end);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH_mm_ss");
		return format.parse(dateStr);
	}
	
	
}
