package com.lec.ex1_string;

public class Ex01 {
	public static void main(String[] args) {
		
	
	int i =10;
	String str1 = "Java"; // Java�� ��� Ǯ?!
	String str2 = "Java"; // str2�� ���Ӱ� ������ ������ ���� �ƴ�. str1�� �����״� ���� str2�� ���� ����Ű�� ��.
						// str1���� �̹� ������ �Ǿ���, str2�� ������ �ּҸ� ����Ű�⸸ �ϴ� ����.
	String str3 = new String("Java"); // ��������� �� ������ ���� �� �ص� �ǵ��� ����.
										
	if (str1 == str2) {
		System.out.println("str1�� str2�� ���� �ּҸ� ����");
	} else {
		System.out.println("str1�� str2�� �ٸ� �ּҸ� ����");
	}
	System.out.println(str1 == str3 ? "���� �ּ�" : "�ٸ� �ּ�"); // �и� ���� ���ε��� �ּҰ� �ٸ�. new�� ���Ӱ� ��������� ����.
	str2 = "Oracle"; // str2�� java���� oracle�� �ٲ۴ٸ�? ���� �ּҸ� ������ oracle�� �����ϴ� �޸𸮸� ����.
	if (str1 == str2) {
		System.out.println("������, str1�� str2�� ���� �ּҸ� ����");
	} else {
		System.out.println("������, str1�� str2�� �ٸ� �ּҸ� ����");
	}
	
	// ������ equals�� ���Ѵٸ�?
	
	
	
	
	}
}
