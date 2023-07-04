package com.lec.ex2_access;

public class AccessTestMain {
	public static void main(String[] args) {
		AccessTest obj = new AccessTest(); //obj��� ��ü�� AccessTest Ŭ������ �ִ� �����͸� ������.
		// System.out.println(obj.privateMember); // not visible ����. private�̱� ����.
		// getter�� ����� ����� ���� ����.
		System.out.println(obj.defaultMember); // ���� ��Ű���̹Ƿ� ����.
		System.out.println(obj.protectedMember); // ���� ��Ű���̹Ƿ� ����.
		System.out.println(obj.publicMember); // ��𼭳� ����.
		
		// obj.privateMethod(); // �޼ҵ� ȣ�� ���� �Ұ���. 
		obj.defaultMethod(); // ���� ��Ű��.
		obj.protectedMethod(); // ����.
		obj.publicMethod(); // ��𼭵� ����.
			
		}
	}

