package com.lec.method;
// sum(from, to) 외에 sum(int 1개) 등 함수 1개만 넣는 경우 : 함수의 오버로딩 // evenOdd(int 1개) // abs(-9) --> 9로 출력되는 절댓값 리턴
public class Arithmetic {
	public int sum(int from, int to) { // from부터 to까지의 합
		int total = 0;
		for (int i = from; i<=to; i++) { 
			total += i;
		
		
		} return total;
		
		
}
	public int sum (int to) {
		int total = 0;
		for (int i =1; i<=to; i++) {
			total += i;
		} return total;
	}
	
	public String evenOdd (int value) {
		String result = value % 2 == 0? "짝수입니다." : "홀수입니다.";
		return result;
	}
	
	public static int abs (int value) { // static이 들어간 것과 안 들어간 것의 차이는?
		int result = value > 0 ? value : value * (-1); // 절대값
		return result;
	}
		
		
		
	
}
