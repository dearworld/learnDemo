package com.example.demo.upload;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class UploadTest {
	
	public static String sendFile(String urlStr,String fileName,String deviceId)  {
		
		try {
            // 换行符  
            final String newLine = "\r\n";  
            final String boundaryPrefix = "--";  
            // 定义数据分隔线  
            String BOUNDARY = "========7d4a6d158c9";  
            
			//打开和url之间的连接
			URL url = new URL(urlStr);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        // 设置为POST请求
	        conn.setRequestMethod("POST");
	        // 发送POST请求必须设置如下两行
	        conn.setDoOutput(true);
	        conn.setDoInput(true);
	        conn.setUseCaches(false);
	        // 设置请求头参数
	        conn.setRequestProperty("connection", "Keep-Alive");
	        conn.setRequestProperty("Charsert", "UTF-8");
	        conn.setRequestProperty("Content-Type", "multipart/form-data; boundary="+BOUNDARY);
	        conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.146 Safari/537.36");
	        conn.connect();
	        
	        OutputStream out = new DataOutputStream(conn.getOutputStream());

            // 上传文件  
            File file = new File(fileName);  
            StringBuilder sb = new StringBuilder();  
            sb.append(boundaryPrefix);  
            sb.append(BOUNDARY);  
            sb.append(newLine);  
            // 文件参数,photo参数名可以随意修改  
            sb.append("Content-Disposition: form-data;name=\"photo\";filename=\"" + fileName  
                    + "\"" + newLine);  
            sb.append("Content-Type:application/octet-stream");  
            // 参数头设置完以后需要两个换行，然后才是参数内容  
            sb.append(newLine);  
            sb.append(newLine);  
  
            // 将参数头的数据写入到输出流中  
            out.write(sb.toString().getBytes());

	        // 数据输入流,用于读取文件数据
	        DataInputStream in = new DataInputStream(new FileInputStream(file));
	        byte[] bufferOut = new byte[1024];
	        int bytes = 0;
	        // 每次读2KB数据,并且将文件数据写入到输出流中
	        while ((bytes = in.read(bufferOut)) != -1) {
	            out.write(bufferOut, 0, bytes);
	        }
	        // 最后添加换行
	        out.write(newLine.getBytes());
	        in.close();
	        // 定义最后数据分隔线，即--加上BOUNDARY再加上--。
	        byte[] end_data = (newLine + boundaryPrefix + BOUNDARY + boundaryPrefix + newLine).getBytes();
	        // 写上结尾标识
	        out.write(end_data);
	        out.flush();
	        out.close();

	        // 定义BufferedReader输入流来读取URL的响应
	        BufferedReader reader = new BufferedReader(new InputStreamReader(
	                conn.getInputStream(),"UTF-8"));
	        StringBuffer buffer = new StringBuffer();
	        String line = null;
	        while ((line = reader.readLine()) != null) {
	            buffer.append(line);
	        }
	        return buffer.toString();
	    } catch (Exception e) {
	        System.out.println("发送POST请求出现异常！" + e);
	        e.printStackTrace();
	    }
	    return "";
	}
	
	public static void main(String[] args) {
		String result = UploadTest.sendFile("http://localhost:8080/file/uploadFile", "C:\\project\\helmet\\pic\\864082010109034\\2350BDA622844072B93ADA5A327A46E8.jpg", "864082010109034");
		System.out.println(result);
	}
}
