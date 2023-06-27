package com.lec.ex;
//논리 연산자 : &&(and) ||(or) & | ? 등
public class Ex04 {
	public static void main(String[] args) {
		
		int i=1, j=10, h=10;
		System.out.println("&&(AND) : (i<j) && (++j>h) 는" + ((i<j) && (++j>h))); // i<j = 1<10 // ++j>h 는 11>1이므로 모두 true.
		//or에서 모두 true이므로 결과는 true로 출력
		System.out.println("j=" + j);
		System.out.println("&&(AND) : (i>j) && (++j>h) 는" + ((i>j) && (++j>h)));
		System.out.println("j=" + j);
		
		// ||연산자의 경우 좌항이 true이면 우항의 값에 관계없이 true로 출력됨. (한개만 true를 만족하면 true)
		System.out.println("||(OR) : (i>j) || (++j>h) 는 " + ((i>j) || (++j>h) )); // i>j는 false, ++j>h는 true이므로 true
		System.out.println("||(OR) : (i<j) || (++j>h) 는" + ((i<j) || (++j>h))); // i<j는 true, ++j>h 는 true이므로 true
		System.out.println("||(OR) : (i<j) || (++j>h) 는" + ((i>j) || (++j<h))); // i>j는 false, ++j<h는 false이므로 false
		
		// & | 뜻은? 
		
		
	}
}
