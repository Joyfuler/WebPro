package com.lec.ex;

public class Ex04_void {
 //return�� ���� �޼ҵ�.. ���� �׸��� ���?
	private static void printLine() { // �Ű����� ����, ����Ÿ�Ե� ���� �޼ҵ�
		for (int i = 0; i <= 20; i++) {
			System.out.print('-');
		}
			System.out.println(); //�⺻ ������ �׸� �� ����
	}
	
	public static void printLine(char c) {
		for (int i = 0; i <= 20; i++) {
			System.out.print(c);
		}
			System.out.println(); //�⺻ ������ �׸� �� ����
	}
	
		
		


	
	public static void printLine(int cnt) { // cnt�� �� 15�� ���Ե�.
		for (int i = 0; i < cnt; i++) { // 15�� �ݺ��ϰ� ����. (���� 20���� �ƴ϶� �Է��� ���ڸ�ŭ�� �� ���� ����ϱ� ����)
			System.out.print('-');
		}
			System.out.println(); //�⺻ ������ �׸� �� ����
			
			
			
	}
	
	public static void printLine(int cnt, char c) { // �� ���� ������ �����ϵ��� �� �� �Ű������� �� �߰�. (�����ε�)
		for (int i = 0; i < cnt; i++) { // 15�� �ݺ��ϰ� ����.
			System.out.print(c); // ���θ޼ҵ忡�� prinLine�� �Է��� �κ��� ��µ�.
		}
			System.out.println(); //�⺻ ������ �׸� �� ����

	
	}
	public static void main(String[] args) {
		printLine(); // printLine(); ���� ���� �� �޼ҵ��� �״�� ����( -------------�� �ϰ� ����) 
		System.out.println("Hello, Java"); // ���� Hello Java�� ��½�Ŵ.
		printLine('~'); // ~~~~~~~�� ���� �ʹٸ�? char ������ �߰���. (-----) ��ü ��� c��  ~�� ������ ������ �� ��, �� �޼ҵ忡�� 20�� �ݺ�.
		System.out.println("Hello, Oracle DB");
		printLine(15); // int ������ ������ ������ ���� ������ ���Ƿ� ���� �޼ҵ带 ��������. ���� int cnt�� �ִ� �޼ҵ带 ���� ����.
		System.out.println("Hello, Void");
		printLine(20, '#'); // 21��, #���� �Ǿ� �ִ� ������ ����Ϸ��� 2�� �������� �� ������ ���Ƿ� ���� ������ 2�� �ִ� �޼ҵ带 �� �������.
		
	}
}
