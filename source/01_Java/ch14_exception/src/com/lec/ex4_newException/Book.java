package com.lec.ex4_newException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// Book book = new book ("890-��01", "JAVA" "�ſ��");
public class Book implements ILendable {
	private String bookNo; // û����ȣ ��������.
	private String bookTitle; // å�̸� ��������.
	private String writer; // ���� ��������
	private String borrower; // �������
	private Date checkOutDate; // ������¥ (������ ���� ������ �ڵ��Է�.
	private byte state; // å ����. (0 - ���Ⱑ��, 1- ������ --> normal, borrowed)

	public Book(String bookNo, String bookTitle, String writer) { // ������ ������ å��ȣ, å�̸�, ���ڸ� ���� �����̹Ƿ�

		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
		// borrower = null, checkOutDate = null, state = 0 ��� x ������ �ڵ����� �̸���
	}

	@Override
	public void checkout(String borrower) { // ������ , ������, �������
		if (state == STATE_BORROWED) { // ���� �������̶��?
			System.out.println(bookTitle + " å�� �������� �����Դϴ�.");
			return; // void�� ���� return;�� ���. �޽����� ����ϰ� ���ư�.
		}
		// state == STATE_NORMAL�̾ ������ ����Ǵ� ���
		this.borrower = borrower;
		checkOutDate = new Date(); // ���� �����Ϸ� ����
		state = STATE_BORROWED; // STATE_BORROWED�� 1, �����ϰ� ������ 1�� �� �ٲٴ� ��.
		System.out.println(bookTitle + " å�� ����˴ϴ�.");
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		System.out.println("������: " + borrower + "\t������: " + sdf.format(checkOutDate));
	}

	@Override
	public void checkIn() throws Exception { // �ݳ�
		if (state == STATE_NOMAL) { // ������ ������ å�̶�� �ǹ�.
			throw new Exception(bookTitle + " å�� �̹� �ݳ��� �Ϸ�Ǿ����ϴ�. Ȯ���� �ּ���.");

		}
		// state == STATE_BORROED���� �ݳ��� ����Ǵ� ���
		// å�� �ݳ������� �ٽ� 0���� �ٲٴ� �۾�. �������� �ʰ� ����...
		Date now = new Date(); // checkOutDate���� now������ ���� ����� ��ü�� ����
		long checkOutDateMilli = checkOutDate.getTime(); // 1970~ �����ϱ���
		long nowMilli = now.getTime();
		long yeonche = (int) ((nowMilli - checkOutDateMilli) / (1000 * 60 * 60 * 24));
		
		if (yeonche > 14) { // ��ü
			yeonche -= 14; // 14�� �̻��� �� ��ĥ �ʰ��Ǿ������� ���.
			System.out.println(yeonche + "�ϸ�ŭ ��ü�Ǿ�" + (yeonche * 100) + "�� ��ü�� �ΰ��˴ϴ�. ��ü�Ḧ �����̳��� (Y/N?)");
			Scanner scanner = new Scanner(System.in);
			
			if (!scanner.next().trim().equalsIgnoreCase("y")) {
				System.out.println("��ü�Ḧ �̳��Ͻø� �ݳ�ó���� �� �˴ϴ�.");
				return; // ��������. �ݺ��ϰ� �ʹٸ�  do while ���
			}
		}
		
			state = STATE_NOMAL;
			System.out.println(bookTitle + " ������ �ݳ� �Ϸ�Ǿ����ϴ�.");
		}

	

	/*
	 * public void printState() { // ����� ����. "890-��1 Java (������ ��) ���� ���� if (state ==
	 * STATE_BORROWED) { System.out.println(bookNo + "\t" + bookTitle + "\t (" +
	 * writer + " ��) - ������"); } else if (state == STATE_NOMAL) {
	 * System.out.println(bookNo + "\t" + bookTitle + "\t (" + writer +
	 * " ��) - ���Ⱑ��"); }
	 * 
	 * String msg = bookNo + "\t" + bookTitle + "(" + writer + " ��)"; msg += state
	 * == STATE_BORROWED? "������" : "���Ⱑ��"; System.out.println(msg);
	 */

	@Override
	public String toString() {
		String msg = bookNo + "\t" + bookTitle + " (" + writer + " ��) ";
		msg += state == STATE_BORROWED ? ("������ (������: " + (checkOutDate) + ")") : "���Ⱑ��";
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
		// ��ü�� ������ ���� �޼ҵ�
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
