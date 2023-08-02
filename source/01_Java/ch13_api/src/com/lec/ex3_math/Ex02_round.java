package com.lec.ex3_math;
// round - 올림, 반올림, 내림
// Math.ceil (천장) (올릴 실수) - Double 값으로 리턴됨. ex) Math.ceil(8.17) --> 9.0으로 출력
// Math.round (반올림할 실수, long값을 return함. ex) Math.round(8.17) --> 8로 출력 
// Math.floor (바닥) (내릴 실수) - Double 값으로 리턴됨. ex) Math.floor (8.17) --> 8.0으로 출력

public class Ex02_round {
	public static void main(String[] args) {
		System.out.println("소수점에서 반올림, 올림, 버림");
		System.out.println("8.17을 올림 : " + (int)Math.ceil(8.17)); // 소숫점 첫째 자리에서 올리는 것. 9
		System.out.println("8.17을 반올림 : " + Math.round(8.17)); // 8
		System.out.println("8.15를 버림 : " + (int)Math.floor(8.15));
		// 소숫점 두번쨰에서 올림, 반올림, 내림하려면?
		System.out.println("소숫점 두번째 자리에서 반올림");
		System.out.println("8.15를 올려서 8.2로 나오는 방법 : " + Math.ceil(8.15 * 10) /10);		
		// 8.15를 10 곱하면 81.5가 나오고, 올리면 82가 됨. 여기서 다시 10으로 나누면 최종적으로 8.2가 됨.
		System.out.println("8.15를 반올림 " + Math.round(8.15 * 10) / 10.0); // java의 나눗셈 주의! 10이 아닌 10.0으로 나눠야
		System.out.println("8.15를 내림 " + Math.floor(8.15 * 10) / 10);
		System.out.println("일의자리에서 반올림, 올림, 버림 (ex 85 => 90");
		System.out.println("85를 올림 : " + (int)Math.ceil(85 / 10.0) * 10); // 나누기는 10이 아닌 10.0임을 잊지말것. 8.5를 올림하면 9.0이 됨
		System.out.println("85를 반올림 : " + Math.round(85 / 10.0) * 10);
		System.out.println("85를 내림 : " + (int)Math.floor(85 / 10.0) * 10);
		// 자리수를 변경하는 반올림, 내림 등은 잔머리를 써서 바꿔보자. *10을 한 후 다시 /10을 한다든가... 
	}	
}
