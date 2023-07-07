package com.lec.ex06_book;

import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Book[] books = { new Book("890-��01", "java", "������"), new Book("890-��02", "oracle", "���浿"),
				new Book("890-��02", "mysql", "���̵�"), new Book("891-��03", "jdbc", "������"),
				new Book("890-��01", "html", "�̿�ġ") };

		Scanner scanner = new Scanner(System.in);
		int fn; // ��ɹ�ȣ(1�� ����, 2�� �ݳ�, 3�� å list ���, 0�� ����)
		int idx; // ����, �ݳ��� �� ��ȸ�� å�� index�� ������
		String bTitle, borrower, checkOutDate; // ����ڿ��� �Է¹��� å �̸�, ������, �������� ��. (��� ��������...)
		do { // do- while ����. ��ɹ�ȣ�� 0���� ��� ���ѹݺ�
			System.out.println("���ϴ� ����� �����ϼ���. 1:���� | 2:�ݳ� | 3:å list ��� | 0: ����");
			fn = scanner.nextInt(); // white-space �ձ��� �Էµ� ������ ����. (space, enter ��..)
			switch (fn) {
			case 1:
				System.out.println("���� ����"); // ���� ���� - 1.å�̸� �Է� 2. å ��ȸ 3. å ���⿩�� Ȯ�� (state...)
												// ������,������ 5. checkOutȣ�� (������,������)
				// 1. å�̸� �Է�
				System.out.println("�����Ϸ��� å �̸��� �Է����ּ���.");
				bTitle = scanner.next(); // ���ڰ� �ƴ� ���ڸ� �Է� ����ó���߻� ���� - å�̸� ���� x.
				// 2. å ��ȸ - ���� �����ص� idx�� �迭 ������ �̸� Ȯ��
				for (idx = 0; idx < books.length; idx++) {
					if (books[idx].getBookTitle().equals(bTitle)) { // �̷� ���� get�� �̿��� �̸��� ������. �Է��� å ���� ������ å �̸��� ���ٸ�?
						break; // for�� Ż�� .
					}
					// 3. å ���� Ȯ��
				}
				if (idx == books.length) { // �� �ݺ����� ��� �ݺ��� idx�� �迭 ���̿� ������ ������ �� ã�Ҵٸ�?
					System.out.println("���� �������� ���� �����Դϴ�.");
				} else { // book[idx] ���� ����.
					if (books[idx].getState() == Book.STATE_BORROWED) { // 0�̾�� ���� ����. 1�̶�� ���� �Ұ�..
						System.out.println("�������� �����Դϴ�.");
					} else {
						// 4. ������ �Է¹ް�
						System.out.println("�����Ϸ��� ����� �̸��� �Է����ּ���.");
						borrower = scanner.next(); // �������� ��� �̸��� �Է�.

						// 5. ������ �Է¹ް�
						System.out.println("�������� (07-07)?");
						checkOutDate = scanner.next();

						// 6. checkout �޼ҵ� ȣ��
						books[idx].checkout(borrower, checkOutDate);
					}
				}
				break;
			case 2: // �ݳ�. 1. å�̸� �ް� 2. å ��ȸ 3. å ���⿩�� ��ȸ (checkIn()�޼ҵ� ȣ��)
				// 1. å�̸� �Է�
				System.out.println("�ݳ��� å�� �̸���?");
				bTitle = scanner.next(); // å�� �̸��� �Է�...
				// 2. å ��ȸ
				for (idx = 0; idx < books.length; idx++) {
					if (bTitle.equals(books[idx].getBookTitle())) { // btitle�� books[idx]��°�� Ÿ��Ʋ�� ���ٸ�.. �ݺ������� �� idx��
																	// booktitle�� ��� ����.
						break; // �Է��� btitle�� �ش� ������ book�� title�� ���ٸ� break��.
					}
				}
				if (idx == books.length) { // idx�� �ش� �迭 ���� ���� �ش� å�� ã�� ����.
					System.out.println("�ش� ������ �� �������� �����ϴ�.");
				} else {
					// checkin() �ݳ��޼ҵ� ����
					books[idx].checkIn(); // �ش� �迭�� å�� checkin �޼ҵ带 ������.
				}
				break;

			case 3:
				for (Book book : books) {
					book.printState(); // å ����ϴ� �� Book Ŭ������ ���ڳ�...
				}

			}

		} while (fn != 0);
		System.out.println("�����մϴ�.");

	}
}
