package com.example.demo.test.data;

import com.google.gson.Gson;

public class GsonTest {


	public static void main(String[] args) {
		
		String json = "{'fileType':12,'OnlineVo':{'deviceId':'864082010105727','state':'on','timestamp':1559613303705}}";
		
		Data2 data2 = new Gson().fromJson(json, Data2.class);
		System.out.println(data2);
		System.out.println(data2.getOnlineVo().getDeviceId());
	}
}
