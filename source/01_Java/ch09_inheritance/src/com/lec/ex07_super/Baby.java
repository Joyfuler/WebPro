package com.lec.ex07_super;
// private (name, character), public (intro(), setget����
// super() : �θ� Ŭ������ ������ �Լ�
// this() : �� Ŭ������ ������ �Լ��� ���ϴ� ��.
// super. �θ� Ŭ������ ~
// this. : �� ��ü��~
public class Baby extends Person{


	public Baby() {
		super(); //�θ�Ŭ������ �������Լ�
		System.out.println("�Ű����� ���� Baby ������");
	}
	
	public Baby (String name, String character) {
		/*
		 * setName(name); setCharacter(character);
		 */
		super(name,character); // �Ű������� �ִ�.. �θ� Ŭ������ Person(name,character);�� ������ �� ���. Person()�� �������� ����.
		System.out.println("�Ű����� �ִ� Baby ������");
			
	}
	@Override
	public void intro() { // �ֱ��� �Ұ��� super�� �ٸ��� �ٲٰ� �ʹٸ�...
		System.out.print("������ ���� �̻� �Ʊ�");
		super.intro(); // �θ� Ŭ������ intro() ȣ��..
	}
	
	
}
