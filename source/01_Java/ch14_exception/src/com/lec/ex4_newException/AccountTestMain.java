package com.lec.ex4_newException;

public class AccountTestMain {
	public static void main(String[] args) {
		Account hong = new Account ("011-1234", "ȫ�浿", 10000); //���¹�ȣ, �̸�, �ܾ��� ����ִ� ������ �Լ�.
		String name = "ȫȫȫ";
		System.out.println(hong);
		// �׳� hong�� �Է��ϴ� ���, @15db9742 ��� �ؽ��ڵ�(16����) �ּҷ� ��µ�.
		// hong.infoString�� �ְų�, hong.infoPrint(); �� ���� ����� ����ؾ���.
		
		hong.infoPrint();
		System.out.println(hong);
		Account hong1 = new Account("0123-9875", "ȫ����"); // �ܾ��� 0���̶� �Էµ��� �ʾ���. ���¹�ȣ�� �̸��� �ִ� ������ �Լ�.
		hong1.infoPrint();
		System.out.println(hong1);
		
		// �ܾ� ������ ��� ���ܰ� �߻��� ����, �� �� ���� �����Ƿ�..
		try {
		hong.withdraw(5000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			hong1.withdraw(10);
		} catch (Exception e) {
			e.getMessage();
		}
		hong.deposite(100000);
		
	}
		
	}


