package com.lec.ex06_book.copy;

// Book book = new book ("890-ㅁ01", "JAVA" "신용권");
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
			System.out.println("해당 도서는 현재 대출중입니다.");
			return;
		}
		borrowState = BOOK_BURROWING;
		System.out.println(borrowName + "님이 요청하신" + bookTitle + " 책의 대출이 완료되었습니다.");
		
	}

	@Override
	public void checkin() {
		if (borrowState == BOOK_AVAILABLE) {
			System.out.println(borrowName + "님이 요청하신" + bookTitle + "은 이미 반납이 완료되었습니다.");
			return;
		}
		
			
			System.out.println(borrowName + "님이 요청하신 " + bookTitle + " 도서의 반납이 완료되었습니다.");
			borrowState = BOOK_BURROWING;
	}
		


	@Override
	public void printstate() { // 책의 list 출력
		if (borrowState == BOOK_AVAILABLE) {
			System.out.println(bookNo + "\t" + bookTitle + "(" + writer + ") 지음, 대출가능");
		} else {
			System.out.println(bookNo + "\t" + bookTitle + "(" + writer + ") 지음, 대출중");
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