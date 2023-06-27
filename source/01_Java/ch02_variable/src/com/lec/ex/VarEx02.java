package com.lec.ex;

public class VarEx02 {
	public static void main(String[] args) {
		// 변수 타입 + 변수명 (알파벳, 숫자, _(언더바) / 영문으로 시작해야 함. (숫자 시작 불가) + 할당연산 초기값 (=)
		int i = 10;
		byte j = 127;
		double h = 10.15;
		System.out.println("i=" + i + "\t j=" + j + "\t h=" + h); // 콘솔창 출력(개행 포함)
		System.out.printf("i=%d\t j=%d\t h=%.2f\n", i,j,h);  // d는 정수 출력하는 포맷. f는 소숫점 출력하는 포맷. 1f는 소숫점 1자리까지, 2f는 소숫점 2자리까지...
		//  i는 정수 형식으로 (tab) j도 정수 형식으로 (tab) h는 소숫점 형식으로 표시한다는 의미
		//b는 boolean, \n은 줄바꿈.. 
		System.out.println("프로그램 끝");
		
		char c1= 'A';
		char c2= '쯔';
		// 문자 (%c) = char , 문자열 (%s) = string, 정수(%d) / 실수 (%f), 참거짓 boolean (%b)
		System.out.printf("c1=%c \t c2=%c \n", c1, c2); // 문자로 표시한 것
		System.out.printf("c1=%d \t c2=%d\n", (int) c1, (int) c2 ); // 정수로 표시한 것
		System.out.printf("c1=%f \t c2=%f \n", (double)c1, (double)c2); // 소수(실수)로 표시한 것
		
		
		
		int age = 10;
		String addr= "경기도";
				
				System.out.printf("내 나이는 %d살 입니다.\n", age);
				System.out.printf("내 나이는 %d 살이고, %s에 살고 있습니다", age, addr);
	}			
}
