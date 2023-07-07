package com.lec.ex06_book.copy;

public interface ILendable { // 대출가능 인터페이스
	public int BOOK_AVAILABLE = 0;
	public int BOOK_BURROWING = 1;
	public void checkout (String borrower, String checkoutDate);
	public void checkin ();
	public void printstate(); // 상태출력
	
}
