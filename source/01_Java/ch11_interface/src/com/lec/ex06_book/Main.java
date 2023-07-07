package com.lec.ex06_book;

import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Book[] books = { new Book("890-ㅁ01", "java", "신윤권"), new Book("890-ㅂ02", "oracle", "오길동"),
				new Book("890-ㅁ02", "mysql", "마이동"), new Book("891-ㅂ03", "jdbc", "제갈동"),
				new Book("890-ㄱ01", "html", "이에치") };

		Scanner scanner = new Scanner(System.in);
		int fn; // 기능번호(1은 대출, 2는 반납, 3은 책 list 출력, 0은 종료)
		int idx; // 대출, 반납할 때 조회된 책의 index를 가져옴
		String bTitle, borrower, checkOutDate; // 사용자에게 입력받을 책 이름, 대출인, 대출일이 들어감. (모두 변수설정...)
		do { // do- while 문구. 기능번호를 0누른 경우 무한반복
			System.out.println("원하는 기능을 선택하세요. 1:대출 | 2:반납 | 3:책 list 출력 | 0: 종료");
			fn = scanner.nextInt(); // white-space 앞까지 입력된 정수를 받음. (space, enter 등..)
			switch (fn) {
			case 1:
				System.out.println("대출 로직"); // 대출 로직 - 1.책이름 입력 2. 책 조회 3. 책 대출여부 확인 (state...)
												// 대출인,대출일 5. checkOut호출 (대출인,대출일)
				// 1. 책이름 입력
				System.out.println("대출하려는 책 이름을 입력해주세요.");
				bTitle = scanner.next(); // 숫자가 아닌 글자를 입력 예외처리발생 주의 - 책이름 띄어쓰기 x.
				// 2. 책 조회 - 위에 설정해둔 idx로 배열 내에서 이름 확인
				for (idx = 0; idx < books.length; idx++) {
					if (books[idx].getBookTitle().equals(bTitle)) { // 이런 경우는 get을 이용해 이름만 가져옴. 입력한 책 명이 가져온 책 이름과 같다면?
						break; // for문 탈출 .
					}
					// 3. 책 상태 확인
				}
				if (idx == books.length) { // 위 반복문을 모두 반복해 idx가 배열 길이와 동일할 떄까지 못 찾았다면?
					System.out.println("현재 보유하지 않은 도서입니다.");
				} else { // book[idx] 도서 대출.
					if (books[idx].getState() == Book.STATE_BORROWED) { // 0이어야 대출 가능. 1이라면 대출 불가..
						System.out.println("대출중인 도서입니다.");
					} else {
						// 4. 대출인 입력받고
						System.out.println("대출하려는 사람의 이름을 입력해주세요.");
						borrower = scanner.next(); // 빌리려는 사람 이름을 입력.

						// 5. 대출일 입력받고
						System.out.println("대출일은 (07-07)?");
						checkOutDate = scanner.next();

						// 6. checkout 메소드 호출
						books[idx].checkout(borrower, checkOutDate);
					}
				}
				break;
			case 2: // 반납. 1. 책이름 받고 2. 책 조회 3. 책 대출여부 조회 (checkIn()메소드 호출)
				// 1. 책이름 입력
				System.out.println("반납할 책의 이름은?");
				bTitle = scanner.next(); // 책의 이름을 입력...
				// 2. 책 조회
				for (idx = 0; idx < books.length; idx++) {
					if (bTitle.equals(books[idx].getBookTitle())) { // btitle과 books[idx]번째의 타이틀이 같다면.. 반복문으로 각 idx의
																	// booktitle을 모두 비교함.
						break; // 입력한 btitle과 해당 순번의 book의 title이 같다면 break함.
					}
				}
				if (idx == books.length) { // idx가 해당 배열 길이 내내 해당 책을 찾지 못함.
					System.out.println("해당 도서는 본 도서관에 없습니다.");
				} else {
					// checkin() 반납메소드 실행
					books[idx].checkIn(); // 해당 배열의 책의 checkin 메소드를 실행함.
				}
				break;

			case 3:
				for (Book book : books) {
					book.printState(); // 책 출력하는 건 Book 클래스에 있자너...
				}

			}

		} while (fn != 0);
		System.out.println("감사합니다.");

	}
}
