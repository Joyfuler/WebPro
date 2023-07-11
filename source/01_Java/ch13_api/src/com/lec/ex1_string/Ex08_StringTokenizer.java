package com.lec.ex1_string;

import java.util.StringTokenizer;

// ������� ����Ʈ�� �ް� ���� ��. �׷��� ��� ���� ���� �ȿ� �� �� �ִ� ���?
public class Ex08_StringTokenizer {
	public static void main(String[] args) {
		String str1 = "�ں��� ���� ���� ��ҿ� �嵿��"; // �����ڰ� �����̽��� ���.
		String str2 = "100, 99, 85, 73"; // �޸������� �����Ͱ� ����Ǵ� ���. �� �����ڰ� �����ϴ� ���
		StringTokenizer token1 = new StringTokenizer(str1);  
		//str1�� ��ū�� ����. �ƹ��͵� �Է� ���ϴ� ��� �⺻������ �����̽� ������.
		StringTokenizer token2 = new StringTokenizer(str2, ", "); 
		//str2�� ��ū�� ����. �޸�����, �޸� �����̽����� ����!
		while(token1.hasMoreTokens()) { // hasmoretokens?! �ش� ������ �������� ���� '��ū'���� ���� ��ɾ�. true�� ��ȯ
										// ���� ���������� ���� ��� false�� ��.
			System.out.println(token1.nextToken()); // ���� ��ū�� ��ȯ.
		} 
		System.out.println("------------------");
		
		while(token2.hasMoreElements()) {
			System.out.println(token2.nextElement()); // hasmoretoken = hasmoreelements. 
		}
		
	}
}
