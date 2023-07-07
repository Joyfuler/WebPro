package com.lec.ex06_book;

// Book book = new book ("890-ㅁ01", "JAVA" "신용권");
public class Book implements ILendable {
	private String bookNo; // 청구번호 변수생성.
	private String bookTitle; // 책이름 변수생성.
	private String writer; // 저자 변수생성
	private String borrower; // 빌린사람
	private String checkoutDate; // 빌린날짜 (차후 Date...)
	private byte state; // 책 상태. (0 - 대출가능, 1- 대출중 --> normal, borrowed)

	public Book(String bookNo, String bookTitle, String writer) { // 데이터 넣을때 책번호, 책이름, 저자만 넣을 예정이므로

		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
		// borrower = null, checkOutDate = null, state = 0 모두 x 생성시 자동으로 이리됨
	}

	@Override
	public void checkout(String borrower, String checkoutDate) { // 대출인 , 대출일, 대출상태
		if (state == STATE_BORROWED) { // 만일 대출중이라면?
			System.out.println(bookTitle + " 책은 대출중인 상태입니다.");
			return; // void의 경우는 return;만 사용. 메시지만 출력하고 돌아감.
		}
		// state == STATE_NORMAL이어서 대출이 진행되는 경우
		this.borrower = borrower;
		this.checkoutDate = checkoutDate;
		state = STATE_BORROWED; // STATE_BORROWED는 1, 대출하고 있으니 1로 값 바꾸는 것.
		System.out.println(bookTitle + " 책이 대출됩니다.");
		System.out.println("대출인: " + borrower + "\t대출일: " + checkoutDate);
	}

	@Override
	public void checkIn() { // 반납
		if (state == STATE_NOMAL) { // 대출이 가능한 책이라는 의미.
			System.out.println(bookTitle + " 책은 이미 반납이 완료되었습니다. 확인해 주세요.");
			return;
		}
		// state == STATE_BORROED여서 반납이 진행되는 경우
		borrower = null; // 없는 값으로 초기화
		checkoutDate = null;
		state = STATE_NOMAL; // 책을 반납했으니 다시 0으로 바꾸는 작업. 누락하지 않게 조심...
		System.out.println(bookTitle + " 도서가 반납 완료되었습니다.");

	}
	
	@Override
	public void printState() { // 출력할 문구. "890-ㅁ1 Java (신윤권 저) 대출 가능
		if (state == STATE_BORROWED) {
			System.out.println(bookNo + "\t" + bookTitle + "\t (" + writer + " 저) - 대출중");
		}
		else if (state == STATE_NOMAL) {
			System.out.println(bookNo + "\t" + bookTitle + "\t (" + writer + " 저) - 대출가능");
		}
		/*
		 * String msg = bookNo + "\t" + bookTitle + "(" + writer + " 저)"; msg += state
		 * == STATE_BORROWED? "대출중" : "대출가능"; System.out.println(msg);
		 */
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

	public String getBorrower() {
		return borrower;
	}

	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}

	public String getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(String checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public byte getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	} 
	
	
	
}
