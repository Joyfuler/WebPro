package com.lec.quiz;

public class ProgramingLan2 {
	public static void main(String[] args) {
		int[] arr = { 76, 45, 34, 89, 100, 50, 90, 93 };
		int total = 0;
		// 합계, 평균, 최대, 최소
		for (int i = 0; i < arr.length; i++) {
			total += arr[i];
		}
		System.out.println("배열의 모든 수의 합은 " + total + "이고, ");
		System.out.printf("평균은 %.2f 이며, ", ((double) total / arr.length));
		int temp = 0;
		int temp2 = 200;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > temp) {
				temp = arr[i];
			}

		}
		System.out.println("최대값은 " + temp + "입니다.");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < temp2) {
				temp2 = arr[i];
			}
		}
		System.out.println("최소값은 " + temp2 + "입니다.");
	}
}
