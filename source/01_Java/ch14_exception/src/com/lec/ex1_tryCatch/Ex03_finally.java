package com.lec.ex1_tryCatch;

import java.text.Format;

public class Ex03_finally {
	public static void main(String[] args) {

		int[] arr = { 0, 1, 2 };
		for (int idx = 0; idx <= arr.length; idx++) {
			try {
				System.out.println("arr[" + idx + "] = " + arr[idx]);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("예외 메시지 : " + e.getMessage());
			} finally { // 일종의 try절의 마무리 작업...? 가독성을 위해 사용. 
				System.out.println("try절 실행 후에도, catch절 실행 후에도 항상 실행되는 절.");
			} // try + catch + finally (try절)
			System.out.println("----------------------------------------");

		}
	}
}
