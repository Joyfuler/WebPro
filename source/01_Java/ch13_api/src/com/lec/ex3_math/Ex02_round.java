package com.lec.ex3_math;
// round - �ø�, �ݿø�, ����
// Math.ceil (õ��) (�ø� �Ǽ�) - Double ������ ���ϵ�. ex) Math.ceil(8.17) --> 9.0���� ���
// Math.round (�ݿø��� �Ǽ�, long���� return��. ex) Math.round(8.17) --> 8�� ��� 
// Math.floor (�ٴ�) (���� �Ǽ�) - Double ������ ���ϵ�. ex) Math.floor (8.17) --> 8.0���� ���

public class Ex02_round {
	public static void main(String[] args) {
		System.out.println("�Ҽ������� �ݿø�, �ø�, ����");
		System.out.println("8.17�� �ø� : " + (int)Math.ceil(8.17)); // �Ҽ��� ù° �ڸ����� �ø��� ��. 9
		System.out.println("8.17�� �ݿø� : " + Math.round(8.17)); // 8
		System.out.println("8.15�� ���� : " + (int)Math.floor(8.15));
		// �Ҽ��� �ι������� �ø�, �ݿø�, �����Ϸ���?
		System.out.println("�Ҽ��� �ι�° �ڸ����� �ݿø�");
		System.out.println("8.15�� �÷��� 8.2�� ������ ��� : " + Math.ceil(8.15 * 10) /10);		
		// 8.15�� 10 ���ϸ� 81.5�� ������, �ø��� 82�� ��. ���⼭ �ٽ� 10���� ������ ���������� 8.2�� ��.
		System.out.println("8.15�� �ݿø� " + Math.round(8.15 * 10) / 10.0); // java�� ������ ����! 10�� �ƴ� 10.0���� ������
		System.out.println("8.15�� ���� " + Math.floor(8.15 * 10) / 10);
		System.out.println("�����ڸ����� �ݿø�, �ø�, ���� (ex 85 => 90");
		System.out.println("85�� �ø� : " + (int)Math.ceil(85 / 10.0) * 10); // ������� 10�� �ƴ� 10.0���� ��������. 8.5�� �ø��ϸ� 9.0�� ��
		System.out.println("85�� �ݿø� : " + Math.round(85 / 10.0) * 10);
		System.out.println("85�� ���� : " + (int)Math.floor(85 / 10.0) * 10);
		// �ڸ����� �����ϴ� �ݿø�, ���� ���� �ܸӸ��� �Ἥ �ٲ㺸��. *10�� �� �� �ٽ� /10�� �Ѵٵ簡... 
	}	
}
