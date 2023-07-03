package com.lec.ex4_human.kid;
// 메인함수에서 Kid kid = new Kid();
public class Kid {
	
	private String name;
	public Kid(String name) {
		this.name = name;
		System.out.println("name을 초기화하는 Kid 생성자 함수");
	}
	public Kid() {
		System.out.println("매개변수가 없는 Kid 생성자 함수");
	}
	
	
		
		// Kid kid = new Kid(); --> 디폴트 생성자. 위에 String name 함수가 없으면 가능하나 이미 생성자 함수를 만들었으므로
		// 위 문구는 에러가 뜸.
		// 따라서 Kid kid = new Kid("홍길동"); 등으로 이름을 넣어줘야...
	}
	


