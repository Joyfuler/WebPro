package com.lec.ex11_account;

public class Account {
	// ������� (account) Ŭ���� ����
	// ������ (�Ӽ�) : ���¹�ȣ, ������, �ܾ�
	// �޼ҵ�: �����ϴ�, �����ϴ� + ���� ���� ���. ���� ������ ���ڿ��� return *

	private String accountNo; // �����ȣ�� - �� �ְ�, �� ���� 0���� �����ϴ� ��� ���ư��Ƿ� String���� ���ٰ�.
	private String ownerName; // �����ָ�
	private int balance; // �ܾ�

	public Account(String accountNo, String ownerName) { // �ܾ׾��� �����ϴ� ����� Account �޼ҵ�
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		// �ܾ��� �⺻���� 0 (balance = 0);
		System.out.println(ownerName + "�� ���� ���� �����մϴ�. ���� �ܾ��� " + balance);
		// Ȥ�� source --> ~ field�� ����
	}

	public Account(String accountNo, String ownerName, int balance) { // �ܾ׳����鼭 �����ϴ� ����� Account �޼ҵ�
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		System.out.println(ownerName + "�� ���� ���� �������� �����մϴ�. �ܾ��� : " + balance);
	}

	public void deposite(int money) { // �Աݽ�
		balance += money; // balance = balance + money; �� �����ϸ� �ܾ��� �þ�ٴ� ��.
		System.out.println(accountNo + ":" + money + "�� �����Ͽ�, �ܾ��� :" + balance);
		System.out.printf("%s : %d �� �����Ͽ�, �ܾ��� %d\n", accountNo, money, balance);

	}

	public void withdraw(int money) { // �ܾ��� ���� ��쿡�� ������ ����. �ܾ� ������ ���� ���
		if (money <= balance) {
			balance -= money;
			System.out.println(ownerName + "��, " + money + "���� ����Ͽ�, �ܾ��� " + balance + "�Դϴ�.");
		} else {
			System.out.println(ownerName + "��, �ܾ��� �����Ͽ� ����� �� �����ϴ�.");
			// ���߿��� ���� ���ܰ� �߻��ϴ� ���� ��� ����...
		}

	}

	public void infoPrint() { // "101-1234", ȫ�浿�� �ܾ� : 1000�� ������ ����� ����)
		System.out.println("\"" + accountNo + "\"" + ownerName + "�� �ܾ�: " + balance + " ��");
		System.out.printf("\" %s \"%s�� �ܾ� : %d ��", accountNo, ownerName, balance);
	}

	public String infoString() { // "101-1234", ȫ�浿�� �ܾ� : 1000�� �����Ͱ� return��. (String�̹Ƿ� return�� �ʿ�)
		// return "\"" + accountNo + "\"" + ownerName + "�� �ܾ�: " + balance + " ��";
		return String.format("\" %s \" %s�� �ܾ� : %d ��", accountNo, ownerName, balance);
		// ���� string�� ������� �ϴ� format�� ����.

		// ���� sysout�� ������ ������ ���Ͻ�����. ���� ���θ޼ҵ忡�� sout (hong) �ϴ� ��� ���� ���� ��µ�.
	}
	// getter & setter �߰�. �� �ܾ��� �Ժη� �������� �ʱ� ���� balance�� set���� ����. ���¹�ȣ�� ����� ���� ������
	// username�� set

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public int getBalance() {
		return balance;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}

// new Account("110-98", "ȫ�浿");
// ���� �־�� �Ѵٸ� new Account ("110-98", "ȫ�浿", 200000) ������ ��������.
// �����ȣ 110-98, �����ָ� ȫ�浿
