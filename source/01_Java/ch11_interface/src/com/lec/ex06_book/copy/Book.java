package com.lec.ex06_book.copy;

// Book book = new book ("890-��01", "JAVA" "�ſ��");
public class Book implements ILendable {

	private String bookNo;
	private String bookTitle;
	private String writer;
	private String borrowName;
	private String borrowDate;
	private int borrowState;
	
	
	
	public Book(String bookNo, String bookTitle, String Writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = Writer;
	}

	@Override
	public void checkout (String borrower, String checkDate){
		this.borrowName = borrower;
		this.borrowDate = checkDate;
	
		if (borrowState == ILendable.BOOK_BURROWING) {
			System.out.println("�ش� ������ ���� �������Դϴ�.");
			return;
		}
		borrowState = BOOK_BURROWING;
		System.out.println(borrowName + "���� ��û�Ͻ�" + bookTitle + " å�� ������ �Ϸ�Ǿ����ϴ�.");
		
	}

	@Override
	public void checkin() {
		if (borrowState == BOOK_AVAILABLE) {
			System.out.println(borrowName + "���� ��û�Ͻ�" + bookTitle + "�� �̹� �ݳ��� �Ϸ�Ǿ����ϴ�.");
			return;
		}
		
			
			System.out.println(borrowName + "���� ��û�Ͻ� " + bookTitle + " ������ �ݳ��� �Ϸ�Ǿ����ϴ�.");
			borrowState = BOOK_BURROWING;
	}
		


	@Override
	public void printstate() { // å�� list ���
		if (borrowState == BOOK_AVAILABLE) {
			System.out.println(bookNo + "\t" + bookTitle + "(" + writer + ") ����, ���Ⱑ��");
		} else {
			System.out.println(bookNo + "\t" + bookTitle + "(" + writer + ") ����, ������");
		}
		
	}

	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getBorrowName() {
		return borrowName;
	}

	public void setBorrowName(String borrowName) {
		this.borrowName = borrowName;
	}

	public String getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(String borrowDate) {
		this.borrowDate = borrowDate;
	}

	public int getBorrowState() {
		return borrowState;
	}

	public void setBorrowState(int borrowState) {
		this.borrowState = borrowState;
	}
	
	
}