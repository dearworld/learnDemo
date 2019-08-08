package com.example.demo.java8.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

import lombok.Data;

public class StreamTest2 {
	
	public static void main(String[] args) {
		List<User> users = Lists.newArrayList();
		for (long i = 0; i < 4; i++) {
			User user = new User();
			user.setId(i);
			user.setUserNo("admin"+i);
			user.setUserName("管理员"+i);
			users.add(user);
		}
		
		System.out.println(users);
		Map<Long, User> map = users.stream().collect(Collectors.toMap(user->user.getId(), user->user));
		System.out.println(map);
	}

}


@Data
class User{
	private Long id;
	private String userNo;
	private String userName;
}