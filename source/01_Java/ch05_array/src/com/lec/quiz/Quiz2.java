package com.lec.quiz;

public class Quiz2 {
	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50 };
		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			temp += arr[i];
		}
		

		System.out.println("모든 배열의 수의 합은 " + "" + temp + "입니다.");
	}
}