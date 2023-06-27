package com.lec.ex;
// 변수 선언 방법. 기본 : int i =10;
public class VarEx03 {
	
	public static void main(String[] args) {
		// 1. 자료형 변수명 = 초기값; - 변수 선언과 동시에 초기화(할당)
		int num1 = 10;
		// 2. 자료형 변수명; 값을 넣지 않고 변수만 선언한 것. but 실행시에는 오류가 발생
//		int num2;
		int num2 = 20; // 할당한 모습
		System.out.printf("num1=%d \t num2=%d \n", num1, num2);
		
		// 3. 자료형 변수1 = 값1, 변수2=값2 , 변수3=값3 ..; 동일자료형 변수를 다수 선언과 초기화
		int num3=30, num4=40, num5=50; //여러 변수를 한번에 선언및 초기화
		System.out.printf("num3=%d \t num4=%d \t num5=%d \n", num3, num4, num5);
		
		// 4. 자료형 변수1, 변수2, ..; 동일자료형 변수를 다수 선언 (초기화x)
		int num6, num7, num8;
		num6 = 50; num7= 60;
		System.out.printf("num6=%d \t num7=%d \n", num6, num7);
	}

}
