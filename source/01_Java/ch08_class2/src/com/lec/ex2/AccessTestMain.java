package com.lec.ex2;

import com.lec.ex2_access.AccessTest;

public class AccessTestMain {
	public static void main(String[] args) {
		AccessTest obj = new AccessTest(); //obj��� ��ü�� AccessTest Ŭ������ �ִ� �����͸� ������.
		// System.out.println(obj.privateMember); // not visible ����. private�̱� ����.
		// getter�� ����� ����� ���� ����.
		//System.out.println(obj.defaultMember); // �ٸ� ��Ű���� �Ǿ� ����� �Ұ�������.
		//System.out.println(obj.protectedMember); // �ٸ���Ű��
		//System.out.println(obj.publicMember); // ��𼭳� ����.
		
		// obj.privateMethod(); // �޼ҵ� ȣ�� ���� �Ұ���. 
		//obj.defaultMethod(); // �ٸ� ��Ű��.
		//obj.protectedMethod(); // �ٸ�.
		obj.publicMethod(); // ��𼭵� ����.
		
		// ��Ű���� �޶��� ��쿡�� public�� �����Թ̴�
			
		}
	}

