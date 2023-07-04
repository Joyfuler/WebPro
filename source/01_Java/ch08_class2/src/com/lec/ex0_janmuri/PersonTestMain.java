package com.lec.ex0_janmuri;


public class PersonTestMain {
	public static void main(String[] args) { // �� ���� �Լ��� static. �̷� ���� ��ǻ�Ͱ� ������ ���� ���ε���. 
		// ������ ���� �Լ� �ܿ� static�� �� ����ٸ�? �ش� �޼ҵ�� mainó�� ����  �޸� ������ Ȯ����. static�� ���� ������ �޸� ���ϰ� �� �� �ִٴ� ��������.
		// ��ǻ���� garvage collection�� static���� ������� �ʱ� ����.
		PersonInfo p1 = new PersonInfo("ȫ", 20, 'm');
		PersonInfo[] p2 = {p1, new PersonInfo("ȫ���",24,'f')};
		p1.print();
	}
} // ���� �ٸ� Ŭ�����̹Ƿ� } �� �ļ� ��������.

class PersonInfo { // public�� �ƴ� Ŭ������ �ϳ� �� ���� �� ����.
					// ��, public class�� �� ���� ���� �� ����. (�ΰ� ������ ����)
	 private String name;
	 private int age;
	 private char gender;
	public PersonInfo(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	 public void print() {
		 System.out.println("�̸� : " + name + ", ���� : " + age + ", ���� : " + gender);
	 }
}
	 
	 // public ���� ���� Ŭ�������� 2���� ����� ���� ������, �ٸ� �� or �ٸ� ����� ������� ���ϰ� ��.
	 // ���� public �ϳ����� �ְ� �ٸ� Ŭ�������� ����ϴ� ���� �����.
	 // ���� �������ϴ� ���� ��������� bin���� 2���� class ������ ����Ƿ� ���� Ŭ���� 2���� ����õ




		
		
		




