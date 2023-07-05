package com.lec.ex06_this;
// this. : �� ��ü�� ~
// this() : �� Ŭ������ ������ �Լ��� ����. this() --> �Ű� x, this(10) --> int �Ű� 1
public class Friend {
	private String name;
	private String tel;
	
	public Friend() {
		System.out.println("�Ű������� ���� Friend ������");
	}
	
	public Friend(String name) {
		this(); // = Friend();�� �ٸ��� �� ��. Friend�� Friend()�� ���������Ƿ� ȥ������ �ʵ��� ��.
		this.name = name;
		System.out.println("�Ű������� �ϳ��� Friend ������");
	}
	
	public Friend (String name, String tel) {
		this(name); // �ٷ� ���� Friend(String name)�� ȣ���� ��. �ش� �������Լ��� ���� ��µ�. ������ this.name = name;�� �Է������Ƿ� �߰��� ���� �ʿ�� ����.
		this.tel = tel;
		System.out.println("�Ű������� 2���� Friend ������");
	} 
	
	public String infoString() { // infoString ���� �̸� : ��ȭ��ȣ �������� return��
		return name + " : " + tel;
	}
}
