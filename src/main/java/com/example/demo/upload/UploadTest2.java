package com.example.demo.upload;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class UploadTest2 {
	
	public static String sendFile(String urlStr,String fileName,String deviceId) {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		String result = null;
		try {
			httpClient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(urlStr);
			
			// 把文件转换成流对象FileBody
			FileBody bin = new FileBody(new File(fileName));
			StringBody devId = new StringBody(deviceId, ContentType.create("text/plain", Consts.UTF_8));
			
			HttpEntity httpEntity = MultipartEntityBuilder.create()
				.addPart("file", bin)
				.addPart("deviceId", devId)
				.build();
			
			httpPost.setEntity(httpEntity);
			
			// 发起请求 并返回请求的响应
			response = httpClient.execute(httpPost);
			// 获取响应对象
			HttpEntity resEntity = response.getEntity();
			if (resEntity != null) {
				 // 打印响应长度
				 System.out.println("Response content length: " + resEntity.getContentLength());
				 //获得响应结果
				 result = EntityUtils.toString(resEntity, Charset.forName("UTF-8"));
			}
			// 销毁
			EntityUtils.consume(resEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		String result = UploadTest2.sendFile("http://localhost:8080/file/uploadFile", "C:\\project\\helmet\\pic\\864082010109034\\2350BDA622844072B93ADA5A327A46E8.jpg", "864082010109034");
		System.out.println("1111111");
		System.out.println(result);
		
	}
}
