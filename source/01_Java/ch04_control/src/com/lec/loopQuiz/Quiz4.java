package com.lec.loopQuiz;

public class Quiz4 {
	public static void main(String[] args) {
		int start = 1;
		for (int i = 1; i <= 9; i++) {
			for (int j = 2; j <=9; j++) {
				start = (i * j);
				System.out.printf("%d * %d = %d \t",j,i,start);
		}
			System.out.println();
	}
}
}
