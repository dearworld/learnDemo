package com.example.demo.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListUtils {
	
	public static <T> List<T> removeSame(List<T> list){
		List<T> result = new ArrayList<T>();
		for (T t : list) {
			if(!result.contains(t)) {
				result.add(t);
			}
		}
		return result;
	}
}
