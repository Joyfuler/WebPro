package com.lec.ex4_object;

import com.lec.quiz1.Sawon;

public class Ex1_PersonMain {
	public static void main(String[] args) {
		Person p1 = new Person(9812121012012L); // Long�� �����̹Ƿ� ���� �ڿ� L�� �ٿ������. (���ڴ� ����Ʈ�� int�̱� ����)
		Person p2 = new Person(9812121012012L);
		Person p3 = null;
		Sawon s = new Sawon("1", "��", "COM");
		System.out.println(p1);
		System.out.println(p2);
		System.out.println("p1 == p2��? " + (p1==p2));
		System.out.println("p1�� p2�� ���� : " + p1.equals(p2)); // String�� ���� equals�� �ϸ� true�� �����µ�,
															// Person ��ü�� ���� equals�� �ϸ� true�� �������� �ϰ� ����.
		System.out.println("p1�� p3�� ���� : " + p1.equals(p3)); // p3�� null�̹Ƿ� �տ� ���� ���� ����. (��ü�� �� ����)
		System.out.println("p2�� s�� ���� : " + p2.equals(s));
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode()); // p1�� p2�� �ؽ��ڵ尡 �ٸ�.
	}
}
