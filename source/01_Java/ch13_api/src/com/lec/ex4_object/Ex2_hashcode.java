package com.lec.ex4_object;

public class Ex2_hashcode {
	public static void main(String[] args) {
		String str1 = "Hello"; // ���� �޸� �� Hello�� �ִ����� Ž����. ���� ��� ���� ����
		String str2 = new String("Hello"); // ������ ���ο� ��ü�� ����. ���� str1�� str2�� �ּҴ� �ٸ�.
		if (str1 == str2) { // �翬�� �ٸ�����)
			System.out.println("�ּҰ� ���� ���� ������.");
		} else {
			System.out.println("�ּҰ� �ٸ� ���� ������.");
		}
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode()); // ���� ���̸� �ؽ��ڵ�� �����ϳ�, �� �ּҴ� �ٸ�.

		if (str1.equals(str2)) {
			System.out.println("���� ���ڿ�");
			System.out.println(str1.hashCode());
			System.out.println(str2.hashCode()); // �ּҴ´޶�! ���ڿ��� ���ٴ� �ǹ�
		}
	}
}
