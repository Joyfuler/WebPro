package com.lec.loop;

public class Ex03_for_star2 {
	public static void main(String[] args) {
		for (int i = 5; i >= 1; i--) { // 5���ݺ�
			for (int j = 1; j <= i; j++) { // 1���ݺ�
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
