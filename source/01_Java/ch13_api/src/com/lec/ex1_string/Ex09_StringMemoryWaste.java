package com.lec.ex1_string;

public class Ex09_StringMemoryWaste {
	public static void main(String[] args) {
		String str = "Hello, java";
		System.out.println(str); // str�� �ּҸ� ���� �� ���� ����. �ؽ��ڵ�� ��ü...
		System.out.println(str.hashCode()); // �ؽ��ڵ� Ȯ��
		str = "Hello, JAVA"; // ���� �ٲ�� ���, ���� ���� ������ ���Ӱ� ��ü�� ����.
		System.out.println(str.hashCode()); // ���� ���� ������� ���Ƽ� �޸𸮸� ������.
		str = "Hello, C";
		System.out.println(str.hashCode()); // String�� ���� �ٲ� ������ ��ü�� ���Ӱ� ����.
	}
}

