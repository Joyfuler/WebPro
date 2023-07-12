package com.lec.ex1_string;

public class Ex11_speedCheck { // 함수 실행전 - 후 시간계산
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis(); // 밀리세컨 단위의 현재시간을 확인하는 함수.		
		// 1970.11 0시부터 현재까지의 밀리세컨..
		String str = "a";
		str += "a";
		for (int i=0; i<100000; i++) {
			str += "a"; // str에 a를 10만번더하는 계산..			
		}
		long end= System.currentTimeMillis();
		System.out.println("스트링 10만번 수정 시간 : " + (end - start));
			
		start = System.currentTimeMillis();
		StringBuilder stringBuilder = new StringBuilder("a");
		for (int i=0; i<100000; i++) {
			stringBuilder.append("a");
		}
		end = System.currentTimeMillis();
		System.out.println("스트링빌더 10만번 수정 시간 :" + (end - start));
	}	
}
