package com.lec.method;

public class Ex03 {
	public static void main(String[] args) {
		System.out.println(" -9의 절대값은 : " + Arithmetic.abs(-9)); 
		//class가 다른 경우 앞에 클래스 이름을 쓴 후 메소드를 써주면 작동함.
		// abs 앞에는 static을 사용했으므로 다른 클래스에서 동작함.
		
		
		
		// 만일 string이 적혀 있지 않은 sum이나 ovenOdd는 어떻게?
		// 오류남 - System.out.println("1부터 10의 합은" + Arithmetic.sum(1,10));
		Arithmetic ar = new Arithmetic(); // 다른 클래스(파일)명을 불러오고 객체형 변수인 ar을 생성. 다른 패키지이므로 
		int num = ar.sum(11,100);
		System.out.println("11부터 100까지 누적합은" + num);
		System.out.println(ar.evenOdd(num));
		
		num = ar.sum(50);
		System.out.println("50까지의 누적합은 " + num);
		
	}
}
