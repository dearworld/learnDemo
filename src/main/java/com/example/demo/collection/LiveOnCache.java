package com.example.demo.collection;

import java.util.List;
import java.util.Map;

import com.example.demo.util.ListUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class LiveOnCache {
	/**
	 * 设备编号为key 开启该设备的用户集合为value
	 */
	private static Map<String, List<String>> map = Maps.newHashMap();

	public static Map<String, List<String>> getMap() {
		return map;
	}

	public static void setMap(Map<String, List<String>> map) {
		LiveOnCache.map = map;
	}

	public static boolean containDevice(String deviceId) {
		return map.containsKey(deviceId);
	}

	public static boolean containUser(String deviceId) {
		if (LiveOnCache.containDevice(deviceId)) {
			List<String> users = map.get(deviceId);
			if (ListUtils.hasLength(users)) {
				return true;
			}
		}
		return false;
	}

	public static boolean cotainUserNo(String deviceId, String userNo) {
		if (LiveOnCache.containUser(deviceId) && map.get(deviceId).contains(userNo)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 开启直播时将当前用户添加到缓存
	 * @param deviceId
	 * @param userNo
	 */
	public static void addUser(String deviceId, String userNo) {
		if(LiveOnCache.containUser(deviceId)) {
			List<String> users = map.get(deviceId);
			if(!users.contains(userNo)) {
				users.add(userNo);
			}
		}else {
			List<String> newUsers = Lists.newArrayList();
			newUsers.add(userNo);
			map.put(deviceId, newUsers);
		}
	}
	
	/**
	 * 关闭直播时判断用户表中是否还有其他用户
	 * @param deviceId
	 * @param userNo
	 * @return
	 */
	public static boolean isClose(String deviceId,String userNo) {
		 if(LiveOnCache.containDevice(deviceId)) {
			 List<String> users = map.get(deviceId);
			 users.remove(userNo);
			 if(ListUtils.hasLength(users)) {
				 return false;
			 }
		 }
		 return true;
	}
	
	/**
	 * 删除用户信息
	 * @param deviceId
	 * @param userNo
	 */
	public static void delUserNo(String deviceId,String userNo) {
		if(LiveOnCache.containDevice(deviceId)) {
			List<String> users = map.get(deviceId);
			users.remove(userNo);
		}
	}
}
