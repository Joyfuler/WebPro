package com.lec.ex1_string;

import java.util.Scanner;

// 사용자가 x를 입력할 때까지 반복
public class Ex03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String fn;
		do {
			System.out.println("무엇을 도와드릴까용? I: input, U: update, D: delete, X : exit");
			fn = scanner.next(); // i,I,U,u,d,D,x,X, 등등...
			switch (fn) {
			case "I":
			case "i":
				System.out.println("입력 로직");
				break;
			case "U":
			case "u":
				System.out.println("업데이트 로직");
				break;
			case "D":
			case "d":
				System.out.println("삭제 로직");
				break;
			}

		// } while (!fn.equals("x") && !fn.equals("X")); // x가 아니면 계속 돔. (fn 앞에 !)
		} while (!fn.equalsIgnoreCase("x"));
		System.out.println("종료합니다.");
		scanner.close();
	}
}
