package com.lec.ex5_account;

public class AccountTestMain {
	public static void main(String[] args) {
		Account hong = new Account ("011-1234", "홍길동", 10000); //계좌번호, 이름, 잔액이 들어있는 생성자 함수.
		String name = "홍홍홍";
		System.out.println(hong.infoString());
		// 그냥 hong만 입력하는 경우, @15db9742 라는 해시코드(16진수) 주소로 출력됨.
		// hong.infoString을 넣거나, hong.infoPrint(); 를 새로 만들어 출력해야함.
		
		hong.infoPrint();
		System.out.println(hong.infoString());
		Account hong1 = new Account("0123-9875", "홍길자"); // 잔액이 0원이라 입력되지 않았음. 계좌번호와 이름만 있는 생성자 함수.
		hong1.infoPrint();
		System.out.println(hong1.infoString());
		hong.withdraw(5000);
		hong1.withdraw(10);
		hong.deposite(100000);
		
	}
		
	}


