package com.lec.ex05_override;

public class TestMain {
	public static void main(String[] args) {
		Parent pObj1 = new Parent();
		Parent pObj2 = new Parent(10);
		System.out.println("�� ��ü�� ������?" + pObj1.equals(pObj2)); // �ٸ� ���̹Ƿ� �翬�� false
		pObj1.method1();
		pObj2.method2();
		pObj2.method1();
		System.out.println("----------------------------------"); // parent�� �� �ִ� ���� ��� ��µ�. 
		Child cObj1 = new Child (); // �Ű������� �����Ƿ� Parent() -> Child () ������.
		Child cObj2 = new Child (10); // Parent() -> Child (10) ������. (�θ�Ŭ������ �Ű����� x)
		cObj1.method1(); // �������̵尡 �Ǿ��⿡ parent�� �޼ҵ尡 �ƴ� child�� �޼ҵ�� �������Ͽ� ����� ��.
		cObj2.method2(); // �������̵� ���� method2�� parent�� �޼ҵ忡�� ������.
		cObj2.method3();
		// pObj1.method3(); // parents�� �޼ҵ�3�� �����Ƿ� �翬�� ����
		System.out.println("�� ��ü�� ������? " +cObj1.equals(cObj2)); // �Ʊ� object�� true�� ��ȯ������ ������ true�� ����.
		System.out.println("----------------------------------");
		
		Parent obj = new Child(); // parent���� ��ӹ޾����Ƿ� parent Ÿ�����ε� ���氡��.
		obj.method1(); // Parent Ÿ�������� Child�� �ִ� method�� ������.
		obj.method2(); // Child�� �����Ƿ� Parent�� �ִ� �޼ҵ� ����.
		// obj.method3(); // obj ������ Ÿ���� parent�̹Ƿ� ������ �������� ����. ���⼭ ����ȯ�� ���� �ذ� ����.
		if (obj instanceof Child) { // ���� child�� obj��� ��ü(�ν��Ͻ�)�� �ִٸ�
		((Child)obj).method3(); // Ÿ���� �ٲ��ִ� ������ ((Ÿ��)��ü).�޼ҵ�(); �������� ������� ����ȯ�� ����. �׳� �����ϸ� �������� ������ ��.
		} else {
			System.out.println("����ȯ �Ұ�"); // �� ��쿡�� ��ӹ޾����Ƿ� else�� ��µ��� ����.
			// ** new �� �������� �޼ҵ��� ���࿩�θ� �Ǵ��Ѵٴ� ���� ������ ��. ������ �����غ��� ���θ� �˼� ����.
		}
	}
	
	
}
