package com.lec.ex4_newException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// Book book = new book ("890-ㅁ01", "JAVA" "신용권");
public class Book implements ILendable {
	private String bookNo; // 청구번호 변수생성.
	private String bookTitle; // 책이름 변수생성.
	private String writer; // 저자 변수생성
	private String borrower; // 빌린사람
	private Date checkOutDate; // 빌린날짜 (빌렸을 때의 시점을 자동입력.
	private byte state; // 책 상태. (0 - 대출가능, 1- 대출중 --> normal, borrowed)

	public Book(String bookNo, String bookTitle, String writer) { // 데이터 넣을때 책번호, 책이름, 저자만 넣을 예정이므로

		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
		// borrower = null, checkOutDate = null, state = 0 모두 x 생성시 자동으로 이리됨
	}

	@Override
	public void checkout(String borrower) { // 대출인 , 대출일, 대출상태
		if (state == STATE_BORROWED) { // 만일 대출중이라면?
			System.out.println(bookTitle + " 책은 대출중인 상태입니다.");
			return; // void의 경우는 return;만 사용. 메시지만 출력하고 돌아감.
		}
		// state == STATE_NORMAL이어서 대출이 진행되는 경우
		this.borrower = borrower;
		checkOutDate = new Date(); // 현재 대출일로 변경
		state = STATE_BORROWED; // STATE_BORROWED는 1, 대출하고 있으니 1로 값 바꾸는 것.
		System.out.println(bookTitle + " 책이 대출됩니다.");
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		System.out.println("대출인: " + borrower + "\t대출일: " + sdf.format(checkOutDate));
	}

	@Override
	public void checkIn() throws Exception { // 반납
		if (state == STATE_NOMAL) { // 대출이 가능한 책이라는 의미.
			throw new Exception(bookTitle + " 책은 이미 반납이 완료되었습니다. 확인해 주세요.");

		}
		// state == STATE_BORROED여서 반납이 진행되는 경우
		// 책을 반납했으니 다시 0으로 바꾸는 작업. 누락하지 않게 조심...
		Date now = new Date(); // checkOutDate부터 now까지의 차를 계산해 연체일 산출
		long checkOutDateMilli = checkOutDate.getTime(); // 1970~ 대출일까지
		long nowMilli = now.getTime();
		long yeonche = (int) ((nowMilli - checkOutDateMilli) / (1000 * 60 * 60 * 24));
		
		if (yeonche > 14) { // 연체
			yeonche -= 14; // 14일 이상일 때 며칠 초과되었는지를 계산.
			System.out.println(yeonche + "일만큼 연체되어" + (yeonche * 100) + "원 연체료 부과됩니다. 연체료를 받으셨나요 (Y/N?)");
			Scanner scanner = new Scanner(System.in);
			
			if (!scanner.next().trim().equalsIgnoreCase("y")) {
				System.out.println("연체료를 미납하시면 반납처리가 안 됩니다.");
				return; // 돌려보냄. 반복하고 싶다면  do while 사용
			}
		}
		
			state = STATE_NOMAL;
			System.out.println(bookTitle + " 도서가 반납 완료되었습니다.");
		}

	

	/*
	 * public void printState() { // 출력할 문구. "890-ㅁ1 Java (신윤권 저) 대출 가능 if (state ==
	 * STATE_BORROWED) { System.out.println(bookNo + "\t" + bookTitle + "\t (" +
	 * writer + " 저) - 대출중"); } else if (state == STATE_NOMAL) {
	 * System.out.println(bookNo + "\t" + bookTitle + "\t (" + writer +
	 * " 저) - 대출가능"); }
	 * 
	 * String msg = bookNo + "\t" + bookTitle + "(" + writer + " 저)"; msg += state
	 * == STATE_BORROWED? "대출중" : "대출가능"; System.out.println(msg);
	 */

	@Override
	public String toString() {
		String msg = bookNo + "\t" + bookTitle + " (" + writer + " 저) ";
		msg += state == STATE_BORROWED ? ("대출중 (대출일: " + (checkOutDate) + ")") : "대출가능";
		return msg;
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

	public Date getCheckoutDate() {
		return checkOutDate;
	}
		// 연체일 조작을 위해 메소드
	public void setCheckoutDate(Date checkoutDate) {
		this.checkOutDate = checkoutDate;
	}

	public byte getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}

}
