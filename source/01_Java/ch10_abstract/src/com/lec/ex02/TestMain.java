package com.lec.ex02;

public class TestMain {
	public static void main(String[] args) {
		SuperClass obj = new ChildClass(); // �߻� Ŭ���� (SuperClass)�� Ÿ�����θ� ���� . ��ü ������ �Ұ�
		obj.method1();
		obj.method2(); // ����.�޼ҵ� ����� ������ Ÿ�Կ� �´� ���� ����. but ���� ������ �Ϲݸ޼ҵ常 ����. �߻�Ŭ���� superclass�� method1�� ȣ����� ����.
		obj.method3();
		
		// obj.method4(); �����ϴ� �������� childclass�� method4�� ������... superclassŸ���̹Ƿ� ������ ������ ��.
		// �� �����ϴ� ������ �ƴ϶� ���� ������ �������� ���� ������ ������ ������ �߻�.
	if (obj instanceof ChildClass) { // �ִٸ� ����ȯ�ؼ� ������ ��.
		((ChildClass)obj).method4(); // ����ȯ: (���ϵ�Ŭ������) obj ��ü�� �ٲٰ�, �� �� method4�� �����϶�.
	}
	if (obj instanceof SuperClass) {
		
	}
	
	}
	}

