package com.lec.ex5_final;

import com.lec.constant.Constant;

public class FInalTestMain {
public static void main(String[] args) {
	final double PI = 3.1415926535;
	// final�� Ȯ���ϸ� ���� pi�� ���� ������ �� ����.
	// pi = 3; �������.. �ַ� �ٸ� ������ ������Ʈ�� ������ �� ���� �����ϰ� ���� �ʴٸ�.
	
	int r = 3; // ���� �������� ���̰� 3
	double area = Constant.PI * r * r;  // ���� ���̴� r ���� ���ϱ� 3.14
	double round = 2 * Constant.PI * r ; // ���� �������� r�϶� ���� �ѷ���? 2 X 3.14 X r
	System.out.printf("�������� %d�� ���� ���̴� %.3f\n", r,area);
	System.out.printf("������ %d�� ���� �ѷ��� %.3f\n", r, round);
	
	// �׻� ����ϴ� ����̹Ƿ� �޸� Ȯ���� �ʿ� --> static�� Ȱ����.
}
}
