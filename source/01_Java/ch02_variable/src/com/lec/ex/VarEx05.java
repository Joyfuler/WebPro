package com.lec.ex;
// 형변환 
public class VarEx05 {
	public static void main(String[] args) {
		int i = 10; //4바이트
		double d = i;  // d= 10.0 으로 변환됨. 묵시적인 형변환 // 8바이트
		System.out.println("d= " + d); // 10이 아닌 10.0으로 됨. 큰 변수에 작은 수를 넣을때는 자동으로 변환
		
		i= (int) 10.6; // 10.6을 int로 형변환할 것. 명시적인(수동적인) 형변환. but 데이터 손실 발생할 수 있음
		System.out.println("i= " + i); // 10.6을 반올림해 11로 내는 것이 아닌 10으로 나오므로 오류 발생 위험.
		
		
		
}
}