package com.lec.ex06_book;

// Book book = new book ("890-��01", "JAVA" "�ſ��");
public class Book implements ILendable {
	private String bookNo; // û����ȣ ��������.
	private String bookTitle; // å�̸� ��������.
	private String writer; // ���� ��������
	private String borrower; // �������
	private String checkoutDate; // ������¥ (���� Date...)
	private byte state; // å ����. (0 - ���Ⱑ��, 1- ������ --> normal, borrowed)

	public Book(String bookNo, String bookTitle, String writer) { // ������ ������ å��ȣ, å�̸�, ���ڸ� ���� �����̹Ƿ�

		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
		// borrower = null, checkOutDate = null, state = 0 ��� x ������ �ڵ����� �̸���
	}

	@Override
	public void checkout(String borrower, String checkoutDate) { // ������ , ������, �������
		if (state == STATE_BORROWED) { // ���� �������̶��?
			System.out.println(bookTitle + " å�� �������� �����Դϴ�.");
			return; // void�� ���� return;�� ���. �޽����� ����ϰ� ���ư�.
		}
		// state == STATE_NORMAL�̾ ������ ����Ǵ� ���
		this.borrower = borrower;
		this.checkoutDate = checkoutDate;
		state = STATE_BORROWED; // STATE_BORROWED�� 1, �����ϰ� ������ 1�� �� �ٲٴ� ��.
		System.out.println(bookTitle + " å�� ����˴ϴ�.");
		System.out.println("������: " + borrower + "\t������: " + checkoutDate);
	}

	@Override
	public void checkIn() { // �ݳ�
		if (state == STATE_NOMAL) { // ������ ������ å�̶�� �ǹ�.
			System.out.println(bookTitle + " å�� �̹� �ݳ��� �Ϸ�Ǿ����ϴ�. Ȯ���� �ּ���.");
			return;
		}
		// state == STATE_BORROED���� �ݳ��� ����Ǵ� ���
		borrower = null; // ���� ������ �ʱ�ȭ
		checkoutDate = null;
		state = STATE_NOMAL; // å�� �ݳ������� �ٽ� 0���� �ٲٴ� �۾�. �������� �ʰ� ����...
		System.out.println(bookTitle + " ������ �ݳ� �Ϸ�Ǿ����ϴ�.");

	}
	
	@Override
	public void printState() { // ����� ����. "890-��1 Java (������ ��) ���� ����
		if (state == STATE_BORROWED) {
			System.out.println(bookNo + "\t" + bookTitle + "\t (" + writer + " ��) - ������");
		}
		else if (state == STATE_NOMAL) {
			System.out.println(bookNo + "\t" + bookTitle + "\t (" + writer + " ��) - ���Ⱑ��");
		}
		/*
		 * String msg = bookNo + "\t" + bookTitle + "(" + writer + " ��)"; msg += state
		 * == STATE_BORROWED? "������" : "���Ⱑ��"; System.out.println(msg);
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
