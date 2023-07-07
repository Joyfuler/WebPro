package com.lec.ex06_book.copy;

import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Book[] books = { new Book("890ㅁ-101-1ㄱ", "java", "홍길동"), new Book("110ㄱ-111-1ㄱ", "dbms", "신길동"),
				new Book("110ㅁ-123-2ㅌ", "web", "유길동"), new Book("770ㅁ-123-2ㅌ", "jsp", "고길동"),
				new Book("110ㅁ-123-2ㅌ", "spring", "김길동") };

		Scanner scanner = new Scanner(System.in);
		// 기능번호 생성
		int fn;
		int idx; // 가상번호 조회
		String bTitle, borrower, checkOutDate;

		do {
			System.out.println("원하시는 기능을 선택해주세요. 1 - 대출 | 2 - 반납 | 3 - 책 list 조회 | 0 - 종료");
			fn = scanner.nextInt();
			
			switch (fn) {
			case 1:
				System.out.println("대출하려는 책의 이름을 입력해주세요.");
				bTitle = scanner.next(); // 회원이 입력한 데이터가 btitle
				for (idx = 0; idx < books.length; idx++) {
					if (bTitle.equals(books[idx].getBookTitle())) {
						break; // 아래로 바로감
					}
				}
				if (idx == books.length) { // 못찾으면?
					System.out.println("현재 보유하지 않은 도서입니다.");
				} else {
					if (books[idx].getBorrowState() == Book.BOOK_AVAILABLE) {
						System.out.println("대출하시는 분의 성명을 입력해주세요.");
						borrower = scanner.next();
						System.out.println("대출하는 날짜는?");
						checkOutDate = scanner.next();
						books[idx].checkout(borrower, checkOutDate);
					}
				}
				break;
			case 2:
				System.out.println("반납할 책 이름은?");
				bTitle = scanner.next();
				for (idx=0; idx<books.length; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						break;
					
					} if (idx == books.length) {
						System.out.println("해당 도서는 본 도서관의 책이 아닙니다.");
			
					} else { books[idx].checkin();
					
					
				}
			} break;
			
				
				
			case 3:
				System.out.println("책 리스트는 다음과 같습니다.");
				for (idx =0 ; idx < books.length; idx++) {
					books[idx].printstate();
				} break;
			}
		}while(fn!=0);System.out.println("이용해 주셔서 감사합니다.");

}}