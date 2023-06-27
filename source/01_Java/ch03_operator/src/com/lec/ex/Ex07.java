package com.lec.ex;
// 비트 논리연산자 : &(and) , |(or)
public class Ex07 {
	public static void main(String[] args) {
		int n1 = 1; // 내부적으로는 2진수로 변환되므로 실제로는  0 0 0 1
		int n2 = 2; // 내부적으로는 2진수... 실제로는 		  0 0 1 0
		//                                           --------
		//                                &(and)계산시  0 0 0 0
		//								  하나라도 0이면 모두 0으로.
		//                                |(or)계산시 0 0 1 1 = 3
		//								 하나라도 1이면 모두 1로. 
		System.out.println("n1 & n2 는 " + (n1 & n2));
		System.out.println("n1 | n2 는 " + (n1 | n2));
		// 자바 환경에서는 거의 사용되지 않는 수식.
	
}
}
