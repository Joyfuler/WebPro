package com.lec.ex10_final;

// ����Ŭ������ �� ���� = speed, running() �޼ҵ�, stop() �޼ҵ�, �� final�̹Ƿ� �������̵� ����.
public class Dog extends Animal {
	@Override
	public void running() {
		speed += 10;
		System.out.println("�������� ������ ���� �پ��. ���� �ӵ� : " + speed);
		
	}

}
