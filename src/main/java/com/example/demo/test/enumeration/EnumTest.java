package com.example.demo.test.enumeration;

public enum EnumTest {
	MON(1), TUE(2), WED(3), THU(4), FRI(5), SAT(6), SUN(7);
	
	private int value;

	private EnumTest(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
