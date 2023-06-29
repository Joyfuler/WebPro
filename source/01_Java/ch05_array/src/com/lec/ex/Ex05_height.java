package com.lec.ex;

import java.util.Scanner;

public class Ex05_height {
	public static void main(String[] args) {
		// 다섯명의 친구 키를 입력한 후 그 평균을 구할 것.
		// 가장 큰친구와 가장 작은 친구를 출력. 가장 큰 친구 ~의 키는 ~cm...
		String[] member = {"영희", "철수", "길동", "몽룡", "춘향"};
		int[] height = new int[member.length]; // 우선 키 배열을 만듬.
		int totalheight = 0; // 임시변수 만듬. 키 합산용
		Scanner scanner = new Scanner(System.in); //키 입력받기 
		for(int i=0; i <=4; i++) {  // 5번 반복하기 위해
			System.out.println(member[i] + "은(는) 키를 입력해주세요.");
			height[i] = scanner.nextInt();
		
		totalheight += height[i];
		
		
		
	}
		System.out.println("키의 총합계는 " + totalheight + "입니다.");
		System.out.println("다섯 명의 평균 키는" + (totalheight / (double)(height.length) + "입니다."));
		
		scanner.close();
	}
}
