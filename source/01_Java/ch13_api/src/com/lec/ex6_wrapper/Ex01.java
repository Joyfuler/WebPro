package com.lec.ex6_wrapper;

import com.lec.ex4_object.Card;

public class Ex01 {
	public static void main(String[] args) {
		Card c1 = new Card("��", 3);
		Card c2 = new Card("��", 3);
		int i = 10; // int�� ��ü �����Ͱ� �ƴѵ��� ������?!
		Integer iObj = new Integer(10); // ����� �̷��� �ڵ������Ǵ� ��.
		double d = 2.2;
		Double dObj = new Double(2.2); // �� ������.
		// �����ε�? ��ü�� 10������ ���� �״�� ����� �ȵǰ�����...?
		System.out.println(iObj);
		//System.out.println(c1.equals(i));
		System.out.println(c1.equals(10)); // �̷��� �־ �Ǵ� ������ new Integer(10)�� �ڵ����� ���ԵǱ� ������.
		System.out.println(c1.equals(2.2)); // �̷��� �־ new Double(2.2)�� �ڵ����� ���Ե�. �̰��� Wrapper...?
		System.out.println(c1.equals(true)); // new boolean (true) ������ ��ü�� ��������� ����.
		// ��, Wrapper�� ���� �����Ϳ� ��ü �������� ���̸� �շ��� �� �ִ� ��.
		//i = iObj; // ���� iObj.intValue(); �� ��ü�� �������� ��.. 
	}
}
