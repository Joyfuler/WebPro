package com.lec.ex4_newException;

public class AccountTestMain {
	public static void main(String[] args) {
		Account hong = new Account ("011-1234", "홍길동", 10000); //계좌번호, 이름, 잔액이 들어있는 생성자 함수.
		String name = "홍홍홍";
		System.out.println(hong);
		// 그냥 hong만 입력하는 경우, @15db9742 라는 해시코드(16진수) 주소로 출력됨.
		// hong.infoString을 넣거나, hong.infoPrint(); 를 새로 만들어 출력해야함.
		
		hong.infoPrint();
		System.out.println(hong);
		Account hong1 = new Account("0123-9875", "홍길자"); // 잔액이 0원이라 입력되지 않았음. 계좌번호와 이름만 있는 생성자 함수.
		hong1.infoPrint();
		System.out.println(hong1);
		
		// 잔액 인출할 경우 예외가 발생할 수도, 안 할 수도 있으므로..
		try {
		hong.withdraw(5000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			hong1.withdraw(10);
		} catch (Exception e) {
			e.getMessage();
		}
		hong.deposite(100000);
		
	}
		
	}


