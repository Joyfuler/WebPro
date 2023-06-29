package com.lec.loopQuiz;

public class Quiz1 {
	
	public static void main(String[] args) {
		int total = 1				;
		for(int i = 1; i <= 10; i++) {
			total *= i;
			
	}
		System.out.printf("1부터 10까지의 곱의 결과는 %d 입니다.", total);

}
}