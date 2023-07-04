package com.lec.ex5_final;

import com.lec.constant.Constant;

public class FInalTestMain {
public static void main(String[] args) {
	final double PI = 3.1415926535;
	// final로 확정하면 이후 pi의 값을 변경할 수 없음.
	// pi = 3; 에러출력.. 주로 다른 사람들과 프로젝트를 공유할 때 값을 변경하고 싶지 않다면.
	
	int r = 3; // 원의 반지름의 길이가 3
	double area = Constant.PI * r * r;  // 원의 넓이는 r 제곱 곱하기 3.14
	double round = 2 * Constant.PI * r ; // 원의 반지름이 r일때 원의 둘레는? 2 X 3.14 X r
	System.out.printf("반지름이 %d인 원의 넓이는 %.3f\n", r,area);
	System.out.printf("지름이 %d인 원의 둘레는 %.3f\n", r, round);
	
	// 항상 사용하는 상수이므로 메모리 확보가 필요 --> static을 활용함.
}
}
