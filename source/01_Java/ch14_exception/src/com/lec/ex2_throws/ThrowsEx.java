package com.lec.ex2_throws;

public class ThrowsEx {

	public ThrowsEx() throws Exception {
		actionC();
	}

	private void actionC() throws Exception { // Runtime예외가 아닌 경우는 위에 문법적 오류가 발생..
		System.out.println("actioncC 전반부");
		actionB();
		System.out.println("actionC 후반부");

	}

	private void actionB() throws RuntimeException {
		System.out.println("actionB 전반부");
		actionA();

		System.out.println("actionB 후반부");
	}

	private void actionA() throws ArrayIndexOutOfBoundsException { // 다음과 같이 예외를 다른 곳으로 던질수도 있음..
		// 예외가 발생된 순간 자신이 호출받은 곳으로 돌아가므로, sout 액션A 후반부는 출력되지 않음.
		System.out.println("actionA 전반부");
		int[] arr = { 0, 1 };
		// try {
		System.out.println(arr[2]);
		// } catch (ArrayIndexOutOfBoundsException e) {
		// System.out.println(e.getMessage());

		System.out.println("액션A 후반부");
	}

}
