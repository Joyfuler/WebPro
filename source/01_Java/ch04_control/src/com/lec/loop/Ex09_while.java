package com.lec.loop;
// 1~ 10까지의 숫자 중 3의 배수들의 합을 출력
public class Ex09_while {
	public static void main(String[] args) {
		// for (int i = 1; i <=10; i++) {
		//	if (i % 3 !=0) {
			//	break;
		int total = 0;
		int i= 1; // 초기값
		while (i<=10) {
			if (i % 3 == 0) {
				total += i;
			}
			i++;
			
		}
		System.out.println("1부터 10까지의 3의 배수의 합은 " + total); // sysout은 괄호바깥에
		
	}
}
