package com.lec.ex6_person;

public class PersonInfo {
	private String name;
	private int age;
	private char gender;
	public PersonInfo() { // ����Ʈ ������. (superclass generate�ؼ� ���� �� ����.)
		}
	public PersonInfo(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public void print() {
		System.out.println("�̸� :" + name);
		System.out.println("���� :" + age);
		System.out.println("���� :" + gender); // ����: m... �ƹ��͵� ���ٸ� ���X
		String str = (gender == 'm' || gender =='M' )? "��" : (gender =='f' || gender == 'F' ? "��": "��������");
		// System.out.println("����:" + str);	//���� ���.
		
		}
		
	public String infoPrint() {
		String str = (gender == 'm' || gender =='M' )? "��" : (gender =='f' || gender == 'F' ? "��": "��������");
		String result = "�̸� :" + name + "\n" + "���� :" + age + "\n" + "����: " + str; //str�� �׳ɾ��� �����Ƿ� ���� �������ذ� �ٽ� ��������
		// Ȥ�� ���پ��� ����
		String result2 = "�̸�: " + name;
		result2 += "\n����: " +age;
		result2 += "\n����: " +gender;
		return result2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
		
	
	}
	

	
	
	
	
	
	

