package com.lec.ex;
// ����ȯ 
public class VarEx05 {
	public static void main(String[] args) {
		int i = 10; //4����Ʈ
		double d = i;  // d= 10.0 ���� ��ȯ��. �������� ����ȯ // 8����Ʈ
		System.out.println("d= " + d); // 10�� �ƴ� 10.0���� ��. ū ������ ���� ���� �������� �ڵ����� ��ȯ
		
		i= (int) 10.6; // 10.6�� int�� ����ȯ�� ��. �������(��������) ����ȯ. but ������ �ս� �߻��� �� ����
		System.out.println("i= " + i); // 10.6�� �ݿø��� 11�� ���� ���� �ƴ� 10���� �����Ƿ� ���� �߻� ����.
		
		
		
}
}