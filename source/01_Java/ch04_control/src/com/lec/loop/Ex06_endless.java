package com.lec.loop;

// �ݺ���(loop��)�� �ۼ��� ���� ���� �ݺ����� ���� �ʵ��� ����
public class Ex06_endless {
	public static void main(String[] args) {
		for (int i = 0; true ; i++) {
			// Ȥ�� ������ ���� �ʴ� ��쿡�� for (int i =0; ; i++){ ���ǿ� �ƹ��͵� ���� ������ true�� �ν�, true�� �ν��ص� ���ѹݺ�
			System.out.println("�ȳ��ϼ���"); // ��ȣ�ȿ� �ִ°��� ���ѹݺ�
			if (i == 10) {
				break;
			}
		} // ���ѹݺ� for ��	
	System.out.println("����");
	}
	
	}

