package com.lec.ex4_newException;

public interface ILendable { // ���Ⱑ�� �������̽�
	public byte STATE_BORROWED = 1; // ������.
	public byte STATE_NOMAL = 0; // ���Ⱑ��
	
	public void checkout(String borrower); // �������� Ȯ��, �������� ���÷� ����ǹǷ� date�Ű������� ������.
	public void checkIn() throws Exception; // �ݳ��ϴ� �޼ҵ�.
	// å��ȣ�� å �̸�, ���Ⱑ�ɿ��θ� ����ϴ� �޼ҵ�.
}
