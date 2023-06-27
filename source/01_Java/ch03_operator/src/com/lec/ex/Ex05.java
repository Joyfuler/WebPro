package com.lec.ex;
// 삼항연산자 (조건식) ?    (a==b) ?  조건이 true일 경우 취할 값 : 조건이 false일 경우 취할 값
public class Ex05 {
	public static void main(String[] args) {
		int h = 100;
//		String result = (h%2 == 0)? "짝수입니다":"홀수입니다"; // h를 2로 나눈 나머지가 0이 true라면 짝수, false라면 홀수로 표시. 
		String result = (h%2 == 0)? "짝수입니다." : "홀수입니다.";
		System.out.println(result); // 짝수임니당
		if (h%2 == 0) { // if else를 사용해도 동일하게 출력 가능. 일반적으로는 삼항을 더 많이 쓰는모양
			System.out.println("짝수입니다.");
		} else {
			System.out.println("홀수입니다.");
				
			}
		}
		
	}


