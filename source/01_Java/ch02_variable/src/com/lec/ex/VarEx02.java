package com.lec.ex;

public class VarEx02 {
	public static void main(String[] args) {
		// ���� Ÿ�� + ������ (���ĺ�, ����, _(�����) / �������� �����ؾ� ��. (���� ���� �Ұ�) + �Ҵ翬�� �ʱⰪ (=)
		int i = 10;
		byte j = 127;
		double h = 10.15;
		System.out.println("i=" + i + "\t j=" + j + "\t h=" + h); // �ܼ�â ���(���� ����)
		System.out.printf("i=%d\t j=%d\t h=%.2f\n", i,j,h);  // d�� ���� ����ϴ� ����. f�� �Ҽ��� ����ϴ� ����. 1f�� �Ҽ��� 1�ڸ�����, 2f�� �Ҽ��� 2�ڸ�����...
		//  i�� ���� �������� (tab) j�� ���� �������� (tab) h�� �Ҽ��� �������� ǥ���Ѵٴ� �ǹ�
		//b�� boolean, \n�� �ٹٲ�.. 
		System.out.println("���α׷� ��");
		
		char c1= 'A';
		char c2= '��';
		// ���� (%c) = char , ���ڿ� (%s) = string, ����(%d) / �Ǽ� (%f), ������ boolean (%b)
		System.out.printf("c1=%c \t c2=%c \n", c1, c2); // ���ڷ� ǥ���� ��
		System.out.printf("c1=%d \t c2=%d\n", (int) c1, (int) c2 ); // ������ ǥ���� ��
		System.out.printf("c1=%f \t c2=%f \n", (double)c1, (double)c2); // �Ҽ�(�Ǽ�)�� ǥ���� ��
		
		
		
		int age = 10;
		String addr= "��⵵";
				
				System.out.printf("�� ���̴� %d�� �Դϴ�.\n", age);
				System.out.printf("�� ���̴� %d ���̰�, %s�� ��� �ֽ��ϴ�", age, addr);
	}			
}
