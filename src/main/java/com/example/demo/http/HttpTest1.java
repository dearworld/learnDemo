package com.example.demo.http;

import java.util.Map;

import com.google.common.collect.Maps;

import cn.hutool.http.HttpUtil;

public class HttpTest1 {
	public static void main(String[] args) {
		String nclientsUrl = "http://36.99.47.235:9055/nclients";
		String deviceId = "864082010105727";
		Map<String, Object> param = Maps.newHashMap();
		param.put("app", "live");
		param.put("name", deviceId);
		String json = HttpUtil.post(nclientsUrl, param, 2000);
		System.out.println(json);
	}
}
