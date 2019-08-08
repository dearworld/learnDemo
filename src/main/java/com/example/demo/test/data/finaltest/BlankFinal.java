package com.example.demo.test.data.finaltest;

public class BlankFinal {
	private final int i = 0;
	private final int j;
	private final Poppet p;
	public BlankFinal() {
		j = i;
		p = new Poppet(1);
	}

	public BlankFinal(int x) {
		j = x;
		p = new Poppet(x);
	}
	
}


class Poppet{
	private int i;

	public Poppet(int i) {
		this.i = i;
	}
	
}