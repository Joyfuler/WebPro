package com.lec.ex01_parentChild;

//childclass�� ��ü�� ����� �����۾�. (���뺯���� ����)
public class ChildTestMain {
	public static void main(String[] args) {
		ChildClass child = new ChildClass(); // childclass�� �Ű������� ���� �����ںκ��� ����Ͽ���. childclass() { sisout...)
		// extends�� ���⿡ �θ�Ŭ������ ������ �Լ��� �켱 ������.
		System.out.println(child.pstr);
		System.out.println(child.cstr);
		child.getPapaName();
		child.getMamiName(); // child�� �־ �θ� Ŭ������ �ִ� �����͸� ��� ������ �� ����.
	}

}
