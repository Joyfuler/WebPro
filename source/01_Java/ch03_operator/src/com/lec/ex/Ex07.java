package com.lec.ex;
// ��Ʈ �������� : &(and) , |(or)
public class Ex07 {
	public static void main(String[] args) {
		int n1 = 1; // ���������δ� 2������ ��ȯ�ǹǷ� �����δ�  0 0 0 1
		int n2 = 2; // ���������δ� 2����... �����δ� 		  0 0 1 0
		//                                           --------
		//                                &(and)����  0 0 0 0
		//								  �ϳ��� 0�̸� ��� 0����.
		//                                |(or)���� 0 0 1 1 = 3
		//								 �ϳ��� 1�̸� ��� 1��. 
		System.out.println("n1 & n2 �� " + (n1 & n2));
		System.out.println("n1 | n2 �� " + (n1 | n2));
		// �ڹ� ȯ�濡���� ���� ������ �ʴ� ����.
	
}
}
