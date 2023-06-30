package com.lec.ex;

public class Ex02_method {
 // parameter (=매개변수) -> 바뀌는 특정 값.. 주로 from, to로 사용함) 를 받아 from부터 to까지의 누적합을 return 해야함. (호출자에게 반환하는 값)
 // 접근제한자: private (이 파일에서만 쓸 예정), public (다른 파일에서도 쓸 것)
//  리턴타입 : 돌려줄 값의 타입은?
	private static int sum (int from, int to) { // ★★ from부터 to까지 누적. 
	 int tot = 0; // 누적변수
	 	for (int i = from; i <= to; i++) {
	 		tot += i;
	 	}
	 	return tot; // tot 값을 main에 반환해줄 예정
	 	
	
	}

	// 패러미터 (매개변수, 인자 ( value)를 받아 짝, 홀수 여부를 문자열로 return 하는 메소드
	// 짝수입니다. 홀수입니다. 값을 return하므로 return 타입은 String
	private static String evenOdd(int value) { // value값을 받은 뒤 짝,홀을 리턴
		String result = value % 2 == 0 ? "짝수입니다." : "홀수입니다."; //result 값을 출력하는 과정 
		return result; // result를 반환. 반환값은 반드시 넣을 것.
	}
	
	public static void main(String[] args) { // void는 리턴값이 없는 경우. main 함수에서는 return 사용 안했음.
		//int tot = sum(1,10); // sum 메소드에 있던 tot 변수에 2가지 값만 넣음.
		int tot = sum(1,50); // sum 메소드의 from은 1, to는 50
		System.out.println("1부터 50까지 정수의 합은" + tot);
		System.out.println("수는" + evenOdd(tot));
		
		tot = sum (50,151);
		System.out.println( "50부터 151까지 정수의 합은" + tot);
		System.out.println(evenOdd(tot)); //앞 과정에서 tot= 50에서 151의 합 10251이 되었음. 따라서 evenodd(10251)이 됨. 
		
		
		
	}
		
	}
 
