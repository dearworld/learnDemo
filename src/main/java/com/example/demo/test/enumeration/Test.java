package com.example.demo.test.enumeration;

public class Test {
	public static void main(String[] args) {
		
		for (Week week : Week.values()) {
			System.out.println(week.toString());
		}
		
		System.out.println("----------分割线----------");
		
		
		Week mon = Week.SUN;
		switch (mon) {
		case MON:
			System.out.println("今天是星期一");
			break;
		case TUE:
			System.out.println("今天是星期二");
			break;
		case WED:
			System.out.println("今天是星期三");
			break;
		case THU:
			System.out.println("今天是星期四");
			break;
		case FRI:
			System.out.println("今天是星期五");
			break;
		case SAT:
			System.out.println("今天是星期六");
			break;
		default:
			System.out.println("今天是星期日");
			break;
		}
	}
}

enum Week {
	MON, TUE, WED, THU, FRI, SAT, SUN;
}
