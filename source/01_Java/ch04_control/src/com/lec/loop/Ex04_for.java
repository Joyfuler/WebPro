package com.lec.loop;
// 15~ 50까지
// 15 16 17 18 19
// 20 21 22 23 24 일때, 19나 24일때 개행하도록 (5로 나눠서 나머지가 4인경우 개행)
public class Ex04_for {
	public static void main(String[] args) {
		for (int i = 15; i < 50; i++) {
			System.out.print(i + "\t");
			if (i % 5 == 4) {
				System.out.println(); // 나머지 4일떄는 개행만 한다는 의미
		} // if
		
		} // fori
	} // main
		
	
} //class
