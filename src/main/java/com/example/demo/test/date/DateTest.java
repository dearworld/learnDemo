package com.example.demo.test.date;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DateTest {

	public static String getPastDate(int past) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
		Date date = calendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String result = format.format(date);
		return result;
	}
	
	public static void main(String[] args) {
		List<Map<String,Object>> list = new ArrayList<>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("time", new Date());
		map1.put("name", "test1");
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("time", new Date((new Date().getTime()-1000*60)));
		map2.put("name", "test2");
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("time", new Date((new Date().getTime()-1000*60*2)));
		map3.put("name", "test3");
		list.add(map1);
		list.add(map2);
		list.add(map3);
		System.out.println(list);
		Collections.sort(list, new Comparator<Map<String,Object>>() {

			@Override
			public int compare(Map<String, Object> o1, Map<String, Object> o2) {
				 Date date1 = (Date) o1.get("time");
				 Date date2 = (Date) o2.get("time");
				return date1.compareTo(date2);
			}
		});
		System.out.println(list);
	}
}
