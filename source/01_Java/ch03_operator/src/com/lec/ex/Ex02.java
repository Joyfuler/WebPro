package com.lec.ex;

// 증감연산자: ++ (1증가), --(1감소)
public class Ex02 {
	public static void main(String[] args) {
		int n1 = 10;
		int n2 = ++n1; // n1을 1증가하고 n2에 할당한 것. (n1과 n2 모두 11) --> 앞에다 붙이면 즉시 계산.
		System.out.println("n1 =" + n1 + " n2 =" + n2);
		n2 = n1++; // n2는 n1에 대입되고, 그 후 n1이 +1됨. (n2는 11, n1은 12)
		System.out.println("n1 =" + n1 + " n2 =" + n2);
		--n1; // n1을 1 감소. (앞에 있으므로 즉시계산) 
		System.out.println("n1 = " + n1); // (11이 됨.)
		n2 = n1--; // (n1은 우선 -1 되고, n2는 그대로. (앞에 n2가 있기 때문)) --> n1은 10, n2는 11
		System.out.println("n1=" + n1 + " n2=" + n2);
		
	}
}
