package com.lec.ex1_string;

public class Ex11_speedCheck { // �Լ� ������ - �� �ð����
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis(); // �и����� ������ ����ð��� Ȯ���ϴ� �Լ�.		
		// 1970.11 0�ú��� ��������� �и�����..
		String str = "a";
		str += "a";
		for (int i=0; i<100000; i++) {
			str += "a"; // str�� a�� 10�������ϴ� ���..			
		}
		long end= System.currentTimeMillis();
		System.out.println("��Ʈ�� 10���� ���� �ð� : " + (end - start));
			
		start = System.currentTimeMillis();
		StringBuilder stringBuilder = new StringBuilder("a");
		for (int i=0; i<100000; i++) {
			stringBuilder.append("a");
		}
		end = System.currentTimeMillis();
		System.out.println("��Ʈ������ 10���� ���� �ð� :" + (end - start));
	}	
}
