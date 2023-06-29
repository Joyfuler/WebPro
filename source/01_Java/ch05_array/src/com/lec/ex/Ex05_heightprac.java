package com.lec.ex;

import java.util.Scanner;

public class Ex05_heightprac {
	public static void main(String[] args) {
		String[] name = {"가","나","다","라","마"};
		int[] height = new int[5];
		int totalheight = 0; //키 누적용
		Scanner scanner = new Scanner(System.in);
		for(int idx =0; idx <5; idx++) {
			System.out.println(name[idx] +"의 키를 입력해주세요.");
			height[idx] = scanner.nextInt();
			totalheight += height[idx];
			
		}
		for (int idx = 0; idx <5; idx++) {
			System.out.println(name[idx] + "의 키는 " + height[idx] + "입니다.");
			
		}
		
		System.out.println("다섯 명의 키의 합은 " + totalheight + "입니다.");
		System.out.println("다섯 명의 키의 평균은 " + (totalheight) / (double)(name.length) + "입니다.");
		scanner.close();
		
		// ★★최장신, 최단신을 출력하는 법
		int max = 0; int maxidx = 0;
		int min = 999; int minidx = 999; // 뒤에 값들이 적용되게 하려면 점점 작게 해야하므로 초기값은 크게 설정할 것.
		for (int idx = 0; idx <5; idx++) {
		if (height[idx] > max) {
			max = height[idx]; 
			maxidx = idx; // 최대키 idx를 지정해주는 작업.
		}
		if (height[idx] < min) {
			min = height[idx];
			minidx= idx; // 최소키 idx를 지정해주는 작업.
		}
		
		}
		System.out.printf("최고 키는 %d이고, 최소 키는 %d입니다.\t", max,min);
		System.out.printf("최고 키를 가진 사람은 %s 이고, 최소 키를 가진 사람은 %s 입니다.", name[maxidx], name[minidx]);
		
		}
	}


