package com.lec.loop;

public class Ex03_for_star2 {
	public static void main(String[] args) {
		for (int i = 0; i <= 5; i++) { // 5���ݺ�
			for (int j = 1; j<= 5-i; j++) { // 1���ݺ�
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
