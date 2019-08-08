package com.example.demo.collection.thinking;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

public class Gerbil {
	private int gerbilNumber;

	public Gerbil(int gerbilNumber) {
		super();
		this.gerbilNumber = gerbilNumber;
	}
	
	public int getGerbilNumber() {
		return gerbilNumber;
	}


	public void setGerbilNumber(int gerbilNumber) {
		this.gerbilNumber = gerbilNumber;
	}


	public void hop(int gerbilNumber) {
		System.out.println("沙鼠"+gerbilNumber+"正在跳跃");
	}
	
	
	public static void main(String[] args) {
		List<Gerbil> list = Lists.newArrayList();
		for (int i = 0; i < 3; i++) {
			list.add(new Gerbil(i+1));
		}
		
		for (Gerbil gerbil : list) {
			gerbil.hop(gerbil.getGerbilNumber());
		}
	}
}
