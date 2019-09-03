package com.example.demo.test.genericity;

import java.util.Map;

import com.google.common.collect.Maps;


//泛型类
public class Test1 {
	public static void main(String[] args) {
		VariableType<Map<String, Object>> type = new VariableType<Map<String,Object>>();
		Map<String, Object> map = Maps.newHashMap();
		map.put("name", "赵丽颖");
		map.put("age", 18);
		type.setVar(map);
		Map<String, Object> map2 = type.getVar();
		System.out.println(map2);
	}
}

class VariableType<T>{
	private T var;

	public T getVar() {
		return var;
	}

	public void setVar(T var) {
		this.var = var;
	}
}
