package com.lec.ex07_super;
// super. �� super();
public class Person {
	private String name;
	private String character; // �̸��� ���ݸ� ����...
	
	
	
	public Person() {
		System.out.println("�Ű����� ���� Person ������");
	}



	public Person(String name, String character) {
		this.name = name;
		this.character = character;
		System.out.println("�Ű����� �ִ� Person ������");
	} // ��ӹ��� �޼��忡�� �Ű����� ���� �����ڸ� ������� �ʰ� �Ϸ���?
	
	public void intro() {
		System.out.println("��" + name + "�� " + character);
	}



	public String getName() { // name�� character�� ��� private�̹Ƿ� �ܺο��� ���� �ְų� ����ϱ� ���ؼ� getset �־���.
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getCharacter() {
		return character;
	}



	public void setCharacter(String character) {
		this.character = character;
	}
	
}
