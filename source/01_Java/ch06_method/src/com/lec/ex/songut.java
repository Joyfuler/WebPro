package com.lec.ex;

public class songut {
	private static int sum(int from, int to) {
		int tot = 0;
		for (int i = from; i < to; i++) {
			tot += i;
		}
		return tot;
	}

	private static String evenOdd(int value) {
		String result = (value % 2 == 0) ? "짝수입니다" : "홀수입니다.";
		return result;

	}
	
	public static void main(String[] args) {
		int tot = sum(1,90);
		System.out.println("합은" + tot);
		System.out.println("해당 수는" + evenOdd(tot));
	}

}
