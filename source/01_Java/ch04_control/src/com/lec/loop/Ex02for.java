package com.lec.loop;

// 1 ~ 10까지 누적합은 55입니다.
// 1+2+3+4+5+6+7+8+9+10 = 55
public class Ex02for {
	public static void main(String[] args) {
		int total = 0;
		for(int i = 1; i <= 10; i++) {
			total += i; //total = total + i;
			// 더해지고 있는 바로 아래에 같이 넣어준다.
			// System.out.print(i + "+");
			// 마지막에 10+로 바껴버림. 을 제외해야...
			System.out.print(i);
			if (i != 10) {
				System.out.print("+"); // i가 10이 되는 순간 출력x
			}
			
		}
		System.out.println(" = " + total);
		// 1+2+3+4+5+6+7+8+9+10= 형식으로 출력하려면?
		System.out.println();
	}
}
