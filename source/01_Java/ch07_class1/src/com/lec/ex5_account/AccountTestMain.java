package com.lec.ex5_account;

public class AccountTestMain {
	public static void main(String[] args) {
		Account hong = new Account ("011-1234", "ȫ�浿", 10000); //���¹�ȣ, �̸�, �ܾ��� ����ִ� ������ �Լ�.
		String name = "ȫȫȫ";
		System.out.println(hong.infoString());
		// �׳� hong�� �Է��ϴ� ���, @15db9742 ��� �ؽ��ڵ�(16����) �ּҷ� ��µ�.
		// hong.infoString�� �ְų�, hong.infoPrint(); �� ���� ����� ����ؾ���.
		
		hong.infoPrint();
		System.out.println(hong.infoString());
		Account hong1 = new Account("0123-9875", "ȫ����"); // �ܾ��� 0���̶� �Էµ��� �ʾ���. ���¹�ȣ�� �̸��� �ִ� ������ �Լ�.
		hong1.infoPrint();
		System.out.println(hong1.infoString());
		hong.withdraw(5000);
		hong1.withdraw(10);
		hong.deposite(100000);
		
	}
		
	}


