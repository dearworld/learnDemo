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
	
	public static <T> boolean hasLength(List<T> list) {
		if(list!=null && list.size()>0) {
			return true;
		}
		return false;
	}
	
	public static <T> List<T> getSame(List<T> list1,List<T> list2){
		List<T> result = new ArrayList<T>();
		for (T t : list1) {
			if(list2.contains(t)) {
				result.add(t);
			}
		}
		return result;
	}
}
