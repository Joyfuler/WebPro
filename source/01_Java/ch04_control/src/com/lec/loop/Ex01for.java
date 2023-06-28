package com.lec.loop;

public class Ex01for {
	public static void main(String[] args) {
		for(int i =0 ; i<5 ; i++) { //초기값은 0, i가 5가 될 때까지 계속 +1씩
			// 순서는 i=10이 1번, i<5가 2번, sysout이 3번, i++이 4번.
			// 1234 234 234 234 234 ... 순서로 진행. sysout 출력된 후 i가 1 늘어나는 것.
			// 2번의 조건이 거짓이 되면 멈춤.
			System.out.println(i + ", 안녕하세요"); // i가 따로 없는 경우엔 i가 몇 번 반복할지의 프로그램 용도로 사용됨
			System.out.println("방가방가");
	} // for
} // main
} // class