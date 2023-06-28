package com.lec.loop;

// 반복문(loop문)을 작성할 떄는 무한 반복문에 들어가지 않도록 주의
public class Ex06_endless {
	public static void main(String[] args) {
		for (int i = 0; true ; i++) {
			// 혹은 조건을 넣지 않는 경우에도 for (int i =0; ; i++){ 조건에 아무것도 쓰지 않으면 true로 인식, true로 인식해도 무한반복
			System.out.println("안녕하세요"); // 괄호안에 있는것이 무한반복
			if (i == 10) {
				break;
			}
		} // 무한반복 for 문	
	System.out.println("에러");
	}
	
	}

