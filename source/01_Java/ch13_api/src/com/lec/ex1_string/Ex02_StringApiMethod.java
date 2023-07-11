package com.lec.ex1_string;

public class Ex02_StringApiMethod {
	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str4 = new String("abcXabc"); // ���� ���� ������ �ּҰ� �ٸ�. new�� ����
		String str2 = "         Ja va          ";
		System.out.println("1."+ str1.concat("AAA")); // concat�� �� ���ڸ� ���ϴ� ��. abcXabc�� AAA�� ����.
		System.out.println("2." + str1.substring(3)); //���ڿ� ����. ����, ������. 3�� �Է½� 3��° ���ں��� ��������������
		System.out.println("3." + str1.substring(3, 5)); // 3��°���� 5��° '�ձ���' --> Xa (string��ȯ)
		System.out.println("4." + str1.length()); // ���ڿ��� ���� = 7 (0���� 6����)
		System.out.println("5." + str1.toUpperCase()); // ��� �빮�ڷ�. ABCXABC
		System.out.println("6." + str1.toLowerCase()); // ��� �ҹ��ڷ�. abcxabc
		System.out.println("7." + str1.charAt(3)); // 3��° ���ڸ� �������� ��. (char��ȯ)
		System.out.println("8." + str1.indexOf('b')); // �ش� ���ڰ� 'ó��' �ִ� ���� ��ġ�� ã����. 1
		System.out.println("9." + str1.lastIndexOf('b')); // �ش� ���ڰ� '������' ���� ���� ��ġ�� ã����. 5
		System.out.println("10." + str1.indexOf('@')); //���� ���, -1�� ���ϵ�. --> ���� ��ȿ�� �˻翡 ���.
		System.out.println("11." + str1.indexOf("Xabc")); // ���ڸ� ������ �Է��ص� ����. ���� ��ġ
		String str3 = "abcXabcXabc"; // b�� 3�� ���� ��, ��� b�� ã�� �����?
		System.out.println("12." + str3.indexOf("bc", 6)); // 2��° ��ġ���� �����ϴ� b�� ã�� ���.
		System.out.println("13." + str4.equals(str1)); // ���� �ּҰ� x, ���� ���縵���� ���. true
														// str1 == str4�� ���� ���� false
		System.out.println("14." + str4.equalsIgnoreCase("ABCXABC")); // ��ҹ��� ���о���
		System.out.println("15." + str2.trim()); // �յ��� �����̽��� ��������. Ja va
		System.out.println("16." + str3.replace("abc", "�ٲ�")); // abc��� ������ ��� �ٲ�� �ٲ�
		// ��, �ش� �޼ҵ��� ����� ��ȯ�ϴ� ���̸�, str ���� ��ü�� ���� �ٲٴ� ���� �ƴ�.
		System.out.println("str1: " + str1);
	}
}
