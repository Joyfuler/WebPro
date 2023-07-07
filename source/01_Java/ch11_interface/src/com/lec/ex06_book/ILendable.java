package com.lec.ex06_book;

public interface ILendable { // 대출가능 인터페이스
	public byte STATE_BORROWED = 1; // 대출중.
	public byte STATE_NOMAL = 0; // 대출가능
	
	public void checkout(String borrower, String checkoutDate); // 대출. 이름과 날짜
	public void checkIn(); // 반납하는 메소드.
	public void printState(); // 책번호와 책 이름, 대출가능여부를 출력하는 메소드.
}
