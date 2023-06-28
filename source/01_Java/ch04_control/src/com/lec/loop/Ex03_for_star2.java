package com.lec.loop;

public class Ex03_for_star2 {
	public static void main(String[] args) {
		for (int i = 5; i >= 1; i--) { // 5번반복
			for (int j = 1; j <= i; j++) { // 1번반복
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
