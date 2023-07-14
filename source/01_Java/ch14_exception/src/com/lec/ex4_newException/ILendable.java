package com.lec.ex4_newException;

public interface ILendable { // 대출가능 인터페이스
	public byte STATE_BORROWED = 1; // 대출중.
	public byte STATE_NOMAL = 0; // 대출가능
	
	public void checkout(String borrower); // 대출인은 확인, 대출일은 오늘로 변경되므로 date매개변수를 빼버림.
	public void checkIn() throws Exception; // 반납하는 메소드.
	// 책번호와 책 이름, 대출가능여부를 출력하는 메소드.
}
