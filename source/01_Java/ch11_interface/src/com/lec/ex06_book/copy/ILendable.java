package com.lec.ex06_book.copy;

public interface ILendable { // ���Ⱑ�� �������̽�
	public int BOOK_AVAILABLE = 0;
	public int BOOK_BURROWING = 1;
	public void checkout (String borrower, String checkoutDate);
	public void checkin ();
	public void printstate(); // �������
	
}
