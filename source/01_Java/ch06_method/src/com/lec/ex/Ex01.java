package com.lec.ex;
// 1부터 10까지 정수의 합과 그 결과가 짝수인지 홀수인지 출력하는 법.
public class Ex01 {
	public static void main(String[] args) {
		int num =0; 
		for(int i=1; i<=10; i++) {
		num += i;	
		} System.out.println("총합은 " + num);
		System.out.println( num % 2 == 0 ? "짝수입니다." : "홀수입니다.");
		
		
		num =0; 
		for(int i=11; i<=100; i++) {
		num += i;	}
		System.out.println("총합은 " + num); // 수치는 거의 비슷하지만 비슷한 분량을 두번쳐야함. 메모리점유...
		
	}
}
