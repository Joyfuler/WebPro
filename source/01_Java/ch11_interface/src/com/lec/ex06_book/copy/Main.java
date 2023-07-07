package com.lec.ex06_book.copy;

import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Book[] books = { new Book("890��-101-1��", "java", "ȫ�浿"), new Book("110��-111-1��", "dbms", "�ű浿"),
				new Book("110��-123-2��", "web", "���浿"), new Book("770��-123-2��", "jsp", "��浿"),
				new Book("110��-123-2��", "spring", "��浿") };

		Scanner scanner = new Scanner(System.in);
		// ��ɹ�ȣ ����
		int fn;
		int idx; // �����ȣ ��ȸ
		String bTitle, borrower, checkOutDate;

		do {
			System.out.println("���Ͻô� ����� �������ּ���. 1 - ���� | 2 - �ݳ� | 3 - å list ��ȸ | 0 - ����");
			fn = scanner.nextInt();
			
			switch (fn) {
			case 1:
				System.out.println("�����Ϸ��� å�� �̸��� �Է����ּ���.");
				bTitle = scanner.next(); // ȸ���� �Է��� �����Ͱ� btitle
				for (idx = 0; idx < books.length; idx++) {
					if (bTitle.equals(books[idx].getBookTitle())) {
						break; // �Ʒ��� �ٷΰ�
					}
				}
				if (idx == books.length) { // ��ã����?
					System.out.println("���� �������� ���� �����Դϴ�.");
				} else {
					if (books[idx].getBorrowState() == Book.BOOK_AVAILABLE) {
						System.out.println("�����Ͻô� ���� ������ �Է����ּ���.");
						borrower = scanner.next();
						System.out.println("�����ϴ� ��¥��?");
						checkOutDate = scanner.next();
						books[idx].checkout(borrower, checkOutDate);
					}
				}
				break;
			case 2:
				System.out.println("�ݳ��� å �̸���?");
				bTitle = scanner.next();
				for (idx=0; idx<books.length; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						break;
					
					} if (idx == books.length) {
						System.out.println("�ش� ������ �� �������� å�� �ƴմϴ�.");
			
					} else { books[idx].checkin();
					
					
				}
			} break;
			
				
				
			case 3:
				System.out.println("å ����Ʈ�� ������ �����ϴ�.");
				for (idx =0 ; idx < books.length; idx++) {
					books[idx].printstate();
				} break;
			}
		}while(fn!=0);System.out.println("�̿��� �ּż� �����մϴ�.");

}}