package com.lec.ex04_abc;

public class TestMain {
	public static void main(String[] args) {
		S sObj = new S(); // S ������ �Լ��� �����.
		// SŸ��, Ÿ�� ����(���ο� �̸�) = new �ִ� ��ü();
		// A aObj = new A();
		S aObj = new A(); // Ÿ���� S�� �����ص� ����.. ������ �Լ��� 2�� �����. (�θ��, �ڽĴ� 1����)
		S bObj = new B(); // ���������� ������ �Լ��� 2�� ����. (S,B)
		C cObj = new C(); // SŸ���� �ƴ� CŸ������ ����...?!
		
		S[] arr = {sObj, aObj, bObj, cObj}; // CŸ�������� ���ÿ� S�� ����� �޾����Ƿ� �����ϰ� �迭�� ������ �� ����.
		for (int idx = 0; idx < arr.length; idx++) {
			System.out.println(idx + "��°: " + arr[idx].s); //arr[idx]�� s ���� �ݺ�����
		}
		
		for (S a : arr) { // arr�� �迭�� a�� ī���ϴ� ���� Ȯ�� for��.
			System.out.println("s= " + a.s); // arr[idx]�� a�� ī�������Ƿ� a�� �״�� ����ϸ� ��.
		}
	}
}
