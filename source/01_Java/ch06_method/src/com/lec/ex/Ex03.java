package com.lec.ex;

import com.lec.method.Arithmetic;

public class Ex03 {
	public static void main(String[] args) { //public = 외부에서 실행가능한 메소드라는 의미
		// 만일 생략하면? default 가 되면서 다른 패키지에선 사용할 수 없게됨.
		System.out.println("-9의 절대값은" + Arithmetic.abs(-9)); // 자동완성 사용시 import가 자동으로 생김.
		// 패키지가 다른경우 Arithme정도 입력한 후 컨트롤 스페이스로 import를 꼭 실행.
		// static인 경우 abs처럼 누운폰트, static이 아니면 evenOdd, sum처럼 일반글자로 출력
		Arithmetic ar = new Arithmetic();
		int tot = ar.sum(10);
		System.out.println("1에서 10까지의 합은 " + tot);
		System.out.println(ar.evenOdd(tot));
		tot = ar.sum (10,100);
		System.out.println("10부터 100까지의 합은" + tot);
		System.out.println(ar.evenOdd(tot));
}
}