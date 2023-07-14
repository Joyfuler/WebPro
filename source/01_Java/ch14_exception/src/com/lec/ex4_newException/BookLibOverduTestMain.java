package com.lec.ex4_newException;

import java.io.ObjectInputStream.GetField;
import java.util.Date;
import java.util.GregorianCalendar;

// 책객체 생성 -> 대출 -> 대출일(20일전으로 주작) -> 반납 
public class BookLibOverduTestMain {
	public static void main(String[] args) {
		Book book = new Book("950-ㄱ10", "이것이 자바다", "신용권");
		System.out.println("대출 전 : " + book);
		book.checkout("홍길동"); // 대출.
		//book.setCheckoutDate(new Date (2023-1900, 5, 23)); // 6월 23일로 날짜주작
		book.setCheckoutDate(new Date(new GregorianCalendar(2023,5,23).getTimeInMillis()));
		System.out.println("대출 후 : " + book);
		try { // 반납할 때의 오류를 미리 예지하고 넣기
			book.checkIn();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("반납처리 확인 : " + book);
	} 
}
