package com.lec.loopQuiz;

public class Quiz2 {
	public static void main(String[] args) {
	int total = 0;
	for(int i = 1 ; i<=10 ; i++) {
		if (i % 2 == 1) {
			total = total + i;
		}
		
		
}
	System.out.printf("1부터 10까지 홀수의 합은 %d 입니다.", total);
	
}
}