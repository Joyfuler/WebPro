package com.lec.ex06_book;

public interface ILendable { // ���Ⱑ�� �������̽�
	public byte STATE_BORROWED = 1; // ������.
	public byte STATE_NOMAL = 0; // ���Ⱑ��
	
	public void checkout(String borrower, String checkoutDate); // ����. �̸��� ��¥
	public void checkIn(); // �ݳ��ϴ� �޼ҵ�.
	public void printState(); // å��ȣ�� å �̸�, ���Ⱑ�ɿ��θ� ����ϴ� �޼ҵ�.
}
