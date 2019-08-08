package com.example.demo.util;

import java.io.File;
import java.util.List;

public class FFMpegCmdExec {
	
	public static boolean processImg(String videoPath, String ffmpegPath, String startTime, String endTime,
			String outputPath) {
		File file = new File(videoPath);
		if (!file.exists()) {
			System.err.println("路径[" + videoPath + "]对应的视频文件不存在!");
			return false;
		}
		List<String> commands = new java.util.ArrayList<String>();
		commands.add(ffmpegPath);
		commands.add("-i");
		commands.add(videoPath);
		commands.add("-vcodec");
		commands.add("copy");
		commands.add("-acodec");
		commands.add("copy");
		commands.add("-ss");// 这个参数是设置截取视频多少秒时的画面
		commands.add(startTime);
		commands.add("-to");
		commands.add(endTime);
		commands.add(outputPath);
		commands.add("-y");
		try {
			ProcessBuilder builder = new ProcessBuilder();
			builder.command(commands);
			builder.start();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public static void main(String[] args) {
		String videoPath = "D:\\temp\\864082010105727-2019-07-03-11_51_19.flv";
		String ffmpegPath = "C:\\software\\ffmpeg.exe";
		String startTime = "0";
		String endTime = "19";
		String outputPath = "D:\\temp\\test1.flv";
		FFMpegCmdExec.processImg(videoPath, ffmpegPath, startTime, endTime, outputPath);
	}
}